package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AvatarMedal extends com.squareup.wire.Message<AvatarMedal, Builder> {
    public static final ProtoAdapter<AvatarMedal> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_KEY = "";
    public static final Boolean DEFAULT_SHOW_SWITCH = null;
    private static final long serialVersionUID = 0;
    public final String mfs_unit;
    public final I18nVal mi18n_name;
    public final String mkey;
    public final Boolean mshow_switch;

    public static final class Builder extends com.squareup.wire.Message.Builder<AvatarMedal, Builder> {
        public String mfs_unit;
        public I18nVal mi18n_name;
        public String mkey;
        public Boolean mshow_switch;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AvatarMedal m1013build() {
            return new AvatarMedal(this.mkey, this.mfs_unit, this.mi18n_name, this.mshow_switch, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1013build();
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder i18n_name(I18nVal r1) {
            this.mi18n_name = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder show_switch(Boolean r1) {
            this.mshow_switch = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AvatarMedal extends ProtoAdapter<AvatarMedal> {
        public ProtoAdapter_AvatarMedal() {
            super(FieldEncoding.LENGTH_DELIMITED, AvatarMedal.class);
        }

        public AvatarMedal decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mfs_unit = "";
            r0.mshow_switch = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mi18n_name = (I18nVal) I18nVal.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mshow_switch = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1013build();
        }

        public int encodedSize(AvatarMedal r6) {
            String r0 = r6.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mfs_unit;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            I18nVal r7 = r6.mi18n_name;
            if (r7 == null) goto L13;
            int r8 = I18nVal.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mshow_switch;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m1014decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AvatarMedal) r1);
        }

        public void encode(ProtoWriter r4, AvatarMedal r5) throws IOException {
            String r0 = r5.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mfs_unit;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            I18nVal r2 = r5.mi18n_name;
            if (r2 == null) goto L11;
            I18nVal.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mshow_switch;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AvatarMedal) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AvatarMedal();
        DEFAULT_SHOW_SWITCH = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1012newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mfs_unit = this.mfs_unit;
        r0.mi18n_name = this.mi18n_name;
        r0.mshow_switch = this.mshow_switch;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AvatarMedal.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1012newBuilder();
    }

    public AvatarMedal(String r7, String r8, I18nVal r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public AvatarMedal(String r2, String r3, I18nVal r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mkey = r2;
        this.mfs_unit = r3;
        this.mi18n_name = r4;
        this.mshow_switch = r5;
    }
}
