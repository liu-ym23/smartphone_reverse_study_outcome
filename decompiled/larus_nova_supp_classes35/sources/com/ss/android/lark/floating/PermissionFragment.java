package com.ss.android.lark.floating;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.floatbubble.util.RomUtils;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wfb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0006\u0010\u001a\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/floating/PermissionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callbackRegistered", BuildConfig.FLAVOR, "getCallbackRegistered", "()Z", "setCallbackRegistered", "(Z)V", "hasLifecyclePaused", "getHasLifecyclePaused", "setHasLifecyclePaused", "onActivityCreated", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", BuildConfig.FLAVOR, "resultCode", Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "onResume", "onPause", "onDetach", "registerCallbackOnResume", "Companion", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionFragment extends Fragment {
    public static g f;
    public boolean d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final void onDetach() {
        super.onDetach();
        f = null;
    }

    public final void onPause() {
        super.onPause();
        this.e = true;
    }

    public final void onResume() {
        super.onResume();
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L9;
        getLifecycle().addObserver(new com.ss.android.lark.floating.a(this));
        this.d = true;
        return;
    }

    public PermissionFragment() {
    }

    public final void onActivityCreated(Bundle r9) {
        super.onActivityCreated(r9);
        int r10 = b.a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        Application r0 = requireActivity().getApplication();
        Log.i("VideoChat_FloatBubblePermission", "goToSettingPage");
        int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L27
        if (r1 < 23) goto L6;
        String r5 = RomUtils.a("ro.build.display.id");     // Catch: Exception -> L27
        if (r5 != null) goto L11;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L20;
        if (r1 != 23) goto L20;
        yta.a.a(r0);     // Catch: Exception -> L27
    L29:
        Log.i("PermissionFragment：requestPermission");
        return;
    L20:
        if ((!TextUtils.isEmpty(RomUtils.a("ro.vivo.os.version"))) == false) goto L22;
        zta.a.d(r0);     // Catch: Exception -> L27
    L22:
        Intent r2 = new Intent();     // Catch: Exception -> L27
        r2.setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");     // Catch: Exception -> L27
        r2.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L27
        r2.setData(UriProtector.parse("package:" + r0.getPackageName()));     // Catch: Exception -> L27
        r2.setFlags(268435456);     // Catch: Exception -> L27
        if (r2.resolveActivity(r0.getPackageManager()) == null) goto L25;
        r0.startActivity(r2);     // Catch: Exception -> L27
        goto L29
    L25:
        Log.e("VideoChat_FloatBubblePermission", "permission setting page not found");     // Catch: Exception -> L27
        goto L29
    L11:
        if (r5.contains("flyme") == false) goto L13;
    L14:
        r6 = true;
        goto L16
    L13:
        if (r5.toLowerCase().contains("flyme") == false) goto L15;
    L6:
        if ((!TextUtils.isEmpty(RomUtils.a("ro.miui.ui.version.name"))) == false) goto L22;
        aua.a.b(r0);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        if (r1 == 199) goto L5;
        return;
    L5:
        if (this.d == true) goto L9;
        getLifecycle().addObserver(new com.ss.android.lark.floating.a(this));
        this.d = true;
        return;
    }
}
