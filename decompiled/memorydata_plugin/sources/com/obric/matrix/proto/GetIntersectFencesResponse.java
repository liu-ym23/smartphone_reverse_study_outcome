package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class GetIntersectFencesResponse extends Message<GetIntersectFencesResponse, a> {
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

    public static final class a extends Message.Builder<GetIntersectFencesResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<Fence> f8171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Double> f8172b;
        public List<Double> c;

        public a() {
            this.f8171a = Internal.newMutableList();
            this.f8172b = Internal.newMutableList();
            this.c = Internal.newMutableList();
        }

        public GetIntersectFencesResponse a() {
            return new GetIntersectFencesResponse(this.f8171a, this.f8172b, this.c, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<GetIntersectFencesResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesResponse.class);
        }

        public int a(GetIntersectFencesResponse r4) {
            return ((Fence.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.fences) + ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(2, r4.overlap_froms)) + ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(3, r4.overlap_targets)) + r4.unknownFields().size();
        }

        public GetIntersectFencesResponse a(ProtoReader r7) {
            a r6 = new a();
            long r0 = r7.beginMessage();
        L3:
            int r2 = r7.nextTag();
            if (r2 == (-1)) goto L17;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L13;
            if (r2 != 3) goto L11;
            List r3 = r6.c;
        L14:
            Object r4 = (Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r7), Double.class, "com.obric.memorydata.plugin");
        L16:
            r3.add(r4);
            goto L3
        L11:
            FieldEncoding r5 = r7.peekFieldEncoding();
            r6.addUnknownField(r2, r5, r5.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r3 = r6.f8172b;
            goto L14
        L15:
            r3 = r6.f8171a;
            r4 = (Fence) ZeusTransformUtils.preCheckCast(Fence.ADAPTER.decode(r7), Fence.class, "com.obric.memorydata.plugin");
            goto L16
        L17:
            r7.endMessage(r0);
            return r6.a();
        }

        public void a(ProtoWriter r3, GetIntersectFencesResponse r4) {
            Fence.ADAPTER.asRepeated().encodeWithTag(r3, 1, r4.fences);
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(r3, 2, r4.overlap_froms);
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(r3, 3, r4.overlap_targets);
            r3.writeBytes(r4.unknownFields());
        }

        public GetIntersectFencesResponse b(GetIntersectFencesResponse r2) {
            a r1 = r2.newBuilder();
            Internal.redactElements(r1.f8171a, Fence.ADAPTER);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetIntersectFencesResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, GetIntersectFencesResponse r4) {
            a(r3, (GetIntersectFencesResponse) ZeusTransformUtils.preCheckCast(r4, GetIntersectFencesResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(GetIntersectFencesResponse r3) {
            return a((GetIntersectFencesResponse) ZeusTransformUtils.preCheckCast(r3, GetIntersectFencesResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetIntersectFencesResponse redact(GetIntersectFencesResponse r3) {
            return b((GetIntersectFencesResponse) ZeusTransformUtils.preCheckCast(r3, GetIntersectFencesResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public GetIntersectFencesResponse(List<Fence> r3, List<Double> r4, List<Double> r5) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public GetIntersectFencesResponse(List<Fence> r3, List<Double> r4, List<Double> r5, ByteString r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r6);
        this.fences = Internal.immutableCopyOf("fences", r7);
        this.overlap_froms = Internal.immutableCopyOf("overlap_froms", r8);
        this.overlap_targets = Internal.immutableCopyOf("overlap_targets", r9);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GetIntersectFencesResponse.class) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesResponse r6 = (GetIntersectFencesResponse) ZeusTransformUtils.preCheckCast(r5, GetIntersectFencesResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.fences.equals(r6.fences) == false) goto L18;
        if (this.overlap_froms.equals(r6.overlap_froms) == false) goto L18;
        if (this.overlap_targets.equals(r6.overlap_targets) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.fences.hashCode()) * 37) + this.overlap_froms.hashCode()) * 37) + this.overlap_targets.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8171a = Internal.copyOf("fences", this.fences);
        r0.f8172b = Internal.copyOf("overlap_froms", this.overlap_froms);
        r0.c = Internal.copyOf("overlap_targets", this.overlap_targets);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<Fence> r1 = this.fences;
        if (r1 != null) goto L5;
    L7:
        List<Double> r2 = this.overlap_froms;
        if (r2 != null) goto L10;
    L12:
        List<Double> r3 = this.overlap_targets;
        if (r3 == null) goto L18;
        if (r3.isEmpty() == true) goto L18;
        r0.append(", overlap_targets=").append(this.overlap_targets);
    L18:
        return r0.replace(0, 2, "GetIntersectFencesResponse{").append('}').toString();
    L10:
        if (r2.isEmpty() == true) goto L12;
        r0.append(", overlap_froms=").append(this.overlap_froms);
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", fences=").append(this.fences);
        goto L7
    }
}
