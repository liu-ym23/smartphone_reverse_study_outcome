package com.larus.bmhome.block.holder.deepthink;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import cb8.x1;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.markdown.imagetool.MarkdownImageSearchWidget;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.utils.z3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc8.w0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z extends jc8.b<gb8.f> {
    public MarkdownImageSearchWidget d;

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
        return "DeepThinkImageSearchBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        MarkdownImageSearchWidget r0 = this.d;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public z() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r8) {
        gb8.f r9 = (gb8.f) r8;
        Intrinsics.checkNotNullParameter(r9, "blockModel");
        jc8.k r0 = this.a;
        if (r0 == null) goto L5;
        tb8.a r1 = (tb8.a) r0.a(tb8.a.class);
    L6:
        boolean r2 = false;
        if (r1 == null) goto L9;
        boolean r3 = r1.e;
    L10:
        if (r1 == null) goto L14;
        fh8.d r4 = r1.f;
        if (r4 == null) goto L14;
        boolean r5 = r4.b();
    L15:
        boolean r6 = r9.m();
        boolean r10 = r9.n();
        if (r5 == false) goto L20;
        if (r3 == false) goto L20;
        r2 = true;
    L20:
        if (r6 == false) goto L28;
        if (r10 == false) goto L28;
        int r7 = c7.b(16);
        int r11 = c7.b(12);
        int r12 = c7.b(16);
        if (r2 == false) goto L25;
        int r13 = 40;
    L38:
        return new jc8.d(r7, r11, r12, c7.b(r13));
    L25:
        r13 = 14;
    L28:
        if (r6 == true) goto L39;
        if (r10 == false) goto L37;
        int r14 = c7.b(16);
        int r15 = c7.b(6);
        int r16 = c7.b(16);
        if (r2 == false) goto L34;
        int r17 = 40;
    L40:
        return new jc8.d(r14, r15, r16, c7.b(r17));
    L34:
        r17 = 14;
        goto L40
    L37:
        return new jc8.d(c7.b(16), c7.b(6), c7.b(16), c7.b(6));
    L39:
        return new jc8.d(c7.b(16), c7.b(12), c7.b(16), c7.b(6));
    L14:
        r5 = false;
        goto L15
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // jc8.b
    public final void g(jc8.a r7) {
        gb8.f r8 = (gb8.f) r7;
        Intrinsics.checkNotNullParameter(r8, "blockModel");
        Intrinsics.checkNotNullParameter(r8, "blockModel");
        MarkdownImageSearchWidget r0 = this.d;
        if (r0 == null) goto L16;
        jc8.k r1 = this.a;
        int r2 = 1;
        if (r1 == null) goto L15;
        List<jc8.a> r3 = r1.b();
        if (r3 == null) goto L15;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        if ((r6 instanceof gb8.f) == false) goto L10;
        r4.add(r6);
        goto L10
    L14:
        r2 = 1 + x1.a(r4, r8, gb8.f.class);
    L15:
        r0.setCardPosition(Integer.valueOf(r2));
    L16:
        MarkdownImageSearchWidget r9 = this.d;
        if (r9 == null) goto L26;
        j(r8, r9);
        return;
    }

    @Override // jc8.b
    public final View h(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        MarkdownImageSearchWidget r0 = new MarkdownImageSearchWidget(r3.getContext(), null);
        this.d = r0;
        return r0;
    }

    public final void j(final gb8.f r12, final MarkdownImageSearchWidget r13) {
        tb8.a r0 = (tb8.a) jc8.c.a(this, tb8.a.class);
        if (r0 != null) goto L5;
        r0 = new tb8.a(null, null, null, null, false, null, 63);
    L5:
        cd8.a r1 = (cd8.a) jc8.c.a(this, cd8.a.class);
        boolean r2 = false;
        if (r1 == null) goto L8;
        int r5 = r1.a;
    L9:
        kc8.b r9 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r9 == null) goto L12;
        w0 r3 = r9.v;
    L13:
        String r4 = r12.a.getBlockId();
        if (r3 == null) goto L16;
        ToolBlockInitStatus r6 = r3.b;
    L18:
        if (r6 != null) goto L20;
        int r7 = -1;
    L22:
        if (r7 == (-1)) goto L33;
        if (r7 != 1) goto L25;
        Boolean r8 = Boolean.TRUE;
    L35:
        if (Intrinsics.areEqual(r13.k, r4) == true) goto L37;
    L38:
        r13.k = r4;
        r13.l = r8;
        r13.m = true;
    L39:
        SearchReferenceData r10 = r12.o();
        if (r9 == null) goto L44;
        kc8.p r11 = r9.e;
        if (r11 == null) goto L44;
        Integer r14 = Integer.valueOf(r11.a);
    L45:
        int r15 = com.larus.bmhome.chat.markdown.imagetool.f.a;
        kc8.b r16 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r16 == null) goto L48;
        fh8.f r17 = z3.a(r16, r12.j()).a();
    L49:
        fh8.f r18 = com.larus.bmhome.chat.markdown.imagetool.f.b(r0, r17, new x(this, r12, r13));
        if (r3 == null) goto L52;
        ToolBlockInteractType r19 = r3.a;
    L54:
        if (r19 != ToolBlockInteractType.DisableHeaderInteract) goto L56;
        r2 = true;
    L56:
        if (r3 == null) goto L58;
        ToolBlockInteractType r20 = r3.a;
    L60:
        if (r20 != ToolBlockInteractType.OpenFloatingPage) goto L62;
        Function0<Boolean> r110 = new y(this, r12);
    L63:
        Size r111 = r13.a(r10, r5, r18, r14, Boolean.valueOf(r2), r9, r110);
        ViewGroup.LayoutParams r21 = r13.getLayoutParams();
        if (r21 == null) goto L66;
        r21.width = r111.getWidth();
    L66:
        ViewGroup.LayoutParams r112 = r13.getLayoutParams();
        if (r112 == null) goto L70;
        r112.height = r111.getHeight();
        return;
    L70:
        return;
    L62:
        r110 = null;
        goto L63
    L58:
        r20 = null;
        goto L60
    L52:
        r19 = null;
        goto L54
    L48:
        r17 = new fh8.f(0);
    L44:
        r14 = null;
        goto L45
    L37:
        if (Intrinsics.areEqual(r13.l, r8) == true) goto L39;
    L25:
        if (r7 != 2) goto L27;
        r8 = Boolean.FALSE;
        goto L35
    L27:
        if (r7 == 3) goto L33;
        throw new NoWhenBranchMatchedException();
    L33:
        r8 = null;
        goto L35
    L20:
        r7 = a.a[r6.ordinal()];
        goto L22
    L16:
        r6 = null;
        goto L18
    L12:
        r3 = null;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }
}
