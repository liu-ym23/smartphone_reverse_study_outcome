package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class WikiCollaboratorInfo extends Message<WikiCollaboratorInfo, Builder> {
    public static final ProtoAdapter<WikiCollaboratorInfo> ADAPTER = null;
    public static final String DEFAULT_AVATAR_URL = "";
    public static final Long DEFAULT_MEMBER_ID = null;
    public static final Long DEFAULT_TENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mavatar_url;
    public final I18NNameText mmember_display_name;
    public final Long mmember_id;
    public final I18NNameText mmember_name;
    public final Long mtenant_id;

    public static final class Builder extends Message.Builder<WikiCollaboratorInfo, Builder> {
        public String mavatar_url;
        public I18NNameText mmember_display_name;
        public Long mmember_id;
        public I18NNameText mmember_name;
        public Long mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public WikiCollaboratorInfo m2975build() {
            return new WikiCollaboratorInfo(this.mmember_id, this.mmember_name, this.mmember_display_name, this.mavatar_url, this.mtenant_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2975build();
        }

        public Builder avatar_url(String r1) {
            this.mavatar_url = r1;
            return this;
        }

        public Builder member_display_name(I18NNameText r1) {
            this.mmember_display_name = r1;
            return this;
        }

        public Builder member_id(Long r1) {
            this.mmember_id = r1;
            return this;
        }

        public Builder member_name(I18NNameText r1) {
            this.mmember_name = r1;
            return this;
        }

        public Builder tenant_id(Long r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiCollaboratorInfo extends ProtoAdapter<WikiCollaboratorInfo> {
        public ProtoAdapter_WikiCollaboratorInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiCollaboratorInfo.class);
        }

        public WikiCollaboratorInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mmember_id = 0L;
            r0.mavatar_url = "";
            r0.mtenant_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mmember_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmember_name = (I18NNameText) I18NNameText.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mmember_display_name = (I18NNameText) I18NNameText.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mavatar_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mtenant_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2975build();
        }

        public int encodedSize(WikiCollaboratorInfo r6) {
            Long r0 = r6.mmember_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            I18NNameText r3 = r6.mmember_name;
            if (r3 == null) goto L9;
            int r4 = I18NNameText.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            I18NNameText r7 = r6.mmember_display_name;
            if (r7 == null) goto L13;
            int r8 = I18NNameText.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mavatar_url;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r6.mtenant_id;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
        L17:
            r11 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Object m2976decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((WikiCollaboratorInfo) r1);
        }

        public void encode(ProtoWriter r4, WikiCollaboratorInfo r5) throws IOException {
            Long r0 = r5.mmember_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            I18NNameText r1 = r5.mmember_name;
            if (r1 == null) goto L8;
            I18NNameText.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            I18NNameText r2 = r5.mmember_display_name;
            if (r2 == null) goto L11;
            I18NNameText.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mavatar_url;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Long r6 = r5.mtenant_id;
            if (r6 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (WikiCollaboratorInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiCollaboratorInfo();
        DEFAULT_MEMBER_ID = 0L;
        DEFAULT_TENANT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2974newBuilder() {
        Builder r0 = new Builder();
        r0.mmember_id = this.mmember_id;
        r0.mmember_name = this.mmember_name;
        r0.mmember_display_name = this.mmember_display_name;
        r0.mavatar_url = this.mavatar_url;
        r0.mtenant_id = this.mtenant_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return WikiCollaboratorInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2974newBuilder();
    }

    public WikiCollaboratorInfo(Long r8, I18NNameText r9, I18NNameText r10, String r11, Long r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public WikiCollaboratorInfo(Long r2, I18NNameText r3, I18NNameText r4, String r5, Long r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mmember_id = r2;
        this.mmember_name = r3;
        this.mmember_display_name = r4;
        this.mavatar_url = r5;
        this.mtenant_id = r6;
    }
}
