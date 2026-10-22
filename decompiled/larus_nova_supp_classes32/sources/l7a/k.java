package l7a;

import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.q0;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.service.security.ILynxSecurityService;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends c {
    public final long c;
    public final q0 d;
    public final LynxResourceRequest.LynxResourceType e;

    public k(String r1, long r2, q0 r4, LynxResourceRequest.LynxResourceType r5) {
        super(r1);
        this.c = r2;
        this.d = r4;
        this.e = r5;
    }

    public final void b(boolean r13, byte[] r14, TemplateBundle r15, String r16) {
        if (a() == true) goto L5;
        return;
    L5:
        int r9 = 0;
        if (r14 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r15 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r13 == false) goto L22;
        if (r2 == true) goto L19;
        if (r10 == false) goto L22;
    L19:
        q0 r1 = this.d;
        if (r1 == null) goto L22;
        r1.a("last_lynx_async_component_url", this.b);
    L22:
        if (r13 == false) goto L34;
        if (r10 == true) goto L34;
        if (r2 == false) goto L34;
        ILynxSecurityService r3 = (ILynxSecurityService) n.c().a(ILynxSecurityService.class);
        if (r3 == null) goto L34;
        if (this.e != LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate) goto L30;
        ILynxSecurityService.LynxTasmType r4 = ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE;
    L32:
        if (r3.verifyTASM(null, r14, null, this.b, r4).a == true) goto L34;
        String r11 = "tasm verify failed, url: " + this.b;
        boolean r5 = false;
    L35:
        long r6 = this.c;
        if (r10 == false) goto L38;
        long r7 = r15.a;
    L39:
        if (r5 == true) goto L42;
        r9 = -1;
    L42:
        LynxResourceLoader.nativeInvokeCallback(r6, r14, r7, null, r9, r11);
        return;
    L38:
        r7 = 0;
        goto L39
    L30:
        r4 = ILynxSecurityService.LynxTasmType.TYPE_DYNAMIC_COMPONENT;
    L34:
        r5 = r13;
        r11 = r16;
        goto L35
    L13:
        if (r15.i() == false) goto L15;
        r10 = true;
        goto L16
    L8:
        if (r14.length <= 0) goto L10;
        r2 = true;
        goto L11
    }
}
