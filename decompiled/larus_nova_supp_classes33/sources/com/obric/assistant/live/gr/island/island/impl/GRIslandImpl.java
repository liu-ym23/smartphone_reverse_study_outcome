package com.obric.assistant.live.gr.island.island.impl;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.live.gr.island.business.utils.GRIslandType;
import com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate;
import com.obric.assistant.live.gr.island.island.template.GRComplexTaskOperatingExpandedTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;
import pea.f;
import pea.j;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GRIslandImpl {
    public final ConcurrentHashMap<j, Long> a;
    public final MutexImpl b;
    public final MutableSharedFlow<c> c;
    public final AtomicLong d;

    /* JADX INFO: renamed from: com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$1", f = "GRIslandImpl.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GRIslandImpl this$0;

        /* JADX INFO: renamed from: com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00091<T> implements FlowCollector {
            public final /* synthetic */ GRIslandImpl a;

            public C00091(GRIslandImpl r1) {
                this.a = r1;
            }

            public final Object a(c r8, Continuation<? super Unit> r9) {
                if ((r9 instanceof GRIslandImpl$1$1$emit$1) == false) goto L7;
                GRIslandImpl$1$1$emit$1 r0 = (GRIslandImpl$1$1$emit$1) r9;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L20;
                if (r3 == 1) goto L19;
                if (r3 != 2) goto L18;
                kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r0.L$0;
                ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
            L30:
                Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L33
                r11.unlock(null);
                return Unit.INSTANCE;
            L33:
                th = move-exception;
                r11.unlock(null);
                throw th;
            L15:
                Throwable th = th;
            L38:
                FLogger.a.e("GRIslandImpl", "createSession() error", th);     // Catch: Throwable -> L33
                goto L30
            L18:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L19:
                kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r0.L$1;
                c r4 = (c) r0.L$0;
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.sync.a r14 = r13;
                r8 = r4;
            L40:
                Function1<Continuation<? super Unit>, Object> r15 = r8.b;     // Catch: Throwable -> L27
                r0.L$0 = r14;     // Catch: Throwable -> L27
                r0.L$1 = null;     // Catch: Throwable -> L27
                r0.label = 2;     // Catch: Throwable -> L27
                if (r15.invoke(r0) != r2) goto L26;
                return r2;
            L26:
                r11 = r14;
            L27:
                th = move-exception;
                kotlinx.coroutines.sync.a r6 = r14;
                th = th;
                r11 = r6;
                goto L38
            L20:
                ResultKt.throwOnFailure(r10);
                r14 = this.a.b;
                r0.L$0 = r8;
                r0.L$1 = r14;
                r0.label = 1;
                if (r14.a(null, r0) != r2) goto L40;
                return r2;
            L7:
                r0 = new GRIslandImpl$1$1$emit$1(this, r9);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((c) r1, r2);
            }
        }

        public AnonymousClass1(GRIslandImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            GRIslandImpl r6 = this.this$0;
            MutableSharedFlow<c> r2 = r6.c;
            C00091 r3 = new C00091(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
    }

    static {
    }

    public GRIslandImpl() {
        this.a = new ConcurrentHashMap();
        this.b = kotlinx.coroutines.sync.b.a();
        int r2 = 0;
        this.c = SharedFlowKt.MutableSharedFlow$default(0, 64, null, 5, null);
        this.d = new AtomicLong(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) goto L25;
    L23:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L25:
        Context r1 = AppHost.a.getApplication().getApplicationContext();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L21
        Object r3 = r1.getSystemService("notification");     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.NotificationManager");     // Catch: Throwable -> L21
        NotificationManager r4 = (NotificationManager) r3;     // Catch: Throwable -> L21
        StatusBarNotification[] r5 = r4.getActiveNotifications();     // Catch: Throwable -> L21
        if (r5 == null) goto L23;
        int r6 = r5.length;     // Catch: Throwable -> L21
    L9:
        if (r2 >= r6) goto L23;
        StatusBarNotification r7 = r5[r2];     // Catch: Throwable -> L21
        Notification r8 = r7.getNotification();     // Catch: Throwable -> L21
        if (r8 == null) goto L13;
        String r9 = r8.getChannelId();     // Catch: Throwable -> L21
    L15:
        if (Intrinsics.areEqual(r9, "obric_gr_island_channel") == false) goto L20;
        FLogger.a.i("GRIslandImpl", "cancelLeftoverIslandNotifications() cancel id=" + r7.getId() + ", tag=" + r7.getTag() + ", channelId=" + r9);     // Catch: Throwable -> L21
        String r10 = r7.getTag();     // Catch: Throwable -> L21
        if (r10 == null) goto L19;
        r4.cancel(r10, r7.getId());     // Catch: Throwable -> L21
        goto L20
    L19:
        r4.cancel(r7.getId());     // Catch: Throwable -> L21
    L20:
        r2 = r2 + 1;
        goto L9
    L13:
        r9 = null;
    L21:
        th = move-exception;
        FLogger.a.e("GRIslandImpl", "cancelLeftoverIslandNotifications() error", th);
        goto L23
    }

    public final void c(j r5) {
        Intrinsics.checkNotNullParameter(r5, "session");
        this.c.tryEmit(new c(new GRIslandImpl$destroySession$1(r5, this, null)));
    }

    public final void e(j r5) {
        Intrinsics.checkNotNullParameter(r5, "session");
        this.c.tryEmit(new c(new GRIslandImpl$updateSessionFlags$1(this, r5, null)));
    }

    public final void b(j r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "session");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.c.tryEmit(new c(new GRIslandImpl$createSession$1(r5, this, r6, null)));
    }

    public final void f(j r4, k r5) {
        Intrinsics.checkNotNullParameter(r4, "targetSession");
        Intrinsics.checkNotNullParameter(r5, "targetWidget");
        this.c.tryEmit(new c(new GRIslandImpl$updateWidget$1(r4, this, null)));
    }

    public static final void a(GRIslandImpl r21, j r22, Context r23) {
        r21.getClass();
        boolean r2 = !r22.a();
        k r4 = r22.b;
        if (r4 == null) goto L5;
        l r6 = r4.b;
    L6:
        boolean r7 = r6 instanceof GRComplexTaskExpandedTemplate;
        if (r7 == false) goto L17;
        if (r2 == false) goto L13;
        if (r4 == null) goto L11;
        l r5 = r4.b;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        l r8 = ((GRComplexTaskExpandedTemplate) r5).getNormal();
    L20:
        if (r8 == null) goto L22;
        Bundle r9 = r8.getPics();
    L23:
        if (r8 == null) goto L25;
        Bundle r10 = r8.getActions();
    L27:
        if ((r8 instanceof GRExpandedNormalTemplate) == false) goto L30;
        f r11 = ((GRExpandedNormalTemplate) r8).getIconTextInfo();
    L36:
        if (r11 == null) goto L38;
        String r12 = r11.b;
    L40:
        if (o0.d(r12) == false) goto L44;
        if (r11 == null) goto L43;
        String r13 = r11.b;
    L45:
        if (r11 == null) goto L47;
        String r14 = r11.a;
    L49:
        if (o0.d(r14) == false) goto L53;
        if (r11 == null) goto L52;
        String r15 = r11.a;
    L54:
        Bundle r16 = r22.a.b.getPics();
        Bundle r17 = r22.c.b.getPics();
        Object r18 = r23.getSystemService("notification");
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager r19 = (NotificationManager) r18;
        if (r19.getNotificationChannel("obric_gr_island_channel") != null) goto L58;
        FLogger.a.d("GRIslandImpl", "ensureChannel() create channel: obric_gr_island_channel");
        r19.createNotificationChannel(new NotificationChannel("obric_gr_island_channel", "助手消息", 4));
    L58:
        JsonObject r3 = r22.k;
        if (r3 == null) goto L63;
        JsonElement r20 = r3.get("obric_island_type");
        if (r20 == null) goto L63;
        String r24 = r20.getAsString();
    L64:
        boolean r25 = Intrinsics.areEqual(r24, GRIslandType.REALTIME_CALL.getValue());
        if ((r22.l & 256) == 0) goto L67;
        boolean r26 = true;
    L68:
        if (r26 == false) goto L75;
        if (r25 == false) goto L75;
        IObricRealtimeCallExtService r27 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r27 == null) goto L74;
        PendingIntent r28 = r27.getNotificationPendingIntent(r23, true, r23);
        if (r28 == null) goto L74;
    L76:
        Notification.Builder r29 = new Notification.Builder(r23, "obric_gr_island_channel").setSmallIcon(2131244530).setContentTitle(r13).setContentText(r15).setContentIntent(r28);
        Bundle r30 = new Bundle();
        r30.putAll(r16);
        if (r9 == null) goto L79;
        r30.putAll(r9);
    L79:
        r30.putAll(r17);
        Integer r31 = r22.v;
        if (o0.d(r22.t) == true) goto L82;
    L85:
        Integer r32 = r22.y;
        if (o0.d(r22.w) == true) goto L88;
    L91:
        Bundle r33 = new Bundle();
        r33.putBundle("miui.focus.actions", r10);
        r33.putBundle("miui.focus.pics", r30);
        r29.addExtras(r33);
        JSONObject r34 = new JSONObject();
        if (r22.a() == false) goto L94;
        int r35 = 1;
        r34.put("enableFloat", true);
        r34.put("islandFirstFloat", true);
    L95:
        r34.put("protocol", r35);
        r34.put("business", r22.n);
        r34.put("updatable", r22.q);
        Integer r36 = r22.r;
        if (r36 == null) goto L98;
        r36.intValue();
        r34.put("timeout", r22.r);
    L98:
        String r37 = r22.s;
        if (r37 == null) goto L101;
        r34.put("reopen", r37);
    L101:
        String r38 = r22.t;
        if (r38 == null) goto L104;
        r34.put("ticker", r38);
    L104:
        String r39 = r22.u;
        if (r39 == null) goto L107;
        r34.put("tickerPic", r39);
    L107:
        String r40 = r22.w;
        if (r40 == null) goto L110;
        r34.put("aodTitle", r40);
    L110:
        String r41 = r22.x;
        if (r41 == null) goto L113;
        r34.put("aodPic", r41);
    L113:
        JSONObject r42 = new JSONObject();
        Integer r43 = r22.z;
        if (r43 == null) goto L116;
        r43.intValue();
        r42.put("islandProperty", r22.z);
    L116:
        Boolean r44 = r22.A;
        if (r44 == null) goto L119;
        r44.booleanValue();
        r42.put("islandOrder", r22.A);
    L119:
        Integer r45 = r22.B;
        if (r45 == null) goto L122;
        r45.intValue();
        r42.put("islandTimeout", r22.B);
    L122:
        Boolean r46 = r22.C;
        if (r46 == null) goto L125;
        r46.booleanValue();
        r42.put("dismissIsland", r22.C);
    L125:
        r42.put("bigIslandArea", r22.a.b.toJSONObject());
        r42.put("smallIslandArea", r22.c.b.toJSONObject());
        Integer r47 = r22.D;
        if (r47 == null) goto L128;
        r47.intValue();
        r42.put("expandedTime", r22.D);
    L128:
        r34.put("param_island", r42);
        boolean r48 = !r22.a();
        k r49 = r22.b;
        if (r49 == null) goto L131;
        l r50 = r49.b;
    L133:
        if ((r50 instanceof GRComplexTaskExpandedTemplate) == false) goto L143;
        if (r48 == false) goto L139;
        if (r49 == null) goto L137;
        l r51 = r49.b;
    L138:
        Intrinsics.checkNotNull(r51, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        JSONObject r52 = ((GRComplexTaskExpandedTemplate) r51).getNormal().toJSONObject();
    L148:
        if (r52 == null) goto L156;
        Iterator<String> r53 = r52.keys();
        if (r53 == null) goto L156;
    L152:
        if (r53.hasNext() == false) goto L156;
        String r54 = r53.next();
        Object r55 = r52.opt(r54);
        if (r55 == null) goto L152;
        r34.put(r54, r55);
    L156:
        JSONObject r56 = new JSONObject();
        r56.put("param_v2", r34);
        String r57 = r56.toString();
        Notification r58 = r29.build();
        r58.extras.putString("miui.focus.param", r57);
        Object r1 = r23.getSystemService("notification");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r1).notify((int) r22.g, r58);
        FLogger r59 = FLogger.a;
        StringBuilder r60 = new StringBuilder("sendNotify() taskId:");
        r60.append(r22.g);
        r60.append(",isNormal:");
        r60.append(r2);
        r60.append(", isComplexTaskTemplate:");
        r60.append(r7);
        r60.append(", expandTemplate:");
        k r0 = r22.b;
        if (r0 == null) goto L161;
        l r61 = r0.b;
        if (r61 == null) goto L161;
        String r62 = r61.getClass().getSimpleName();
    L162:
        r60.append(r62);
        r60.append(" param:");
        r60.append(r57);
        r59.i("GRIslandImpl", r60.toString());
        return;
    L161:
        r62 = null;
        goto L162
    L137:
        r51 = null;
        goto L138
    L139:
        if (r49 == null) goto L141;
        l r63 = r49.b;
    L142:
        Intrinsics.checkNotNull(r63, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        r52 = ((GRComplexTaskExpandedTemplate) r63).getDialogue().toJSONObject();
        goto L148
    L141:
        r63 = null;
        goto L142
    L143:
        if (r49 == null) goto L147;
        l r64 = r49.b;
        if (r64 == null) goto L147;
        r52 = r64.toJSONObject();
    L147:
        r52 = null;
        goto L148
    L131:
        r50 = null;
        goto L133
    L94:
        r35 = 1;
        r34.put("enableFloat", r22.o);
        r34.put("islandFirstFloat", r22.p);
        goto L95
    L88:
        if (o0.d(r22.x) == false) goto L91;
        if (r32 == null) goto L91;
        r30.putParcelable(r22.x, Icon.createWithResource(AppHost.a.getApplication().getApplicationContext(), r32.intValue()));
        goto L91
    L82:
        if (o0.d(r22.u) == false) goto L85;
        if (r31 == null) goto L85;
        r30.putParcelable(r22.u, Icon.createWithResource(AppHost.a.getApplication().getApplicationContext(), r31.intValue()));
    L74:
        r28 = r22.d;
    L75:
        r28 = r22.d;
        goto L76
    L67:
        r26 = false;
    L63:
        r24 = null;
        goto L64
    L52:
        r15 = null;
        goto L54
    L53:
        r15 = " ";
        goto L54
    L47:
        r14 = null;
        goto L49
    L43:
        r13 = null;
        goto L45
    L44:
        r13 = "豆包手机助手";
        goto L45
    L38:
        r12 = null;
        goto L40
    L30:
        if ((r8 instanceof GRComplexTaskOperatingExpandedTemplate) == false) goto L33;
        r11 = ((GRComplexTaskOperatingExpandedTemplate) r8).getIconTextInfo();
        goto L36
    L33:
        if ((r8 instanceof GRExpandedDialogueTemplate) == false) goto L35;
        r11 = ((GRExpandedDialogueTemplate) r8).getIconTextInfo();
        goto L36
    L35:
        r11 = null;
        goto L36
    L25:
        r10 = null;
        goto L27
    L22:
        r9 = null;
        goto L23
    L11:
        r5 = null;
        goto L12
    L13:
        if (r4 == null) goto L15;
        l r65 = r4.b;
    L16:
        Intrinsics.checkNotNull(r65, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        r8 = ((GRComplexTaskExpandedTemplate) r65).getDialogue();
        goto L20
    L15:
        r65 = null;
        goto L16
    L17:
        if (r4 == null) goto L19;
        r8 = r4.b;
        goto L20
    L19:
        r8 = null;
        goto L20
    L5:
        r6 = null;
        goto L6
    }

    public final void d(j r11, k r12, oea.a r13) {
        Intrinsics.checkNotNullParameter(r11, "targetSession");
        Intrinsics.checkNotNullParameter(r12, "targetWidget");
        Intrinsics.checkNotNullParameter("update_button", "eventId");
        Intrinsics.checkNotNullParameter(r13, "event");
        this.c.tryEmit(new c(new GRIslandImpl$sendEvent$1("update_button", r13, r12, this, r11, null)));
    }
}
