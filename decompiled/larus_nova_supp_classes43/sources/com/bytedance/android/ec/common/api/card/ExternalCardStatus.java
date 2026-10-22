package com.bytedance.android.ec.common.api.card;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.utils.FontWeight;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/common/api/card/ExternalCardStatus;", "", "", a.KEY_STATUS_CODE, "I", "getStatusCode", "()I", "UNINITIALIZED", "PENDING", "SCHEDULED", "LOADING", "ANIM_SHOWING", "SHOWING", "ANIM_HIDING", "FINISHED", "INTERRUPTED", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ExternalCardStatus extends Enum<ExternalCardStatus> {
    public static final ExternalCardStatus ANIM_HIDING = null;
    public static final ExternalCardStatus ANIM_SHOWING = null;
    public static final ExternalCardStatus FINISHED = null;
    public static final ExternalCardStatus INTERRUPTED = null;
    public static final ExternalCardStatus LOADING = null;
    public static final ExternalCardStatus PENDING = null;
    public static final ExternalCardStatus SCHEDULED = null;
    public static final ExternalCardStatus SHOWING = null;
    public static final ExternalCardStatus UNINITIALIZED = null;
    public static final /* synthetic */ ExternalCardStatus[] a = null;
    private final int statusCode;

    public static ExternalCardStatus valueOf(String r1) {
        return (ExternalCardStatus) r27.a.a(ExternalCardStatus.class, r1);
    }

    public static ExternalCardStatus[] values() {
        return (ExternalCardStatus[]) a.clone();
    }

    static {
        ExternalCardStatus r1 = new ExternalCardStatus("UNINITIALIZED", 0, 0);
        UNINITIALIZED = r1;
        ExternalCardStatus r10 = new ExternalCardStatus("PENDING", 1, 100);
        PENDING = r10;
        ExternalCardStatus r11 = new ExternalCardStatus("SCHEDULED", 2, 200);
        SCHEDULED = r11;
        ExternalCardStatus r12 = new ExternalCardStatus("LOADING", 3, FontWeight.WEIGHT_300);
        LOADING = r12;
        ExternalCardStatus r13 = new ExternalCardStatus("ANIM_SHOWING", 4, 400);
        ANIM_SHOWING = r13;
        ExternalCardStatus r14 = new ExternalCardStatus("SHOWING", 5, 500);
        SHOWING = r14;
        ExternalCardStatus r15 = new ExternalCardStatus("ANIM_HIDING", 6, FontWeight.WEIGHT_600);
        ANIM_HIDING = r15;
        ExternalCardStatus r16 = new ExternalCardStatus("FINISHED", 7, FontWeight.WEIGHT_700);
        FINISHED = r16;
        ExternalCardStatus r17 = new ExternalCardStatus("INTERRUPTED", 8, 800);
        INTERRUPTED = r17;
        a = new ExternalCardStatus[]{r1, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public ExternalCardStatus(String r1, int r10, int r11) {
        super(r1, r10);
        this.statusCode = r11;
    }
}
