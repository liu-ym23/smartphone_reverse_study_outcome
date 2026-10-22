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
public final class UMGWFetchRequest extends AndroidMessage<UMGWFetchRequest, Builder> {
    public static final ProtoAdapter<UMGWFetchRequest> ADAPTER = null;
    public static final Parcelable.Creator<UMGWFetchRequest> CREATOR = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventData#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<UMGWEventData> event_data;

    public static final class Builder extends Message.Builder<UMGWFetchRequest, Builder> {
        public List<UMGWEventData> event_data;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UMGWFetchRequest m1701build() {
            return new UMGWFetchRequest(this.event_data, super.buildUnknownFields());
        }

        public Builder() {
            this.event_data = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1701build();
        }

        public Builder event_data(List<UMGWEventData> r1) {
            Internal.checkElementsNotNull(r1);
            this.event_data = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWFetchRequest extends ProtoAdapter<UMGWFetchRequest> {
        public ProtoAdapter_UMGWFetchRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWFetchRequest.class);
        }

        public UMGWFetchRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.event_data.add((UMGWEventData) UMGWEventData.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1701build();
        }

        public int encodedSize(UMGWFetchRequest r4) {
            return UMGWEventData.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.event_data) + r4.unknownFields().size();
        }

        public UMGWFetchRequest redact(UMGWFetchRequest r3) {
            Builder r4 = r3.m1700newBuilder();
            Internal.redactElements(r4.event_data, UMGWEventData.ADAPTER);
            r4.clearUnknownFields();
            return r4.m1701build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1702decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UMGWFetchRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UMGWFetchRequest) r1);
        }

        public void encode(ProtoWriter r4, UMGWFetchRequest r5) throws IOException {
            UMGWEventData.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.event_data);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UMGWFetchRequest) r2);
        }
    }

    static {
        ProtoAdapter_UMGWFetchRequest r0 = new ProtoAdapter_UMGWFetchRequest();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.event_data.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1700newBuilder() {
        Builder r0 = new Builder();
        r0.event_data = Internal.copyOf("event_data", this.event_data);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<UMGWEventData> r1 = this.event_data;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r2 = r0.replace(0, 2, "UMGWFetchRequest{");
        r2.append('}');
        return r2.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", event_data=");
        r0.append(this.event_data);
        goto L7
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1700newBuilder();
    }

    public UMGWFetchRequest(List<UMGWEventData> r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UMGWFetchRequest) == true) goto L8;
        return false;
    L8:
        UMGWFetchRequest r6 = (UMGWFetchRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.event_data.equals(r6.event_data) == false) goto L13;
        return true;
    }

    public UMGWFetchRequest(List<UMGWEventData> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.event_data = Internal.immutableCopyOf("event_data", r2);
    }
}
