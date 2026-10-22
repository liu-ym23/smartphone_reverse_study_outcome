package l3b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.h;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Layouts;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MsgBubbleUtil;
import com.ss.android.lark.chat.utils.f0;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends h implements l3b.a {
    public final c m;
    public LKUIRoundLinearLayout n;

    public static final class a implements wza.d<y6b.a<?>> {
        public final c a;
        public final IMMessageKeys$Layouts b;

        public u getType() {
            return this.b;
        }

        public a(c r1) {
            this.a = r1;
            this.b = IMMessageKeys$Layouts.BUBBLE_OPEN_CELL_NESTED;
        }

        public final q a(g r4, BlueprintCell r5) {
            Intrinsics.checkNotNullParameter(r4, "ctx");
            Intrinsics.checkNotNullParameter(r5, "cell");
            return new e(r4, r5, false, this.a);
        }
    }

    public static final class b implements wza.d<y6b.a<?>> {
        public final c a;
        public final IMMessageKeys$Layouts b;

        public u getType() {
            return this.b;
        }

        public b(c r1) {
            this.a = r1;
            this.b = IMMessageKeys$Layouts.RTL_BUBBLE_OPEN_CELL_NESTED;
        }

        public final q a(g r4, BlueprintCell r5) {
            Intrinsics.checkNotNullParameter(r4, "ctx");
            Intrinsics.checkNotNullParameter(r5, "cell");
            return new e(r4, r5, true, this.a);
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.h, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys$Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys$Slots.HEADER, 2131364920), TuplesKt.to(IMMessageKeys$Slots.FOOTER, 2131364913)});
    }

    @Override // l3b.a
    public final u5b.c j() {
        ViewGroup r0 = s(IMMessageKeys$Slots.CONTENT);
        if (r0 != null) goto L7;
        return null;
    L7:
        return d.c(r0);
    }

    @Override // l3b.a
    public final BubbleStyle p() {
        ViewGroup r0 = s(IMMessageKeys$Slots.CONTENT);
        if (r0 != null) goto L7;
        return null;
    L7:
        return d.a(r0);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final void A(y6b.a<?> r12) {
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_DATA);
        super.A(r12);
        BubbleStyle r0 = p();
        if (r0 == null) goto L30;
        LKUIRoundLinearLayout r2 = this.k;
        if (r2 == null) goto L30;
        LKUIRoundLinearLayout r3 = this.n;
        if (r3 == null) goto L30;
        IMMessageKeys$Slots r4 = IMMessageKeys$Slots.CONTENT;
        ViewGroup r5 = s(r4);
        if (r5 == null) goto L30;
        if (r12.getType() != Message.Type.RED_PACKET) goto L16;
        r0.b();
    L16:
        boolean r6 = r0.g;
        ViewGroup r7 = s(r4);
        if (r7 == null) goto L19;
        d.d(r7, r6);
    L19:
        d.d(r2, r6);
        d.d(r3, r6);
        int[] r8 = r0.a;
        r5.setPadding(r8[0], r8[1], r8[2], r8[3]);
        if (d.e(r12) == false) goto L22;
        r3.setRadius(0.0f);
    L23:
        int r9 = r0.e;
        View r10 = r0.b.get();
        int r11 = r12.getGroupType();
        int r13 = r0.c;
        if (r13 == (-1)) goto L26;
    L28:
        int[] r14 = {r13, r0.d};
    L29:
        MsgBubbleUtil.c(r3, r9, r10, r11, r14, f0.c(r12));
        goto L30
    L26:
        if (r0.d != (-1)) goto L28;
        r14 = null;
        goto L29
    L22:
        r3.setRadius(10.0f);
    L30:
        ViewGroup r1 = s(IMMessageKeys$Slots.HEADER);
        if (r1 != null) goto L33;
        return;
    L33:
        if (d.e(r12) == false) goto L35;
        r1.setPadding(0, 0, r1.getPaddingRight(), r1.getPaddingBottom());
        return;
    L35:
        int r15 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f);
        r1.setPadding(r15, r15, r1.getPaddingRight(), r1.getPaddingBottom());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final View u(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r4 = super.u(r3);
        c r0 = this.m;
        if (r0 == null) goto L5;
        r0.a(r4, this.f);
    L5:
        return r4;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.h, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131559303, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        LKUIRoundLinearLayout r6 = r5;
        this.n = r6.findViewById(2131364919);
        return r6;
    }

    public e(g r2, BlueprintCell r3, boolean r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
        this.m = r5;
    }
}
