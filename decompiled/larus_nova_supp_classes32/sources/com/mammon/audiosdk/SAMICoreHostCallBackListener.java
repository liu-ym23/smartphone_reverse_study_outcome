package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface SAMICoreHostCallBackListener {
    void onSendToHost(SAMICoreCallBackEventType r1, SAMICoreBlock r2);
}
