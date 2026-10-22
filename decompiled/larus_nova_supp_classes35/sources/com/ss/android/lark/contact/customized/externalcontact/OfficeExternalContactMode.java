package com.ss.android.lark.contact.customized.externalcontact;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/OfficeExternalContactMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PERSONAL_CONTACTS", "ENTERPRISE_CONTACTS", "EXTERNAL_CONTACTS", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeExternalContactMode extends Enum<OfficeExternalContactMode> {
    public static final OfficeExternalContactMode ENTERPRISE_CONTACTS = null;
    public static final OfficeExternalContactMode EXTERNAL_CONTACTS = null;
    public static final OfficeExternalContactMode PERSONAL_CONTACTS = null;
    public static final /* synthetic */ OfficeExternalContactMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeExternalContactMode> getEntries() {
        return b;
    }

    static {
        OfficeExternalContactMode r0 = new OfficeExternalContactMode("PERSONAL_CONTACTS", 0);
        PERSONAL_CONTACTS = r0;
        OfficeExternalContactMode r1 = new OfficeExternalContactMode("ENTERPRISE_CONTACTS", 1);
        ENTERPRISE_CONTACTS = r1;
        OfficeExternalContactMode r3 = new OfficeExternalContactMode("EXTERNAL_CONTACTS", 2);
        EXTERNAL_CONTACTS = r3;
        OfficeExternalContactMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static OfficeExternalContactMode[] values() {
        return (OfficeExternalContactMode[]) a.clone();
    }

    public static OfficeExternalContactMode valueOf(String r1) {
        return (OfficeExternalContactMode) a.a(OfficeExternalContactMode.class, r1);
    }

    public OfficeExternalContactMode(String r1, int r2) {
        super(r1, r2);
    }
}
