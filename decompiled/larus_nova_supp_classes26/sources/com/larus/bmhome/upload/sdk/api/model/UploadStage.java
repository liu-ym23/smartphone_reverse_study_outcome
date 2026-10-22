package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/UploadStage;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "PREPROCESSING", "CREDENTIAL_PREPARING", "UPLOADING", "REGISTERING", "SUCCESS", "FAILED", "CANCELLED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadStage extends Enum<UploadStage> {
    public static final UploadStage CANCELLED = null;
    public static final UploadStage CREATED = null;
    public static final UploadStage CREDENTIAL_PREPARING = null;
    public static final UploadStage FAILED = null;
    public static final UploadStage PREPROCESSING = null;
    public static final UploadStage REGISTERING = null;
    public static final UploadStage SUCCESS = null;
    public static final UploadStage UPLOADING = null;
    public static final /* synthetic */ UploadStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UploadStage> getEntries() {
        return b;
    }

    static {
        UploadStage r0 = new UploadStage("CREATED", 0);
        CREATED = r0;
        UploadStage r1 = new UploadStage("PREPROCESSING", 1);
        PREPROCESSING = r1;
        UploadStage r3 = new UploadStage("CREDENTIAL_PREPARING", 2);
        CREDENTIAL_PREPARING = r3;
        UploadStage r5 = new UploadStage("UPLOADING", 3);
        UPLOADING = r5;
        UploadStage r7 = new UploadStage("REGISTERING", 4);
        REGISTERING = r7;
        UploadStage r9 = new UploadStage("SUCCESS", 5);
        SUCCESS = r9;
        UploadStage r11 = new UploadStage("FAILED", 6);
        FAILED = r11;
        UploadStage r13 = new UploadStage("CANCELLED", 7);
        CANCELLED = r13;
        UploadStage[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static UploadStage[] values() {
        return (UploadStage[]) a.clone();
    }

    public static UploadStage valueOf(String r1) {
        return (UploadStage) a.a(UploadStage.class, r1);
    }

    public UploadStage(String r1, int r2) {
        super(r1, r2);
    }
}
