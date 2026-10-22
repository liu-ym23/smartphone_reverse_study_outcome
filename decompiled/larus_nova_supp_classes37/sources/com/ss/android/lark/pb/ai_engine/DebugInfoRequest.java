package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DebugInfoRequest extends Message<DebugInfoRequest, Builder> {
    public static final ProtoAdapter<DebugInfoRequest> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_QUERY_ID = "";
    public static final String DEFAULT_SCENARIO = "";
    private static final long serialVersionUID = 0;
    public final String mmessage_id;
    public final WorkMode mmode;
    public final String mquery_id;
    public final String mscenario;

    public static final class Builder extends Message.Builder<DebugInfoRequest, Builder> {
        public String mmessage_id;
        public WorkMode mmode;
        public String mquery_id;
        public String mscenario;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DebugInfoRequest m776build() {
            return new DebugInfoRequest(this.mmessage_id, this.mquery_id, this.mmode, this.mscenario, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m776build();
        }

        public Builder message_id(String r1) {
            this.mmessage_id = r1;
            return this;
        }

        public Builder mode(WorkMode r1) {
            this.mmode = r1;
            return this;
        }

        public Builder query_id(String r1) {
            this.mquery_id = r1;
            return this;
        }

        public Builder scenario(String r1) {
            this.mscenario = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DebugInfoRequest extends ProtoAdapter<DebugInfoRequest> {
        public ProtoAdapter_DebugInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DebugInfoRequest.class);
        }

        public DebugInfoRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmessage_id = "";
            r0.mquery_id = "";
            r0.mscenario = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mquery_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mmode = (WorkMode) WorkMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mscenario = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m776build();
        }

        public int encodedSize(DebugInfoRequest r6) {
            String r0 = r6.mmessage_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mquery_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            WorkMode r7 = r6.mmode;
            if (r7 == null) goto L13;
            int r8 = WorkMode.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mscenario;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m777decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DebugInfoRequest) r1);
        }

        public void encode(ProtoWriter r4, DebugInfoRequest r5) throws IOException {
            String r0 = r5.mmessage_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mquery_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            WorkMode r2 = r5.mmode;
            if (r2 == null) goto L11;
            WorkMode.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mscenario;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DebugInfoRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DebugInfoRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m775newBuilder() {
        Builder r0 = new Builder();
        r0.mmessage_id = this.mmessage_id;
        r0.mquery_id = this.mquery_id;
        r0.mmode = this.mmode;
        r0.mscenario = this.mscenario;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DebugInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m775newBuilder();
    }

    public DebugInfoRequest(String r7, String r8, WorkMode r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public DebugInfoRequest(String r2, String r3, WorkMode r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mmessage_id = r2;
        this.mquery_id = r3;
        this.mmode = r4;
        this.mscenario = r5;
    }
}
