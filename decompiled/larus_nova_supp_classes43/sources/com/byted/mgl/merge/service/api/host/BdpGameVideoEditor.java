package com.byted.mgl.merge.service.api.host;

import android.util.Size;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpGameVideoEditor {
    int addAudioTrack(String r1, int r10, int r11, int r12, int r13);

    int addImageSticker(String r1, float r10, float r11, float r12, float r13);

    boolean cancel();

    boolean compile(String r1, Size r10, BdpGameVideoEditorListener r11);

    void destroy();

    int init(String[] r1, int[] r10, int[] r11, String[] r12, float[] r13);

    int prepare();

    int run(String r1, BdpGameVideoEditorListener r10);
}
