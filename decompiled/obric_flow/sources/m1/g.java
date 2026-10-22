package m1;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.lynx.tasm.utils.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19967c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g(int r5, String r10, Object r11) {
        this.f19966b = r5;
        this.f19967c = r10;
        this.d = r11;
    }

    @Override // com.lynx.tasm.utils.a
    public final void d() {
        switch(this.f19966b) {
            case 0: goto L18;
            default: goto L4;
        };
    L4:
        final String r5 = this.f19967c;
        if (r5 != null) goto L7;
        return;
    L7:
        if (td.d.f22127b == null) goto L22;
        j r10 = (j) ((i) this.d).g.b(j.class);
        if (r10 == null) goto L14;
        ContainerType r11 = r10.d();
        if (r11 == null) goto L14;
    L13:
        final ContainerType r12 = r11;
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r12, "containerType");
        final long r13 = System.currentTimeMillis();
        final int r14 = 0;
        a3.i.a(new a3.c(r13, r14, r5, r12));
        return;
    L14:
        r11 = ContainerType.e;
        goto L13
    L22:
        return;
    L18:
        if (td.d.f22127b == null) goto L23;
        final String r15 = this.f19967c;
        Intrinsics.checkNotNullParameter(r15, "traceId");
        final ProtocolMessage r16 = (ProtocolMessage) this.d;
        Intrinsics.checkNotNullParameter(r16, "callbackMsg");
        final long r17 = System.currentTimeMillis();
        final int r18 = 1;
        a3.i.a(new a3.c(r17, r18, r15, r16));
        return;
    }

    @Override // com.lynx.tasm.utils.a
    public final void l() {
        switch(this.f19966b) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        String r5 = this.f19967c;
        if (r5 != null) goto L7;
        return;
    L7:
        if (td.d.f22127b == null) goto L15;
        i2.c r10 = ((i) this.d).d;
        Intrinsics.checkNotNullParameter(r5, "traceId");
        a3.i.a(new a3.d(r5, System.currentTimeMillis(), r10, 1));
        return;
    L15:
        return;
    L11:
        if (td.d.f22127b == null) goto L16;
        String r11 = this.f19967c;
        Intrinsics.checkNotNullParameter(r11, "traceId");
        a3.i.a(new a3.b(r11, System.currentTimeMillis(), 1));
        return;
    }
}
