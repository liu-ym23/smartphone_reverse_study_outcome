package com.obric.cae.libs.useraware;

import com.qti.extphone.QosBearerFilter;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5567a;

    public /* synthetic */ a(int r8) {
        this.f5567a = r8;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int r8) {
        switch(this.f5567a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return BtAwareInfo.a(r8);
    L8:
        return QosBearerFilter.u(r8);
    }
}
