package com.bytedance.pia.core.bridge.methods;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements fh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6961a;

    public /* synthetic */ a(int r5) {
        this.f6961a = r5;
    }

    @Override // fh.b
    public final Object create() {
        switch(this.f6961a) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            default: goto L5;
        };
    L5:
        return new com.bytedance.ai.resource.core.net.a(17);
    L7:
        return new com.bytedance.pia.core.utils.f(null);
    L9:
        return new s0();
    L11:
        return new q0();
    L13:
        return new k0();
    L15:
        return new g0();
    L17:
        return new c0();
    L19:
        return new z();
    L21:
        return new w();
    L23:
        return new u();
    L25:
        return new c();
    }
}
