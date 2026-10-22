package com.bytedance.common.wschannel.model;

import ai.j0;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class Frame extends Message<Frame, Builder> {
    public static final ProtoAdapter<Frame> ADAPTER = null;
    public static final Long DEFAULT_LOGID = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtendedEntry> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payload_encoding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payload_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long seqid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    public final Integer service;

    public static final class Builder extends Message.Builder<Frame, Builder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f3989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f3990c;
        public Integer d;
        public List e;
        public String f;
        public String g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ByteString f3991h;

        public Builder() {
            this.e = Internal.newMutableList();
        }

        public final void a(ArrayList r5) {
            Internal.checkElementsNotNull(r5);
            this.e = r5;
        }

        public final Frame a() {
            Long r5 = this.f3988a;
            if (r5 == null) goto L13;
            if (this.f3989b == null) goto L13;
            if (this.f3990c == null) goto L13;
            if (this.d == null) goto L13;
            return new Frame(this.f3988a, this.f3989b, this.f3990c, this.d, this.e, this.f, this.g, this.f3991h, buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r5, "seqid", this.f3989b, "logid", this.f3990c, NotificationCompat.CATEGORY_SERVICE, this.d, "method"});
        }
    }

    public static final class ExtendedEntry extends Message<ExtendedEntry, Builder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ProtoAdapter f3992a = null;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String key;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String value;

        public static final class Builder extends Message.Builder<ExtendedEntry, Builder> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f3993a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f3994b;

            public Builder() {
            }

            public final ExtendedEntry a() {
                String r5 = this.f3993a;
                if (r5 == null) goto L9;
                if (this.f3994b == null) goto L9;
                return new ExtendedEntry(this.f3993a, this.f3994b, buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r5, STGroup.DICT_KEY, this.f3994b, "value"});
            }
        }

        public static final class ProtoAdapter_ExtendedEntry extends ProtoAdapter<ExtendedEntry> {
            public ProtoAdapter_ExtendedEntry() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendedEntry.class);
            }
        }

        static {
            f3992a = new ProtoAdapter_ExtendedEntry();
        }

        public ExtendedEntry(String r5, String r10, ByteString r11) {
            super(f3992a, r11);
            this.key = r5;
            this.value = r10;
        }
    }

    public static final class ProtoAdapter_Frame extends ProtoAdapter<Frame> {
        public ProtoAdapter_Frame() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Frame();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public Frame(Long r11, Long r12, Integer r13, Integer r14, List<ExtendedEntry> r15, String r16, String r17, ByteString r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Frame) == true) goto L8;
        return false;
    L8:
        Frame r10 = (Frame) r5;
        if (unknownFields().equals(r10.unknownFields()) == true) goto L11;
    L27:
        return false;
    L11:
        if (this.seqid.equals(r10.seqid) == false) goto L27;
        if (this.logid.equals(r10.logid) == false) goto L27;
        if (this.service.equals(r10.service) == false) goto L27;
        if (this.method.equals(r10.method) == false) goto L27;
        if (this.headers.equals(r10.headers) == false) goto L27;
        if (Internal.equals(this.payload_encoding, r10.payload_encoding) == false) goto L27;
        if (Internal.equals(this.payload_type, r10.payload_type) == false) goto L27;
        if (Internal.equals(this.payload, r10.payload) == false) goto L27;
        return true;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L17;
        int r10 = (this.headers.hashCode() + ((this.method.hashCode() + ((this.service.hashCode() + ((this.logid.hashCode() + ((this.seqid.hashCode() + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37)) * 37;
        String r11 = this.payload_encoding;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.payload_type;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        ByteString r18 = this.payload;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        int r19 = r17 + r12;
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = j0.u(", seqid=");
        r5.append(this.seqid);
        r5.append(", logid=");
        r5.append(this.logid);
        r5.append(", service=");
        r5.append(this.service);
        r5.append(", method=");
        r5.append(this.method);
        if (this.headers.isEmpty() == true) goto L6;
        r5.append(", headers=");
        r5.append(this.headers);
    L6:
        if (this.payload_encoding == null) goto L9;
        r5.append(", payload_encoding=");
        r5.append(this.payload_encoding);
    L9:
        if (this.payload_type == null) goto L12;
        r5.append(", payload_type=");
        r5.append(this.payload_type);
    L12:
        if (this.payload == null) goto L15;
        r5.append(", payload=");
        r5.append(this.payload);
    L15:
        return androidx.room.jarjarred.org.antlr.runtime.a.s(r5, 0, 2, "Frame{", '}');
    }

    public Frame(Long r5, Long r10, Integer r11, Integer r12, List<ExtendedEntry> r13, String r14, String r15, ByteString r16, ByteString r17) {
        super(ADAPTER, r17);
        this.seqid = r5;
        this.logid = r10;
        this.service = r11;
        this.method = r12;
        this.headers = Internal.immutableCopyOf("headers", r13);
        this.payload_encoding = r14;
        this.payload_type = r15;
        this.payload = r16;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.f3988a = this.seqid;
        r5.f3989b = this.logid;
        r5.f3990c = this.service;
        r5.d = this.method;
        r5.e = Internal.copyOf("headers", this.headers);
        r5.f = this.payload_encoding;
        r5.g = this.payload_type;
        r5.f3991h = this.payload;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
