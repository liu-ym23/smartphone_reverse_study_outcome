package com.ss.android.lark.pb.videochat_my_ai;

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
public final class EmptyStateMaterial extends Message<EmptyStateMaterial, Builder> {
    public static final ProtoAdapter<EmptyStateMaterial> ADAPTER = null;
    public static final String DEFAULT_CREATE_TIME = "";
    public static final String DEFAULT_DURATION = "";
    public static final String DEFAULT_IMAGE_URL = "";
    public static final String DEFAULT_MATERIAL_ID = "";
    public static final String DEFAULT_NOTE_TOKEN = "";
    public static final String DEFAULT_NOTE_URL = "";
    public static final String DEFAULT_SUBTITLE = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String mcreate_time;
    public final String mduration;
    public final List<CustomSummaryGoldenSentences> mgolden_sentences;
    public final String mimage_url;
    public final String mmaterial_id;
    public final String mnote_token;
    public final String mnote_url;
    public final String msubtitle;
    public final String msummary;
    public final String mtitle;

    public static final class Builder extends Message.Builder<EmptyStateMaterial, Builder> {
        public String mcreate_time;
        public String mduration;
        public List<CustomSummaryGoldenSentences> mgolden_sentences;
        public String mimage_url;
        public String mmaterial_id;
        public String mnote_token;
        public String mnote_url;
        public String msubtitle;
        public String msummary;
        public String mtitle;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EmptyStateMaterial m3275build() {
            return new EmptyStateMaterial(this.mmaterial_id, this.mimage_url, this.mtitle, this.msubtitle, this.msummary, this.mgolden_sentences, this.mnote_url, this.mnote_token, this.mcreate_time, this.mduration, super.buildUnknownFields());
        }

        public Builder() {
            this.mgolden_sentences = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3275build();
        }

        public Builder create_time(String r1) {
            this.mcreate_time = r1;
            return this;
        }

        public Builder duration(String r1) {
            this.mduration = r1;
            return this;
        }

        public Builder golden_sentences(List<CustomSummaryGoldenSentences> r1) {
            Internal.checkElementsNotNull(r1);
            this.mgolden_sentences = r1;
            return this;
        }

        public Builder image_url(String r1) {
            this.mimage_url = r1;
            return this;
        }

        public Builder material_id(String r1) {
            this.mmaterial_id = r1;
            return this;
        }

        public Builder note_token(String r1) {
            this.mnote_token = r1;
            return this;
        }

        public Builder note_url(String r1) {
            this.mnote_url = r1;
            return this;
        }

        public Builder subtitle(String r1) {
            this.msubtitle = r1;
            return this;
        }

        public Builder summary(String r1) {
            this.msummary = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EmptyStateMaterial extends ProtoAdapter<EmptyStateMaterial> {
        public ProtoAdapter_EmptyStateMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, EmptyStateMaterial.class);
        }

        public EmptyStateMaterial decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mmaterial_id = "";
            r0.mimage_url = "";
            r0.mtitle = "";
            r0.msubtitle = "";
            r0.msummary = "";
            r0.mnote_url = "";
            r0.mnote_token = "";
            r0.mcreate_time = "";
            r0.mduration = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.mduration = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mcreate_time = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mnote_token = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mnote_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mgolden_sentences.add((CustomSummaryGoldenSentences) CustomSummaryGoldenSentences.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.msummary = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.msubtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            r0.mimage_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L16:
            r0.mmaterial_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r1);
            return r0.m3275build();
        }

        public int encodedSize(EmptyStateMaterial r6) {
            String r0 = r6.mmaterial_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mimage_url;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mtitle;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.msubtitle;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.msummary;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = (r12 + r14) + CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.mgolden_sentences);
            String r16 = r6.mnote_url;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(7, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mnote_token;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(8, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mcreate_time;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(9, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r6.mduration;
            if (r25 == null) goto L38;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(10, r25);
        L38:
            return (r24 + r1) + r6.unknownFields().size();
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ Object m3276decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EmptyStateMaterial) r1);
        }

        public void encode(ProtoWriter r4, EmptyStateMaterial r5) throws IOException {
            String r0 = r5.mmaterial_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mimage_url;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mtitle;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.msubtitle;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.msummary;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.mgolden_sentences);
            String r7 = r5.mnote_url;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r7);
        L20:
            String r8 = r5.mnote_token;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r8);
        L23:
            String r9 = r5.mcreate_time;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 9, r9);
        L26:
            String r10 = r5.mduration;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r10);
        L29:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EmptyStateMaterial) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmptyStateMaterial();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3274newBuilder() {
        Builder r0 = new Builder();
        r0.mmaterial_id = this.mmaterial_id;
        r0.mimage_url = this.mimage_url;
        r0.mtitle = this.mtitle;
        r0.msubtitle = this.msubtitle;
        r0.msummary = this.msummary;
        r0.mgolden_sentences = Internal.copyOf("mgolden_sentences", this.mgolden_sentences);
        r0.mnote_url = this.mnote_url;
        r0.mnote_token = this.mnote_token;
        r0.mcreate_time = this.mcreate_time;
        r0.mduration = this.mduration;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EmptyStateMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3274newBuilder();
    }

    public EmptyStateMaterial(String r13, String r14, String r15, String r16, String r17, List<CustomSummaryGoldenSentences> r18, String r19, String r20, String r21, String r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public EmptyStateMaterial(String r2, String r3, String r4, String r5, String r6, List<CustomSummaryGoldenSentences> r7, String r8, String r9, String r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mmaterial_id = r2;
        this.mimage_url = r3;
        this.mtitle = r4;
        this.msubtitle = r5;
        this.msummary = r6;
        this.mgolden_sentences = Internal.immutableCopyOf("mgolden_sentences", r7);
        this.mnote_url = r8;
        this.mnote_token = r9;
        this.mcreate_time = r10;
        this.mduration = r11;
    }
}
