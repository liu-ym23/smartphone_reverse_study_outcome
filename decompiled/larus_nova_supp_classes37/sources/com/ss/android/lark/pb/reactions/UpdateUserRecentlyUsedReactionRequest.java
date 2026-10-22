package com.ss.android.lark.pb.reactions;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateUserRecentlyUsedReactionRequest extends Message<UpdateUserRecentlyUsedReactionRequest, Builder> {
    public static final ProtoAdapter<UpdateUserRecentlyUsedReactionRequest> ADAPTER = null;
    public static final String DEFAULT_REACTION_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mreaction_key;

    public static final class Builder extends Message.Builder<UpdateUserRecentlyUsedReactionRequest, Builder> {
        public String mreaction_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateUserRecentlyUsedReactionRequest m2078build() {
            return new UpdateUserRecentlyUsedReactionRequest(this.mreaction_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2078build();
        }

        public Builder reaction_key(String r1) {
            this.mreaction_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateUserRecentlyUsedReactionRequest extends ProtoAdapter<UpdateUserRecentlyUsedReactionRequest> {
        public ProtoAdapter_UpdateUserRecentlyUsedReactionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateUserRecentlyUsedReactionRequest.class);
        }

        public UpdateUserRecentlyUsedReactionRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mreaction_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mreaction_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2078build();
        }

        public int encodedSize(UpdateUserRecentlyUsedReactionRequest r4) {
            String r0 = r4.mreaction_key;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2079decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateUserRecentlyUsedReactionRequest) r1);
        }

        public void encode(ProtoWriter r4, UpdateUserRecentlyUsedReactionRequest r5) throws IOException {
            String r0 = r5.mreaction_key;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateUserRecentlyUsedReactionRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateUserRecentlyUsedReactionRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2077newBuilder() {
        Builder r0 = new Builder();
        r0.mreaction_key = this.mreaction_key;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateUserRecentlyUsedReactionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2077newBuilder();
    }

    public UpdateUserRecentlyUsedReactionRequest(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public UpdateUserRecentlyUsedReactionRequest(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mreaction_key = r2;
    }
}
