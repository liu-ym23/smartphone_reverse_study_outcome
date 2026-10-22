package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.movable.MarkdownMovableView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotThinkingBlock extends com.ss.android.lark.chat.cot.detail.blueprint.block.a {
    public final com.ss.android.lark.chat.cot.a c;
    public final com.ss.android.lark.chat.cot.detail.blueprint.b.d d;

    public static final class a implements k<View> {
        public final View a;
        public final TextView b;
        public final MarkdownMovableView c;
        public final c d;

        public final View getView() {
            return this.a;
        }

        public a(View r3, com.ss.android.lark.chat.cot.a r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "cotFeatureGate");
            this.a = r3;
            this.b = (TextView) r3.findViewById(2131367995);
            CotMovableSetup r0 = CotMovableSetup.a;
            r0.getClass();
            c r1 = null;
            if (CotMovableSetup.a(r4) == false) goto L5;
            MarkdownMovableView r5 = (MarkdownMovableView) r3.findViewById(2131367996);
        L6:
            this.c = r5;
            if (r5 == null) goto L9;
            r1 = CotMovableSetup.d(r0, r5, null, 6);
        L9:
            this.d = r1;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public final j getKey() {
        return this.d;
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public final void d(k<?> r2) {
        if ((r2 instanceof a) == false) goto L5;
        a r3 = (a) r2;
    L6:
        if (r3 == null) goto L11;
        c r4 = r3.d;
        if (r4 == null) goto L12;
        r4.b();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public CotThinkingBlock(g r2, com.ss.android.lark.chat.cot.a r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cotFeatureGate");
        super(r2);
        this.c = r3;
        this.d = com.ss.android.lark.chat.cot.detail.blueprint.b.a;
    }

    public void update(m<com.ss.android.lark.chat.cot.detail.k> r6, q<com.ss.android.lark.chat.cot.detail.k> r7, com.ss.android.lark.chat.cot.detail.k r8) {
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "layout");
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        a r9 = (a) r7.c(this.d, this.b, new CotThinkingBlock$update$$inlined$acquireBlockView$1(this));
        CharSequence r10 = r8.d;
        if (r10 == null) goto L5;
        String r11 = r10.toString();
    L6:
        if (r11 != null) goto L8;
        r11 = BuildConfig.FLAVOR;
    L8:
        MarkdownMovableView r0 = r9.c;
        int r1 = 8;
        boolean r2 = true;
        if (r0 != null) goto L11;
    L18:
        MarkdownMovableView r3 = r9.c;
        if (r3 == null) goto L21;
        r3.setVisibility(8);
    L21:
        r9.b.setText(r11);
        TextView r4 = r9.b;
        if (r11.length() == 0) goto L25;
        r2 = false;
    L25:
        if (r2 == true) goto L28;
        r1 = 0;
    L28:
        r4.setVisibility(r1);
        c r12 = r9.d;
        if (r12 == null) goto L31;
        r12.a();
    L31:
        e(r9.a, r8);
        e(r9.c, r8);
        e(r9.b, r8);
        return;
    L11:
        if (r11.length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L18;
        r9.b.setVisibility(8);
        r0.setVisibility(0);
        CotMovableSetup.a.getClass();
        float r13 = CotMovableSetup.c(r0);
        c r14 = r9.d;
        if (r14 == null) goto L31;
        r14.c(r11, r13);
        goto L31
    L13:
        r5 = false;
        goto L14
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (com.ss.android.lark.chat.cot.detail.k) r3);
    }
}
