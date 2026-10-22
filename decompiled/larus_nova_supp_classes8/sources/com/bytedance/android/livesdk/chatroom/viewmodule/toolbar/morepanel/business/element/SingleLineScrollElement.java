package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.ComposePool;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class SingleLineScrollElement extends BaseElement<ip1.d> {
    public final ComposePool<Integer, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g> c;
    public ViewGroup d;
    public final jp1.b e;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // kp1.b
    public final void release() {
        this.c.b(AnonymousClass1.INSTANCE);
        ViewGroup r0 = this.d;
        if (r0 == null) goto L12;
        Sequence r1 = UtilityKotlinExtentionsKt.g(r0);
        if (r1 == null) goto L14;
        Sequence r2 = SequencesKt.mapNotNull(r1, AnonymousClass2.INSTANCE);
        if (r2 == null) goto L15;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g) r3.next()).release();
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final Integer k() {
        return 2131567778;
    }

    public SingleLineScrollElement(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.e = r2;
        int r3 = ComposePool.e;
        this.c = new ComposePool(30);
    }

    @Override // kp1.b
    public /* bridge */ /* synthetic */ void h(lp1.b r1) {
        m((ip1.d) r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public void l(View r2) {
        Intrinsics.checkNotNullParameter(r2, "elementView");
        this.d = (ViewGroup) r2.findViewById(2131378572);
    }

    public void m(ip1.d r9) {
        Intrinsics.checkNotNullParameter(r9, "model");
        ViewGroup r1 = this.d;
        if (r1 != null) goto L5;
        return;
    L5:
        Sequence r2 = UtilityKotlinExtentionsKt.g(r1);
        r1.removeAllViews();
        Iterator r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L14;
        Object r4 = ((View) r3.next()).getTag(2131389664);
        if ((r4 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g) == true) goto L11;
        r4 = null;
    L11:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g r5 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g) r4;
        if (r5 == null) goto L7;
        ComposePool.c(this.c, r5);
        goto L7
    L14:
        Iterator r10 = r9.a.iterator();
        int r6 = 0;
    L16:
        if (r10.hasNext() == false) goto L27;
        Object r7 = r10.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        lp1.a r11 = (lp1.a) r7;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g r12 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g) this.c.a(Integer.valueOf(r11.getButton().g));
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g r13 = r12;
        if (r12 != null) goto L23;
        int r14 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.a.e;
        jp1.b r15 = this.e;
        Intrinsics.checkNotNullParameter(r15, "session");
        Intrinsics.checkNotNullParameter(r11, "model");
        r13 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.a(r15, r11);
    L23:
        View r16 = r13.a();
        if (r16 != null) goto L26;
        r16 = r13.b(r1, r11.getButton());
        r16.setTag(2131389664, r13);
    L26:
        r13.d(r11, r16, r6);
        r1.addView(r16);
        r6 = r8;
        goto L16
    }
}
