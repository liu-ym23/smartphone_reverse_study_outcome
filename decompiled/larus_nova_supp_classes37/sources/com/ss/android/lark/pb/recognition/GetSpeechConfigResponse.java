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
public final class GetSpeechConfigResponse extends Message<GetSpeechConfigResponse, Builder> {
    public static final ProtoAdapter<GetSpeechConfigResponse> ADAPTER = null;
    public static final Integer DEFAULT_CODE = null;
    public static final Boolean DEFAULT_ENABLE_FORMAT = null;
    public static final String DEFAULT_MANUAL_CONF_LANG = "";
    public static final Integer DEFAULT_SPEECH_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Integer mcode;
    public final Boolean menable_format;
    public final String mmanual_conf_lang;
    public final Integer mspeech_version;
    public final List<SpeechLang> msupport_lang_list;
    public final List<String> msupport_langs;

    public static final class Builder extends Message.Builder<GetSpeechConfigResponse, Builder> {
        public Integer mcode;
        public Boolean menable_format;
        public String mmanual_conf_lang;
        public Integer mspeech_version;
        public List<SpeechLang> msupport_lang_list;
        public List<String> msupport_langs;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSpeechConfigResponse m2087build() {
            return new GetSpeechConfigResponse(this.mcode, this.mmanual_conf_lang, this.msupport_langs, this.msupport_lang_list, this.mspeech_version, this.menable_format, super.buildUnknownFields());
        }

        public Builder() {
            this.msupport_langs = Internal.newMutableList();
            this.msupport_lang_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2087build();
        }

        public Builder code(Integer r1) {
            this.mcode = r1;
            return this;
        }

        public Builder enable_format(Boolean r1) {
            this.menable_format = r1;
            return this;
        }

        public Builder manual_conf_lang(String r1) {
            this.mmanual_conf_lang = r1;
            return this;
        }

        public Builder speech_version(Integer r1) {
            this.mspeech_version = r1;
            return this;
        }

        public Builder support_lang_list(List<SpeechLang> r1) {
            Internal.checkElementsNotNull(r1);
            this.msupport_lang_list = r1;
            return this;
        }

        public Builder support_langs(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.msupport_langs = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeechConfigResponse extends ProtoAdapter<GetSpeechConfigResponse> {
        public ProtoAdapter_GetSpeechConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeechConfigResponse.class);
        }

        public GetSpeechConfigResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcode = 0;
            r0.mmanual_conf_lang = "";
            r0.mspeech_version = 0;
            r0.menable_format = Boolean.TRUE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.menable_format = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mspeech_version = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L9:
            r0.msupport_lang_list.add((SpeechLang) SpeechLang.ADAPTER.decode(r7));
            goto L3
        L10:
            r0.msupport_langs.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.mmanual_conf_lang = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mcode = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m2087build();
        }

        public int encodedSize(GetSpeechConfigResponse r6) {
            Integer r0 = r6.mcode;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mmanual_conf_lang;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = ((r2 + r4) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r6.msupport_langs)) + SpeechLang.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.msupport_lang_list);
            Integer r7 = r6.mspeech_version;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(5, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.menable_format;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r10);
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
        public /* bridge */ /* synthetic */ Object m2088decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSpeechConfigResponse) r1);
        }

        public void encode(ProtoWriter r4, GetSpeechConfigResponse r5) throws IOException {
            Integer r0 = r5.mcode;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mmanual_conf_lang;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 3, r5.msupport_langs);
            SpeechLang.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.msupport_lang_list);
            Integer r2 = r5.mspeech_version;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r2);
        L11:
            Boolean r3 = r5.menable_format;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSpeechConfigResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeechConfigResponse();
        DEFAULT_CODE = 0;
        DEFAULT_SPEECH_VERSION = 0;
        DEFAULT_ENABLE_FORMAT = Boolean.TRUE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2086newBuilder() {
        Builder r0 = new Builder();
        r0.mcode = this.mcode;
        r0.mmanual_conf_lang = this.mmanual_conf_lang;
        r0.msupport_langs = Internal.copyOf("msupport_langs", this.msupport_langs);
        r0.msupport_lang_list = Internal.copyOf("msupport_lang_list", this.msupport_lang_list);
        r0.mspeech_version = this.mspeech_version;
        r0.menable_format = this.menable_format;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSpeechConfigResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2086newBuilder();
    }

    public GetSpeechConfigResponse(Integer r9, String r10, List<String> r11, List<SpeechLang> r12, Integer r13, Boolean r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public GetSpeechConfigResponse(Integer r2, String r3, List<String> r4, List<SpeechLang> r5, Integer r6, Boolean r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mcode = r2;
        this.mmanual_conf_lang = r3;
        this.msupport_langs = Internal.immutableCopyOf("msupport_langs", r4);
        this.msupport_lang_list = Internal.immutableCopyOf("msupport_lang_list", r5);
        this.mspeech_version = r6;
        this.menable_format = r7;
    }
}
