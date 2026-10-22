package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetSummarizeQuickActionResponse extends Message<GetSummarizeQuickActionResponse, Builder> {
    public static final ProtoAdapter<GetSummarizeQuickActionResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final QuickAction mquick_action;

    public static final class Builder extends Message.Builder<GetSummarizeQuickActionResponse, Builder> {
        public QuickAction mquick_action;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSummarizeQuickActionResponse m1952build() {
            return new GetSummarizeQuickActionResponse(this.mquick_action, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1952build();
        }

        public Builder quick_action(QuickAction r1) {
            this.mquick_action = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSummarizeQuickActionResponse extends ProtoAdapter<GetSummarizeQuickActionResponse> {
        public ProtoAdapter_GetSummarizeQuickActionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSummarizeQuickActionResponse.class);
        }

        public GetSummarizeQuickActionResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mquick_action = (QuickAction) QuickAction.ADAPTER.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1952build();
        }

        public int encodedSize(GetSummarizeQuickActionResponse r4) {
            QuickAction r0 = r4.mquick_action;
            if (r0 == null) goto L5;
            int r1 = QuickAction.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1953decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSummarizeQuickActionResponse) r1);
        }

        public void encode(ProtoWriter r4, GetSummarizeQuickActionResponse r5) throws IOException {
            QuickAction r0 = r5.mquick_action;
            if (r0 == null) goto L5;
            QuickAction.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSummarizeQuickActionResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSummarizeQuickActionResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1951newBuilder() {
        Builder r0 = new Builder();
        r0.mquick_action = this.mquick_action;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSummarizeQuickActionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1951newBuilder();
    }

    public GetSummarizeQuickActionResponse(QuickAction r2) {
        this(r2, ByteString.EMPTY);
    }

    public GetSummarizeQuickActionResponse(QuickAction r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mquick_action = r2;
    }
}
