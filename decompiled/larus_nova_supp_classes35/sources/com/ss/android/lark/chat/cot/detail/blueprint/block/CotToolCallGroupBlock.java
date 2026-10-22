package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.chat.cot.detail.s;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotToolCallGroupBlock extends com.ss.android.lark.chat.cot.detail.blueprint.block.a {
    public final Function1<String, Unit> c;
    public final com.ss.android.lark.chat.cot.detail.blueprint.b.C0089b d;

    public static final class a {
    }

    public static final class b implements k<View> {
        public final View a;

        public final View getView() {
            return this.a;
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }
    }

    static {
    }

    public final j getKey() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CotToolCallGroupBlock(g r2, Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "onGroupToggle");
        super(r2);
        this.c = r3;
        this.d = com.ss.android.lark.chat.cot.detail.blueprint.b.b;
    }

    public void update(m<com.ss.android.lark.chat.cot.detail.k> r10, q<com.ss.android.lark.chat.cot.detail.k> r11, final com.ss.android.lark.chat.cot.detail.k r12) {
        Intrinsics.checkNotNullParameter(r10, "cell");
        Intrinsics.checkNotNullParameter(r11, "layout");
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
        b r13 = (b) r11.c(this.d, this.b, new CotToolCallGroupBlock$update$$inlined$acquireBlockView$1());
        com.ss.android.lark.chat.cot.detail.b r14 = r12.g;
        s r1 = null;
        if ((r14 instanceof s) == false) goto L5;
        s r15 = (s) r14;
    L7:
        if (r12.b != CotDetailBlockType.GROUP) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        r1 = r15;
    L12:
        View r16 = r13.a;
        if (r1 == null) goto L15;
        int r2 = r1.a;
    L16:
        if (r1 != null) goto L18;
    L20:
        final boolean r3 = false;
    L21:
        Function0<Unit> r4 = new AnonymousClass1(this, r12);
        Intrinsics.checkNotNullParameter(r16, "root");
        Intrinsics.checkNotNullParameter(r4, "onClick");
        TextView r5 = (TextView) r16.findViewById(2131368000);
        ImageView r6 = (ImageView) r16.findViewById(2131367999);
        String r7 = r16.getResources().getQuantityString(2131755058, r2, new Object[]{Integer.valueOf(r2)});
        r5.setText(r7);
        if (r3 == false) goto L24;
        int r8 = 2131254267;
    L25:
        r6.setImageResource(r8);
        r16.setContentDescription(r7);
        r16.setSelected(r3);
        r16.setOnClickListener(new f(r4));
        ViewCompat.setAccessibilityDelegate(r16, new CotToolCallGroupBlock$Companion$bindGroupView$2(r3));
        e(r13.a, r12);
        return;
    L24:
        r8 = 2131255567;
        goto L25
    L18:
        if (r1.b != true) goto L20;
        r3 = true;
        goto L21
    L15:
        r2 = 0;
        goto L16
    L9:
        r0 = false;
        goto L10
    L5:
        r15 = null;
        goto L7
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (com.ss.android.lark.chat.cot.detail.k) r3);
    }
}
