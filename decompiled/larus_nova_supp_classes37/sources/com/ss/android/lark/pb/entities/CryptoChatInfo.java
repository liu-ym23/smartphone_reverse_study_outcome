package com.ss.android.lark.pb.entities;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.annotation.Debug;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CryptoChatInfo extends com.squareup.wire.Message<CryptoChatInfo, Builder> {
    public static final ProtoAdapter<CryptoChatInfo> ADAPTER = null;
    public static final Integer DEFAULT_FIRST_POSITION = null;
    public static final Integer DEFAULT_FIRST_POSITION_BADGE_COUNT = null;
    public static final FieldOptions FIELD_OPTIONS_MFIRST_POSITION = null;
    public static final FieldOptions FIELD_OPTIONS_MFIRST_POSITION_BADGE_COUNT = null;
    private static final long serialVersionUID = 0;
    public final Integer mfirst_position;
    public final Integer mfirst_position_badge_count;

    public static final class Builder extends com.squareup.wire.Message.Builder<CryptoChatInfo, Builder> {
        public Integer mfirst_position;
        public Integer mfirst_position_badge_count;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CryptoChatInfo m1187build() {
            return new CryptoChatInfo(this.mfirst_position, this.mfirst_position_badge_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1187build();
        }

        public Builder first_position(Integer r1) {
            this.mfirst_position = r1;
            return this;
        }

        public Builder first_position_badge_count(Integer r1) {
            this.mfirst_position_badge_count = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CryptoChatInfo extends ProtoAdapter<CryptoChatInfo> {
        public ProtoAdapter_CryptoChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoChatInfo.class);
        }

        public CryptoChatInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mfirst_position = 0;
            r0.mfirst_position_badge_count = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mfirst_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mfirst_position_badge_count = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1187build();
        }

        public int encodedSize(CryptoChatInfo r5) {
            Integer r0 = r5.mfirst_position;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r5.mfirst_position_badge_count;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1188decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CryptoChatInfo) r1);
        }

        public void encode(ProtoWriter r4, CryptoChatInfo r5) throws IOException {
            Integer r0 = r5.mfirst_position;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mfirst_position_badge_count;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CryptoChatInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoChatInfo();
        FIELD_OPTIONS_MFIRST_POSITION = new FieldOptions.Builder().debug(new Debug.Builder().m815build()).build();
        FIELD_OPTIONS_MFIRST_POSITION_BADGE_COUNT = new FieldOptions.Builder().debug(new Debug.Builder().m815build()).build();
        DEFAULT_FIRST_POSITION = 0;
        DEFAULT_FIRST_POSITION_BADGE_COUNT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1186newBuilder() {
        Builder r0 = new Builder();
        r0.mfirst_position = this.mfirst_position;
        r0.mfirst_position_badge_count = this.mfirst_position_badge_count;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CryptoChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1186newBuilder();
    }

    public CryptoChatInfo(Integer r2, Integer r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CryptoChatInfo(Integer r2, Integer r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mfirst_position = r2;
        this.mfirst_position_badge_count = r3;
    }
}
