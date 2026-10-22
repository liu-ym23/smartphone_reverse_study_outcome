package com.ss.android.lark.movable;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableCallback;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.attatchment.i;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MovableGlobalManager implements MovableCallback {
    public static final b d = null;
    public static volatile MovableGlobalManager e;
    public static volatile List<String> f;
    public static int g;
    public final Lazy a;
    public final ReferenceQueue<MovableCallback> b;
    public final ConcurrentHashMap<Integer, c> c;

    public static final class a implements Runnable {
        public final /* synthetic */ MovableGlobalManager a;

        public a(MovableGlobalManager r1) {
            this.a = r1;
        }

        public final void a() {
        L12:
            Reference<? extends MovableCallback> r0 = this.a.b.remove();     // Catch: InterruptedException -> L9
            if ((r0 instanceof c) == false) goto L5;
            c r1 = (c) r0;     // Catch: InterruptedException -> L9
        L6:
            if (r1 == null) goto L12;
            MovableGlobalManager r2 = this.a;     // Catch: InterruptedException -> L9
            r2.getClass();     // Catch: InterruptedException -> L9
            MovableGlobalManager.d(new f(r1, r2));     // Catch: InterruptedException -> L9
            goto L12
        L5:
            r1 = null;
        L9:
            e = move-exception;
            Log.w("RenderPoolFfi", "MovableViewReferenceQueue interrupted: " + e.getMessage());
            ThreadMethodProxy.currentThread().interrupt();
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

    public static final class b {
        public final MovableGlobalManager a() {
            MovableGlobalManager r0 = MovableGlobalManager.e;
            if (r0 != null) goto L15;
            monitor-enter(this);
            r0 = MovableGlobalManager.e;     // Catch: Throwable -> L9
            if (r0 != null) goto L11;
            r0 = new MovableGlobalManager();     // Catch: Throwable -> L9
            MovableGlobalManager.e = r0;     // Catch: Throwable -> L9
            Lark_markdown_renderKt.ffiInitRenderPoolService(r0);     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r0;
        }

        public b() {
        }
    }

    public static final class c extends WeakReference<MovableCallback> {
        public final int a;

        public c(int r2, MovableCallback r3, ReferenceQueue<MovableCallback> r4) {
            Intrinsics.checkNotNullParameter(r3, "proxy");
            Intrinsics.checkNotNullParameter(r4, "queue");
            super(r3, r4);
            this.a = r2;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MovableGlobalManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public d(MovableGlobalManager r1, int r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MovableCallback r0 = this.a.a(this.b);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.eventClick-OzbTU-A(this.b, this.c, this.d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Ref.ObjectRef<List<Float>> a;
        public final /* synthetic */ i b;
        public final /* synthetic */ float c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CountDownLatch e;

        public e(Ref.ObjectRef<List<Float>> r1, i r2, float r3, String r4, CountDownLatch r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            this.a.element = this.b.getSize(this.c, this.d);     // Catch: Throwable -> L5 Exception -> L7
        L4:
            this.e.countDown();
            return;
        L5:
            th = move-exception;
            this.e.countDown();
            throw th;
        L7:
            e = move-exception;
            Log.e("RenderPoolFfi", "measureAttachment error: " + e.getMessage());     // Catch: Throwable -> L5
            goto L4
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

    static {
        d = new b();
        f = CollectionsKt.emptyList();
        g = AbstractNotification.NoticeType.DOCFEED;
    }

    public MovableGlobalManager() {
        this.a = LazyKt.lazy(MovableGlobalManager$attachmentMeasureResolvers$2.INSTANCE);
        this.b = new ReferenceQueue();
        this.c = new ConcurrentHashMap();
        PthreadThreadV2 r0 = new PthreadThreadV2(new a(this), "MovableViewReferenceQueue");
        r0.setDaemon(true);
        ThreadMethodProxy.start(r0);
    }

    public final List<String> getFontPrefixPathCandidates() {
        return f;
    }

    public static void d(Runnable r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r2);
    }

    public final MovableCallback a(int r4) {
        c r0 = this.c.get(Integer.valueOf(r4));
        if (r0 != null) goto L5;
        return null;
    L5:
        MovableCallback r1 = r0.get();
        if (r1 != null) goto L9;
        this.c.remove(Integer.valueOf(r4));
        Log.i("RenderPoolFfi", "movable view weak reference recycled: " + r4 + ", global size: " + this.c.size());
        return null;
    L9:
        return r1;
    }

    public final MovableView b(int r2) {
        MovableCallback r3 = a(r2);
        if ((r3 instanceof MovableView) == true) goto L7;
        return null;
    L7:
        return (MovableView) r3;
    }

    public final void e(int r3) {
        if (this.c.containsKey(Integer.valueOf(r3)) == true) goto L5;
        return;
    L5:
        this.c.remove(Integer.valueOf(r3));
        Log.i("RenderPoolFfi", "unRegister movable view: " + r3 + ", global size: " + this.c.size());
    }

    public final void c(int r5, MovableCallback r6) {
        Intrinsics.checkNotNullParameter(r6, "proxy");
        c r0 = this.c.get(Integer.valueOf(r5));
        if (r0 == null) goto L5;
        MovableCallback r1 = r0.get();
    L6:
        if (r1 != r6) goto L8;
        return;
    L8:
        this.c.put(Integer.valueOf(r5), new c(r5, r6, this.b));
        Log.i("RenderPoolFfi", "register movable view: " + r5 + ", global size: " + this.c.size());
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: getScrollIslandScrollOffset-feOb9K0, reason: not valid java name */
    public final List<Float> m1464getScrollIslandScrollOffsetfeOb9K0(int r2, int r3) {
        MovableCallback r0 = a(r2);
        if (r0 == null) goto L7;
        List<Float> r4 = r0.getScrollIslandScrollOffset-feOb9K0(r2, r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: eventClick-OzbTU-A, reason: not valid java name */
    public final void m1463eventClickOzbTUA(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "payload");
        d(new d(this, r2, r3, r4));
    }

    /* JADX INFO: renamed from: measureAttachment-OzbTU-A, reason: not valid java name */
    public final List<Float> m1466measureAttachmentOzbTUA(int r11, float r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "propertyString");
        i r4 = (i) ((Map) this.a.getValue()).get(Integer.valueOf(r11));
        if (r4 == null) goto L5;
        CountDownLatch r1 = new CountDownLatch(1);
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = CollectionsKt.emptyList();
        d(new e(r8, r4, r12, r13, r1));
        r1.await(1, TimeUnit.SECONDS);     // Catch: InterruptedException -> L9
    L11:
        Log.i("RenderPoolFfi", "type: " + UInt.toString-impl(r11) + ", containerWidth: " + r12 + ", measureAttachment result: " + r8.element);
        return (List) r8.element;
    L9:
        e = move-exception;
        Log.e("RenderPoolFfi", "measureAttachment interrupted: " + e.getMessage());
        ThreadMethodProxy.currentThread().interrupt();
        goto L11
    L5:
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: registerFont-jXDDuk8, reason: not valid java name */
    public final void m1467registerFontjXDDuk8(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "path");
        com.ss.android.lark.movable.utils.c.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "fontName");
        Intrinsics.checkNotNullParameter(r5, "path");
        Log.i(com.ss.android.lark.movable.utils.c.b, "addFontPath, id: " + r4 + ", path: " + r5 + ", index: " + r6);
        Map<String, com.ss.android.lark.movable.utils.c.a> r0 = com.ss.android.lark.movable.utils.c.c;
        r0.put(r4, new com.ss.android.lark.movable.utils.c.a(r5, r6));
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        LarkKVStorage.p(new com.ss.android.lark.storage.a("movable"), "movable::font_path", true).putString("movable::font_map", new Gson().toJson(r0));     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    /* JADX INFO: renamed from: markHighlightUpdate-iyaXS9w, reason: not valid java name */
    public final void m1465markHighlightUpdateiyaXS9w(int r7, float r8, float r9, float r10, float r11) {
        MovableCallback r0 = a(r7);
        if (r0 == null) goto L6;
        r0.markHighlightUpdate-iyaXS9w(r7, r8, r9, r10, r11);
        return;
    }
}
