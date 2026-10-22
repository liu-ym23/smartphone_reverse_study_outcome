package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.dux.popover.menu.DuxPopoverMenuView;
import com.bytedance.dux.radio.DuxRadio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/tab/TabPopoverFilterMenuView;", "Lcom/bytedance/dux/popover/menu/DuxPopoverMenuView;", "a", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabPopoverFilterMenuView extends DuxPopoverMenuView {
    public ArrayList<b> j;
    public final Map<Integer, DuxRadio> k;
    public final List<ViewGroup> l;

    public static final class a {
        public final ArrayList<b> a;
        public final Context b;

        public final Context getContext() {
            return this.b;
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.b = r2;
            this.a = new ArrayList();
        }
    }

    public static final class b {
        public final CharSequence a;
        public final boolean b;
        public final Function1<? super Integer, Unit> c;
        public final Typeface d;

        public b(CharSequence r1, boolean r2, Function1<? super Integer, Unit> r3, Typeface r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public TabPopoverFilterMenuView(Context r4) {
        this(r4, null, 0, 14);
    }

    public TabPopoverFilterMenuView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public TabPopoverFilterMenuView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    public TabPopoverFilterMenuView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5, null);
        this.j = new ArrayList();
        this.k = new LinkedHashMap();
        this.l = new ArrayList();
    }

    public final void onSizeChanged(int r6, int r7, int r8, int r9) {
        super.onSizeChanged(r6, r7, r8, r9);
        Iterator<T> r11 = this.l.iterator();
    L4:
        if (r11.hasNext() == false) goto L24;
        ViewGroup r12 = (ViewGroup) r11.next();
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L23;
        ViewGroup.LayoutParams r0 = r12.getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r0 = null;
    L10:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        int r3 = 0;
        if (r1 == null) goto L13;
        int r4 = r1.leftMargin;
    L14:
        int r5 = r6 - r4;
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r2 = r14;
    L18:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r2;
        if (r15 == null) goto L21;
        r3 = r15.rightMargin;
    L21:
        r13.width = r5 - r3;
        r12.setLayoutParams(r13);
        goto L4
    L13:
        r4 = 0;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
