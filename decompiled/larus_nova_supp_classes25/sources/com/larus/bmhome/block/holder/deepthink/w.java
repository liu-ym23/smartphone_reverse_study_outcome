package com.larus.bmhome.block.holder.deepthink;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.markdown.imagetool.MarkdownImageAnalysisWidget;
import com.larus.bmhome.utils.z3;
import com.larus.im.bean.message.block.Block;
import kc8.w0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w extends jc8.b<gb8.e> {
    public MarkdownImageAnalysisWidget d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolBlockInitStatus.values().length];
            r0[ToolBlockInitStatus.Fold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ToolBlockInitStatus.Expand.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ToolBlockInitStatus.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // jc8.b
    public final String c() {
        return "DeepThinkImageAnalysisBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        MarkdownImageAnalysisWidget r0 = this.d;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public w() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        gb8.e r3 = (gb8.e) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return j0.a(this.a, r3);
    }

    @Override // jc8.b
    public final void g(jc8.a r2) {
        gb8.e r3 = (gb8.e) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        MarkdownImageAnalysisWidget r0 = this.d;
        if (r0 == null) goto L7;
        j(r3, r0);
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        MarkdownImageAnalysisWidget r0 = new MarkdownImageAnalysisWidget(r3.getContext(), null);
        this.d = r0;
        return r0;
    }

    public final void j(final gb8.e r12, final MarkdownImageAnalysisWidget r13) {
        tb8.a r0 = (tb8.a) jc8.c.a(this, tb8.a.class);
        cd8.a r1 = (cd8.a) jc8.c.a(this, cd8.a.class);
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r5 = r1.a;
    L6:
        kc8.b r9 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r9 == null) goto L9;
        w0 r3 = r9.v;
    L10:
        String r4 = r12.a.getBlockId();
        if (r3 == null) goto L13;
        ToolBlockInitStatus r6 = r3.b;
    L15:
        if (r6 != null) goto L17;
        int r7 = -1;
    L19:
        if (r7 == (-1)) goto L30;
        if (r7 != 1) goto L22;
        Boolean r8 = Boolean.TRUE;
    L32:
        if (Intrinsics.areEqual(r13.k, r4) == true) goto L34;
    L35:
        r13.k = r4;
        r13.l = r8;
        r13.m = true;
    L36:
        Block r10 = r12.a;
        int r11 = com.larus.bmhome.chat.markdown.imagetool.f.a;
        kc8.b r14 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r14 == null) goto L39;
        fh8.f r15 = z3.a(r14, r12.j()).a();
    L40:
        fh8.f r16 = com.larus.bmhome.chat.markdown.imagetool.f.b(r0, r15, new u(this, r12, r13));
        if (r9 == null) goto L45;
        kc8.p r17 = r9.e;
        if (r17 == null) goto L45;
        Integer r18 = Integer.valueOf(r17.a);
    L46:
        if (r3 == null) goto L48;
        ToolBlockInteractType r19 = r3.a;
    L50:
        if (r19 != ToolBlockInteractType.DisableHeaderInteract) goto L52;
        r2 = true;
    L52:
        Boolean r20 = Boolean.valueOf(r2);
        if (r3 == null) goto L55;
        ToolBlockInteractType r21 = r3.a;
    L57:
        if (r21 != ToolBlockInteractType.OpenFloatingPage) goto L59;
        Function0<Boolean> r110 = new v(this, r12);
    L60:
        r13.a(r10, r5, r16, r18, r20, r9, r110);
        return;
    L59:
        r110 = null;
        goto L60
    L55:
        r21 = null;
        goto L57
    L48:
        r19 = null;
    L45:
        r18 = null;
        goto L46
    L39:
        r15 = new fh8.f(0);
        goto L40
    L34:
        if (Intrinsics.areEqual(r13.l, r8) == true) goto L36;
    L22:
        if (r7 != 2) goto L24;
        r8 = Boolean.FALSE;
        goto L32
    L24:
        if (r7 == 3) goto L30;
        throw new NoWhenBranchMatchedException();
    L30:
        r8 = null;
        goto L32
    L17:
        r7 = a.a[r6.ordinal()];
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r3 = null;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }
}
