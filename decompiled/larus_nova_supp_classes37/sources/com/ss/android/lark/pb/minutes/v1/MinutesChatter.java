package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesChatter extends Message<MinutesChatter, Builder> {
    public static final ProtoAdapter<MinutesChatter> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final String id;
    public final String name;

    public static final class Builder extends Message.Builder<MinutesChatter, Builder> {
        public String avatar_key;
        public String id;
        public String name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesChatter m1838build() {
            String r0 = this.id;
            if (r0 == null) goto L7;
            return new MinutesChatter(this.id, this.name, this.avatar_key, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1838build();
        }

        public Builder avatar_key(String r1) {
            this.avatar_key = r1;
            return this;
        }

        public Builder id(String r1) {
            this.id = r1;
            return this;
        }

        public Builder name(String r1) {
            this.name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesChatter extends ProtoAdapter<MinutesChatter> {
        public ProtoAdapter_MinutesChatter() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesChatter.class);
        }

        public MinutesChatter decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.id = "";
            r0.name = "";
            r0.avatar_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.avatar_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1838build();
        }

        public int encodedSize(MinutesChatter r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.id);
            String r2 = r6.name;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.avatar_key;
            if (r7 == null) goto L10;
            r3 = r0.encodedSizeWithTag(3, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1839decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesChatter) r1);
        }

        public void encode(ProtoWriter r4, MinutesChatter r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.id);
            String r1 = r5.name;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            String r2 = r5.avatar_key;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 3, r2);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesChatter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MinutesChatter();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1837newBuilder() {
        Builder r0 = new Builder();
        r0.id = this.id;
        r0.name = this.name;
        r0.avatar_key = this.avatar_key;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesChatter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1837newBuilder();
    }

    public MinutesChatter(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MinutesChatter(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.id = r2;
        this.name = r3;
        this.avatar_key = r4;
    }
}
