package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PartialReplyInfo extends com.squareup.wire.Message<PartialReplyInfo, Builder> {
    public static final ProtoAdapter<PartialReplyInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final RichText mcontent;
    public final PartialContentRelativePosition mposition;

    public static final class Builder extends com.squareup.wire.Message.Builder<PartialReplyInfo, Builder> {
        public RichText mcontent;
        public PartialContentRelativePosition mposition;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PartialReplyInfo m1346build() {
            return new PartialReplyInfo(this.mcontent, this.mposition, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1346build();
        }

        public Builder content(RichText r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder position(PartialContentRelativePosition r1) {
            this.mposition = r1;
            return this;
        }
    }

    public static final enum PartialContentRelativePosition extends Enum<PartialContentRelativePosition> implements WireEnum {
        private static final /* synthetic */ PartialContentRelativePosition[] $VALUES = null;
        public static final ProtoAdapter<PartialContentRelativePosition> ADAPTER = null;
        public static final PartialContentRelativePosition HEAD = null;
        public static final PartialContentRelativePosition MIDDLE = null;
        public static final PartialContentRelativePosition TAIL = null;
        public static final PartialContentRelativePosition UNKNOWN = null;
        private final int value;

        static {
            PartialContentRelativePosition r0 = new PartialContentRelativePosition("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            PartialContentRelativePosition r1 = new PartialContentRelativePosition("HEAD", 1, 1);
            HEAD = r1;
            PartialContentRelativePosition r3 = new PartialContentRelativePosition("MIDDLE", 2, 2);
            MIDDLE = r3;
            PartialContentRelativePosition r5 = new PartialContentRelativePosition("TAIL", 3, 3);
            TAIL = r5;
            $VALUES = new PartialContentRelativePosition[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(PartialContentRelativePosition.class);
        }

        public static PartialContentRelativePosition[] values() {
            return (PartialContentRelativePosition[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static PartialContentRelativePosition fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return TAIL;
        L14:
            return MIDDLE;
        L16:
            return HEAD;
        L18:
            return UNKNOWN;
        }

        public static PartialContentRelativePosition valueOf(String r1) {
            return (PartialContentRelativePosition) a.a(PartialContentRelativePosition.class, r1);
        }

        private PartialContentRelativePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_PartialReplyInfo extends ProtoAdapter<PartialReplyInfo> {
        public ProtoAdapter_PartialReplyInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PartialReplyInfo.class);
        }

        public PartialReplyInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mcontent = (RichText) RichText.ADAPTER.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mposition = (PartialContentRelativePosition) PartialContentRelativePosition.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1346build();
        }

        public int encodedSize(PartialReplyInfo r5) {
            RichText r0 = r5.mcontent;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = RichText.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            PartialContentRelativePosition r3 = r5.mposition;
            if (r3 == null) goto L10;
            r1 = PartialContentRelativePosition.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1347decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PartialReplyInfo) r1);
        }

        public void encode(ProtoWriter r4, PartialReplyInfo r5) throws IOException {
            RichText r0 = r5.mcontent;
            if (r0 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            PartialContentRelativePosition r1 = r5.mposition;
            if (r1 == null) goto L8;
            PartialContentRelativePosition.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PartialReplyInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PartialReplyInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1345newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.mposition = this.mposition;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PartialReplyInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1345newBuilder();
    }

    public PartialReplyInfo(RichText r2, PartialContentRelativePosition r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PartialReplyInfo(RichText r2, PartialContentRelativePosition r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mcontent = r2;
        this.mposition = r3;
    }
}
