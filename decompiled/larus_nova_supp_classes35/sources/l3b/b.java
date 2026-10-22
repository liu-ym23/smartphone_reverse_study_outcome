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
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble.IBubbleBodyBgStyleProvider;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Layouts;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MsgBubbleUtil;
import com.ss.android.lark.chat.utils.f0;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a implements l3b.a {
    public final c m;
    public final List<Integer> n;
    public IBubbleBodyBgStyleProvider.Style o;

    public static final class a implements wza.d<y6b.a<?>> {
        public final c a;
        public final IMMessageKeys$Layouts b;

        public u getType() {
            return this.b;
        }

        public a(c r1) {
            this.a = r1;
            this.b = IMMessageKeys$Layouts.BUBBLE_OPEN_CELL;
        }

        public final q a(g r4, BlueprintCell r5) {
            Intrinsics.checkNotNullParameter(r4, "ctx");
            Intrinsics.checkNotNullParameter(r5, "cell");
            return new b(r4, r5, false, this.a);
        }
    }

    /* JADX INFO: renamed from: l3b.b$b, reason: collision with other inner class name */
    public static final class C0250b implements wza.d<y6b.a<?>> {
        public final c a;
        public final IMMessageKeys$Layouts b;

        public u getType() {
            return this.b;
        }

        public C0250b(c r1) {
            this.a = r1;
            this.b = IMMessageKeys$Layouts.RTL_BUBBLE_OPEN_CELL;
        }

        public final q a(g r4, BlueprintCell r5) {
            Intrinsics.checkNotNullParameter(r4, "ctx");
            Intrinsics.checkNotNullParameter(r5, "cell");
            return new b(r4, r5, true, this.a);
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final void B(LKUIRoundLinearLayout r2, y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "bodyLayout");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys$Slots.HEADER, 2131364920), TuplesKt.to(IMMessageKeys$Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys$Slots.FOOTER, 2131364918)});
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

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble.IBubbleBodyBgStyleProvider
    public final IBubbleBodyBgStyleProvider.Style m() {
        return this.o;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final void A(y6b.a<?> r14) {
        Intrinsics.checkNotNullParameter(r14, Keys.API_RETURN_KEY_DATA);
        super.A(r14);
        BubbleStyle r0 = p();
        if (r0 == null) goto L45;
        LKUIRoundLinearLayout r9 = this.k;
        if (r9 == null) goto L45;
        IMMessageKeys$Slots r10 = IMMessageKeys$Slots.FOOTER;
        ViewGroup r3 = s(r10);
        if (r3 == null) goto L45;
        boolean r4 = r0.g;
        ViewGroup r5 = s(IMMessageKeys$Slots.CONTENT);
        if (r5 == null) goto L13;
        d.d(r5, r4);
    L13:
        d.d(r9, r4);
        int[] r6 = r0.a;
        int r7 = r6[0];
        int r8 = r6[1];
        int r11 = r6[2];
        if (com.ss.android.lark.blueprint.a.w(r3) <= 0) goto L16;
        int r12 = 0;
    L17:
        r9.setPadding(r7, r8, r11, r12);
        int r13 = r0.e;
        View r15 = r0.b.get();
        int r16 = r14.getGroupType();
        int r17 = r0.c;
        if (r17 == (-1)) goto L20;
    L22:
        int[] r18 = {r17, r0.d};
    L23:
        MsgBubbleUtil.c(r9, r13, r15, r16, r18, f0.c(r14));
        if (this.n.contains(Integer.valueOf(r0.e)) == false) goto L26;
        IBubbleBodyBgStyleProvider.Style r19 = IBubbleBodyBgStyleProvider.Style.Normal;
    L27:
        this.o = r19;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a.C(this, r9, r14);
        ViewGroup r20 = s(r10);
        if (r20 == null) goto L45;
        if (r20.getVisibility() != 0) goto L45;
        int[] r1 = r0.a;
        if (r1[0] != 0) goto L36;
    L39:
        int r2 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f);
    L41:
        if (r14.getType() != Message.Type.RED_PACKET) goto L43;
        int r21 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 8.0f);
    L44:
        r20.setPadding(r2, r21, r2, r20.getPaddingBottom());
        goto L45
    L43:
        r21 = r20.getPaddingTop();
        goto L44
    L36:
        if (r1[2] == 0) goto L39;
        r2 = 0;
        goto L41
    L26:
        r19 = IBubbleBodyBgStyleProvider.Style.Clean;
        goto L27
    L20:
        if (r0.d != (-1)) goto L22;
        r18 = null;
        goto L23
    L16:
        r12 = r0.a[3];
    L45:
        ViewGroup r22 = s(IMMessageKeys$Slots.HEADER);
        if (r22 != null) goto L48;
        return;
    L48:
        if (d.e(r14) == false) goto L50;
        r22.setPadding(r22.getPaddingLeft(), r22.getPaddingTop(), r22.getPaddingRight(), 0);
        return;
    L50:
        r22.setPadding(r22.getPaddingLeft(), r22.getPaddingTop(), r22.getPaddingRight(), UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final /* bridge */ /* synthetic */ void l(Object r1) {
        A((y6b.a) r1);
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

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a
    public final LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131559305, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        return r5;
    }

    public b(g r2, BlueprintCell r3, boolean r4, c r5) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
        this.m = r5;
        this.n = CollectionsKt.listOf(new Integer[]{0, 3, 8, 101});
        this.o = IBubbleBodyBgStyleProvider.Style.Normal;
    }
}
