package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DocPermission extends com.squareup.wire.Message<DocPermission, Builder> {
    public static final ProtoAdapter<DocPermission> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SET = null;
    public static final Integer DEFAULT_PERM_CODE = null;
    public static final String DEFAULT_PERM_NAME = "";
    private static final long serialVersionUID = 0;
    public final Boolean mis_set;
    public final Integer mperm_code;
    public final String mperm_name;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocPermission, Builder> {
        public Boolean mis_set;
        public Integer mperm_code;
        public String mperm_name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DocPermission m1205build() {
            return new DocPermission(this.mperm_code, this.mperm_name, this.mis_set, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1205build();
        }

        public Builder is_set(Boolean r1) {
            this.mis_set = r1;
            return this;
        }

        public Builder perm_code(Integer r1) {
            this.mperm_code = r1;
            return this;
        }

        public Builder perm_name(String r1) {
            this.mperm_name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DocPermission extends ProtoAdapter<DocPermission> {
        public ProtoAdapter_DocPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, DocPermission.class);
        }

        public DocPermission decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mperm_code = 0;
            r0.mperm_name = "";
            r0.mis_set = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mperm_code = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mperm_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mis_set = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1205build();
        }

        public int encodedSize(DocPermission r6) {
            Integer r0 = r6.mperm_code;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mperm_name;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_set;
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
        public /* bridge */ /* synthetic */ Object m1206decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DocPermission) r1);
        }

        public void encode(ProtoWriter r4, DocPermission r5) throws IOException {
            Integer r0 = r5.mperm_code;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mperm_name;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_set;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DocPermission) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocPermission();
        DEFAULT_PERM_CODE = 0;
        DEFAULT_IS_SET = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1204newBuilder() {
        Builder r0 = new Builder();
        r0.mperm_code = this.mperm_code;
        r0.mperm_name = this.mperm_name;
        r0.mis_set = this.mis_set;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DocPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1204newBuilder();
    }

    public DocPermission(Integer r2, String r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DocPermission(Integer r2, String r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mperm_code = r2;
        this.mperm_name = r3;
        this.mis_set = r4;
    }
}
