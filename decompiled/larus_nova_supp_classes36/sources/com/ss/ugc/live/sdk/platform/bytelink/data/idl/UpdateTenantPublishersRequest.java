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
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UpdateTenantPublishersRequest extends AndroidMessage<UpdateTenantPublishersRequest, Builder> {
    public static final ProtoAdapter<UpdateTenantPublishersRequest> ADAPTER = null;
    public static final Parcelable.Creator<UpdateTenantPublishersRequest> CREATOR = null;
    public static final String DEFAULT_TRIGGER_TENANT_ID = "";
    public static final Long DEFAULT_TRIGGER_TIME_MS = null;
    public static final String DEFAULT_UPDATE_BY_OPERATION = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String trigger_tenant_id;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.TenantPublishers#ADAPTER", tag = 1)
    public final TenantPublishers trigger_tenant_publishers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long trigger_time_ms;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String update_by_operation;

    public static final class Builder extends Message.Builder<UpdateTenantPublishersRequest, Builder> {
        public String trigger_tenant_id;
        public TenantPublishers trigger_tenant_publishers;
        public Long trigger_time_ms;
        public String update_by_operation;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateTenantPublishersRequest m1729build() {
            return new UpdateTenantPublishersRequest(this.trigger_tenant_publishers, this.trigger_time_ms, this.trigger_tenant_id, this.update_by_operation, super.buildUnknownFields());
        }

        public Builder() {
            this.trigger_time_ms = 0L;
            this.trigger_tenant_id = "";
            this.update_by_operation = "";
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1729build();
        }

        public Builder trigger_tenant_id(String r1) {
            this.trigger_tenant_id = r1;
            return this;
        }

        public Builder trigger_tenant_publishers(TenantPublishers r1) {
            this.trigger_tenant_publishers = r1;
            return this;
        }

        public Builder trigger_time_ms(Long r1) {
            this.trigger_time_ms = r1;
            return this;
        }

        public Builder update_by_operation(String r1) {
            this.update_by_operation = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTenantPublishersRequest extends ProtoAdapter<UpdateTenantPublishersRequest> {
        public ProtoAdapter_UpdateTenantPublishersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTenantPublishersRequest.class);
        }

        public UpdateTenantPublishersRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.trigger_tenant_publishers((TenantPublishers) TenantPublishers.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.trigger_time_ms((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.trigger_tenant_id((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.update_by_operation((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1729build();
        }

        public int encodedSize(UpdateTenantPublishersRequest r5) {
            int r0 = TenantPublishers.ADAPTER.encodedSizeWithTag(1, r5.trigger_tenant_publishers) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.trigger_time_ms);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            return ((r0 + r1.encodedSizeWithTag(3, r5.trigger_tenant_id)) + r1.encodedSizeWithTag(4, r5.update_by_operation)) + r5.unknownFields().size();
        }

        public UpdateTenantPublishersRequest redact(UpdateTenantPublishersRequest r3) {
            Builder r4 = r3.m1728newBuilder();
            TenantPublishers r0 = r4.trigger_tenant_publishers;
            if (r0 == null) goto L5;
            r4.trigger_tenant_publishers = (TenantPublishers) TenantPublishers.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.m1729build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1730decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateTenantPublishersRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UpdateTenantPublishersRequest) r1);
        }

        public void encode(ProtoWriter r4, UpdateTenantPublishersRequest r5) throws IOException {
            TenantPublishers.ADAPTER.encodeWithTag(r4, 1, r5.trigger_tenant_publishers);
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.trigger_time_ms);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 3, r5.trigger_tenant_id);
            r0.encodeWithTag(r4, 4, r5.update_by_operation);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateTenantPublishersRequest) r2);
        }
    }

    static {
        ProtoAdapter_UpdateTenantPublishersRequest r0 = new ProtoAdapter_UpdateTenantPublishersRequest();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_TRIGGER_TIME_MS = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        TenantPublishers r2 = this.trigger_tenant_publishers;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.trigger_time_ms;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.trigger_tenant_id;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.update_by_operation;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        ((Message) this).hashCode = r13;
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

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1728newBuilder() {
        Builder r0 = new Builder();
        r0.trigger_tenant_publishers = this.trigger_tenant_publishers;
        r0.trigger_time_ms = this.trigger_time_ms;
        r0.trigger_tenant_id = this.trigger_tenant_id;
        r0.update_by_operation = this.update_by_operation;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.trigger_tenant_publishers == null) goto L6;
        r0.append(", trigger_tenant_publishers=");
        r0.append(this.trigger_tenant_publishers);
    L6:
        if (this.trigger_time_ms == null) goto L9;
        r0.append(", trigger_time_ms=");
        r0.append(this.trigger_time_ms);
    L9:
        if (this.trigger_tenant_id == null) goto L12;
        r0.append(", trigger_tenant_id=");
        r0.append(this.trigger_tenant_id);
    L12:
        if (this.update_by_operation == null) goto L14;
        r0.append(", update_by_operation=");
        r0.append(this.update_by_operation);
    L14:
        StringBuilder r1 = r0.replace(0, 2, "UpdateTenantPublishersRequest{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1728newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UpdateTenantPublishersRequest) == true) goto L8;
        return false;
    L8:
        UpdateTenantPublishersRequest r6 = (UpdateTenantPublishersRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.trigger_tenant_publishers, r6.trigger_tenant_publishers) == false) goto L19;
        if (Internal.equals(this.trigger_time_ms, r6.trigger_time_ms) == false) goto L19;
        if (Internal.equals(this.trigger_tenant_id, r6.trigger_tenant_id) == false) goto L19;
        if (Internal.equals(this.update_by_operation, r6.update_by_operation) == false) goto L19;
        return true;
    }

    public UpdateTenantPublishersRequest(TenantPublishers r7, Long r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public UpdateTenantPublishersRequest(TenantPublishers r2, Long r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.trigger_tenant_publishers = r2;
        this.trigger_time_ms = r3;
        this.trigger_tenant_id = r4;
        this.update_by_operation = r5;
    }
}
