package nn;

import ai.j0;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.lynx.tasm.v;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20281c;
    public final v d;
    public final LynxResourceRequest$LynxResourceType e;

    public f(String r5, long r10, v r11, LynxResourceRequest$LynxResourceType r12) {
        super(r5);
        this.f20281c = r10;
        this.d = r11;
        this.e = r12;
    }

    public final void b(boolean r14, byte[] r15, TemplateBundle r16, String r17) {
        if (a() == true) goto L6;
        return;
    L6:
        if (r15 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r16 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        String r11 = this.f20275b;
        if (r14 == false) goto L22;
        if (r5 == true) goto L20;
        if (r10 == false) goto L22;
    L20:
        this.d.a("last_lynx_async_component_url", r11);
    L22:
        if (r14 == false) goto L35;
        if (r10 == true) goto L35;
        if (r5 == false) goto L35;
        ILynxSecurityService r12 = (ILynxSecurityService) r.g().e(ILynxSecurityService.class);
        if (r12 == null) goto L35;
        if (this.e != LynxResourceRequest$LynxResourceType.f) goto L31;
        ILynxSecurityService.LynxTasmType r13 = ILynxSecurityService.LynxTasmType.f10958a;
    L33:
        if (r12.verifyTASM(null, r15, null, this.f20275b, r13).f19688a == true) goto L35;
        String r18 = j0.C("tasm verify failed, url: ", r11);
        boolean r19 = false;
    L36:
        if (r10 == false) goto L39;
        long r20 = r16.f10051a;
    L38:
        long r21 = r20;
        if (r19 == false) goto L42;
        int r22 = 0;
    L43:
        LynxResourceLoader.nativeInvokeCallback(this.f20281c, r15, r21, null, r22, r18);
        return;
    L42:
        r22 = -1;
        goto L43
    L39:
        r20 = 0;
        goto L38
    L31:
        r13 = ILynxSecurityService.LynxTasmType.f10959b;
    L35:
        r19 = r14;
        r18 = r17;
        goto L36
    L13:
        if (r16.d() == false) goto L15;
        r10 = true;
        goto L16
    L8:
        if (r15.length <= 0) goto L10;
        r5 = true;
        goto L11
    }
}
