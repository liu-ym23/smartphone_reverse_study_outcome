package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
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
public final class RefreshLocationRequest extends Message<RefreshLocationRequest, a> {
    public static final ProtoAdapter<RefreshLocationRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IGNORECACHE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("ignoreCache")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean ignoreCache;

    @SerializedName(ObricMemoryConstants.KEY_PACKAGE_NAME)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class a extends Message.Builder<RefreshLocationRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f8199b;

        public a() {
            this.f8198a = "";
            this.f8199b = false;
        }

        public a a(Boolean r1) {
            this.f8199b = r1;
            return this;
        }

        public a a(String r1) {
            this.f8198a = r1;
            return this;
        }

        public RefreshLocationRequest a() {
            return new RefreshLocationRequest(this.f8198a, this.f8199b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<RefreshLocationRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationRequest.class);
        }

        public int a(RefreshLocationRequest r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.packageName) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r4.ignoreCache)) + r4.unknownFields().size();
        }

        public RefreshLocationRequest a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, RefreshLocationRequest r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.packageName);
            ProtoAdapter.BOOL.encodeWithTag(r3, 2, r4.ignoreCache);
            r3.writeBytes(r4.unknownFields());
        }

        public RefreshLocationRequest b(RefreshLocationRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ RefreshLocationRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, RefreshLocationRequest r4) {
            a(r3, (RefreshLocationRequest) ZeusTransformUtils.preCheckCast(r4, RefreshLocationRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(RefreshLocationRequest r3) {
            return a((RefreshLocationRequest) ZeusTransformUtils.preCheckCast(r3, RefreshLocationRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ RefreshLocationRequest redact(RefreshLocationRequest r3) {
            return b((RefreshLocationRequest) ZeusTransformUtils.preCheckCast(r3, RefreshLocationRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_IGNORECACHE = false;
    }

    public RefreshLocationRequest(String r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RefreshLocationRequest(String r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.packageName = r2;
        this.ignoreCache = r3;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RefreshLocationRequest.class) == true) goto L8;
        return false;
    L8:
        RefreshLocationRequest r6 = (RefreshLocationRequest) ZeusTransformUtils.preCheckCast(r5, RefreshLocationRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L16;
        if (Internal.equals(this.ignoreCache, r6.ignoreCache) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.packageName;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Boolean r6 = this.ignoreCache;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8198a = this.packageName;
        r0.f8199b = this.ignoreCache;
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
        if (this.packageName == null) goto L6;
        r0.append(", packageName=").append(this.packageName);
    L6:
        if (this.ignoreCache == null) goto L9;
        r0.append(", ignoreCache=").append(this.ignoreCache);
    L9:
        return r0.replace(0, 2, "RefreshLocationRequest{").append('}').toString();
    }
}
