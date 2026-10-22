package com.byted.cast.render.render;

import com.byted.cast.mediacommon.render.parameters.MediaParameter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IRender {
    Object getParameter(MediaParameter r1);

    void render(byte[] r1, int r10);

    void setParameter(MediaParameter r1, Object r10);

    boolean start();

    boolean stop();
}
