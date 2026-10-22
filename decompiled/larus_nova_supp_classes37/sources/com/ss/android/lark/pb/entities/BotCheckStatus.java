package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BotCheckStatus extends com.squareup.wire.Message<BotCheckStatus, Builder> {
    public static final ProtoAdapter<BotCheckStatus> ADAPTER = null;
    public static final Long DEFAULT_BOT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mbot_id;
    public final BotUsageStatus mstatus;
    public final BotTipsContent mtips;

    public static final enum BotUsageStatus extends Enum<BotUsageStatus> implements WireEnum {
        private static final /* synthetic */ BotUsageStatus[] $VALUES = null;
        public static final ProtoAdapter<BotUsageStatus> ADAPTER = null;
        public static final BotUsageStatus BOT_DEVELOPER_FORBIDDEN = null;
        public static final BotUsageStatus BOT_OFFLINE = null;
        public static final BotUsageStatus BOT_PLATFORM_FORBIDDEN = null;
        public static final BotUsageStatus BOT_TENANT_FORBIDDEN = null;
        public static final BotUsageStatus BOT_USABLE = null;
        public static final BotUsageStatus BOT_USER_UNVISIBLE = null;
        private final int value;

        static {
            BotUsageStatus r0 = new BotUsageStatus("BOT_USABLE", 0, 1);
            BOT_USABLE = r0;
            BotUsageStatus r1 = new BotUsageStatus("BOT_TENANT_FORBIDDEN", 1, 2);
            BOT_TENANT_FORBIDDEN = r1;
            BotUsageStatus r4 = new BotUsageStatus("BOT_PLATFORM_FORBIDDEN", 2, 3);
            BOT_PLATFORM_FORBIDDEN = r4;
            BotUsageStatus r6 = new BotUsageStatus("BOT_DEVELOPER_FORBIDDEN", 3, 4);
            BOT_DEVELOPER_FORBIDDEN = r6;
            BotUsageStatus r8 = new BotUsageStatus("BOT_OFFLINE", 4, 5);
            BOT_OFFLINE = r8;
            BotUsageStatus r10 = new BotUsageStatus("BOT_USER_UNVISIBLE", 5, 6);
            BOT_USER_UNVISIBLE = r10;
            $VALUES = new BotUsageStatus[]{r0, r1, r4, r6, r8, r10};
            ADAPTER = ProtoAdapter.newEnumAdapter(BotUsageStatus.class);
        }

        public static BotUsageStatus[] values() {
            return (BotUsageStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BotUsageStatus fromValue(int r0) {
            switch(r0) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return BOT_USER_UNVISIBLE;
        L8:
            return BOT_OFFLINE;
        L10:
            return BOT_DEVELOPER_FORBIDDEN;
        L12:
            return BOT_PLATFORM_FORBIDDEN;
        L14:
            return BOT_TENANT_FORBIDDEN;
        L16:
            return BOT_USABLE;
        }

        public static BotUsageStatus valueOf(String r1) {
            return (BotUsageStatus) a.a(BotUsageStatus.class, r1);
        }

        private BotUsageStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<BotCheckStatus, Builder> {
        public Long mbot_id;
        public BotUsageStatus mstatus;
        public BotTipsContent mtips;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BotCheckStatus m1025build() {
            return new BotCheckStatus(this.mbot_id, this.mstatus, this.mtips, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1025build();
        }

        public Builder bot_id(Long r1) {
            this.mbot_id = r1;
            return this;
        }

        public Builder status(BotUsageStatus r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder tips(BotTipsContent r1) {
            this.mtips = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BotCheckStatus extends ProtoAdapter<BotCheckStatus> {
        public ProtoAdapter_BotCheckStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, BotCheckStatus.class);
        }

        public BotCheckStatus decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mbot_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mbot_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mstatus = (BotUsageStatus) BotUsageStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mtips = (BotTipsContent) BotTipsContent.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1025build();
        }

        public int encodedSize(BotCheckStatus r6) {
            Long r0 = r6.mbot_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            BotUsageStatus r3 = r6.mstatus;
            if (r3 == null) goto L9;
            int r4 = BotUsageStatus.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            BotTipsContent r7 = r6.mtips;
            if (r7 == null) goto L14;
            r1 = BotTipsContent.ADAPTER.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1026decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BotCheckStatus) r1);
        }

        public void encode(ProtoWriter r4, BotCheckStatus r5) throws IOException {
            Long r0 = r5.mbot_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            BotUsageStatus r1 = r5.mstatus;
            if (r1 == null) goto L8;
            BotUsageStatus.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            BotTipsContent r2 = r5.mtips;
            if (r2 == null) goto L11;
            BotTipsContent.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BotCheckStatus) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotCheckStatus();
        DEFAULT_BOT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1024newBuilder() {
        Builder r0 = new Builder();
        r0.mbot_id = this.mbot_id;
        r0.mstatus = this.mstatus;
        r0.mtips = this.mtips;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BotCheckStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1024newBuilder();
    }

    public BotCheckStatus(Long r2, BotUsageStatus r3, BotTipsContent r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public BotCheckStatus(Long r2, BotUsageStatus r3, BotTipsContent r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mbot_id = r2;
        this.mstatus = r3;
        this.mtips = r4;
    }
}
