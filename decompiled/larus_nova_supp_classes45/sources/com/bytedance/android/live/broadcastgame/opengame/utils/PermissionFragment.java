package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.app.Fragment;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/utils/PermissionFragment;", "Landroid/app/Fragment;", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PermissionFragment extends Fragment {
    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        String[] r3 = getArguments().getStringArray("permissions");
        if (r3 == null) goto L6;
        requestPermissions(r3, 1);
        return;
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r21, String[] r22, int[] r23) {
        Intrinsics.checkNotNullParameter(r22, "permissions");
        Intrinsics.checkNotNullParameter(r23, "grantResults");
        ArrayList r2 = new ArrayList();
        Object[] r3 = {Integer.valueOf(r21), r22, r23};
        f06.b r13 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(102612);
        if (r4 == null) goto L5;
        f06.a[] r5 = r4.i;
    L6:
        f06.a[] r11 = r5;
        int r12 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r12) goto L15;
        f06.a r8 = r11[r9];
        int r17 = r9;
        int r18 = r12;
        f06.a[] r19 = r11;
        f06.d r6 = r8.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r3, "void", r13);     // Catch: Exception -> L22
        if (r6.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L22
    L17:
        if (r6.a == true) goto L20;
        super.onRequestPermissionsResult(r21, r22, r23);
    L20:
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        return;
    L14:
        r9 = r17 + 1;
        r12 = r18;
        r11 = r19;
        goto L8
    L15:
        r6 = new f06.d(false, null);
        goto L17
    L5:
        r5 = ApiHookConfig.d;
        goto L6
    }
}
