package com.byted.cast.render.utils;

import com.byted.cast.mediacommon.render.ILatencyListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class LatencyControl {
    private String TAG;
    private final Map<Long, Long> decodeInTimes;
    private final Map<Long, Long> decodedTimes;
    private final Map<Long, Long> frameMap;
    private final boolean isCalculateByUser;
    private ILatencyListener latencyListener;
    private final Map<Long, Long> sendInTimes;
    private String userId;

    public void setLatencyListener(ILatencyListener r1) {
        this.latencyListener = r1;
    }

    public LatencyControl(String r10, String r11) {
        this.TAG = "RenderLatency";
        this.isCalculateByUser = true;
        this.frameMap = new HashMap();
        this.sendInTimes = new HashMap();
        this.decodeInTimes = new HashMap();
        this.decodedTimes = new HashMap();
        this.userId = r10;
        this.TAG += "-" + r11;
    }

    public void decodeIn(int r10, long r11) {
        if (this.frameMap.containsKey(Long.valueOf(r11)) == true) goto L10;
        return;
    L10:
        Long r12 = this.frameMap.get(Long.valueOf(r11));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void decoded(int r15, long r16) {
        if (this.frameMap.containsKey(Long.valueOf(r16)) == true) goto L12;
        return;
    L12:
        Long r0 = this.frameMap.get(Long.valueOf(r16));     // Catch: Exception -> L9
        ILatencyListener r10 = this.latencyListener;     // Catch: Exception -> L9
        if (r10 == null) goto L14;
        r10.onDecoded(this.userId, r15, r0.longValue(), r16);     // Catch: Exception -> L9
        this.latencyListener.onRenderIn(this.userId, r15, r0.longValue(), r16);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public void rendered(int r10, long r11) {
        if (this.frameMap.containsKey(Long.valueOf(r11)) == true) goto L13;
        return;
    L13:
        Long r0 = this.frameMap.get(Long.valueOf(r11));     // Catch: Exception -> L10
        ILatencyListener r1 = this.latencyListener;     // Catch: Exception -> L10
        if (r1 == null) goto L8;
        r1.onRendered(this.userId, r10, r0.longValue(), r11);     // Catch: Exception -> L10
    L8:
        this.frameMap.remove(Long.valueOf(r11));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public void sendDataIn(int r10, long r11, long r12) {
        ILatencyListener r0 = this.latencyListener;
        if (r0 == null) goto L9;
        r0.onDecodeIn(this.userId, r10, r11, r12);
        if (this.frameMap.size() <= 100) goto L7;
        this.frameMap.clear();
    L7:
        this.frameMap.put(Long.valueOf(r12), Long.valueOf(r11));
        return;
    }
}
