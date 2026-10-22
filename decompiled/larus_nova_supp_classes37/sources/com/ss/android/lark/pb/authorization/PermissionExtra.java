package com.ss.android.lark.pb.authorization;

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
public final class PermissionExtra extends Message<PermissionExtra, Builder> {
    public static final ProtoAdapter<PermissionExtra> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<FeatureGateInfo> mfeature_gate_infos;
    public final List<PermissionTypeInfo> mpermission_type_infos;

    public static final class Builder extends Message.Builder<PermissionExtra, Builder> {
        public List<FeatureGateInfo> mfeature_gate_infos;
        public List<PermissionTypeInfo> mpermission_type_infos;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PermissionExtra m845build() {
            return new PermissionExtra(this.mfeature_gate_infos, this.mpermission_type_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.mfeature_gate_infos = Internal.newMutableList();
            this.mpermission_type_infos = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m845build();
        }

        public Builder feature_gate_infos(List<FeatureGateInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfeature_gate_infos = r1;
            return this;
        }

        public Builder permission_type_infos(List<PermissionTypeInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpermission_type_infos = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PermissionExtra extends ProtoAdapter<PermissionExtra> {
        public ProtoAdapter_PermissionExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionExtra.class);
        }

        public PermissionExtra decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mfeature_gate_infos.add((FeatureGateInfo) FeatureGateInfo.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mpermission_type_infos.add((PermissionTypeInfo) PermissionTypeInfo.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m845build();
        }

        public int encodedSize(PermissionExtra r5) {
            return (FeatureGateInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mfeature_gate_infos) + PermissionTypeInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mpermission_type_infos)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m846decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PermissionExtra) r1);
        }

        public void encode(ProtoWriter r4, PermissionExtra r5) throws IOException {
            FeatureGateInfo.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mfeature_gate_infos);
            PermissionTypeInfo.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mpermission_type_infos);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PermissionExtra) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PermissionExtra();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m844newBuilder() {
        Builder r0 = new Builder();
        r0.mfeature_gate_infos = Internal.copyOf("mfeature_gate_infos", this.mfeature_gate_infos);
        r0.mpermission_type_infos = Internal.copyOf("mpermission_type_infos", this.mpermission_type_infos);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PermissionExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m844newBuilder();
    }

    public PermissionExtra(List<FeatureGateInfo> r2, List<PermissionTypeInfo> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PermissionExtra(List<FeatureGateInfo> r2, List<PermissionTypeInfo> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mfeature_gate_infos = Internal.immutableCopyOf("mfeature_gate_infos", r2);
        this.mpermission_type_infos = Internal.immutableCopyOf("mpermission_type_infos", r3);
    }
}
