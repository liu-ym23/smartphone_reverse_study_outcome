package com.bytedance.ai.model.clienttool;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.router.ReplyLocalPluginMethod;
import com.bytedance.ai.bridge.protocol.LynxWorkerAIBridgePort;
import com.bytedance.ai.lynx.q;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.model.objects.RealData;
import com.bytedance.ai.resource.AppletResourceTool;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.TemplateData;
import d3.a0;
import d3.w;
import d3.z;
import f2.k;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ClientToolRuntime {
    public static final /* synthetic */ int q = 0;
    public final Applet a;
    public final Function1<ClientToolRuntime, Unit> b;
    public final String c;
    public final String d;
    public final Applet e;
    public final String f;
    public final String g;
    public final String h;
    public final Object i;
    public final CompletableJob j;
    public final CoroutineScope k;
    public d l;
    public LynxGroup m;
    public LynxBackgroundRuntime n;
    public w o;
    public final j p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/clienttool/ClientToolRuntime$RunningPhase;", "", "<init>", "(Ljava/lang/String;I)V", "PREPARING", "EXECUTING", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RunningPhase extends Enum<RunningPhase> {
        public static final RunningPhase EXECUTING = null;
        public static final RunningPhase PREPARING = null;
        public static final /* synthetic */ RunningPhase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RunningPhase> getEntries() {
            return b;
        }

        static {
            RunningPhase r0 = new RunningPhase("PREPARING", 0);
            PREPARING = r0;
            RunningPhase r1 = new RunningPhase("EXECUTING", 1);
            EXECUTING = r1;
            RunningPhase[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static RunningPhase[] values() {
            return (RunningPhase[]) a.clone();
        }

        public static RunningPhase valueOf(String r1) {
            return (RunningPhase) r27.a.a(RunningPhase.class, r1);
        }

        public RunningPhase(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/clienttool/ClientToolRuntime$SettleResult;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "DESTROYED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SettleResult extends Enum<SettleResult> {
        public static final SettleResult DESTROYED = null;
        public static final SettleResult IDLE = null;
        public static final /* synthetic */ SettleResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SettleResult> getEntries() {
            return b;
        }

        static {
            SettleResult r0 = new SettleResult("IDLE", 0);
            IDLE = r0;
            SettleResult r1 = new SettleResult("DESTROYED", 1);
            DESTROYED = r1;
            SettleResult[] r10 = {r0, r1};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static SettleResult[] values() {
            return (SettleResult[]) a.clone();
        }

        public static SettleResult valueOf(String r1) {
            return (SettleResult) r27.a.a(SettleResult.class, r1);
        }

        public SettleResult(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public final LLMData a;
        public final long b;
        public final String c;
        public final Function1<c, Unit> d;
        public final long e;
        public Long f;
        public boolean g;
        public Job h;
        public final String i;

        public a() {
            throw null;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r11.g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r11.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r10 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            long r11 = this.e;
            int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
            Long r13 = this.f;
            int r14 = 0;
            if (r13 != null) goto L5;
            int r15 = 0;
        L6:
            int r16 = (r12 + r15) * 31;
            if (this.g == false) goto L9;
            int r17 = 1231;
        L10:
            int r18 = (r16 + r17) * 31;
            Job r19 = this.h;
            if (r19 == null) goto L15;
            r14 = r19.hashCode();
        L15:
            return r18 + r14;
        L9:
            r17 = 1237;
            goto L10
        L5:
            r15 = r13.hashCode();
            goto L6
        }

        public final String toString() {
            return "Call(llmData=" + this.a + ", messageReceivedTime=" + this.b + ", callbackId=" + this.c + ", terminal=" + this.d + ", startedAt=" + this.e + ", callAbilitySentAt=" + this.f + ", reused=" + this.g + ", timeoutJob=" + this.h + ')';
        }

        public a(LLMData r10, long r11, String r12, com.bytedance.ai.model.clienttool.c r13) {
            long r0 = SystemClock.elapsedRealtime();
            Intrinsics.checkNotNullParameter(r10, "llmData");
            Intrinsics.checkNotNullParameter(r12, "callbackId");
            Intrinsics.checkNotNullParameter(r13, "terminal");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r0;
            this.f = null;
            this.g = false;
            this.h = null;
            String r14 = r10.getMsgId();
            if (r14 != null) goto L5;
            r14 = "";
        L5:
            this.i = r14;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final int a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            String r13 = this.c;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            String r16 = this.d;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            String r19 = this.e;
            if (r19 == null) goto L19;
            r10 = r19.hashCode();
        L19:
            return r18 + r10;
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ExecutionResult(code=" + this.a + ", message=" + this.b + ", data=" + this.c + ", failureStage=" + this.d + ", failureReason=" + this.e + ')';
        }

        public c(int r1, String r10, String r11, String r12, String r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public final a a;
            public final boolean b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L8;
                return false;
            L8:
                a r11 = (a) r10;
                if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r11.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                if (this.b == false) goto L5;
                int r1 = 1231;
            L7:
                return r0 + r1;
            L5:
                r1 = 1237;
                goto L7
            }

            public final String toString() {
                return "Completing(call=" + this.a + ", reusableAfterAck=" + this.b + ')';
            }

            public a(a r10, boolean r11) {
                Intrinsics.checkNotNullParameter(r10, "call");
                this.a = r10;
                this.b = r11;
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends d {
            public Job a;

            public c() {
                this(0);
            }

            public c(int r1) {
                this.a = null;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.model.clienttool.ClientToolRuntime$d$d, reason: collision with other inner class name */
        public static final class C0042d extends d {
            public static final C0042d a = null;

            static {
                a = new C0042d();
            }

            public C0042d() {
            }
        }

        public static final class e extends d {
            public final a a;
            public final RunningPhase b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof e) == true) goto L8;
                return false;
            L8:
                e r11 = (e) r10;
                if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r11.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Running(call=" + this.a + ", phase=" + this.b + ')';
            }

            public e(a r10, RunningPhase r11) {
                Intrinsics.checkNotNullParameter(r10, "call");
                Intrinsics.checkNotNullParameter(r11, "phase");
                this.a = r10;
                this.b = r11;
            }
        }

        public d() {
        }
    }

    public static final class e extends a0 {
        public final String a;
        public final String b;
        public final ContainerType c;
        public final String d;
        public final int e;

        @Override // d3.a0
        public final Integer getAppSourceType() {
            return Integer.valueOf(this.e);
        }

        @Override // d3.a0
        public final String getAppId() {
            return this.b;
        }

        @Override // d3.a0
        public final String getAppletId() {
            return this.a;
        }

        @Override // d3.a0
        public final String getContainerId() {
            return this.d;
        }

        @Override // d3.a0
        public final ContainerType getContainerType() {
            return this.c;
        }

        public e(ClientToolRuntime r10) {
            String r0 = r10.f;
            this.a = r0;
            this.b = r0;
            this.c = ContainerType.WORKER;
            this.d = "client_tool_" + r10.c;
            this.e = r10.a.G;
        }
    }

    static {
    }

    public final TemplateData a() {
        boolean r10 = false;
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(BdpAwemeConstant.KEY_APP_ID, this.f), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, this.a.a)});
        String r1 = this.a.b();
        if (r1 != null) goto L5;
    L13:
        q r11 = q.a;
        h2.a r12 = f2.b.c;
        if (r12 == null) goto L17;
        String r13 = r12.m;
        if (r13 == null) goto L17;
    L18:
        Map r14 = MapsKt.toMutableMap(q.c(r13));
        r14.put("__AI_SDK_VERSION__", "1.15.0-rc.7");
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 != null) goto L21;
    L23:
        if (r10 == false) goto L25;
        String r16 = "dark";
    L26:
        r14.put("appTheme", r16);
        Object r17 = r14.get("screenWidth");
        if (r17 == null) goto L29;
        r14.put("containerWidth", r17);
    L29:
        Object r18 = r14.get("screenHeight");
        if (r18 == null) goto L32;
        r14.put("containerHeight", r18);
    L32:
        r14.put("packageInfo", r0);
        TemplateData r19 = TemplateData.fromMap(r14);
        r19.markReadOnly();
        return r19;
    L25:
        r16 = "light";
        goto L26
    L21:
        if (r15.v(k.a()) != true) goto L23;
        r10 = true;
    L17:
        r13 = "";
        goto L18
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r20 = true;
    L8:
        if (r20 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r0.put("iconSrc", r1);
        goto L13
    L7:
        r20 = false;
        goto L8
    }

    public final void b() {
        Object r0 = this.i;
        monitor-enter(r0);
        d r1 = this.l;     // Catch: Throwable -> L36
        d.b r10 = d.b.a;     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(r1, r10) == false) goto L8;
        boolean r11 = false;
        a r12 = null;
        Job r13 = null;
    L22:
        monitor-exit(r0);
        if (r11 == true) goto L25;
        return;
    L25:
        if (r13 == null) goto L27;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L27:
        if (r12 == null) goto L32;
        Job r14 = r12.h;
        if (r14 == null) goto L31;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L31:
        r12.h = null;
        this.a.g();
    L32:
        g();
        return;
    L8:
        if ((r1 instanceof d.e) == false) goto L13;
        a r15 = ((d.e) r1).a;     // Catch: Throwable -> L36
        this.l = r10;     // Catch: Throwable -> L36
    L10:
        r12 = r15;
        r13 = null;
    L11:
        r11 = true;
        goto L22
    L13:
        if ((r1 instanceof d.a) == false) goto L16;
        r15 = ((d.a) r1).a;     // Catch: Throwable -> L36
        this.l = r10;     // Catch: Throwable -> L36
        goto L10
    L16:
        if ((r1 instanceof d.c) == false) goto L19;
        r13 = ((d.c) r1).a;     // Catch: Throwable -> L36
        ((d.c) r1).a = null;     // Catch: Throwable -> L36
        this.l = r10;     // Catch: Throwable -> L36
        r12 = null;
        goto L11
    L19:
        if (Intrinsics.areEqual(r1, d.C0042d.a) == false) goto L35;
        this.l = r10;     // Catch: Throwable -> L36
        r12 = null;
        r13 = null;
        goto L11
    L35:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    public final void g() {
        com.bytedance.ai.utils.g.a.i("ClientToolRuntime", "destroy runtimeId=" + this.c + " appletId=" + this.f);
        Job.DefaultImpls.cancel$default(this.j, null, 1, null);
        w r0 = this.o;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        this.o = null;
        LynxBackgroundRuntime r1 = this.n;
        if (r1 == null) goto L10;
        j r10 = this.p;
        if (r1.d.contains(r10) == false) goto L10;
        r1.d.remove(r10);
    L10:
        LynxBackgroundRuntime r11 = this.n;
        if (r11 == null) goto L13;
        r11.b();
    L13:
        this.n = null;
        LynxGroup r12 = this.m;
        if (r12 == null) goto L16;
        r12.destroy();
    L16:
        this.m = null;
    }

    public final void d(final LynxBackgroundRuntime r10) {
        AppletBridgeModule.b r11 = new AppletBridgeModule.b(new s4.c(), new ClientToolRuntime$initializeBridge$modelParams$1(s4.d.a), new f(this), ContainerType.WORKER, new g(r10));
        r10.b.c("AppletBridgeModule", AppletBridgeModule.class, r11);
        LynxModule r12 = r10.b.b("AppletBridgeModule").getModule();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule");
        LynxWorkerAIBridgePort r0 = new LynxWorkerAIBridgePort((AppletBridgeModule) r12);
        w r13 = new w();
        r13.d(new com.bytedance.ai.model.clienttool.a());
        r13.d(new q4.a());
        r13.d(new o4.b());
        r13.d(new k4.a());
        g3.b r1 = new g3.b();
        Intrinsics.checkNotNullParameter(r1, "methodSeeker");
        r13.c.add(r1);
        r13.i.e(a0.class, new e(this));
        r13.i.e(ClientToolRuntime.class, this);
        r13.i.e(z.class, new h(this));
        Intrinsics.checkNotNullParameter(ReplyLocalPluginMethod.class, "clazz");
        r13.b.b(ReplyLocalPluginMethod.class);
        r13.k(r0);
        this.o = r13;
    }

    public final boolean e(a r10) {
        Object r0 = this.i;
        monitor-enter(r0);
        d r1 = this.l;     // Catch: Throwable -> L15
        a r11 = null;
        if ((r1 instanceof d.e) == false) goto L7;
        d.e r12 = (d.e) r1;     // Catch: Throwable -> L15
    L8:
        if (r12 == null) goto L10;
        r11 = r12.a;     // Catch: Throwable -> L15
    L10:
        if (r11 != r10) goto L12;
        boolean r13 = true;
    L13:
        monitor-exit(r0);
        return r13;
    L12:
        r13 = false;
        goto L13
    L7:
        r12 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final void f(final a r10) {
        AppletResourceTool r0 = AppletResourceTool.a;
        Applet r1 = this.a;
        String r11 = this.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r11, "runtimeEntry");
        if (h5.e.a(r1.h, "3.0") < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        String r13 = r0.j(r1, r11);
    L9:
        com.bytedance.ai.utils.g.a.i("ClientToolRuntime", "load entry runtimeId=" + this.c + " appletId=" + this.f + " messageId=" + r10.i);
        AppletResourceTool.q(this.a.x, r13, new com.bytedance.ai.model.clienttool.d(this, r10), new com.bytedance.ai.model.clienttool.e(this, r10), false);
        return;
    L8:
        r13 = r0.f(r1, r11, true);
        goto L9
    L5:
        r12 = false;
        goto L6
    }

    public final void h(a r11) {
        JsonObject r0 = new JsonObject();
        LLMData r1 = r11.a;
        r0.addProperty("botId", r1.getFromBotId());
        r0.addProperty("callbackId", r11.c);
        RealData r10 = r1.getData();
        a r12 = null;
        if (r10 == null) goto L5;
        String r13 = r10.getPluginId();
    L6:
        r0.addProperty("abilityKey", r13);
        r0.addProperty("llmData", r1.realPluginParams());
        r0.addProperty("createTime", r1.getCreateTime());
        r0.addProperty("msgReceivedTime", Long.valueOf(r11.b));
        r0.addProperty("msgId", r11.i);
        r0.addProperty("questionId", r1.getQuestionId());
        r0.addProperty("conversationId", r1.getConversationID());
        Map<String, String> r14 = r1.getFeatureMap();
        if (r14 != null) goto L9;
    L18:
        long r15 = SystemClock.elapsedRealtime();
        Object r16 = this.i;
        monitor-enter(r16);
        d r17 = this.l;     // Catch: Throwable -> L48
        if ((r17 instanceof d.e) == false) goto L23;
        d.e r18 = (d.e) r17;     // Catch: Throwable -> L48
    L24:
        if (r18 == null) goto L27;
        r12 = r18.a;     // Catch: Throwable -> L48
    L27:
        if (r12 == r11) goto L29;
    L36:
        boolean r19 = false;
    L37:
        monitor-exit(r16);
        if (r19 == true) goto L40;
        return;
    L40:
        LruCache<Long, com.bytedance.ai.utils.j.a> r20 = com.bytedance.ai.utils.j.a;
        com.bytedance.ai.utils.j.a r21 = com.bytedance.ai.utils.j.b(StringsKt.toLongOrNull(r11.i));
        if (r21 != null) goto L43;
    L46:
        com.bytedance.ai.utils.g.a.i("ClientToolRuntime", "send callAbility runtimeId=" + this.c + " messageId=" + r11.i);
        return;
    L43:
        if (r11.g == true) goto L45;
        r21.b(new Pair[]{TuplesKt.to("client_tool_runtime_start_duration_ms", Long.valueOf(r15 - r11.e))});
    L45:
        r21.n.a();
        goto L46
    L29:
        if (r18.b != RunningPhase.EXECUTING) goto L36;
        w r22 = this.o;     // Catch: Throwable -> L48
        if (r22 == null) goto L36;
        r11.f = Long.valueOf(r15);     // Catch: Throwable -> L48
        r22.a("callAbility", r0);     // Catch: Throwable -> L48
        r19 = true;
        goto L37
    L23:
        r18 = null;
    L48:
        th = move-exception;
        throw th;
    L9:
        if ((!r14.isEmpty()) == true) goto L12;
        r14 = null;
    L12:
        if (r14 == null) goto L18;
        JsonObject r23 = new JsonObject();
        Iterator<Map.Entry<String, String>> r24 = r14.entrySet().iterator();
    L15:
        if (r24.hasNext() == false) goto L17;
        Map.Entry<String, String> r25 = r24.next();
        r23.addProperty(r25.getKey(), r25.getValue());
        goto L15
    L17:
        Unit r26 = Unit.INSTANCE;
        r0.add("featureMap", r23);
        goto L18
    L5:
        r13 = null;
        goto L6
    }

    public final void j(a r11) {
        Job r0 = BuildersKt.launch$default(this.k, null, null, new ClientToolRuntime$startExecutionTimeout$timeoutJob$1(15000, this, r11, null), 3, null);
        Object r1 = this.i;
        monitor-enter(r1);
        d r10 = this.l;     // Catch: Throwable -> L17
        if ((r10 instanceof d.e) == false) goto L7;
        d.e r12 = (d.e) r10;     // Catch: Throwable -> L17
    L8:
        if (r12 == null) goto L10;
        a r13 = r12.a;     // Catch: Throwable -> L17
    L11:
        if (r13 != r11) goto L13;
        r11.h = r0;     // Catch: Throwable -> L17
    L14:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r1);
        return;
    L13:
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L17
        goto L14
    L10:
        r13 = null;
        goto L11
    L7:
        r12 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final void k(d.c r10) {
        Job r0 = BuildersKt.launch$default(this.k, null, null, new ClientToolRuntime$startIdleTimeout$timeoutJob$1(this, r10, null), 3, null);
        Object r1 = this.i;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.l != r10) goto L7;
        r10.a = r0;     // Catch: Throwable -> L11
    L8:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);
        return;
    L7:
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L11
        goto L8
    }

    public ClientToolRuntime(Applet r10, com.bytedance.ai.model.clienttool.b r11) {
        Intrinsics.checkNotNullParameter(r10, "runtimeApplet");
        Intrinsics.checkNotNullParameter(r11, "onInvalidated");
        this.a = r10;
        this.b = r11;
        String r12 = UUID.randomUUID().toString();
        this.c = r12;
        this.d = r10.b;
        this.e = r10;
        String r0 = r10.o();
        this.f = r0;
        String r13 = r10.Z;
        if (r13 == null) goto L5;
        String r14 = StringsKt.trim(r13).toString();
    L6:
        if (r14 != null) goto L8;
        r14 = "";
    L8:
        this.g = r14;
        this.h = "/" + r0 + '-' + r12 + "-client-tool.js";
        this.i = new Object();
        CompletableJob r15 = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.j = r15;
        this.k = CoroutineScopeKt.CoroutineScope(r15.plus(com.bytedance.ai.infra.thread_pool.b.d));
        this.l = d.C0042d.a;
        this.p = new j(this);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final SettleResult i(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Object r0 = this.i;
        monitor-enter(r0);
        d r1 = this.l;     // Catch: Throwable -> L41
        d.c r12 = null;
        if ((r1 instanceof d.a) == false) goto L7;
        d.a r13 = (d.a) r1;     // Catch: Throwable -> L41
    L8:
        boolean r14 = false;
        if (r13 != null) goto L11;
    L21:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r0);
        if (r14 == true) goto L26;
        b();
        return SettleResult.DESTROYED;
    L26:
        this.a.g();
        if (r12 != null) goto L30;
        g();
        return SettleResult.DESTROYED;
    L30:
        k(r12);
        Object r16 = this.i;
        monitor-enter(r16);
    L38:
        th = move-exception;
        throw th;
    L33:
        if (this.l != r12) goto L35;
        SettleResult r17 = SettleResult.IDLE;     // Catch: Throwable -> L38
    L36:
        monitor-exit(r16);
        return r17;
    L35:
        r17 = SettleResult.DESTROYED;     // Catch: Throwable -> L38
        goto L36
    L11:
        if (Intrinsics.areEqual(r13.a.i, r10) == false) goto L21;
        Job r18 = r13.a.h;     // Catch: Throwable -> L41
        if (r18 == null) goto L15;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);     // Catch: Throwable -> L41
    L15:
        r13.a.h = null;     // Catch: Throwable -> L41
        if (r13.b == false) goto L19;
        if (r11 == false) goto L19;
        r12 = new d.c(0);     // Catch: Throwable -> L41
        this.l = r12;     // Catch: Throwable -> L41
    L20:
        r14 = true;
    L19:
        this.l = d.b.a;     // Catch: Throwable -> L41
        goto L20
    L7:
        r13 = null;
    L41:
        th = move-exception;
        throw th;
    }

    public final boolean c(a r10, c r11, boolean r12) {
        Object r0 = this.i;
        monitor-enter(r0);
        d r1 = this.l;     // Catch: Throwable -> L53
        if ((r1 instanceof d.e) == false) goto L7;
        d.e r13 = (d.e) r1;     // Catch: Throwable -> L53
    L8:
        if (r13 == null) goto L10;
        a r14 = r13.a;     // Catch: Throwable -> L53
    L12:
        if (r14 == r10) goto L14;
        boolean r15 = false;
    L19:
        monitor-exit(r0);
        if (r15 == true) goto L22;
        return false;
    L22:
        long r16 = SystemClock.elapsedRealtime();
        LruCache<Long, com.bytedance.ai.utils.j.a> r17 = com.bytedance.ai.utils.j.a;
        com.bytedance.ai.utils.j.a r18 = com.bytedance.ai.utils.j.b(StringsKt.toLongOrNull(r10.i));
        if (r18 == null) goto L56;
        Pair<String, ? extends Object>[] r19 = new Pair[1];
        if (r11.a != 0) goto L27;
        int r20 = 1;
    L28:
        r19[0] = TuplesKt.to("client_tool_result_success", Integer.valueOf(r20));
        r18.b(r19);
        Long r21 = r10.f;
        if (r21 == null) goto L32;
        r18.b(new Pair[]{TuplesKt.to("client_tool_duration_ms", Long.valueOf(r16 - r21.longValue()))});
    L32:
        if (r10.g == true) goto L37;
        if (r10.f != null) goto L37;
        r18.b(new Pair[]{TuplesKt.to("client_tool_runtime_start_duration_ms", Long.valueOf(r16 - r10.e))});
    L37:
        if (r11.a == 0) goto L56;
        Pair<String, ? extends Object>[] r22 = new Pair[2];
        String r23 = r11.d;
        if (r23 != null) goto L41;
        r23 = "execute";
    L41:
        r22[0] = TuplesKt.to("client_tool_failure_stage", r23);
        String r24 = r11.e;
        if (r24 != null) goto L44;
        r24 = "runtime_error";
    L44:
        r22[1] = TuplesKt.to("client_tool_failure_reason", r24);
        r18.b(r22);
        goto L56
    L27:
        r20 = 0;
    L56:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L47
        r10.d.invoke(r11);     // Catch: Throwable -> L47
        Object r111 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r112 = Result.exceptionOrNull-impl(r111);
        if (r112 == null) goto L52;
        com.bytedance.ai.utils.g.a.e("ClientToolRuntime", "Client Tool terminal callback failed", r112);
        i(r10.i, false);
    L52:
        return true;
    L47:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L14:
        Job r25 = r10.h;     // Catch: Throwable -> L53
        if (r25 == null) goto L17;
        Job.DefaultImpls.cancel$default(r25, null, 1, null);     // Catch: Throwable -> L53
    L17:
        r10.h = null;     // Catch: Throwable -> L53
        this.l = new d.a(r10, r12);     // Catch: Throwable -> L53
        r15 = true;
        goto L19
    L10:
        r14 = null;
        goto L12
    L7:
        r13 = null;
    L53:
        th = move-exception;
        throw th;
    }
}
