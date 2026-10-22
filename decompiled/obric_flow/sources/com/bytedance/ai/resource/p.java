package com.bytedance.ai.resource;

import com.bytedance.geckox.model.LocalPackageModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends pa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f2747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2748c;

    public /* synthetic */ p(Serializable r5, Object r10, int r11) {
        this.f2746a = r11;
        this.f2747b = r5;
        this.f2748c = r10;
    }

    @Override // pa.a
    public void a() {
        switch(this.f2746a) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        StringBuilder r5 = new StringBuilder("onUpdateFinish ");
        Ref.BooleanRef r10 = (Ref.BooleanRef) this.f2747b;
        r5.append(!r10.element);
        String r11 = r5.toString();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L8;
        r12.d("AppletResourceLoader", r11);
    L8:
        ((kotlinx.coroutines.s) this.f2748c).N(Boolean.valueOf(!r10.element));
    }

    @Override // pa.a
    public void b(LocalPackageModel r5) {
        switch(this.f2746a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        String r10 = "local version is latest. packageName: ".concat((String) this.f2747b);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L8;
        r11.d("AIPackageManager", r10);
    L8:
        Result.Companion r12 = Result.Companion;
        Object r13 = Result.m124constructorimpl(Boolean.TRUE);
        ((kotlinx.coroutines.l) this.f2748c).resumeWith(r13);
    }

    @Override // pa.a
    public void c(Throwable r5) {
        switch(this.f2746a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        String r10 = "onCheckServerVersionFail. packageName: ".concat((String) this.f2747b);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L9;
        r11.e("AIPackageManager", r10);
        return;
    }

    @Override // pa.a
    public void d(Map r5, HashMap r10) {
        switch(this.f2746a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        String r11 = "onCheckServerVersionSuccess. packageName: ".concat((String) this.f2747b);
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L9;
        r12.d("AIPackageManager", r11);
        return;
    }

    @Override // pa.a
    public void e(sa.a r5, long r10) {
        switch(this.f2746a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        String r11 = "onUpdateSuccess. packageName: " + ((String) this.f2747b) + ", version: " + r10;
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L8;
        r12.d("AIPackageManager", r11);
    L8:
        Result.Companion r13 = Result.Companion;
        ((kotlinx.coroutines.l) this.f2748c).resumeWith(Result.m124constructorimpl(Boolean.TRUE));
    }

    @Override // pa.a
    public final void f(sa.a r5, Exception r10) {
        Serializable r11 = this.f2747b;
        switch(this.f2746a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        StringBuilder r12 = new StringBuilder("failed to update ");
        if (r5 == null) goto L7;
        String r13 = r5.f21882a;
    L8:
        r12.append(r13);
        r12.append(", ");
        r12.append(r10);
        String r14 = r12.toString();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L11;
        r15.e("AppletResourceLoader", r14);
    L11:
        ((Ref.BooleanRef) r11).element = true;
        return;
    L7:
        r13 = null;
        goto L8
    L13:
        String r16 = "failed to update package: " + ((String) r11) + ", " + r10;
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L16;
        r17.e("AIPackageManager", r16);
    L16:
        Result.Companion r18 = Result.Companion;
        ((kotlinx.coroutines.l) this.f2748c).resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r10)));
    }
}
