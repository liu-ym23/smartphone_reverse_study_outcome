package com.obric.matrix.proto;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class StartPicoLinksResponse extends Message<StartPicoLinksResponse, a> {
    public static final ProtoAdapter<StartPicoLinksResponse> ADAPTER = null;
    public static final Phase DEFAULT_PHASE = null;
    private static final long serialVersionUID = 0;

    @SerializedName(TypedValues.CycleType.S_WAVE_PHASE)
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    public final Phase phase;

    @SerializedName("phaseData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
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

            public Phase a(int r1) {
                return Phase.fromValue(r1);
            }

            @Override // com.squareup.wire.EnumAdapter
            public /* synthetic */ WireEnum fromValue(int r1) {
                return a(r1);
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
            ADAPTER = new a();
        }

        private Phase(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
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

        public static Phase valueOf(String r2) {
            return (Phase) ZeusTransformUtils.preCheckCast(Enum.valueOf(Phase.class, r2), Phase.class, "com.obric.memorydata.plugin");
        }

        public static Phase[] values() {
            return (Phase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Phase[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class a extends Message.Builder<StartPicoLinksResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Phase f8230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f8231b;

        public a() {
            this.f8230a = Phase.SYNC_INVOKE;
            this.f8231b = Internal.newMutableMap();
        }

        public a a(Phase r1) {
            this.f8230a = r1;
            return this;
        }

        public StartPicoLinksResponse a() {
            return new StartPicoLinksResponse(this.f8230a, this.f8231b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<StartPicoLinksResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8232a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksResponse.class);
            this.f8232a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(StartPicoLinksResponse r4) {
            return (Phase.ADAPTER.encodedSizeWithTag(1, r4.phase) + this.f8232a.encodedSizeWithTag(2, r4.phaseData)) + r4.unknownFields().size();
        }

        public StartPicoLinksResponse a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.a((Phase) ZeusTransformUtils.preCheckCast(Phase.ADAPTER.decode(r9), Phase.class, "com.obric.memorydata.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f8231b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8232a.decode(r9), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, StartPicoLinksResponse r5) {
            Phase.ADAPTER.encodeWithTag(r4, 1, r5.phase);
            this.f8232a.encodeWithTag(r4, 2, r5.phaseData);
            r4.writeBytes(r5.unknownFields());
        }

        public StartPicoLinksResponse b(StartPicoLinksResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ StartPicoLinksResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, StartPicoLinksResponse r4) {
            a(r3, (StartPicoLinksResponse) ZeusTransformUtils.preCheckCast(r4, StartPicoLinksResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(StartPicoLinksResponse r3) {
            return a((StartPicoLinksResponse) ZeusTransformUtils.preCheckCast(r3, StartPicoLinksResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ StartPicoLinksResponse redact(StartPicoLinksResponse r3) {
            return b((StartPicoLinksResponse) ZeusTransformUtils.preCheckCast(r3, StartPicoLinksResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_PHASE = Phase.SYNC_INVOKE;
    }

    public StartPicoLinksResponse(Phase r3, Map<String, String> r4) {
        this(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public StartPicoLinksResponse(Phase r3, Map<String, String> r4, ByteString r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r5);
        this.phase = r3;
        this.phaseData = Internal.immutableCopyOf("phaseData", r6);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, StartPicoLinksResponse.class) == true) goto L8;
        return false;
    L8:
        StartPicoLinksResponse r6 = (StartPicoLinksResponse) ZeusTransformUtils.preCheckCast(r5, StartPicoLinksResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.phase, r6.phase) == false) goto L16;
        if (this.phaseData.equals(r6.phaseData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Phase r2 = this.phase;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.phaseData.hashCode();
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8230a = this.phase;
        r0.f8231b = Internal.copyOf("phaseData", this.phaseData);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.phase == null) goto L5;
        r0.append(", phase=").append(this.phase);
    L5:
        Map<String, String> r1 = this.phaseData;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", phaseData=").append(this.phaseData);
    L11:
        return r0.replace(0, 2, "StartPicoLinksResponse{").append('}').toString();
    }
}
