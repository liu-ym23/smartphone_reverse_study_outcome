package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes2.dex */
class SegmentApplyException extends BaseException {
    public static final int ALREADY_APPLY_BY_OTHER = 1;
    public static final int BAD_SEGMENT = 6;
    public static final int CHANGE_SEGMENT = 5;
    public static final int PREV_END_ADJUST_FAIL = 4;
    public static final int PREV_OVERSTEP = 3;
    public static final int SEGMENT_NOT_EXIST = 2;
    private int applyCode;

    SegmentApplyException(int r10, String r11) {
        super(1072, "applyCode=" + r10 + ", " + r11);
        this.applyCode = r10;
    }

    public int getSegmentApplyErrorCode() {
        return this.applyCode;
    }
}
