package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.c.c;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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

        static {
            CREATOR = new AnonymousClass1();
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

        public void setKey(String r1) {
            this.key = r1;
        }

        public void setValue(String r1) {
            this.value = r1;
        }

        public String toString() {
            return "MsgHeader{key='" + this.key + "', value='" + this.value + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.key);
            r1.writeString(this.value);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f2147b;
        private long c;
        private int d;
        private int e;
        private byte[] f;
        private String g;
        private String h;
        private long i;
        private ComponentName j;

        public a(int r2) {
            this.f2147b = new HashMap();
            this.g = "";
            this.h = "";
            this.f2146a = r2;
        }

        public static a a(int r1) {
            return new a(r1);
        }

        public a a(long r1) {
            this.c = r1;
            return this;
        }

        public a a(String r1) {
            this.g = r1;
            return this;
        }

        public a a(String r2, String r3) {
            this.f2147b.put(r2, r3);
            return this;
        }

        public a a(byte[] r1) {
            this.f = r1;
            return this;
        }

        public WsChannelMsg a() {
            if (this.f2146a <= 0) goto L23;
            if (this.d < 0) goto L21;
            if (this.e <= 0) goto L19;
            if (this.f == null) goto L17;
            ArrayList r9 = new ArrayList();
            Iterator<Map.Entry<String, String>> r0 = this.f2147b.entrySet().iterator();
        L12:
            if (r0.hasNext() == false) goto L15;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            MsgHeader r2 = new MsgHeader();
            r2.setKey((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"));
            r2.setValue((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin"));
            r9.add(r2);
            goto L12
        L15:
            return new WsChannelMsg(this.f2146a, this.i, this.c, this.d, this.e, r9, this.h, this.g, this.f, this.j);
        L17:
            throw new IllegalArgumentException("illegal payload");
        L19:
            throw new IllegalArgumentException("illegal method");
        L21:
            throw new IllegalArgumentException("illegal service");
        L23:
            throw new IllegalArgumentException("illegal channelId");
        }

        public a b(int r1) {
            this.d = r1;
            return this;
        }

        public a b(String r1) {
            this.h = r1;
            return this;
        }

        public a c(int r1) {
            this.e = r1;
            return this;
        }
    }

    static {
        CREATOR = new AnonymousClass1();
        EMPTY = new WsChannelMsg();
    }

    @Deprecated
    public WsChannelMsg() {
        this.state = MessageAckEvent.MessageState.Default;
    }

    public WsChannelMsg(int r2, int r3, int r4, String r5, boolean r6) {
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = r2;
        this.service = r3;
        this.method = r4;
        this.uuid = r5;
        this.isAckMsg = r6;
    }

    public WsChannelMsg(int r3, long r4, long r6, int r8, int r9, List<MsgHeader> r10, String r11, String r12, byte[] r13, ComponentName r14) {
        List<MsgHeader> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = r3;
        this.seqId = r4;
        this.logId = r6;
        this.service = r8;
        this.method = r9;
        this.msgHeaders = r15;
        this.payloadEncoding = r11;
        this.payloadType = r12;
        this.payload = r13;
        this.replayToComponentName = r14;
    }

    public WsChannelMsg(Parcel r4) {
        this.state = MessageAckEvent.MessageState.Default;
        this.seqId = r4.readLong();
        this.logId = r4.readLong();
        this.service = r4.readInt();
        this.method = r4.readInt();
        this.msgHeaders = r4.createTypedArrayList(MsgHeader.CREATOR);
        this.payloadEncoding = r4.readString();
        this.payloadType = r4.readString();
        this.payload = r4.createByteArray();
        this.replayToComponentName = (ComponentName) ZeusTransformUtils.preCheckCast(r4.readParcelable(ComponentName.class.getClassLoader()), ComponentName.class, "com.obric.memorydata.plugin");
        this.channelId = r4.readInt();
        this.uuid = r4.readString();
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.isAckMsg = r0;
        this.state = MessageAckEvent.MessageState.valueOf(r4.readInt());
        this.newMsgTimeHolder = (NewMsgTimeHolder) ZeusTransformUtils.preCheckCast(r4.readParcelable(NewMsgTimeHolder.class.getClassLoader()), NewMsgTimeHolder.class, "com.obric.memorydata.plugin");
        this.logInfo = r4.readString();
        this.serverTiming = r4.readString();
        this.msgId = r4.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public WsChannelMsg(WsChannelMsg r3) {
        this.state = MessageAckEvent.MessageState.Default;
        setSeqId(r3.getSeqId());
        setLogId(r3.getLogId());
        setService(r3.getService());
        setMethod(r3.getMethod());
        setMsgHeaders(r3.getMsgHeaders());
        setPayload(r3.getPayload());
        setPayloadEncoding(r3.getPayloadEncoding());
        setPayloadType(r3.getPayloadType());
        setChannelId(r3.getChannelId());
        setReplayToComponentName(r3.getReplayToComponentName());
        setNewMsgTimeHolder(r3.getNewMsgTimeHolder());
        setIsAckMsg(r3.isAckMsg());
        setUUID(r3.getUUID());
        setState(r3.getState());
        setLogInfo(r3.logInfo);
        setServerTiming(r3.serverTiming);
        setMsgId(r3.msgId);
    }

    public void addHeader(String r2, String r3) {
        MsgHeader r0 = new MsgHeader();
        r0.setKey(r2);
        r0.setValue(r3);
        this.msgHeaders.add(r0);
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

    public String getUUID() {
        return this.uuid;
    }

    public boolean isAckMsg() {
        return this.isAckMsg;
    }

    public void setChannelId(int r1) {
        this.channelId = r1;
    }

    public void setIsAckMsg(boolean r1) {
        this.isAckMsg = r1;
    }

    public void setLogId(long r1) {
        this.logId = r1;
    }

    public void setLogInfo(String r1) {
        this.logInfo = r1;
    }

    public void setMethod(int r1) {
        this.method = r1;
    }

    public void setMsgHeaders(List<MsgHeader> r3) {
        this.msgHeaders = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setMsgId(String r1) {
        this.msgId = r1;
    }

    public void setNewMsgTimeHolder(NewMsgTimeHolder r1) {
        this.newMsgTimeHolder = r1;
    }

    public void setPayload(byte[] r1) {
        this.payload = r1;
    }

    public void setPayloadEncoding(String r1) {
        this.payloadEncoding = r1;
    }

    public void setPayloadType(String r1) {
        this.payloadType = r1;
    }

    public void setReplayToComponentName(ComponentName r1) {
        this.replayToComponentName = r1;
    }

    public void setSeqId(long r1) {
        this.seqId = r1;
    }

    public void setServerTiming(String r1) {
        this.serverTiming = r1;
    }

    public void setService(int r1) {
        this.service = r1;
    }

    public void setState(MessageAckEvent.MessageState r1) {
        this.state = r1;
    }

    public void setUUID(String r1) {
        this.uuid = r1;
    }

    public Map<String, String> toMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("seqId", String.valueOf(this.seqId));
        r0.put("logId", String.valueOf(this.logId));
        r0.put("service", String.valueOf(this.service));
        r0.put("method", String.valueOf(this.method));
        r0.put("payloadEncoding", this.payloadEncoding);
        r0.put("payloadType", this.payloadType);
        r0.put(WsConstants.KEY_PAYLOAD_MD5, c.a(MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(this.payload), ""));     // Catch: NoSuchAlgorithmException -> L5
    L7:
        r0.put("channelId", String.valueOf(this.channelId));
        Iterator<MsgHeader> r4 = this.msgHeaders.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        MsgHeader r1 = (MsgHeader) ZeusTransformUtils.preCheckCast(r4.next(), MsgHeader.class, "com.obric.memorydata.plugin");
        r0.put(r1.key, r1.value);
        goto L9
    L11:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "WsChannelMsg{, channelId = " + this.channelId + ", logId=" + this.logId + ", service=" + this.service + ", method=" + this.method + ", msgHeaders=" + this.msgHeaders + ", payloadEncoding='" + this.payloadEncoding + "', payloadType='" + this.payloadType + "', payload=" + Arrays.toString(this.payload) + ", replayToComponentName=" + this.replayToComponentName + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.seqId);
        r3.writeLong(this.logId);
        r3.writeInt(this.service);
        r3.writeInt(this.method);
        r3.writeTypedList(this.msgHeaders);
        r3.writeString(this.payloadEncoding);
        r3.writeString(this.payloadType);
        r3.writeByteArray(this.payload);
        r3.writeParcelable(this.replayToComponentName, r4);
        r3.writeInt(this.channelId);
        r3.writeString(this.uuid);
        r3.writeByte(this.isAckMsg ? 1 : 0);
        r3.writeInt(this.state.getTypeValue());
        r3.writeParcelable(this.newMsgTimeHolder, r4);
        r3.writeString(this.logInfo);
        r3.writeString(this.serverTiming);
        r3.writeString(this.msgId);
    }
}
