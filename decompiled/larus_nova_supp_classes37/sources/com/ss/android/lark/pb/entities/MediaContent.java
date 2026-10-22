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
public final class MediaContent extends com.squareup.wire.Message<MediaContent, Builder> {
    public static final ProtoAdapter<MediaContent> ADAPTER = null;
    public static final Integer DEFAULT_DURATION = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_ORIGINAL = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Long DEFAULT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ResourceCleanScene> mclean_resource_key_scene;
    public final List<String> mclean_resource_keys;
    public final Integer mduration;
    public final String mfs_unit;
    public final ImageSet mimage;
    public final Boolean mis_destroyed;
    public final Boolean mis_original;
    public final String mkey;
    public final String mmime;
    public final String mname;
    public final List<String> mrisk_object_keys;
    public final Long mscene_id;
    public final Long msize;
    public final Source msource;

    public static final class Builder extends com.squareup.wire.Message.Builder<MediaContent, Builder> {
        public Map<String, ResourceCleanScene> mclean_resource_key_scene;
        public List<String> mclean_resource_keys;
        public Integer mduration;
        public String mfs_unit;
        public ImageSet mimage;
        public Boolean mis_destroyed;
        public Boolean mis_original;
        public String mkey;
        public String mmime;
        public String mname;
        public List<String> mrisk_object_keys;
        public Long mscene_id;
        public Long msize;
        public Source msource;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MediaContent m1298build() {
            return new MediaContent(this.mkey, this.mname, this.msize, this.mmime, this.msource, this.mimage, this.mduration, this.mfs_unit, this.mis_original, this.mrisk_object_keys, this.mclean_resource_keys, this.mis_destroyed, this.mclean_resource_key_scene, this.mscene_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mrisk_object_keys = Internal.newMutableList();
            this.mclean_resource_keys = Internal.newMutableList();
            this.mclean_resource_key_scene = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1298build();
        }

        public Builder clean_resource_key_scene(Map<String, ResourceCleanScene> r1) {
            Internal.checkElementsNotNull(r1);
            this.mclean_resource_key_scene = r1;
            return this;
        }

        public Builder clean_resource_keys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mclean_resource_keys = r1;
            return this;
        }

        public Builder duration(Integer r1) {
            this.mduration = r1;
            return this;
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder image(ImageSet r1) {
            this.mimage = r1;
            return this;
        }

        public Builder is_destroyed(Boolean r1) {
            this.mis_destroyed = r1;
            return this;
        }

        public Builder is_original(Boolean r1) {
            this.mis_original = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder mime(String r1) {
            this.mmime = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder risk_object_keys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mrisk_object_keys = r1;
            return this;
        }

        public Builder scene_id(Long r1) {
            this.mscene_id = r1;
            return this;
        }

        public Builder size(Long r1) {
            this.msize = r1;
            return this;
        }

        public Builder source(Source r1) {
            this.msource = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MediaContent extends ProtoAdapter<MediaContent> {
        private final ProtoAdapter<Map<String, ResourceCleanScene>> mclean_resource_key_scene;

        public ProtoAdapter_MediaContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MediaContent.class);
            this.mclean_resource_key_scene = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ResourceCleanScene.ADAPTER);
        }

        public MediaContent decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mname = "";
            r0.msize = 0L;
            r0.mmime = "";
            r0.mduration = 0;
            r0.mfs_unit = "";
            Boolean r1 = Boolean.FALSE;
            r0.mis_original = r1;
            r0.mis_destroyed = r1;
            r0.mscene_id = 0L;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            switch(r3) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L26;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L26:
            r0.msource = (Source) Source.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mscene_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            r0.mclean_resource_key_scene.putAll((Map) this.mclean_resource_key_scene.decode(r9));
            goto L3
        L9:
            r0.mis_destroyed = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            r0.mclean_resource_keys.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L11:
            r0.mrisk_object_keys.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L12:
            r0.mis_original = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mduration = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L15:
            r0.mimage = (ImageSet) ImageSet.ADAPTER.decode(r9);
            goto L3
        L20:
            r0.mmime = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.msize = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L22:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L23:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r2);
            return r0.m1298build();
        }

        public int encodedSize(MediaContent r7) {
            String r0 = r7.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r7.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r6 = r7.msize;
            if (r6 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r6);
        L14:
            int r9 = r5 + r8;
            String r10 = r7.mmime;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Source r13 = r7.msource;
            if (r13 == null) goto L21;
            int r14 = Source.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            ImageSet r16 = r7.mimage;
            if (r16 == null) goto L25;
            int r17 = ImageSet.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Integer r19 = r7.mduration;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.INT32.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r7.mfs_unit;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            Boolean r25 = r7.mis_original;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            ProtoAdapter r28 = ProtoAdapter.STRING;
            int r29 = (r27 + r28.asRepeated().encodedSizeWithTag(10, r7.mrisk_object_keys)) + r28.asRepeated().encodedSizeWithTag(11, r7.mclean_resource_keys);
            Boolean r30 = r7.mis_destroyed;
            if (r30 == null) goto L41;
            int r31 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r30);
        L42:
            int r32 = (r29 + r31) + this.mclean_resource_key_scene.encodedSizeWithTag(13, r7.mclean_resource_key_scene);
            Long r33 = r7.mscene_id;
            if (r33 == null) goto L46;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(14, r33);
        L46:
            return (r32 + r1) + r7.unknownFields().size();
        L41:
            r31 = 0;
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
        public /* bridge */ /* synthetic */ Object m1299decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MediaContent) r1);
        }

        public void encode(ProtoWriter r5, MediaContent r6) throws IOException {
            String r0 = r6.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
        L5:
            String r1 = r6.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r1);
        L8:
            Long r2 = r6.msize;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r5, 3, r2);
        L11:
            String r3 = r6.mmime;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r5, 4, r3);
        L14:
            Source r4 = r6.msource;
            if (r4 == null) goto L17;
            Source.ADAPTER.encodeWithTag(r5, 5, r4);
        L17:
            ImageSet r7 = r6.mimage;
            if (r7 == null) goto L20;
            ImageSet.ADAPTER.encodeWithTag(r5, 6, r7);
        L20:
            Integer r8 = r6.mduration;
            if (r8 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r5, 7, r8);
        L23:
            String r9 = r6.mfs_unit;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r5, 8, r9);
        L26:
            Boolean r10 = r6.mis_original;
            if (r10 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r10);
        L29:
            ProtoAdapter r11 = ProtoAdapter.STRING;
            r11.asRepeated().encodeWithTag(r5, 10, r6.mrisk_object_keys);
            r11.asRepeated().encodeWithTag(r5, 11, r6.mclean_resource_keys);
            Boolean r12 = r6.mis_destroyed;
            if (r12 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r5, 12, r12);
        L32:
            this.mclean_resource_key_scene.encodeWithTag(r5, 13, r6.mclean_resource_key_scene);
            Long r13 = r6.mscene_id;
            if (r13 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r5, 14, r13);
        L35:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MediaContent) r2);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source LARK = null;
        public static final Source UNKNOWN = null;
        private final int value;

        static {
            Source r0 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Source r1 = new Source("LARK", 1, 1);
            LARK = r1;
            $VALUES = new Source[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return LARK;
        L10:
            return UNKNOWN;
        }

        public static Source valueOf(String r1) {
            return (Source) a.a(Source.class, r1);
        }

        private Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MediaContent();
        DEFAULT_SIZE = 0L;
        DEFAULT_DURATION = 0;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_IS_ORIGINAL = r1;
        DEFAULT_IS_DESTROYED = r1;
        DEFAULT_SCENE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1297newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mname = this.mname;
        r0.msize = this.msize;
        r0.mmime = this.mmime;
        r0.msource = this.msource;
        r0.mimage = this.mimage;
        r0.mduration = this.mduration;
        r0.mfs_unit = this.mfs_unit;
        r0.mis_original = this.mis_original;
        r0.mrisk_object_keys = Internal.copyOf("mrisk_object_keys", this.mrisk_object_keys);
        r0.mclean_resource_keys = Internal.copyOf("mclean_resource_keys", this.mclean_resource_keys);
        r0.mis_destroyed = this.mis_destroyed;
        r0.mclean_resource_key_scene = Internal.copyOf("mclean_resource_key_scene", this.mclean_resource_key_scene);
        r0.mscene_id = this.mscene_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MediaContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1297newBuilder();
    }

    public MediaContent(String r17, String r18, Long r19, String r20, Source r21, ImageSet r22, Integer r23, String r24, Boolean r25, List<String> r26, List<String> r27, Boolean r28, Map<String, ResourceCleanScene> r29, Long r30) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, ByteString.EMPTY);
    }

    public MediaContent(String r4, String r5, Long r6, String r7, Source r8, ImageSet r9, Integer r10, String r11, Boolean r12, List<String> r13, List<String> r14, Boolean r15, Map<String, ResourceCleanScene> r16, Long r17, ByteString r18) {
        super(ADAPTER, r18);
        this.mkey = r4;
        this.mname = r5;
        this.msize = r6;
        this.mmime = r7;
        this.msource = r8;
        this.mimage = r9;
        this.mduration = r10;
        this.mfs_unit = r11;
        this.mis_original = r12;
        this.mrisk_object_keys = Internal.immutableCopyOf("mrisk_object_keys", r13);
        this.mclean_resource_keys = Internal.immutableCopyOf("mclean_resource_keys", r14);
        this.mis_destroyed = r15;
        this.mclean_resource_key_scene = Internal.immutableCopyOf("mclean_resource_key_scene", r16);
        this.mscene_id = r17;
    }
}
