package com.obric.matrix.proto;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class TargetDataset extends Message<TargetDataset, a> {
    public static final ProtoAdapter<TargetDataset> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String appid;

    @SerializedName(Api.KEY_APPKEY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appkey;

    @SerializedName(ActivityLifecycle.NAME)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @SerializedName("properties")
    @WireField(adapter = "com.obric.matrix.proto.NullableMap#ADAPTER", tag = 4)
    public final NullableMap properties;

    public static final class a extends Message.Builder<TargetDataset, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8252b;
        public String c;
        public NullableMap d;

        public a() {
            this.f8251a = "";
            this.f8252b = "";
            this.c = "";
        }

        public a a(NullableMap r1) {
            this.d = r1;
            return this;
        }

        public a a(String r1) {
            this.f8251a = r1;
            return this;
        }

        public TargetDataset a() {
            return new TargetDataset(this.f8251a, this.f8252b, this.c, this.d, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f8252b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.c = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<TargetDataset> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, TargetDataset.class);
        }

        public int a(TargetDataset r4) {
            return (((ProtoAdapter.STRING.encodedSizeWithTag(1, r4.name) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.appid)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.appkey)) + NullableMap.ADAPTER.encodedSizeWithTag(4, r4.properties)) + r4.unknownFields().size();
        }

        public TargetDataset a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.a((NullableMap) ZeusTransformUtils.preCheckCast(NullableMap.ADAPTER.decode(r6), NullableMap.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, TargetDataset r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.name);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.appid);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.appkey);
            NullableMap.ADAPTER.encodeWithTag(r3, 4, r4.properties);
            r3.writeBytes(r4.unknownFields());
        }

        public TargetDataset b(TargetDataset r3) {
            a r2 = r3.newBuilder();
            if (r2.d == null) goto L5;
            r2.d = (NullableMap) ZeusTransformUtils.preCheckCast(NullableMap.ADAPTER.redact(r2.d), NullableMap.class, "com.obric.memorydata.plugin");
        L5:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ TargetDataset decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, TargetDataset r4) {
            a(r3, (TargetDataset) ZeusTransformUtils.preCheckCast(r4, TargetDataset.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(TargetDataset r3) {
            return a((TargetDataset) ZeusTransformUtils.preCheckCast(r3, TargetDataset.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ TargetDataset redact(TargetDataset r3) {
            return b((TargetDataset) ZeusTransformUtils.preCheckCast(r3, TargetDataset.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public TargetDataset(String r7, String r8, String r9, NullableMap r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public TargetDataset(String r2, String r3, String r4, NullableMap r5, ByteString r6) {
        super(ADAPTER, r6);
        this.name = r2;
        this.appid = r3;
        this.appkey = r4;
        this.properties = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TargetDataset.class) == true) goto L8;
        return false;
    L8:
        TargetDataset r6 = (TargetDataset) ZeusTransformUtils.preCheckCast(r5, TargetDataset.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.name, r6.name) == false) goto L20;
        if (Internal.equals(this.appid, r6.appid) == false) goto L20;
        if (Internal.equals(this.appkey, r6.appkey) == false) goto L20;
        if (Internal.equals(this.properties, r6.properties) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.name;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.appid;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.appkey;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        NullableMap r12 = this.properties;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8251a = this.name;
        r0.f8252b = this.appid;
        r0.c = this.appkey;
        r0.d = this.properties;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.name == null) goto L6;
        r0.append(", name=").append(this.name);
    L6:
        if (this.appid == null) goto L9;
        r0.append(", appid=").append(this.appid);
    L9:
        if (this.appkey == null) goto L12;
        r0.append(", appkey=").append(this.appkey);
    L12:
        if (this.properties == null) goto L15;
        r0.append(", properties=").append(this.properties);
    L15:
        return r0.replace(0, 2, "TargetDataset{").append('}').toString();
    }
}
