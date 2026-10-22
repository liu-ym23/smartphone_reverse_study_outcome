package com.ss.android.lark.pb.videochat;

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
public final class GetSpeakerInfoRequest extends Message<GetSpeakerInfoRequest, Builder> {
    public static final ProtoAdapter<GetSpeakerInfoRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> mcluster_id_list;
    public final String mmeeting_id;
    public final String moperator_id;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<GetSpeakerInfoRequest, Builder> {
        public List<String> mcluster_id_list;
        public String mmeeting_id;
        public String moperator_id;
        public String mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSpeakerInfoRequest m3140build() {
            String r0 = this.moperator_id;
            if (r0 == null) goto L11;
            if (this.mtenant_id == null) goto L11;
            if (this.mmeeting_id == null) goto L11;
            return new GetSpeakerInfoRequest(this.moperator_id, this.mtenant_id, this.mmeeting_id, this.mcluster_id_list, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "moperator_id", this.mtenant_id, "mtenant_id", this.mmeeting_id, "mmeeting_id"});
        }

        public Builder() {
            this.mcluster_id_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3140build();
        }

        public Builder cluster_id_list(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcluster_id_list = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder operator_id(String r1) {
            this.moperator_id = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSpeakerInfoRequest extends ProtoAdapter<GetSpeakerInfoRequest> {
        public ProtoAdapter_GetSpeakerInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeakerInfoRequest.class);
        }

        public GetSpeakerInfoRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.moperator_id = "";
            r0.mtenant_id = "";
            r0.mmeeting_id = "";
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
            r0.mcluster_id_list.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m3140build();
        }

        public int encodedSize(GetSpeakerInfoRequest r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (((r0.encodedSizeWithTag(1, r5.moperator_id) + r0.encodedSizeWithTag(2, r5.mtenant_id)) + r0.encodedSizeWithTag(3, r5.mmeeting_id)) + r0.asRepeated().encodedSizeWithTag(4, r5.mcluster_id_list)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3141decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSpeakerInfoRequest) r1);
        }

        public void encode(ProtoWriter r4, GetSpeakerInfoRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.moperator_id);
            r0.encodeWithTag(r4, 2, r5.mtenant_id);
            r0.encodeWithTag(r4, 3, r5.mmeeting_id);
            r0.asRepeated().encodeWithTag(r4, 4, r5.mcluster_id_list);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSpeakerInfoRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeakerInfoRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3139newBuilder() {
        Builder r0 = new Builder();
        r0.moperator_id = this.moperator_id;
        r0.mtenant_id = this.mtenant_id;
        r0.mmeeting_id = this.mmeeting_id;
        r0.mcluster_id_list = Internal.copyOf("mcluster_id_list", this.mcluster_id_list);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSpeakerInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3139newBuilder();
    }

    public GetSpeakerInfoRequest(String r7, String r8, String r9, List<String> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public GetSpeakerInfoRequest(String r2, String r3, String r4, List<String> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.moperator_id = r2;
        this.mtenant_id = r3;
        this.mmeeting_id = r4;
        this.mcluster_id_list = Internal.immutableCopyOf("mcluster_id_list", r5);
    }
}
