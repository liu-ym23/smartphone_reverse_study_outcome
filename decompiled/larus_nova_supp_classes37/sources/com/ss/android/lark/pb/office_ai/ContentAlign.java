package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ContentAlign extends Message<ContentAlign, Builder> {
    public static final ProtoAdapter<ContentAlign> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ContentAlignType micon_align;
    public final ContentAlignType mlink_icon_align;
    public final ContentAlignType mname_align;

    public static final class Builder extends Message.Builder<ContentAlign, Builder> {
        public ContentAlignType micon_align;
        public ContentAlignType mlink_icon_align;
        public ContentAlignType mname_align;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ContentAlign m1937build() {
            return new ContentAlign(this.micon_align, this.mname_align, this.mlink_icon_align, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1937build();
        }

        public Builder icon_align(ContentAlignType r1) {
            this.micon_align = r1;
            return this;
        }

        public Builder link_icon_align(ContentAlignType r1) {
            this.mlink_icon_align = r1;
            return this;
        }

        public Builder name_align(ContentAlignType r1) {
            this.mname_align = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ContentAlign extends ProtoAdapter<ContentAlign> {
        public ProtoAdapter_ContentAlign() {
            super(FieldEncoding.LENGTH_DELIMITED, ContentAlign.class);
        }

        public ContentAlign decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.micon_align = (ContentAlignType) ContentAlignType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mname_align = (ContentAlignType) ContentAlignType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mlink_icon_align = (ContentAlignType) ContentAlignType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m1937build();
        }

        public int encodedSize(ContentAlign r6) {
            ContentAlignType r0 = r6.micon_align;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ContentAlignType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ContentAlignType r3 = r6.mname_align;
            if (r3 == null) goto L9;
            int r4 = ContentAlignType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ContentAlignType r7 = r6.mlink_icon_align;
            if (r7 == null) goto L14;
            r1 = ContentAlignType.ADAPTER.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1938decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ContentAlign) r1);
        }

        public void encode(ProtoWriter r4, ContentAlign r5) throws IOException {
            ContentAlignType r0 = r5.micon_align;
            if (r0 == null) goto L5;
            ContentAlignType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            ContentAlignType r1 = r5.mname_align;
            if (r1 == null) goto L8;
            ContentAlignType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            ContentAlignType r2 = r5.mlink_icon_align;
            if (r2 == null) goto L11;
            ContentAlignType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ContentAlign) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContentAlign();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1936newBuilder() {
        Builder r0 = new Builder();
        r0.micon_align = this.micon_align;
        r0.mname_align = this.mname_align;
        r0.mlink_icon_align = this.mlink_icon_align;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ContentAlign.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1936newBuilder();
    }

    public ContentAlign(ContentAlignType r2, ContentAlignType r3, ContentAlignType r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ContentAlign(ContentAlignType r2, ContentAlignType r3, ContentAlignType r4, ByteString r5) {
        super(ADAPTER, r5);
        this.micon_align = r2;
        this.mname_align = r3;
        this.mlink_icon_align = r4;
    }
}
