package com.larus.camera.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/camera/impl/entity/ResultSuggestType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "PHOTO", "HOMEWORK_CORRECTION", "EDU_SINGLE_QUESTION", "EDU_MULTI_QUESTION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultSuggestType extends Enum<ResultSuggestType> {
    public static final ResultSuggestType EDU_MULTI_QUESTION = null;
    public static final ResultSuggestType EDU_SINGLE_QUESTION = null;
    public static final ResultSuggestType HOMEWORK_CORRECTION = null;
    public static final ResultSuggestType NONE = null;
    public static final ResultSuggestType PHOTO = null;
    public static final /* synthetic */ ResultSuggestType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResultSuggestType> getEntries() {
        return b;
    }

    static {
        ResultSuggestType r0 = new ResultSuggestType("NONE", 0);
        NONE = r0;
        ResultSuggestType r1 = new ResultSuggestType("PHOTO", 1);
        PHOTO = r1;
        ResultSuggestType r3 = new ResultSuggestType("HOMEWORK_CORRECTION", 2);
        HOMEWORK_CORRECTION = r3;
        ResultSuggestType r5 = new ResultSuggestType("EDU_SINGLE_QUESTION", 3);
        EDU_SINGLE_QUESTION = r5;
        ResultSuggestType r7 = new ResultSuggestType("EDU_MULTI_QUESTION", 4);
        EDU_MULTI_QUESTION = r7;
        ResultSuggestType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ResultSuggestType[] values() {
        return (ResultSuggestType[]) a.clone();
    }

    public static ResultSuggestType valueOf(String r1) {
        return (ResultSuggestType) a.a(ResultSuggestType.class, r1);
    }

    public ResultSuggestType(String r1, int r2) {
        super(r1, r2);
    }
}
