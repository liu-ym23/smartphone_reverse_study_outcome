package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SystemBannedInfo extends com.squareup.wire.Message<SystemBannedInfo, Builder> {
    public static final ProtoAdapter<SystemBannedInfo> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_AT = null;
    public static final Boolean DEFAULT_IS_BANNED = null;
    public static final Boolean DEFAULT_IS_PERMANENT = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mappeal_urls;
    public final List<BlockedFeature> mblocked_features;
    public final Long mexpire_at;
    public final Boolean mis_banned;
    public final Boolean mis_permanent;

    public static final class Builder extends com.squareup.wire.Message.Builder<SystemBannedInfo, Builder> {
        public Map<String, String> mappeal_urls;
        public List<BlockedFeature> mblocked_features;
        public Long mexpire_at;
        public Boolean mis_banned;
        public Boolean mis_permanent;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SystemBannedInfo m1541build() {
            return new SystemBannedInfo(this.mis_banned, this.mexpire_at, this.mappeal_urls, this.mblocked_features, this.mis_permanent, super.buildUnknownFields());
        }

        public Builder() {
            this.mappeal_urls = Internal.newMutableMap();
            this.mblocked_features = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1541build();
        }

        public Builder appeal_urls(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mappeal_urls = r1;
            return this;
        }

        public Builder blocked_features(List<BlockedFeature> r1) {
            Internal.checkElementsNotNull(r1);
            this.mblocked_features = r1;
            return this;
        }

        public Builder expire_at(Long r1) {
            this.mexpire_at = r1;
            return this;
        }

        public Builder is_banned(Boolean r1) {
            this.mis_banned = r1;
            return this;
        }

        public Builder is_permanent(Boolean r1) {
            this.mis_permanent = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SystemBannedInfo extends ProtoAdapter<SystemBannedInfo> {
        private final ProtoAdapter<Map<String, String>> mappeal_urls;

        public ProtoAdapter_SystemBannedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SystemBannedInfo.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mappeal_urls = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SystemBannedInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mis_banned = r1;
            r0.mexpire_at = 0L;
            r0.mis_permanent = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mis_banned = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mexpire_at = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mappeal_urls.putAll((Map) this.mappeal_urls.decode(r9));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mblocked_features.add((BlockedFeature) BlockedFeature.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mis_permanent = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r2);
            return r0.m1541build();
        }

        public int encodedSize(SystemBannedInfo r6) {
            Boolean r0 = r6.mis_banned;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mexpire_at;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = ((r2 + r4) + this.mappeal_urls.encodedSizeWithTag(3, r6.mappeal_urls)) + BlockedFeature.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mblocked_features);
            Boolean r7 = r6.mis_permanent;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r7);
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
        public /* bridge */ /* synthetic */ Object m1542decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SystemBannedInfo) r1);
        }

        public void encode(ProtoWriter r4, SystemBannedInfo r5) throws IOException {
            Boolean r0 = r5.mis_banned;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mexpire_at;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            this.mappeal_urls.encodeWithTag(r4, 3, r5.mappeal_urls);
            BlockedFeature.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mblocked_features);
            Boolean r2 = r5.mis_permanent;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SystemBannedInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SystemBannedInfo();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_BANNED = r0;
        DEFAULT_EXPIRE_AT = 0L;
        DEFAULT_IS_PERMANENT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1540newBuilder() {
        Builder r0 = new Builder();
        r0.mis_banned = this.mis_banned;
        r0.mexpire_at = this.mexpire_at;
        r0.mappeal_urls = Internal.copyOf("mappeal_urls", this.mappeal_urls);
        r0.mblocked_features = Internal.copyOf("mblocked_features", this.mblocked_features);
        r0.mis_permanent = this.mis_permanent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SystemBannedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1540newBuilder();
    }

    public SystemBannedInfo(Boolean r8, Long r9, Map<String, String> r10, List<BlockedFeature> r11, Boolean r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public SystemBannedInfo(Boolean r2, Long r3, Map<String, String> r4, List<BlockedFeature> r5, Boolean r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mis_banned = r2;
        this.mexpire_at = r3;
        this.mappeal_urls = Internal.immutableCopyOf("mappeal_urls", r4);
        this.mblocked_features = Internal.immutableCopyOf("mblocked_features", r5);
        this.mis_permanent = r6;
    }
}
