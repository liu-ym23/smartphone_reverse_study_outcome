package com.obric.capability.schedulekit.eca.v3;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.execution.eca.ECAAction;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAActionParserV3;", "", "()V", "TAG", "", "mInputParamsParser", "Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3;", "parseEcaAction", "Lcom/obric/capability/schedulekit/eca/v3/ECAActionParserV3$EcaActionRecord;", "targetAction", "Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "actionJsonObject", "Lcom/google/gson/JsonObject;", "EcaActionRecord", "Tags", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f7392b = null;

    /* JADX INFO: renamed from: com.obric.capability.schedulekit.eca.v3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010!\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J]\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAActionParserV3$EcaActionRecord;", "", "actionName", "", "actionIdInJob", "actionPackageName", "inputParams", "", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "outputParams", "", "impls", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Collection;Ljava/util/List;)V", "getActionIdInJob", "()Ljava/lang/String;", "getActionName", "getActionPackageName", "getImpls", "()Ljava/util/List;", "getInputParams", "()Ljava/util/Map;", "getOutputParams", "()Ljava/util/Collection;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0365a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7394b;
        private final String c;
        private final Map<String, ECAInputParam> d;
        private final Collection<String> e;
        private final List<String> f;

        public C0365a(String r3, String r4, String r5, Map<String, ECAInputParam> r6, Collection<String> r7, List<String> r8) {
            Map<String, ECAInputParam> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Collection<String> r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
            List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "actionName");
            Intrinsics.checkNotNullParameter(r4, "actionIdInJob");
            Intrinsics.checkNotNullParameter(r5, "actionPackageName");
            Intrinsics.checkNotNullParameter(r9, "inputParams");
            Intrinsics.checkNotNullParameter(r10, "outputParams");
            Intrinsics.checkNotNullParameter(r11, "impls");
            this.f7393a = r3;
            this.f7394b = r4;
            this.c = r5;
            this.d = r9;
            this.e = r10;
            this.f = r11;
        }

        public final String a() {
            return this.f7393a;
        }

        public final String b() {
            return this.f7394b;
        }

        public final Map<String, ECAInputParam> c() {
            return this.d;
        }

        public final List<String> d() {
            return this.f;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0365a.class) == true) goto L8;
            return false;
        L8:
            C0365a r6 = (C0365a) ZeusTransformUtils.preCheckCast(r5, C0365a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f7393a, r6.f7393a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f7394b, r6.f7394b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((this.f7393a.hashCode() * 31) + this.f7394b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "EcaActionRecord(actionName=" + this.f7393a + ", actionIdInJob=" + this.f7394b + ", actionPackageName=" + this.c + ", inputParams=" + this.d + ", outputParams=" + this.e + ", impls=" + this.f + ')';
        }
    }

    static {
        f7391a = new a();
        f7392b = new e();
    }

    private a() {
    }

    public final C0365a a(ECAAction r13, JsonObject r14) {
        String r12 = "";
        ECAAction r15 = (ECAAction) ZeusTransformUtils.wrapperContextForParams(r13, ECAAction.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "targetAction");
        Intrinsics.checkNotNullParameter(r14, "actionJsonObject");
        String r5 = r14.get("actionName").getAsString();     // Catch: Exception -> L42
        Intrinsics.checkNotNullExpressionValue(r5, "actionName");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L44;
        com.obric.capability.schedulekit.b.c.f7384a.b("ActionParser/V3", "expected non-blank `actionName` but no one found.");
        throw new ECAParserV3.ECAParseMalformedActionError();
    L44:
        String r6 = r14.get(OaidModel.KEY_ID).getAsString();     // Catch: Exception -> L8
    L10:
        if (r14.has(ObricMemoryConstants.KEY_PACKAGE_NAME) == true) goto L50;
    L15:
        String r7 = r12;
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r14.has("inputParams") == false) goto L26;
        JsonObject r16 = r14.get("inputParams").getAsJsonObject();
        Iterator<String> r2 = r16.keySet().iterator();
    L19:
        if (r2.hasNext() == false) goto L26;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        JsonObject r9 = r16.get(r4).getAsJsonObject();     // Catch: Exception -> L25
        if (r9.has(EventBody.KEY_VALUE) == false) goto L19;
        JsonElement r10 = r9.get(EventBody.KEY_VALUE);
        e r11 = f7392b;
        Intrinsics.checkNotNullExpressionValue(r4, "key");
        Intrinsics.checkNotNullExpressionValue(r10, "valueWant");
        ECAInputParam r17 = r11.a(r4, r10);
        r17.setParent(r15);
        r8.put(r4, r17);
    L25:
        com.obric.capability.schedulekit.b.c.f7384a.b("ActionParser/V3", "skipping inputParams (key: `" + r4 + "`) which is not formatted as a JSONObject: " + r16.get(r4));
    L26:
        JsonElement r18 = r14.get("outputParams");
        if (r18.isJsonNull() == false) goto L29;
        Set<String> r19 = SetsKt.emptySet();
    L30:
        List r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r14.has("impls") == false) goto L38;
        Iterator<JsonElement> r111 = r14.get("impls").getAsJsonArray().iterator();
    L34:
        if (r111.hasNext() == false) goto L38;
        JsonObject r112 = ((JsonElement) ZeusTransformUtils.preCheckCast(r111.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsJsonObject();
        if (r112.has("pkgName") == false) goto L34;
        String r113 = r112.get("pkgName").getAsString();
        Intrinsics.checkNotNullExpressionValue(r113, "pkgName");
        r110.add(r113);
    L38:
        Intrinsics.checkNotNullExpressionValue(r6, "actionId");
        Intrinsics.checkNotNullExpressionValue(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullExpressionValue(r19, "outputParamsRecord");
        return new C0365a(r5, r6, r7, r8, (Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin"), r110);
    L29:
        r19 = r18.getAsJsonObject().keySet();
        goto L30
    L50:
        r12 = r14.get(ObricMemoryConstants.KEY_PACKAGE_NAME).getAsString();     // Catch: Exception -> L13
    L13:
        com.obric.capability.schedulekit.b.c.f7384a.b("ActionParser/V3", "packageName not parsable in actionJsonObject");
        throw new ECAParserV3.ECAParseMalformedActionError();
    L8:
        r6 = "";
    L42:
        com.obric.capability.schedulekit.b.c.f7384a.b("ActionParser/V3", "expected parsable `actionName` but no one found.");
        throw new ECAParserV3.ECAParseMalformedActionError();
    }
}
