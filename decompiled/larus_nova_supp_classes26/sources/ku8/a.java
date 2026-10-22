package ku8;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bootprotector.entity.BaseExceptionInfo;
import com.larus.bootprotector.entity.LastException;
import com.larus.common.apphost.AppHost;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    static {
    }

    public static boolean d(LastException r7) {
        Intrinsics.checkNotNullParameter(r7, "lastException");
        AppHost.Companion r0 = AppHost.a;
        String r1 = r0.getVersionName();
        int r2 = r0.getUpdateVersionCode();
        int r3 = Build.VERSION.SDK_INT;
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L8:
        if (r2 <= 0) goto L14;
        if (r2 == r7.getUpdateVersion()) goto L14;
        nu8.a.b("CrashMatchUtils", "matchExceptionWithDeviceInfo: updateVersion NOT match");
        return false;
    L14:
        if (r7.getOsVersion() == r3) goto L17;
        nu8.a.b("CrashMatchUtils", "matchExceptionWithDeviceInfo: osVersion NOT match");
        return false;
    L17:
        return true;
    L5:
        if (StringsKt.equals(r1, r7.getAppVersion(), true) == true) goto L8;
        nu8.a.b("CrashMatchUtils", "matchExceptionWithDeviceInfo: appVersion NOT match");
        return false;
    }

    public static List h(String r8) {
        ArrayList r0 = new ArrayList();
        if (r8 != null) goto L5;
        return r0;
    L5:
        Iterator r9 = StringsKt.split$default(r8, new String[]{"\n"}, false, 0, 6, null).iterator();
    L7:
        if (r9.hasNext() == false) goto L16;
        String r1 = StringsKt.trim((String) r9.next()).toString();
        String r5 = null;
        boolean r2 = StringsKt.startsWith$default(r1, "at ", false, 2, null);
        String r3 = r1;
        if (r2 == false) goto L11;
        r3 = r1.subSequence(3, r1.length());
    L11:
        String r4 = StringsKt.trim(new Regex("\\([a-z.A-Z]+:[0-9]+\\)").replace(r3, "")).toString();
        if ((!TextUtils.isEmpty(r4)) == false) goto L14;
        r5 = r4;
    L14:
        if (r5 == null) goto L7;
        r0.add(r5);
        goto L7
    L16:
        return r0;
    }

    public static boolean a(CrashPortrait r5, LastException r6) {
        if (TextUtils.isEmpty(r5.getAppVersion()) == false) goto L5;
    L8:
        Integer r0 = r5.getUpdateVersion();
        if (r0 != null) goto L11;
    L19:
        Integer r1 = r5.getOsVersion();
        if (r1 == null) goto L31;
        if (r1.intValue() <= 0) goto L31;
        int r2 = r6.getOsVersion();
        Integer r4 = r5.getOsVersion();
        if (r4 != null) goto L27;
    L28:
        nu8.a.b("CrashMatchUtils", "matchBaseInfo: osVersion NOT match");
        return false;
    L27:
        if (r2 != r4.intValue()) goto L28;
    L31:
        if (TextUtils.isEmpty(r5.getThreadName()) == false) goto L33;
    L36:
        return true;
    L33:
        if (StringsKt.equals(r5.getThreadName(), r6.getThreadName(), true) == true) goto L36;
        nu8.a.b("CrashMatchUtils", "matchBaseInfo: threadName NOT match");
        return false;
    L11:
        if (r0.intValue() <= 0) goto L19;
        Integer r3 = r5.getUpdateVersion();
        int r7 = r6.getUpdateVersion();
        if (r3 != null) goto L16;
    L17:
        nu8.a.b("CrashMatchUtils", "matchBaseInfo: updateVersion NOT match");
        return false;
    L16:
        if (r3.intValue() == r7) goto L19;
    L5:
        if (StringsKt.equals(r5.getAppVersion(), r6.getAppVersion(), true) == true) goto L8;
        nu8.a.b("CrashMatchUtils", "matchBaseInfo: appVersion NOT match");
        return false;
    }

    public static boolean b(String r6, String r7) {
        if (r6 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return true;
    L11:
        if (r7 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L20;
        return false;
    L20:
        if (StringsKt.equals(r6, r7, true) == false) goto L23;
        return true;
    L23:
        if (StringsKt.contains$default(r7, r6, false, 2, null) == false) goto L33;
        return true;
    L33:
    L30:
        th = move-exception;
        nu8.a.b("CrashMatchUtils", "matchCrashMessage failed: " + th.getMessage());
        return false;
    L26:
        if (new Regex(r6).matches(r7) == false) goto L29;
        nu8.a.e("CrashMatchUtils", "matchCrashMessage: Regex matched! " + r6);     // Catch: Throwable -> L30
        return true;
    L29:
        return false;
    L13:
        if (r7.length() == 0) goto L16;
        r5 = false;
        goto L17
    L5:
        if (r6.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public static boolean c(LastException r5, CrashPortrait r6) {
        Intrinsics.checkNotNullParameter(r5, "lastException");
        Intrinsics.checkNotNullParameter(r6, "crashPortrait");
        if (r6.getCrashType() != null) goto L7;
        nu8.a.b("CrashMatchUtils", "matchExceptionInfo: crashPortrait.crashType == null");
        return false;
    L7:
        if (StringsKt.equals(r5.getCrashType().toString(), r6.getCrashType(), true) == true) goto L38;
        nu8.a.b("CrashMatchUtils", "matchExceptionInfo: crashType NOT match, lastException.crashType = " + r5.getCrashType() + "，crashPortrait.crashType = " + r6.getCrashType());
        return false;
    L38:
    L35:
        e = move-exception;
        nu8.a.c("CrashMatchUtils", "matchExceptionInfo Error: ", e);
        return false;
    L11:
        if (r5.getCrashType() != BaseExceptionInfo.Type.JAVA) goto L16;
        if (e(r5, r6) == false) goto L34;
        return true;
    L34:
        return false;
    L16:
        if (r5.getCrashType() != BaseExceptionInfo.Type.NATIVE) goto L21;
        if (f(r5, r6) == false) goto L34;
        return true;
    L21:
        if (r5.getCrashType() != BaseExceptionInfo.Type.ANR) goto L34;
        if (a(r6, r5) == true) goto L25;
        nu8.a.b("CrashMatchUtils", "matchAnrException: matchBaseInfo NOT match");     // Catch: Exception -> L35
    L31:
        boolean r7 = false;
    L32:
        if (r7 == false) goto L34;
        return true;
    L25:
        List r8 = h(r5.getExceptionStackTrace());     // Catch: Exception -> L35
        if (((ArrayList) r8).isEmpty() == false) goto L29;
        nu8.a.b("CrashMatchUtils", "matchAnrException: stackList is empty");     // Catch: Exception -> L35
        goto L31
    L29:
        if (g(r6, r8, "", "") == false) goto L31;
        r7 = true;
        goto L32
    }

    public static boolean e(LastException r9, CrashPortrait r10) {
        if (a(r10, r9) == true) goto L6;
        nu8.a.b("CrashMatchUtils", "matchJavaException: matchBaseInfo NOT match");
        return false;
    L6:
        List r11 = h(r9.getExceptionStackTrace());
        if (((ArrayList) r11).isEmpty() == false) goto L10;
        nu8.a.b("CrashMatchUtils", "matchJavaException: stackList is empty");
        return false;
    L10:
        List r0 = StringsKt.split$default((CharSequence) ListProtector.get(r11, 0), new String[]{": "}, false, 2, 2, null);
        if (r0.size() != 2) goto L13;
        String r1 = (String) ListProtector.get(r0, 0);
        String r2 = (String) ListProtector.get(r0, 1);
    L15:
        if (g(r10, r11, r2, r1) == false) goto L17;
        return true;
    L17:
        return false;
    L13:
        r1 = (String) ListProtector.get(r0, 0);
        r2 = "";
        goto L15
    }

    public static boolean f(LastException r9, CrashPortrait r10) {
        if (a(r10, r9) == true) goto L6;
        nu8.a.b("CrashMatchUtils", "matchNativeException: matchBaseInfo NOT match");
        return false;
    L6:
        String r3 = r9.getExceptionStackTrace();
        ArrayList r11 = new ArrayList();
        if (r3 == null) goto L14;
        Iterator r0 = StringsKt.split$default(r3, new String[]{"\n"}, false, 0, 6, null).iterator();
    L11:
        if (r0.hasNext() == false) goto L14;
        r11.add(StringsKt.trim((String) r0.next()).toString());
    L14:
        if (r11.isEmpty() == false) goto L24;
        nu8.a.b("CrashMatchUtils", "matchNativeException: stackList is empty");
        if (TextUtils.isEmpty(r10.getAbortMessage()) == true) goto L18;
    L23:
        return false;
    L18:
        if (TextUtils.isEmpty(r10.getStackItem()) == false) goto L23;
        if (TextUtils.isEmpty(r10.getSignalAndCodeString()) == false) goto L23;
        nu8.a.b("CrashMatchUtils", "matchNativeException: nativeCrashProfile empty, matched!");
        return true;
    L24:
        String r1 = (String) ListProtector.get(r11, 0);
        if (r11.size() > 2) goto L27;
    L29:
        String r4 = "";
    L31:
        if (TextUtils.isEmpty(r10.getSignalAndCodeString()) == true) goto L36;
        if (StringsKt.equals(r10.getSignalAndCodeString(), r1, true) == true) goto L36;
        nu8.a.b("CrashMatchUtils", "matchNativeStackTrace: signalAndCodeString NOT match");
    L48:
        boolean r12 = false;
    L49:
        if (r12 == false) goto L51;
        return true;
    L51:
        return false;
    L36:
        if (TextUtils.isEmpty(r10.getAbortMessage()) == false) goto L38;
    L40:
        String r13 = r10.getStackItem();
        if (r13 == null) goto L48;
        Iterator r14 = r11.iterator();
    L44:
        if (r14.hasNext() == false) goto L48;
        String r2 = (String) r14.next();
        nu8.a.h("CrashMatchUtils", "matchNativeStackTrace stack: " + r2);
        if (b(r13, r2) == false) goto L44;
        nu8.a.b("CrashMatchUtils", "matchNativeStackTrace MATCHED! profileItem = " + r13 + ", item = " + r2);
        r12 = true;
        goto L49
    L38:
        if (StringsKt.equals(r10.getAbortMessage(), r4, true) == true) goto L40;
        nu8.a.b("CrashMatchUtils", "matchNativeStackTrace: abortMessage NOT match");
        goto L48
    L27:
        if (StringsKt.contains$default((CharSequence) ListProtector.get(r11, 1), "abort message:", false, 2, null) == false) goto L29;
        r4 = (String) ListProtector.get(r11, 1);
        goto L31
    }

    public static boolean g(CrashPortrait r17, List r18, String r19, String r20) {
        if (b(r17.getDetailMessage(), r19) == true) goto L7;
        nu8.a.b("CrashMatchUtils", "matchThrowable: exceptionMsg NOT match");
        return false;
    L7:
        if (TextUtils.isEmpty(r17.getThrowableClassName()) == true) goto L13;
        if (StringsKt.equals(r17.getThrowableClassName(), r20, true) == true) goto L13;
        nu8.a.b("CrashMatchUtils", "matchThrowable: throwableClassName NOT match");
        return false;
    L13:
        if (TextUtils.isEmpty(r17.getClazzName()) == true) goto L15;
    L18:
        Iterator r0 = r18.iterator();
    L20:
        if (r0.hasNext() == false) goto L43;
        List r4 = StringsKt.split$default((String) r0.next(), new char[]{'.'}, false, 0, 6, null);
        if (r4.size() >= 2) goto L24;
    L29:
        boolean r5 = false;
    L30:
        Pair r7 = null;
        if (r5 == true) goto L34;
        r4 = null;
    L34:
        if (r4 == null) goto L36;
        r7 = TuplesKt.to(CollectionsKt.joinToString$default(r4.subList(0, CollectionsKt.getLastIndex(r4)), ".", null, null, 0, null, null, 62, null), StringsKt.substringBefore$default((String) CollectionsKt.last(r4), '(', null, 2, null));
    L36:
        if (r7 == null) goto L20;
        if (b(r17.getClazzName(), (String) r7.getFirst()) == false) goto L20;
        if (b(r17.getMethodName(), (String) r7.getSecond()) == false) goto L20;
        nu8.a.b("CrashMatchUtils", "matchThrowable: MATCHED!\njavaCrashProfile.clazzName = " + r17.getClazzName() + "\njavaCrashProfile.methodName = " + r17.getMethodName() + '\n');
        return true;
    L24:
        if (((CharSequence) CollectionsKt.last(r4)).length() <= 0) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
        r5 = true;
        goto L30
    L26:
        r6 = false;
        goto L27
    L43:
        nu8.a.b("CrashMatchUtils", "matchThrowable: NOT match");
        return false;
    L15:
        if (TextUtils.isEmpty(r17.getMethodName()) == false) goto L18;
        nu8.a.b("CrashMatchUtils", "matchThrowable: methodName and clazzName is empty. MATCHED!");
        return true;
    }
}
