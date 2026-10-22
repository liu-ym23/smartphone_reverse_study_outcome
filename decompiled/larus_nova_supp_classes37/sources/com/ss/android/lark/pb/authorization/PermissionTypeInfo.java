package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PermissionTypeInfo extends Message<PermissionTypeInfo, Builder> {
    public static final ProtoAdapter<PermissionTypeInfo> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_CLEAR = null;
    private static final long serialVersionUID = 0;
    public final Boolean mforce_clear;
    public final PermissionType mperm_type;

    public static final class Builder extends Message.Builder<PermissionTypeInfo, Builder> {
        public Boolean mforce_clear;
        public PermissionType mperm_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PermissionTypeInfo m848build() {
            return new PermissionTypeInfo(this.mperm_type, this.mforce_clear, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m848build();
        }

        public Builder force_clear(Boolean r1) {
            this.mforce_clear = r1;
            return this;
        }

        public Builder perm_type(PermissionType r1) {
            this.mperm_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PermissionTypeInfo extends ProtoAdapter<PermissionTypeInfo> {
        public ProtoAdapter_PermissionTypeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PermissionTypeInfo.class);
        }

        public PermissionTypeInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mforce_clear = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mperm_type = (PermissionType) PermissionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mforce_clear = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m848build();
        }

        public int encodedSize(PermissionTypeInfo r5) {
            PermissionType r0 = r5.mperm_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = PermissionType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r5.mforce_clear;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m849decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PermissionTypeInfo) r1);
        }

        public void encode(ProtoWriter r4, PermissionTypeInfo r5) throws IOException {
            PermissionType r0 = r5.mperm_type;
            if (r0 == null) goto L5;
            PermissionType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mforce_clear;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PermissionTypeInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PermissionTypeInfo();
        DEFAULT_FORCE_CLEAR = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m847newBuilder() {
        Builder r0 = new Builder();
        r0.mperm_type = this.mperm_type;
        r0.mforce_clear = this.mforce_clear;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PermissionTypeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m847newBuilder();
    }

    public PermissionTypeInfo(PermissionType r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PermissionTypeInfo(PermissionType r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mperm_type = r2;
        this.mforce_clear = r3;
    }
}
