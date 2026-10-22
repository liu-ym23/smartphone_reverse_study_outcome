package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesGetI18nTemplatesRequest extends Message<MinutesGetI18nTemplatesRequest, Builder> {
    public static final ProtoAdapter<MinutesGetI18nTemplatesRequest> ADAPTER = null;
    public static final ProtoAdapter_MinutesGetI18nTemplatesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> keys;

    public static final class Builder extends Message.Builder<MinutesGetI18nTemplatesRequest, Builder> implements d<MinutesGetI18nTemplatesRequest> {
        public List<String> keys;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesGetI18nTemplatesRequest m1841build() {
            return new MinutesGetI18nTemplatesRequest(this.keys, super.buildUnknownFields());
        }

        public Builder() {
            this.keys = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1841build();
        }

        public Builder keys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.keys = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesGetI18nTemplatesRequest extends ProtoAdapter<MinutesGetI18nTemplatesRequest> implements c<MinutesGetI18nTemplatesRequest> {
        public ProtoAdapter_MinutesGetI18nTemplatesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesGetI18nTemplatesRequest.class);
        }

        public MinutesGetI18nTemplatesRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.keys.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1841build();
        }

        public int encodedSize(MinutesGetI18nTemplatesRequest r4) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.keys) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1842decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesGetI18nTemplatesRequest) r1);
        }

        public void encode(ProtoWriter r4, MinutesGetI18nTemplatesRequest r5) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.keys);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesGetI18nTemplatesRequest) r2);
        }
    }

    static {
        ProtoAdapter_MinutesGetI18nTemplatesRequest r0 = new ProtoAdapter_MinutesGetI18nTemplatesRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1840newBuilder() {
        Builder r0 = new Builder();
        r0.keys = Internal.copyOf("keys", this.keys);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesGetI18nTemplatesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1840newBuilder();
    }

    public MinutesGetI18nTemplatesRequest(List<String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MinutesGetI18nTemplatesRequest(List<String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.keys = Internal.immutableCopyOf("keys", r2);
    }
}
