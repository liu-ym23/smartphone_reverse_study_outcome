package com.byted.cast.sdk;

import com.byted.cast.sdk.utils.JsonFormatter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RTCStatistics {
    public List<AudioRxStatistics> arx;
    public List<AudioTxStatistics> atx;
    public List<CodecStatistics> cx;
    public List<NetworkStatistics> nx;
    public List<VideoRxStatistics> vrx;
    public List<VideoTxStatistics> vtx;

    public static class AudioRxStatistics {
        public int bitrate;
        public long firstPacketTime;
        public long firstRenderTime;
        public int kind;
        public int loss;
        public long totalBytes;
        public String userId;

        public AudioRxStatistics() {
        }
    }

    public static class AudioTxStatistics {
        public int bitrate;
        public int kind;
        public long totalBytes;

        public AudioTxStatistics() {
        }
    }

    public static class CodecStatistics {
        public String userId;
        public int videoDecodeElapse;
        public int videoEncodeElapse;

        public CodecStatistics() {
        }
    }

    public static class NetworkStatistics {
        public int loss;
        public int rtt;
        public String userId;
        public int videoRtt;

        public NetworkStatistics() {
        }
    }

    public static class VideoRxStatistics {
        public int bitrate;
        public long firstFrameTime;
        public long firstPacketTime;
        public long firstRenderTime;
        public int fps;
        public int height;
        public int kind;
        public int loss;
        public long totalBytes;
        public String userId;
        public int width;

        public VideoRxStatistics() {
        }
    }

    public static class VideoTxStatistics {
        public int bitrate;
        public int fps;
        public int height;
        public int kind;
        public long totalBytes;
        public int width;

        public VideoTxStatistics() {
        }
    }

    public long getTotalRxBytes() {
        Iterator<AudioRxStatistics> r0 = this.arx.iterator();
        long r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + r0.next().totalBytes;
        goto L4
    L6:
        Iterator<VideoRxStatistics> r10 = this.vrx.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r1 = r1 + r10.next().totalBytes;
        goto L8
    L10:
        return r1;
    }

    public long getTotalTxBytes() {
        Iterator<AudioTxStatistics> r0 = this.atx.iterator();
        long r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + r0.next().totalBytes;
        goto L4
    L6:
        Iterator<VideoTxStatistics> r10 = this.vtx.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r1 = r1 + r10.next().totalBytes;
        goto L8
    L10:
        return r1;
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public RTCStatistics() {
        this.nx = new ArrayList();
        this.cx = new ArrayList();
        this.atx = new ArrayList();
        this.vtx = new ArrayList();
        this.arx = new ArrayList();
        this.vrx = new ArrayList();
    }

    public static RTCStatistics fromJson(String r1) {
        return (RTCStatistics) JsonFormatter.fromJson(r1, RTCStatistics.class);
    }
}
