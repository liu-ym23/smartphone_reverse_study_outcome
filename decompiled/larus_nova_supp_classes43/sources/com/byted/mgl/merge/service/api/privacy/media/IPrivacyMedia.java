package com.byted.mgl.merge.service.api.privacy.media;

import android.media.MediaRecorder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IPrivacyMedia {
    void release(MediaRecorder r1, String r10) throws IllegalAccessException;

    void start(MediaRecorder r1, String r10) throws IllegalAccessException;

    void stop(MediaRecorder r1, String r10) throws IllegalAccessException;
}
