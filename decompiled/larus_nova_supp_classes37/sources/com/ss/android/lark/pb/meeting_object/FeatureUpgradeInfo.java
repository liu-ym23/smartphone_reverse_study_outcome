package com.ss.android.lark.pb.meeting_object;

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
public final class FeatureUpgradeInfo extends Message<FeatureUpgradeInfo, Builder> {
    public static final ProtoAdapter<FeatureUpgradeInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<FeatureUpgradeType> mupgrade_type;

    public static final class Builder extends Message.Builder<FeatureUpgradeInfo, Builder> {
        public List<FeatureUpgradeType> mupgrade_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FeatureUpgradeInfo m1775build() {
            return new FeatureUpgradeInfo(this.mupgrade_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mupgrade_type = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1775build();
        }

        public Builder upgrade_type(List<FeatureUpgradeType> r1) {
            Internal.checkElementsNotNull(r1);
            this.mupgrade_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FeatureUpgradeInfo extends ProtoAdapter<FeatureUpgradeInfo> {
        public ProtoAdapter_FeatureUpgradeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FeatureUpgradeInfo.class);
        }

        public FeatureUpgradeInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mupgrade_type.add((FeatureUpgradeType) FeatureUpgradeType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L12:
            r9.endMessage(r1);
            return r0.m1775build();
        }

        public int encodedSize(FeatureUpgradeInfo r4) {
            return FeatureUpgradeType.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mupgrade_type) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1776decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FeatureUpgradeInfo) r1);
        }

        public void encode(ProtoWriter r4, FeatureUpgradeInfo r5) throws IOException {
            FeatureUpgradeType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mupgrade_type);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FeatureUpgradeInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeatureUpgradeInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1774newBuilder() {
        Builder r0 = new Builder();
        r0.mupgrade_type = Internal.copyOf("mupgrade_type", this.mupgrade_type);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FeatureUpgradeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1774newBuilder();
    }

    public FeatureUpgradeInfo(List<FeatureUpgradeType> r2) {
        this(r2, ByteString.EMPTY);
    }

    public FeatureUpgradeInfo(List<FeatureUpgradeType> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mupgrade_type = Internal.immutableCopyOf("mupgrade_type", r2);
    }
}
