package com.bytedance.ai.model.widgets;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements m3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lynx.tasm.t f2361b;

    public o(String r5, int r10) {
        this.f2360a = r10;
        switch(r10) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "appGroupId");
        this.f2361b = new com.lynx.tasm.t(false, r5);
        return;
    L6:
        this.f2361b = new com.lynx.tasm.t(false, r5);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "appGroupId");
        this.f2361b = new com.lynx.tasm.t(false, r5);
    }

    @Override // m3.a
    public final com.lynx.tasm.t a() {
        switch(this.f2360a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.f2361b;
    L7:
        return this.f2361b;
    L9:
        return this.f2361b;
    }
}
