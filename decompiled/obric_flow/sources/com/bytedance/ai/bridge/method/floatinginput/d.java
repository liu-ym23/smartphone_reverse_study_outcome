package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1828a = null;

    static {
        int[] r5 = new int[ContainerType.values().length];
        r5[0] = 1;     // Catch: NoSuchFieldError -> L11
    L21:
        ContainerType r10 = ContainerType.f1800b;     // Catch: NoSuchFieldError -> L12
        r5[1] = 2;     // Catch: NoSuchFieldError -> L12
    L19:
        ContainerType r11 = ContainerType.f1800b;     // Catch: NoSuchFieldError -> L13
        r5[2] = 3;     // Catch: NoSuchFieldError -> L13
    L15:
        ContainerType r12 = ContainerType.f1800b;     // Catch: NoSuchFieldError -> L14
        r5[3] = 4;     // Catch: NoSuchFieldError -> L14
    L9:
        f1828a = r5;
    }
}
