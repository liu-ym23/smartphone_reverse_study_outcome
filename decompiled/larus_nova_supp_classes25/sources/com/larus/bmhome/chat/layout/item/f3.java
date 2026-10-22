package com.larus.bmhome.chat.layout.item;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.cell.view.MessageNoBoxContainerView;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f3 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ c3 c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.ObjectRef e;

    public f3(View r1, int r2, c3 r3, Ref.ObjectRef r4, Ref.ObjectRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (this.b != this.c.e) goto L69;
        RecyclerView r0 = (RecyclerView) this.d.element;
        ConstraintLayout r2 = null;
        if (r0 == null) goto L55;
        int r5 = r0.getChildCount();
        int r6 = Integer.MIN_VALUE;
        ConstraintLayout r8 = null;
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L54;
        ConstraintLayout r9 = r0.getChildAt(r7);
        Object r10 = r9.getTag(2131365552);
        if ((r10 instanceof String) == false) goto L12;
        String r11 = (String) r10;
    L14:
        if ((r9 instanceof MessageNoBoxContainerView) == false) goto L53;
        if (r9 == this.e.element) goto L53;
        ConstraintLayout r12 = (MessageNoBoxContainerView) r9;
        if (r12.getBottom() > ((View) this.e.element).getTop()) goto L53;
        if (r11 == null) goto L21;
        Integer r13 = Integer.valueOf(com.larus.bmhome.social.userchat.model.b0.b(r11));
    L22:
        if (r13 != null) goto L25;
    L26:
        if (r11 != null) goto L28;
    L30:
        boolean r14 = false;
    L31:
        if (r14 == true) goto L34;
        boolean r15 = false;
    L35:
        if (r13 != null) goto L38;
    L39:
        if (r11 != null) goto L41;
    L43:
        boolean r16 = false;
    L44:
        if (r16 == true) goto L47;
        boolean r17 = false;
    L48:
        if (r15 == true) goto L51;
        if (r17 == false) goto L53;
    L51:
        if (r12.getBottom() < r6) goto L53;
        r6 = r12.getBottom();
        r8 = r9;
    L47:
        r17 = true;
        goto L48
    L41:
        if (StringsKt.contains$default(r11, "-clear-context", false, 2, null) != true) goto L43;
        r16 = true;
        goto L44
    L38:
        if (r13.intValue() == 3) goto L47;
    L34:
        r15 = true;
        goto L35
    L28:
        if (StringsKt.contains$default(r11, "-welcome-back", false, 2, null) != true) goto L30;
        r14 = true;
        goto L31
    L25:
        if (r13.intValue() == 4) goto L34;
    L21:
        r13 = null;
    L53:
        r7 = r7 + 1;
        goto L8
    L12:
        r11 = null;
        goto L14
    L54:
        r2 = r8;
    L55:
        List<? extends View> r1 = CollectionsKt.distinct(CollectionsKt.listOfNotNull(new View[]{r2, this.e.element}));
        View r3 = (View) CollectionsKt.lastOrNull(r1);
        this.c.f = r1;
        Iterator<T> r4 = r1.iterator();
    L57:
        if (r4.hasNext() == false) goto L59;
        View r18 = (View) r4.next();
        r18.animate().cancel();
        r18.setAlpha(0.0f);
        r18.setTranslationY(i5.h());
        goto L57
    L59:
        ((View) this.e.element).post(new e3(this.b, this.c, r1, r3));
        return;
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
}
