package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DialogMaterial extends Message<DialogMaterial, Builder> {
    public static final ProtoAdapter<DialogMaterial> ADAPTER = null;
    public static final String DEFAULT_DATA = "";
    public static final String DEFAULT_DIALOG_NAME = "";
    public static final String DEFAULT_LAYOUT_NAME = "";
    private static final long serialVersionUID = 0;
    public final MaterialBase mbase;
    public final String mdata;
    public final String mdialog_name;
    public final String mlayout_name;

    public static final class Builder extends Message.Builder<DialogMaterial, Builder> {
        public MaterialBase mbase;
        public String mdata;
        public String mdialog_name;
        public String mlayout_name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DialogMaterial m2441build() {
            return new DialogMaterial(this.mdialog_name, this.mlayout_name, this.mdata, this.mbase, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2441build();
        }

        public Builder base(MaterialBase r1) {
            this.mbase = r1;
            return this;
        }

        public Builder data(String r1) {
            this.mdata = r1;
            return this;
        }

        public Builder dialog_name(String r1) {
            this.mdialog_name = r1;
            return this;
        }

        public Builder layout_name(String r1) {
            this.mlayout_name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DialogMaterial extends ProtoAdapter<DialogMaterial> {
        public ProtoAdapter_DialogMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, DialogMaterial.class);
        }

        public DialogMaterial decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdialog_name = "";
            r0.mlayout_name = "";
            r0.mdata = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mdialog_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mlayout_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mdata = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mbase = (MaterialBase) MaterialBase.ADAPTER.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2441build();
        }

        public int encodedSize(DialogMaterial r6) {
            String r0 = r6.mdialog_name;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mlayout_name;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mdata;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            MaterialBase r10 = r6.mbase;
            if (r10 == null) goto L18;
            r1 = MaterialBase.ADAPTER.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m2442decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DialogMaterial) r1);
        }

        public void encode(ProtoWriter r4, DialogMaterial r5) throws IOException {
            String r0 = r5.mdialog_name;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mlayout_name;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mdata;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            MaterialBase r3 = r5.mbase;
            if (r3 == null) goto L14;
            MaterialBase.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DialogMaterial) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DialogMaterial();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2440newBuilder() {
        Builder r0 = new Builder();
        r0.mdialog_name = this.mdialog_name;
        r0.mlayout_name = this.mlayout_name;
        r0.mdata = this.mdata;
        r0.mbase = this.mbase;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DialogMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2440newBuilder();
    }

    public DialogMaterial(String r7, String r8, String r9, MaterialBase r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public DialogMaterial(String r2, String r3, String r4, MaterialBase r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mdialog_name = r2;
        this.mlayout_name = r3;
        this.mdata = r4;
        this.mbase = r5;
    }
}
