package com.google.protobuf;

import com.qti.extphone.QosBearerFilter;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5194a;

    public /* synthetic */ e(int r8) {
        this.f5194a = r8;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int r8) {
        switch(this.f5194a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return LegacyUnredactedTextFormat.c(r8);
    L8:
        return QosBearerFilter.t(r8);
    }
}
