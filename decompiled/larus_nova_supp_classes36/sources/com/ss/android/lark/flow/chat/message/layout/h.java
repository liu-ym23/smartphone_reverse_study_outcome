package com.ss.android.lark.flow.chat.message.layout;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends com.ss.android.lark.blueprint.a<y6b.a<?>> implements h3b.c {
    public BubbleLayoutAlphaMode f;
    public final Map<v, Integer> g;

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.PLAIN;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r2, BlueprintCell r3) {
            Intrinsics.checkNotNullParameter(r2, "ctx");
            Intrinsics.checkNotNullParameter(r3, "cell");
            return new h(r2, r3);
        }
    }

    public final List<v> g() {
        return CollectionsKt.toList(this.g.keySet());
    }

    public final Map<v, Integer> t() {
        return this.g;
    }

    public final View n(v r2) {
        Intrinsics.checkNotNullParameter(r2, "slotId");
        return s(r2);
    }

    public final View u(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        FrameLayout r0 = new FrameLayout(r4.getContext());
        r0.setId(R.id.content);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r0;
    }

    public void update(y6b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if ((r6 instanceof y6b.c) == false) goto L65;
        y6b.c r7 = (y6b.c) r6;
        if (r7.L2 == true) goto L7;
        BubbleLayoutAlphaMode r8 = this.f;
        if (r8 != BubbleLayoutAlphaMode.EDIT_MASK) goto L36;
        r().setAlpha(1.0f);
    L43:
        this.f = BubbleLayoutAlphaMode.NORMAL;
        return;
    L36:
        if (r8 != BubbleLayoutAlphaMode.AVATAR_HIGHLIGHT) goto L43;
        Iterator<Map.Entry<v, Integer>> r9 = this.g.entrySet().iterator();
    L39:
        if (r9.hasNext() == false) goto L43;
        View r0 = n(r9.next().getKey());
        if (r0 == null) goto L39;
        r0.setAlpha(1.0f);
        goto L39
    L7:
        if (r7.M2 == false) goto L23;
        Iterator<Map.Entry<v, Integer>> r10 = this.g.entrySet().iterator();
    L10:
        if (r10.hasNext() == false) goto L20;
        Map.Entry<v, Integer> r2 = r10.next();
        IMMessageKeys.Slots r3 = r2.getKey();
        IMMessageKeys.Slots r4 = IMMessageKeys.Slots.AVATAR;
        if (r3 == r4) goto L13;
        View r5 = n(r2.getKey());
        if (r5 == null) goto L10;
        r5.setAlpha(0.3f);
        goto L10
    L13:
        View r11 = n(r4);
        if (r11 == null) goto L10;
        r11.setAlpha(1.0f);
        goto L10
    L20:
        if (this.f != BubbleLayoutAlphaMode.EDIT_MASK) goto L22;
        r().setAlpha(1.0f);
    L22:
        this.f = BubbleLayoutAlphaMode.AVATAR_HIGHLIGHT;
        return;
    L23:
        r().setAlpha(0.3f);
        if (this.f != BubbleLayoutAlphaMode.AVATAR_HIGHLIGHT) goto L31;
        Iterator<Map.Entry<v, Integer>> r12 = this.g.entrySet().iterator();
    L27:
        if (r12.hasNext() == false) goto L31;
        View r1 = n(r12.next().getKey());
        if (r1 == null) goto L27;
        r1.setAlpha(1.0f);
    L31:
        this.f = BubbleLayoutAlphaMode.EDIT_MASK;
        return;
    }

    public /* bridge */ /* synthetic */ void update(Object r1) {
        update((y6b.a) r1);
    }

    public h(com.ss.android.lark.blueprint.g r2, BlueprintCell r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3);
        this.f = BubbleLayoutAlphaMode.NORMAL;
        this.g = MapsKt.mapOf(TuplesKt.to(IMMessageKeys.Slots.CONTENT, Integer.valueOf(R.id.content)));
    }
}
