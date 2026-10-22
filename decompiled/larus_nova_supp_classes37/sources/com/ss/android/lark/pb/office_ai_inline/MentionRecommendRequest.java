package com.ss.android.lark.pb.office_ai_inline;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MentionRecommendRequest extends Message<MentionRecommendRequest, Builder> {
    public static final ProtoAdapter<MentionRecommendRequest> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_OBJ_TOKEN = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final String mobj_token;
    public final Scenario mscenario;
    public final String mtype;

    public static final class Builder extends Message.Builder<MentionRecommendRequest, Builder> {
        public String mcontent;
        public String mobj_token;
        public Scenario mscenario;
        public String mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MentionRecommendRequest m2039build() {
            return new MentionRecommendRequest(this.mscenario, this.mobj_token, this.mcontent, this.mtype, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2039build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder obj_token(String r1) {
            this.mobj_token = r1;
            return this;
        }

        public Builder scenario(Scenario r1) {
            this.mscenario = r1;
            return this;
        }

        public Builder type(String r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MentionRecommendRequest extends ProtoAdapter<MentionRecommendRequest> {
        public ProtoAdapter_MentionRecommendRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MentionRecommendRequest.class);
        }

        public MentionRecommendRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mobj_token = "";
            r0.mcontent = "";
            r0.mtype = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mscenario = (Scenario) Scenario.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mobj_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mtype = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2039build();
        }

        public int encodedSize(MentionRecommendRequest r6) {
            Scenario r0 = r6.mscenario;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Scenario.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mobj_token;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mcontent;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mtype;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m2040decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MentionRecommendRequest) r1);
        }

        public void encode(ProtoWriter r4, MentionRecommendRequest r5) throws IOException {
            Scenario r0 = r5.mscenario;
            if (r0 == null) goto L5;
            Scenario.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mobj_token;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mcontent;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mtype;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MentionRecommendRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MentionRecommendRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2038newBuilder() {
        Builder r0 = new Builder();
        r0.mscenario = this.mscenario;
        r0.mobj_token = this.mobj_token;
        r0.mcontent = this.mcontent;
        r0.mtype = this.mtype;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MentionRecommendRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2038newBuilder();
    }

    public MentionRecommendRequest(Scenario r7, String r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public MentionRecommendRequest(Scenario r2, String r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mscenario = r2;
        this.mobj_token = r3;
        this.mcontent = r4;
        this.mtype = r5;
    }
}
