package ut8;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.TraceCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.api.d0;
import com.larus.bmhome.utils.e2;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b {
    public Context a;
    public final ViewTreeObserverOnScrollChangedListenerC0137b b;
    public final c c;
    public View d;
    public Spannable e;
    public final int[] f;
    public final Rect g;
    public i h;
    public int i;
    public i j;
    public int k;
    public int l;
    public int m;
    public final int n;
    public final BackgroundColorSpan o;
    public boolean p;
    public final Set<st8.c> q;
    public final g r;
    public d0 s;
    public final f t;
    public ut8.f u;
    public final d v;
    public final e w;

    public class a implements g.a {
        public final /* synthetic */ b a;

        @Override // ut8.g.a
        public final void onStart() {
        }

        @Override // ut8.g.a
        public final void b() {
            this.a.l();
        }

        @Override // ut8.g.a
        public final void onStop() {
            b r0 = this.a;
            if (r0.h != null) goto L5;
            return;
        L5:
            if (r0.j == null) goto L9;
            r0.o();
            return;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: ut8.b$b, reason: collision with other inner class name */
    public class ViewTreeObserverOnScrollChangedListenerC0137b implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ b a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            b r0 = this.a;
            if (r0.p == false) goto L15;
            int[] r1 = r0.f;
            float r3 = r1[1];
            r0.d.getLocationInWindow(r1);
            b r2 = this.a;
            if (r3 == r2.f[1]) goto L16;
            g r4 = r2.r;
            if (r4.a == true) goto L11;
            r4.a = true;
            g.a r5 = r4.b;
            if (r5 == null) goto L11;
            r5.onStart();
        L11:
            g.a r6 = r4.b;
            if (r6 == null) goto L17;
            r6.b();
            return;
        L17:
            return;
        L16:
            return;
        }

        public ViewTreeObserverOnScrollChangedListenerC0137b(b r1) {
            this.a = r1;
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ b a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            b r0 = this.a;
            if (r0.p == false) goto L17;
            View r1 = r0.d;
            if (r1 == null) goto L7;
            r1.removeCallbacks(r0.v);
            r0.d.postDelayed(r0.v, 100);
        L7:
            b r2 = this.a;
            int[] r3 = r2.f;
            float r4 = r3[1];
            r2.d.getLocationInWindow(r3);
            b r5 = this.a;
            if (r4 != r5.f[1]) goto L18;
            g r6 = r5.r;
            if (r6 != null) goto L12;
            return;
        L12:
            if (r6.a == false) goto L20;
            r6.a = false;
            g.a r7 = r6.b;
            if (r7 == null) goto L21;
            r7.onStop();
            return;
        L21:
            return;
        L20:
            return;
        L18:
            return;
        }

        public c(b r1) {
            this.a = r1;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ b a;

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L9
            if (r0.p == true) goto L5;
            return;
        L5:
            if (r0.r.a == true) goto L16;
            r0.l();     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public d(b r1) {
            this.a = r1;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ b a;

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L10
            if (r0.r.a == true) goto L15;
            View r1 = r0.d;     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            r0.i();     // Catch: Throwable -> L10
            goto L15
        L8:
            r1.post(new ut8.e(this));     // Catch: Throwable -> L10
        L15:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public e(b r1) {
            this.a = r1;
        }
    }

    public class f implements Runnable {
        public Pair<Integer, Integer> a;
        public Pair<Integer, Integer> b;
        public final /* synthetic */ b c;

        public final void a() {
            if (this.c.r.a == false) goto L6;
            FLogger.a.i("BaseWordSelector", "SelectorOutsideClickTask.run reset by scrolling");
            b();
            return;
        L6:
            Pair<Integer, Integer> r0 = this.b;
            if (Objects.equals(r0.first, r0.second) == false) goto L21;
            Pair<Integer, Integer> r1 = this.a;
            if (Objects.equals(r1.first, r1.second) == false) goto L21;
            if (((Integer) this.b.first).intValue() == 0) goto L21;
            d0 r2 = this.c.s;
            if (((Integer) this.a.first).intValue() != 1) goto L16;
            if (r2 == null) goto L16;
        L17:
            if (r2 == null) goto L19;
            FLogger.a.i("BaseWordSelector", "SelectorOutsideClickTask.run -> onClickWhenSelected, totalCount=" + this.b.first + ", selectedAreaFirst=" + this.a.first);
            r2.a(this.c.d, ((Integer) this.b.first).intValue(), ((Integer) this.a.first).intValue());
        L19:
            b();
            return;
        L16:
            FLogger.a.i("BaseWordSelector", "SelectorOutsideClickTask.run -> hideTask.run(), callback=" + r2 + ", selectedAreaFirst=" + this.a.first);
            this.c.w.run();
        L21:
            FLogger.a.i("BaseWordSelector", "SelectorOutsideClickTask.run reset by invalid count, totalCount=" + this.b + ", selectedAreaCount=" + this.a);
            b();
        }

        public final void b() {
            ((Integer) this.b.first).intValue();
            ((Integer) this.b.second).intValue();
            this.a = new Pair(0, 0);
            this.b = new Pair(0, 0);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(b r2) {
            this.c = r2;
            this.a = new Pair(0, 0);
            this.b = new Pair(0, 0);
        }
    }

    public abstract Rect f();

    public abstract Layout g();

    public abstract CharSequence h();

    public void i() {
        this.p = false;
        i r1 = this.h;
        if (r1 == null) goto L12;
        PopupWindow r3 = r1.a;
        if (r3 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r3);     // Catch: Exception -> L10
        r3.dismiss();     // Catch: Exception -> L10
        i.b r2 = r1.i;     // Catch: Exception -> L10
        if (r2 == null) goto L12;
        ((ut8.a) r2).a.i = -1;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        i r4 = this.j;
        if (r4 == null) goto L22;
        PopupWindow r5 = r4.a;
        if (r5 == null) goto L22;
        PopupWindowLancet.handleDismissBeforeOrigin(r5);     // Catch: Exception -> L20
        r5.dismiss();     // Catch: Exception -> L20
        i.b r6 = r4.i;     // Catch: Exception -> L20
        if (r6 == null) goto L22;
        ((ut8.a) r6).a.i = -1;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L22:
        Object r7 = this.d;
        if (r7 != null) goto L25;
    L49:
        this.l = 0;
        this.m = 0;
        return;
    L25:
        if ((r7 instanceof CustomMarkdownTextView) == false) goto L46;
        MarkwonContent r8 = ((CustomMarkdownTextView) r7).getMarkwonContent();
        if (r8 == null) goto L46;
        SpannableStringBuilder r9 = r8.a;
        List r10 = ArraysKt.toList(r9.getSpans(0, r9.length(), wsc.f.class));
        int r11 = e2.a;
        int r12 = this.l;
        int r13 = this.m;
        Intrinsics.checkNotNullParameter(r8, "markwon");
        Intrinsics.checkNotNullParameter(r10, "l");
        ArrayList r14 = new ArrayList();
        Iterator r15 = r10.iterator();
    L30:
        if (r15.hasNext() == false) goto L34;
        Object r16 = r15.next();
        if ((r16 instanceof io.noties.markwon.ext.onetex.c) == false) goto L30;
        r14.add(r16);
        goto L30
    L34:
        Iterator r17 = r14.iterator();
    L36:
        if (r17.hasNext() == false) goto L46;
        io.noties.markwon.ext.onetex.c r18 = (io.noties.markwon.ext.onetex.c) r17.next();
        int r19 = r8.a.getSpanStart(r18);
        int r20 = r8.a.getSpanStart(r18);
        if (r19 < r12) goto L36;
        if (r20 > r13) goto L36;
        if ((r18 instanceof io.noties.markwon.ext.onetex.c) == true) goto L44;
        r18 = null;
    L44:
        if (r18 == null) goto L36;
        r18.g = 0;
    L46:
        Spannable r21 = (Spannable) h();
        this.e = r21;
        if (r21 == null) goto L49;
        r21.removeSpan(this.o);
        this.d.invalidate();
        goto L49
    }

    public abstract void j();

    public abstract void k(Layout r1, int r2, i r3, boolean r4);

    public abstract void p(boolean r1, int r2, int r3);

    public final void l() {
        if (this.d != null) goto L5;
        return;
    L5:
        Layout r0 = g();
        this.d.getLocationInWindow(this.f);
        i r1 = this.h;
        if (r1 == null) goto L8;
        r1.removeCallbacks(this.w);
        this.h.removeCallbacks(this.t);
    L8:
        i r2 = this.j;
        if (r2 == null) goto L11;
        r2.removeCallbacks(this.w);
        this.j.removeCallbacks(this.t);
    L11:
        this.t.b();
        int r3 = this.l;
        i r4 = this.h;
        if (r4.d == false) goto L14;
        boolean r5 = r4.f;
    L16:
        if (r5 == true) goto L19;
        r4 = this.j;
    L19:
        k(r0, r3, r4, true);
        int r6 = this.m;
        i r7 = this.h;
        if (r7.d == false) goto L22;
        boolean r8 = r7.f;
    L23:
        if (r8 == false) goto L26;
        r7 = this.j;
    L26:
        k(r0, r6, r7, false);
        return;
    L22:
        r8 = r7.e;
        goto L23
    L14:
        r5 = r4.e;
        goto L16
    }

    public final void m() {
        if (this.d != null) goto L5;
        return;
    L5:
        n();
        int r0 = this.l;
        if (r0 >= 0) goto L8;
    L35:
        this.d.invalidate();
        TraceCompat.endSection();
        return;
    L8:
        if (this.m <= r0) goto L35;
        BreakIterator r1 = BreakIterator.getCharacterInstance();
        r1.setText(this.e.toString());
        this.l = e(r1, Integer.valueOf(this.l)).intValue();
        this.m = d(r1, Integer.valueOf(this.m)).intValue();
        Object r2 = this.d;
        if ((r2 instanceof CustomMarkdownTextView) == false) goto L35;
        MarkwonContent r3 = ((CustomMarkdownTextView) r2).getMarkwonContent();
        if (r3 == null) goto L35;
        SpannableStringBuilder r4 = r3.a;
        List r5 = ArraysKt.toList(r4.getSpans(0, r4.length(), wsc.f.class));
        int r6 = e2.a;
        int r7 = this.l;
        int r8 = this.m;
        int r9 = this.n;
        Intrinsics.checkNotNullParameter(r3, "markwon");
        Intrinsics.checkNotNullParameter(r5, "l");
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r12 = r11.next();
        if ((((wsc.f) r12) instanceof io.noties.markwon.ext.onetex.c) == false) goto L15;
        r10.add(r12);
        goto L15
    L19:
        Iterator r13 = r10.iterator();
    L21:
        if (r13.hasNext() == false) goto L35;
        io.noties.markwon.ext.onetex.c r14 = (wsc.f) r13.next();
        int r15 = r3.a.getSpanStart(r14);
        int r16 = r3.a.getSpanStart(r14);
        io.noties.markwon.ext.onetex.c r17 = null;
        if (r15 < r7) goto L31;
        if (r16 > r8) goto L31;
        if ((r14 instanceof io.noties.markwon.ext.onetex.c) == false) goto L28;
        r17 = r14;
    L28:
        if (r17 == null) goto L21;
        r17.g = r9;
    L31:
        if ((r14 instanceof io.noties.markwon.ext.onetex.c) == false) goto L33;
        r17 = r14;
    L33:
        if (r17 == null) goto L21;
        r17.g = 0;
        goto L21
    }

    public final void n() {
        Spannable r0 = (Spannable) h();
        this.e = r0;
        if (r0 == null) goto L34;
        int r1 = this.l;
        int r2 = this.m;
        if (r1 < 0) goto L23;
        if (r2 <= r1) goto L23;
        if (r2 > r0.length()) goto L23;
        String r3 = r0.subSequence(r1, r2).toString();
        ArrayList r4 = new ArrayList();
        r4.add("\n");
        r4.add("\n ");
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L18;
        String r6 = (String) r5.next();
        if (r3.startsWith(r6) == false) goto L16;
        r1 = r1 + r6.length();
    L16:
        if (r3.endsWith(r6) == false) goto L11;
        r2 = r2 - r6.length();
        goto L11
    L18:
        if (r1 < 0) goto L23;
        if (r2 <= r1) goto L23;
        if (r2 > r0.length()) goto L23;
        this.l = r1;
        this.m = r2;
    L23:
        int r7 = this.l;
        if (r7 >= 0) goto L26;
        return;
    L26:
        if (this.m <= r7) goto L36;
        BreakIterator r8 = BreakIterator.getCharacterInstance();
        r8.setText(this.e.toString());
        this.l = e(r8, Integer.valueOf(this.l)).intValue();
        this.m = d(r8, Integer.valueOf(this.m)).intValue();
        FLogger.a.i("TextSelector", "getSafeStartPos process, mStartCursorPos = " + this.l + ", mEndCursorPos = " + this.m);
        this.e.setSpan(this.o, this.l, this.m, 17);
        return;
    L36:
        return;
    }

    public void o() {
        l();
    }

    public b(View r6) {
        int[] r0 = new int[2];
        this.f = r0;
        this.g = new Rect();
        this.i = -1;
        this.k = -1;
        this.p = false;
        this.q = Collections.newSetFromMap(new WeakHashMap());
        this.t = new f(this);
        this.v = new d(this);
        this.w = new e(this);
        Context r2 = r6.getContext();
        this.a = r2;
        this.d = r6;
        int r3 = ContextCompat.getColor(r2, 2131103318);
        this.n = r3;
        this.o = new BackgroundColorSpan(r3);
        g r4 = new g();
        this.r = r4;
        a r5 = new a(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r4.b = r5;
        View r7 = this.d;
        if ((r7 instanceof TextView) == false) goto L6;
        ((TextView) r7).setTextIsSelectable(false);
    L6:
        if ((r6 instanceof TextView) == false) goto L8;
        TextView r8 = (TextView) r6;
        r8.setText(r8.getText(), TextView.BufferType.SPANNABLE);
    L8:
        i r9 = new i(this.a);
        this.h = r9;
        r9.setIsStartCursor(true);
        this.h.setChangeListener(new ut8.a(this));
        this.h.setTouchMoveListener(new ut8.c(this));
        i r10 = new i(this.a);
        this.j = r10;
        r10.setIsStartCursor(false);
        this.j.setTouchMoveListener(new ut8.d(this));
        this.d.getLocationInWindow(r0);
        ViewTreeObserverOnScrollChangedListenerC0137b r11 = new ViewTreeObserverOnScrollChangedListenerC0137b(this);
        this.b = r11;
        this.d.getViewTreeObserver().addOnScrollChangedListener(r11);
        c r12 = new c(this);
        this.c = r12;
        this.d.getViewTreeObserver().addOnGlobalLayoutListener(r12);
    }

    public static Integer d(BreakIterator r1, Integer r2) {
        if (r1.isBoundary(r2.intValue()) == false) goto L5;
        int r3 = r2.intValue();     // Catch: Exception -> L8
    L6:
        return Integer.valueOf(r3);
    L5:
        r3 = r1.following(r2.intValue());     // Catch: Exception -> L8
    L9:
        return Integer.valueOf(r1.getText().getEndIndex());
    }

    public static Integer e(BreakIterator r1, Integer r2) {
        if (r1.isBoundary(r2.intValue()) == false) goto L5;
        int r3 = r2.intValue();     // Catch: Exception -> L8
    L6:
        return Integer.valueOf(r3);
    L5:
        r3 = r1.preceding(r2.intValue());     // Catch: Exception -> L8
    L9:
        return Integer.valueOf(r1.getText().getBeginIndex());
    }

    public static void b(b r8, boolean r9, boolean r10) {
        d0 r0 = r8.s;
        if (r9 == true) goto L17;
        if (r0 == null) goto L18;
        Rect r6 = r8.f();
        CharSequence r11 = r8.h();
        if (r11 == null) goto L14;
        int r1 = r8.l;
        if (r1 < 0) goto L14;
        int r2 = r8.m;
        if (r2 <= r1) goto L14;
        if (r2 > r11.length()) goto L14;
        String r12 = r11.subSequence(r8.l, r8.m).toString();
    L15:
        SelectionRangeType r3 = SelectionRangeType.CUSTOM_RANGE;
        int r4 = r8.l;
        int r5 = r8.m;
        r0.b(r3, r4, r5, true, r10, r6, r12);
        return;
    L14:
        r12 = "";
        goto L15
    L18:
        return;
    }

    public static void c(b r9, i r10, MotionEvent r11, boolean r12) {
        boolean r0 = false;
        if (r11 == null) goto L26;
        View r2 = r9.d;
        if (r2 == null) goto L26;
        int[] r3 = new int[2];     // Catch: Exception -> L25
        r2.getLocationOnScreen(r3);     // Catch: Exception -> L25
        int r4 = r3[0];     // Catch: Exception -> L25
        int r5 = r3[1];     // Catch: Exception -> L25
        float r6 = r11.getRawX() - r4;     // Catch: Exception -> L25
        float r13 = r11.getRawY() - r5;     // Catch: Exception -> L25
        if (r6 < 0.0f) goto L26;
        if (r6 > r9.d.getWidth()) goto L26;
        if (r13 < 0.0f) goto L26;
        if (r13 > r9.d.getHeight()) goto L26;
        View r7 = r9.d;     // Catch: Exception -> L25
        if ((r7 instanceof TextView) == false) goto L26;
        int r14 = j.a((TextView) r7, (int) r6, (int) r13);     // Catch: Exception -> L25
        if (r14 < r9.l) goto L26;
        if (r14 > r9.m) goto L26;
        boolean r15 = true;
    L27:
        f r8 = r9.t;
        r8.getClass();
        if (r15 == false) goto L32;
        if (r12 == false) goto L31;
        r8.a = new Pair(Integer.valueOf(((Integer) r8.a.first).intValue() + 1), (Integer) r8.a.second);
        goto L32
    L31:
        Pair<Integer, Integer> r16 = r8.a;
        r8.a = new Pair((Integer) r16.first, Integer.valueOf(((Integer) r16.second).intValue() + 1));
    L32:
        if (r12 == false) goto L34;
        r8.b = new Pair(Integer.valueOf(((Integer) r8.b.first).intValue() + 1), (Integer) r8.b.second);
    L35:
        FLogger r17 = FLogger.a;
        r17.i("BaseWordSelector", "SelectorOutsideClickTask.count, isStartCursor=" + r12 + ", isInSelectedArea=" + r15 + ", totalCount=" + r8.b + ", selectedAreaCount=" + r8.a);
        r17.i("BaseWordSelector", "onOutsideTouchedByInternal, isStartCursor=" + r12 + ", isInSelectedArea=" + r15 + ", totalCount=" + r9.t.b + ", selectedAreaCount=" + r9.t.a);
        f r18 = r9.t;
        if ((((Integer) r18.b.first).intValue() + ((Integer) r18.b.second).intValue()) != 1) goto L38;
        r0 = true;
    L38:
        if (r0 == false) goto L43;
        r17.i("BaseWordSelector", "onOutsideTouchedByInternal firstClick -> call onTouchOutside and post SelectorOutsideClickTask");
        r9.j();
        r10.postDelayed(r9.t, 300);
        return;
    L43:
        return;
    L34:
        Pair<Integer, Integer> r19 = r8.b;
        r8.b = new Pair((Integer) r19.first, Integer.valueOf(((Integer) r19.second).intValue() + 1));
    L26:
        r15 = false;
        goto L27
    }

    private void update(boolean r2, boolean r3, int r4, int r5) {
        if (this.d != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L13;
        int r6 = this.l;
        int r7 = this.m;
        if (r6 != r7) goto L14;
        if (r6 <= 0) goto L11;
        this.l = r6 - 1;
        goto L14
    L11:
        if (r7 >= (h().length() - 1)) goto L14;
        this.m++;
    L14:
        m();
        l();
        return;
    L13:
        p(r2, r4, r5);
        goto L14
    }

    public static /* synthetic */ void a(b r0, boolean r1, boolean r2, int r3, int r4) {
        r0.update(r1, r2, r3, r4);
    }
}
