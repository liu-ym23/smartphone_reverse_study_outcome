package com.ss.android.lark.floating;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.floatbubble.util.RomUtils;
import com.ss.android.lark.log.Log;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import wfb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        long r0 = System.currentTimeMillis();
        if (r8 != null) goto L25;
    L22:
        boolean r9 = false;
    L23:
        Log.i("VideoChat_FloatBubblePermission", String.format("isGranted : %b, spendTime = %d", new Object[]{Boolean.valueOf(r9), Long.valueOf(System.currentTimeMillis() - r0)}));
        return r9;
    L25:
    L20:
        e = move-exception;
        Log.e("VideoChat_FloatBubblePermission", "Exception : " + e.getMessage());
        goto L22
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        if ((!TextUtils.isEmpty(RomUtils.a("ro.miui.ui.version.name"))) == false) goto L17;
        r9 = aua.a.a(r8);     // Catch: Exception -> L20
    L17:
        r9 = true;
        goto L23
    L11:
        if ((!TextUtils.isEmpty(RomUtils.a("ro.vivo.os.version"))) == true) goto L26;
        r9 = Settings.canDrawOverlays(r8);     // Catch: Exception -> L20
        goto L23
    L26:
        if (zta.a.b(r8) != 0) goto L22;
    L15:
        e = move-exception;
        Log.e("VivoFloatPermission", Arrays.toString(e.getStackTrace()));     // Catch: Exception -> L20
        goto L17
    }

    @JvmStatic
    public static final void b(FragmentActivity r3, g r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "onPermissionResult");
        g r2 = PermissionFragment.f;
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "onPermissionResult");
        PermissionFragment.f = r4;
        FragmentTransaction r5 = r3.getSupportFragmentManager().beginTransaction();
        PermissionFragment r0 = new PermissionFragment();
        String r6 = r3.getLocalClassName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r6, 0) == true) goto L6;
        r5 = r5.add(r0, r6);
    L6:
        r5.commitAllowingStateLoss();
    }
}
