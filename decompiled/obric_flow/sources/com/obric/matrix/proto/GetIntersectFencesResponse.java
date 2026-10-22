package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
import com.google.gson.annotations.SerializedName;
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

/* JADX INFO: loaded from: classes3.dex */
public final class GetIntersectFencesResponse extends Message<GetIntersectFencesResponse, Builder> {
    public static final ProtoAdapter<GetIntersectFencesResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("fences")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Fence> fences;

    @SerializedName("overlap_froms")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    public final List<Double> overlap_froms;

    @SerializedName("overlap_targets")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 3)
    public final List<Double> overlap_targets;

    public static final class Builder extends Message.Builder<GetIntersectFencesResponse, Builder> {
        public List<Fence> fences;
        public List<Double> overlap_froms;
        public List<Double> overlap_targets;

        public Builder() {
            this.fences = Internal.newMutableList();
            this.overlap_froms = Internal.newMutableList();
            this.overlap_targets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fences(List<Fence> r5) {
            Internal.checkElementsNotNull(r5);
            this.fences = r5;
            return this;
        }

        public Builder overlap_froms(List<Double> r5) {
            Internal.checkElementsNotNull(r5);
            this.overlap_froms = r5;
            return this;
        }

        public Builder overlap_targets(List<Double> r5) {
            Internal.checkElementsNotNull(r5);
            this.overlap_targets = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GetIntersectFencesResponse build() {
            return new GetIntersectFencesResponse(this.fences, this.overlap_froms, this.overlap_targets, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_GetIntersectFencesResponse extends ProtoAdapter<GetIntersectFencesResponse> {
        public ProtoAdapter_GetIntersectFencesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, GetIntersectFencesResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIntersectFencesResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse redact(GetIntersectFencesResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetIntersectFencesResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L15;
            if (r12 != 1) goto L8;
            r5.fences.add(Fence.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.overlap_froms.add(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L11;
            r5.overlap_targets.add(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L11:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, GetIntersectFencesResponse r10) throws IOException {
            Fence.ADAPTER.asRepeated().encodeWithTag(r5, 1, r10.fences);
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            r11.asRepeated().encodeWithTag(r5, 2, r10.overlap_froms);
            r11.asRepeated().encodeWithTag(r5, 3, r10.overlap_targets);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetIntersectFencesResponse r5) {
            int r10 = Fence.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.fences);
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            int r12 = r11.asRepeated().encodedSizeWithTag(2, r5.overlap_froms) + r10;
            int r13 = r11.asRepeated().encodedSizeWithTag(3, r5.overlap_targets) + r12;
            return r5.unknownFields().size() + r13;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetIntersectFencesResponse redact2(GetIntersectFencesResponse r5) {
            Builder r10 = r5.newBuilder();
            Internal.redactElements(r10.fences, Fence.ADAPTER);
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetIntersectFencesResponse();
    }

    public GetIntersectFencesResponse(List<Fence> r5, List<Double> r10, List<Double> r11) {
        this(r5, r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetIntersectFencesResponse) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesResponse r10 = (GetIntersectFencesResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L18;
        if (this.fences.equals(r10.fences) == false) goto L18;
        if (this.overlap_froms.equals(r10.overlap_froms) == false) goto L18;
        if (this.overlap_targets.equals(r10.overlap_targets) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L6;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = (this.fences.hashCode() + r10) * 37;
        int r12 = ((this.overlap_froms.hashCode() + r11) * 37) + this.overlap_targets.hashCode();
        this.hashCode = r12;
        return r12;
    L6:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        List<Fence> r10 = this.fences;
        if (r10 != null) goto L5;
    L7:
        List<Double> r11 = this.overlap_froms;
        if (r11 != null) goto L10;
    L12:
        List<Double> r12 = this.overlap_targets;
        if (r12 == null) goto L18;
        if (r12.isEmpty() == true) goto L18;
        r5.append(", overlap_targets=");
        r5.append(this.overlap_targets);
    L18:
        return a.s(r5, 0, 2, "GetIntersectFencesResponse{", '}');
    L10:
        if (r11.isEmpty() == true) goto L12;
        r5.append(", overlap_froms=");
        r5.append(this.overlap_froms);
        goto L12
    L5:
        if (r10.isEmpty() == true) goto L7;
        r5.append(", fences=");
        r5.append(this.fences);
        goto L7
    }

    public GetIntersectFencesResponse(List<Fence> r5, List<Double> r10, List<Double> r11, ByteString r12) {
        super(ADAPTER, r12);
        this.fences = Internal.immutableCopyOf("fences", r5);
        this.overlap_froms = Internal.immutableCopyOf("overlap_froms", r10);
        this.overlap_targets = Internal.immutableCopyOf("overlap_targets", r11);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.fences = Internal.copyOf("fences", this.fences);
        r5.overlap_froms = Internal.copyOf("overlap_froms", this.overlap_froms);
        r5.overlap_targets = Internal.copyOf("overlap_targets", this.overlap_targets);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
