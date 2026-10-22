package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TranslateMessageDisplayRule extends com.squareup.wire.Message<TranslateMessageDisplayRule, Builder> {
    public static final ProtoAdapter<TranslateMessageDisplayRule> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DisplayRule mrule;

    public static final class Builder extends com.squareup.wire.Message.Builder<TranslateMessageDisplayRule, Builder> {
        public DisplayRule mrule;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TranslateMessageDisplayRule m1571build() {
            DisplayRule r0 = this.mrule;
            if (r0 == null) goto L7;
            return new TranslateMessageDisplayRule(this.mrule, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mrule"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1571build();
        }

        public Builder rule(DisplayRule r1) {
            this.mrule = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateMessageDisplayRule extends ProtoAdapter<TranslateMessageDisplayRule> {
        public ProtoAdapter_TranslateMessageDisplayRule() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateMessageDisplayRule.class);
        }

        public TranslateMessageDisplayRule decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mrule = (DisplayRule) DisplayRule.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L12:
            r9.endMessage(r1);
            return r0.m1571build();
        }

        public int encodedSize(TranslateMessageDisplayRule r4) {
            return DisplayRule.ADAPTER.encodedSizeWithTag(1, r4.mrule) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1572decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TranslateMessageDisplayRule) r1);
        }

        public void encode(ProtoWriter r4, TranslateMessageDisplayRule r5) throws IOException {
            DisplayRule.ADAPTER.encodeWithTag(r4, 1, r5.mrule);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TranslateMessageDisplayRule) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TranslateMessageDisplayRule();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1570newBuilder() {
        Builder r0 = new Builder();
        r0.mrule = this.mrule;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TranslateMessageDisplayRule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1570newBuilder();
    }

    public TranslateMessageDisplayRule(DisplayRule r2) {
        this(r2, ByteString.EMPTY);
    }

    public TranslateMessageDisplayRule(DisplayRule r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mrule = r2;
    }
}
