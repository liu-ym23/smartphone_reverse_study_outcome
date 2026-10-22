package com.obric.aiproactive.ui.ipc;

import android.content.Context;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003234B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005J \u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&J\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0)2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110)2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010+\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0005H\u0002J \u0010.\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010/\u001a\u00020,H\u0002J\u0018\u00100\u001a\u00020&2\u0006\u0010/\u001a\u00020,2\u0006\u00101\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u00065"}, d2 = {"Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore;", "", "<init>", "()V", "SP_NAME", "", "KEY_PENDING_ADOPTED", "KEY_PENDING_DISMISSED", "KEY_TIMESTAMP", "KEY_FEEDBACK_ACTION", "KEY_REASON", "PENDING_WINDOW_MILLIS", "", "adoptedEventsInternal", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$AdoptedEvent;", "dismissedEventsInternal", "Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$DismissedEvent;", "feedbackReportResultEventsInternal", "Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$FeedbackReportResultEvent;", "adoptedEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "getAdoptedEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "dismissedEvents", "getDismissedEvents", "feedbackReportResultEvents", "getFeedbackReportResultEvents", "publishAdopted", "", "context", "Landroid/content/Context;", "recommendId", "feedbackAction", "publishDismissed", InfoRequestQPSOptTraceLogger.REASON, "publishFeedbackReportResult", "success", "", "shouldToast", "peekPendingAdoptedEvents", "", "peekPendingDismissedEvents", "readPending", "Lorg/json/JSONObject;", "key", "writePending", "pending", "pruneExpiredLocked", "now", "AdoptedEvent", "DismissedEvent", "FeedbackReportResultEvent", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ad<C0305a> f6678b = null;
    private static final ad<b> c = null;
    private static final ad<c> d = null;
    private static final ai<C0305a> e = null;
    private static final ai<b> f = null;
    private static final ai<c> g = null;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.ipc.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$AdoptedEvent;", "", "recommendId", "", "feedbackAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRecommendId", "()Ljava/lang/String;", "getFeedbackAction", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0305a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6680b;

        public C0305a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "recommendId");
            this.f6679a = r2;
            this.f6680b = r3;
        }

        public final String a() {
            return this.f6680b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0305a.class) == true) goto L8;
            return false;
        L8:
            C0305a r6 = (C0305a) ZeusTransformUtils.preCheckCast(r5, C0305a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6679a, r6.f6679a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6680b, r6.f6680b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f6679a.hashCode() * 31;
            String r1 = this.f6680b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "AdoptedEvent(recommendId=" + this.f6679a + ", feedbackAction=" + this.f6680b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$DismissedEvent;", "", "recommendId", "", InfoRequestQPSOptTraceLogger.REASON, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRecommendId", "()Ljava/lang/String;", "getReason", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6682b;

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "recommendId");
            this.f6681a = r2;
            this.f6682b = r3;
        }

        public final String a() {
            return this.f6682b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6681a, r6.f6681a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6682b, r6.f6682b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f6681a.hashCode() * 31;
            String r1 = this.f6682b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "DismissedEvent(recommendId=" + this.f6681a + ", reason=" + this.f6682b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/ipc/ProactiveUiSyncStore$FeedbackReportResultEvent;", "", "success", "", "shouldToast", "<init>", "(ZZ)V", "getSuccess", "()Z", "getShouldToast", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6684b;

        public c(boolean r1, boolean r2) {
            this.f6683a = r1;
            this.f6684b = r2;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f6683a == r6.f6683a) goto L12;
            return false;
        L12:
            if (this.f6684b == r6.f6684b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f6683a) * 31) + Boolean.hashCode(this.f6684b);
        }

        public String toString() {
            return "FeedbackReportResultEvent(success=" + this.f6683a + ", shouldToast=" + this.f6684b + ')';
        }
    }

    static {
        f6677a = new a();
        ad<C0305a> r4 = ak.a(16, 32, null, 4, null);
        f6678b = r4;
        ad<b> r1 = ak.a(16, 32, null, 4, null);
        c = r1;
        ad<c> r0 = ak.a(0, 16, null, 4, null);
        d = r0;
        e = k.a(r4);
        f = k.a(r1);
        g = k.a(r0);
    }

    private a() {
    }

    private final JSONObject a(Context r4, String r5) {
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("proactive_ui_sync", 0).getString(r5, null);
        if (r6 == null) goto L5;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L8
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r8 = Result.m1421constructorimpl(new JSONObject(r6));     // Catch: Throwable -> L8
    L10:
        JSONObject r9 = new JSONObject();
        if (Result.m1427isFailureimpl(r8) == false) goto L14;
        r8 = r9;
    L14:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        return new JSONObject();
    }

    private final void a(Context r2, String r3, JSONObject r4) {
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("proactive_ui_sync", 0).edit().putString(r3, r4.toString()).apply();
    }

    private final boolean a(JSONObject r8, long r9) {
        long r10 = r9 - 600000;
        ArrayList r7 = new ArrayList();
        Iterator<String> r0 = r8.keys();
    L4:
        if (r0.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Object r3 = r8.opt(r1);
        long r5 = 0;
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L9;
        r5 = ((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin")).optLong("timestamp", 0);
    L12:
        if (r5 >= r10) goto L4;
        r7.add(r1);
        goto L4
    L9:
        if (ZeusTransformUtils.instanceOf(r3, Number.class) == false) goto L12;
        r5 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue();
        goto L12
    L15:
        if (r7.isEmpty() == false) goto L18;
        return false;
    L18:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        r8.remove((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));
        goto L20
    L22:
        return true;
    }

    public final Map<String, C0305a> a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L21
        a r2 = f6677a;     // Catch: Throwable -> L21
        JSONObject r3 = r2.a(r9, "pending_adopted_v1");     // Catch: Throwable -> L21
        if (r2.a(r3, r0) == false) goto L7;
        r2.a(r9, "pending_adopted_v1", r3);     // Catch: Throwable -> L21
    L7:
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L21
        Iterator<String> r1 = r3.keys();     // Catch: Throwable -> L21
    L9:
        if (r1.hasNext() == false) goto L18;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        JSONObject r5 = r3.optJSONObject(r4);     // Catch: Throwable -> L21
        String r6 = null;
        if (r5 == null) goto L17;
        String r7 = r5.optString("feedbackAction");     // Catch: Throwable -> L21
        if (r7 == null) goto L17;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
        r6 = r7;
    L17:
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L21
        r11.put(r4, new C0305a(r4, r6));     // Catch: Throwable -> L21
        goto L9
    L18:
        Map<String, C0305a> r12 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        monitor-exit(this);
        return r12;
    L21:
        th = move-exception;
        throw th;
    }

    public final ai<C0305a> a() {
        return e;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(Context r7, String r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r8, "recommendId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L10
        a r2 = f6677a;     // Catch: Throwable -> L10
        JSONObject r3 = r2.a(r10, "pending_adopted_v1");     // Catch: Throwable -> L10
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L10
        r4.put("timestamp", r0);     // Catch: Throwable -> L10
        r4.put("feedbackAction", r9);     // Catch: Throwable -> L10
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r3.put(r8, r4);     // Catch: Throwable -> L10
        r2.a(r3, r0);     // Catch: Throwable -> L10
        r2.a(r10, "pending_adopted_v1", r3);     // Catch: Throwable -> L10
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        f6678b.a(new C0305a(r8, r9));
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a(boolean r2, boolean r3) {
        d.a(new c(r2, r3));
    }

    public final Map<String, b> b(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L21
        a r2 = f6677a;     // Catch: Throwable -> L21
        JSONObject r3 = r2.a(r9, "pending_dismissed_v1");     // Catch: Throwable -> L21
        if (r2.a(r3, r0) == false) goto L7;
        r2.a(r9, "pending_dismissed_v1", r3);     // Catch: Throwable -> L21
    L7:
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L21
        Iterator<String> r1 = r3.keys();     // Catch: Throwable -> L21
    L9:
        if (r1.hasNext() == false) goto L18;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        JSONObject r5 = r3.optJSONObject(r4);     // Catch: Throwable -> L21
        String r6 = null;
        if (r5 == null) goto L17;
        String r7 = r5.optString(InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L21
        if (r7 == null) goto L17;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
        r6 = r7;
    L17:
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L21
        r11.put(r4, new b(r4, r6));     // Catch: Throwable -> L21
        goto L9
    L18:
        Map<String, b> r12 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        monitor-exit(this);
        return r12;
    L21:
        th = move-exception;
        throw th;
    }

    public final ai<b> b() {
        return f;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(Context r7, String r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r8, "recommendId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L10
        a r2 = f6677a;     // Catch: Throwable -> L10
        JSONObject r3 = r2.a(r10, "pending_dismissed_v1");     // Catch: Throwable -> L10
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L10
        r4.put("timestamp", r0);     // Catch: Throwable -> L10
        r4.put(InfoRequestQPSOptTraceLogger.REASON, r9);     // Catch: Throwable -> L10
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r3.put(r8, r4);     // Catch: Throwable -> L10
        r2.a(r3, r0);     // Catch: Throwable -> L10
        r2.a(r10, "pending_dismissed_v1", r3);     // Catch: Throwable -> L10
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        c.a(new b(r8, r9));
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
