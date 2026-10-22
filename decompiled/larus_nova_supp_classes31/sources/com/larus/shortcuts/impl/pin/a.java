package com.larus.shortcuts.impl.pin;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a = null;

    static {
        a = Build.MANUFACTURER.toLowerCase(Locale.US);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.huawei.hsm.permission.PermissionManager");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.huawei.hsm.permission.PermissionManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.huawei.hsm.permission.PermissionManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v1 */
    public static int d(Context r17) {
        Intrinsics.checkNotNullParameter(r17, "context");
        String[] r2 = f.a;
        ?? r3 = 0;
        r3 = 0;
        r3 = 0;
        r3 = 0;
        boolean r4 = !TextUtils.isEmpty(DeviceUtils.getSystemProperty("ro.miui.ui.version.name"));
    L6:
        if (r4 == false) goto L194;
    L9:
        Cursor r6 = null;
        String r14 = "";
        if (r4 == true) goto L198;
        String r1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r1) == true) goto L30;
        Intrinsics.checkNotNull(r1);
        if (StringsKt.contains$default(r1, "HUAWEI", false, 2, null) == false) goto L30;
        boolean r5 = true;
    L31:
        if (r5 == false) goto L46;
        if (TextUtils.isEmpty(r1) == true) goto L37;
        Intrinsics.checkNotNull(r1);
        if (StringsKt.contains$default(r1, "HUAWEI", false, 2, null) == false) goto L37;
        boolean r7 = true;
    L38:
        if (r7 == false) goto L44;
        String r8 = DeviceUtils.getSystemProperty("ro.build.version.emui");
        if (TextUtils.isEmpty(r8) == true) goto L44;
        r14 = r8 + "__" + Build.DISPLAY;
    L44:
        f.a r9 = new f.a("emui", r14);
    L81:
        String r10 = r9.a;
        switch(r10.hashCode()) {
            case -314765822: goto L183;
            case 3117372: goto L167;
            case 3351856: goto L149;
            case 97536331: goto L143;
            case 949547143: goto L117;
            case 1396500768: goto L85;
            default: goto L184;
        };
    L184:
        return 2;
    L85:
        if (r10.equals("funtouch") == false) goto L184;
        Cursor r11 = b(r17.getContentResolver(), Uri.parse("content://com.bbk.launcher2.settings/favorites"), null, null);     // Catch: Throwable -> L109 Exception -> L113
        if (r11 == null) goto L184;
    L200:
    L108:
        r6 = r11;
    L106:
        th = th;
        r6 = r11;
    L110:
        if (r6 == null) goto L112;
        r6.close();
    L112:
        throw th;
    L92:
        if (r11.moveToNext() == false) goto L105;
        String r12 = r11.getString(r11.getColumnIndex("intent"));     // Catch: Throwable -> L106 Exception -> L108
        if (TextUtils.isEmpty(r12) == true) goto L200;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L106 Exception -> L108
        if (StringsKt.contains$default(r12, r17.getApplicationContext().getPackageName(), false, 2, null) == false) goto L200;
        int r0 = r11.getInt(r11.getColumnIndex("shortcutPermission"));     // Catch: Throwable -> L106 Exception -> L108
    L99:
        if (r0 != 16) goto L101;
    L103:
        r3 = 1;
    L104:
        r11.close();
    L221:
        return r3 == true ? 1 : 0;
    L101:
        if (r0 == 18) goto L103;
    L105:
        r11.close();
        goto L184
    L109:
        th = th;
    L114:
        if (r6 == null) goto L184;
        r6.close();
        goto L184
    L117:
        if (r10.equals("coloros") == false) goto L184;
        Cursor r13 = b(r17.getContentResolver(), Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), null, null);     // Catch: Throwable -> L135 Exception -> L139
        if (r13 == null) goto L184;
    L202:
    L134:
        r6 = r13;
    L132:
        th = th;
        r6 = r13;
    L136:
        if (r6 == null) goto L138;
        r6.close();
    L138:
        throw th;
    L124:
        if (r13.moveToNext() == false) goto L131;
        String r15 = r13.getString(r13.getColumnIndex("value"));     // Catch: Throwable -> L132 Exception -> L134
        if (TextUtils.isEmpty(r15) == true) goto L202;
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L132 Exception -> L134
        if (StringsKt.contains$default(r15, r17.getApplicationContext().getPackageName(), false, 2, null) == false) goto L202;
        boolean r16 = StringsKt.contains$default(r15, r17.getApplicationContext().getPackageName() + ", 1", false, 2, null);     // Catch: Throwable -> L132 Exception -> L134
        r13.close();
        return r16 ? 1 : 0;
    L131:
        r13.close();
        goto L184
    L135:
        th = th;
    L140:
        if (r6 == null) goto L184;
        r6.close();
        goto L184
    L143:
        if (r10.equals("flyme") == false) goto L184;
        if (Build.VERSION.SDK_INT < 26) goto L184;
        return 1;
    L149:
        if (r10.equals("miui") == false) goto L184;
        String r18 = r9.a();
        if (TextUtils.isEmpty(r18) == true) goto L221;
        if (c("11.0.6", r18) < 0) goto L180;
        Object r19 = r17.getSystemService("appops");     // Catch: Exception -> L188
        if ((r19 instanceof AppOpsManager) == false) goto L180;
        AppOpsManager r20 = (AppOpsManager) r19;     // Catch: Exception -> L188
        Class<?> r21 = r20.getClass();     // Catch: Exception -> L188
        Class<?> r22 = Integer.TYPE;     // Catch: Exception -> L188
        Object r23 = r21.getMethod("checkOpNoThrow", new Class[]{r22, r22, String.class}).invoke(r20, new Object[]{10017, Integer.valueOf(r17.getApplicationInfo().uid), r17.getApplicationContext().getPackageName()});     // Catch: Exception -> L188
        if ((r23 instanceof Integer) == false) goto L180;
        int r24 = ((Number) r23).intValue();     // Catch: Exception -> L188
        if (r24 == 0) goto L165;
        if (r24 != 1) goto L180;
    L189:
    L165:
        r3 = 1;
        goto L189
    L167:
        if (r10.equals("emui") == false) goto L184;
        String r25 = r9.a();
        if (TextUtils.isEmpty(r25) == true) goto L221;
        if (c("10.1.0", r25) <= 0) goto L180;
        Object r26 = a().getMethod("canSendBroadcast", new Class[]{Context.class, Intent.class}).invoke(null, new Object[]{r17, new Intent("com.android.launcher.action.INSTALL_SHORTCUT")});     // Catch: Exception -> L188
        if ((r26 instanceof Boolean) == false) goto L180;
        r3 = ((Boolean) r26).booleanValue();     // Catch: Exception -> L188
        goto L189
    L183:
        if (r10.equals("primary") == false) goto L184;
        return 1;
    L180:
        r3 = 2;
    L37:
        r7 = false;
        goto L38
    L46:
        if (f.b() == false) goto L56;
        if (f.b() == false) goto L54;
        String r27 = DeviceUtils.getSystemProperty("ro.build.version.opporom");
        if (TextUtils.isEmpty(r27) == true) goto L54;
        r14 = "coloros__" + r27 + "__" + Build.DISPLAY;
    L54:
        r9 = new f.a("coloros", r14);
        goto L81
    L56:
        if (f.d() == false) goto L66;
        if (f.d() == false) goto L64;
        String r28 = DeviceUtils.getSystemProperty("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r28) == true) goto L64;
        r14 = "funtouch__" + r28 + "__" + DeviceUtils.getSystemProperty("ro.vivo.product.version");
    L64:
        r9 = new f.a("funtouch", r14);
        goto L81
    L66:
        if (f.c() == false) goto L77;
        if (f.c() == false) goto L75;
        String r29 = Build.DISPLAY;
        if (TextUtils.isEmpty(r29) == true) goto L75;
        Intrinsics.checkNotNull(r29);
        if (StringsKt.contains$default(r29.toLowerCase(Locale.US), "flyme", false, 2, null) == false) goto L75;
        r14 = r29;
    L75:
        r9 = new f.a("flyme", r14);
        goto L81
    L77:
        if (ArraysKt.contains(f.a, Build.BRAND.toLowerCase(Locale.US)) == false) goto L79;
        f.a r30 = new f.a("primary", Build.VERSION.RELEASE);
    L80:
        r9 = r30;
        goto L81
    L79:
        r30 = new f.a("other", Build.DISPLAY);
    L30:
        r5 = false;
        goto L31
    L198:
        boolean r110 = !TextUtils.isEmpty(DeviceUtils.getSystemProperty("ro.miui.ui.version.name"));
    L15:
        if (r110 == false) goto L192;
    L18:
        if (r110 == false) goto L24;
        String r31 = DeviceUtils.getSystemProperty("ro.miui.ui.version.name");
        if (TextUtils.isEmpty(r31) == true) goto L24;
        r14 = "miui" + r31 + "__" + Build.VERSION.INCREMENTAL;
    L24:
        r9 = new f.a("miui", r14);
        goto L81
    L192:
        f.a();     // Catch: ClassNotFoundException -> L187
        r110 = true;
    L14:
        r110 = false;
        goto L15
    L194:
        f.a();     // Catch: ClassNotFoundException -> L186
        r4 = true;
    L5:
        r4 = false;
        goto L6
    }

    public static Intent e(FragmentActivity r3) {
        Intent r0 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r0.setData(Uri.fromParts("package", r3.getPackageName(), null));
        return r0;
    }

    public static int c(String r5, String r6) {
        if (r6 == null) goto L14;
        int r2 = 0;
        String[] r7 = (String[]) new Regex("\\.").split(r5, 0).toArray(new String[0]);
        String[] r8 = (String[]) new Regex("\\.").split(r6, 0).toArray(new String[0]);
        int r0 = Math.min(r7.length, r8.length);
        int r1 = 0;
    L4:
        if (r2 >= r0) goto L9;
        int r3 = CastIntegerProtector.parseInt(r7[r2]);
        int r4 = CastIntegerProtector.parseInt(r8[r2]);
        Unit r9 = Unit.INSTANCE;
        if ((r3 - r4) != 0) goto L8;
        r2 = r2 + 1;
        r1 = r4;
        goto L4
    L8:
        r1 = r4;
    L9:
        if (r1 == 0) goto L12;
        return r1;
    L12:
        return r7.length - r8.length;
    L14:
        throw new RuntimeException("version name can not be null");
    }

    public static boolean f(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "title");
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.HOME");
        PackageManager r1 = r6.getPackageManager();
        ResolveInfo r2 = r1.resolveActivity(r0, 0);
        if (r2 == null) goto L17;
        ActivityInfo r3 = r2.activityInfo;
        List<ProviderInfo> r4 = r1.queryContentProviders(r3.packageName, r3.applicationInfo.uid, 8);
        if (r4 == null) goto L17;
        Iterator<ProviderInfo> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        ProviderInfo r8 = r5.next();
        if (TextUtils.isEmpty(r8.readPermission) == true) goto L10;
        if (Pattern.matches(".*launcher.*READ_SETTINGS", r8.readPermission) == false) goto L10;
        String r9 = r8.authority;
    L19:
        if (r9 != null) goto L21;
    L28:
        r9 = "com.android.launcher3.settings";
    L29:
        StringBuffer r10 = new StringBuffer("content://");
        r10.append(r9);
        r10.append("/favorites?notify=true");
        Cursor r11 = b(r6.getContentResolver(), UriProtector.parse(r10.toString()), "id=? ", new String[]{r7});     // Catch: Exception -> L46
        if (r11 == null) goto L45;
        Cursor r12 = r11;     // Catch: Exception -> L46
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L46
        throw th;     // Catch: Exception -> L46
    L34:
        if (r12.moveToNext() == false) goto L37;
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L46
        return true;
    L37:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L46
        goto L45
    L45:
        return false;
    L21:
        if (r9.length() <= 0) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == true) goto L27;
        r9 = null;
    L27:
        if (r9 != null) goto L29;
    L23:
        r14 = false;
    L17:
        r9 = "";
        goto L19
    }

    public static Cursor b(ContentResolver r12, Uri r13, String r14, String[] r15) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, r14, r15, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r16 = r12.query(r13, null, r14, r15, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r16, r10, true);
        return r16;
    }
}
