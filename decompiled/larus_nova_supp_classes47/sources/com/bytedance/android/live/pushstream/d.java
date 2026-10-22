package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d extends b, f {
    nc1.a e();

    void f(RadioWidget.e r1);

    Map<String, String> getLastAudioCaptureLogMap();

    Map<String, String> getLastVideoCaptureLogMap();
}
