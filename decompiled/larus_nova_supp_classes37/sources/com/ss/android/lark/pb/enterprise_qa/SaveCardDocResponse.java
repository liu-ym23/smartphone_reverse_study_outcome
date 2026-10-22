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
public final class SaveCardDocResponse extends Message<SaveCardDocResponse, Builder> {
    public static final ProtoAdapter<SaveCardDocResponse> ADAPTER = null;
    public static final String DEFAULT_SAVE_CARD_DOC_LINK = "";
    private static final long serialVersionUID = 0;
    public final DocAction mdoc_action;
    public final String msave_card_doc_link;

    public static final class Builder extends Message.Builder<SaveCardDocResponse, Builder> {
        public DocAction mdoc_action;
        public String msave_card_doc_link;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SaveCardDocResponse m992build() {
            return new SaveCardDocResponse(this.msave_card_doc_link, this.mdoc_action, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m992build();
        }

        public Builder doc_action(DocAction r1) {
            this.mdoc_action = r1;
            return this;
        }

        public Builder save_card_doc_link(String r1) {
            this.msave_card_doc_link = r1;
            return this;
        }
    }

    public static final enum DocAction extends Enum<DocAction> implements WireEnum {
        private static final /* synthetic */ DocAction[] $VALUES = null;
        public static final ProtoAdapter<DocAction> ADAPTER = null;
        public static final DocAction CREATE = null;
        public static final DocAction EDIT = null;
        public static final DocAction UNKNOWN = null;
        public static final DocAction VIEW = null;
        private final int value;

        static {
            DocAction r0 = new DocAction("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            DocAction r1 = new DocAction("CREATE", 1, 1);
            CREATE = r1;
            DocAction r3 = new DocAction("EDIT", 2, 2);
            EDIT = r3;
            DocAction r5 = new DocAction("VIEW", 3, 3);
            VIEW = r5;
            $VALUES = new DocAction[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(DocAction.class);
        }

        public static DocAction[] values() {
            return (DocAction[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DocAction fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return VIEW;
        L14:
            return EDIT;
        L16:
            return CREATE;
        L18:
            return UNKNOWN;
        }

        public static DocAction valueOf(String r1) {
            return (DocAction) a.a(DocAction.class, r1);
        }

        private DocAction(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_SaveCardDocResponse extends ProtoAdapter<SaveCardDocResponse> {
        public ProtoAdapter_SaveCardDocResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveCardDocResponse.class);
        }

        public SaveCardDocResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.msave_card_doc_link = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.msave_card_doc_link = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mdoc_action = (DocAction) DocAction.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
            return r0.m992build();
        }

        public int encodedSize(SaveCardDocResponse r5) {
            String r0 = r5.msave_card_doc_link;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            DocAction r3 = r5.mdoc_action;
            if (r3 == null) goto L10;
            r1 = DocAction.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m993decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SaveCardDocResponse) r1);
        }

        public void encode(ProtoWriter r4, SaveCardDocResponse r5) throws IOException {
            String r0 = r5.msave_card_doc_link;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            DocAction r1 = r5.mdoc_action;
            if (r1 == null) goto L8;
            DocAction.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SaveCardDocResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SaveCardDocResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m991newBuilder() {
        Builder r0 = new Builder();
        r0.msave_card_doc_link = this.msave_card_doc_link;
        r0.mdoc_action = this.mdoc_action;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SaveCardDocResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m991newBuilder();
    }

    public SaveCardDocResponse(String r2, DocAction r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SaveCardDocResponse(String r2, DocAction r3, ByteString r4) {
        super(ADAPTER, r4);
        this.msave_card_doc_link = r2;
        this.mdoc_action = r3;
    }
}
