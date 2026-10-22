package com.ss.android.lark.pb.office_ai;

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
public final class FetchQuickActionsResponse extends Message<FetchQuickActionsResponse, Builder> {
    public static final ProtoAdapter<FetchQuickActionsResponse> ADAPTER = null;
    public static final String DEFAULT_MESSAGE = "";
    public static final String DEFAULT_ROUND_ID = "";
    public static final Long DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String mmessage;
    public final List<QuickAction> mquick_actions;
    public final String mround_id;
    public final Long mstatus;

    public static final class Builder extends Message.Builder<FetchQuickActionsResponse, Builder> {
        public String mmessage;
        public List<QuickAction> mquick_actions;
        public String mround_id;
        public Long mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FetchQuickActionsResponse m1949build() {
            return new FetchQuickActionsResponse(this.mstatus, this.mmessage, this.mquick_actions, this.mround_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mquick_actions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1949build();
        }

        public Builder message(String r1) {
            this.mmessage = r1;
            return this;
        }

        public Builder quick_actions(List<QuickAction> r1) {
            Internal.checkElementsNotNull(r1);
            this.mquick_actions = r1;
            return this;
        }

        public Builder round_id(String r1) {
            this.mround_id = r1;
            return this;
        }

        public Builder status(Long r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionsResponse extends ProtoAdapter<FetchQuickActionsResponse> {
        public ProtoAdapter_FetchQuickActionsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionsResponse.class);
        }

        public FetchQuickActionsResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mstatus = 0L;
            r0.mmessage = "";
            r0.mround_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mstatus = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmessage = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mquick_actions.add((QuickAction) QuickAction.ADAPTER.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mround_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1949build();
        }

        public int encodedSize(FetchQuickActionsResponse r6) {
            Long r0 = r6.mstatus;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mmessage;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = (r2 + r4) + QuickAction.ADAPTER.asRepeated().encodedSizeWithTag(3, r6.mquick_actions);
            String r7 = r6.mround_id;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1950decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FetchQuickActionsResponse) r1);
        }

        public void encode(ProtoWriter r4, FetchQuickActionsResponse r5) throws IOException {
            Long r0 = r5.mstatus;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mmessage;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            QuickAction.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mquick_actions);
            String r2 = r5.mround_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FetchQuickActionsResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionsResponse();
        DEFAULT_STATUS = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1948newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.mmessage = this.mmessage;
        r0.mquick_actions = Internal.copyOf("mquick_actions", this.mquick_actions);
        r0.mround_id = this.mround_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FetchQuickActionsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1948newBuilder();
    }

    public FetchQuickActionsResponse(Long r7, String r8, List<QuickAction> r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public FetchQuickActionsResponse(Long r2, String r3, List<QuickAction> r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mstatus = r2;
        this.mmessage = r3;
        this.mquick_actions = Internal.immutableCopyOf("mquick_actions", r4);
        this.mround_id = r5;
    }
}
