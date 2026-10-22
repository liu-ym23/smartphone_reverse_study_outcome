package q9;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Pair;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import com.bytedance.android.annie.container.fragment.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // q9.b
    public final boolean isPermissionAllGranted(Context r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "permission");
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r1 = com.bytedance.android.annie.bridge.method.permission.c.a;
        String[] r12 = (String[]) Arrays.copyOf(r11, r11.length);
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "permissions");
        Pair r13 = com.bytedance.android.annie.bridge.method.permission.c.e(r10, (String[]) Arrays.copyOf(r12, r12.length));
        if ((!((List) r13.second).isEmpty()) == true) goto L16;
        Iterator r14 = ((List) r13.first).iterator();
    L7:
        if (r14.hasNext() == false) goto L23;
        String r0 = (String) r14.next();
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L14:
        boolean r15 = true;
    L15:
        if (r15 == true) goto L7;
    L11:
        if (ContextCompat.checkSelfPermission(r10, r0) == 0) goto L14;
        r15 = false;
        goto L15
    L23:
        return true;
    L16:
        return false;
    }

    @Override // q9.b
    public final void n(Activity r11, q r12, c r13, String... r14) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r14, "permission");
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r0 = com.bytedance.android.annie.bridge.method.permission.c.a;
        String[] r15 = (String[]) Arrays.copyOf(r14, r14.length);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r15, "permissions");
        com.bytedance.android.annie.bridge.method.permission.c.b = new LinkedHashSet();
        com.bytedance.android.annie.bridge.method.permission.c.c = new ArrayList();
        com.bytedance.android.annie.bridge.method.permission.c.d = new ArrayList();
        com.bytedance.android.annie.bridge.method.permission.c.e = new ArrayList();
        com.bytedance.android.annie.bridge.method.permission.c.f = new ArrayList();
        Pair r1 = com.bytedance.android.annie.bridge.method.permission.c.e(r11, (String[]) Arrays.copyOf(r15, r15.length));
        LinkedHashSet<String> r10 = com.bytedance.android.annie.bridge.method.permission.c.b;
        ArrayList<String> r16 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
        r10 = null;
    L5:
        r10.addAll((Collection) r1.first);
        ArrayList<String> r17 = com.bytedance.android.annie.bridge.method.permission.c.e;
        if (r17 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDenied");
        r17 = null;
    L8:
        r17.addAll((Collection) r1.second);
        boolean r18 = false;
        if (Build.VERSION.SDK_INT >= 23) goto L17;
        ArrayList<String> r19 = com.bytedance.android.annie.bridge.method.permission.c.d;
        if (r19 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsGranted");
        r19 = null;
    L13:
        LinkedHashSet<String> r110 = com.bytedance.android.annie.bridge.method.permission.c.b;
        if (r110 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
        r110 = null;
    L16:
        r19.addAll(r110);
    L48:
        LinkedHashMap r111 = new LinkedHashMap();
        ArrayList<String> r112 = com.bytedance.android.annie.bridge.method.permission.c.d;
        if (r112 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsGranted");
        r112 = null;
    L51:
        Iterator<T> r113 = r112.iterator();
    L53:
        if (r113.hasNext() == false) goto L55;
        r111.put((String) r113.next(), PermissionStatus.PERMITTED);
        goto L53
    L55:
        ArrayList<String> r114 = com.bytedance.android.annie.bridge.method.permission.c.c;
        if (r114 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r114 = null;
    L58:
        Iterator<T> r115 = r114.iterator();
    L60:
        if (r115.hasNext() == false) goto L62;
        r111.put((String) r115.next(), PermissionStatus.UNDETERMINED);
        goto L60
    L62:
        ArrayList<String> r116 = com.bytedance.android.annie.bridge.method.permission.c.e;
        if (r116 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDenied");
        r116 = null;
    L65:
        Iterator<T> r117 = r116.iterator();
    L67:
        if (r117.hasNext() == false) goto L77;
        String r118 = (String) r117.next();
        r111.put(r118, PermissionStatus.DENIED);
        ArrayList<String> r20 = com.bytedance.android.annie.bridge.method.permission.c.c;
        if (r20 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r20 = null;
    L72:
        if (r20.contains(r118) == false) goto L67;
        ArrayList<String> r21 = com.bytedance.android.annie.bridge.method.permission.c.c;
        if (r21 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r21 = null;
    L76:
        r21.remove(r118);
        goto L67
    L77:
        ArrayList<String> r119 = com.bytedance.android.annie.bridge.method.permission.c.f;
        if (r119 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDeniedForever");
        r119 = null;
    L80:
        Iterator<T> r120 = r119.iterator();
    L82:
        if (r120.hasNext() == false) goto L84;
        r111.put((String) r120.next(), PermissionStatus.DENIED);
        goto L82
    L84:
        if (r13 == null) goto L113;
        ArrayList<String> r121 = com.bytedance.android.annie.bridge.method.permission.c.e;
        if (r121 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsDenied");
        r121 = null;
    L89:
        if (r121.isEmpty() == false) goto L97;
        ArrayList<String> r122 = com.bytedance.android.annie.bridge.method.permission.c.c;
        if (r122 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
    L95:
        if (r16.isEmpty() == false) goto L97;
        r18 = true;
        goto L97
    L93:
        r16 = r122;
    L97:
        r13.onResult(r18, r111);
        return;
    L113:
        return;
    L17:
        LinkedHashSet<String> r22 = com.bytedance.android.annie.bridge.method.permission.c.b;
        if (r22 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
        r22 = null;
    L20:
        Iterator<String> r23 = r22.iterator();
    L22:
        if (r23.hasNext() == false) goto L39;
        String r24 = r23.next();
        if (Build.VERSION.SDK_INT >= 23) goto L26;
    L29:
        boolean r25 = true;
    L30:
        if (r25 == true) goto L31;
        ArrayList<String> r26 = com.bytedance.android.annie.bridge.method.permission.c.c;
        if (r26 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r26 = null;
    L38:
        r26.add(r24);
        goto L22
    L31:
        ArrayList<String> r27 = com.bytedance.android.annie.bridge.method.permission.c.d;
        if (r27 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsGranted");
        r27 = null;
    L34:
        r27.add(r24);
        goto L22
    L26:
        if (ContextCompat.checkSelfPermission(r11, r24) == 0) goto L29;
        r25 = false;
        goto L30
    L39:
        ArrayList<String> r28 = com.bytedance.android.annie.bridge.method.permission.c.c;
        if (r28 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mPermissionsRequest");
        r28 = null;
    L43:
        if ((!r28.isEmpty()) == false) goto L48;
        if (r12 == null) goto L47;
        r12.requestPermissionsProxy(r15, 200);
        goto L48
    L47:
        ActivityCompat.requestPermissions(r11, r15, 200);
        goto L48
    }
}
