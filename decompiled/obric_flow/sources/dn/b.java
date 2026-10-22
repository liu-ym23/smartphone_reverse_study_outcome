package dn;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.ui.image.InlineImageShadowNode;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends f {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final /* synthetic */ InlineImageShadowNode f16667j0;

    public b(InlineImageShadowNode r5, b0 r10) {
        this.f16667j0 = r5;
        super(r10);
    }

    @Override // dn.f
    public final void b(int r5, int r10) {
        this.f16667j0.B(r5, r10);
    }

    @Override // dn.f
    public final void h(LynxError r5, int r10, int r11) {
        String r12 = r5.f9993h;
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        this.f16667j0.D(r12);
    }

    @Override // dn.f
    public final void n() {
        this.f16667j0.n();
    }
}
