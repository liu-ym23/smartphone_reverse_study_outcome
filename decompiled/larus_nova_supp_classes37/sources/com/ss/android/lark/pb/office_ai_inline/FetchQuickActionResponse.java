package com.ss.android.lark.pb.office_ai_inline;

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
public final class FetchQuickActionResponse extends Message<FetchQuickActionResponse, Builder> {
    public static final ProtoAdapter<FetchQuickActionResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<QuickAction> mactions;

    public static final class Builder extends Message.Builder<FetchQuickActionResponse, Builder> {
        public List<QuickAction> mactions;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FetchQuickActionResponse m2036build() {
            return new FetchQuickActionResponse(this.mactions, super.buildUnknownFields());
        }

        public Builder() {
            this.mactions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2036build();
        }

        public Builder actions(List<QuickAction> r1) {
            Internal.checkElementsNotNull(r1);
            this.mactions = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionResponse extends ProtoAdapter<FetchQuickActionResponse> {
        public ProtoAdapter_FetchQuickActionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionResponse.class);
        }

        public FetchQuickActionResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mactions.add((QuickAction) QuickAction.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2036build();
        }

        public int encodedSize(FetchQuickActionResponse r4) {
            return QuickAction.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mactions) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2037decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FetchQuickActionResponse) r1);
        }

        public void encode(ProtoWriter r4, FetchQuickActionResponse r5) throws IOException {
            QuickAction.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mactions);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FetchQuickActionResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2035newBuilder() {
        Builder r0 = new Builder();
        r0.mactions = Internal.copyOf("mactions", this.mactions);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FetchQuickActionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2035newBuilder();
    }

    public FetchQuickActionResponse(List<QuickAction> r2) {
        this(r2, ByteString.EMPTY);
    }

    public FetchQuickActionResponse(List<QuickAction> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mactions = Internal.immutableCopyOf("mactions", r2);
    }
}
