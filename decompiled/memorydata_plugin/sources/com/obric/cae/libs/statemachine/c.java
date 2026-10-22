package com.obric.cae.libs.statemachine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    private static final int SM_INIT_CMD = -2;
    private static final int SM_QUIT_CMD = -1;
    private String mName;
    private HandlerC0343c mSmHandler;
    private HandlerThread mSmThread;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f6991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f6992b;
        public int c;
        public String d;
        public com.obric.cae.libs.statemachine.a e;
        public com.obric.cae.libs.statemachine.a f;
        public com.obric.cae.libs.statemachine.a g;

        public a(c r1, Message r2, String r3, com.obric.cae.libs.statemachine.b r4, com.obric.cae.libs.statemachine.b r5, com.obric.cae.libs.statemachine.b r6) {
            update(r1, r2, r3, r4, r5, r6);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("time=");
            Calendar r1 = Calendar.getInstance();
            r1.setTimeInMillis(this.f6992b);
            r0.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r1, r1, r1, r1, r1, r1}));
            r0.append(" processed=");
            com.obric.cae.libs.statemachine.a r2 = this.e;
            String r3 = "<null>";
            if (r2 != null) goto L5;
            String r4 = "<null>";
        L6:
            r0.append(r4);
            r0.append(" org=");
            com.obric.cae.libs.statemachine.a r5 = this.f;
            if (r5 != null) goto L9;
            String r6 = "<null>";
        L10:
            r0.append(r6);
            r0.append(" dest=");
            com.obric.cae.libs.statemachine.a r7 = this.g;
            if (r7 == null) goto L14;
            r3 = r7.getName();
        L14:
            r0.append(r3);
            r0.append(" what=");
            c r8 = this.f6991a;
            if (r8 == null) goto L17;
            String r9 = r8.getWhatToString(this.c);
        L19:
            if (TextUtils.isEmpty(r9) == false) goto L21;
            r0.append(this.c);
            r0.append("(0x");
            r0.append(Integer.toHexString(this.c));
            r9 = ")";
        L21:
            r0.append(r9);
            if (TextUtils.isEmpty(this.d) == true) goto L25;
            r0.append(" ");
            r0.append(this.d);
        L25:
            return r0.toString();
        L17:
            r9 = "";
            goto L19
        L9:
            r6 = r5.getName();
            goto L10
        L5:
            r4 = r2.getName();
            goto L6
        }

        public void update(c r3, Message r4, String r5, com.obric.cae.libs.statemachine.a r6, com.obric.cae.libs.statemachine.a r7, com.obric.cae.libs.statemachine.a r8) {
            com.obric.cae.libs.statemachine.a r9 = (com.obric.cae.libs.statemachine.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.cae.libs.statemachine.a.class, "com.obric.memorydata.plugin");
            com.obric.cae.libs.statemachine.a r10 = (com.obric.cae.libs.statemachine.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.cae.libs.statemachine.a.class, "com.obric.memorydata.plugin");
            com.obric.cae.libs.statemachine.a r11 = (com.obric.cae.libs.statemachine.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.libs.statemachine.a.class, "com.obric.memorydata.plugin");
            this.f6991a = r3;
            this.f6992b = System.currentTimeMillis();
            if (r4 == null) goto L5;
            int r12 = r4.what;
        L6:
            this.c = r12;
            this.d = r5;
            this.e = r9;
            this.f = r10;
            this.g = r11;
            return;
        L5:
            r12 = 0;
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Vector<a> f6993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6994b;
        public int c;
        public int d;
        public boolean e;

        public b() {
            this.f6993a = new Vector();
            this.f6994b = 20;
            this.c = 0;
            this.d = 0;
            this.e = false;
        }

        public /* synthetic */ b(int r1) {
            this();
        }

        public final synchronized int a() {
            monitor-enter(this);
            int r0 = this.f6993a.size();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(c r10, Message r11, String r12, com.obric.cae.libs.statemachine.b r13, com.obric.cae.libs.statemachine.b r14, com.obric.cae.libs.statemachine.b r15) {
            monitor-enter(this);
            this.d++;     // Catch: Throwable -> L12
            if (this.f6993a.size() >= this.f6994b) goto L6;
            this.f6993a.add(new a(r10, r11, r12, r13, r14, r15));     // Catch: Throwable -> L12
        L10:
            monitor-exit(this);
            return;
        L6:
            a r1 = (a) ZeusTransformUtils.preCheckCast(this.f6993a.get(this.c), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            int r0 = this.c + 1;     // Catch: Throwable -> L12
            this.c = r0;     // Catch: Throwable -> L12
            if (r0 < this.f6994b) goto L9;
            this.c = 0;     // Catch: Throwable -> L12
        L9:
            r1.update(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.libs.statemachine.c$c, reason: collision with other inner class name */
    public static class HandlerC0343c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f6995a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6996b;
        public boolean c;
        public Message d;
        public final b e;
        public boolean f;
        public C0344c[] g;
        public int h;
        public C0344c[] i;
        public int j;
        public final a k;
        public final b l;
        public c m;
        public final HashMap<com.obric.cae.libs.statemachine.b, C0344c> n;
        public com.obric.cae.libs.statemachine.b o;
        public com.obric.cae.libs.statemachine.b p;
        public boolean q;
        public final ArrayList<Message> r;

        /* JADX INFO: renamed from: com.obric.cae.libs.statemachine.c$c$a */
        public class a extends com.obric.cae.libs.statemachine.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HandlerC0343c f6997a;

            public a(HandlerC0343c r1) {
                this.f6997a = r1;
            }

            public /* synthetic */ a(HandlerC0343c r1, int r2) {
                this(r1);
            }

            @Override // com.obric.cae.libs.statemachine.b
            public final boolean processMessage(Message r1) {
                this.f6997a.m.haltedProcessMessage(r1);
                return true;
            }
        }

        /* JADX INFO: renamed from: com.obric.cae.libs.statemachine.c$c$b */
        public static class b extends com.obric.cae.libs.statemachine.b {
            public b() {
            }

            public /* synthetic */ b(int r1) {
                this();
            }

            @Override // com.obric.cae.libs.statemachine.b
            public final boolean processMessage(Message r1) {
                return false;
            }
        }

        /* JADX INFO: renamed from: com.obric.cae.libs.statemachine.c$c$c, reason: collision with other inner class name */
        public static class C0344c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.obric.cae.libs.statemachine.b f6998a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final C0344c f6999b;
            public boolean c;

            public C0344c(com.obric.cae.libs.statemachine.b r2, C0344c r3) {
                this.c = false;
                this.f6998a = r2;
                this.f6999b = r3;
            }

            public final String toString() {
                StringBuilder r0 = new StringBuilder("state=").append(this.f6998a.getName()).append(",active=").append(this.c).append(",parent=");
                C0344c r2 = this.f6999b;
                if (r2 != null) goto L5;
                String r3 = "null";
            L7:
                return r0.append(r3).toString();
            L5:
                r3 = r2.f6998a.getName();
                goto L7
            }
        }

        static {
            f6995a = new Object();
        }

        public HandlerC0343c(Looper r4, c r5) {
            super(r4);
            int r6 = 0;
            this.f6996b = false;
            this.c = false;
            this.e = new b(r6);
            this.h = -1;
            a r0 = new a(this, r6);
            this.k = r0;
            b r1 = new b(r6);
            this.l = r1;
            this.n = new HashMap();
            this.q = false;
            this.r = new ArrayList();
            this.m = r5;
            a(r0, null);
            a(r1, null);
        }

        public static /* synthetic */ boolean a(C0344c r0, C0344c r1) {
            if (r1.f6999b != r0) goto L5;
            return true;
        L5:
            return false;
        }

        public final C0344c a(com.obric.cae.libs.statemachine.b r5, com.obric.cae.libs.statemachine.b r6) {
            if (this.c == false) goto L9;
            c r0 = this.m;
            StringBuilder r1 = new StringBuilder("addStateInternal: E state=").append(r5.getName()).append(",parent=");
            if (r6 != null) goto L7;
            String r2 = "";
        L8:
            r0.log(r1.append(r2).toString());
            goto L9
        L7:
            r2 = r6.getName();
        L9:
            C0344c r3 = null;
            if (r6 == null) goto L15;
            C0344c r4 = (C0344c) ZeusTransformUtils.preCheckCast(this.n.get(r6), C0344c.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L14;
            r3 = a(r6, null);
            goto L15
        L14:
            r3 = r4;
        L15:
            C0344c r7 = (C0344c) ZeusTransformUtils.preCheckCast(this.n.get(r5), C0344c.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L18;
            r7 = new C0344c(r5, r3);
            this.n.put(r5, r7);
        L18:
            C0344c r8 = r7.f6999b;
            if (r8 == null) goto L25;
            if (r8 == r3) goto L25;
            throw new RuntimeException("state already added");
        L25:
            if (this.c == false) goto L27;
            this.m.log("addStateInternal: X stateInfo: " + r7);
        L27:
            return r7;
        }

        public final void a() {
            if (c.access$400(this.m) == null) goto L5;
            getLooper().quit();
            c.access$402(this.m, null);
        L5:
            c.access$502(this.m, null);
            this.m = null;
            this.d = null;
            b r0 = this.e;
            monitor-enter(r0);
            r0.f6993a.clear();     // Catch: Throwable -> L11
            monitor-exit(r0);
            this.g = null;
            this.i = null;
            this.n.clear();
            this.o = null;
            this.p = null;
            this.r.clear();
            this.f6996b = true;
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public final void a(int r5) {
            int r0 = r5;
        L3:
            int r1 = this.h;
            if (r0 > r1) goto L11;
            if (r5 != r1) goto L8;
            this.q = false;
        L8:
            if (this.c == false) goto L10;
            this.m.log("invokeEnterMethods: " + this.g[r0].f6998a.getName());
        L10:
            this.g[r0].f6998a.enter();
            this.g[r0].c = true;
            r0 = r0 + 1;
            goto L3
        L11:
            this.q = false;
        }

        public final void a(com.obric.cae.libs.statemachine.a r5) {
            com.obric.cae.libs.statemachine.a r6 = (com.obric.cae.libs.statemachine.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.cae.libs.statemachine.a.class, "com.obric.memorydata.plugin");
            if (this.q == false) goto L5;
            Log.wtf(c.access$600(this.m), "transitionTo called while transition already in progress to " + this.p + ", new target state=" + r6);
        L5:
            this.p = (com.obric.cae.libs.statemachine.b) ZeusTransformUtils.preCheckCast(r6, com.obric.cae.libs.statemachine.b.class, "com.obric.memorydata.plugin");
            if (this.c == false) goto L9;
            this.m.log("transitionTo: destState=" + this.p.getName());
            return;
        }

        public final void a(com.obric.cae.libs.statemachine.b r4) {
            final C0344c r0 = (C0344c) ZeusTransformUtils.preCheckCast(this.n.get(r4), C0344c.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.c == false) goto L8;
            return;
        L8:
            if (this.n.values().stream().anyMatch(new $$Lambda$xpjMoP9P3y48wsKAZoIbKSHIC4(r0)) == false) goto L10;
            return;
        L10:
            this.n.remove(r4);
        }

        public final int b() {
            int r0 = this.h + 1;
            int r1 = this.j - 1;
            int r2 = r0;
        L3:
            if (r1 < 0) goto L8;
            if (this.c == false) goto L7;
            this.m.log("moveTempStackToStateStack: i=" + r1 + ",j=" + r2);
        L7:
            this.g[r2] = this.i[r1];
            r2 = r2 + 1;
            r1 = r1 - 1;
            goto L3
        L8:
            this.h = r2 - 1;
            if (this.c == false) goto L11;
            this.m.log(e.a(new StringBuilder("moveTempStackToStateStack: X mStateStackTop="), this.h, ",startingIndex=", r0, ",Top=").append(this.g[this.h].f6998a.getName()).toString());
        L11:
            return r0;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r14) {
            if (this.f6996b == true) goto L115;
            c r0 = this.m;
            if (r0 == null) goto L11;
            int r3 = r14.what;
            if (r3 == (-2)) goto L11;
            if (r3 == (-1)) goto L11;
            r0.onPreHandleMessage(r14);
        L11:
            if (this.c == false) goto L13;
            this.m.log("handleMessage: E msg.what=" + r14.what);
        L13:
            Message r1 = obtainMessage();
            this.d = r1;
            r1.copyFrom(r14);
            if (this.f == true) goto L25;
            int r2 = r14.what;
            if (r2 == (-1)) goto L25;
            if (r2 != (-2)) goto L24;
            if (r14.obj != f6995a) goto L24;
            this.f = true;
            a(0);
        L22:
            com.obric.cae.libs.statemachine.b r10 = null;
        L46:
            com.obric.cae.libs.statemachine.b r11 = this.g[this.h].f6998a;
            if (this.m.recordLogRec(r14) == true) goto L49;
        L51:
            boolean r4 = false;
        L52:
            b r6 = this.e;
            monitor-enter(r6);
            boolean r7 = r6.e;     // Catch: Throwable -> L112
            monitor-exit(r6);
            if (r7 == true) goto L58;
            if (r4 == false) goto L62;
        L61:
            b r8 = this.e;
            c r9 = this.m;
            r8.a(r9, r14, r9.getLogRecString(r14), r10, r11, this.p);
        L62:
            com.obric.cae.libs.statemachine.b r5 = this.p;
            if (r5 != null) goto L65;
        L94:
            if (r5 == null) goto L102;
            if (r5 != this.l) goto L99;
            this.m.onQuitting();
            a();
            goto L102
        L99:
            if (r5 != this.k) goto L102;
            this.m.onHalting();
        L102:
            if (this.c == false) goto L106;
            c r12 = this.m;
            if (r12 == null) goto L106;
            r12.log("handleMessage: X");
        L106:
            c r13 = this.m;
            if (r13 == null) goto L135;
            int r15 = r14.what;
            if (r15 == (-2)) goto L136;
            if (r15 == (-1)) goto L137;
            r13.onPostHandleMessage(r14);
            return;
        L137:
            return;
        L136:
            return;
        L135:
            return;
        L65:
            if (this.c == false) goto L67;
            this.m.log("handleMessage: new destination call exit/enter");
        L67:
            this.j = 0;
            C0344c r16 = (C0344c) ZeusTransformUtils.preCheckCast(this.n.get(r5), C0344c.class, "com.obric.memorydata.plugin");
        L68:
            C0344c[] r17 = this.i;
            int r18 = this.j;
            this.j = r18 + 1;
            r17[r18] = r16;
            r16 = r16.f6999b;
            if (r16 == null) goto L73;
            if (r16.c == false) goto L68;
        L73:
            if (this.c == false) goto L75;
            this.m.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.j + ",curStateInfo: " + r16);
        L75:
            this.q = true;
        L76:
            int r19 = this.h;
            if (r19 < 0) goto L84;
            C0344c r20 = this.g[r19];
            if (r20 == r16) goto L84;
            com.obric.cae.libs.statemachine.b r21 = r20.f6998a;
            if (this.c == false) goto L83;
            this.m.log("invokeExitMethods: " + r21.getName());
        L83:
            r21.exit();
            C0344c[] r22 = this.g;
            int r23 = this.h;
            r22[r23].c = false;
            this.h = r23 - 1;
        L84:
            a(b());
            int r24 = this.r.size() - 1;
        L85:
            if (r24 < 0) goto L90;
            Message r25 = (Message) ZeusTransformUtils.preCheckCast(this.r.get(r24), Message.class, "com.obric.memorydata.plugin");
            if (this.c == false) goto L89;
            this.m.log("moveDeferredMessageAtFrontOfQueue; what=" + r25.what);
        L89:
            sendMessageAtFrontOfQueue(r25);
            r24 = r24 - 1;
            goto L85
        L90:
            this.r.clear();
            com.obric.cae.libs.statemachine.b r26 = this.p;
            if (r5 == r26) goto L93;
            r5 = r26;
            goto L65
        L93:
            this.p = null;
            goto L94
        L58:
            if (this.p == null) goto L62;
        L112:
            th = move-exception;
            throw th;
        L49:
            if (r14.obj == f6995a) goto L51;
            r4 = true;
        L24:
            throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + r14);
        L25:
            C0344c r27 = this.g[this.h];
            if (this.c == false) goto L29;
            this.m.log("processMsg: " + r27.f6998a.getName());
        L29:
            if (r14.what == (-1)) goto L31;
        L33:
            boolean r28 = false;
        L34:
            if (r28 == false) goto L37;
            a(this.l);
        L44:
            if (r27 == null) goto L22;
            r10 = r27.f6998a;
        L37:
            if (r27.f6998a.processMessage(r14) == true) goto L44;
            r27 = r27.f6999b;
            if (r27 == null) goto L40;
            if (this.c == false) goto L37;
            this.m.log("processMsg: " + r27.f6998a.getName());
            goto L37
        L40:
            this.m.unhandledMessage(r14);
            goto L44
        L31:
            if (r14.obj != f6995a) goto L33;
            r28 = true;
            goto L34
        }
    }

    public c(String r2) {
        HandlerThread r0 = new HandlerThread(r2);
        this.mSmThread = r0;
        r0.start();
        initStateMachine(r2, this.mSmThread.getLooper());
    }

    public c(String r1, Handler r2) {
        initStateMachine(r1, r2.getLooper());
    }

    public c(String r1, Looper r2) {
        initStateMachine(r1, r2);
    }

    public static /* synthetic */ HandlerThread access$400(c r0) {
        return r0.mSmThread;
    }

    public static /* synthetic */ HandlerThread access$402(c r0, HandlerThread r1) {
        r0.mSmThread = r1;
        return r1;
    }

    public static /* synthetic */ HandlerC0343c access$502(c r0, HandlerC0343c r1) {
        r0.mSmHandler = r1;
        return r1;
    }

    public static /* synthetic */ String access$600(c r0) {
        return r0.mName;
    }

    private void initStateMachine(String r1, Looper r2) {
        this.mName = r1;
        this.mSmHandler = new HandlerC0343c(r2, this);
    }

    public void addLogRec(String r9) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        b r1 = r0.e;
        Message r3 = r0.d;
        com.obric.cae.libs.statemachine.b r6 = r0.g[r0.h].f6998a;
        r1.a(this, r3, r9, r6, r6, r0.p);
    }

    public final void addState(com.obric.cae.libs.statemachine.b r2) {
        HandlerC0343c r1 = this.mSmHandler;
        Object r0 = HandlerC0343c.f6995a;
        r1.a(r2, null);
    }

    public final void addState(com.obric.cae.libs.statemachine.b r2, com.obric.cae.libs.statemachine.b r3) {
        HandlerC0343c r1 = this.mSmHandler;
        Object r0 = HandlerC0343c.f6995a;
        r1.a(r2, r3);
    }

    public final Collection<a> copyLogRecs() {
        Vector r0 = new Vector();
        HandlerC0343c r4 = this.mSmHandler;
        if (r4 == null) goto L8;
        Iterator<a> r5 = r4.e.f6993a.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.add((a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin"));
    L8:
        return r0;
    }

    public final void deferMessage(Message r4) {
        HandlerC0343c r3 = this.mSmHandler;
        if (r3.c == false) goto L5;
        r3.m.log("deferMessage: msg=" + r4.what);
    L5:
        Message r0 = r3.obtainMessage();
        r0.copyFrom(r4);
        r3.r.add(r0);
    }

    public void dump(FileDescriptor r2, PrintWriter r3, String[] r4) {
        r3.println(getName() + ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r3.println(" total records=" + getLogRecCount());
        int r5 = 0;
    L4:
        if (r5 >= getLogRecSize()) goto L6;
        r3.println(d.a(" rec[", r5, "]: ").append(getLogRec(r5)).toString());
        r3.flush();
        r5 = r5 + 1;
        goto L4
    L6:
        com.obric.cae.libs.statemachine.a r1 = getCurrentState();
        StringBuilder r6 = new StringBuilder("curState=");
        if (r1 != null) goto L9;
        String r7 = "<QUIT>";
    L10:
        r3.println(r6.append(r7).toString());
        return;
    L9:
        r7 = r1.getName();
        goto L10
    }

    public final Message getCurrentMessage() {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final com.obric.cae.libs.statemachine.a getCurrentState() {
        HandlerC0343c r1 = this.mSmHandler;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.g[r1.h].f6998a;
    }

    public final Handler getHandler() {
        return this.mSmHandler;
    }

    public final a getLogRec(int r3) {
        HandlerC0343c r2 = this.mSmHandler;
        a r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        b r4 = r2.e;
        monitor-enter(r4);
        int r1 = r4.c + r3;     // Catch: Throwable -> L17
        int r5 = r4.f6994b;     // Catch: Throwable -> L17
        if (r1 < r5) goto L11;
        r1 = r1 - r5;     // Catch: Throwable -> L17
    L11:
        if (r1 < r4.a()) goto L14;
    L12:
        monitor-exit(r4);
        return r0;
    L14:
        r0 = (a) ZeusTransformUtils.preCheckCast(r4.f6993a.get(r1), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final int getLogRecCount() {
        HandlerC0343c r1 = this.mSmHandler;
        if (r1 != null) goto L6;
        return 0;
    L6:
        b r2 = r1.e;
        monitor-enter(r2);
        int r0 = r2.d;     // Catch: Throwable -> L11
        monitor-exit(r2);
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int getLogRecMaxSize() {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e.f6994b;
    }

    public final int getLogRecSize() {
        HandlerC0343c r1 = this.mSmHandler;
        if (r1 != null) goto L6;
        return 0;
    L6:
        b r2 = r1.e;
        monitor-enter(r2);
        int r0 = r2.f6993a.size();     // Catch: Throwable -> L11
        monitor-exit(r2);
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    public String getLogRecString(Message r1) {
        return "";
    }

    public final String getName() {
        return this.mName;
    }

    public String getWhatToString(int r1) {
        return null;
    }

    public void haltedProcessMessage(Message r1) {
    }

    public final boolean hasDeferredMessages(int r5) {
        HandlerC0343c r4 = this.mSmHandler;
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<Message> r6 = r4.r.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        if (((Message) ZeusTransformUtils.preCheckCast(r6.next(), Message.class, "com.obric.memorydata.plugin")).what != r5) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean hasMessages(int r1) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.hasMessages(r1);
    }

    public boolean isDbg() {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c;
    }

    public final boolean isQuit(Message r4) {
        if (this.mSmHandler == null) goto L5;
        Object r3 = HandlerC0343c.f6995a;
        if (r4.what != (-1)) goto L15;
        if (r4.obj != HandlerC0343c.f6995a) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r4.what != (-1)) goto L8;
        return true;
    L8:
        return false;
    }

    public void log(String r1) {
        Log.d(this.mName, r1);
    }

    public void logAndAddLogRec(String r1) {
        addLogRec(r1);
        log(r1);
    }

    public void logd(String r1) {
        Log.d(this.mName, r1);
    }

    public void loge(String r1) {
        Log.e(this.mName, r1);
    }

    public void loge(String r1, Throwable r2) {
        Log.e(this.mName, r1, r2);
    }

    public void logi(String r1) {
        Log.i(this.mName, r1);
    }

    public void logv(String r1) {
        Log.v(this.mName, r1);
    }

    public void logw(String r1) {
        Log.w(this.mName, r1);
    }

    public final Message obtainMessage() {
        return Message.obtain(this.mSmHandler);
    }

    public final Message obtainMessage(int r1) {
        return Message.obtain(this.mSmHandler, r1);
    }

    public final Message obtainMessage(int r2, int r3) {
        return Message.obtain(this.mSmHandler, r2, r3, 0);
    }

    public final Message obtainMessage(int r1, int r2, int r3) {
        return Message.obtain(this.mSmHandler, r1, r2, r3);
    }

    public final Message obtainMessage(int r1, int r2, int r3, Object r4) {
        return Message.obtain(this.mSmHandler, r1, r2, r3, r4);
    }

    public final Message obtainMessage(int r1, Object r2) {
        return Message.obtain(this.mSmHandler, r1, r2);
    }

    public void onHalting() {
    }

    public void onPostHandleMessage(Message r1) {
    }

    public void onPreHandleMessage(Message r1) {
    }

    public void onQuitting() {
    }

    public final void quit() {
        HandlerC0343c r2 = this.mSmHandler;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.c == false) goto L8;
        r2.m.log("quit:");
    L8:
        r2.sendMessage(r2.obtainMessage(-1, HandlerC0343c.f6995a));
    }

    public final void quitNow() {
        HandlerC0343c r2 = this.mSmHandler;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.c == false) goto L8;
        r2.m.log("quitNow:");
    L8:
        r2.sendMessageAtFrontOfQueue(r2.obtainMessage(-1, HandlerC0343c.f6995a));
    }

    public boolean recordLogRec(Message r1) {
        return true;
    }

    public final void removeDeferredMessages(int r4) {
        HandlerC0343c r3 = this.mSmHandler;
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<Message> r5 = r3.r.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if (((Message) ZeusTransformUtils.preCheckCast(r5.next(), Message.class, "com.obric.memorydata.plugin")).what != r4) goto L7;
        r5.remove();
        goto L7
    }

    public final void removeMessages(int r1) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeMessages(r1);
    }

    public final void removeState(com.obric.cae.libs.statemachine.b r2) {
        HandlerC0343c r1 = this.mSmHandler;
        Object r0 = HandlerC0343c.f6995a;
        r1.a(r2);
    }

    public void sendMessage(int r2) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessage(obtainMessage(r2));
    }

    public void sendMessage(int r2, int r3) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessage(obtainMessage(r2, r3));
    }

    public void sendMessage(int r2, int r3, int r4) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessage(obtainMessage(r2, r3, r4));
    }

    public void sendMessage(int r2, int r3, int r4, Object r5) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessage(obtainMessage(r2, r3, r4, r5));
    }

    public void sendMessage(int r2, Object r3) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessage(obtainMessage(r2, r3));
    }

    public void sendMessage(Message r1) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessage(r1);
    }

    public final void sendMessageAtFrontOfQueue(int r2) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageAtFrontOfQueue(obtainMessage(r2));
    }

    public final void sendMessageAtFrontOfQueue(int r2, int r3) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageAtFrontOfQueue(obtainMessage(r2, r3));
    }

    public final void sendMessageAtFrontOfQueue(int r2, int r3, int r4) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageAtFrontOfQueue(obtainMessage(r2, r3, r4));
    }

    public final void sendMessageAtFrontOfQueue(int r2, int r3, int r4, Object r5) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageAtFrontOfQueue(obtainMessage(r2, r3, r4, r5));
    }

    public final void sendMessageAtFrontOfQueue(int r2, Object r3) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageAtFrontOfQueue(obtainMessage(r2, r3));
    }

    public final void sendMessageAtFrontOfQueue(Message r1) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageAtFrontOfQueue(r1);
    }

    public void sendMessageDelayed(int r2, int r3, int r4, long r5) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageDelayed(obtainMessage(r2, r3, r4), r5);
    }

    public void sendMessageDelayed(int r2, int r3, int r4, Object r5, long r6) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageDelayed(obtainMessage(r2, r3, r4, r5), r6);
    }

    public void sendMessageDelayed(int r2, int r3, long r4) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageDelayed(obtainMessage(r2, r3), r4);
    }

    public void sendMessageDelayed(int r2, long r3) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageDelayed(obtainMessage(r2), r3);
    }

    public void sendMessageDelayed(int r2, Object r3, long r4) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageDelayed(obtainMessage(r2, r3), r4);
    }

    public void sendMessageDelayed(Message r1, long r2) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.sendMessageDelayed(r1, r2);
    }

    public void setDbg(boolean r1) {
        HandlerC0343c r0 = this.mSmHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c = r1;
    }

    public final void setInitialState(com.obric.cae.libs.statemachine.b r4) {
        HandlerC0343c r3 = this.mSmHandler;
        if (r3.c == false) goto L5;
        r3.m.log("setInitialState: initialState=" + r4.getName());
    L5:
        r3.o = r4;
    }

    public final void setLogOnlyTransitions(boolean r1) {
        b r0 = this.mSmHandler.e;
        monitor-enter(r0);
        r0.e = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setLogRecSize(int r1) {
        b r0 = this.mSmHandler.e;
        monitor-enter(r0);
        r0.f6994b = r1;     // Catch: Throwable -> L7
        r0.c = 0;     // Catch: Throwable -> L7
        r0.d = 0;     // Catch: Throwable -> L7
        r0.f6993a.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void start() {
        HandlerC0343c r6 = this.mSmHandler;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.c == false) goto L8;
        r6.m.log("completeConstruction: E");
    L8:
        Iterator<HandlerC0343c.C0344c> r0 = r6.n.values().iterator();
        int r2 = 0;
    L10:
        if (r0.hasNext() == false) goto L17;
        HandlerC0343c.C0344c r3 = (HandlerC0343c.C0344c) ZeusTransformUtils.preCheckCast(r0.next(), HandlerC0343c.C0344c.class, "com.obric.memorydata.plugin");
        int r4 = 0;
    L12:
        if (r3 == null) goto L14;
        r3 = r3.f6999b;
        r4 = r4 + 1;
        goto L12
    L14:
        if (r2 >= r4) goto L10;
        r2 = r4;
        goto L10
    L17:
        if (r6.c == false) goto L19;
        r6.m.log("completeConstruction: maxDepth=" + r2);
    L19:
        r6.g = new HandlerC0343c.C0344c[r2];
        r6.i = new HandlerC0343c.C0344c[r2];
        if (r6.c == false) goto L22;
        r6.m.log("setupInitialStateStack: E mInitialState=" + r6.o.getName());
    L22:
        HandlerC0343c.C0344c r1 = (HandlerC0343c.C0344c) ZeusTransformUtils.preCheckCast(r6.n.get(r6.o), HandlerC0343c.C0344c.class, "com.obric.memorydata.plugin");
        r6.j = 0;
    L23:
        if (r1 == null) goto L25;
        HandlerC0343c.C0344c[] r5 = r6.i;
        int r7 = r6.j;
        r5[r7] = r1;
        r1 = r1.f6999b;
        r6.j = r7 + 1;
        goto L23
    L25:
        r6.h = -1;
        r6.b();
        r6.sendMessageAtFrontOfQueue(r6.obtainMessage(-2, HandlerC0343c.f6995a));
        if (r6.c == false) goto L36;
        r6.m.log("completeConstruction: X");
        return;
    }

    public String toString() {
        HandlerC0343c r0 = this.mSmHandler;     // Catch: Throwable -> L4
        String r1 = r0.g[r0.h].f6998a.getName().toString();     // Catch: Throwable -> L4
    L6:
        return "name=" + this.mName + " state=" + r1;
    L4:
        r1 = "null";
        goto L6
    }

    public final void transitionTo(com.obric.cae.libs.statemachine.a r3) {
        com.obric.cae.libs.statemachine.a r4 = (com.obric.cae.libs.statemachine.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.statemachine.a.class, "com.obric.memorydata.plugin");
        HandlerC0343c r2 = this.mSmHandler;
        Object r0 = HandlerC0343c.f6995a;
        r2.a(r4);
    }

    public final void transitionToHaltingState() {
        HandlerC0343c r1 = this.mSmHandler;
        r1.a(r1.k);
    }

    public void unhandledMessage(Message r3) {
        if (this.mSmHandler.c == false) goto L6;
        loge(" - unhandledMessage: msg.what=" + r3.what);
        return;
    }
}
