package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class URLPreviewComponent extends com.squareup.wire.Message<URLPreviewComponent, Builder> {
    public static final ProtoAdapter<URLPreviewComponent> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_SKIP_WHEN_UNKNOWN = null;
    public static final Boolean DEFAULT_IS_FONT_ZOOMABLE = null;
    private static final long serialVersionUID = 0;
    public final AvatarProperty mavatar;
    public final ButtonProperty mbutton;
    public final Boolean mcan_skip_when_unknown;
    public final CardContainerProperty mcard_container;
    public final ChattersPreviewProperty mchatters_preview;
    public final List<String> mchild_ids;
    public final DocImageProperty mdoc_image;
    public final DocStateButtonProperty mdoc_state_button;
    public final EmptyProperty mempty;
    public final EngineProperty mengine;
    public final FlexLayoutProperty mflex_layout;
    public final PreviewHeaderProperty mheader;
    public final IconButtonProperty micon_button;
    public final ImageProperty mimage;
    public final ImageContainerProperty mimage_container;
    public final Boolean mis_font_zoomable;
    public final LinearLayoutProperty mlinear_layout;
    public final LoadingProperty mloading;
    public final OversizedTextProperty moversized_text;
    public final RichTextProperty mrichtext;
    public final SpinButtonProperty mspin_button;
    public final Style mstyle;
    public final TagListProperty mtag_list;
    public final TextProperty mtext;
    public final TextButtonProperty mtext_button;
    public final TimeProperty mtime;
    public final TimeZoneProperty mtime_zone;
    public final Type mtype;
    public final VideoProperty mvideo;

    public static final enum Align extends Enum<Align> implements WireEnum {
        private static final /* synthetic */ Align[] $VALUES = null;
        public static final ProtoAdapter<Align> ADAPTER = null;
        public static final Align BASELINE = null;
        public static final Align BOTTOM = null;
        public static final Align MIDDLE = null;
        public static final Align STRETCH = null;
        public static final Align TOP = null;
        private final int value;

        static {
            Align r0 = new Align("TOP", 0, 0);
            TOP = r0;
            Align r1 = new Align("MIDDLE", 1, 1);
            MIDDLE = r1;
            Align r3 = new Align("BOTTOM", 2, 2);
            BOTTOM = r3;
            Align r5 = new Align("STRETCH", 3, 3);
            STRETCH = r5;
            Align r7 = new Align("BASELINE", 4, 4);
            BASELINE = r7;
            $VALUES = new Align[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(Align.class);
        }

        public static Align[] values() {
            return (Align[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Align fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return BASELINE;
        L16:
            return STRETCH;
        L18:
            return BOTTOM;
        L20:
            return MIDDLE;
        L22:
            return TOP;
        }

        public static Align valueOf(String r1) {
            return (Align) a.a(Align.class, r1);
        }

        private Align(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class AvatarProperty extends com.squareup.wire.Message<AvatarProperty, Builder> {
        public static final ProtoAdapter<AvatarProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ChatterInfo mchatter_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<AvatarProperty, Builder> {
            public ChatterInfo mchatter_info;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AvatarProperty m1578build() {
                return new AvatarProperty(this.mchatter_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1578build();
            }

            public Builder chatter_info(ChatterInfo r1) {
                this.mchatter_info = r1;
                return this;
            }
        }

        public static final class ChatterInfo extends com.squareup.wire.Message<ChatterInfo, Builder> {
            public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
            public static final String DEFAULT_CHATTER_ID = "";
            private static final long serialVersionUID = 0;
            public final Image mavatar;
            public final String mchatter_id;

            public static final class Builder extends com.squareup.wire.Message.Builder<ChatterInfo, Builder> {
                public Image mavatar;
                public String mchatter_id;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public ChatterInfo m1580build() {
                    return new ChatterInfo(this.mavatar, this.mchatter_id, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1580build();
                }

                public Builder avatar(Image r1) {
                    this.mavatar = r1;
                    return this;
                }

                public Builder chatter_id(String r1) {
                    this.mchatter_id = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_ChatterInfo extends ProtoAdapter<ChatterInfo> {
                public ProtoAdapter_ChatterInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, ChatterInfo.class);
                }

                public ChatterInfo decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mchatter_id = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L12;
                    if (r3 != 1) goto L8;
                    r0.mavatar = (Image) Image.ADAPTER.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.mchatter_id = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L9:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L12:
                    r7.endMessage(r1);
                    return r0.m1580build();
                }

                public int encodedSize(ChatterInfo r5) {
                    Image r0 = r5.mavatar;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = Image.ADAPTER.encodedSizeWithTag(1, r0);
                L6:
                    String r3 = r5.mchatter_id;
                    if (r3 == null) goto L10;
                    r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
                L10:
                    return (r2 + r1) + r5.unknownFields().size();
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1581decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((ChatterInfo) r1);
                }

                public void encode(ProtoWriter r4, ChatterInfo r5) throws IOException {
                    Image r0 = r5.mavatar;
                    if (r0 == null) goto L5;
                    Image.ADAPTER.encodeWithTag(r4, 1, r0);
                L5:
                    String r1 = r5.mchatter_id;
                    if (r1 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
                L8:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (ChatterInfo) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ChatterInfo();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1579newBuilder() {
                Builder r0 = new Builder();
                r0.mavatar = this.mavatar;
                r0.mchatter_id = this.mchatter_id;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return ChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1579newBuilder();
            }

            public ChatterInfo(Image r2, String r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public ChatterInfo(Image r2, String r3, ByteString r4) {
                super(ADAPTER, r4);
                this.mavatar = r2;
                this.mchatter_id = r3;
            }
        }

        public static final class ProtoAdapter_AvatarProperty extends ProtoAdapter<AvatarProperty> {
            public ProtoAdapter_AvatarProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AvatarProperty.class);
            }

            public AvatarProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mchatter_info = (ChatterInfo) ChatterInfo.ADAPTER.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1578build();
            }

            public int encodedSize(AvatarProperty r4) {
                ChatterInfo r0 = r4.mchatter_info;
                if (r0 == null) goto L5;
                int r1 = ChatterInfo.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1582decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AvatarProperty) r1);
            }

            public void encode(ProtoWriter r4, AvatarProperty r5) throws IOException {
                ChatterInfo r0 = r5.mchatter_info;
                if (r0 == null) goto L5;
                ChatterInfo.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AvatarProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AvatarProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1577newBuilder() {
            Builder r0 = new Builder();
            r0.mchatter_info = this.mchatter_info;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AvatarProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1577newBuilder();
        }

        public AvatarProperty(ChatterInfo r2) {
            this(r2, ByteString.EMPTY);
        }

        public AvatarProperty(ChatterInfo r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mchatter_info = r2;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<URLPreviewComponent, Builder> {
        public AvatarProperty mavatar;
        public ButtonProperty mbutton;
        public Boolean mcan_skip_when_unknown;
        public CardContainerProperty mcard_container;
        public ChattersPreviewProperty mchatters_preview;
        public List<String> mchild_ids;
        public DocImageProperty mdoc_image;
        public DocStateButtonProperty mdoc_state_button;
        public EmptyProperty mempty;
        public EngineProperty mengine;
        public FlexLayoutProperty mflex_layout;
        public PreviewHeaderProperty mheader;
        public IconButtonProperty micon_button;
        public ImageProperty mimage;
        public ImageContainerProperty mimage_container;
        public Boolean mis_font_zoomable;
        public LinearLayoutProperty mlinear_layout;
        public LoadingProperty mloading;
        public OversizedTextProperty moversized_text;
        public RichTextProperty mrichtext;
        public SpinButtonProperty mspin_button;
        public Style mstyle;
        public TagListProperty mtag_list;
        public TextProperty mtext;
        public TextButtonProperty mtext_button;
        public TimeProperty mtime;
        public TimeZoneProperty mtime_zone;
        public Type mtype;
        public VideoProperty mvideo;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public URLPreviewComponent m1583build() {
            Type r1 = this.mtype;
            if (r1 == null) goto L7;
            return new URLPreviewComponent(this.mtype, this.mcan_skip_when_unknown, this.mstyle, this.mchild_ids, this.mis_font_zoomable, this.mempty, this.mlinear_layout, this.mflex_layout, this.mheader, this.mrichtext, this.mimage, this.mchatters_preview, this.mbutton, this.micon_button, this.mtext_button, this.mtime, this.mtext, this.mtag_list, this.mspin_button, this.mavatar, this.mvideo, this.mcard_container, this.mdoc_image, this.mloading, this.mtime_zone, this.moversized_text, this.mengine, this.mdoc_state_button, this.mimage_container, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mtype"});
        }

        public Builder() {
            this.mchild_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1583build();
        }

        public Builder avatar(AvatarProperty r1) {
            this.mavatar = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder button(ButtonProperty r1) {
            this.mbutton = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder can_skip_when_unknown(Boolean r1) {
            this.mcan_skip_when_unknown = r1;
            return this;
        }

        public Builder card_container(CardContainerProperty r1) {
            this.mcard_container = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder chatters_preview(ChattersPreviewProperty r1) {
            this.mchatters_preview = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder child_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchild_ids = r1;
            return this;
        }

        public Builder doc_image(DocImageProperty r1) {
            this.mdoc_image = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder doc_state_button(DocStateButtonProperty r1) {
            this.mdoc_state_button = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mimage_container = null;
            return this;
        }

        public Builder empty(EmptyProperty r1) {
            this.mempty = r1;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder engine(EngineProperty r1) {
            this.mengine = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder flex_layout(FlexLayoutProperty r1) {
            this.mflex_layout = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder header(PreviewHeaderProperty r1) {
            this.mheader = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder icon_button(IconButtonProperty r1) {
            this.micon_button = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder image(ImageProperty r1) {
            this.mimage = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder image_container(ImageContainerProperty r1) {
            this.mimage_container = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            return this;
        }

        public Builder is_font_zoomable(Boolean r1) {
            this.mis_font_zoomable = r1;
            return this;
        }

        public Builder linear_layout(LinearLayoutProperty r1) {
            this.mlinear_layout = r1;
            this.mempty = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder loading(LoadingProperty r1) {
            this.mloading = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder oversized_text(OversizedTextProperty r1) {
            this.moversized_text = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder richtext(RichTextProperty r1) {
            this.mrichtext = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder spin_button(SpinButtonProperty r1) {
            this.mspin_button = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder style(Style r1) {
            this.mstyle = r1;
            return this;
        }

        public Builder tag_list(TagListProperty r1) {
            this.mtag_list = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder text(TextProperty r1) {
            this.mtext = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder text_button(TextButtonProperty r1) {
            this.mtext_button = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder time(TimeProperty r1) {
            this.mtime = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder time_zone(TimeZoneProperty r1) {
            this.mtime_zone = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mvideo = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }

        public Builder video(VideoProperty r1) {
            this.mvideo = r1;
            this.mempty = null;
            this.mlinear_layout = null;
            this.mflex_layout = null;
            this.mheader = null;
            this.mrichtext = null;
            this.mimage = null;
            this.mchatters_preview = null;
            this.mbutton = null;
            this.micon_button = null;
            this.mtext_button = null;
            this.mtime = null;
            this.mtext = null;
            this.mtag_list = null;
            this.mspin_button = null;
            this.mavatar = null;
            this.mcard_container = null;
            this.mdoc_image = null;
            this.mloading = null;
            this.mtime_zone = null;
            this.moversized_text = null;
            this.mengine = null;
            this.mdoc_state_button = null;
            this.mimage_container = null;
            return this;
        }
    }

    public static final class ButtonProperty extends com.squareup.wire.Message<ButtonProperty, Builder> {
        public static final ProtoAdapter<ButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_IS_DISABLE = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final Direction mdirection;
        public final ImageSetV2 micon;
        public final Boolean mis_disable;
        public final String mtext;
        public final UDIcon mud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonProperty, Builder> {
            public String maction_id;
            public Direction mdirection;
            public ImageSetV2 micon;
            public Boolean mis_disable;
            public String mtext;
            public UDIcon mud_icon;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ButtonProperty m1585build() {
                return new ButtonProperty(this.micon, this.mtext, this.mdirection, this.maction_id, this.mis_disable, this.mud_icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1585build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder direction(Direction r1) {
                this.mdirection = r1;
                return this;
            }

            public Builder icon(ImageSetV2 r1) {
                this.micon = r1;
                return this;
            }

            public Builder is_disable(Boolean r1) {
                this.mis_disable = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }

            public Builder ud_icon(UDIcon r1) {
                this.mud_icon = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonProperty extends ProtoAdapter<ButtonProperty> {
            public ProtoAdapter_ButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonProperty.class);
            }

            public ButtonProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mtext = "";
                r0.maction_id = "";
                r0.mis_disable = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L16;
                switch(r3) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L18;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L18:
                r0.mdirection = (Direction) Direction.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mud_icon = (UDIcon) UDIcon.ADAPTER.decode(r9);
                goto L3
            L8:
                r0.mis_disable = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L9:
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L14:
                r0.mtext = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L15:
                r0.micon = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L16:
                r9.endMessage(r1);
                return r0.m1585build();
            }

            public int encodedSize(ButtonProperty r6) {
                ImageSetV2 r0 = r6.micon;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetV2.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mtext;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Direction r7 = r6.mdirection;
                if (r7 == null) goto L13;
                int r8 = Direction.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.maction_id;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.mis_disable;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                UDIcon r16 = r6.mud_icon;
                if (r16 == null) goto L26;
                r1 = UDIcon.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                return (r15 + r1) + r6.unknownFields().size();
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1586decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ButtonProperty) r1);
            }

            public void encode(ProtoWriter r4, ButtonProperty r5) throws IOException {
                ImageSetV2 r0 = r5.micon;
                if (r0 == null) goto L5;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mtext;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Direction r2 = r5.mdirection;
                if (r2 == null) goto L11;
                Direction.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.maction_id;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.mis_disable;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
            L17:
                UDIcon r7 = r5.mud_icon;
                if (r7 == null) goto L20;
                UDIcon.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ButtonProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonProperty();
            DEFAULT_IS_DISABLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1584newBuilder() {
            Builder r0 = new Builder();
            r0.micon = this.micon;
            r0.mtext = this.mtext;
            r0.mdirection = this.mdirection;
            r0.maction_id = this.maction_id;
            r0.mis_disable = this.mis_disable;
            r0.mud_icon = this.mud_icon;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1584newBuilder();
        }

        public ButtonProperty(ImageSetV2 r9, String r10, Direction r11, String r12, Boolean r13, UDIcon r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public ButtonProperty(ImageSetV2 r2, String r3, Direction r4, String r5, Boolean r6, UDIcon r7, ByteString r8) {
            super(ADAPTER, r8);
            this.micon = r2;
            this.mtext = r3;
            this.mdirection = r4;
            this.maction_id = r5;
            this.mis_disable = r6;
            this.mud_icon = r7;
        }
    }

    public static final class CardContainerProperty extends com.squareup.wire.Message<CardContainerProperty, Builder> {
        public static final ProtoAdapter<CardContainerProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ThemeColor mmask_color;

        public static final class Builder extends com.squareup.wire.Message.Builder<CardContainerProperty, Builder> {
            public ThemeColor mmask_color;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CardContainerProperty m1588build() {
                return new CardContainerProperty(this.mmask_color, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1588build();
            }

            public Builder mask_color(ThemeColor r1) {
                this.mmask_color = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CardContainerProperty extends ProtoAdapter<CardContainerProperty> {
            public ProtoAdapter_CardContainerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, CardContainerProperty.class);
            }

            public CardContainerProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mmask_color = (ThemeColor) ThemeColor.ADAPTER.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1588build();
            }

            public int encodedSize(CardContainerProperty r4) {
                ThemeColor r0 = r4.mmask_color;
                if (r0 == null) goto L5;
                int r1 = ThemeColor.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1589decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CardContainerProperty) r1);
            }

            public void encode(ProtoWriter r4, CardContainerProperty r5) throws IOException {
                ThemeColor r0 = r5.mmask_color;
                if (r0 == null) goto L5;
                ThemeColor.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CardContainerProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CardContainerProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1587newBuilder() {
            Builder r0 = new Builder();
            r0.mmask_color = this.mmask_color;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CardContainerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1587newBuilder();
        }

        public CardContainerProperty(ThemeColor r2) {
            this(r2, ByteString.EMPTY);
        }

        public CardContainerProperty(ThemeColor r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mmask_color = r2;
        }
    }

    public static final class ChattersPreviewProperty extends com.squareup.wire.Message<ChattersPreviewProperty, Builder> {
        public static final ProtoAdapter<ChattersPreviewProperty> ADAPTER = null;
        public static final Integer DEFAULT_CHATTERS_COUNT = null;
        public static final Integer DEFAULT_MAX_SHOW_COUNT = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final List<ChatterInfo> mchatter_infos;
        public final Integer mchatters_count;
        public final ChattersMode mchatters_mode;
        public final Integer mmax_show_count;
        public final Theme mtheme;
        public final String mtitle;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChattersPreviewProperty, Builder> {
            public List<ChatterInfo> mchatter_infos;
            public Integer mchatters_count;
            public ChattersMode mchatters_mode;
            public Integer mmax_show_count;
            public Theme mtheme;
            public String mtitle;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChattersPreviewProperty m1591build() {
                return new ChattersPreviewProperty(this.mtheme, this.mchatters_count, this.mchatter_infos, this.mmax_show_count, this.mchatters_mode, this.mtitle, super.buildUnknownFields());
            }

            public Builder() {
                this.mchatter_infos = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1591build();
            }

            public Builder chatter_infos(List<ChatterInfo> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchatter_infos = r1;
                return this;
            }

            public Builder chatters_count(Integer r1) {
                this.mchatters_count = r1;
                return this;
            }

            public Builder chatters_mode(ChattersMode r1) {
                this.mchatters_mode = r1;
                return this;
            }

            public Builder max_show_count(Integer r1) {
                this.mmax_show_count = r1;
                return this;
            }

            public Builder theme(Theme r1) {
                this.mtheme = r1;
                return this;
            }

            public Builder title(String r1) {
                this.mtitle = r1;
                return this;
            }
        }

        public static final class ChatterInfo extends com.squareup.wire.Message<ChatterInfo, Builder> {
            public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
            public static final String DEFAULT_CHATTER_ID = "";
            public static final String DEFAULT_NAME = "";
            private static final long serialVersionUID = 0;
            public final Image mavatar;
            public final String mchatter_id;
            public final String mname;
            public final ChatterType mtype;

            public static final class Builder extends com.squareup.wire.Message.Builder<ChatterInfo, Builder> {
                public Image mavatar;
                public String mchatter_id;
                public String mname;
                public ChatterType mtype;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public ChatterInfo m1593build() {
                    return new ChatterInfo(this.mavatar, this.mchatter_id, this.mname, this.mtype, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1593build();
                }

                public Builder avatar(Image r1) {
                    this.mavatar = r1;
                    return this;
                }

                public Builder chatter_id(String r1) {
                    this.mchatter_id = r1;
                    return this;
                }

                public Builder name(String r1) {
                    this.mname = r1;
                    return this;
                }

                public Builder type(ChatterType r1) {
                    this.mtype = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_ChatterInfo extends ProtoAdapter<ChatterInfo> {
                public ProtoAdapter_ChatterInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, ChatterInfo.class);
                }

                public ChatterInfo decode(ProtoReader r9) throws IOException {
                    Builder r0 = new Builder();
                    r0.mchatter_id = "";
                    r0.mname = "";
                    long r1 = r9.beginMessage();
                L3:
                    int r3 = r9.nextTag();
                    if (r3 == (-1)) goto L21;
                    if (r3 != 1) goto L8;
                    r0.mavatar = (Image) Image.ADAPTER.decode(r9);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mchatter_id = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.mname = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L12:
                    if (r3 != 4) goto L13;
                    r0.mtype = (ChatterType) ChatterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L13:
                    FieldEncoding r4 = r9.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                    goto L3
                L21:
                    r9.endMessage(r1);
                    return r0.m1593build();
                }

                public int encodedSize(ChatterInfo r6) {
                    Image r0 = r6.mavatar;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = Image.ADAPTER.encodedSizeWithTag(1, r0);
                L6:
                    String r3 = r6.mchatter_id;
                    if (r3 == null) goto L9;
                    int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
                L10:
                    int r5 = r2 + r4;
                    String r7 = r6.mname;
                    if (r7 == null) goto L13;
                    int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
                L14:
                    int r9 = r5 + r8;
                    ChatterType r10 = r6.mtype;
                    if (r10 == null) goto L18;
                    r1 = ChatterType.ADAPTER.encodedSizeWithTag(4, r10);
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
                public /* bridge */ /* synthetic */ Object m1594decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((ChatterInfo) r1);
                }

                public void encode(ProtoWriter r4, ChatterInfo r5) throws IOException {
                    Image r0 = r5.mavatar;
                    if (r0 == null) goto L5;
                    Image.ADAPTER.encodeWithTag(r4, 1, r0);
                L5:
                    String r1 = r5.mchatter_id;
                    if (r1 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
                L8:
                    String r2 = r5.mname;
                    if (r2 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
                L11:
                    ChatterType r3 = r5.mtype;
                    if (r3 == null) goto L14;
                    ChatterType.ADAPTER.encodeWithTag(r4, 4, r3);
                L14:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (ChatterInfo) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ChatterInfo();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1592newBuilder() {
                Builder r0 = new Builder();
                r0.mavatar = this.mavatar;
                r0.mchatter_id = this.mchatter_id;
                r0.mname = this.mname;
                r0.mtype = this.mtype;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return ChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1592newBuilder();
            }

            public ChatterInfo(Image r7, String r8, String r9, ChatterType r10) {
                this(r7, r8, r9, r10, ByteString.EMPTY);
            }

            public ChatterInfo(Image r2, String r3, String r4, ChatterType r5, ByteString r6) {
                super(ADAPTER, r6);
                this.mavatar = r2;
                this.mchatter_id = r3;
                this.mname = r4;
                this.mtype = r5;
            }
        }

        public static final enum ChatterType extends Enum<ChatterType> implements WireEnum {
            private static final /* synthetic */ ChatterType[] $VALUES = null;
            public static final ProtoAdapter<ChatterType> ADAPTER = null;
            public static final ChatterType UNKNOWN = null;
            public static final ChatterType USER = null;
            private final int value;

            static {
                ChatterType r0 = new ChatterType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                ChatterType r1 = new ChatterType("USER", 1, 1);
                USER = r1;
                $VALUES = new ChatterType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChatterType.class);
            }

            public static ChatterType[] values() {
                return (ChatterType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ChatterType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return USER;
            L10:
                return UNKNOWN;
            }

            public static ChatterType valueOf(String r1) {
                return (ChatterType) a.a(ChatterType.class, r1);
            }

            private ChatterType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum ChattersMode extends Enum<ChattersMode> implements WireEnum {
            private static final /* synthetic */ ChattersMode[] $VALUES = null;
            public static final ProtoAdapter<ChattersMode> ADAPTER = null;
            public static final ChattersMode DYNAMIC = null;
            public static final ChattersMode STATIC = null;
            private final int value;

            static {
                ChattersMode r0 = new ChattersMode("STATIC", 0, 0);
                STATIC = r0;
                ChattersMode r1 = new ChattersMode("DYNAMIC", 1, 1);
                DYNAMIC = r1;
                $VALUES = new ChattersMode[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChattersMode.class);
            }

            public static ChattersMode[] values() {
                return (ChattersMode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ChattersMode fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return DYNAMIC;
            L10:
                return STATIC;
            }

            public static ChattersMode valueOf(String r1) {
                return (ChattersMode) a.a(ChattersMode.class, r1);
            }

            private ChattersMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ChattersPreviewProperty extends ProtoAdapter<ChattersPreviewProperty> {
            public ProtoAdapter_ChattersPreviewProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ChattersPreviewProperty.class);
            }

            public ChattersPreviewProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mchatters_count = 0;
                r0.mmax_show_count = 5;
                r0.mtitle = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L19;
                switch(r3) {
                    case 1: goto L23;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L21;
                    case 6: goto L7;
                    default: goto L6;
                };
            L21:
                r0.mchatters_mode = (ChattersMode) ChattersMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L23:
                r0.mtheme = (Theme) Theme.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mtitle = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L12:
                r0.mmax_show_count = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L13:
                r0.mchatter_infos.add((ChatterInfo) ChatterInfo.ADAPTER.decode(r9));
                goto L3
            L14:
                r0.mchatters_count = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L19:
                r9.endMessage(r1);
                return r0.m1591build();
            }

            public int encodedSize(ChattersPreviewProperty r6) {
                Theme r0 = r6.mtheme;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Theme.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mchatters_count;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                int r5 = (r2 + r4) + ChatterInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, r6.mchatter_infos);
                Integer r7 = r6.mmax_show_count;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.INT32.encodedSizeWithTag(4, r7);
            L14:
                int r9 = r5 + r8;
                ChattersMode r10 = r6.mchatters_mode;
                if (r10 == null) goto L17;
                int r11 = ChattersMode.ADAPTER.encodedSizeWithTag(5, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.mtitle;
                if (r13 == null) goto L22;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1595decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChattersPreviewProperty) r1);
            }

            public void encode(ProtoWriter r4, ChattersPreviewProperty r5) throws IOException {
                Theme r0 = r5.mtheme;
                if (r0 == null) goto L5;
                Theme.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mchatters_count;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                ChatterInfo.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mchatter_infos);
                Integer r2 = r5.mmax_show_count;
                if (r2 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r4, 4, r2);
            L11:
                ChattersMode r3 = r5.mchatters_mode;
                if (r3 == null) goto L14;
                ChattersMode.ADAPTER.encodeWithTag(r4, 5, r3);
            L14:
                String r6 = r5.mtitle;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChattersPreviewProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChattersPreviewProperty();
            DEFAULT_CHATTERS_COUNT = 0;
            DEFAULT_MAX_SHOW_COUNT = 5;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1590newBuilder() {
            Builder r0 = new Builder();
            r0.mtheme = this.mtheme;
            r0.mchatters_count = this.mchatters_count;
            r0.mchatter_infos = Internal.copyOf("mchatter_infos", this.mchatter_infos);
            r0.mmax_show_count = this.mmax_show_count;
            r0.mchatters_mode = this.mchatters_mode;
            r0.mtitle = this.mtitle;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChattersPreviewProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1590newBuilder();
        }

        public ChattersPreviewProperty(Theme r9, Integer r10, List<ChatterInfo> r11, Integer r12, ChattersMode r13, String r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public ChattersPreviewProperty(Theme r2, Integer r3, List<ChatterInfo> r4, Integer r5, ChattersMode r6, String r7, ByteString r8) {
            super(ADAPTER, r8);
            this.mtheme = r2;
            this.mchatters_count = r3;
            this.mchatter_infos = Internal.immutableCopyOf("mchatter_infos", r4);
            this.mmax_show_count = r5;
            this.mchatters_mode = r6;
            this.mtitle = r7;
        }
    }

    public static final enum Direction extends Enum<Direction> implements WireEnum {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final ProtoAdapter<Direction> ADAPTER = null;
        public static final Direction LTR = null;
        public static final Direction RTL = null;
        private final int value;

        static {
            Direction r0 = new Direction("LTR", 0, 0);
            LTR = r0;
            Direction r1 = new Direction("RTL", 1, 1);
            RTL = r1;
            $VALUES = new Direction[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Direction.class);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Direction fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return RTL;
        L10:
            return LTR;
        }

        public static Direction valueOf(String r1) {
            return (Direction) a.a(Direction.class, r1);
        }

        private Direction(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class DocImageProperty extends com.squareup.wire.Message<DocImageProperty, Builder> {
        public static final ProtoAdapter<DocImageProperty> ADAPTER = null;
        public static final String DEFAULT_SECRET_KEY = "";
        public static final String DEFAULT_SECRET_NONCE = "";
        public static final Integer DEFAULT_SECRET_TYPE = null;
        public static final String DEFAULT_SECRET_URL = "";
        public static final Boolean DEFAULT_SUPPORT_PREVIEW = null;
        public static final String DEFAULT_THUMBNAIL_URL = "";
        private static final long serialVersionUID = 0;
        public final DocType mdoc_type;
        public final String msecret_key;
        public final String msecret_nonce;
        public final Integer msecret_type;
        public final String msecret_url;
        public final Boolean msupport_preview;
        public final String mthumbnail_url;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocImageProperty, Builder> {
            public DocType mdoc_type;
            public String msecret_key;
            public String msecret_nonce;
            public Integer msecret_type;
            public String msecret_url;
            public Boolean msupport_preview;
            public String mthumbnail_url;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocImageProperty m1597build() {
                return new DocImageProperty(this.mdoc_type, this.mthumbnail_url, this.msecret_url, this.msecret_type, this.msecret_key, this.msecret_nonce, this.msupport_preview, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1597build();
            }

            public Builder doc_type(DocType r1) {
                this.mdoc_type = r1;
                return this;
            }

            public Builder secret_key(String r1) {
                this.msecret_key = r1;
                return this;
            }

            public Builder secret_nonce(String r1) {
                this.msecret_nonce = r1;
                return this;
            }

            public Builder secret_type(Integer r1) {
                this.msecret_type = r1;
                return this;
            }

            public Builder secret_url(String r1) {
                this.msecret_url = r1;
                return this;
            }

            public Builder support_preview(Boolean r1) {
                this.msupport_preview = r1;
                return this;
            }

            public Builder thumbnail_url(String r1) {
                this.mthumbnail_url = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DocImageProperty extends ProtoAdapter<DocImageProperty> {
            public ProtoAdapter_DocImageProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DocImageProperty.class);
            }

            public DocImageProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mthumbnail_url = "";
                r0.msecret_url = "";
                r0.msecret_type = 0;
                r0.msecret_key = "";
                r0.msecret_nonce = "";
                r0.msupport_preview = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L17;
                switch(r3) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r0.mdoc_type = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.msupport_preview = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L8:
                r0.msecret_nonce = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L9:
                r0.msecret_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                r0.msecret_type = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L11:
                r0.msecret_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L12:
                r0.mthumbnail_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L17:
                r9.endMessage(r1);
                return r0.m1597build();
            }

            public int encodedSize(DocImageProperty r6) {
                DocType r0 = r6.mdoc_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = DocType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mthumbnail_url;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.msecret_url;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Integer r10 = r6.msecret_type;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.msecret_key;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                String r16 = r6.msecret_nonce;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Boolean r19 = r6.msupport_preview;
                if (r19 == null) goto L30;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
            L30:
                return (r18 + r1) + r6.unknownFields().size();
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1598decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocImageProperty) r1);
            }

            public void encode(ProtoWriter r4, DocImageProperty r5) throws IOException {
                DocType r0 = r5.mdoc_type;
                if (r0 == null) goto L5;
                DocType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mthumbnail_url;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.msecret_url;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                Integer r3 = r5.msecret_type;
                if (r3 == null) goto L14;
                ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
            L14:
                String r6 = r5.msecret_key;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
            L17:
                String r7 = r5.msecret_nonce;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
            L20:
                Boolean r8 = r5.msupport_preview;
                if (r8 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
            L23:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocImageProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocImageProperty();
            DEFAULT_SECRET_TYPE = 0;
            DEFAULT_SUPPORT_PREVIEW = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1596newBuilder() {
            Builder r0 = new Builder();
            r0.mdoc_type = this.mdoc_type;
            r0.mthumbnail_url = this.mthumbnail_url;
            r0.msecret_url = this.msecret_url;
            r0.msecret_type = this.msecret_type;
            r0.msecret_key = this.msecret_key;
            r0.msecret_nonce = this.msecret_nonce;
            r0.msupport_preview = this.msupport_preview;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocImageProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1596newBuilder();
        }

        public DocImageProperty(DocType r10, String r11, String r12, Integer r13, String r14, String r15, Boolean r16) {
            this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
        }

        public DocImageProperty(DocType r2, String r3, String r4, Integer r5, String r6, String r7, Boolean r8, ByteString r9) {
            super(ADAPTER, r9);
            this.mdoc_type = r2;
            this.mthumbnail_url = r3;
            this.msecret_url = r4;
            this.msecret_type = r5;
            this.msecret_key = r6;
            this.msecret_nonce = r7;
            this.msupport_preview = r8;
        }
    }

    public static final class DocStateButtonProperty extends com.squareup.wire.Message<DocStateButtonProperty, Builder> {
        public static final ProtoAdapter<DocStateButtonProperty> ADAPTER = null;
        public static final String DEFAULT_CURR_STATE = "";
        private static final long serialVersionUID = 0;
        public final String mcurr_state;
        public final Map<String, DocState> mstate_map;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocStateButtonProperty, Builder> {
            public String mcurr_state;
            public Map<String, DocState> mstate_map;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocStateButtonProperty m1600build() {
                return new DocStateButtonProperty(this.mcurr_state, this.mstate_map, super.buildUnknownFields());
            }

            public Builder() {
                this.mstate_map = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1600build();
            }

            public Builder curr_state(String r1) {
                this.mcurr_state = r1;
                return this;
            }

            public Builder state_map(Map<String, DocState> r1) {
                Internal.checkElementsNotNull(r1);
                this.mstate_map = r1;
                return this;
            }
        }

        public static final class DocState extends com.squareup.wire.Message<DocState, Builder> {
            public static final ProtoAdapter<DocState> ADAPTER = null;
            public static final String DEFAULT_ALT = "";
            public static final Boolean DEFAULT_LOADING = null;
            public static final String DEFAULT_NEXT_STATE = "";
            public static final Boolean DEFAULT_SELECTED = null;
            public static final String DEFAULT_UD_BTN_COLOR = "";
            private static final long serialVersionUID = 0;
            public final String malt;
            public final Boolean mloading;
            public final String mnext_state;
            public final Boolean mselected;
            public final String mud_btn_color;
            public final UDIcon mud_icon;

            public static final class Builder extends com.squareup.wire.Message.Builder<DocState, Builder> {
                public String malt;
                public Boolean mloading;
                public String mnext_state;
                public Boolean mselected;
                public String mud_btn_color;
                public UDIcon mud_icon;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public DocState m1602build() {
                    return new DocState(this.malt, this.mud_icon, this.mnext_state, this.mud_btn_color, this.mloading, this.mselected, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1602build();
                }

                public Builder alt(String r1) {
                    this.malt = r1;
                    return this;
                }

                public Builder loading(Boolean r1) {
                    this.mloading = r1;
                    return this;
                }

                public Builder next_state(String r1) {
                    this.mnext_state = r1;
                    return this;
                }

                public Builder selected(Boolean r1) {
                    this.mselected = r1;
                    return this;
                }

                public Builder ud_btn_color(String r1) {
                    this.mud_btn_color = r1;
                    return this;
                }

                public Builder ud_icon(UDIcon r1) {
                    this.mud_icon = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_DocState extends ProtoAdapter<DocState> {
                public ProtoAdapter_DocState() {
                    super(FieldEncoding.LENGTH_DELIMITED, DocState.class);
                }

                public DocState decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.malt = "";
                    r0.mnext_state = "";
                    r0.mud_btn_color = "";
                    Boolean r1 = Boolean.FALSE;
                    r0.mloading = r1;
                    r0.mselected = r1;
                    long r2 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L13;
                    switch(r3) {
                        case 1: goto L12;
                        case 2: goto L11;
                        case 3: goto L10;
                        case 4: goto L9;
                        case 5: goto L8;
                        case 6: goto L7;
                        default: goto L6;
                    };
                L7:
                    r0.mselected = (Boolean) ProtoAdapter.BOOL.decode(r7);
                    goto L3
                L8:
                    r0.mloading = (Boolean) ProtoAdapter.BOOL.decode(r7);
                    goto L3
                L9:
                    r0.mud_btn_color = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L10:
                    r0.mnext_state = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L11:
                    r0.mud_icon = (UDIcon) UDIcon.ADAPTER.decode(r7);
                    goto L3
                L12:
                    r0.malt = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L6:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L13:
                    r7.endMessage(r2);
                    return r0.m1602build();
                }

                public int encodedSize(DocState r6) {
                    String r0 = r6.malt;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
                L6:
                    UDIcon r3 = r6.mud_icon;
                    if (r3 == null) goto L9;
                    int r4 = UDIcon.ADAPTER.encodedSizeWithTag(2, r3);
                L10:
                    int r5 = r2 + r4;
                    String r7 = r6.mnext_state;
                    if (r7 == null) goto L13;
                    int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
                L14:
                    int r9 = r5 + r8;
                    String r10 = r6.mud_btn_color;
                    if (r10 == null) goto L17;
                    int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
                L18:
                    int r12 = r9 + r11;
                    Boolean r13 = r6.mloading;
                    if (r13 == null) goto L21;
                    int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
                L22:
                    int r15 = r12 + r14;
                    Boolean r16 = r6.mselected;
                    if (r16 == null) goto L26;
                    r1 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
                L26:
                    return (r15 + r1) + r6.unknownFields().size();
                L21:
                    r14 = 0;
                    goto L22
                L17:
                    r11 = 0;
                    goto L18
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
                public /* bridge */ /* synthetic */ Object m1603decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((DocState) r1);
                }

                public void encode(ProtoWriter r4, DocState r5) throws IOException {
                    String r0 = r5.malt;
                    if (r0 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
                L5:
                    UDIcon r1 = r5.mud_icon;
                    if (r1 == null) goto L8;
                    UDIcon.ADAPTER.encodeWithTag(r4, 2, r1);
                L8:
                    String r2 = r5.mnext_state;
                    if (r2 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
                L11:
                    String r3 = r5.mud_btn_color;
                    if (r3 == null) goto L14;
                    ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
                L14:
                    Boolean r6 = r5.mloading;
                    if (r6 == null) goto L17;
                    ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
                L17:
                    Boolean r7 = r5.mselected;
                    if (r7 == null) goto L20;
                    ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
                L20:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (DocState) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DocState();
                Boolean r0 = Boolean.FALSE;
                DEFAULT_LOADING = r0;
                DEFAULT_SELECTED = r0;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1601newBuilder() {
                Builder r0 = new Builder();
                r0.malt = this.malt;
                r0.mud_icon = this.mud_icon;
                r0.mnext_state = this.mnext_state;
                r0.mud_btn_color = this.mud_btn_color;
                r0.mloading = this.mloading;
                r0.mselected = this.mselected;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return DocState.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1601newBuilder();
            }

            public DocState(String r9, UDIcon r10, String r11, String r12, Boolean r13, Boolean r14) {
                this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
            }

            public DocState(String r2, UDIcon r3, String r4, String r5, Boolean r6, Boolean r7, ByteString r8) {
                super(ADAPTER, r8);
                this.malt = r2;
                this.mud_icon = r3;
                this.mnext_state = r4;
                this.mud_btn_color = r5;
                this.mloading = r6;
                this.mselected = r7;
            }
        }

        public static final class ProtoAdapter_DocStateButtonProperty extends ProtoAdapter<DocStateButtonProperty> {
            private final ProtoAdapter<Map<String, DocState>> mstate_map;

            public ProtoAdapter_DocStateButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DocStateButtonProperty.class);
                this.mstate_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DocState.ADAPTER);
            }

            public DocStateButtonProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcurr_state = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mcurr_state = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mstate_map.putAll((Map) this.mstate_map.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1600build();
            }

            public int encodedSize(DocStateButtonProperty r5) {
                String r0 = r5.mcurr_state;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return (r1 + this.mstate_map.encodedSizeWithTag(2, r5.mstate_map)) + r5.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1604decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocStateButtonProperty) r1);
            }

            public void encode(ProtoWriter r4, DocStateButtonProperty r5) throws IOException {
                String r0 = r5.mcurr_state;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                this.mstate_map.encodeWithTag(r4, 2, r5.mstate_map);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocStateButtonProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocStateButtonProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1599newBuilder() {
            Builder r0 = new Builder();
            r0.mcurr_state = this.mcurr_state;
            r0.mstate_map = Internal.copyOf("mstate_map", this.mstate_map);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocStateButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1599newBuilder();
        }

        public DocStateButtonProperty(String r2, Map<String, DocState> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public DocStateButtonProperty(String r2, Map<String, DocState> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mcurr_state = r2;
            this.mstate_map = Internal.immutableCopyOf("mstate_map", r3);
        }
    }

    public static final class EmptyProperty extends com.squareup.wire.Message<EmptyProperty, Builder> {
        public static final ProtoAdapter<EmptyProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_CONTAINER_STYLE = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ThemeColor mactive;
        public final String mcontainer_style;
        public final ThemeColor mhover;

        public static final class Builder extends com.squareup.wire.Message.Builder<EmptyProperty, Builder> {
            public String maction_id;
            public ThemeColor mactive;
            public String mcontainer_style;
            public ThemeColor mhover;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public EmptyProperty m1606build() {
                return new EmptyProperty(this.maction_id, this.mhover, this.mactive, this.mcontainer_style, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1606build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder active(ThemeColor r1) {
                this.mactive = r1;
                return this;
            }

            public Builder container_style(String r1) {
                this.mcontainer_style = r1;
                return this;
            }

            public Builder hover(ThemeColor r1) {
                this.mhover = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_EmptyProperty extends ProtoAdapter<EmptyProperty> {
            public ProtoAdapter_EmptyProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, EmptyProperty.class);
            }

            public EmptyProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.mcontainer_style = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mhover = (ThemeColor) ThemeColor.ADAPTER.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mactive = (ThemeColor) ThemeColor.ADAPTER.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mcontainer_style = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m1606build();
            }

            public int encodedSize(EmptyProperty r6) {
                String r0 = r6.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                ThemeColor r3 = r6.mhover;
                if (r3 == null) goto L9;
                int r4 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                ThemeColor r7 = r6.mactive;
                if (r7 == null) goto L13;
                int r8 = ThemeColor.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mcontainer_style;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
            public /* bridge */ /* synthetic */ Object m1607decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((EmptyProperty) r1);
            }

            public void encode(ProtoWriter r4, EmptyProperty r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                ThemeColor r1 = r5.mhover;
                if (r1 == null) goto L8;
                ThemeColor.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                ThemeColor r2 = r5.mactive;
                if (r2 == null) goto L11;
                ThemeColor.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mcontainer_style;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (EmptyProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EmptyProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1605newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.mhover = this.mhover;
            r0.mactive = this.mactive;
            r0.mcontainer_style = this.mcontainer_style;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return EmptyProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1605newBuilder();
        }

        public EmptyProperty(String r7, ThemeColor r8, ThemeColor r9, String r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public EmptyProperty(String r2, ThemeColor r3, ThemeColor r4, String r5, ByteString r6) {
            super(ADAPTER, r6);
            this.maction_id = r2;
            this.mhover = r3;
            this.mactive = r4;
            this.mcontainer_style = r5;
        }
    }

    public static final class EngineProperty extends com.squareup.wire.Message<EngineProperty, Builder> {
        public static final ProtoAdapter<EngineProperty> ADAPTER = null;
        public static final ByteString DEFAULT_BODY = null;
        private static final long serialVersionUID = 0;
        public final ByteString mbody;
        public final EngineType mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<EngineProperty, Builder> {
            public ByteString mbody;
            public EngineType mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public EngineProperty m1609build() {
                return new EngineProperty(this.mtype, this.mbody, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1609build();
            }

            public Builder body(ByteString r1) {
                this.mbody = r1;
                return this;
            }

            public Builder type(EngineType r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final enum EngineType extends Enum<EngineType> implements WireEnum {
            private static final /* synthetic */ EngineType[] $VALUES = null;
            public static final ProtoAdapter<EngineType> ADAPTER = null;
            public static final EngineType DOC_COMPONENT = null;
            public static final EngineType MESSAGE = null;
            public static final EngineType TURTLE_CANVAS = null;
            private final int value;

            static {
                EngineType r0 = new EngineType("MESSAGE", 0, 0);
                MESSAGE = r0;
                EngineType r1 = new EngineType("DOC_COMPONENT", 1, 1);
                DOC_COMPONENT = r1;
                EngineType r3 = new EngineType("TURTLE_CANVAS", 2, 2);
                TURTLE_CANVAS = r3;
                $VALUES = new EngineType[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(EngineType.class);
            }

            public static EngineType[] values() {
                return (EngineType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static EngineType fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return TURTLE_CANVAS;
            L12:
                return DOC_COMPONENT;
            L14:
                return MESSAGE;
            }

            public static EngineType valueOf(String r1) {
                return (EngineType) a.a(EngineType.class, r1);
            }

            private EngineType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_EngineProperty extends ProtoAdapter<EngineProperty> {
            public ProtoAdapter_EngineProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, EngineProperty.class);
            }

            public EngineProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mbody = ByteString.EMPTY;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtype = (EngineType) EngineType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mbody = (ByteString) ProtoAdapter.BYTES.decode(r9);
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m1609build();
            }

            public int encodedSize(EngineProperty r5) {
                EngineType r0 = r5.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = EngineType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ByteString r3 = r5.mbody;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1610decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((EngineProperty) r1);
            }

            public void encode(ProtoWriter r4, EngineProperty r5) throws IOException {
                EngineType r0 = r5.mtype;
                if (r0 == null) goto L5;
                EngineType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                ByteString r1 = r5.mbody;
                if (r1 == null) goto L8;
                ProtoAdapter.BYTES.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (EngineProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EngineProperty();
            DEFAULT_BODY = ByteString.EMPTY;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1608newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mbody = this.mbody;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return EngineProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1608newBuilder();
        }

        public EngineProperty(EngineType r2, ByteString r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public EngineProperty(EngineType r2, ByteString r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtype = r2;
            this.mbody = r3;
        }
    }

    public static final class FlexLayoutProperty extends com.squareup.wire.Message<FlexLayoutProperty, Builder> {
        public static final ProtoAdapter<FlexLayoutProperty> ADAPTER = null;
        public static final Float DEFAULT_CROSS_AXIS_SPACING = null;
        public static final Boolean DEFAULT_FORCE_USE_NARROW_MODE = null;
        public static final Float DEFAULT_MAIN_AXIS_SPACING = null;
        private static final long serialVersionUID = 0;
        public final Align mcross_axis_align;
        public final Float mcross_axis_spacing;
        public final FlexWrap mflex_wrap;
        public final Boolean mforce_use_narrow_mode;
        public final Justify mmain_axis_justify;
        public final Float mmain_axis_spacing;
        public final Orientation morientation;
        public final Padding mpadding;

        public static final class Builder extends com.squareup.wire.Message.Builder<FlexLayoutProperty, Builder> {
            public Align mcross_axis_align;
            public Float mcross_axis_spacing;
            public FlexWrap mflex_wrap;
            public Boolean mforce_use_narrow_mode;
            public Justify mmain_axis_justify;
            public Float mmain_axis_spacing;
            public Orientation morientation;
            public Padding mpadding;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FlexLayoutProperty m1612build() {
                return new FlexLayoutProperty(this.morientation, this.mflex_wrap, this.mmain_axis_spacing, this.mcross_axis_spacing, this.mpadding, this.mmain_axis_justify, this.mcross_axis_align, this.mforce_use_narrow_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1612build();
            }

            public Builder cross_axis_align(Align r1) {
                this.mcross_axis_align = r1;
                return this;
            }

            public Builder cross_axis_spacing(Float r1) {
                this.mcross_axis_spacing = r1;
                return this;
            }

            public Builder flex_wrap(FlexWrap r1) {
                this.mflex_wrap = r1;
                return this;
            }

            public Builder force_use_narrow_mode(Boolean r1) {
                this.mforce_use_narrow_mode = r1;
                return this;
            }

            public Builder main_axis_justify(Justify r1) {
                this.mmain_axis_justify = r1;
                return this;
            }

            public Builder main_axis_spacing(Float r1) {
                this.mmain_axis_spacing = r1;
                return this;
            }

            public Builder orientation(Orientation r1) {
                this.morientation = r1;
                return this;
            }

            public Builder padding(Padding r1) {
                this.mpadding = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_FlexLayoutProperty extends ProtoAdapter<FlexLayoutProperty> {
            public ProtoAdapter_FlexLayoutProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, FlexLayoutProperty.class);
            }

            public FlexLayoutProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Float r1 = Float.valueOf(0.0f);
                r0.mmain_axis_spacing = r1;
                r0.mcross_axis_spacing = r1;
                r0.mforce_use_narrow_mode = Boolean.FALSE;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L27;
                switch(r3) {
                    case 1: goto L33;
                    case 2: goto L35;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L29;
                    case 7: goto L31;
                    case 8: goto L7;
                    default: goto L6;
                };
            L29:
                r0.mmain_axis_justify = (Justify) Justify.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L31:
                r0.mcross_axis_align = (Align) Align.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L33:
                r0.morientation = (Orientation) Orientation.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L35:
                r0.mflex_wrap = (FlexWrap) FlexWrap.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mforce_use_narrow_mode = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L16:
                r0.mpadding = (Padding) Padding.ADAPTER.decode(r9);
                goto L3
            L17:
                r0.mcross_axis_spacing = (Float) ProtoAdapter.FLOAT.decode(r9);
                goto L3
            L18:
                r0.mmain_axis_spacing = (Float) ProtoAdapter.FLOAT.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L27:
                r9.endMessage(r2);
                return r0.m1612build();
            }

            public int encodedSize(FlexLayoutProperty r6) {
                Orientation r0 = r6.morientation;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Orientation.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                FlexWrap r3 = r6.mflex_wrap;
                if (r3 == null) goto L9;
                int r4 = FlexWrap.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Float r7 = r6.mmain_axis_spacing;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Float r10 = r6.mcross_axis_spacing;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Padding r13 = r6.mpadding;
                if (r13 == null) goto L21;
                int r14 = Padding.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                Justify r16 = r6.mmain_axis_justify;
                if (r16 == null) goto L25;
                int r17 = Justify.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Align r19 = r6.mcross_axis_align;
                if (r19 == null) goto L29;
                int r20 = Align.ADAPTER.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                Boolean r22 = r6.mforce_use_narrow_mode;
                if (r22 == null) goto L34;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
            L34:
                return (r21 + r1) + r6.unknownFields().size();
            L29:
                r20 = 0;
                goto L30
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1613decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((FlexLayoutProperty) r1);
            }

            public void encode(ProtoWriter r4, FlexLayoutProperty r5) throws IOException {
                Orientation r0 = r5.morientation;
                if (r0 == null) goto L5;
                Orientation.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                FlexWrap r1 = r5.mflex_wrap;
                if (r1 == null) goto L8;
                FlexWrap.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                Float r2 = r5.mmain_axis_spacing;
                if (r2 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 3, r2);
            L11:
                Float r3 = r5.mcross_axis_spacing;
                if (r3 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 4, r3);
            L14:
                Padding r6 = r5.mpadding;
                if (r6 == null) goto L17;
                Padding.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                Justify r7 = r5.mmain_axis_justify;
                if (r7 == null) goto L20;
                Justify.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                Align r8 = r5.mcross_axis_align;
                if (r8 == null) goto L23;
                Align.ADAPTER.encodeWithTag(r4, 7, r8);
            L23:
                Boolean r9 = r5.mforce_use_narrow_mode;
                if (r9 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r4, 8, r9);
            L26:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (FlexLayoutProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FlexLayoutProperty();
            Float r0 = Float.valueOf(0.0f);
            DEFAULT_MAIN_AXIS_SPACING = r0;
            DEFAULT_CROSS_AXIS_SPACING = r0;
            DEFAULT_FORCE_USE_NARROW_MODE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1611newBuilder() {
            Builder r0 = new Builder();
            r0.morientation = this.morientation;
            r0.mflex_wrap = this.mflex_wrap;
            r0.mmain_axis_spacing = this.mmain_axis_spacing;
            r0.mcross_axis_spacing = this.mcross_axis_spacing;
            r0.mpadding = this.mpadding;
            r0.mmain_axis_justify = this.mmain_axis_justify;
            r0.mcross_axis_align = this.mcross_axis_align;
            r0.mforce_use_narrow_mode = this.mforce_use_narrow_mode;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FlexLayoutProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1611newBuilder();
        }

        public FlexLayoutProperty(Orientation r11, FlexWrap r12, Float r13, Float r14, Padding r15, Justify r16, Align r17, Boolean r18) {
            this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
        }

        public FlexLayoutProperty(Orientation r2, FlexWrap r3, Float r4, Float r5, Padding r6, Justify r7, Align r8, Boolean r9, ByteString r10) {
            super(ADAPTER, r10);
            this.morientation = r2;
            this.mflex_wrap = r3;
            this.mmain_axis_spacing = r4;
            this.mcross_axis_spacing = r5;
            this.mpadding = r6;
            this.mmain_axis_justify = r7;
            this.mcross_axis_align = r8;
            this.mforce_use_narrow_mode = r9;
        }
    }

    public static final enum FlexWrap extends Enum<FlexWrap> implements WireEnum {
        private static final /* synthetic */ FlexWrap[] $VALUES = null;
        public static final ProtoAdapter<FlexWrap> ADAPTER = null;
        public static final FlexWrap LINEAR_WRAP = null;
        public static final FlexWrap NO_WRAP = null;
        public static final FlexWrap WRAP = null;
        public static final FlexWrap WRAP_REVERSE = null;
        private final int value;

        static {
            FlexWrap r0 = new FlexWrap("NO_WRAP", 0, 0);
            NO_WRAP = r0;
            FlexWrap r1 = new FlexWrap("WRAP", 1, 1);
            WRAP = r1;
            FlexWrap r3 = new FlexWrap("WRAP_REVERSE", 2, 2);
            WRAP_REVERSE = r3;
            FlexWrap r5 = new FlexWrap("LINEAR_WRAP", 3, 3);
            LINEAR_WRAP = r5;
            $VALUES = new FlexWrap[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(FlexWrap.class);
        }

        public static FlexWrap[] values() {
            return (FlexWrap[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FlexWrap fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return LINEAR_WRAP;
        L14:
            return WRAP_REVERSE;
        L16:
            return WRAP;
        L18:
            return NO_WRAP;
        }

        public static FlexWrap valueOf(String r1) {
            return (FlexWrap) a.a(FlexWrap.class, r1);
        }

        private FlexWrap(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class FontLevel extends com.squareup.wire.Message<FontLevel, Builder> {
        public static final ProtoAdapter<FontLevel> ADAPTER = null;
        public static final Integer DEFAULT_LEVEL = null;
        private static final long serialVersionUID = 0;
        public final Integer mlevel;
        public final FontType mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<FontLevel, Builder> {
            public Integer mlevel;
            public FontType mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FontLevel m1615build() {
                return new FontLevel(this.mtype, this.mlevel, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1615build();
            }

            public Builder level(Integer r1) {
                this.mlevel = r1;
                return this;
            }

            public Builder type(FontType r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_FontLevel extends ProtoAdapter<FontLevel> {
            public ProtoAdapter_FontLevel() {
                super(FieldEncoding.LENGTH_DELIMITED, FontLevel.class);
            }

            public FontLevel decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mlevel = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtype = (FontType) FontType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mlevel = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m1615build();
            }

            public int encodedSize(FontLevel r5) {
                FontType r0 = r5.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = FontType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r5.mlevel;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1616decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((FontLevel) r1);
            }

            public void encode(ProtoWriter r4, FontLevel r5) throws IOException {
                FontType r0 = r5.mtype;
                if (r0 == null) goto L5;
                FontType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mlevel;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (FontLevel) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FontLevel();
            DEFAULT_LEVEL = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1614newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mlevel = this.mlevel;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FontLevel.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1614newBuilder();
        }

        public FontLevel(FontType r2, Integer r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public FontLevel(FontType r2, Integer r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtype = r2;
            this.mlevel = r3;
        }
    }

    public static final enum FontType extends Enum<FontType> implements WireEnum {
        private static final /* synthetic */ FontType[] $VALUES = null;
        public static final ProtoAdapter<FontType> ADAPTER = null;
        public static final FontType BODY = null;
        public static final FontType CAPTION = null;
        public static final FontType HEADLINE = null;
        public static final FontType TITLE = null;
        private final int value;

        static {
            FontType r0 = new FontType("TITLE", 0, 0);
            TITLE = r0;
            FontType r1 = new FontType("HEADLINE", 1, 1);
            HEADLINE = r1;
            FontType r3 = new FontType("BODY", 2, 2);
            BODY = r3;
            FontType r5 = new FontType("CAPTION", 3, 3);
            CAPTION = r5;
            $VALUES = new FontType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(FontType.class);
        }

        public static FontType[] values() {
            return (FontType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FontType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return CAPTION;
        L14:
            return BODY;
        L16:
            return HEADLINE;
        L18:
            return TITLE;
        }

        public static FontType valueOf(String r1) {
            return (FontType) a.a(FontType.class, r1);
        }

        private FontType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class IconButtonProperty extends com.squareup.wire.Message<IconButtonProperty, Builder> {
        public static final ProtoAdapter<IconButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_ALT = "";
        public static final Boolean DEFAULT_IS_DISABLE = null;
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final String malt;
        public final ImageSetV2 micon;
        public final Boolean mis_disable;
        public final UDIcon mud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<IconButtonProperty, Builder> {
            public String maction_id;
            public String malt;
            public ImageSetV2 micon;
            public Boolean mis_disable;
            public UDIcon mud_icon;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public IconButtonProperty m1618build() {
                return new IconButtonProperty(this.micon, this.maction_id, this.mis_disable, this.malt, this.mud_icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1618build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder alt(String r1) {
                this.malt = r1;
                return this;
            }

            public Builder icon(ImageSetV2 r1) {
                this.micon = r1;
                return this;
            }

            public Builder is_disable(Boolean r1) {
                this.mis_disable = r1;
                return this;
            }

            public Builder ud_icon(UDIcon r1) {
                this.mud_icon = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_IconButtonProperty extends ProtoAdapter<IconButtonProperty> {
            public ProtoAdapter_IconButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, IconButtonProperty.class);
            }

            public IconButtonProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.mis_disable = Boolean.FALSE;
                r0.malt = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.micon = (ImageSetV2) ImageSetV2.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mis_disable = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.malt = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mud_icon = (UDIcon) UDIcon.ADAPTER.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1618build();
            }

            public int encodedSize(IconButtonProperty r6) {
                ImageSetV2 r0 = r6.micon;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetV2.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.maction_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mis_disable;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.malt;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                UDIcon r13 = r6.mud_icon;
                if (r13 == null) goto L22;
                r1 = UDIcon.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1619decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((IconButtonProperty) r1);
            }

            public void encode(ProtoWriter r4, IconButtonProperty r5) throws IOException {
                ImageSetV2 r0 = r5.micon;
                if (r0 == null) goto L5;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.maction_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mis_disable;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.malt;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                UDIcon r6 = r5.mud_icon;
                if (r6 == null) goto L17;
                UDIcon.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (IconButtonProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_IconButtonProperty();
            DEFAULT_IS_DISABLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1617newBuilder() {
            Builder r0 = new Builder();
            r0.micon = this.micon;
            r0.maction_id = this.maction_id;
            r0.mis_disable = this.mis_disable;
            r0.malt = this.malt;
            r0.mud_icon = this.mud_icon;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return IconButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1617newBuilder();
        }

        public IconButtonProperty(ImageSetV2 r8, String r9, Boolean r10, String r11, UDIcon r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public IconButtonProperty(ImageSetV2 r2, String r3, Boolean r4, String r5, UDIcon r6, ByteString r7) {
            super(ADAPTER, r7);
            this.micon = r2;
            this.maction_id = r3;
            this.mis_disable = r4;
            this.malt = r5;
            this.mud_icon = r6;
        }
    }

    public static final class ImageContainerProperty extends com.squareup.wire.Message<ImageContainerProperty, Builder> {
        public static final ProtoAdapter<ImageContainerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ImageSetV2 mbackground;
        public final ContentMode mcontent_mode;
        public final ImageSetV2 mdm_background;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageContainerProperty, Builder> {
            public String maction_id;
            public ImageSetV2 mbackground;
            public ContentMode mcontent_mode;
            public ImageSetV2 mdm_background;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ImageContainerProperty m1621build() {
                return new ImageContainerProperty(this.mbackground, this.maction_id, this.mcontent_mode, this.mdm_background, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1621build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder background(ImageSetV2 r1) {
                this.mbackground = r1;
                return this;
            }

            public Builder content_mode(ContentMode r1) {
                this.mcontent_mode = r1;
                return this;
            }

            public Builder dm_background(ImageSetV2 r1) {
                this.mdm_background = r1;
                return this;
            }
        }

        public static final enum ContentMode extends Enum<ContentMode> implements WireEnum {
            private static final /* synthetic */ ContentMode[] $VALUES = null;
            public static final ProtoAdapter<ContentMode> ADAPTER = null;
            public static final ContentMode CENTER = null;
            public static final ContentMode SCALE_ASPECT_FILL = null;
            public static final ContentMode SCALE_ASPECT_FIT = null;
            public static final ContentMode SCALE_TO_FILL = null;
            private final int value;

            static {
                ContentMode r0 = new ContentMode("SCALE_TO_FILL", 0, 0);
                SCALE_TO_FILL = r0;
                ContentMode r1 = new ContentMode("SCALE_ASPECT_FIT", 1, 1);
                SCALE_ASPECT_FIT = r1;
                ContentMode r3 = new ContentMode("SCALE_ASPECT_FILL", 2, 2);
                SCALE_ASPECT_FILL = r3;
                ContentMode r5 = new ContentMode("CENTER", 3, 3);
                CENTER = r5;
                $VALUES = new ContentMode[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContentMode.class);
            }

            public static ContentMode[] values() {
                return (ContentMode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ContentMode fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return CENTER;
            L14:
                return SCALE_ASPECT_FILL;
            L16:
                return SCALE_ASPECT_FIT;
            L18:
                return SCALE_TO_FILL;
            }

            public static ContentMode valueOf(String r1) {
                return (ContentMode) a.a(ContentMode.class, r1);
            }

            private ContentMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ImageContainerProperty extends ProtoAdapter<ImageContainerProperty> {
            public ProtoAdapter_ImageContainerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageContainerProperty.class);
            }

            public ImageContainerProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mbackground = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mcontent_mode = (ContentMode) ContentMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mdm_background = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1621build();
            }

            public int encodedSize(ImageContainerProperty r6) {
                ImageSetV2 r0 = r6.mbackground;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetV2.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.maction_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                ContentMode r7 = r6.mcontent_mode;
                if (r7 == null) goto L13;
                int r8 = ContentMode.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                ImageSetV2 r10 = r6.mdm_background;
                if (r10 == null) goto L18;
                r1 = ImageSetV2.ADAPTER.encodedSizeWithTag(4, r10);
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
            public /* bridge */ /* synthetic */ Object m1622decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ImageContainerProperty) r1);
            }

            public void encode(ProtoWriter r4, ImageContainerProperty r5) throws IOException {
                ImageSetV2 r0 = r5.mbackground;
                if (r0 == null) goto L5;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.maction_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                ContentMode r2 = r5.mcontent_mode;
                if (r2 == null) goto L11;
                ContentMode.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                ImageSetV2 r3 = r5.mdm_background;
                if (r3 == null) goto L14;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ImageContainerProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageContainerProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1620newBuilder() {
            Builder r0 = new Builder();
            r0.mbackground = this.mbackground;
            r0.maction_id = this.maction_id;
            r0.mcontent_mode = this.mcontent_mode;
            r0.mdm_background = this.mdm_background;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ImageContainerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1620newBuilder();
        }

        public ImageContainerProperty(ImageSetV2 r7, String r8, ContentMode r9, ImageSetV2 r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public ImageContainerProperty(ImageSetV2 r2, String r3, ContentMode r4, ImageSetV2 r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mbackground = r2;
            this.maction_id = r3;
            this.mcontent_mode = r4;
            this.mdm_background = r5;
        }
    }

    public static final class ImageProperty extends com.squareup.wire.Message<ImageProperty, Builder> {
        public static final ProtoAdapter<ImageProperty> ADAPTER = null;
        public static final String DEFAULT_ALT = "";
        public static final String DEFAULT_DM_IMAGE_URL = "";
        public static final String DEFAULT_IMAGE_URL = "";
        private static final long serialVersionUID = 0;
        public final String malt;
        public final ImageSetV2 mdm_image;
        public final String mdm_image_url;
        public final ImageSetV2 mimage;
        public final String mimage_url;
        public final UDIcon mud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageProperty, Builder> {
            public String malt;
            public ImageSetV2 mdm_image;
            public String mdm_image_url;
            public ImageSetV2 mimage;
            public String mimage_url;
            public UDIcon mud_icon;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ImageProperty m1624build() {
                return new ImageProperty(this.mimage, this.malt, this.mud_icon, this.mimage_url, this.mdm_image, this.mdm_image_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1624build();
            }

            public Builder alt(String r1) {
                this.malt = r1;
                return this;
            }

            public Builder dm_image(ImageSetV2 r1) {
                this.mdm_image = r1;
                return this;
            }

            public Builder dm_image_url(String r1) {
                this.mdm_image_url = r1;
                return this;
            }

            public Builder image(ImageSetV2 r1) {
                this.mimage = r1;
                return this;
            }

            public Builder image_url(String r1) {
                this.mimage_url = r1;
                return this;
            }

            public Builder ud_icon(UDIcon r1) {
                this.mud_icon = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageProperty extends ProtoAdapter<ImageProperty> {
            public ProtoAdapter_ImageProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageProperty.class);
            }

            public ImageProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.malt = "";
                r0.mimage_url = "";
                r0.mdm_image_url = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L13;
                switch(r3) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mdm_image_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                r0.mdm_image = (ImageSetV2) ImageSetV2.ADAPTER.decode(r7);
                goto L3
            L9:
                r0.mimage_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                r0.mud_icon = (UDIcon) UDIcon.ADAPTER.decode(r7);
                goto L3
            L11:
                r0.malt = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                r0.mimage = (ImageSetV2) ImageSetV2.ADAPTER.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L13:
                r7.endMessage(r1);
                return r0.m1624build();
            }

            public int encodedSize(ImageProperty r6) {
                ImageSetV2 r0 = r6.mimage;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetV2.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.malt;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                UDIcon r7 = r6.mud_icon;
                if (r7 == null) goto L13;
                int r8 = UDIcon.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mimage_url;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                ImageSetV2 r13 = r6.mdm_image;
                if (r13 == null) goto L21;
                int r14 = ImageSetV2.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                String r16 = r6.mdm_image_url;
                if (r16 == null) goto L26;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
            L26:
                return (r15 + r1) + r6.unknownFields().size();
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1625decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ImageProperty) r1);
            }

            public void encode(ProtoWriter r4, ImageProperty r5) throws IOException {
                ImageSetV2 r0 = r5.mimage;
                if (r0 == null) goto L5;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.malt;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                UDIcon r2 = r5.mud_icon;
                if (r2 == null) goto L11;
                UDIcon.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mimage_url;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                ImageSetV2 r6 = r5.mdm_image;
                if (r6 == null) goto L17;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                String r7 = r5.mdm_image_url;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ImageProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageProperty();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1623newBuilder() {
            Builder r0 = new Builder();
            r0.mimage = this.mimage;
            r0.malt = this.malt;
            r0.mud_icon = this.mud_icon;
            r0.mimage_url = this.mimage_url;
            r0.mdm_image = this.mdm_image;
            r0.mdm_image_url = this.mdm_image_url;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ImageProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1623newBuilder();
        }

        public ImageProperty(ImageSetV2 r9, String r10, UDIcon r11, String r12, ImageSetV2 r13, String r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public ImageProperty(ImageSetV2 r2, String r3, UDIcon r4, String r5, ImageSetV2 r6, String r7, ByteString r8) {
            super(ADAPTER, r8);
            this.mimage = r2;
            this.malt = r3;
            this.mud_icon = r4;
            this.mimage_url = r5;
            this.mdm_image = r6;
            this.mdm_image_url = r7;
        }
    }

    public static final class Item extends com.squareup.wire.Message<Item, Builder> {
        public static final ProtoAdapter<Item> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final String mtext;

        public static final class Builder extends com.squareup.wire.Message.Builder<Item, Builder> {
            public String maction_id;
            public String mtext;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Item m1627build() {
                return new Item(this.maction_id, this.mtext, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1627build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Item extends ProtoAdapter<Item> {
            public ProtoAdapter_Item() {
                super(FieldEncoding.LENGTH_DELIMITED, Item.class);
            }

            public Item decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maction_id = "";
                r0.mtext = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1627build();
            }

            public int encodedSize(Item r5) {
                String r0 = r5.maction_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mtext;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1628decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Item) r1);
            }

            public void encode(ProtoWriter r4, Item r5) throws IOException {
                String r0 = r5.maction_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mtext;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Item) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Item();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1626newBuilder() {
            Builder r0 = new Builder();
            r0.maction_id = this.maction_id;
            r0.mtext = this.mtext;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Item.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1626newBuilder();
        }

        public Item(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Item(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.maction_id = r2;
            this.mtext = r3;
        }
    }

    public static final enum Justify extends Enum<Justify> implements WireEnum {
        private static final /* synthetic */ Justify[] $VALUES = null;
        public static final ProtoAdapter<Justify> ADAPTER = null;
        public static final Justify CENTER = null;
        public static final Justify END = null;
        public static final Justify SPACE_AROUND = null;
        public static final Justify SPACE_BETWEEN = null;
        public static final Justify SPACE_EVENLY = null;
        public static final Justify START = null;
        private final int value;

        static {
            Justify r0 = new Justify("START", 0, 0);
            START = r0;
            Justify r1 = new Justify("CENTER", 1, 1);
            CENTER = r1;
            Justify r3 = new Justify("END", 2, 2);
            END = r3;
            Justify r5 = new Justify("SPACE_BETWEEN", 3, 3);
            SPACE_BETWEEN = r5;
            Justify r7 = new Justify("SPACE_AROUND", 4, 4);
            SPACE_AROUND = r7;
            Justify r9 = new Justify("SPACE_EVENLY", 5, 5);
            SPACE_EVENLY = r9;
            $VALUES = new Justify[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(Justify.class);
        }

        public static Justify[] values() {
            return (Justify[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Justify fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return SPACE_EVENLY;
        L18:
            return SPACE_AROUND;
        L20:
            return SPACE_BETWEEN;
        L22:
            return END;
        L24:
            return CENTER;
        L26:
            return START;
        }

        public static Justify valueOf(String r1) {
            return (Justify) a.a(Justify.class, r1);
        }

        private Justify(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class LinearLayoutProperty extends com.squareup.wire.Message<LinearLayoutProperty, Builder> {
        public static final ProtoAdapter<LinearLayoutProperty> ADAPTER = null;
        public static final Float DEFAULT_PADDING = null;
        public static final Float DEFAULT_SPACING = null;
        public static final Float DEFAULT_WRAP_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final Align mcross_axis_align;
        public final Justify mmain_axis_justify;
        public final Orientation morientation;
        public final Float mpadding;
        public final Padding mside_padding;
        public final Float mspacing;
        public final Float mwrap_width;

        public static final class Builder extends com.squareup.wire.Message.Builder<LinearLayoutProperty, Builder> {
            public Align mcross_axis_align;
            public Justify mmain_axis_justify;
            public Orientation morientation;
            public Float mpadding;
            public Padding mside_padding;
            public Float mspacing;
            public Float mwrap_width;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public LinearLayoutProperty m1630build() {
                return new LinearLayoutProperty(this.morientation, this.mspacing, this.mwrap_width, this.mpadding, this.mmain_axis_justify, this.mcross_axis_align, this.mside_padding, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1630build();
            }

            public Builder cross_axis_align(Align r1) {
                this.mcross_axis_align = r1;
                return this;
            }

            public Builder main_axis_justify(Justify r1) {
                this.mmain_axis_justify = r1;
                return this;
            }

            public Builder orientation(Orientation r1) {
                this.morientation = r1;
                return this;
            }

            public Builder padding(Float r1) {
                this.mpadding = r1;
                return this;
            }

            public Builder side_padding(Padding r1) {
                this.mside_padding = r1;
                return this;
            }

            public Builder spacing(Float r1) {
                this.mspacing = r1;
                return this;
            }

            public Builder wrap_width(Float r1) {
                this.mwrap_width = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_LinearLayoutProperty extends ProtoAdapter<LinearLayoutProperty> {
            public ProtoAdapter_LinearLayoutProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LinearLayoutProperty.class);
            }

            public LinearLayoutProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Float r1 = Float.valueOf(0.0f);
                r0.mspacing = r1;
                r0.mwrap_width = r1;
                r0.mpadding = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L23;
                switch(r3) {
                    case 1: goto L29;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L25;
                    case 6: goto L27;
                    case 7: goto L7;
                    default: goto L6;
                };
            L25:
                r0.mmain_axis_justify = (Justify) Justify.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L27:
                r0.mcross_axis_align = (Align) Align.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L29:
                r0.morientation = (Orientation) Orientation.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mside_padding = (Padding) Padding.ADAPTER.decode(r9);
                goto L3
            L16:
                r0.mpadding = (Float) ProtoAdapter.FLOAT.decode(r9);
                goto L3
            L17:
                r0.mwrap_width = (Float) ProtoAdapter.FLOAT.decode(r9);
                goto L3
            L18:
                r0.mspacing = (Float) ProtoAdapter.FLOAT.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L23:
                r9.endMessage(r2);
                return r0.m1630build();
            }

            public int encodedSize(LinearLayoutProperty r6) {
                Orientation r0 = r6.morientation;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Orientation.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Float r3 = r6.mspacing;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Float r7 = r6.mwrap_width;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Float r10 = r6.mpadding;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Justify r13 = r6.mmain_axis_justify;
                if (r13 == null) goto L21;
                int r14 = Justify.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                Align r16 = r6.mcross_axis_align;
                if (r16 == null) goto L25;
                int r17 = Align.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Padding r19 = r6.mside_padding;
                if (r19 == null) goto L30;
                r1 = Padding.ADAPTER.encodedSizeWithTag(7, r19);
            L30:
                return (r18 + r1) + r6.unknownFields().size();
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1631decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((LinearLayoutProperty) r1);
            }

            public void encode(ProtoWriter r4, LinearLayoutProperty r5) throws IOException {
                Orientation r0 = r5.morientation;
                if (r0 == null) goto L5;
                Orientation.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Float r1 = r5.mspacing;
                if (r1 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 2, r1);
            L8:
                Float r2 = r5.mwrap_width;
                if (r2 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 3, r2);
            L11:
                Float r3 = r5.mpadding;
                if (r3 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 4, r3);
            L14:
                Justify r6 = r5.mmain_axis_justify;
                if (r6 == null) goto L17;
                Justify.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                Align r7 = r5.mcross_axis_align;
                if (r7 == null) goto L20;
                Align.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                Padding r8 = r5.mside_padding;
                if (r8 == null) goto L23;
                Padding.ADAPTER.encodeWithTag(r4, 7, r8);
            L23:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (LinearLayoutProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LinearLayoutProperty();
            Float r0 = Float.valueOf(0.0f);
            DEFAULT_SPACING = r0;
            DEFAULT_WRAP_WIDTH = r0;
            DEFAULT_PADDING = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1629newBuilder() {
            Builder r0 = new Builder();
            r0.morientation = this.morientation;
            r0.mspacing = this.mspacing;
            r0.mwrap_width = this.mwrap_width;
            r0.mpadding = this.mpadding;
            r0.mmain_axis_justify = this.mmain_axis_justify;
            r0.mcross_axis_align = this.mcross_axis_align;
            r0.mside_padding = this.mside_padding;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return LinearLayoutProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1629newBuilder();
        }

        public LinearLayoutProperty(Orientation r10, Float r11, Float r12, Float r13, Justify r14, Align r15, Padding r16) {
            this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
        }

        public LinearLayoutProperty(Orientation r2, Float r3, Float r4, Float r5, Justify r6, Align r7, Padding r8, ByteString r9) {
            super(ADAPTER, r9);
            this.morientation = r2;
            this.mspacing = r3;
            this.mwrap_width = r4;
            this.mpadding = r5;
            this.mmain_axis_justify = r6;
            this.mcross_axis_align = r7;
            this.mside_padding = r8;
        }
    }

    public static final class LoadingProperty extends com.squareup.wire.Message<LoadingProperty, Builder> {
        public static final ProtoAdapter<LoadingProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<LoadingProperty, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public LoadingProperty m1633build() {
                return new LoadingProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1633build();
            }
        }

        public static final class ProtoAdapter_LoadingProperty extends ProtoAdapter<LoadingProperty> {
            public ProtoAdapter_LoadingProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LoadingProperty.class);
            }

            public LoadingProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1633build();
            }

            public int encodedSize(LoadingProperty r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1634decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((LoadingProperty) r1);
            }

            public void encode(ProtoWriter r1, LoadingProperty r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (LoadingProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LoadingProperty();
        }

        public LoadingProperty() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1632newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return LoadingProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1632newBuilder();
        }

        public LoadingProperty(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final enum Orientation extends Enum<Orientation> implements WireEnum {
        private static final /* synthetic */ Orientation[] $VALUES = null;
        public static final ProtoAdapter<Orientation> ADAPTER = null;
        public static final Orientation COLUMN = null;
        public static final Orientation COLUMN_REVERSE = null;
        public static final Orientation ROW = null;
        public static final Orientation ROW_REVERSE = null;
        private final int value;

        static {
            Orientation r0 = new Orientation("ROW", 0, 0);
            ROW = r0;
            Orientation r1 = new Orientation("COLUMN", 1, 1);
            COLUMN = r1;
            Orientation r3 = new Orientation("ROW_REVERSE", 2, 2);
            ROW_REVERSE = r3;
            Orientation r5 = new Orientation("COLUMN_REVERSE", 3, 3);
            COLUMN_REVERSE = r5;
            $VALUES = new Orientation[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Orientation.class);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Orientation fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return COLUMN_REVERSE;
        L14:
            return ROW_REVERSE;
        L16:
            return COLUMN;
        L18:
            return ROW;
        }

        public static Orientation valueOf(String r1) {
            return (Orientation) a.a(Orientation.class, r1);
        }

        private Orientation(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class OversizedTextProperty extends com.squareup.wire.Message<OversizedTextProperty, Builder> {
        public static final ProtoAdapter<OversizedTextProperty> ADAPTER = null;
        public static final Integer DEFAULT_FONT_SIZE = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final Integer mfont_size;
        public final FontWeight mfont_weight;
        public final Integer mnumber_of_lines;
        public final String mtext;

        public static final class Builder extends com.squareup.wire.Message.Builder<OversizedTextProperty, Builder> {
            public Integer mfont_size;
            public FontWeight mfont_weight;
            public Integer mnumber_of_lines;
            public String mtext;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OversizedTextProperty m1636build() {
                return new OversizedTextProperty(this.mtext, this.mnumber_of_lines, this.mfont_size, this.mfont_weight, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1636build();
            }

            public Builder font_size(Integer r1) {
                this.mfont_size = r1;
                return this;
            }

            public Builder font_weight(FontWeight r1) {
                this.mfont_weight = r1;
                return this;
            }

            public Builder number_of_lines(Integer r1) {
                this.mnumber_of_lines = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }
        }

        public static final enum FontWeight extends Enum<FontWeight> implements WireEnum {
            private static final /* synthetic */ FontWeight[] $VALUES = null;
            public static final ProtoAdapter<FontWeight> ADAPTER = null;
            public static final FontWeight REGULAR = null;
            public static final FontWeight SEMI_BOLD = null;
            private final int value;

            static {
                FontWeight r0 = new FontWeight("REGULAR", 0, 0);
                REGULAR = r0;
                FontWeight r1 = new FontWeight("SEMI_BOLD", 1, 1);
                SEMI_BOLD = r1;
                $VALUES = new FontWeight[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(FontWeight.class);
            }

            public static FontWeight[] values() {
                return (FontWeight[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static FontWeight fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return SEMI_BOLD;
            L10:
                return REGULAR;
            }

            public static FontWeight valueOf(String r1) {
                return (FontWeight) a.a(FontWeight.class, r1);
            }

            private FontWeight(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_OversizedTextProperty extends ProtoAdapter<OversizedTextProperty> {
            public ProtoAdapter_OversizedTextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, OversizedTextProperty.class);
            }

            public OversizedTextProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mtext = "";
                r0.mnumber_of_lines = 0;
                r0.mfont_size = 36;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mtext = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mnumber_of_lines = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mfont_size = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mfont_weight = (FontWeight) FontWeight.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1636build();
            }

            public int encodedSize(OversizedTextProperty r6) {
                String r0 = r6.mtext;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mnumber_of_lines;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Integer r7 = r6.mfont_size;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                FontWeight r10 = r6.mfont_weight;
                if (r10 == null) goto L18;
                r1 = FontWeight.ADAPTER.encodedSizeWithTag(4, r10);
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
            public /* bridge */ /* synthetic */ Object m1637decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OversizedTextProperty) r1);
            }

            public void encode(ProtoWriter r4, OversizedTextProperty r5) throws IOException {
                String r0 = r5.mtext;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mnumber_of_lines;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                Integer r2 = r5.mfont_size;
                if (r2 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
            L11:
                FontWeight r3 = r5.mfont_weight;
                if (r3 == null) goto L14;
                FontWeight.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OversizedTextProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OversizedTextProperty();
            DEFAULT_NUMBER_OF_LINES = 0;
            DEFAULT_FONT_SIZE = 36;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1635newBuilder() {
            Builder r0 = new Builder();
            r0.mtext = this.mtext;
            r0.mnumber_of_lines = this.mnumber_of_lines;
            r0.mfont_size = this.mfont_size;
            r0.mfont_weight = this.mfont_weight;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OversizedTextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1635newBuilder();
        }

        public OversizedTextProperty(String r7, Integer r8, Integer r9, FontWeight r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public OversizedTextProperty(String r2, Integer r3, Integer r4, FontWeight r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mtext = r2;
            this.mnumber_of_lines = r3;
            this.mfont_size = r4;
            this.mfont_weight = r5;
        }
    }

    public static final class Padding extends com.squareup.wire.Message<Padding, Builder> {
        public static final ProtoAdapter<Padding> ADAPTER = null;
        public static final Float DEFAULT_BOTTOM = null;
        public static final Float DEFAULT_LEFT = null;
        public static final Float DEFAULT_RIGHT = null;
        public static final Float DEFAULT_TOP = null;
        private static final long serialVersionUID = 0;
        public final Float mbottom;
        public final Float mleft;
        public final Float mright;
        public final Float mtop;

        public static final class Builder extends com.squareup.wire.Message.Builder<Padding, Builder> {
            public Float mbottom;
            public Float mleft;
            public Float mright;
            public Float mtop;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Padding m1639build() {
                return new Padding(this.mtop, this.mright, this.mbottom, this.mleft, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1639build();
            }

            public Builder bottom(Float r1) {
                this.mbottom = r1;
                return this;
            }

            public Builder left(Float r1) {
                this.mleft = r1;
                return this;
            }

            public Builder right(Float r1) {
                this.mright = r1;
                return this;
            }

            public Builder top(Float r1) {
                this.mtop = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Padding extends ProtoAdapter<Padding> {
            public ProtoAdapter_Padding() {
                super(FieldEncoding.LENGTH_DELIMITED, Padding.class);
            }

            public Padding decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Float r1 = Float.valueOf(0.0f);
                r0.mtop = r1;
                r0.mright = r1;
                r0.mbottom = r1;
                r0.mleft = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtop = (Float) ProtoAdapter.FLOAT.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mright = (Float) ProtoAdapter.FLOAT.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mbottom = (Float) ProtoAdapter.FLOAT.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mleft = (Float) ProtoAdapter.FLOAT.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r2);
                return r0.m1639build();
            }

            public int encodedSize(Padding r6) {
                Float r0 = r6.mtop;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r0);
            L6:
                Float r3 = r6.mright;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Float r7 = r6.mbottom;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Float r10 = r6.mleft;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r10);
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
            public /* bridge */ /* synthetic */ Object m1640decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Padding) r1);
            }

            public void encode(ProtoWriter r4, Padding r5) throws IOException {
                Float r0 = r5.mtop;
                if (r0 == null) goto L5;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 1, r0);
            L5:
                Float r1 = r5.mright;
                if (r1 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 2, r1);
            L8:
                Float r2 = r5.mbottom;
                if (r2 == null) goto L11;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 3, r2);
            L11:
                Float r3 = r5.mleft;
                if (r3 == null) goto L14;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Padding) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Padding();
            Float r0 = Float.valueOf(0.0f);
            DEFAULT_TOP = r0;
            DEFAULT_RIGHT = r0;
            DEFAULT_BOTTOM = r0;
            DEFAULT_LEFT = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1638newBuilder() {
            Builder r0 = new Builder();
            r0.mtop = this.mtop;
            r0.mright = this.mright;
            r0.mbottom = this.mbottom;
            r0.mleft = this.mleft;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Padding.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1638newBuilder();
        }

        public Padding(Float r7, Float r8, Float r9, Float r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public Padding(Float r2, Float r3, Float r4, Float r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mtop = r2;
            this.mright = r3;
            this.mbottom = r4;
            this.mleft = r5;
        }
    }

    public static final class PreviewHeaderProperty extends com.squareup.wire.Message<PreviewHeaderProperty, Builder> {
        public static final ProtoAdapter<PreviewHeaderProperty> ADAPTER = null;
        public static final String DEFAULT_CHILD_COMPONENT_ID = "";
        public static final String DEFAULT_FAVICON_URL = "";
        public static final String DEFAULT_HEADER_TAG = "";
        public static final Integer DEFAULT_ICON_SIZE = null;
        public static final Boolean DEFAULT_IS_NEED_CLOSE = null;
        public static final Boolean DEFAULT_IS_NEED_COPY_LINK = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final String mchild_component_id;
        public final ImageSetV2 mdm_icon;
        public final String mfavicon_url;
        public final String mheader_tag;
        public final ImageSetV2 micon;
        public final ThemeColor micon_color;
        public final Integer micon_size;
        public final Boolean mis_need_close;
        public final Boolean mis_need_copy_link;
        public final Tag mlark_tag;
        public final Integer mnumber_of_lines;
        public final ThemeColor mtag_color;
        public final ThemeColor mtag_text_color;
        public final Theme mtheme;
        public final String mtitle;
        public final Type mtype;
        public final UDIcon mud_icon;

        public static final class Builder extends com.squareup.wire.Message.Builder<PreviewHeaderProperty, Builder> {
            public String mchild_component_id;
            public ImageSetV2 mdm_icon;
            public String mfavicon_url;
            public String mheader_tag;
            public ImageSetV2 micon;
            public ThemeColor micon_color;
            public Integer micon_size;
            public Boolean mis_need_close;
            public Boolean mis_need_copy_link;
            public Tag mlark_tag;
            public Integer mnumber_of_lines;
            public ThemeColor mtag_color;
            public ThemeColor mtag_text_color;
            public Theme mtheme;
            public String mtitle;
            public Type mtype;
            public UDIcon mud_icon;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public PreviewHeaderProperty m1642build() {
                return new PreviewHeaderProperty(this.micon, this.mtitle, this.mlark_tag, this.mchild_component_id, this.mis_need_copy_link, this.mis_need_close, this.mtheme, this.mtype, this.mtag_color, this.mtag_text_color, this.mheader_tag, this.mfavicon_url, this.micon_color, this.mud_icon, this.mnumber_of_lines, this.micon_size, this.mdm_icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1642build();
            }

            public Builder child_component_id(String r1) {
                this.mchild_component_id = r1;
                return this;
            }

            public Builder dm_icon(ImageSetV2 r1) {
                this.mdm_icon = r1;
                return this;
            }

            public Builder favicon_url(String r1) {
                this.mfavicon_url = r1;
                return this;
            }

            public Builder header_tag(String r1) {
                this.mheader_tag = r1;
                return this;
            }

            public Builder icon(ImageSetV2 r1) {
                this.micon = r1;
                return this;
            }

            public Builder icon_color(ThemeColor r1) {
                this.micon_color = r1;
                return this;
            }

            public Builder icon_size(Integer r1) {
                this.micon_size = r1;
                return this;
            }

            public Builder is_need_close(Boolean r1) {
                this.mis_need_close = r1;
                return this;
            }

            public Builder is_need_copy_link(Boolean r1) {
                this.mis_need_copy_link = r1;
                return this;
            }

            public Builder lark_tag(Tag r1) {
                this.mlark_tag = r1;
                return this;
            }

            public Builder number_of_lines(Integer r1) {
                this.mnumber_of_lines = r1;
                return this;
            }

            public Builder tag_color(ThemeColor r1) {
                this.mtag_color = r1;
                return this;
            }

            public Builder tag_text_color(ThemeColor r1) {
                this.mtag_text_color = r1;
                return this;
            }

            public Builder theme(Theme r1) {
                this.mtheme = r1;
                return this;
            }

            public Builder title(String r1) {
                this.mtitle = r1;
                return this;
            }

            public Builder type(Type r1) {
                this.mtype = r1;
                return this;
            }

            public Builder ud_icon(UDIcon r1) {
                this.mud_icon = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_PreviewHeaderProperty extends ProtoAdapter<PreviewHeaderProperty> {
            public ProtoAdapter_PreviewHeaderProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, PreviewHeaderProperty.class);
            }

            public PreviewHeaderProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mtitle = "";
                r0.mchild_component_id = "";
                Boolean r2 = Boolean.TRUE;
                r0.mis_need_copy_link = r2;
                r0.mis_need_close = r2;
                r0.mheader_tag = "";
                r0.mfavicon_url = "";
                r0.mnumber_of_lines = 3;
                r0.micon_size = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L33;
                switch(r3) {
                    case 1: goto L32;
                    case 2: goto L31;
                    case 3: goto L39;
                    case 4: goto L26;
                    case 5: goto L25;
                    case 6: goto L24;
                    case 7: goto L37;
                    case 8: goto L35;
                    case 9: goto L15;
                    case 10: goto L14;
                    case 11: goto L13;
                    case 12: goto L12;
                    case 13: goto L11;
                    case 14: goto L10;
                    case 15: goto L9;
                    case 16: goto L8;
                    case 17: goto L7;
                    default: goto L6;
                };
            L35:
                r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L37:
                r0.mtheme = (Theme) Theme.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L39:
                r0.mlark_tag = (Tag) Tag.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
            L29:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mdm_icon = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L8:
                r0.micon_size = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L9:
                r0.mnumber_of_lines = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L10:
                r0.mud_icon = (UDIcon) UDIcon.ADAPTER.decode(r9);
                goto L3
            L11:
                r0.micon_color = (ThemeColor) ThemeColor.ADAPTER.decode(r9);
                goto L3
            L12:
                r0.mfavicon_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L13:
                r0.mheader_tag = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L14:
                r0.mtag_text_color = (ThemeColor) ThemeColor.ADAPTER.decode(r9);
                goto L3
            L15:
                r0.mtag_color = (ThemeColor) ThemeColor.ADAPTER.decode(r9);
                goto L3
            L24:
                r0.mis_need_close = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L25:
                r0.mis_need_copy_link = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L26:
                r0.mchild_component_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L31:
                r0.mtitle = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L32:
                r0.micon = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L33:
                r9.endMessage(r1);
                return r0.m1642build();
            }

            public int encodedSize(PreviewHeaderProperty r6) {
                ImageSetV2 r0 = r6.micon;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetV2.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mtitle;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Tag r7 = r6.mlark_tag;
                if (r7 == null) goto L13;
                int r8 = Tag.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mchild_component_id;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.mis_need_copy_link;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                Boolean r16 = r6.mis_need_close;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Theme r19 = r6.mtheme;
                if (r19 == null) goto L29;
                int r20 = Theme.ADAPTER.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                Type r22 = r6.mtype;
                if (r22 == null) goto L33;
                int r23 = Type.ADAPTER.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                ThemeColor r25 = r6.mtag_color;
                if (r25 == null) goto L37;
                int r26 = ThemeColor.ADAPTER.encodedSizeWithTag(9, r25);
            L38:
                int r27 = r24 + r26;
                ThemeColor r28 = r6.mtag_text_color;
                if (r28 == null) goto L41;
                int r29 = ThemeColor.ADAPTER.encodedSizeWithTag(10, r28);
            L42:
                int r30 = r27 + r29;
                String r31 = r6.mheader_tag;
                if (r31 == null) goto L45;
                int r32 = ProtoAdapter.STRING.encodedSizeWithTag(11, r31);
            L46:
                int r33 = r30 + r32;
                String r34 = r6.mfavicon_url;
                if (r34 == null) goto L49;
                int r35 = ProtoAdapter.STRING.encodedSizeWithTag(12, r34);
            L50:
                int r36 = r33 + r35;
                ThemeColor r37 = r6.micon_color;
                if (r37 == null) goto L53;
                int r38 = ThemeColor.ADAPTER.encodedSizeWithTag(13, r37);
            L54:
                int r39 = r36 + r38;
                UDIcon r40 = r6.mud_icon;
                if (r40 == null) goto L57;
                int r41 = UDIcon.ADAPTER.encodedSizeWithTag(14, r40);
            L58:
                int r42 = r39 + r41;
                Integer r43 = r6.mnumber_of_lines;
                if (r43 == null) goto L61;
                int r44 = ProtoAdapter.INT32.encodedSizeWithTag(15, r43);
            L62:
                int r45 = r42 + r44;
                Integer r46 = r6.micon_size;
                if (r46 == null) goto L65;
                int r47 = ProtoAdapter.INT32.encodedSizeWithTag(16, r46);
            L66:
                int r48 = r45 + r47;
                ImageSetV2 r49 = r6.mdm_icon;
                if (r49 == null) goto L70;
                r1 = ImageSetV2.ADAPTER.encodedSizeWithTag(17, r49);
            L70:
                return (r48 + r1) + r6.unknownFields().size();
            L65:
                r47 = 0;
                goto L66
            L61:
                r44 = 0;
                goto L62
            L57:
                r41 = 0;
                goto L58
            L53:
                r38 = 0;
                goto L54
            L49:
                r35 = 0;
                goto L50
            L45:
                r32 = 0;
                goto L46
            L41:
                r29 = 0;
                goto L42
            L37:
                r26 = 0;
                goto L38
            L33:
                r23 = 0;
                goto L34
            L29:
                r20 = 0;
                goto L30
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1643decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((PreviewHeaderProperty) r1);
            }

            public void encode(ProtoWriter r4, PreviewHeaderProperty r5) throws IOException {
                ImageSetV2 r0 = r5.micon;
                if (r0 == null) goto L5;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mtitle;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Tag r2 = r5.mlark_tag;
                if (r2 == null) goto L11;
                Tag.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mchild_component_id;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.mis_need_copy_link;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
            L17:
                Boolean r7 = r5.mis_need_close;
                if (r7 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
            L20:
                Theme r8 = r5.mtheme;
                if (r8 == null) goto L23;
                Theme.ADAPTER.encodeWithTag(r4, 7, r8);
            L23:
                Type r9 = r5.mtype;
                if (r9 == null) goto L26;
                Type.ADAPTER.encodeWithTag(r4, 8, r9);
            L26:
                ThemeColor r10 = r5.mtag_color;
                if (r10 == null) goto L29;
                ThemeColor.ADAPTER.encodeWithTag(r4, 9, r10);
            L29:
                ThemeColor r11 = r5.mtag_text_color;
                if (r11 == null) goto L32;
                ThemeColor.ADAPTER.encodeWithTag(r4, 10, r11);
            L32:
                String r12 = r5.mheader_tag;
                if (r12 == null) goto L35;
                ProtoAdapter.STRING.encodeWithTag(r4, 11, r12);
            L35:
                String r13 = r5.mfavicon_url;
                if (r13 == null) goto L38;
                ProtoAdapter.STRING.encodeWithTag(r4, 12, r13);
            L38:
                ThemeColor r14 = r5.micon_color;
                if (r14 == null) goto L41;
                ThemeColor.ADAPTER.encodeWithTag(r4, 13, r14);
            L41:
                UDIcon r15 = r5.mud_icon;
                if (r15 == null) goto L44;
                UDIcon.ADAPTER.encodeWithTag(r4, 14, r15);
            L44:
                Integer r16 = r5.mnumber_of_lines;
                if (r16 == null) goto L47;
                ProtoAdapter.INT32.encodeWithTag(r4, 15, r16);
            L47:
                Integer r17 = r5.micon_size;
                if (r17 == null) goto L50;
                ProtoAdapter.INT32.encodeWithTag(r4, 16, r17);
            L50:
                ImageSetV2 r18 = r5.mdm_icon;
                if (r18 == null) goto L53;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 17, r18);
            L53:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (PreviewHeaderProperty) r2);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type HEADLINES = null;
            public static final Type NORMAL = null;
            private final int value;

            static {
                Type r0 = new Type("NORMAL", 0, 0);
                NORMAL = r0;
                Type r1 = new Type("HEADLINES", 1, 1);
                HEADLINES = r1;
                $VALUES = new Type[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return HEADLINES;
            L10:
                return NORMAL;
            }

            public static Type valueOf(String r1) {
                return (Type) a.a(Type.class, r1);
            }

            private Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PreviewHeaderProperty();
            Boolean r0 = Boolean.TRUE;
            DEFAULT_IS_NEED_COPY_LINK = r0;
            DEFAULT_IS_NEED_CLOSE = r0;
            DEFAULT_NUMBER_OF_LINES = 3;
            DEFAULT_ICON_SIZE = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1641newBuilder() {
            Builder r0 = new Builder();
            r0.micon = this.micon;
            r0.mtitle = this.mtitle;
            r0.mlark_tag = this.mlark_tag;
            r0.mchild_component_id = this.mchild_component_id;
            r0.mis_need_copy_link = this.mis_need_copy_link;
            r0.mis_need_close = this.mis_need_close;
            r0.mtheme = this.mtheme;
            r0.mtype = this.mtype;
            r0.mtag_color = this.mtag_color;
            r0.mtag_text_color = this.mtag_text_color;
            r0.mheader_tag = this.mheader_tag;
            r0.mfavicon_url = this.mfavicon_url;
            r0.micon_color = this.micon_color;
            r0.mud_icon = this.mud_icon;
            r0.mnumber_of_lines = this.mnumber_of_lines;
            r0.micon_size = this.micon_size;
            r0.mdm_icon = this.mdm_icon;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return PreviewHeaderProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1641newBuilder();
        }

        public PreviewHeaderProperty(ImageSetV2 r20, String r21, Tag r22, String r23, Boolean r24, Boolean r25, Theme r26, Type r27, ThemeColor r28, ThemeColor r29, String r30, String r31, ThemeColor r32, UDIcon r33, Integer r34, Integer r35, ImageSetV2 r36) {
            this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, ByteString.EMPTY);
        }

        public PreviewHeaderProperty(ImageSetV2 r4, String r5, Tag r6, String r7, Boolean r8, Boolean r9, Theme r10, Type r11, ThemeColor r12, ThemeColor r13, String r14, String r15, ThemeColor r16, UDIcon r17, Integer r18, Integer r19, ImageSetV2 r20, ByteString r21) {
            super(ADAPTER, r21);
            this.micon = r4;
            this.mtitle = r5;
            this.mlark_tag = r6;
            this.mchild_component_id = r7;
            this.mis_need_copy_link = r8;
            this.mis_need_close = r9;
            this.mtheme = r10;
            this.mtype = r11;
            this.mtag_color = r12;
            this.mtag_text_color = r13;
            this.mheader_tag = r14;
            this.mfavicon_url = r15;
            this.micon_color = r16;
            this.mud_icon = r17;
            this.mnumber_of_lines = r18;
            this.micon_size = r19;
            this.mdm_icon = r20;
        }
    }

    public static final class ProtoAdapter_URLPreviewComponent extends ProtoAdapter<URLPreviewComponent> {
        public ProtoAdapter_URLPreviewComponent() {
            super(FieldEncoding.LENGTH_DELIMITED, URLPreviewComponent.class);
        }

        public URLPreviewComponent decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.TRUE;
            r0.mcan_skip_when_unknown = r1;
            r0.mis_font_zoomable = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L50;
            if (r3 != 1) goto L8;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
        L48:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcan_skip_when_unknown = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mstyle = (Style) Style.ADAPTER.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mchild_ids.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mis_font_zoomable = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L15:
            switch(r3) {
                case 1000: goto L41;
                case 1001: goto L40;
                case 1002: goto L39;
                default: goto L16;
            };
        L39:
            r0.flex_layout((FlexLayoutProperty) FlexLayoutProperty.ADAPTER.decode(r9));
            goto L3
        L40:
            r0.linear_layout((LinearLayoutProperty) LinearLayoutProperty.ADAPTER.decode(r9));
            goto L3
        L41:
            r0.empty((EmptyProperty) EmptyProperty.ADAPTER.decode(r9));
            goto L3
        L16:
            switch(r3) {
                case 1501: goto L38;
                case 1502: goto L37;
                case 1503: goto L36;
                case 1504: goto L35;
                case 1505: goto L34;
                case 1506: goto L33;
                case 1507: goto L32;
                case 1508: goto L31;
                case 1509: goto L30;
                case 1510: goto L29;
                case 1511: goto L28;
                case 1512: goto L27;
                case 1513: goto L26;
                case 1514: goto L25;
                case 1515: goto L24;
                case 1516: goto L23;
                case 1517: goto L22;
                case 1518: goto L21;
                case 1519: goto L20;
                case 1520: goto L19;
                case 1521: goto L18;
                default: goto L17;
            };
        L18:
            r0.image_container((ImageContainerProperty) ImageContainerProperty.ADAPTER.decode(r9));
            goto L3
        L19:
            r0.doc_state_button((DocStateButtonProperty) DocStateButtonProperty.ADAPTER.decode(r9));
            goto L3
        L20:
            r0.engine((EngineProperty) EngineProperty.ADAPTER.decode(r9));
            goto L3
        L21:
            r0.oversized_text((OversizedTextProperty) OversizedTextProperty.ADAPTER.decode(r9));
            goto L3
        L22:
            r0.time_zone((TimeZoneProperty) TimeZoneProperty.ADAPTER.decode(r9));
            goto L3
        L23:
            r0.loading((LoadingProperty) LoadingProperty.ADAPTER.decode(r9));
            goto L3
        L24:
            r0.doc_image((DocImageProperty) DocImageProperty.ADAPTER.decode(r9));
            goto L3
        L25:
            r0.card_container((CardContainerProperty) CardContainerProperty.ADAPTER.decode(r9));
            goto L3
        L26:
            r0.video((VideoProperty) VideoProperty.ADAPTER.decode(r9));
            goto L3
        L27:
            r0.avatar((AvatarProperty) AvatarProperty.ADAPTER.decode(r9));
            goto L3
        L28:
            r0.spin_button((SpinButtonProperty) SpinButtonProperty.ADAPTER.decode(r9));
            goto L3
        L29:
            r0.tag_list((TagListProperty) TagListProperty.ADAPTER.decode(r9));
            goto L3
        L30:
            r0.text((TextProperty) TextProperty.ADAPTER.decode(r9));
            goto L3
        L31:
            r0.time((TimeProperty) TimeProperty.ADAPTER.decode(r9));
            goto L3
        L32:
            r0.text_button((TextButtonProperty) TextButtonProperty.ADAPTER.decode(r9));
            goto L3
        L33:
            r0.icon_button((IconButtonProperty) IconButtonProperty.ADAPTER.decode(r9));
            goto L3
        L34:
            r0.button((ButtonProperty) ButtonProperty.ADAPTER.decode(r9));
            goto L3
        L35:
            r0.chatters_preview((ChattersPreviewProperty) ChattersPreviewProperty.ADAPTER.decode(r9));
            goto L3
        L36:
            r0.image((ImageProperty) ImageProperty.ADAPTER.decode(r9));
            goto L3
        L37:
            r0.richtext((RichTextProperty) RichTextProperty.ADAPTER.decode(r9));
            goto L3
        L38:
            r0.header((PreviewHeaderProperty) PreviewHeaderProperty.ADAPTER.decode(r9));
            goto L3
        L17:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L50:
            r9.endMessage(r2);
            return r0.m1583build();
        }

        public int encodedSize(URLPreviewComponent r6) {
            int r0 = Type.ADAPTER.encodedSizeWithTag(1, r6.mtype);
            Boolean r1 = r6.mcan_skip_when_unknown;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Style r5 = r6.mstyle;
            if (r5 == null) goto L9;
            int r7 = Style.ADAPTER.encodedSizeWithTag(3, r5);
        L10:
            int r8 = (r4 + r7) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(4, r6.mchild_ids);
            Boolean r9 = r6.mis_font_zoomable;
            if (r9 == null) goto L13;
            int r10 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r9);
        L14:
            int r11 = r8 + r10;
            EmptyProperty r12 = r6.mempty;
            if (r12 == null) goto L17;
            int r13 = EmptyProperty.ADAPTER.encodedSizeWithTag(1000, r12);
        L18:
            int r14 = r11 + r13;
            LinearLayoutProperty r15 = r6.mlinear_layout;
            if (r15 == null) goto L21;
            int r16 = LinearLayoutProperty.ADAPTER.encodedSizeWithTag(1001, r15);
        L22:
            int r17 = r14 + r16;
            FlexLayoutProperty r18 = r6.mflex_layout;
            if (r18 == null) goto L25;
            int r19 = FlexLayoutProperty.ADAPTER.encodedSizeWithTag(1002, r18);
        L26:
            int r20 = r17 + r19;
            PreviewHeaderProperty r21 = r6.mheader;
            if (r21 == null) goto L29;
            int r22 = PreviewHeaderProperty.ADAPTER.encodedSizeWithTag(1501, r21);
        L30:
            int r23 = r20 + r22;
            RichTextProperty r24 = r6.mrichtext;
            if (r24 == null) goto L33;
            int r25 = RichTextProperty.ADAPTER.encodedSizeWithTag(1502, r24);
        L34:
            int r26 = r23 + r25;
            ImageProperty r27 = r6.mimage;
            if (r27 == null) goto L37;
            int r28 = ImageProperty.ADAPTER.encodedSizeWithTag(1503, r27);
        L38:
            int r29 = r26 + r28;
            ChattersPreviewProperty r30 = r6.mchatters_preview;
            if (r30 == null) goto L41;
            int r31 = ChattersPreviewProperty.ADAPTER.encodedSizeWithTag(1504, r30);
        L42:
            int r32 = r29 + r31;
            ButtonProperty r33 = r6.mbutton;
            if (r33 == null) goto L45;
            int r34 = ButtonProperty.ADAPTER.encodedSizeWithTag(1505, r33);
        L46:
            int r35 = r32 + r34;
            IconButtonProperty r36 = r6.micon_button;
            if (r36 == null) goto L49;
            int r37 = IconButtonProperty.ADAPTER.encodedSizeWithTag(1506, r36);
        L50:
            int r38 = r35 + r37;
            TextButtonProperty r39 = r6.mtext_button;
            if (r39 == null) goto L53;
            int r40 = TextButtonProperty.ADAPTER.encodedSizeWithTag(1507, r39);
        L54:
            int r41 = r38 + r40;
            TimeProperty r42 = r6.mtime;
            if (r42 == null) goto L57;
            int r43 = TimeProperty.ADAPTER.encodedSizeWithTag(1508, r42);
        L58:
            int r44 = r41 + r43;
            TextProperty r45 = r6.mtext;
            if (r45 == null) goto L61;
            int r46 = TextProperty.ADAPTER.encodedSizeWithTag(1509, r45);
        L62:
            int r47 = r44 + r46;
            TagListProperty r48 = r6.mtag_list;
            if (r48 == null) goto L65;
            int r49 = TagListProperty.ADAPTER.encodedSizeWithTag(1510, r48);
        L66:
            int r50 = r47 + r49;
            SpinButtonProperty r51 = r6.mspin_button;
            if (r51 == null) goto L69;
            int r52 = SpinButtonProperty.ADAPTER.encodedSizeWithTag(1511, r51);
        L70:
            int r53 = r50 + r52;
            AvatarProperty r54 = r6.mavatar;
            if (r54 == null) goto L73;
            int r55 = AvatarProperty.ADAPTER.encodedSizeWithTag(1512, r54);
        L74:
            int r56 = r53 + r55;
            VideoProperty r57 = r6.mvideo;
            if (r57 == null) goto L77;
            int r58 = VideoProperty.ADAPTER.encodedSizeWithTag(1513, r57);
        L78:
            int r59 = r56 + r58;
            CardContainerProperty r60 = r6.mcard_container;
            if (r60 == null) goto L81;
            int r61 = CardContainerProperty.ADAPTER.encodedSizeWithTag(1514, r60);
        L82:
            int r62 = r59 + r61;
            DocImageProperty r63 = r6.mdoc_image;
            if (r63 == null) goto L85;
            int r64 = DocImageProperty.ADAPTER.encodedSizeWithTag(1515, r63);
        L86:
            int r65 = r62 + r64;
            LoadingProperty r66 = r6.mloading;
            if (r66 == null) goto L89;
            int r67 = LoadingProperty.ADAPTER.encodedSizeWithTag(1516, r66);
        L90:
            int r68 = r65 + r67;
            TimeZoneProperty r69 = r6.mtime_zone;
            if (r69 == null) goto L93;
            int r70 = TimeZoneProperty.ADAPTER.encodedSizeWithTag(1517, r69);
        L94:
            int r71 = r68 + r70;
            OversizedTextProperty r72 = r6.moversized_text;
            if (r72 == null) goto L97;
            int r73 = OversizedTextProperty.ADAPTER.encodedSizeWithTag(1518, r72);
        L98:
            int r74 = r71 + r73;
            EngineProperty r75 = r6.mengine;
            if (r75 == null) goto L101;
            int r76 = EngineProperty.ADAPTER.encodedSizeWithTag(1519, r75);
        L102:
            int r77 = r74 + r76;
            DocStateButtonProperty r78 = r6.mdoc_state_button;
            if (r78 == null) goto L105;
            int r79 = DocStateButtonProperty.ADAPTER.encodedSizeWithTag(1520, r78);
        L106:
            int r80 = r77 + r79;
            ImageContainerProperty r81 = r6.mimage_container;
            if (r81 == null) goto L110;
            r2 = ImageContainerProperty.ADAPTER.encodedSizeWithTag(1521, r81);
        L110:
            return (r80 + r2) + r6.unknownFields().size();
        L105:
            r79 = 0;
            goto L106
        L101:
            r76 = 0;
            goto L102
        L97:
            r73 = 0;
            goto L98
        L93:
            r70 = 0;
            goto L94
        L89:
            r67 = 0;
            goto L90
        L85:
            r64 = 0;
            goto L86
        L81:
            r61 = 0;
            goto L82
        L77:
            r58 = 0;
            goto L78
        L73:
            r55 = 0;
            goto L74
        L69:
            r52 = 0;
            goto L70
        L65:
            r49 = 0;
            goto L66
        L61:
            r46 = 0;
            goto L62
        L57:
            r43 = 0;
            goto L58
        L53:
            r40 = 0;
            goto L54
        L49:
            r37 = 0;
            goto L50
        L45:
            r34 = 0;
            goto L46
        L41:
            r31 = 0;
            goto L42
        L37:
            r28 = 0;
            goto L38
        L33:
            r25 = 0;
            goto L34
        L29:
            r22 = 0;
            goto L30
        L25:
            r19 = 0;
            goto L26
        L21:
            r16 = 0;
            goto L22
        L17:
            r13 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1644decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((URLPreviewComponent) r1);
        }

        public void encode(ProtoWriter r4, URLPreviewComponent r5) throws IOException {
            Type.ADAPTER.encodeWithTag(r4, 1, r5.mtype);
            Boolean r0 = r5.mcan_skip_when_unknown;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
        L5:
            Style r1 = r5.mstyle;
            if (r1 == null) goto L8;
            Style.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 4, r5.mchild_ids);
            Boolean r2 = r5.mis_font_zoomable;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r2);
        L11:
            EmptyProperty r3 = r5.mempty;
            if (r3 == null) goto L14;
            EmptyProperty.ADAPTER.encodeWithTag(r4, 1000, r3);
        L14:
            LinearLayoutProperty r6 = r5.mlinear_layout;
            if (r6 == null) goto L17;
            LinearLayoutProperty.ADAPTER.encodeWithTag(r4, 1001, r6);
        L17:
            FlexLayoutProperty r7 = r5.mflex_layout;
            if (r7 == null) goto L20;
            FlexLayoutProperty.ADAPTER.encodeWithTag(r4, 1002, r7);
        L20:
            PreviewHeaderProperty r8 = r5.mheader;
            if (r8 == null) goto L23;
            PreviewHeaderProperty.ADAPTER.encodeWithTag(r4, 1501, r8);
        L23:
            RichTextProperty r9 = r5.mrichtext;
            if (r9 == null) goto L26;
            RichTextProperty.ADAPTER.encodeWithTag(r4, 1502, r9);
        L26:
            ImageProperty r10 = r5.mimage;
            if (r10 == null) goto L29;
            ImageProperty.ADAPTER.encodeWithTag(r4, 1503, r10);
        L29:
            ChattersPreviewProperty r11 = r5.mchatters_preview;
            if (r11 == null) goto L32;
            ChattersPreviewProperty.ADAPTER.encodeWithTag(r4, 1504, r11);
        L32:
            ButtonProperty r12 = r5.mbutton;
            if (r12 == null) goto L35;
            ButtonProperty.ADAPTER.encodeWithTag(r4, 1505, r12);
        L35:
            IconButtonProperty r13 = r5.micon_button;
            if (r13 == null) goto L38;
            IconButtonProperty.ADAPTER.encodeWithTag(r4, 1506, r13);
        L38:
            TextButtonProperty r14 = r5.mtext_button;
            if (r14 == null) goto L41;
            TextButtonProperty.ADAPTER.encodeWithTag(r4, 1507, r14);
        L41:
            TimeProperty r15 = r5.mtime;
            if (r15 == null) goto L44;
            TimeProperty.ADAPTER.encodeWithTag(r4, 1508, r15);
        L44:
            TextProperty r16 = r5.mtext;
            if (r16 == null) goto L47;
            TextProperty.ADAPTER.encodeWithTag(r4, 1509, r16);
        L47:
            TagListProperty r17 = r5.mtag_list;
            if (r17 == null) goto L50;
            TagListProperty.ADAPTER.encodeWithTag(r4, 1510, r17);
        L50:
            SpinButtonProperty r18 = r5.mspin_button;
            if (r18 == null) goto L53;
            SpinButtonProperty.ADAPTER.encodeWithTag(r4, 1511, r18);
        L53:
            AvatarProperty r19 = r5.mavatar;
            if (r19 == null) goto L56;
            AvatarProperty.ADAPTER.encodeWithTag(r4, 1512, r19);
        L56:
            VideoProperty r20 = r5.mvideo;
            if (r20 == null) goto L59;
            VideoProperty.ADAPTER.encodeWithTag(r4, 1513, r20);
        L59:
            CardContainerProperty r21 = r5.mcard_container;
            if (r21 == null) goto L62;
            CardContainerProperty.ADAPTER.encodeWithTag(r4, 1514, r21);
        L62:
            DocImageProperty r22 = r5.mdoc_image;
            if (r22 == null) goto L65;
            DocImageProperty.ADAPTER.encodeWithTag(r4, 1515, r22);
        L65:
            LoadingProperty r23 = r5.mloading;
            if (r23 == null) goto L68;
            LoadingProperty.ADAPTER.encodeWithTag(r4, 1516, r23);
        L68:
            TimeZoneProperty r24 = r5.mtime_zone;
            if (r24 == null) goto L71;
            TimeZoneProperty.ADAPTER.encodeWithTag(r4, 1517, r24);
        L71:
            OversizedTextProperty r25 = r5.moversized_text;
            if (r25 == null) goto L74;
            OversizedTextProperty.ADAPTER.encodeWithTag(r4, 1518, r25);
        L74:
            EngineProperty r26 = r5.mengine;
            if (r26 == null) goto L77;
            EngineProperty.ADAPTER.encodeWithTag(r4, 1519, r26);
        L77:
            DocStateButtonProperty r27 = r5.mdoc_state_button;
            if (r27 == null) goto L80;
            DocStateButtonProperty.ADAPTER.encodeWithTag(r4, 1520, r27);
        L80:
            ImageContainerProperty r28 = r5.mimage_container;
            if (r28 == null) goto L83;
            ImageContainerProperty.ADAPTER.encodeWithTag(r4, 1521, r28);
        L83:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (URLPreviewComponent) r2);
        }
    }

    public static final class RichTextProperty extends com.squareup.wire.Message<RichTextProperty, Builder> {
        public static final ProtoAdapter<RichTextProperty> ADAPTER = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final Boolean DEFAULT_SHOW_UPDATE_TIME = null;
        private static final long serialVersionUID = 0;
        public final List<String> mat_out_chatter_ids;
        public final Integer mnumber_of_lines;
        public final RichText mrichtext;
        public final Boolean mshow_update_time;
        public final RichTextTheme mtheme;

        public static final class Builder extends com.squareup.wire.Message.Builder<RichTextProperty, Builder> {
            public List<String> mat_out_chatter_ids;
            public Integer mnumber_of_lines;
            public RichText mrichtext;
            public Boolean mshow_update_time;
            public RichTextTheme mtheme;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RichTextProperty m1646build() {
                return new RichTextProperty(this.mrichtext, this.mnumber_of_lines, this.mat_out_chatter_ids, this.mshow_update_time, this.mtheme, super.buildUnknownFields());
            }

            public Builder() {
                this.mat_out_chatter_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1646build();
            }

            public Builder at_out_chatter_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mat_out_chatter_ids = r1;
                return this;
            }

            public Builder number_of_lines(Integer r1) {
                this.mnumber_of_lines = r1;
                return this;
            }

            public Builder richtext(RichText r1) {
                this.mrichtext = r1;
                return this;
            }

            public Builder show_update_time(Boolean r1) {
                this.mshow_update_time = r1;
                return this;
            }

            public Builder theme(RichTextTheme r1) {
                this.mtheme = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RichTextProperty extends ProtoAdapter<RichTextProperty> {
            public ProtoAdapter_RichTextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, RichTextProperty.class);
            }

            public RichTextProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mnumber_of_lines = 0;
                r0.mshow_update_time = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L24;
                if (r3 != 1) goto L8;
                r0.mrichtext = (RichText) RichText.ADAPTER.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mnumber_of_lines = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mat_out_chatter_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.mshow_update_time = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mtheme = (RichTextTheme) RichTextTheme.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L15:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L24:
                r9.endMessage(r1);
                return r0.m1646build();
            }

            public int encodedSize(RichTextProperty r6) {
                RichText r0 = r6.mrichtext;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = RichText.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mnumber_of_lines;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                int r5 = (r2 + r4) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r6.mat_out_chatter_ids);
                Boolean r7 = r6.mshow_update_time;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r7);
            L14:
                int r9 = r5 + r8;
                RichTextTheme r10 = r6.mtheme;
                if (r10 == null) goto L18;
                r1 = RichTextTheme.ADAPTER.encodedSizeWithTag(5, r10);
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
            public /* bridge */ /* synthetic */ Object m1647decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RichTextProperty) r1);
            }

            public void encode(ProtoWriter r4, RichTextProperty r5) throws IOException {
                RichText r0 = r5.mrichtext;
                if (r0 == null) goto L5;
                RichText.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mnumber_of_lines;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 3, r5.mat_out_chatter_ids);
                Boolean r2 = r5.mshow_update_time;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r2);
            L11:
                RichTextTheme r3 = r5.mtheme;
                if (r3 == null) goto L14;
                RichTextTheme.ADAPTER.encodeWithTag(r4, 5, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RichTextProperty) r2);
            }
        }

        public static final enum RichTextTheme extends Enum<RichTextTheme> implements WireEnum {
            private static final /* synthetic */ RichTextTheme[] $VALUES = null;
            public static final ProtoAdapter<RichTextTheme> ADAPTER = null;
            public static final RichTextTheme DARK = null;
            public static final RichTextTheme DEFAULT = null;
            public static final RichTextTheme LIGHT = null;
            private final int value;

            static {
                RichTextTheme r0 = new RichTextTheme("DEFAULT", 0, 0);
                DEFAULT = r0;
                RichTextTheme r1 = new RichTextTheme("DARK", 1, 1);
                DARK = r1;
                RichTextTheme r3 = new RichTextTheme("LIGHT", 2, 2);
                LIGHT = r3;
                $VALUES = new RichTextTheme[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(RichTextTheme.class);
            }

            public static RichTextTheme[] values() {
                return (RichTextTheme[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static RichTextTheme fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return LIGHT;
            L12:
                return DARK;
            L14:
                return DEFAULT;
            }

            public static RichTextTheme valueOf(String r1) {
                return (RichTextTheme) a.a(RichTextTheme.class, r1);
            }

            private RichTextTheme(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RichTextProperty();
            DEFAULT_NUMBER_OF_LINES = 0;
            DEFAULT_SHOW_UPDATE_TIME = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1645newBuilder() {
            Builder r0 = new Builder();
            r0.mrichtext = this.mrichtext;
            r0.mnumber_of_lines = this.mnumber_of_lines;
            r0.mat_out_chatter_ids = Internal.copyOf("mat_out_chatter_ids", this.mat_out_chatter_ids);
            r0.mshow_update_time = this.mshow_update_time;
            r0.mtheme = this.mtheme;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RichTextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1645newBuilder();
        }

        public RichTextProperty(RichText r8, Integer r9, List<String> r10, Boolean r11, RichTextTheme r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public RichTextProperty(RichText r2, Integer r3, List<String> r4, Boolean r5, RichTextTheme r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mrichtext = r2;
            this.mnumber_of_lines = r3;
            this.mat_out_chatter_ids = Internal.immutableCopyOf("mat_out_chatter_ids", r4);
            this.mshow_update_time = r5;
            this.mtheme = r6;
        }
    }

    public static final enum SizeLevel extends Enum<SizeLevel> implements WireEnum {
        private static final /* synthetic */ SizeLevel[] $VALUES = null;
        public static final ProtoAdapter<SizeLevel> ADAPTER = null;
        public static final SizeLevel LARGE = null;
        public static final SizeLevel NORMAL = null;
        public static final SizeLevel SMALL = null;
        private final int value;

        static {
            SizeLevel r0 = new SizeLevel("NORMAL", 0, 0);
            NORMAL = r0;
            SizeLevel r1 = new SizeLevel("SMALL", 1, 1);
            SMALL = r1;
            SizeLevel r3 = new SizeLevel("LARGE", 2, 2);
            LARGE = r3;
            $VALUES = new SizeLevel[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(SizeLevel.class);
        }

        public static SizeLevel[] values() {
            return (SizeLevel[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SizeLevel fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return LARGE;
        L12:
            return SMALL;
        L14:
            return NORMAL;
        }

        public static SizeLevel valueOf(String r1) {
            return (SizeLevel) a.a(SizeLevel.class, r1);
        }

        private SizeLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class SpinButtonProperty extends com.squareup.wire.Message<SpinButtonProperty, Builder> {
        public static final ProtoAdapter<SpinButtonProperty> ADAPTER = null;
        public static final Long DEFAULT_SELECTED_INDEX = null;
        private static final long serialVersionUID = 0;
        public final Direction mdirection;
        public final ImageSetV2 micon;
        public final List<Item> mitems;
        public final Long mselected_index;

        public static final class Builder extends com.squareup.wire.Message.Builder<SpinButtonProperty, Builder> {
            public Direction mdirection;
            public ImageSetV2 micon;
            public List<Item> mitems;
            public Long mselected_index;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SpinButtonProperty m1649build() {
                return new SpinButtonProperty(this.micon, this.mitems, this.mselected_index, this.mdirection, super.buildUnknownFields());
            }

            public Builder() {
                this.mitems = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1649build();
            }

            public Builder direction(Direction r1) {
                this.mdirection = r1;
                return this;
            }

            public Builder icon(ImageSetV2 r1) {
                this.micon = r1;
                return this;
            }

            public Builder items(List<Item> r1) {
                Internal.checkElementsNotNull(r1);
                this.mitems = r1;
                return this;
            }

            public Builder selected_index(Long r1) {
                this.mselected_index = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SpinButtonProperty extends ProtoAdapter<SpinButtonProperty> {
            public ProtoAdapter_SpinButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, SpinButtonProperty.class);
            }

            public SpinButtonProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mselected_index = 0L;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.micon = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mitems.add((Item) Item.ADAPTER.decode(r9));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mselected_index = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mdirection = (Direction) Direction.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1649build();
            }

            public int encodedSize(SpinButtonProperty r6) {
                ImageSetV2 r0 = r6.micon;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetV2.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                int r3 = r2 + Item.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mitems);
                Long r4 = r6.mselected_index;
                if (r4 == null) goto L9;
                int r5 = ProtoAdapter.INT64.encodedSizeWithTag(3, r4);
            L10:
                int r7 = r3 + r5;
                Direction r8 = r6.mdirection;
                if (r8 == null) goto L14;
                r1 = Direction.ADAPTER.encodedSizeWithTag(4, r8);
            L14:
                return (r7 + r1) + r6.unknownFields().size();
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1650decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SpinButtonProperty) r1);
            }

            public void encode(ProtoWriter r4, SpinButtonProperty r5) throws IOException {
                ImageSetV2 r0 = r5.micon;
                if (r0 == null) goto L5;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Item.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mitems);
                Long r1 = r5.mselected_index;
                if (r1 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r4, 3, r1);
            L8:
                Direction r2 = r5.mdirection;
                if (r2 == null) goto L11;
                Direction.ADAPTER.encodeWithTag(r4, 4, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SpinButtonProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SpinButtonProperty();
            DEFAULT_SELECTED_INDEX = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1648newBuilder() {
            Builder r0 = new Builder();
            r0.micon = this.micon;
            r0.mitems = Internal.copyOf("mitems", this.mitems);
            r0.mselected_index = this.mselected_index;
            r0.mdirection = this.mdirection;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SpinButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1648newBuilder();
        }

        public SpinButtonProperty(ImageSetV2 r7, List<Item> r8, Long r9, Direction r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public SpinButtonProperty(ImageSetV2 r2, List<Item> r3, Long r4, Direction r5, ByteString r6) {
            super(ADAPTER, r6);
            this.micon = r2;
            this.mitems = Internal.immutableCopyOf("mitems", r3);
            this.mselected_index = r4;
            this.mdirection = r5;
        }
    }

    public static final class Style extends com.squareup.wire.Message<Style, Builder> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final Integer DEFAULT_ASPECT_RATIO = null;
        public static final Integer DEFAULT_GROW_WEIGHT = null;
        public static final Integer DEFAULT_SHRINK_WEIGHT = null;
        public static final Integer DEFAULT_TEXT_COLOR = null;
        private static final long serialVersionUID = 0;
        public final Align malign_self;
        public final Integer maspect_ratio;
        public final Gradient mbackground_color;
        public final Border mborder;
        public final FontLevel mfont_level;
        public final Integer mgrow_weight;
        public final Value mheight;
        public final Value mmax_height;
        public final Value mmax_width;
        public final Value mmin_height;
        public final Value mmin_width;
        public final Integer mshrink_weight;
        public final SizeLevel msize_level;
        public final Integer mtext_color;
        public final ThemeColor mtext_color_v2;
        public final Value mwidth;

        public static final class Builder extends com.squareup.wire.Message.Builder<Style, Builder> {
            public Align malign_self;
            public Integer maspect_ratio;
            public Gradient mbackground_color;
            public Border mborder;
            public FontLevel mfont_level;
            public Integer mgrow_weight;
            public Value mheight;
            public Value mmax_height;
            public Value mmax_width;
            public Value mmin_height;
            public Value mmin_width;
            public Integer mshrink_weight;
            public SizeLevel msize_level;
            public Integer mtext_color;
            public ThemeColor mtext_color_v2;
            public Value mwidth;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Style m1652build() {
                return new Style(this.msize_level, this.mtext_color, this.mbackground_color, this.mwidth, this.mheight, this.mmax_width, this.mmax_height, this.mmin_width, this.mmin_height, this.mgrow_weight, this.mshrink_weight, this.mfont_level, this.mborder, this.mtext_color_v2, this.maspect_ratio, this.malign_self, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1652build();
            }

            public Builder align_self(Align r1) {
                this.malign_self = r1;
                return this;
            }

            public Builder aspect_ratio(Integer r1) {
                this.maspect_ratio = r1;
                return this;
            }

            public Builder background_color(Gradient r1) {
                this.mbackground_color = r1;
                return this;
            }

            public Builder border(Border r1) {
                this.mborder = r1;
                return this;
            }

            public Builder font_level(FontLevel r1) {
                this.mfont_level = r1;
                return this;
            }

            public Builder grow_weight(Integer r1) {
                this.mgrow_weight = r1;
                return this;
            }

            public Builder height(Value r1) {
                this.mheight = r1;
                return this;
            }

            public Builder max_height(Value r1) {
                this.mmax_height = r1;
                return this;
            }

            public Builder max_width(Value r1) {
                this.mmax_width = r1;
                return this;
            }

            public Builder min_height(Value r1) {
                this.mmin_height = r1;
                return this;
            }

            public Builder min_width(Value r1) {
                this.mmin_width = r1;
                return this;
            }

            public Builder shrink_weight(Integer r1) {
                this.mshrink_weight = r1;
                return this;
            }

            public Builder size_level(SizeLevel r1) {
                this.msize_level = r1;
                return this;
            }

            public Builder text_color(Integer r1) {
                this.mtext_color = r1;
                return this;
            }

            public Builder text_color_v2(ThemeColor r1) {
                this.mtext_color_v2 = r1;
                return this;
            }

            public Builder width(Value r1) {
                this.mwidth = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Style extends ProtoAdapter<Style> {
            public ProtoAdapter_Style() {
                super(FieldEncoding.LENGTH_DELIMITED, Style.class);
            }

            public Style decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mtext_color = 0;
                r0.mgrow_weight = 0;
                r0.mshrink_weight = 0;
                r0.maspect_ratio = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L29;
                switch(r3) {
                    case 1: goto L31;
                    case 2: goto L24;
                    case 3: goto L23;
                    case 4: goto L22;
                    case 5: goto L21;
                    case 6: goto L20;
                    case 7: goto L19;
                    case 8: goto L18;
                    case 9: goto L17;
                    case 10: goto L16;
                    case 11: goto L15;
                    case 12: goto L14;
                    case 13: goto L13;
                    case 14: goto L12;
                    case 15: goto L11;
                    case 16: goto L33;
                    default: goto L6;
                };
            L31:
                r0.msize_level = (SizeLevel) SizeLevel.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
            L27:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L33:
                r0.malign_self = (Align) Align.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r0.maspect_ratio = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L12:
                r0.mtext_color_v2 = (ThemeColor) ThemeColor.ADAPTER.decode(r9);
                goto L3
            L13:
                r0.mborder = (Border) Border.ADAPTER.decode(r9);
                goto L3
            L14:
                r0.mfont_level = (FontLevel) FontLevel.ADAPTER.decode(r9);
                goto L3
            L15:
                r0.mshrink_weight = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L16:
                r0.mgrow_weight = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L17:
                r0.mmin_height = (Value) Value.ADAPTER.decode(r9);
                goto L3
            L18:
                r0.mmin_width = (Value) Value.ADAPTER.decode(r9);
                goto L3
            L19:
                r0.mmax_height = (Value) Value.ADAPTER.decode(r9);
                goto L3
            L20:
                r0.mmax_width = (Value) Value.ADAPTER.decode(r9);
                goto L3
            L21:
                r0.mheight = (Value) Value.ADAPTER.decode(r9);
                goto L3
            L22:
                r0.mwidth = (Value) Value.ADAPTER.decode(r9);
                goto L3
            L23:
                r0.mbackground_color = (Gradient) Gradient.ADAPTER.decode(r9);
                goto L3
            L24:
                r0.mtext_color = (Integer) ProtoAdapter.UINT32.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L29:
                r9.endMessage(r1);
                return r0.m1652build();
            }

            public int encodedSize(Style r6) {
                SizeLevel r0 = r6.msize_level;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = SizeLevel.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mtext_color;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.UINT32.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Gradient r7 = r6.mbackground_color;
                if (r7 == null) goto L13;
                int r8 = Gradient.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Value r10 = r6.mwidth;
                if (r10 == null) goto L17;
                int r11 = Value.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Value r13 = r6.mheight;
                if (r13 == null) goto L21;
                int r14 = Value.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                Value r16 = r6.mmax_width;
                if (r16 == null) goto L25;
                int r17 = Value.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Value r19 = r6.mmax_height;
                if (r19 == null) goto L29;
                int r20 = Value.ADAPTER.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                Value r22 = r6.mmin_width;
                if (r22 == null) goto L33;
                int r23 = Value.ADAPTER.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                Value r25 = r6.mmin_height;
                if (r25 == null) goto L37;
                int r26 = Value.ADAPTER.encodedSizeWithTag(9, r25);
            L38:
                int r27 = r24 + r26;
                Integer r28 = r6.mgrow_weight;
                if (r28 == null) goto L41;
                int r29 = ProtoAdapter.INT32.encodedSizeWithTag(10, r28);
            L42:
                int r30 = r27 + r29;
                Integer r31 = r6.mshrink_weight;
                if (r31 == null) goto L45;
                int r32 = ProtoAdapter.INT32.encodedSizeWithTag(11, r31);
            L46:
                int r33 = r30 + r32;
                FontLevel r34 = r6.mfont_level;
                if (r34 == null) goto L49;
                int r35 = FontLevel.ADAPTER.encodedSizeWithTag(12, r34);
            L50:
                int r36 = r33 + r35;
                Border r37 = r6.mborder;
                if (r37 == null) goto L53;
                int r38 = Border.ADAPTER.encodedSizeWithTag(13, r37);
            L54:
                int r39 = r36 + r38;
                ThemeColor r40 = r6.mtext_color_v2;
                if (r40 == null) goto L57;
                int r41 = ThemeColor.ADAPTER.encodedSizeWithTag(14, r40);
            L58:
                int r42 = r39 + r41;
                Integer r43 = r6.maspect_ratio;
                if (r43 == null) goto L61;
                int r44 = ProtoAdapter.INT32.encodedSizeWithTag(15, r43);
            L62:
                int r45 = r42 + r44;
                Align r46 = r6.malign_self;
                if (r46 == null) goto L66;
                r1 = Align.ADAPTER.encodedSizeWithTag(16, r46);
            L66:
                return (r45 + r1) + r6.unknownFields().size();
            L61:
                r44 = 0;
                goto L62
            L57:
                r41 = 0;
                goto L58
            L53:
                r38 = 0;
                goto L54
            L49:
                r35 = 0;
                goto L50
            L45:
                r32 = 0;
                goto L46
            L41:
                r29 = 0;
                goto L42
            L37:
                r26 = 0;
                goto L38
            L33:
                r23 = 0;
                goto L34
            L29:
                r20 = 0;
                goto L30
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1653decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Style) r1);
            }

            public void encode(ProtoWriter r4, Style r5) throws IOException {
                SizeLevel r0 = r5.msize_level;
                if (r0 == null) goto L5;
                SizeLevel.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mtext_color;
                if (r1 == null) goto L8;
                ProtoAdapter.UINT32.encodeWithTag(r4, 2, r1);
            L8:
                Gradient r2 = r5.mbackground_color;
                if (r2 == null) goto L11;
                Gradient.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                Value r3 = r5.mwidth;
                if (r3 == null) goto L14;
                Value.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                Value r6 = r5.mheight;
                if (r6 == null) goto L17;
                Value.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                Value r7 = r5.mmax_width;
                if (r7 == null) goto L20;
                Value.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                Value r8 = r5.mmax_height;
                if (r8 == null) goto L23;
                Value.ADAPTER.encodeWithTag(r4, 7, r8);
            L23:
                Value r9 = r5.mmin_width;
                if (r9 == null) goto L26;
                Value.ADAPTER.encodeWithTag(r4, 8, r9);
            L26:
                Value r10 = r5.mmin_height;
                if (r10 == null) goto L29;
                Value.ADAPTER.encodeWithTag(r4, 9, r10);
            L29:
                Integer r11 = r5.mgrow_weight;
                if (r11 == null) goto L32;
                ProtoAdapter.INT32.encodeWithTag(r4, 10, r11);
            L32:
                Integer r12 = r5.mshrink_weight;
                if (r12 == null) goto L35;
                ProtoAdapter.INT32.encodeWithTag(r4, 11, r12);
            L35:
                FontLevel r13 = r5.mfont_level;
                if (r13 == null) goto L38;
                FontLevel.ADAPTER.encodeWithTag(r4, 12, r13);
            L38:
                Border r14 = r5.mborder;
                if (r14 == null) goto L41;
                Border.ADAPTER.encodeWithTag(r4, 13, r14);
            L41:
                ThemeColor r15 = r5.mtext_color_v2;
                if (r15 == null) goto L44;
                ThemeColor.ADAPTER.encodeWithTag(r4, 14, r15);
            L44:
                Integer r16 = r5.maspect_ratio;
                if (r16 == null) goto L47;
                ProtoAdapter.INT32.encodeWithTag(r4, 15, r16);
            L47:
                Align r17 = r5.malign_self;
                if (r17 == null) goto L50;
                Align.ADAPTER.encodeWithTag(r4, 16, r17);
            L50:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Style) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Style();
            DEFAULT_TEXT_COLOR = 0;
            DEFAULT_GROW_WEIGHT = 0;
            DEFAULT_SHRINK_WEIGHT = 0;
            DEFAULT_ASPECT_RATIO = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1651newBuilder() {
            Builder r0 = new Builder();
            r0.msize_level = this.msize_level;
            r0.mtext_color = this.mtext_color;
            r0.mbackground_color = this.mbackground_color;
            r0.mwidth = this.mwidth;
            r0.mheight = this.mheight;
            r0.mmax_width = this.mmax_width;
            r0.mmax_height = this.mmax_height;
            r0.mmin_width = this.mmin_width;
            r0.mmin_height = this.mmin_height;
            r0.mgrow_weight = this.mgrow_weight;
            r0.mshrink_weight = this.mshrink_weight;
            r0.mfont_level = this.mfont_level;
            r0.mborder = this.mborder;
            r0.mtext_color_v2 = this.mtext_color_v2;
            r0.maspect_ratio = this.maspect_ratio;
            r0.malign_self = this.malign_self;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Style.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1651newBuilder();
        }

        public Style(SizeLevel r19, Integer r20, Gradient r21, Value r22, Value r23, Value r24, Value r25, Value r26, Value r27, Integer r28, Integer r29, FontLevel r30, Border r31, ThemeColor r32, Integer r33, Align r34) {
            this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, ByteString.EMPTY);
        }

        public Style(SizeLevel r4, Integer r5, Gradient r6, Value r7, Value r8, Value r9, Value r10, Value r11, Value r12, Integer r13, Integer r14, FontLevel r15, Border r16, ThemeColor r17, Integer r18, Align r19, ByteString r20) {
            super(ADAPTER, r20);
            this.msize_level = r4;
            this.mtext_color = r5;
            this.mbackground_color = r6;
            this.mwidth = r7;
            this.mheight = r8;
            this.mmax_width = r9;
            this.mmax_height = r10;
            this.mmin_width = r11;
            this.mmin_height = r12;
            this.mgrow_weight = r13;
            this.mshrink_weight = r14;
            this.mfont_level = r15;
            this.mborder = r16;
            this.mtext_color_v2 = r17;
            this.maspect_ratio = r18;
            this.malign_self = r19;
        }
    }

    public static final class TagListProperty extends com.squareup.wire.Message<TagListProperty, Builder> {
        public static final ProtoAdapter<TagListProperty> ADAPTER = null;
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        private static final long serialVersionUID = 0;
        public final List<Tag> mmixed_tags;
        public final Integer mnumber_of_lines;
        public final List<String> mtags;

        public static final class Builder extends com.squareup.wire.Message.Builder<TagListProperty, Builder> {
            public List<Tag> mmixed_tags;
            public Integer mnumber_of_lines;
            public List<String> mtags;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TagListProperty m1655build() {
                return new TagListProperty(this.mtags, this.mmixed_tags, this.mnumber_of_lines, super.buildUnknownFields());
            }

            public Builder() {
                this.mtags = Internal.newMutableList();
                this.mmixed_tags = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1655build();
            }

            public Builder mixed_tags(List<Tag> r1) {
                Internal.checkElementsNotNull(r1);
                this.mmixed_tags = r1;
                return this;
            }

            public Builder number_of_lines(Integer r1) {
                this.mnumber_of_lines = r1;
                return this;
            }

            public Builder tags(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mtags = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TagListProperty extends ProtoAdapter<TagListProperty> {
            public ProtoAdapter_TagListProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TagListProperty.class);
            }

            public TagListProperty decode(ProtoReader r8) throws IOException {
                Builder r0 = new Builder();
                r0.mnumber_of_lines = 1;
                long r2 = r8.beginMessage();
            L3:
                int r4 = r8.nextTag();
                if (r4 == (-1)) goto L14;
                if (r4 != 1) goto L7;
                r0.mtags.add((String) ProtoAdapter.STRING.decode(r8));
                goto L3
            L7:
                if (r4 != 2) goto L9;
                r0.mmixed_tags.add((Tag) Tag.ADAPTER.decode(r8));
                goto L3
            L9:
                if (r4 != 3) goto L10;
                r0.mnumber_of_lines = (Integer) ProtoAdapter.INT32.decode(r8);
                goto L3
            L10:
                FieldEncoding r5 = r8.peekFieldEncoding();
                r0.addUnknownField(r4, r5, r5.rawProtoAdapter().decode(r8));
                goto L3
            L14:
                r8.endMessage(r2);
                return r0.m1655build();
            }

            public int encodedSize(TagListProperty r5) {
                int r0 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r5.mtags) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mmixed_tags);
                Integer r1 = r5.mnumber_of_lines;
                if (r1 == null) goto L5;
                int r2 = ProtoAdapter.INT32.encodedSizeWithTag(3, r1);
            L7:
                return (r0 + r2) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1656decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TagListProperty) r1);
            }

            public void encode(ProtoWriter r4, TagListProperty r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mtags);
                Tag.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mmixed_tags);
                Integer r0 = r5.mnumber_of_lines;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 3, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TagListProperty) r2);
            }
        }

        public static final class Tag extends com.squareup.wire.Message<Tag, Builder> {
            public static final ProtoAdapter<Tag> ADAPTER = null;
            public static final String DEFAULT_TAG = "";
            private static final long serialVersionUID = 0;
            public final ThemeColor mbackground_color;
            public final String mtag;
            public final ThemeColor mtext_color;

            public static final class Builder extends com.squareup.wire.Message.Builder<Tag, Builder> {
                public ThemeColor mbackground_color;
                public String mtag;
                public ThemeColor mtext_color;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Tag m1658build() {
                    return new Tag(this.mtag, this.mtext_color, this.mbackground_color, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return m1658build();
                }

                public Builder background_color(ThemeColor r1) {
                    this.mbackground_color = r1;
                    return this;
                }

                public Builder tag(String r1) {
                    this.mtag = r1;
                    return this;
                }

                public Builder text_color(ThemeColor r1) {
                    this.mtext_color = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Tag extends ProtoAdapter<Tag> {
                public ProtoAdapter_Tag() {
                    super(FieldEncoding.LENGTH_DELIMITED, Tag.class);
                }

                public Tag decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mtag = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L15;
                    if (r3 != 1) goto L8;
                    r0.mtag = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mtext_color = (ThemeColor) ThemeColor.ADAPTER.decode(r7);
                    goto L3
                L10:
                    if (r3 != 3) goto L11;
                    r0.mbackground_color = (ThemeColor) ThemeColor.ADAPTER.decode(r7);
                    goto L3
                L11:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L15:
                    r7.endMessage(r1);
                    return r0.m1658build();
                }

                public int encodedSize(Tag r6) {
                    String r0 = r6.mtag;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
                L6:
                    ThemeColor r3 = r6.mtext_color;
                    if (r3 == null) goto L9;
                    int r4 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r3);
                L10:
                    int r5 = r2 + r4;
                    ThemeColor r7 = r6.mbackground_color;
                    if (r7 == null) goto L14;
                    r1 = ThemeColor.ADAPTER.encodedSizeWithTag(3, r7);
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
                public /* bridge */ /* synthetic */ Object m1659decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Tag) r1);
                }

                public void encode(ProtoWriter r4, Tag r5) throws IOException {
                    String r0 = r5.mtag;
                    if (r0 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
                L5:
                    ThemeColor r1 = r5.mtext_color;
                    if (r1 == null) goto L8;
                    ThemeColor.ADAPTER.encodeWithTag(r4, 2, r1);
                L8:
                    ThemeColor r2 = r5.mbackground_color;
                    if (r2 == null) goto L11;
                    ThemeColor.ADAPTER.encodeWithTag(r4, 3, r2);
                L11:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Tag) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Tag();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1657newBuilder() {
                Builder r0 = new Builder();
                r0.mtag = this.mtag;
                r0.mtext_color = this.mtext_color;
                r0.mbackground_color = this.mbackground_color;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Tag.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return m1657newBuilder();
            }

            public Tag(String r2, ThemeColor r3, ThemeColor r4) {
                this(r2, r3, r4, ByteString.EMPTY);
            }

            public Tag(String r2, ThemeColor r3, ThemeColor r4, ByteString r5) {
                super(ADAPTER, r5);
                this.mtag = r2;
                this.mtext_color = r3;
                this.mbackground_color = r4;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TagListProperty();
            DEFAULT_NUMBER_OF_LINES = 1;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1654newBuilder() {
            Builder r0 = new Builder();
            r0.mtags = Internal.copyOf("mtags", this.mtags);
            r0.mmixed_tags = Internal.copyOf("mmixed_tags", this.mmixed_tags);
            r0.mnumber_of_lines = this.mnumber_of_lines;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TagListProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1654newBuilder();
        }

        public TagListProperty(List<String> r2, List<Tag> r3, Integer r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TagListProperty(List<String> r2, List<Tag> r3, Integer r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtags = Internal.immutableCopyOf("mtags", r2);
            this.mmixed_tags = Internal.immutableCopyOf("mmixed_tags", r3);
            this.mnumber_of_lines = r4;
        }
    }

    public static final class TextButtonProperty extends com.squareup.wire.Message<TextButtonProperty, Builder> {
        public static final ProtoAdapter<TextButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_IS_DISABLE = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final Boolean mis_disable;
        public final String mtext;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextButtonProperty, Builder> {
            public String maction_id;
            public Boolean mis_disable;
            public String mtext;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TextButtonProperty m1661build() {
                return new TextButtonProperty(this.mtext, this.maction_id, this.mis_disable, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1661build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder is_disable(Boolean r1) {
                this.mis_disable = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TextButtonProperty extends ProtoAdapter<TextButtonProperty> {
            public ProtoAdapter_TextButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextButtonProperty.class);
            }

            public TextButtonProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtext = "";
                r0.maction_id = "";
                r0.mis_disable = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mis_disable = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1661build();
            }

            public int encodedSize(TextButtonProperty r6) {
                String r0 = r6.mtext;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.maction_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mis_disable;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m1662decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TextButtonProperty) r1);
            }

            public void encode(ProtoWriter r4, TextButtonProperty r5) throws IOException {
                String r0 = r5.mtext;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.maction_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mis_disable;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TextButtonProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextButtonProperty();
            DEFAULT_IS_DISABLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1660newBuilder() {
            Builder r0 = new Builder();
            r0.mtext = this.mtext;
            r0.maction_id = this.maction_id;
            r0.mis_disable = this.mis_disable;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TextButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1660newBuilder();
        }

        public TextButtonProperty(String r2, String r3, Boolean r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TextButtonProperty(String r2, String r3, Boolean r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtext = r2;
            this.maction_id = r3;
            this.mis_disable = r4;
        }
    }

    public static final class TextProperty extends com.squareup.wire.Message<TextProperty, Builder> {
        public static final ProtoAdapter<TextProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Integer DEFAULT_NUMBER_OF_LINES = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final Integer mnumber_of_lines;
        public final String mtext;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextProperty, Builder> {
            public String maction_id;
            public Integer mnumber_of_lines;
            public String mtext;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TextProperty m1664build() {
                return new TextProperty(this.mtext, this.mnumber_of_lines, this.maction_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1664build();
            }

            public Builder action_id(String r1) {
                this.maction_id = r1;
                return this;
            }

            public Builder number_of_lines(Integer r1) {
                this.mnumber_of_lines = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TextProperty extends ProtoAdapter<TextProperty> {
            public ProtoAdapter_TextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextProperty.class);
            }

            public TextProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtext = "";
                r0.mnumber_of_lines = 0;
                r0.maction_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mnumber_of_lines = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1664build();
            }

            public int encodedSize(TextProperty r6) {
                String r0 = r6.mtext;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r6.mnumber_of_lines;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.maction_id;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m1665decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TextProperty) r1);
            }

            public void encode(ProtoWriter r4, TextProperty r5) throws IOException {
                String r0 = r5.mtext;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mnumber_of_lines;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.maction_id;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TextProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextProperty();
            DEFAULT_NUMBER_OF_LINES = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1663newBuilder() {
            Builder r0 = new Builder();
            r0.mtext = this.mtext;
            r0.mnumber_of_lines = this.mnumber_of_lines;
            r0.maction_id = this.maction_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1663newBuilder();
        }

        public TextProperty(String r2, Integer r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TextProperty(String r2, Integer r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtext = r2;
            this.mnumber_of_lines = r3;
            this.maction_id = r4;
        }
    }

    public static final enum Theme extends Enum<Theme> implements WireEnum {
        private static final /* synthetic */ Theme[] $VALUES = null;
        public static final ProtoAdapter<Theme> ADAPTER = null;
        public static final Theme DARK = null;
        public static final Theme LIGHT = null;
        private final int value;

        static {
            Theme r0 = new Theme("LIGHT", 0, 0);
            LIGHT = r0;
            Theme r1 = new Theme("DARK", 1, 1);
            DARK = r1;
            $VALUES = new Theme[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Theme.class);
        }

        public static Theme[] values() {
            return (Theme[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Theme fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return DARK;
        L10:
            return LIGHT;
        }

        public static Theme valueOf(String r1) {
            return (Theme) a.a(Theme.class, r1);
        }

        private Theme(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class TimeProperty extends com.squareup.wire.Message<TimeProperty, Builder> {
        public static final ProtoAdapter<TimeProperty> ADAPTER = null;
        public static final Long DEFAULT_END_TIME_STAMP = null;
        public static final Boolean DEFAULT_IS_COUNTDOWN = null;
        public static final Boolean DEFAULT_IS_END = null;
        public static final String DEFAULT_NTP_ACTION_ID = "";
        public static final Long DEFAULT_START_TIME_STAMP = null;
        private static final long serialVersionUID = 0;
        public final Long mend_time_stamp;
        public final Boolean mis_countdown;
        public final Boolean mis_end;
        public final String mntp_action_id;
        public final Long mstart_time_stamp;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeProperty, Builder> {
            public Long mend_time_stamp;
            public Boolean mis_countdown;
            public Boolean mis_end;
            public String mntp_action_id;
            public Long mstart_time_stamp;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TimeProperty m1667build() {
                Long r0 = this.mstart_time_stamp;
                if (r0 == null) goto L7;
                return new TimeProperty(this.mstart_time_stamp, this.mis_countdown, this.mntp_action_id, this.mis_end, this.mend_time_stamp, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mstart_time_stamp"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1667build();
            }

            public Builder end_time_stamp(Long r1) {
                this.mend_time_stamp = r1;
                return this;
            }

            public Builder is_countdown(Boolean r1) {
                this.mis_countdown = r1;
                return this;
            }

            public Builder is_end(Boolean r1) {
                this.mis_end = r1;
                return this;
            }

            public Builder ntp_action_id(String r1) {
                this.mntp_action_id = r1;
                return this;
            }

            public Builder start_time_stamp(Long r1) {
                this.mstart_time_stamp = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeProperty extends ProtoAdapter<TimeProperty> {
            public ProtoAdapter_TimeProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeProperty.class);
            }

            public TimeProperty decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mstart_time_stamp = 0L;
                Boolean r2 = Boolean.FALSE;
                r0.mis_countdown = r2;
                r0.mntp_action_id = "";
                r0.mis_end = r2;
                r0.mend_time_stamp = 0L;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mstart_time_stamp = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mis_countdown = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mntp_action_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.mis_end = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mend_time_stamp = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1667build();
            }

            public int encodedSize(TimeProperty r7) {
                ProtoAdapter r0 = ProtoAdapter.INT64;
                int r1 = r0.encodedSizeWithTag(1, r7.mstart_time_stamp);
                Boolean r2 = r7.mis_countdown;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r2);
            L6:
                int r5 = r1 + r4;
                String r6 = r7.mntp_action_id;
                if (r6 == null) goto L9;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r6);
            L10:
                int r9 = r5 + r8;
                Boolean r10 = r7.mis_end;
                if (r10 == null) goto L13;
                int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
            L14:
                int r12 = r9 + r11;
                Long r13 = r7.mend_time_stamp;
                if (r13 == null) goto L18;
                r3 = r0.encodedSizeWithTag(5, r13);
            L18:
                return (r12 + r3) + r7.unknownFields().size();
            L13:
                r11 = 0;
                goto L14
            L9:
                r8 = 0;
                goto L10
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1668decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TimeProperty) r1);
            }

            public void encode(ProtoWriter r5, TimeProperty r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.INT64;
                r0.encodeWithTag(r5, 1, r6.mstart_time_stamp);
                Boolean r1 = r6.mis_countdown;
                if (r1 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r5, 2, r1);
            L5:
                String r2 = r6.mntp_action_id;
                if (r2 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r5, 3, r2);
            L8:
                Boolean r3 = r6.mis_end;
                if (r3 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r5, 4, r3);
            L11:
                Long r4 = r6.mend_time_stamp;
                if (r4 == null) goto L14;
                r0.encodeWithTag(r5, 5, r4);
            L14:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TimeProperty) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeProperty();
            DEFAULT_START_TIME_STAMP = 0L;
            Boolean r1 = Boolean.FALSE;
            DEFAULT_IS_COUNTDOWN = r1;
            DEFAULT_IS_END = r1;
            DEFAULT_END_TIME_STAMP = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1666newBuilder() {
            Builder r0 = new Builder();
            r0.mstart_time_stamp = this.mstart_time_stamp;
            r0.mis_countdown = this.mis_countdown;
            r0.mntp_action_id = this.mntp_action_id;
            r0.mis_end = this.mis_end;
            r0.mend_time_stamp = this.mend_time_stamp;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TimeProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1666newBuilder();
        }

        public TimeProperty(Long r8, Boolean r9, String r10, Boolean r11, Long r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public TimeProperty(Long r2, Boolean r3, String r4, Boolean r5, Long r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mstart_time_stamp = r2;
            this.mis_countdown = r3;
            this.mntp_action_id = r4;
            this.mis_end = r5;
            this.mend_time_stamp = r6;
        }
    }

    public static final class TimeZoneProperty extends com.squareup.wire.Message<TimeZoneProperty, Builder> {
        public static final ProtoAdapter<TimeZoneProperty> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE_GMT = null;
        public static final Long DEFAULT_END_TIME_STAMP = null;
        public static final Long DEFAULT_START_TIME_STAMP = null;
        private static final long serialVersionUID = 0;
        public final DatePrecisionType mdate_precision_type;
        public final DateStatusType mdate_status_type;
        public final Boolean menable_gmt;
        public final Long mend_time_stamp;
        public final FormatType mformat_type;
        public final Long mstart_time_stamp;
        public final TimePrecisionType mtime_precision_type;
        public final TimeStyle mtime_style;
        public final TimeZoneType mtime_zone_type;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeZoneProperty, Builder> {
            public DatePrecisionType mdate_precision_type;
            public DateStatusType mdate_status_type;
            public Boolean menable_gmt;
            public Long mend_time_stamp;
            public FormatType mformat_type;
            public Long mstart_time_stamp;
            public TimePrecisionType mtime_precision_type;
            public TimeStyle mtime_style;
            public TimeZoneType mtime_zone_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TimeZoneProperty m1670build() {
                return new TimeZoneProperty(this.mtime_zone_type, this.mformat_type, this.mtime_precision_type, this.mtime_style, this.mdate_precision_type, this.mdate_status_type, this.mstart_time_stamp, this.mend_time_stamp, this.menable_gmt, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1670build();
            }

            public Builder date_precision_type(DatePrecisionType r1) {
                this.mdate_precision_type = r1;
                return this;
            }

            public Builder date_status_type(DateStatusType r1) {
                this.mdate_status_type = r1;
                return this;
            }

            public Builder enable_gmt(Boolean r1) {
                this.menable_gmt = r1;
                return this;
            }

            public Builder end_time_stamp(Long r1) {
                this.mend_time_stamp = r1;
                return this;
            }

            public Builder format_type(FormatType r1) {
                this.mformat_type = r1;
                return this;
            }

            public Builder start_time_stamp(Long r1) {
                this.mstart_time_stamp = r1;
                return this;
            }

            public Builder time_precision_type(TimePrecisionType r1) {
                this.mtime_precision_type = r1;
                return this;
            }

            public Builder time_style(TimeStyle r1) {
                this.mtime_style = r1;
                return this;
            }

            public Builder time_zone_type(TimeZoneType r1) {
                this.mtime_zone_type = r1;
                return this;
            }
        }

        public static final enum DatePrecisionType extends Enum<DatePrecisionType> implements WireEnum {
            private static final /* synthetic */ DatePrecisionType[] $VALUES = null;
            public static final ProtoAdapter<DatePrecisionType> ADAPTER = null;
            public static final DatePrecisionType DAY_TYPE = null;
            public static final DatePrecisionType MONTH_TYPE = null;
            private final int value;

            static {
                DatePrecisionType r0 = new DatePrecisionType("DAY_TYPE", 0, 0);
                DAY_TYPE = r0;
                DatePrecisionType r1 = new DatePrecisionType("MONTH_TYPE", 1, 1);
                MONTH_TYPE = r1;
                $VALUES = new DatePrecisionType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(DatePrecisionType.class);
            }

            public static DatePrecisionType[] values() {
                return (DatePrecisionType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static DatePrecisionType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return MONTH_TYPE;
            L10:
                return DAY_TYPE;
            }

            public static DatePrecisionType valueOf(String r1) {
                return (DatePrecisionType) a.a(DatePrecisionType.class, r1);
            }

            private DatePrecisionType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum DateStatusType extends Enum<DateStatusType> implements WireEnum {
            private static final /* synthetic */ DateStatusType[] $VALUES = null;
            public static final DateStatusType ABSOLUTE = null;
            public static final ProtoAdapter<DateStatusType> ADAPTER = null;
            public static final DateStatusType RELATIVE = null;
            private final int value;

            static {
                DateStatusType r0 = new DateStatusType("ABSOLUTE", 0, 0);
                ABSOLUTE = r0;
                DateStatusType r1 = new DateStatusType("RELATIVE", 1, 1);
                RELATIVE = r1;
                $VALUES = new DateStatusType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(DateStatusType.class);
            }

            public static DateStatusType[] values() {
                return (DateStatusType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static DateStatusType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return RELATIVE;
            L10:
                return ABSOLUTE;
            }

            public static DateStatusType valueOf(String r1) {
                return (DateStatusType) a.a(DateStatusType.class, r1);
            }

            private DateStatusType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum FormatType extends Enum<FormatType> implements WireEnum {
            private static final /* synthetic */ FormatType[] $VALUES = null;
            public static final ProtoAdapter<FormatType> ADAPTER = null;
            public static final FormatType LONG = null;
            public static final FormatType SHORT = null;
            private final int value;

            static {
                FormatType r0 = new FormatType("SHORT", 0, 0);
                SHORT = r0;
                FormatType r1 = new FormatType("LONG", 1, 1);
                LONG = r1;
                $VALUES = new FormatType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(FormatType.class);
            }

            public static FormatType[] values() {
                return (FormatType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static FormatType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return LONG;
            L10:
                return SHORT;
            }

            public static FormatType valueOf(String r1) {
                return (FormatType) a.a(FormatType.class, r1);
            }

            private FormatType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_TimeZoneProperty extends ProtoAdapter<TimeZoneProperty> {
            public ProtoAdapter_TimeZoneProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeZoneProperty.class);
            }

            public TimeZoneProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mstart_time_stamp = 0L;
                r0.mend_time_stamp = 0L;
                r0.menable_gmt = Boolean.TRUE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L34;
                switch(r3) {
                    case 1: goto L40;
                    case 2: goto L44;
                    case 3: goto L46;
                    case 4: goto L36;
                    case 5: goto L42;
                    case 6: goto L38;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L36:
                r0.mtime_style = (TimeStyle) TimeStyle.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L38:
                r0.mdate_status_type = (DateStatusType) DateStatusType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L40:
                r0.mtime_zone_type = (TimeZoneType) TimeZoneType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
            L32:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L42:
                r0.mdate_precision_type = (DatePrecisionType) DatePrecisionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L44:
                r0.mformat_type = (FormatType) FormatType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
            L28:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L46:
                r0.mtime_precision_type = (TimePrecisionType) TimePrecisionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
            L24:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.menable_gmt = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L8:
                r0.mend_time_stamp = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L9:
                r0.mstart_time_stamp = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L34:
                r9.endMessage(r1);
                return r0.m1670build();
            }

            public int encodedSize(TimeZoneProperty r6) {
                TimeZoneType r0 = r6.mtime_zone_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = TimeZoneType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                FormatType r3 = r6.mformat_type;
                if (r3 == null) goto L9;
                int r4 = FormatType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                TimePrecisionType r7 = r6.mtime_precision_type;
                if (r7 == null) goto L13;
                int r8 = TimePrecisionType.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                TimeStyle r10 = r6.mtime_style;
                if (r10 == null) goto L17;
                int r11 = TimeStyle.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                DatePrecisionType r13 = r6.mdate_precision_type;
                if (r13 == null) goto L21;
                int r14 = DatePrecisionType.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                DateStatusType r16 = r6.mdate_status_type;
                if (r16 == null) goto L25;
                int r17 = DateStatusType.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Long r19 = r6.mstart_time_stamp;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.INT64.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                Long r22 = r6.mend_time_stamp;
                if (r22 == null) goto L33;
                int r23 = ProtoAdapter.INT64.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                Boolean r25 = r6.menable_gmt;
                if (r25 == null) goto L38;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
            L38:
                return (r24 + r1) + r6.unknownFields().size();
            L33:
                r23 = 0;
                goto L34
            L29:
                r20 = 0;
                goto L30
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1671decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TimeZoneProperty) r1);
            }

            public void encode(ProtoWriter r4, TimeZoneProperty r5) throws IOException {
                TimeZoneType r0 = r5.mtime_zone_type;
                if (r0 == null) goto L5;
                TimeZoneType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                FormatType r1 = r5.mformat_type;
                if (r1 == null) goto L8;
                FormatType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                TimePrecisionType r2 = r5.mtime_precision_type;
                if (r2 == null) goto L11;
                TimePrecisionType.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                TimeStyle r3 = r5.mtime_style;
                if (r3 == null) goto L14;
                TimeStyle.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                DatePrecisionType r6 = r5.mdate_precision_type;
                if (r6 == null) goto L17;
                DatePrecisionType.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                DateStatusType r7 = r5.mdate_status_type;
                if (r7 == null) goto L20;
                DateStatusType.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                Long r8 = r5.mstart_time_stamp;
                if (r8 == null) goto L23;
                ProtoAdapter.INT64.encodeWithTag(r4, 7, r8);
            L23:
                Long r9 = r5.mend_time_stamp;
                if (r9 == null) goto L26;
                ProtoAdapter.INT64.encodeWithTag(r4, 8, r9);
            L26:
                Boolean r10 = r5.menable_gmt;
                if (r10 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r4, 9, r10);
            L29:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TimeZoneProperty) r2);
            }
        }

        public static final enum TimePrecisionType extends Enum<TimePrecisionType> implements WireEnum {
            private static final /* synthetic */ TimePrecisionType[] $VALUES = null;
            public static final ProtoAdapter<TimePrecisionType> ADAPTER = null;
            public static final TimePrecisionType HOUR = null;
            public static final TimePrecisionType MINUTE = null;
            public static final TimePrecisionType SECOND = null;
            private final int value;

            static {
                TimePrecisionType r0 = new TimePrecisionType("SECOND", 0, 0);
                SECOND = r0;
                TimePrecisionType r1 = new TimePrecisionType("MINUTE", 1, 1);
                MINUTE = r1;
                TimePrecisionType r3 = new TimePrecisionType("HOUR", 2, 2);
                HOUR = r3;
                $VALUES = new TimePrecisionType[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimePrecisionType.class);
            }

            public static TimePrecisionType[] values() {
                return (TimePrecisionType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TimePrecisionType fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return HOUR;
            L12:
                return MINUTE;
            L14:
                return SECOND;
            }

            public static TimePrecisionType valueOf(String r1) {
                return (TimePrecisionType) a.a(TimePrecisionType.class, r1);
            }

            private TimePrecisionType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum TimeStyle extends Enum<TimeStyle> implements WireEnum {
            private static final /* synthetic */ TimeStyle[] $VALUES = null;
            public static final ProtoAdapter<TimeStyle> ADAPTER = null;
            public static final TimeStyle BY_12_HOUR = null;
            public static final TimeStyle BY_24_HOUR = null;
            public static final TimeStyle DEFAULT = null;
            private final int value;

            static {
                TimeStyle r0 = new TimeStyle("DEFAULT", 0, 0);
                DEFAULT = r0;
                TimeStyle r1 = new TimeStyle("BY_12_HOUR", 1, 1);
                BY_12_HOUR = r1;
                TimeStyle r3 = new TimeStyle("BY_24_HOUR", 2, 2);
                BY_24_HOUR = r3;
                $VALUES = new TimeStyle[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeStyle.class);
            }

            public static TimeStyle[] values() {
                return (TimeStyle[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TimeStyle fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return BY_24_HOUR;
            L12:
                return BY_12_HOUR;
            L14:
                return DEFAULT;
            }

            public static TimeStyle valueOf(String r1) {
                return (TimeStyle) a.a(TimeStyle.class, r1);
            }

            private TimeStyle(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum TimeZoneType extends Enum<TimeZoneType> implements WireEnum {
            private static final /* synthetic */ TimeZoneType[] $VALUES = null;
            public static final ProtoAdapter<TimeZoneType> ADAPTER = null;
            public static final TimeZoneType DATE = null;
            public static final TimeZoneType DATE_RANGE = null;
            public static final TimeZoneType DATE_TIME = null;
            public static final TimeZoneType DATE_TIME_RANGE = null;
            public static final TimeZoneType FULL_DATE = null;
            public static final TimeZoneType FULL_DATE_TIME = null;
            public static final TimeZoneType MERIDIEM = null;
            public static final TimeZoneType MONTH = null;
            public static final TimeZoneType TIME = null;
            public static final TimeZoneType WEEK = null;
            private final int value;

            static {
                TimeZoneType r0 = new TimeZoneType("MERIDIEM", 0, 0);
                MERIDIEM = r0;
                TimeZoneType r1 = new TimeZoneType("WEEK", 1, 1);
                WEEK = r1;
                TimeZoneType r3 = new TimeZoneType("MONTH", 2, 2);
                MONTH = r3;
                TimeZoneType r5 = new TimeZoneType("TIME", 3, 3);
                TIME = r5;
                TimeZoneType r7 = new TimeZoneType("DATE", 4, 4);
                DATE = r7;
                TimeZoneType r9 = new TimeZoneType("FULL_DATE", 5, 5);
                FULL_DATE = r9;
                TimeZoneType r11 = new TimeZoneType("DATE_TIME", 6, 6);
                DATE_TIME = r11;
                TimeZoneType r13 = new TimeZoneType("FULL_DATE_TIME", 7, 7);
                FULL_DATE_TIME = r13;
                TimeZoneType r15 = new TimeZoneType("DATE_RANGE", 8, 8);
                DATE_RANGE = r15;
                TimeZoneType r14 = new TimeZoneType("DATE_TIME_RANGE", 9, 9);
                DATE_TIME_RANGE = r14;
                $VALUES = new TimeZoneType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeZoneType.class);
            }

            public static TimeZoneType[] values() {
                return (TimeZoneType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TimeZoneType fromValue(int r0) {
                switch(r0) {
                    case 0: goto L24;
                    case 1: goto L22;
                    case 2: goto L20;
                    case 3: goto L18;
                    case 4: goto L16;
                    case 5: goto L14;
                    case 6: goto L12;
                    case 7: goto L10;
                    case 8: goto L8;
                    case 9: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return DATE_TIME_RANGE;
            L8:
                return DATE_RANGE;
            L10:
                return FULL_DATE_TIME;
            L12:
                return DATE_TIME;
            L14:
                return FULL_DATE;
            L16:
                return DATE;
            L18:
                return TIME;
            L20:
                return MONTH;
            L22:
                return WEEK;
            L24:
                return MERIDIEM;
            }

            public static TimeZoneType valueOf(String r1) {
                return (TimeZoneType) a.a(TimeZoneType.class, r1);
            }

            private TimeZoneType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeZoneProperty();
            DEFAULT_START_TIME_STAMP = 0L;
            DEFAULT_END_TIME_STAMP = 0L;
            DEFAULT_ENABLE_GMT = Boolean.TRUE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1669newBuilder() {
            Builder r0 = new Builder();
            r0.mtime_zone_type = this.mtime_zone_type;
            r0.mformat_type = this.mformat_type;
            r0.mtime_precision_type = this.mtime_precision_type;
            r0.mtime_style = this.mtime_style;
            r0.mdate_precision_type = this.mdate_precision_type;
            r0.mdate_status_type = this.mdate_status_type;
            r0.mstart_time_stamp = this.mstart_time_stamp;
            r0.mend_time_stamp = this.mend_time_stamp;
            r0.menable_gmt = this.menable_gmt;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TimeZoneProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1669newBuilder();
        }

        public TimeZoneProperty(TimeZoneType r12, FormatType r13, TimePrecisionType r14, TimeStyle r15, DatePrecisionType r16, DateStatusType r17, Long r18, Long r19, Boolean r20) {
            this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
        }

        public TimeZoneProperty(TimeZoneType r2, FormatType r3, TimePrecisionType r4, TimeStyle r5, DatePrecisionType r6, DateStatusType r7, Long r8, Long r9, Boolean r10, ByteString r11) {
            super(ADAPTER, r11);
            this.mtime_zone_type = r2;
            this.mformat_type = r3;
            this.mtime_precision_type = r4;
            this.mtime_style = r5;
            this.mdate_precision_type = r6;
            this.mdate_status_type = r7;
            this.mstart_time_stamp = r8;
            this.mend_time_stamp = r9;
            this.menable_gmt = r10;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AVATAR = null;
        public static final Type BUTTON = null;
        public static final Type CARD_CONTAINER = null;
        public static final Type CHATTERS_PREVIEW = null;
        public static final Type DOC_IMAGE = null;
        public static final Type DOC_STATE_BUTTON = null;
        public static final Type EMPTY = null;
        public static final Type ENGINE = null;
        public static final Type FLEX_LAYOUT = null;
        public static final Type HEADER = null;
        public static final Type ICON_BUTTON = null;
        public static final Type IMAGE = null;
        public static final Type IMAGE_CONTAINER = null;
        public static final Type LINEAR_LAYOUT = null;
        public static final Type LOADING = null;
        public static final Type OVERSIZED_TEXT = null;
        public static final Type RICHTEXT = null;
        public static final Type SPIN_BUTTON = null;
        public static final Type TAG_LIST = null;
        public static final Type TEXT = null;
        public static final Type TEXT_BUTTON = null;
        public static final Type TIME = null;
        public static final Type TIME_ZONE = null;
        public static final Type VIDEO = null;
        private final int value;

        static {
            Type r0 = new Type("EMPTY", 0, 0);
            EMPTY = r0;
            Type r1 = new Type("LINEAR_LAYOUT", 1, 1);
            LINEAR_LAYOUT = r1;
            Type r3 = new Type("FLEX_LAYOUT", 2, 2);
            FLEX_LAYOUT = r3;
            Type r5 = new Type("HEADER", 3, 501);
            HEADER = r5;
            Type r7 = new Type("RICHTEXT", 4, 502);
            RICHTEXT = r7;
            Type r8 = new Type("IMAGE", 5, 503);
            IMAGE = r8;
            Type r10 = new Type("CHATTERS_PREVIEW", 6, 504);
            CHATTERS_PREVIEW = r10;
            Type r12 = new Type("BUTTON", 7, 505);
            BUTTON = r12;
            Type r14 = new Type("ICON_BUTTON", 8, 506);
            ICON_BUTTON = r14;
            Type r13 = new Type("TEXT_BUTTON", 9, 507);
            TEXT_BUTTON = r13;
            Type r11 = new Type("TIME", 10, 508);
            TIME = r11;
            Type r9 = new Type("TEXT", 11, 509);
            TEXT = r9;
            Type r6 = new Type("TAG_LIST", 12, 510);
            TAG_LIST = r6;
            Type r4 = new Type("SPIN_BUTTON", 13, 511);
            SPIN_BUTTON = r4;
            Type r2 = new Type("AVATAR", 14, 512);
            AVATAR = r2;
            Type r15 = new Type("VIDEO", 15, 513);
            VIDEO = r15;
            Type r16 = new Type("CARD_CONTAINER", 16, 514);
            CARD_CONTAINER = r16;
            Type r17 = new Type("DOC_IMAGE", 17, 515);
            DOC_IMAGE = r17;
            Type r18 = new Type("LOADING", 18, 516);
            LOADING = r18;
            Type r19 = new Type("TIME_ZONE", 19, 517);
            TIME_ZONE = r19;
            Type r20 = new Type("OVERSIZED_TEXT", 20, 518);
            OVERSIZED_TEXT = r20;
            Type r21 = new Type("ENGINE", 21, 519);
            ENGINE = r21;
            Type r22 = new Type("DOC_STATE_BUTTON", 22, 520);
            DOC_STATE_BUTTON = r22;
            Type r23 = new Type("IMAGE_CONTAINER", 23, 521);
            IMAGE_CONTAINER = r23;
            $VALUES = new Type[]{r0, r1, r3, r5, r7, r8, r10, r12, r14, r13, r11, r9, r6, r4, r2, r15, r16, r17, r18, r19, r20, r21, r22, r23};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r1) {
            if (r1 == 0) goto L57;
            if (r1 == 1) goto L55;
            if (r1 == 2) goto L53;
            switch(r1) {
                case 501: goto L51;
                case 502: goto L49;
                case 503: goto L47;
                case 504: goto L45;
                case 505: goto L43;
                case 506: goto L41;
                case 507: goto L39;
                case 508: goto L37;
                case 509: goto L35;
                case 510: goto L33;
                case 511: goto L31;
                case 512: goto L29;
                case 513: goto L27;
                case 514: goto L25;
                case 515: goto L23;
                case 516: goto L21;
                case 517: goto L19;
                case 518: goto L17;
                case 519: goto L15;
                case 520: goto L13;
                case 521: goto L11;
                default: goto L8;
            };
        L8:
            return null;
        L11:
            return IMAGE_CONTAINER;
        L13:
            return DOC_STATE_BUTTON;
        L15:
            return ENGINE;
        L17:
            return OVERSIZED_TEXT;
        L19:
            return TIME_ZONE;
        L21:
            return LOADING;
        L23:
            return DOC_IMAGE;
        L25:
            return CARD_CONTAINER;
        L27:
            return VIDEO;
        L29:
            return AVATAR;
        L31:
            return SPIN_BUTTON;
        L33:
            return TAG_LIST;
        L35:
            return TEXT;
        L37:
            return TIME;
        L39:
            return TEXT_BUTTON;
        L41:
            return ICON_BUTTON;
        L43:
            return BUTTON;
        L45:
            return CHATTERS_PREVIEW;
        L47:
            return IMAGE;
        L49:
            return RICHTEXT;
        L51:
            return HEADER;
        L53:
            return FLEX_LAYOUT;
        L55:
            return LINEAR_LAYOUT;
        L57:
            return EMPTY;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Value extends com.squareup.wire.Message<Value, Builder> {
        public static final ProtoAdapter<Value> ADAPTER = null;
        public static final Float DEFAULT_VALUE = null;
        private static final long serialVersionUID = 0;
        public final ValueType mtype;
        public final Float mvalue;

        public static final class Builder extends com.squareup.wire.Message.Builder<Value, Builder> {
            public ValueType mtype;
            public Float mvalue;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Value m1673build() {
                return new Value(this.mtype, this.mvalue, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1673build();
            }

            public Builder type(ValueType r1) {
                this.mtype = r1;
                return this;
            }

            public Builder value(Float r1) {
                this.mvalue = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Value extends ProtoAdapter<Value> {
            public ProtoAdapter_Value() {
                super(FieldEncoding.LENGTH_DELIMITED, Value.class);
            }

            public Value decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mvalue = Float.valueOf(0.0f);
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtype = (ValueType) ValueType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mvalue = (Float) ProtoAdapter.FLOAT.decode(r9);
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m1673build();
            }

            public int encodedSize(Value r5) {
                ValueType r0 = r5.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ValueType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Float r3 = r5.mvalue;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1674decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Value) r1);
            }

            public void encode(ProtoWriter r4, Value r5) throws IOException {
                ValueType r0 = r5.mtype;
                if (r0 == null) goto L5;
                ValueType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Float r1 = r5.mvalue;
                if (r1 == null) goto L8;
                ProtoAdapter.FLOAT.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Value) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Value();
            DEFAULT_VALUE = Float.valueOf(0.0f);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1672newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mvalue = this.mvalue;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Value.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1672newBuilder();
        }

        public Value(ValueType r2, Float r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Value(ValueType r2, Float r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtype = r2;
            this.mvalue = r3;
        }
    }

    public static final enum ValueType extends Enum<ValueType> implements WireEnum {
        private static final /* synthetic */ ValueType[] $VALUES = null;
        public static final ProtoAdapter<ValueType> ADAPTER = null;
        public static final ValueType AUTO = null;
        public static final ValueType PERCENTAGE = null;
        public static final ValueType POINT = null;
        private final int value;

        static {
            ValueType r0 = new ValueType("AUTO", 0, 0);
            AUTO = r0;
            ValueType r1 = new ValueType("POINT", 1, 1);
            POINT = r1;
            ValueType r3 = new ValueType("PERCENTAGE", 2, 2);
            PERCENTAGE = r3;
            $VALUES = new ValueType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ValueType.class);
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ValueType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return PERCENTAGE;
        L12:
            return POINT;
        L14:
            return AUTO;
        }

        public static ValueType valueOf(String r1) {
            return (ValueType) a.a(ValueType.class, r1);
        }

        private ValueType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class VideoProperty extends com.squareup.wire.Message<VideoProperty, Builder> {
        public static final ProtoAdapter<VideoProperty> ADAPTER = null;
        public static final String DEFAULT_COVER_IMAGE_URL = "";
        public static final Long DEFAULT_DURATION = null;
        public static final String DEFAULT_IFRAME_URL = "";
        public static final String DEFAULT_SRC_URL = "";
        public static final String DEFAULT_VID = "";
        private static final long serialVersionUID = 0;
        public final ImageSetV2 mcover_image;
        public final String mcover_image_url;
        public final Long mduration;
        public final String miframe_url;
        public final Site msite;
        public final String msrc_url;
        public final String mvid;

        public static final class Builder extends com.squareup.wire.Message.Builder<VideoProperty, Builder> {
            public ImageSetV2 mcover_image;
            public String mcover_image_url;
            public Long mduration;
            public String miframe_url;
            public Site msite;
            public String msrc_url;
            public String mvid;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public VideoProperty m1676build() {
                return new VideoProperty(this.msite, this.mcover_image, this.mduration, this.msrc_url, this.mvid, this.miframe_url, this.mcover_image_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1676build();
            }

            public Builder cover_image(ImageSetV2 r1) {
                this.mcover_image = r1;
                return this;
            }

            public Builder cover_image_url(String r1) {
                this.mcover_image_url = r1;
                return this;
            }

            public Builder duration(Long r1) {
                this.mduration = r1;
                return this;
            }

            public Builder iframe_url(String r1) {
                this.miframe_url = r1;
                return this;
            }

            public Builder site(Site r1) {
                this.msite = r1;
                return this;
            }

            public Builder src_url(String r1) {
                this.msrc_url = r1;
                return this;
            }

            public Builder vid(String r1) {
                this.mvid = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_VideoProperty extends ProtoAdapter<VideoProperty> {
            public ProtoAdapter_VideoProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, VideoProperty.class);
            }

            public VideoProperty decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mduration = 0L;
                r0.msrc_url = "";
                r0.mvid = "";
                r0.miframe_url = "";
                r0.mcover_image_url = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L17;
                switch(r3) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r0.msite = (Site) Site.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mcover_image_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                r0.miframe_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L9:
                r0.mvid = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                r0.msrc_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L11:
                r0.mduration = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L12:
                r0.mcover_image = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L17:
                r9.endMessage(r1);
                return r0.m1676build();
            }

            public int encodedSize(VideoProperty r6) {
                Site r0 = r6.msite;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Site.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ImageSetV2 r3 = r6.mcover_image;
                if (r3 == null) goto L9;
                int r4 = ImageSetV2.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Long r7 = r6.mduration;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.msrc_url;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.mvid;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                String r16 = r6.miframe_url;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                String r19 = r6.mcover_image_url;
                if (r19 == null) goto L30;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
            L30:
                return (r18 + r1) + r6.unknownFields().size();
            L25:
                r17 = 0;
                goto L26
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ Object m1677decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((VideoProperty) r1);
            }

            public void encode(ProtoWriter r4, VideoProperty r5) throws IOException {
                Site r0 = r5.msite;
                if (r0 == null) goto L5;
                Site.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                ImageSetV2 r1 = r5.mcover_image;
                if (r1 == null) goto L8;
                ImageSetV2.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                Long r2 = r5.mduration;
                if (r2 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.msrc_url;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                String r6 = r5.mvid;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
            L17:
                String r7 = r5.miframe_url;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
            L20:
                String r8 = r5.mcover_image_url;
                if (r8 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
            L23:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (VideoProperty) r2);
            }
        }

        public static final enum Site extends Enum<Site> implements WireEnum {
            private static final /* synthetic */ Site[] $VALUES = null;
            public static final ProtoAdapter<Site> ADAPTER = null;
            public static final Site DOUYIN = null;
            public static final Site HUOSHAN = null;
            public static final Site UNKNOWN = null;
            public static final Site XIGUA = null;
            public static final Site YOUTUBE = null;
            private final int value;

            static {
                Site r0 = new Site("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Site r1 = new Site("XIGUA", 1, 1);
                XIGUA = r1;
                Site r3 = new Site("DOUYIN", 2, 2);
                DOUYIN = r3;
                Site r5 = new Site("HUOSHAN", 3, 3);
                HUOSHAN = r5;
                Site r7 = new Site("YOUTUBE", 4, 4);
                YOUTUBE = r7;
                $VALUES = new Site[]{r0, r1, r3, r5, r7};
                ADAPTER = ProtoAdapter.newEnumAdapter(Site.class);
            }

            public static Site[] values() {
                return (Site[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Site fromValue(int r1) {
                if (r1 == 0) goto L22;
                if (r1 == 1) goto L20;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L16;
                if (r1 == 4) goto L14;
                return null;
            L14:
                return YOUTUBE;
            L16:
                return HUOSHAN;
            L18:
                return DOUYIN;
            L20:
                return XIGUA;
            L22:
                return UNKNOWN;
            }

            public static Site valueOf(String r1) {
                return (Site) a.a(Site.class, r1);
            }

            private Site(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_VideoProperty();
            DEFAULT_DURATION = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1675newBuilder() {
            Builder r0 = new Builder();
            r0.msite = this.msite;
            r0.mcover_image = this.mcover_image;
            r0.mduration = this.mduration;
            r0.msrc_url = this.msrc_url;
            r0.mvid = this.mvid;
            r0.miframe_url = this.miframe_url;
            r0.mcover_image_url = this.mcover_image_url;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return VideoProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1675newBuilder();
        }

        public VideoProperty(Site r10, ImageSetV2 r11, Long r12, String r13, String r14, String r15, String r16) {
            this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
        }

        public VideoProperty(Site r2, ImageSetV2 r3, Long r4, String r5, String r6, String r7, String r8, ByteString r9) {
            super(ADAPTER, r9);
            this.msite = r2;
            this.mcover_image = r3;
            this.mduration = r4;
            this.msrc_url = r5;
            this.mvid = r6;
            this.miframe_url = r7;
            this.mcover_image_url = r8;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLPreviewComponent();
        Boolean r0 = Boolean.TRUE;
        DEFAULT_CAN_SKIP_WHEN_UNKNOWN = r0;
        DEFAULT_IS_FONT_ZOOMABLE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1576newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mcan_skip_when_unknown = this.mcan_skip_when_unknown;
        r0.mstyle = this.mstyle;
        r0.mchild_ids = Internal.copyOf("mchild_ids", this.mchild_ids);
        r0.mis_font_zoomable = this.mis_font_zoomable;
        r0.mempty = this.mempty;
        r0.mlinear_layout = this.mlinear_layout;
        r0.mflex_layout = this.mflex_layout;
        r0.mheader = this.mheader;
        r0.mrichtext = this.mrichtext;
        r0.mimage = this.mimage;
        r0.mchatters_preview = this.mchatters_preview;
        r0.mbutton = this.mbutton;
        r0.micon_button = this.micon_button;
        r0.mtext_button = this.mtext_button;
        r0.mtime = this.mtime;
        r0.mtext = this.mtext;
        r0.mtag_list = this.mtag_list;
        r0.mspin_button = this.mspin_button;
        r0.mavatar = this.mavatar;
        r0.mvideo = this.mvideo;
        r0.mcard_container = this.mcard_container;
        r0.mdoc_image = this.mdoc_image;
        r0.mloading = this.mloading;
        r0.mtime_zone = this.mtime_zone;
        r0.moversized_text = this.moversized_text;
        r0.mengine = this.mengine;
        r0.mdoc_state_button = this.mdoc_state_button;
        r0.mimage_container = this.mimage_container;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return URLPreviewComponent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1576newBuilder();
    }

    public URLPreviewComponent(Type r32, Boolean r33, Style r34, List<String> r35, Boolean r36, EmptyProperty r37, LinearLayoutProperty r38, FlexLayoutProperty r39, PreviewHeaderProperty r40, RichTextProperty r41, ImageProperty r42, ChattersPreviewProperty r43, ButtonProperty r44, IconButtonProperty r45, TextButtonProperty r46, TimeProperty r47, TextProperty r48, TagListProperty r49, SpinButtonProperty r50, AvatarProperty r51, VideoProperty r52, CardContainerProperty r53, DocImageProperty r54, LoadingProperty r55, TimeZoneProperty r56, OversizedTextProperty r57, EngineProperty r58, DocStateButtonProperty r59, ImageContainerProperty r60) {
        this(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, ByteString.EMPTY);
    }

    public URLPreviewComponent(Type r18, Boolean r19, Style r20, List<String> r21, Boolean r22, EmptyProperty r23, LinearLayoutProperty r24, FlexLayoutProperty r25, PreviewHeaderProperty r26, RichTextProperty r27, ImageProperty r28, ChattersPreviewProperty r29, ButtonProperty r30, IconButtonProperty r31, TextButtonProperty r32, TimeProperty r33, TextProperty r34, TagListProperty r35, SpinButtonProperty r36, AvatarProperty r37, VideoProperty r38, CardContainerProperty r39, DocImageProperty r40, LoadingProperty r41, TimeZoneProperty r42, OversizedTextProperty r43, EngineProperty r44, DocStateButtonProperty r45, ImageContainerProperty r46, ByteString r47) {
        super(ADAPTER, r47);
        if (Internal.countNonNull(r23, r24, r25, r26, new Object[]{r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46}) > 1) goto L7;
        this.mtype = r18;
        this.mcan_skip_when_unknown = r19;
        this.mstyle = r20;
        this.mchild_ids = Internal.immutableCopyOf("mchild_ids", r21);
        this.mis_font_zoomable = r22;
        this.mempty = r23;
        this.mlinear_layout = r24;
        this.mflex_layout = r25;
        this.mheader = r26;
        this.mrichtext = r27;
        this.mimage = r28;
        this.mchatters_preview = r29;
        this.mbutton = r30;
        this.micon_button = r31;
        this.mtext_button = r32;
        this.mtime = r33;
        this.mtext = r34;
        this.mtag_list = r35;
        this.mspin_button = r36;
        this.mavatar = r37;
        this.mvideo = r38;
        this.mcard_container = r39;
        this.mdoc_image = r40;
        this.mloading = r41;
        this.mtime_zone = r42;
        this.moversized_text = r43;
        this.mengine = r44;
        this.mdoc_state_button = r45;
        this.mimage_container = r46;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mempty, mlinear_layout, mflex_layout, mheader, mrichtext, mimage, mchatters_preview, mbutton, micon_button, mtext_button, mtime, mtext, mtag_list, mspin_button, mavatar, mvideo, mcard_container, mdoc_image, mloading, mtime_zone, moversized_text, mengine, mdoc_state_button, mimage_container may be non-null");
    }
}
