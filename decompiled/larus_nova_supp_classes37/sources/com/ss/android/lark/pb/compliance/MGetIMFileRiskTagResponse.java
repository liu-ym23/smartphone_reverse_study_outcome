package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MGetIMFileRiskTagResponse extends Message<MGetIMFileRiskTagResponse, Builder> {
    public static final ProtoAdapter<MGetIMFileRiskTagResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<IMFileRiskTag> mresult;

    public static final class Builder extends Message.Builder<MGetIMFileRiskTagResponse, Builder> {
        public List<IMFileRiskTag> mresult;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MGetIMFileRiskTagResponse m959build() {
            return new MGetIMFileRiskTagResponse(this.mresult, super.buildUnknownFields());
        }

        public Builder() {
            this.mresult = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m959build();
        }

        public Builder result(List<IMFileRiskTag> r1) {
            Internal.checkElementsNotNull(r1);
            this.mresult = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetIMFileRiskTagResponse extends ProtoAdapter<MGetIMFileRiskTagResponse> {
        public ProtoAdapter_MGetIMFileRiskTagResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetIMFileRiskTagResponse.class);
        }

        public MGetIMFileRiskTagResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mresult.add((IMFileRiskTag) IMFileRiskTag.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m959build();
        }

        public int encodedSize(MGetIMFileRiskTagResponse r4) {
            return IMFileRiskTag.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mresult) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m960decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MGetIMFileRiskTagResponse) r1);
        }

        public void encode(ProtoWriter r4, MGetIMFileRiskTagResponse r5) throws IOException {
            IMFileRiskTag.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mresult);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MGetIMFileRiskTagResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MGetIMFileRiskTagResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m958newBuilder() {
        Builder r0 = new Builder();
        r0.mresult = Internal.copyOf("mresult", this.mresult);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MGetIMFileRiskTagResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m958newBuilder();
    }

    public MGetIMFileRiskTagResponse(List<IMFileRiskTag> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MGetIMFileRiskTagResponse(List<IMFileRiskTag> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mresult = Internal.immutableCopyOf("mresult", r2);
    }
}
