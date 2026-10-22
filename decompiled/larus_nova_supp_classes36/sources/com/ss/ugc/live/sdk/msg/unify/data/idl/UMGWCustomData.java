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
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UMGWCustomData extends AndroidMessage<UMGWCustomData, Builder> {
    public static final ProtoAdapter<UMGWCustomData> ADAPTER = null;
    public static final Parcelable.Creator<UMGWCustomData> CREATOR = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String value;

    public static final class Builder extends Message.Builder<UMGWCustomData, Builder> {
        public String key;
        public String value;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UMGWCustomData m1691build() {
            return new UMGWCustomData(this.key, this.value, super.buildUnknownFields());
        }

        public Builder() {
            this.key = "";
            this.value = "";
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1691build();
        }

        public Builder key(String r1) {
            this.key = r1;
            return this;
        }

        public Builder value(String r1) {
            this.value = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWCustomData extends ProtoAdapter<UMGWCustomData> {
        public ProtoAdapter_UMGWCustomData() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWCustomData.class);
        }

        public UMGWCustomData decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.key((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.value((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1691build();
        }

        public int encodedSize(UMGWCustomData r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5.key) + r0.encodedSizeWithTag(2, r5.value)) + r5.unknownFields().size();
        }

        public UMGWCustomData redact(UMGWCustomData r1) {
            Builder r2 = r1.m1690newBuilder();
            r2.clearUnknownFields();
            return r2.m1691build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1692decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UMGWCustomData) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UMGWCustomData) r1);
        }

        public void encode(ProtoWriter r4, UMGWCustomData r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.key);
            r0.encodeWithTag(r4, 2, r5.value);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UMGWCustomData) r2);
        }
    }

    static {
        ProtoAdapter_UMGWCustomData r0 = new ProtoAdapter_UMGWCustomData();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.key;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.value;
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
    public Builder m1690newBuilder() {
        Builder r0 = new Builder();
        r0.key = this.key;
        r0.value = this.value;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.key == null) goto L6;
        r0.append(", key=");
        r0.append(this.key);
    L6:
        if (this.value == null) goto L8;
        r0.append(", value=");
        r0.append(this.value);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "UMGWCustomData{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1690newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UMGWCustomData) == true) goto L8;
        return false;
    L8:
        UMGWCustomData r6 = (UMGWCustomData) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.key, r6.key) == false) goto L15;
        if (Internal.equals(this.value, r6.value) == false) goto L15;
        return true;
    }

    public UMGWCustomData(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public UMGWCustomData(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.key = r2;
        this.value = r3;
    }
}
