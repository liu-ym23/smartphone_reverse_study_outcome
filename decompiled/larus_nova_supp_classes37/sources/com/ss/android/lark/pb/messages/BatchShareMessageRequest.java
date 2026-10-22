package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BatchShareMessageRequest extends Message<BatchShareMessageRequest, Builder> {
    public static final ProtoAdapter<BatchShareMessageRequest> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_IDS = null;
    private static final long serialVersionUID = 0;
    public final List<String> mchat_ids;
    public final FavShareOption mfav_share_option;
    public final FlagShareOption mflag_share_option;
    public final MessageShareOption mmessage_share_option;
    public final Scene mscene;
    public final List<TargetInfo> mtargets;

    public static final class Builder extends Message.Builder<BatchShareMessageRequest, Builder> {
        public List<String> mchat_ids;
        public FavShareOption mfav_share_option;
        public FlagShareOption mflag_share_option;
        public MessageShareOption mmessage_share_option;
        public Scene mscene;
        public List<TargetInfo> mtargets;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BatchShareMessageRequest m1778build() {
            Scene r0 = this.mscene;
            if (r0 == null) goto L7;
            return new BatchShareMessageRequest(this.mchat_ids, this.mtargets, this.mscene, this.mmessage_share_option, this.mfav_share_option, this.mflag_share_option, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mscene"});
        }

        public Builder() {
            this.mchat_ids = Internal.newMutableList();
            this.mtargets = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1778build();
        }

        public Builder chat_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchat_ids = r1;
            return this;
        }

        public Builder fav_share_option(FavShareOption r1) {
            this.mfav_share_option = r1;
            return this;
        }

        public Builder flag_share_option(FlagShareOption r1) {
            this.mflag_share_option = r1;
            return this;
        }

        public Builder message_share_option(MessageShareOption r1) {
            this.mmessage_share_option = r1;
            return this;
        }

        public Builder scene(Scene r1) {
            this.mscene = r1;
            return this;
        }

        public Builder targets(List<TargetInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtargets = r1;
            return this;
        }
    }

    public static final class FavShareOption extends Message<FavShareOption, Builder> {
        public static final ProtoAdapter<FavShareOption> ADAPTER = null;
        public static final String DEFAULT_FAV_ID = "";
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mfav_id;
        public final String mmessage_id;
        public final String mresource_key;

        public static final class Builder extends Message.Builder<FavShareOption, Builder> {
            public String mfav_id;
            public String mmessage_id;
            public String mresource_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FavShareOption m1780build() {
                String r0 = this.mmessage_id;
                if (r0 == null) goto L9;
                if (this.mresource_key == null) goto L9;
                return new FavShareOption(this.mmessage_id, this.mresource_key, this.mfav_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mmessage_id", this.mresource_key, "mresource_key"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1780build();
            }

            public Builder fav_id(String r1) {
                this.mfav_id = r1;
                return this;
            }

            public Builder message_id(String r1) {
                this.mmessage_id = r1;
                return this;
            }

            public Builder resource_key(String r1) {
                this.mresource_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_FavShareOption extends ProtoAdapter<FavShareOption> {
            public ProtoAdapter_FavShareOption() {
                super(FieldEncoding.LENGTH_DELIMITED, FavShareOption.class);
            }

            public FavShareOption decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmessage_id = "";
                r0.mresource_key = "";
                r0.mfav_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mresource_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mfav_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1780build();
            }

            public int encodedSize(FavShareOption r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r5.mmessage_id) + r0.encodedSizeWithTag(2, r5.mresource_key);
                String r2 = r5.mfav_id;
                if (r2 == null) goto L5;
                int r3 = r0.encodedSizeWithTag(3, r2);
            L7:
                return (r1 + r3) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1781decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((FavShareOption) r1);
            }

            public void encode(ProtoWriter r4, FavShareOption r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mmessage_id);
                r0.encodeWithTag(r4, 2, r5.mresource_key);
                String r1 = r5.mfav_id;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 3, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (FavShareOption) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FavShareOption();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1779newBuilder() {
            Builder r0 = new Builder();
            r0.mmessage_id = this.mmessage_id;
            r0.mresource_key = this.mresource_key;
            r0.mfav_id = this.mfav_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FavShareOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1779newBuilder();
        }

        public FavShareOption(String r2, String r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public FavShareOption(String r2, String r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mmessage_id = r2;
            this.mresource_key = r3;
            this.mfav_id = r4;
        }
    }

    public static final class FlagShareOption extends Message<FlagShareOption, Builder> {
        public static final ProtoAdapter<FlagShareOption> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_ORIGIN_MERGEFORWARD_ID = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mmessage_id;
        public final String morigin_mergeforward_id;
        public final String mresource_key;

        public static final class Builder extends Message.Builder<FlagShareOption, Builder> {
            public String mmessage_id;
            public String morigin_mergeforward_id;
            public String mresource_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FlagShareOption m1783build() {
                String r0 = this.mmessage_id;
                if (r0 == null) goto L9;
                if (this.mresource_key == null) goto L9;
                return new FlagShareOption(this.mmessage_id, this.mresource_key, this.morigin_mergeforward_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mmessage_id", this.mresource_key, "mresource_key"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1783build();
            }

            public Builder message_id(String r1) {
                this.mmessage_id = r1;
                return this;
            }

            public Builder origin_mergeforward_id(String r1) {
                this.morigin_mergeforward_id = r1;
                return this;
            }

            public Builder resource_key(String r1) {
                this.mresource_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_FlagShareOption extends ProtoAdapter<FlagShareOption> {
            public ProtoAdapter_FlagShareOption() {
                super(FieldEncoding.LENGTH_DELIMITED, FlagShareOption.class);
            }

            public FlagShareOption decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmessage_id = "";
                r0.mresource_key = "";
                r0.morigin_mergeforward_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mresource_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.morigin_mergeforward_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1783build();
            }

            public int encodedSize(FlagShareOption r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r5.mmessage_id) + r0.encodedSizeWithTag(2, r5.mresource_key);
                String r2 = r5.morigin_mergeforward_id;
                if (r2 == null) goto L5;
                int r3 = r0.encodedSizeWithTag(3, r2);
            L7:
                return (r1 + r3) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1784decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((FlagShareOption) r1);
            }

            public void encode(ProtoWriter r4, FlagShareOption r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mmessage_id);
                r0.encodeWithTag(r4, 2, r5.mresource_key);
                String r1 = r5.morigin_mergeforward_id;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 3, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (FlagShareOption) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FlagShareOption();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1782newBuilder() {
            Builder r0 = new Builder();
            r0.mmessage_id = this.mmessage_id;
            r0.mresource_key = this.mresource_key;
            r0.morigin_mergeforward_id = this.morigin_mergeforward_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FlagShareOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1782newBuilder();
        }

        public FlagShareOption(String r2, String r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public FlagShareOption(String r2, String r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mmessage_id = r2;
            this.mresource_key = r3;
            this.morigin_mergeforward_id = r4;
        }
    }

    public static final class MessageShareOption extends Message<MessageShareOption, Builder> {
        public static final ProtoAdapter<MessageShareOption> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_ORIGIN_MERGEFORWARD_ID = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mmessage_id;
        public final String morigin_mergeforward_id;
        public final String mresource_key;

        public static final class Builder extends Message.Builder<MessageShareOption, Builder> {
            public String mmessage_id;
            public String morigin_mergeforward_id;
            public String mresource_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MessageShareOption m1786build() {
                String r0 = this.mmessage_id;
                if (r0 == null) goto L9;
                if (this.mresource_key == null) goto L9;
                return new MessageShareOption(this.mmessage_id, this.mresource_key, this.morigin_mergeforward_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mmessage_id", this.mresource_key, "mresource_key"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1786build();
            }

            public Builder message_id(String r1) {
                this.mmessage_id = r1;
                return this;
            }

            public Builder origin_mergeforward_id(String r1) {
                this.morigin_mergeforward_id = r1;
                return this;
            }

            public Builder resource_key(String r1) {
                this.mresource_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageShareOption extends ProtoAdapter<MessageShareOption> {
            public ProtoAdapter_MessageShareOption() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageShareOption.class);
            }

            public MessageShareOption decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmessage_id = "";
                r0.mresource_key = "";
                r0.morigin_mergeforward_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mresource_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.morigin_mergeforward_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1786build();
            }

            public int encodedSize(MessageShareOption r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r5.mmessage_id) + r0.encodedSizeWithTag(2, r5.mresource_key);
                String r2 = r5.morigin_mergeforward_id;
                if (r2 == null) goto L5;
                int r3 = r0.encodedSizeWithTag(3, r2);
            L7:
                return (r1 + r3) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1787decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MessageShareOption) r1);
            }

            public void encode(ProtoWriter r4, MessageShareOption r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mmessage_id);
                r0.encodeWithTag(r4, 2, r5.mresource_key);
                String r1 = r5.morigin_mergeforward_id;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 3, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MessageShareOption) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageShareOption();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1785newBuilder() {
            Builder r0 = new Builder();
            r0.mmessage_id = this.mmessage_id;
            r0.mresource_key = this.mresource_key;
            r0.morigin_mergeforward_id = this.morigin_mergeforward_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MessageShareOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1785newBuilder();
        }

        public MessageShareOption(String r2, String r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public MessageShareOption(String r2, String r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mmessage_id = r2;
            this.mresource_key = r3;
            this.morigin_mergeforward_id = r4;
        }
    }

    public static final class ProtoAdapter_BatchShareMessageRequest extends ProtoAdapter<BatchShareMessageRequest> {
        public ProtoAdapter_BatchShareMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchShareMessageRequest.class);
        }

        public BatchShareMessageRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L18;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r0.mscene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mflag_share_option = (FlagShareOption) FlagShareOption.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mfav_share_option = (FavShareOption) FavShareOption.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mmessage_share_option = (MessageShareOption) MessageShareOption.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mtargets.add((TargetInfo) TargetInfo.ADAPTER.decode(r9));
            goto L3
        L15:
            r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r1);
            return r0.m1778build();
        }

        public int encodedSize(BatchShareMessageRequest r6) {
            int r0 = (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r6.mchat_ids) + TargetInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mtargets)) + Scene.ADAPTER.encodedSizeWithTag(3, r6.mscene);
            MessageShareOption r1 = r6.mmessage_share_option;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = MessageShareOption.ADAPTER.encodedSizeWithTag(4, r1);
        L6:
            int r4 = r0 + r3;
            FavShareOption r5 = r6.mfav_share_option;
            if (r5 == null) goto L9;
            int r7 = FavShareOption.ADAPTER.encodedSizeWithTag(5, r5);
        L10:
            int r8 = r4 + r7;
            FlagShareOption r9 = r6.mflag_share_option;
            if (r9 == null) goto L14;
            r2 = FlagShareOption.ADAPTER.encodedSizeWithTag(6, r9);
        L14:
            return (r8 + r2) + r6.unknownFields().size();
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1788decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BatchShareMessageRequest) r1);
        }

        public void encode(ProtoWriter r4, BatchShareMessageRequest r5) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mchat_ids);
            TargetInfo.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mtargets);
            Scene.ADAPTER.encodeWithTag(r4, 3, r5.mscene);
            MessageShareOption r0 = r5.mmessage_share_option;
            if (r0 == null) goto L5;
            MessageShareOption.ADAPTER.encodeWithTag(r4, 4, r0);
        L5:
            FavShareOption r1 = r5.mfav_share_option;
            if (r1 == null) goto L8;
            FavShareOption.ADAPTER.encodeWithTag(r4, 5, r1);
        L8:
            FlagShareOption r2 = r5.mflag_share_option;
            if (r2 == null) goto L11;
            FlagShareOption.ADAPTER.encodeWithTag(r4, 6, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BatchShareMessageRequest) r2);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene CHAT_MESSAGE_SHARE = null;
        public static final Scene FAV_MESSAGE_SHARE = null;
        public static final Scene FLAG_MESSAGE_SHARE = null;
        private final int value;

        static {
            Scene r0 = new Scene("CHAT_MESSAGE_SHARE", 0, 1);
            CHAT_MESSAGE_SHARE = r0;
            Scene r1 = new Scene("FAV_MESSAGE_SHARE", 1, 2);
            FAV_MESSAGE_SHARE = r1;
            Scene r4 = new Scene("FLAG_MESSAGE_SHARE", 2, 3);
            FLAG_MESSAGE_SHARE = r4;
            $VALUES = new Scene[]{r0, r1, r4};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return null;
        L11:
            return FLAG_MESSAGE_SHARE;
        L13:
            return FAV_MESSAGE_SHARE;
        L15:
            return CHAT_MESSAGE_SHARE;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        private Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class TargetInfo extends Message<TargetInfo, Builder> {
        public static final ProtoAdapter<TargetInfo> ADAPTER = null;
        public static final String DEFAULT_CID = "";
        public static final String DEFAULT_TARGET_ID = "";
        private static final long serialVersionUID = 0;
        public final String mcid;
        public final String mtarget_id;
        public final TargetType mtarget_type;

        public static final class Builder extends Message.Builder<TargetInfo, Builder> {
            public String mcid;
            public String mtarget_id;
            public TargetType mtarget_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TargetInfo m1790build() {
                return new TargetInfo(this.mcid, this.mtarget_type, this.mtarget_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1790build();
            }

            public Builder cid(String r1) {
                this.mcid = r1;
                return this;
            }

            public Builder target_id(String r1) {
                this.mtarget_id = r1;
                return this;
            }

            public Builder target_type(TargetType r1) {
                this.mtarget_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TargetInfo extends ProtoAdapter<TargetInfo> {
            public ProtoAdapter_TargetInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TargetInfo.class);
            }

            public TargetInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mcid = "";
                r0.mtarget_id = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mcid = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mtarget_type = (TargetType) TargetType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mtarget_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m1790build();
            }

            public int encodedSize(TargetInfo r6) {
                String r0 = r6.mcid;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                TargetType r3 = r6.mtarget_type;
                if (r3 == null) goto L9;
                int r4 = TargetType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mtarget_id;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m1791decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TargetInfo) r1);
            }

            public void encode(ProtoWriter r4, TargetInfo r5) throws IOException {
                String r0 = r5.mcid;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                TargetType r1 = r5.mtarget_type;
                if (r1 == null) goto L8;
                TargetType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mtarget_id;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TargetInfo) r2);
            }
        }

        public static final enum TargetType extends Enum<TargetType> implements WireEnum {
            private static final /* synthetic */ TargetType[] $VALUES = null;
            public static final ProtoAdapter<TargetType> ADAPTER = null;
            public static final TargetType CHAT = null;
            public static final TargetType THREAD = null;
            private final int value;

            static {
                TargetType r0 = new TargetType("CHAT", 0, 1);
                CHAT = r0;
                TargetType r1 = new TargetType("THREAD", 1, 2);
                THREAD = r1;
                $VALUES = new TargetType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(TargetType.class);
            }

            public static TargetType[] values() {
                return (TargetType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TargetType fromValue(int r1) {
                if (r1 == 1) goto L11;
                if (r1 == 2) goto L9;
                return null;
            L9:
                return THREAD;
            L11:
                return CHAT;
            }

            public static TargetType valueOf(String r1) {
                return (TargetType) a.a(TargetType.class, r1);
            }

            private TargetType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TargetInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1789newBuilder() {
            Builder r0 = new Builder();
            r0.mcid = this.mcid;
            r0.mtarget_type = this.mtarget_type;
            r0.mtarget_id = this.mtarget_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TargetInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1789newBuilder();
        }

        public TargetInfo(String r2, TargetType r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TargetInfo(String r2, TargetType r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mcid = r2;
            this.mtarget_type = r3;
            this.mtarget_id = r4;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BatchShareMessageRequest();
        FIELD_OPTIONS_MCHAT_IDS = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1777newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
        r0.mtargets = Internal.copyOf("mtargets", this.mtargets);
        r0.mscene = this.mscene;
        r0.mmessage_share_option = this.mmessage_share_option;
        r0.mfav_share_option = this.mfav_share_option;
        r0.mflag_share_option = this.mflag_share_option;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BatchShareMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1777newBuilder();
    }

    public BatchShareMessageRequest(List<String> r9, List<TargetInfo> r10, Scene r11, MessageShareOption r12, FavShareOption r13, FlagShareOption r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public BatchShareMessageRequest(List<String> r2, List<TargetInfo> r3, Scene r4, MessageShareOption r5, FavShareOption r6, FlagShareOption r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r2);
        this.mtargets = Internal.immutableCopyOf("mtargets", r3);
        this.mscene = r4;
        this.mmessage_share_option = r5;
        this.mfav_share_option = r6;
        this.mflag_share_option = r7;
    }
}
