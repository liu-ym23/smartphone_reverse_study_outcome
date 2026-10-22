package com.lynx.tasm.behavior.ui.image;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;
import d7a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class InlineImageShadowNode extends AbsInlineImageShadowNode {
    public a Q;

    public class a extends f {
        public final /* synthetic */ InlineImageShadowNode h2;

        @Override // d7a.f
        public final void f() {
            this.h2.q();
        }

        public a(InlineImageShadowNode r1, LynxContext r2) {
            this.h2 = r1;
            super(r2);
        }

        @Override // d7a.f
        public final void k(int r2, int r3) {
            this.h2.R(r2, r3);
        }

        @Override // d7a.f
        public final void j(LynxError r1, int r2, int r3) {
            this.h2.Q(r1.getSummaryMessage());
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ InlineImageShadowNode a;

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a.Q;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.d();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(InlineImageShadowNode r1) {
            this.a = r1;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final com.lynx.tasm.behavior.ui.text.a O() {
        float r0 = this.h.c();
        float r1 = this.h.a();
        return new d7a.b((int) Math.ceil(r0), (int) Math.ceil(r1), this.h.b(), this.Q);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void s() {
        this.Q.B();
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void t() {
        UIThreadUtils.runOnUiThreadImmediately(new b(this));
    }

    public InlineImageShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setMode(String r2) {
        this.Q.u(r2);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setSource(String r2) {
        this.Q.v(r2);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r2) {
        super.w(r2);
        this.Q = new a(this, this.m);
    }
}
