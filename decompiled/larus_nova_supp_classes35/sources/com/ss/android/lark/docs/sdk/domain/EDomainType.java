package com.ss.android.lark.docs.sdk.domain;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/docs/sdk/domain/EDomainType;", BuildConfig.FLAVOR, "DOCS_API", "DRIVE_STREAM", "docs-model_release"}, k = 1, mv = {1, 7, 1})
public final enum EDomainType extends Enum<EDomainType> {
    public static final EDomainType DOCS_API = null;
    public static final EDomainType DRIVE_STREAM = null;
    public static final /* synthetic */ EDomainType[] a = null;

    public static EDomainType valueOf(String r1) {
        return (EDomainType) a.a(EDomainType.class, r1);
    }

    public static EDomainType[] values() {
        return (EDomainType[]) a.clone();
    }

    static {
        EDomainType r0 = new EDomainType("DOCS_API", 0);
        DOCS_API = r0;
        EDomainType r1 = new EDomainType("DRIVE_STREAM", 1);
        DRIVE_STREAM = r1;
        a = new EDomainType[]{r0, r1};
    }

    public EDomainType(String r1, int r2) {
        super(r1, r2);
    }
}
