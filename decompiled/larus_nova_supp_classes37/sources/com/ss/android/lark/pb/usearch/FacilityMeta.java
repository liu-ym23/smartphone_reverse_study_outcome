package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FacilityMeta extends Message<FacilityMeta, Builder> {
    public static final ProtoAdapter<FacilityMeta> ADAPTER = null;
    public static final String DEFAULT_APP_LINK = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_SOURCE_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mapp_link;
    public final String mid;
    public final String msource_key;

    public static final class Builder extends Message.Builder<FacilityMeta, Builder> {
        public String mapp_link;
        public String mid;
        public String msource_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FacilityMeta m2654build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new FacilityMeta(this.mid, this.msource_key, this.mapp_link, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2654build();
        }

        public Builder app_link(String r1) {
            this.mapp_link = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder source_key(String r1) {
            this.msource_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FacilityMeta extends ProtoAdapter<FacilityMeta> {
        public ProtoAdapter_FacilityMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, FacilityMeta.class);
        }

        public FacilityMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.msource_key = "";
            r0.mapp_link = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msource_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mapp_link = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2654build();
        }

        public int encodedSize(FacilityMeta r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mid);
            String r2 = r6.msource_key;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.mapp_link;
            if (r7 == null) goto L10;
            r3 = r0.encodedSizeWithTag(3, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2655decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FacilityMeta) r1);
        }

        public void encode(ProtoWriter r4, FacilityMeta r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            String r1 = r5.msource_key;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            String r2 = r5.mapp_link;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 3, r2);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FacilityMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FacilityMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2653newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.msource_key = this.msource_key;
        r0.mapp_link = this.mapp_link;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FacilityMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2653newBuilder();
    }

    public FacilityMeta(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public FacilityMeta(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mid = r2;
        this.msource_key = r3;
        this.mapp_link = r4;
    }
}
