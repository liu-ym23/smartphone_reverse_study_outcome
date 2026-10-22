package com.obric.memorydata.memory.inapprule;

import android.database.SQLException;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.bridge.IInAppRuleBridgeAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/inapprule/InAppRuleBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IInAppRuleBridgeAPI;", "<init>", "()V", "getInst", "getSnapshot", "", Ext.KEY_REQUEST, "applyDelta", "respond", "raw", "action", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "failure", "code", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppRuleBridgeAPIImpl implements IInAppRuleBridgeAPI {
    public static final InAppRuleBridgeAPIImpl INSTANCE = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.inapprule.InAppRuleBridgeAPIImpl$applyDelta$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<JSONObject, JSONObject> {
        AnonymousClass1(Object r8) {
            super(1, r8, c.class, "apply", "apply(Lorg/json/JSONObject;)Lorg/json/JSONObject;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ JSONObject invoke(JSONObject r3) {
            return invoke2((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final JSONObject invoke2(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            return ((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.memorydata.plugin")).b(r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.inapprule.InAppRuleBridgeAPIImpl$getSnapshot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C11051 extends FunctionReferenceImpl implements Function1<JSONObject, JSONObject> {
        C11051(Object r8) {
            super(1, r8, c.class, "snapshot", "snapshot(Lorg/json/JSONObject;)Lorg/json/JSONObject;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ JSONObject invoke(JSONObject r3) {
            return invoke2((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final JSONObject invoke2(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            return ((c) ZeusTransformUtils.preCheckCast(this.receiver, c.class, "com.obric.memorydata.plugin")).a(r3);
        }
    }

    static {
        INSTANCE = new InAppRuleBridgeAPIImpl();
    }

    private InAppRuleBridgeAPIImpl() {
    }

    private final String failure(String r2) {
        String r1 = new JSONObject().put("code", r2).toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }

    @JvmStatic
    public static final InAppRuleBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private final String respond(String r6, Function1<? super JSONObject, ? extends JSONObject> r7) {
        String r1 = "INVALID_CATALOG";
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        byte[] r2 = r6.getBytes(Charsets.UTF_8);     // Catch: SQLException -> L11 IllegalArgumentException -> L12 JSONException -> L24
        Intrinsics.checkNotNullExpressionValue(r2, "getBytes(...)");     // Catch: SQLException -> L11 IllegalArgumentException -> L12 JSONException -> L24
        if (r2.length > 524288) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
        String r9 = new JSONObject().put("code", "OK").put("data", r8.invoke(new JSONObject(r6))).toString();     // Catch: SQLException -> L11 IllegalArgumentException -> L12 JSONException -> L24
        Intrinsics.checkNotNull(r9);     // Catch: SQLException -> L11 IllegalArgumentException -> L12 JSONException -> L24
        return r9;
    L10:
        throw new IllegalArgumentException("TOO_LARGE".toString());     // Catch: SQLException -> L11 IllegalArgumentException -> L12 JSONException -> L24
    L6:
        r3 = false;
    L12:
        e = move-exception;
        String r10 = e.getMessage();
        if (r10 != null) goto L16;
    L18:
        r10 = null;
    L19:
        if (r10 == null) goto L23;
        r1 = r10;
        goto L23
    L16:
        if (SetsKt.setOf(new String[]{"UNSUPPORTED_SCHEMA", "STALE_RUN", "BASE_CHANGED", "TOO_LARGE"}).contains(r10) == false) goto L18;
    L27:
        return failure("DB_FAILED");
    L23:
        return failure(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInAppRuleBridgeAPI
    public String applyDelta(String r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        return respond(r4, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(c.f10152a), Function1.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IInAppRuleBridgeAPI
    public String getSnapshot(String r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        return respond(r4, (Function1) ZeusTransformUtils.preCheckCast(new C11051(c.f10152a), Function1.class, "com.obric.memorydata.plugin"));
    }
}
