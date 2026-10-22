package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MailContactMeta extends Message<MailContactMeta, Builder> {
    public static final ProtoAdapter<MailContactMeta> ADAPTER = null;
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final String memail;
    public final String mid;
    public final ContactType mtype;

    public static final class Builder extends Message.Builder<MailContactMeta, Builder> {
        public String memail;
        public String mid;
        public ContactType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MailContactMeta m2678build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new MailContactMeta(this.mid, this.mtype, this.memail, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2678build();
        }

        public Builder email(String r1) {
            this.memail = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder type(ContactType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final enum ContactType extends Enum<ContactType> implements WireEnum {
        private static final /* synthetic */ ContactType[] $VALUES = null;
        public static final ProtoAdapter<ContactType> ADAPTER = null;
        public static final ContactType CHATTER = null;
        public static final ContactType EXTERNAL_CONTACT = null;
        public static final ContactType GROUP = null;
        public static final ContactType MAIL_GROUP = null;
        public static final ContactType NAME_CARD = null;
        public static final ContactType NONE_TYPE = null;
        public static final ContactType SHARED_MAILBOX = null;
        public static final ContactType UNKNOWN = null;
        private final int value;

        static {
            ContactType r0 = new ContactType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ContactType r1 = new ContactType("CHATTER", 1, 1);
            CHATTER = r1;
            ContactType r3 = new ContactType("GROUP", 2, 2);
            GROUP = r3;
            ContactType r5 = new ContactType("EXTERNAL_CONTACT", 3, 3);
            EXTERNAL_CONTACT = r5;
            ContactType r7 = new ContactType("NAME_CARD", 4, 4);
            NAME_CARD = r7;
            ContactType r9 = new ContactType("SHARED_MAILBOX", 5, 5);
            SHARED_MAILBOX = r9;
            ContactType r11 = new ContactType("MAIL_GROUP", 6, 6);
            MAIL_GROUP = r11;
            ContactType r13 = new ContactType("NONE_TYPE", 7, 7);
            NONE_TYPE = r13;
            $VALUES = new ContactType[]{r0, r1, r3, r5, r7, r9, r11, r13};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContactType.class);
        }

        public static ContactType[] values() {
            return (ContactType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ContactType fromValue(int r0) {
            switch(r0) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return NONE_TYPE;
        L8:
            return MAIL_GROUP;
        L10:
            return SHARED_MAILBOX;
        L12:
            return NAME_CARD;
        L14:
            return EXTERNAL_CONTACT;
        L16:
            return GROUP;
        L18:
            return CHATTER;
        L20:
            return UNKNOWN;
        }

        public static ContactType valueOf(String r1) {
            return (ContactType) a.a(ContactType.class, r1);
        }

        private ContactType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_MailContactMeta extends ProtoAdapter<MailContactMeta> {
        public ProtoAdapter_MailContactMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MailContactMeta.class);
        }

        public MailContactMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.memail = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (ContactType) ContactType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.memail = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2678build();
        }

        public int encodedSize(MailContactMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            ContactType r2 = r7.mtype;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ContactType.ADAPTER.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.memail;
            if (r6 == null) goto L10;
            r3 = r0.encodedSizeWithTag(3, r6);
        L10:
            return (r5 + r3) + r7.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2679decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MailContactMeta) r1);
        }

        public void encode(ProtoWriter r5, MailContactMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            ContactType r1 = r6.mtype;
            if (r1 == null) goto L5;
            ContactType.ADAPTER.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.memail;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MailContactMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MailContactMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2677newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.memail = this.memail;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MailContactMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2677newBuilder();
    }

    public MailContactMeta(String r2, ContactType r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MailContactMeta(String r2, ContactType r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mid = r2;
        this.mtype = r3;
        this.memail = r4;
    }
}
