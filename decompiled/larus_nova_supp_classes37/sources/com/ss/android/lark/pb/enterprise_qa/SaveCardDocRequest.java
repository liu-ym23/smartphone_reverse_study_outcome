package com.ss.android.lark.pb.enterprise_qa;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SaveCardDocRequest extends Message<SaveCardDocRequest, Builder> {
    public static final ProtoAdapter<SaveCardDocRequest> ADAPTER = null;
    public static final Integer DEFAULT_ASK_SCENE = null;
    public static final String DEFAULT_CARD_KEY = "";
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final String DEFAULT_IDENTIFIER_ID = "";
    public static final Integer DEFAULT_SELECTED_ANSWER_INDEX = null;
    public static final String DEFAULT_TOPIC_ID = "";
    public static final String DEFAULT_WIKI_SPACE_ID = "";
    private static final long serialVersionUID = 0;
    public final AnswerType manswer_type;
    public final Integer mask_scene;
    public final String mcard_key;
    public final String mdoc_token;
    public final String midentifier_id;
    public final Integer mselected_answer_index;
    public final String mtopic_id;
    public final String mwiki_space_id;

    public static final enum AnswerType extends Enum<AnswerType> implements WireEnum {
        private static final /* synthetic */ AnswerType[] $VALUES = null;
        public static final ProtoAdapter<AnswerType> ADAPTER = null;
        public static final AnswerType CANVAS = null;
        public static final AnswerType CARD = null;
        public static final AnswerType UNKNOWN = null;
        private final int value;

        static {
            AnswerType r0 = new AnswerType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AnswerType r1 = new AnswerType("CARD", 1, 1);
            CARD = r1;
            AnswerType r3 = new AnswerType("CANVAS", 2, 2);
            CANVAS = r3;
            $VALUES = new AnswerType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(AnswerType.class);
        }

        public static AnswerType[] values() {
            return (AnswerType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AnswerType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return CANVAS;
        L12:
            return CARD;
        L14:
            return UNKNOWN;
        }

        public static AnswerType valueOf(String r1) {
            return (AnswerType) a.a(AnswerType.class, r1);
        }

        private AnswerType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<SaveCardDocRequest, Builder> {
        public AnswerType manswer_type;
        public Integer mask_scene;
        public String mcard_key;
        public String mdoc_token;
        public String midentifier_id;
        public Integer mselected_answer_index;
        public String mtopic_id;
        public String mwiki_space_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SaveCardDocRequest m989build() {
            return new SaveCardDocRequest(this.mcard_key, this.mask_scene, this.mwiki_space_id, this.midentifier_id, this.mtopic_id, this.manswer_type, this.mdoc_token, this.mselected_answer_index, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m989build();
        }

        public Builder answer_type(AnswerType r1) {
            this.manswer_type = r1;
            return this;
        }

        public Builder ask_scene(Integer r1) {
            this.mask_scene = r1;
            return this;
        }

        public Builder card_key(String r1) {
            this.mcard_key = r1;
            return this;
        }

        public Builder doc_token(String r1) {
            this.mdoc_token = r1;
            return this;
        }

        public Builder identifier_id(String r1) {
            this.midentifier_id = r1;
            return this;
        }

        public Builder selected_answer_index(Integer r1) {
            this.mselected_answer_index = r1;
            return this;
        }

        public Builder topic_id(String r1) {
            this.mtopic_id = r1;
            return this;
        }

        public Builder wiki_space_id(String r1) {
            this.mwiki_space_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SaveCardDocRequest extends ProtoAdapter<SaveCardDocRequest> {
        public ProtoAdapter_SaveCardDocRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveCardDocRequest.class);
        }

        public SaveCardDocRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcard_key = "";
            r0.mask_scene = 0;
            r0.mwiki_space_id = "";
            r0.midentifier_id = "";
            r0.mtopic_id = "";
            r0.mdoc_token = "";
            r0.mselected_answer_index = 0;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L20;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r0.manswer_type = (AnswerType) AnswerType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mselected_answer_index = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L8:
            r0.mdoc_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mtopic_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.midentifier_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mwiki_space_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mask_scene = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L17:
            r0.mcard_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m989build();
        }

        public int encodedSize(SaveCardDocRequest r6) {
            String r0 = r6.mcard_key;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.mask_scene;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mwiki_space_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.midentifier_id;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mtopic_id;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            AnswerType r16 = r6.manswer_type;
            if (r16 == null) goto L25;
            int r17 = AnswerType.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mdoc_token;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Integer r22 = r6.mselected_answer_index;
            if (r22 == null) goto L34;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(8, r22);
        L34:
            return (r21 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m990decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SaveCardDocRequest) r1);
        }

        public void encode(ProtoWriter r4, SaveCardDocRequest r5) throws IOException {
            String r0 = r5.mcard_key;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mask_scene;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mwiki_space_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.midentifier_id;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mtopic_id;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            AnswerType r7 = r5.manswer_type;
            if (r7 == null) goto L20;
            AnswerType.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mdoc_token;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            Integer r9 = r5.mselected_answer_index;
            if (r9 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r4, 8, r9);
        L26:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SaveCardDocRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SaveCardDocRequest();
        DEFAULT_ASK_SCENE = 0;
        DEFAULT_SELECTED_ANSWER_INDEX = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m988newBuilder() {
        Builder r0 = new Builder();
        r0.mcard_key = this.mcard_key;
        r0.mask_scene = this.mask_scene;
        r0.mwiki_space_id = this.mwiki_space_id;
        r0.midentifier_id = this.midentifier_id;
        r0.mtopic_id = this.mtopic_id;
        r0.manswer_type = this.manswer_type;
        r0.mdoc_token = this.mdoc_token;
        r0.mselected_answer_index = this.mselected_answer_index;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SaveCardDocRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m988newBuilder();
    }

    public SaveCardDocRequest(String r11, Integer r12, String r13, String r14, String r15, AnswerType r16, String r17, Integer r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public SaveCardDocRequest(String r2, Integer r3, String r4, String r5, String r6, AnswerType r7, String r8, Integer r9, ByteString r10) {
        super(ADAPTER, r10);
        this.mcard_key = r2;
        this.mask_scene = r3;
        this.mwiki_space_id = r4;
        this.midentifier_id = r5;
        this.mtopic_id = r6;
        this.manswer_type = r7;
        this.mdoc_token = r8;
        this.mselected_answer_index = r9;
    }
}
