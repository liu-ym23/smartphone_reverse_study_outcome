package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BaikeEntry extends Message<BaikeEntry, Builder> {
    public static final ProtoAdapter<BaikeEntry> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TEXT_HIGHLIGHTED = "";
    private static final long serialVersionUID = 0;
    public final String mid;
    public final String mtext_highlighted;

    public static final class Builder extends Message.Builder<BaikeEntry, Builder> {
        public String mid;
        public String mtext_highlighted;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BaikeEntry m2519build() {
            String r0 = this.mid;
            if (r0 == null) goto L9;
            if (this.mtext_highlighted == null) goto L9;
            return new BaikeEntry(this.mid, this.mtext_highlighted, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mtext_highlighted, "mtext_highlighted"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2519build();
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder text_highlighted(String r1) {
            this.mtext_highlighted = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BaikeEntry extends ProtoAdapter<BaikeEntry> {
        public ProtoAdapter_BaikeEntry() {
            super(FieldEncoding.LENGTH_DELIMITED, BaikeEntry.class);
        }

        public BaikeEntry decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mtext_highlighted = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtext_highlighted = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2519build();
        }

        public int encodedSize(BaikeEntry r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5.mid) + r0.encodedSizeWithTag(2, r5.mtext_highlighted)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2520decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BaikeEntry) r1);
        }

        public void encode(ProtoWriter r4, BaikeEntry r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            r0.encodeWithTag(r4, 2, r5.mtext_highlighted);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BaikeEntry) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BaikeEntry();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2518newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtext_highlighted = this.mtext_highlighted;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BaikeEntry.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2518newBuilder();
    }

    public BaikeEntry(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public BaikeEntry(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mid = r2;
        this.mtext_highlighted = r3;
    }
}
