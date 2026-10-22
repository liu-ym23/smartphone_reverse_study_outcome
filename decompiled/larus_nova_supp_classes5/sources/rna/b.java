package rna;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.assistant.voice.l;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import sna.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static String a;
    public static String b;
    public static String c;
    public static final List<Regex> d = null;

    static {
        a = "";
        b = "";
        c = "";
        d = CollectionsKt.listOf(new Regex[]{new Regex("(\"uid\"\\s*:\\s*\")([^\"]*)(\")"), new Regex("(\\buid\\s*=\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buid\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buid:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buserId\\s*=\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bmyID\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bgivenUid\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buuid\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bcachedUUID\\s*=\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bsCachedUUID\\s*=\\s*)([^,\\s)\\]}]+)")});
    }

    @JvmStatic
    public static final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "doubaoDid");
        h r1 = h.a;
        Intrinsics.checkNotNullParameter(r2, "doubaoDid");
        if (StringsKt.isBlank(r2) == false) goto L5;
    L8:
        h.b("saveDoubaoDid ignored invalid value, valueLength=" + r2.length());
        return false;
    L5:
        if (Intrinsics.areEqual(r2, "0") == true) goto L8;
        h.a().storeString("doubao_did", r2);
        h.b("saveDoubaoDid success, valueLength=" + r2.length());
        return true;
    }

    @JvmStatic
    public static final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "osDeviceId");
        h r1 = h.a;
        Intrinsics.checkNotNullParameter(r2, "osDeviceId");
        if (StringsKt.isBlank(r2) == false) goto L5;
    L8:
        h.b("saveOsDeviceId ignored invalid value, valueLength=" + r2.length());
        return false;
    L5:
        if (Intrinsics.areEqual(r2, "0") == true) goto L8;
        h.a().storeString("os_device_id", r2);
        h.b("saveOsDeviceId success, valueLength=" + r2.length());
        return true;
    }

    @JvmStatic
    public static final void c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        h r0 = h.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r6, "config");     // Catch: Throwable -> L7
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L7
        h.a().storeString("voice_wakeup_sid_threshold_config", r6);     // Catch: Throwable -> L7
        h.a().storeLong("voice_wakeup_sid_threshold_cached_at", r2);     // Catch: Throwable -> L7
        h.b("saveSidThreshold success, configLength=" + r6.length() + ", cachedAt=" + r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final String d(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (c.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        Bundle r4 = r3.getContentResolver().call(l.a, "get-app-id", null, null);
        String r1 = "";
        if (r4 == null) goto L13;
        String r5 = r4.getString("appid", "");
        if (r5 == null) goto L13;
        r1 = r5;
    L13:
        c = r1;
    L15:
        return c;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final String e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        Bundle r4 = r3.getContentResolver().call(l.a, "get-app-version-name", null, null);
        String r1 = "";
        if (r4 == null) goto L13;
        String r5 = r4.getString(EffectConfiguration.KEY_VERSION, "");
        if (r5 == null) goto L13;
        r1 = r5;
    L13:
        b = r1;
    L15:
        return b;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final String f(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Bundle r4 = r3.getContentResolver().call(l.a, "get-build-channel", null, null);
        String r0 = "debug";
        if (r4 == null) goto L9;
        String r5 = r4.getString(EffectConfiguration.KEY_CHANNEL, "debug");
        if (r5 == null) goto L9;
        r0 = r5;
    L9:
        return r0;
    }

    @JvmStatic
    public static final String g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        h r3 = h.a;
        String r1 = "";
        String r4 = h.a().getString("doubao_did", "");
        if (r4 == null) goto L6;
        r1 = r4;
    L6:
        StringBuilder r5 = new StringBuilder("getDoubaoDid ");
        if (r1.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        String r6 = "cache miss";
    L13:
        r5.append(r6);
        r5.append(", valueLength=");
        r5.append(r1.length());
        h.b(r5.toString());
        q(r1);
        return r1;
    L12:
        r6 = "success";
        goto L13
    L9:
        r0 = false;
        goto L10
    }

    @JvmStatic
    public static final String h(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Bundle r5 = r4.getContentResolver().call(l.a, "stage1_user_config_setting", null, null);     // Catch: Exception -> L10
        if (r5 == null) goto L7;
        String r6 = r5.getString("data", "");     // Catch: Exception -> L10
        if (r6 == null) goto L7;
    L8:
        TextUtils.isEmpty(r6);     // Catch: Exception -> L10
        return r6;
    L7:
        r6 = "";
    L10:
        e = move-exception;
        e.getMessage();
        return "";
    }

    @JvmStatic
    public static final String i(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r1 = a;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (k(StringsKt.substringBefore(r1, '-', ""), StringsKt.substringAfter(r1, '-', "")) == false) goto L8;
    L17:
        l(a);
        return a;
    L8:
        if (a.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        l(a);
        a = "";
    L13:
        Intrinsics.checkNotNullParameter(r6, "context");
        String[] r7 = j(r6);
        if (k((String) ArraysKt.getOrNull(r7, 0), (String) ArraysKt.getOrNull(r7, 1)) == false) goto L16;
        r2 = r7[0] + '-' + r7[1];
    L16:
        a = r2;
        l(r2);
        l(a);
        goto L17
    L10:
        r3 = false;
        goto L11
    }

    @JvmStatic
    public static final String[] j(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Bundle r5 = r4.getContentResolver().call(l.a, "uuid", null, null);     // Catch: Exception -> L14
        if (r5 == null) goto L7;
        String r1 = r5.getString("uid", "");     // Catch: Exception -> L14
        if (r1 == null) goto L7;
    L8:
        if (r5 == null) goto L11;
        String r6 = r5.getString("did", "");     // Catch: Exception -> L14
        if (r6 == null) goto L11;
    L12:
        k(r1, r6);     // Catch: Exception -> L14
        l(r1);     // Catch: Exception -> L14
        q(r6);     // Catch: Exception -> L14
        return new String[]{r1, r6};
    L11:
        r6 = "";
    L7:
        r1 = "";
    L14:
        e = move-exception;
        e.getMessage();
        return new String[]{"", ""};
    }

    @JvmStatic
    public static final String l(String r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        boolean r2 = true;
        if (r5.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return "";
    L11:
        String r4 = StringsKt.substringBefore(r5, '-', r5);
        String r6 = StringsKt.substringAfter(r5, '-', "");
        if (r6.length() == 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L19;
        return "****" + StringsKt.takeLast(r4, 4);
    L19:
        return "****" + StringsKt.takeLast(r4, 4) + '-' + r6;
    L8:
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final int m(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Bundle r5 = r4.getContentResolver().call(l.a, "migrate-legacy-phone-enroll", null, null);     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        int r6 = r5.getInt("ret", IntCompanionObject.MIN_VALUE);     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(Integer.valueOf(r6));     // Catch: Throwable -> L9
    L11:
        Throwable r2 = Result.exceptionOrNull-impl(r7);
        if (r2 == null) goto L14;
        r2.getMessage();
    L14:
        Integer r0 = Integer.valueOf(IntCompanionObject.MIN_VALUE);
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = r0;
    L18:
        return ((Number) r7).intValue();
    L6:
        r6 = IntCompanionObject.MIN_VALUE;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static void q(String r1) {
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        StringsKt.takeLast(r1, 4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean k(String r3, String r4) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r3, "0") == true) goto L22;
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (StringsKt.isBlank(r4) == true) goto L17;
        r5 = false;
        goto L18
    L22:
        return false;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r2 = false;
        goto L9
    }

    @JvmStatic
    public static final void n(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, DBDefinition.PACKAGE_NAME);
        if (StringsKt.isBlank(r4) == false) goto L13;
        return;
    L13:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r1 = new Bundle();     // Catch: Throwable -> L7
        r1.putString("package_name", r4);     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(r3.getContentResolver().call(l.a, "on-app-installed", null, r1));     // Catch: Throwable -> L7
    L9:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        r6.getMessage();
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void o(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, DBDefinition.PACKAGE_NAME);
        if (StringsKt.isBlank(r4) == false) goto L13;
        return;
    L13:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r1 = new Bundle();     // Catch: Throwable -> L7
        r1.putString("package_name", r4);     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(r3.getContentResolver().call(l.a, "on-app-uninstalled", null, r1));     // Catch: Throwable -> L7
    L9:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        r6.getMessage();
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final boolean p(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "wakeupId");
        h r1 = h.a;
        Intrinsics.checkNotNullParameter(r5, "wakeupId");
        if (r3 > 0) goto L5;
        h.b("saveVoiceprintFailRecord ignored invalid failTime=" + r3);
        return false;
    L5:
        h.a().storeLong("voiceprint_fail_time", r3);
        h.a().storeString("voiceprint_fail_wakeup_id", r5);
        h.b("saveVoiceprintFailRecord success, failTime=" + r3 + ", wakeupIdLength=" + r5.length());
        return true;
    }
}
