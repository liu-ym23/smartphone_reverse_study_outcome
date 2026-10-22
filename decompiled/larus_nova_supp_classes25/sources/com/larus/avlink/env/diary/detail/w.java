package com.larus.avlink.env.diary.detail;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.chat.common.databinding.LarusLayoutMessageMenuNewBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w implements sr9.e0, st8.b.c {
    public final Fragment a;
    public final CustomMarkdownTextView b;
    public final Function0<Unit> c;
    public Balloon d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    public final Lazy i;
    public final y j;

    public static final class a {
    }

    static {
    }

    public final void l0(CommonMenu r2) {
        Intrinsics.checkNotNullParameter(r2, "menu");
    }

    public final void d() {
        CustomMarkdownTextView r0 = this.b;
        r0.getClass();
        Context r1 = r0.getContext();
        final View r2 = null;
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r3 = (Activity) r1;
    L6:
        if (r3 == null) goto L14;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L14;
        r2 = r4.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L14:
        if (r2 == null) goto L17;
        r2.post(new r(this, r2));
        return;
    L17:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onShow() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.g = true;
        FLogger.a.i("DiaryMenuTrigger", "onShow");
        c(this.b.getContext());
        d();
    }

    public final void a(boolean r2) {
        b(r2, false);
    }

    public final void c(Context r2) {
        LarusLayoutMessageMenuNewBinding r3 = LarusLayoutMessageMenuNewBinding.a(LayoutInflater.from(r2));
        e1.x(r3.f);
        e1.o(r3.h);
        e1.o(r3.i);
        this.b.A(this.j);
        this.b.x(this.j);
        Balloon r4 = this.d;
        if (r4 == null) goto L5;
        r4.h();
    L5:
        tt8.b r5 = this.b.getTextSelector();
        if (r5 == null) goto L9;
        r5.E = this;
        return;
    }

    public final Object invoke(Object r5) {
        ot8.a r6 = (ot8.a) r5;
        Intrinsics.checkNotNullParameter(r6, "item");
        int r7 = r6.getId();
        if (r7 != 2131907401) goto L9;
        CustomMarkdownTextView r0 = this.b;     // Catch: Exception -> L7
        r0.G3(r0.getMarkdownContent(), true);     // Catch: Exception -> L7
        CustomMarkdownTextView r1 = this.b;     // Catch: Exception -> L7
        r1.getClass();     // Catch: Exception -> L7
        r1.clearFocus();     // Catch: Exception -> L7
        t19.s r2 = t19.s.a;     // Catch: Exception -> L7
        Context r3 = this.a.getContext();     // Catch: Exception -> L7
        r2.getClass();     // Catch: Exception -> L7
        t19.s.o(r3, 2131910467, false);     // Catch: Exception -> L7
        this.c.invoke();     // Catch: Exception -> L7
    L21:
        return Unit.INSTANCE;
    L7:
        t19.s r4 = t19.s.a;
        Context r8 = this.a.getContext();
        r4.getClass();
        t19.s.s(r8, 2131910467);
        goto L21
    L9:
        if (r7 != 2131907407) goto L21;
        this.c.invoke();
        Context r9 = this.a.getContext();
        if (r9 == null) goto L21;
        c(r9);
        tt8.b r10 = this.b.getTextSelector();
        if (r10 == null) goto L16;
        ((ut8.b) r10).s = (x) this.i.getValue();
    L16:
        tt8.b r11 = this.b.getTextSelector();
        if (r11 == null) goto L19;
        r11.r((int) this.b.getClickX(), (int) this.b.getClickY(), 2, false);
    L19:
        d();
        goto L21
    }

    public final void b(boolean r6, boolean r7) {
        if (r6 == true) goto L12;
        if (r7 == true) goto L12;
        long r8 = SystemClock.elapsedRealtime();
        if ((r8 - this.h) <= 300) goto L12;
        this.h = r8;
        Balloon r9 = this.d;
        boolean r10 = false;
        if (r9 != null) goto L9;
    L11:
        this.g = r10;
        goto L12
    L9:
        if (r9.g != true) goto L11;
        r10 = true;
    L12:
        FLogger.a.i("DiaryMenuTrigger", "onDismiss");
        Balloon r11 = this.d;
        if (r11 == null) goto L15;
        r11.h();
    L15:
        this.d = null;
    }

    public w(Fragment r2, CustomMarkdownTextView r3, z r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "markdownView");
        Intrinsics.checkNotNullParameter(r4, "onDismiss");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.g = true;
        this.i = LazyKt.lazy(new q(this));
        this.j = new y(this);
    }
}
