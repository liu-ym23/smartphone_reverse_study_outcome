package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskField extends Message<TaskField, Builder> {
    public static final ProtoAdapter<TaskField> ADAPTER = null;
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final Long DEFAULT_CREATOR_ID = null;
    public static final Long DEFAULT_DELETED_MILLI_TIME = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_UPDATE_MILLI_TIME = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final TaskFieldCategory mcategory;
    public final Long mcreate_milli_time;
    public final Long mcreator_id;
    public final Long mdeleted_milli_time;
    public final String mkey;
    public final String mname;
    public final TaskFieldSettings msettings;
    public final FieldType mtype;
    public final Long mupdate_milli_time;
    public final Long mversion;

    public static final class Builder extends Message.Builder<TaskField, Builder> {
        public TaskFieldCategory mcategory;
        public Long mcreate_milli_time;
        public Long mcreator_id;
        public Long mdeleted_milli_time;
        public String mkey;
        public String mname;
        public TaskFieldSettings msettings;
        public FieldType mtype;
        public Long mupdate_milli_time;
        public Long mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskField m2342build() {
            return new TaskField(this.mkey, this.mname, this.mtype, this.msettings, this.mcategory, this.mcreator_id, this.mcreate_milli_time, this.mupdate_milli_time, this.mdeleted_milli_time, this.mversion, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2342build();
        }

        public Builder category(TaskFieldCategory r1) {
            this.mcategory = r1;
            return this;
        }

        public Builder create_milli_time(Long r1) {
            this.mcreate_milli_time = r1;
            return this;
        }

        public Builder creator_id(Long r1) {
            this.mcreator_id = r1;
            return this;
        }

        public Builder deleted_milli_time(Long r1) {
            this.mdeleted_milli_time = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder settings(TaskFieldSettings r1) {
            this.msettings = r1;
            return this;
        }

        public Builder type(FieldType r1) {
            this.mtype = r1;
            return this;
        }

        public Builder update_milli_time(Long r1) {
            this.mupdate_milli_time = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskField extends ProtoAdapter<TaskField> {
        public ProtoAdapter_TaskField() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskField.class);
        }

        public TaskField decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mname = "";
            r0.mcreator_id = 0L;
            r0.mcreate_milli_time = 0L;
            r0.mupdate_milli_time = 0L;
            r0.mdeleted_milli_time = 0L;
            r0.mversion = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            switch(r3) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L28;
                case 4: goto L17;
                case 5: goto L26;
                case 6: goto L12;
                default: goto L6;
            };
        L26:
            r0.mcategory = (TaskFieldCategory) TaskFieldCategory.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L28:
            r0.mtype = (FieldType) FieldType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            r0.mcreator_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L17:
            r0.msettings = (TaskFieldSettings) TaskFieldSettings.ADAPTER.decode(r9);
            goto L3
        L22:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L23:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            switch(r3) {
                case 100: goto L11;
                case 101: goto L10;
                case 102: goto L9;
                case 103: goto L8;
                default: goto L7;
            };
        L8:
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L9:
            r0.mdeleted_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            r0.mupdate_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L11:
            r0.mcreate_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m2342build();
        }

        public int encodedSize(TaskField r6) {
            String r0 = r6.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            FieldType r7 = r6.mtype;
            if (r7 == null) goto L13;
            int r8 = FieldType.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TaskFieldSettings r10 = r6.msettings;
            if (r10 == null) goto L17;
            int r11 = TaskFieldSettings.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            TaskFieldCategory r13 = r6.mcategory;
            if (r13 == null) goto L21;
            int r14 = TaskFieldCategory.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Long r16 = r6.mcreator_id;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.INT64.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Long r19 = r6.mcreate_milli_time;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.INT64.encodedSizeWithTag(100, r19);
        L30:
            int r21 = r18 + r20;
            Long r22 = r6.mupdate_milli_time;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.INT64.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r22);
        L34:
            int r24 = r21 + r23;
            Long r25 = r6.mdeleted_milli_time;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.INT64.encodedSizeWithTag(BaseField.FIELD_TYPE_S_FRIEND_LINK, r25);
        L38:
            int r27 = r24 + r26;
            Long r28 = r6.mversion;
            if (r28 == null) goto L42;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(103, r28);
        L42:
            return (r27 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2343decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskField) r1);
        }

        public void encode(ProtoWriter r4, TaskField r5) throws IOException {
            String r0 = r5.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            FieldType r2 = r5.mtype;
            if (r2 == null) goto L11;
            FieldType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TaskFieldSettings r3 = r5.msettings;
            if (r3 == null) goto L14;
            TaskFieldSettings.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            TaskFieldCategory r6 = r5.mcategory;
            if (r6 == null) goto L17;
            TaskFieldCategory.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            Long r7 = r5.mcreator_id;
            if (r7 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r4, 6, r7);
        L20:
            Long r8 = r5.mcreate_milli_time;
            if (r8 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r4, 100, r8);
        L23:
            Long r9 = r5.mupdate_milli_time;
            if (r9 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r9);
        L26:
            Long r10 = r5.mdeleted_milli_time;
            if (r10 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r4, BaseField.FIELD_TYPE_S_FRIEND_LINK, r10);
        L29:
            Long r11 = r5.mversion;
            if (r11 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r4, 103, r11);
        L32:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskField) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskField();
        DEFAULT_CREATOR_ID = 0L;
        DEFAULT_CREATE_MILLI_TIME = 0L;
        DEFAULT_UPDATE_MILLI_TIME = 0L;
        DEFAULT_DELETED_MILLI_TIME = 0L;
        DEFAULT_VERSION = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2341newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mname = this.mname;
        r0.mtype = this.mtype;
        r0.msettings = this.msettings;
        r0.mcategory = this.mcategory;
        r0.mcreator_id = this.mcreator_id;
        r0.mcreate_milli_time = this.mcreate_milli_time;
        r0.mupdate_milli_time = this.mupdate_milli_time;
        r0.mdeleted_milli_time = this.mdeleted_milli_time;
        r0.mversion = this.mversion;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskField.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2341newBuilder();
    }

    public TaskField(String r13, String r14, FieldType r15, TaskFieldSettings r16, TaskFieldCategory r17, Long r18, Long r19, Long r20, Long r21, Long r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public TaskField(String r2, String r3, FieldType r4, TaskFieldSettings r5, TaskFieldCategory r6, Long r7, Long r8, Long r9, Long r10, Long r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mkey = r2;
        this.mname = r3;
        this.mtype = r4;
        this.msettings = r5;
        this.mcategory = r6;
        this.mcreator_id = r7;
        this.mcreate_milli_time = r8;
        this.mupdate_milli_time = r9;
        this.mdeleted_milli_time = r10;
        this.mversion = r11;
    }
}
