package com.obric.contactsdk.loader;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.contactsdk.h;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\u001a\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006\u001a\u0010\u0010\r\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u001a\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u001a \u0010\u0013\u001a\u0004\u0018\u00010\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a%\u0010\u0017\u001a\u0004\u0018\u00010\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0019\u001a%\u0010\u001a\u001a\u0004\u0018\u00010\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\u001b\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001c\u001a \u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\"\u001a\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u001e\u001a\u00020\u001f\u001a\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010\u001a\u0018\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0006\u001a\u001a\u0010(\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a.\u0010)\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0002\u001a\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002\u001a\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a\u0017\u0010.\u001a\u00020/2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u00100\u001a \u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020/H\u0002\u001a \u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00102\u0006\u0010\u001e\u001a\u00020\u001f\u001a*\u0010<\u001a\b\u0012\u0004\u0012\u0002060\u00102\u0006\u00107\u001a\u0002082\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u001e\u001a\u00020\u001f\u001a6\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0002\u001a$\u0010?\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001a\u0010@\u001a\u0004\u0018\u00010\u00012\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0001\u001a\u0012\u0010D\u001a\u00020\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002\u001a(\u0010E\u001a\b\u0012\u0004\u0012\u0002060\u00102\f\u0010F\u001a\b\u0012\u0004\u0012\u0002060G2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"CALL_LOG_COLUMN_SIM_ID", "", "CALL_LOG_COLUMN_SUBSCRIPTION_ID", "CALL_LOG_DONATION_MAX_COUNT", "", "CALL_LOG_DONATION_TIME_LIMIT_MS", "", "INVALID_SIM_SLOT_ID", "INVALID_SUBSCRIPTION_ID", "callTypeToDesc", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "type", "duration", "filterAdministrativeDivision", "location", "filterExpiredCallHistoryEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "entities", "findSubscriptionNumberBySlot", "subscriptions", "Landroid/telephony/SubscriptionInfo;", "slotId", "findSubscriptionSlotById", "subscriptionId", "(Ljava/util/List;I)Ljava/lang/Integer;", "findSubscriptionSlotBySimId", "simId", "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/Integer;", "formatNumber", "context", "Landroid/content/Context;", "phoneNumber", "entity", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getAllCallLogIds", "getCallLogIdByCallFlags", "callFlags", "getCallLogIdByTimestamp", "timestamp", "getLine1Number", "getSlotIdForSimId", "availableSubscriptions", "activeSubscriptions", "getSlotIdForSubscription", "getSubscriptionIdForSlot", "isValidSimSlotId", "", "(Ljava/lang/Integer;)Z", "loadSubscriptions", "subscriptionManager", "Landroid/telephony/SubscriptionManager;", "activeOnly", "queryCallLogById", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "contentResolver", "Landroid/content/ContentResolver;", OaidModel.KEY_ID, "queryCallLogSampleEntities", "Lcom/obric/capabilitykit/sync/EntityIdData;", "queryCallLogsByIds", "ids", "resolveSimSlotId", "resolveSourceSimNumber", "safeGetColumn", "cursor", "Landroid/database/Cursor;", "columnName", "simIdStateForLog", "updateCallHistoryEntitiesQueryByIds", "callHistoryEntities", "", "contactsdk_debug"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class d {
    private static final int a(int r5) {
        if (r5 != (-1)) goto L10;
        return -1;
    L10:
        return SubscriptionManager.getSlotIndex(r5);
    L7:
        e = move-exception;
        com.obric.a.a.f.f5867a.a("CallContentObserver", "getSlotIdForSubscription: failed, subscriptionId=" + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return -1;
    }

    private static final int a(int r3, String r4, List<? extends SubscriptionInfo> r5, List<? extends SubscriptionInfo> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = a(r4, r7, r8);
        if (a(Integer.valueOf(r0)) == false) goto L5;
        return r0;
    L5:
        int r1 = a(r3);
        if (a(Integer.valueOf(r1)) == false) goto L8;
        return r1;
    L8:
        Integer r9 = a(r7, r3);
        if (r9 != null) goto L12;
        r9 = a(r8, r3);
    L12:
        if (a(r9) == false) goto L15;
        Intrinsics.checkNotNull(r9);
        return r9.intValue();
    L15:
        com.obric.a.a.f.f5867a.b("CallContentObserver", "resolveSimSlotId: unresolved, subscriptionId=" + r3 + ", simId=" + b(r4) + ", slotBySimId=" + r0 + ", slotBySubscription=" + r1);
        return -1;
    }

    private static final int a(String r2, List<? extends SubscriptionInfo> r3, List<? extends SubscriptionInfo> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return -1;
    L12:
        Integer r7 = a(r5, r2);
        if (r7 != null) goto L15;
        r7 = a(r6, r2);
    L15:
        if (r7 != null) goto L17;
        return -1;
    L17:
        return r7.intValue();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static final CallTypeEnum a(int r2, long r3) {
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L17;
        return null;
    L17:
        return CallTypeEnum.INCOMING_CALL_MISSED;
    L11:
        if (r3 <= 0) goto L19;
        return CallTypeEnum.OUTGOING_CALL_ANSWERED;
    L19:
        return CallTypeEnum.OUTGOING_CALL_MISSED;
    L15:
        return CallTypeEnum.INCOMING_CALL_ANSWERED;
    }

    private static final Integer a(List<? extends SubscriptionInfo> r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != (-1)) goto L5;
        return null;
    L5:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Object r2 = r7.next();
        if (((SubscriptionInfo) ZeusTransformUtils.preCheckCast(r2, SubscriptionInfo.class, "com.obric.memorydata.plugin")).getSubscriptionId() != r5) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
    L15:
        SubscriptionInfo r8 = (SubscriptionInfo) ZeusTransformUtils.preCheckCast(r2, SubscriptionInfo.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L18;
        return null;
    L18:
        return Integer.valueOf(r8.getSimSlotIndex());
    L11:
        r3 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    private static final Integer a(List<? extends SubscriptionInfo> r9, String r10) {
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L3:
        boolean r3 = false;
        if (r12.hasNext() == false) goto L12;
        Object r2 = r12.next();
        SubscriptionInfo r5 = (SubscriptionInfo) ZeusTransformUtils.preCheckCast(r2, SubscriptionInfo.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5.getIccId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
    L9:
        r3 = true;
    L10:
        if (r3 == false) goto L3;
        r0.add(r2);
        goto L3
    L8:
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5.getCardString(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
    L12:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        r1.add(Integer.valueOf(((SubscriptionInfo) ZeusTransformUtils.preCheckCast(r14.next(), SubscriptionInfo.class, "com.obric.memorydata.plugin")).getSimSlotIndex()));
        goto L14
    L16:
        List r15 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        int r4 = r15.size();
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L30;
        com.obric.a.a.f.f5867a.b("CallContentObserver", "findSubscriptionSlotBySimId: duplicated sim ids, simId=" + b(r10) + ", matchedSlotCount=" + r15.size());
        return -1;
    L30:
        return (Integer) ZeusTransformUtils.preCheckCast(r15.get(0), Integer.class, "com.obric.memorydata.plugin");
    L21:
        return null;
    }

    private static final String a(Context r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        int r3 = b(r7);     // Catch: Exception -> L16 SecurityException -> L18
        if (r3 == (-1)) goto L24;
        String r9 = TelephonyManager.from(r8).createForSubscriptionId(r3).getLine1Number();     // Catch: Exception -> L16 SecurityException -> L18
        if (r9 == null) goto L25;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Exception -> L16 SecurityException -> L18
        if (r10 == null) goto L26;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L28;
        return null;
    L28:
        return r10;
    L13:
        r11 = false;
        goto L14
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L18:
        e = e;
        com.obric.a.a.f r4 = com.obric.a.a.f.f5867a;
        StringBuilder r5 = new StringBuilder();
        String r12 = "getLine1Number: permission denied, slotId=";
    L20:
        r4.a("CallContentObserver", r5.append(r12).append(r7).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L16:
        e = e;
        r4 = com.obric.a.a.f.f5867a;
        r5 = new StringBuilder();
        r12 = "getLine1Number: failed, slotId=";
        goto L20
    }

    private static final String a(Context r8, int r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        SubscriptionManager r0 = (SubscriptionManager) ZeusTransformUtils.preCheckCast(r11.getSystemService(SubscriptionManager.class), SubscriptionManager.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        List<SubscriptionInfo> r3 = a(r0, false);
        List<SubscriptionInfo> r1 = a(r0, true);
        int r5 = a(r9, r10, r3, r1);
        if (r5 != (-1)) goto L5;
        return null;
    L5:
        String r4 = b(r3, r5);
        if (r4 != null) goto L8;
        r4 = b(r1, r5);
    L8:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return r4;
    L17:
        String r12 = a(r11, r5);
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L20;
    L21:
        r2 = true;
    L22:
        if (r2 == true) goto L24;
        return r12;
    L24:
        com.obric.a.a.f.f5867a.b("CallContentObserver", "resolveSourceSimNumber: source sim number empty, subscriptionId=" + r9 + ", simId=" + b(r10) + ", slotId=" + r5);
        return null;
    L20:
        if (r13.length() != 0) goto L22;
    L11:
        if (r6.length() == 0) goto L14;
        r7 = false;
        goto L15
    }

    public static final String a(Context r9, String r10, ContactEntity r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r10, "phoneNumber");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return r10;
    L5:
        if (r11 == null) goto L15;
        List<MetaTelephone> r13 = r11.getTelephones();
        if (r13 != null) goto L9;
        r13 = CollectionsKt.emptyList();
    L9:
        Iterator<MetaTelephone> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L15;
        String r0 = ((MetaTelephone) ZeusTransformUtils.preCheckCast(r14.next(), MetaTelephone.class, "com.obric.memorydata.plugin")).getTelephone();
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r0, " ", "", false, 4, null), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        return r0;
    L15:
        Object r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE);
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r15, TelephonyManager.class) == false) goto L18;
        TelephonyManager r16 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r15, TelephonyManager.class, "com.obric.memorydata.plugin");
    L19:
        if (r16 == null) goto L21;
        String r17 = r16.getSimCountryIso();
    L22:
        if (r17 == null) goto L24;
        r1 = r17.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r1, "toUpperCase(...)");
    L24:
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L27;
    L30:
        boolean r19 = true;
    L31:
        if (r19 == false) goto L33;
        r1 = Locale.CHINA.getCountry();
    L33:
        String r20 = PhoneNumberUtils.formatNumber(r10, r1);
        if (r20 != null) goto L37;
        return r10;
    L37:
        return r20;
    L27:
        if (r18.length() == 0) goto L30;
        r19 = false;
        goto L31
    L21:
        r17 = null;
        goto L22
    L18:
        r16 = null;
        goto L19
    }

    public static final String a(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        if (r4 != null) goto L5;
    L9:
        return null;
    L5:
        if (r4.getCount() <= 0) goto L9;
        int r5 = r4.getColumnIndex(r3);
        if (r5 == (-1)) goto L9;
        return r4.getString(r5);
    }

    public static final String a(String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "";
    L12:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(new Regex("(省|自治区|直辖市)").replace(r5, " "), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(new Regex("市").replace(r6, " "), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(new Regex("[·]").replace(r7, " "), CharSequence.class, "com.obric.memorydata.plugin");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(new Regex("\\s+").replace(r8, " "), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<CallHistoryEntity> a(ContentResolver r35, List<Long> r36, Context r37) {
        r35 = r35;
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r37, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r35, "contentResolver");
        Intrinsics.checkNotNullParameter(r9, "ids");
        Intrinsics.checkNotNullParameter(r10, "context");
        String r4 = "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null);
        Cursor r1 = ZeusProviderTransform.query(r35, CallLog.Calls.CONTENT_URI, new String[]{"_id", "date", "duration", "number", "type", "numberlabel", "geocoded_location", "subscription_id", "sim_id"}, r4, null, null, "com.obric.memorydata.plugin");
        String r2 = "CallContentObserver";
        if (r1 != null) goto L5;
        com.obric.a.a.f.f5867a.b("CallContentObserver", "queryCallLogsByIds: call log cursor is null");
    L5:
        List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L119;
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.preCheckCast(r6, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L112
        int r11 = 0;
        int r12 = 0;
        boolean r13 = false;
    L10:
        if (r7.moveToNext() == false) goto L107;
        int r14 = r7.getColumnIndex("_id");     // Catch: Throwable -> L112
        int r15 = r7.getColumnIndex("date");     // Catch: Throwable -> L112
        int r8 = r7.getColumnIndex("duration");     // Catch: Throwable -> L112
        int r16 = r7.getColumnIndex("number");     // Catch: Throwable -> L112
        int r17 = r7.getColumnIndex("type");     // Catch: Throwable -> L112
        r6 = r6;
        int r18 = r7.getColumnIndex("numberlabel");     // Catch: Throwable -> L105
        r2 = r2;
        int r19 = r7.getColumnIndex("geocoded_location");     // Catch: Throwable -> L105
        r13 = r13;
        int r110 = r7.getColumnIndex("subscription_id");     // Catch: Throwable -> L105
        List r21 = r3;
        int r20 = r7.getColumnIndex("sim_id");     // Catch: Throwable -> L105
        r12 = r12;
        if (r14 == (-1)) goto L99;
        if (r15 == (-1)) goto L99;
        if (r8 == (-1)) goto L99;
        if (r16 == (-1)) goto L99;
        if (r17 == (-1)) goto L99;
        if (r18 == (-1)) goto L99;
        if (r19 == (-1)) goto L99;
        String r24 = r7.getString(r14);     // Catch: Throwable -> L105
        long r111 = r7.getLong(r15);     // Catch: Throwable -> L105
        int r22 = r7.getInt(r8);     // Catch: Throwable -> L105
        String r23 = r7.getString(r16);     // Catch: Throwable -> L105
        int r25 = r7.getInt(r17);     // Catch: Throwable -> L105
        String r26 = r7.getString(r18);     // Catch: Throwable -> L105
        String r27 = r7.getString(r19);     // Catch: Throwable -> L105
        if (r110 == (-1)) goto L24;
        int r112 = r7.getInt(r110);     // Catch: Throwable -> L105
    L25:
        if (r20 == (-1)) goto L27;
        String r28 = r7.getString(r20);     // Catch: Throwable -> L105
    L28:
        String r29 = a(r10, r112, r28);     // Catch: Throwable -> L105
        CharSequence r113 = (CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
        if (r113 != null) goto L31;
    L34:
        boolean r114 = true;
    L35:
        if (r114 == true) goto L37;
        r11 = r11 + 1;     // Catch: Throwable -> L105
    L37:
        CallTypeEnum r31 = a(r25, r22);     // Catch: Throwable -> L105
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L105
        String r30 = e.a(r35, r23);     // Catch: Throwable -> L105
        Ref.ObjectRef r115 = new Ref.ObjectRef();     // Catch: Throwable -> L105
        if (r30 == null) goto L47;
        long r210 = Long.parseLong(r30);     // Catch: Throwable -> L105
        ContactEntity r32 = (ContactEntity) ZeusTransformUtils.preCheckCast(r5.get(Long.valueOf(r210)), ContactEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
        if (r32 != null) goto L45;
        List<ContactEntity> r33 = e.a(r35, CollectionsKt.listOf(Long.valueOf(r210)), false, false);     // Catch: Throwable -> L105
        boolean r34 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r33, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L44;
        r5.put(Long.valueOf(r210), r33.get(0));     // Catch: Throwable -> L105
        T r38 = r33;
    L46:
        r115.element = r38;     // Catch: Throwable -> L105
    L48:
        List r39 = (List) ZeusTransformUtils.preCheckCast(r115.element, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
        if (r39 == null) goto L51;
        boolean r40 = false;
        ContactEntity r41 = (ContactEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r39, 0), ContactEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
    L52:
        List r211 = CollectionsKt.listOf(a(r10, r23, r41));     // Catch: Throwable -> L105
        b r42 = c.a(r35, r111);     // Catch: Throwable -> L105
        if (r31 == null) goto L97;
        Intrinsics.checkNotNull(r24);     // Catch: Throwable -> L105
        CallHistoryEntity r43 = new CallHistoryEntity(r24, r111, r111, r211, (List) ZeusTransformUtils.preCheckCast(r115.element, List.class, "com.obric.memorydata.plugin"), r31, r22);     // Catch: Throwable -> L105
        String r44 = h.a(r10, r29);     // Catch: Throwable -> L105
        r43.setSourceNumber(r44);     // Catch: Throwable -> L105
        CharSequence r45 = (CharSequence) ZeusTransformUtils.preCheckCast(r44, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
        if (r45 != null) goto L57;
    L60:
        boolean r116 = r34;
    L61:
        if (r116 == true) goto L63;
        r12 = r12 + 1;     // Catch: Throwable -> L105
    L64:
        CharSequence r46 = (CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
        if (r46 != null) goto L67;
    L70:
        boolean r117 = r34;
    L71:
        if (r117 == true) goto L73;
        String r47 = a(r27);     // Catch: Throwable -> L105
    L84:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r47, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L86;
        boolean r118 = r34;
    L87:
        if (r118 == false) goto L89;
        r43.setCarriers(CollectionsKt.listOf(r47));     // Catch: Throwable -> L105
    L89:
        if (r26 == null) goto L91;
        Intrinsics.checkNotNull(r26);     // Catch: Throwable -> L105
        r43.setTag(r26);     // Catch: Throwable -> L105
    L91:
        if (r42 == null) goto L96;
        r43.setHasTranscript(r42.a());     // Catch: Throwable -> L105
        String r48 = r42.b();     // Catch: Throwable -> L105
        if (r48 == null) goto L95;
        r43.setTranscript(r48);     // Catch: Throwable -> L105
    L95:
        r43.setTodoList(r42.c());     // Catch: Throwable -> L105
        r43.setTranscriptTitle(r42.d());     // Catch: Throwable -> L105
    L96:
        r21.add(r43);     // Catch: Throwable -> L105
        r3 = r21;
    L98:
        r11 = r11;
        goto L10
    L86:
        r118 = r40;
        goto L87
    L73:
        CharSequence r49 = (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
        if (r49 != null) goto L76;
    L79:
        boolean r119 = r34;
    L80:
        if (r119 == true) goto L82;
        Intrinsics.checkNotNull(r26);     // Catch: Throwable -> L105
        r47 = r26;
        goto L84
    L82:
        r47 = "";
        goto L84
    L76:
        if (r49.length() == 0) goto L79;
        r119 = r40;
        goto L80
    L67:
        if (r46.length() == 0) goto L70;
        r117 = r40;
        goto L71
    L63:
        r12 = r12;
        goto L64
    L57:
        if (r45.length() == 0) goto L60;
        r116 = r40;
        goto L61
    L97:
        r3 = r21;
        r12 = r12;
        goto L98
    L51:
        r40 = false;
        r41 = null;
        goto L52
    L44:
        r38 = r33;
        goto L46
    L45:
        r34 = true;
        r38 = CollectionsKt.listOf(r32);     // Catch: Throwable -> L105
        goto L46
    L47:
        r7 = r7;
        r11 = r11;
        r34 = true;
        goto L48
    L31:
        if (r113.length() == 0) goto L34;
        r114 = false;
        goto L35
    L27:
        r28 = null;
        goto L28
    L24:
        r112 = -1;
    L99:
        Cursor r310 = r7;
        r3 = r21;
        if (r13 == true) goto L103;
        Map r212 = r5;
        com.obric.a.a.f.f5867a.b(r2, "queryCallLogsByIds: required column missing, callIdIndex=" + r14 + ", dateIndex=" + r15 + ", durationIndex=" + r8 + ", numberIndex=" + r16 + ", typeIndex=" + r17 + ", cachedNumberLabelIndex=" + r18 + ", geocodedLocationIndex=" + r19 + ", subscriptionIdIndex=" + r110 + ", simIdIndex=" + r20);     // Catch: Throwable -> L105
        r2 = r2;
        r5 = r212;
        r13 = true;
    L104:
        r7 = r310;
        goto L10
    L103:
        r2 = r2;
        r13 = r13;
    L105:
        th = move-exception;
        Throwable r50 = th;
        Closeable r51 = r6;
    L122:
        throw r50;     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        CloseableKt.closeFinally(r51, r50);
        throw th;
    L107:
        Closeable r120 = r6;
        String r52 = r2;
        List r53 = r3;
        List r121 = r9;
        int r213 = r12;
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L110
        CloseableKt.closeFinally(r120, null);
        int r54 = r11;
        List r55 = r121;
        int r56 = r213;
    L120:
        List<CallHistoryEntity> r57 = a(r53, r55);
        com.obric.a.a.f.f5867a.b(r52, "queryCallLogsByIds: finish, idsSize=" + r55.size() + ", queriedSize=" + r53.size() + ", orderedSize=" + r57.size() + ", sourceSimNumberResolvedSize=" + r54 + ", sourceNumberFilledSize=" + r56);
        return r57;
    L110:
        th = th;
        r51 = r120;
    L114:
        r50 = th;
    L112:
        th = th;
        r51 = r6;
        goto L114
    L119:
        r52 = "CallContentObserver";
        r53 = r3;
        r55 = r9;
        r56 = 0;
        r54 = 0;
        goto L120
    }

    public static final List<Long> a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        List<Long> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Uri r2 = CallLog.Calls.CONTENT_URI;
        Cursor r1 = ZeusProviderTransform.query(r9.getContentResolver(), r2, new String[]{"_id"}, null, null, null, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r1.moveToNext() == false) goto L9;
        int r3 = r1.getColumnIndex("_id");
        if (r3 == (-1)) goto L5;
        r0.add(Long.valueOf(r1.getLong(r3)));
        goto L5
    L9:
        r1.close();
        goto L10
    }

    public static final List<String> a(Context r12, List<String> r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "callFlags");
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        ContentResolver r16 = r14.getContentResolver();
        String[] r10 = {"_id", "date", "number"};
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r17.hasNext() == false) goto L27;
        Pair<String, String> r2 = c.a((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L8;
        String[] r6 = {r2.getFirst(), r2.getSecond()};
    L9:
        Cursor r3 = ZeusProviderTransform.query(r16, CallLog.Calls.CONTENT_URI, r10, "date=? AND number=?", r6, "date DESC", "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L14:
        if (r3.moveToNext() == false) goto L20;
        String r7 = a(r3, "_id");     // Catch: Throwable -> L22
        if (r7 == null) goto L14;
        if (r0.contains(r7) == true) goto L14;
        r0.add(r7);     // Catch: Throwable -> L22
        goto L14
    L20:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r4, null);
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L8:
        r6 = null;
        goto L9
    L27:
        return r0;
    }

    private static final List<SubscriptionInfo> a(SubscriptionManager r4, boolean r5) {
        List<SubscriptionInfo> r0 = null;
        if (r5 == false) goto L6;
        if (r4 == null) goto L11;
        r0 = r4.getActiveSubscriptionInfoList();     // Catch: SecurityException -> L9
    L14:
    L11:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return CollectionsKt.emptyList();
    L6:
        if (r4 == null) goto L11;
        r0 = r4.getAvailableSubscriptionInfoList();     // Catch: SecurityException -> L9
    L9:
        e = move-exception;
        com.obric.a.a.f.f5867a.a("CallContentObserver", "loadSubscriptions: query subscriptions failed, activeOnly=" + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L11
    }

    public static final List<AppEntity> a(List<? extends AppEntity> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "entities");
        long r2 = System.currentTimeMillis() - 63072000000L;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Object r5 = r1.next();
        AppEntity r6 = (AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, CallHistoryEntity.class) == true) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L4;
        r4.add(r5);
        goto L4
    L8:
        if (r6.getCreateTime() >= r2) goto L11;
        r7 = false;
        goto L12
    L14:
        List<AppEntity> r3 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r3.size() <= 500) goto L17;
        List<AppEntity> r10 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), 500);
    L18:
        int r11 = r9.size() - r3.size();
        int r12 = r3.size() - r10.size();
        com.obric.a.a.f.f5867a.b("CallContentObserver", "filterExpiredCallHistoryEntities: " + r9.size() + " -> " + r10.size() + " (expired " + r11 + ", truncated " + r12 + ')');
        com.obric.a.a.d r13 = com.obric.a.a.e.f5865a.a();
        if (r13 == null) goto L21;
        r13.a(r9.size(), r10.size(), r11, r12);
    L21:
        return r10;
    L17:
        r10 = r3;
        goto L18
    }

    public static final List<CallHistoryEntity> a(List<CallHistoryEntity> r9, List<Long> r10) {
        List<CallHistoryEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "callHistoryEntities");
        Intrinsics.checkNotNullParameter(r12, "ids");
        List<CallHistoryEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L14;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Iterator<CallHistoryEntity> r4 = r11.iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        CallHistoryEntity r5 = (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r4.next(), CallHistoryEntity.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5.getId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        if (r0.contains(r5) == true) goto L7;
        r0.add(r5);
        goto L7
    L14:
        if (r0.size() != 0) goto L17;
        return r11;
    L17:
        return r0;
    }

    private static final boolean a(Integer r2) {
        if (r2 != null) goto L6;
    L7:
        if (r2 != null) goto L10;
    L12:
        return false;
    L10:
        if (r2.intValue() != 1) goto L12;
        return true;
    L6:
        if (r2.intValue() != 0) goto L7;
        return true;
    }

    private static final int b(int r7) {
        int[] r1 = SubscriptionManager.getSubId(r7);     // Catch: Exception -> L18
        if (r1 == null) goto L25;
        int r2 = r1.length;     // Catch: Exception -> L18
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        int r5 = r1[r4];     // Catch: Exception -> L18
        if (r5 == (-1)) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L12;
        r4 = r4 + 1;     // Catch: Exception -> L18
        goto L6
    L12:
        Integer r3 = Integer.valueOf(r5);     // Catch: Exception -> L18
    L15:
        if (r3 == null) goto L26;
        return r3.intValue();
    L26:
        return -1;
    L10:
        r6 = false;
        goto L11
    L14:
        r3 = null;
        goto L15
    L25:
        return -1;
    L18:
        e = move-exception;
        com.obric.a.a.f.f5867a.a("CallContentObserver", "getSubscriptionIdForSlot: failed, slotId=" + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return -1;
    }

    private static final String b(String r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        return "blank";
    L8:
        return "present(length=" + r2.length() + ')';
    }

    private static final String b(List<? extends SubscriptionInfo> r6, int r7) {
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r2 = true;
        if (r8.hasNext() == false) goto L11;
        Object r0 = r8.next();
        if (((SubscriptionInfo) ZeusTransformUtils.preCheckCast(r0, SubscriptionInfo.class, "com.obric.memorydata.plugin")).getSimSlotIndex() != r7) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L3;
    L12:
        SubscriptionInfo r9 = (SubscriptionInfo) ZeusTransformUtils.preCheckCast(r0, SubscriptionInfo.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        String r10 = r9.getNumber();
        if (r10 == null) goto L17;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L18:
        if (r11 != null) goto L20;
        return null;
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L23;
        r2 = false;
    L23:
        if (r2 == true) goto L25;
        return null;
    L25:
        return r11;
    L17:
        r11 = null;
        goto L18
    L8:
        r5 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public static final List<EntityIdData> b(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        List<EntityIdData> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Uri r3 = CallLog.Calls.CONTENT_URI;
        Cursor r2 = ZeusProviderTransform.query(r11.getContentResolver(), r3, new String[]{"_id", "date"}, null, null, null, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        int r12 = r1.getColumnIndex("_id");     // Catch: Throwable -> L13
        int r5 = r1.getColumnIndex("date");     // Catch: Throwable -> L13
        if (r12 == (-1)) goto L11;
        if (r5 == (-1)) goto L11;
    L9:
        if (r1.moveToNext() == false) goto L11;
        String r6 = r1.getString(r12);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");     // Catch: Throwable -> L13
        r0.add(new EntityIdData(r6, 202, r1.getLong(r5)));     // Catch: Throwable -> L13
    L11:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r4, null);
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L18:
        return r0;
    }
}
