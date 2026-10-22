package com.obric.cae.location.geosdk.poi;

import com.obric.cae.userAware.UserAwareService;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f5683b;

    public /* synthetic */ b(boolean r8, int r10) {
        this.f5682a = r10;
        this.f5683b = r8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r8) {
        int r10 = this.f5682a;
        boolean r11 = this.f5683b;
        switch(r10) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return StarAoiBoardManager.c((String) r8, r11);
    L8:
        return UserAwareService.a((String) r8, r11);
    }
}
