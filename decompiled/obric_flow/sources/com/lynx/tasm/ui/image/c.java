package com.lynx.tasm.ui.image;

import com.bytedance.common.wschannel.WsConstants;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxBaseUI f11032b;

    public /* synthetic */ c(LynxBaseUI r5, int r10) {
        this.f11031a = r10;
        this.f11032b = r5;
    }

    @Override // com.lynx.tasm.ui.image.b0
    public void a(int r5, int r10) {
        switch(this.f11031a) {
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        UIImage r11 = (UIImage) this.f11032b;
        UIImage.access$302(r11, r5);
        UIImage.access$402(r11, r10);
    }

    @Override // com.lynx.tasm.ui.image.b0
    public final void b(LynxError r5, int r10, int r11) {
        switch(this.f11031a) {
            case 0: goto L22;
            case 1: goto L13;
            default: goto L4;
        };
    L4:
        UIImage r12 = (UIImage) this.f11032b;
        com.lynx.animax.i r13 = new com.lynx.animax.i(r12.getSign(), "error");
        StringBuilder r14 = new StringBuilder();
        String r15 = r5.f9993h;
        String r16 = "";
        if (r15 != null) goto L7;
        r15 = "";
    L7:
        r14.append(r15);
        r14.append(": ");
        String r17 = r5.f10000o;
        if (r17 == null) goto L11;
        r16 = r17;
    L11:
        r14.append(r16);
        r13.a("errMsg", r14.toString());
        r13.a("lynx_categorized_code", Integer.valueOf(r10));
        r13.a(WsConstants.ERROR_CODE, Integer.valueOf(r11));
        r12.getLynxContext().g.b(r13);
        r12.getLynxContext().f(UIImage.access$200(r12), "image", r5);
        return;
    L13:
        UIFilterImage r18 = (UIFilterImage) this.f11032b;
        com.lynx.animax.i r19 = new com.lynx.animax.i(r18.getSign(), "error");
        StringBuilder r20 = new StringBuilder();
        String r21 = r5.f9993h;
        String r22 = "";
        if (r21 != null) goto L16;
        r21 = "";
    L16:
        r20.append(r21);
        r20.append(": ");
        String r23 = r5.f10000o;
        if (r23 == null) goto L20;
        r22 = r23;
    L20:
        r20.append(r22);
        r19.a("errMsg", r20.toString());
        r19.a("lynx_categorized_code", Integer.valueOf(r10));
        r19.a(WsConstants.ERROR_CODE, Integer.valueOf(r11));
        r18.getLynxContext().g.b(r19);
        return;
    L22:
        FlattenUIImage r24 = (FlattenUIImage) this.f11032b;
        com.lynx.animax.i r25 = new com.lynx.animax.i(r24.getSign(), "error");
        StringBuilder r26 = new StringBuilder();
        String r27 = r5.f9993h;
        String r28 = "";
        if (r27 != null) goto L25;
        r27 = "";
    L25:
        r26.append(r27);
        r26.append(": ");
        String r29 = r5.f10000o;
        if (r29 == null) goto L29;
        r28 = r29;
    L29:
        r26.append(r28);
        r25.a("errMsg", r26.toString());
        r25.a("lynx_categorized_code", Integer.valueOf(r10));
        r25.a(WsConstants.ERROR_CODE, Integer.valueOf(r11));
        r24.getLynxContext().g.b(r25);
        r24.getLynxContext().f(FlattenUIImage.access$300(r24), "image", r5);
    }

    @Override // com.lynx.tasm.ui.image.b0
    public boolean c() {
        switch(this.f11031a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.c();
    L7:
        return UIImage.access$500((UIImage) this.f11032b);
    }

    @Override // com.lynx.tasm.ui.image.b0
    public final void d(int r5, int r10) {
        switch(this.f11031a) {
            case 0: goto L16;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        UIImage r11 = (UIImage) this.f11032b;
        if (UIImage.access$000(r11) != null) goto L7;
        return;
    L7:
        if (UIImage.access$100(r11).containsKey("load") == false) goto L23;
        com.lynx.animax.i r12 = new com.lynx.animax.i(r11.getSign(), "load");
        r12.a("height", Integer.valueOf(r10));
        r12.a("width", Integer.valueOf(r5));
        r11.getLynxContext().g.b(r12);
        return;
    L23:
        return;
    L10:
        UIFilterImage r13 = (UIFilterImage) this.f11032b;
        if (UIFilterImage.b(r13) != null) goto L13;
        return;
    L13:
        if (UIFilterImage.c(r13).containsKey("load") == false) goto L25;
        com.lynx.animax.i r14 = new com.lynx.animax.i(r13.getSign(), "load");
        r14.a("height", Integer.valueOf(r10));
        r14.a("width", Integer.valueOf(r5));
        r13.getLynxContext().g.b(r14);
        return;
    L25:
        return;
    L16:
        FlattenUIImage r15 = (FlattenUIImage) this.f11032b;
        if (FlattenUIImage.access$100(r15) != null) goto L19;
        return;
    L19:
        if (FlattenUIImage.access$200(r15).containsKey("load") == false) goto L27;
        com.lynx.animax.i r16 = new com.lynx.animax.i(r15.getSign(), "load");
        r16.a("height", Integer.valueOf(r10));
        r16.a("width", Integer.valueOf(r5));
        r15.getLynxContext().g.b(r16);
        return;
    }
}
