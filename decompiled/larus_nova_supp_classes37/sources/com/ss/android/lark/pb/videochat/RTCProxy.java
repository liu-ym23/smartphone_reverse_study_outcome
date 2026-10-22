package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RTCProxy extends Message<RTCProxy, Builder> {
    public static final ProtoAdapter<RTCProxy> ADAPTER = null;
    public static final String DEFAULT_PASSPORT = "";
    public static final String DEFAULT_PROXY_IP = "";
    public static final Long DEFAULT_PROXY_PORT = null;
    public static final Boolean DEFAULT_STATUS = null;
    public static final String DEFAULT_USER_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mpassport;
    public final String mproxy_ip;
    public final Long mproxy_port;
    public final ProxyType mproxy_type;
    public final Boolean mstatus;
    public final String muser_name;

    public static final class Builder extends Message.Builder<RTCProxy, Builder> {
        public String mpassport;
        public String mproxy_ip;
        public Long mproxy_port;
        public ProxyType mproxy_type;
        public Boolean mstatus;
        public String muser_name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RTCProxy m3176build() {
            Boolean r0 = this.mstatus;
            if (r0 == null) goto L13;
            if (this.mproxy_type == null) goto L13;
            if (this.mproxy_ip == null) goto L13;
            if (this.mproxy_port == null) goto L13;
            return new RTCProxy(this.mstatus, this.mproxy_type, this.mproxy_ip, this.mproxy_port, this.muser_name, this.mpassport, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r0, "mstatus", this.mproxy_type, "mproxy_type", this.mproxy_ip, "mproxy_ip", this.mproxy_port, "mproxy_port"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3176build();
        }

        public Builder passport(String r1) {
            this.mpassport = r1;
            return this;
        }

        public Builder proxy_ip(String r1) {
            this.mproxy_ip = r1;
            return this;
        }

        public Builder proxy_port(Long r1) {
            this.mproxy_port = r1;
            return this;
        }

        public Builder proxy_type(ProxyType r1) {
            this.mproxy_type = r1;
            return this;
        }

        public Builder status(Boolean r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder user_name(String r1) {
            this.muser_name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RTCProxy extends ProtoAdapter<RTCProxy> {
        public ProtoAdapter_RTCProxy() {
            super(FieldEncoding.LENGTH_DELIMITED, RTCProxy.class);
        }

        public RTCProxy decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mstatus = Boolean.FALSE;
            r0.mproxy_ip = "";
            r0.mproxy_port = 0L;
            r0.muser_name = "";
            r0.mpassport = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L18;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r0.mproxy_type = (ProxyType) ProxyType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mpassport = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.muser_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mproxy_port = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            r0.mproxy_ip = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mstatus = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r1);
            return r0.m3176build();
        }

        public int encodedSize(RTCProxy r6) {
            int r0 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r6.mstatus) + ProxyType.ADAPTER.encodedSizeWithTag(2, r6.mproxy_type);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            int r2 = (r0 + r1.encodedSizeWithTag(3, r6.mproxy_ip)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r6.mproxy_port);
            String r3 = r6.muser_name;
            int r4 = 0;
            if (r3 == null) goto L5;
            int r5 = r1.encodedSizeWithTag(5, r3);
        L6:
            int r7 = r2 + r5;
            String r8 = r6.mpassport;
            if (r8 == null) goto L10;
            r4 = r1.encodedSizeWithTag(6, r8);
        L10:
            return (r7 + r4) + r6.unknownFields().size();
        L5:
            r5 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3177decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RTCProxy) r1);
        }

        public void encode(ProtoWriter r5, RTCProxy r6) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r6.mstatus);
            ProxyType.ADAPTER.encodeWithTag(r5, 2, r6.mproxy_type);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 3, r6.mproxy_ip);
            ProtoAdapter.INT64.encodeWithTag(r5, 4, r6.mproxy_port);
            String r1 = r6.muser_name;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 5, r1);
        L5:
            String r2 = r6.mpassport;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 6, r2);
        L8:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RTCProxy) r2);
        }
    }

    public static final enum ProxyType extends Enum<ProxyType> implements WireEnum {
        private static final /* synthetic */ ProxyType[] $VALUES = null;
        public static final ProtoAdapter<ProxyType> ADAPTER = null;
        public static final ProxyType HTTP = null;
        public static final ProxyType HTTPS = null;
        public static final ProxyType NONE = null;
        public static final ProxyType SOCKS5 = null;
        public static final ProxyType UNKNOWN = null;
        private final int value;

        static {
            ProxyType r0 = new ProxyType("NONE", 0, 0);
            NONE = r0;
            ProxyType r1 = new ProxyType("HTTPS", 1, 1);
            HTTPS = r1;
            ProxyType r3 = new ProxyType("SOCKS5", 2, 2);
            SOCKS5 = r3;
            ProxyType r5 = new ProxyType("HTTP", 3, 3);
            HTTP = r5;
            ProxyType r7 = new ProxyType("UNKNOWN", 4, 4);
            UNKNOWN = r7;
            $VALUES = new ProxyType[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(ProxyType.class);
        }

        public static ProxyType[] values() {
            return (ProxyType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ProxyType fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return UNKNOWN;
        L16:
            return HTTP;
        L18:
            return SOCKS5;
        L20:
            return HTTPS;
        L22:
            return NONE;
        }

        public static ProxyType valueOf(String r1) {
            return (ProxyType) a.a(ProxyType.class, r1);
        }

        private ProxyType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RTCProxy();
        DEFAULT_STATUS = Boolean.FALSE;
        DEFAULT_PROXY_PORT = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3175newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.mproxy_type = this.mproxy_type;
        r0.mproxy_ip = this.mproxy_ip;
        r0.mproxy_port = this.mproxy_port;
        r0.muser_name = this.muser_name;
        r0.mpassport = this.mpassport;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RTCProxy.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3175newBuilder();
    }

    public RTCProxy(Boolean r9, ProxyType r10, String r11, Long r12, String r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public RTCProxy(Boolean r2, ProxyType r3, String r4, Long r5, String r6, String r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mstatus = r2;
        this.mproxy_type = r3;
        this.mproxy_ip = r4;
        this.mproxy_port = r5;
        this.muser_name = r6;
        this.mpassport = r7;
    }
}
