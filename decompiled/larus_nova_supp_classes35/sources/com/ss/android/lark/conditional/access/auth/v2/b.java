package com.ss.android.lark.conditional.access.auth.v2;

import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CalendarFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final HashSet<String> d = null;
    public static final List<String> e = null;
    public static final Map<String, PolicyModel> f = null;
    public static final Map<String, PolicyModel> g = null;

    static {
        a = CollectionsKt.listOf("PointKey_IM_MSG_FILE_DOWNLOAD");
        b = CollectionsKt.listOf(new String[]{"IM_MSG_FILE_READ", "IM_MSG_FILE_DOWNLOAD"});
        c = CollectionsKt.listOf(new String[]{"PointKey_IM_MSG_FILE_READ", "PointKey_IM_MSG_FILE_DOWNLOAD", "PointKey_CCM_EXPORT_WITH_OBJECT", "PointKey_CCM_ATTACHMENT_DOWNLOAD_WITH_OBJECT", "PointKey_CCM_FILE_DOWNLOAD_WITH_OBJECT", "PointKey_CCM_CONTENT_COPY_WITH_OBJECT", "PointKey_CCM_OPEN_EXTERNAL_ACCESS_WITH_OBJECT"});
        d = SetsKt.hashSetOf(new String[]{"PointKey_IM_MSG_FILE_PREVIEW", "PointKey_IM_MSG_FILE_COPY", "PointKey_CCM_EXPORT", "PointKey_CCM_ATTACHMENT_DOWNLOAD", "PointKey_CCM_FILE_DOWNLOAD", "PointKey_CCM_CONTENT_PREVIEW", "PointKey_CCM_CONTENT_COPY", "PointKey_CCM_FILE_PREVIEW", "PointKey_CCM_FILE_UPLOAD", "PointKey_CCM_CREATE_COPY", "PointKey_CCM_MOVE_RECYCLE_BIN", "PointKey_CCM_FILE_ATTACHMENT_UPLOAD", "PointKey_VC_MM_CONTENT_COPY", "PointKey_CALENDAR_CONTENT_COPY", "PointKey_CALENDAR_FILE_PREVIEW"});
        e = CollectionsKt.listOf(new String[]{"DOC", "DOCX", "SHEET", "BITABLE", "MINDNOTE", "FILE", "DASHBOARD", "CHART", "WIKI_SPACE", "PIVOT_TABLE", "BITABLE_SHARE_FORM", "SPACE_CATALOG", "SLIDES"});
        EntityDomain r10 = EntityDomain.EntityDomainIM;
        FileBizDomain r16 = FileBizDomain.FileBizDomainIM;
        EntityDomain r8 = EntityDomain.EntityDomainCCM;
        FileBizDomain r28 = FileBizDomain.FileBizDomainCCM;
        f = MapsKt.mapOf(new Pair[]{TuplesKt.to("IM_MSG_FILE_PREVIEW", new PolicyModel("PointKey_IM_MSG_FILE_PREVIEW", new IMFileEntity("IM_MSG_FILE", r10, "IM_MSG_FILE_PREVIEW", 1, 1, r16, null, null, null, null, null, null, null, null, null, 32256, null), null, 4, null)), TuplesKt.to("IM_MSG_FILE_COPY", new PolicyModel("PointKey_IM_MSG_FILE_COPY", new IMFileEntity("IM_MSG_FILE", r10, "IM_MSG_FILE_COPY", 1, 1, r16, null, null, null, null, null, null, null, null, null, 32256, null), null, 4, null)), TuplesKt.to("CAL_FILE_DOWNLOAD", new PolicyModel("PointKey_CCM_FILE_DOWNLOAD", new CalendarFileEntity("FILE", r8, "CCM_FILE_DOWNLOAD", 1, 1, FileBizDomain.FileBizDomainCALENDAR, null, null, null, 448, null), null, 4, null)), TuplesKt.to("CCM_FILE_DOWNLOAD", new PolicyModel("PointKey_CCM_FILE_DOWNLOAD", new CCMFileEntity("FILE", r8, "CCM_FILE_DOWNLOAD", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_FILE_PREVIEW", new PolicyModel("PointKey_CCM_FILE_PREVIEW", new CCMFileEntity("FILE", r8, "CCM_FILE_PREVIEW", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_ATTACHMENT_DOWNLOAD", new PolicyModel("PointKey_CCM_ATTACHMENT_DOWNLOAD", new CCMFileEntity("FILE", r8, "CCM_ATTACHMENT_DOWNLOAD", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_FILE_UPLOAD", new PolicyModel("PointKey_CCM_FILE_UPLOAD", new CCMFileEntity("FILE", r8, "CCM_FILE_UPLOAD", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_ATTACHMENT_UPLOAD", new PolicyModel("PointKey_CCM_FILE_ATTACHMENT_UPLOAD", new CCMFileEntity("FILE", r8, "CCM_ATTACHMENT_UPLOAD", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_EXPORT", new PolicyModel("PointKey_CCM_EXPORT", new CCMFileEntity("DOC", r8, "CCM_EXPORT", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_CONTENT_PREVIEW", new PolicyModel("PointKey_CCM_CONTENT_PREVIEW", new CCMFileEntity("DOC", r8, "CCM_CONTENT_PREVIEW", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null))});
        g = MapsKt.mapOf(new Pair[]{TuplesKt.to("CCM_CONTENT_COPY", new PolicyModel("PointKey_CCM_CONTENT_COPY", new CCMFileEntity("DOC", r8, "CCM_CONTENT_COPY", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_CREATE_COPY", new PolicyModel("PointKey_CCM_CREATE_COPY", new CCMFileEntity("DOC", r8, "CCM_CREATE_COPY", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null)), TuplesKt.to("CCM_MOVE_RECYCLE_BIN", new PolicyModel("PointKey_CCM_MOVE_RECYCLE_BIN", new CCMFileEntity("DOC", r8, "CCM_MOVE_RECYCLE_BIN", 1, 1, r28, null, null, null, null, null, null, null, null, 16320, null), null, 4, null))});
    }

    public static final c a(com.bytedance.lark.policy.model.b0 r7, ValidateResultSource r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        if (r7 != null) goto L5;
    L27:
        int r0 = ScsLogger.a;
        StringBuilder r1 = new StringBuilder("validate2AuthResult，errorMsg = ");
        if (r7 == null) goto L30;
        String r9 = r7.c();
    L31:
        r1.append(r9);
        ScsLogger.d("SecurityPolicy_PolicyValidateService", r1.toString());
        return new c(ResultType.ERROR, r8, null, null, 1016);
    L30:
        r9 = null;
        goto L31
    L5:
        if (r7.c() != null) goto L27;
        List r2 = CollectionsKt.emptyList();
        List r3 = r7.d();
        boolean r4 = true;
        if (r3 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
    L21:
        List r6 = r2;
        if (r7.f() == false) goto L24;
        ResultType r10 = ResultType.ALLOW;
    L25:
        ResultType r11 = r10;
        int r12 = com.ss.android.lark.conditional.access.utils.e.a;
        return new c(r11, r8, com.ss.android.lark.conditional.access.utils.e.d(r7.a()), r6, DocErrorCode.ERRCODE_PULL_DATA_START_NOT_READY);
    L24:
        r10 = ResultType.DENY;
        goto L25
    L16:
        if (r7.e().length() > 0) goto L19;
        r4 = false;
    L19:
        if (r4 == false) goto L21;
        r2 = CollectionsKt.listOf(new ValidateLogInfo(r7.e(), new LinkedList(r3)));
        goto L21
    L10:
        if (r3.isEmpty() == true) goto L13;
        r5 = false;
        goto L14
    }
}
