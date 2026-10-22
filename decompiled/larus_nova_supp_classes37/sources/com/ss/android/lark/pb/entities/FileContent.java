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
public final class FileContent extends com.squareup.wire.Message<FileContent, Builder> {
    public static final ProtoAdapter<FileContent> ADAPTER = null;
    public static final String DEFAULT_COMPRESSED_FOLDER = "";
    public static final String DEFAULT_FS_UNIT = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_FOLDER = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_LAST_UPDATE_TIME_MS = null;
    public static final Long DEFAULT_LAST_UPDATE_USER_ID = null;
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_SPACE = "";
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Long DEFAULT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ResourceCleanScene> mclean_resource_key_scene;
    public final List<String> mclean_resource_keys;
    public final String mcompressed_folder;
    public final FileAbility mfile_ability;
    public final FilePermission mfile_permission;
    public final FilePreviewStage mfile_preview_stage;
    public final String mfs_unit;
    public final Boolean mis_destroyed;
    public final Boolean mis_folder;
    public final String mkey;
    public final LANTransExtra mlan_trans_extra;
    public final Long mlast_update_time_ms;
    public final Long mlast_update_user_id;
    public final String mmime;
    public final String mname;
    public final String mname_space;
    public final List<String> mrisk_object_keys;
    public final Long mscene_id;
    public final Long msize;
    public final Source msource;
    public final TransExtra mtrans_extra;

    public static final class Builder extends com.squareup.wire.Message.Builder<FileContent, Builder> {
        public Map<String, ResourceCleanScene> mclean_resource_key_scene;
        public List<String> mclean_resource_keys;
        public String mcompressed_folder;
        public FileAbility mfile_ability;
        public FilePermission mfile_permission;
        public FilePreviewStage mfile_preview_stage;
        public String mfs_unit;
        public Boolean mis_destroyed;
        public Boolean mis_folder;
        public String mkey;
        public LANTransExtra mlan_trans_extra;
        public Long mlast_update_time_ms;
        public Long mlast_update_user_id;
        public String mmime;
        public String mname;
        public String mname_space;
        public List<String> mrisk_object_keys;
        public Long mscene_id;
        public Long msize;
        public Source msource;
        public TransExtra mtrans_extra;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FileContent m1217build() {
            return new FileContent(this.mkey, this.mname, this.msize, this.mmime, this.msource, this.mname_space, this.mfs_unit, this.mlan_trans_extra, this.mtrans_extra, this.mrisk_object_keys, this.mfile_ability, this.mfile_permission, this.mlast_update_user_id, this.mlast_update_time_ms, this.mcompressed_folder, this.mfile_preview_stage, this.mclean_resource_keys, this.mis_destroyed, this.mclean_resource_key_scene, this.mscene_id, this.mis_folder, super.buildUnknownFields());
        }

        public Builder() {
            this.mrisk_object_keys = Internal.newMutableList();
            this.mclean_resource_keys = Internal.newMutableList();
            this.mclean_resource_key_scene = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1217build();
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

        public Builder compressed_folder(String r1) {
            this.mcompressed_folder = r1;
            return this;
        }

        public Builder file_ability(FileAbility r1) {
            this.mfile_ability = r1;
            return this;
        }

        public Builder file_permission(FilePermission r1) {
            this.mfile_permission = r1;
            return this;
        }

        public Builder file_preview_stage(FilePreviewStage r1) {
            this.mfile_preview_stage = r1;
            return this;
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder is_destroyed(Boolean r1) {
            this.mis_destroyed = r1;
            return this;
        }

        public Builder is_folder(Boolean r1) {
            this.mis_folder = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder lan_trans_extra(LANTransExtra r1) {
            this.mlan_trans_extra = r1;
            return this;
        }

        public Builder last_update_time_ms(Long r1) {
            this.mlast_update_time_ms = r1;
            return this;
        }

        public Builder last_update_user_id(Long r1) {
            this.mlast_update_user_id = r1;
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

        public Builder name_space(String r1) {
            this.mname_space = r1;
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

        public Builder trans_extra(TransExtra r1) {
            this.mtrans_extra = r1;
            return this;
        }
    }

    public static final enum FileAbility extends Enum<FileAbility> implements WireEnum {
        private static final /* synthetic */ FileAbility[] $VALUES = null;
        public static final ProtoAdapter<FileAbility> ADAPTER = null;
        public static final FileAbility NOT_SUPPORT_PREVIEW = null;
        public static final FileAbility SUPPORT_EDIT = null;
        public static final FileAbility SUPPORT_PREVIEW = null;
        public static final FileAbility UNKNOWN_SUPPORT_STATE = null;
        private final int value;

        static {
            FileAbility r0 = new FileAbility("UNKNOWN_SUPPORT_STATE", 0, 0);
            UNKNOWN_SUPPORT_STATE = r0;
            FileAbility r1 = new FileAbility("SUPPORT_EDIT", 1, 1);
            SUPPORT_EDIT = r1;
            FileAbility r3 = new FileAbility("SUPPORT_PREVIEW", 2, 2);
            SUPPORT_PREVIEW = r3;
            FileAbility r5 = new FileAbility("NOT_SUPPORT_PREVIEW", 3, 3);
            NOT_SUPPORT_PREVIEW = r5;
            $VALUES = new FileAbility[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileAbility.class);
        }

        public static FileAbility[] values() {
            return (FileAbility[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FileAbility fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return NOT_SUPPORT_PREVIEW;
        L14:
            return SUPPORT_PREVIEW;
        L16:
            return SUPPORT_EDIT;
        L18:
            return UNKNOWN_SUPPORT_STATE;
        }

        public static FileAbility valueOf(String r1) {
            return (FileAbility) a.a(FileAbility.class, r1);
        }

        private FileAbility(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum FilePermission extends Enum<FilePermission> implements WireEnum {
        private static final /* synthetic */ FilePermission[] $VALUES = null;
        public static final ProtoAdapter<FilePermission> ADAPTER = null;
        public static final FilePermission CAN_EDIT = null;
        public static final FilePermission CAN_PREVIEW = null;
        public static final FilePermission UNKNOWN_CAN_STATE = null;
        private final int value;

        static {
            FilePermission r0 = new FilePermission("UNKNOWN_CAN_STATE", 0, 0);
            UNKNOWN_CAN_STATE = r0;
            FilePermission r1 = new FilePermission("CAN_EDIT", 1, 1);
            CAN_EDIT = r1;
            FilePermission r3 = new FilePermission("CAN_PREVIEW", 2, 2);
            CAN_PREVIEW = r3;
            $VALUES = new FilePermission[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(FilePermission.class);
        }

        public static FilePermission[] values() {
            return (FilePermission[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FilePermission fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return CAN_PREVIEW;
        L12:
            return CAN_EDIT;
        L14:
            return UNKNOWN_CAN_STATE;
        }

        public static FilePermission valueOf(String r1) {
            return (FilePermission) a.a(FilePermission.class, r1);
        }

        private FilePermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class LANTransExtra extends com.squareup.wire.Message<LANTransExtra, Builder> {
        public static final ProtoAdapter<LANTransExtra> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final TransStatus mstatus;

        public static final class Builder extends com.squareup.wire.Message.Builder<LANTransExtra, Builder> {
            public TransStatus mstatus;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public LANTransExtra m1219build() {
                return new LANTransExtra(this.mstatus, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1219build();
            }

            public Builder status(TransStatus r1) {
                this.mstatus = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_LANTransExtra extends ProtoAdapter<LANTransExtra> {
            public ProtoAdapter_LANTransExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, LANTransExtra.class);
            }

            public LANTransExtra decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mstatus = (TransStatus) TransStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                return r0.m1219build();
            }

            public int encodedSize(LANTransExtra r4) {
                TransStatus r0 = r4.mstatus;
                if (r0 == null) goto L5;
                int r1 = TransStatus.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1220decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((LANTransExtra) r1);
            }

            public void encode(ProtoWriter r4, LANTransExtra r5) throws IOException {
                TransStatus r0 = r5.mstatus;
                if (r0 == null) goto L5;
                TransStatus.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (LANTransExtra) r2);
            }
        }

        public static final enum TransStatus extends Enum<TransStatus> implements WireEnum {
            private static final /* synthetic */ TransStatus[] $VALUES = null;
            public static final TransStatus ABORT_BY_RECEIVER = null;
            public static final TransStatus ABORT_BY_SENDER = null;
            public static final TransStatus ACCEPT = null;
            public static final ProtoAdapter<TransStatus> ADAPTER = null;
            public static final TransStatus CANCEL = null;
            public static final TransStatus DONE = null;
            public static final TransStatus OFFLINE_MODE = null;
            public static final TransStatus PENDING = null;
            public static final TransStatus REFUSE = null;
            private final int value;

            static {
                TransStatus r0 = new TransStatus("PENDING", 0, 0);
                PENDING = r0;
                TransStatus r1 = new TransStatus("ACCEPT", 1, 1);
                ACCEPT = r1;
                TransStatus r3 = new TransStatus("REFUSE", 2, 2);
                REFUSE = r3;
                TransStatus r5 = new TransStatus("CANCEL", 3, 3);
                CANCEL = r5;
                TransStatus r7 = new TransStatus("ABORT_BY_SENDER", 4, 4);
                ABORT_BY_SENDER = r7;
                TransStatus r9 = new TransStatus("ABORT_BY_RECEIVER", 5, 5);
                ABORT_BY_RECEIVER = r9;
                TransStatus r11 = new TransStatus("DONE", 6, 6);
                DONE = r11;
                TransStatus r13 = new TransStatus("OFFLINE_MODE", 7, 7);
                OFFLINE_MODE = r13;
                $VALUES = new TransStatus[]{r0, r1, r3, r5, r7, r9, r11, r13};
                ADAPTER = ProtoAdapter.newEnumAdapter(TransStatus.class);
            }

            public static TransStatus[] values() {
                return (TransStatus[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TransStatus fromValue(int r0) {
                switch(r0) {
                    case 0: goto L20;
                    case 1: goto L18;
                    case 2: goto L16;
                    case 3: goto L14;
                    case 4: goto L12;
                    case 5: goto L10;
                    case 6: goto L8;
                    case 7: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return OFFLINE_MODE;
            L8:
                return DONE;
            L10:
                return ABORT_BY_RECEIVER;
            L12:
                return ABORT_BY_SENDER;
            L14:
                return CANCEL;
            L16:
                return REFUSE;
            L18:
                return ACCEPT;
            L20:
                return PENDING;
            }

            public static TransStatus valueOf(String r1) {
                return (TransStatus) a.a(TransStatus.class, r1);
            }

            private TransStatus(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LANTransExtra();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1218newBuilder() {
            Builder r0 = new Builder();
            r0.mstatus = this.mstatus;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return LANTransExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1218newBuilder();
        }

        public LANTransExtra(TransStatus r2) {
            this(r2, ByteString.EMPTY);
        }

        public LANTransExtra(TransStatus r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mstatus = r2;
        }
    }

    public static final class ProtoAdapter_FileContent extends ProtoAdapter<FileContent> {
        private final ProtoAdapter<Map<String, ResourceCleanScene>> mclean_resource_key_scene;

        public ProtoAdapter_FileContent() {
            super(FieldEncoding.LENGTH_DELIMITED, FileContent.class);
            this.mclean_resource_key_scene = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ResourceCleanScene.ADAPTER);
        }

        public FileContent decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mname = "";
            r0.msize = 0L;
            r0.mmime = "";
            r0.mname_space = "";
            r0.mfs_unit = "";
            r0.mlast_update_user_id = 0L;
            r0.mlast_update_time_ms = 0L;
            r0.mcompressed_folder = "";
            Boolean r1 = Boolean.FALSE;
            r0.mis_destroyed = r1;
            r0.mscene_id = 0L;
            r0.mis_folder = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L40;
            switch(r3) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L37;
                case 4: goto L36;
                case 5: goto L42;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L46;
                case 12: goto L48;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L44;
                case 17: goto L11;
                case 18: goto L10;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L42:
            r0.msource = (Source) Source.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r0.mfile_preview_stage = (FilePreviewStage) FilePreviewStage.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L46:
            r0.mfile_ability = (FileAbility) FileAbility.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L48:
            r0.mfile_permission = (FilePermission) FilePermission.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mis_folder = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.mscene_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L9:
            r0.mclean_resource_key_scene.putAll((Map) this.mclean_resource_key_scene.decode(r9));
            goto L3
        L10:
            r0.mis_destroyed = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            r0.mclean_resource_keys.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L16:
            r0.mcompressed_folder = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mlast_update_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L18:
            r0.mlast_update_user_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L27:
            r0.mrisk_object_keys.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L28:
            r0.mtrans_extra = (TransExtra) TransExtra.ADAPTER.decode(r9);
            goto L3
        L29:
            r0.mlan_trans_extra = (LANTransExtra) LANTransExtra.ADAPTER.decode(r9);
            goto L3
        L30:
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L31:
            r0.mname_space = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L36:
            r0.mmime = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L37:
            r0.msize = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L38:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L39:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L40:
            r9.endMessage(r2);
            return r0.m1217build();
        }

        public int encodedSize(FileContent r7) {
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
            String r16 = r7.mname_space;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r7.mfs_unit;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            LANTransExtra r22 = r7.mlan_trans_extra;
            if (r22 == null) goto L33;
            int r23 = LANTransExtra.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            TransExtra r25 = r7.mtrans_extra;
            if (r25 == null) goto L37;
            int r26 = TransExtra.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            ProtoAdapter r28 = ProtoAdapter.STRING;
            int r29 = r27 + r28.asRepeated().encodedSizeWithTag(10, r7.mrisk_object_keys);
            FileAbility r30 = r7.mfile_ability;
            if (r30 == null) goto L41;
            int r31 = FileAbility.ADAPTER.encodedSizeWithTag(11, r30);
        L42:
            int r32 = r29 + r31;
            FilePermission r33 = r7.mfile_permission;
            if (r33 == null) goto L45;
            int r34 = FilePermission.ADAPTER.encodedSizeWithTag(12, r33);
        L46:
            int r35 = r32 + r34;
            Long r36 = r7.mlast_update_user_id;
            if (r36 == null) goto L49;
            int r37 = ProtoAdapter.INT64.encodedSizeWithTag(13, r36);
        L50:
            int r38 = r35 + r37;
            Long r39 = r7.mlast_update_time_ms;
            if (r39 == null) goto L53;
            int r40 = ProtoAdapter.INT64.encodedSizeWithTag(14, r39);
        L54:
            int r41 = r38 + r40;
            String r42 = r7.mcompressed_folder;
            if (r42 == null) goto L57;
            int r43 = r28.encodedSizeWithTag(15, r42);
        L58:
            int r44 = r41 + r43;
            FilePreviewStage r45 = r7.mfile_preview_stage;
            if (r45 == null) goto L61;
            int r46 = FilePreviewStage.ADAPTER.encodedSizeWithTag(16, r45);
        L62:
            int r47 = (r44 + r46) + r28.asRepeated().encodedSizeWithTag(17, r7.mclean_resource_keys);
            Boolean r48 = r7.mis_destroyed;
            if (r48 == null) goto L65;
            int r49 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r48);
        L66:
            int r50 = (r47 + r49) + this.mclean_resource_key_scene.encodedSizeWithTag(19, r7.mclean_resource_key_scene);
            Long r51 = r7.mscene_id;
            if (r51 == null) goto L69;
            int r52 = ProtoAdapter.INT64.encodedSizeWithTag(20, r51);
        L70:
            int r53 = r50 + r52;
            Boolean r54 = r7.mis_folder;
            if (r54 == null) goto L74;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r54);
        L74:
            return (r53 + r1) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1221decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FileContent) r1);
        }

        public void encode(ProtoWriter r5, FileContent r6) throws IOException {
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
            String r7 = r6.mname_space;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r5, 6, r7);
        L20:
            String r8 = r6.mfs_unit;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r5, 7, r8);
        L23:
            LANTransExtra r9 = r6.mlan_trans_extra;
            if (r9 == null) goto L26;
            LANTransExtra.ADAPTER.encodeWithTag(r5, 8, r9);
        L26:
            TransExtra r10 = r6.mtrans_extra;
            if (r10 == null) goto L29;
            TransExtra.ADAPTER.encodeWithTag(r5, 9, r10);
        L29:
            ProtoAdapter r11 = ProtoAdapter.STRING;
            r11.asRepeated().encodeWithTag(r5, 10, r6.mrisk_object_keys);
            FileAbility r12 = r6.mfile_ability;
            if (r12 == null) goto L32;
            FileAbility.ADAPTER.encodeWithTag(r5, 11, r12);
        L32:
            FilePermission r13 = r6.mfile_permission;
            if (r13 == null) goto L35;
            FilePermission.ADAPTER.encodeWithTag(r5, 12, r13);
        L35:
            Long r14 = r6.mlast_update_user_id;
            if (r14 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r5, 13, r14);
        L38:
            Long r15 = r6.mlast_update_time_ms;
            if (r15 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r5, 14, r15);
        L41:
            String r16 = r6.mcompressed_folder;
            if (r16 == null) goto L44;
            r11.encodeWithTag(r5, 15, r16);
        L44:
            FilePreviewStage r17 = r6.mfile_preview_stage;
            if (r17 == null) goto L47;
            FilePreviewStage.ADAPTER.encodeWithTag(r5, 16, r17);
        L47:
            r11.asRepeated().encodeWithTag(r5, 17, r6.mclean_resource_keys);
            Boolean r18 = r6.mis_destroyed;
            if (r18 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r5, 18, r18);
        L50:
            this.mclean_resource_key_scene.encodeWithTag(r5, 19, r6.mclean_resource_key_scene);
            Long r19 = r6.mscene_id;
            if (r19 == null) goto L53;
            ProtoAdapter.INT64.encodeWithTag(r5, 20, r19);
        L53:
            Boolean r20 = r6.mis_folder;
            if (r20 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r5, 21, r20);
        L56:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FileContent) r2);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source LAN_TRANS = null;
        public static final Source NUT_STORE = null;
        public static final Source UNKNOWN = null;
        private final int value;

        static {
            Source r0 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Source r1 = new Source("NUT_STORE", 1, 2);
            NUT_STORE = r1;
            Source r3 = new Source("LAN_TRANS", 2, 3);
            LAN_TRANS = r3;
            $VALUES = new Source[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L10;
            return null;
        L10:
            return LAN_TRANS;
        L12:
            return NUT_STORE;
        L14:
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
        ADAPTER = new ProtoAdapter_FileContent();
        DEFAULT_SIZE = 0L;
        DEFAULT_LAST_UPDATE_USER_ID = 0L;
        DEFAULT_LAST_UPDATE_TIME_MS = 0L;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_IS_DESTROYED = r1;
        DEFAULT_SCENE_ID = 0L;
        DEFAULT_IS_FOLDER = r1;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1216newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mname = this.mname;
        r0.msize = this.msize;
        r0.mmime = this.mmime;
        r0.msource = this.msource;
        r0.mname_space = this.mname_space;
        r0.mfs_unit = this.mfs_unit;
        r0.mlan_trans_extra = this.mlan_trans_extra;
        r0.mtrans_extra = this.mtrans_extra;
        r0.mrisk_object_keys = Internal.copyOf("mrisk_object_keys", this.mrisk_object_keys);
        r0.mfile_ability = this.mfile_ability;
        r0.mfile_permission = this.mfile_permission;
        r0.mlast_update_user_id = this.mlast_update_user_id;
        r0.mlast_update_time_ms = this.mlast_update_time_ms;
        r0.mcompressed_folder = this.mcompressed_folder;
        r0.mfile_preview_stage = this.mfile_preview_stage;
        r0.mclean_resource_keys = Internal.copyOf("mclean_resource_keys", this.mclean_resource_keys);
        r0.mis_destroyed = this.mis_destroyed;
        r0.mclean_resource_key_scene = Internal.copyOf("mclean_resource_key_scene", this.mclean_resource_key_scene);
        r0.mscene_id = this.mscene_id;
        r0.mis_folder = this.mis_folder;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FileContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1216newBuilder();
    }

    public FileContent(String r24, String r25, Long r26, String r27, Source r28, String r29, String r30, LANTransExtra r31, TransExtra r32, List<String> r33, FileAbility r34, FilePermission r35, Long r36, Long r37, String r38, FilePreviewStage r39, List<String> r40, Boolean r41, Map<String, ResourceCleanScene> r42, Long r43, Boolean r44) {
        this(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, ByteString.EMPTY);
    }

    public FileContent(String r4, String r5, Long r6, String r7, Source r8, String r9, String r10, LANTransExtra r11, TransExtra r12, List<String> r13, FileAbility r14, FilePermission r15, Long r16, Long r17, String r18, FilePreviewStage r19, List<String> r20, Boolean r21, Map<String, ResourceCleanScene> r22, Long r23, Boolean r24, ByteString r25) {
        super(ADAPTER, r25);
        this.mkey = r4;
        this.mname = r5;
        this.msize = r6;
        this.mmime = r7;
        this.msource = r8;
        this.mname_space = r9;
        this.mfs_unit = r10;
        this.mlan_trans_extra = r11;
        this.mtrans_extra = r12;
        this.mrisk_object_keys = Internal.immutableCopyOf("mrisk_object_keys", r13);
        this.mfile_ability = r14;
        this.mfile_permission = r15;
        this.mlast_update_user_id = r16;
        this.mlast_update_time_ms = r17;
        this.mcompressed_folder = r18;
        this.mfile_preview_stage = r19;
        this.mclean_resource_keys = Internal.immutableCopyOf("mclean_resource_keys", r20);
        this.mis_destroyed = r21;
        this.mclean_resource_key_scene = Internal.immutableCopyOf("mclean_resource_key_scene", r22);
        this.mscene_id = r23;
        this.mis_folder = r24;
    }
}
