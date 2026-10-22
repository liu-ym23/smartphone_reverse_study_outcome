package com.ss.ugc.effectplatform.model.algorithm;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/effectplatform/model/algorithm/FetchModelType;", "", "", "value", "fromValue", "ORIGIN", "ZIP", "effect_model_release"}, k = 1, mv = {1, 4, 0})
public final enum FetchModelType extends Enum<FetchModelType> {
    public static final FetchModelType ORIGIN = null;
    public static final FetchModelType ZIP = null;
    public static final /* synthetic */ FetchModelType[] a = null;

    static {
        FetchModelType r1 = new FetchModelType("ORIGIN", 0);
        ORIGIN = r1;
        FetchModelType r2 = new FetchModelType("ZIP", 1);
        ZIP = r2;
        a = new FetchModelType[]{r1, r2};
    }

    public static FetchModelType valueOf(String r1) {
        return (FetchModelType) a.a(FetchModelType.class, r1);
    }

    public static FetchModelType[] values() {
        return (FetchModelType[]) a.clone();
    }

    public FetchModelType fromValue(int r6) {
        FetchModelType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        FetchModelType r3 = r0[r2];
        if (r3.ordinal() == r6) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return ORIGIN;
    }

    public FetchModelType(String r1, int r2) {
        super(r1, r2);
    }
}
