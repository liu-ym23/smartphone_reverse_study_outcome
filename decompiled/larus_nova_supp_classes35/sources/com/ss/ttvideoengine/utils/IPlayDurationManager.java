package com.ss.ttvideoengine.utils;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IPlayDurationManager {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.utils.IPlayDurationManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$release(IPlayDurationManager r0) {
        }
    }

    void clear();

    int getPlayedDuration();

    long getWiredPlayedDuration();

    long getWirelessPlayedDuration(Context r1);

    void release();

    void reset();

    void start();

    void stop();
}
