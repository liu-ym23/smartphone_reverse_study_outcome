package com.google.protobuf;

import com.obric.cae.userAware.ui.StoreArrivalActivity;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5195a;

    public /* synthetic */ f(int r8) {
        this.f5195a = r8;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch(this.f5195a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return ProtobufToStringOutput.a();
    L8:
        return StoreArrivalActivity.l();
    }
}
