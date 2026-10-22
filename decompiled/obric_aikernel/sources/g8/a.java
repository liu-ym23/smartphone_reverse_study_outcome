package g8;

import com.obric.aikernel.api.b;
import com.obric.aikernel.runtime.AIInferRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements AIInferRuntime.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9004a = null;

    static {
        f9004a = new a();
    }

    private a() {
    }

    @Override // com.obric.aikernel.runtime.AIInferRuntime.e
    public int a(int r10) {
        return b.f4431a.i().a(r10);
    }

    @Override // com.obric.aikernel.runtime.AIInferRuntime.e
    public void b(int r10) {
        b.f4431a.i().b(r10);
    }

    public int c(int r10) {
        return b.f4431a.i().c(r10);
    }

    public Boolean d(int r10) {
        return b.f4431a.i().d(r10);
    }

    public void e(int r10, int r11) {
        b.f4431a.i().e(r10, r11);
    }

    public void f(int r10, int r11) {
        b.f4431a.i().f(r10, r11);
    }

    public int g(int r10, String r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "modelStage");
        return b.f4431a.i().g(r10, r11, r12, r13, r14);
    }
}
