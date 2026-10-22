package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.packageName = "";
            this.ignoreCache = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ignoreCache(Boolean r5) {
            this.ignoreCache = r5;
            return this;
        }

        public Builder packageName(String r5) {
            this.packageName = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public RefreshLocationRequest build() {
            return new RefreshLocationRequest(this.packageName, this.ignoreCache, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_RefreshLocationRequest extends ProtoAdapter<RefreshLocationRequest> {
        public ProtoAdapter_RefreshLocationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, RefreshLocationRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RefreshLocationRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationRequest redact(RefreshLocationRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RefreshLocationRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.packageName(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.ignoreCache(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, RefreshLocationRequest r10) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r10.packageName);
            ProtoAdapter.BOOL.encodeWithTag(r5, 2, r10.ignoreCache);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RefreshLocationRequest r5) {
            int r10 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.packageName);
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r5.ignoreCache) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public RefreshLocationRequest redact2(RefreshLocationRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RefreshLocationRequest();
        DEFAULT_IGNORECACHE = Boolean.FALSE;
    }

    public RefreshLocationRequest(String r5, Boolean r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RefreshLocationRequest) == true) goto L8;
        return false;
    L8:
        RefreshLocationRequest r10 = (RefreshLocationRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.packageName, r10.packageName) == false) goto L16;
        if (Internal.equals(this.ignoreCache, r10.ignoreCache) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        String r11 = this.packageName;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Boolean r15 = this.ignoreCache;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        int r16 = r14 + r12;
        this.hashCode = r16;
        return r16;
    L7:
        r13 = 0;
        goto L8
    L13:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.packageName == null) goto L6;
        r5.append(", packageName=");
        r5.append(this.packageName);
    L6:
        if (this.ignoreCache == null) goto L9;
        r5.append(", ignoreCache=");
        r5.append(this.ignoreCache);
    L9:
        return a.s(r5, 0, 2, "RefreshLocationRequest{", '}');
    }

    public RefreshLocationRequest(String r5, Boolean r10, ByteString r11) {
        super(ADAPTER, r11);
        this.packageName = r5;
        this.ignoreCache = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.packageName = this.packageName;
        r5.ignoreCache = this.ignoreCache;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
