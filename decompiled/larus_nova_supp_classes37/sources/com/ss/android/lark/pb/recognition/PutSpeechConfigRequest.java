package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutSpeechConfigRequest extends Message<PutSpeechConfigRequest, Builder> {
    public static final ProtoAdapter<PutSpeechConfigRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE_FORMAT = null;
    public static final String DEFAULT_MANUAL_CONF_LANG = "";
    public static final String DEFAULT_REQUEST_NO = "";
    public static final Integer DEFAULT_SPEECH_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Boolean menable_format;
    public final String mmanual_conf_lang;
    public final String mrequest_no;
    public final Integer mspeech_version;

    public static final class Builder extends Message.Builder<PutSpeechConfigRequest, Builder> {
        public Boolean menable_format;
        public String mmanual_conf_lang;
        public String mrequest_no;
        public Integer mspeech_version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutSpeechConfigRequest m2090build() {
            return new PutSpeechConfigRequest(this.mrequest_no, this.mmanual_conf_lang, this.mspeech_version, this.menable_format, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2090build();
        }

        public Builder enable_format(Boolean r1) {
            this.menable_format = r1;
            return this;
        }

        public Builder manual_conf_lang(String r1) {
            this.mmanual_conf_lang = r1;
            return this;
        }

        public Builder request_no(String r1) {
            this.mrequest_no = r1;
            return this;
        }

        public Builder speech_version(Integer r1) {
            this.mspeech_version = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSpeechConfigRequest extends ProtoAdapter<PutSpeechConfigRequest> {
        public ProtoAdapter_PutSpeechConfigRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSpeechConfigRequest.class);
        }

        public PutSpeechConfigRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mrequest_no = "";
            r0.mmanual_conf_lang = "";
            r0.mspeech_version = 0;
            r0.menable_format = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mrequest_no = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmanual_conf_lang = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mspeech_version = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.menable_format = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2090build();
        }

        public int encodedSize(PutSpeechConfigRequest r6) {
            String r0 = r6.mrequest_no;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mmanual_conf_lang;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mspeech_version;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.menable_format;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2091decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutSpeechConfigRequest) r1);
        }

        public void encode(ProtoWriter r4, PutSpeechConfigRequest r5) throws IOException {
            String r0 = r5.mrequest_no;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mmanual_conf_lang;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mspeech_version;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.menable_format;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutSpeechConfigRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSpeechConfigRequest();
        DEFAULT_SPEECH_VERSION = 0;
        DEFAULT_ENABLE_FORMAT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2089newBuilder() {
        Builder r0 = new Builder();
        r0.mrequest_no = this.mrequest_no;
        r0.mmanual_conf_lang = this.mmanual_conf_lang;
        r0.mspeech_version = this.mspeech_version;
        r0.menable_format = this.menable_format;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutSpeechConfigRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2089newBuilder();
    }

    public PutSpeechConfigRequest(String r7, String r8, Integer r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PutSpeechConfigRequest(String r2, String r3, Integer r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mrequest_no = r2;
        this.mmanual_conf_lang = r3;
        this.mspeech_version = r4;
        this.menable_format = r5;
    }
}
