package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class CustomUiImage extends UIImage<FrescoImageView> {
    /* JADX INFO: renamed from: createView, reason: collision with other method in class */
    public final FrescoImageView m516createView(Context r2) {
        FrescoImageView r3 = super.createView(r2);
        r3.setFadeDuration(300);
        return r3;
    }

    @LynxProp(name = "fade-duration")
    public void setFadeDuration(int r2) {
        if (getView() == null) goto L6;
        getView().setFadeDuration(r2);
        return;
    }

    public final /* bridge */ /* synthetic */ View createView(Context r1) {
        return m516createView(r1);
    }
}
