package com.bytedance.badger.y;

import com.bytedance.badger.data.EventReportEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[EventReportEnum.values().length];
        a = r0;
        r0[EventReportEnum.START.ordinal()] = 1;
        r0[EventReportEnum.PHONE_INPUT.ordinal()] = 2;
        r0[EventReportEnum.PHONE_INPUT_START.ordinal()] = 3;
        r0[EventReportEnum.PHONE_INPUT_END.ordinal()] = 4;
        r0[EventReportEnum.AGREEMENT_BUTTON.ordinal()] = 5;
        r0[EventReportEnum.VERIFY_AND_LOGIN_BUTTON.ordinal()] = 6;
        r0[EventReportEnum.VERIFY_CODE_INPUT.ordinal()] = 7;
        r0[EventReportEnum.VERIFY_CODE_INPUT_START.ordinal()] = 8;
        r0[EventReportEnum.VERIFY_CODE_INPUT_END.ordinal()] = 9;
        r0[EventReportEnum.LOGIN_BUTTON.ordinal()] = 10;
        r0[EventReportEnum.TOUCH.ordinal()] = 11;
    }
}
