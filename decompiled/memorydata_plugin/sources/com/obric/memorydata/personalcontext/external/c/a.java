package com.obric.memorydata.personalcontext.external.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.h;
import com.obric.memorydata.utils.aj;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00052\u0006\u0010/\u001a\u000200H\u0016J\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00052\u0006\u0010/\u001a\u000200H\u0016J$\u00103\u001a\b\u0012\u0004\u0012\u00020.0\u00052\u0006\u0010/\u001a\u0002002\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0016Jk\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u00107\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0+2\b\u00109\u001a\u0004\u0018\u00010\b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010+2&\u0010;\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0=0\u0005\u0012\u0004\u0012\u0002060<¢\u0006\u0002\u0010>J,\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00052\u0006\u0010/\u001a\u0002002\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00052\b\b\u0002\u0010C\u001a\u00020DJ\u0012\u0010E\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010J\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020GH\u0002J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,¨\u0006N"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/contacts/ExternalContactsDataRequester;", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "<init>", "()V", "supportDonateTypes", "", "", "EMAIL_SELF", "", "EMAIL_WORK", "EMAIL_OTHER", "EMAIL_CUSTOM", "ADDRESS_HOME", "ADDRESS_WORK", "ADDRESS_OTHER", "ADDRESS_CUSTOM", "IM_QQ", "IM_MSN", "IM_SKYPE", "IM_WECHAT", "IM_MOMO", "IM_WANGWANG", "IM_CUSTOM", "DATE_BIRTHDAY", "DATE_CHINESE_BIRTHDAY", "DATE_ANNIVERSARY", "DATE_OTHER", "DATE_CUSTOM", "RELATION_CUSTOM", "RELATION_PARENT", "RELATION_MOTHER", "RELATION_FATHER", "RELATION_BROTHER", "RELATION_SISTER", "RELATION_SPOUSE", "RELATION_CHILDREN", "RELATION_FRIEND", "RELATION_FAMILY", "RELATION_ROOMMATE", "RELATION_PARTNER", "RELATION_LEADER", "RELATION_REFEREE", "CONTACT_DATA_PROJECTION", "", "[Ljava/lang/String;", "onGetAllEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "contentResolver", "Landroid/content/ContentResolver;", "onGetAllEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "onQueryEntities", "entityIds", "contactsPaginationQuery", "", "pageLimit", "projection", "selection", "selectionArgs", "result", "Lkotlin/Function1;", "", "(Landroid/content/ContentResolver;I[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "queryContactsByIds", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "ids", "", "isProfile", "", "phoneTypeToDesc", "cursor", "Landroid/database/Cursor;", "emailTypeToDesc", "addressTypeToDesc", "imTypeToDesc", "relationShipsTypeToDesc", "dateTypeToDesc", "getDonateEntityTypeList", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f12110b = null;
    private static final String[] c = null;

    static {
        f12109a = new a();
        f12110b = CollectionsKt.listOf(201);
        c = new String[]{"contact_id", "mimetype", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15"};
    }

    private a() {
    }

    private final String a(Cursor r5) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        String r6 = r4.getString(r4.getColumnIndexOrThrow("data2"));
        if (r6 == null) goto L10;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L11;
        int r8 = r7.intValue();
        String r9 = r4.getString(r4.getColumnIndexOrThrow("data3"));
        CharSequence r10 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"), r8, (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.toString();
    L11:
        return null;
    L10:
        return null;
    }

    private static final Unit a(List r4, List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "it");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r9.next(), Map.class, "com.obric.memorydata.plugin")).get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final String b(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        String r3 = r1.getString(r1.getColumnIndexOrThrow("data2"));
        if (r3 != null) goto L5;
    L23:
        return null;
    L5:
        switch(r3.hashCode()) {
            case 48: goto L20;
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L23;
        };
    L8:
        if (r3.equals("3") == false) goto L23;
        return IRecommendSettings.ProfileTag.OTHER;
    L12:
        if (r3.equals("2") == false) goto L23;
        return "工作";
    L16:
        if (r3.equals("1") == false) goto L23;
        return "家庭";
    L20:
        if (r3.equals("0") == false) goto L23;
        return r1.getString(r1.getColumnIndexOrThrow("data3"));
    }

    private static final Unit b(List r6, List r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "rows");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r10.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("contact_last_updated_timestamp"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L13;
        Long r3 = StringsKt.toLongOrNull(r1);
        if (r3 == null) goto L13;
        long r4 = r3.longValue();
    L14:
        r8.add(new EntityIdData(r2, 201, r4));
    L13:
        r4 = 0;
        goto L14
    L16:
        return Unit.INSTANCE;
    }

    private final String c(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        String r3 = r1.getString(r1.getColumnIndexOrThrow("data2"));
        if (r3 != null) goto L5;
    L23:
        return null;
    L5:
        switch(r3.hashCode()) {
            case 48: goto L20;
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L23;
        };
    L8:
        if (r3.equals("3") == false) goto L23;
        return IRecommendSettings.ProfileTag.OTHER;
    L12:
        if (r3.equals("2") == false) goto L23;
        return "工作";
    L16:
        if (r3.equals("1") == false) goto L23;
        return "住宅";
    L20:
        if (r3.equals("0") == false) goto L23;
        return r1.getString(r1.getColumnIndexOrThrow("data3"));
    }

    private final String d(Cursor r3) {
        Cursor r2 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        String r4 = r2.getString(r2.getColumnIndexOrThrow("data5"));
        if (r4 == null) goto L42;
        int r0 = r4.hashCode();
        if (r0 == 49) goto L39;
        if (r0 == 1444) goto L35;
        if (r0 == 51) goto L31;
        if (r0 == 52) goto L27;
        switch(r0) {
            case 48625: goto L23;
            case 48626: goto L19;
            case 48627: goto L15;
            default: goto L42;
        };
    L15:
        if (r4.equals(BDLocationException.ERROR_UID_IS_EMPTY) == false) goto L42;
        return "旺旺";
    L19:
        if (r4.equals("101") == false) goto L42;
        return "陌陌";
    L23:
        if (r4.equals(BDLocationException.ERROR_BEACON_ADVERTISING) == false) goto L42;
        return "微信";
    L27:
        if (r4.equals("4") == false) goto L42;
        return "QQ";
    L31:
        if (r4.equals("3") == false) goto L42;
        return "SKYPE";
    L35:
        if (r4.equals(StructuredDataId.RESERVED) == false) goto L42;
        return r2.getString(r2.getColumnIndexOrThrow("data6"));
    L39:
        if (r4.equals("1") == false) goto L42;
        return "MSN";
    L42:
        return null;
    }

    private final String e(Cursor r3) {
        Cursor r2 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        String r4 = r2.getString(r2.getColumnIndexOrThrow("data2"));
        if (r4 == null) goto L65;
        int r0 = r4.hashCode();
        if (r0 == 48) goto L62;
        switch(r0) {
            case 50: goto L58;
            case 51: goto L54;
            case 52: goto L50;
            case 53: goto L46;
            case 54: goto L42;
            case 55: goto L38;
            case 56: goto L34;
            case 57: goto L30;
            default: goto L7;
        };
    L7:
        switch(r0) {
            case 1567: goto L26;
            case 1568: goto L22;
            case 1569: goto L18;
            case 1570: goto L14;
            case 1571: goto L10;
            default: goto L65;
        };
    L10:
        if (r4.equals("14") == false) goto L65;
        return "配偶";
    L14:
        if (r4.equals("13") == false) goto L65;
        return "姐妹";
    L18:
        if (r4.equals("12") == false) goto L65;
        return "亲戚";
    L22:
        if (r4.equals("11") == false) goto L65;
        return "推荐人";
    L26:
        if (r4.equals("10") == false) goto L65;
        return "合作伙伴";
    L30:
        if (r4.equals("9") == false) goto L65;
        return "父母";
    L34:
        if (r4.equals("8") == false) goto L65;
        return "母亲";
    L38:
        if (r4.equals("7") == false) goto L65;
        return "经理";
    L42:
        if (r4.equals("6") == false) goto L65;
        return "朋友";
    L46:
        if (r4.equals("5") == false) goto L65;
        return "父亲";
    L50:
        if (r4.equals("4") == false) goto L65;
        return "室友";
    L54:
        if (r4.equals("3") == false) goto L65;
        return "子女";
    L58:
        if (r4.equals("2") == false) goto L65;
        return "兄弟";
    L62:
        if (r4.equals("0") == false) goto L65;
        return r2.getString(r2.getColumnIndexOrThrow("data3"));
    L65:
        return null;
    }

    private final String f(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        String r3 = r1.getString(r1.getColumnIndexOrThrow("data2"));
        if (r3 != null) goto L5;
    L22:
        return null;
    L5:
        switch(r3.hashCode()) {
            case 48: goto L19;
            case 49: goto L15;
            case 50: goto L11;
            case 51: goto L8;
            default: goto L22;
        };
    L8:
        if (r3.equals("3") == false) goto L22;
        return "生日";
    L11:
        if (r3.equals("2") == false) goto L22;
        return "其它";
    L15:
        if (r3.equals("1") == false) goto L22;
        return InfoCommonMemoryEntity.InfoKeyType.ANNIVERSARY;
    L19:
        if (r3.equals("0") == false) goto L22;
        return r1.getString(r1.getColumnIndexOrThrow("data3"));
    }

    public static /* synthetic */ Unit lambda$6UqTZzuqR1zxRNNz7KKBxl7avjQ(List r0, List r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ Unit lambda$O5yWN7CpOaa1TzPmAUZIbRVbigU(List r0, List r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<Integer> a() {
        return f12110b;
    }

    public final List<ContactEntity> a(ContentResolver r32, List<Long> r33, boolean r34) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r32, "contentResolver");
        Intrinsics.checkNotNullParameter(r0, "ids");
        String r2 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null);
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r6 = "_id IN " + r2;
        if (r34 == false) goto L5;
        Uri r3 = ContactsContract.Profile.CONTENT_URI;
    L6:
        Cursor r4 = ZeusProviderTransform.query(r32, r3, new String[]{"_id", "photo_uri", "contact_last_updated_timestamp"}, r6, null, null, "com.obric.memorydata.plugin");
        if (r4 == null) goto L25;
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.preCheckCast(r5, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L11:
        if (r7.moveToNext() == false) goto L17;
        long r8 = r7.getLong(r7.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L19
        String r22 = r7.getString(r7.getColumnIndexOrThrow("photo_uri"));     // Catch: Throwable -> L19
        long r9 = r7.getLong(r7.getColumnIndexOrThrow("contact_last_updated_timestamp"));     // Catch: Throwable -> L19
        if (r22 == null) goto L15;
        Uri r15 = Uri.parse(r22);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r15, "parse(...)");     // Catch: Throwable -> L19
        FileEntity r10 = new FileEntity(r22, 0, 0, r22, 0, r15, FileTypeEnum.FILE, "image/jpeg");     // Catch: Throwable -> L19
    L16:
        ContactEntity r12 = new ContactEntity(String.valueOf(r8), r9, r9, "", null);     // Catch: Throwable -> L19
        r12.setAvatar(r10);     // Catch: Throwable -> L19
        r11.put(Long.valueOf(r8), r12);     // Catch: Throwable -> L19
        r7 = r7;
        goto L11
    L15:
        r10 = null;
        goto L16
    L17:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r5, null);
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L25:
        String r14 = "contact_id IN " + r2;
        if (r34 == false) goto L28;
        Cursor r16 = ZeusProviderTransform.query(r32, Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), c, null, null, null, "com.obric.memorydata.plugin");
    L29:
        if (r16 == null) goto L156;
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r18 = (Cursor) ZeusTransformUtils.preCheckCast(r17, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L150
    L33:
        if (r18.moveToNext() == false) goto L148;
        ContactEntity r19 = (ContactEntity) ZeusTransformUtils.preCheckCast(r11.get(Long.valueOf(r18.getLong(r18.getColumnIndexOrThrow("contact_id")))), ContactEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L150
        String r20 = r18.getString(r18.getColumnIndexOrThrow("mimetype"));     // Catch: Throwable -> L150
        String r21 = r18.getString(r18.getColumnIndexOrThrow("data1"));     // Catch: Throwable -> L150
        if (r21 != null) goto L39;
        if (Intrinsics.areEqual(r20, "vnd.android.cursor.item/organization") == false) goto L33;
    L39:
        if (r19 == null) goto L33;
        if (r20 == null) goto L33;
        String r23 = "";
        boolean r110 = false;
        switch(r20.hashCode()) {
            case -1569536764: goto L142;
            case -1328682538: goto L131;
            case -1079224304: goto L127;
            case -1079210633: goto L117;
            case -601229436: goto L110;
            case 3430506: goto L106;
            case 456415478: goto L99;
            case 684173810: goto L92;
            case 689862072: goto L72;
            case 950831081: goto L61;
            case 1409846529: goto L50;
            case 2034973555: goto L46;
            default: goto L33;
        };
    L46:
        if (r20.equals("vnd.android.cursor.item/nickname") == false) goto L33;
    L48:
        r19.setNote(r21);     // Catch: Throwable -> L150
        goto L33
    L50:
        if (r20.equals("vnd.android.cursor.item/relation") == false) goto L33;
        List<MetaRelationship> r24 = r19.getRelationShips();     // Catch: Throwable -> L150
        if (r24 != null) goto L55;
        r24 = CollectionsKt.emptyList();     // Catch: Throwable -> L150
    L55:
        List<MetaRelationship> r25 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L150
        String r26 = f12109a.e(r18);     // Catch: Throwable -> L150
        if (r26 == null) goto L59;
        r23 = r26;
    L59:
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L150
        r25.add(new MetaRelationship(r23, r21));     // Catch: Throwable -> L150
        r19.setRelationShips(r25);     // Catch: Throwable -> L150
        goto L33
    L61:
        if (r20.equals("vnd.android.cursor.item/im") == false) goto L33;
        List<MetaInstantMessaging> r27 = r19.getInstantMessagings();     // Catch: Throwable -> L150
        if (r27 != null) goto L66;
        r27 = CollectionsKt.emptyList();     // Catch: Throwable -> L150
    L66:
        List<MetaInstantMessaging> r28 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L150
        String r29 = f12109a.d(r18);     // Catch: Throwable -> L150
        if (r29 == null) goto L70;
        r23 = r29;
    L70:
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L150
        r28.add(new MetaInstantMessaging(r23, r21));     // Catch: Throwable -> L150
        r19.setInstantMessagings(r28);     // Catch: Throwable -> L150
        goto L33
    L72:
        if (r20.equals("vnd.android.cursor.item/organization") == false) goto L33;
        r19.setCompany(r21);     // Catch: Throwable -> L150
        String r30 = r18.getString(r18.getColumnIndexOrThrow("data4"));     // Catch: Throwable -> L150
        if (r30 != null) goto L77;
    L83:
        String r31 = r18.getString(r18.getColumnIndexOrThrow("data5"));     // Catch: Throwable -> L150
        if (r31 == null) goto L33;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L88;
        r110 = true;
    L88:
        if (r110 == true) goto L89;
        r19.setDepartment(null);     // Catch: Throwable -> L150
        goto L33
    L89:
        r19.setDepartment(r31);     // Catch: Throwable -> L150
        goto L33
    L77:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L79;
        boolean r35 = true;
    L80:
        if (r35 == false) goto L82;
        r19.setJobTitle(r30);     // Catch: Throwable -> L150
        goto L83
    L82:
        r19.setJobTitle(null);     // Catch: Throwable -> L150
        goto L83
    L79:
        r35 = false;
        goto L80
    L92:
        if (r20.equals("vnd.android.cursor.item/phone_v2") == false) goto L33;
        List<MetaTelephone> r36 = r19.getTelephones();     // Catch: Throwable -> L150
        if (r36 != null) goto L97;
        r36 = CollectionsKt.emptyList();     // Catch: Throwable -> L150
    L97:
        List<MetaTelephone> r37 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L150
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L150
        r37.add(new MetaTelephone(r21, f12109a.a(r18)));     // Catch: Throwable -> L150
        r19.setTelephones(r37);     // Catch: Throwable -> L150
        goto L33
    L99:
        if (r20.equals("vnd.android.cursor.item/website") == false) goto L33;
        List<String> r38 = r19.getWebsites();     // Catch: Throwable -> L150
        if (r38 != null) goto L104;
        r38 = CollectionsKt.emptyList();     // Catch: Throwable -> L150
    L104:
        List<String> r39 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r38, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L150
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L150
        r39.add(r21);     // Catch: Throwable -> L150
        r19.setWebsites(r39);     // Catch: Throwable -> L150
        goto L33
    L106:
        if (r20.equals("vnd.android.cursor.item/sip_address") == false) goto L33;
        r19.setVoip(r21);     // Catch: Throwable -> L150
        goto L33
    L110:
        if (r20.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L33;
        List<MetaAddress> r40 = r19.getAddresses();     // Catch: Throwable -> L150
        if (r40 != null) goto L115;
        r40 = CollectionsKt.emptyList();     // Catch: Throwable -> L150
    L115:
        List<MetaAddress> r41 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r40, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L150
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L150
        r41.add(new MetaAddress(r21, f12109a.c(r18)));     // Catch: Throwable -> L150
        r19.setAddresses(r41);     // Catch: Throwable -> L150
        goto L33
    L117:
        if (r20.equals("vnd.android.cursor.item/note") == false) goto L33;
        r19.setSubNote(r21);     // Catch: Throwable -> L150
        CharSequence r42 = (CharSequence) ZeusTransformUtils.preCheckCast(r19.getNote(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L150
        if (r42 != null) goto L122;
    L123:
        r110 = true;
    L124:
        if (r110 == false) goto L33;
    L122:
        if (r42.length() != 0) goto L124;
    L127:
        if (r20.equals("vnd.android.cursor.item/name") == false) goto L33;
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L150
        r19.setName(r21);     // Catch: Throwable -> L150
        goto L33
    L131:
        if (r20.equals("vnd.android.cursor.item/contact_event") == false) goto L33;
        List<MetaAnniversary> r43 = r19.getAnniversaries();     // Catch: Throwable -> L150
        if (r43 != null) goto L136;
        r43 = CollectionsKt.emptyList();     // Catch: Throwable -> L150
    L136:
        List<MetaAnniversary> r44 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r43, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L150
        String r45 = f12109a.f(r18);     // Catch: Throwable -> L150
        if (r45 == null) goto L140;
        r23 = r45;
    L140:
        r44.add(new MetaAnniversary(r23, g.f12138a.a(r21)));     // Catch: Throwable -> L150
        r19.setAnniversaries(r44);     // Catch: Throwable -> L150
        goto L33
    L142:
        if (r20.equals("vnd.android.cursor.item/email_v2") == false) goto L33;
        List<MetaEmailAddress> r46 = r19.getEmails();     // Catch: Throwable -> L150
        if (r46 != null) goto L147;
        r46 = CollectionsKt.emptyList();     // Catch: Throwable -> L150
    L147:
        List<MetaEmailAddress> r47 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r46, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L150
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L150
        r47.add(new MetaEmailAddress(r21, f12109a.b(r18)));     // Catch: Throwable -> L150
        r19.setEmails(r47);     // Catch: Throwable -> L150
        goto L33
    L148:
        Unit r48 = Unit.INSTANCE;     // Catch: Throwable -> L150
        CloseableKt.closeFinally(r17, null);
    L150:
        th = move-exception;
        throw th;     // Catch: Throwable -> L153
    L153:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L156:
        g r49 = g.f12138a;
        Collection r50 = r11.values();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r51 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r52 = r1.iterator();
    L158:
        if (r52.hasNext() == false) goto L161;
        r51.add(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r52.next(), Number.class, "com.obric.memorydata.plugin")).longValue()));
        goto L158
    L161:
        return r49.a(r50, (List) ZeusTransformUtils.preCheckCast(r51, List.class, "com.obric.memorydata.plugin"));
    L28:
        r16 = ZeusProviderTransform.query(r32, ContactsContract.Data.CONTENT_URI, c, r14, null, null, "com.obric.memorydata.plugin");
        goto L29
    L5:
        r3 = ContactsContract.Contacts.CONTENT_URI;
        goto L6
    }

    public final void a(ContentResolver r10, int r11, String[] r12, String r13, String[] r14, Function1<? super List<? extends Map<String, String>>, Unit> r15) {
        Function1<? super List<? extends Map<String, String>>, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        Intrinsics.checkNotNullParameter(r12, "projection");
        Intrinsics.checkNotNullParameter(r8, "result");
        g r0 = g.f12138a;
        Uri r2 = ContactsContract.Contacts.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r2, "CONTENT_URI");
        r0.a(r10, r2, r12, "_id", r11, r13, r14, r8);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> b(ContentResolver r5, List<String> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "entityIds");
        List<AppEntity> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.add(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    L6:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 200), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        List<Long> r2 = (List) ZeusTransformUtils.preCheckCast(r10.next(), List.class, "com.obric.memorydata.plugin");
        r7.addAll((Collection) ZeusTransformUtils.preCheckCast(f12109a.a(r5, r2, false), Collection.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        return r7;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> c(ContentResolver r12) {
        Intrinsics.checkNotNullParameter(r12, "contentResolver");
        final List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Uri r4 = ContactsContract.Contacts.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r4, "CONTENT_URI");
        aj.a(r12, r4, new String[]{"_id"}, "_id", 200, null, null, new $$Lambda$a$O5yWN7CpOaa1TzPmAUZIbRVbigU(r0));
        List<AppEntity> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(a(r12, r0), Collection.class, "com.obric.memorydata.plugin"));
        return r1;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<EntityIdData> d(ContentResolver r11) {
        Intrinsics.checkNotNullParameter(r11, "contentResolver");
        final List<EntityIdData> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a(r11, 2000, new String[]{"_id", "contact_last_updated_timestamp"}, null, null, new $$Lambda$a$6UqTZzuqR1zxRNNz7KKBxl7avjQ(r0));
        return r0;
    }
}
