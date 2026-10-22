package com.ss.android.lark.flow.chat.message.layout;

import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends com.ss.android.lark.flow.chat.message.layout.b {

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.BUBBLE_MINIMAL;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new f(r3, r4, false);
        }
    }

    public static final class b implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public b() {
            this.a = IMMessageKeys.Layouts.RTL_BUBBLE_MINIMAL;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new f(r3, r4, true);
        }
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final void A(y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        super.A(r3);
        LKUIRoundLinearLayout r4 = this.l;
        if (r4 != null) goto L6;
        return;
    L6:
        if (com.ss.android.lark.blueprint.a.w(r4) > 1) goto L9;
        Intrinsics.checkNotNullParameter(r4, "bodyLayout");
        r4.setRadius(0.0f, 0.0f, 0.0f, 0.0f);
        r4.setBackground(null);
        r4.setPadding(0);
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final /* bridge */ /* synthetic */ void l(Object r1) {
        A((y6b.a) r1);
    }

    public f(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
    }
}
