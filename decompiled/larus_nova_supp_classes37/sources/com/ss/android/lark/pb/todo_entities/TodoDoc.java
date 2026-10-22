package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TodoDoc extends Message<TodoDoc, Builder> {
    public static final ProtoAdapter<TodoDoc> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_PERMISSION = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Boolean mhas_permission;
    public final String mid;
    public final String mname;
    public final String murl;

    public static final class Builder extends Message.Builder<TodoDoc, Builder> {
        public Boolean mhas_permission;
        public String mid;
        public String mname;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TodoDoc m2399build() {
            return new TodoDoc(this.murl, this.mname, this.mhas_permission, this.mid, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2399build();
        }

        public Builder has_permission(Boolean r1) {
            this.mhas_permission = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoDoc extends ProtoAdapter<TodoDoc> {
        public ProtoAdapter_TodoDoc() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoDoc.class);
        }

        public TodoDoc decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.murl = "";
            r0.mname = "";
            r0.mhas_permission = Boolean.FALSE;
            r0.mid = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.murl = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mhas_permission = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2399build();
        }

        public int encodedSize(TodoDoc r6) {
            String r0 = r6.murl;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mhas_permission;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mid;
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
        public /* bridge */ /* synthetic */ Object m2400decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TodoDoc) r1);
        }

        public void encode(ProtoWriter r4, TodoDoc r5) throws IOException {
            String r0 = r5.murl;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mhas_permission;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mid;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TodoDoc) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoDoc();
        DEFAULT_HAS_PERMISSION = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2398newBuilder() {
        Builder r0 = new Builder();
        r0.murl = this.murl;
        r0.mname = this.mname;
        r0.mhas_permission = this.mhas_permission;
        r0.mid = this.mid;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TodoDoc.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2398newBuilder();
    }

    public TodoDoc(String r7, String r8, Boolean r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public TodoDoc(String r2, String r3, Boolean r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.murl = r2;
        this.mname = r3;
        this.mhas_permission = r4;
        this.mid = r5;
    }
}
