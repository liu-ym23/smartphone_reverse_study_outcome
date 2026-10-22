package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DeletedMessageUsersInfo extends com.squareup.wire.Message<DeletedMessageUsersInfo, Builder> {
    public static final ProtoAdapter<DeletedMessageUsersInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, Long> mDeletedMessageUserIDs2DelTime;
    public final StorageLocation mInfoStorageLocation;

    public static final class Builder extends com.squareup.wire.Message.Builder<DeletedMessageUsersInfo, Builder> {
        public Map<Long, Long> mDeletedMessageUserIDs2DelTime;
        public StorageLocation mInfoStorageLocation;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DeletedMessageUsersInfo m1196build() {
            return new DeletedMessageUsersInfo(this.mInfoStorageLocation, this.mDeletedMessageUserIDs2DelTime, super.buildUnknownFields());
        }

        public Builder() {
            this.mDeletedMessageUserIDs2DelTime = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1196build();
        }

        public Builder DeletedMessageUserIDs2DelTime(Map<Long, Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mDeletedMessageUserIDs2DelTime = r1;
            return this;
        }

        public Builder InfoStorageLocation(StorageLocation r1) {
            this.mInfoStorageLocation = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DeletedMessageUsersInfo extends ProtoAdapter<DeletedMessageUsersInfo> {
        private final ProtoAdapter<Map<Long, Long>> mDeletedMessageUserIDs2DelTime;

        public ProtoAdapter_DeletedMessageUsersInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DeletedMessageUsersInfo.class);
            ProtoAdapter r0 = ProtoAdapter.INT64;
            this.mDeletedMessageUserIDs2DelTime = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public DeletedMessageUsersInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mInfoStorageLocation = (StorageLocation) StorageLocation.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mDeletedMessageUserIDs2DelTime.putAll((Map) this.mDeletedMessageUserIDs2DelTime.decode(r9));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1196build();
        }

        public int encodedSize(DeletedMessageUsersInfo r5) {
            StorageLocation r0 = r5.mInfoStorageLocation;
            if (r0 == null) goto L5;
            int r1 = StorageLocation.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + this.mDeletedMessageUserIDs2DelTime.encodedSizeWithTag(2, r5.mDeletedMessageUserIDs2DelTime)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1197decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DeletedMessageUsersInfo) r1);
        }

        public void encode(ProtoWriter r4, DeletedMessageUsersInfo r5) throws IOException {
            StorageLocation r0 = r5.mInfoStorageLocation;
            if (r0 == null) goto L5;
            StorageLocation.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            this.mDeletedMessageUserIDs2DelTime.encodeWithTag(r4, 2, r5.mDeletedMessageUserIDs2DelTime);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DeletedMessageUsersInfo) r2);
        }
    }

    public static final enum StorageLocation extends Enum<StorageLocation> implements WireEnum {
        private static final /* synthetic */ StorageLocation[] $VALUES = null;
        public static final ProtoAdapter<StorageLocation> ADAPTER = null;
        public static final StorageLocation STORAGE_IN_EXTERNAL = null;
        public static final StorageLocation STORAGE_IN_MYSQL_ENTITY = null;
        public static final StorageLocation UNKNOWN = null;
        private final int value;

        static {
            StorageLocation r0 = new StorageLocation("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            StorageLocation r1 = new StorageLocation("STORAGE_IN_EXTERNAL", 1, 1);
            STORAGE_IN_EXTERNAL = r1;
            StorageLocation r3 = new StorageLocation("STORAGE_IN_MYSQL_ENTITY", 2, 2);
            STORAGE_IN_MYSQL_ENTITY = r3;
            $VALUES = new StorageLocation[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(StorageLocation.class);
        }

        public static StorageLocation[] values() {
            return (StorageLocation[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StorageLocation fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return STORAGE_IN_MYSQL_ENTITY;
        L12:
            return STORAGE_IN_EXTERNAL;
        L14:
            return UNKNOWN;
        }

        public static StorageLocation valueOf(String r1) {
            return (StorageLocation) a.a(StorageLocation.class, r1);
        }

        private StorageLocation(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeletedMessageUsersInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1195newBuilder() {
        Builder r0 = new Builder();
        r0.mInfoStorageLocation = this.mInfoStorageLocation;
        r0.mDeletedMessageUserIDs2DelTime = Internal.copyOf("mDeletedMessageUserIDs2DelTime", this.mDeletedMessageUserIDs2DelTime);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DeletedMessageUsersInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1195newBuilder();
    }

    public DeletedMessageUsersInfo(StorageLocation r2, Map<Long, Long> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public DeletedMessageUsersInfo(StorageLocation r2, Map<Long, Long> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mInfoStorageLocation = r2;
        this.mDeletedMessageUserIDs2DelTime = Internal.immutableCopyOf("mDeletedMessageUserIDs2DelTime", r3);
    }
}
