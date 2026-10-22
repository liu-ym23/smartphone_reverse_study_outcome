package com.bytedance.android.chunkstreamprediction.network;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ChunkDataException extends RuntimeException {
    public final Map<String, String> extraInfo;

    public ChunkDataException(Throwable r1, Map<String, String> r10) {
        super(r1);
        this.extraInfo = r10;
    }
}
