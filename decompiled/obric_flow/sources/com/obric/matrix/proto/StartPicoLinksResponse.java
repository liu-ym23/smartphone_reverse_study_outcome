package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.phase = Phase.SYNC_INVOKE;
            this.phaseData = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder phase(Phase r5) {
            this.phase = r5;
            return this;
        }

        public Builder phaseData(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.phaseData = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public StartPicoLinksResponse build() {
            return new StartPicoLinksResponse(this.phase, this.phaseData, buildUnknownFields());
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

            @Override // com.squareup.wire.EnumAdapter
            public /* bridge */ /* synthetic */ WireEnum fromValue(int r5) {
                return fromValue(r5);
            }

            @Override // com.squareup.wire.EnumAdapter
            public Phase fromValue(int r5) {
                return Phase.fromValue(r5);
            }
        }

        static {
            Phase r5 = new Phase("SYNC_INVOKE", 0, 0);
            SYNC_INVOKE = r5;
            Phase r10 = new Phase("ASYNC_CALLBACK", 1, 1);
            ASYNC_CALLBACK = r10;
            Phase r11 = new Phase("URL_REDIRECT", 2, 2);
            URL_REDIRECT = r11;
            $VALUES = new Phase[]{r5, r10, r11};
            ADAPTER = new ProtoAdapter_Phase();
        }

        private Phase(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static Phase fromValue(int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L10;
            return null;
        L10:
            return URL_REDIRECT;
        L12:
            return ASYNC_CALLBACK;
        L14:
            return SYNC_INVOKE;
        }

        public static Phase valueOf(String r5) {
            return (Phase) Enum.valueOf(Phase.class, r5);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class ProtoAdapter_StartPicoLinksResponse extends ProtoAdapter<StartPicoLinksResponse> {
        private final ProtoAdapter<Map<String, String>> phaseData;

        public ProtoAdapter_StartPicoLinksResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksResponse.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.phaseData = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, StartPicoLinksResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StartPicoLinksResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse redact(StartPicoLinksResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StartPicoLinksResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L15;
            if (r12 != 1) goto L8;
            r5.phase(Phase.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r5.addUnknownField(r12, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.phaseData.putAll(this.phaseData.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, StartPicoLinksResponse r10) throws IOException {
            Phase.ADAPTER.encodeWithTag(r5, 1, r10.phase);
            this.phaseData.encodeWithTag(r5, 2, r10.phaseData);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StartPicoLinksResponse r5) {
            int r10 = Phase.ADAPTER.encodedSizeWithTag(1, r5.phase);
            int r11 = this.phaseData.encodedSizeWithTag(2, r5.phaseData) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public StartPicoLinksResponse redact2(StartPicoLinksResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StartPicoLinksResponse();
        DEFAULT_PHASE = Phase.SYNC_INVOKE;
    }

    public StartPicoLinksResponse(Phase r5, Map<String, String> r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StartPicoLinksResponse) == true) goto L8;
        return false;
    L8:
        StartPicoLinksResponse r10 = (StartPicoLinksResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.phase, r10.phase) == false) goto L16;
        if (this.phaseData.equals(r10.phaseData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        Phase r11 = this.phase;
        if (r11 == null) goto L7;
        int r12 = r11.hashCode();
    L8:
        int r13 = ((r10 + r12) * 37) + this.phaseData.hashCode();
        this.hashCode = r13;
        return r13;
    L7:
        r12 = 0;
        goto L8
    L10:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.phase == null) goto L5;
        r5.append(", phase=");
        r5.append(this.phase);
    L5:
        Map<String, String> r10 = this.phaseData;
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        r5.append(", phaseData=");
        r5.append(this.phaseData);
    L11:
        return a.s(r5, 0, 2, "StartPicoLinksResponse{", '}');
    }

    public StartPicoLinksResponse(Phase r5, Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.phase = r5;
        this.phaseData = Internal.immutableCopyOf("phaseData", r10);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.phase = this.phase;
        r5.phaseData = Internal.copyOf("phaseData", this.phaseData);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
