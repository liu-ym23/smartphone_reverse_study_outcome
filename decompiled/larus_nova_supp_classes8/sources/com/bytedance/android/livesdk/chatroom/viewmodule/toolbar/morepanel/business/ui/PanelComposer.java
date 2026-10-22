package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.e;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.PanelElementProvider;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.ComposePool;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import jp1.c;
import jp1.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kp1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class PanelComposer implements c {
    public final Lazy a;
    public final List<b<lp1.b<Object>>> b;
    public jp1.b c;
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.a d;
    public final PanelElementProvider e;
    public ViewGroup f;
    public final TreeSet<RedDotDelegate> g;
    public final Context h;
    public final DataCenter i;

    @Override // jp1.c
    public final d<Object> d() {
        return (d) this.a.getValue();
    }

    public abstract hp1.a e();

    @Override // jp1.c
    public final void release() {
        this.d.b(AnonymousClass1.INSTANCE);
        ArrayList r0 = (ArrayList) this.b;
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((b) r1.next()).release();
        goto L4
    L6:
        r0.clear();
        MorePanelDynamicControllerViewModel.Companion r2 = MorePanelDynamicControllerViewModel.Companion;
        jp1.b r3 = this.c;
        if (r3 == null) goto L9;
        DataCenter r4 = r3.getDataCenter();
    L10:
        r2.getClass();
        k r5 = MorePanelDynamicControllerViewModel.Companion.a(r4);
        if (r5 == null) goto L15;
        r5.cancelShowEffect();
        return;
    L15:
        return;
    L9:
        r4 = null;
        goto L10
    }

    @Override // jp1.c
    public Context getContext() {
        return this.h;
    }

    @Override // jp1.c
    public final void b(ArrayList<? extends e> r11) {
        Intrinsics.checkNotNullParameter(r11, "buttons");
        jp1.b r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        ip1.e r12 = d().a(r11);
        if (r12 == null) goto L81;
        Intrinsics.checkNotNullParameter(r12, "$this$asType");
        ArrayList<lp1.b<Object>> r13 = r12.a;
        if (r13 == null) goto L98;
        boolean r3 = true;
        ViewGroup r4 = null;
        if ((!r13.isEmpty()) == true) goto L13;
        r13 = null;
    L13:
        if (r13 == null) goto L99;
        jp1.b r2 = this.c;
        if (r2 == null) goto L19;
        DataCenter r5 = r2.getDataCenter();
        if (r5 == null) goto L19;
        boolean r6 = z.e(r5, false);
    L21:
        if (c4.a(r6) == false) goto L46;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r13.iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        CollectionsKt.addAll(r7, ((lp1.b) r8.next()).getChildren());
        goto L24
    L26:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
    L28:
        if (r10.hasNext() == false) goto L33;
        Object r14 = r10.next();
        if ((r14 instanceof lp1.a) == false) goto L28;
        r9.add(r14);
        goto L28
    L33:
        if ((!r9.isEmpty()) == true) goto L36;
        r9 = null;
    L36:
        if (r9 == null) goto L46;
        this.g.clear();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r16 = r9.iterator();
    L39:
        if (r16.hasNext() == false) goto L41;
        r15.add(((lp1.a) r16.next()).getButton().m);
        goto L39
    L41:
        jp1.b r17 = this.c;
        if (r17 == null) goto L44;
        x3 r18 = r17.getToolbarManager();
    L45:
        RedDotHelper.b(r15, r18, this.g);
        goto L46
    L44:
        r18 = null;
    L46:
        ArrayList r19 = (ArrayList) this.b;
        Iterator r20 = r19.iterator();
    L48:
        if (r20.hasNext() == false) goto L55;
        b r21 = (b) r20.next();
        ComposePool.c(this.d, r21);
        View r22 = r21.e();
        if (r22 == null) goto L48;
        ViewGroup r23 = this.f;
        if (r23 == null) goto L54;
        r23.removeView(r22);
    L54:
        r21.i();
        goto L48
    L55:
        r19.clear();
        ViewGroup r24 = this.f;
        if (r24 != null) goto L58;
    L69:
        Iterator<T> r110 = r13.iterator();
    L71:
        if (r110.hasNext() == false) goto L100;
        lp1.b r25 = (lp1.b) r110.next();
        Intrinsics.checkNotNullParameter(r25, "elementModel");
        Intrinsics.checkNotNullParameter(r0, "session");
        b<? extends lp1.b<Object>> r26 = this.d.a(r25.getElementType());
        if (r26 != null) goto L75;
        r26 = this.e.a(new kp1.a(r25.getElementType(), r0));
        Intrinsics.checkNotNullParameter(r26, "$this$asType");
    L75:
        ((ArrayList) this.b).add(r26);
        ViewGroup r27 = this.f;
        if (r27 == null) goto L80;
        View r28 = r26.c(r27);
        if (r28 == null) goto L80;
        r28.setTag(2131389665, r26);
    L80:
        r26.h(r25);
        goto L71
    L100:
        return;
    L58:
        if (r24.getChildCount() > 0) goto L61;
        r3 = false;
    L61:
        if (r3 == false) goto L63;
        r4 = r24;
    L63:
        if (r4 == null) goto L69;
        Sequence r29 = UtilityKotlinExtentionsKt.g(r4);
        if (r29 == null) goto L69;
        Sequence r30 = SequencesKt.mapNotNull(r29, new PanelComposer$resetPanel$3(this));
        if (r30 == null) goto L69;
        SequencesKt.onEach(r30, new PanelComposer$resetPanel$4(this));
    L19:
        r6 = true;
        goto L21
    L99:
        return;
    L98:
        return;
    }

    @Override // jp1.c
    public void c(hp1.c r5) {
        Intrinsics.checkNotNullParameter(r5, "session");
        this.c = r5;
        this.f = (ViewGroup) r5.findView(2131381866);
        if (g.b() == false) goto L5;
        int r6 = -1;
    L6:
        MoreMixSharePanelUtils r0 = MoreMixSharePanelUtils.INSTANCE;
        jp1.b r1 = this.c;
        boolean r2 = true;
        if (r1 == null) goto L11;
        DataCenter r3 = r1.getDataCenter();
        if (r3 == null) goto L11;
        boolean r4 = z.e(r3, false);
    L12:
        DataCenter r7 = this.i;
        if (r7 == null) goto L16;
        r2 = z.m(r7, true);
    L16:
        if (r0.isMoreMixShareMode(r4, r2) == false) goto L18;
        r6 = ColorProtector.parseColor("#F3F3F4");
    L18:
        ViewGroup r8 = this.f;
        if (r8 == null) goto L22;
        r8.setBackgroundColor(r6);
        return;
    L22:
        return;
    L11:
        r4 = true;
        goto L12
    L5:
        r6 = (int) 4279638051L;
        goto L6
    }

    public PanelComposer(Context r1, DataCenter r2) {
        this.h = r1;
        this.i = r2;
        this.a = LazyKt.lazy(new PanelComposer$dataProcessor$2(this));
        this.b = new ArrayList();
        this.d = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.a();
        this.e = PanelElementProvider.b;
        this.g = new TreeSet();
    }
}
