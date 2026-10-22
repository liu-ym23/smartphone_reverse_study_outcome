package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullChangeGroupMemberAuthorizationResponse extends Message<PullChangeGroupMemberAuthorizationResponse, Builder> {
    public static final ProtoAdapter<PullChangeGroupMemberAuthorizationResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final String DEFAULT_MSG_DESCRIPTION = "";
    public static final Boolean DEFAULT_NEED_APPLY_FOR_INCR = null;
    public static final Boolean DEFAULT_PASS = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_cross_tenant;
    public final String mmsg_description;
    public final Boolean mneed_apply_for_incr;
    public final Boolean mpass;

    public static final class Builder extends Message.Builder<PullChangeGroupMemberAuthorizationResponse, Builder> {
        public Boolean mis_cross_tenant;
        public String mmsg_description;
        public Boolean mneed_apply_for_incr;
        public Boolean mpass;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullChangeGroupMemberAuthorizationResponse m890build() {
            return new PullChangeGroupMemberAuthorizationResponse(this.mpass, this.mmsg_description, this.mneed_apply_for_incr, this.mis_cross_tenant, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m890build();
        }

        public Builder is_cross_tenant(Boolean r1) {
            this.mis_cross_tenant = r1;
            return this;
        }

        public Builder msg_description(String r1) {
            this.mmsg_description = r1;
            return this;
        }

        public Builder need_apply_for_incr(Boolean r1) {
            this.mneed_apply_for_incr = r1;
            return this;
        }

        public Builder pass(Boolean r1) {
            this.mpass = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChangeGroupMemberAuthorizationResponse extends ProtoAdapter<PullChangeGroupMemberAuthorizationResponse> {
        public ProtoAdapter_PullChangeGroupMemberAuthorizationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChangeGroupMemberAuthorizationResponse.class);
        }

        public PullChangeGroupMemberAuthorizationResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mpass = r1;
            r0.mmsg_description = "";
            r0.mneed_apply_for_incr = r1;
            r0.mis_cross_tenant = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mpass = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmsg_description = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mneed_apply_for_incr = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r2);
            return r0.m890build();
        }

        public int encodedSize(PullChangeGroupMemberAuthorizationResponse r6) {
            Boolean r0 = r6.mpass;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mmsg_description;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mneed_apply_for_incr;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mis_cross_tenant;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m891decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullChangeGroupMemberAuthorizationResponse) r1);
        }

        public void encode(ProtoWriter r4, PullChangeGroupMemberAuthorizationResponse r5) throws IOException {
            Boolean r0 = r5.mpass;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mmsg_description;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mneed_apply_for_incr;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mis_cross_tenant;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullChangeGroupMemberAuthorizationResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChangeGroupMemberAuthorizationResponse();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_PASS = r0;
        DEFAULT_NEED_APPLY_FOR_INCR = r0;
        DEFAULT_IS_CROSS_TENANT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m889newBuilder() {
        Builder r0 = new Builder();
        r0.mpass = this.mpass;
        r0.mmsg_description = this.mmsg_description;
        r0.mneed_apply_for_incr = this.mneed_apply_for_incr;
        r0.mis_cross_tenant = this.mis_cross_tenant;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullChangeGroupMemberAuthorizationResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m889newBuilder();
    }

    public PullChangeGroupMemberAuthorizationResponse(Boolean r7, String r8, Boolean r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PullChangeGroupMemberAuthorizationResponse(Boolean r2, String r3, Boolean r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mpass = r2;
        this.mmsg_description = r3;
        this.mneed_apply_for_incr = r4;
        this.mis_cross_tenant = r5;
    }
}
