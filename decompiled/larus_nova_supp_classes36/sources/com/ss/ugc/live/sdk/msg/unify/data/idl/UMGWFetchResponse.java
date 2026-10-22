package com.ss.ugc.live.sdk.msg.unify.data.idl;

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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UMGWFetchResponse extends AndroidMessage<UMGWFetchResponse, Builder> {
    public static final ProtoAdapter<UMGWFetchResponse> ADAPTER = null;
    public static final Parcelable.Creator<UMGWFetchResponse> CREATOR = null;
    public static final String DEFAULT_UMGW_GLOBAL_EXT = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWDownlinkPacket#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<UMGWDownlinkPacket> business_data;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWConnectionInfo#ADAPTER", tag = 2)
    public final UMGWConnectionInfo connection_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String umgw_global_ext;

    public static final class Builder extends Message.Builder<UMGWFetchResponse, Builder> {
        public List<UMGWDownlinkPacket> business_data;
        public UMGWConnectionInfo connection_info;
        public String umgw_global_ext;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UMGWFetchResponse m1704build() {
            return new UMGWFetchResponse(this.business_data, this.connection_info, this.umgw_global_ext, super.buildUnknownFields());
        }

        public Builder() {
            this.umgw_global_ext = "";
            this.business_data = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1704build();
        }

        public Builder business_data(List<UMGWDownlinkPacket> r1) {
            Internal.checkElementsNotNull(r1);
            this.business_data = r1;
            return this;
        }

        public Builder connection_info(UMGWConnectionInfo r1) {
            this.connection_info = r1;
            return this;
        }

        public Builder umgw_global_ext(String r1) {
            this.umgw_global_ext = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWFetchResponse extends ProtoAdapter<UMGWFetchResponse> {
        public ProtoAdapter_UMGWFetchResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWFetchResponse.class);
        }

        public UMGWFetchResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.business_data.add((UMGWDownlinkPacket) UMGWDownlinkPacket.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.connection_info((UMGWConnectionInfo) UMGWConnectionInfo.ADAPTER.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.umgw_global_ext((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1704build();
        }

        public int encodedSize(UMGWFetchResponse r5) {
            return ((UMGWDownlinkPacket.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.business_data) + UMGWConnectionInfo.ADAPTER.encodedSizeWithTag(2, r5.connection_info)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.umgw_global_ext)) + r5.unknownFields().size();
        }

        public UMGWFetchResponse redact(UMGWFetchResponse r3) {
            Builder r4 = r3.m1703newBuilder();
            Internal.redactElements(r4.business_data, UMGWDownlinkPacket.ADAPTER);
            UMGWConnectionInfo r0 = r4.connection_info;
            if (r0 == null) goto L5;
            r4.connection_info = (UMGWConnectionInfo) UMGWConnectionInfo.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.m1704build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1705decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UMGWFetchResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UMGWFetchResponse) r1);
        }

        public void encode(ProtoWriter r4, UMGWFetchResponse r5) throws IOException {
            UMGWDownlinkPacket.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.business_data);
            UMGWConnectionInfo.ADAPTER.encodeWithTag(r4, 2, r5.connection_info);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.umgw_global_ext);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UMGWFetchResponse) r2);
        }
    }

    static {
        ProtoAdapter_UMGWFetchResponse r0 = new ProtoAdapter_UMGWFetchResponse();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = ((unknownFields().hashCode() * 37) + this.business_data.hashCode()) * 37;
        UMGWConnectionInfo r2 = this.connection_info;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.umgw_global_ext;
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

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1703newBuilder() {
        Builder r0 = new Builder();
        r0.business_data = Internal.copyOf("business_data", this.business_data);
        r0.connection_info = this.connection_info;
        r0.umgw_global_ext = this.umgw_global_ext;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<UMGWDownlinkPacket> r1 = this.business_data;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", business_data=");
        r0.append(this.business_data);
    L8:
        if (this.connection_info == null) goto L11;
        r0.append(", connection_info=");
        r0.append(this.connection_info);
    L11:
        if (this.umgw_global_ext == null) goto L13;
        r0.append(", umgw_global_ext=");
        r0.append(this.umgw_global_ext);
    L13:
        StringBuilder r2 = r0.replace(0, 2, "UMGWFetchResponse{");
        r2.append('}');
        return r2.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1703newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UMGWFetchResponse) == true) goto L8;
        return false;
    L8:
        UMGWFetchResponse r6 = (UMGWFetchResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.business_data.equals(r6.business_data) == false) goto L17;
        if (Internal.equals(this.connection_info, r6.connection_info) == false) goto L17;
        if (Internal.equals(this.umgw_global_ext, r6.umgw_global_ext) == false) goto L17;
        return true;
    }

    public UMGWFetchResponse(List<UMGWDownlinkPacket> r2, UMGWConnectionInfo r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public UMGWFetchResponse(List<UMGWDownlinkPacket> r2, UMGWConnectionInfo r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.business_data = Internal.immutableCopyOf("business_data", r2);
        this.connection_info = r3;
        this.umgw_global_ext = r4;
    }
}
