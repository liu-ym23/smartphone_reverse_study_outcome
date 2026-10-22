package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SpeechRecognitionReportEditItem extends Message<SpeechRecognitionReportEditItem, Builder> {
    public static final ProtoAdapter<SpeechRecognitionReportEditItem> ADAPTER = null;
    public static final String DEFAULT_RECORDING_DEVICE = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_TEXT_ORIGIN = "";
    public static final String DEFAULT_TEXT_SNAPSHOT_AFTER = "";
    public static final String DEFAULT_TEXT_SNAPSHOT_BEFORE = "";
    private static final long serialVersionUID = 0;
    public final String mrecording_device;
    public final String msource_id;
    public final String mtext_origin;
    public final String mtext_snapshot_after;
    public final String mtext_snapshot_before;

    public static final class Builder extends Message.Builder<SpeechRecognitionReportEditItem, Builder> {
        public String mrecording_device;
        public String msource_id;
        public String mtext_origin;
        public String mtext_snapshot_after;
        public String mtext_snapshot_before;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SpeechRecognitionReportEditItem m2108build() {
            return new SpeechRecognitionReportEditItem(this.msource_id, this.mtext_origin, this.mtext_snapshot_before, this.mtext_snapshot_after, this.mrecording_device, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2108build();
        }

        public Builder recording_device(String r1) {
            this.mrecording_device = r1;
            return this;
        }

        public Builder source_id(String r1) {
            this.msource_id = r1;
            return this;
        }

        public Builder text_origin(String r1) {
            this.mtext_origin = r1;
            return this;
        }

        public Builder text_snapshot_after(String r1) {
            this.mtext_snapshot_after = r1;
            return this;
        }

        public Builder text_snapshot_before(String r1) {
            this.mtext_snapshot_before = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionReportEditItem extends ProtoAdapter<SpeechRecognitionReportEditItem> {
        public ProtoAdapter_SpeechRecognitionReportEditItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionReportEditItem.class);
        }

        public SpeechRecognitionReportEditItem decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msource_id = "";
            r0.mtext_origin = "";
            r0.mtext_snapshot_before = "";
            r0.mtext_snapshot_after = "";
            r0.mrecording_device = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.msource_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtext_origin = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mtext_snapshot_before = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mtext_snapshot_after = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mrecording_device = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2108build();
        }

        public int encodedSize(SpeechRecognitionReportEditItem r6) {
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
            String r7 = r6.mtext_snapshot_before;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mtext_snapshot_after;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mrecording_device;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
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
        public /* bridge */ /* synthetic */ Object m2109decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SpeechRecognitionReportEditItem) r1);
        }

        public void encode(ProtoWriter r4, SpeechRecognitionReportEditItem r5) throws IOException {
            String r0 = r5.msource_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtext_origin;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mtext_snapshot_before;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mtext_snapshot_after;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mrecording_device;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SpeechRecognitionReportEditItem) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionReportEditItem();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2107newBuilder() {
        Builder r0 = new Builder();
        r0.msource_id = this.msource_id;
        r0.mtext_origin = this.mtext_origin;
        r0.mtext_snapshot_before = this.mtext_snapshot_before;
        r0.mtext_snapshot_after = this.mtext_snapshot_after;
        r0.mrecording_device = this.mrecording_device;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SpeechRecognitionReportEditItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2107newBuilder();
    }

    public SpeechRecognitionReportEditItem(String r8, String r9, String r10, String r11, String r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public SpeechRecognitionReportEditItem(String r2, String r3, String r4, String r5, String r6, ByteString r7) {
        super(ADAPTER, r7);
        this.msource_id = r2;
        this.mtext_origin = r3;
        this.mtext_snapshot_before = r4;
        this.mtext_snapshot_after = r5;
        this.mrecording_device = r6;
    }
}
