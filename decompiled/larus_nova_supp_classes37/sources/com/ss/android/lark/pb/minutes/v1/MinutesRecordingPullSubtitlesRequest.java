package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingPullSubtitlesRequest extends Message<MinutesRecordingPullSubtitlesRequest, Builder> {
    public static final ProtoAdapter<MinutesRecordingPullSubtitlesRequest> ADAPTER = null;
    public static final Long DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_FORCE_FROM_SERVER = null;
    public static final Boolean DEFAULT_IS_FORWARD = null;
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final Long DEFAULT_TARGET_SEG_ID = null;
    public static final ProtoAdapter_MinutesRecordingPullSubtitlesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long count;
    public final Boolean force_from_server;
    public final Boolean is_forward;
    public final String language;
    public final String session_id;
    public final Long target_seg_id;

    public static final class Builder extends Message.Builder<MinutesRecordingPullSubtitlesRequest, Builder> implements d<MinutesRecordingPullSubtitlesRequest> {
        public Long count;
        public Boolean force_from_server;
        public Boolean is_forward;
        public String language;
        public String session_id;
        public Long target_seg_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingPullSubtitlesRequest m1853build() {
            String r0 = this.session_id;
            if (r0 == null) goto L9;
            if (this.language == null) goto L9;
            return new MinutesRecordingPullSubtitlesRequest(this.session_id, this.language, this.force_from_server, this.is_forward, this.target_seg_id, this.count, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "session_id", this.language, "language"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1853build();
        }

        public Builder count(Long r1) {
            this.count = r1;
            return this;
        }

        public Builder force_from_server(Boolean r1) {
            this.force_from_server = r1;
            return this;
        }

        public Builder is_forward(Boolean r1) {
            this.is_forward = r1;
            return this;
        }

        public Builder language(String r1) {
            this.language = r1;
            return this;
        }

        public Builder session_id(String r1) {
            this.session_id = r1;
            return this;
        }

        public Builder target_seg_id(Long r1) {
            this.target_seg_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingPullSubtitlesRequest extends ProtoAdapter<MinutesRecordingPullSubtitlesRequest> implements c<MinutesRecordingPullSubtitlesRequest> {
        public ProtoAdapter_MinutesRecordingPullSubtitlesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingPullSubtitlesRequest.class);
        }

        public MinutesRecordingPullSubtitlesRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.session_id = "";
            r0.language = "";
            Boolean r1 = Boolean.FALSE;
            r0.force_from_server = r1;
            r0.is_forward = r1;
            r0.target_seg_id = 0L;
            r0.count = 0L;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.count = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            r0.target_seg_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            r0.is_forward = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            r0.force_from_server = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            r0.language = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.session_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r2);
            return r0.m1853build();
        }

        public int encodedSize(MinutesRecordingPullSubtitlesRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.session_id) + r0.encodedSizeWithTag(2, r6.language);
            Boolean r2 = r6.force_from_server;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r2);
        L6:
            int r5 = r1 + r4;
            Boolean r7 = r6.is_forward;
            if (r7 == null) goto L9;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r7);
        L10:
            int r9 = r5 + r8;
            Long r10 = r6.target_seg_id;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(5, r10);
        L14:
            int r12 = r9 + r11;
            Long r13 = r6.count;
            if (r13 == null) goto L18;
            r3 = ProtoAdapter.INT64.encodedSizeWithTag(6, r13);
        L18:
            return (r12 + r3) + r6.unknownFields().size();
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1854decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingPullSubtitlesRequest) r1);
        }

        public void encode(ProtoWriter r4, MinutesRecordingPullSubtitlesRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.session_id);
            r0.encodeWithTag(r4, 2, r5.language);
            Boolean r1 = r5.force_from_server;
            if (r1 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L5:
            Boolean r2 = r5.is_forward;
            if (r2 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r2);
        L8:
            Long r3 = r5.target_seg_id;
            if (r3 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r3);
        L11:
            Long r6 = r5.count;
            if (r6 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 6, r6);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingPullSubtitlesRequest) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingPullSubtitlesRequest r0 = new ProtoAdapter_MinutesRecordingPullSubtitlesRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_FORCE_FROM_SERVER = r1;
        DEFAULT_IS_FORWARD = r1;
        DEFAULT_TARGET_SEG_ID = 0L;
        DEFAULT_COUNT = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1852newBuilder() {
        Builder r0 = new Builder();
        r0.session_id = this.session_id;
        r0.language = this.language;
        r0.force_from_server = this.force_from_server;
        r0.is_forward = this.is_forward;
        r0.target_seg_id = this.target_seg_id;
        r0.count = this.count;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingPullSubtitlesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1852newBuilder();
    }

    public MinutesRecordingPullSubtitlesRequest(String r9, String r10, Boolean r11, Boolean r12, Long r13, Long r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public MinutesRecordingPullSubtitlesRequest(String r2, String r3, Boolean r4, Boolean r5, Long r6, Long r7, ByteString r8) {
        super(ADAPTER, r8);
        this.session_id = r2;
        this.language = r3;
        this.force_from_server = r4;
        this.is_forward = r5;
        this.target_seg_id = r6;
        this.count = r7;
    }
}
