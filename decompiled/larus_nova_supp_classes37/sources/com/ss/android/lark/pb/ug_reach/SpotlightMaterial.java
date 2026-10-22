package com.ss.android.lark.pb.ug_reach;

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
public final class SpotlightMaterial extends Message<SpotlightMaterial, Builder> {
    public static final ProtoAdapter<SpotlightMaterial> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MaterialBase mbase;
    public final MaskConfig mspotlight_mask_config;
    public final List<SpotlightMaterialItem> mspotlights;

    public static final class Builder extends Message.Builder<SpotlightMaterial, Builder> {
        public MaterialBase mbase;
        public MaskConfig mspotlight_mask_config;
        public List<SpotlightMaterialItem> mspotlights;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SpotlightMaterial m2462build() {
            return new SpotlightMaterial(this.mspotlights, this.mspotlight_mask_config, this.mbase, super.buildUnknownFields());
        }

        public Builder() {
            this.mspotlights = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2462build();
        }

        public Builder base(MaterialBase r1) {
            this.mbase = r1;
            return this;
        }

        public Builder spotlight_mask_config(MaskConfig r1) {
            this.mspotlight_mask_config = r1;
            return this;
        }

        public Builder spotlights(List<SpotlightMaterialItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mspotlights = r1;
            return this;
        }
    }

    public static final class MaskConfig extends Message<MaskConfig, Builder> {
        public static final ProtoAdapter<MaskConfig> ADAPTER = null;
        public static final Double DEFAULT_ALPHA = null;
        public static final Boolean DEFAULT_MASK_INTERACTION_FORCE_OPEN = null;
        private static final long serialVersionUID = 0;
        public final Double malpha;
        public final Boolean mmask_interaction_force_open;

        public static final class Builder extends Message.Builder<MaskConfig, Builder> {
            public Double malpha;
            public Boolean mmask_interaction_force_open;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MaskConfig m2464build() {
                return new MaskConfig(this.malpha, this.mmask_interaction_force_open, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2464build();
            }

            public Builder alpha(Double r1) {
                this.malpha = r1;
                return this;
            }

            public Builder mask_interaction_force_open(Boolean r1) {
                this.mmask_interaction_force_open = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MaskConfig extends ProtoAdapter<MaskConfig> {
            public ProtoAdapter_MaskConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, MaskConfig.class);
            }

            public MaskConfig decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.malpha = Double.valueOf(0.0d);
                r0.mmask_interaction_force_open = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.malpha = (Double) ProtoAdapter.DOUBLE.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mmask_interaction_force_open = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2464build();
            }

            public int encodedSize(MaskConfig r5) {
                Double r0 = r5.malpha;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mmask_interaction_force_open;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2465decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MaskConfig) r1);
            }

            public void encode(ProtoWriter r4, MaskConfig r5) throws IOException {
                Double r0 = r5.malpha;
                if (r0 == null) goto L5;
                ProtoAdapter.DOUBLE.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mmask_interaction_force_open;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MaskConfig) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MaskConfig();
            DEFAULT_ALPHA = Double.valueOf(0.0d);
            DEFAULT_MASK_INTERACTION_FORCE_OPEN = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2463newBuilder() {
            Builder r0 = new Builder();
            r0.malpha = this.malpha;
            r0.mmask_interaction_force_open = this.mmask_interaction_force_open;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MaskConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2463newBuilder();
        }

        public MaskConfig(Double r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public MaskConfig(Double r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.malpha = r2;
            this.mmask_interaction_force_open = r3;
        }
    }

    public static final class ProtoAdapter_SpotlightMaterial extends ProtoAdapter<SpotlightMaterial> {
        public ProtoAdapter_SpotlightMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, SpotlightMaterial.class);
        }

        public SpotlightMaterial decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mspotlights.add((SpotlightMaterialItem) SpotlightMaterialItem.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mspotlight_mask_config = (MaskConfig) MaskConfig.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mbase = (MaterialBase) MaterialBase.ADAPTER.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2462build();
        }

        public int encodedSize(SpotlightMaterial r6) {
            int r0 = SpotlightMaterialItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mspotlights);
            MaskConfig r1 = r6.mspotlight_mask_config;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = MaskConfig.ADAPTER.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            MaterialBase r5 = r6.mbase;
            if (r5 == null) goto L10;
            r2 = MaterialBase.ADAPTER.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2466decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SpotlightMaterial) r1);
        }

        public void encode(ProtoWriter r4, SpotlightMaterial r5) throws IOException {
            SpotlightMaterialItem.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mspotlights);
            MaskConfig r0 = r5.mspotlight_mask_config;
            if (r0 == null) goto L5;
            MaskConfig.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            MaterialBase r1 = r5.mbase;
            if (r1 == null) goto L8;
            MaterialBase.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SpotlightMaterial) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpotlightMaterial();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2461newBuilder() {
        Builder r0 = new Builder();
        r0.mspotlights = Internal.copyOf("mspotlights", this.mspotlights);
        r0.mspotlight_mask_config = this.mspotlight_mask_config;
        r0.mbase = this.mbase;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SpotlightMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2461newBuilder();
    }

    public SpotlightMaterial(List<SpotlightMaterialItem> r2, MaskConfig r3, MaterialBase r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SpotlightMaterial(List<SpotlightMaterialItem> r2, MaskConfig r3, MaterialBase r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mspotlights = Internal.immutableCopyOf("mspotlights", r2);
        this.mspotlight_mask_config = r3;
        this.mbase = r4;
    }
}
