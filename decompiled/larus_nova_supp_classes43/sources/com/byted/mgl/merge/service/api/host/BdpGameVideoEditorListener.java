package com.byted.mgl.merge.service.api.host;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpGameVideoEditorListener {
    void onCompileDone();

    void onCompileError(int r1, int r10, float r11, String r12);

    void onProgress(float r1);
}
