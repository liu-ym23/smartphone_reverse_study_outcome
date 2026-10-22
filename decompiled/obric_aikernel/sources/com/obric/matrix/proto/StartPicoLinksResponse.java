package com.obric.matrix.proto;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class StartPicoLinksResponse extends Message<StartPicoLinksResponse, a> {
    public static final ProtoAdapter<StartPicoLinksResponse> ADAPTER = null;
    public static final Phase DEFAULT_PHASE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    @c(TypedValues.CycleType.S_WAVE_PHASE)
    public final Phase phase;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @c("phaseData")
    public final Map<String, String> phaseData;

    public static final enum Phase extends Enum<Phase> implements WireEnum {
        private static final /* synthetic */ Phase[] $VALUES = null;
        public static final ProtoAdapter<Phase> ADAPTER = null;
        public static final Phase ASYNC_CALLBACK = null;
        public static final Phase SYNC_INVOKE = null;
        public static final Phase URL_REDIRECT = null;
        private final int value;

        private static final class a extends EnumAdapter<Phase> {
            a() {
                super(Phase.class);
            }

            protected Phase a(int r10) {
                return Phase.fromValue(r10);
            }

            @Override // com.squareup.wire.EnumAdapter
            protected /* bridge */ /* synthetic */ WireEnum fromValue(int r10) {
                return a(r10);
            }
        }

        static {
            Phase r10 = new Phase("SYNC_INVOKE", 0, 0);
            SYNC_INVOKE = r10;
            Phase r11 = new Phase("ASYNC_CALLBACK", 1, 1);
            ASYNC_CALLBACK = r11;
            Phase r12 = new Phase("URL_REDIRECT", 2, 2);
            URL_REDIRECT = r12;
            $VALUES = new Phase[]{r10, r11, r12};
            ADAPTER = new a();
        }

        private Phase(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Phase fromValue(int r10) {
            if (r10 == 0) goto L14;
            if (r10 == 1) goto L12;
            if (r10 == 2) goto L10;
            return null;
        L10:
            return URL_REDIRECT;
        L12:
            return ASYNC_CALLBACK;
        L14:
            return SYNC_INVOKE;
        }

        public static Phase valueOf(String r10) {
            return (Phase) Enum.valueOf(Phase.class, r10);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class a extends Message.Builder<StartPicoLinksResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Phase f6100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f6101b;

        public a() {
            this.f6100a = Phase.SYNC_INVOKE;
            this.f6101b = Internal.newMutableMap();
        }

        public StartPicoLinksResponse a() {
            return new StartPicoLinksResponse(this.f6100a, this.f6101b, super.buildUnknownFields());
        }

        public a b(Phase r10) {
            this.f6100a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<StartPicoLinksResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6102a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksResponse.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f6102a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public StartPicoLinksResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L15;
            if (r13 != 1) goto L8;
            r11.b(Phase.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r11.addUnknownField(r13, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.f6101b.putAll(this.f6102a.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, StartPicoLinksResponse r11) {
            Phase.ADAPTER.encodeWithTag(r10, 1, r11.phase);
            this.f6102a.encodeWithTag(r10, 2, r11.phaseData);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(StartPicoLinksResponse r10) {
            return (Phase.ADAPTER.encodedSizeWithTag(1, r10.phase) + this.f6102a.encodedSizeWithTag(2, r10.phaseData)) + r10.unknownFields().size();
        }

        public StartPicoLinksResponse d(StartPicoLinksResponse r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, StartPicoLinksResponse r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StartPicoLinksResponse r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse redact(StartPicoLinksResponse r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_PHASE = Phase.SYNC_INVOKE;
    }

    public StartPicoLinksResponse(Phase r10, Map<String, String> r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public StartPicoLinksResponse(Phase r10, Map<String, String> r11, ByteString r12) {
        super(ADAPTER, r12);
        this.phase = r10;
        this.phaseData = Internal.immutableCopyOf("phaseData", r11);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof StartPicoLinksResponse) == true) goto L8;
        return false;
    L8:
        StartPicoLinksResponse r11 = (StartPicoLinksResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.phase, r11.phase) == false) goto L16;
        if (this.phaseData.equals(r11.phaseData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        Phase r12 = this.phase;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = ((r11 + r13) * 37) + this.phaseData.hashCode();
        this.hashCode = r14;
        return r14;
    L7:
        r13 = 0;
        goto L8
    L10:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6100a = this.phase;
        r10.f6101b = Internal.copyOf("phaseData", this.phaseData);
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.phase == null) goto L5;
        r10.append(", phase=");
        r10.append(this.phase);
    L5:
        Map<String, String> r11 = this.phaseData;
        if (r11 != null) goto L8;
    L10:
        StringBuilder r12 = r10.replace(0, 2, "StartPicoLinksResponse{");
        r12.append('}');
        return r12.toString();
    L8:
        if (r11.isEmpty() == true) goto L10;
        r10.append(", phaseData=");
        r10.append(this.phaseData);
        goto L10
    }
}
