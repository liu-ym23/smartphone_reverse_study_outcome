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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class GetIntersectFencesRequest extends Message<GetIntersectFencesRequest, a> {
    public static final ProtoAdapter<GetIntersectFencesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FILTER_ADJACENCY = null;
    public static final Boolean DEFAULT_WITH_BORDER_INFO = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_FROM = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_TARGET = null;
    private static final long serialVersionUID = 0;

    @SerializedName("fence_to_cal")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", tag = 3)
    public final Fence fence_to_cal;

    @SerializedName("filter_adjacency")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean filter_adjacency;

    @SerializedName("from_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 4)
    public final TargetDataset from_dataset;

    @SerializedName("from_fence_id_list")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    public final List<String> from_fence_id_list;

    @SerializedName("properties_filter")
    @WireField(adapter = "com.obric.matrix.proto.StringArray#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, StringArray> properties_filter;

    @SerializedName("target_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 1)
    public final TargetDataset target_dataset;

    @SerializedName("with_border_info")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean with_border_info;

    @SerializedName("with_overlap_from")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean with_overlap_from;

    @SerializedName("with_overlap_target")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean with_overlap_target;

    public static final class a extends Message.Builder<GetIntersectFencesRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TargetDataset f8168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, StringArray> f8169b;
        public Fence c;
        public TargetDataset d;
        public List<String> e;
        public Boolean f;
        public Boolean g;
        public Boolean h;
        public Boolean i;

        public a() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.f8169b = Internal.newMutableMap();
            this.e = Internal.newMutableList();
        }

        public a a(Fence r1) {
            this.c = r1;
            return this;
        }

        public a a(TargetDataset r1) {
            this.f8168a = r1;
            return this;
        }

        public a a(Boolean r1) {
            this.f = r1;
            return this;
        }

        public GetIntersectFencesRequest a() {
            return new GetIntersectFencesRequest(this.f8168a, this.f8169b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, super.buildUnknownFields());
        }

        public a b(TargetDataset r1) {
            this.d = r1;
            return this;
        }

        public a b(Boolean r1) {
            this.g = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(Boolean r1) {
            this.h = r1;
            return this;
        }

        public a d(Boolean r1) {
            this.i = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<GetIntersectFencesRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, StringArray>> f8170a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesRequest.class);
            this.f8170a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, StringArray.ADAPTER);
        }

        public int a(GetIntersectFencesRequest r4) {
            return ((((((((TargetDataset.ADAPTER.encodedSizeWithTag(1, r4.target_dataset) + this.f8170a.encodedSizeWithTag(2, r4.properties_filter)) + Fence.ADAPTER.encodedSizeWithTag(3, r4.fence_to_cal)) + TargetDataset.ADAPTER.encodedSizeWithTag(4, r4.from_dataset)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r4.from_fence_id_list)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r4.with_border_info)) + ProtoAdapter.BOOL.encodedSizeWithTag(7, r4.filter_adjacency)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r4.with_overlap_from)) + ProtoAdapter.BOOL.encodedSizeWithTag(9, r4.with_overlap_target)) + r4.unknownFields().size();
        }

        public GetIntersectFencesRequest a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r0.d((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.c((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r0.b((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r0.e.add((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            r0.b((TargetDataset) ZeusTransformUtils.preCheckCast(TargetDataset.ADAPTER.decode(r8), TargetDataset.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r0.a((Fence) ZeusTransformUtils.preCheckCast(Fence.ADAPTER.decode(r8), Fence.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r0.f8169b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8170a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L16:
            r0.a((TargetDataset) ZeusTransformUtils.preCheckCast(TargetDataset.ADAPTER.decode(r8), TargetDataset.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L17:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, GetIntersectFencesRequest r5) {
            TargetDataset.ADAPTER.encodeWithTag(r4, 1, r5.target_dataset);
            this.f8170a.encodeWithTag(r4, 2, r5.properties_filter);
            Fence.ADAPTER.encodeWithTag(r4, 3, r5.fence_to_cal);
            TargetDataset.ADAPTER.encodeWithTag(r4, 4, r5.from_dataset);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 5, r5.from_fence_id_list);
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r5.with_border_info);
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r5.filter_adjacency);
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r5.with_overlap_from);
            ProtoAdapter.BOOL.encodeWithTag(r4, 9, r5.with_overlap_target);
            r4.writeBytes(r5.unknownFields());
        }

        public GetIntersectFencesRequest b(GetIntersectFencesRequest r3) {
            a r2 = r3.newBuilder();
            if (r2.f8168a == null) goto L5;
            r2.f8168a = (TargetDataset) ZeusTransformUtils.preCheckCast(TargetDataset.ADAPTER.redact(r2.f8168a), TargetDataset.class, "com.obric.memorydata.plugin");
        L5:
            Internal.redactElements(r2.f8169b, StringArray.ADAPTER);
            if (r2.c == null) goto L9;
            r2.c = (Fence) ZeusTransformUtils.preCheckCast(Fence.ADAPTER.redact(r2.c), Fence.class, "com.obric.memorydata.plugin");
        L9:
            if (r2.d == null) goto L11;
            r2.d = (TargetDataset) ZeusTransformUtils.preCheckCast(TargetDataset.ADAPTER.redact(r2.d), TargetDataset.class, "com.obric.memorydata.plugin");
        L11:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetIntersectFencesRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, GetIntersectFencesRequest r4) {
            a(r3, (GetIntersectFencesRequest) ZeusTransformUtils.preCheckCast(r4, GetIntersectFencesRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(GetIntersectFencesRequest r3) {
            return a((GetIntersectFencesRequest) ZeusTransformUtils.preCheckCast(r3, GetIntersectFencesRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetIntersectFencesRequest redact(GetIntersectFencesRequest r3) {
            return b((GetIntersectFencesRequest) ZeusTransformUtils.preCheckCast(r3, GetIntersectFencesRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_WITH_BORDER_INFO = false;
        DEFAULT_FILTER_ADJACENCY = false;
        DEFAULT_WITH_OVERLAP_FROM = false;
        DEFAULT_WITH_OVERLAP_TARGET = false;
    }

    public GetIntersectFencesRequest(TargetDataset r14, Map<String, StringArray> r15, Fence r16, TargetDataset r17, List<String> r18, Boolean r19, Boolean r20, Boolean r21, Boolean r22) {
        this(r14, (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin"), r16, r17, (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin"), r19, r20, r21, r22, ByteString.EMPTY);
    }

    public GetIntersectFencesRequest(TargetDataset r3, Map<String, StringArray> r4, Fence r5, TargetDataset r6, List<String> r7, Boolean r8, Boolean r9, Boolean r10, Boolean r11, ByteString r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r12);
        this.target_dataset = r3;
        this.properties_filter = Internal.immutableCopyOf("properties_filter", r13);
        this.fence_to_cal = r5;
        this.from_dataset = r6;
        this.from_fence_id_list = Internal.immutableCopyOf("from_fence_id_list", r14);
        this.with_border_info = r8;
        this.filter_adjacency = r9;
        this.with_overlap_from = r10;
        this.with_overlap_target = r11;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GetIntersectFencesRequest.class) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesRequest r6 = (GetIntersectFencesRequest) ZeusTransformUtils.preCheckCast(r5, GetIntersectFencesRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.target_dataset, r6.target_dataset) == false) goto L30;
        if (this.properties_filter.equals(r6.properties_filter) == false) goto L30;
        if (Internal.equals(this.fence_to_cal, r6.fence_to_cal) == false) goto L30;
        if (Internal.equals(this.from_dataset, r6.from_dataset) == false) goto L30;
        if (this.from_fence_id_list.equals(r6.from_fence_id_list) == false) goto L30;
        if (Internal.equals(this.with_border_info, r6.with_border_info) == false) goto L30;
        if (Internal.equals(this.filter_adjacency, r6.filter_adjacency) == false) goto L30;
        if (Internal.equals(this.with_overlap_from, r6.with_overlap_from) == false) goto L30;
        if (Internal.equals(this.with_overlap_target, r6.with_overlap_target) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L33;
        int r1 = unknownFields().hashCode() * 37;
        TargetDataset r2 = this.target_dataset;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (((r1 + r4) * 37) + this.properties_filter.hashCode()) * 37;
        Fence r6 = this.fence_to_cal;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        TargetDataset r9 = this.from_dataset;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (((r8 + r10) * 37) + this.from_fence_id_list.hashCode()) * 37;
        Boolean r12 = this.with_border_info;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Boolean r15 = this.filter_adjacency;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        Boolean r18 = this.with_overlap_from;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        Boolean r21 = this.with_overlap_target;
        if (r21 == null) goto L31;
        r3 = r21.hashCode();
    L31:
        int r22 = r20 + r3;
        this.hashCode = r22;
        return r22;
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L33:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8168a = this.target_dataset;
        r0.f8169b = Internal.copyOf("properties_filter", this.properties_filter);
        r0.c = this.fence_to_cal;
        r0.d = this.from_dataset;
        r0.e = Internal.copyOf("from_fence_id_list", this.from_fence_id_list);
        r0.f = this.with_border_info;
        r0.g = this.filter_adjacency;
        r0.h = this.with_overlap_from;
        r0.i = this.with_overlap_target;
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
        if (this.target_dataset == null) goto L5;
        r0.append(", target_dataset=").append(this.target_dataset);
    L5:
        Map<String, StringArray> r1 = this.properties_filter;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", properties_filter=").append(this.properties_filter);
    L11:
        if (this.fence_to_cal == null) goto L14;
        r0.append(", fence_to_cal=").append(this.fence_to_cal);
    L14:
        if (this.from_dataset == null) goto L16;
        r0.append(", from_dataset=").append(this.from_dataset);
    L16:
        List<String> r2 = this.from_fence_id_list;
        if (r2 == null) goto L22;
        if (r2.isEmpty() == true) goto L22;
        r0.append(", from_fence_id_list=").append(this.from_fence_id_list);
    L22:
        if (this.with_border_info == null) goto L25;
        r0.append(", with_border_info=").append(this.with_border_info);
    L25:
        if (this.filter_adjacency == null) goto L28;
        r0.append(", filter_adjacency=").append(this.filter_adjacency);
    L28:
        if (this.with_overlap_from == null) goto L31;
        r0.append(", with_overlap_from=").append(this.with_overlap_from);
    L31:
        if (this.with_overlap_target == null) goto L34;
        r0.append(", with_overlap_target=").append(this.with_overlap_target);
    L34:
        return r0.replace(0, 2, "GetIntersectFencesRequest{").append('}').toString();
    }
}
