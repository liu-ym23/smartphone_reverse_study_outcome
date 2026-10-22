package com.ss.ugc.live.sdk.msg.data;

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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class HeartbeatPacket extends AndroidMessage<HeartbeatPacket, Builder> {
    public static final ProtoAdapter<HeartbeatPacket> ADAPTER = null;
    public static final Parcelable.Creator<HeartbeatPacket> CREATOR = null;
    public static final Long DEFAULT_ROOMID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long roomID;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.HeartbeatPacket$WrdsKeyVersion#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<WrdsKeyVersion> wrdsKeyVersions;

    public static final class Builder extends Message.Builder<HeartbeatPacket, Builder> {
        public Long roomID;
        public List<WrdsKeyVersion> wrdsKeyVersions;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public HeartbeatPacket m1673build() {
            return new HeartbeatPacket(this.wrdsKeyVersions, this.roomID, super.buildUnknownFields());
        }

        public Builder() {
            this.roomID = 0L;
            this.wrdsKeyVersions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1673build();
        }

        public Builder roomID(Long r1) {
            this.roomID = r1;
            return this;
        }

        public Builder wrdsKeyVersions(List<WrdsKeyVersion> r1) {
            Internal.checkElementsNotNull(r1);
            this.wrdsKeyVersions = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_HeartbeatPacket extends ProtoAdapter<HeartbeatPacket> {
        public ProtoAdapter_HeartbeatPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, HeartbeatPacket.class);
        }

        public HeartbeatPacket decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.wrdsKeyVersions.add((WrdsKeyVersion) WrdsKeyVersion.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.roomID((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1673build();
        }

        public int encodedSize(HeartbeatPacket r5) {
            return (WrdsKeyVersion.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.wrdsKeyVersions) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.roomID)) + r5.unknownFields().size();
        }

        public HeartbeatPacket redact(HeartbeatPacket r3) {
            Builder r4 = r3.m1672newBuilder();
            Internal.redactElements(r4.wrdsKeyVersions, WrdsKeyVersion.ADAPTER);
            r4.clearUnknownFields();
            return r4.m1673build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1674decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((HeartbeatPacket) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((HeartbeatPacket) r1);
        }

        public void encode(ProtoWriter r4, HeartbeatPacket r5) throws IOException {
            WrdsKeyVersion.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.wrdsKeyVersions);
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.roomID);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (HeartbeatPacket) r2);
        }
    }

    public static final class WrdsKeyVersion extends AndroidMessage<WrdsKeyVersion, Builder> {
        public static final ProtoAdapter<WrdsKeyVersion> ADAPTER = null;
        public static final Parcelable.Creator<WrdsKeyVersion> CREATOR = null;
        public static final String DEFAULT_SYNCKEY = "";
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        public final String syncKey;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
        public final Long version;

        public static final class Builder extends Message.Builder<WrdsKeyVersion, Builder> {
            public String syncKey;
            public Long version;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public WrdsKeyVersion m1676build() {
                return new WrdsKeyVersion(this.syncKey, this.version, super.buildUnknownFields());
            }

            public Builder() {
                this.syncKey = "";
                this.version = 0L;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1676build();
            }

            public Builder syncKey(String r1) {
                this.syncKey = r1;
                return this;
            }

            public Builder version(Long r1) {
                this.version = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_WrdsKeyVersion extends ProtoAdapter<WrdsKeyVersion> {
            public ProtoAdapter_WrdsKeyVersion() {
                super(FieldEncoding.LENGTH_DELIMITED, WrdsKeyVersion.class);
            }

            public WrdsKeyVersion decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.syncKey((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.version((Long) ProtoAdapter.INT64.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1676build();
            }

            public int encodedSize(WrdsKeyVersion r5) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.syncKey) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.version)) + r5.unknownFields().size();
            }

            public WrdsKeyVersion redact(WrdsKeyVersion r1) {
                Builder r2 = r1.m1675newBuilder();
                r2.clearUnknownFields();
                return r2.m1676build();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1677decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((WrdsKeyVersion) r1);
            }

            public /* bridge */ /* synthetic */ Object redact(Object r1) {
                return redact((WrdsKeyVersion) r1);
            }

            public void encode(ProtoWriter r4, WrdsKeyVersion r5) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.syncKey);
                ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.version);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (WrdsKeyVersion) r2);
            }
        }

        static {
            ProtoAdapter_WrdsKeyVersion r0 = new ProtoAdapter_WrdsKeyVersion();
            ADAPTER = r0;
            CREATOR = AndroidMessage.newCreator(r0);
            DEFAULT_VERSION = 0L;
        }

        public int hashCode() {
            int r0 = ((Message) this).hashCode;
            if (r0 != 0) goto L13;
            int r1 = unknownFields().hashCode() * 37;
            String r2 = this.syncKey;
            int r3 = 0;
            if (r2 == null) goto L7;
            int r4 = r2.hashCode();
        L8:
            int r5 = (r1 + r4) * 37;
            Long r6 = this.version;
            if (r6 == null) goto L11;
            r3 = r6.hashCode();
        L11:
            int r7 = r5 + r3;
            ((Message) this).hashCode = r7;
            return r7;
        L7:
            r4 = 0;
            goto L8
        L13:
            return r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1675newBuilder() {
            Builder r0 = new Builder();
            r0.syncKey = this.syncKey;
            r0.version = this.version;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.syncKey == null) goto L6;
            r0.append(", syncKey=");
            r0.append(this.syncKey);
        L6:
            if (this.version == null) goto L8;
            r0.append(", version=");
            r0.append(this.version);
        L8:
            StringBuilder r1 = r0.replace(0, 2, "WrdsKeyVersion{");
            r1.append('}');
            return r1.toString();
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1675newBuilder();
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof WrdsKeyVersion) == true) goto L8;
            return false;
        L8:
            WrdsKeyVersion r6 = (WrdsKeyVersion) r5;
            if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
        L15:
            return false;
        L11:
            if (Internal.equals(this.syncKey, r6.syncKey) == false) goto L15;
            if (Internal.equals(this.version, r6.version) == false) goto L15;
            return true;
        }

        public WrdsKeyVersion(String r2, Long r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public WrdsKeyVersion(String r2, Long r3, ByteString r4) {
            super(ADAPTER, r4);
            this.syncKey = r2;
            this.version = r3;
        }
    }

    static {
        ProtoAdapter_HeartbeatPacket r0 = new ProtoAdapter_HeartbeatPacket();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_ROOMID = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = ((unknownFields().hashCode() * 37) + this.wrdsKeyVersions.hashCode()) * 37;
        Long r2 = this.roomID;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = r1 + r3;
        ((Message) this).hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1672newBuilder() {
        Builder r0 = new Builder();
        r0.wrdsKeyVersions = Internal.copyOf("wrdsKeyVersions", this.wrdsKeyVersions);
        r0.roomID = this.roomID;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<WrdsKeyVersion> r1 = this.wrdsKeyVersions;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", wrdsKeyVersions=");
        r0.append(this.wrdsKeyVersions);
    L8:
        if (this.roomID == null) goto L10;
        r0.append(", roomID=");
        r0.append(this.roomID);
    L10:
        StringBuilder r2 = r0.replace(0, 2, "HeartbeatPacket{");
        r2.append('}');
        return r2.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1672newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof HeartbeatPacket) == true) goto L8;
        return false;
    L8:
        HeartbeatPacket r6 = (HeartbeatPacket) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.wrdsKeyVersions.equals(r6.wrdsKeyVersions) == false) goto L15;
        if (Internal.equals(this.roomID, r6.roomID) == false) goto L15;
        return true;
    }

    public HeartbeatPacket(List<WrdsKeyVersion> r2, Long r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public HeartbeatPacket(List<WrdsKeyVersion> r2, Long r3, ByteString r4) {
        super(ADAPTER, r4);
        this.wrdsKeyVersions = Internal.immutableCopyOf("wrdsKeyVersions", r2);
        this.roomID = r3;
    }
}
