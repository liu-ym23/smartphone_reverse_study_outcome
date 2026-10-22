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
public final class AccessibleInfo extends com.squareup.wire.Message<AccessibleInfo, Builder> {
    public static final ProtoAdapter<AccessibleInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ACCESSIBLE = null;
    private static final long serialVersionUID = 0;
    public final InaccessibleCode minaccessible_code;
    public final Boolean mis_accessible;

    public static final class Builder extends com.squareup.wire.Message.Builder<AccessibleInfo, Builder> {
        public InaccessibleCode minaccessible_code;
        public Boolean mis_accessible;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AccessibleInfo m998build() {
            return new AccessibleInfo(this.mis_accessible, this.minaccessible_code, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m998build();
        }

        public Builder inaccessible_code(InaccessibleCode r1) {
            this.minaccessible_code = r1;
            return this;
        }

        public Builder is_accessible(Boolean r1) {
            this.mis_accessible = r1;
            return this;
        }
    }

    public static final enum InaccessibleCode extends Enum<InaccessibleCode> implements WireEnum {
        private static final /* synthetic */ InaccessibleCode[] $VALUES = null;
        public static final ProtoAdapter<InaccessibleCode> ADAPTER = null;
        public static final InaccessibleCode CROSS_TENANT = null;
        public static final InaccessibleCode DEFAULT = null;
        public static final InaccessibleCode EMPTY_NAME = null;
        public static final InaccessibleCode EMPTY_PHONE = null;
        public static final InaccessibleCode EXECUTIVES = null;
        public static final InaccessibleCode NOT_FRIEND = null;
        private final int value;

        static {
            InaccessibleCode r0 = new InaccessibleCode("DEFAULT", 0, 0);
            DEFAULT = r0;
            InaccessibleCode r1 = new InaccessibleCode("EXECUTIVES", 1, 1);
            EXECUTIVES = r1;
            InaccessibleCode r3 = new InaccessibleCode("EMPTY_NAME", 2, 2);
            EMPTY_NAME = r3;
            InaccessibleCode r5 = new InaccessibleCode("EMPTY_PHONE", 3, 3);
            EMPTY_PHONE = r5;
            InaccessibleCode r7 = new InaccessibleCode("CROSS_TENANT", 4, 4);
            CROSS_TENANT = r7;
            InaccessibleCode r9 = new InaccessibleCode("NOT_FRIEND", 5, 5);
            NOT_FRIEND = r9;
            $VALUES = new InaccessibleCode[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(InaccessibleCode.class);
        }

        public static InaccessibleCode[] values() {
            return (InaccessibleCode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static InaccessibleCode fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return NOT_FRIEND;
        L18:
            return CROSS_TENANT;
        L20:
            return EMPTY_PHONE;
        L22:
            return EMPTY_NAME;
        L24:
            return EXECUTIVES;
        L26:
            return DEFAULT;
        }

        public static InaccessibleCode valueOf(String r1) {
            return (InaccessibleCode) a.a(InaccessibleCode.class, r1);
        }

        private InaccessibleCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_AccessibleInfo extends ProtoAdapter<AccessibleInfo> {
        public ProtoAdapter_AccessibleInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AccessibleInfo.class);
        }

        public AccessibleInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_accessible = Boolean.TRUE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mis_accessible = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.minaccessible_code = (InaccessibleCode) InaccessibleCode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m998build();
        }

        public int encodedSize(AccessibleInfo r5) {
            Boolean r0 = r5.mis_accessible;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            InaccessibleCode r3 = r5.minaccessible_code;
            if (r3 == null) goto L10;
            r1 = InaccessibleCode.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m999decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AccessibleInfo) r1);
        }

        public void encode(ProtoWriter r4, AccessibleInfo r5) throws IOException {
            Boolean r0 = r5.mis_accessible;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            InaccessibleCode r1 = r5.minaccessible_code;
            if (r1 == null) goto L8;
            InaccessibleCode.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AccessibleInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AccessibleInfo();
        DEFAULT_IS_ACCESSIBLE = Boolean.TRUE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m997newBuilder() {
        Builder r0 = new Builder();
        r0.mis_accessible = this.mis_accessible;
        r0.minaccessible_code = this.minaccessible_code;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AccessibleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m997newBuilder();
    }

    public AccessibleInfo(Boolean r2, InaccessibleCode r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public AccessibleInfo(Boolean r2, InaccessibleCode r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mis_accessible = r2;
        this.minaccessible_code = r3;
    }
}
