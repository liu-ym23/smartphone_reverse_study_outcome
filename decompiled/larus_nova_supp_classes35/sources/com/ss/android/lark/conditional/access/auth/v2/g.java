package com.ss.android.lark.conditional.access.auth.v2;

import com.bytedance.lark.policy.model.ResponseType;
import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.InteractionType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final Map<String, Integer> a = null;

    static {
        Pair[] r0 = new Pair[8];
        if (w4c.c.a().n() == false) goto L5;
        int r1 = 0;
    L6:
        r0[0] = TuplesKt.to("ACCESS_CONTROL_ACTION_COMMON", Integer.valueOf(r1));
        r0[1] = TuplesKt.to("TT_BLOCK", 1000);
        r0[2] = TuplesKt.to("FILE_BLOCK_COMMON", 800);
        r0[3] = TuplesKt.to("DLP_CONTENT_SENSITIVE", 600);
        r0[4] = TuplesKt.to("DLP_CONTENT_DETECTING", Integer.valueOf(DocErrorCode.ERRCODE_NOT_RENDER));
        r0[5] = TuplesKt.to("FALLBACK_COMMON", 200);
        r0[6] = TuplesKt.to("UNIVERSAL_FALLBACK_COMMON", 100);
        r0[7] = TuplesKt.to("OTHERS", 0);
        a = MapsKt.mapOf(r0);
        return;
    L5:
        r1 = 1200;
        goto L6
    }

    public static final ValidateResult a(c r6) {
        Intrinsics.checkNotNullParameter(r6, "filePolicyResult");
        ValidateResult r0 = new ValidateResult(r6.h());
        List<DecisionData.Action> r1 = r6.b();
        String r2 = null;
        if (r1 == null) goto L7;
        DecisionData.Action r3 = (DecisionData.Action) CollectionsKt.firstOrNull(r1);
        if (r3 == null) goto L7;
        String r4 = r3.getName();
    L8:
        if (r4 != null) goto L10;
    L31:
        FileAuthResultFrom r5 = FileAuthResultFrom.COME_FROM_UNKNOWN;
    L32:
        r0.setResultPolicy(r5);
        r0.setCredible(c(r6));
        r0.setPolicyMethod(r6.g());
        ValidateResult.ValidateResultExtra r7 = new ValidateResult.ValidateResultExtra();
        DecisionData r8 = new DecisionData();
        List<DecisionData.Action> r9 = r6.b();
        if (r9 != null) goto L36;
        r9 = CollectionsKt.emptyList();
    L36:
        r8.setActions(new LinkedList(r9));
        r7.setRawActions(com.ss.android.lark.security.compliance.infra.util.f.c(r8));
        r7.setResultLogs(r6.i());
        if (idb.f.a().isEnable("admin.security.dlp.banner") == false) goto L51;
        List<DecisionData.Action> r10 = r6.b();
        if (r10 == null) goto L41;
        DecisionData.Action r11 = (DecisionData.Action) CollectionsKt.firstOrNull(r10);
    L42:
        if (r11 == null) goto L47;
        Map<String, String> r12 = r11.getParams();
        if (r12 == null) goto L47;
        r2 = r12.get("displayInteractMode");
    L47:
        if (Intrinsics.areEqual(r2, "hidden") == false) goto L49;
        InteractionType r13 = InteractionType.HIDDEN;
    L50:
        r7.setInteractionType(r13);
        goto L51
    L49:
        r13 = InteractionType.DEFAULT;
        goto L50
    L41:
        r11 = null;
    L51:
        r7.setPointKey(r6.f());
        r7.setCacheHitTaskId(r6.c());
        r7.setCacheType(r6.d());
        r7.setTraceId(qqb.a.d());
        r0.setValidateResultExtra(r7);
        return r0;
    L10:
        switch(r4.hashCode()) {
            case -454817246: goto L28;
            case 391141870: goto L24;
            case 1494495200: goto L20;
            case 1757428727: goto L17;
            case 1874431577: goto L13;
            default: goto L31;
        };
    L13:
        if (r4.equals("DLP_CONTENT_SENSITIVE") == false) goto L31;
        r5 = FileAuthResultFrom.COME_FROM_DLP_CONTENT_SENSITIVE;
        goto L32
    L17:
        if (r4.equals("ACCESS_CONTROL_ACTION_COMMON") == false) goto L31;
    L22:
        r5 = FileAuthResultFrom.COME_FROM_FILE_POLICY;
        goto L32
    L20:
        if (r4.equals("FILE_BLOCK_COMMON") == true) goto L22;
    L24:
        if (r4.equals("TT_BLOCK") == false) goto L31;
        r5 = FileAuthResultFrom.COME_FROM_TT_BLOCK;
        goto L32
    L28:
        if (r4.equals("DLP_CONTENT_DETECTING") == false) goto L31;
        r5 = FileAuthResultFrom.COME_FROM_DLP_CONTENT_DETECTING;
    L7:
        r4 = null;
        goto L8
    }

    public static final ValidateLogInfo b(d r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        boolean r2 = false;
        if (ArraysKt.contains(new ResponseType[]{ResponseType.REMOTE, ResponseType.LOCAL}, r4.getType()) == true) goto L5;
    L20:
        return null;
    L5:
        if (r4.f().length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L20;
        List<String> r1 = r4.d();
        if (r1 != null) goto L12;
    L14:
        if (r2 == false) goto L20;
        String r3 = r4.f();
        List<String> r5 = r4.d();
        if (r5 != null) goto L22;
        r5 = CollectionsKt.emptyList();
    L22:
        return new ValidateLogInfo(r3, new LinkedList(r5));
    L12:
        if ((!r1.isEmpty()) != true) goto L14;
        r2 = true;
        goto L14
    L7:
        r0 = false;
        goto L8
    }

    public static final boolean c(c r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.e() == false) goto L5;
        return false;
    L5:
        if (r4.k() == true) goto L7;
        return false;
    L7:
        if (ArraysKt.contains(new ValidateResultSource[]{ValidateResultSource.DOWNGRADE, ValidateResultSource.FALLBACK}, r4.g()) == true) goto L12;
        return true;
    L12:
        return false;
    }
}
