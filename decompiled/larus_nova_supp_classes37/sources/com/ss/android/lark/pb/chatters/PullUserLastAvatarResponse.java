package com.ss.android.lark.pb.chatters;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullUserLastAvatarResponse extends Message<PullUserLastAvatarResponse, Builder> {
    public static final ProtoAdapter<PullUserLastAvatarResponse> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mavatar_key;

    public static final class Builder extends Message.Builder<PullUserLastAvatarResponse, Builder> {
        public String mavatar_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUserLastAvatarResponse m935build() {
            return new PullUserLastAvatarResponse(this.mavatar_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m935build();
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserLastAvatarResponse extends ProtoAdapter<PullUserLastAvatarResponse> {
        public ProtoAdapter_PullUserLastAvatarResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserLastAvatarResponse.class);
        }

        public PullUserLastAvatarResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mavatar_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m935build();
        }

        public int encodedSize(PullUserLastAvatarResponse r4) {
            String r0 = r4.mavatar_key;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m936decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUserLastAvatarResponse) r1);
        }

        public void encode(ProtoWriter r4, PullUserLastAvatarResponse r5) throws IOException {
            String r0 = r5.mavatar_key;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUserLastAvatarResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserLastAvatarResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m934newBuilder() {
        Builder r0 = new Builder();
        r0.mavatar_key = this.mavatar_key;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUserLastAvatarResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m934newBuilder();
    }

    public PullUserLastAvatarResponse(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullUserLastAvatarResponse(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mavatar_key = r2;
    }
}
