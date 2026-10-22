package com.larus.camera.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import px8.e;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0013"}, d2 = {"Lcom/larus/camera/impl/entity/ResultTabPresentationType;", "", "controlType", "Lcom/larus/camera/impl/entity/ResultBottomControlType;", "suggestType", "Lcom/larus/camera/impl/entity/ResultSuggestType;", "<init>", "(Ljava/lang/String;ILcom/larus/camera/impl/entity/ResultBottomControlType;Lcom/larus/camera/impl/entity/ResultSuggestType;)V", "getControlType", "()Lcom/larus/camera/impl/entity/ResultBottomControlType;", "getSuggestType", "()Lcom/larus/camera/impl/entity/ResultSuggestType;", "QUESTION_LEGACY", "QUESTION", "MULTI_QUESTION", "HOMEWORK_CORRECTION", "PHOTO", "toBottomState", "Lcom/larus/camera/impl/entity/ResultBottomState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultTabPresentationType extends Enum<ResultTabPresentationType> {
    public static final ResultTabPresentationType HOMEWORK_CORRECTION = null;
    public static final ResultTabPresentationType MULTI_QUESTION = null;
    public static final ResultTabPresentationType PHOTO = null;
    public static final ResultTabPresentationType QUESTION = null;
    public static final ResultTabPresentationType QUESTION_LEGACY = null;
    public static final /* synthetic */ ResultTabPresentationType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final ResultBottomControlType controlType;
    private final ResultSuggestType suggestType;

    public static EnumEntries<ResultTabPresentationType> getEntries() {
        return b;
    }

    static {
        ResultTabPresentationType r0 = new ResultTabPresentationType("QUESTION_LEGACY", 0, ResultBottomControlType.CONFIRM, ResultSuggestType.NONE);
        QUESTION_LEGACY = r0;
        ResultBottomControlType r2 = ResultBottomControlType.INPUT;
        ResultTabPresentationType r1 = new ResultTabPresentationType("QUESTION", 1, r2, ResultSuggestType.EDU_SINGLE_QUESTION);
        QUESTION = r1;
        ResultTabPresentationType r3 = new ResultTabPresentationType("MULTI_QUESTION", 2, r2, ResultSuggestType.EDU_MULTI_QUESTION);
        MULTI_QUESTION = r3;
        ResultTabPresentationType r5 = new ResultTabPresentationType("HOMEWORK_CORRECTION", 3, r2, ResultSuggestType.HOMEWORK_CORRECTION);
        HOMEWORK_CORRECTION = r5;
        ResultTabPresentationType r7 = new ResultTabPresentationType("PHOTO", 4, r2, ResultSuggestType.PHOTO);
        PHOTO = r7;
        ResultTabPresentationType[] r4 = {r0, r1, r3, r5, r7};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ResultTabPresentationType[] values() {
        return (ResultTabPresentationType[]) a.clone();
    }

    public final e toBottomState() {
        return new e(this.controlType, this.suggestType);
    }

    public final ResultBottomControlType getControlType() {
        return this.controlType;
    }

    public final ResultSuggestType getSuggestType() {
        return this.suggestType;
    }

    public static ResultTabPresentationType valueOf(String r1) {
        return (ResultTabPresentationType) a.a(ResultTabPresentationType.class, r1);
    }

    public ResultTabPresentationType(String r1, int r2, ResultBottomControlType r3, ResultSuggestType r4) {
        super(r1, r2);
        this.controlType = r3;
        this.suggestType = r4;
    }
}
