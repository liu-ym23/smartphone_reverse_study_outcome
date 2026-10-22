package com.bytedance.ies.bullet.forest;

import com.bytedance.env.api.AccessKeyType;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f5391a = null;

    static {
        int[] r5 = new int[ResourceLoaderType.values().length];
        r5[0] = 1;     // Catch: NoSuchFieldError -> L11
    L15:
        r5[1] = 2;     // Catch: NoSuchFieldError -> L12
    L6:
        int[] r10 = new int[AccessKeyType.values().length];
        r10[0] = 1;     // Catch: NoSuchFieldError -> L13
    L17:
        r10[2] = 2;     // Catch: NoSuchFieldError -> L14
    L9:
        f5391a = r10;
    }
}
