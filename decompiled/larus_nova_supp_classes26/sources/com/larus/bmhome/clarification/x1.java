package com.larus.bmhome.clarification;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.input.swipe.InputContentMode;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import com.larus.im.bean.message.block.InteractionAskQuestionCapability;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x1 implements ze8.a {
    public final e2 a;
    public final Function0<Unit> b;
    public final Function2<Integer, InteractionAskOption, Unit> c;
    public final Function1<Integer, Unit> d;
    public final Function1<Integer, BaseResourceViewHolder.a> e;
    public final Function1<Integer, Integer> f;

    public static final class a extends FrameLayout {
        public hk9.a a;

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }
    }

    public final int getPageCount() {
        d2 r0 = this.a.a;
        if (r0 == null) goto L7;
        List<InteractionAskQuestion> r1 = r0.h;
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    public final a b(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        a r0 = new a(r6.getContext());
        int r1 = ra8.a.a;
        hk9.a r7 = ra8.a.a(r6.getContext());
        Intrinsics.checkNotNullParameter(r7, "blockContainer");
        if (r0.a == r7) goto L6;
        r0.removeAllViews();
        r0.a = r7;
        r0.addView(r7, new FrameLayout.LayoutParams(-1, -2, 80));
    L6:
        return r0;
    }

    public final ze8.d c(int r19) {
        d2 r2 = this.a.a;
        InputContentMode r3 = null;
        if (r2 == null) goto L7;
        List<z1> r4 = r2.l;
        if (r4 == null) goto L7;
        z1 r5 = (z1) CollectionsKt.getOrNull(r4, r19);
    L8:
        if (r2 == null) goto L12;
        List<InteractionAskQuestion> r6 = r2.h;
        if (r6 == null) goto L12;
        InteractionAskQuestion r7 = (InteractionAskQuestion) CollectionsKt.getOrNull(r6, r19);
    L13:
        if (r7 == null) goto L17;
        InteractionAskQuestionCapability r8 = r7.getQuestionCapability();
        if (r8 == null) goto L17;
        String r9 = r8.getTextPlaceholder();
    L18:
        if (r7 == null) goto L22;
        InteractionAskQuestionCapability r10 = r7.getQuestionCapability();
        if (r10 == null) goto L22;
        boolean r11 = Intrinsics.areEqual(r10.getAllowText(), Boolean.TRUE);
    L23:
        if (r5 == null) goto L27;
        i r12 = r5.l;
        if (r12 == null) goto L27;
        String r13 = r12.b;
    L28:
        String r14 = "";
        if (r13 != null) goto L31;
        String r15 = "";
    L32:
        if (r7 == null) goto L34;
        String r16 = r7.getQuestionId();
    L35:
        if (r16 == null) goto L39;
        r14 = r16;
    L39:
        if (StringsKt.isBlank(r14) == false) goto L41;
        String r17 = "clarification_input_" + r19;
    L42:
        if (r11 == false) goto L44;
        String r18 = r9;
    L45:
        if (r5 == null) goto L47;
        int r20 = r5.e;
    L48:
        int r110 = r20;
        if (r5 == null) goto L51;
        int r21 = r5.f;
    L52:
        int r111 = r21;
        Integer r112 = (Integer) this.f.invoke(Integer.valueOf(r19));
        if (r5 == null) goto L55;
        ze8.c r113 = y1.a(r5, null);
    L56:
        if (r5 == null) goto L63;
        if (r5.g == false) goto L60;
        InputContentMode r1 = InputContentMode.SPEAK;
    L61:
        r3 = r1;
        goto L63
    L60:
        r1 = InputContentMode.TEXT;
    L63:
        return new ze8.d(r17, r15, r18, r110, r111, r112, r113, r3);
    L55:
        r113 = null;
        goto L56
    L51:
        r21 = r15.length();
        goto L52
    L47:
        r20 = r15.length();
        goto L48
    L44:
        r18 = null;
        goto L45
    L41:
        r17 = r14;
        goto L42
    L34:
        r16 = null;
        goto L35
    L31:
        r15 = r13;
    L27:
        r13 = null;
    L22:
        r11 = false;
    L17:
        r9 = null;
    L12:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    public final void onPageSelected(int r2) {
        this.d.invoke(Integer.valueOf(r2));
    }

    public final void a(View r26, int r27) {
        Intrinsics.checkNotNullParameter(r26, "page");
        d2 r12 = this.a.a;
        if (r12 != null) goto L6;
        return;
    L6:
        if ((r26 instanceof a) == false) goto L8;
        a r1 = (a) r26;
    L9:
        if (r1 == null) goto L22;
        final hk9.a r13 = r1.a;
        if (r13 == null) goto L23;
        z1 r2 = (z1) CollectionsKt.getOrNull(r12.l, r27);
        if (r2 != null) goto L16;
        return;
    L16:
        i r3 = r2.l;
        List<String> r4 = r3.a;
        String r5 = r3.b;
        boolean r6 = r2.i;
        int r7 = r2.j;
        List<ResourceItemBean> r8 = r2.k;
        Function0<Unit> r9 = this.b;
        Function2<Integer, InteractionAskOption, Unit> r10 = this.c;
        Function1<Integer, BaseResourceViewHolder.a> r11 = this.e;
        if (r11 == null) goto L19;
        BaseResourceViewHolder.a r16 = (BaseResourceViewHolder.a) r11.invoke(Integer.valueOf(r27));
    L20:
        r13.b(u.class, new u(r27, r4, r5, r6, r7, r8, r9, r10, r16));
        this.a.d(r27, new w1(r13));
        int r14 = ra8.a.a;
        ra8.a.d(r13, CollectionsKt.listOf(Block.copy$default(r12.g, 0, null, null, null, false, null, null, null, 251, null)), new kc8.f(r12.f, Boolean.TRUE, false, false, null, "input_supplement", 476), true);
        return;
    L19:
        r16 = null;
        goto L20
    L23:
        return;
    L22:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public x1(e2 r2, i0 r3, t0 r4, e1 r5, j1 r6, k1 r7) {
        Intrinsics.checkNotNullParameter(r2, "stateStore");
        Intrinsics.checkNotNullParameter(r3, "onCloseClick");
        Intrinsics.checkNotNullParameter(r4, "onOptionClick");
        Intrinsics.checkNotNullParameter(r5, "onPageSelected");
        Intrinsics.checkNotNullParameter(r7, "sendButtonImageResId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
