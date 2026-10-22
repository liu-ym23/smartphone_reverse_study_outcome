package com.obric.memorydata.middleware.impl.playground;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.Response;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 %2\u00020\u0001:\u0003%&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ2\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J2\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\nH\u0002J\f\u0010$\u001a\u00020\u0017*\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/AppIntentAdapter;", "", "<init>", "()V", "entityContextLock", "entityContext", "Lcom/obric/memorydata/middleware/impl/playground/AppIntentAdapter$EntityContext;", "dispatchIntent", "Lcom/obric/memorydata/middleware/api/bridge/Response;", "payload", "", "parseDispatchResponse", Ext.KEY_REQUEST, "Lcom/obric/memorydata/middleware/impl/playground/AppIntentAdapter$DispatchRequest;", "sourceIntent", "preparedPayload", "result", "Lcom/obric/memorydata/middleware/impl/playground/DispatchIntentResult;", "entityResolver", "Lcom/obric/memorydata/middleware/impl/playground/EntityResolver;", "parseDispatchRequest", "resolveDispatchFailureMessage", "shouldReturnOuterFailure", "", "parseAppIntentResult", "requestMessageId", "", "currentEntityContext", "resolveEntityPersistence", "Lcom/obric/memorydata/middleware/impl/playground/EntityStorePersistence;", "createEntityContext", "persistence", "normalizeActionResult", "rawActionResult", "shouldRecordDeletedEntities", "actionResultData", "isDeleteSuccessMessage", "Companion", "EntityContext", "DispatchRequest", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0638a f11800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f11801b;
    private volatile c c;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.playground.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/AppIntentAdapter$Companion;", "", "<init>", "()V", "ID", "", "MESSAGE_ID", "RESULT", "QUESTION_ID", "ACTION_RESULT_DATA", "EXT", "RAW_RESULT", "RAW_RESULT_SOURCE", "INTENT_RESULT_EXT", "RET", "DETAILS", "UI_TYPE_TYPED", "SCREENSHOT_BASE64", "CODE", "MSG", "ENTITY_DATA", "SHOULD_NOTIFY", "UI_TYPE", "CODE_SUCCESS", "", "CODE_BAD_REQUEST", "CODE_DISPATCH_ERROR", "CODE_PROTOCOL_ERROR", "INTERACTIVE_UI_TYPE", "TAG", "LOG_CODE_ECA_PREPARE_FAILED", "LOG_CODE_RESULT_PARSE_FAILED", "LOG_CODE_PERSONAL_STORE_RESOLVE_FAILED", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0638a {
        private C0638a() {
        }

        public /* synthetic */ C0638a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/AppIntentAdapter$DispatchRequest;", "", "questionId", "", "messageId", "<init>", "(JJ)V", "getQuestionId", "()J", "getMessageId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f11802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11803b;

        public b(long r1, long r3) {
            this.f11802a = r1;
            this.f11803b = r3;
        }

        public final long a() {
            return this.f11802a;
        }

        public final long b() {
            return this.f11803b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.f11802a == r10.f11802a) goto L12;
            return false;
        L12:
            if (this.f11803b == r10.f11803b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f11802a) * 31) + Long.hashCode(this.f11803b);
        }

        public String toString() {
            return "DispatchRequest(questionId=" + this.f11802a + ", messageId=" + this.f11803b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/AppIntentAdapter$EntityContext;", "", "resolver", "Lcom/obric/memorydata/middleware/impl/playground/EntityResolver;", "<init>", "(Lcom/obric/memorydata/middleware/impl/playground/EntityResolver;)V", "getResolver", "()Lcom/obric/memorydata/middleware/impl/playground/EntityResolver;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.middleware.impl.playground.c f11804a;

        public c(com.obric.memorydata.middleware.impl.playground.c r2) {
            Intrinsics.checkNotNullParameter(r2, "resolver");
            this.f11804a = r2;
        }

        public final com.obric.memorydata.middleware.impl.playground.c a() {
            return this.f11804a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11804a, r6.f11804a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11804a.hashCode();
        }

        public String toString() {
            return "EntityContext(resolver=" + this.f11804a + ')';
        }
    }

    static {
        f11800a = new C0638a(null);
    }

    public a() {
        this.f11801b = new Object();
    }

    private final Response a(long r9, String r11, String r12, com.obric.memorydata.middleware.impl.playground.b r13, com.obric.memorydata.middleware.impl.playground.c r14) {
        String r0 = r13.f();
        boolean r1 = true;
        if (r0 != null) goto L11;
        JSONObject r2 = new JSONObject().put("code", r13.b());
        String r3 = r13.c();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        JSONObject r4 = r2.put(NotificationCompat.CATEGORY_MESSAGE, r3);
        List<JSONObject> r5 = l.a(r13.d());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        r4.put("entity_data", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).toString());
    L10:
        r0 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
    L11:
        String r15 = r14.a(a(r0, r13), r11);
        if (c(r15) == false) goto L14;
        r14.b(r12, r15);
    L14:
        JSONObject r8 = new JSONObject();
        Long r16 = Long.valueOf(r13.g());
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue() == (-1)) goto L17;
        boolean r17 = true;
    L18:
        Long r6 = null;
        if (r17 == true) goto L22;
        r16 = null;
    L22:
        if (r16 == null) goto L24;
        r9 = r16.longValue();
    L24:
        JSONObject r10 = r8.put(OaidModel.KEY_ID, r9);
        Long r18 = Long.valueOf(r13.h());
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L28;
        r1 = false;
    L28:
        if (r1 == false) goto L30;
        r6 = r18;
    L30:
        if (r6 == null) goto L32;
        long r19 = r6.longValue();
    L33:
        JSONObject r20 = r10.put("question_id", r19).put("action_result_data", r15).put("ext", r13.i());
        if (r13.q() != AppIntentResultMode.MOBILE_USE_CALLBACK) goto L51;
        JSONObject r21 = r20.put("intent_result_ext", r13.m()).put("ret", r13.b());
        Object r110 = r13.c();
        if (r110 != null) goto L38;
        r110 = JSONObject.NULL;
    L38:
        JSONObject r22 = r21.put("details", r110).put("ui_type", r13.n());
        Object r111 = r13.o();
        if (r111 != null) goto L41;
        r111 = JSONObject.NULL;
    L41:
        r22.put("screenshot_base64", r111);
        if (r13.k() == false) goto L54;
        Object r23 = r13.j();
        if (r23 != null) goto L46;
        r23 = JSONObject.NULL;
    L46:
        r20.put("raw_result", r23);
        Object r24 = r13.l();
        if (r24 != null) goto L49;
        r24 = JSONObject.NULL;
    L49:
        r20.put("raw_result_source", r24);
    L54:
        return new Response(0, "success", new JSONObject().put("result", r20), null, 8, null);
    L51:
        if (r13.o() == null) goto L54;
        r20.put("screenshot_base64", r13.o());
        goto L54
    L32:
        r19 = r13.a();
        goto L33
    L17:
        r17 = false;
        goto L18
    }

    private final Response a(b r14, String r15, String r16, com.obric.memorydata.middleware.impl.playground.b r17, com.obric.memorydata.middleware.impl.playground.c r18) {
    L13:
        return a(r14.b(), r15, r16, r17, r18);
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppIntentAdapter", "[code=playground_app_intent_result_parse_failed] app intent result parse failed questionId=" + r14.a() + " error=" + e.getClass().getSimpleName(), null, 4, null);
        return new Response(-3, "intent dispatch failed", null, null, 12, null);
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppIntentAdapter", "[code=playground_app_intent_result_parse_failed] app intent result parse failed questionId=" + r14.a() + " error=" + e.getClass().getSimpleName(), null, 4, null);
        return new Response(-3, "intent dispatch failed", null, null, 12, null);
    }

    private final c a() {
        c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = this.f11801b;
        monitor-enter(r1);
        c r2 = this.c;     // Catch: Throwable -> L12
        if (r2 != null) goto L10;
        r2 = a(b());     // Catch: Throwable -> L12
        this.c = r2;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    private final c a(e r7) {
        return new c(new com.obric.memorydata.middleware.impl.playground.c(new d(0, 0, r7, 3, null)));
    }

    private final String a(com.obric.memorydata.middleware.impl.playground.b r4) {
        String r3 = r4.e();
        String r1 = null;
        if (r3 != null) goto L5;
    L9:
        String r5 = r4.c();
        if (r5 != null) goto L12;
    L14:
        if (r1 != null) goto L17;
        return "intent execution failed";
    L17:
        return r1;
    L12:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L14;
        r1 = r5;
        goto L14
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L9;
        return r3;
    }

    private final String a(String r7, com.obric.memorydata.middleware.impl.playground.b r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(new JSONObject(r7));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r9) == false) goto L10;
        r9 = null;
    L10:
        JSONObject r10 = (JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.memorydata.plugin");
        String r2 = "";
        if (r10 != null) goto L23;
        JSONObject r11 = new JSONObject().put("code", r8.b());
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r12) == false) goto L19;
        String r13 = r8.c();
        if (r13 == null) goto L18;
        r2 = r13;
    L18:
        r12 = r2;
    L19:
        r10 = r11.put(NotificationCompat.CATEGORY_MESSAGE, r12);
    L20:
        String r14 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        return r14;
    L23:
        if (ZeusTransformUtils.instanceOf(r10.opt("code"), Number.class) == true) goto L26;
        r10.put("code", r8.b());
    L26:
        if (r10.has(NotificationCompat.CATEGORY_MESSAGE) == true) goto L28;
    L29:
        String r15 = r8.c();
        if (r15 == null) goto L33;
        r2 = r15;
    L33:
        r10.put(NotificationCompat.CATEGORY_MESSAGE, r2);
        goto L20
    L28:
        if (r10.isNull(NotificationCompat.CATEGORY_MESSAGE) == false) goto L20;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final b b(String r12) {
        Long r11 = null;
        JSONObject r0 = new JSONObject(r12);     // Catch: JSONException -> L33
        Long r13 = Long.valueOf(r0.optLong("question_id", 0));
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L32;
        long r7 = r13.longValue();
        Long r14 = Long.valueOf(r0.optLong("message_id", 0));
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        r14 = null;
    L19:
        if (r14 == null) goto L21;
        long r15 = r14.longValue();
    L31:
        return new b(r7, r15);
    L21:
        Long r16 = Long.valueOf(r0.optLong(OaidModel.KEY_ID, 0));
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L25;
        r5 = false;
    L25:
        if (r5 == false) goto L27;
        r11 = r16;
    L27:
        if (r11 == null) goto L29;
        r15 = r11.longValue();
        goto L31
    L29:
        r15 = r7;
        goto L31
    L15:
        r4 = false;
        goto L16
    L7:
        r3 = false;
    L32:
        return null;
    }

    private final e b() {
        if (StoreManager.INSTANCE.hasInit() == true) goto L5;
        return null;
    L5:
        if (AppContext.INSTANCE.isLogin() == false) goto L36;
        Long r0 = StringsKt.toLongOrNull(AppContext.INSTANCE.getUserId());
        boolean r2 = true;
        if (r0 != null) goto L10;
    L15:
        r2 = false;
    L16:
        if (r2 == true) goto L32;
        return null;
    L32:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r12 = Result.m1421constructorimpl(StoreManager.INSTANCE.getPersonalStore());     // Catch: Throwable -> L20
    L22:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r12);
        if (r3 == null) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppIntentAdapter", "[code=playground_app_intent_personal_store_resolve_failed] personal Store resolve failed errorType=" + r3.getClass().getSimpleName(), null, 4, null);
    L26:
        if (Result.m1427isFailureimpl(r12) == false) goto L28;
        r12 = null;
    L28:
        IStore r13 = (IStore) ZeusTransformUtils.preCheckCast(r12, IStore.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L31;
        return null;
    L31:
        return new e(r13);
    L20:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L10:
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 != true) goto L15;
    L12:
        r5 = false;
        goto L13
    L36:
        return null;
    }

    private final boolean b(com.obric.memorydata.middleware.impl.playground.b r1) {
        if (r1.p() == false) goto L5;
    L10:
        return true;
    L5:
        if (r1.b() != 0) goto L7;
    L9:
        return false;
    L7:
        if (r1.q() == AppIntentResultMode.MOBILE_USE_CALLBACK) goto L9;
        goto L9
    }

    private final boolean c(String r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(new JSONObject(r8));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r9) == false) goto L10;
        r9 = null;
    L10:
        JSONObject r10 = (JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L14;
        return false;
    L14:
        if (r10.optInt("code", -3) == 0) goto L16;
        return false;
    L16:
        String r3 = r10.optString("entity_data");
        String r4 = r10.optString(NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Object r6 = r10.opt("shouldNotify");
        if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == false) goto L21;
        Boolean r7 = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin");
    L19:
        boolean r11 = r7.booleanValue();
    L26:
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L29;
    L40:
        return true;
    L29:
        if (d(r5) == true) goto L40;
        if (r11 == false) goto L35;
        if (r10.optInt("uiType", 0) != 1) goto L35;
        return false;
    L35:
        if (StringsKt.endsWith$default(r5, "?", false, 2, null) == false) goto L37;
        return false;
    L37:
        if (StringsKt.endsWith$default(r5, "？", false, 2, null) == false) goto L39;
        return false;
    L39:
        return true;
    L21:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L25;
        r7 = StringsKt.toBooleanStrictOrNull((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
        if (r7 != null) goto L19;
    L25:
        r11 = false;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final boolean d(String r8) {
        if (StringsKt.equals(r8, "deleted", true) == false) goto L5;
        return true;
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("删除成功", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L7;
        return true;
    L7:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("已", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L12;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("删除", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final Response a(String r17) {
        Intrinsics.checkNotNullParameter(r17, "payload");
        b r2 = b(r17);
        if (r2 == null) goto L5;
        com.obric.memorydata.middleware.impl.playground.c r6 = a().a();
        String r4 = r6.a(r17);     // Catch: JSONException -> L17 EntityResolutionException -> L20 EntityNotFoundException -> L22
        String r1 = i.f11826a.a(r17);
        if (r1 != null) goto L11;
        r1 = i.f11826a.a(r4);
    L11:
        String r3 = r1;
        com.obric.memorydata.middleware.impl.playground.b r5 = m.f11838a.a(r2.a(), r4, r2.b(), i.f11826a.a(r4, r3), i.f11826a.b(r4, r3));
        if (b(r5) == false) goto L16;
        return new Response(r5.b(), a(r5), null, null, 12, null);
    L16:
        return a(r2, r3, r4, r5, r6);
    L17:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppIntentAdapter", "[code=playground_app_intent_eca_prepare_failed] app intent ECA prepare failed questionId=" + r2.a() + " error=" + e.getClass().getSimpleName(), null, 4, null);
        return new Response(-4, "app intent ECA command is invalid", null, null, 12, null);
    L23:
        return new Response(200, "app intent entity does not exist", null, null, 12, null);
    L21:
        return new Response(-4, "app intent ECA command is invalid", null, null, 12, null);
    L5:
        return new Response(-2, "payload must contain a positive question_id", null, null, 12, null);
    }
}
