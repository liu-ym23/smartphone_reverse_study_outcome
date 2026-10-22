package com.ss.android.lark.keyboard.keyboard2.content;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Region;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.KeyboardChangeBounds;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenu;
import com.ss.android.lark.keyboard.keyboard2.KeyboardRootContainer;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardMainContent implements IKeyboardContent {
    public static final a m = null;
    public com.ss.android.lark.keyboard.b a;
    public final a b;
    public final View c;
    public final View d;
    public final ViewGroup e;
    public final ViewGroup f;
    public final ViewGroup g;
    public final ViewGroup h;
    public final ViewGroup i;
    public final ViewGroup j;
    public final ArrayList<Pair<Function1<Transition, Transition>, Boolean>> k;
    public boolean l;

    public static final class a implements IKeyboardContent.a {
        @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent.a
        public final String getTag() {
            return "MainContent";
        }

        public a() {
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ KeyboardMainContent b;

        public b(int r1, KeyboardMainContent r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            com.ss.android.lark.keyboard.ime.b r10 = com.ss.android.lark.keyboard.ime.b.a;
            final int r11 = this.a;
            final KeyboardMainContent r12 = this.b;
            Function0<String> r13 = new KeyboardMainContent$handleImeHeight$3$1(r11, r12);
            r10.getClass();
            com.ss.android.lark.keyboard.ime.b.a("KeyboardMainContent", r13);
        }
    }

    static {
        m = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onCreate() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onDestroy() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onShow() {
    }

    public final com.ss.android.lark.keyboard.b e() {
        com.ss.android.lark.keyboard.b r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public final Region f() {
        Region r0 = new Region();
        ViewGroup r1 = this.i;
        r0.set(r1.getLeft(), r1.getTop(), r1.getRight(), r1.getBottom());
        return r0;
    }

    public final void g() {
        this.e.setVisibility(8);
    }

    public final void h() {
        this.i.setVisibility(8);
    }

    public final void l() {
        this.i.setVisibility(0);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onHide() {
        k.a.a(e().e(), new com.ss.android.lark.keyboard.event.b(InputSupportType.Text));
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.ViewInitStrategy a() {
        return IKeyboardContent.ViewInitStrategy.Lazy;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.a getKey() {
        return this.b;
    }

    public KeyboardMainContent(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.b = m;
        View r5 = LayoutInflater.from(r4).inflate(2131561722, null, false);
        this.c = r5;
        this.d = r5.findViewById(2131375112);
        this.e = (ViewGroup) r5.findViewById(2131379938);
        this.f = (ViewGroup) r5.findViewById(2131380095);
        this.g = (ViewGroup) r5.findViewById(2131389168);
        this.h = (ViewGroup) r5.findViewById(2131364475);
        this.i = (ViewGroup) r5.findViewById(2131384598);
        this.j = (ViewGroup) r5.findViewById(2131377786);
        this.k = new ArrayList();
    }

    public static final String d(KeyboardMainContent r6) {
        View r0 = r6.c.getRootView();
        Integer r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(R.id.content);
    L6:
        StringBuilder r3 = new StringBuilder("delegate[h=");
        r3.append(r6.d.getHeight());
        r3.append(", top=");
        r3.append(r6.d.getTop());
        r3.append(", bottom=");
        r3.append(r6.d.getBottom());
        r3.append(", measuredH=");
        r3.append(r6.d.getMeasuredHeight());
        r3.append("], main[h=");
        r3.append(r6.c.getHeight());
        r3.append(", top=");
        r3.append(r6.c.getTop());
        r3.append(", bottom=");
        r3.append(r6.c.getBottom());
        r3.append("], content[h=");
        if (r2 == null) goto L9;
        Integer r4 = Integer.valueOf(r2.getHeight());
    L10:
        r3.append(r4);
        r3.append(", bottom=");
        if (r2 == null) goto L13;
        Integer r5 = Integer.valueOf(r2.getBottom());
    L14:
        r3.append(r5);
        r3.append("], root[h=");
        View r7 = r6.c.getRootView();
        if (r7 == null) goto L17;
        Integer r8 = Integer.valueOf(r7.getHeight());
    L18:
        r3.append(r8);
        r3.append(", bottom=");
        View r9 = r6.c.getRootView();
        if (r9 == null) goto L21;
        r1 = Integer.valueOf(r9.getBottom());
    L21:
        r3.append(r1);
        r3.append(']');
        return r3.toString();
    L17:
        r8 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final View b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return this.c;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void c(final int r3) {
        com.ss.android.lark.keyboard.ime.b r0 = com.ss.android.lark.keyboard.ime.b.a;
        Function0<String> r1 = new KeyboardMainContent$handleImeHeight$1(r3, this);
        r0.getClass();
        com.ss.android.lark.keyboard.ime.b.a("KeyboardMainContent", r1);
        View r2 = this.d;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4 == null) goto L7;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        r5.height = r3;
        r2.setLayoutParams(r5);
        this.d.addOnLayoutChangeListener(new b(r3, this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void i(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.k.add(TuplesKt.to(r3, Boolean.TRUE));
        if (this.l == true) goto L13;
        this.l = true;
        com.ss.android.lark.keyboard.b r4 = e();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((r4 instanceof BasicKeyboard) == false) goto L8;
        KeyboardRootContainer r5 = ((BasicKeyboard) r4).b;
    L9:
        if (r5 == null) goto L12;
        r5.addOnLayoutChangeListener(new d(this));
        return;
    L12:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final Transition j(KeyboardChangeBounds r4) {
        Intrinsics.checkNotNullParameter(r4, "transition");
        Iterator<Pair<Function1<Transition, Transition>, Boolean>> r0 = this.k.iterator();
        Object r1 = r4;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = ((Function1) r0.next().getFirst()).invoke(r4);
        goto L4
    L6:
        CollectionsKt.removeAll(this.k, KeyboardMainContent$onOverrideNextKeyboardTransition$2.INSTANCE);
        return (Transition) r1;
    }

    public final void k(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        com.ss.android.lark.keyboard.keyboard2.b r0 = e().L();
        if ((r0 instanceof com.ss.android.lark.keyboard.base.c) == false) goto L6;
        ((com.ss.android.lark.keyboard.base.c) r0).onConfigurationChanged(r3);
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onActivityResult(int r4, int r5, Intent r6) {
        if (r5 != (-1)) goto L26;
        if (r6 == null) goto L26;
        com.ss.android.lark.keyboard.keyboard2.d r7 = e().H();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r6, "data");
        if ((r7 instanceof KeyboardMenu) == false) goto L22;
        KeyboardMenu r8 = (KeyboardMenu) r7;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        Collection r9 = ((LinkedHashMap) r8.d).values();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r0.add(((KeyboardMenu.b) r10.next()).a);
        goto L10
    L12:
        ArrayList r11 = new ArrayList();
        Iterator r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        Object r2 = r1.next();
        if ((r2 instanceof com.ss.android.lark.keyboard.base.b) == false) goto L14;
        r11.add(r2);
        goto L14
    L18:
        Iterator r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        ((com.ss.android.lark.keyboard.base.b) r12.next()).e(r4, r6);
    L22:
        com.ss.android.lark.keyboard.keyboard2.b r13 = e().L();
        if ((r13 instanceof com.ss.android.lark.keyboard.base.b) == false) goto L35;
        ((com.ss.android.lark.keyboard.base.b) r13).e(r4, r6);
        return;
    L35:
        return;
    L26:
        Log.i("KeyboardMainContent", "handleActivityResult: result code is not result ok");
    }
}
