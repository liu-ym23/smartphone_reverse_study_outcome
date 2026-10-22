package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetUserGuideResponse extends Message<GetUserGuideResponse, Builder> {
    public static final ProtoAdapter<GetUserGuideResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, Long> mfirst_login_time;
    public final Map<String, Long> mfst_login_time;
    public final List<UserGuideViewAreaPair> mpairs;

    public static final class Builder extends Message.Builder<GetUserGuideResponse, Builder> {
        public Map<Long, Long> mfirst_login_time;
        public Map<String, Long> mfst_login_time;
        public List<UserGuideViewAreaPair> mpairs;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetUserGuideResponse m1724build() {
            return new GetUserGuideResponse(this.mpairs, this.mfirst_login_time, this.mfst_login_time, super.buildUnknownFields());
        }

        public Builder() {
            this.mpairs = Internal.newMutableList();
            this.mfirst_login_time = Internal.newMutableMap();
            this.mfst_login_time = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1724build();
        }

        public Builder first_login_time(Map<Long, Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfirst_login_time = r1;
            return this;
        }

        public Builder fst_login_time(Map<String, Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfst_login_time = r1;
            return this;
        }

        public Builder pairs(List<UserGuideViewAreaPair> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpairs = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserGuideResponse extends ProtoAdapter<GetUserGuideResponse> {
        private final ProtoAdapter<Map<Long, Long>> mfirst_login_time;
        private final ProtoAdapter<Map<String, Long>> mfst_login_time;

        public ProtoAdapter_GetUserGuideResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserGuideResponse.class);
            ProtoAdapter r0 = ProtoAdapter.INT64;
            this.mfirst_login_time = ProtoAdapter.newMapAdapter(r0, r0);
            this.mfst_login_time = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, r0);
        }

        public GetUserGuideResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mpairs.add((UserGuideViewAreaPair) UserGuideViewAreaPair.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mfirst_login_time.putAll((Map) this.mfirst_login_time.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mfst_login_time.putAll((Map) this.mfst_login_time.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1724build();
        }

        public int encodedSize(GetUserGuideResponse r5) {
            return ((UserGuideViewAreaPair.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mpairs) + this.mfirst_login_time.encodedSizeWithTag(2, r5.mfirst_login_time)) + this.mfst_login_time.encodedSizeWithTag(3, r5.mfst_login_time)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1725decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetUserGuideResponse) r1);
        }

        public void encode(ProtoWriter r4, GetUserGuideResponse r5) throws IOException {
            UserGuideViewAreaPair.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mpairs);
            this.mfirst_login_time.encodeWithTag(r4, 2, r5.mfirst_login_time);
            this.mfst_login_time.encodeWithTag(r4, 3, r5.mfst_login_time);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetUserGuideResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetUserGuideResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1723newBuilder() {
        Builder r0 = new Builder();
        r0.mpairs = Internal.copyOf("mpairs", this.mpairs);
        r0.mfirst_login_time = Internal.copyOf("mfirst_login_time", this.mfirst_login_time);
        r0.mfst_login_time = Internal.copyOf("mfst_login_time", this.mfst_login_time);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetUserGuideResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1723newBuilder();
    }

    public GetUserGuideResponse(List<UserGuideViewAreaPair> r2, Map<Long, Long> r3, Map<String, Long> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GetUserGuideResponse(List<UserGuideViewAreaPair> r2, Map<Long, Long> r3, Map<String, Long> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mpairs = Internal.immutableCopyOf("mpairs", r2);
        this.mfirst_login_time = Internal.immutableCopyOf("mfirst_login_time", r3);
        this.mfst_login_time = Internal.immutableCopyOf("mfst_login_time", r4);
    }
}
