package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
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
public final class UrlPreviewHangPoint extends com.squareup.wire.Message<UrlPreviewHangPoint, Builder> {
    public static final ProtoAdapter<UrlPreviewHangPoint> ADAPTER = null;
    public static final Boolean DEFAULT_IS_LAZY_LOAD = null;
    public static final Boolean DEFAULT_NEED_LOCAL_PREVIEW = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final List<ClientCustomStrategy> mclient_custom_strategies;
    public final Boolean mis_lazy_load;
    public final Boolean mneed_local_preview;
    public final String mpreview_id;
    public final SendScene msend_scene;
    public final String murl;

    public static final class Builder extends com.squareup.wire.Message.Builder<UrlPreviewHangPoint, Builder> {
        public List<ClientCustomStrategy> mclient_custom_strategies;
        public Boolean mis_lazy_load;
        public Boolean mneed_local_preview;
        public String mpreview_id;
        public SendScene msend_scene;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UrlPreviewHangPoint m1679build() {
            String r0 = this.murl;
            if (r0 == null) goto L7;
            return new UrlPreviewHangPoint(this.murl, this.mpreview_id, this.mneed_local_preview, this.mis_lazy_load, this.msend_scene, this.mclient_custom_strategies, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "murl"});
        }

        public Builder() {
            this.mclient_custom_strategies = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1679build();
        }

        public Builder client_custom_strategies(List<ClientCustomStrategy> r1) {
            Internal.checkElementsNotNull(r1);
            this.mclient_custom_strategies = r1;
            return this;
        }

        public Builder is_lazy_load(Boolean r1) {
            this.mis_lazy_load = r1;
            return this;
        }

        public Builder need_local_preview(Boolean r1) {
            this.mneed_local_preview = r1;
            return this;
        }

        public Builder preview_id(String r1) {
            this.mpreview_id = r1;
            return this;
        }

        public Builder send_scene(SendScene r1) {
            this.msend_scene = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final enum ClientContainer extends Enum<ClientContainer> implements WireEnum {
        private static final /* synthetic */ ClientContainer[] $VALUES = null;
        public static final ProtoAdapter<ClientContainer> ADAPTER = null;
        public static final ClientContainer DOUBAO = null;
        public static final ClientContainer FEISHU = null;
        public static final ClientContainer UNKNOWN_CLIENT_CONTAINER = null;
        private final int value;

        static {
            ClientContainer r0 = new ClientContainer("UNKNOWN_CLIENT_CONTAINER", 0, 0);
            UNKNOWN_CLIENT_CONTAINER = r0;
            ClientContainer r1 = new ClientContainer("FEISHU", 1, 1);
            FEISHU = r1;
            ClientContainer r3 = new ClientContainer("DOUBAO", 2, 2);
            DOUBAO = r3;
            $VALUES = new ClientContainer[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ClientContainer.class);
        }

        public static ClientContainer[] values() {
            return (ClientContainer[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ClientContainer fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return DOUBAO;
        L12:
            return FEISHU;
        L14:
            return UNKNOWN_CLIENT_CONTAINER;
        }

        public static ClientContainer valueOf(String r1) {
            return (ClientContainer) a.a(ClientContainer.class, r1);
        }

        private ClientContainer(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ClientCustomStrategy extends com.squareup.wire.Message<ClientCustomStrategy, Builder> {
        public static final ProtoAdapter<ClientCustomStrategy> ADAPTER = null;
        public static final Boolean DEFAULT_IS_LAZY_LOAD = null;
        private static final long serialVersionUID = 0;
        public final ClientContainer mcontainer;
        public final Boolean mis_lazy_load;
        public final PreviewSourceStrategy mstrategy;

        public static final class Builder extends com.squareup.wire.Message.Builder<ClientCustomStrategy, Builder> {
            public ClientContainer mcontainer;
            public Boolean mis_lazy_load;
            public PreviewSourceStrategy mstrategy;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ClientCustomStrategy m1681build() {
                return new ClientCustomStrategy(this.mcontainer, this.mstrategy, this.mis_lazy_load, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1681build();
            }

            public Builder container(ClientContainer r1) {
                this.mcontainer = r1;
                return this;
            }

            public Builder is_lazy_load(Boolean r1) {
                this.mis_lazy_load = r1;
                return this;
            }

            public Builder strategy(PreviewSourceStrategy r1) {
                this.mstrategy = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ClientCustomStrategy extends ProtoAdapter<ClientCustomStrategy> {
            public ProtoAdapter_ClientCustomStrategy() {
                super(FieldEncoding.LENGTH_DELIMITED, ClientCustomStrategy.class);
            }

            public ClientCustomStrategy decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mis_lazy_load = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mcontainer = (ClientContainer) ClientContainer.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mstrategy = (PreviewSourceStrategy) PreviewSourceStrategy.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mis_lazy_load = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1681build();
            }

            public int encodedSize(ClientCustomStrategy r6) {
                ClientContainer r0 = r6.mcontainer;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ClientContainer.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                PreviewSourceStrategy r3 = r6.mstrategy;
                if (r3 == null) goto L9;
                int r4 = PreviewSourceStrategy.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mis_lazy_load;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m1682decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ClientCustomStrategy) r1);
            }

            public void encode(ProtoWriter r4, ClientCustomStrategy r5) throws IOException {
                ClientContainer r0 = r5.mcontainer;
                if (r0 == null) goto L5;
                ClientContainer.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                PreviewSourceStrategy r1 = r5.mstrategy;
                if (r1 == null) goto L8;
                PreviewSourceStrategy.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mis_lazy_load;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ClientCustomStrategy) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ClientCustomStrategy();
            DEFAULT_IS_LAZY_LOAD = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1680newBuilder() {
            Builder r0 = new Builder();
            r0.mcontainer = this.mcontainer;
            r0.mstrategy = this.mstrategy;
            r0.mis_lazy_load = this.mis_lazy_load;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ClientCustomStrategy.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1680newBuilder();
        }

        public ClientCustomStrategy(ClientContainer r2, PreviewSourceStrategy r3, Boolean r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public ClientCustomStrategy(ClientContainer r2, PreviewSourceStrategy r3, Boolean r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mcontainer = r2;
            this.mstrategy = r3;
            this.mis_lazy_load = r4;
        }
    }

    public static final enum PreviewSourceStrategy extends Enum<PreviewSourceStrategy> implements WireEnum {
        private static final /* synthetic */ PreviewSourceStrategy[] $VALUES = null;
        public static final ProtoAdapter<PreviewSourceStrategy> ADAPTER = null;
        public static final PreviewSourceStrategy CLIENT_CRAWL = null;
        public static final PreviewSourceStrategy DISABLED = null;
        public static final PreviewSourceStrategy SERVER_PULL = null;
        public static final PreviewSourceStrategy UNKNOWN_PREVIEW_SOURCE_STRATEGY = null;
        private final int value;

        static {
            PreviewSourceStrategy r0 = new PreviewSourceStrategy("UNKNOWN_PREVIEW_SOURCE_STRATEGY", 0, 0);
            UNKNOWN_PREVIEW_SOURCE_STRATEGY = r0;
            PreviewSourceStrategy r1 = new PreviewSourceStrategy("SERVER_PULL", 1, 1);
            SERVER_PULL = r1;
            PreviewSourceStrategy r3 = new PreviewSourceStrategy("CLIENT_CRAWL", 2, 2);
            CLIENT_CRAWL = r3;
            PreviewSourceStrategy r5 = new PreviewSourceStrategy("DISABLED", 3, 3);
            DISABLED = r5;
            $VALUES = new PreviewSourceStrategy[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(PreviewSourceStrategy.class);
        }

        public static PreviewSourceStrategy[] values() {
            return (PreviewSourceStrategy[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static PreviewSourceStrategy fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return DISABLED;
        L14:
            return CLIENT_CRAWL;
        L16:
            return SERVER_PULL;
        L18:
            return UNKNOWN_PREVIEW_SOURCE_STRATEGY;
        }

        public static PreviewSourceStrategy valueOf(String r1) {
            return (PreviewSourceStrategy) a.a(PreviewSourceStrategy.class, r1);
        }

        private PreviewSourceStrategy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_UrlPreviewHangPoint extends ProtoAdapter<UrlPreviewHangPoint> {
        public ProtoAdapter_UrlPreviewHangPoint() {
            super(FieldEncoding.LENGTH_DELIMITED, UrlPreviewHangPoint.class);
        }

        public UrlPreviewHangPoint decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.murl = "";
            r0.mpreview_id = "";
            Boolean r1 = Boolean.FALSE;
            r0.mneed_local_preview = r1;
            r0.mis_lazy_load = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r0.msend_scene = (SendScene) SendScene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mclient_custom_strategies.add((ClientCustomStrategy) ClientCustomStrategy.ADAPTER.decode(r9));
            goto L3
        L12:
            r0.mis_lazy_load = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            r0.mneed_local_preview = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            r0.mpreview_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.murl = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r2);
            return r0.m1679build();
        }

        public int encodedSize(UrlPreviewHangPoint r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.murl);
            String r2 = r6.mpreview_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Boolean r7 = r6.mneed_local_preview;
            if (r7 == null) goto L9;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L10:
            int r9 = r5 + r8;
            Boolean r10 = r6.mis_lazy_load;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            SendScene r13 = r6.msend_scene;
            if (r13 == null) goto L18;
            r3 = SendScene.ADAPTER.encodedSizeWithTag(5, r13);
        L18:
            return ((r12 + r3) + ClientCustomStrategy.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.mclient_custom_strategies)) + r6.unknownFields().size();
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1683decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UrlPreviewHangPoint) r1);
        }

        public void encode(ProtoWriter r4, UrlPreviewHangPoint r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.murl);
            String r1 = r5.mpreview_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            Boolean r2 = r5.mneed_local_preview;
            if (r2 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L8:
            Boolean r3 = r5.mis_lazy_load;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L11:
            SendScene r6 = r5.msend_scene;
            if (r6 == null) goto L14;
            SendScene.ADAPTER.encodeWithTag(r4, 5, r6);
        L14:
            ClientCustomStrategy.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.mclient_custom_strategies);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UrlPreviewHangPoint) r2);
        }
    }

    public static final enum SendScene extends Enum<SendScene> implements WireEnum {
        private static final /* synthetic */ SendScene[] $VALUES = null;
        public static final ProtoAdapter<SendScene> ADAPTER = null;
        public static final SendScene DEFAULT = null;
        public static final SendScene DOUBAO_CLOUD_DRIVE_CHOOSE = null;
        private final int value;

        static {
            SendScene r0 = new SendScene("DEFAULT", 0, 0);
            DEFAULT = r0;
            SendScene r1 = new SendScene("DOUBAO_CLOUD_DRIVE_CHOOSE", 1, 1);
            DOUBAO_CLOUD_DRIVE_CHOOSE = r1;
            $VALUES = new SendScene[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(SendScene.class);
        }

        public static SendScene[] values() {
            return (SendScene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SendScene fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return DOUBAO_CLOUD_DRIVE_CHOOSE;
        L10:
            return DEFAULT;
        }

        public static SendScene valueOf(String r1) {
            return (SendScene) a.a(SendScene.class, r1);
        }

        private SendScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UrlPreviewHangPoint();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_NEED_LOCAL_PREVIEW = r0;
        DEFAULT_IS_LAZY_LOAD = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1678newBuilder() {
        Builder r0 = new Builder();
        r0.murl = this.murl;
        r0.mpreview_id = this.mpreview_id;
        r0.mneed_local_preview = this.mneed_local_preview;
        r0.mis_lazy_load = this.mis_lazy_load;
        r0.msend_scene = this.msend_scene;
        r0.mclient_custom_strategies = Internal.copyOf("mclient_custom_strategies", this.mclient_custom_strategies);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UrlPreviewHangPoint.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1678newBuilder();
    }

    public UrlPreviewHangPoint(String r9, String r10, Boolean r11, Boolean r12, SendScene r13, List<ClientCustomStrategy> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public UrlPreviewHangPoint(String r2, String r3, Boolean r4, Boolean r5, SendScene r6, List<ClientCustomStrategy> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.murl = r2;
        this.mpreview_id = r3;
        this.mneed_local_preview = r4;
        this.mis_lazy_load = r5;
        this.msend_scene = r6;
        this.mclient_custom_strategies = Internal.immutableCopyOf("mclient_custom_strategies", r7);
    }
}
