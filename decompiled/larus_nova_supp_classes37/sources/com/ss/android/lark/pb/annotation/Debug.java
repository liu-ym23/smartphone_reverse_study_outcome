package com.ss.android.lark.pb.annotation;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Debug extends Message<Debug, Builder> {
    public static final ProtoAdapter<Debug> ADAPTER = null;
    public static final Boolean DEFAULT_LEN = null;
    public static final Integer DEFAULT_TRUNCATE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mlen;
    public final Integer mtruncate;

    public static final class Builder extends Message.Builder<Debug, Builder> {
        public Boolean mlen;
        public Integer mtruncate;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Debug m815build() {
            return new Debug(this.mtruncate, this.mlen, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m815build();
        }

        public Builder len(Boolean r1) {
            this.mlen = r1;
            return this;
        }

        public Builder truncate(Integer r1) {
            this.mtruncate = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Debug extends ProtoAdapter<Debug> {
        public ProtoAdapter_Debug() {
            super(FieldEncoding.LENGTH_DELIMITED, Debug.class);
        }

        public Debug decode(ProtoReader r8) throws IOException {
            Builder r0 = new Builder();
            r0.mtruncate = 2;
            r0.mlen = Boolean.FALSE;
            long r2 = r8.beginMessage();
        L3:
            int r4 = r8.nextTag();
            if (r4 == (-1)) goto L11;
            if (r4 != 1) goto L7;
            r0.mtruncate = (Integer) ProtoAdapter.UINT32.decode(r8);
            goto L3
        L7:
            if (r4 != 2) goto L8;
            r0.mlen = (Boolean) ProtoAdapter.BOOL.decode(r8);
            goto L3
        L8:
            FieldEncoding r5 = r8.peekFieldEncoding();
            r0.addUnknownField(r4, r5, r5.rawProtoAdapter().decode(r8));
            goto L3
        L11:
            r8.endMessage(r2);
            return r0.m815build();
        }

        public int encodedSize(Debug r5) {
            Integer r0 = r5.mtruncate;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.UINT32.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r5.mlen;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m816decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Debug) r1);
        }

        public void encode(ProtoWriter r4, Debug r5) throws IOException {
            Integer r0 = r5.mtruncate;
            if (r0 == null) goto L5;
            ProtoAdapter.UINT32.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mlen;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Debug) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Debug();
        DEFAULT_TRUNCATE = 2;
        DEFAULT_LEN = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m814newBuilder() {
        Builder r0 = new Builder();
        r0.mtruncate = this.mtruncate;
        r0.mlen = this.mlen;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Debug.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m814newBuilder();
    }

    public Debug(Integer r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Debug(Integer r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtruncate = r2;
        this.mlen = r3;
    }
}
