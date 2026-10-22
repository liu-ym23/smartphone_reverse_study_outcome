package com.ss.android.lark.pb.office_ai_inline;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FetchQuickActionRequest extends Message<FetchQuickActionRequest, Builder> {
    public static final ProtoAdapter<FetchQuickActionRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Scenario mscenario;
    public final Map<String, String> mtrigger_params_map;

    public static final class Builder extends Message.Builder<FetchQuickActionRequest, Builder> {
        public Scenario mscenario;
        public Map<String, String> mtrigger_params_map;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FetchQuickActionRequest m2033build() {
            return new FetchQuickActionRequest(this.mscenario, this.mtrigger_params_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mtrigger_params_map = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2033build();
        }

        public Builder scenario(Scenario r1) {
            this.mscenario = r1;
            return this;
        }

        public Builder trigger_params_map(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtrigger_params_map = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionRequest extends ProtoAdapter<FetchQuickActionRequest> {
        private final ProtoAdapter<Map<String, String>> mtrigger_params_map;

        public ProtoAdapter_FetchQuickActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionRequest.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mtrigger_params_map = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public FetchQuickActionRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mscenario = (Scenario) Scenario.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtrigger_params_map.putAll((Map) this.mtrigger_params_map.decode(r9));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2033build();
        }

        public int encodedSize(FetchQuickActionRequest r5) {
            Scenario r0 = r5.mscenario;
            if (r0 == null) goto L5;
            int r1 = Scenario.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + this.mtrigger_params_map.encodedSizeWithTag(2, r5.mtrigger_params_map)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2034decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FetchQuickActionRequest) r1);
        }

        public void encode(ProtoWriter r4, FetchQuickActionRequest r5) throws IOException {
            Scenario r0 = r5.mscenario;
            if (r0 == null) goto L5;
            Scenario.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            this.mtrigger_params_map.encodeWithTag(r4, 2, r5.mtrigger_params_map);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FetchQuickActionRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2032newBuilder() {
        Builder r0 = new Builder();
        r0.mscenario = this.mscenario;
        r0.mtrigger_params_map = Internal.copyOf("mtrigger_params_map", this.mtrigger_params_map);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FetchQuickActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2032newBuilder();
    }

    public FetchQuickActionRequest(Scenario r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public FetchQuickActionRequest(Scenario r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mscenario = r2;
        this.mtrigger_params_map = Internal.immutableCopyOf("mtrigger_params_map", r3);
    }
}
