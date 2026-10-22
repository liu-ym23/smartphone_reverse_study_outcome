package o9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f11595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f11596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f11597c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        new n9.a();
    }

    public n(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f11595a = new k(r10, r11, r12, r13);
        this.f11596b = new g(r10, r11, r12, r13);
    }

    public o9.a a() {
        return this.f11596b;
    }

    public j b() {
        j r10 = this.f11597c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOUIEffectHelper");
    L5:
        return r10;
    }

    public b c() {
        return this.f11595a;
    }

    public final void d(View r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this.f11595a.C(r10);
        this.f11596b.i(r10);
        this.f11597c = new j(r10);
    }
}
