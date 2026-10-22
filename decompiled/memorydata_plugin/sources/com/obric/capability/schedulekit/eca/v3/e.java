package com.obric.capability.schedulekit.eca.v3;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamDependency;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamPrimitive;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamRawJson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3;", "", "()V", "mParsers", "", "Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IInputParamParser;", "resolveRawInputParam", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "paramName", "", "paramValueRaw", "Lcom/google/gson/JsonElement;", "ActionIDBasedPDP", "ActionNameBasedPDP", "AppEntityIDPDP", "Companion", "DefaultPDP", "IInputParamParser", "IStringBasedParamParser", "Tags", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<f> f7402b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$ActionIDBasedPDP;", "Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IStringBasedParamParser;", "(Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3;)V", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "paramName", "", "descriptor", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f7403a;

        public a(e r1) {
            this.f7403a = r1;
        }

        @Override // com.obric.capability.schedulekit.eca.v3.e.f
        public ECAInputParam a(String r1, Object r2) {
            return g.a.a(this, r1, r2);
        }

        @Override // com.obric.capability.schedulekit.eca.v3.e.g
        public ECAInputParam a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "paramName");
            Intrinsics.checkNotNullParameter(r11, "descriptor");
            if (StringsKt.startsWith$default(r11, "$id_", false, 2, null) == true) goto L5;
            return null;
        L5:
            List r1 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null);
            if (r1.size() == 3) goto L8;
            com.obric.capability.schedulekit.b.c.f7384a.b("ECAInputParamParser/V3", "[ID-Dependency] expected descriptor to be as `$id_[ecaId].outputParams.[value]`, got `" + r11 + "`.");
            throw new ECAParserV3.ECAParseMalformedActionError();
        L8:
            return (ECAInputParam) ZeusTransformUtils.preCheckCast(new ECAInputParamDependency(StringsKt.removePrefix((String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("$id_", CharSequence.class, "com.obric.memorydata.plugin")), null, (String) ZeusTransformUtils.preCheckCast(r1.get(2), String.class, "com.obric.memorydata.plugin"), 2, null), ECAInputParam.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$ActionNameBasedPDP;", "Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IStringBasedParamParser;", "(Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3;)V", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "paramName", "", "descriptor", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f7404a;

        public b(e r1) {
            this.f7404a = r1;
        }

        @Override // com.obric.capability.schedulekit.eca.v3.e.f
        public ECAInputParam a(String r1, Object r2) {
            return g.a.a(this, r1, r2);
        }

        @Override // com.obric.capability.schedulekit.eca.v3.e.g
        public ECAInputParam a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "paramName");
            Intrinsics.checkNotNullParameter(r11, "descriptor");
            if (StringsKt.startsWith$default(r11, "$", false, 2, null) == true) goto L5;
            return null;
        L5:
            List r1 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null);
            if (r1.size() == 3) goto L8;
            com.obric.capability.schedulekit.b.c.f7384a.b("ECAInputParamParser/V3", "[ActionName-Dependency] expected descriptor to be as `$[name].outputParams.[value]`, got `" + r11 + "`.");
            throw new ECAParserV3.ECAParseMalformedActionError();
        L8:
            return (ECAInputParam) ZeusTransformUtils.preCheckCast(new ECAInputParamDependency(null, StringsKt.removePrefix((String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("$", CharSequence.class, "com.obric.memorydata.plugin")), (String) ZeusTransformUtils.preCheckCast(r1.get(2), String.class, "com.obric.memorydata.plugin"), 1, null), ECAInputParam.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$AppEntityIDPDP;", "Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IStringBasedParamParser;", "(Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3;)V", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "paramName", "", "descriptor", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f7405a;

        public c(e r1) {
            this.f7405a = r1;
        }

        @Override // com.obric.capability.schedulekit.eca.v3.e.f
        public ECAInputParam a(String r1, Object r2) {
            return g.a.a(this, r1, r2);
        }

        @Override // com.obric.capability.schedulekit.eca.v3.e.g
        public ECAInputParam a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "paramName");
            Intrinsics.checkNotNullParameter(r4, "descriptor");
            if (StringsKt.startsWith$default(r4, "$E_", false, 2, null) == true) goto L6;
            return null;
        L6:
            return (ECAInputParam) ZeusTransformUtils.preCheckCast(new ECAInputParamRawJson((JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r4), JsonElement.class, "com.obric.memorydata.plugin")), ECAInputParam.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$Companion;", "", "()V", "TAG", "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.capability.schedulekit.eca.v3.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$DefaultPDP;", "Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IInputParamParser;", "(Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3;)V", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "paramName", "", "paramValueRaw", "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class C0366e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f7406a;

        public C0366e(e r1) {
            this.f7406a = r1;
        }

        @Override // com.obric.capability.schedulekit.eca.v3.e.f
        public ECAInputParam a(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "paramName");
            Intrinsics.checkNotNullParameter(r3, "paramValueRaw");
            if (ZeusTransformUtils.instanceOf(r3, JsonNull.class) == false) goto L8;
            Object r1 = new ECAInputParamPrimitive(null);
        L6:
            return (ECAInputParam) ZeusTransformUtils.preCheckCast(r1, ECAInputParam.class, "com.obric.memorydata.plugin");
        L8:
            if (ZeusTransformUtils.instanceOf(r3, JsonObject.class) == false) goto L10;
        L24:
            r1 = new ECAInputParamRawJson((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.memorydata.plugin"));
            goto L6
        L10:
            if (ZeusTransformUtils.instanceOf(r3, JsonArray.class) == true) goto L24;
            if (ZeusTransformUtils.instanceOf(r3, JsonPrimitive.class) == true) goto L15;
        L23:
            return null;
        L15:
            if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r3, JsonPrimitive.class, "com.obric.memorydata.plugin")).isString() == false) goto L18;
            r1 = new ECAInputParamPrimitive(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r3, JsonPrimitive.class, "com.obric.memorydata.plugin")).getAsString());
            goto L6
        L18:
            if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r3, JsonPrimitive.class, "com.obric.memorydata.plugin")).isNumber() == false) goto L21;
            r1 = new ECAInputParamPrimitive(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r3, JsonPrimitive.class, "com.obric.memorydata.plugin")).getAsNumber());
            goto L6
        L21:
            if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r3, JsonPrimitive.class, "com.obric.memorydata.plugin")).isBoolean() == false) goto L23;
            r1 = new ECAInputParamPrimitive(Boolean.valueOf(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r3, JsonPrimitive.class, "com.obric.memorydata.plugin")).getAsBoolean()));
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IInputParamParser;", "", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "paramName", "", "paramValueRaw", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private interface f {
        ECAInputParam a(String r1, Object r2);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IStringBasedParamParser;", "Lcom/obric/capability/schedulekit/eca/v3/ECAInputParamsParserV3$IInputParamParser;", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "paramName", "", "paramValueRaw", "", "descriptor", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private interface g extends f {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a {
            public static ECAInputParam a(g r2, String r3, Object r4) {
                g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "paramName");
                Intrinsics.checkNotNullParameter(r4, "paramValueRaw");
                if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L8;
                String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
            L6:
                return r5.a(r3, r6);
            L8:
                if (ZeusTransformUtils.instanceOf(r4, JsonPrimitive.class) == true) goto L10;
                return null;
            L10:
                if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r4, JsonPrimitive.class, "com.obric.memorydata.plugin")).isString() == false) goto L14;
                r6 = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r4, JsonPrimitive.class, "com.obric.memorydata.plugin")).getAsString();
                Intrinsics.checkNotNullExpressionValue(r6, "paramValueRaw.asString");
                goto L6
            L14:
                return null;
            }
        }

        ECAInputParam a(String r1, String r2);
    }

    static {
        f7401a = new d(null);
    }

    public e() {
        this.f7402b = CollectionsKt.listOf(new f[]{(f) ZeusTransformUtils.preCheckCast(new c(this), f.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.preCheckCast(new a(this), f.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.preCheckCast(new b(this), f.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.preCheckCast(new C0366e(this), f.class, "com.obric.memorydata.plugin")});
    }

    public final ECAInputParam a(String r4, JsonElement r5) {
        Intrinsics.checkNotNullParameter(r4, "paramName");
        Intrinsics.checkNotNullParameter(r5, "paramValueRaw");
        Iterator<f> r3 = this.f7402b.iterator();
        ECAInputParam r0 = null;
    L4:
        if (r3.hasNext() == false) goto L7;
        r0 = ((f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.memorydata.plugin")).a(r4, r5);
        if (r0 == null) goto L4;
    L7:
        if (r0 == null) goto L10;
        r0.setParamName(r4);
        com.obric.capability.schedulekit.eca.v3.d r6 = new com.obric.capability.schedulekit.eca.v3.d(r0);
        r6.a(r5);
        return (ECAInputParam) ZeusTransformUtils.preCheckCast(r6, ECAInputParam.class, "com.obric.memorydata.plugin");
    L10:
        com.obric.capability.schedulekit.b.c.f7384a.b("ECAInputParamParser/V3", "[resolveRawInputParam] not supported inputParam; key=`" + r4 + "`, value=" + r5 + '.');
        throw new ECAParserV3.ECAParseMalformedActionError();
    }
}
