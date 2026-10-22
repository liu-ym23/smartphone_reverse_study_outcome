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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class GetIntersectFencesRequest extends Message<GetIntersectFencesRequest, Builder> {
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

    public static final class Builder extends Message.Builder<GetIntersectFencesRequest, Builder> {
        public Fence fence_to_cal;
        public Boolean filter_adjacency;
        public TargetDataset from_dataset;
        public List<String> from_fence_id_list;
        public Map<String, StringArray> properties_filter;
        public TargetDataset target_dataset;
        public Boolean with_border_info;
        public Boolean with_overlap_from;
        public Boolean with_overlap_target;

        public Builder() {
            Boolean r5 = Boolean.FALSE;
            this.with_border_info = r5;
            this.filter_adjacency = r5;
            this.with_overlap_from = r5;
            this.with_overlap_target = r5;
            this.properties_filter = Internal.newMutableMap();
            this.from_fence_id_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fence_to_cal(Fence r5) {
            this.fence_to_cal = r5;
            return this;
        }

        public Builder filter_adjacency(Boolean r5) {
            this.filter_adjacency = r5;
            return this;
        }

        public Builder from_dataset(TargetDataset r5) {
            this.from_dataset = r5;
            return this;
        }

        public Builder from_fence_id_list(List<String> r5) {
            Internal.checkElementsNotNull(r5);
            this.from_fence_id_list = r5;
            return this;
        }

        public Builder properties_filter(Map<String, StringArray> r5) {
            Internal.checkElementsNotNull(r5);
            this.properties_filter = r5;
            return this;
        }

        public Builder target_dataset(TargetDataset r5) {
            this.target_dataset = r5;
            return this;
        }

        public Builder with_border_info(Boolean r5) {
            this.with_border_info = r5;
            return this;
        }

        public Builder with_overlap_from(Boolean r5) {
            this.with_overlap_from = r5;
            return this;
        }

        public Builder with_overlap_target(Boolean r5) {
            this.with_overlap_target = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GetIntersectFencesRequest build() {
            return new GetIntersectFencesRequest(this.target_dataset, this.properties_filter, this.fence_to_cal, this.from_dataset, this.from_fence_id_list, this.with_border_info, this.filter_adjacency, this.with_overlap_from, this.with_overlap_target, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_GetIntersectFencesRequest extends ProtoAdapter<GetIntersectFencesRequest> {
        private final ProtoAdapter<Map<String, StringArray>> properties_filter;

        public ProtoAdapter_GetIntersectFencesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesRequest.class);
            this.properties_filter = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, StringArray.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, GetIntersectFencesRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIntersectFencesRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesRequest redact(GetIntersectFencesRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetIntersectFencesRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L16;
            switch(r12) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r5.with_overlap_target(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            r5.with_overlap_from(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            r5.filter_adjacency(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L10:
            r5.with_border_info(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L11:
            r5.from_fence_id_list.add(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r5.from_dataset(TargetDataset.ADAPTER.decode(r10));
            goto L3
        L13:
            r5.fence_to_cal(Fence.ADAPTER.decode(r10));
            goto L3
        L14:
            r5.properties_filter.putAll(this.properties_filter.decode(r10));
            goto L3
        L15:
            r5.target_dataset(TargetDataset.ADAPTER.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L16:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, GetIntersectFencesRequest r10) throws IOException {
            ProtoAdapter<TargetDataset> r11 = TargetDataset.ADAPTER;
            r11.encodeWithTag(r5, 1, r10.target_dataset);
            this.properties_filter.encodeWithTag(r5, 2, r10.properties_filter);
            Fence.ADAPTER.encodeWithTag(r5, 3, r10.fence_to_cal);
            r11.encodeWithTag(r5, 4, r10.from_dataset);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r5, 5, r10.from_fence_id_list);
            ProtoAdapter<Boolean> r12 = ProtoAdapter.BOOL;
            r12.encodeWithTag(r5, 6, r10.with_border_info);
            r12.encodeWithTag(r5, 7, r10.filter_adjacency);
            r12.encodeWithTag(r5, 8, r10.with_overlap_from);
            r12.encodeWithTag(r5, 9, r10.with_overlap_target);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetIntersectFencesRequest r5) {
            ProtoAdapter<TargetDataset> r10 = TargetDataset.ADAPTER;
            int r11 = r10.encodedSizeWithTag(1, r5.target_dataset);
            int r12 = this.properties_filter.encodedSizeWithTag(2, r5.properties_filter) + r11;
            int r13 = Fence.ADAPTER.encodedSizeWithTag(3, r5.fence_to_cal) + r12;
            int r14 = r10.encodedSizeWithTag(4, r5.from_dataset) + r13;
            int r15 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r5.from_fence_id_list) + r14;
            ProtoAdapter<Boolean> r16 = ProtoAdapter.BOOL;
            int r17 = r16.encodedSizeWithTag(6, r5.with_border_info) + r15;
            int r18 = r16.encodedSizeWithTag(7, r5.filter_adjacency) + r17;
            int r19 = r16.encodedSizeWithTag(8, r5.with_overlap_from) + r18;
            int r20 = r16.encodedSizeWithTag(9, r5.with_overlap_target) + r19;
            return r5.unknownFields().size() + r20;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetIntersectFencesRequest redact2(GetIntersectFencesRequest r5) {
            Builder r10 = r5.newBuilder();
            TargetDataset r11 = r10.target_dataset;
            if (r11 == null) goto L5;
            r10.target_dataset = TargetDataset.ADAPTER.redact(r11);
        L5:
            Internal.redactElements(r10.properties_filter, StringArray.ADAPTER);
            Fence r12 = r10.fence_to_cal;
            if (r12 == null) goto L8;
            r10.fence_to_cal = Fence.ADAPTER.redact(r12);
        L8:
            TargetDataset r13 = r10.from_dataset;
            if (r13 == null) goto L11;
            r10.from_dataset = TargetDataset.ADAPTER.redact(r13);
        L11:
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetIntersectFencesRequest();
        Boolean r5 = Boolean.FALSE;
        DEFAULT_WITH_BORDER_INFO = r5;
        DEFAULT_FILTER_ADJACENCY = r5;
        DEFAULT_WITH_OVERLAP_FROM = r5;
        DEFAULT_WITH_OVERLAP_TARGET = r5;
    }

    public GetIntersectFencesRequest(TargetDataset r12, Map<String, StringArray> r13, Fence r14, TargetDataset r15, List<String> r16, Boolean r17, Boolean r18, Boolean r19, Boolean r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetIntersectFencesRequest) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesRequest r10 = (GetIntersectFencesRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L30;
        if (Internal.equals(this.target_dataset, r10.target_dataset) == false) goto L30;
        if (this.properties_filter.equals(r10.properties_filter) == false) goto L30;
        if (Internal.equals(this.fence_to_cal, r10.fence_to_cal) == false) goto L30;
        if (Internal.equals(this.from_dataset, r10.from_dataset) == false) goto L30;
        if (this.from_fence_id_list.equals(r10.from_fence_id_list) == false) goto L30;
        if (Internal.equals(this.with_border_info, r10.with_border_info) == false) goto L30;
        if (Internal.equals(this.filter_adjacency, r10.filter_adjacency) == false) goto L30;
        if (Internal.equals(this.with_overlap_from, r10.with_overlap_from) == false) goto L30;
        if (Internal.equals(this.with_overlap_target, r10.with_overlap_target) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L33;
        int r10 = unknownFields().hashCode() * 37;
        TargetDataset r11 = this.target_dataset;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (this.properties_filter.hashCode() + ((r10 + r13) * 37)) * 37;
        Fence r15 = this.fence_to_cal;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        TargetDataset r18 = this.from_dataset;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (this.from_fence_id_list.hashCode() + ((r17 + r19) * 37)) * 37;
        Boolean r21 = this.with_border_info;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        Boolean r24 = this.filter_adjacency;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        Boolean r27 = this.with_overlap_from;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        Boolean r30 = this.with_overlap_target;
        if (r30 == null) goto L31;
        r12 = r30.hashCode();
    L31:
        int r31 = r29 + r12;
        this.hashCode = r31;
        return r31;
    L27:
        r28 = 0;
        goto L28
    L23:
        r25 = 0;
        goto L24
    L19:
        r22 = 0;
        goto L20
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L33:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.target_dataset == null) goto L5;
        r5.append(", target_dataset=");
        r5.append(this.target_dataset);
    L5:
        Map<String, StringArray> r10 = this.properties_filter;
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        r5.append(", properties_filter=");
        r5.append(this.properties_filter);
    L11:
        if (this.fence_to_cal == null) goto L14;
        r5.append(", fence_to_cal=");
        r5.append(this.fence_to_cal);
    L14:
        if (this.from_dataset == null) goto L16;
        r5.append(", from_dataset=");
        r5.append(this.from_dataset);
    L16:
        List<String> r11 = this.from_fence_id_list;
        if (r11 == null) goto L22;
        if (r11.isEmpty() == true) goto L22;
        r5.append(", from_fence_id_list=");
        r5.append(this.from_fence_id_list);
    L22:
        if (this.with_border_info == null) goto L25;
        r5.append(", with_border_info=");
        r5.append(this.with_border_info);
    L25:
        if (this.filter_adjacency == null) goto L28;
        r5.append(", filter_adjacency=");
        r5.append(this.filter_adjacency);
    L28:
        if (this.with_overlap_from == null) goto L31;
        r5.append(", with_overlap_from=");
        r5.append(this.with_overlap_from);
    L31:
        if (this.with_overlap_target == null) goto L34;
        r5.append(", with_overlap_target=");
        r5.append(this.with_overlap_target);
    L34:
        return a.s(r5, 0, 2, "GetIntersectFencesRequest{", '}');
    }

    public GetIntersectFencesRequest(TargetDataset r5, Map<String, StringArray> r10, Fence r11, TargetDataset r12, List<String> r13, Boolean r14, Boolean r15, Boolean r16, Boolean r17, ByteString r18) {
        super(ADAPTER, r18);
        this.target_dataset = r5;
        this.properties_filter = Internal.immutableCopyOf("properties_filter", r10);
        this.fence_to_cal = r11;
        this.from_dataset = r12;
        this.from_fence_id_list = Internal.immutableCopyOf("from_fence_id_list", r13);
        this.with_border_info = r14;
        this.filter_adjacency = r15;
        this.with_overlap_from = r16;
        this.with_overlap_target = r17;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.target_dataset = this.target_dataset;
        r5.properties_filter = Internal.copyOf("properties_filter", this.properties_filter);
        r5.fence_to_cal = this.fence_to_cal;
        r5.from_dataset = this.from_dataset;
        r5.from_fence_id_list = Internal.copyOf("from_fence_id_list", this.from_fence_id_list);
        r5.with_border_info = this.with_border_info;
        r5.filter_adjacency = this.filter_adjacency;
        r5.with_overlap_from = this.with_overlap_from;
        r5.with_overlap_target = this.with_overlap_target;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
