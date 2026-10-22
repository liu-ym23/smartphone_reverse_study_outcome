package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class GetIntersectFencesResponse extends Message<GetIntersectFencesResponse, a> {
    public static final ProtoAdapter<GetIntersectFencesResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    @c("fences")
    public final List<Fence> fences;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    @c("overlap_froms")
    public final List<Double> overlap_froms;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 3)
    @c("overlap_targets")
    public final List<Double> overlap_targets;

    public static final class a extends Message.Builder<GetIntersectFencesResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<Fence> f5959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Double> f5960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Double> f5961c;

        public a() {
            this.f5959a = Internal.newMutableList();
            this.f5960b = Internal.newMutableList();
            this.f5961c = Internal.newMutableList();
        }

        public GetIntersectFencesResponse a() {
            return new GetIntersectFencesResponse(this.f5959a, this.f5960b, this.f5961c, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<GetIntersectFencesResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesResponse.class);
        }

        public GetIntersectFencesResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L17;
            if (r13 == 1) goto L15;
            if (r13 == 2) goto L13;
            if (r13 != 3) goto L11;
            List r14 = r11.f5961c;
        L14:
            Object r15 = (Double) ProtoAdapter.DOUBLE.decode(r10);
        L16:
            r14.add(r15);
            goto L3
        L11:
            FieldEncoding r16 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r16, r16.rawProtoAdapter().decode(r10));
            goto L3
        L13:
            r14 = r11.f5960b;
            goto L14
        L15:
            r14 = r11.f5959a;
            r15 = (Fence) Fence.ADAPTER.decode(r10);
            goto L16
        L17:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, GetIntersectFencesResponse r11) {
            Fence.ADAPTER.asRepeated().encodeWithTag(r10, 1, r11.fences);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            r12.asRepeated().encodeWithTag(r10, 2, r11.overlap_froms);
            r12.asRepeated().encodeWithTag(r10, 3, r11.overlap_targets);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(GetIntersectFencesResponse r10) {
            int r11 = Fence.ADAPTER.asRepeated().encodedSizeWithTag(1, r10.fences);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            return ((r11 + r12.asRepeated().encodedSizeWithTag(2, r10.overlap_froms)) + r12.asRepeated().encodedSizeWithTag(3, r10.overlap_targets)) + r10.unknownFields().size();
        }

        public GetIntersectFencesResponse d(GetIntersectFencesResponse r10) {
            a r11 = r10.newBuilder();
            Internal.redactElements(r11.f5959a, Fence.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, GetIntersectFencesResponse r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIntersectFencesResponse r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse redact(GetIntersectFencesResponse r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public GetIntersectFencesResponse(List<Fence> r10, List<Double> r11, List<Double> r12) {
        this(r10, r11, r12, ByteString.EMPTY);
    }

    public GetIntersectFencesResponse(List<Fence> r10, List<Double> r11, List<Double> r12, ByteString r13) {
        super(ADAPTER, r13);
        this.fences = Internal.immutableCopyOf("fences", r10);
        this.overlap_froms = Internal.immutableCopyOf("overlap_froms", r11);
        this.overlap_targets = Internal.immutableCopyOf("overlap_targets", r12);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetIntersectFencesResponse) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesResponse r11 = (GetIntersectFencesResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L18;
        if (this.fences.equals(r11.fences) == false) goto L18;
        if (this.overlap_froms.equals(r11.overlap_froms) == false) goto L18;
        if (this.overlap_targets.equals(r11.overlap_targets) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (((((unknownFields().hashCode() * 37) + this.fences.hashCode()) * 37) + this.overlap_froms.hashCode()) * 37) + this.overlap_targets.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f5959a = Internal.copyOf("fences", this.fences);
        r10.f5960b = Internal.copyOf("overlap_froms", this.overlap_froms);
        r10.f5961c = Internal.copyOf("overlap_targets", this.overlap_targets);
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        List<Fence> r11 = this.fences;
        if (r11 != null) goto L5;
    L7:
        List<Double> r12 = this.overlap_froms;
        if (r12 != null) goto L10;
    L12:
        List<Double> r13 = this.overlap_targets;
        if (r13 != null) goto L15;
    L17:
        StringBuilder r14 = r10.replace(0, 2, "GetIntersectFencesResponse{");
        r14.append('}');
        return r14.toString();
    L15:
        if (r13.isEmpty() == true) goto L17;
        r10.append(", overlap_targets=");
        r10.append(this.overlap_targets);
        goto L17
    L10:
        if (r12.isEmpty() == true) goto L12;
        r10.append(", overlap_froms=");
        r10.append(this.overlap_froms);
        goto L12
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.append(", fences=");
        r10.append(this.fences);
        goto L7
    }
}
