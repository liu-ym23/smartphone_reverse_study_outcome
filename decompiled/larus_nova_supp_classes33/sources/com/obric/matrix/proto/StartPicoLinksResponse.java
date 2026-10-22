package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class StartPicoLinksResponse extends Message<StartPicoLinksResponse, Builder> {
    public static final ProtoAdapter<StartPicoLinksResponse> ADAPTER = null;
    public static final Phase DEFAULT_PHASE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("phase")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    public final Phase phase;

    @SerializedName("phaseData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> phaseData;

    public static final class Builder extends Message.Builder<StartPicoLinksResponse, Builder> {
        public Phase phase;
        public Map<String, String> phaseData;

        public StartPicoLinksResponse build() {
            return new StartPicoLinksResponse(this.phase, this.phaseData, super.buildUnknownFields());
        }

        public Builder() {
            this.phase = Phase.SYNC_INVOKE;
            this.phaseData = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m189build() {
            return build();
        }

        public Builder phase(Phase r1) {
            this.phase = r1;
            return this;
        }

        public Builder phaseData(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.phaseData = r1;
            return this;
        }
    }

    public static final enum Phase extends Enum<Phase> implements WireEnum {
        private static final /* synthetic */ Phase[] $VALUES = null;
        public static final ProtoAdapter<Phase> ADAPTER = null;
        public static final Phase ASYNC_CALLBACK = null;
        public static final Phase SYNC_INVOKE = null;
        public static final Phase URL_REDIRECT = null;
        private final int value;

        public static final class ProtoAdapter_Phase extends EnumAdapter<Phase> {
            public ProtoAdapter_Phase() {
                super(Phase.class);
            }

            public Phase fromValue(int r1) {
                return Phase.fromValue(r1);
            }

            /* JADX INFO: renamed from: fromValue, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ WireEnum m190fromValue(int r1) {
                return fromValue(r1);
            }
        }

        static {
            Phase r0 = new Phase("SYNC_INVOKE", 0, 0);
            SYNC_INVOKE = r0;
            Phase r1 = new Phase("ASYNC_CALLBACK", 1, 1);
            ASYNC_CALLBACK = r1;
            Phase r3 = new Phase("URL_REDIRECT", 2, 2);
            URL_REDIRECT = r3;
            $VALUES = new Phase[]{r0, r1, r3};
            ADAPTER = new ProtoAdapter_Phase();
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Phase fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return URL_REDIRECT;
        L12:
            return ASYNC_CALLBACK;
        L14:
            return SYNC_INVOKE;
        }

        public static Phase valueOf(String r1) {
            return (Phase) a.a(Phase.class, r1);
        }

        private Phase(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_StartPicoLinksResponse extends ProtoAdapter<StartPicoLinksResponse> {
        private final ProtoAdapter<Map<String, String>> phaseData;

        public ProtoAdapter_StartPicoLinksResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksResponse.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.phaseData = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public StartPicoLinksResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.phase((Phase) Phase.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.phaseData.putAll((Map) this.phaseData.decode(r9));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(StartPicoLinksResponse r5) {
            return (Phase.ADAPTER.encodedSizeWithTag(1, r5.phase) + this.phaseData.encodedSizeWithTag(2, r5.phaseData)) + r5.unknownFields().size();
        }

        public StartPicoLinksResponse redact(StartPicoLinksResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m191decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((StartPicoLinksResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((StartPicoLinksResponse) r1);
        }

        public void encode(ProtoWriter r4, StartPicoLinksResponse r5) throws IOException {
            Phase.ADAPTER.encodeWithTag(r4, 1, r5.phase);
            this.phaseData.encodeWithTag(r4, 2, r5.phaseData);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (StartPicoLinksResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StartPicoLinksResponse();
        DEFAULT_PHASE = Phase.SYNC_INVOKE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Phase r2 = this.phase;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.phaseData.hashCode();
        ((Message) this).hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.phase = this.phase;
        r0.phaseData = Internal.copyOf("phaseData", this.phaseData);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.phase == null) goto L5;
        r0.append(", phase=");
        r0.append(this.phase);
    L5:
        Map<String, String> r1 = this.phaseData;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r2 = r0.replace(0, 2, "StartPicoLinksResponse{");
        r2.append('}');
        return r2.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", phaseData=");
        r0.append(this.phaseData);
        goto L10
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m188newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StartPicoLinksResponse) == true) goto L8;
        return false;
    L8:
        StartPicoLinksResponse r6 = (StartPicoLinksResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.phase, r6.phase) == false) goto L15;
        if (this.phaseData.equals(r6.phaseData) == false) goto L15;
        return true;
    }

    public StartPicoLinksResponse(Phase r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public StartPicoLinksResponse(Phase r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.phase = r2;
        this.phaseData = Internal.immutableCopyOf("phaseData", r3);
    }
}
