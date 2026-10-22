package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AIBot extends Message<AIBot, Builder> {
    public static final ProtoAdapter<AIBot> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final AppLink mapp_link;
    public final String mdescription;
    public final String micon_url;
    public final Long mid;
    public final String mname;

    public static final class Builder extends Message.Builder<AIBot, Builder> {
        public AppLink mapp_link;
        public String mdescription;
        public String micon_url;
        public Long mid;
        public String mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AIBot m1916build() {
            return new AIBot(this.mid, this.mname, this.mdescription, this.micon_url, this.mapp_link, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1916build();
        }

        public Builder app_link(AppLink r1) {
            this.mapp_link = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder icon_url(String r1) {
            this.micon_url = r1;
            return this;
        }

        public Builder id(Long r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AIBot extends ProtoAdapter<AIBot> {
        public ProtoAdapter_AIBot() {
            super(FieldEncoding.LENGTH_DELIMITED, AIBot.class);
        }

        public AIBot decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = 0L;
            r0.mname = "";
            r0.mdescription = "";
            r0.micon_url = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mid = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.micon_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mapp_link = (AppLink) AppLink.ADAPTER.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1916build();
        }

        public int encodedSize(AIBot r6) {
            Long r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mdescription;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.micon_url;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            AppLink r13 = r6.mapp_link;
            if (r13 == null) goto L22;
            r1 = AppLink.ADAPTER.encodedSizeWithTag(5, r13);
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
        public /* bridge */ /* synthetic */ Object m1917decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AIBot) r1);
        }

        public void encode(ProtoWriter r4, AIBot r5) throws IOException {
            Long r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mdescription;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.micon_url;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            AppLink r6 = r5.mapp_link;
            if (r6 == null) goto L17;
            AppLink.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AIBot) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIBot();
        DEFAULT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1915newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mdescription = this.mdescription;
        r0.micon_url = this.micon_url;
        r0.mapp_link = this.mapp_link;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AIBot.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1915newBuilder();
    }

    public AIBot(Long r8, String r9, String r10, String r11, AppLink r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public AIBot(Long r2, String r3, String r4, String r5, AppLink r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mid = r2;
        this.mname = r3;
        this.mdescription = r4;
        this.micon_url = r5;
        this.mapp_link = r6;
    }
}
