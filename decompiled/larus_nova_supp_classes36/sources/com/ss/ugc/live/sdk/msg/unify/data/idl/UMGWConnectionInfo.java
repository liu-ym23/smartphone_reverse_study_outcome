package com.ss.ugc.live.sdk.msg.unify.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UMGWConnectionInfo extends AndroidMessage<UMGWConnectionInfo, Builder> {
    public static final ProtoAdapter<UMGWConnectionInfo> ADAPTER = null;
    public static final Parcelable.Creator<UMGWConnectionInfo> CREATOR = null;
    public static final Long DEFAULT_FETCH_INTERVAL = null;
    public static final Integer DEFAULT_FETCH_TYPE = null;
    public static final Long DEFAULT_HEARTBEAT_DURATION = null;
    public static final String DEFAULT_WSS_URL = "";
    public static final String DEFAULT_WSS_URL_V2 = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long fetch_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer fetch_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long heartbeat_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String wss_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String wss_url_v2;

    public static final class Builder extends Message.Builder<UMGWConnectionInfo, Builder> {
        public Long fetch_interval;
        public Integer fetch_type;
        public Long heartbeat_duration;
        public String wss_url;
        public String wss_url_v2;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UMGWConnectionInfo m1688build() {
            return new UMGWConnectionInfo(this.fetch_interval, this.fetch_type, this.wss_url, this.heartbeat_duration, this.wss_url_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.fetch_interval = 0L;
            this.fetch_type = 0;
            this.wss_url = "";
            this.heartbeat_duration = 0L;
            this.wss_url_v2 = "";
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1688build();
        }

        public Builder fetch_interval(Long r1) {
            this.fetch_interval = r1;
            return this;
        }

        public Builder fetch_type(Integer r1) {
            this.fetch_type = r1;
            return this;
        }

        public Builder heartbeat_duration(Long r1) {
            this.heartbeat_duration = r1;
            return this;
        }

        public Builder wss_url(String r1) {
            this.wss_url = r1;
            return this;
        }

        public Builder wss_url_v2(String r1) {
            this.wss_url_v2 = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWConnectionInfo extends ProtoAdapter<UMGWConnectionInfo> {
        public ProtoAdapter_UMGWConnectionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWConnectionInfo.class);
        }

        public UMGWConnectionInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.fetch_interval((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.fetch_type((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.wss_url((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.heartbeat_duration((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.wss_url_v2((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1688build();
        }

        public int encodedSize(UMGWConnectionInfo r6) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            int r1 = r0.encodedSizeWithTag(1, r6.fetch_interval) + ProtoAdapter.INT32.encodedSizeWithTag(2, r6.fetch_type);
            ProtoAdapter r2 = ProtoAdapter.STRING;
            return (((r1 + r2.encodedSizeWithTag(3, r6.wss_url)) + r0.encodedSizeWithTag(4, r6.heartbeat_duration)) + r2.encodedSizeWithTag(5, r6.wss_url_v2)) + r6.unknownFields().size();
        }

        public UMGWConnectionInfo redact(UMGWConnectionInfo r1) {
            Builder r2 = r1.m1687newBuilder();
            r2.clearUnknownFields();
            return r2.m1688build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1689decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UMGWConnectionInfo) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UMGWConnectionInfo) r1);
        }

        public void encode(ProtoWriter r5, UMGWConnectionInfo r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 1, r6.fetch_interval);
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r6.fetch_type);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.encodeWithTag(r5, 3, r6.wss_url);
            r0.encodeWithTag(r5, 4, r6.heartbeat_duration);
            r1.encodeWithTag(r5, 5, r6.wss_url_v2);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UMGWConnectionInfo) r2);
        }
    }

    static {
        ProtoAdapter_UMGWConnectionInfo r0 = new ProtoAdapter_UMGWConnectionInfo();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_FETCH_INTERVAL = 0L;
        DEFAULT_FETCH_TYPE = 0;
        DEFAULT_HEARTBEAT_DURATION = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.fetch_interval;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.fetch_type;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.wss_url;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.heartbeat_duration;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.wss_url_v2;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = r14 + r3;
        ((Message) this).hashCode = r16;
        return r16;
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L25:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1687newBuilder() {
        Builder r0 = new Builder();
        r0.fetch_interval = this.fetch_interval;
        r0.fetch_type = this.fetch_type;
        r0.wss_url = this.wss_url;
        r0.heartbeat_duration = this.heartbeat_duration;
        r0.wss_url_v2 = this.wss_url_v2;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.fetch_interval == null) goto L6;
        r0.append(", fetch_interval=");
        r0.append(this.fetch_interval);
    L6:
        if (this.fetch_type == null) goto L9;
        r0.append(", fetch_type=");
        r0.append(this.fetch_type);
    L9:
        if (this.wss_url == null) goto L12;
        r0.append(", wss_url=");
        r0.append(this.wss_url);
    L12:
        if (this.heartbeat_duration == null) goto L15;
        r0.append(", heartbeat_duration=");
        r0.append(this.heartbeat_duration);
    L15:
        if (this.wss_url_v2 == null) goto L17;
        r0.append(", wss_url_v2=");
        r0.append(this.wss_url_v2);
    L17:
        StringBuilder r1 = r0.replace(0, 2, "UMGWConnectionInfo{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1687newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UMGWConnectionInfo) == true) goto L8;
        return false;
    L8:
        UMGWConnectionInfo r6 = (UMGWConnectionInfo) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.fetch_interval, r6.fetch_interval) == false) goto L21;
        if (Internal.equals(this.fetch_type, r6.fetch_type) == false) goto L21;
        if (Internal.equals(this.wss_url, r6.wss_url) == false) goto L21;
        if (Internal.equals(this.heartbeat_duration, r6.heartbeat_duration) == false) goto L21;
        if (Internal.equals(this.wss_url_v2, r6.wss_url_v2) == false) goto L21;
        return true;
    }

    public UMGWConnectionInfo(Long r8, Integer r9, String r10, Long r11, String r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public UMGWConnectionInfo(Long r2, Integer r3, String r4, Long r5, String r6, ByteString r7) {
        super(ADAPTER, r7);
        this.fetch_interval = r2;
        this.fetch_type = r3;
        this.wss_url = r4;
        this.heartbeat_duration = r5;
        this.wss_url_v2 = r6;
    }
}
