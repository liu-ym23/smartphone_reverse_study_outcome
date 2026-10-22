package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullProductGuideRequest extends Message<PullProductGuideRequest, Builder> {
    public static final ProtoAdapter<PullProductGuideRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final GuideScene mscene;

    public static final class Builder extends Message.Builder<PullProductGuideRequest, Builder> {
        public GuideScene mscene;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullProductGuideRequest m1730build() {
            return new PullProductGuideRequest(this.mscene, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1730build();
        }

        public Builder scene(GuideScene r1) {
            this.mscene = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullProductGuideRequest extends ProtoAdapter<PullProductGuideRequest> {
        public ProtoAdapter_PullProductGuideRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullProductGuideRequest.class);
        }

        public PullProductGuideRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mscene = (GuideScene) GuideScene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L12:
            r9.endMessage(r1);
            return r0.m1730build();
        }

        public int encodedSize(PullProductGuideRequest r4) {
            GuideScene r0 = r4.mscene;
            if (r0 == null) goto L5;
            int r1 = GuideScene.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1731decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullProductGuideRequest) r1);
        }

        public void encode(ProtoWriter r4, PullProductGuideRequest r5) throws IOException {
            GuideScene r0 = r5.mscene;
            if (r0 == null) goto L5;
            GuideScene.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullProductGuideRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullProductGuideRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1729newBuilder() {
        Builder r0 = new Builder();
        r0.mscene = this.mscene;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullProductGuideRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1729newBuilder();
    }

    public PullProductGuideRequest(GuideScene r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullProductGuideRequest(GuideScene r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mscene = r2;
    }
}
