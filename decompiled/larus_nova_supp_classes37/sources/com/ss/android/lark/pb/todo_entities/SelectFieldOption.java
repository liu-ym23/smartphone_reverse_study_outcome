package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SelectFieldOption extends Message<SelectFieldOption, Builder> {
    public static final ProtoAdapter<SelectFieldOption> ADAPTER = null;
    public static final Integer DEFAULT_COLOR_INDEX = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_HIDDEN = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_RANK = "";
    public static final String DEFAULT_TASK_FIELD_KEY = "";
    private static final long serialVersionUID = 0;
    public final Integer mcolor_index;
    public final String mguid;
    public final Boolean mis_hidden;
    public final String mname;
    public final String mrank;
    public final String mtask_field_key;

    public static final class Builder extends Message.Builder<SelectFieldOption, Builder> {
        public Integer mcolor_index;
        public String mguid;
        public Boolean mis_hidden;
        public String mname;
        public String mrank;
        public String mtask_field_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SelectFieldOption m2321build() {
            return new SelectFieldOption(this.mguid, this.mtask_field_key, this.mname, this.mcolor_index, this.mrank, this.mis_hidden, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2321build();
        }

        public Builder color_index(Integer r1) {
            this.mcolor_index = r1;
            return this;
        }

        public Builder guid(String r1) {
            this.mguid = r1;
            return this;
        }

        public Builder is_hidden(Boolean r1) {
            this.mis_hidden = r1;
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

        public Builder task_field_key(String r1) {
            this.mtask_field_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SelectFieldOption extends ProtoAdapter<SelectFieldOption> {
        public ProtoAdapter_SelectFieldOption() {
            super(FieldEncoding.LENGTH_DELIMITED, SelectFieldOption.class);
        }

        public SelectFieldOption decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mguid = "";
            r0.mtask_field_key = "";
            r0.mname = "";
            r0.mcolor_index = 0;
            r0.mrank = "";
            r0.mis_hidden = Boolean.FALSE;
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
            r0.mis_hidden = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mrank = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mcolor_index = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mtask_field_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mguid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m2321build();
        }

        public int encodedSize(SelectFieldOption r6) {
            String r0 = r6.mguid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtask_field_key;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mname;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Integer r10 = r6.mcolor_index;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mrank;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Boolean r16 = r6.mis_hidden;
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
        public /* bridge */ /* synthetic */ Object m2322decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SelectFieldOption) r1);
        }

        public void encode(ProtoWriter r4, SelectFieldOption r5) throws IOException {
            String r0 = r5.mguid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtask_field_key;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mname;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Integer r3 = r5.mcolor_index;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mrank;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            Boolean r7 = r5.mis_hidden;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SelectFieldOption) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SelectFieldOption();
        DEFAULT_COLOR_INDEX = 0;
        DEFAULT_IS_HIDDEN = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2320newBuilder() {
        Builder r0 = new Builder();
        r0.mguid = this.mguid;
        r0.mtask_field_key = this.mtask_field_key;
        r0.mname = this.mname;
        r0.mcolor_index = this.mcolor_index;
        r0.mrank = this.mrank;
        r0.mis_hidden = this.mis_hidden;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SelectFieldOption.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2320newBuilder();
    }

    public SelectFieldOption(String r9, String r10, String r11, Integer r12, String r13, Boolean r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public SelectFieldOption(String r2, String r3, String r4, Integer r5, String r6, Boolean r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mguid = r2;
        this.mtask_field_key = r3;
        this.mname = r4;
        this.mcolor_index = r5;
        this.mrank = r6;
        this.mis_hidden = r7;
    }
}
