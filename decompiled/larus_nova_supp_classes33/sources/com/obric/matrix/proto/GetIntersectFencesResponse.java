package com.obric.matrix.proto;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
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

        public GetIntersectFencesResponse build() {
            return new GetIntersectFencesResponse(this.fences, this.overlap_froms, this.overlap_targets, super.buildUnknownFields());
        }

        public Builder() {
            this.fences = Internal.newMutableList();
            this.overlap_froms = Internal.newMutableList();
            this.overlap_targets = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m96build() {
            return build();
        }

        public Builder fences(List<Fence> r1) {
            Internal.checkElementsNotNull(r1);
            this.fences = r1;
            return this;
        }

        public Builder overlap_froms(List<Double> r1) {
            Internal.checkElementsNotNull(r1);
            this.overlap_froms = r1;
            return this;
        }

        public Builder overlap_targets(List<Double> r1) {
            Internal.checkElementsNotNull(r1);
            this.overlap_targets = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetIntersectFencesResponse extends ProtoAdapter<GetIntersectFencesResponse> {
        public ProtoAdapter_GetIntersectFencesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesResponse.class);
        }

        public GetIntersectFencesResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.fences.add((Fence) Fence.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.overlap_froms.add((Double) ProtoAdapter.DOUBLE.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.overlap_targets.add((Double) ProtoAdapter.DOUBLE.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GetIntersectFencesResponse r6) {
            int r0 = Fence.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.fences);
            ProtoAdapter r1 = ProtoAdapter.DOUBLE;
            return ((r0 + r1.asRepeated().encodedSizeWithTag(2, r6.overlap_froms)) + r1.asRepeated().encodedSizeWithTag(3, r6.overlap_targets)) + r6.unknownFields().size();
        }

        public GetIntersectFencesResponse redact(GetIntersectFencesResponse r3) {
            Builder r4 = r3.newBuilder();
            Internal.redactElements(r4.fences, Fence.ADAPTER);
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m97decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetIntersectFencesResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((GetIntersectFencesResponse) r1);
        }

        public void encode(ProtoWriter r5, GetIntersectFencesResponse r6) throws IOException {
            Fence.ADAPTER.asRepeated().encodeWithTag(r5, 1, r6.fences);
            ProtoAdapter r0 = ProtoAdapter.DOUBLE;
            r0.asRepeated().encodeWithTag(r5, 2, r6.overlap_froms);
            r0.asRepeated().encodeWithTag(r5, 3, r6.overlap_targets);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetIntersectFencesResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetIntersectFencesResponse();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.fences.hashCode()) * 37) + this.overlap_froms.hashCode()) * 37) + this.overlap_targets.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.fences = Internal.copyOf("fences", this.fences);
        r0.overlap_froms = Internal.copyOf("overlap_froms", this.overlap_froms);
        r0.overlap_targets = Internal.copyOf("overlap_targets", this.overlap_targets);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<Fence> r1 = this.fences;
        if (r1 != null) goto L5;
    L7:
        List<Double> r2 = this.overlap_froms;
        if (r2 != null) goto L10;
    L12:
        List<Double> r3 = this.overlap_targets;
        if (r3 != null) goto L15;
    L17:
        StringBuilder r4 = r0.replace(0, 2, "GetIntersectFencesResponse{");
        r4.append('}');
        return r4.toString();
    L15:
        if (r3.isEmpty() == true) goto L17;
        r0.append(", overlap_targets=");
        r0.append(this.overlap_targets);
        goto L17
    L10:
        if (r2.isEmpty() == true) goto L12;
        r0.append(", overlap_froms=");
        r0.append(this.overlap_froms);
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", fences=");
        r0.append(this.fences);
        goto L7
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m95newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetIntersectFencesResponse) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesResponse r6 = (GetIntersectFencesResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.fences.equals(r6.fences) == false) goto L17;
        if (this.overlap_froms.equals(r6.overlap_froms) == false) goto L17;
        if (this.overlap_targets.equals(r6.overlap_targets) == false) goto L17;
        return true;
    }

    public GetIntersectFencesResponse(List<Fence> r2, List<Double> r3, List<Double> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GetIntersectFencesResponse(List<Fence> r2, List<Double> r3, List<Double> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.fences = Internal.immutableCopyOf("fences", r2);
        this.overlap_froms = Internal.immutableCopyOf("overlap_froms", r3);
        this.overlap_targets = Internal.immutableCopyOf("overlap_targets", r4);
    }
}
