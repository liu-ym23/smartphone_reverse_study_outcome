package com.obric.memorydata.database.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class SemanticMigrationTracker$resetTestOverrides$2 extends FunctionReferenceImpl implements Function4<String, Boolean, String, JSONObject, Unit> {
    SemanticMigrationTracker$resetTestOverrides$2(Object r8) {
        super(4, r8, t.class, "reportTrace", "reportTrace(Ljava/lang/String;ZLjava/lang/String;Lorg/json/JSONObject;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* synthetic */ Unit invoke(String r3, Boolean r4, String r5, JSONObject r6) {
        invoke((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public final void invoke(String r3, boolean r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r5, "p2");
        Intrinsics.checkNotNullParameter(r6, "p3");
        t.a((t) ZeusTransformUtils.preCheckCast(this.receiver, t.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
    }
}
