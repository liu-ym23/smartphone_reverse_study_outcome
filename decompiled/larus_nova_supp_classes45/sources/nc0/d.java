package nc0;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements com.bytedance.android.live.revenuelink.rtc.g {
    public final gy.d a;

    public final void U3() {
    }

    public final void W3() {
    }

    public final void o() {
        this.a.o();
    }

    public d(gy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final void L(String r2) {
        this.a.L(r2);
    }

    public final void o0(long r2) {
        this.a.o0(r2);
    }

    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        this.a.onUserJoined(r2);
    }

    public final void A(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        this.a.A(r2, r3);
    }

    public final void C1(vc0.a r2, vc0.a[] r3) {
        this.a.C1(r2, r3);
    }

    public final void R(long r2, Exception r4) {
        this.a.R(r2, r4);
    }

    public final void S3(String r2, ByteBuffer r3) {
        this.a.S3(r2, r3);
    }

    public final void X0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a.X0(r2, r3);
    }

    public final void e1(String r2, long r3) {
        this.a.e1(r2, r3);
    }

    public final void f0(long r2, Exception r4) {
        this.a.f0(r2, r4);
    }

    public final void f1(long r2, long r4) {
        this.a.f1(r2, r4);
    }

    public final void g(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        this.a.g(r2, r3);
    }

    public final void p1(int r2, int r3) {
        this.a.p1(r2, r3);
    }

    public final void s(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a.s(r2, r3);
    }

    public final void u1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a.u1(r2, r3);
    }

    public final void J(String[] r2, boolean[] r3, int[] r4) {
        this.a.J(r2, r3, r4);
    }

    public final void S(String r2, int r3, int r4) {
        this.a.S(r2, r3, r4);
    }

    public final void L0(String r2, TextureView r3, int r4, int r5) {
        this.a.L0(r2, r3, r4, r5);
    }

    public final void S2(String r2, Object r3, int r4, int r5) {
        this.a.S2(r2, r3, r4, r5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void T3(String r3, vc0.a r4, int r5, int r6) {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        z.a r1 = null;
        Object r2 = null;
        if (r0 == null) goto L7;
        if (r4 == null) goto L6;
        r2 = r4.a;
    L6:
        r1 = r0.buildLayerControlLayer(r2);
    L7:
        this.a.b4(r3, r1, r5, r6);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void V3(String r1, vc0.a r2, int r3, int r4) {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
        z.a r6 = null;
        Object r7 = null;
        if (r5 == null) goto L7;
        if (r2 == null) goto L6;
        r7 = r2.a;
    L6:
        r6 = r5.buildLayerControlLayer(r7);
    L7:
        this.a.V4(r1, r6);
    }

    public final void h1(String r2, SurfaceView r3, int r4, int r5) {
        this.a.h1(r2, r3, r4, r5);
    }

    public final void j0(String r2, TextureView r3, int r4, int r5) {
        this.a.j0(r2, r3, r4, r5);
    }

    public final void y0(String r2, SurfaceView r3, int r4, int r5) {
        this.a.y0(r2, r3, r4, r5);
    }
}
