package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context r5, GenericDraweeHierarchy r10) {
        super(r5);
        setHierarchy(r10);
    }

    public void inflateHierarchy(Context r5, AttributeSet r10) {
        FrescoSystrace.a().getClass();
        GenericDraweeHierarchyBuilder r11 = GenericDraweeHierarchyInflater.a(r5, r10);
        setAspectRatio(r11.f7917c);
        setHierarchy(r11.a());
        FrescoSystrace.a().getClass();
    }

    public GenericDraweeView(Context r5) {
        super(r5);
        inflateHierarchy(r5, null);
    }

    public GenericDraweeView(Context r5, AttributeSet r10) {
        super(r5, r10);
        inflateHierarchy(r5, r10);
    }

    public GenericDraweeView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        inflateHierarchy(r5, r10);
    }

    public GenericDraweeView(Context r5, AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11, 0);
        inflateHierarchy(r5, r10);
    }
}
