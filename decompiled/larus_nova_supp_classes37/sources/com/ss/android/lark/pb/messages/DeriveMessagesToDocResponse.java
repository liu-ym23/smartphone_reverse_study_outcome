package com.ss.android.lark.pb.messages;

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
public final class DeriveMessagesToDocResponse extends Message<DeriveMessagesToDocResponse, Builder> {
    public static final ProtoAdapter<DeriveMessagesToDocResponse> ADAPTER = null;
    public static final String DEFAULT_DOCUMENT_TOKEN = "";
    public static final String DEFAULT_DOC_TITLE = "";
    public static final String DEFAULT_DOC_URL = "";
    private static final long serialVersionUID = 0;
    public final List<Long> mderive_message_ids;
    public final String mdoc_title;
    public final String mdoc_url;
    public final String mdocument_token;
    public final List<Long> mrestricted_message_ids;

    public static final class Builder extends Message.Builder<DeriveMessagesToDocResponse, Builder> {
        public List<Long> mderive_message_ids;
        public String mdoc_title;
        public String mdoc_url;
        public String mdocument_token;
        public List<Long> mrestricted_message_ids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DeriveMessagesToDocResponse m1799build() {
            return new DeriveMessagesToDocResponse(this.mdoc_url, this.mdoc_title, this.mdocument_token, this.mderive_message_ids, this.mrestricted_message_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mderive_message_ids = Internal.newMutableList();
            this.mrestricted_message_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1799build();
        }

        public Builder derive_message_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mderive_message_ids = r1;
            return this;
        }

        public Builder doc_title(String r1) {
            this.mdoc_title = r1;
            return this;
        }

        public Builder doc_url(String r1) {
            this.mdoc_url = r1;
            return this;
        }

        public Builder document_token(String r1) {
            this.mdocument_token = r1;
            return this;
        }

        public Builder restricted_message_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mrestricted_message_ids = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DeriveMessagesToDocResponse extends ProtoAdapter<DeriveMessagesToDocResponse> {
        public ProtoAdapter_DeriveMessagesToDocResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DeriveMessagesToDocResponse.class);
        }

        public DeriveMessagesToDocResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdoc_url = "";
            r0.mdoc_title = "";
            r0.mdocument_token = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mdoc_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mdoc_title = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mdocument_token = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mderive_message_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mrestricted_message_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1799build();
        }

        public int encodedSize(DeriveMessagesToDocResponse r6) {
            String r0 = r6.mdoc_url;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mdoc_title;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mdocument_token;
            if (r7 == null) goto L13;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L13:
            int r8 = r5 + r1;
            ProtoAdapter r9 = ProtoAdapter.INT64;
            return ((r8 + r9.asRepeated().encodedSizeWithTag(4, r6.mderive_message_ids)) + r9.asRepeated().encodedSizeWithTag(5, r6.mrestricted_message_ids)) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1800decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DeriveMessagesToDocResponse) r1);
        }

        public void encode(ProtoWriter r5, DeriveMessagesToDocResponse r6) throws IOException {
            String r0 = r6.mdoc_url;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
        L5:
            String r1 = r6.mdoc_title;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r1);
        L8:
            String r2 = r6.mdocument_token;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r5, 3, r2);
        L11:
            ProtoAdapter r3 = ProtoAdapter.INT64;
            r3.asRepeated().encodeWithTag(r5, 4, r6.mderive_message_ids);
            r3.asRepeated().encodeWithTag(r5, 5, r6.mrestricted_message_ids);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DeriveMessagesToDocResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeriveMessagesToDocResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1798newBuilder() {
        Builder r0 = new Builder();
        r0.mdoc_url = this.mdoc_url;
        r0.mdoc_title = this.mdoc_title;
        r0.mdocument_token = this.mdocument_token;
        r0.mderive_message_ids = Internal.copyOf("mderive_message_ids", this.mderive_message_ids);
        r0.mrestricted_message_ids = Internal.copyOf("mrestricted_message_ids", this.mrestricted_message_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DeriveMessagesToDocResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1798newBuilder();
    }

    public DeriveMessagesToDocResponse(String r8, String r9, String r10, List<Long> r11, List<Long> r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public DeriveMessagesToDocResponse(String r2, String r3, String r4, List<Long> r5, List<Long> r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mdoc_url = r2;
        this.mdoc_title = r3;
        this.mdocument_token = r4;
        this.mderive_message_ids = Internal.immutableCopyOf("mderive_message_ids", r5);
        this.mrestricted_message_ids = Internal.immutableCopyOf("mrestricted_message_ids", r6);
    }
}
