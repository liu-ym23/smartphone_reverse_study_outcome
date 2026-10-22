package com.byted.cast.render.render.video;

import android.view.Surface;
import com.byted.cast.render.render.IRender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IVideoRender extends IRender {
    void config_video_parameters(int r1, int r10, int r11, int r12, int r13);

    void isOpenDump(boolean r1);

    void setDumpPath(String r1);

    void setSurface(Surface r1);
}
