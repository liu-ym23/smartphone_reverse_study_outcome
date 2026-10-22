package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SpeechRecognitionReportEditRequest extends Message<SpeechRecognitionReportEditRequest, Builder> {
    public static final ProtoAdapter<SpeechRecognitionReportEditRequest> ADAPTER = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_TEXT_EDIT = "";
    public static final String DEFAULT_TEXT_INIT = "";
    public static final String DEFAULT_TEXT_ORIGIN = "";
    private static final long serialVersionUID = 0;
    public final List<SpeechRecognitionReportEditItem> mitems;
    public final Scene mscene;
    public final String msource_id;
    public final String mtext_edit;
    public final String mtext_init;
    public final String mtext_origin;

    public static final class Builder extends Message.Builder<SpeechRecognitionReportEditRequest, Builder> {
        public List<SpeechRecognitionReportEditItem> mitems;
        public Scene mscene;
        public String msource_id;
        public String mtext_edit;
        public String mtext_init;
        public String mtext_origin;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SpeechRecognitionReportEditRequest m2111build() {
            return new SpeechRecognitionReportEditRequest(this.msource_id, this.mtext_origin, this.mtext_edit, this.mitems, this.mscene, this.mtext_init, super.buildUnknownFields());
        }

        public Builder() {
            this.mitems = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2111build();
        }

        public Builder items(List<SpeechRecognitionReportEditItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mitems = r1;
            return this;
        }

        public Builder scene(Scene r1) {
            this.mscene = r1;
            return this;
        }

        public Builder source_id(String r1) {
            this.msource_id = r1;
            return this;
        }

        public Builder text_edit(String r1) {
            this.mtext_edit = r1;
            return this;
        }

        public Builder text_init(String r1) {
            this.mtext_init = r1;
            return this;
        }

        public Builder text_origin(String r1) {
            this.mtext_origin = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionReportEditRequest extends ProtoAdapter<SpeechRecognitionReportEditRequest> {
        public ProtoAdapter_SpeechRecognitionReportEditRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionReportEditRequest.class);
        }

        public SpeechRecognitionReportEditRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.msource_id = "";
            r0.mtext_origin = "";
            r0.mtext_edit = "";
            r0.mtext_init = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r0.mscene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mtext_init = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mitems.add((SpeechRecognitionReportEditItem) SpeechRecognitionReportEditItem.ADAPTER.decode(r9));
            goto L3
        L13:
            r0.mtext_edit = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mtext_origin = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.msource_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r1);
            return r0.m2111build();
        }

        public int encodedSize(SpeechRecognitionReportEditRequest r6) {
            String r0 = r6.msource_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtext_origin;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mtext_edit;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = (r5 + r8) + SpeechRecognitionReportEditItem.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mitems);
            Scene r10 = r6.mscene;
            if (r10 == null) goto L17;
            int r11 = Scene.ADAPTER.encodedSizeWithTag(5, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mtext_init;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2112decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SpeechRecognitionReportEditRequest) r1);
        }

        public void encode(ProtoWriter r4, SpeechRecognitionReportEditRequest r5) throws IOException {
            String r0 = r5.msource_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtext_origin;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mtext_edit;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            SpeechRecognitionReportEditItem.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mitems);
            Scene r3 = r5.mscene;
            if (r3 == null) goto L14;
            Scene.ADAPTER.encodeWithTag(r4, 5, r3);
        L14:
            String r6 = r5.mtext_init;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SpeechRecognitionReportEditRequest) r2);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene ADVANCED = null;
        public static final Scene BUBBLE = null;
        public static final Scene PC = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r0 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Scene r1 = new Scene("BUBBLE", 1, 1);
            BUBBLE = r1;
            Scene r3 = new Scene("ADVANCED", 2, 2);
            ADVANCED = r3;
            Scene r5 = new Scene("PC", 3, 3);
            PC = r5;
            $VALUES = new Scene[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return PC;
        L14:
            return ADVANCED;
        L16:
            return BUBBLE;
        L18:
            return UNKNOWN;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        private Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionReportEditRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2110newBuilder() {
        Builder r0 = new Builder();
        r0.msource_id = this.msource_id;
        r0.mtext_origin = this.mtext_origin;
        r0.mtext_edit = this.mtext_edit;
        r0.mitems = Internal.copyOf("mitems", this.mitems);
        r0.mscene = this.mscene;
        r0.mtext_init = this.mtext_init;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SpeechRecognitionReportEditRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2110newBuilder();
    }

    public SpeechRecognitionReportEditRequest(String r9, String r10, String r11, List<SpeechRecognitionReportEditItem> r12, Scene r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public SpeechRecognitionReportEditRequest(String r2, String r3, String r4, List<SpeechRecognitionReportEditItem> r5, Scene r6, String r7, ByteString r8) {
        super(ADAPTER, r8);
        this.msource_id = r2;
        this.mtext_origin = r3;
        this.mtext_edit = r4;
        this.mitems = Internal.immutableCopyOf("mitems", r5);
        this.mscene = r6;
        this.mtext_init = r7;
    }
}
