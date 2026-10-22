package com.obric.memorydata.personalcontext.external.message;

import android.net.Uri;
import android.provider.Telephony;
import androidx.room.FtsOptions;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\n\u0010!\u001a\u00020\u000f*\u00020\u000f\u001a\n\u0010\"\u001a\u00020\u000f*\u00020\u000f\u001a\n\u0010#\u001a\u00020\u000f*\u00020\u000f\u001a\n\u0010$\u001a\u00020%*\u00020\u000f\u001a\n\u0010&\u001a\u00020%*\u00020\u000f\u001a\n\u0010'\u001a\u00020%*\u00020\u000f\u001a\f\u0010(\u001a\u0004\u0018\u00010\u000f*\u00020\u000f\u001a\f\u0010)\u001a\u0004\u0018\u00010\u000f*\u00020\u000f\u001a\f\u0010*\u001a\u0004\u0018\u00010\u000f*\u00020\u000f\"\u001e\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0007\u0010\u0004\"\u001e\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\t\u0010\u0004\"\u001e\u0010\n\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000b\u0010\u0004\"\u001e\u0010\f\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\u0004\"\u0014\u0010\u000e\u001a\u00020\u000fX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u000fX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0014\u0010\u0014\u001a\u00020\u000fX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0014\u0010\u0016\u001a\u00020\u000fX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0014\u0010\u0018\u001a\u00020\u000fX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d\"\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001d¨\u0006+"}, d2 = {"SMS_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getSMS_URI", "()Landroid/net/Uri;", "Landroid/net/Uri;", "MMS_URI", "getMMS_URI", "MMS_SMS_URI", "getMMS_SMS_URI", "SMS_MMS_THREAD_URI", "getSMS_MMS_THREAD_URI", "SMS_MMS_CANONICAL_URI", "getSMS_MMS_CANONICAL_URI", "SMS_PREFIX_ID", "", "getSMS_PREFIX_ID", "()Ljava/lang/String;", "MMS_PREFIX_ID", "getMMS_PREFIX_ID", "RMS_PREFIX_ID", "getRMS_PREFIX_ID", "SMS_ID", "getSMS_ID", "MMS_ID", "getMMS_ID", "SMS_PROJECTION", "", "getSMS_PROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "MMS_PROJECTION", "getMMS_PROJECTION", "toSmsId", "toMmsId", "toRmsId", "isSms", "", "isMms", "isRms", "getSmsOriginId", "getMmsOriginId", "getRmsOriginId", "obric_entity_data_collector_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f12145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f12146b = null;
    private static final Uri c = null;
    private static final Uri d = null;
    private static final Uri e = null;
    private static final String f = null;
    private static final String g = null;
    private static final String h = null;
    private static final String i = null;
    private static final String j = null;
    private static final String[] k = null;
    private static final String[] l = null;

    static {
        f12145a = Telephony.Sms.CONTENT_URI;
        f12146b = Telephony.Mms.CONTENT_URI;
        c = Telephony.MmsSms.CONTENT_URI;
        d = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter(FtsOptions.TOKENIZER_SIMPLE, "true").build();
        e = Uri.parse("content://mms-sms/canonical-addresses");
        f = "sms_";
        g = "mms_";
        h = "rms_";
        i = "_id";
        j = "_id";
        k = new String[]{"_id", "thread_id", MemoryKeyInfoEntity.KEY_ADDRESS, "body", "date", "date_sent", "type"};
        l = new String[]{"_id", "thread_id", "date", "date_sent", "m_type", "msg_box", "text_only", "ct_t"};
    }

    public static final Uri a() {
        return f12145a;
    }

    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return f + r2;
    }

    public static final Uri b() {
        return f12146b;
    }

    public static final String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return g + r2;
    }

    public static final Uri c() {
        return c;
    }

    public static final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return h + r2;
    }

    public static final Uri d() {
        return d;
    }

    public static final boolean d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return StringsKt.startsWith$default(r4, f, false, 2, null);
    }

    public static final Uri e() {
        return e;
    }

    public static final boolean e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return StringsKt.startsWith$default(r4, g, false, 2, null);
    }

    public static final String f() {
        return f;
    }

    public static final boolean f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return StringsKt.startsWith$default(r4, h, false, 2, null);
    }

    public static final String g() {
        return g;
    }

    public static final String g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (d(r1) == true) goto L6;
        return null;
    L6:
        String r2 = r1.substring(f.length());
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        return r2;
    }

    public static final String h() {
        return h;
    }

    public static final String h(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (e(r1) == true) goto L6;
        return null;
    L6:
        String r2 = r1.substring(g.length());
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        return r2;
    }

    public static final String i() {
        return i;
    }

    public static final String i(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (f(r1) == true) goto L6;
        return null;
    L6:
        String r2 = r1.substring(h.length());
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        return r2;
    }

    public static final String j() {
        return j;
    }

    public static final String[] k() {
        return k;
    }

    public static final String[] l() {
        return l;
    }
}
