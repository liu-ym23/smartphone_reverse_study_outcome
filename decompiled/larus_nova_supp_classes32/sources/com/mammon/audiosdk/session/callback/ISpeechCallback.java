package com.mammon.audiosdk.session.callback;

import com.mammon.audiosdk.session.data.SpeechReceiverCallbackParam;
import com.mammon.audiosdk.session.data.SpeechSenderCallbackParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ISpeechCallback {
    void onReceiverCallback(SpeechReceiverCallbackParam r1, Object r2);

    void onSenderCallback(SpeechSenderCallbackParam r1, Object r2);
}
