package com.ss.android.lark.flow.chat.message.block;

import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.AvatarBlock;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends AvatarBlock {

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.block.a$a, reason: collision with other inner class name */
    public static final class C0024a extends AvatarBlock.a {
        public final ViewGroup e;
        public final View f;

        public final View getView() {
            return this.e;
        }

        public C0024a(ViewGroup r2, DecoratedAvatar r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "decoratedAvatar");
            Intrinsics.checkNotNullParameter(r4, "aiBadgeView");
            super(r2, r3);
            this.e = r2;
            this.f = r4;
        }
    }

    public final int i() {
        return 2131561122;
    }

    public a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
    }

    public final AvatarBlock.a h(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        ViewGroup r5 = (ViewGroup) r4;
        return new C0024a(r5, r5.findViewById(2131373022), r5.findViewById(2131373021));
    }

    public final void l(AvatarBlock.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockView");
        if ((r2 instanceof C0024a) == false) goto L5;
        C0024a r3 = (C0024a) r2;
    L6:
        if (r3 == null) goto L11;
        View r4 = r3.f;
        if (r4 == null) goto L12;
        r4.setVisibility(8);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void j(AvatarBlock.a r4, y6b.a<?> r5) {
        Intrinsics.checkNotNullParameter(r4, "blockView");
        Intrinsics.checkNotNullParameter(r5, "item");
        if ((r4 instanceof C0024a) == false) goto L5;
        C0024a r6 = (C0024a) r4;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        View r0 = r6.f;
        boolean r1 = true;
        int r2 = 0;
        if (r6.e.getVisibility() != 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L14;
    L19:
        r2 = 8;
    L20:
        r0.setVisibility(r2);
        return;
    L14:
        if (r5.getType() == Message.Type.DOUBAO) goto L17;
        r1 = false;
    L17:
        if (r1 == false) goto L19;
    L11:
        r7 = false;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    public final void k(AvatarBlock.a r2, y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "blockView");
        Intrinsics.checkNotNullParameter(r3, "item");
        if ((r2 instanceof C0024a) == false) goto L5;
        C0024a r4 = (C0024a) r2;
    L6:
        if (r4 == null) goto L11;
        View r5 = r4.f;
        if (r5 == null) goto L12;
        r5.setVisibility(8);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
