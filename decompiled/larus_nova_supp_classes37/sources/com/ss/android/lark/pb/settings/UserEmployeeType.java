package com.ss.android.lark.pb.settings;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserEmployeeType extends Message<UserEmployeeType, Builder> {
    public static final ProtoAdapter<UserEmployeeType> ADAPTER = null;
    public static final String DEFAULT_EMPLOYEE_TYPE_ID = "";
    public static final String DEFAULT_EMPLOYEE_TYPE_NAME = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> memployee_type_i18n_name;
    public final String memployee_type_id;
    public final String memployee_type_name;

    public static final class Builder extends Message.Builder<UserEmployeeType, Builder> {
        public Map<String, String> memployee_type_i18n_name;
        public String memployee_type_id;
        public String memployee_type_name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserEmployeeType m2216build() {
            return new UserEmployeeType(this.memployee_type_id, this.memployee_type_name, this.memployee_type_i18n_name, super.buildUnknownFields());
        }

        public Builder() {
            this.memployee_type_i18n_name = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2216build();
        }

        public Builder employee_type_i18n_name(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.memployee_type_i18n_name = r1;
            return this;
        }

        public Builder employee_type_id(String r1) {
            this.memployee_type_id = r1;
            return this;
        }

        public Builder employee_type_name(String r1) {
            this.memployee_type_name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserEmployeeType extends ProtoAdapter<UserEmployeeType> {
        private final ProtoAdapter<Map<String, String>> memployee_type_i18n_name;

        public ProtoAdapter_UserEmployeeType() {
            super(FieldEncoding.LENGTH_DELIMITED, UserEmployeeType.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.memployee_type_i18n_name = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public UserEmployeeType decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.memployee_type_id = "";
            r0.memployee_type_name = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.memployee_type_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.memployee_type_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.memployee_type_i18n_name.putAll((Map) this.memployee_type_i18n_name.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2216build();
        }

        public int encodedSize(UserEmployeeType r5) {
            String r0 = r5.memployee_type_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.memployee_type_name;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + this.memployee_type_i18n_name.encodedSizeWithTag(3, r5.memployee_type_i18n_name)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2217decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserEmployeeType) r1);
        }

        public void encode(ProtoWriter r4, UserEmployeeType r5) throws IOException {
            String r0 = r5.memployee_type_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.memployee_type_name;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            this.memployee_type_i18n_name.encodeWithTag(r4, 3, r5.memployee_type_i18n_name);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserEmployeeType) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserEmployeeType();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2215newBuilder() {
        Builder r0 = new Builder();
        r0.memployee_type_id = this.memployee_type_id;
        r0.memployee_type_name = this.memployee_type_name;
        r0.memployee_type_i18n_name = Internal.copyOf("memployee_type_i18n_name", this.memployee_type_i18n_name);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserEmployeeType.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2215newBuilder();
    }

    public UserEmployeeType(String r2, String r3, Map<String, String> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public UserEmployeeType(String r2, String r3, Map<String, String> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.memployee_type_id = r2;
        this.memployee_type_name = r3;
        this.memployee_type_i18n_name = Internal.immutableCopyOf("memployee_type_i18n_name", r4);
    }
}
