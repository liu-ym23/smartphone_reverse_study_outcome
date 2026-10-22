package com.ss.android.lark.pb.section;

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
public final class Modifier extends Message<Modifier, Builder> {
    public static final ProtoAdapter<Modifier> ADAPTER = null;
    public static final Integer DEFAULT_END_INDEX = null;
    public static final Integer DEFAULT_START_INDEX = null;
    private static final long serialVersionUID = 0;
    public final Integer mend_index;
    public final List<ModifierMeta> mmetas;
    public final Integer mstart_index;

    public static final class Builder extends Message.Builder<Modifier, Builder> {
        public Integer mend_index;
        public List<ModifierMeta> mmetas;
        public Integer mstart_index;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Modifier m2141build() {
            return new Modifier(this.mstart_index, this.mend_index, this.mmetas, super.buildUnknownFields());
        }

        public Builder() {
            this.mmetas = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2141build();
        }

        public Builder end_index(Integer r1) {
            this.mend_index = r1;
            return this;
        }

        public Builder metas(List<ModifierMeta> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmetas = r1;
            return this;
        }

        public Builder start_index(Integer r1) {
            this.mstart_index = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Modifier extends ProtoAdapter<Modifier> {
        public ProtoAdapter_Modifier() {
            super(FieldEncoding.LENGTH_DELIMITED, Modifier.class);
        }

        public Modifier decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mstart_index = 0;
            r0.mend_index = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mstart_index = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mend_index = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mmetas.add((ModifierMeta) ModifierMeta.ADAPTER.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2141build();
        }

        public int encodedSize(Modifier r5) {
            Integer r0 = r5.mstart_index;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r5.mend_index;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + ModifierMeta.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mmetas)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2142decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Modifier) r1);
        }

        public void encode(ProtoWriter r4, Modifier r5) throws IOException {
            Integer r0 = r5.mstart_index;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mend_index;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            ModifierMeta.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mmetas);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Modifier) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Modifier();
        DEFAULT_START_INDEX = 0;
        DEFAULT_END_INDEX = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2140newBuilder() {
        Builder r0 = new Builder();
        r0.mstart_index = this.mstart_index;
        r0.mend_index = this.mend_index;
        r0.mmetas = Internal.copyOf("mmetas", this.mmetas);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Modifier.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2140newBuilder();
    }

    public Modifier(Integer r2, Integer r3, List<ModifierMeta> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public Modifier(Integer r2, Integer r3, List<ModifierMeta> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mstart_index = r2;
        this.mend_index = r3;
        this.mmetas = Internal.immutableCopyOf("mmetas", r4);
    }
}
