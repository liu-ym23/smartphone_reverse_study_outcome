package jb8;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.larus.bmhome.block.newheader.thinkcontent.DeepThinkContentView;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.bmhome.chat.standarduikit.vlm.view.VLMContainerView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements hb8.a {
    public final Context a;
    public final RelativeLayout b;
    public final List<e> c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public boolean h;
    public final Lazy i;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((e) r1).a), Integer.valueOf(((e) r2).a));
        }
    }

    public final lb8.f b() {
        return (lb8.f) this.g.getValue();
    }

    public final DeepThinkContentView d() {
        return (DeepThinkContentView) this.f.getValue();
    }

    public final tk8.d e() {
        return (tk8.d) this.i.getValue();
    }

    @Override // hb8.a
    public final void f() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        KeyEvent.Callback r1 = ((e) r0.next()).b;
        if ((r1 instanceof hb8.a) == false) goto L8;
        hb8.a r2 = (hb8.a) r1;
    L9:
        if (r2 == null) goto L4;
        r2.f();
        goto L4
    L8:
        r2 = null;
        goto L9
    L11:
        ((ArrayList) this.c).clear();
        this.b.removeAllViews();
    }

    public final VLMContainerView g() {
        return (VLMContainerView) this.d.getValue();
    }

    public final CustomMarkdownTextView c() {
        CustomMarkdownTextView r0 = e().getContentMarkdownView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (d().getParent() != null) goto L8;
        return null;
    L8:
        DeepThinkContentView r1 = d();
        int r2 = r1.getChildCount();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        CustomMarkdownTextView r4 = r1.getChildAt(r3);
        if ((r4 instanceof CustomMarkdownTextView) == true) goto L13;
        r3 = r3 + 1;
        goto L9
    L13:
        return r4;
    L15:
        return null;
    }

    public k(Context r2, MaxHeightRelativeLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.d = LazyKt.lazy(new f(this));
        this.e = LazyKt.lazy(new g(this));
        this.f = LazyKt.lazy(new h(this));
        this.g = LazyKt.lazy(new i(this));
        this.i = LazyKt.lazy(new j(this));
    }

    public final void a(View r3, RelativeLayout.LayoutParams r4, int r5, int r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L32
        if (r3.getParent() == null) goto L5;
        return;
    L5:
        RelativeLayout r1 = this.b;     // Catch: Throwable -> L32
        r3.setId(r5);     // Catch: Throwable -> L32
        r1.addView(r3, r4);     // Catch: Throwable -> L32
        ((ArrayList) this.c).add(new e(r6, r3, r5));     // Catch: Throwable -> L32
        ArrayList r7 = (ArrayList) this.c;     // Catch: Throwable -> L32
        if (r7.size() <= 1) goto L8;
        CollectionsKt.sortWith(r7, new a());     // Catch: Throwable -> L32
    L8:
        int r8 = ((ArrayList) this.c).size();     // Catch: Throwable -> L32
        int r9 = 0;
    L9:
        if (r9 >= r8) goto L30;
        e r10 = (e) CollectionsKt.getOrNull(this.c, r9);     // Catch: Throwable -> L32
        Integer r11 = null;
        if (r10 == null) goto L15;
        View r12 = r10.b;     // Catch: Throwable -> L32
        if (r12 == null) goto L15;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();     // Catch: Throwable -> L32
    L17:
        if ((r13 instanceof RelativeLayout.LayoutParams) == false) goto L19;
        RelativeLayout.LayoutParams r14 = (RelativeLayout.LayoutParams) r13;     // Catch: Throwable -> L32
    L20:
        if (r9 != 0) goto L23;
        if (r14 == null) goto L29;
        r14.addRule(10);     // Catch: Throwable -> L32
    L29:
        r9 = r9 + 1;     // Catch: Throwable -> L32
        goto L9
    L23:
        e r2 = (e) CollectionsKt.getOrNull(this.c, r9 - 1);     // Catch: Throwable -> L32
        if (r2 == null) goto L26;
        r11 = Integer.valueOf(r2.c);     // Catch: Throwable -> L32
    L26:
        if (r11 == null) goto L29;
        if (r14 == null) goto L29;
        r14.addRule(3, r11.intValue());     // Catch: Throwable -> L32
        goto L29
    L19:
        r14 = null;
    L15:
        r13 = null;
        goto L17
    L30:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
