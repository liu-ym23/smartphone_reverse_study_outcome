package com.ss.android.lark.chat.chatwindow.chat.scroll;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AppendNewMessageScrollStrategy extends ScrollBottomController.b {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ScrollBottomController.d a;
        public final /* synthetic */ AppendNewMessageScrollStrategy b;

        public b(ScrollBottomController.d r1, AppendNewMessageScrollStrategy r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.a.c == true) goto L5;
        L6:
            this.b.b().a.b(0, false);     // Catch: Throwable -> L8
            return;
        L5:
            if (c.a(this.b.b().d()) == false) goto L6;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.scroll.ScrollBottomController.b
    public final Function2<Integer, y6b.c<?>, Boolean> a() {
        return new AppendNewMessageScrollStrategy$getScrollCondition$1(this);
    }

    public AppendNewMessageScrollStrategy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.scroll.ScrollBottomController.b
    public final void c(ScrollBottomController.d r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        RecyclerView r0 = b().d();
        com.ss.android.lark.chat.chatwindow.chat.scroll.a<y6b.c<?>> r1 = b().c();
        y6b.c r2 = (y6b.c) r1.getItem(r1.getItemCount() - 1);
        boolean r3 = r2.i;
        if (r2.G != null) goto L5;
        boolean r4 = true;
    L7:
        if (r8.c == true) goto L11;
        if (r3 == false) goto L19;
        if (r4 == true) goto L11;
        return;
    L19:
        return;
    L11:
        if ((r0 instanceof SceneCoordinateRecyclerView) == true) goto L13;
    L15:
        b().a.b(100, true ^ r2.isPreMessage());
        if (r2.isPreMessage() == false) goto L22;
        r0.postDelayed(new b(r8, this), 300);
        return;
    L22:
        return;
    L13:
        if (((SceneCoordinateRecyclerView) r0).l == false) goto L15;
        b().a.b(0, false);
        return;
    L5:
        r4 = false;
        goto L7
    }
}
