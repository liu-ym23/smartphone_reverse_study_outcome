package com.larus.bmhome.chat.cotdetail.list.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cotdetail.list.processor.d;
import com.larus.bmhome.chat.cotdetail.list.processor.e;
import com.larus.bmhome.chat.cotdetail.list.processor.f;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.g;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.u0;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import java.util.List;
import kc8.y;
import ke8.r;
import ke8.s;
import ke8.t;
import ke8.u;
import ke8.v;
import ke8.x;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oo8.b;
import st8.a;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class UplinkTextMenuController implements a {
    public final TextView a;
    public final FrameLayout b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final MovementMethod g;
    public Message h;
    public y i;
    public int j;
    public boolean k;
    public ActionMode l;
    public x m;
    public RecyclerView n;
    public ViewTreeObserver o;
    public final s p;
    public final Rect q;
    public final UplinkTextMenuController$outsideSelectionTouchListener$1 r;
    public float s;
    public float t;

    public final boolean d() {
        y r0 = this.i;
        String r1 = null;
        if (r0 == null) goto L5;
        Fragment r2 = r0.a;
    L7:
        if ((r2 instanceof fe8.a) == false) goto L9;
        fe8.a r3 = (fe8.a) r2;
    L10:
        if (r3 == null) goto L15;
        w r4 = r3.vF();
        if (r4 == null) goto L15;
        r1 = r4.a;
    L15:
        if (z2.a.enableMessageMenuTimestamp() == true) goto L17;
    L21:
        return false;
    L17:
        if (Intrinsics.areEqual(r1, "thread") == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r1, "organizer") == false) goto L21;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void e() {
        ViewTreeObserver r0 = this.o;
        if (r0 != null) goto L5;
    L10:
        this.o = null;
        RecyclerView r1 = this.n;
        if (r1 == null) goto L13;
        r1.removeOnItemTouchListener(this.r);
    L13:
        this.n = null;
        x r2 = this.m;
        if (r2 == null) goto L16;
        this.a.removeCallbacks(r2);
    L16:
        this.m = null;
        ActionMode r3 = this.l;
        this.l = null;
        if (r3 == null) goto L20;
        r3.finish();
    L20:
        if (this.k == false) goto L28;
        this.a.clearFocus();
        CharSequence r4 = this.a.getText();
        if ((r4 instanceof Spannable) == false) goto L24;
        Spannable r5 = (Spannable) r4;
    L25:
        if (r5 == null) goto L27;
        Selection.removeSelection(r5);
    L27:
        this.a.setTextIsSelectable(false);
        this.a.setMovementMethod(this.g);
        goto L28
    L24:
        r5 = null;
    L28:
        this.k = false;
        this.a.setCustomSelectionActionModeCallback(null);
        this.a.setOnLongClickListener(new r(this));
        this.a.setClickable(this.c);
        this.a.setLongClickable(this.d);
        this.a.setFocusable(this.e);
        this.a.setFocusableInTouchMode(this.f);
        return;
    L5:
        if (r0.isAlive() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.removeOnWindowFocusChangeListener(this.p);
        goto L10
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, ke8.w] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, ke8.v] */
    public final boolean f() {
        boolean r1 = false;
        if (d() == true) goto L5;
    L39:
        return false;
    L5:
        if (this.k == true) goto L39;
        CharSequence r0 = this.a.getText();
        if (r0 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L39;
        Message r4 = this.h;
        if (r4 != null) goto L18;
        return false;
    L18:
        y r3 = this.i;
        if (r3 == null) goto L39;
        Fragment r5 = r3.a;
        if (r5 == null) goto L39;
        RecyclerView r6 = r3.d;
        if (r6 == null) goto L39;
        final int r7 = this.j;
        int r8 = f.f;
        String r9 = null;
        final f r10 = f.a.a(r5, r4, null);
        final ?? r11 = new v(this, r7, r10);
        final ?? r12 = new ke8.w(this, r7);
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        Intrinsics.checkNotNullParameter(this, "anchorView");
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r11, "onSelect");
        Intrinsics.checkNotNullParameter(r12, "onCopy");
        f r13 = f.a.a(r5, r4, null);
        if (r13 == null) goto L38;
        List<? extends ot8.a> r14 = CollectionsKt.listOf(new l0[]{new l0(2131907407, 2131907407, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(c.b(2130971828, r6.getContext(), 2131241970)), null, false, false, null, null, "choose_text", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127), new l0(2131907401, 2131907401, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(c.b(2130971813, r6.getContext(), 2131241927)), null, false, false, null, null, "copy", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127)});
        CommonMenu r15 = new CommonMenu(r6.getContext());
        g.a(r15);
        u0.a(r15, true);
        r15.i = i5.q();
        Long r16 = Long.valueOf(r4.getCreateTime());
        if (r16.longValue() <= 0) goto L32;
        r1 = true;
    L32:
        if (r1 == true) goto L35;
        r16 = null;
    L35:
        if (r16 == null) goto L37;
        r9 = b.a(r16.longValue() * 1000, true);
    L37:
        r15.g(u0.b(r14, true, r9), new d(r11, r12));
        IAIChatService.a.I7(r5, new e.b(r6), this, r4, r15);
        r13.b(r14);
    L38:
        return true;
    L9:
        if (r0.length() == 0) goto L12;
        r2 = false;
        goto L13
    }

    public final float getClickX() {
        return this.s;
    }

    public final float getClickY() {
        return this.t;
    }

    public final View l5() {
        return this.a;
    }

    public final boolean b(int r2) {
        if (this.j == r2) goto L5;
    L9:
        return false;
    L5:
        if (this.a.isAttachedToWindow() == false) goto L9;
        if (d() == false) goto L9;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ke8.s] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.chat.cotdetail.list.view.UplinkTextMenuController$outsideSelectionTouchListener$1] */
    public UplinkTextMenuController(TextView r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.a = r2;
        this.b = r3;
        this.c = r2.isClickable();
        boolean r4 = r2.isLongClickable();
        this.d = r4;
        this.e = r2.isFocusable();
        this.f = r2.isFocusableInTouchMode();
        this.g = r2.getMovementMethod();
        this.p = new s(this);
        this.q = new Rect();
        this.r = new UplinkTextMenuController$outsideSelectionTouchListener$1(this);
        r2.setOnLongClickListener(new t(this));
        r2.setLongClickable(r4);
        r2.setOnTouchListener(new u(this));
    }

    public static final void a(UplinkTextMenuController r3, Menu r4) {
        r3.getClass();
        int r5 = r4.size() - 1;
    L3:
        if ((-1) >= r5) goto L10;
        int r1 = r4.getItem(r5).getItemId();
        if (r1 == 16908321) goto L9;
        if (r1 == 16908319) goto L9;
        r4.removeItem(r1);
    L9:
        r5 = r5 - 1;
        goto L3
    }

    public final void c(CharSequence r4, String r5) {
        if (d() == true) goto L5;
        return;
    L5:
        s0 r0 = ILegacyChatUiServiceDelegate.b.X8();
        if (r0 == null) goto L10;
        boolean r6 = r0.f(this.a.getContext(), r4);
        boolean r1 = true;
        if (r6 != true) goto L10;
    L11:
        if (r1 == true) goto L13;
        return;
    L13:
        Message r7 = this.h;
        if (r7 == null) goto L22;
        int r2 = f.f;
        y r3 = this.i;
        if (r3 == null) goto L18;
        Fragment r8 = r3.a;
    L19:
        f r9 = f.a.a(r8, r7, null);
        if (r9 == null) goto L22;
        r9.a("copy", r5);
        goto L22
    L18:
        r8 = null;
    L22:
        t19.s r10 = t19.s.a;
        Context r11 = this.a.getContext();
        r10.getClass();
        t19.s.o(r11, 2131910467, false);
        return;
    L10:
        r1 = false;
        goto L11
    }
}
