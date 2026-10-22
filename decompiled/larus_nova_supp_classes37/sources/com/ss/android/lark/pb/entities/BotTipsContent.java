package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BotTipsContent extends com.squareup.wire.Message<BotTipsContent, Builder> {
    public static final ProtoAdapter<BotTipsContent> ADAPTER = null;
    public static final Long DEFAULT_ADMIN_ID = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Long madmin_id;
    public final Map<String, String> madmin_name;
    public final Map<String, String> mi18n_msg;
    public final Long mversion;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotTipsContent, Builder> {
        public Long madmin_id;
        public Map<String, String> madmin_name;
        public Map<String, String> mi18n_msg;
        public Long mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BotTipsContent m1034build() {
            return new BotTipsContent(this.mversion, this.mi18n_msg, this.madmin_id, this.madmin_name, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_msg = Internal.newMutableMap();
            this.madmin_name = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1034build();
        }

        public Builder admin_id(Long r1) {
            this.madmin_id = r1;
            return this;
        }

        public Builder admin_name(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.madmin_name = r1;
            return this;
        }

        public Builder i18n_msg(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_msg = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BotTipsContent extends ProtoAdapter<BotTipsContent> {
        private final ProtoAdapter<Map<String, String>> madmin_name;
        private final ProtoAdapter<Map<String, String>> mi18n_msg;

        public ProtoAdapter_BotTipsContent() {
            super(FieldEncoding.LENGTH_DELIMITED, BotTipsContent.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_msg = ProtoAdapter.newMapAdapter(r0, r0);
            this.madmin_name = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public BotTipsContent decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mversion = 0L;
            r0.madmin_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mi18n_msg.putAll((Map) this.mi18n_msg.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.madmin_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.madmin_name.putAll((Map) this.madmin_name.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1034build();
        }

        public int encodedSize(BotTipsContent r6) {
            Long r0 = r6.mversion;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + this.mi18n_msg.encodedSizeWithTag(2, r6.mi18n_msg);
            Long r4 = r6.madmin_id;
            if (r4 == null) goto L10;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(3, r4);
        L10:
            return ((r3 + r1) + this.madmin_name.encodedSizeWithTag(4, r6.madmin_name)) + r6.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1035decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BotTipsContent) r1);
        }

        public void encode(ProtoWriter r4, BotTipsContent r5) throws IOException {
            Long r0 = r5.mversion;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            this.mi18n_msg.encodeWithTag(r4, 2, r5.mi18n_msg);
            Long r1 = r5.madmin_id;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r1);
        L8:
            this.madmin_name.encodeWithTag(r4, 4, r5.madmin_name);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BotTipsContent) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotTipsContent();
        DEFAULT_VERSION = 0L;
        DEFAULT_ADMIN_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1033newBuilder() {
        Builder r0 = new Builder();
        r0.mversion = this.mversion;
        r0.mi18n_msg = Internal.copyOf("mi18n_msg", this.mi18n_msg);
        r0.madmin_id = this.madmin_id;
        r0.madmin_name = Internal.copyOf("madmin_name", this.madmin_name);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BotTipsContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1033newBuilder();
    }

    public BotTipsContent(Long r7, Map<String, String> r8, Long r9, Map<String, String> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public BotTipsContent(Long r2, Map<String, String> r3, Long r4, Map<String, String> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mversion = r2;
        this.mi18n_msg = Internal.immutableCopyOf("mi18n_msg", r3);
        this.madmin_id = r4;
        this.madmin_name = Internal.immutableCopyOf("madmin_name", r5);
    }
}
