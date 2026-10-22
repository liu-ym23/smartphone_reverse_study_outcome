package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MemberFieldSettings extends Message<MemberFieldSettings, Builder> {
    public static final ProtoAdapter<MemberFieldSettings> ADAPTER = null;
    public static final Boolean DEFAULT_MULTIPLE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mmultiple;

    public static final class Builder extends Message.Builder<MemberFieldSettings, Builder> {
        public Boolean mmultiple;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MemberFieldSettings m2306build() {
            return new MemberFieldSettings(this.mmultiple, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2306build();
        }

        public Builder multiple(Boolean r1) {
            this.mmultiple = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MemberFieldSettings extends ProtoAdapter<MemberFieldSettings> {
        public ProtoAdapter_MemberFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, MemberFieldSettings.class);
        }

        public MemberFieldSettings decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mmultiple = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmultiple = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2306build();
        }

        public int encodedSize(MemberFieldSettings r4) {
            Boolean r0 = r4.mmultiple;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2307decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MemberFieldSettings) r1);
        }

        public void encode(ProtoWriter r4, MemberFieldSettings r5) throws IOException {
            Boolean r0 = r5.mmultiple;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MemberFieldSettings) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MemberFieldSettings();
        DEFAULT_MULTIPLE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2305newBuilder() {
        Builder r0 = new Builder();
        r0.mmultiple = this.mmultiple;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MemberFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2305newBuilder();
    }

    public MemberFieldSettings(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public MemberFieldSettings(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmultiple = r2;
    }
}
