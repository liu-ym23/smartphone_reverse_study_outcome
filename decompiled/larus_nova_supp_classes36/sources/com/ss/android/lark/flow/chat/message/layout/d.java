package com.ss.android.lark.flow.chat.message.layout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble.IBubbleBodyBgStyleProvider;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends com.ss.android.lark.flow.chat.message.layout.b {
    public final boolean n;

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.BUBBLE_CLEAN;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r8, BlueprintCell r9) {
            Intrinsics.checkNotNullParameter(r8, "ctx");
            Intrinsics.checkNotNullParameter(r9, "cell");
            return new d(r8, r9, false, false, 12);
        }
    }

    public static final class b implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public b() {
            this.a = IMMessageKeys.Layouts.RTL_BUBBLE_CLEAN;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r8, BlueprintCell r9) {
            Intrinsics.checkNotNullParameter(r8, "ctx");
            Intrinsics.checkNotNullParameter(r9, "cell");
            return new d(r8, r9, true, false, 8);
        }
    }

    public static final class c implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public c() {
            this.a = IMMessageKeys.Layouts.BUBBLE_SINGLE_URL;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r8, BlueprintCell r9) {
            Intrinsics.checkNotNullParameter(r8, "ctx");
            Intrinsics.checkNotNullParameter(r9, "cell");
            return new d(r8, r9, false, true, 4);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.layout.d$d, reason: collision with other inner class name */
    public static final class C0028d implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public C0028d() {
            this.a = IMMessageKeys.Layouts.RTL_BUBBLE_SINGLE_URL;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new d(r3, r4, true, true);
        }
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys.Slots.HEADER, 2131364920), TuplesKt.to(IMMessageKeys.Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys.Slots.FOOTER, 2131364918)});
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final void v() {
        ViewGroup r0 = s(IMMessageKeys.Slots.HEADER);
        if (r0 == null) goto L9;
        int r1 = r0.getPaddingLeft();
        int r2 = r0.getPaddingTop();
        int r3 = r0.getPaddingRight();
        if (this.n == false) goto L7;
        int r4 = 0;
    L8:
        r0.setPadding(r1, r2, r3, r4);
        goto L9
    L7:
        r4 = r0.getPaddingBottom();
    L9:
        LKUIRoundLinearLayout r5 = this.l;
        if (r5 == null) goto L13;
        r5.setBackgroundColor(UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131100557));
        r5.setBorderColor(UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131103351));
        r5.setBorderWidth(1.0f);
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final IBubbleBodyBgStyleProvider.Style m() {
        return IBubbleBodyBgStyleProvider.Style.Clean;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131559301, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        return r5;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final void B(LKUIRoundLinearLayout r2, y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "bodyLayout");
        Intrinsics.checkNotNullParameter(r3, "data");
        C(r2, r3, 8.0f);
    }

    public d(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
        this.n = r5;
    }

    public /* synthetic */ d(com.ss.android.lark.blueprint.g r3, BlueprintCell r4, boolean r5, boolean r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = false;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = false;
    L8:
        this(r3, r4, r5, r6);
    }
}
