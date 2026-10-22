package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ExtraInfoBlock extends Message<ExtraInfoBlock, Builder> {
    public static final ProtoAdapter<ExtraInfoBlock> ADAPTER = null;
    public static final Boolean DEFAULT_IS_NEED_HOVER = null;
    public static final String DEFAULT_SEGMENT_SEPARATOR = "";
    private static final long serialVersionUID = 0;
    public final ExtraInfoBlockIcon mblock_icon;
    public final List<ExtraInfoBlockSegment> mblock_segments;
    public final Boolean mis_need_hover;
    public final String msegment_separator;

    public static final class Builder extends Message.Builder<ExtraInfoBlock, Builder> {
        public ExtraInfoBlockIcon mblock_icon;
        public List<ExtraInfoBlockSegment> mblock_segments;
        public Boolean mis_need_hover;
        public String msegment_separator;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ExtraInfoBlock m2642build() {
            return new ExtraInfoBlock(this.mblock_segments, this.msegment_separator, this.mblock_icon, this.mis_need_hover, super.buildUnknownFields());
        }

        public Builder() {
            this.mblock_segments = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2642build();
        }

        public Builder block_icon(ExtraInfoBlockIcon r1) {
            this.mblock_icon = r1;
            return this;
        }

        public Builder block_segments(List<ExtraInfoBlockSegment> r1) {
            Internal.checkElementsNotNull(r1);
            this.mblock_segments = r1;
            return this;
        }

        public Builder is_need_hover(Boolean r1) {
            this.mis_need_hover = r1;
            return this;
        }

        public Builder segment_separator(String r1) {
            this.msegment_separator = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraInfoBlock extends ProtoAdapter<ExtraInfoBlock> {
        public ProtoAdapter_ExtraInfoBlock() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraInfoBlock.class);
        }

        public ExtraInfoBlock decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msegment_separator = "";
            r0.mis_need_hover = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mblock_segments.add((ExtraInfoBlockSegment) ExtraInfoBlockSegment.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msegment_separator = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mblock_icon = (ExtraInfoBlockIcon) ExtraInfoBlockIcon.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mis_need_hover = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2642build();
        }

        public int encodedSize(ExtraInfoBlock r6) {
            int r0 = ExtraInfoBlockSegment.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mblock_segments);
            String r1 = r6.msegment_separator;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.STRING.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            ExtraInfoBlockIcon r5 = r6.mblock_icon;
            if (r5 == null) goto L9;
            int r7 = ExtraInfoBlockIcon.ADAPTER.encodedSizeWithTag(3, r5);
        L10:
            int r8 = r4 + r7;
            Boolean r9 = r6.mis_need_hover;
            if (r9 == null) goto L14;
            r2 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r9);
        L14:
            return (r8 + r2) + r6.unknownFields().size();
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2643decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ExtraInfoBlock) r1);
        }

        public void encode(ProtoWriter r4, ExtraInfoBlock r5) throws IOException {
            ExtraInfoBlockSegment.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mblock_segments);
            String r0 = r5.msegment_separator;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r0);
        L5:
            ExtraInfoBlockIcon r1 = r5.mblock_icon;
            if (r1 == null) goto L8;
            ExtraInfoBlockIcon.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            Boolean r2 = r5.mis_need_hover;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ExtraInfoBlock) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraInfoBlock();
        DEFAULT_IS_NEED_HOVER = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2641newBuilder() {
        Builder r0 = new Builder();
        r0.mblock_segments = Internal.copyOf("mblock_segments", this.mblock_segments);
        r0.msegment_separator = this.msegment_separator;
        r0.mblock_icon = this.mblock_icon;
        r0.mis_need_hover = this.mis_need_hover;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ExtraInfoBlock.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2641newBuilder();
    }

    public ExtraInfoBlock(List<ExtraInfoBlockSegment> r7, String r8, ExtraInfoBlockIcon r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public ExtraInfoBlock(List<ExtraInfoBlockSegment> r2, String r3, ExtraInfoBlockIcon r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mblock_segments = Internal.immutableCopyOf("mblock_segments", r2);
        this.msegment_separator = r3;
        this.mblock_icon = r4;
        this.mis_need_hover = r5;
    }
}
