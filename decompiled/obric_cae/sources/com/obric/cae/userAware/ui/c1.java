package com.obric.cae.userAware.ui;

import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SubwayStatusActivity f5929b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f5930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5931n;

    public /* synthetic */ c1(SubwayStatusActivity r8, Object r10, boolean r11, int r12) {
        this.f5928a = r12;
        this.f5929b = r8;
        this.f5931n = r10;
        this.f5930m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5928a;
        SubwayStatusActivity r10 = this.f5929b;
        boolean r11 = this.f5930m;
        Object r12 = this.f5931n;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        SubwayStatusActivity.q(r10, (Set) r12, r11);
        return;
    L7:
        SubwayStatusActivity.f(r10, (SubwayFeedbackInfo) r12, r11);
    }
}
