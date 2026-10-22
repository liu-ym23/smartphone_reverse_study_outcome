package com.ss.android.lark.pb.graph;

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
public final class MapFeature extends Message<MapFeature, Builder> {
    public static final ProtoAdapter<MapFeature> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Double> mfeature_map;

    public static final class Builder extends Message.Builder<MapFeature, Builder> {
        public Map<String, Double> mfeature_map;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MapFeature m1700build() {
            return new MapFeature(this.mfeature_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mfeature_map = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1700build();
        }

        public Builder feature_map(Map<String, Double> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfeature_map = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MapFeature extends ProtoAdapter<MapFeature> {
        private final ProtoAdapter<Map<String, Double>> mfeature_map;

        public ProtoAdapter_MapFeature() {
            super(FieldEncoding.LENGTH_DELIMITED, MapFeature.class);
            this.mfeature_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.DOUBLE);
        }

        public MapFeature decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mfeature_map.putAll((Map) this.mfeature_map.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1700build();
        }

        public int encodedSize(MapFeature r4) {
            return this.mfeature_map.encodedSizeWithTag(1, r4.mfeature_map) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1701decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MapFeature) r1);
        }

        public void encode(ProtoWriter r4, MapFeature r5) throws IOException {
            this.mfeature_map.encodeWithTag(r4, 1, r5.mfeature_map);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MapFeature) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MapFeature();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1699newBuilder() {
        Builder r0 = new Builder();
        r0.mfeature_map = Internal.copyOf("mfeature_map", this.mfeature_map);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MapFeature.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1699newBuilder();
    }

    public MapFeature(Map<String, Double> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MapFeature(Map<String, Double> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mfeature_map = Internal.immutableCopyOf("mfeature_map", r2);
    }
}
