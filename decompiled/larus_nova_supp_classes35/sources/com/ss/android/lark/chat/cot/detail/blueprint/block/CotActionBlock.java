package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.content.Context;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotActionBlock extends com.ss.android.lark.chat.cot.detail.blueprint.block.a {
    public final com.ss.android.lark.chat.cot.a c;
    public final com.ss.android.lark.chat.cot.detail.blueprint.b.a d;

    public static final class a implements k<View> {
        public final View a;
        public final TextView b;
        public final TextView c;
        public final MarkdownMovableView d;
        public final c e;
        public final MarkdownMovableView f;
        public final c g;

        public final View getView() {
            return this.a;
        }

        public a(View r5, com.ss.android.lark.chat.cot.a r6) {
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "cotFeatureGate");
            this.a = r5;
            this.b = (TextView) r5.findViewById(2131367975);
            this.c = (TextView) r5.findViewById(2131367974);
            CotMovableSetup r0 = CotMovableSetup.a;
            r0.getClass();
            c r2 = null;
            if (CotMovableSetup.a(r6) == false) goto L5;
            MarkdownMovableView r1 = (MarkdownMovableView) r5.findViewById(2131367976);
        L6:
            this.d = r1;
            if (r1 == null) goto L9;
            c r3 = CotMovableSetup.d(r0, r1, null, 6);
        L10:
            this.e = r3;
            if (CotMovableSetup.a(r6) == false) goto L13;
            MarkdownMovableView r7 = (MarkdownMovableView) r5.findViewById(2131367973);
        L14:
            this.f = r7;
            if (r7 == null) goto L17;
            r2 = CotMovableSetup.d(r0, r7, null, 6);
        L17:
            this.g = r2;
            return;
        L13:
            r7 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }
    }

    public final j getKey() {
        return this.d;
    }

    public static String f(String r9) {
        List r10 = SequencesKt.toList(SequencesKt.dropWhile(StringsKt.lineSequence(r9), CotActionBlock$filterBlankLines$1.INSTANCE));
        if (r10.isEmpty() == true) goto L10;
        ListIterator r0 = r10.listIterator(r10.size());
    L6:
        if (r0.hasPrevious() == false) goto L10;
        if (StringsKt.isBlank((String) r0.previous()) == true) goto L6;
        List r11 = CollectionsKt.take(r10, r0.nextIndex() + 1);
    L11:
        ArrayList r1 = new ArrayList();
        Iterator r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L18;
        Object r2 = r12.next();
        if ((!StringsKt.isBlank((String) r2)) == false) goto L13;
        r1.add(r2);
        goto L13
    L18:
        return CollectionsKt.joinToString$default(r1, "\n", null, null, 0, null, null, 62, null);
    L10:
        r11 = CollectionsKt.emptyList();
        goto L11
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public final void d(k<?> r2) {
        if ((r2 instanceof a) == false) goto L5;
        a r3 = (a) r2;
    L6:
        if (r3 == null) goto L14;
        c r0 = r3.e;
        if (r0 == null) goto L10;
        r0.b();
    L10:
        c r4 = r3.g;
        if (r4 == null) goto L15;
        r4.b();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public CotActionBlock(g r2, com.ss.android.lark.chat.cot.a r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cotFeatureGate");
        super(r2);
        this.c = r3;
        this.d = com.ss.android.lark.chat.cot.detail.blueprint.b.d;
    }

    public void update(m<com.ss.android.lark.chat.cot.detail.k> r7, q<com.ss.android.lark.chat.cot.detail.k> r8, com.ss.android.lark.chat.cot.detail.k r9) {
        Intrinsics.checkNotNullParameter(r7, "cell");
        Intrinsics.checkNotNullParameter(r8, "layout");
        Intrinsics.checkNotNullParameter(r9, Keys.API_RETURN_KEY_DATA);
        a r10 = (a) r8.c(this.d, this.b, new CotActionBlock$update$$inlined$acquireBlockView$1(this));
        Context r11 = r10.a.getContext();
        String r0 = r9.c;
        boolean r1 = true;
        int r2 = 0;
        String r3 = null;
        if (r0 == null) goto L14;
        String r4 = f(r0);
        if (r4 == null) goto L14;
        if (r4.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L14;
    L15:
        MarkdownMovableView r12 = r10.d;
        if (r12 != null) goto L18;
    L25:
        MarkdownMovableView r13 = r10.d;
        if (r13 == null) goto L28;
        r13.setVisibility(8);
    L28:
        r10.b.setText(r4);
        TextView r14 = r10.b;
        if (r4.length() != 0) goto L31;
        boolean r6 = true;
    L32:
        if (r6 == false) goto L34;
        int r15 = 8;
    L35:
        r14.setVisibility(r15);
        c r16 = r10.e;
        if (r16 == null) goto L38;
        r16.a();
    L38:
        CharSequence r17 = r9.d;
        if (r17 == null) goto L50;
        String r18 = r17.toString();
        if (r18 == null) goto L50;
        String r19 = f(r18);
        if (r19 == null) goto L50;
        if (r19.length() <= 0) goto L47;
        boolean r20 = true;
    L48:
        if (r20 == false) goto L50;
        r3 = r19;
        goto L50
    L47:
        r20 = false;
    L50:
        if (r3 != null) goto L52;
        r3 = BuildConfig.FLAVOR;
    L52:
        MarkdownMovableView r21 = r10.f;
        if (r21 != null) goto L55;
    L62:
        MarkdownMovableView r22 = r10.f;
        if (r22 == null) goto L65;
        r22.setVisibility(8);
    L65:
        r10.c.setText(r3);
        TextView r23 = r10.c;
        if (r3.length() == 0) goto L69;
        r1 = false;
    L69:
        if (r1 == false) goto L71;
        r2 = 8;
    L71:
        r23.setVisibility(r2);
        c r24 = r10.g;
        if (r24 == null) goto L74;
        r24.a();
    L74:
        e(r10.a, r9);
        e(r10.d, r9);
        e(r10.b, r9);
        return;
    L55:
        if (r3.length() <= 0) goto L57;
        boolean r25 = true;
    L58:
        if (r25 == false) goto L62;
        r10.c.setVisibility(8);
        r21.setVisibility(0);
        CotMovableSetup.a.getClass();
        float r26 = CotMovableSetup.c(r21);
        c r27 = r10.g;
        if (r27 == null) goto L74;
        r27.c(r3, r26);
        goto L74
    L57:
        r25 = false;
        goto L58
    L34:
        r15 = 0;
        goto L35
    L31:
        r6 = false;
        goto L32
    L18:
        if (r4.length() <= 0) goto L20;
        boolean r28 = true;
    L21:
        if (r28 == false) goto L25;
        r10.b.setVisibility(8);
        r12.setVisibility(0);
        CotMovableSetup.a.getClass();
        float r29 = CotMovableSetup.c(r12);
        c r30 = r10.e;
        if (r30 == null) goto L38;
        r30.c(r4, r29);
        goto L38
    L20:
        r28 = false;
        goto L21
    L9:
        r5 = false;
    L14:
        r4 = r11.getString(2131890941);
        goto L15
    }

    @Override // com.ss.android.lark.chat.cot.detail.blueprint.block.a
    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (com.ss.android.lark.chat.cot.detail.k) r3);
    }
}
