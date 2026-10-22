package com.suite.lark.platform.component.widget_biz_tenantname.data;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TenantCertificationData {
    public final Boolean a;
    public final CertificateStatus b;
    public final String c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_tenantname/data/TenantCertificationData$CertificateStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNCERTIFICATED", "CERTIFICATED", "EXPIRED", "TEAM_CERTIFICATED", "getValue", "Companion", "widget-biz-tenantname_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum CertificateStatus extends Enum<CertificateStatus> {
        public static final CertificateStatus CERTIFICATED = null;
        public static final a Companion = null;
        public static final CertificateStatus EXPIRED = null;
        public static final CertificateStatus TEAM_CERTIFICATED = null;
        public static final CertificateStatus UNCERTIFICATED = null;
        public static final /* synthetic */ CertificateStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CertificateStatus> getEntries() {
            return b;
        }

        static {
            CertificateStatus r0 = new CertificateStatus("UNCERTIFICATED", 0, 0);
            UNCERTIFICATED = r0;
            CertificateStatus r1 = new CertificateStatus("CERTIFICATED", 1, 1);
            CERTIFICATED = r1;
            CertificateStatus r3 = new CertificateStatus("EXPIRED", 2, 2);
            EXPIRED = r3;
            CertificateStatus r5 = new CertificateStatus("TEAM_CERTIFICATED", 3, 3);
            TEAM_CERTIFICATED = r5;
            CertificateStatus[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static CertificateStatus[] values() {
            return (CertificateStatus[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final CertificateStatus fromValue(Integer r2) {
            Companion.getClass();
            if (r2 != null) goto L6;
            return UNCERTIFICATED;
        L6:
            if (r2.intValue() != 0) goto L9;
            return UNCERTIFICATED;
        L9:
            if (r2.intValue() != 1) goto L12;
            return CERTIFICATED;
        L12:
            if (r2.intValue() != 2) goto L15;
            return EXPIRED;
        L15:
            if (r2.intValue() == 3) goto L23;
            return null;
        L23:
            return TEAM_CERTIFICATED;
        }

        public static CertificateStatus valueOf(String r1) {
            return (CertificateStatus) r27.a.a(CertificateStatus.class, r1);
        }

        public CertificateStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public TenantCertificationData() {
        this(null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TenantCertificationData) == true) goto L8;
        return false;
    L8:
        TenantCertificationData r6 = (TenantCertificationData) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CertificateStatus r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TenantCertificationData(isShowCertSign=" + this.a + ", certificateStatus=" + this.b + ", tenantCertificationUrl=" + this.c + ')';
    }

    public TenantCertificationData(Boolean r1, CertificateStatus r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
