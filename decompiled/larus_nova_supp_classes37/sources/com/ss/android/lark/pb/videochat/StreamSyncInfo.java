package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class StreamSyncInfo extends Message<StreamSyncInfo, Builder> {
    public static final ProtoAdapter<StreamSyncInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SIStreamSyncInfo msiInfo;

    public static final class Builder extends Message.Builder<StreamSyncInfo, Builder> {
        public SIStreamSyncInfo msiInfo;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public StreamSyncInfo m3194build() {
            return new StreamSyncInfo(this.msiInfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3194build();
        }

        public Builder siInfo(SIStreamSyncInfo r1) {
            this.msiInfo = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_StreamSyncInfo extends ProtoAdapter<StreamSyncInfo> {
        public ProtoAdapter_StreamSyncInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, StreamSyncInfo.class);
        }

        public StreamSyncInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.siInfo((SIStreamSyncInfo) SIStreamSyncInfo.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m3194build();
        }

        public int encodedSize(StreamSyncInfo r4) {
            SIStreamSyncInfo r0 = r4.msiInfo;
            if (r0 == null) goto L5;
            int r1 = SIStreamSyncInfo.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3195decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((StreamSyncInfo) r1);
        }

        public void encode(ProtoWriter r4, StreamSyncInfo r5) throws IOException {
            SIStreamSyncInfo r0 = r5.msiInfo;
            if (r0 == null) goto L5;
            SIStreamSyncInfo.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (StreamSyncInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StreamSyncInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3193newBuilder() {
        Builder r0 = new Builder();
        r0.msiInfo = this.msiInfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return StreamSyncInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3193newBuilder();
    }

    public StreamSyncInfo(SIStreamSyncInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public StreamSyncInfo(SIStreamSyncInfo r2, ByteString r3) {
        super(ADAPTER, r3);
        this.msiInfo = r2;
    }
}
