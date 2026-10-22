package com.ss.android.lark.pb.edu;

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
public final class EduJoinChatPreCheckRequest extends Message<EduJoinChatPreCheckRequest, Builder> {
    public static final ProtoAdapter<EduJoinChatPreCheckRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final List<String> muser_ids;

    public static final class Builder extends Message.Builder<EduJoinChatPreCheckRequest, Builder> {
        public String mchat_id;
        public List<String> muser_ids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EduJoinChatPreCheckRequest m983build() {
            String r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new EduJoinChatPreCheckRequest(this.mchat_id, this.muser_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
            this.muser_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m983build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder user_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.muser_ids = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EduJoinChatPreCheckRequest extends ProtoAdapter<EduJoinChatPreCheckRequest> {
        public ProtoAdapter_EduJoinChatPreCheckRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, EduJoinChatPreCheckRequest.class);
        }

        public EduJoinChatPreCheckRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.muser_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m983build();
        }

        public int encodedSize(EduJoinChatPreCheckRequest r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5.mchat_id) + r0.asRepeated().encodedSizeWithTag(2, r5.muser_ids)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m984decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EduJoinChatPreCheckRequest) r1);
        }

        public void encode(ProtoWriter r4, EduJoinChatPreCheckRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mchat_id);
            r0.asRepeated().encodeWithTag(r4, 2, r5.muser_ids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EduJoinChatPreCheckRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EduJoinChatPreCheckRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m982newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EduJoinChatPreCheckRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m982newBuilder();
    }

    public EduJoinChatPreCheckRequest(String r2, List<String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public EduJoinChatPreCheckRequest(String r2, List<String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mchat_id = r2;
        this.muser_ids = Internal.immutableCopyOf("muser_ids", r3);
    }
}
