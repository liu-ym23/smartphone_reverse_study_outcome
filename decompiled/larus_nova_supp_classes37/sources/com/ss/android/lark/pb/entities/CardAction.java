package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.improto.Command;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CardAction extends com.squareup.wire.Message<CardAction, Builder> {
    public static final ProtoAdapter<CardAction> ADAPTER = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Command mcmd;
    public final Method mmethod;
    public final Url mopen_url;
    public final CardActionPacket mpacket;
    public final Parameters mparameters;
    public final RequiredParameters mrequired_parameters;
    public final String murl;

    public static final class Builder extends com.squareup.wire.Message.Builder<CardAction, Builder> {
        public Command mcmd;
        public Method mmethod;
        public Url mopen_url;
        public CardActionPacket mpacket;
        public Parameters mparameters;
        public RequiredParameters mrequired_parameters;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CardAction m1040build() {
            String r0 = this.murl;
            if (r0 == null) goto L9;
            if (this.mmethod == null) goto L9;
            return new CardAction(this.murl, this.mmethod, this.mrequired_parameters, this.mparameters, this.mcmd, this.mpacket, this.mopen_url, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "murl", this.mmethod, "mmethod"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1040build();
        }

        public Builder cmd(Command r1) {
            this.mcmd = r1;
            return this;
        }

        public Builder method(Method r1) {
            this.mmethod = r1;
            return this;
        }

        public Builder open_url(Url r1) {
            this.mopen_url = r1;
            return this;
        }

        public Builder packet(CardActionPacket r1) {
            this.mpacket = r1;
            return this;
        }

        public Builder parameters(Parameters r1) {
            this.mparameters = r1;
            return this;
        }

        public Builder required_parameters(RequiredParameters r1) {
            this.mrequired_parameters = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class MessageInfo extends com.squareup.wire.Message<MessageInfo, Builder> {
        public static final ProtoAdapter<MessageInfo> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_OPEN_ID = "";
        private static final long serialVersionUID = 0;
        public final String mmessage_open_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageInfo, Builder> {
            public String mmessage_open_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MessageInfo m1042build() {
                return new MessageInfo(this.mmessage_open_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1042build();
            }

            public Builder message_open_id(String r1) {
                this.mmessage_open_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageInfo extends ProtoAdapter<MessageInfo> {
            public ProtoAdapter_MessageInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageInfo.class);
            }

            public MessageInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmessage_open_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 2) goto L7;
                r0.mmessage_open_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1042build();
            }

            public int encodedSize(MessageInfo r4) {
                String r0 = r4.mmessage_open_id;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1043decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MessageInfo) r1);
            }

            public void encode(ProtoWriter r4, MessageInfo r5) throws IOException {
                String r0 = r5.mmessage_open_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MessageInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1041newBuilder() {
            Builder r0 = new Builder();
            r0.mmessage_open_id = this.mmessage_open_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MessageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1041newBuilder();
        }

        public MessageInfo(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public MessageInfo(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mmessage_open_id = r2;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        public static final Method UNKNOWN_METHOD = null;
        private final int value;

        static {
            Method r0 = new Method("UNKNOWN_METHOD", 0, 0);
            UNKNOWN_METHOD = r0;
            Method r1 = new Method("GET", 1, 1);
            GET = r1;
            Method r3 = new Method("POST", 2, 2);
            POST = r3;
            Method r5 = new Method("LARK_COMMAND", 3, 3);
            LARK_COMMAND = r5;
            Method r7 = new Method("OPEN_URL", 4, 4);
            OPEN_URL = r7;
            $VALUES = new Method[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(Method.class);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Method fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return OPEN_URL;
        L16:
            return LARK_COMMAND;
        L18:
            return POST;
        L20:
            return GET;
        L22:
            return UNKNOWN_METHOD;
        }

        public static Method valueOf(String r1) {
            return (Method) a.a(Method.class, r1);
        }

        private Method(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Parameters extends com.squareup.wire.Message<Parameters, Builder> {
        public static final ProtoAdapter<Parameters> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String mmessage_id;
        public final MessageInfo mmessage_info;
        public final Map<String, String> mparameters;
        public final String muser_id;
        public final UserInfo muser_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<Parameters, Builder> {
            public String mmessage_id;
            public MessageInfo mmessage_info;
            public Map<String, String> mparameters;
            public String muser_id;
            public UserInfo muser_info;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Parameters m1045build() {
                return new Parameters(this.mparameters, this.muser_info, this.mmessage_info, this.muser_id, this.mmessage_id, super.buildUnknownFields());
            }

            public Builder() {
                this.mparameters = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1045build();
            }

            public Builder message_id(String r1) {
                this.mmessage_id = r1;
                return this;
            }

            public Builder message_info(MessageInfo r1) {
                this.mmessage_info = r1;
                return this;
            }

            public Builder parameters(Map<String, String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mparameters = r1;
                return this;
            }

            public Builder user_id(String r1) {
                this.muser_id = r1;
                return this;
            }

            public Builder user_info(UserInfo r1) {
                this.muser_info = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Parameters extends ProtoAdapter<Parameters> {
            private final ProtoAdapter<Map<String, String>> mparameters;

            public ProtoAdapter_Parameters() {
                super(FieldEncoding.LENGTH_DELIMITED, Parameters.class);
                ProtoAdapter r0 = ProtoAdapter.STRING;
                this.mparameters = ProtoAdapter.newMapAdapter(r0, r0);
            }

            public Parameters decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.muser_id = "";
                r0.mmessage_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mparameters.putAll((Map) this.mparameters.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.muser_info = (UserInfo) UserInfo.ADAPTER.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mmessage_info = (MessageInfo) MessageInfo.ADAPTER.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.muser_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1045build();
            }

            public int encodedSize(Parameters r6) {
                int r0 = this.mparameters.encodedSizeWithTag(1, r6.mparameters);
                UserInfo r1 = r6.muser_info;
                int r2 = 0;
                if (r1 == null) goto L5;
                int r3 = UserInfo.ADAPTER.encodedSizeWithTag(2, r1);
            L6:
                int r4 = r0 + r3;
                MessageInfo r5 = r6.mmessage_info;
                if (r5 == null) goto L9;
                int r7 = MessageInfo.ADAPTER.encodedSizeWithTag(3, r5);
            L10:
                int r8 = r4 + r7;
                String r9 = r6.muser_id;
                if (r9 == null) goto L13;
                int r10 = ProtoAdapter.STRING.encodedSizeWithTag(4, r9);
            L14:
                int r11 = r8 + r10;
                String r12 = r6.mmessage_id;
                if (r12 == null) goto L18;
                r2 = ProtoAdapter.STRING.encodedSizeWithTag(5, r12);
            L18:
                return (r11 + r2) + r6.unknownFields().size();
            L13:
                r10 = 0;
                goto L14
            L9:
                r7 = 0;
                goto L10
            L5:
                r3 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1046decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Parameters) r1);
            }

            public void encode(ProtoWriter r4, Parameters r5) throws IOException {
                this.mparameters.encodeWithTag(r4, 1, r5.mparameters);
                UserInfo r0 = r5.muser_info;
                if (r0 == null) goto L5;
                UserInfo.ADAPTER.encodeWithTag(r4, 2, r0);
            L5:
                MessageInfo r1 = r5.mmessage_info;
                if (r1 == null) goto L8;
                MessageInfo.ADAPTER.encodeWithTag(r4, 3, r1);
            L8:
                String r2 = r5.muser_id;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
            L11:
                String r3 = r5.mmessage_id;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Parameters) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Parameters();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1044newBuilder() {
            Builder r0 = new Builder();
            r0.mparameters = Internal.copyOf("mparameters", this.mparameters);
            r0.muser_info = this.muser_info;
            r0.mmessage_info = this.mmessage_info;
            r0.muser_id = this.muser_id;
            r0.mmessage_id = this.mmessage_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Parameters.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1044newBuilder();
        }

        public Parameters(Map<String, String> r8, UserInfo r9, MessageInfo r10, String r11, String r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public Parameters(Map<String, String> r2, UserInfo r3, MessageInfo r4, String r5, String r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mparameters = Internal.immutableCopyOf("mparameters", r2);
            this.muser_info = r3;
            this.mmessage_info = r4;
            this.muser_id = r5;
            this.mmessage_id = r6;
        }
    }

    public static final class ProtoAdapter_CardAction extends ProtoAdapter<CardAction> {
        public ProtoAdapter_CardAction() {
            super(FieldEncoding.LENGTH_DELIMITED, CardAction.class);
        }

        public CardAction decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.murl = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L22;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L24;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L22:
            r0.mmethod = (Method) Method.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r0.mcmd = (Command) Command.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mopen_url = (Url) Url.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mpacket = (CardActionPacket) CardActionPacket.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mparameters = (Parameters) Parameters.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mrequired_parameters = (RequiredParameters) RequiredParameters.ADAPTER.decode(r9);
            goto L3
        L19:
            r0.murl = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r1);
            return r0.m1040build();
        }

        public int encodedSize(CardAction r6) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r6.murl) + Method.ADAPTER.encodedSizeWithTag(2, r6.mmethod);
            RequiredParameters r1 = r6.mrequired_parameters;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = RequiredParameters.ADAPTER.encodedSizeWithTag(3, r1);
        L6:
            int r4 = r0 + r3;
            Parameters r5 = r6.mparameters;
            if (r5 == null) goto L9;
            int r7 = Parameters.ADAPTER.encodedSizeWithTag(4, r5);
        L10:
            int r8 = r4 + r7;
            Command r9 = r6.mcmd;
            if (r9 == null) goto L13;
            int r10 = Command.ADAPTER.encodedSizeWithTag(5, r9);
        L14:
            int r11 = r8 + r10;
            CardActionPacket r12 = r6.mpacket;
            if (r12 == null) goto L17;
            int r13 = CardActionPacket.ADAPTER.encodedSizeWithTag(6, r12);
        L18:
            int r14 = r11 + r13;
            Url r15 = r6.mopen_url;
            if (r15 == null) goto L22;
            r2 = Url.ADAPTER.encodedSizeWithTag(7, r15);
        L22:
            return (r14 + r2) + r6.unknownFields().size();
        L17:
            r13 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1047decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CardAction) r1);
        }

        public void encode(ProtoWriter r4, CardAction r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.murl);
            Method.ADAPTER.encodeWithTag(r4, 2, r5.mmethod);
            RequiredParameters r0 = r5.mrequired_parameters;
            if (r0 == null) goto L5;
            RequiredParameters.ADAPTER.encodeWithTag(r4, 3, r0);
        L5:
            Parameters r1 = r5.mparameters;
            if (r1 == null) goto L8;
            Parameters.ADAPTER.encodeWithTag(r4, 4, r1);
        L8:
            Command r2 = r5.mcmd;
            if (r2 == null) goto L11;
            Command.ADAPTER.encodeWithTag(r4, 5, r2);
        L11:
            CardActionPacket r3 = r5.mpacket;
            if (r3 == null) goto L14;
            CardActionPacket.ADAPTER.encodeWithTag(r4, 6, r3);
        L14:
            Url r6 = r5.mopen_url;
            if (r6 == null) goto L17;
            Url.ADAPTER.encodeWithTag(r4, 7, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CardAction) r2);
        }
    }

    public static final class RequiredParameters extends com.squareup.wire.Message<RequiredParameters, Builder> {
        public static final ProtoAdapter<RequiredParameters> ADAPTER = null;
        public static final Boolean DEFAULT_NEED_MESSAGE_ID = null;
        public static final Boolean DEFAULT_NEED_MESSAGE_INFO = null;
        public static final Boolean DEFAULT_NEED_USER_ID = null;
        public static final Boolean DEFAULT_NEED_USER_INFO = null;
        private static final long serialVersionUID = 0;
        public final Boolean mneed_message_id;
        public final Boolean mneed_message_info;
        public final Boolean mneed_user_id;
        public final Boolean mneed_user_info;

        public static final class Builder extends com.squareup.wire.Message.Builder<RequiredParameters, Builder> {
            public Boolean mneed_message_id;
            public Boolean mneed_message_info;
            public Boolean mneed_user_id;
            public Boolean mneed_user_info;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RequiredParameters m1049build() {
                return new RequiredParameters(this.mneed_user_info, this.mneed_message_info, this.mneed_user_id, this.mneed_message_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1049build();
            }

            public Builder need_message_id(Boolean r1) {
                this.mneed_message_id = r1;
                return this;
            }

            public Builder need_message_info(Boolean r1) {
                this.mneed_message_info = r1;
                return this;
            }

            public Builder need_user_id(Boolean r1) {
                this.mneed_user_id = r1;
                return this;
            }

            public Builder need_user_info(Boolean r1) {
                this.mneed_user_info = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RequiredParameters extends ProtoAdapter<RequiredParameters> {
            public ProtoAdapter_RequiredParameters() {
                super(FieldEncoding.LENGTH_DELIMITED, RequiredParameters.class);
            }

            public RequiredParameters decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mneed_user_info = r1;
                r0.mneed_message_info = r1;
                r0.mneed_user_id = r1;
                r0.mneed_message_id = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mneed_user_info = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mneed_message_info = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mneed_user_id = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mneed_message_id = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r2);
                return r0.m1049build();
            }

            public int encodedSize(RequiredParameters r6) {
                Boolean r0 = r6.mneed_user_info;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mneed_message_info;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mneed_user_id;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r6.mneed_message_id;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
            L18:
                return (r9 + r1) + r6.unknownFields().size();
            L13:
                r8 = 0;
                goto L14
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1050decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RequiredParameters) r1);
            }

            public void encode(ProtoWriter r4, RequiredParameters r5) throws IOException {
                Boolean r0 = r5.mneed_user_info;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mneed_message_info;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mneed_user_id;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                Boolean r3 = r5.mneed_message_id;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RequiredParameters) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RequiredParameters();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_NEED_USER_INFO = r0;
            DEFAULT_NEED_MESSAGE_INFO = r0;
            DEFAULT_NEED_USER_ID = r0;
            DEFAULT_NEED_MESSAGE_ID = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1048newBuilder() {
            Builder r0 = new Builder();
            r0.mneed_user_info = this.mneed_user_info;
            r0.mneed_message_info = this.mneed_message_info;
            r0.mneed_user_id = this.mneed_user_id;
            r0.mneed_message_id = this.mneed_message_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RequiredParameters.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1048newBuilder();
        }

        public RequiredParameters(Boolean r7, Boolean r8, Boolean r9, Boolean r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public RequiredParameters(Boolean r2, Boolean r3, Boolean r4, Boolean r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mneed_user_info = r2;
            this.mneed_message_info = r3;
            this.mneed_user_id = r4;
            this.mneed_message_id = r5;
        }
    }

    public static final class Url extends com.squareup.wire.Message<Url, Builder> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_HARMONY_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String mandroid_url;
        public final String mharmony_url;
        public final String mios_url;
        public final String mpc_url;
        public final String murl;

        public static final class Builder extends com.squareup.wire.Message.Builder<Url, Builder> {
            public String mandroid_url;
            public String mharmony_url;
            public String mios_url;
            public String mpc_url;
            public String murl;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Url m1052build() {
                return new Url(this.murl, this.mios_url, this.mandroid_url, this.mpc_url, this.mharmony_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1052build();
            }

            public Builder android_url(String r1) {
                this.mandroid_url = r1;
                return this;
            }

            public Builder harmony_url(String r1) {
                this.mharmony_url = r1;
                return this;
            }

            public Builder ios_url(String r1) {
                this.mios_url = r1;
                return this;
            }

            public Builder pc_url(String r1) {
                this.mpc_url = r1;
                return this;
            }

            public Builder url(String r1) {
                this.murl = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Url extends ProtoAdapter<Url> {
            public ProtoAdapter_Url() {
                super(FieldEncoding.LENGTH_DELIMITED, Url.class);
            }

            public Url decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.murl = "";
                r0.mios_url = "";
                r0.mandroid_url = "";
                r0.mpc_url = "";
                r0.mharmony_url = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.murl = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mios_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mandroid_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.mpc_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mharmony_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1052build();
            }

            public int encodedSize(Url r6) {
                String r0 = r6.murl;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mios_url;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mandroid_url;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mpc_url;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.mharmony_url;
                if (r13 == null) goto L22;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1053decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Url) r1);
            }

            public void encode(ProtoWriter r4, Url r5) throws IOException {
                String r0 = r5.murl;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mios_url;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mandroid_url;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mpc_url;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                String r6 = r5.mharmony_url;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Url) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Url();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1051newBuilder() {
            Builder r0 = new Builder();
            r0.murl = this.murl;
            r0.mios_url = this.mios_url;
            r0.mandroid_url = this.mandroid_url;
            r0.mpc_url = this.mpc_url;
            r0.mharmony_url = this.mharmony_url;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Url.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1051newBuilder();
        }

        public Url(String r8, String r9, String r10, String r11, String r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public Url(String r2, String r3, String r4, String r5, String r6, ByteString r7) {
            super(ADAPTER, r7);
            this.murl = r2;
            this.mios_url = r3;
            this.mandroid_url = r4;
            this.mpc_url = r5;
            this.mharmony_url = r6;
        }
    }

    public static final class UserInfo extends com.squareup.wire.Message<UserInfo, Builder> {
        public static final ProtoAdapter<UserInfo> ADAPTER = null;
        public static final String DEFAULT_USER_OPEN_ID = "";
        private static final long serialVersionUID = 0;
        public final String muser_open_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<UserInfo, Builder> {
            public String muser_open_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UserInfo m1055build() {
                return new UserInfo(this.muser_open_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1055build();
            }

            public Builder user_open_id(String r1) {
                this.muser_open_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_UserInfo extends ProtoAdapter<UserInfo> {
            public ProtoAdapter_UserInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, UserInfo.class);
            }

            public UserInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.muser_open_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.muser_open_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1055build();
            }

            public int encodedSize(UserInfo r4) {
                String r0 = r4.muser_open_id;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1056decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UserInfo) r1);
            }

            public void encode(ProtoWriter r4, UserInfo r5) throws IOException {
                String r0 = r5.muser_open_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UserInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1054newBuilder() {
            Builder r0 = new Builder();
            r0.muser_open_id = this.muser_open_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UserInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1054newBuilder();
        }

        public UserInfo(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public UserInfo(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_open_id = r2;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardAction();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1039newBuilder() {
        Builder r0 = new Builder();
        r0.murl = this.murl;
        r0.mmethod = this.mmethod;
        r0.mrequired_parameters = this.mrequired_parameters;
        r0.mparameters = this.mparameters;
        r0.mcmd = this.mcmd;
        r0.mpacket = this.mpacket;
        r0.mopen_url = this.mopen_url;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CardAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1039newBuilder();
    }

    public CardAction(String r10, Method r11, RequiredParameters r12, Parameters r13, Command r14, CardActionPacket r15, Url r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public CardAction(String r2, Method r3, RequiredParameters r4, Parameters r5, Command r6, CardActionPacket r7, Url r8, ByteString r9) {
        super(ADAPTER, r9);
        this.murl = r2;
        this.mmethod = r3;
        this.mrequired_parameters = r4;
        this.mparameters = r5;
        this.mcmd = r6;
        this.mpacket = r7;
        this.mopen_url = r8;
    }
}
