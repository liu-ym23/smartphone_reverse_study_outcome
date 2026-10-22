package com.ss.android.lark.pb.usearch;

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
public final class OncallMeta extends Message<OncallMeta, Builder> {
    public static final ProtoAdapter<OncallMeta> ADAPTER = null;
    public static final String DEFAULT_FAQ_ID = "";
    public static final String DEFAULT_FAQ_TITLE = "";
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mfaq_id;
    public final String mfaq_title;
    public final String mid;
    public final List<Integer> mtags;

    public static final class Builder extends Message.Builder<OncallMeta, Builder> {
        public String mfaq_id;
        public String mfaq_title;
        public String mid;
        public List<Integer> mtags;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public OncallMeta m2735build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new OncallMeta(this.mid, this.mtags, this.mfaq_id, this.mfaq_title, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
            this.mtags = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2735build();
        }

        public Builder faq_id(String r1) {
            this.mfaq_id = r1;
            return this;
        }

        public Builder faq_title(String r1) {
            this.mfaq_title = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder tags(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtags = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_OncallMeta extends ProtoAdapter<OncallMeta> {
        public ProtoAdapter_OncallMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, OncallMeta.class);
        }

        public OncallMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mfaq_id = "";
            r0.mfaq_title = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtags.add((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mfaq_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mfaq_title = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2735build();
        }

        public int encodedSize(OncallMeta r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mid) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r6.mtags);
            String r2 = r6.mfaq_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(3, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.mfaq_title;
            if (r7 == null) goto L10;
            r3 = r0.encodedSizeWithTag(4, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2736decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((OncallMeta) r1);
        }

        public void encode(ProtoWriter r5, OncallMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r5, 2, r6.mtags);
            String r1 = r6.mfaq_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 3, r1);
        L5:
            String r2 = r6.mfaq_title;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 4, r2);
        L8:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (OncallMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OncallMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2734newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtags = Internal.copyOf("mtags", this.mtags);
        r0.mfaq_id = this.mfaq_id;
        r0.mfaq_title = this.mfaq_title;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return OncallMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2734newBuilder();
    }

    public OncallMeta(String r7, List<Integer> r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public OncallMeta(String r2, List<Integer> r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mid = r2;
        this.mtags = Internal.immutableCopyOf("mtags", r3);
        this.mfaq_id = r4;
        this.mfaq_title = r5;
    }
}
