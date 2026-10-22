package com.ss.android.lark.pb.recognition;

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
public final class SpeechRecognitionFeedbackRequest extends Message<SpeechRecognitionFeedbackRequest, Builder> {
    public static final ProtoAdapter<SpeechRecognitionFeedbackRequest> ADAPTER = null;
    public static final String DEFAULT_CLIENT_RESULT = "";
    public static final String DEFAULT_DESC = "";
    public static final ByteString DEFAULT_ORIGIN_AUDIO_DATA = null;
    public static final String DEFAULT_ORIGIN_AUDIO_TYPE = "";
    public static final String DEFAULT_SOURCE_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> mbutton_desc;
    public final String mclient_result;
    public final String mdesc;
    public final List<SpeechRecognitionFeedbackItem> mitems;
    public final ByteString morigin_audio_data;
    public final String morigin_audio_type;
    public final String msource_id;

    public static final class Builder extends Message.Builder<SpeechRecognitionFeedbackRequest, Builder> {
        public List<String> mbutton_desc;
        public String mclient_result;
        public String mdesc;
        public List<SpeechRecognitionFeedbackItem> mitems;
        public ByteString morigin_audio_data;
        public String morigin_audio_type;
        public String msource_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SpeechRecognitionFeedbackRequest m2102build() {
            return new SpeechRecognitionFeedbackRequest(this.msource_id, this.mdesc, this.mbutton_desc, this.mclient_result, this.morigin_audio_type, this.morigin_audio_data, this.mitems, super.buildUnknownFields());
        }

        public Builder() {
            this.mbutton_desc = Internal.newMutableList();
            this.mitems = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2102build();
        }

        public Builder button_desc(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbutton_desc = r1;
            return this;
        }

        public Builder client_result(String r1) {
            this.mclient_result = r1;
            return this;
        }

        public Builder desc(String r1) {
            this.mdesc = r1;
            return this;
        }

        public Builder items(List<SpeechRecognitionFeedbackItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mitems = r1;
            return this;
        }

        public Builder origin_audio_data(ByteString r1) {
            this.morigin_audio_data = r1;
            return this;
        }

        public Builder origin_audio_type(String r1) {
            this.morigin_audio_type = r1;
            return this;
        }

        public Builder source_id(String r1) {
            this.msource_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionFeedbackRequest extends ProtoAdapter<SpeechRecognitionFeedbackRequest> {
        public ProtoAdapter_SpeechRecognitionFeedbackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionFeedbackRequest.class);
        }

        public SpeechRecognitionFeedbackRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msource_id = "";
            r0.mdesc = "";
            r0.mclient_result = "";
            r0.morigin_audio_type = "";
            r0.morigin_audio_data = ByteString.EMPTY;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.mitems.add((SpeechRecognitionFeedbackItem) SpeechRecognitionFeedbackItem.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.morigin_audio_data = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L9:
            r0.morigin_audio_type = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mclient_result = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mbutton_desc.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.mdesc = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.msource_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m2102build();
        }

        public int encodedSize(SpeechRecognitionFeedbackRequest r7) {
            String r0 = r7.msource_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r7.mdesc;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ProtoAdapter r6 = ProtoAdapter.STRING;
            int r8 = r5 + r6.asRepeated().encodedSizeWithTag(3, r7.mbutton_desc);
            String r9 = r7.mclient_result;
            if (r9 == null) goto L13;
            int r10 = r6.encodedSizeWithTag(4, r9);
        L14:
            int r11 = r8 + r10;
            String r12 = r7.morigin_audio_type;
            if (r12 == null) goto L17;
            int r13 = r6.encodedSizeWithTag(5, r12);
        L18:
            int r14 = r11 + r13;
            ByteString r15 = r7.morigin_audio_data;
            if (r15 == null) goto L22;
            r1 = ProtoAdapter.BYTES.encodedSizeWithTag(6, r15);
        L22:
            return ((r14 + r1) + SpeechRecognitionFeedbackItem.ADAPTER.asRepeated().encodedSizeWithTag(7, r7.mitems)) + r7.unknownFields().size();
        L17:
            r13 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2103decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SpeechRecognitionFeedbackRequest) r1);
        }

        public void encode(ProtoWriter r5, SpeechRecognitionFeedbackRequest r6) throws IOException {
            String r0 = r6.msource_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
        L5:
            String r1 = r6.mdesc;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r1);
        L8:
            ProtoAdapter r2 = ProtoAdapter.STRING;
            r2.asRepeated().encodeWithTag(r5, 3, r6.mbutton_desc);
            String r3 = r6.mclient_result;
            if (r3 == null) goto L11;
            r2.encodeWithTag(r5, 4, r3);
        L11:
            String r4 = r6.morigin_audio_type;
            if (r4 == null) goto L14;
            r2.encodeWithTag(r5, 5, r4);
        L14:
            ByteString r7 = r6.morigin_audio_data;
            if (r7 == null) goto L17;
            ProtoAdapter.BYTES.encodeWithTag(r5, 6, r7);
        L17:
            SpeechRecognitionFeedbackItem.ADAPTER.asRepeated().encodeWithTag(r5, 7, r6.mitems);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SpeechRecognitionFeedbackRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionFeedbackRequest();
        DEFAULT_ORIGIN_AUDIO_DATA = ByteString.EMPTY;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2101newBuilder() {
        Builder r0 = new Builder();
        r0.msource_id = this.msource_id;
        r0.mdesc = this.mdesc;
        r0.mbutton_desc = Internal.copyOf("mbutton_desc", this.mbutton_desc);
        r0.mclient_result = this.mclient_result;
        r0.morigin_audio_type = this.morigin_audio_type;
        r0.morigin_audio_data = this.morigin_audio_data;
        r0.mitems = Internal.copyOf("mitems", this.mitems);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SpeechRecognitionFeedbackRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2101newBuilder();
    }

    public SpeechRecognitionFeedbackRequest(String r10, String r11, List<String> r12, String r13, String r14, ByteString r15, List<SpeechRecognitionFeedbackItem> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public SpeechRecognitionFeedbackRequest(String r2, String r3, List<String> r4, String r5, String r6, ByteString r7, List<SpeechRecognitionFeedbackItem> r8, ByteString r9) {
        super(ADAPTER, r9);
        this.msource_id = r2;
        this.mdesc = r3;
        this.mbutton_desc = Internal.immutableCopyOf("mbutton_desc", r4);
        this.mclient_result = r5;
        this.morigin_audio_type = r6;
        this.morigin_audio_data = r7;
        this.mitems = Internal.immutableCopyOf("mitems", r8);
    }
}
