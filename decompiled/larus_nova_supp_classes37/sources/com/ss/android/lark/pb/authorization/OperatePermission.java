package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OperatePermission extends Message<OperatePermission, Builder> {
    public static final ProtoAdapter<OperatePermission> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity mobject;
    public final PermissionType mperm_type;
    public final ResultType mresult;

    public static final class Builder extends Message.Builder<OperatePermission, Builder> {
        public Entity mobject;
        public PermissionType mperm_type;
        public ResultType mresult;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public OperatePermission m842build() {
            PermissionType r0 = this.mperm_type;
            if (r0 == null) goto L11;
            if (this.mresult == null) goto L11;
            if (this.mobject == null) goto L11;
            return new OperatePermission(this.mperm_type, this.mresult, this.mobject, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "mperm_type", this.mresult, "mresult", this.mobject, "mobject"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m842build();
        }

        public Builder object(Entity r1) {
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

    public static final class ProtoAdapter_OperatePermission extends ProtoAdapter<OperatePermission> {
        public ProtoAdapter_OperatePermission() {
            super(FieldEncoding.LENGTH_DELIMITED, OperatePermission.class);
        }

        public OperatePermission decode(ProtoReader r9) throws IOException {
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
            r0.mobject = (Entity) Entity.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m842build();
        }

        public int encodedSize(OperatePermission r5) {
            return ((PermissionType.ADAPTER.encodedSizeWithTag(1, r5.mperm_type) + ResultType.ADAPTER.encodedSizeWithTag(2, r5.mresult)) + Entity.ADAPTER.encodedSizeWithTag(3, r5.mobject)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m843decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((OperatePermission) r1);
        }

        public void encode(ProtoWriter r4, OperatePermission r5) throws IOException {
            PermissionType.ADAPTER.encodeWithTag(r4, 1, r5.mperm_type);
            ResultType.ADAPTER.encodeWithTag(r4, 2, r5.mresult);
            Entity.ADAPTER.encodeWithTag(r4, 3, r5.mobject);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (OperatePermission) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OperatePermission();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m841newBuilder() {
        Builder r0 = new Builder();
        r0.mperm_type = this.mperm_type;
        r0.mresult = this.mresult;
        r0.mobject = this.mobject;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return OperatePermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m841newBuilder();
    }

    public OperatePermission(PermissionType r2, ResultType r3, Entity r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public OperatePermission(PermissionType r2, ResultType r3, Entity r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mperm_type = r2;
        this.mresult = r3;
        this.mobject = r4;
    }
}
