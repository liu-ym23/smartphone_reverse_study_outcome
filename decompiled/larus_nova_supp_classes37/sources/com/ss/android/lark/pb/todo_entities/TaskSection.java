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
public final class TaskSection extends Message<TaskSection, Builder> {
    public static final ProtoAdapter<TaskSection> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_DEFAULT = null;
    public static final Boolean DEFAULT_IS_FROM_MEEGO = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_RANK = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String mcontainer_id;
    public final Long mdelete_milli_time;
    public final String mguid;
    public final Boolean mis_default;
    public final Boolean mis_from_meego;
    public final String mkey;
    public final String mname;
    public final String mrank;
    public final Long mversion;

    public static final class Builder extends Message.Builder<TaskSection, Builder> {
        public String mcontainer_id;
        public Long mdelete_milli_time;
        public String mguid;
        public Boolean mis_default;
        public Boolean mis_from_meego;
        public String mkey;
        public String mname;
        public String mrank;
        public Long mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskSection m2351build() {
            return new TaskSection(this.mguid, this.mname, this.mis_default, this.mkey, this.mrank, this.mcontainer_id, this.mis_from_meego, this.mversion, this.mdelete_milli_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2351build();
        }

        public Builder container_id(String r1) {
            this.mcontainer_id = r1;
            return this;
        }

        public Builder delete_milli_time(Long r1) {
            this.mdelete_milli_time = r1;
            return this;
        }

        public Builder guid(String r1) {
            this.mguid = r1;
            return this;
        }

        public Builder is_default(Boolean r1) {
            this.mis_default = r1;
            return this;
        }

        public Builder is_from_meego(Boolean r1) {
            this.mis_from_meego = r1;
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

        public Builder rank(String r1) {
            this.mrank = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSection extends ProtoAdapter<TaskSection> {
        public ProtoAdapter_TaskSection() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSection.class);
        }

        public TaskSection decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mguid = "";
            r0.mname = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_default = r2;
            r0.mkey = "";
            r0.mrank = "";
            r0.mcontainer_id = "";
            r0.mis_from_meego = r2;
            r0.mversion = 0L;
            r0.mdelete_milli_time = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L20;
            if (r3 != 100) goto L8;
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 101) goto L9;
            r0.mdelete_milli_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            switch(r3) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L11:
            r0.mis_from_meego = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            r0.mcontainer_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.mrank = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            r0.mis_default = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L16:
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L17:
            r0.mguid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L20:
            r7.endMessage(r1);
            return r0.m2351build();
        }

        public int encodedSize(TaskSection r6) {
            String r0 = r6.mguid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_default;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mkey;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mrank;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mcontainer_id;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mis_from_meego;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Long r22 = r6.mversion;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.INT64.encodedSizeWithTag(100, r22);
        L34:
            int r24 = r21 + r23;
            Long r25 = r6.mdelete_milli_time;
            if (r25 == null) goto L38;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r25);
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
        public /* bridge */ /* synthetic */ Object m2352decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskSection) r1);
        }

        public void encode(ProtoWriter r4, TaskSection r5) throws IOException {
            String r0 = r5.mguid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_default;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mkey;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mrank;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mcontainer_id;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            Boolean r8 = r5.mis_from_meego;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
        L23:
            Long r9 = r5.mversion;
            if (r9 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r4, 100, r9);
        L26:
            Long r10 = r5.mdelete_milli_time;
            if (r10 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r10);
        L29:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskSection) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSection();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_DEFAULT = r0;
        DEFAULT_IS_FROM_MEEGO = r0;
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2350newBuilder() {
        Builder r0 = new Builder();
        r0.mguid = this.mguid;
        r0.mname = this.mname;
        r0.mis_default = this.mis_default;
        r0.mkey = this.mkey;
        r0.mrank = this.mrank;
        r0.mcontainer_id = this.mcontainer_id;
        r0.mis_from_meego = this.mis_from_meego;
        r0.mversion = this.mversion;
        r0.mdelete_milli_time = this.mdelete_milli_time;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskSection.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2350newBuilder();
    }

    public TaskSection(String r12, String r13, Boolean r14, String r15, String r16, String r17, Boolean r18, Long r19, Long r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public TaskSection(String r2, String r3, Boolean r4, String r5, String r6, String r7, Boolean r8, Long r9, Long r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mguid = r2;
        this.mname = r3;
        this.mis_default = r4;
        this.mkey = r5;
        this.mrank = r6;
        this.mcontainer_id = r7;
        this.mis_from_meego = r8;
        this.mversion = r9;
        this.mdelete_milli_time = r10;
    }
}
