package com.obric.memorydata.middleware.impl.abtest;

import com.bytedance.ies.abmock.f;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0000H\u0007R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/impl/abtest/ExperimentBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IExperimentBridgeAPI;", "<init>", "()V", "getBooleanValue", "", "key", "", "defaultValue", "scope", "getIntValue", "", "getLongValue", "", "getDoubleValue", "", "getStringValue", "getJsonObjectValue", "prepareScope", "", "getInst", "SCOPE_DID", "SCOPE_UID", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExperimentBridgeAPIImpl implements IExperimentBridgeAPI {
    public static final ExperimentBridgeAPIImpl INSTANCE = null;
    private static final String SCOPE_DID = "did";
    private static final String SCOPE_UID = "uid";

    static {
        INSTANCE = new ExperimentBridgeAPIImpl();
    }

    private ExperimentBridgeAPIImpl() {
    }

    @JvmStatic
    public static final ExperimentBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private final void prepareScope(String r1, String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, SCOPE_DID) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r2, "uid") == false) goto L9;
        com.bytedance.ies.abmock.datacenter.precise.c.f2698a.d(r1);
        return;
    L9:
        throw new IllegalArgumentException("Unsupported experiment scope");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public boolean getBooleanValue(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        prepareScope(r2, r4);
        return f.f2742a.a(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public double getDoubleValue(String r2, double r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        prepareScope(r2, r5);
        return f.f2742a.a(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public int getIntValue(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        prepareScope(r2, r4);
        return f.f2742a.a(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public String getJsonObjectValue(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        JsonObject r5 = JsonParser.parseString(r3).getAsJsonObject();
        prepareScope(r2, r4);
        f r1 = f.f2742a;
        Intrinsics.checkNotNull(r5);
        String r6 = r1.a(r2, r5).toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public long getLongValue(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        prepareScope(r2, r5);
        return f.f2742a.a(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IExperimentBridgeAPI
    public String getStringValue(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        prepareScope(r2, r4);
        return f.f2742a.a(r2, r3);
    }
}
