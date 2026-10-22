package com.ss.android.lark.flow.chat.message.layout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.s;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b extends com.ss.android.lark.flow.chat.message.layout.a {

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.BUBBLE;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new b(r3, r4, false);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.layout.b$b, reason: collision with other inner class name */
    public static final class C0027b implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public C0027b() {
            this.a = IMMessageKeys.Layouts.RTL_BUBBLE;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new b(r3, r4, true);
        }
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys.Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys.Slots.HEADER, 2131364916), TuplesKt.to(IMMessageKeys.Slots.FOOTER, 2131364916)});
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131559304, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        return r5;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public void B(LKUIRoundLinearLayout r4, y6b.a<?> r5) {
        Intrinsics.checkNotNullParameter(r4, "bodyLayout");
        Intrinsics.checkNotNullParameter(r5, "data");
        C(r4, r5, 12.0f);
        s r1 = x().d0(s.class);
        int r6 = p3b.a.b(r5.h());
        if (r1 == null) goto L7;
        Integer r2 = r1.a;
        if (r2 == null) goto L7;
        int r7 = r2.intValue();
        r6 = UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), r7);
    L7:
        r4.setBackgroundColor(r6);
        int r8 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 12.0f);
        int r0 = UIUtils.dp2px(((com.ss.android.lark.blueprint.a) this).a.getContext(), 8.0f);
        r4.setPadding(r8, r0, r8, r0);
    }

    public b(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
    }
}
