package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0047c f1393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends z1.a> f1394b;

    static /* synthetic */ class a {
    }

    private class b implements InterfaceC0047c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f1395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f1396b;

        b(c r10, Context r11) {
            this.f1396b = r10;
            this.f1395a = r11;
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0047c
        public void c() {
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0047c
        public void d(Intent r10) {
            r10.setComponent(new ComponentName(this.f1395a, c.a(this.f1396b)));     // Catch: Throwable -> L4
            this.f1395a.startService(r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.c$c, reason: collision with other inner class name */
    public interface InterfaceC0047c {
        void c();

        void d(Intent r10);
    }

    private class d implements InterfaceC0047c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f1397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Messenger f1398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkedBlockingDeque<Intent> f1399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ServiceConnection f1400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1401e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f1402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Runnable f1403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Runnable f1404h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicInteger f1405i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ c f1406j;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f1407c;

            a(d r10) {
                this.f1407c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object r10 = d.a(this.f1407c);
                monitor-enter(r10);
                Logger.d("WsChannelSdk", "mBindServiceTimeoutRunnable run");     // Catch: Throwable -> L9
                if (d.b(this.f1407c) == false) goto L7;
                d.e(this.f1407c, false);     // Catch: Throwable -> L9
            L7:
                monitor-exit(r10);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f1408c;

            b(d r10) {
                this.f1408c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                /*  JADX ERROR: Simple mode code generation failed
                    java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                    	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                    	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    this = this;
                    com.bytedance.common.wschannel.server.c$d r0 = r3.f1408c
                    java.lang.Object r0 = com.bytedance.common.wschannel.server.c.d.a(r0)
                    monitor-enter(r0)
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f1408c     // Catch: java.lang.Throwable -> L33
                    android.content.ServiceConnection r1 = com.bytedance.common.wschannel.server.c.d.f(r1)     // Catch: java.lang.Throwable -> L33
                    if (r1 == 0) goto L37
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f1408c     // Catch: java.lang.Throwable -> L33
                    android.content.Context r1 = com.bytedance.common.wschannel.server.c.d.h(r1)     // Catch: java.lang.Throwable -> L33
                    com.bytedance.common.wschannel.server.c$d r2 = r3.f1408c     // Catch: java.lang.Throwable -> L33
                    com.bytedance.common.wschannel.server.c r2 = r2.f1406j     // Catch: java.lang.Throwable -> L33
                    java.lang.Class r2 = com.bytedance.common.wschannel.server.c.a(r2)     // Catch: java.lang.Throwable -> L33
                    boolean r1 = g2.c.l(r1, r2)     // Catch: java.lang.Throwable -> L33
                    if (r1 == 0) goto L37
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f1408c     // Catch: java.lang.Throwable -> L33
                    android.content.Context r1 = com.bytedance.common.wschannel.server.c.d.h(r1)     // Catch: java.lang.Throwable -> L33
                    com.bytedance.common.wschannel.server.c$d r2 = r3.f1408c     // Catch: java.lang.Throwable -> L33
                    android.content.ServiceConnection r2 = com.bytedance.common.wschannel.server.c.d.f(r2)     // Catch: java.lang.Throwable -> L33
                    r1.unbindService(r2)     // Catch: java.lang.Throwable -> L33
                    goto L37
                L33:
                    r1 = move-exception
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L4b
                L37:
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f1408c     // Catch: java.lang.Throwable -> L4b
                    r2 = 0
                    com.bytedance.common.wschannel.server.c.d.g(r1, r2)     // Catch: java.lang.Throwable -> L4b
                    com.bytedance.common.wschannel.server.c$d r3 = r3.f1408c     // Catch: java.lang.Throwable -> L4b
                    com.bytedance.common.wschannel.server.c.d.i(r3, r2)     // Catch: java.lang.Throwable -> L4b
                    java.lang.String r3 = "WsChannelSdk"
                    java.lang.String r1 = "mDisconnectRunnable timeout"
                    com.bytedance.common.utility.Logger.d(r3, r1)     // Catch: java.lang.Throwable -> L4b
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L4b
                    return
                L4b:
                    r3 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L4b
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.server.c.d.b.run():void");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.c$d$c, reason: collision with other inner class name */
        private class ServiceConnectionC0048c implements ServiceConnection {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f1409c;

            private ServiceConnectionC0048c(d r10) {
                this.f1409c = r10;
            }

            /* synthetic */ ServiceConnectionC0048c(d r10, a r11) {
                this(r10);
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r10, IBinder r11) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r10.toString());
            L5:
                Object r12 = d.a(this.f1409c);
                monitor-enter(r12);
                d.k(this.f1409c);     // Catch: Throwable -> L20
                if (r10 == null) goto L18;
                if (r11 == null) goto L18;
                d.i(this.f1409c, new Messenger(r11));     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                d.l(this.f1409c);     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L20
                d.e(this.f1409c, false);     // Catch: Throwable -> L20
                monitor-exit(r12);     // Catch: Throwable -> L20
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L20
            L18:
                monitor-exit(r12);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r10) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r10.toString());
            L5:
                Object r11 = d.a(this.f1409c);
                monitor-enter(r11);
                if (r10 != null) goto L10;
                monitor-exit(r11);     // Catch: Throwable -> L13
                return;
            L10:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L13
                d.i(this.f1409c, null);     // Catch: Throwable -> L13
                d.g(this.f1409c, null);     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L13
                d.e(this.f1409c, false);     // Catch: Throwable -> L13
                d.j(this.f1409c);     // Catch: Throwable -> L13
                d.k(this.f1409c);     // Catch: Throwable -> L13
                monitor-exit(r11);     // Catch: Throwable -> L13
                return;
            L13:
                th = move-exception;
                throw th;
            }
        }

        d(c r10, Context r11) {
            this.f1406j = r10;
            this.f1399c = new LinkedBlockingDeque();
            this.f1401e = false;
            this.f1402f = new Object();
            this.f1403g = new a(this);
            this.f1404h = new b(this);
            this.f1405i = new AtomicInteger(0);
            this.f1397a = r11;
        }

        static /* synthetic */ Object a(d r10) {
            return r10.f1402f;
        }

        static /* synthetic */ boolean b(d r10) {
            return r10.f1401e;
        }

        static /* synthetic */ boolean e(d r10, boolean r11) {
            r10.f1401e = r11;
            return r11;
        }

        static /* synthetic */ ServiceConnection f(d r10) {
            return r10.f1400d;
        }

        static /* synthetic */ ServiceConnection g(d r10, ServiceConnection r11) {
            r10.f1400d = r11;
            return r11;
        }

        static /* synthetic */ Context h(d r10) {
            return r10.f1397a;
        }

        static /* synthetic */ Messenger i(d r10, Messenger r11) {
            r10.f1398b = r11;
            return r11;
        }

        static /* synthetic */ void j(d r10) {
            r10.p();
        }

        static /* synthetic */ void k(d r10) {
            r10.o();
        }

        static /* synthetic */ void l(d r10) {
            r10.n();
        }

        private void m() {
            if (Logger.debug() == false) goto L14;
            Logger.d("WsChannelSdk", "doBindService");
        L14:
            this.f1397a.startService(new Intent(this.f1397a, c.a(this.f1406j)));     // Catch: Throwable -> L11
        L12:
            this.f1400d = new ServiceConnectionC0048c(this, null);     // Catch: Throwable -> L8
            this.f1397a.bindService(new Intent(this.f1397a, c.a(this.f1406j)), this.f1400d, 1);     // Catch: Throwable -> L8
            r();     // Catch: Throwable -> L8
            this.f1401e = true;     // Catch: Throwable -> L8
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            o();
            this.f1401e = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        private void n() {
        L17:
        L14:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.f1399c.peek() == null) goto L12;
            Intent r10 = this.f1399c.poll();     // Catch: Throwable -> L14
            if (r10 == null) goto L6;
            q(r10);     // Catch: Throwable -> L9 DeadObjectException -> L11
        L11:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L14
            this.f1398b = null;     // Catch: Throwable -> L14
            this.f1399c.offerFirst(r10);     // Catch: Throwable -> L14
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L14
            goto L17
        L6:
            return;
        L12:
            s();     // Catch: Throwable -> L14
        }

        private void o() {
            com.bytedance.common.wschannel.g.b().a().removeCallbacks(this.f1403g);
        }

        private void p() {
            com.bytedance.common.wschannel.g.b().a().removeCallbacks(this.f1404h);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        private void q(Intent r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r10);
        L7:
            Messenger r11 = this.f1398b;
            Message r12 = new Message();
            r12.what = WsConstants.MSG_INTENT;
            r12.getData().putParcelable(WsConstants.DATA_INTENT, r10);
            if (r11 != null) goto L10;
            return;
        L10:
            r11.send(r12);
        }

        private void r() {
            o();
            com.bytedance.common.wschannel.g.b().a().postDelayed(this.f1403g, TimeUnit.SECONDS.toMillis(7));
        }

        private synchronized void s() {
            monitor-enter(this);
            p();     // Catch: Throwable -> L6
            com.bytedance.common.wschannel.g.b().a().postDelayed(this.f1404h, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0047c
        public void c() {
            if (this.f1399c.size() > 0) goto L5;
            return;
        L5:
            if (this.f1398b != null) goto L21;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r10 = this.f1402f;
            monitor-enter(r10);
        L15:
            th = move-exception;
            throw th;
        L9:
            if (this.f1399c.size() > 0) goto L11;
        L13:
            monitor-exit(r10);     // Catch: Throwable -> L15
            return;
        L11:
            if (this.f1398b != null) goto L13;
            m();     // Catch: Throwable -> L15
            goto L13
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0047c
        public void d(Intent r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            r10.putExtra(WsConstants.MSG_COUNT, this.f1405i.addAndGet(1));
        L7:
            Object r11 = this.f1402f;
            monitor-enter(r11);
            p();     // Catch: Throwable -> L19
            this.f1399c.offer(r10);     // Catch: Throwable -> L19
            if (this.f1398b == null) goto L12;
            n();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r11);     // Catch: Throwable -> L19
            return;
        L12:
            if (this.f1401e == false) goto L15;
            monitor-exit(r11);     // Catch: Throwable -> L19
            return;
        L15:
            m();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }
    }

    public c(Context r10, Class<? extends z1.a> r11) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L7:
        InterfaceC0047c r12 = new b(this, r10);
    L8:
        this.f1393a = r12;
        this.f1394b = r11;
        return;
    L5:
        if (r10.getApplicationInfo().targetSdkVersion < 26) goto L7;
        r12 = new d(this, r10);
        goto L8
    }

    static /* synthetic */ Class a(c r10) {
        return r10.f1394b;
    }

    public void b(Intent r10) {
        this.f1393a.d(r10);
    }

    public void c() {
        this.f1393a.c();
    }
}
