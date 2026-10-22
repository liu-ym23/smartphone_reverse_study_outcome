package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomizedOperatePermission extends Message<CustomizedOperatePermission, Builder> {
    public static final ProtoAdapter<CustomizedOperatePermission> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CustomizedEntity mobject;
    public final PermissionType mperm_type;
    public final ResultType mresult;

    public static final class Builder extends Message.Builder<CustomizedOperatePermission, Builder> {
        public CustomizedEntity mobject;
        public PermissionType mperm_type;
        public ResultType mresult;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomizedOperatePermission m830build() {
            return new CustomizedOperatePermission(this.mperm_type, this.mresult, this.mobject, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m830build();
        }

        public Builder object(CustomizedEntity r1) {
            this.mobject = r1;
            return this;
        }

        public Builder perm_type(PermissionType r1) {
            this.mperm_type = r1;
            return this;
        }

        public Builder result(ResultType r1) {
            this.mresult = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomizedOperatePermission extends ProtoAdapter<CustomizedOperatePermission> {
        public ProtoAdapter_CustomizedOperatePermission() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomizedOperatePermission.class);
        }

        public CustomizedOperatePermission decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mperm_type = (PermissionType) PermissionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mresult = (ResultType) ResultType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mobject = (CustomizedEntity) CustomizedEntity.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m830build();
        }

        public int encodedSize(CustomizedOperatePermission r6) {
            PermissionType r0 = r6.mperm_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = PermissionType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ResultType r3 = r6.mresult;
            if (r3 == null) goto L9;
            int r4 = ResultType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            CustomizedEntity r7 = r6.mobject;
            if (r7 == null) goto L14;
            r1 = CustomizedEntity.ADAPTER.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m831decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomizedOperatePermission) r1);
        }

        public void encode(ProtoWriter r4, CustomizedOperatePermission r5) throws IOException {
            PermissionType r0 = r5.mperm_type;
            if (r0 == null) goto L5;
            PermissionType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            ResultType r1 = r5.mresult;
            if (r1 == null) goto L8;
            ResultType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            CustomizedEntity r2 = r5.mobject;
            if (r2 == null) goto L11;
            CustomizedEntity.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomizedOperatePermission) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomizedOperatePermission();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m829newBuilder() {
        Builder r0 = new Builder();
        r0.mperm_type = this.mperm_type;
        r0.mresult = this.mresult;
        r0.mobject = this.mobject;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomizedOperatePermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m829newBuilder();
    }

    public CustomizedOperatePermission(PermissionType r2, ResultType r3, CustomizedEntity r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public CustomizedOperatePermission(PermissionType r2, ResultType r3, CustomizedEntity r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mperm_type = r2;
        this.mresult = r3;
        this.mobject = r4;
    }
}
