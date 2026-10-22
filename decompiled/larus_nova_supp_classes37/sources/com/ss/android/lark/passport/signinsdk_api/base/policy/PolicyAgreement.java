package com.ss.android.lark.passport.signinsdk_api.base.policy;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/policy/PolicyAgreement;", "", AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "SERVICE_TERM", "PRIVACY", "FACE_INFO", "REAL_NAME", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum PolicyAgreement extends Enum<PolicyAgreement> {
    public static final PolicyAgreement FACE_INFO = null;
    public static final PolicyAgreement PRIVACY = null;
    public static final PolicyAgreement REAL_NAME = null;
    public static final PolicyAgreement SERVICE_TERM = null;
    public static final /* synthetic */ PolicyAgreement[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String path;

    public static EnumEntries<PolicyAgreement> getEntries() {
        return b;
    }

    static {
        PolicyAgreement r0 = new PolicyAgreement("SERVICE_TERM", 0, "terms");
        SERVICE_TERM = r0;
        PolicyAgreement r1 = new PolicyAgreement("PRIVACY", 1, "privacy");
        PRIVACY = r1;
        PolicyAgreement r2 = new PolicyAgreement("FACE_INFO", 2, "face-id");
        FACE_INFO = r2;
        PolicyAgreement r4 = new PolicyAgreement("REAL_NAME", 3, "identity");
        REAL_NAME = r4;
        PolicyAgreement[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static PolicyAgreement[] values() {
        return (PolicyAgreement[]) a.clone();
    }

    public final String getPath() {
        return this.path;
    }

    public static PolicyAgreement valueOf(String r1) {
        return (PolicyAgreement) a.a(PolicyAgreement.class, r1);
    }

    public PolicyAgreement(String r1, int r2, String r3) {
        super(r1, r2);
        this.path = r3;
    }
}
