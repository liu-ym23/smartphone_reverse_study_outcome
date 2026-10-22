package com.obric.smssdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import androidx.room.FtsOptions;
import bytedanceos.app.mms.verification.VerificationManager;
import com.obric.a.a.f;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.obric.contactsdk.loader.e;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001IB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u0004H\u0002J\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050-2\u0006\u0010/\u001a\u000200J2\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002080-072\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0007J(\u0010>\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010/\u001a\u0002002\b\u0010A\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0007J*\u0010D\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200J \u0010G\u001a\b\u0012\u0004\u0012\u0002050-2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010F\u001a\u00020\u000fH\u0002J\u0018\u0010H\u001a\b\u0012\u0004\u0012\u0002050-2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0019\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u000e\u0010\u001b\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b!\u0010\u0011R\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b#\u0010\u0011R\u0019\u0010$\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\nR\u0019\u0010&\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\nR\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b)\u0010\u0011R\u000e\u0010*\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/smssdk/utils/SmsMmsDatabaseUtil;", "", "()V", "MESSAGE_TYPE_RETRIEVE_CONF", "", "MESSAGE_TYPE_SEND_REQ", "MMS_CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getMMS_CONTENT_URI", "()Landroid/net/Uri;", "MMS_DRAFT_CONTENT_URI", "getMMS_DRAFT_CONTENT_URI", "MMS_PROJECTION", "", "", "getMMS_PROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "MMS_SMS_CANONICAL_URI", "getMMS_SMS_CANONICAL_URI", "MMS_SMS_CONTENT_URI", "getMMS_SMS_CONTENT_URI", "MMS_SMS_OBSERVER_URI", "getMMS_SMS_OBSERVER_URI", "MMS_SMS_THREAD_URI", "getMMS_SMS_THREAD_URI", "MMS_TYPE", "PROJECTION", "getPROJECTION", "SAMPLE_MMS_DRAFT_PROJECTION", "getSAMPLE_MMS_DRAFT_PROJECTION", "SAMPLE_PROJECTION", "getSAMPLE_PROJECTION", "SAMPLE_SMS_DRAFT_PROJECTION", "getSAMPLE_SMS_DRAFT_PROJECTION", "SMS_CONTENT_URI", "getSMS_CONTENT_URI", "SMS_DRAFT_CONTENT_URI", "getSMS_DRAFT_CONTENT_URI", "SMS_PROJECTION", "getSMS_PROJECTION", "SMS_TYPE", "TAG", "getAllMessages", "", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "context", "Landroid/content/Context;", "getMessageStatus", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "code", "getMessageSyncSamples", "Lcom/obric/smssdk/utils/SmsMmsDatabaseUtil$MessageSyncSample;", "getMmsPart", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "mmsId", "createTime", "", "contentResolver", "Landroid/content/ContentResolver;", "getMmsSmsInfo", "cursor", "Landroid/database/Cursor;", "mmsSmsType", "getPhoneNumberByThreadId", "threadId", "getSmsMmsByRowIds", "rowIds", "type", "parseDraftSampleEntities", "parseSampleEntities", "MessageSyncSample", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f14983b = null;
    private static final String[] c = null;
    private static final String[] d = null;
    private static final String[] e = null;
    private static final String[] f = null;
    private static final String[] g = null;
    private static final Uri h = null;
    private static final Uri i = null;
    private static final Uri j = null;
    private static final Uri k = null;
    private static final Uri l = null;
    private static final Uri m = null;
    private static final Uri n = null;
    private static final Uri o = null;

    /* JADX INFO: renamed from: com.obric.smssdk.utils.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/smssdk/utils/SmsMmsDatabaseUtil$MessageSyncSample;", "", "rowId", "", "type", "", "lastModifyTime", "(JLjava/lang/String;J)V", "getLastModifyTime", "()J", "getRowId", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class C0802a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f14984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14985b;
        private final long c;

        public C0802a(long r2, String r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "type");
            this.f14984a = r2;
            this.f14985b = r4;
            this.c = r5;
        }

        public final long a() {
            return this.f14984a;
        }

        public final long b() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0802a.class) == true) goto L8;
            return false;
        L8:
            C0802a r10 = (C0802a) ZeusTransformUtils.preCheckCast(r9, C0802a.class, "com.obric.memorydata.plugin");
            if (this.f14984a == r10.f14984a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14985b, r10.f14985b) == true) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getType() {
            return this.f14985b;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f14984a) * 31) + this.f14985b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "MessageSyncSample(rowId=" + this.f14984a + ", type=" + this.f14985b + ", lastModifyTime=" + this.c + ')';
        }
    }

    static {
        f14982a = new a();
        f14983b = new String[]{"transport_type", "_id", "thread_id", MemoryKeyInfoEntity.KEY_ADDRESS, "body", "date", "date_sent", "type", "date", "date_sent", "m_type", "msg_box", "text_only", "ct_t"};
        c = new String[]{"_id", "thread_id", MemoryKeyInfoEntity.KEY_ADDRESS, "body", "date", "date_sent", "type"};
        d = new String[]{"_id", "thread_id", "date", "date_sent", "m_type", "msg_box", "text_only", "ct_t"};
        e = new String[]{"transport_type", "_id", "date", "date", "m_type"};
        f = new String[]{"_id", "date"};
        g = new String[]{"_id", "date", "m_type"};
        h = Uri.parse("content://mms-sms/complete-conversations");
        i = Uri.parse("content://sms");
        j = Uri.parse("content://mms");
        k = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter(FtsOptions.TOKENIZER_SIMPLE, "true").build();
        l = Uri.parse("content://mms-sms/canonical-addresses");
        m = Uri.parse("content://sms_change_with_action");
        n = Uri.parse("content://sms/draft");
        o = Uri.parse("content://mms/drafts");
    }

    private a() {
    }

    private final MessageStatusTypeEnum a(int r1) {
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L22;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L20;
        return null;
    L20:
        return MessageStatusTypeEnum.SEND_FAILED;
    L21:
        return MessageStatusTypeEnum.SENDING;
    L22:
        return MessageStatusTypeEnum.DRAFT;
    L23:
        return MessageStatusTypeEnum.OUTBOX;
    L18:
        return MessageStatusTypeEnum.INBOX;
    }

    private final List<C0802a> a(Cursor r15) {
        Cursor r14 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r15, Cursor.class, "com.obric.memorydata.plugin");
        List<C0802a> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L5;
        int r1 = r14.getColumnIndex("transport_type");
        int r2 = r14.getColumnIndex("_id");
        int r4 = r14.getColumnIndex("date");
        int r3 = r14.getColumnIndex("date");
        int r5 = r14.getColumnIndex("m_type");
    L8:
        if (r14.moveToNext() == false) goto L45;
        if (r1 < 0) goto L11;
        String r6 = r14.getString(r1);
    L12:
        String r10 = r6;
        if (r2 < 0) goto L15;
        long r7 = r14.getLong(r2);
    L16:
        long r8 = r7;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L19;
    L22:
        boolean r11 = true;
    L23:
        if (r11 == true) goto L8;
        long r12 = 0;
        if (r8 <= 0) goto L8;
        if (Intrinsics.areEqual(r10, "sms") == true) goto L29;
        if (Intrinsics.areEqual(r10, "mms") == false) goto L8;
        if (r5 < 0) goto L36;
        int r13 = r14.getInt(r5);
    L38:
        if (r13 == 128) goto L42;
        if (r13 != 132) goto L8;
    L42:
        if (r3 < 0) goto L44;
        r12 = r14.getLong(r3);
    L44:
        r16.add(new C0802a(r8, r10, 1000 * r12));
        goto L8
    L36:
        r13 = -1;
        goto L38
    L29:
        if (r4 < 0) goto L31;
        r12 = r14.getLong(r4);
    L31:
        r16.add(new C0802a(r8, r10, r12));
        goto L8
    L19:
        if (r9.length() == 0) goto L22;
        r11 = false;
        goto L23
    L15:
        r7 = -1;
        goto L16
    L11:
        r6 = null;
        goto L12
    L45:
        return r16;
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<C0802a> a(Cursor r14, String r15) {
        Cursor r13 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r14, Cursor.class, "com.obric.memorydata.plugin");
        List<C0802a> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L5;
        int r0 = r13.getColumnIndex("_id");
        if (Intrinsics.areEqual(r15, "sms") == false) goto L10;
    L8:
        int r1 = r13.getColumnIndex("date");
    L14:
        if (Intrinsics.areEqual(r15, "mms") == false) goto L16;
        int r2 = r13.getColumnIndex("m_type");
    L18:
        if (r13.moveToNext() == false) goto L40;
        if (r0 < 0) goto L21;
        long r5 = r13.getLong(r0);
    L22:
        long r8 = r5;
        long r6 = 0;
        if (r8 <= 0) goto L18;
        if (Intrinsics.areEqual(r15, "mms") == false) goto L34;
        if (r2 < 0) goto L28;
        int r7 = r13.getInt(r2);
    L30:
        if (r7 == 128) goto L34;
        if (r7 == 132) goto L34;
    L28:
        r7 = -1;
    L34:
        if (r1 < 0) goto L37;
        r6 = r13.getLong(r1);
    L37:
        if (Intrinsics.areEqual(r15, "mms") == false) goto L39;
        r6 = r6 * 1000;
    L39:
        r16.add(new C0802a(r8, r15, r6));
        goto L18
    L21:
        r5 = -1;
        goto L22
    L40:
        return r16;
    L16:
        r2 = -1;
        goto L18
    L10:
        if (Intrinsics.areEqual(r15, "mms") == true) goto L8;
        r1 = -1;
        goto L14
    L5:
        return CollectionsKt.emptyList();
    }

    public final Uri a() {
        return m;
    }

    public final List<String> a(long r20, ContentResolver r22) {
        Intrinsics.checkNotNullParameter(r22, "contentResolver");
        if (r20 <= 0) goto L5;
        ArrayList r4 = new ArrayList();
        Cursor r0 = ZeusProviderTransform.query(r22, k, new String[]{"recipient_ids"}, "_id = " + r20, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L71
        if (r0 == null) goto L24;
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L71
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r5, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r1.moveToFirst() == false) goto L13;
        String r2 = r1.getString(0);     // Catch: Throwable -> L17
    L14:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L71
    L26:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L28;
        f.f5867a.a("SmsMmsDatabaseUtil", "in getPhoneNumberByThreadId, spaceSepIds = " + r2);     // Catch: Exception -> L71
        if (r2 == null) goto L44;
        List r3 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{" "}, false, 0, 6, null);     // Catch: Exception -> L71
        if (r3 == null) goto L44;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L71
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L71
        Iterator r9 = r7.iterator();     // Catch: Exception -> L71
    L35:
        if (r9.hasNext() == false) goto L43;
        Long r10 = Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin")));     // Catch: NumberFormatException -> L39 Exception -> L71
    L41:
        if (r10 == null) goto L35;
        r8.add(r10);     // Catch: Exception -> L71
        goto L35
    L39:
        e = move-exception;
        f.f5867a.a("SmsMmsDatabaseUtil", "in function getPhoneNumberByThreadId", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L71
        r10 = null;
        goto L41
    L43:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L71
    L46:
        if (r11.isEmpty() == true) goto L48;
        Cursor r12 = ZeusProviderTransform.query(r22, l, null, "_id in " + StringsKt.replace$default(StringsKt.replace$default(r11.toString(), "[", "(", false, 4, null), "]", ")", false, 4, null), null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L71
        if (r12 == null) goto L73;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L71
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
    L54:
        if (r14.moveToNext() == false) goto L61;
        String r15 = r14.getString(r14.getColumnIndex(MemoryKeyInfoEntity.KEY_ADDRESS));     // Catch: Throwable -> L64
        if (r15 == null) goto L58;
        String r16 = new Regex("\\s").replace((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), "");     // Catch: Throwable -> L64
    L59:
        if (r16 == null) goto L54;
        f.f5867a.a("SmsMmsDatabaseUtil", "in getPhoneNumberByThreadId, address != null");     // Catch: Throwable -> L64
        r4.add(r16);     // Catch: Throwable -> L64
        goto L54
    L58:
        r16 = null;
        goto L59
    L61:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L71
        goto L73
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L71
        throw th;     // Catch: Exception -> L71
    L73:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L48:
        return CollectionsKt.emptyList();
    L44:
        r11 = CollectionsKt.emptyList();     // Catch: Exception -> L71
        goto L46
    L28:
        return CollectionsKt.emptyList();
    L13:
        r2 = null;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Exception -> L71
        throw th;     // Catch: Exception -> L71
    L24:
        r2 = null;
    L71:
        f.a(f.f5867a, "SmsMmsDatabaseUtil", "in getPhoneNumberByThreadId", null, 4, null);
        goto L73
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<MessageEntity> a(Context r13) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        f.f5867a.b("SmsMmsDatabaseUtil", "in getAllMessages");
        ContentResolver r14 = r12.getContentResolver();
        if (r14 == null) goto L5;
        List<MessageEntity> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusProviderTransform.query(r14, h, f14983b, null, null, null, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        a r10 = f14982a;     // Catch: Throwable -> L25
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r10.a(r4, r12, null), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L30
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusProviderTransform.query(r14, n, c, null, null, null, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r10.a((Cursor) ZeusTransformUtils.preCheckCast(r5, Cursor.class, "com.obric.memorydata.plugin"), r12, "sms"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L30
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusProviderTransform.query(r14, o, d, null, null, null, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r10.a((Cursor) ZeusTransformUtils.preCheckCast(r15, Cursor.class, "com.obric.memorydata.plugin"), r12, "mms"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r15, null);     // Catch: Exception -> L30
    L32:
        f.f5867a.b("SmsMmsDatabaseUtil", "getAllMessages size = " + r2.size());
        return r2;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        f.f5867a.a("SmsMmsDatabaseUtil", "getAllMessages error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L32
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<MessageEntity> a(Cursor r31, Context r32, String r33) {
        a r0 = this;
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r31, Cursor.class, "com.obric.memorydata.plugin");
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r32, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        ContentResolver r4 = r3.getContentResolver();
        List<MessageEntity> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L51;
        com.obric.smssdk.a r6 = new com.obric.smssdk.a(r1);
        f.f5867a.b("SmsMmsDatabaseUtil", "getMmsSmsInfo(), cursor size = " + r1.getCount());
    L6:
        if (r1.moveToNext() == false) goto L51;
        List<String> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<FileEntity> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r19 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r10 = "";
        if (r33 != null) goto L12;
        String r11 = r1.getString(r6.a());
        if (r11 != null) goto L13;
        r11 = "";
    L13:
        long r12 = r1.getLong(r6.b());
        String r14 = String.valueOf(r1.getLong(r6.c()));
        MessageTypeEnum r16 = null;
        long r17 = -1;
        if (Intrinsics.areEqual(r11, "sms") == true) goto L15;
        List<MessageEntity> r34 = r5;
        if (Intrinsics.areEqual(r11, "mms") == false) goto L40;
        int r9 = r1.getInt(r6.i());
        if (r9 == 128) goto L39;
        if (r9 == 132) goto L39;
        r5 = r34;
    L39:
        long r13 = r1.getLong(r6.h()) * 1000;
        Intrinsics.checkNotNull(r4);
        List<String> r15 = r0.a(r12, r4);
        Pair<String, List<FileEntity>> r18 = r0.a(r14, r13, r4);
        String r110 = (String) ZeusTransformUtils.preCheckCast(r18.getFirst(), String.class, "com.obric.memorydata.plugin");
        TypeIntrinsics.asMutableList(r8).addAll((Collection) ZeusTransformUtils.preCheckCast(r18.getSecond(), Collection.class, "com.obric.memorydata.plugin"));
        r17 = r13;
        String r20 = r110;
        List<String> r111 = r15;
        MessageStatusTypeEnum r21 = r0.a(r1.getInt(r6.j()));
        MessageTypeEnum r22 = null;
    L41:
        long r112 = r17;
    L42:
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L44:
        if (r113.hasNext() == false) goto L49;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r4);
        String r115 = e.a(r4, r114);
        Cursor r29 = r1;
        f.f5867a.a("SmsMmsDatabaseUtil", "contactId = " + r115);
        if (r115 == null) goto L48;
        TypeIntrinsics.asMutableList(r19).add(new ContactEntity(r115, 0, 0, "", null));
    L48:
        r1 = r29;
        goto L44
    L49:
        MessageEntity r2 = new MessageEntity(r11 + '_' + r14, r17, r112, r111, r20, r19);
        r2.setMessageType(r22);
        r2.setFiles(r8);
        r2.setMessageStatusType(r21);
        TypeIntrinsics.asMutableList(r34).add(r2);
        r0 = this;
        r5 = r34;
        r3 = r3;
        r1 = r1;
        goto L6
    L40:
        r20 = "";
        r22 = null;
        r111 = r7;
        r21 = null;
        goto L41
    L15:
        r17 = r1.getLong(r6.f());
        String r116 = r1.getString(r6.d());
        r34 = r5;
        if (r116 != null) goto L19;
        r116 = "";
    L19:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L21;
        Intrinsics.checkNotNull(r4);
        r7 = r0.a(r12, r4);
    L22:
        String r23 = r1.getString(r6.e());
        if (r23 == null) goto L26;
        r10 = r23;
    L26:
        MessageStatusTypeEnum r24 = r0.a(r1.getInt(r6.g()));
        if (VerificationManager.getInstance(r3).parseVerificationCode(r10) != null) goto L29;
    L31:
        r3 = r3;
        r20 = r10;
        r22 = r16;
        r112 = r17;
        r111 = r7;
        r21 = r24;
        r11 = r11;
        goto L42
    L29:
        if (r24 != MessageStatusTypeEnum.INBOX) goto L31;
        r16 = MessageTypeEnum.VERIFICATION_CODE;
        goto L31
    L21:
        TypeIntrinsics.asMutableList(r7).add(new Regex("\\s").replace((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.memorydata.plugin"), ""));
        goto L22
    L12:
        r11 = r33;
    L51:
        return r5;
    }

    public final List<MessageEntity> a(List<String> r13, String r14, Context r15) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "rowIds");
        Intrinsics.checkNotNullParameter(r14, "type");
        Intrinsics.checkNotNullParameter(r16, "context");
        ContentResolver r1 = r16.getContentResolver();
        if (r1 == null) goto L5;
        String r4 = "_id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(SmsMmsDatabaseUtil$getSmsMmsByRowIds$selection$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 30, null) + ')';
        String[] r5 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        f r17 = f.f5867a;
        StringBuilder r18 = new StringBuilder().append("selection = ").append(r4).append(", selectionArgs = ");
        String r2 = Arrays.toString(r5);
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        r17.a("SmsMmsDatabaseUtil", r18.append(r2).toString());
    L12:
        f.a(f.f5867a, "SmsMmsDatabaseUtil", "in getSmsMmsByRowIds, query failed!!!", null, 4, null);
        Cursor r19 = null;
    L13:
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r19, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        List<MessageEntity> r110 = f14982a.a(r19, r16, r14);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r3, null);
        return r110;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L8:
        if (Intrinsics.areEqual(r14, "sms") == false) goto L10;
        r19 = ZeusProviderTransform.query(r1, i, c, r4, r5, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
    L26:
        goto L13
    L10:
        r19 = ZeusProviderTransform.query(r1, j, d, r4, r5, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        goto L26
    L5:
        return CollectionsKt.emptyList();
    }

    public final Pair<String, List<FileEntity>> a(String r22, long r23, ContentResolver r25) {
        Intrinsics.checkNotNullParameter(r22, "mmsId");
        Intrinsics.checkNotNullParameter(r25, "contentResolver");
        Cursor r0 = ZeusProviderTransform.query(r25, Uri.parse(Telephony.Mms.CONTENT_URI.toString()).buildUpon().appendPath(r22).appendPath("part").build(), null, null, null, null, "com.obric.memorydata.plugin");
        ArrayList r1 = new ArrayList();
        f.f5867a.b("SmsMmsDatabaseUtil", "in getMmsPart, cursor = " + r0);
        String r2 = "";
        if (r0 == null) goto L24;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
    L7:
        if (r5.moveToNext() == false) goto L15;
        long r6 = r5.getLong(r5.getColumnIndex("_id"));     // Catch: Throwable -> L17
        String r8 = r5.getString(r5.getColumnIndex("ct"));     // Catch: Throwable -> L17
        String r9 = r5.getString(r5.getColumnIndex(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT));     // Catch: Throwable -> L17
        String r10 = r5.getString(r5.getColumnIndex("_data"));     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r8, "application/smil") == true) goto L7;
        if (r9 != null) goto L12;
        if (r10 == null) goto L7;
        Uri r7 = Uri.withAppendedPath(Uri.parse("content://mms/part"), String.valueOf(r6));     // Catch: Throwable -> L17
        f.f5867a.b("SmsMmsDatabaseUtil", "partUri = " + r7 + ", filePath = " + r10);     // Catch: Throwable -> L17
        String r15 = new File(r10).getName();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r15, "getName(...)");     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L17
        r1.add(new FileEntity(r10, r23, r23, r15, 0, r7, FileTypeEnum.FILE, r8));     // Catch: Throwable -> L17
        goto L7
    L12:
        r2 = r9;
        goto L7
    L15:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r3, null);
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L24:
        return new Pair(r2, r1);
    }

    public final List<C0802a> b(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        ContentResolver r14 = r13.getContentResolver();
        if (r14 == null) goto L5;
        List<C0802a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusProviderTransform.query(r14, h, e, null, null, null, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(f14982a.a(r3), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L16
    L41:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusProviderTransform.query(r14, n, f, null, null, null, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L34
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        a r10 = f14982a;     // Catch: Throwable -> L29
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r10.a(r5, "sms"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L34
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusProviderTransform.query(r14, o, g, null, null, null, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L34
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r10.a((Cursor) ZeusTransformUtils.preCheckCast(r15, Cursor.class, "com.obric.memorydata.plugin"), "mms"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r15, null);     // Catch: Exception -> L34
    L36:
        return r0;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Exception -> L34
        throw th;     // Catch: Exception -> L34
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L34
        throw th;     // Catch: Exception -> L34
    L34:
        e = move-exception;
        f.f5867a.a("SmsMmsDatabaseUtil", "getMessageSyncSamples draft query error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L36
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        f.f5867a.a("SmsMmsDatabaseUtil", "getMessageSyncSamples main query error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L41
    L5:
        return CollectionsKt.emptyList();
    }
}
