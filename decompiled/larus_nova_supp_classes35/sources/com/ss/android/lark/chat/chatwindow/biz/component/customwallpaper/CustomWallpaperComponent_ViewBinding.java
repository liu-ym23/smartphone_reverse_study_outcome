package com.ss.android.lark.chat.chatwindow.biz.component.customwallpaper;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CustomWallpaperComponent_ViewBinding implements Unbinder {
    public CustomWallpaperComponent a;

    public final void unbind() {
        CustomWallpaperComponent r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mIVCustomWallpaper = null;
        r0.mIVMaskCustomWallpaper = null;
        r0.mWallpaperWrapper = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CustomWallpaperComponent_ViewBinding(CustomWallpaperComponent r4, View r5) {
        this.a = r4;
        r4.mIVCustomWallpaper = (AppCompatImageView) Utils.findRequiredViewAsType(r5, 2131365614, "field 'mIVCustomWallpaper'", AppCompatImageView.class);
        r4.mIVMaskCustomWallpaper = (AppCompatImageView) Utils.findRequiredViewAsType(r5, 2131379663, "field 'mIVMaskCustomWallpaper'", AppCompatImageView.class);
        r4.mWallpaperWrapper = (DetectSizeChangeFrameLayout) Utils.findRequiredViewAsType(r5, 2131365615, "field 'mWallpaperWrapper'", DetectSizeChangeFrameLayout.class);
    }
}
