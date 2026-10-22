package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetSpeakerInfoListRequest extends Message<GetSpeakerInfoListRequest, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoListRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final String DEFAULT_QUERY_CONDITION = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final String moperator_id;
    public final String mquery_condition;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<GetSpeakerInfoListRequest, Builder> {
        public String mmeeting_id;
        public String moperator_id;
        public String mquery_condition;
        public String mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSpeakerInfoListRequest m3134build() {
            String r0 = this.moperator_id;
            if (r0 == null) goto L11;
            if (this.mtenant_id == null) goto L11;
            if (this.mmeeting_id == null) goto L11;
            return new GetSpeakerInfoListRequest(this.moperator_id, this.mtenant_id, this.mmeeting_id, this.mquery_condition, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "moperator_id", this.mtenant_id, "mtenant_id", this.mmeeting_id, "mmeeting_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3134build();
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder operator_id(String r1) {
            this.moperator_id = r1;
            return this;
        }

        public Builder query_condition(String r1) {
            this.mquery_condition = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoListRequest extends ProtoAdapter<GetSpeakerInfoListRequest> {
        public ProtoAdapter_GetSpeakerInfoListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoListRequest.class);
        }

        public GetSpeakerInfoListRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.moperator_id = "";
            r0.mtenant_id = "";
            r0.mmeeting_id = "";
            r0.mquery_condition = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.moperator_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mquery_condition = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m3134build();
        }

        public int encodedSize(GetSpeakerInfoListRequest r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = (r0.encodedSizeWithTag(1, r5.moperator_id) + r0.encodedSizeWithTag(2, r5.mtenant_id)) + r0.encodedSizeWithTag(3, r5.mmeeting_id);
            String r2 = r5.mquery_condition;
            if (r2 == null) goto L5;
            int r3 = r0.encodedSizeWithTag(4, r2);
        L7:
            return (r1 + r3) + r5.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3135decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSpeakerInfoListRequest) r1);
        }

        public void encode(ProtoWriter r4, GetSpeakerInfoListRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.moperator_id);
            r0.encodeWithTag(r4, 2, r5.mtenant_id);
            r0.encodeWithTag(r4, 3, r5.mmeeting_id);
            String r1 = r5.mquery_condition;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 4, r1);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSpeakerInfoListRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoListRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3133newBuilder() {
        Builder r0 = new Builder();
        r0.moperator_id = this.moperator_id;
        r0.mtenant_id = this.mtenant_id;
        r0.mmeeting_id = this.mmeeting_id;
        r0.mquery_condition = this.mquery_condition;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSpeakerInfoListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3133newBuilder();
    }

    public GetSpeakerInfoListRequest(String r7, String r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public GetSpeakerInfoListRequest(String r2, String r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.moperator_id = r2;
        this.mtenant_id = r3;
        this.mmeeting_id = r4;
        this.mquery_condition = r5;
    }
}
