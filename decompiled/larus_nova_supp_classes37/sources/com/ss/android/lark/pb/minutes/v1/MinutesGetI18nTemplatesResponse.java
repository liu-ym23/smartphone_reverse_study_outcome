package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesGetI18nTemplatesResponse extends Message<MinutesGetI18nTemplatesResponse, Builder> {
    public static final ProtoAdapter<MinutesGetI18nTemplatesResponse> ADAPTER = null;
    public static final ProtoAdapter_MinutesGetI18nTemplatesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> templates;

    public static final class Builder extends Message.Builder<MinutesGetI18nTemplatesResponse, Builder> implements d<MinutesGetI18nTemplatesResponse> {
        public Map<String, String> templates;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesGetI18nTemplatesResponse m1844build() {
            return new MinutesGetI18nTemplatesResponse(this.templates, super.buildUnknownFields());
        }

        public Builder() {
            this.templates = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1844build();
        }

        public Builder templates(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.templates = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesGetI18nTemplatesResponse extends ProtoAdapter<MinutesGetI18nTemplatesResponse> implements c<MinutesGetI18nTemplatesResponse> {
        private final ProtoAdapter<Map<String, String>> templates;

        public ProtoAdapter_MinutesGetI18nTemplatesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesGetI18nTemplatesResponse.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.templates = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public MinutesGetI18nTemplatesResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.templates.putAll((Map) this.templates.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1844build();
        }

        public int encodedSize(MinutesGetI18nTemplatesResponse r4) {
            return this.templates.encodedSizeWithTag(1, r4.templates) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1845decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesGetI18nTemplatesResponse) r1);
        }

        public void encode(ProtoWriter r4, MinutesGetI18nTemplatesResponse r5) throws IOException {
            this.templates.encodeWithTag(r4, 1, r5.templates);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesGetI18nTemplatesResponse) r2);
        }
    }

    static {
        ProtoAdapter_MinutesGetI18nTemplatesResponse r0 = new ProtoAdapter_MinutesGetI18nTemplatesResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1843newBuilder() {
        Builder r0 = new Builder();
        r0.templates = Internal.copyOf("templates", this.templates);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesGetI18nTemplatesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1843newBuilder();
    }

    public MinutesGetI18nTemplatesResponse(Map<String, String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MinutesGetI18nTemplatesResponse(Map<String, String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.templates = Internal.immutableCopyOf("templates", r2);
    }
}
