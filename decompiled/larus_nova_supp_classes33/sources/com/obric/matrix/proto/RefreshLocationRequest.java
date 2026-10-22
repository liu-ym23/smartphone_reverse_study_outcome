package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RefreshLocationRequest extends Message<RefreshLocationRequest, Builder> {
    public static final ProtoAdapter<RefreshLocationRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IGNORECACHE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("ignoreCache")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean ignoreCache;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class Builder extends Message.Builder<RefreshLocationRequest, Builder> {
        public Boolean ignoreCache;
        public String packageName;

        public RefreshLocationRequest build() {
            return new RefreshLocationRequest(this.packageName, this.ignoreCache, super.buildUnknownFields());
        }

        public Builder() {
            this.packageName = "";
            this.ignoreCache = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m143build() {
            return build();
        }

        public Builder ignoreCache(Boolean r1) {
            this.ignoreCache = r1;
            return this;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RefreshLocationRequest extends ProtoAdapter<RefreshLocationRequest> {
        public ProtoAdapter_RefreshLocationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationRequest.class);
        }

        public RefreshLocationRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.packageName((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.ignoreCache((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(RefreshLocationRequest r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.packageName) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r5.ignoreCache)) + r5.unknownFields().size();
        }

        public RefreshLocationRequest redact(RefreshLocationRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m144decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RefreshLocationRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((RefreshLocationRequest) r1);
        }

        public void encode(ProtoWriter r4, RefreshLocationRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.packageName);
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r5.ignoreCache);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RefreshLocationRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RefreshLocationRequest();
        DEFAULT_IGNORECACHE = Boolean.FALSE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
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
        ((Message) this).hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.packageName = this.packageName;
        r0.ignoreCache = this.ignoreCache;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.packageName == null) goto L6;
        r0.append(", packageName=");
        r0.append(this.packageName);
    L6:
        if (this.ignoreCache == null) goto L8;
        r0.append(", ignoreCache=");
        r0.append(this.ignoreCache);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "RefreshLocationRequest{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m142newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RefreshLocationRequest) == true) goto L8;
        return false;
    L8:
        RefreshLocationRequest r6 = (RefreshLocationRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L15;
        if (Internal.equals(this.ignoreCache, r6.ignoreCache) == false) goto L15;
        return true;
    }

    public RefreshLocationRequest(String r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RefreshLocationRequest(String r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.packageName = r2;
        this.ignoreCache = r3;
    }
}
