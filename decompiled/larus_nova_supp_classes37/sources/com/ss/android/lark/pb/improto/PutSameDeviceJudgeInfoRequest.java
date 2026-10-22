package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutSameDeviceJudgeInfoRequest extends Message<PutSameDeviceJudgeInfoRequest, Builder> {
    public static final ProtoAdapter<PutSameDeviceJudgeInfoRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SameDeviceJudgeItem mitem;

    public static final class Builder extends Message.Builder<PutSameDeviceJudgeInfoRequest, Builder> {
        public SameDeviceJudgeItem mitem;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutSameDeviceJudgeInfoRequest m1763build() {
            SameDeviceJudgeItem r0 = this.mitem;
            if (r0 == null) goto L7;
            return new PutSameDeviceJudgeInfoRequest(this.mitem, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mitem"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1763build();
        }

        public Builder item(SameDeviceJudgeItem r1) {
            this.mitem = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSameDeviceJudgeInfoRequest extends ProtoAdapter<PutSameDeviceJudgeInfoRequest> {
        public ProtoAdapter_PutSameDeviceJudgeInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSameDeviceJudgeInfoRequest.class);
        }

        public PutSameDeviceJudgeInfoRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mitem = (SameDeviceJudgeItem) SameDeviceJudgeItem.ADAPTER.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1763build();
        }

        public int encodedSize(PutSameDeviceJudgeInfoRequest r4) {
            return SameDeviceJudgeItem.ADAPTER.encodedSizeWithTag(1, r4.mitem) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1764decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutSameDeviceJudgeInfoRequest) r1);
        }

        public void encode(ProtoWriter r4, PutSameDeviceJudgeInfoRequest r5) throws IOException {
            SameDeviceJudgeItem.ADAPTER.encodeWithTag(r4, 1, r5.mitem);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutSameDeviceJudgeInfoRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSameDeviceJudgeInfoRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1762newBuilder() {
        Builder r0 = new Builder();
        r0.mitem = this.mitem;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutSameDeviceJudgeInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1762newBuilder();
    }

    public PutSameDeviceJudgeInfoRequest(SameDeviceJudgeItem r2) {
        this(r2, ByteString.EMPTY);
    }

    public PutSameDeviceJudgeInfoRequest(SameDeviceJudgeItem r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mitem = r2;
    }
}
