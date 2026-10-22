package com.bytedance.android.annie.bridge.method.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.log.LogLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Map<String, b> a = null;
    public static LinkedHashSet<String> b;
    public static ArrayList<String> c;
    public static ArrayList<String> d;
    public static ArrayList<String> e;
    public static ArrayList<String> f;

    public static class a implements b {
        public a() {
        }
    }

    public interface b {
        Intent a(Context r1);

        Intent b(Context r1);

        Intent c(Context r1);
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.permission.c$c, reason: collision with other inner class name */
    public static final class C0064c extends a {
        public C0064c() {
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.c.b
        public final Intent a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intent r0 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            r0.addCategory("android.intent.category.DEFAULT");
            r0.putExtra("packageName", r10.getPackageName());
            return r0;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.c.b
        public final Intent b(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            ComponentName r0 = new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
            Intent r1 = new Intent();
            r1.setComponent(r0);
            r1.setData(Uri.fromParts("package", r10.getPackageName(), null));
            r1.setFlags(268435456);
            return r1;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.c.b
        public final Intent c(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intent r11 = new Intent("com.meizu.connectivitysettings.CONNECTIVITY_SETTINGS");
            r11.addFlags(268435456);
            r11.putExtra(":settings:show_fragment", "com.meizu.settings.location.MzLocationSettings");
            return r11;
        }
    }

    static {
        a = MapsKt.mapOf(TuplesKt.to("meizu", new C0064c()));
    }

    public static List c() {
        int r0 = Build.VERSION.SDK_INT;
        boolean r10 = true;
        if (r0 < 33) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return CollectionsKt.listOf(new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"});
    L9:
        if (r0 >= 29) goto L13;
        r10 = false;
    L13:
        if (r10 == false) goto L16;
        return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    L16:
        return CollectionsKt.listOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
    L5:
        r1 = false;
        goto L6
    }

    public static List d() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return CollectionsKt.listOf(new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"});
    L9:
        return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    L5:
        r0 = false;
        goto L6
    }

    public static List f() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
    L5:
        r0 = false;
        goto L6
    }

    public static Intent b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        String r1 = Build.MANUFACTURER;
        b r11 = a.get(r1.toLowerCase());
        if (r11 == null) goto L6;
        Intent r12 = r11.b(r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        Intrinsics.checkNotNullParameter(r10, "context");
        Intent r13 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r13.addFlags(268435456);
        r13.setData(Uri.fromParts("package", r10.getPackageName(), null));
        return r13;
    }

    public static boolean g(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return NotificationManagerCompat.from(r1).areNotificationsEnabled();
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean h(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "grantResults");
        int r0 = r10.length;
        int r11 = 0;
    L3:
        if (r11 >= r0) goto L8;
        if (r10[r11] < 0) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static boolean i(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT < 28) goto L17;
        Object r11 = r10.getSystemService(com.bytedance.android.ec.core.event.a.KEY_LOCATION);
        if ((r11 instanceof LocationManager) == false) goto L7;
        LocationManager r12 = (LocationManager) r11;
    L8:
        if (r12 != null) goto L20;
        return false;
    L20:
        return r12.isLocationEnabled();
    L7:
        r12 = null;
        goto L8
    L17:
        if (Settings.Secure.getInt(r10.getContentResolver(), "location_mode") == 0) goto L21;
        return true;
    L21:
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean a(Context r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, "permName");
        if (r1 != null) goto L6;
        return false;
    L6:
        if (ContextCompat.checkSelfPermission(r1, r10) == (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public static Pair e(Context r19, String... r20) {
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        String[] r0 = r19.getPackageManager().getPackageInfo(r19.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r0 != null) goto L6;
        List r1 = CollectionsKt.emptyList();     // Catch: PackageManager.NameNotFoundException -> L8
    L76:
    L10:
        int r12 = r20.length;
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r14 >= r12) goto L75;
        String r15 = r20[r14];
        String[] r16 = PermissionConstants.a;
        if (r15 != null) goto L15;
        String[] r17 = new String[r13];
    L63:
        int r18 = r17.length;
        int r110 = 0;
    L64:
        if (r110 >= r18) goto L73;
        String r111 = r17[r110];
        if (r1.contains(r111) == false) goto L68;
        r10.add(r111);
    L70:
        if (a(r19, r15) == true) goto L72;
        r11.add(r15);
    L72:
        r110 = r110 + 1;
        goto L64
    L68:
        b8.a r112 = b8.a.a;
        b8.a.a(new b8.b("PermissionUtils", LogLevel.ERROR, null, "U should add the permission of " + r15 + " in manifest.", 4), true);
        r11.add(r15);
        goto L70
    L73:
        r14 = r14 + 1;
        r13 = 0;
        goto L11
    L15:
        byte r113 = -1;
        switch(r15.hashCode()) {
            case -1596608551: goto L47;
            case -1166291365: goto L43;
            case 82233: goto L39;
            case 76105038: goto L35;
            case 215175251: goto L31;
            case 604302142: goto L27;
            case 1856013610: goto L23;
            case 1980544805: goto L19;
            default: goto L50;
        };
    L50:
        switch(r113) {
            case 0: goto L62;
            case 1: goto L61;
            case 2: goto L60;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L52;
            default: goto L51;
        };
    L51:
        r17 = new String[1];
        r17[r13] = r15;
        goto L63
    L52:
        r17 = PermissionConstants.b;
        goto L63
    L53:
        r17 = PermissionConstants.d;
        goto L63
    L54:
        r17 = PermissionConstants.a;
        goto L63
    L55:
        r17 = PermissionConstants.c;
        goto L63
    L60:
        r17 = PermissionConstants.h;
        goto L63
    L61:
        r17 = PermissionConstants.i;
        goto L63
    L62:
        r17 = PermissionConstants.g;
        goto L63
    L57:
        if (Build.VERSION.SDK_INT >= 26) goto L59;
        r17 = PermissionConstants.f;
        goto L63
    L59:
        r17 = PermissionConstants.e;
        goto L63
    L19:
        if (r15.equals("CAMERA") == false) goto L50;
        r113 = 7;
        goto L50
    L23:
        if (r15.equals("MICROPHONE") == false) goto L50;
        r113 = 6;
        goto L50
    L27:
        if (r15.equals("CALENDAR") == false) goto L50;
        r113 = 5;
        goto L50
    L31:
        if (r15.equals("CONTACTS") == false) goto L50;
        r113 = 4;
        goto L50
    L35:
        if (r15.equals("PHONE") == false) goto L50;
        r113 = 3;
        goto L50
    L39:
        if (r15.equals("SMS") == false) goto L50;
        r113 = 2;
        goto L50
    L43:
        if (r15.equals("STORAGE") == false) goto L50;
        r113 = 1;
        goto L50
    L47:
        if (r15.equals("SENSORS") == false) goto L50;
        r113 = 0;
        goto L50
    L75:
        return Pair.create(r10, r11);
    L6:
        r1 = CollectionsKt.listOf(Arrays.copyOf(r0, r0.length));     // Catch: PackageManager.NameNotFoundException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        r1 = CollectionsKt.emptyList();
        goto L10
    }
}
