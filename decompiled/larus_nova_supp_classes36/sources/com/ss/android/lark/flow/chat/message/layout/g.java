package com.ss.android.lark.flow.chat.message.layout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.r;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class g extends com.ss.android.lark.flow.chat.message.layout.b {

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.BUBBLE_NESTED;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new g(r3, r4, false);
        }
    }

    public static final class b implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public b() {
            this.a = IMMessageKeys.Layouts.RTL_BUBBLE_NESTED;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new g(r3, r4, true);
        }
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys.Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys.Slots.HEADER, 2131364920), TuplesKt.to(IMMessageKeys.Slots.FOOTER, 2131364913)});
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public void v() {
        LKUIRoundLinearLayout r0 = s(IMMessageKeys.Slots.CONTENT);
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof LKUIRoundLinearLayout) == false) goto L5;
        LKUIRoundLinearLayout r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setBackgroundColor(UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131100557));
        r1.setBorderColor(UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131103351));
        r1.setBorderWidth(1.0f);
        r1.setPadding(0);
        r1.setRadius(10.0f);
        r r3 = x().d0(r.class);
        if (r3 == null) goto L11;
        float r4 = r3.a;
    L12:
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        r2 = (ViewGroup.MarginLayoutParams) r5;
    L15:
        if (r2 == null) goto L17;
        r2.topMargin = UIHelper.dp2px(r4);
    L17:
        if (r2 == null) goto L20;
        r2.bottomMargin = UIHelper.dp2px(r4);
        return;
    L20:
        return;
    L11:
        r4 = 0.0f;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131559302, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        return r5;
    }

    public g(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
    }
}
