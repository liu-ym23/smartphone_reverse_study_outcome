package com.larus.bmhome.chat.nestedmenu.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.nestedmenu.NestedMenuPopupStrategy;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.menu.CreateMenuV2;
import com.larus.bmhome.view.screenmenu.MenuItemType;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.skydoves.balloon.Balloon;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.j0;
import di8.k0;
import di8.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;
import wa8.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NestedMenuPopup {
    public final c0 a;
    public List<? extends q> b;
    public final Function1<q.a, Unit> c;
    public final Function1<q.a, Unit> d;
    public final Function1<List<? extends q>, Unit> e;
    public final Function0<Unit> f;
    public Balloon g;
    public Balloon h;
    public CreateMenuV2 i;
    public View j;
    public boolean k;
    public int l;
    public PopupShowMethod m;
    public boolean n;
    public String o;
    public final boolean p;
    public b q;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/ui/NestedMenuPopup$PopupShowMethod;", "", "<init>", "(Ljava/lang/String;I)V", "ALIGN_TOP", "DROP_DOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum PopupShowMethod extends Enum<PopupShowMethod> {
        public static final PopupShowMethod ALIGN_TOP = null;
        public static final PopupShowMethod DROP_DOWN = null;
        public static final /* synthetic */ PopupShowMethod[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PopupShowMethod> getEntries() {
            return b;
        }

        static {
            PopupShowMethod r0 = new PopupShowMethod("ALIGN_TOP", 0);
            ALIGN_TOP = r0;
            PopupShowMethod r1 = new PopupShowMethod("DROP_DOWN", 1);
            DROP_DOWN = r1;
            PopupShowMethod[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PopupShowMethod[] values() {
            return (PopupShowMethod[]) a.clone();
        }

        public static PopupShowMethod valueOf(String r1) {
            return (PopupShowMethod) r27.a.a(PopupShowMethod.class, r1);
        }

        public PopupShowMethod(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/ui/NestedMenuPopup$PopupVerticalSide;", "", "<init>", "(Ljava/lang/String;I)V", "ABOVE", "BELOW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum PopupVerticalSide extends Enum<PopupVerticalSide> {
        public static final PopupVerticalSide ABOVE = null;
        public static final PopupVerticalSide BELOW = null;
        public static final /* synthetic */ PopupVerticalSide[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PopupVerticalSide> getEntries() {
            return b;
        }

        static {
            PopupVerticalSide r0 = new PopupVerticalSide("ABOVE", 0);
            ABOVE = r0;
            PopupVerticalSide r1 = new PopupVerticalSide("BELOW", 1);
            BELOW = r1;
            PopupVerticalSide[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PopupVerticalSide[] values() {
            return (PopupVerticalSide[]) a.clone();
        }

        public static PopupVerticalSide valueOf(String r1) {
            return (PopupVerticalSide) r27.a.a(PopupVerticalSide.class, r1);
        }

        public PopupVerticalSide(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final PopupShowMethod a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "PopupPlacement(showMethod=" + this.a + ", businessXOff=" + this.b + ", businessYOff=" + this.c + ", rawXOff=" + this.d + ", rawYOff=" + this.e + ')';
        }

        public a(PopupShowMethod r2, int r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "showMethod");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
        public final PopupVerticalSide a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "PopupVerticalSlot(side=" + this.a + ", maxHeight=" + this.b + ')';
        }

        public b(PopupVerticalSide r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "side");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final CreateMenuV2 a;
        public final View b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PreparedMenuView(menu=" + this.a + ", view=" + this.b + ')';
        }

        public c(CreateMenuV2 r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "menu");
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PopupVerticalSide.values().length];
            r0[PopupVerticalSide.ABOVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PopupVerticalSide.BELOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void b() {
        if (this.n == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.iterator();
    L6:
        final q.a r3 = null;
        if (r0.hasNext() == false) goto L22;
        Object r1 = r0.next();
        q r4 = (q) r1;
        boolean r6 = false;
        if ((r4 instanceof q.a) == false) goto L20;
        q.a r5 = (q.a) r4;
        if (Intrinsics.areEqual(r5.a, "model") == false) goto L20;
        d0 r7 = r5.c;
        if (g(r7) == false) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L20;
        r6 = true;
        goto L20
    L15:
        if (i(r7) == false) goto L17;
        r8 = true;
    L20:
        if (r6 == false) goto L6;
    L24:
        if ((r1 instanceof q.a) == false) goto L26;
        r3 = (q.a) r1;
    L26:
        if (r3 != null) goto L28;
        return;
    L28:
        final CreateMenuV2 r2 = this.i;
        if (r2 != null) goto L31;
        return;
    L31:
        final int r9 = this.b.indexOf(r3);
        if (r9 >= 0) goto L34;
        return;
    L34:
        this.n = true;
        r2.G(r9);
        r2.post(new i(r2, r9, this, r3));
        return;
    L22:
        r1 = null;
        goto L24
    }

    public final CreateMenu.a.a d() {
        CreateMenu.a.a r0 = CreateMenuV2.s;
        Integer r1 = Integer.valueOf(i5.q());
        r1.intValue();
        c0 r2 = this.a;
        if (r2.g.a == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L14;
        int r8 = r1.intValue();
        CreateMenu.a.a r4 = CreateMenuV2.s;
        return new CreateMenu.a.a(r4.a, r4.b, r4.c, r4.d, r4.e, r4.f, r8, r4.h, r4.i, r4.j);
    L14:
        return CreateMenuV2.s;
    L5:
        if (Intrinsics.areEqual(r2.b, "fork_conv") == false) goto L7;
        r3 = true;
        goto L8
    }

    public final Integer k() {
        b r0 = this.q;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.b);
    L6:
        Integer r2 = this.a.g.m;
        if (r1 == null) goto L13;
        if (r2 != null) goto L12;
        return r1;
    L12:
        return Integer.valueOf(Math.min(r1.intValue(), r2.intValue()));
    L13:
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean o() {
        boolean r1 = false;
        if (this.b.isEmpty() == false) goto L5;
        return false;
    L5:
        List<? extends q> r0 = this.b;
        c r2 = e(this, r0, true, true, this.a.g.m, 4);
        r2.b.measure(0, 0);
        Integer r3 = Integer.valueOf(r2.a.getMeasuredHeight());
        if (r3.intValue() <= 0) goto L8;
        boolean r4 = true;
    L9:
        b r6 = null;
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        int r5 = r3.intValue();
    L16:
        int r7 = r5 + r2.b.getPaddingBottom();
        if (this.p == false) goto L63;
        c0 r8 = this.a;
        o0 r9 = r8.g;
        if (r9.v == false) goto L22;
        View r10 = r8.d;
    L23:
        View r11 = r9.s;
        if (r10.isAttachedToWindow() == false) goto L63;
        if (r11 != null) goto L27;
    L29:
        boolean r12 = false;
    L30:
        if (r12 == false) goto L63;
        Rect r13 = m(r10);
        Rect r14 = new Rect();
        Rect r15 = new Rect();
        if (this.a.g.v == false) goto L35;
        boolean r16 = f(r10, r14);
    L37:
        if (this.a.g.v == false) goto L39;
        boolean r17 = f(r11, r15);
    L41:
        if (r13.isEmpty() == true) goto L63;
        if (r16 == false) goto L63;
        if (r17 == false) goto L63;
        if (this.a.g.v == false) goto L48;
        int r18 = RangesKt.coerceAtLeast(r13.bottom - r14.bottom, 0);
    L50:
        if (this.a.g.v == false) goto L52;
        int r19 = RangesKt.coerceAtLeast(r15.bottom - r13.top, 0);
    L54:
        if (this.a.g.v == false) goto L57;
        if (r7 <= r18) goto L58;
    L59:
        if (r1 == false) goto L61;
        b r20 = new b(PopupVerticalSide.BELOW, r18 + i5.Q());
    L62:
        r6 = r20;
        goto L63
    L61:
        r20 = new b(PopupVerticalSide.ABOVE, r19 + i5.Q());
    L58:
        r1 = true;
        goto L59
    L57:
        if (r18 < r19) goto L59;
    L52:
        r19 = RangesKt.coerceAtLeast(r14.top - r13.top, 0);
        goto L54
    L48:
        r18 = RangesKt.coerceAtLeast(r13.bottom - r14.bottom, 0);
        goto L50
    L39:
        r17 = true;
        goto L41
    L35:
        r16 = r10.getGlobalVisibleRect(r14);
        goto L37
    L27:
        if (r11.isAttachedToWindow() != true) goto L29;
        r12 = true;
        goto L30
    L22:
        r10 = r8.e;
    L63:
        this.q = r6;
        Integer r21 = k();
        if (r21 != null) goto L66;
    L68:
        final View r22 = r2.b;
    L69:
        this.i = r2.a;
        this.j = r22;
        com.larus.bmhome.view.screenmenu.d r23 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(this.a.e);
        c0 r24 = this.a;
        o0 r25 = r24.g;
        View r26 = r25.s;
        if (r26 != null) goto L72;
        View r27 = r24.e;
    L73:
        final Balloon r28 = c(this, r22, r27, null, r25.t, new j(this), 4);
        r2.a.setOnMenuSizeChangedListener(new k(r28, this, r22));
        View r29 = r28.e.getContentView();
        r29.getViewTreeObserver().addOnPreDrawListener(new p(r29, this, r28));
        p(r28, r22, true);
        this.g = r28;
        this.e.invoke(r0);
        b();
        return true;
    L72:
        r27 = r26;
        goto L73
    L66:
        if (r2.b.getMeasuredHeight() <= r21.intValue()) goto L68;
        r22 = j(r2.a, r0);
        goto L69
    L15:
        r5 = RangesKt.coerceAtLeast((r2.b.getMeasuredHeight() - r2.b.getPaddingTop()) - r2.b.getPaddingBottom(), 0);
        goto L16
    L8:
        r4 = false;
        goto L9
    }

    public static boolean g(d0 r4) {
        String r0 = n0.a();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
    L13:
        r1 = false;
    L14:
        if (r1 == true) goto L16;
    L18:
        return r1;
    L16:
        if (i(r4) == false) goto L18;
        return false;
    L11:
        if (Intrinsics.areEqual(r4.getCenter().i, r0) == false) goto L13;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r3 = false;
        goto L9
    }

    public static boolean h(d0 r4) {
        if (g(r4) == false) goto L5;
        return true;
    L5:
        di8.n0 r5 = r4.getSubMenu();
        if (r5 == null) goto L34;
        Map<String, List<d0>> r6 = r5.a;
        if (r6 == null) goto L34;
        Collection<List<d0>> r7 = r6.values();
        if (r7 == null) goto L34;
        Collection<List<d0>> r8 = r7;
        if (r8.isEmpty() == true) goto L31;
        Iterator<T> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L31;
        List r2 = (List) r9.next();
        if ((r2 instanceof Collection) == true) goto L20;
    L22:
        Iterator r3 = r2.iterator();
    L24:
        if (r3.hasNext() == false) goto L28;
        if (h((d0) r3.next()) == false) goto L24;
        boolean r10 = true;
    L29:
        if (r10 == false) goto L16;
        boolean r11 = true;
    L32:
        if (r11 != true) goto L34;
        return true;
    L28:
        r10 = false;
        goto L29
    L20:
        if (r2.isEmpty() == false) goto L22;
    L31:
        r11 = false;
    L34:
        return false;
    }

    public static boolean i(d0 r4) {
        di8.n0 r5 = r4.getSubMenu();
        if (r5 != null) goto L5;
        return false;
    L5:
        Collection<List<d0>> r6 = r5.a.values();
        if ((r6 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L37;
        List r1 = (List) r7.next();
        if ((r1 instanceof Collection) == true) goto L16;
    L18:
        Iterator r2 = r1.iterator();
    L20:
        if (r2.hasNext() == false) goto L24;
        if (h((d0) r2.next()) == false) goto L20;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L12;
        return true;
    L24:
        r3 = false;
        goto L25
    L16:
        if (r1.isEmpty() == false) goto L18;
    L37:
        return false;
    L8:
        if (r6.isEmpty() == false) goto L10;
        return false;
    }

    public static Rect m(View r6) {
        Rect r0 = new Rect();
        r6.getWindowVisibleDisplayFrame(r0);
        i0.a.getClass();
        int r1 = RangesKt.coerceAtLeast(i0.g(), 0);
        int r2 = RangesKt.coerceAtLeast(i0.e(), 0);
        int r4 = r0.left;
        int r3 = r0.right;
        int r5 = m0.a;
        return new Rect(r4, r1, r3, RangesKt.coerceAtLeast((m0.a(r6.getContext()) - r2) - i5.h(), r1));
    }

    public final void a(View r9) {
        o0 r0 = this.a.g;
        boolean r1 = r0.u;
        boolean r2 = r0.v;
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
        return;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        View r3 = r0.s;
        Rect r4 = new Rect();
        Rect r5 = new Rect();
        if (r3 == null) goto L13;
        boolean r7 = true;
        if (r3.getGlobalVisibleRect(r5) != true) goto L13;
    L14:
        if (r7 == false) goto L16;
        r3.getWindowVisibleDisplayFrame(r4);
    L16:
        if (r1 == false) goto L19;
        if (r7 == false) goto L19;
        int r6 = RangesKt.coerceIn(r5.left - r4.left, 0, r9.getPaddingLeft());
    L20:
        if (r2 == false) goto L23;
        if (r7 == false) goto L23;
        int r8 = RangesKt.coerceIn(r4.right - r5.right, 0, r9.getPaddingRight());
    L24:
        r9.setPadding(r6, r9.getPaddingTop(), r8, r9.getPaddingBottom());
        return;
    L23:
        r8 = r9.getPaddingRight();
    L19:
        r6 = r9.getPaddingLeft();
    L13:
        r7 = false;
        goto L14
    }

    public final void s(View r5) {
        Balloon r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.e.getContentView().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        a r6 = l(r5, r0.m(), r0.l(), this.m);
        this.m = r6.a;
        Triple<View, Integer, Integer> r7 = n(this.a.e, r6.d, r6.e);
        if (r7 != null) goto L8;
        return;
    L8:
        r0.update((View) r7.getFirst(), ((Number) r7.getSecond()).intValue(), ((Number) r7.getThird()).intValue());
    }

    public final boolean update(List<? extends q> r7) {
        Intrinsics.checkNotNullParameter(r7, "nodes");
        boolean r1 = false;
        if (r7.isEmpty() == false) goto L5;
        return false;
    L5:
        this.b = r7;
        boolean r0 = Intrinsics.areEqual(this.o, "model");
        if (r0 == true) goto L13;
        this.l++;
        Balloon r3 = this.h;
        if (r3 == null) goto L10;
        r3.h();
    L10:
        this.h = null;
        this.o = null;
        CreateMenuV2 r4 = this.i;
        if (r4 == null) goto L13;
        CreateMenu.a.a r5 = CreateMenuV2.s;
        r4.H(false, null);
    L13:
        CreateMenuV2 r6 = this.i;
        if (r6 != null) goto L16;
        return false;
    L16:
        View r8 = j(r6, r7);
        this.j = r8;
        if (this.q == null) goto L25;
        Balloon r9 = this.g;
        if (r9 != null) goto L21;
    L23:
        if (r1 == false) goto L25;
        s(r8);
        goto L25
    L21:
        if (r9.g != true) goto L23;
        r1 = true;
    L25:
        r8.requestLayout();
        r8.invalidate();
        Balloon r10 = this.g;
        if (r10 == null) goto L32;
        PopupWindow r11 = r10.e;
        if (r11 == null) goto L32;
        View r12 = r11.getContentView();
        if (r12 == null) goto L32;
        r12.requestLayout();
    L32:
        Balloon r13 = this.g;
        if (r13 == null) goto L39;
        PopupWindow r14 = r13.e;
        if (r14 == null) goto L39;
        View r15 = r14.getContentView();
        if (r15 == null) goto L39;
        r15.invalidate();
    L39:
        if (r0 == false) goto L41;
    L43:
        return true;
    L41:
        if (this.h != null) goto L43;
        b();
        goto L43
    }

    public static boolean f(View r5, Rect r6) {
        if (r5.isAttachedToWindow() == true) goto L5;
    L11:
        return false;
    L5:
        if (r5.getWidth() <= 0) goto L11;
        if (r5.getHeight() <= 0) goto L11;
        int[] r0 = new int[2];
        r5.getLocationOnScreen(r0);
        int r1 = r0[0];
        r6.set(r1, r0[1], r5.getWidth() + r1, r0[1] + r5.getHeight());
        return true;
    }

    public final View j(CreateMenuV2 r56, List r57) {
        final LinkedHashMap r1 = new LinkedHashMap();
        List r2 = r57;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
        boolean r5 = false;
        int r13 = 0;
    L3:
        ViewGroup.LayoutParams r6 = null;
        if (r4.hasNext() == false) goto L17;
        Object r7 = r4.next();
        int r8 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        q r9 = (q) r7;
        if ((r9 instanceof q.a) == false) goto L12;
        r1.put(Integer.valueOf(r13), r9);
        l0 r10 = l0.b(((q.a) r9).d, r13, null, false, -2);
    L14:
        r3.add(r10);
        r13 = r8;
        goto L3
    L12:
        if ((r9 instanceof q.b) == false) goto L16;
        r10 = new l0(r13, 0, null, null, null, null, null, null, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, MenuItemType.SECTION_DIVIDER, null, null, null, null, null, null, null, Integer.valueOf(((q.b) r9).a), null, null, null, null, false, -33554434, 125);
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        o0 r11 = this.a.g;
        int r12 = r11.k;
        int r14 = r11.l;
        Integer r15 = k();
        CreateMenu.a.a r16 = d();
        Integer r17 = Integer.valueOf(r12);
        Integer r18 = Integer.valueOf(r14);
        Function2 r19 = new com.larus.bmhome.chat.nestedmenu.ui.b(r1, this);
        Function2 r110 = new g(r1, this);
        Function1 r111 = new h(r1, this);
        CreateMenu.a.a r20 = CreateMenuV2.s;
        int r21 = i5.Q();
        r56.getClass();
        Intrinsics.checkNotNullParameter(r3, "items");
        Intrinsics.checkNotNullParameter(r16, "config");
        Intrinsics.checkNotNullParameter(r111, "listener");
        ViewParent r22 = r56.getParent();
        if ((r22 instanceof ViewGroup) == false) goto L20;
        ViewGroup r23 = (ViewGroup) r22;
    L21:
        if (r23 != null) goto L23;
    L29:
        ViewGroup r24 = r23;
        if (r24 == null) goto L32;
        ViewParent r25 = r24.getParent();
    L34:
        if ((r25 instanceof ViewGroup) == false) goto L36;
        ViewGroup r26 = (ViewGroup) r25;
    L37:
        if (r26 == null) goto L39;
        int r27 = r26.indexOfChild(r24);
    L40:
        if (r24 == null) goto L42;
        r6 = r24.getLayoutParams();
    L42:
        if (r24 == null) goto L44;
        r24.removeView(r56);
    L44:
        if (r26 == null) goto L47;
        if (r24 == null) goto L47;
        r26.removeView(r24);
    L47:
        int r112 = r27;
        ViewGroup.LayoutParams r53 = r6;
        ViewGroup r54 = r26;
        View r28 = r56.B(r3, r21, true, false, null, r17, r18, r15, r16, r19, r110, r111);
        if (r53 == null) goto L51;
        r28.setLayoutParams(r53);
    L51:
        if (r54 == null) goto L54;
        if (r112 < 0) goto L54;
        r54.addView(r28, r112);
    L54:
        o0 r29 = this.a.g;
        if (r29.n == false) goto L59;
        Function1<View, Unit> r30 = r29.o;
        if (r30 == null) goto L59;
        r30.invoke(r28);
    L59:
        a(r28);
        return r28;
    L39:
        r27 = -1;
        goto L40
    L36:
        r26 = null;
        goto L37
    L32:
        r25 = null;
        goto L34
    L23:
        if ((r23 instanceof FrameLayout) == false) goto L26;
        r5 = true;
    L26:
        if (r5 == false) goto L29;
        ViewGroup r31 = r23;
        List r32 = r56.K(r3, false, null, r17, r18, r16, r19, r110, r111);
        r56.D(r31, r21, r15);
        r56.L(r32);
        r31.requestLayout();
        r31.invalidate();
        r56.n();
        r28 = r31;
        goto L54
    L20:
        r23 = null;
        goto L21
    }

    public final Triple<View, Integer, Integer> n(View r8, int r9, int r10) {
        View r0 = this.a.c.getRootView();
        if (r0.isAttachedToWindow() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L14;
        return null;
    L14:
        int[] r4 = new int[2];
        r8.getLocationOnScreen(r4);
        int[] r2 = new int[2];
        r0.getLocationOnScreen(r2);
        return new Triple(r0, Integer.valueOf((r4[0] - r2[0]) + r9), Integer.valueOf((((r4[1] + r8.getHeight()) - r2[1]) - r0.getHeight()) + r10));
    L5:
        if (r0.getWindowToken() == null) goto L7;
        r1 = true;
        goto L9
    }

    public final void p(Balloon r4, View r5, boolean r6) {
        if (r6 == false) goto L4;
        PopupShowMethod r0 = this.m;
    L5:
        a r7 = l(r5, r5.getMeasuredWidth(), r5.getMeasuredHeight(), r0);
        if (r6 == false) goto L8;
        this.m = r7.a;
    L8:
        q(r4, this.a.e, r7.d, r7.e);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final boolean r(q.a r15, View r16, boolean r17) {
        di8.n0 r0 = r15.c.getSubMenu();
        if (r0 != null) goto L5;
        return false;
    L5:
        int r1 = com.larus.bmhome.chat.nestedmenu.ui.a.a;
        int r2 = this.a.g.j;
        LinkedHashMap<String, List<d0>> r3 = r15.b;
        Intrinsics.checkNotNullParameter(r0, "subMenu");
        LinkedHashMap<String, List<d0>> r4 = new LinkedHashMap();
        Iterator<T> r5 = r0.b.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        String r6 = (String) r5.next();
        List<d0> r9 = r0.a.get(r6);
        if (r9 == null) goto L7;
        r4.put(r6, r9);
        goto L7
    L11:
        Iterator<Map.Entry<String, List<d0>>> r7 = r0.a.entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        Map.Entry<String, List<d0>> r8 = r7.next();
        String r10 = r8.getKey();
        List<d0> r11 = r8.getValue();
        if (r4.containsKey(r10) == true) goto L13;
        r4.put(r10, r11);
        goto L13
    L17:
        if (r3 != null) goto L19;
        r3 = r4;
    L19:
        List r12 = com.larus.bmhome.chat.nestedmenu.ui.a.a(r4, r2, r3);
        if (((ArrayList) r12).isEmpty() == false) goto L23;
        return false;
    L23:
        if (this.a.a != NestedMenuScene.SETTINGS) goto L25;
        boolean r13 = true;
    L26:
        c r14 = e(this, r12, false, r13, null, 20);
        CreateMenuV2 r18 = r14.a;
        CreateMenuV2 r19 = this.i;
        if (r19 == null) goto L32;
        int r20 = r19.getCurrentMenuWidth();
        int r21 = r18.getCurrentMenuWidth();
        if (r21 != r20) goto L32;
        r18.setMenuWidth(r21 + i5.c());
    L32:
        final int r22 = this.l + 1;
        this.l = r22;
        Balloon r23 = this.h;
        if (r23 == null) goto L35;
        r23.h();
    L35:
        String r24 = r15.a;
        this.o = r24;
        if (r17 == true) goto L38;
    L96:
        Balloon r25 = c(this, r14.b, null, this.i, new o(this), new com.larus.bmhome.chat.nestedmenu.ui.c(this, r22), 2);
        View r26 = r14.b;
        View r27 = this.a.e;
        if (r16.isAttachedToWindow() == true) goto L99;
    L120:
        p(r25, r26, false);
    L121:
        this.h = r25;
        CreateMenuV2 r28 = this.i;
        if (r28 == null) goto L124;
        r28.H(true, new com.larus.bmhome.chat.nestedmenu.ui.d(this));
    L124:
        this.e.invoke(r12);
        return true;
    L99:
        if (r27.isAttachedToWindow() == false) goto L120;
        r26.measure(0, 0);
        int[] r29 = new int[2];
        int[] r30 = new int[2];
        r16.getLocationOnScreen(r29);
        r27.getLocationOnScreen(r30);
        Function1<View, Integer> r31 = this.a.g.q;
        if (r31 == null) goto L104;
        int r32 = ((Number) r31.invoke(r26)).intValue();
    L105:
        View r110 = this.j;
        if (r110 != null) goto L108;
    L115:
        int r33 = (r29[1] - r30[1]) + r26.getPaddingBottom();
        if (r27.getResources().getConfiguration().getLayoutDirection() != 1) goto L118;
        int r34 = -1;
    L119:
        q(r25, r27, r34 * (((r27.getMeasuredWidth() / 2) - (r26.getMeasuredWidth() / 2)) + r32), ((-r26.getMeasuredHeight()) - r27.getMeasuredHeight()) + r33);
        goto L121
    L118:
        r34 = 1;
        goto L119
    L108:
        if (r110.isAttachedToWindow() == false) goto L115;
        if (r110.getWidth() <= 0) goto L115;
        if (r26.getMeasuredWidth() <= 0) goto L115;
        int[] r35 = new int[2];
        r27.getLocationOnScreen(r35);
        int[] r111 = new int[2];
        r110.getLocationOnScreen(r111);
        r32 = (r111[0] + (r26.getMeasuredWidth() / 2)) - (r35[0] + (r27.getWidth() / 2));
        goto L115
    L104:
        r32 = 0;
        goto L105
    L38:
        if (Intrinsics.areEqual(r24, "model") == false) goto L96;
        di8.n0 r36 = r15.c.getSubMenu();
        if (r36 == null) goto L96;
        List<d0> r37 = r36.a.get("model");
        if (r37 != null) goto L46;
        r37 = CollectionsKt.emptyList();
    L46:
        ArrayList r38 = new ArrayList();
        Iterator<T> r39 = r37.iterator();
    L47:
        com.larus.bmhome.chat.nestedmenu.b.C0068b r40 = null;
        if (r39.hasNext() == false) goto L61;
        Object r41 = r39.next();
        f0 r112 = ((d0) r41).c();
        if ((r112 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L52;
        com.larus.bmhome.chat.nestedmenu.b r113 = (com.larus.bmhome.chat.nestedmenu.b) r112;
    L53:
        if (r113 == null) goto L55;
        r40 = r113.a;
    L55:
        if (r40 == null) goto L57;
        boolean r42 = true;
    L58:
        if (r42 == false) goto L47;
        r38.add(r41);
        goto L47
    L57:
        r42 = false;
        goto L58
    L52:
        r113 = null;
        goto L53
    L61:
        if (r38.isEmpty() == true) goto L96;
        List<d0> r43 = r15.b.get("model");
        if (r43 != null) goto L66;
        r43 = CollectionsKt.emptyList();
    L66:
        List<d0> r44 = r43;
        if ((r44 instanceof Collection) == true) goto L69;
    L71:
        Iterator<T> r45 = r44.iterator();
        int r46 = 0;
    L73:
        if (r45.hasNext() == false) goto L88;
        f0 r47 = ((d0) r45.next()).c();
        if ((r47 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L77;
        com.larus.bmhome.chat.nestedmenu.b r48 = (com.larus.bmhome.chat.nestedmenu.b) r47;
    L78:
        if (r48 == null) goto L80;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r49 = r48.a;
    L81:
        if (r49 == null) goto L83;
        boolean r50 = true;
    L84:
        if (r50 == false) goto L73;
        r46 = r46 + 1;
        if (r46 >= 0) goto L73;
        CollectionsKt.throwCountOverflow();
        goto L73
    L83:
        r50 = false;
        goto L84
    L80:
        r49 = null;
        goto L81
    L77:
        r48 = null;
    L88:
        NestedMenuScene r51 = this.a.a;
        NestedMenuScene r52 = NestedMenuScene.SETTINGS;
        String r53 = "setting";
        if (r51 != r52) goto L91;
        String r54 = "setting";
    L92:
        if (r51 == r52) goto L95;
        r53 = "action_bar_model_selector";
    L95:
        int r55 = r38.size();
        JSONObject r56 = new JSONObject();
        Intrinsics.checkNotNullParameter(r54, "currentPage");
        Intrinsics.checkNotNullParameter(r53, "menuEntry");
        Intrinsics.checkNotNullParameter(r56, "params");
        r56.put("current_page", r54);
        r56.put("menu_entry", r53);
        r56.put("folded_model_count", r55);
        r56.put("max_visible_model_count", r46);
        TrackParams r57 = new TrackParams().merge(r56);
        by7.a r58 = new by7.a("model_selector_more_click");
        r58.a.merge(r57);
        r58.b();
        goto L96
    L91:
        r54 = "chat";
        goto L92
    L69:
        if (r44.isEmpty() == false) goto L71;
        r46 = 0;
        goto L88
    L25:
        r13 = false;
        goto L26
    }

    public final a l(View r25, int r26, int r27, PopupShowMethod r28) {
        int r3 = 0;
        r25.measure(0, 0);
        View r4 = this.a.e;
        int[] r6 = new int[2];
        r4.getLocationOnScreen(r6);
        Integer r7 = Integer.valueOf(r26);
        if (r7.intValue() <= 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L9;
        r7 = null;
    L9:
        if (r7 == null) goto L11;
        int r9 = r7.intValue();
    L12:
        Integer r10 = Integer.valueOf(r27);
        if (r10.intValue() <= 0) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L21;
        int r12 = r10.intValue();
    L23:
        if (r4.getResources().getConfiguration().getLayoutDirection() != 1) goto L25;
        int r13 = -1;
    L26:
        o0 r14 = this.a.g;
        View r15 = r14.s;
        NestedMenuPopupStrategy r16 = r14.p;
        NestedMenuPopupStrategy r17 = NestedMenuPopupStrategy.ALIGN_TOP;
        if (r16 != r17) goto L113;
        if (r15 == null) goto L113;
        if (r15.isAttachedToWindow() == false) goto L113;
        if (r4.isAttachedToWindow() == false) goto L113;
        if (this.a.g.v == false) goto L71;
        Rect r2 = new Rect();
        boolean r18 = f(r15, r2);
        int r5 = r2.bottom;
        CreateMenuV2 r19 = this.i;
        if (r19 == null) goto L46;
        Integer r110 = Integer.valueOf(r19.getMeasuredHeight());
        if (r110.intValue() <= 0) goto L40;
        boolean r111 = true;
    L41:
        if (r111 == true) goto L44;
        r110 = null;
    L44:
        if (r110 == null) goto L46;
        int r112 = r110.intValue();
    L47:
        int r20 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(com.larus.utils.i.c(r4.getContext()) - r5, r112 / 2), 0);
        Rect r21 = new Rect();
        if (r18 == true) goto L50;
    L68:
        int r22 = r15.getBottom() + r20;
    L69:
        int r23 = r22;
        int r1 = -i5.e0();
        return new a(PopupShowMethod.ALIGN_TOP, r1, r23, r13 * (((r4.getMeasuredWidth() / 2) - (r9 / 2)) + r1), ((-r12) - r4.getMeasuredHeight()) + r23);
    L50:
        if (f(this.a.d, r21) == false) goto L68;
        b r24 = this.q;
        if (r24 == null) goto L54;
        PopupVerticalSide r113 = r24.a;
    L55:
        if (r113 != null) goto L57;
        int r29 = -1;
    L58:
        if (r29 == (-1)) goto L66;
        if (r29 != 1) goto L61;
        int r30 = r5 - r112;
    L67:
        r22 = ((r30 - r6[1]) + r12) - r25.getPaddingTop();
        goto L69
    L61:
        if (r29 == 2) goto L66;
        throw new NoWhenBranchMatchedException();
    L66:
        r30 = r21.bottom;
        goto L67
    L57:
        r29 = d.a[r113.ordinal()];
        goto L58
    L54:
        r113 = null;
        goto L55
    L40:
        r111 = false;
    L46:
        r112 = RangesKt.coerceAtLeast((r12 - r25.getPaddingTop()) - r25.getPaddingBottom(), 0);
        goto L47
    L71:
        Rect r31 = m(r4);
        Rect r114 = new Rect();
        Rect r115 = new Rect();
        if (r31.isEmpty() == true) goto L113;
        if (r4.getGlobalVisibleRect(r114) == false) goto L113;
        if (r15.getGlobalVisibleRect(r115) == false) goto L113;
        int r32 = r25.getPaddingLeft();
        int r33 = r25.getPaddingTop();
        int r116 = RangesKt.coerceAtLeast(r9 - r25.getPaddingRight(), r32);
        int r117 = r116 - r32;
        int r118 = RangesKt.coerceAtLeast(r12 - r25.getPaddingBottom(), r33) - r33;
        o0 r34 = this.a.g;
        if (r34.v == false) goto L81;
        int r35 = r115.right - r117;
    L84:
        int r119 = r31.left;
        int r36 = r9 / 2;
        int r210 = ((RangesKt.coerceIn(r35, r119, RangesKt.coerceAtLeast(r31.right - r117, r119)) - r114.centerX()) + r36) - r32;
        int r37 = RangesKt.coerceAtLeast(r31.bottom - r114.bottom, 0);
        int r38 = RangesKt.coerceAtLeast(r114.top - r31.top, 0);
        b r39 = this.q;
        if (r39 == null) goto L87;
        PopupVerticalSide r40 = r39.a;
    L88:
        if (r40 != null) goto L90;
        int r41 = -1;
    L92:
        if (r41 == (-1)) goto L102;
        if (r41 != 1) goto L96;
        int r42 = r114.top;
    L109:
        int r43 = r42 - r118;
    L111:
        int r211 = ((r43 - r114.top) + r12) - r33;
        return new a(PopupShowMethod.ALIGN_TOP, r210, r211, r13 * (((r4.getMeasuredWidth() / 2) - r36) + r210), ((-r12) - r4.getMeasuredHeight()) + r211);
    L96:
        if (r41 != 2) goto L99;
        r43 = r114.bottom;
        goto L111
    L99:
        throw new NoWhenBranchMatchedException();
    L102:
        if ((r25.getPaddingBottom() + r118) > r37) goto L105;
        r43 = r114.bottom;
        goto L111
    L105:
        if ((r118 + r33) > r38) goto L107;
        r42 = r114.top;
        goto L109
    L107:
        if (r37 < r38) goto L110;
        r42 = r31.bottom - r25.getPaddingBottom();
        goto L109
    L110:
        r43 = r31.top + r33;
        goto L111
    L90:
        r41 = d.a[r40.ordinal()];
        goto L92
    L87:
        r40 = null;
        goto L88
    L81:
        if (r34.u == false) goto L83;
        r35 = r115.left;
        goto L84
    L83:
        r35 = r115.centerX() - (r117 / 2);
    L113:
        Function1<View, Integer> r44 = this.a.g.q;
        if (r44 == null) goto L116;
        r3 = ((Number) r44.invoke(r25)).intValue();
    L116:
        Function0<Integer> r45 = this.a.g.r;
        if (r45 == null) goto L119;
        int r46 = ((Number) r45.invoke()).intValue();
    L120:
        int r212 = r3;
        int r213 = r46;
        a r47 = new a(PopupShowMethod.ALIGN_TOP, r212, r213, r13 * (((r4.getMeasuredWidth() / 2) - (r9 / 2)) + r3), ((-r12) - r4.getMeasuredHeight()) + r46);
        NestedMenuPopupStrategy r48 = this.a.g.p;
        if (r48 != r17) goto L124;
        return r47;
    L124:
        if (r48 != NestedMenuPopupStrategy.DROP_DOWN) goto L127;
        int r214 = r3;
        int r215 = r46;
        int r216 = r3;
        return new a(PopupShowMethod.DROP_DOWN, r214, r215, r216, -r46);
    L127:
        if (r28 == null) goto L132;
        PopupShowMethod r49 = PopupShowMethod.DROP_DOWN;
        if (r28 != r49) goto L137;
        int r217 = r3;
        int r218 = r46;
        int r219 = r3;
        return new a(r49, r217, r218, r219, -r46);
    L137:
        return r47;
    L132:
        int r50 = r25.getMeasuredHeight();
        Resources r51 = r4.getResources();
        int r52 = WindowDisplayMetricsOverride.apply(r51, r51.getDisplayMetrics()).heightPixels;
        int r53 = r6[1];
        int r54 = r52 - (r4.getHeight() + r53);
        if (r54 >= (r50 + r46)) goto L135;
        if (r54 >= r53) goto L135;
        return r47;
    L135:
        int r220 = r3;
        int r221 = r46;
        int r222 = r3;
        return new a(PopupShowMethod.DROP_DOWN, r220, r221, r222, -r46);
    L119:
        r46 = i5.E();
        goto L120
    L25:
        r13 = 1;
        goto L26
    L21:
        r12 = r25.getMeasuredHeight();
        goto L23
    L15:
        r11 = false;
        goto L16
    L11:
        r9 = r25.getMeasuredWidth();
        goto L12
    L5:
        r8 = false;
        goto L6
    }

    public final void q(Balloon r1, View r2, int r3, int r4) {
        Triple<View, Integer, Integer> r5 = n(r2, r3, r4);
        if (r5 != null) goto L5;
        return;
    L5:
        r1.x((View) r5.getFirst(), ((Number) r5.getSecond()).intValue(), ((Number) r5.getThird()).intValue());
    }

    public NestedMenuPopup(c0 r2, List r3, di8.i0 r4, j0 r5, k0 r6, di8.l0 r7) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "nodes");
        Intrinsics.checkNotNullParameter(r4, "onItemClick");
        Intrinsics.checkNotNullParameter(r5, "onUnEnableClick");
        Intrinsics.checkNotNullParameter(r6, "onNodesShown");
        Intrinsics.checkNotNullParameter(r7, "onDismiss");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        if (Intrinsics.areEqual(r2.b, "fork_conv") == false) goto L15;
        o0 r8 = r2.g;
        if (r8.p != NestedMenuPopupStrategy.ALIGN_TOP) goto L15;
        if (r8.s == null) goto L15;
        if (r8.v == false) goto L11;
    L14:
        boolean r9 = true;
    L16:
        this.p = r9;
        return;
    L11:
        if (r8.h == null) goto L15;
        if (r8.u == true) goto L14;
    L15:
        r9 = false;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [com.larus.bmhome.chat.nestedmenu.ui.l] */
    public static c e(final NestedMenuPopup r52, List r53, boolean r54, boolean r55, Integer r56, int r57) {
        if ((r57 & 8) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r57 & 16) == 0) goto L9;
        Integer r10 = r52.a.g.m;
    L10:
        r52.getClass();
        CreateMenuV2 r3 = new CreateMenuV2(r52.a.c.getContext());
        final LinkedHashMap r4 = new LinkedHashMap();
        List r5 = r53;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
        int r12 = 0;
    L12:
        if (r7.hasNext() == false) goto L25;
        Object r8 = r7.next();
        int r9 = r12 + 1;
        if (r12 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        q r11 = (q) r8;
        if ((r11 instanceof q.a) == false) goto L20;
        r4.put(Integer.valueOf(r12), r11);
        l0 r13 = l0.b(((q.a) r11).d, r12, null, false, -2);
    L22:
        r6.add(r13);
        r12 = r9;
        goto L12
    L20:
        if ((r11 instanceof q.b) == false) goto L24;
        r13 = new l0(r12, 0, null, null, null, null, null, null, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, MenuItemType.SECTION_DIVIDER, null, null, null, null, null, null, null, Integer.valueOf(((q.b) r11).a), null, null, null, null, false, -33554434, 125);
        goto L22
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        o0 r2 = r52.a.g;
        int r14 = r2.k;
        int r15 = r2.l;
        CreateMenu.a.a r16 = r52.d();
        View r17 = CreateMenuV2.C(r3, r6, 0, r54, Integer.valueOf(r14), Integer.valueOf(r15), r10, r16, new l(r4, r52), new m(r4, r52), new n(r4, r52), 26);
        if (r1 == false) goto L32;
        o0 r18 = r52.a.g;
        if (r18.n == false) goto L32;
        Function1<View, Unit> r19 = r18.o;
        if (r19 == null) goto L32;
        r19.invoke(r17);
    L32:
        r52.a(r17);
        return new c(r3, r17);
    L9:
        r10 = r56;
        goto L10
    L5:
        r1 = r55;
        goto L7
    }

    public static Balloon c(final NestedMenuPopup r9, View r10, View r11, CreateMenuV2 r12, Function0 r13, Function0 r14, int r15) {
        if ((r15 & 2) == 0) goto L6;
        r11 = r9.a.e;
    L6:
        if ((r15 & 4) == 0) goto L8;
        r12 = r9.a.g.s;
    L8:
        final CreateMenuV2 r4 = r12;
        if ((r15 & 8) == 0) goto L11;
        r13 = null;
    L11:
        final Function0 r3 = r13;
        Boolean r16 = r9.a.g.y;
        if (r16 == null) goto L14;
        boolean r17 = r16.booleanValue();
    L15:
        com.larus.bmhome.view.screenmenu.d r18 = com.larus.bmhome.view.screenmenu.d.a;
        final boolean r2 = r17;
        final View r5 = r11;
        Function1 r6 = new e(r9, r2, r3, r4, r5);
        return com.larus.bmhome.view.screenmenu.d.a(r18, r11, r10, r17, null, r6, null, r14, 40);
    L14:
        r17 = nda.d.a().sa();
        goto L15
    }
}
