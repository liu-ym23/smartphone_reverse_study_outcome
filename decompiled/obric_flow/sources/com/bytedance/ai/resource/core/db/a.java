package com.bytedance.ai.resource.core.db;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIPackageDao_Impl f2665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2666c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public /* synthetic */ a(AIPackageDao_Impl r5, String r10, String r11, long r12, int r13) {
        this.f2664a = r13;
        this.f2665b = r5;
        this.f2666c = r10;
        this.d = r11;
        this.e = r12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        switch(this.f2664a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        AIPackageDao_Impl r5 = this.f2665b;
        String r11 = this.f2666c;
        String r12 = this.d;
        return AIPackageDao_Impl.a(r5, r11, r12, this.e, (Continuation) r10);
    L6:
        AIPackageDao_Impl r13 = this.f2665b;
        String r14 = this.f2666c;
        String r15 = this.d;
        return AIPackageDao_Impl.c(r13, r14, r15, this.e, (Continuation) r10);
    }
}
