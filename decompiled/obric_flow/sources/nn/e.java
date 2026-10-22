package nn;

import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import fo.g;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f20280b;

    public e(int r10, long r11, LynxResourceLoader r12, String r13) {
        this.f20279a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        LynxResourceRequest$LynxResourceType r5 = LynxResourceRequest$LynxResourceType.g;
        this.f20280b = new f(r13, r11, r12.f, r5);
        return;
    L6:
        this.f20280b = new a(r12, r13, r11);
    }

    @Override // fo.g
    public final void a(b0 r5) {
        switch(this.f20279a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        Object r10 = r5.d;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L8:
        byte[] r12 = (byte[]) r10;
        Throwable r13 = (Throwable) r5.f7247c;
        if (r13 == null) goto L11;
        r13.getMessage();
    L11:
        ((a) this.f20280b).b(r11, r12);
        return;
    L7:
        r11 = false;
        goto L8
    L13:
        Object r14 = r5.d;
        if (r14 == null) goto L16;
        boolean r15 = true;
    L17:
        byte[] r16 = (byte[]) r14;
        Throwable r17 = (Throwable) r5.f7247c;
        if (r17 == null) goto L20;
        String r18 = r17.getMessage();
    L21:
        ((f) this.f20280b).b(r15, r16, null, r18);
        return;
    L20:
        r18 = null;
        goto L21
    L16:
        r15 = false;
        goto L17
    }
}
