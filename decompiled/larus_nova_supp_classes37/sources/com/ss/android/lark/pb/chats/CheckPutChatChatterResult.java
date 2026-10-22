package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CheckPutChatChatterResult extends Message<CheckPutChatChatterResult, Builder> {
    public static final ProtoAdapter<CheckPutChatChatterResult> ADAPTER = null;
    public static final Long DEFAULT_CHATTER_ID = null;
    public static final Boolean DEFAULT_CHECK_RESULT = null;
    private static final long serialVersionUID = 0;
    public final Long mchatter_id;
    public final Boolean mcheck_result;

    public static final class Builder extends Message.Builder<CheckPutChatChatterResult, Builder> {
        public Long mchatter_id;
        public Boolean mcheck_result;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CheckPutChatChatterResult m875build() {
            Long r0 = this.mchatter_id;
            if (r0 == null) goto L9;
            if (this.mcheck_result == null) goto L9;
            return new CheckPutChatChatterResult(this.mchatter_id, this.mcheck_result, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchatter_id", this.mcheck_result, "mcheck_result"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m875build();
        }

        public Builder chatter_id(Long r1) {
            this.mchatter_id = r1;
            return this;
        }

        public Builder check_result(Boolean r1) {
            this.mcheck_result = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckPutChatChatterResult extends ProtoAdapter<CheckPutChatChatterResult> {
        public ProtoAdapter_CheckPutChatChatterResult() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckPutChatChatterResult.class);
        }

        public CheckPutChatChatterResult decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchatter_id = 0L;
            r0.mcheck_result = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mchatter_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mcheck_result = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m875build();
        }

        public int encodedSize(CheckPutChatChatterResult r5) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r5.mchatter_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r5.mcheck_result)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m876decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CheckPutChatChatterResult) r1);
        }

        public void encode(ProtoWriter r4, CheckPutChatChatterResult r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.mchatter_id);
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r5.mcheck_result);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CheckPutChatChatterResult) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckPutChatChatterResult();
        DEFAULT_CHATTER_ID = 0L;
        DEFAULT_CHECK_RESULT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m874newBuilder() {
        Builder r0 = new Builder();
        r0.mchatter_id = this.mchatter_id;
        r0.mcheck_result = this.mcheck_result;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CheckPutChatChatterResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m874newBuilder();
    }

    public CheckPutChatChatterResult(Long r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CheckPutChatChatterResult(Long r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mchatter_id = r2;
        this.mcheck_result = r3;
    }
}
