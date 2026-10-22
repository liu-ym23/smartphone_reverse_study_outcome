package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SpotlightMaterialItem extends Message<SpotlightMaterialItem, Builder> {
    public static final ProtoAdapter<SpotlightMaterialItem> ADAPTER = null;
    public static final String DEFAULT_STEP_NAME = "";
    private static final long serialVersionUID = 0;
    public final ContainerConfiguration mcontainer_config;
    public final SpotlightContent mcontent;
    public final String mstep_name;
    public final TargetAnchor mtarget_anchor_config;

    public static final enum ArrowDirection extends Enum<ArrowDirection> implements WireEnum {
        private static final /* synthetic */ ArrowDirection[] $VALUES = null;
        public static final ProtoAdapter<ArrowDirection> ADAPTER = null;
        public static final ArrowDirection DOWN = null;
        public static final ArrowDirection LEFT = null;
        public static final ArrowDirection RIGHT = null;
        public static final ArrowDirection UNKNOWN = null;
        public static final ArrowDirection UP = null;
        private final int value;

        static {
            ArrowDirection r0 = new ArrowDirection("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ArrowDirection r1 = new ArrowDirection("LEFT", 1, 1);
            LEFT = r1;
            ArrowDirection r3 = new ArrowDirection("UP", 2, 2);
            UP = r3;
            ArrowDirection r5 = new ArrowDirection("RIGHT", 3, 3);
            RIGHT = r5;
            ArrowDirection r7 = new ArrowDirection("DOWN", 4, 4);
            DOWN = r7;
            $VALUES = new ArrowDirection[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(ArrowDirection.class);
        }

        public static ArrowDirection[] values() {
            return (ArrowDirection[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ArrowDirection fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return DOWN;
        L16:
            return RIGHT;
        L18:
            return UP;
        L20:
            return LEFT;
        L22:
            return UNKNOWN;
        }

        public static ArrowDirection valueOf(String r1) {
            return (ArrowDirection) a.a(ArrowDirection.class, r1);
        }

        private ArrowDirection(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<SpotlightMaterialItem, Builder> {
        public ContainerConfiguration mcontainer_config;
        public SpotlightContent mcontent;
        public String mstep_name;
        public TargetAnchor mtarget_anchor_config;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SpotlightMaterialItem m2468build() {
            return new SpotlightMaterialItem(this.mstep_name, this.mcontent, this.mcontainer_config, this.mtarget_anchor_config, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2468build();
        }

        public Builder container_config(ContainerConfiguration r1) {
            this.mcontainer_config = r1;
            return this;
        }

        public Builder content(SpotlightContent r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder step_name(String r1) {
            this.mstep_name = r1;
            return this;
        }

        public Builder target_anchor_config(TargetAnchor r1) {
            this.mtarget_anchor_config = r1;
            return this;
        }
    }

    public static final class ContainerConfiguration extends Message<ContainerConfiguration, Builder> {
        public static final ProtoAdapter<ContainerConfiguration> ADAPTER = null;
        public static final String DEFAULT_BACKGROUND_COLOR = "";
        public static final String DEFAULT_SHADOW_COLOR = "";
        private static final long serialVersionUID = 0;
        public final String mbackground_color;
        public final String mshadow_color;
        public final ContainerStyle mstyle;

        public static final class Builder extends Message.Builder<ContainerConfiguration, Builder> {
            public String mbackground_color;
            public String mshadow_color;
            public ContainerStyle mstyle;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ContainerConfiguration m2470build() {
                return new ContainerConfiguration(this.mbackground_color, this.mshadow_color, this.mstyle, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2470build();
            }

            public Builder background_color(String r1) {
                this.mbackground_color = r1;
                return this;
            }

            public Builder shadow_color(String r1) {
                this.mshadow_color = r1;
                return this;
            }

            public Builder style(ContainerStyle r1) {
                this.mstyle = r1;
                return this;
            }
        }

        public static final enum ContainerStyle extends Enum<ContainerStyle> implements WireEnum {
            private static final /* synthetic */ ContainerStyle[] $VALUES = null;
            public static final ProtoAdapter<ContainerStyle> ADAPTER = null;
            public static final ContainerStyle FILL = null;
            public static final ContainerStyle STROKE = null;
            public static final ContainerStyle UNKNOWN = null;
            private final int value;

            static {
                ContainerStyle r0 = new ContainerStyle("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                ContainerStyle r1 = new ContainerStyle("FILL", 1, 1);
                FILL = r1;
                ContainerStyle r3 = new ContainerStyle("STROKE", 2, 2);
                STROKE = r3;
                $VALUES = new ContainerStyle[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContainerStyle.class);
            }

            public static ContainerStyle[] values() {
                return (ContainerStyle[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ContainerStyle fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return STROKE;
            L12:
                return FILL;
            L14:
                return UNKNOWN;
            }

            public static ContainerStyle valueOf(String r1) {
                return (ContainerStyle) a.a(ContainerStyle.class, r1);
            }

            private ContainerStyle(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ContainerConfiguration extends ProtoAdapter<ContainerConfiguration> {
            public ProtoAdapter_ContainerConfiguration() {
                super(FieldEncoding.LENGTH_DELIMITED, ContainerConfiguration.class);
            }

            public ContainerConfiguration decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mbackground_color = "";
                r0.mshadow_color = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mbackground_color = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mshadow_color = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mstyle = (ContainerStyle) ContainerStyle.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m2470build();
            }

            public int encodedSize(ContainerConfiguration r6) {
                String r0 = r6.mbackground_color;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mshadow_color;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                ContainerStyle r7 = r6.mstyle;
                if (r7 == null) goto L14;
                r1 = ContainerStyle.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                return (r5 + r1) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2471decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ContainerConfiguration) r1);
            }

            public void encode(ProtoWriter r4, ContainerConfiguration r5) throws IOException {
                String r0 = r5.mbackground_color;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mshadow_color;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                ContainerStyle r2 = r5.mstyle;
                if (r2 == null) goto L11;
                ContainerStyle.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ContainerConfiguration) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContainerConfiguration();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2469newBuilder() {
            Builder r0 = new Builder();
            r0.mbackground_color = this.mbackground_color;
            r0.mshadow_color = this.mshadow_color;
            r0.mstyle = this.mstyle;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ContainerConfiguration.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2469newBuilder();
        }

        public ContainerConfiguration(String r2, String r3, ContainerStyle r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public ContainerConfiguration(String r2, String r3, ContainerStyle r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mbackground_color = r2;
            this.mshadow_color = r3;
            this.mstyle = r4;
        }
    }

    public static final class ProtoAdapter_SpotlightMaterialItem extends ProtoAdapter<SpotlightMaterialItem> {
        public ProtoAdapter_SpotlightMaterialItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SpotlightMaterialItem.class);
        }

        public SpotlightMaterialItem decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mstep_name = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mstep_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcontent = (SpotlightContent) SpotlightContent.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcontainer_config = (ContainerConfiguration) ContainerConfiguration.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mtarget_anchor_config = (TargetAnchor) TargetAnchor.ADAPTER.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2468build();
        }

        public int encodedSize(SpotlightMaterialItem r6) {
            String r0 = r6.mstep_name;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            SpotlightContent r3 = r6.mcontent;
            if (r3 == null) goto L9;
            int r4 = SpotlightContent.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ContainerConfiguration r7 = r6.mcontainer_config;
            if (r7 == null) goto L13;
            int r8 = ContainerConfiguration.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TargetAnchor r10 = r6.mtarget_anchor_config;
            if (r10 == null) goto L18;
            r1 = TargetAnchor.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2472decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SpotlightMaterialItem) r1);
        }

        public void encode(ProtoWriter r4, SpotlightMaterialItem r5) throws IOException {
            String r0 = r5.mstep_name;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            SpotlightContent r1 = r5.mcontent;
            if (r1 == null) goto L8;
            SpotlightContent.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            ContainerConfiguration r2 = r5.mcontainer_config;
            if (r2 == null) goto L11;
            ContainerConfiguration.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TargetAnchor r3 = r5.mtarget_anchor_config;
            if (r3 == null) goto L14;
            TargetAnchor.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SpotlightMaterialItem) r2);
        }
    }

    public static final class SpotlightContent extends Message<SpotlightContent, Builder> {
        public static final ProtoAdapter<SpotlightContent> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<ButtonElement> mbuttons;
        public final TextElement mdescription;
        public final ImageElement mimage;
        public final TextElement mtitle;

        public static final class Builder extends Message.Builder<SpotlightContent, Builder> {
            public List<ButtonElement> mbuttons;
            public TextElement mdescription;
            public ImageElement mimage;
            public TextElement mtitle;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SpotlightContent m2474build() {
                return new SpotlightContent(this.mtitle, this.mdescription, this.mimage, this.mbuttons, super.buildUnknownFields());
            }

            public Builder() {
                this.mbuttons = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2474build();
            }

            public Builder buttons(List<ButtonElement> r1) {
                Internal.checkElementsNotNull(r1);
                this.mbuttons = r1;
                return this;
            }

            public Builder description(TextElement r1) {
                this.mdescription = r1;
                return this;
            }

            public Builder image(ImageElement r1) {
                this.mimage = r1;
                return this;
            }

            public Builder title(TextElement r1) {
                this.mtitle = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SpotlightContent extends ProtoAdapter<SpotlightContent> {
            public ProtoAdapter_SpotlightContent() {
                super(FieldEncoding.LENGTH_DELIMITED, SpotlightContent.class);
            }

            public SpotlightContent decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtitle = (TextElement) TextElement.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mdescription = (TextElement) TextElement.ADAPTER.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mimage = (ImageElement) ImageElement.ADAPTER.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mbuttons.add((ButtonElement) ButtonElement.ADAPTER.decode(r7));
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m2474build();
            }

            public int encodedSize(SpotlightContent r6) {
                TextElement r0 = r6.mtitle;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = TextElement.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                TextElement r3 = r6.mdescription;
                if (r3 == null) goto L9;
                int r4 = TextElement.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                ImageElement r7 = r6.mimage;
                if (r7 == null) goto L14;
                r1 = ImageElement.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                return ((r5 + r1) + ButtonElement.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mbuttons)) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2475decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SpotlightContent) r1);
            }

            public void encode(ProtoWriter r4, SpotlightContent r5) throws IOException {
                TextElement r0 = r5.mtitle;
                if (r0 == null) goto L5;
                TextElement.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                TextElement r1 = r5.mdescription;
                if (r1 == null) goto L8;
                TextElement.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                ImageElement r2 = r5.mimage;
                if (r2 == null) goto L11;
                ImageElement.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                ButtonElement.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mbuttons);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SpotlightContent) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpotlightContent();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2473newBuilder() {
            Builder r0 = new Builder();
            r0.mtitle = this.mtitle;
            r0.mdescription = this.mdescription;
            r0.mimage = this.mimage;
            r0.mbuttons = Internal.copyOf("mbuttons", this.mbuttons);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SpotlightContent.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2473newBuilder();
        }

        public SpotlightContent(TextElement r7, TextElement r8, ImageElement r9, List<ButtonElement> r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public SpotlightContent(TextElement r2, TextElement r3, ImageElement r4, List<ButtonElement> r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mtitle = r2;
            this.mdescription = r3;
            this.mimage = r4;
            this.mbuttons = Internal.immutableCopyOf("mbuttons", r5);
        }
    }

    public static final class TargetAnchor extends Message<TargetAnchor, Builder> {
        public static final ProtoAdapter<TargetAnchor> ADAPTER = null;
        public static final Double DEFAULT_OFFSET = null;
        private static final long serialVersionUID = 0;
        public final ArrowDirection marrow_direction;
        public final Double moffset;
        public final TargetRectType mtarget_rect_type;

        public static final class Builder extends Message.Builder<TargetAnchor, Builder> {
            public ArrowDirection marrow_direction;
            public Double moffset;
            public TargetRectType mtarget_rect_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TargetAnchor m2477build() {
                return new TargetAnchor(this.moffset, this.marrow_direction, this.mtarget_rect_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2477build();
            }

            public Builder arrow_direction(ArrowDirection r1) {
                this.marrow_direction = r1;
                return this;
            }

            public Builder offset(Double r1) {
                this.moffset = r1;
                return this;
            }

            public Builder target_rect_type(TargetRectType r1) {
                this.mtarget_rect_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TargetAnchor extends ProtoAdapter<TargetAnchor> {
            public ProtoAdapter_TargetAnchor() {
                super(FieldEncoding.LENGTH_DELIMITED, TargetAnchor.class);
            }

            public TargetAnchor decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.moffset = Double.valueOf(0.0d);
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.moffset = (Double) ProtoAdapter.DOUBLE.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.marrow_direction = (ArrowDirection) ArrowDirection.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mtarget_rect_type = (TargetRectType) TargetRectType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m2477build();
            }

            public int encodedSize(TargetAnchor r6) {
                Double r0 = r6.moffset;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r0);
            L6:
                ArrowDirection r3 = r6.marrow_direction;
                if (r3 == null) goto L9;
                int r4 = ArrowDirection.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                TargetRectType r7 = r6.mtarget_rect_type;
                if (r7 == null) goto L14;
                r1 = TargetRectType.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                return (r5 + r1) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2478decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TargetAnchor) r1);
            }

            public void encode(ProtoWriter r4, TargetAnchor r5) throws IOException {
                Double r0 = r5.moffset;
                if (r0 == null) goto L5;
                ProtoAdapter.DOUBLE.encodeWithTag(r4, 1, r0);
            L5:
                ArrowDirection r1 = r5.marrow_direction;
                if (r1 == null) goto L8;
                ArrowDirection.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                TargetRectType r2 = r5.mtarget_rect_type;
                if (r2 == null) goto L11;
                TargetRectType.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TargetAnchor) r2);
            }
        }

        public static final enum TargetRectType extends Enum<TargetRectType> implements WireEnum {
            private static final /* synthetic */ TargetRectType[] $VALUES = null;
            public static final ProtoAdapter<TargetRectType> ADAPTER = null;
            public static final TargetRectType CIRCLE = null;
            public static final TargetRectType RECTANGLE = null;
            public static final TargetRectType UNKNOWN = null;
            private final int value;

            static {
                TargetRectType r0 = new TargetRectType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                TargetRectType r1 = new TargetRectType("RECTANGLE", 1, 1);
                RECTANGLE = r1;
                TargetRectType r3 = new TargetRectType("CIRCLE", 2, 2);
                CIRCLE = r3;
                $VALUES = new TargetRectType[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(TargetRectType.class);
            }

            public static TargetRectType[] values() {
                return (TargetRectType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TargetRectType fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return CIRCLE;
            L12:
                return RECTANGLE;
            L14:
                return UNKNOWN;
            }

            public static TargetRectType valueOf(String r1) {
                return (TargetRectType) a.a(TargetRectType.class, r1);
            }

            private TargetRectType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TargetAnchor();
            DEFAULT_OFFSET = Double.valueOf(0.0d);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2476newBuilder() {
            Builder r0 = new Builder();
            r0.moffset = this.moffset;
            r0.marrow_direction = this.marrow_direction;
            r0.mtarget_rect_type = this.mtarget_rect_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TargetAnchor.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2476newBuilder();
        }

        public TargetAnchor(Double r2, ArrowDirection r3, TargetRectType r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TargetAnchor(Double r2, ArrowDirection r3, TargetRectType r4, ByteString r5) {
            super(ADAPTER, r5);
            this.moffset = r2;
            this.marrow_direction = r3;
            this.mtarget_rect_type = r4;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpotlightMaterialItem();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2467newBuilder() {
        Builder r0 = new Builder();
        r0.mstep_name = this.mstep_name;
        r0.mcontent = this.mcontent;
        r0.mcontainer_config = this.mcontainer_config;
        r0.mtarget_anchor_config = this.mtarget_anchor_config;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SpotlightMaterialItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2467newBuilder();
    }

    public SpotlightMaterialItem(String r7, SpotlightContent r8, ContainerConfiguration r9, TargetAnchor r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SpotlightMaterialItem(String r2, SpotlightContent r3, ContainerConfiguration r4, TargetAnchor r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mstep_name = r2;
        this.mcontent = r3;
        this.mcontainer_config = r4;
        this.mtarget_anchor_config = r5;
    }
}
