package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IAudioController;", BuildConfig.FLAVOR, "clear", BuildConfig.FLAVOR, "startAsrAudio", BuildConfig.FLAVOR, "startRecordAudio", "stopAsrAudio", "stopRecordAudio", "send", "cancel", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAudioController {
    void clear();

    boolean startAsrAudio();

    boolean startRecordAudio();

    boolean stopAsrAudio();

    boolean stopRecordAudio(boolean r1, boolean r2);
}
