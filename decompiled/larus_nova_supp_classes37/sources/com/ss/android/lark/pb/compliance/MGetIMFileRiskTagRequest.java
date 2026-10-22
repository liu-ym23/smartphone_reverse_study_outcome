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
public final class MGetIMFileRiskTagRequest extends Message<MGetIMFileRiskTagRequest, Builder> {
    public static final ProtoAdapter<MGetIMFileRiskTagRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> mobject_id;
    public final SourceTerminal msource_terminal;

    public static final class Builder extends Message.Builder<MGetIMFileRiskTagRequest, Builder> {
        public List<String> mobject_id;
        public SourceTerminal msource_terminal;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MGetIMFileRiskTagRequest m956build() {
            return new MGetIMFileRiskTagRequest(this.mobject_id, this.msource_terminal, super.buildUnknownFields());
        }

        public Builder() {
            this.mobject_id = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m956build();
        }

        public Builder object_id(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mobject_id = r1;
            return this;
        }

        public Builder source_terminal(SourceTerminal r1) {
            this.msource_terminal = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetIMFileRiskTagRequest extends ProtoAdapter<MGetIMFileRiskTagRequest> {
        public ProtoAdapter_MGetIMFileRiskTagRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetIMFileRiskTagRequest.class);
        }

        public MGetIMFileRiskTagRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mobject_id.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.msource_terminal = (SourceTerminal) SourceTerminal.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m956build();
        }

        public int encodedSize(MGetIMFileRiskTagRequest r5) {
            int r0 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r5.mobject_id);
            SourceTerminal r1 = r5.msource_terminal;
            if (r1 == null) goto L5;
            int r2 = SourceTerminal.ADAPTER.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m957decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MGetIMFileRiskTagRequest) r1);
        }

        public void encode(ProtoWriter r4, MGetIMFileRiskTagRequest r5) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mobject_id);
            SourceTerminal r0 = r5.msource_terminal;
            if (r0 == null) goto L5;
            SourceTerminal.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MGetIMFileRiskTagRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MGetIMFileRiskTagRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m955newBuilder() {
        Builder r0 = new Builder();
        r0.mobject_id = Internal.copyOf("mobject_id", this.mobject_id);
        r0.msource_terminal = this.msource_terminal;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MGetIMFileRiskTagRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m955newBuilder();
    }

    public MGetIMFileRiskTagRequest(List<String> r2, SourceTerminal r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public MGetIMFileRiskTagRequest(List<String> r2, SourceTerminal r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mobject_id = Internal.immutableCopyOf("mobject_id", r2);
        this.msource_terminal = r3;
    }
}
