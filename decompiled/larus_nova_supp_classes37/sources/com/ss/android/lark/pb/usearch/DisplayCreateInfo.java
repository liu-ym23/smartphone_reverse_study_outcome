package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DisplayCreateInfo extends Message<DisplayCreateInfo, Builder> {
    public static final ProtoAdapter<DisplayCreateInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final WikiCollaboratorInfo mwiki_collaborator_info;
    public final WikiTenantInfo mwiki_tenant_info;

    public static final class Builder extends Message.Builder<DisplayCreateInfo, Builder> {
        public WikiCollaboratorInfo mwiki_collaborator_info;
        public WikiTenantInfo mwiki_tenant_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DisplayCreateInfo m2588build() {
            return new DisplayCreateInfo(this.mwiki_collaborator_info, this.mwiki_tenant_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2588build();
        }

        public Builder wiki_collaborator_info(WikiCollaboratorInfo r1) {
            this.mwiki_collaborator_info = r1;
            return this;
        }

        public Builder wiki_tenant_info(WikiTenantInfo r1) {
            this.mwiki_tenant_info = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DisplayCreateInfo extends ProtoAdapter<DisplayCreateInfo> {
        public ProtoAdapter_DisplayCreateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DisplayCreateInfo.class);
        }

        public DisplayCreateInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mwiki_collaborator_info = (WikiCollaboratorInfo) WikiCollaboratorInfo.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mwiki_tenant_info = (WikiTenantInfo) WikiTenantInfo.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2588build();
        }

        public int encodedSize(DisplayCreateInfo r5) {
            WikiCollaboratorInfo r0 = r5.mwiki_collaborator_info;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = WikiCollaboratorInfo.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            WikiTenantInfo r3 = r5.mwiki_tenant_info;
            if (r3 == null) goto L10;
            r1 = WikiTenantInfo.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2589decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DisplayCreateInfo) r1);
        }

        public void encode(ProtoWriter r4, DisplayCreateInfo r5) throws IOException {
            WikiCollaboratorInfo r0 = r5.mwiki_collaborator_info;
            if (r0 == null) goto L5;
            WikiCollaboratorInfo.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            WikiTenantInfo r1 = r5.mwiki_tenant_info;
            if (r1 == null) goto L8;
            WikiTenantInfo.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DisplayCreateInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DisplayCreateInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2587newBuilder() {
        Builder r0 = new Builder();
        r0.mwiki_collaborator_info = this.mwiki_collaborator_info;
        r0.mwiki_tenant_info = this.mwiki_tenant_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DisplayCreateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2587newBuilder();
    }

    public DisplayCreateInfo(WikiCollaboratorInfo r2, WikiTenantInfo r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public DisplayCreateInfo(WikiCollaboratorInfo r2, WikiTenantInfo r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mwiki_collaborator_info = r2;
        this.mwiki_tenant_info = r3;
    }
}
