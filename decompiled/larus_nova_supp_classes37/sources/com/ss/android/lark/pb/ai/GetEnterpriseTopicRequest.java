package com.ss.android.lark.pb.ai;

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
public final class GetEnterpriseTopicRequest extends Message<GetEnterpriseTopicRequest, Builder> {
    public static final ProtoAdapter<GetEnterpriseTopicRequest> ADAPTER = null;
    public static final String DEFAULT_ABBR_ID = "";
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String mabbr_id;
    public final String mlocale;
    public final Method mmethod;
    public final String mquery;
    public final Scene mscene;

    public static final class Builder extends Message.Builder<GetEnterpriseTopicRequest, Builder> {
        public String mabbr_id;
        public String mlocale;
        public Method mmethod;
        public String mquery;
        public Scene mscene;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetEnterpriseTopicRequest m758build() {
            Scene r0 = this.mscene;
            if (r0 == null) goto L9;
            if (this.mquery == null) goto L9;
            return new GetEnterpriseTopicRequest(this.mscene, this.mquery, this.mlocale, this.mabbr_id, this.mmethod, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mscene", this.mquery, "mquery"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m758build();
        }

        public Builder abbr_id(String r1) {
            this.mabbr_id = r1;
            return this;
        }

        public Builder locale(String r1) {
            this.mlocale = r1;
            return this;
        }

        public Builder method(Method r1) {
            this.mmethod = r1;
            return this;
        }

        public Builder query(String r1) {
            this.mquery = r1;
            return this;
        }

        public Builder scene(Scene r1) {
            this.mscene = r1;
            return this;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method CLICK = null;
        public static final Method QUERY = null;
        private final int value;

        static {
            Method r0 = new Method("CLICK", 0, 0);
            CLICK = r0;
            Method r1 = new Method("QUERY", 1, 1);
            QUERY = r1;
            $VALUES = new Method[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Method.class);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Method fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return QUERY;
        L10:
            return CLICK;
        }

        public static Method valueOf(String r1) {
            return (Method) a.a(Method.class, r1);
        }

        private Method(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_GetEnterpriseTopicRequest extends ProtoAdapter<GetEnterpriseTopicRequest> {
        public ProtoAdapter_GetEnterpriseTopicRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetEnterpriseTopicRequest.class);
        }

        public GetEnterpriseTopicRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mquery = "";
            r0.mlocale = "";
            r0.mabbr_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L27;
            if (r3 != 1) goto L8;
            r0.mscene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mquery = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mlocale = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mabbr_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mmethod = (Method) Method.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L27:
            r9.endMessage(r1);
            return r0.m758build();
        }

        public int encodedSize(GetEnterpriseTopicRequest r6) {
            int r0 = Scene.ADAPTER.encodedSizeWithTag(1, r6.mscene);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            int r2 = r0 + r1.encodedSizeWithTag(2, r6.mquery);
            String r3 = r6.mlocale;
            int r4 = 0;
            if (r3 == null) goto L5;
            int r5 = r1.encodedSizeWithTag(3, r3);
        L6:
            int r7 = r2 + r5;
            String r8 = r6.mabbr_id;
            if (r8 == null) goto L9;
            int r9 = r1.encodedSizeWithTag(4, r8);
        L10:
            int r10 = r7 + r9;
            Method r11 = r6.mmethod;
            if (r11 == null) goto L14;
            r4 = Method.ADAPTER.encodedSizeWithTag(5, r11);
        L14:
            return (r10 + r4) + r6.unknownFields().size();
        L9:
            r9 = 0;
            goto L10
        L5:
            r5 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m759decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetEnterpriseTopicRequest) r1);
        }

        public void encode(ProtoWriter r4, GetEnterpriseTopicRequest r5) throws IOException {
            Scene.ADAPTER.encodeWithTag(r4, 1, r5.mscene);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.mquery);
            String r1 = r5.mlocale;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 3, r1);
        L5:
            String r2 = r5.mabbr_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 4, r2);
        L8:
            Method r3 = r5.mmethod;
            if (r3 == null) goto L11;
            Method.ADAPTER.encodeWithTag(r4, 5, r3);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetEnterpriseTopicRequest) r2);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene BROWSER = null;
        public static final Scene DOCS = null;
        public static final Scene EMAIL = null;
        public static final Scene MESSENGER = null;
        public static final Scene SEARCH = null;
        public static final Scene UNKNOWN = null;
        public static final Scene VC = null;
        private final int value;

        static {
            Scene r0 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Scene r1 = new Scene("MESSENGER", 1, 1);
            MESSENGER = r1;
            Scene r3 = new Scene("EMAIL", 2, 2);
            EMAIL = r3;
            Scene r5 = new Scene("DOCS", 3, 3);
            DOCS = r5;
            Scene r7 = new Scene("BROWSER", 4, 4);
            BROWSER = r7;
            Scene r9 = new Scene("VC", 5, 5);
            VC = r9;
            Scene r11 = new Scene("SEARCH", 6, 6);
            SEARCH = r11;
            $VALUES = new Scene[]{r0, r1, r3, r5, r7, r9, r11};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r0) {
            switch(r0) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SEARCH;
        L8:
            return VC;
        L10:
            return BROWSER;
        L12:
            return DOCS;
        L14:
            return EMAIL;
        L16:
            return MESSENGER;
        L18:
            return UNKNOWN;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        private Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetEnterpriseTopicRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m757newBuilder() {
        Builder r0 = new Builder();
        r0.mscene = this.mscene;
        r0.mquery = this.mquery;
        r0.mlocale = this.mlocale;
        r0.mabbr_id = this.mabbr_id;
        r0.mmethod = this.mmethod;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetEnterpriseTopicRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m757newBuilder();
    }

    public GetEnterpriseTopicRequest(Scene r8, String r9, String r10, String r11, Method r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public GetEnterpriseTopicRequest(Scene r2, String r3, String r4, String r5, Method r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mscene = r2;
        this.mquery = r3;
        this.mlocale = r4;
        this.mabbr_id = r5;
        this.mmethod = r6;
    }
}
