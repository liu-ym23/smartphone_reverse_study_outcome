package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ImageSetV2;
import com.ss.android.lark.pb.entities.MediaContent;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ResourceMeta extends Message<ResourceMeta, Builder> {
    public static final ProtoAdapter<ResourceMeta> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_RESOURCE_ACCESS_AUTH = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Long DEFAULT_SCENE_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_resource_access_auth;
    public final String mid;
    public final ImageSetV2 mimage;
    public final Boolean mis_destroyed;
    public final MediaContent mmedia_content;
    public final MessageRelatedInfo mmessage_related_info;
    public final ResourceType mresourceType;
    public final Long mscene_id;

    public static final class Builder extends Message.Builder<ResourceMeta, Builder> {
        public Boolean mhas_resource_access_auth;
        public String mid;
        public ImageSetV2 mimage;
        public Boolean mis_destroyed;
        public MediaContent mmedia_content;
        public MessageRelatedInfo mmessage_related_info;
        public ResourceType mresourceType;
        public Long mscene_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ResourceMeta m2798build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new ResourceMeta(this.mid, this.mresourceType, this.mmessage_related_info, this.mmedia_content, this.mimage, this.mhas_resource_access_auth, this.mis_destroyed, this.mscene_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2798build();
        }

        public Builder has_resource_access_auth(Boolean r1) {
            this.mhas_resource_access_auth = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder image(ImageSetV2 r1) {
            this.mimage = r1;
            return this;
        }

        public Builder is_destroyed(Boolean r1) {
            this.mis_destroyed = r1;
            return this;
        }

        public Builder media_content(MediaContent r1) {
            this.mmedia_content = r1;
            return this;
        }

        public Builder message_related_info(MessageRelatedInfo r1) {
            this.mmessage_related_info = r1;
            return this;
        }

        public Builder resourceType(ResourceType r1) {
            this.mresourceType = r1;
            return this;
        }

        public Builder scene_id(Long r1) {
            this.mscene_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ResourceMeta extends ProtoAdapter<ResourceMeta> {
        public ProtoAdapter_ResourceMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ResourceMeta.class);
        }

        public ResourceMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            Boolean r1 = Boolean.FALSE;
            r0.mhas_resource_access_auth = r1;
            r0.mis_destroyed = r1;
            r0.mscene_id = 0L;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L20;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r0.mresourceType = (ResourceType) ResourceType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mscene_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            r0.mis_destroyed = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            r0.mhas_resource_access_auth = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            r0.mimage = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
            goto L3
        L11:
            r0.mmedia_content = (MediaContent) MediaContent.ADAPTER.decode(r9);
            goto L3
        L12:
            r0.mmessage_related_info = (MessageRelatedInfo) MessageRelatedInfo.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r2);
            return r0.m2798build();
        }

        public int encodedSize(ResourceMeta r6) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r6.mid);
            ResourceType r1 = r6.mresourceType;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ResourceType.ADAPTER.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            MessageRelatedInfo r5 = r6.mmessage_related_info;
            if (r5 == null) goto L9;
            int r7 = MessageRelatedInfo.ADAPTER.encodedSizeWithTag(3, r5);
        L10:
            int r8 = r4 + r7;
            MediaContent r9 = r6.mmedia_content;
            if (r9 == null) goto L13;
            int r10 = MediaContent.ADAPTER.encodedSizeWithTag(4, r9);
        L14:
            int r11 = r8 + r10;
            ImageSetV2 r12 = r6.mimage;
            if (r12 == null) goto L17;
            int r13 = ImageSetV2.ADAPTER.encodedSizeWithTag(5, r12);
        L18:
            int r14 = r11 + r13;
            Boolean r15 = r6.mhas_resource_access_auth;
            if (r15 == null) goto L21;
            int r16 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r15);
        L22:
            int r17 = r14 + r16;
            Boolean r18 = r6.mis_destroyed;
            if (r18 == null) goto L25;
            int r19 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r18);
        L26:
            int r20 = r17 + r19;
            Long r21 = r6.mscene_id;
            if (r21 == null) goto L30;
            r2 = ProtoAdapter.INT64.encodedSizeWithTag(8, r21);
        L30:
            return (r20 + r2) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2799decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ResourceMeta) r1);
        }

        public void encode(ProtoWriter r4, ResourceMeta r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mid);
            ResourceType r0 = r5.mresourceType;
            if (r0 == null) goto L5;
            ResourceType.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            MessageRelatedInfo r1 = r5.mmessage_related_info;
            if (r1 == null) goto L8;
            MessageRelatedInfo.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            MediaContent r2 = r5.mmedia_content;
            if (r2 == null) goto L11;
            MediaContent.ADAPTER.encodeWithTag(r4, 4, r2);
        L11:
            ImageSetV2 r3 = r5.mimage;
            if (r3 == null) goto L14;
            ImageSetV2.ADAPTER.encodeWithTag(r4, 5, r3);
        L14:
            Boolean r6 = r5.mhas_resource_access_auth;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r6);
        L17:
            Boolean r7 = r5.mis_destroyed;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r7);
        L20:
            Long r8 = r5.mscene_id;
            if (r8 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r4, 8, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ResourceMeta) r2);
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> implements WireEnum {
        private static final /* synthetic */ ResourceType[] $VALUES = null;
        public static final ProtoAdapter<ResourceType> ADAPTER = null;
        public static final ResourceType IMAGE = null;
        public static final ResourceType UNKNOWN = null;
        public static final ResourceType VIDEO = null;
        private final int value;

        static {
            ResourceType r0 = new ResourceType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ResourceType r1 = new ResourceType("IMAGE", 1, 1);
            IMAGE = r1;
            ResourceType r3 = new ResourceType("VIDEO", 2, 2);
            VIDEO = r3;
            $VALUES = new ResourceType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ResourceType.class);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ResourceType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return VIDEO;
        L12:
            return IMAGE;
        L14:
            return UNKNOWN;
        }

        public static ResourceType valueOf(String r1) {
            return (ResourceType) a.a(ResourceType.class, r1);
        }

        private ResourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResourceMeta();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_HAS_RESOURCE_ACCESS_AUTH = r0;
        DEFAULT_IS_DESTROYED = r0;
        DEFAULT_SCENE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2797newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mresourceType = this.mresourceType;
        r0.mmessage_related_info = this.mmessage_related_info;
        r0.mmedia_content = this.mmedia_content;
        r0.mimage = this.mimage;
        r0.mhas_resource_access_auth = this.mhas_resource_access_auth;
        r0.mis_destroyed = this.mis_destroyed;
        r0.mscene_id = this.mscene_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ResourceMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2797newBuilder();
    }

    public ResourceMeta(String r11, ResourceType r12, MessageRelatedInfo r13, MediaContent r14, ImageSetV2 r15, Boolean r16, Boolean r17, Long r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public ResourceMeta(String r2, ResourceType r3, MessageRelatedInfo r4, MediaContent r5, ImageSetV2 r6, Boolean r7, Boolean r8, Long r9, ByteString r10) {
        super(ADAPTER, r10);
        this.mid = r2;
        this.mresourceType = r3;
        this.mmessage_related_info = r4;
        this.mmedia_content = r5;
        this.mimage = r6;
        this.mhas_resource_access_auth = r7;
        this.mis_destroyed = r8;
        this.mscene_id = r9;
    }
}
