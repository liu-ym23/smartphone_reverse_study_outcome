package com.byted.cast.sink.api;

import com.bytedance.ai.event.MessageIndication;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class CastInfo {
    public static final int INFO_CAST_PORT_SET = 220002;
    public static final int INFO_CAST_PORT_UNSET = 220003;
    public static final int INFO_SERVER_START = 220004;
    public static final int INFO_SERVER_STOP = 220005;
    public static final int INFO_SET_BITRATE_KPS = 220001;
    public static final int STOP_BY_SERVER = 104;
    public static final int STOP_ERROR = 3;
    public static final int STOP_NORMAL = 1;
    public static final int STOP_PREEMPTED = 101;
    public static final int STOP_REMOTE_CONTROL = 102;
    public static final int STOP_TIMEOUT = 2;
    public static final int STOP_USER_EXIT = 103;
    public static final int TYPE_CAST = 101;
    public static final int TYPE_CAST_PAUSE = 104;
    public static final int TYPE_CAST_RESUME = 105;
    public static final int TYPE_CAST_SUCCESS = 108;
    public static final int TYPE_DISCONNECT = 106;
    public static final int TYPE_INFO = 109;
    public static final int TYPE_PAUSED = 107;
    public static final int TYPE_SIZE_CHANGED = 103;
    public static final int TYPE_START = 100;
    public static final int TYPE_STOP = 102;
    public int audioSessionId;
    public int castType;
    public String clientID;
    public boolean handleInside;
    public InfoData infoData;
    public int infoType;
    public String mediaAlbum;
    public String mediaAlbumUrl;
    public String mediaArtist;
    public String mediaTitle;
    public int mimeType;
    public int protocol;
    public int rotation;
    public SizeInfo sizeInfo;
    public int sourceDeviceType;
    public StartInfo startInfo;
    public double startPosition;
    public StopInfo stopInfo;
    public String token;
    public String url;

    public static class InfoData {
        public int infoCode;
        public String msg;
        public int what;

        public InfoData(int r1, int r10, String r11) {
            this.what = r1;
            this.infoCode = r10;
            this.msg = r11;
        }

        public String toString() {
            JSONObject r0 = new JSONObject();
            r0.put("what", this.what);     // Catch: JSONException -> L10
            r0.put("infoCode", this.infoCode);     // Catch: JSONException -> L10
            r0.put(MessageIndication.MESSAGE_TYPE_MSG, this.msg);     // Catch: JSONException -> L10
            return r0.toString();
        L11:
            return "{\"what\":" + this.what + ",\"infoCode\":" + this.infoCode + ",\"msg\":\"" + this.msg + "\"}";
        }
    }

    public static class SizeInfo {
        public int height;
        public int width;

        public SizeInfo() {
        }
    }

    public static class StartInfo {
        public int bitRate;
        public int frameRate;
        public int height;
        public int type;
        public int width;

        public StartInfo() {
        }
    }

    public static class StopInfo {
        public int stopDetail;
        public int stopReason;

        public StopInfo(int r1, int r10) {
            this.stopReason = r1;
            this.stopDetail = r10;
        }

        public String toString() {
            return "StopInfo{stopReason=" + this.stopReason + ", stopDetail=" + this.stopDetail + '}';
        }
    }

    public CastInfo() {
        this.handleInside = true;
        this.sourceDeviceType = -1;
    }

    public CastInfo(CastInfo r10) {
        this.handleInside = true;
        this.sourceDeviceType = -1;
        this.castType = r10.castType;
        this.protocol = r10.protocol;
        this.mimeType = r10.mimeType;
        this.rotation = r10.rotation;
        this.handleInside = true;
        this.clientID = r10.clientID;
        this.audioSessionId = r10.audioSessionId;
        this.infoType = r10.infoType;
        this.sourceDeviceType = r10.sourceDeviceType;
    }

    public String toString() {
        return "CastInfo{clientID='" + this.clientID + "', token='" + this.token + "', stopInfo=" + this.stopInfo + '}';
    }
}
