package com.byted.mgl.merge.service.api.privacy.audio;

import android.media.AudioRecord;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IPrivacyAudio {
    void release(AudioRecord r1, String r10) throws IllegalAccessException;

    void startRecording(AudioRecord r1, String r10) throws IllegalAccessException;

    void stop(AudioRecord r1, String r10) throws IllegalAccessException;
}
