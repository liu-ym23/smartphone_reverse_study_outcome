package com.ss.android.lark.pb.hongbao;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullHongbaoCoverListRequest extends Message<PullHongbaoCoverListRequest, Builder> {
    public static final ProtoAdapter<PullHongbaoCoverListRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<PullHongbaoCoverListRequest, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullHongbaoCoverListRequest m1742build() {
            return new PullHongbaoCoverListRequest(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1742build();
        }
    }

    public static final class ProtoAdapter_PullHongbaoCoverListRequest extends ProtoAdapter<PullHongbaoCoverListRequest> {
        public ProtoAdapter_PullHongbaoCoverListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullHongbaoCoverListRequest.class);
        }

        public PullHongbaoCoverListRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L6;
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L6:
            r7.endMessage(r1);
            return r0.m1742build();
        }

        public int encodedSize(PullHongbaoCoverListRequest r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1743decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullHongbaoCoverListRequest) r1);
        }

        public void encode(ProtoWriter r1, PullHongbaoCoverListRequest r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullHongbaoCoverListRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullHongbaoCoverListRequest();
    }

    public PullHongbaoCoverListRequest() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1741newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullHongbaoCoverListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1741newBuilder();
    }

    public PullHongbaoCoverListRequest(ByteString r2) {
        super(ADAPTER, r2);
    }
}
