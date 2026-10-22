package com.ss.android.lark.pb.users;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PatchUserMemoResponse extends Message<PatchUserMemoResponse, Builder> {
    public static final ProtoAdapter<PatchUserMemoResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<PatchUserMemoResponse, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PatchUserMemoResponse m3005build() {
            return new PatchUserMemoResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3005build();
        }
    }

    public static final class ProtoAdapter_PatchUserMemoResponse extends ProtoAdapter<PatchUserMemoResponse> {
        public ProtoAdapter_PatchUserMemoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PatchUserMemoResponse.class);
        }

        public PatchUserMemoResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L6;
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L6:
            r7.endMessage(r1);
            return r0.m3005build();
        }

        public int encodedSize(PatchUserMemoResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3006decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PatchUserMemoResponse) r1);
        }

        public void encode(ProtoWriter r1, PatchUserMemoResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PatchUserMemoResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PatchUserMemoResponse();
    }

    public PatchUserMemoResponse() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3004newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PatchUserMemoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3004newBuilder();
    }

    public PatchUserMemoResponse(ByteString r2) {
        super(ADAPTER, r2);
    }
}
