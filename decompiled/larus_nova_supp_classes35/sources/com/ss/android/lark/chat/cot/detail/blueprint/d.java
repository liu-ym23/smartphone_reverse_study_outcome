package com.ss.android.lark.chat.cot.detail.blueprint;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.chat.cot.detail.k;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends com.ss.android.lark.blueprint.a<k> {
    public final boolean f;
    public ImageView g;
    public FrameLayout h;
    public final Map<v, Integer> i;

    public static final class a {
    }

    public static final class b implements wza.d<k> {
        public final boolean a;
        public final CotDetailCellKeys$Layouts b;

        public u getType() {
            return this.b;
        }

        public b(boolean r1) {
            this.a = r1;
            this.b = CotDetailCellKeys$Layouts.SINGLE;
        }

        public final q a(g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new d(r3, r4, this.a);
        }
    }

    static {
    }

    public final Map<v, Integer> t() {
        return this.i;
    }

    public final View u(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        Context r10 = r9.getContext();
        FrameLayout r0 = new FrameLayout(r10);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNull(r10);
        int r1 = (int) h18.d.a(r10, 16.0f);
        int r4 = (int) h18.d.a(r10, 0.0f);
        int r5 = (int) h18.d.a(r10, 5.0f);
        ImageView r6 = new ImageView(r10);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(r1, r1);
        r7.leftMargin = r4;
        r7.topMargin = r5;
        r6.setLayoutParams(r7);
        r0.addView(r6);
        this.g = r6;
        int r2 = (int) h18.d.a(r10, 24.0f);
        FrameLayout r8 = new FrameLayout(r10);
        r8.setId(2131367978);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -2);
        r11.leftMargin = r2;
        r8.setLayoutParams(r11);
        r0.addView(r8);
        this.h = r8;
        return r0;
    }

    public void update(k r14) {
        Intrinsics.checkNotNullParameter(r14, Keys.API_RETURN_KEY_DATA);
        ImageView r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        FrameLayout r1 = this.h;
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r2 = this.f;
        com.ss.android.lark.chat.cot.detail.widget.a r4 = com.ss.android.lark.chat.cot.detail.widget.a.a;
        CotDetailItemLayout$Companion$bindItemChrome$1 r3 = new CotDetailItemLayout$Companion$bindItemChrome$1(r4);
        CotDetailItemLayout$Companion$bindItemChrome$2 r5 = new CotDetailItemLayout$Companion$bindItemChrome$2(r4);
        Intrinsics.checkNotNullParameter(r0, "markerView");
        Intrinsics.checkNotNullParameter(r1, "contentSlot");
        Intrinsics.checkNotNullParameter(r14, "item");
        Intrinsics.checkNotNullParameter(r3, "bindMarker");
        Intrinsics.checkNotNullParameter(r5, "clearMarker");
        boolean r6 = true;
        int r7 = 0;
        FrameLayout.LayoutParams r8 = null;
        if (r2 == false) goto L22;
        CotDetailBlockType r9 = r14.b;
        if (r9 == CotDetailBlockType.GROUP) goto L22;
        if (r9 != CotDetailBlockType.TOOLCALL) goto L21;
        Context r10 = r0.getContext();
        com.ss.android.lark.chat.cot.detail.u r11 = r14.c();
        if (r11 == null) goto L17;
        com.ss.android.lark.chat.cot.c r12 = r11.a;
    L18:
        r4.getClass();
        if (com.ss.android.lark.chat.cot.detail.widget.a.h(r10, r12) == false) goto L21;
    L17:
        r12 = null;
    L21:
        boolean r13 = false;
    L23:
        if (r13 == false) goto L25;
        int r15 = 0;
    L26:
        r0.setVisibility(r15);
        if (r13 == false) goto L48;
        CotDetailBlockType r16 = r14.b;
        ViewGroup.LayoutParams r17 = r0.getLayoutParams();
        if ((r17 instanceof FrameLayout.LayoutParams) == false) goto L31;
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) r17;
    L32:
        if (r18 == null) goto L47;
        Intrinsics.checkNotNullParameter(r16, "blockType");
        CotDetailBlockType r19 = CotDetailBlockType.GROUP;
        if (r16 != r19) goto L37;
        int r110 = 16;
    L38:
        Context r111 = r0.getContext();
        Intrinsics.checkNotNullParameter(r16, "blockType");
        if (r16 != r19) goto L41;
        float r20 = 0.0f;
    L42:
        int r21 = (int) h18.d.a(r111, r20);
        if (r18.gravity == r110) goto L45;
    L46:
        r18.gravity = r110;
        r18.topMargin = r21;
        r0.setLayoutParams(r18);
        goto L47
    L45:
        if (r18.topMargin == r21) goto L47;
    L41:
        r20 = 5.0f;
        goto L42
    L37:
        r110 = 48;
    L47:
        r3.invoke(r0, r14, Boolean.valueOf(r2));
    L49:
        ViewGroup.LayoutParams r22 = r1.getLayoutParams();
        if ((r22 instanceof FrameLayout.LayoutParams) == false) goto L52;
        r8 = (FrameLayout.LayoutParams) r22;
    L52:
        if (r8 == null) goto L66;
        if (r2 == true) goto L56;
    L59:
        if (r6 == false) goto L62;
        r7 = (int) h18.d.a(r1.getContext(), 24.0f);
    L62:
        if (r8.leftMargin == r7) goto L65;
        r8.leftMargin = r7;
        r1.setLayoutParams(r8);
        return;
    L65:
        return;
    L56:
        if (r14.b == CotDetailBlockType.GROUP) goto L59;
        r6 = false;
        goto L59
    L66:
        return;
    L31:
        r18 = null;
        goto L32
    L48:
        r5.invoke(r0);
        goto L49
    L25:
        r15 = 8;
    L22:
        r13 = true;
        goto L23
    }

    public /* bridge */ /* synthetic */ void update(Object r1) {
        update((k) r1);
    }

    public d(g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3);
        this.f = r4;
        this.i = MapsKt.mapOf(TuplesKt.to(CotDetailCellKeys$Slots.CONTENT, 2131367978));
    }
}
