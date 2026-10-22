package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AutoMuteConfig extends com.squareup.wire.Message<AutoMuteConfig, Builder> {
    public static final ProtoAdapter<AutoMuteConfig> ADAPTER = null;
    public static final Long DEFAULT_BADGE_COUNT = null;
    public static final Boolean DEFAULT_IS_MUTE = null;
    public static final Long DEFAULT_OPEN_MUTE_TIME_MS = null;
    public static final Long DEFAULT_POSITION = null;
    private static final long serialVersionUID = 0;
    public final Long mbadge_count;
    public final Boolean mis_mute;
    public final MuteWay mmute_way;
    public final Long mopen_mute_time_ms;
    public final Long mposition;

    public static final class Builder extends com.squareup.wire.Message.Builder<AutoMuteConfig, Builder> {
        public Long mbadge_count;
        public Boolean mis_mute;
        public MuteWay mmute_way;
        public Long mopen_mute_time_ms;
        public Long mposition;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AutoMuteConfig m1010build() {
            return new AutoMuteConfig(this.mis_mute, this.mposition, this.mbadge_count, this.mmute_way, this.mopen_mute_time_ms, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1010build();
        }

        public Builder badge_count(Long r1) {
            this.mbadge_count = r1;
            return this;
        }

        public Builder is_mute(Boolean r1) {
            this.mis_mute = r1;
            return this;
        }

        public Builder mute_way(MuteWay r1) {
            this.mmute_way = r1;
            return this;
        }

        public Builder open_mute_time_ms(Long r1) {
            this.mopen_mute_time_ms = r1;
            return this;
        }

        public Builder position(Long r1) {
            this.mposition = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AutoMuteConfig extends ProtoAdapter<AutoMuteConfig> {
        public ProtoAdapter_AutoMuteConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, AutoMuteConfig.class);
        }

        public AutoMuteConfig decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_mute = Boolean.FALSE;
            r0.mposition = 0L;
            r0.mbadge_count = 0L;
            r0.mopen_mute_time_ms = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mis_mute = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mposition = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mbadge_count = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mmute_way = (MuteWay) MuteWay.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mopen_mute_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m1010build();
        }

        public int encodedSize(AutoMuteConfig r6) {
            Boolean r0 = r6.mis_mute;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mposition;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.mbadge_count;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            MuteWay r10 = r6.mmute_way;
            if (r10 == null) goto L17;
            int r11 = MuteWay.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r6.mopen_mute_time_ms;
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
        public /* bridge */ /* synthetic */ Object m1011decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AutoMuteConfig) r1);
        }

        public void encode(ProtoWriter r4, AutoMuteConfig r5) throws IOException {
            Boolean r0 = r5.mis_mute;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mposition;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.mbadge_count;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            MuteWay r3 = r5.mmute_way;
            if (r3 == null) goto L14;
            MuteWay.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            Long r6 = r5.mopen_mute_time_ms;
            if (r6 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AutoMuteConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AutoMuteConfig();
        DEFAULT_IS_MUTE = Boolean.FALSE;
        DEFAULT_POSITION = 0L;
        DEFAULT_BADGE_COUNT = 0L;
        DEFAULT_OPEN_MUTE_TIME_MS = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1009newBuilder() {
        Builder r0 = new Builder();
        r0.mis_mute = this.mis_mute;
        r0.mposition = this.mposition;
        r0.mbadge_count = this.mbadge_count;
        r0.mmute_way = this.mmute_way;
        r0.mopen_mute_time_ms = this.mopen_mute_time_ms;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AutoMuteConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1009newBuilder();
    }

    public AutoMuteConfig(Boolean r8, Long r9, Long r10, MuteWay r11, Long r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public AutoMuteConfig(Boolean r2, Long r3, Long r4, MuteWay r5, Long r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mis_mute = r2;
        this.mposition = r3;
        this.mbadge_count = r4;
        this.mmute_way = r5;
        this.mopen_mute_time_ms = r6;
    }
}
