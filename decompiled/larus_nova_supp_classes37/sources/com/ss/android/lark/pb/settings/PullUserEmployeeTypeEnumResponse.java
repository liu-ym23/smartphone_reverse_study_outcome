package com.ss.android.lark.pb.settings;

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
public final class PullUserEmployeeTypeEnumResponse extends Message<PullUserEmployeeTypeEnumResponse, Builder> {
    public static final ProtoAdapter<PullUserEmployeeTypeEnumResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UserEmployeeType> muser_employee_types;

    public static final class Builder extends Message.Builder<PullUserEmployeeTypeEnumResponse, Builder> {
        public List<UserEmployeeType> muser_employee_types;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUserEmployeeTypeEnumResponse m2207build() {
            return new PullUserEmployeeTypeEnumResponse(this.muser_employee_types, super.buildUnknownFields());
        }

        public Builder() {
            this.muser_employee_types = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2207build();
        }

        public Builder user_employee_types(List<UserEmployeeType> r1) {
            Internal.checkElementsNotNull(r1);
            this.muser_employee_types = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserEmployeeTypeEnumResponse extends ProtoAdapter<PullUserEmployeeTypeEnumResponse> {
        public ProtoAdapter_PullUserEmployeeTypeEnumResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserEmployeeTypeEnumResponse.class);
        }

        public PullUserEmployeeTypeEnumResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.muser_employee_types.add((UserEmployeeType) UserEmployeeType.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2207build();
        }

        public int encodedSize(PullUserEmployeeTypeEnumResponse r4) {
            return UserEmployeeType.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.muser_employee_types) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2208decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUserEmployeeTypeEnumResponse) r1);
        }

        public void encode(ProtoWriter r4, PullUserEmployeeTypeEnumResponse r5) throws IOException {
            UserEmployeeType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.muser_employee_types);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUserEmployeeTypeEnumResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserEmployeeTypeEnumResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2206newBuilder() {
        Builder r0 = new Builder();
        r0.muser_employee_types = Internal.copyOf("muser_employee_types", this.muser_employee_types);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUserEmployeeTypeEnumResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2206newBuilder();
    }

    public PullUserEmployeeTypeEnumResponse(List<UserEmployeeType> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullUserEmployeeTypeEnumResponse(List<UserEmployeeType> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.muser_employee_types = Internal.immutableCopyOf("muser_employee_types", r2);
    }
}
