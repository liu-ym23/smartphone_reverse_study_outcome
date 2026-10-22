package com.bytedance.ai.model;

import com.bytedance.ai.core.base.SessionType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2248a = null;

    static {
        int[] r5 = new int[SessionType.values().length];
        r5[3] = 1;     // Catch: NoSuchFieldError -> L7
    L11:
        SessionType r10 = SessionType.f2087a;     // Catch: NoSuchFieldError -> L8
        r5[1] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f2248a = r5;
    }
}
