package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ExtraInfoBlockIcon extends Message<ExtraInfoBlockIcon, Builder> {
    public static final ProtoAdapter<ExtraInfoBlockIcon> ADAPTER = null;
    public static final String DEFAULT_HOVER_TEXT = "";
    public static final String DEFAULT_ICON_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mhover_text;
    public final String micon_key;

    public static final class Builder extends Message.Builder<ExtraInfoBlockIcon, Builder> {
        public String mhover_text;
        public String micon_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ExtraInfoBlockIcon m2645build() {
            return new ExtraInfoBlockIcon(this.mhover_text, this.micon_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2645build();
        }

        public Builder hover_text(String r1) {
            this.mhover_text = r1;
            return this;
        }

        public Builder icon_key(String r1) {
            this.micon_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraInfoBlockIcon extends ProtoAdapter<ExtraInfoBlockIcon> {
        public ProtoAdapter_ExtraInfoBlockIcon() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraInfoBlockIcon.class);
        }

        public ExtraInfoBlockIcon decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mhover_text = "";
            r0.micon_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mhover_text = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.micon_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2645build();
        }

        public int encodedSize(ExtraInfoBlockIcon r5) {
            String r0 = r5.mhover_text;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.micon_key;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2646decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ExtraInfoBlockIcon) r1);
        }

        public void encode(ProtoWriter r4, ExtraInfoBlockIcon r5) throws IOException {
            String r0 = r5.mhover_text;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.micon_key;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ExtraInfoBlockIcon) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraInfoBlockIcon();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2644newBuilder() {
        Builder r0 = new Builder();
        r0.mhover_text = this.mhover_text;
        r0.micon_key = this.micon_key;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ExtraInfoBlockIcon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2644newBuilder();
    }

    public ExtraInfoBlockIcon(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public ExtraInfoBlockIcon(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mhover_text = r2;
        this.micon_key = r3;
    }
}
