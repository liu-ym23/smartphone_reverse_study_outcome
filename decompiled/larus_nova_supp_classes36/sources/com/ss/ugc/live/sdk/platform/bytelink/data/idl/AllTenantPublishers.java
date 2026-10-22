package com.ss.ugc.live.sdk.platform.bytelink.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AllTenantPublishers extends AndroidMessage<AllTenantPublishers, Builder> {
    public static final ProtoAdapter<AllTenantPublishers> ADAPTER = null;
    public static final Parcelable.Creator<AllTenantPublishers> CREATOR = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.TenantPublishers#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, TenantPublishers> tenant_publishers_map;

    public static final class Builder extends Message.Builder<AllTenantPublishers, Builder> {
        public Map<String, TenantPublishers> tenant_publishers_map;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AllTenantPublishers m1720build() {
            return new AllTenantPublishers(this.tenant_publishers_map, super.buildUnknownFields());
        }

        public Builder() {
            this.tenant_publishers_map = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1720build();
        }

        public Builder tenant_publishers_map(Map<String, TenantPublishers> r1) {
            Internal.checkElementsNotNull(r1);
            this.tenant_publishers_map = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AllTenantPublishers extends ProtoAdapter<AllTenantPublishers> {
        private final ProtoAdapter<Map<String, TenantPublishers>> tenant_publishers_map;

        public ProtoAdapter_AllTenantPublishers() {
            super(FieldEncoding.LENGTH_DELIMITED, AllTenantPublishers.class);
            this.tenant_publishers_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TenantPublishers.ADAPTER);
        }

        public AllTenantPublishers decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.tenant_publishers_map.putAll((Map) this.tenant_publishers_map.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1720build();
        }

        public int encodedSize(AllTenantPublishers r4) {
            return this.tenant_publishers_map.encodedSizeWithTag(1, r4.tenant_publishers_map) + r4.unknownFields().size();
        }

        public AllTenantPublishers redact(AllTenantPublishers r3) {
            Builder r4 = r3.m1719newBuilder();
            Internal.redactElements(r4.tenant_publishers_map, TenantPublishers.ADAPTER);
            r4.clearUnknownFields();
            return r4.m1720build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1721decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AllTenantPublishers) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((AllTenantPublishers) r1);
        }

        public void encode(ProtoWriter r4, AllTenantPublishers r5) throws IOException {
            this.tenant_publishers_map.encodeWithTag(r4, 1, r5.tenant_publishers_map);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AllTenantPublishers) r2);
        }
    }

    static {
        ProtoAdapter_AllTenantPublishers r0 = new ProtoAdapter_AllTenantPublishers();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.tenant_publishers_map.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1719newBuilder() {
        Builder r0 = new Builder();
        r0.tenant_publishers_map = Internal.copyOf("tenant_publishers_map", this.tenant_publishers_map);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Map<String, TenantPublishers> r1 = this.tenant_publishers_map;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r2 = r0.replace(0, 2, "AllTenantPublishers{");
        r2.append('}');
        return r2.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", tenant_publishers_map=");
        r0.append(this.tenant_publishers_map);
        goto L7
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1719newBuilder();
    }

    public AllTenantPublishers(Map<String, TenantPublishers> r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AllTenantPublishers) == true) goto L8;
        return false;
    L8:
        AllTenantPublishers r6 = (AllTenantPublishers) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.tenant_publishers_map.equals(r6.tenant_publishers_map) == false) goto L13;
        return true;
    }

    public AllTenantPublishers(Map<String, TenantPublishers> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.tenant_publishers_map = Internal.immutableCopyOf("tenant_publishers_map", r2);
    }
}
