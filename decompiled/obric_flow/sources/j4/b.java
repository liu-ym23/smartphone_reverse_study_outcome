package j4;

import com.lynx.tasm.o0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f18233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f18234b;

    public b(Function0 r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r5, "onLoadSuccessOuter");
        Intrinsics.checkNotNullParameter(r10, "onFirstScreenOuter");
        this.f18233a = r5;
        this.f18234b = r10;
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstScreen() {
        this.f18234b.invoke();
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadSuccess() {
        this.f18233a.invoke();
    }
}
