package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TimeZone extends com.squareup.wire.Message<TimeZone, Builder> {
    public static final ProtoAdapter<TimeZone> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mname;

    public static final class Builder extends com.squareup.wire.Message.Builder<TimeZone, Builder> {
        public String mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TimeZone m1562build() {
            String r0 = this.mname;
            if (r0 == null) goto L7;
            return new TimeZone(this.mname, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mname"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1562build();
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TimeZone extends ProtoAdapter<TimeZone> {
        public ProtoAdapter_TimeZone() {
            super(FieldEncoding.LENGTH_DELIMITED, TimeZone.class);
        }

        public TimeZone decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mname = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1562build();
        }

        public int encodedSize(TimeZone r4) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.mname) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1563decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TimeZone) r1);
        }

        public void encode(ProtoWriter r4, TimeZone r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mname);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TimeZone) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TimeZone();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1561newBuilder() {
        Builder r0 = new Builder();
        r0.mname = this.mname;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TimeZone.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1561newBuilder();
    }

    public TimeZone(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public TimeZone(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mname = r2;
    }
}
