package com.bytedance.ies.bullet.forest;

import com.bytedance.env.api.AccessKeyType;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f5411a = null;

    static {
        int[] r5 = new int[AccessKeyType.values().length];
        r5[0] = 1;     // Catch: NoSuchFieldError -> L10
    L14:
        r5[2] = 2;     // Catch: NoSuchFieldError -> L11
    L6:
        f5411a = r5;
        int[] r10 = new int[ResourceLoaderType.values().length];
        r10[1] = 1;     // Catch: NoSuchFieldError -> L12
    L18:
        r10[0] = 2;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
