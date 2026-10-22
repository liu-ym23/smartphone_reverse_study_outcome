package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crypto.utils.CryptoConst;
import g2.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = null;
    public static WsChannelMsg EMPTY;
    private int channelId;
    private boolean isAckMsg;
    private long logId;
    private String logInfo;
    private int method;
    private List<MsgHeader> msgHeaders;
    private String msgId;
    private NewMsgTimeHolder newMsgTimeHolder;
    private byte[] payload;
    private String payloadEncoding;
    private String payloadType;
    public transient long receiveDataFromIpcTs;
    private ComponentName replayToComponentName;
    private long seqId;
    private String serverTiming;
    private int service;
    private MessageAckEvent.MessageState state;
    private String uuid;

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;
        String key;
        String value;

        static class a implements Parcelable.Creator<MsgHeader> {
            a() {
            }

            public MsgHeader a(Parcel r10) {
                MsgHeader r11 = new MsgHeader();
                r11.key = r10.readString();
                r11.value = r10.readString();
                return r11;
            }

            public MsgHeader[] b(int r10) {
                return new MsgHeader[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MsgHeader createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MsgHeader[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public MsgHeader() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public void setKey(String r10) {
            this.key = r10;
        }

        public void setValue(String r10) {
            this.value = r10;
        }

        @NonNull
        public String toString() {
            return "MsgHeader{key='" + this.key + "', value='" + this.value + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeString(this.key);
            r10.writeString(this.value);
        }
    }

    static class a implements Parcelable.Creator<WsChannelMsg> {
        a() {
        }

        public WsChannelMsg a(Parcel r10) {
            return new WsChannelMsg(r10);
        }

        public WsChannelMsg[] b(int r10) {
            return new WsChannelMsg[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsChannelMsg createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsChannelMsg[] newArray(int r10) {
            return b(r10);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f1359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1361d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1362e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f1363f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f1364g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f1365h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f1366i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ComponentName f1367j;

        public b(int r10) {
            this.f1359b = new HashMap();
            this.f1364g = "";
            this.f1365h = "";
            this.f1358a = r10;
        }

        public static b c(int r10) {
            return new b(r10);
        }

        public b a(String r10, String r11) {
            this.f1359b.put(r10, r11);
            return this;
        }

        public WsChannelMsg b() {
            if (this.f1358a <= 0) goto L23;
            if (this.f1361d < 0) goto L21;
            if (this.f1362e <= 0) goto L19;
            if (this.f1363f == null) goto L17;
            ArrayList r10 = new ArrayList();
            Iterator<Map.Entry<String, String>> r11 = this.f1359b.entrySet().iterator();
        L12:
            if (r11.hasNext() == false) goto L15;
            Map.Entry<String, String> r12 = r11.next();
            MsgHeader r13 = new MsgHeader();
            r13.setKey(r12.getKey());
            r13.setValue(r12.getValue());
            r10.add(r13);
            goto L12
        L15:
            return new WsChannelMsg(this.f1358a, this.f1366i, this.f1360c, this.f1361d, this.f1362e, r10, this.f1365h, this.f1364g, this.f1363f, this.f1367j);
        L17:
            throw new IllegalArgumentException("illegal payload");
        L19:
            throw new IllegalArgumentException("illegal method");
        L21:
            throw new IllegalArgumentException("illegal service");
        L23:
            throw new IllegalArgumentException("illegal channelId");
        }

        public b d(long r10) {
            this.f1360c = r10;
            return this;
        }

        public b e(int r10) {
            this.f1362e = r10;
            return this;
        }

        public b f(byte[] r10) {
            this.f1363f = r10;
            return this;
        }

        public b g(String r10) {
            this.f1365h = r10;
            return this;
        }

        public b h(String r10) {
            this.f1364g = r10;
            return this;
        }

        public b i(int r10) {
            this.f1361d = r10;
            return this;
        }
    }

    static {
        CREATOR = new a();
        EMPTY = new WsChannelMsg();
    }

    @Deprecated
    public WsChannelMsg() {
        this.state = MessageAckEvent.MessageState.Default;
    }

    public WsChannelMsg(int r10, int r11, int r12, String r13, boolean r14) {
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = r10;
        this.service = r11;
        this.method = r12;
        this.uuid = r13;
        this.isAckMsg = r14;
    }

    public WsChannelMsg(int r10, long r11, long r12, int r13, int r14, List<MsgHeader> r15, String r16, String r17, byte[] r18, ComponentName r19) {
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = r10;
        this.seqId = r11;
        this.logId = r12;
        this.service = r13;
        this.method = r14;
        this.msgHeaders = r15;
        this.payloadEncoding = r16;
        this.payloadType = r17;
        this.payload = r18;
        this.replayToComponentName = r19;
    }

    protected WsChannelMsg(Parcel r10) {
        this.state = MessageAckEvent.MessageState.Default;
        this.seqId = r10.readLong();
        this.logId = r10.readLong();
        this.service = r10.readInt();
        this.method = r10.readInt();
        this.msgHeaders = r10.createTypedArrayList(MsgHeader.CREATOR);
        this.payloadEncoding = r10.readString();
        this.payloadType = r10.readString();
        this.payload = r10.createByteArray();
        this.replayToComponentName = (ComponentName) r10.readParcelable(ComponentName.class.getClassLoader());
        this.channelId = r10.readInt();
        this.uuid = r10.readString();
        if (r10.readByte() == 0) goto L5;
        boolean r11 = true;
    L6:
        this.isAckMsg = r11;
        this.state = MessageAckEvent.MessageState.valueOf(r10.readInt());
        this.newMsgTimeHolder = (NewMsgTimeHolder) r10.readParcelable(NewMsgTimeHolder.class.getClassLoader());
        this.logInfo = r10.readString();
        this.serverTiming = r10.readString();
        this.msgId = r10.readString();
        return;
    L5:
        r11 = false;
        goto L6
    }

    protected WsChannelMsg(WsChannelMsg r10) {
        this.state = MessageAckEvent.MessageState.Default;
        setSeqId(r10.getSeqId());
        setLogId(r10.getLogId());
        setService(r10.getService());
        setMethod(r10.getMethod());
        setMsgHeaders(r10.getMsgHeaders());
        setPayload(r10.getPayload());
        setPayloadEncoding(r10.getPayloadEncoding());
        setPayloadType(r10.getPayloadType());
        setChannelId(r10.getChannelId());
        setReplayToComponentName(r10.getReplayToComponentName());
        setNewMsgTimeHolder(r10.getNewMsgTimeHolder());
        setIsAckMsg(r10.isAckMsg());
        setUUID(r10.getUUID());
        setState(r10.getState());
        setLogInfo(r10.logInfo);
        setServerTiming(r10.serverTiming);
        setMsgId(r10.msgId);
    }

    public void addHeader(String r10, String r11) {
        MsgHeader r12 = new MsgHeader();
        r12.setKey(r10);
        r12.setValue(r11);
        this.msgHeaders.add(r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public long getLogId() {
        return this.logId;
    }

    public String getLogInfo() {
        return this.logInfo;
    }

    public int getMethod() {
        return this.method;
    }

    public List<MsgHeader> getMsgHeaders() {
        return this.msgHeaders;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public NewMsgTimeHolder getNewMsgTimeHolder() {
        return this.newMsgTimeHolder;
    }

    public byte[] getPayload() {
        if (this.payload != null) goto L6;
        this.payload = new byte[1];
    L6:
        return this.payload;
    }

    public String getPayloadEncoding() {
        return this.payloadEncoding;
    }

    public String getPayloadType() {
        return this.payloadType;
    }

    public ComponentName getReplayToComponentName() {
        return this.replayToComponentName;
    }

    public long getSeqId() {
        return this.seqId;
    }

    public String getServerTiming() {
        return this.serverTiming;
    }

    public int getService() {
        return this.service;
    }

    public MessageAckEvent.MessageState getState() {
        return this.state;
    }

    @Nullable
    public String getUUID() {
        return this.uuid;
    }

    public boolean isAckMsg() {
        return this.isAckMsg;
    }

    public void setChannelId(int r10) {
        this.channelId = r10;
    }

    public void setIsAckMsg(boolean r10) {
        this.isAckMsg = r10;
    }

    public void setLogId(long r10) {
        this.logId = r10;
    }

    public void setLogInfo(String r10) {
        this.logInfo = r10;
    }

    public void setMethod(int r10) {
        this.method = r10;
    }

    public void setMsgHeaders(List<MsgHeader> r10) {
        this.msgHeaders = r10;
    }

    public void setMsgId(String r10) {
        this.msgId = r10;
    }

    public void setNewMsgTimeHolder(NewMsgTimeHolder r10) {
        this.newMsgTimeHolder = r10;
    }

    public void setPayload(byte[] r10) {
        this.payload = r10;
    }

    public void setPayloadEncoding(String r10) {
        this.payloadEncoding = r10;
    }

    public void setPayloadType(String r10) {
        this.payloadType = r10;
    }

    public void setReplayToComponentName(ComponentName r10) {
        this.replayToComponentName = r10;
    }

    public void setSeqId(long r10) {
        this.seqId = r10;
    }

    public void setServerTiming(String r10) {
        this.serverTiming = r10;
    }

    public void setService(int r10) {
        this.service = r10;
    }

    public void setState(MessageAckEvent.MessageState r10) {
        this.state = r10;
    }

    public void setUUID(String r10) {
        this.uuid = r10;
    }

    @NonNull
    public Map<String, String> toMap() {
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("seqId", String.valueOf(this.seqId));
        r10.put("logId", String.valueOf(this.logId));
        r10.put("service", String.valueOf(this.service));
        r10.put(EnsureReportData.METHOD, String.valueOf(this.method));
        r10.put("payloadEncoding", this.payloadEncoding);
        r10.put("payloadType", this.payloadType);
        r10.put(WsConstants.KEY_PAYLOAD_MD5, c.b(MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(this.payload), ""));     // Catch: NoSuchAlgorithmException -> L5
    L7:
        r10.put("channelId", String.valueOf(this.channelId));
        Iterator<MsgHeader> r11 = this.msgHeaders.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        MsgHeader r12 = r11.next();
        r10.put(r12.key, r12.value);
        goto L9
    L11:
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @NonNull
    public String toString() {
        return "WsChannelMsg{, channelId = " + this.channelId + ", logId=" + this.logId + ", service=" + this.service + ", method=" + this.method + ", msgHeaders=" + this.msgHeaders + ", payloadEncoding='" + this.payloadEncoding + "', payloadType='" + this.payloadType + "', payload=" + Arrays.toString(this.payload) + ", replayToComponentName=" + this.replayToComponentName + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeLong(this.seqId);
        r10.writeLong(this.logId);
        r10.writeInt(this.service);
        r10.writeInt(this.method);
        r10.writeTypedList(this.msgHeaders);
        r10.writeString(this.payloadEncoding);
        r10.writeString(this.payloadType);
        r10.writeByteArray(this.payload);
        r10.writeParcelable(this.replayToComponentName, r11);
        r10.writeInt(this.channelId);
        r10.writeString(this.uuid);
        r10.writeByte(this.isAckMsg ? 1 : 0);
        r10.writeInt(this.state.getTypeValue());
        r10.writeParcelable(this.newMsgTimeHolder, r11);
        r10.writeString(this.logInfo);
        r10.writeString(this.serverTiming);
        r10.writeString(this.msgId);
    }
}
