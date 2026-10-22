package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TagInfo extends com.squareup.wire.Message<TagInfo, Builder> {
    public static final ProtoAdapter<TagInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SHOW_TAG = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_show_tag;
    public final TagColor mtag_color;

    public static final class Builder extends com.squareup.wire.Message.Builder<TagInfo, Builder> {
        public Boolean mis_show_tag;
        public TagColor mtag_color;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TagInfo m1550build() {
            return new TagInfo(this.mis_show_tag, this.mtag_color, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1550build();
        }

        public Builder is_show_tag(Boolean r1) {
            this.mis_show_tag = r1;
            return this;
        }

        public Builder tag_color(TagColor r1) {
            this.mtag_color = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TagInfo extends ProtoAdapter<TagInfo> {
        public ProtoAdapter_TagInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TagInfo.class);
        }

        public TagInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_show_tag = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mis_show_tag = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtag_color = (TagColor) TagColor.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1550build();
        }

        public int encodedSize(TagInfo r5) {
            Boolean r0 = r5.mis_show_tag;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            TagColor r3 = r5.mtag_color;
            if (r3 == null) goto L10;
            r1 = TagColor.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1551decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TagInfo) r1);
        }

        public void encode(ProtoWriter r4, TagInfo r5) throws IOException {
            Boolean r0 = r5.mis_show_tag;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            TagColor r1 = r5.mtag_color;
            if (r1 == null) goto L8;
            TagColor.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TagInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TagInfo();
        DEFAULT_IS_SHOW_TAG = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1549newBuilder() {
        Builder r0 = new Builder();
        r0.mis_show_tag = this.mis_show_tag;
        r0.mtag_color = this.mtag_color;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TagInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1549newBuilder();
    }

    public TagInfo(Boolean r2, TagColor r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public TagInfo(Boolean r2, TagColor r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mis_show_tag = r2;
        this.mtag_color = r3;
    }
}
