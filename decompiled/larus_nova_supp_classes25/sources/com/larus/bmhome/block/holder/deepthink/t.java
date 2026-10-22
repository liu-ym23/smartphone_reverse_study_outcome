package com.larus.bmhome.block.holder.deepthink;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.deepresearch.view.j2;
import com.larus.bmhome.chat.deepresearch.view.n2;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.im.bean.message.block.Block;
import java.util.LinkedHashMap;
import java.util.Map;
import kc8.w0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t extends jc8.b<gb8.d> {
    public n2 d;
    public final Map<String, Boolean> e;

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
        return "DeepThinkGenImageHolder";
    }

    @Override // jc8.b
    public final void i() {
        ((LinkedHashMap) this.e).clear();
    }

    public t() {
        this.e = new LinkedHashMap();
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        gb8.d r3 = (gb8.d) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return jc8.e.d(r3);
    }

    @Override // jc8.b
    public final void g(jc8.a r13) {
        final gb8.d r14 = (gb8.d) r13;
        Intrinsics.checkNotNullParameter(r14, "blockModel");
        kc8.b r0 = (kc8.b) jc8.c.a(this, kc8.b.class);
        Integer r1 = null;
        if (r0 == null) goto L5;
        w0 r2 = r0.v;
    L6:
        n2 r3 = this.d;
        boolean r4 = true;
        if (r3 == null) goto L23;
        if (r2 == null) goto L10;
        ToolBlockInteractType r6 = r2.a;
    L12:
        if (r6 != ToolBlockInteractType.DisableHeaderInteract) goto L14;
        boolean r7 = true;
    L15:
        if (r2 == null) goto L17;
        ToolBlockInteractType r8 = r2.a;
    L19:
        if (r8 != ToolBlockInteractType.OpenFloatingPage) goto L21;
        Function0<Boolean> r9 = new s(this, r14);
    L22:
        r3.f = r7;
        r3.g = r9;
        goto L23
    L21:
        r9 = null;
        goto L22
    L17:
        r8 = null;
        goto L19
    L14:
        r7 = false;
        goto L15
    L10:
        r6 = null;
    L23:
        if (r3 == null) goto L50;
        Block r10 = r14.a;
        LinkedHashMap r11 = new LinkedHashMap();
        n2 r12 = this.d;
        if (r12 == null) goto L45;
        String r15 = r12.e(r14.a);
        Map<String, Boolean> r16 = this.e;
        if (r2 == null) goto L29;
        ToolBlockInitStatus r5 = r2.b;
    L31:
        if (r5 != null) goto L33;
        int r17 = -1;
    L34:
        if (r17 == (-1)) goto L43;
        if (r17 != 1) goto L37;
    L44:
        Boolean r18 = r16.putIfAbsent(r15, Boolean.valueOf(r4));
        goto L45
    L37:
        if (r17 == 2) goto L43;
        if (r17 == 3) goto L43;
        throw new NoWhenBranchMatchedException();
    L43:
        r4 = false;
        goto L44
    L33:
        r17 = a.a[r5.ordinal()];
        goto L34
    L29:
        r5 = null;
    L45:
        r11.put("block_view_extra_fold_states", this.e);
        cd8.a r19 = (cd8.a) jc8.c.a(this, cd8.a.class);
        if (r19 == null) goto L48;
        int r20 = r19.a;
    L49:
        r11.put("block_view_extra_max_width", Integer.valueOf(r20));
        r11.put("block_view_extra_fold_with_anim", Boolean.FALSE);
        r11.put("block_view_extra_align_start", Boolean.TRUE);
        r11.put("block_view_outer_block_status", Boolean.valueOf(il8.b.a(r14)));
        Unit r110 = Unit.INSTANCE;
        r3.a(r10, r11);
        goto L50
    L48:
        r20 = 0;
    L50:
        n2 r111 = this.d;
        if (r111 == null) goto L58;
        Integer r21 = 0;
        j2 r112 = r111.n;
        if (r112 == null) goto L58;
        if (r21 == null) goto L56;
        int r22 = r21.intValue();
    L57:
        r112.setPadding(r22, i5.m(), 0, 0);
        goto L58
    L56:
        r22 = i5.Q();
    L58:
        n2 r113 = this.d;
        if (r113 == null) goto L70;
        if (r0 == null) goto L64;
        kc8.p r23 = r0.e;
        if (r23 == null) goto L64;
        r1 = Integer.valueOf(r23.a);
    L64:
        if (r1 == null) goto L72;
        DeepThinkCommonToolHeader r114 = r113.getToolHeader();
        if (r114 == null) goto L71;
        r114.setBackgroundResource(r1.intValue());
        return;
    L71:
        return;
    L72:
        return;
    L70:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        n2 r0 = new n2(r2.getContext());
        this.d = r0;
        return r0;
    }
}
