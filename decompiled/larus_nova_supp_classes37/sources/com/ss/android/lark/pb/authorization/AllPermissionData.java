package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AllPermissionData extends Message<AllPermissionData, Builder> {
    public static final ProtoAdapter<AllPermissionData> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final List<CustomizedOperatePermission> mcustomized_operate_permission_data;
    public final Long mexpire_time;
    public final List<ExtendedOperatePermission> mextended_operate_permission_data;
    public final List<OperatePermission> moperate_permission_data;
    public final Long mupdate_time;

    public static final class Builder extends Message.Builder<AllPermissionData, Builder> {
        public List<CustomizedOperatePermission> mcustomized_operate_permission_data;
        public Long mexpire_time;
        public List<ExtendedOperatePermission> mextended_operate_permission_data;
        public List<OperatePermission> moperate_permission_data;
        public Long mupdate_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AllPermissionData m824build() {
            Long r0 = this.mupdate_time;
            if (r0 == null) goto L9;
            if (this.mexpire_time == null) goto L9;
            return new AllPermissionData(this.mupdate_time, this.mexpire_time, this.moperate_permission_data, this.mextended_operate_permission_data, this.mcustomized_operate_permission_data, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mupdate_time", this.mexpire_time, "mexpire_time"});
        }

        public Builder() {
            this.moperate_permission_data = Internal.newMutableList();
            this.mextended_operate_permission_data = Internal.newMutableList();
            this.mcustomized_operate_permission_data = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m824build();
        }

        public Builder customized_operate_permission_data(List<CustomizedOperatePermission> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcustomized_operate_permission_data = r1;
            return this;
        }

        public Builder expire_time(Long r1) {
            this.mexpire_time = r1;
            return this;
        }

        public Builder extended_operate_permission_data(List<ExtendedOperatePermission> r1) {
            Internal.checkElementsNotNull(r1);
            this.mextended_operate_permission_data = r1;
            return this;
        }

        public Builder operate_permission_data(List<OperatePermission> r1) {
            Internal.checkElementsNotNull(r1);
            this.moperate_permission_data = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AllPermissionData extends ProtoAdapter<AllPermissionData> {
        public ProtoAdapter_AllPermissionData() {
            super(FieldEncoding.LENGTH_DELIMITED, AllPermissionData.class);
        }

        public AllPermissionData decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mupdate_time = 0L;
            r0.mexpire_time = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mexpire_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.moperate_permission_data.add((OperatePermission) OperatePermission.ADAPTER.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mextended_operate_permission_data.add((ExtendedOperatePermission) ExtendedOperatePermission.ADAPTER.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mcustomized_operate_permission_data.add((CustomizedOperatePermission) CustomizedOperatePermission.ADAPTER.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m824build();
        }

        public int encodedSize(AllPermissionData r5) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            return ((((r0.encodedSizeWithTag(1, r5.mupdate_time) + r0.encodedSizeWithTag(2, r5.mexpire_time)) + OperatePermission.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.moperate_permission_data)) + ExtendedOperatePermission.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.mextended_operate_permission_data)) + CustomizedOperatePermission.ADAPTER.asRepeated().encodedSizeWithTag(5, r5.mcustomized_operate_permission_data)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m825decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AllPermissionData) r1);
        }

        public void encode(ProtoWriter r4, AllPermissionData r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r4, 1, r5.mupdate_time);
            r0.encodeWithTag(r4, 2, r5.mexpire_time);
            OperatePermission.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.moperate_permission_data);
            ExtendedOperatePermission.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mextended_operate_permission_data);
            CustomizedOperatePermission.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.mcustomized_operate_permission_data);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AllPermissionData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AllPermissionData();
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_EXPIRE_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m823newBuilder() {
        Builder r0 = new Builder();
        r0.mupdate_time = this.mupdate_time;
        r0.mexpire_time = this.mexpire_time;
        r0.moperate_permission_data = Internal.copyOf("moperate_permission_data", this.moperate_permission_data);
        r0.mextended_operate_permission_data = Internal.copyOf("mextended_operate_permission_data", this.mextended_operate_permission_data);
        r0.mcustomized_operate_permission_data = Internal.copyOf("mcustomized_operate_permission_data", this.mcustomized_operate_permission_data);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AllPermissionData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m823newBuilder();
    }

    public AllPermissionData(Long r8, Long r9, List<OperatePermission> r10, List<ExtendedOperatePermission> r11, List<CustomizedOperatePermission> r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public AllPermissionData(Long r2, Long r3, List<OperatePermission> r4, List<ExtendedOperatePermission> r5, List<CustomizedOperatePermission> r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mupdate_time = r2;
        this.mexpire_time = r3;
        this.moperate_permission_data = Internal.immutableCopyOf("moperate_permission_data", r4);
        this.mextended_operate_permission_data = Internal.immutableCopyOf("mextended_operate_permission_data", r5);
        this.mcustomized_operate_permission_data = Internal.immutableCopyOf("mcustomized_operate_permission_data", r6);
    }
}
