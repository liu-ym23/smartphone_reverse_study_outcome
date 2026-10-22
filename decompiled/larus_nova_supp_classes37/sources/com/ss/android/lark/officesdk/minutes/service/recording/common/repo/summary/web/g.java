package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmSummaryWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public g(MmSummaryWebHelper r1) {
        this.a = r1;
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
    @Override // xwb.f
    public final void a(Object r18, xwb.d r19, String r20, OfficeWebView r21) {
        String r0 = (String) r18;
        Intrinsics.checkNotNullParameter(r19, "callback");
        MmSummaryWebHelper r3 = this.a;
        r3.getClass();
        if (r0 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.d r8 = null;
        Object r9 = null;
        if (r6 == false) goto L47;
    L38:
        lvb.a.a(this.a.d, "[common_mark_fish_bone] payload=" + r8);
        if (r8 != null) goto L42;
        r19.a(Status.FAILURE, "");
        return;
    L42:
        if (this.a.b.e(r8) == false) goto L44;
        Status r1 = Status.SUCCESS;
    L45:
        r19.a(r1, "");
        return;
    L44:
        r1 = Status.FAILURE;
        goto L45
    L47:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L28
        JSONObject r10 = new JSONObject(r0);     // Catch: Throwable -> L28
        String r11 = r10.optString("action", "");     // Catch: Throwable -> L28
        int r12 = r10.optInt("type", 0);     // Catch: Throwable -> L28
        String r13 = r10.optString("id", "");     // Catch: Throwable -> L28
        long r14 = r10.optLong("timestamp", 0);     // Catch: Throwable -> L28
        String r2 = r10.optString("image");     // Catch: Throwable -> L28
        if ((!StringsKt.isBlank(r2)) == true) goto L16;
        r2 = null;
    L16:
        if (r2 != null) goto L21;
        r2 = r10.optString("chart");     // Catch: Throwable -> L28
        if ((!StringsKt.isBlank(r2)) == true) goto L21;
        String r15 = null;
    L22:
        String r4 = r10.optString("text");     // Catch: Throwable -> L28
        if ((true ^ StringsKt.isBlank(r4)) == false) goto L25;
        String r16 = r4;
    L26:
        Object r5 = Result.constructor-impl(new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.d(r11, r12, r13, r14, r15, r16));     // Catch: Throwable -> L28
    L30:
        Throwable r17 = Result.exceptionOrNull-impl(r5);
        if (r17 == null) goto L34;
        lvb.a.b(r3.d, "[parseFishBoneMarkPayload] failed: " + r17);
    L34:
        if (Result.isFailure-impl(r5) == true) goto L37;
        r9 = r5;
    L37:
        r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.d) r9;
        goto L38
    L25:
        r16 = null;
    L21:
        r15 = r2;
    L28:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r6 = false;
        goto L9
    }
}
