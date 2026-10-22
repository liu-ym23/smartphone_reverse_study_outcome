package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.ss.android.lark.pb.recognition.GetSpeechConfigResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements SdkSender.IParser {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object parse(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return (GetSpeechConfigResponse) GetSpeechConfigResponse.ADAPTER.decode(r2);
    }
}
