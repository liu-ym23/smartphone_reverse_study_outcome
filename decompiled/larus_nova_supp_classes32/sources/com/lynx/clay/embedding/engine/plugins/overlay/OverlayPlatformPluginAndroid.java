package com.lynx.clay.embedding.engine.plugins.overlay;

import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;
import com.obric.aivoice.core.data.NameKeys;
import m5a.h;
import m5a.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class OverlayPlatformPluginAndroid {
    public int a;
    public String b;
    public q c;
    public final ClayPluginContext d;
    public final long e;

    public static native void nativeOnDialogBackPressed(long r0);

    public static native void nativeUpdateRootPosOffset(long r0, int r2, int r3);

    private void changeVisibility(boolean r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setVisible(r2);
        return;
    }

    public void setAndroidFullScreen(boolean r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setFullScreen(r2);
        return;
    }

    public void setAndroidNativeEventPass(boolean r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setNativeEventPass(r2);
        return;
    }

    public void setAndroidSoftInputMode(String r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setAndroidSetSoftInputMode(r2);
        return;
    }

    public void setCutOutMode(boolean r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setCutOutMode(r2);
        return;
    }

    public void setLevel(int r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setLevel(r2);
        return;
    }

    public void setStatusBarTranslucent(boolean r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setStatusBarTranslucent(r2);
        return;
    }

    public void setStatusBarTranslucentStyle(String r2) {
        q r0 = this.c;
        if (r0 == null) goto L6;
        r0.setStatusBarTranslucentStyle(r2);
        return;
    }

    public OverlayPlatformPluginAndroid(ClayPluginContext r3, long r4) {
        this.a = 0;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
        this.c = null;
        this.e = 0;
        this.d = r3;
        this.e = r4;
    }

    private static OverlayPlatformPluginAndroid createPlugin(ClayPluginContext r1, long r2) {
        return new OverlayPlatformPluginAndroid(r1, r2);
    }

    public void onCreateNode(int r7, String r8, ExternalViewPlugin r9) {
        this.a = r7;
        this.b = r8;
        q r10 = new q(this.d.a.getContext(), this.a, this.b, this.d.a, r9);
        this.c = r10;
        h.e.b.put(Integer.valueOf(r7), r10);
        this.c.setOverlayPlatformPluginAndroid(this);
    }
}
