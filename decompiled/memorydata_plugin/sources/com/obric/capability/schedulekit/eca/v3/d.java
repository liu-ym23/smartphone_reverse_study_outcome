package com.obric.capability.schedulekit.eca.v3;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.obric.capabilitykit.common.execution.eca.ECAAction;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import com.obric.capabilitykit.common.execution.eca.ECAModifiable;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamDependency;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamPrimitive;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamRawJson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0001H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\t*\u00020\u0017H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\t*\u00020\u0018H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamWrapperV3;", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "Lcom/obric/capabilitykit/common/execution/eca/ECAModifiable;", "Lcom/obric/capability/schedulekit/eca/json/JsonBasedECAScriptPiece;", "original", "(Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;)V", "mDirty", "", "mJson", "Lcom/google/gson/JsonElement;", "getMJson", "()Lcom/google/gson/JsonElement;", "setMJson", "(Lcom/google/gson/JsonElement;)V", "commit", "", "ensureJson", "getJson", "getName", "", "getValue", "isDirty", "toJsonV3", "Lcom/obric/capabilitykit/common/execution/eca/inputparam/ECAInputParamDependency;", "Lcom/obric/capabilitykit/common/execution/eca/inputparam/ECAInputParamPrimitive;", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d extends ECAInputParam implements ECAModifiable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ECAInputParam f7399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7400b;
    private JsonElement c;

    public d(ECAInputParam r2) {
        Intrinsics.checkNotNullParameter(r2, "original");
        this.f7399a = r2;
    }

    private final JsonElement a(ECAInputParamDependency r6) {
        String r5 = ".outputParams." + r6.getDependedParamName();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getTargetEcaId(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        StringBuilder r3 = new StringBuilder().append("$id_");
        String r7 = r6.getTargetEcaId();
    L20:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r3.append(r7).append(r5).toString()), JsonElement.class, "com.obric.memorydata.plugin");
    L12:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getTargetActionName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L15;
    L16:
        r1 = true;
    L17:
        if (r1 == true) goto L21;
        r3 = new StringBuilder().append(Typography.dollar);
        r7 = r6.getTargetActionName();
        goto L20
    L21:
        return null;
    L15:
        if (StringsKt.isBlank(r4) == false) goto L17;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final JsonElement a(ECAInputParamPrimitive r3) {
        Object r2 = r3.getValue();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        Object r4 = r3.getValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.String");
        JsonPrimitive r5 = new JsonPrimitive((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    L13:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L10;
        Object r6 = r3.getValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Number");
        r5 = new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin"));
        goto L13
    L10:
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L12;
        Object r7 = r3.getValue();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Boolean");
        r5 = new JsonPrimitive((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin"));
        goto L13
    L12:
        r5 = null;
        goto L13
    }

    private final JsonElement c() {
        JsonElement r0 = a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        commit();
        JsonElement r1 = a();
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public JsonElement a() {
        return this.c;
    }

    public void a(JsonElement r1) {
        this.c = r1;
    }

    public JsonElement b() {
        return c();
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public void commit() {
        ECAInputParam r0 = this.f7399a;
        if (ZeusTransformUtils.instanceOf(r0, ECAInputParamPrimitive.class) == false) goto L6;
        JsonElement r1 = a((ECAInputParamPrimitive) ZeusTransformUtils.preCheckCast(this.f7399a, ECAInputParamPrimitive.class, "com.obric.memorydata.plugin"));
    L12:
        a(r1);
        this.f7400b = true;
        ECAAction r2 = getParent();
        if (r2 == null) goto L15;
        r2.commit();
    L15:
        this.f7400b = false;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ECAInputParamRawJson.class) == false) goto L9;
        r1 = ((ECAInputParamRawJson) ZeusTransformUtils.preCheckCast(this.f7399a, ECAInputParamRawJson.class, "com.obric.memorydata.plugin")).getRawJson();
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(r0, ECAInputParamDependency.class) == false) goto L11;
        r1 = a((ECAInputParamDependency) ZeusTransformUtils.preCheckCast(this.f7399a, ECAInputParamDependency.class, "com.obric.memorydata.plugin"));
        goto L12
    L11:
        r1 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.memorydata.plugin");
        goto L12
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAInputParam
    public String getName() {
        return this.f7399a.getParamName();
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAInputParam
    public ECAInputParam getValue() {
        return this.f7399a;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public boolean isDirty() {
        return this.f7400b;
    }
}
