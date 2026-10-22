package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.blueprint.s;
import com.ss.android.lark.blueprint.t;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.Keys;
import e6b.e;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OpenCellContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> implements e6b.a {
    public static final e6b.c j = null;
    public final j g;
    public final com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> h;
    public final List<j> i;

    public static final class a {
    }

    public static final class b implements k<FrameLayout>, t {
        public final FrameLayout a;
        public BubbleStyle b;
        public u5b.c c;

        public static final class a implements k3b.a {
            public final /* synthetic */ b b;

            @Override // k3b.a
            public final u5b.c d() {
                return this.b.c;
            }

            @Override // k3b.a
            public final BubbleStyle e() {
                return this.b.b;
            }

            public a(b r1) {
                this.b = r1;
            }
        }

        public final s a() {
            return new a(this);
        }

        public final View getView() {
            return this.a;
        }

        public b(FrameLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }
    }

    public static final class c implements r5b.c<v5b.a<?>> {
        public final /* synthetic */ m<y6b.a<?>> a;
        public final /* synthetic */ OpenCellContentBlock b;

        public c(m<y6b.a<?>> r1, OpenCellContentBlock r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // r5b.c
        public final boolean d(View r4, v5b.c<v5b.a<?>> r5) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            Intrinsics.checkNotNullParameter(r5, "item");
            Boolean r0 = null;
            if ((r5 instanceof y6b.a) == false) goto L5;
            y6b.a r6 = (y6b.a) r5;
        L6:
            if (r6 == null) goto L15;
            e6b.b r7 = this.a;
            OpenCellContentBlock r1 = this.b;
            if ((r7 instanceof e6b.b) == false) goto L10;
            e6b.b r8 = r7;
        L11:
            if (r8 == null) goto L13;
            r0 = Boolean.valueOf(r8.e(r1, r6));
        L13:
            if (r0 == null) goto L15;
            return r0.booleanValue();
        L10:
            r8 = null;
        L15:
            return false;
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
        j = new e6b.c(null);
    }

    public final j getKey() {
        return this.g;
    }

    @Override // e6b.a
    public final e6b.a.C0216a e(j r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return new e6b.a.C0216a(this.i.indexOf(r3), this.i.size());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(m<y6b.a<?>> r2, q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        i.a.a(r2, r3);
        k r4 = r3.f(this.g, IMMessageKeys$Slots.CONTENT);
        if (r4 == null) goto L9;
        View r5 = r4.getView();
        if (r5 == null) goto L10;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r6 = this.h;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "itemView");
        r6.b.f(r5);
        return;
    L10:
        return;
    }

    public OpenCellContentBlock(g r2, j r3, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "openCell");
        super(r2);
        this.g = r3;
        this.h = r4;
        this.i = CollectionsKt.listOf(new j[]{j, r3});
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(m<y6b.a<?>> r8, q<y6b.a<?>> r9, y6b.a<?> r10) {
        Intrinsics.checkNotNullParameter(r8, "cell");
        Intrinsics.checkNotNullParameter(r9, "layout");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        b r1 = (b) r9.c(this.g, IMMessageKeys$Slots.CONTENT, new OpenCellContentBlock$update$blockView$1(this));
        if (r1.a.getChildCount() >= 1) goto L5;
        return;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r2 = this.h;
        c r3 = new c(r8, this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "clickCallback");
        r2.d = r3;
        View r4 = r1.a.getChildAt(0);
        ViewGroup r5 = null;
        if ((r8 instanceof xza.a) == false) goto L8;
        xza.a r11 = (xza.a) r8;
    L9:
        int r6 = -1;
        if (r11 == null) goto L14;
        BlueprintCellViewHolder r12 = r11.i();
        if (r12 == null) goto L14;
        int r13 = r12.getBindingAdapterPosition();
    L15:
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r7 = this.h;
        Intrinsics.checkNotNull(r4);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        r7.b.e(r4, r13, r10);
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r14 = this.h;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        CP r15 = r14.b;
        if ((r15 instanceof u5b.a) == false) goto L18;
        u5b.a r16 = (u5b.a) r15;
    L19:
        if (r16 == null) goto L21;
        BubbleStyle r17 = r16.d(r10, r4);
    L22:
        r1.b = r17;
        if (r17 == null) goto L29;
        ViewGroup.LayoutParams r18 = r1.a.getLayoutParams();
        if (r17.g == true) goto L28;
        r6 = -2;
    L28:
        r18.width = r6;
        r1.a.setLayoutParams(r18);
    L29:
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r19 = this.h;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        CP r20 = r19.b;
        if ((r20 instanceof u5b.a) == false) goto L32;
        u5b.a r21 = (u5b.a) r20;
    L33:
        if (r21 == null) goto L35;
        u5b.c r22 = r21.i(r10);
    L36:
        r1.c = r22;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?> r23 = this.h;
        FrameLayout r24 = r1.a;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r24, "parent");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        CP r25 = r23.b;
        if ((r25 instanceof e) == false) goto L39;
        e r26 = (e) r25;
    L40:
        if (r26 == null) goto L42;
        final View r27 = r26.g(r4, r24, r10);
    L43:
        e6b.c r110 = j;
        if (r27 != null) goto L46;
        g(r9, r110, IMMessageKeys$Slots.ROOF);
        return;
    L46:
        ViewParent r0 = r27.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L49;
        ViewGroup r28 = (ViewGroup) r0;
    L50:
        if (r28 == null) goto L61;
        r9.o(r110, IMMessageKeys$Slots.ROOF);
        ViewParent r29 = r27.getParent();
        if ((r29 instanceof ViewGroup) == false) goto L54;
        ViewGroup r30 = (ViewGroup) r29;
    L55:
        if (r30 == null) goto L61;
        ViewParent r31 = r27.getParent();
        if ((r31 instanceof ViewGroup) == false) goto L59;
        r5 = (ViewGroup) r31;
    L59:
        if (r5 == null) goto L61;
        r5.removeView(r27);
        goto L61
    L54:
        r30 = null;
    L61:
        r9.c(r110, IMMessageKeys$Slots.ROOF, new AnonymousClass2(r27));
        return;
    L49:
        r28 = null;
        goto L50
    L42:
        r27 = null;
        goto L43
    L39:
        r26 = null;
        goto L40
    L35:
        r22 = null;
        goto L36
    L32:
        r21 = null;
        goto L33
    L21:
        r17 = null;
        goto L22
    L18:
        r16 = null;
    L14:
        r13 = -1;
        goto L15
    L8:
        r11 = null;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(m<y6b.a<?>> r1, q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
