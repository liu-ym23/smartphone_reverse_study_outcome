package com.obric.capability.schedulekit.eca.v3;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.common.execution.eca.ECAAction;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import com.obric.capabilitykit.common.execution.eca.ECAModifiable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0001H\u0016J\u000e\u0010)\u001a\u0004\u0018\u00010\u001b*\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAAppIntentV3;", "Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "Lcom/obric/capability/schedulekit/eca/json/JsonBasedECAScriptPiece;", "()V", "actionName", "", "getActionName", "()Ljava/lang/String;", "setActionName", "(Ljava/lang/String;)V", "ecaId", "getEcaId", "setEcaId", "impls", "", "getImpls", "()Ljava/util/List;", "setImpls", "(Ljava/util/List;)V", "inputParams", "", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "getInputParams", "()Ljava/util/Map;", "setInputParams", "(Ljava/util/Map;)V", "mJson", "Lcom/google/gson/JsonElement;", "getMJson", "()Lcom/google/gson/JsonElement;", "setMJson", "(Lcom/google/gson/JsonElement;)V", "commit", "", "commitJson", "forced", "", "ensureJson", "getJson", "mergeWith", "withAnother", "toJson", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements ECAAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ECAInputParam> f7395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f7396b;
    private String c;
    private String d;
    private JsonElement e;

    public b() {
        this.c = "";
        this.d = "";
    }

    private final JsonElement a(ECAInputParam r2) {
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L6;
        return ((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin")).b();
    L6:
        return (JsonElement) ZeusTransformUtils.preCheckCast(null, JsonElement.class, "com.obric.memorydata.plugin");
    }

    private final void a(boolean r11) {
        JsonElement r0 = a();
        if (r0 != null) goto L5;
        r0 = (JsonElement) ZeusTransformUtils.preCheckCast(new JsonObject(), JsonElement.class, "com.obric.memorydata.plugin");
    L5:
        JsonObject r1 = (JsonObject) ZeusTransformUtils.preCheckCast(r0, JsonObject.class, "com.obric.memorydata.plugin");
        r1.addProperty("actionName", getActionName());
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(getEcaId(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        r1.addProperty(OaidModel.KEY_ID, getEcaId());
    L8:
        JsonElement r3 = r1.get("inputParams");
        JsonObject r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, JsonObject.class) == false) goto L11;
        JsonObject r4 = (JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.memorydata.plugin");
    L12:
        if (r4 != null) goto L14;
        r4 = new JsonObject();
    L14:
        Iterator<Map.Entry<String, ECAInputParam>> r6 = getInputParams().entrySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ECAInputParam r8 = (ECAInputParam) ZeusTransformUtils.preCheckCast(r7.getValue(), ECAInputParam.class, "com.obric.memorydata.plugin");
        if (r11 == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r8, ECAModifiable.class) == false) goto L24;
        if (((ECAModifiable) ZeusTransformUtils.preCheckCast(r8, ECAModifiable.class, "com.obric.memorydata.plugin")).isDirty() == false) goto L16;
    L24:
        JsonElement r9 = a(r8);
        JsonObject r10 = new JsonObject();
        r10.add(EventBody.KEY_VALUE, r9);
        r4.add((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.memorydata.plugin"));
        goto L16
    L25:
        r1.add("inputParams", (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.memorydata.plugin"));
        JsonElement r2 = r1.get("outputParams");
        if (ZeusTransformUtils.instanceOf(r2, JsonObject.class) == false) goto L28;
        r5 = (JsonObject) ZeusTransformUtils.preCheckCast(r2, JsonObject.class, "com.obric.memorydata.plugin");
    L28:
        if (r5 != null) goto L30;
        r5 = new JsonObject();
    L30:
        r1.add("outputParams", (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.memorydata.plugin"));
        JsonArray r12 = new JsonArray();
        Iterator<String> r13 = getImpls().iterator();
    L32:
        if (r13.hasNext() == false) goto L34;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        JsonObject r15 = new JsonObject();
        r15.addProperty("pkgName", r14);
        r12.add((JsonElement) ZeusTransformUtils.preCheckCast(r15, JsonElement.class, "com.obric.memorydata.plugin"));
        goto L32
    L34:
        r1.add("impls", (JsonElement) ZeusTransformUtils.preCheckCast(r12, JsonElement.class, "com.obric.memorydata.plugin"));
        a((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r4 = null;
        goto L12
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
        return this.e;
    }

    public void a(JsonElement r1) {
        this.e = r1;
    }

    public JsonElement b() {
        return c();
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public void commit() {
        a(false);
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public String getActionName() {
        return this.c;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public String getEcaId() {
        return this.d;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public List<String> getImpls() {
        List<String> r0 = this.f7396b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("impls");
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public Map<String, ECAInputParam> getInputParams() {
        Map<String, ECAInputParam> r0 = this.f7395a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("inputParams");
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public boolean isDirty() {
        return ECAAction.DefaultImpls.isDirty(this);
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public void mergeWith(ECAAction r3) {
        ECAAction r4 = (ECAAction) ZeusTransformUtils.wrapperContextForParams(r3, ECAAction.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "withAnother");
        ECAAction.DefaultImpls.mergeWith(this, r4);
        a(true);
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public void setActionName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public void setEcaId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public void setImpls(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f7396b = r4;
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAAction
    public void setInputParams(Map<String, ECAInputParam> r3) {
        Map<String, ECAInputParam> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f7395a = r4;
    }
}
