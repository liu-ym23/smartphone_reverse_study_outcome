package com.zte.miboard.recommend.agent;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m.a0;
import m.c0;
import m.f;
import m.w;
import m.x;
import m.y;
import m.z;

/* JADX INFO: loaded from: classes3.dex */
public class HandleService extends Service implements f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f16482h = "Mi_R_HandleService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f16483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f16484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f16485c;
    private ExecutorService d;
    private e e;
    private z f;
    private c0 g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HandleService f16487b;

        public a(HandleService r5, String r10) {
            this.f16487b = r5;
            this.f16486a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r5 = HandleService.b();
            androidx.constraintlayout.motion.widget.a.B(new StringBuilder("test debug agent postStartLocalPrompt LOCAL_SMS run prompt="), this.f16486a, r5);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f16489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ HandleService f16490c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f16491a;

            public a(b r5) {
                this.f16491a = r5;
            }

            @Override // java.lang.Runnable
            public void run() {
                String r5 = HandleService.b();
                androidx.constraintlayout.motion.widget.a.B(new StringBuilder("test debug agent postStartLocalPrompt AGENT_TYPE_LOCAL_ASR_RECOMMEND run  prompt="), this.f16491a.f16488a, r5);
                HandleService.a(this.f16491a.f16490c).a(this.f16491a.f16488a);
            }
        }

        public b(HandleService r5, String r10, long r11) {
            this.f16490c = r5;
            this.f16488a = r10;
            this.f16489b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r5 = new a(this);
            HandleService.b(this.f16490c).postDelayed(r5, this.f16489b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HandleService f16493b;

        public c(HandleService r5, String r10) {
            this.f16493b = r5;
            this.f16492a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r5 = HandleService.b();
            androidx.constraintlayout.motion.widget.a.B(new StringBuilder("test debug agent postStartLocalPrompt AGENT_TYPE_LOCAL_RECOMMEND run  prompt="), this.f16492a, r5);
            HandleService.a(this.f16493b).a(this.f16492a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ HandleService f16495b;

        public d(HandleService r5, String r10) {
            this.f16495b = r5;
            this.f16494a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r5 = HandleService.b();
            androidx.constraintlayout.motion.widget.a.B(new StringBuilder("test debug agent postStartLocalPrompt AGENT_VERYZHUN_RECOMMEND run  prompt="), this.f16494a, r5);
            c0 r10 = HandleService.a(this.f16495b);
            Object[] r11 = {this.f16494a};
            r10.f19868a.a("LocalFeichangzhunTool", "extractFlightInfo", r11);
        }
    }

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HandleService f16496a;

        private e(HandleService r5) {
            this.f16496a = r5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            Log.d(HandleService.b(), "test debug agent HandleService handleMessage msg.what = " + r5.what);
        }

        public /* synthetic */ e(HandleService r5, a r10) {
            this(r5);
        }
    }

    public HandleService() {
        this.f16484b = null;
        this.f16485c = null;
        this.d = Executors.newSingleThreadExecutor();
        this.e = new e(this, null);
        this.f = null;
        this.g = null;
    }

    public static /* synthetic */ c0 a(HandleService r5) {
        return r5.g;
    }

    public static /* synthetic */ String b() {
        return f16482h;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r5) {
        Log.d(f16482h, "test debug agent HandleService onBind action:" + r5.getAction());
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(f16482h, "test debug agent HandleService onCreate:");
        this.f16483a = getApplicationContext();
        z r5 = new z();
        HashMap r10 = new HashMap();
        r5.f19942a = r10;
        a0 r11 = new a0(a());
        List r12 = (List) r10.get("LocalTravelBookingTool");
        if (r12 != null) goto L5;
        r12 = new ArrayList();
    L5:
        r12.add(r11);
        r10.put("LocalTravelBookingTool", r12);
        x r13 = new x(a());
        List r14 = (List) r10.get("LocalHotelBookingTool");
        if (r14 != null) goto L8;
        r14 = new ArrayList();
    L8:
        r14.add(r13);
        r10.put("LocalHotelBookingTool", r14);
        w r15 = new w(a());
        List r16 = (List) r10.get("LocalFeichangzhunTool");
        if (r16 != null) goto L11;
        r16 = new ArrayList();
    L11:
        r16.add(r15);
        r10.put("LocalFeichangzhunTool", r16);
        this.f = r5;
        c0 r17 = new c0();
        r17.f19868a = this;
        a();
        if (m.b.d != null) goto L14;
        m.b.d = new m.b(12);
    L14:
        this.g = r17;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(f16482h, "test debug agent HandleService onDestroy:");
        Runnable r5 = this.f16484b;
        if (r5 == null) goto L5;
        this.e.removeCallbacks(r5);
    L5:
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r5, int r10, int r11) {
        if (r5 != null) goto L5;
        return 2;
    L5:
        Log.d(f16482h, "test debug agent HandleService onStartCommand action:" + r5.getAction() + ",this=" + this);
        String r12 = r5.getAction();
        if ("com.zte.intent.action.VERYZHUN_RECOMMEND_ACTION".equals(r12) == false) goto L12;
        String r13 = r5.getStringExtra("veryZhunPush");
        if (r13 == null) goto L10;
        a(4, r13, 200);
    L10:
        return 1;
    L12:
        if ("com.zte.intent.action.AGENT_RECOMMEND_ACTION".equals(r12) == false) goto L18;
        String r14 = r5.getStringExtra("agentRecommendKey");
        if (r14 == null) goto L16;
        a(2, r14, 200);
    L16:
        return 1;
    L18:
        if ("com.zte.intent.action.ASR_RECOMMEND_LOCAL_ACTION".equals(r12) == false) goto L22;
        String r15 = r5.getStringExtra("asrRecommendLocalKey");
        if (r15 == null) goto L22;
        a(1, r15, 200);
    L22:
        Log.d(m.d.f19867b, "test debug agent LLM disable");
        return 1;
    }

    public static /* synthetic */ e b(HandleService r5) {
        return r5.e;
    }

    @Override // m.f
    public Context a() {
        return this.f16483a;
    }

    @Override // m.f
    public boolean a(String r10, String r11, Object... r12) {
        z r13 = this.f;
        r13.getClass();
        String r5 = z.f19941b;
        Log.d(r5, "test debug agent handleLocalCallback toolName:" + r10 + ",funcName:" + r11 + ",param=" + r12);
        List r14 = (List) r13.f19942a.get(r10);
        if (r14 == null) goto L13;
        Iterator r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L22;
        y r16 = (y) r15.next();
        if (r16 == null) goto L6;
        r16.a(r10, r11, r12);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        StringBuilder r17 = androidx.constraintlayout.motion.widget.a.y("test debug agent handleLocalCallback  toolName:", r10, ",funcName:", r11, ",param=");
        r17.append(r12);
        r17.append(",exception=");
        r17.append(e);
        Log.d(r5, r17.toString());
        goto L6
    L22:
        return true;
    L13:
        return true;
    }

    private void a(int r5, String r10, long r11) {
        if (r10 != null) goto L5;
        Log.d(m.d.f19867b, "test debug agent postStartLocalPrompt invalid prompt: null");
        return;
    L5:
        if (r5 != 0) goto L9;
        a r12 = new a(this, r10);
        this.e.postDelayed(r12, r11);
        return;
    L9:
        if (r5 != 1) goto L13;
        b r13 = new b(this, r10, r11);
        this.e.postDelayed(r13, r11);
        return;
    L13:
        if (r5 != 2) goto L17;
        c r14 = new c(this, r10);
        this.e.postDelayed(r14, r11);
        return;
    L17:
        if (r5 != 4) goto L20;
        d r15 = new d(this, r10);
        this.e.postDelayed(r15, r11);
        return;
    }
}
