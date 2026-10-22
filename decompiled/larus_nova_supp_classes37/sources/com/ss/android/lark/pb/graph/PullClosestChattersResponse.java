package com.ss.android.lark.pb.graph;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullClosestChattersResponse extends Message<PullClosestChattersResponse, Builder> {
    public static final ProtoAdapter<PullClosestChattersResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Integer DEFAULT_TOTAL = null;
    private static final long serialVersionUID = 0;
    public final List<ChatterMeta> mchatters;
    public final Boolean mhas_more;
    public final Map<String, RelationshipTypeVector> mrelationship_map;
    public final Integer mtotal;

    public static final class Builder extends Message.Builder<PullClosestChattersResponse, Builder> {
        public List<ChatterMeta> mchatters;
        public Boolean mhas_more;
        public Map<String, RelationshipTypeVector> mrelationship_map;
        public Integer mtotal;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullClosestChattersResponse m1712build() {
            return new PullClosestChattersResponse(this.mchatters, this.mtotal, this.mhas_more, this.mrelationship_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mchatters = Internal.newMutableList();
            this.mrelationship_map = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1712build();
        }

        public Builder chatters(List<ChatterMeta> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatters = r1;
            return this;
        }

        public Builder has_more(Boolean r1) {
            this.mhas_more = r1;
            return this;
        }

        public Builder relationship_map(Map<String, RelationshipTypeVector> r1) {
            Internal.checkElementsNotNull(r1);
            this.mrelationship_map = r1;
            return this;
        }

        public Builder total(Integer r1) {
            this.mtotal = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullClosestChattersResponse extends ProtoAdapter<PullClosestChattersResponse> {
        private final ProtoAdapter<Map<String, RelationshipTypeVector>> mrelationship_map;

        public ProtoAdapter_PullClosestChattersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullClosestChattersResponse.class);
            this.mrelationship_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, RelationshipTypeVector.ADAPTER);
        }

        public PullClosestChattersResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtotal = 0;
            r0.mhas_more = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mchatters.add((ChatterMeta) ChatterMeta.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtotal = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mhas_more = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mrelationship_map.putAll((Map) this.mrelationship_map.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1712build();
        }

        public int encodedSize(PullClosestChattersResponse r6) {
            int r0 = ChatterMeta.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mchatters);
            Integer r1 = r6.mtotal;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.INT32.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Boolean r5 = r6.mhas_more;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r5);
        L10:
            return ((r4 + r2) + this.mrelationship_map.encodedSizeWithTag(4, r6.mrelationship_map)) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1713decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullClosestChattersResponse) r1);
        }

        public void encode(ProtoWriter r4, PullClosestChattersResponse r5) throws IOException {
            ChatterMeta.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mchatters);
            Integer r0 = r5.mtotal;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r0);
        L5:
            Boolean r1 = r5.mhas_more;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L8:
            this.mrelationship_map.encodeWithTag(r4, 4, r5.mrelationship_map);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullClosestChattersResponse) r2);
        }
    }

    public static final enum RelationshipType extends Enum<RelationshipType> implements WireEnum {
        private static final /* synthetic */ RelationshipType[] $VALUES = null;
        public static final ProtoAdapter<RelationshipType> ADAPTER = null;
        public static final RelationshipType RELATIONSHIP_B2B_FRIEND = null;
        public static final RelationshipType RELATIONSHIP_OUTER_FRIEND = null;
        public static final RelationshipType RELATIONSHIP_UNKNOWN = null;
        private final int value;

        static {
            RelationshipType r0 = new RelationshipType("RELATIONSHIP_UNKNOWN", 0, 0);
            RELATIONSHIP_UNKNOWN = r0;
            RelationshipType r1 = new RelationshipType("RELATIONSHIP_B2B_FRIEND", 1, 1);
            RELATIONSHIP_B2B_FRIEND = r1;
            RelationshipType r3 = new RelationshipType("RELATIONSHIP_OUTER_FRIEND", 2, 2);
            RELATIONSHIP_OUTER_FRIEND = r3;
            $VALUES = new RelationshipType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(RelationshipType.class);
        }

        public static RelationshipType[] values() {
            return (RelationshipType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RelationshipType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return RELATIONSHIP_OUTER_FRIEND;
        L12:
            return RELATIONSHIP_B2B_FRIEND;
        L14:
            return RELATIONSHIP_UNKNOWN;
        }

        public static RelationshipType valueOf(String r1) {
            return (RelationshipType) a.a(RelationshipType.class, r1);
        }

        private RelationshipType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class RelationshipTypeVector extends Message<RelationshipTypeVector, Builder> {
        public static final ProtoAdapter<RelationshipTypeVector> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<RelationshipType> mrelationships;

        public static final class Builder extends Message.Builder<RelationshipTypeVector, Builder> {
            public List<RelationshipType> mrelationships;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RelationshipTypeVector m1715build() {
                return new RelationshipTypeVector(this.mrelationships, super.buildUnknownFields());
            }

            public Builder() {
                this.mrelationships = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1715build();
            }

            public Builder relationships(List<RelationshipType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mrelationships = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RelationshipTypeVector extends ProtoAdapter<RelationshipTypeVector> {
            public ProtoAdapter_RelationshipTypeVector() {
                super(FieldEncoding.LENGTH_DELIMITED, RelationshipTypeVector.class);
            }

            public RelationshipTypeVector decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mrelationships.add((RelationshipType) RelationshipType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L12:
                r9.endMessage(r1);
                return r0.m1715build();
            }

            public int encodedSize(RelationshipTypeVector r4) {
                return RelationshipType.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mrelationships) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1716decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RelationshipTypeVector) r1);
            }

            public void encode(ProtoWriter r4, RelationshipTypeVector r5) throws IOException {
                RelationshipType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mrelationships);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RelationshipTypeVector) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RelationshipTypeVector();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1714newBuilder() {
            Builder r0 = new Builder();
            r0.mrelationships = Internal.copyOf("mrelationships", this.mrelationships);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RelationshipTypeVector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1714newBuilder();
        }

        public RelationshipTypeVector(List<RelationshipType> r2) {
            this(r2, ByteString.EMPTY);
        }

        public RelationshipTypeVector(List<RelationshipType> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mrelationships = Internal.immutableCopyOf("mrelationships", r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullClosestChattersResponse();
        DEFAULT_TOTAL = 0;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1711newBuilder() {
        Builder r0 = new Builder();
        r0.mchatters = Internal.copyOf("mchatters", this.mchatters);
        r0.mtotal = this.mtotal;
        r0.mhas_more = this.mhas_more;
        r0.mrelationship_map = Internal.copyOf("mrelationship_map", this.mrelationship_map);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullClosestChattersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1711newBuilder();
    }

    public PullClosestChattersResponse(List<ChatterMeta> r7, Integer r8, Boolean r9, Map<String, RelationshipTypeVector> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PullClosestChattersResponse(List<ChatterMeta> r2, Integer r3, Boolean r4, Map<String, RelationshipTypeVector> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mchatters = Internal.immutableCopyOf("mchatters", r2);
        this.mtotal = r3;
        this.mhas_more = r4;
        this.mrelationship_map = Internal.immutableCopyOf("mrelationship_map", r5);
    }
}
