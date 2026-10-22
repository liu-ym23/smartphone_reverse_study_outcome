package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g[] f18917b;

    public /* synthetic */ z1(g[] r5, int r10) {
        this.f18916a = r10;
        this.f18917b = r5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f18916a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r5 = this.f18917b.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[r5];
    L6:
        int r10 = this.f18917b.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[r10];
    }
}
