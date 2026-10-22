package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EffectiveInterval extends com.squareup.wire.Message<EffectiveInterval, Builder> {
    public static final ProtoAdapter<EffectiveInterval> ADAPTER = null;
    public static final Long DEFAULT_END_TIME = null;
    public static final Boolean DEFAULT_IS_OPEN_WITHOUT_END_TIME = null;
    public static final Boolean DEFAULT_IS_SHOW_END_TIME = null;
    public static final Long DEFAULT_START_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long mend_time;
    public final Boolean mis_open_without_end_time;
    public final Boolean mis_show_end_time;
    public final Long mstart_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<EffectiveInterval, Builder> {
        public Long mend_time;
        public Boolean mis_open_without_end_time;
        public Boolean mis_show_end_time;
        public Long mstart_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EffectiveInterval m1208build() {
            return new EffectiveInterval(this.mstart_time, this.mend_time, this.mis_show_end_time, this.mis_open_without_end_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1208build();
        }

        public Builder end_time(Long r1) {
            this.mend_time = r1;
            return this;
        }

        public Builder is_open_without_end_time(Boolean r1) {
            this.mis_open_without_end_time = r1;
            return this;
        }

        public Builder is_show_end_time(Boolean r1) {
            this.mis_show_end_time = r1;
            return this;
        }

        public Builder start_time(Long r1) {
            this.mstart_time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EffectiveInterval extends ProtoAdapter<EffectiveInterval> {
        public ProtoAdapter_EffectiveInterval() {
            super(FieldEncoding.LENGTH_DELIMITED, EffectiveInterval.class);
        }

        public EffectiveInterval decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mstart_time = 0L;
            r0.mend_time = 0L;
            r0.mis_show_end_time = Boolean.TRUE;
            r0.mis_open_without_end_time = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mstart_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mend_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mis_show_end_time = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mis_open_without_end_time = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1208build();
        }

        public int encodedSize(EffectiveInterval r6) {
            Long r0 = r6.mstart_time;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mend_time;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_show_end_time;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mis_open_without_end_time;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1209decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EffectiveInterval) r1);
        }

        public void encode(ProtoWriter r4, EffectiveInterval r5) throws IOException {
            Long r0 = r5.mstart_time;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mend_time;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_show_end_time;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mis_open_without_end_time;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EffectiveInterval) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EffectiveInterval();
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
        DEFAULT_IS_SHOW_END_TIME = Boolean.TRUE;
        DEFAULT_IS_OPEN_WITHOUT_END_TIME = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1207newBuilder() {
        Builder r0 = new Builder();
        r0.mstart_time = this.mstart_time;
        r0.mend_time = this.mend_time;
        r0.mis_show_end_time = this.mis_show_end_time;
        r0.mis_open_without_end_time = this.mis_open_without_end_time;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EffectiveInterval.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1207newBuilder();
    }

    public EffectiveInterval(Long r7, Long r8, Boolean r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public EffectiveInterval(Long r2, Long r3, Boolean r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mstart_time = r2;
        this.mend_time = r3;
        this.mis_show_end_time = r4;
        this.mis_open_without_end_time = r5;
    }
}
