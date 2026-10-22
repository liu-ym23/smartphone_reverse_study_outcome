package com.obric.capability.schedulekit.eca.v3;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.common.execution.eca.ECAAction;
import com.obric.capabilitykit.common.execution.eca.ECAJob;
import com.obric.capabilitykit.common.execution.eca.ECAScript;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0019"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAParserV3;", "Lcom/obric/capabilitykit/common/execution/eca/ECAScript$Parser;", "()V", "ensureJobParseable", "", "jobJson", "Lcom/google/gson/JsonObject;", "failIfJobNotSupported", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAScript$ParseResult;", "Lcom/obric/capability/schedulekit/eca/v3/ECAScriptV3;", "script", "", "parseEcaAction", "Lcom/obric/capability/schedulekit/eca/v3/ECAAppIntentV3;", "actionJson", "parseEcaInternal", "contentJson", "parseEcaJob", "Lcom/obric/capabilitykit/common/execution/eca/ECAJob;", "Companion", "ECAParseMalformedActionError", "ECAParseMalformedJobContentError", "ECAParseMalformedScriptContentError", "ECAParseUnsupportedOperationError", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ECAParserV3 implements ECAScript.Parser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7390a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAParserV3$ECAParseMalformedActionError;", "", "()V", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ECAParseMalformedActionError extends Throwable {
        public ECAParseMalformedActionError() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAParserV3$ECAParseMalformedJobContentError;", "", "()V", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ECAParseMalformedJobContentError extends Throwable {
        public ECAParseMalformedJobContentError() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAParserV3$ECAParseMalformedScriptContentError;", "", "()V", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ECAParseMalformedScriptContentError extends Throwable {
        public ECAParseMalformedScriptContentError() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAParserV3$ECAParseUnsupportedOperationError;", "", "()V", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ECAParseUnsupportedOperationError extends Throwable {
        public ECAParseUnsupportedOperationError() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capability/schedulekit/eca/v3/ECAParserV3$Companion;", "", "()V", "ECA_JSON_TAG__ACTIONS", "", "ECA_JSON_TAG__CONTENT", "ECA_JSON_TAG__EVENTS", "ECA_JSON_TAG__JOBS", "TAG", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7390a = new a(null);
    }

    private final g c(JsonObject r10) {
        if (r10.has("Content") == true) goto L33;
        JsonObject r0 = r10;
    L10:
        if (r0 != null) goto L31;
        com.obric.capability.schedulekit.b.c.f7384a.b("ECAParser-V3", "malformed ECA string; content-root not locatable; check the content.");
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "contentJson=" + r10);
        throw new ECAParseMalformedScriptContentError();
    L31:
        JsonArray r1 = r0.get("jobs").getAsJsonArray();     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L25
        ArrayList r2 = new ArrayList(r1.size());
        int r4 = 0;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r3.hasNext() == false) goto L23;
        Object r6 = r3.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        JsonElement r8 = (JsonElement) ZeusTransformUtils.preCheckCast(r6, JsonElement.class, "com.obric.memorydata.plugin");
        JsonObject r9 = r8.getAsJsonObject();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L21
        r2.add(d(r9));
        r4 = r7;
    L21:
        com.obric.capability.schedulekit.b.c.f7384a.b("ECAParser-V3", "cannot parse job (i=" + r4 + "); not a non-null JsonObject (got: " + r8.getClass() + ')');
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "contentJson=" + r10);
        throw new ECAParseMalformedJobContentError();
    L23:
        g r11 = new g();
        r11.setJobs((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
        return r11;
    L25:
        com.obric.capability.schedulekit.b.c.f7384a.b("ECAParser-V3", "malformed ECA string; expected `jobs` tag but found nothing; check the content.");
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "contentJson=" + r10);
        throw new ECAParseMalformedScriptContentError();
    L33:
        r0 = JsonParserExt.INSTANCE.parseString(r10.get("Content").getAsString()).getAsJsonObject();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "malformed ECA string; `Content` not parsable.", th);
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "contentJson=" + r10);
        throw new ECAParseMalformedScriptContentError();
    }

    private final ECAJob d(JsonObject r10) {
        a(r10);
        b(r10);
        JsonArray r2 = r10.get("actions").getAsJsonArray();     // Catch: Throwable -> L17
        ArrayList r3 = new ArrayList(r2.size());
        Intrinsics.checkNotNullExpressionValue(r2, "actionsArray");
        int r4 = 0;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        JsonElement r8 = (JsonElement) ZeusTransformUtils.preCheckCast(r6, JsonElement.class, "com.obric.memorydata.plugin");
        JsonObject r9 = r8.getAsJsonObject();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L13
        r3.add(e(r9));
        r4 = r7;
    L13:
        com.obric.capability.schedulekit.b.c.f7384a.b("ECAParser-V3", "cannot parse action (i=" + r4 + "); not a non-null JsonObject (got: " + r8.getClass() + ')');
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "jobJson=" + r10);
        throw new ECAParseMalformedJobContentError();
    L15:
        f r11 = new f((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        r11.a((JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.memorydata.plugin"));
        return (ECAJob) ZeusTransformUtils.preCheckCast(r11, ECAJob.class, "com.obric.memorydata.plugin");
    L17:
        th = move-exception;
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "malformed job content: expected array `actions`.", th);
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "jobJson=" + r10);
        throw new ECAParseMalformedJobContentError();
    }

    private final b e(JsonObject r4) {
        b r3 = new b();
        com.obric.capability.schedulekit.eca.v3.a.C0365a r0 = com.obric.capability.schedulekit.eca.v3.a.f7391a.a((ECAAction) ZeusTransformUtils.preCheckCast(r3, ECAAction.class, "com.obric.memorydata.plugin"), r4);
        r3.setActionName(r0.a());
        r3.setEcaId(r0.b());
        r3.setInputParams(r0.c());
        r3.setImpls(r0.d());
        r3.a((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.memorydata.plugin"));
        return r3;
    }

    public void a(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "jobJson");
        if (r4.has("actions") == false) goto L5;
        return;
    L5:
        com.obric.capability.schedulekit.b.c.f7384a.b("ECAParser-V3", "malformed job content: expected `actions`");
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "jobJson=" + r4);
        throw new ECAParseMalformedJobContentError();
    }

    public void b(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jobJson");
        if (r2.has("events") == true) goto L5;
        return;
    L5:
        com.obric.capability.schedulekit.b.c.f7384a.b("ECAParser-V3", "malformed job content: tag `events` is a future feature.");
        throw new ECAParseUnsupportedOperationError();
    }

    @Override // com.obric.capabilitykit.common.execution.eca.ECAScript.Parser
    public ECAScript.ParseResult<g> parse(String r8) {
        Intrinsics.checkNotNullParameter(r8, "script");
        JsonObject r4 = JsonParserExt.INSTANCE.parseString(r8).getAsJsonObject();     // Catch: Throwable -> L5
    L7:
        if (r4 == null) goto L9;
        g r7 = c(r4);     // Catch: Throwable -> L12
    L15:
        return new ECAScript.ParseResult(0, (ECAScript) ZeusTransformUtils.preCheckCast(r7, ECAScript.class, "com.obric.memorydata.plugin"));
    L12:
        th = move-exception;
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "parse error: not-handleable eca parser error.", th);
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "contentJson=" + r8);
        r7 = (g) ZeusTransformUtils.preCheckCast(null, g.class, "com.obric.memorydata.plugin");
        goto L15
    L9:
        return new ECAScript.ParseResult(1, null);
    L5:
        th = move-exception;
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "parse error: syntax error.", th);
        com.obric.capability.schedulekit.b.c.f7384a.a("ECAParser-V3", "contentJson=" + r8);
        r4 = (JsonObject) ZeusTransformUtils.preCheckCast(null, JsonObject.class, "com.obric.memorydata.plugin");
        goto L7
    }
}
