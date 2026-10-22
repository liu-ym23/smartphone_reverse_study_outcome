package com.bytedance.ai.uiu;

import com.bytedance.ai.uiu.objects.ConversionScene;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2824a = null;

    static {
        int[] r5 = new int[ConversionScene.values().length];
        r5[ConversionScene.SCENE_FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r5[ConversionScene.SCENE_WIDGETS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r5[ConversionScene.SCENE_POPUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f2824a = r5;
    }
}
