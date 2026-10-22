package com.bytedance.ies.bullet.lynx;

import com.lynx.tasm.TemplateBundle;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f5632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5633c;
    public final /* synthetic */ TemplateBundle d;

    public /* synthetic */ f(h r5, String r10, TemplateBundle r11, int r12) {
        this.f5631a = r12;
        this.f5632b = r5;
        this.f5633c = r10;
        this.d = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5631a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        String r5 = this.f5633c;
        TemplateBundle r10 = this.d;
        this.f5632b.f(r5, r10);
        return Unit.INSTANCE;
    L6:
        String r11 = this.f5633c;
        TemplateBundle r12 = this.d;
        this.f5632b.f(r11, r12);
        return Unit.INSTANCE;
    }
}
