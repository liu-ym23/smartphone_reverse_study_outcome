package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import android.content.Context;
import android.os.Build;
import android.os.Trace;
import android.text.Layout;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.RomUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.a$a, reason: collision with other inner class name */
    public interface InterfaceC0048a {
        void f(y6b.a<?> r1);

        Context getContext();
    }

    public static final class b implements Runnable {
        public final z2b.b a;
        public final y6b.a<?> b;
        public final BaseTextContentVO<?> c;
        public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b d;
        public final WeakReference<InterfaceC0048a> e;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC0049a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ String c;
            public final /* synthetic */ Layout d;

            public RunnableC0049a(b r1, boolean r2, String r3, Layout r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void a() {
                InterfaceC0048a r0 = this.a.e.get();
                if (r0 != null) goto L6;
                Log.e("AsyncParseLog", "dependency from WeakReference is null");
                return;
            L6:
                int r2 = a.a;
                BaseTextContentVO r3 = a.c(this.a.b, this.b);
                if (r3 != null) goto L11;
                Log.e("AsyncParseLog", "get latest ContentVO failed for message: " + this.c);
                return;
            L11:
                if (Intrinsics.areEqual(r3, this.a.c) == true) goto L14;
                Log.i("AsyncParseLog", "ContentVO changed for message: " + this.c + ", so drop parsed result");
                return;
            L14:
                r3.z = this.d;
                Log.i("AsyncParseLog", "notify message update, id " + this.c + ", isTranslation: " + this.b);
                Trace.beginSection("notify_layout_refreshed");
                r0.f(this.a.b);
                Trace.endSection();
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

        public final void a() {
            String r0 = this.b.getId();
            boolean r1 = this.d.k;
            InterfaceC0048a r2 = this.e.get();
            if (r2 != null) goto L6;
            Log.i("AsyncParseLog", "AsyncParseDependency from WeakReference is null before parse, return quickly");
            return;
        L6:
            Context r3 = r2.getContext();
            if (r3 != null) goto L9;
            return;
        L9:
            long r4 = System.currentTimeMillis();
            Trace.beginSection("layout_processor_process");
            com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r6 = this.d;
            r6.m = true;
            Layout r5 = TextLayoutRenderExtKt.d(this.a, this.b, r6, r3);
            if (r5 != null) goto L12;
            return;
        L12:
            Trace.endSection();
            Log.i("AsyncParseLog", "layout parse cost " + (System.currentTimeMillis() - r4) + "ms for message " + r0 + ", length " + this.b.r());
            if (r5.getText() != null) goto L16;
            Log.e("AsyncParseLog", "contentLayout.text is null for message " + r0);
            return;
        L16:
            CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC0049a(this, r1, r0, r5));
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

        public b(z2b.b r2, y6b.a r3, BaseTextContentVO r4, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r5, b3b.a r6) {
            Intrinsics.checkNotNullParameter(r2, ChameleonOpenTracker.Stage.RENDER);
            Intrinsics.checkNotNullParameter(r3, "messageVO");
            Intrinsics.checkNotNullParameter(r4, "contentVoSnapshot");
            Intrinsics.checkNotNullParameter(r5, "processParams");
            Intrinsics.checkNotNullParameter(r6, "dependency");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = new WeakReference(r6);
        }
    }

    public static final class c implements Runnable {
        public final z2b.b a;
        public final boolean b;
        public final y6b.a<?> c;
        public final BaseTextContentVO<?> d;
        public final WeakReference<InterfaceC0048a> e;
        public final WeakReference<n> f;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC0050a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Layout c;

            public RunnableC0050a(c r1, String r2, Layout r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                InterfaceC0048a r0 = this.a.e.get();
                if (r0 != null) goto L6;
                Log.e("AsyncParseLog", "dependency from WeakReference is null");
                return;
            L6:
                int r2 = a.a;
                c r3 = this.a;
                BaseTextContentVO r4 = a.c(r3.c, r3.b);
                if (r4 != null) goto L11;
                Log.e("AsyncParseLog", "get latest ContentVO failed for message: " + this.b);
                return;
            L11:
                if (Intrinsics.areEqual(r4, this.a.d) == true) goto L14;
                Log.i("AsyncParseLog", "ContentVO changed for message: " + this.b + ", so drop parsed result");
                return;
            L14:
                r4.z = this.c;
                Log.i("AsyncParseLog", "notify message update, id " + this.b + ", isTranslation: " + this.a.b);
                Trace.beginSection("notify_layout_refreshed");
                r0.f(this.a.c);
                Trace.endSection();
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

        public final void a() {
            String r0 = this.c.getId();
            long r1 = System.currentTimeMillis();
            Trace.beginSection("layout_processor_process");
            n r3 = this.f.get();
            if (r3 != null) goto L6;
            Log.e("AsyncParseLog", "config is null ,async parse return.");
            return;
        L6:
            Object r5 = this.c.b();
            RichText r7 = null;
            if ((r5 instanceof BaseTextContentVO) == false) goto L9;
            BaseTextContentVO r6 = (BaseTextContentVO) r5;
        L10:
            if (r6 != null) goto L13;
            return;
        L13:
            if (this.b == true) goto L15;
            r7 = r6.g();
        L20:
            if (r7 != null) goto L22;
            return;
        L22:
            Layout r4 = TextLayoutRenderExtKt.f(this.a, r7, r3);
            if (r4 != null) goto L25;
            return;
        L25:
            Trace.endSection();
            Log.i("AsyncParseLog", "layout parse cost " + (System.currentTimeMillis() - r1) + "ms for message " + r0 + ", length " + this.c.r());
            if (r4.getText() != null) goto L29;
            Log.e("AsyncParseLog", "contentLayout.text is null for message " + r0);
            return;
        L29:
            CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC0050a(this, r0, r4));
            return;
        L15:
            v5b.a r8 = r6.g;
            if (r8 == null) goto L20;
            BaseTextContent r9 = (BaseTextContent) r8.a;
            if (r9 == null) goto L20;
            r7 = r9.getRichText();
            goto L20
        L9:
            r6 = null;
            goto L10
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

        public c(z2b.b r2, boolean r3, y6b.a r4, BaseTextContentVO r5, n r6, b3b.a r7) {
            Intrinsics.checkNotNullParameter(r2, ChameleonOpenTracker.Stage.RENDER);
            Intrinsics.checkNotNullParameter(r4, "messageVO");
            Intrinsics.checkNotNullParameter(r5, "contentVoSnapshot");
            Intrinsics.checkNotNullParameter(r6, "config");
            Intrinsics.checkNotNullParameter(r7, "dependency");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = new WeakReference(r7);
            this.f = new WeakReference(r6);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static BaseTextContentVO c(y6b.a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "messageVO");
        if (r2 == false) goto L14;
        T r3 = r1.b();
        if ((r3 instanceof BaseTextContentVO) == false) goto L7;
        BaseTextContentVO r4 = (BaseTextContentVO) r3;
    L8:
        if (r4 == null) goto L10;
        Object r5 = r4.g;
    L12:
        if ((r5 instanceof BaseTextContentVO) == true) goto L19;
        return null;
    L19:
        return (BaseTextContentVO) r5;
    L10:
        r5 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    L14:
        T r6 = r1.b();
        if ((r6 instanceof BaseTextContentVO) == true) goto L17;
        return null;
    L17:
        return (BaseTextContentVO) r6;
    }

    public static void a(z2b.b r7, y6b.a r8, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r9, b3b.a r10) {
        Intrinsics.checkNotNullParameter(r8, "messageVO");
        Intrinsics.checkNotNullParameter(r9, "processParams");
        Intrinsics.checkNotNullParameter(r10, "dependency");
        if (r7 != null) goto L5;
        int r11 = TextLayoutRender.j;
        r7 = w2b.b.d;
    L5:
        z2b.b r1 = r7;
        BaseTextContentVO r3 = c(r8, r9.k);
        if (r3 != null) goto L9;
        Log.e("AsyncParseLog", "ContentVO get failed for message: " + r8.getId());
        return;
    L9:
        r3.A = false;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r1, r8, r3, r9, r10));
    }

    public static void b(z2b.b r8, boolean r9, y6b.a r10, n r11, b3b.a r12) {
        Intrinsics.checkNotNullParameter(r10, "messageVO");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r12, "dependency");
        if (r8 != null) goto L5;
        int r13 = TextLayoutRender.j;
        r8 = w2b.b.d;
    L5:
        z2b.b r1 = r8;
        BaseTextContentVO r4 = c(r10, r9);
        if (r4 != null) goto L9;
        Log.e("AsyncParseLog", "ContentVO get failed for message: " + r10.getId());
        return;
    L9:
        boolean r0 = false;
        r4.A = false;
        if (Build.VERSION.SDK_INT != 31) goto L13;
        r0 = RomUtils.g();
    L13:
        if (r0 == true) goto L15;
    L18:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r1, r9, r10, r4, r11, r12));
        return;
    L15:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.close_pre_layout.reverse") == true) goto L18;
        Log.i("AsyncParseLog", "skip asyncParseV2 on risk device, message: " + r10.getId());
    }
}
