package com.ss.android.lark.flow.chat.message.layout;

import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o extends g {

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.BUBBLE_NESTED_TRANSPARENT;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new o(r3, r4, false);
        }
    }

    public static final class b implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public b() {
            this.a = IMMessageKeys.Layouts.RTL_BUBBLE_NESTED_TRANSPARENT;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new o(r3, r4, true);
        }
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.g, com.ss.android.lark.flow.chat.message.layout.a
    public final void v() {
        super.v();
        LKUIRoundLinearLayout r0 = s(IMMessageKeys.Slots.CONTENT);
        if ((r0 instanceof LKUIRoundLinearLayout) == false) goto L5;
        LKUIRoundLinearLayout r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setBackgroundColor(UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131106784));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public o(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
    }
}
