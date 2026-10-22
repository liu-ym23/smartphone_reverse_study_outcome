package com.bytedance.bmmt.video.memory;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface BmmtVideoByteMemoryInterface extends BmmtVideoMemoryInterface {
    int getNumberOfPlanes();

    ByteBuffer getPlaneData(int r1);

    int getPlaneLineSize(int r1);
}
