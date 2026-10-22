package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PickEntities extends Message<PickEntities, Builder> {
    public static final ProtoAdapter<PickEntities> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> mpick_ids;
    public final PickType mpick_type;

    public static final class Builder extends Message.Builder<PickEntities, Builder> {
        public List<String> mpick_ids;
        public PickType mpick_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PickEntities m884build() {
            PickType r0 = this.mpick_type;
            if (r0 == null) goto L7;
            return new PickEntities(this.mpick_type, this.mpick_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mpick_type"});
        }

        public Builder() {
            this.mpick_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m884build();
        }

        public Builder pick_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpick_ids = r1;
            return this;
        }

        public Builder pick_type(PickType r1) {
            this.mpick_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PickEntities extends ProtoAdapter<PickEntities> {
        public ProtoAdapter_PickEntities() {
            super(FieldEncoding.LENGTH_DELIMITED, PickEntities.class);
        }

        public PickEntities decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mpick_type = (PickType) PickType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mpick_ids.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m884build();
        }

        public int encodedSize(PickEntities r5) {
            return (PickType.ADAPTER.encodedSizeWithTag(1, r5.mpick_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r5.mpick_ids)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m885decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PickEntities) r1);
        }

        public void encode(ProtoWriter r4, PickEntities r5) throws IOException {
            PickType.ADAPTER.encodeWithTag(r4, 1, r5.mpick_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 2, r5.mpick_ids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PickEntities) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PickEntities();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m883newBuilder() {
        Builder r0 = new Builder();
        r0.mpick_type = this.mpick_type;
        r0.mpick_ids = Internal.copyOf("mpick_ids", this.mpick_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PickEntities.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m883newBuilder();
    }

    public PickEntities(PickType r2, List<String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PickEntities(PickType r2, List<String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mpick_type = r2;
        this.mpick_ids = Internal.immutableCopyOf("mpick_ids", r3);
    }
}
