package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> {
    public static final int p = 0;
    public final RecyclerView a;
    public final RecyclerView.Adapter<?> b;
    public final b<T> c;
    public int d;
    public final List<d<T>> e;
    public final List<InterfaceC0082c<T>> f;
    public final AndroidThrottle<T> g;
    public boolean h;
    public int i;
    public int j;
    public final com.larksuite.framework.callback.c k;
    public final Handler l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;

    public static final class a {
    }

    public interface b<T> {
        String a(T r1);

        y6b.c getItem(int r1);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.widget.c$c, reason: collision with other inner class name */
    public interface InterfaceC0082c<T> {
        void a(List<? extends T> r1);

        void b(boolean r1, int r2, int r3);

        void c();
    }

    public interface d<T> {
        boolean a();
    }

    public static final class e implements Runnable {
        public final /* synthetic */ c<T> a;
        public final /* synthetic */ ArrayList<T> b;

        public e(c<T> r1, ArrayList<T> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<InterfaceC0082c<T>> r0 = this.a.f;     // Catch: Throwable -> L7
            ArrayList<T> r1 = this.b;     // Catch: Throwable -> L7
            Iterator r2 = ((CopyOnWriteArrayList) r0).iterator();     // Catch: Throwable -> L7
        L4:
            if (r2.hasNext() == false) goto L16;
            ((InterfaceC0082c) r2.next()).a(new ArrayList(r1));     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
        p = UIHelper.dp2px(12.0f);
    }

    public final void b(Collection<? extends T> r6) {
        ArrayList r0 = new ArrayList();
        Iterator<? extends T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        T r1 = r7.next();
        Iterator r2 = ((ArrayList) this.e).iterator();
        boolean r3 = true;
    L7:
        if (r2.hasNext() == false) goto L9;
        r3 = r3 & ((d) r2.next()).a();
        goto L7
    L9:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L11:
        CoreThreadPool.getDefault().getUIExecutor().execute(new e(this, r0));
    }

    public final synchronized void c(InterfaceC0082c<T> r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L6
        ((CopyOnWriteArrayList) this.f).add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static final void a(c r4, boolean r5) {
        LinearLayoutManager r0 = r4.a.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
        int r2 = r1.findFirstVisibleItemPosition();
        int r3 = r1.findLastVisibleItemPosition();
    L6:
        if (r2 < 0) goto L15;
        if (r3 < 0) goto L15;
        int r6 = r4.i;
        if (r2 != r6) goto L18;
        int r7 = r4.j;
        if (r3 != r7) goto L18;
        if ((r6 + r7) > 0) goto L15;
    L18:
        r4.i = r2;
        r4.j = r3;
        Log.d("RecyclerViewItemDetector", "collectCurrentPageData:" + r2 + '/' + r3 + '/' + r5 + '/' + p);
        Iterator r8 = ((CopyOnWriteArrayList) r4.f).iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        ((InterfaceC0082c) r8.next()).b(r5, r2, r3);
        goto L20
    L22:
        ArrayList r9 = new ArrayList();
        if (r2 > r3) goto L30;
    L24:
        y6b.c r10 = r4.c.getItem(r2);
        if (r10 == null) goto L27;
        r9.add(r10);
    L27:
        if (r2 == r3) goto L30;
        r2 = r2 + 1;
    L30:
        if (r4.h == false) goto L32;
        r4.b(r9);
        r4.h = false;
        return;
    L32:
        r4.g.e(r9);
        return;
    L15:
        if (((Boolean) r4.m.getValue()).booleanValue() == false) goto L36;
        if (r5 == false) goto L18;
        return;
    L36:
        return;
    L5:
        r2 = -1;
        r3 = -1;
        goto L6
    }

    public c(SceneCoordinateRecyclerView r3, RecyclerView.Adapter r4, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.e r5) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        Intrinsics.checkNotNullParameter(r5, "dataProvider");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.e = new ArrayList();
        this.f = new CopyOnWriteArrayList();
        this.h = true;
        Handler r6 = CoreThreadPool.getNonblockingHandler();
        this.l = r6;
        this.m = LazyKt.lazy(RecyclerViewItemDetector$isCardTranslateFg$2.INSTANCE);
        AndroidThrottle.a r7 = new AndroidThrottle.a();
        r7.b = 300;
        r7.d = new com.ss.android.lark.chat.chatwindow.chat.v2.widget.a(r5);
        r7.a = r6;
        r7.e = new com.ss.android.lark.chat.chatwindow.chat.v2.widget.b(this);
        this.g = new AndroidThrottle(r7);
        this.k = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        this.n = LazyKt.lazy(new RecyclerViewItemDetector$mScrollListener$2(this));
        this.o = LazyKt.lazy(new RecyclerViewItemDetector$mDataObserver$2(this));
    }
}
