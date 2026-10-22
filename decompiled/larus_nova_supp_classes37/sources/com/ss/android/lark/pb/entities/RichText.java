package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RichText extends com.squareup.wire.Message<RichText, Builder> {
    public static final ProtoAdapter<RichText> ADAPTER = null;
    public static final String DEFAULT_INNER_TEXT = "";
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<String> manchor_ids;
    public final List<String> mat_ids;
    public final List<String> mat_user_group_ids;
    public final List<String> mdocs_ids;
    public final List<String> melement_ids;
    public final RichTextElements melements;
    public final List<String> mi18n_ids;
    public final List<String> mimage_ids;
    public final String minner_text;
    public final List<String> minteractive_ids;
    public final List<String> mmarkdown_ids;
    public final List<String> mmedia_ids;
    public final List<String> mmention_ids;
    public final Integer mversion;

    public static final class Builder extends com.squareup.wire.Message.Builder<RichText, Builder> {
        public List<String> manchor_ids;
        public List<String> mat_ids;
        public List<String> mat_user_group_ids;
        public List<String> mdocs_ids;
        public List<String> melement_ids;
        public RichTextElements melements;
        public List<String> mi18n_ids;
        public List<String> mimage_ids;
        public String minner_text;
        public List<String> minteractive_ids;
        public List<String> mmarkdown_ids;
        public List<String> mmedia_ids;
        public List<String> mmention_ids;
        public Integer mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RichText m1349build() {
            String r1 = this.minner_text;
            if (r1 == null) goto L9;
            if (this.melements == null) goto L9;
            return new RichText(this.melement_ids, this.minner_text, this.melements, this.mimage_ids, this.mat_ids, this.manchor_ids, this.mi18n_ids, this.mmedia_ids, this.mdocs_ids, this.minteractive_ids, this.mmention_ids, this.mversion, this.mat_user_group_ids, this.mmarkdown_ids, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r1, "minner_text", this.melements, "melements"});
        }

        public Builder() {
            this.melement_ids = Internal.newMutableList();
            this.mimage_ids = Internal.newMutableList();
            this.mat_ids = Internal.newMutableList();
            this.manchor_ids = Internal.newMutableList();
            this.mi18n_ids = Internal.newMutableList();
            this.mmedia_ids = Internal.newMutableList();
            this.mdocs_ids = Internal.newMutableList();
            this.minteractive_ids = Internal.newMutableList();
            this.mmention_ids = Internal.newMutableList();
            this.mat_user_group_ids = Internal.newMutableList();
            this.mmarkdown_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1349build();
        }

        public Builder anchor_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.manchor_ids = r1;
            return this;
        }

        public Builder at_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mat_ids = r1;
            return this;
        }

        public Builder at_user_group_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mat_user_group_ids = r1;
            return this;
        }

        public Builder docs_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdocs_ids = r1;
            return this;
        }

        public Builder element_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.melement_ids = r1;
            return this;
        }

        public Builder elements(RichTextElements r1) {
            this.melements = r1;
            return this;
        }

        public Builder i18n_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_ids = r1;
            return this;
        }

        public Builder image_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mimage_ids = r1;
            return this;
        }

        public Builder inner_text(String r1) {
            this.minner_text = r1;
            return this;
        }

        public Builder interactive_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.minteractive_ids = r1;
            return this;
        }

        public Builder markdown_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmarkdown_ids = r1;
            return this;
        }

        public Builder media_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmedia_ids = r1;
            return this;
        }

        public Builder mention_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmention_ids = r1;
            return this;
        }

        public Builder version(Integer r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RichText extends ProtoAdapter<RichText> {
        public ProtoAdapter_RichText() {
            super(FieldEncoding.LENGTH_DELIMITED, RichText.class);
        }

        public RichText decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.minner_text = "";
            r0.mversion = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            switch(r3) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L6;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L7:
            r0.mmarkdown_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            r0.mat_user_group_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            r0.mversion = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            r0.mmention_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.minteractive_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.mdocs_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.mmedia_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.mi18n_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L15:
            r0.manchor_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L16:
            r0.mat_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L17:
            r0.mimage_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L18:
            r0.melements = (RichTextElements) RichTextElements.ADAPTER.decode(r7);
            goto L3
        L19:
            r0.minner_text = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L20:
            r0.melement_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1349build();
        }

        public int encodedSize(RichText r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = (((((((((r0.asRepeated().encodedSizeWithTag(1, r6.melement_ids) + r0.encodedSizeWithTag(2, r6.minner_text)) + RichTextElements.ADAPTER.encodedSizeWithTag(3, r6.melements)) + r0.asRepeated().encodedSizeWithTag(5, r6.mimage_ids)) + r0.asRepeated().encodedSizeWithTag(6, r6.mat_ids)) + r0.asRepeated().encodedSizeWithTag(7, r6.manchor_ids)) + r0.asRepeated().encodedSizeWithTag(8, r6.mi18n_ids)) + r0.asRepeated().encodedSizeWithTag(9, r6.mmedia_ids)) + r0.asRepeated().encodedSizeWithTag(10, r6.mdocs_ids)) + r0.asRepeated().encodedSizeWithTag(11, r6.minteractive_ids)) + r0.asRepeated().encodedSizeWithTag(12, r6.mmention_ids);
            Integer r2 = r6.mversion;
            if (r2 == null) goto L5;
            int r3 = ProtoAdapter.INT32.encodedSizeWithTag(13, r2);
        L7:
            return (((r1 + r3) + r0.asRepeated().encodedSizeWithTag(14, r6.mat_user_group_ids)) + r0.asRepeated().encodedSizeWithTag(15, r6.mmarkdown_ids)) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1350decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RichText) r1);
        }

        public void encode(ProtoWriter r5, RichText r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.asRepeated().encodeWithTag(r5, 1, r6.melement_ids);
            r0.encodeWithTag(r5, 2, r6.minner_text);
            RichTextElements.ADAPTER.encodeWithTag(r5, 3, r6.melements);
            r0.asRepeated().encodeWithTag(r5, 5, r6.mimage_ids);
            r0.asRepeated().encodeWithTag(r5, 6, r6.mat_ids);
            r0.asRepeated().encodeWithTag(r5, 7, r6.manchor_ids);
            r0.asRepeated().encodeWithTag(r5, 8, r6.mi18n_ids);
            r0.asRepeated().encodeWithTag(r5, 9, r6.mmedia_ids);
            r0.asRepeated().encodeWithTag(r5, 10, r6.mdocs_ids);
            r0.asRepeated().encodeWithTag(r5, 11, r6.minteractive_ids);
            r0.asRepeated().encodeWithTag(r5, 12, r6.mmention_ids);
            Integer r1 = r6.mversion;
            if (r1 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r5, 13, r1);
        L5:
            r0.asRepeated().encodeWithTag(r5, 14, r6.mat_user_group_ids);
            r0.asRepeated().encodeWithTag(r5, 15, r6.mmarkdown_ids);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RichText) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RichText();
        DEFAULT_VERSION = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1348newBuilder() {
        Builder r0 = new Builder();
        r0.melement_ids = Internal.copyOf("melement_ids", this.melement_ids);
        r0.minner_text = this.minner_text;
        r0.melements = this.melements;
        r0.mimage_ids = Internal.copyOf("mimage_ids", this.mimage_ids);
        r0.mat_ids = Internal.copyOf("mat_ids", this.mat_ids);
        r0.manchor_ids = Internal.copyOf("manchor_ids", this.manchor_ids);
        r0.mi18n_ids = Internal.copyOf("mi18n_ids", this.mi18n_ids);
        r0.mmedia_ids = Internal.copyOf("mmedia_ids", this.mmedia_ids);
        r0.mdocs_ids = Internal.copyOf("mdocs_ids", this.mdocs_ids);
        r0.minteractive_ids = Internal.copyOf("minteractive_ids", this.minteractive_ids);
        r0.mmention_ids = Internal.copyOf("mmention_ids", this.mmention_ids);
        r0.mversion = this.mversion;
        r0.mat_user_group_ids = Internal.copyOf("mat_user_group_ids", this.mat_user_group_ids);
        r0.mmarkdown_ids = Internal.copyOf("mmarkdown_ids", this.mmarkdown_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RichText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1348newBuilder();
    }

    public RichText(List<String> r17, String r18, RichTextElements r19, List<String> r20, List<String> r21, List<String> r22, List<String> r23, List<String> r24, List<String> r25, List<String> r26, List<String> r27, Integer r28, List<String> r29, List<String> r30) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, ByteString.EMPTY);
    }

    public RichText(List<String> r4, String r5, RichTextElements r6, List<String> r7, List<String> r8, List<String> r9, List<String> r10, List<String> r11, List<String> r12, List<String> r13, List<String> r14, Integer r15, List<String> r16, List<String> r17, ByteString r18) {
        super(ADAPTER, r18);
        this.melement_ids = Internal.immutableCopyOf("melement_ids", r4);
        this.minner_text = r5;
        this.melements = r6;
        this.mimage_ids = Internal.immutableCopyOf("mimage_ids", r7);
        this.mat_ids = Internal.immutableCopyOf("mat_ids", r8);
        this.manchor_ids = Internal.immutableCopyOf("manchor_ids", r9);
        this.mi18n_ids = Internal.immutableCopyOf("mi18n_ids", r10);
        this.mmedia_ids = Internal.immutableCopyOf("mmedia_ids", r11);
        this.mdocs_ids = Internal.immutableCopyOf("mdocs_ids", r12);
        this.minteractive_ids = Internal.immutableCopyOf("minteractive_ids", r13);
        this.mmention_ids = Internal.immutableCopyOf("mmention_ids", r14);
        this.mversion = r15;
        this.mat_user_group_ids = Internal.immutableCopyOf("mat_user_group_ids", r16);
        this.mmarkdown_ids = Internal.immutableCopyOf("mmarkdown_ids", r17);
    }
}
