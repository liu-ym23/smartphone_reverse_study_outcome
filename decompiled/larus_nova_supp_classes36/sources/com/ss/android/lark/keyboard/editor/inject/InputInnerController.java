package com.ss.android.lark.keyboard.editor.inject;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.biz.attachment.inject.AttachmentInnerTopPlugin;
import com.ss.android.lark.keyboard.biz.mention.inject.h;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InputInnerController implements wnb.c {
    public final com.ss.android.lark.keyboard.b a;
    public final ViewGroup b;
    public final ViewGroup c;
    public final ViewGroup d;
    public final Map<wnb.b.a<?>, wnb.b<?>> e;
    public final Map<wnb.b.a<?>, View> f;
    public final Map<wnb.b.a<?>, Direction> g;
    public final List<wnb.b.a<?>> h;
    public final k i;
    public final Lazy j;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ InputInnerController a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ View c;

        public a(InputInnerController r1, ViewGroup r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            InputInnerController r10 = this.a;
            ViewGroup r11 = this.b;
            View r12 = this.c;
            r10.getClass();
            int r13 = r11.getHeight();
            int r14 = 0;
            if (r13 <= 0) goto L5;
            boolean r15 = true;
        L6:
            if (r15 == true) goto L9;
            r14 = 8;
        L9:
            r12.setVisibility(r14);
            return;
        L5:
            r15 = false;
            goto L6
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[InputInnerVisibilityMode.values().length];
            r0[InputInnerVisibilityMode.ALWAYS_GONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[InputInnerVisibilityMode.ALWAYS_VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[InputInnerVisibilityMode.DYNAMIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ InputInnerController a;

        public c(InputInnerController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.c.d(this.a.i);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // wnb.c
    public final void a(wnb.b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r6, TabAppInfo.IMAGE_JSON_KEY);
        Direction r0 = (Direction) ((LinkedHashMap) this.g).get(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup r1 = (ViewGroup) ((Map) this.j.getValue()).get(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = (View) ((LinkedHashMap) this.f).get(r6);
        if (r2 != null) goto L11;
        return;
    L11:
        wnb.b r3 = (wnb.b) ((LinkedHashMap) this.e).get(r6);
        if (r3 == null) goto L14;
        InputInnerVisibilityMode r4 = r3.d();
    L16:
        if (r4 != InputInnerVisibilityMode.ALWAYS_GONE) goto L20;
        r2.setVisibility(8);
        return;
    L20:
        if (r0 != Direction.InnerTop) goto L23;
        h(r6, r2, r1);
        return;
    L23:
        r2.setVisibility(0);
        g(r0, r1);
        return;
    L14:
        r4 = null;
        goto L16
    }

    @Override // wnb.c
    public final void b(wnb.b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r6, TabAppInfo.IMAGE_JSON_KEY);
        Direction r0 = (Direction) ((LinkedHashMap) this.g).get(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup r1 = (ViewGroup) ((Map) this.j.getValue()).get(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = (View) ((LinkedHashMap) this.f).get(r6);
        if (r2 != null) goto L11;
        return;
    L11:
        wnb.b r3 = (wnb.b) ((LinkedHashMap) this.e).get(r6);
        if (r3 == null) goto L14;
        InputInnerVisibilityMode r4 = r3.d();
    L16:
        if (r4 != InputInnerVisibilityMode.ALWAYS_VISIBLE) goto L20;
        r2.setVisibility(0);
        return;
    L20:
        if (r0 != Direction.InnerTop) goto L23;
        e(r6, r2, r1);
        return;
    L23:
        r2.setVisibility(8);
        g(r0, r1);
        return;
    L14:
        r4 = null;
        goto L16
    }

    public final <E extends wnb.b<E>> E d(wnb.b.a<E> r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Object r3 = ((LinkedHashMap) this.e).get(r2);
        if ((r3 instanceof wnb.b) == true) goto L7;
        return null;
    L7:
        return (E) r3;
    }

    @Override // wnb.c
    public final void c(boolean r13, Direction r14) {
        Intrinsics.checkNotNullParameter(r14, "direction");
        Map<wnb.b.a<?>, Direction> r0 = this.g;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L11;
        Map.Entry r4 = (Map.Entry) r2.next();
        if (((Direction) r4.getValue()) == r14) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L3;
        r1.put(r4.getKey(), r4.getValue());
        goto L3
    L11:
        Set r5 = r1.keySet();
        ViewGroup r6 = (ViewGroup) ((Map) this.j.getValue()).get(r14);
        if (r6 != null) goto L14;
        return;
    L14:
        Iterator r7 = r5.iterator();
        boolean r8 = false;
    L16:
        if (r7.hasNext() == false) goto L49;
        wnb.b.a<?> r9 = (wnb.b.a) r7.next();
        View r10 = (View) ((LinkedHashMap) this.f).get(r9);
        if (r10 == null) goto L16;
        wnb.b r11 = (wnb.b) ((LinkedHashMap) this.e).get(r9);
        if (r11 == null) goto L16;
        InputInnerVisibilityMode r12 = r11.d();
        int r15 = 8;
        if (r14 == Direction.InnerTop) goto L25;
        int r16 = b.a[r12.ordinal()];
        if (r16 == 1) goto L45;
        if (r16 == 2) goto L44;
        if (r16 != 3) goto L43;
        boolean r17 = r13;
    L46:
        if (r17 == false) goto L48;
        r15 = 0;
    L48:
        r10.setVisibility(r15);
        goto L16
    L43:
        throw new NoWhenBranchMatchedException();
    L44:
        r17 = true;
        goto L46
    L45:
        r17 = false;
        goto L46
    L25:
        int r18 = b.a[r12.ordinal()];
        if (r18 == 1) goto L35;
        if (r18 == 2) goto L34;
        if (r18 != 3) goto L33;
        if (r13 == false) goto L31;
        h(r9, r10, r6);
    L36:
        r8 = true;
        goto L16
    L31:
        e(r9, r10, r6);
        goto L36
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        h(r9, r10, r6);
        goto L36
    L35:
        r10.setVisibility(8);
        goto L36
    L49:
        if (r8 == false) goto L51;
        g(Direction.InnerTop, r6);
        return;
    L51:
        g(r14, r6);
    }

    public final void f(wnb.b.a<?> r3, boolean r4) {
        if (Intrinsics.areEqual(r3, h.d) == false) goto L10;
        k.a.a(this.i, new com.ss.android.lark.keyboard.editor.inject.a(r4));
        ImeStateDetail r0 = this.a.z().getImeState().b();
        ImeStateDetail r1 = this.a.z().getPanelState().b();
        if (r0.isShowOrExit() == false) goto L7;
    L8:
        k.a.a(this.i, new k2b.a(r4));
        goto L10
    L7:
        if (r1.isShowOrExit() == true) goto L8;
    L10:
        if (Intrinsics.areEqual(r3, AttachmentInnerTopPlugin.i) == false) goto L13;
        k.a.a(this.i, new znb.a(r4));
        return;
    }

    public final void g(Direction r2, ViewGroup r3) {
        if (r2 != Direction.Top) goto L5;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L17;
        return;
    L17:
        r3.post(new c(this));
        return;
    L5:
        if (r2 == Direction.TopExpand) goto L14;
        if (r2 == Direction.TopMiddle) goto L14;
        if (r2 == Direction.InnerTop) goto L14;
        if (r2 == Direction.InnerBottom) goto L14;
        r4 = false;
        goto L15
    }

    public final void e(wnb.b.a<?> r3, View r4, ViewGroup r5) {
        boolean r0 = Intrinsics.areEqual(CollectionsKt.lastOrNull(this.h), r3);
        r4.setVisibility(8);
        ((ArrayList) this.h).remove(r3);
        if (r0 == false) goto L5;
        f(r3, false);
    L5:
        if (r0 == false) goto L12;
        wnb.b.a<?> r6 = (wnb.b.a) CollectionsKt.lastOrNull(this.h);
        if (r6 == null) goto L12;
        View r1 = (View) ((LinkedHashMap) this.f).get(r6);
        if (r1 == null) goto L11;
        r1.setVisibility(0);
    L11:
        f(r6, true);
    L12:
        g(Direction.InnerTop, r5);
    }

    public final void h(wnb.b.a<?> r5, View r6, ViewGroup r7) {
        wnb.b.a<?> r0 = (wnb.b.a) CollectionsKt.lastOrNull(this.h);
        if (r0 != null) goto L5;
    L10:
        ((ArrayList) this.h).remove(r5);
        ((ArrayList) this.h).add(r5);
        r6.setVisibility(0);
        f(r5, true);
        g(Direction.InnerTop, r7);
        return;
    L5:
        if (Intrinsics.areEqual(r0, r5) == true) goto L10;
        View r2 = (View) ((LinkedHashMap) this.f).get(r0);
        if (r2 == null) goto L9;
        r2.setVisibility(8);
    L9:
        f(r0, false);
        goto L10
    }

    public InputInnerController(final ViewGroup r15, final ViewGroup r16, final ViewGroup r17, final ViewGroup r18, final ViewGroup r19, final ViewGroup r20, final ViewGroup r21, final ViewGroup r22, View r23, com.ss.android.lark.keyboard.b r24) {
        Intrinsics.checkNotNullParameter(r15, "inputTopContainer");
        Intrinsics.checkNotNullParameter(r16, "inputTopExpandContainer");
        Intrinsics.checkNotNullParameter(r17, "inputTopMiddleContainer");
        Intrinsics.checkNotNullParameter(r18, "inputInnerStartContainer");
        Intrinsics.checkNotNullParameter(r19, "inputInnerTopContainer");
        Intrinsics.checkNotNullParameter(r20, "inputInnerEndContainer");
        Intrinsics.checkNotNullParameter(r21, "inputInnerEndVerticalContainer");
        Intrinsics.checkNotNullParameter(r22, "inputInnerBottomContainer");
        Intrinsics.checkNotNullParameter(r23, "inputInnerTopContainerDivider");
        Intrinsics.checkNotNullParameter(r24, "keyboard");
        this.a = r24;
        this.b = r15;
        this.c = r16;
        this.d = r17;
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new ArrayList();
        k r12 = r24.e();
        this.i = r12;
        this.j = LazyKt.lazy(new InputInnerController$directionRegions$2(r15, r16, r17, r18, r19, r20, r21, r22));
        r19.addOnLayoutChangeListener(new a(this, r19, r23));
        r12.of(this).c(com.ss.android.lark.keyboard.editor.inject.a.class, new AnonymousClass2(this));
    }
}
