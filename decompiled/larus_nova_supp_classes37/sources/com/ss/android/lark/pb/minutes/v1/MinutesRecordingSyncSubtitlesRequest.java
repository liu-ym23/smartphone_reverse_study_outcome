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
public final class MinutesRecordingSyncSubtitlesRequest extends Message<MinutesRecordingSyncSubtitlesRequest, Builder> {
    public static final ProtoAdapter<MinutesRecordingSyncSubtitlesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_SYNC = null;
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final ProtoAdapter_MinutesRecordingSyncSubtitlesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean force_sync;
    public final String language;
    public final String session_id;

    public static final class Builder extends Message.Builder<MinutesRecordingSyncSubtitlesRequest, Builder> implements d<MinutesRecordingSyncSubtitlesRequest> {
        public Boolean force_sync;
        public String language;
        public String session_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingSyncSubtitlesRequest m1892build() {
            String r0 = this.session_id;
            if (r0 == null) goto L9;
            if (this.language == null) goto L9;
            return new MinutesRecordingSyncSubtitlesRequest(this.session_id, this.language, this.force_sync, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "session_id", this.language, "language"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1892build();
        }

        public Builder force_sync(Boolean r1) {
            this.force_sync = r1;
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
    }

    public static final class ProtoAdapter_MinutesRecordingSyncSubtitlesRequest extends ProtoAdapter<MinutesRecordingSyncSubtitlesRequest> implements c<MinutesRecordingSyncSubtitlesRequest> {
        public ProtoAdapter_MinutesRecordingSyncSubtitlesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingSyncSubtitlesRequest.class);
        }

        public MinutesRecordingSyncSubtitlesRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.session_id = "";
            r0.language = "";
            r0.force_sync = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.session_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.language = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.force_sync = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1892build();
        }

        public int encodedSize(MinutesRecordingSyncSubtitlesRequest r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r5.session_id) + r0.encodedSizeWithTag(2, r5.language);
            Boolean r2 = r5.force_sync;
            if (r2 == null) goto L5;
            int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r2);
        L7:
            return (r1 + r3) + r5.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1893decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingSyncSubtitlesRequest) r1);
        }

        public void encode(ProtoWriter r4, MinutesRecordingSyncSubtitlesRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.session_id);
            r0.encodeWithTag(r4, 2, r5.language);
            Boolean r1 = r5.force_sync;
            if (r1 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingSyncSubtitlesRequest) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingSyncSubtitlesRequest r0 = new ProtoAdapter_MinutesRecordingSyncSubtitlesRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_FORCE_SYNC = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1891newBuilder() {
        Builder r0 = new Builder();
        r0.session_id = this.session_id;
        r0.language = this.language;
        r0.force_sync = this.force_sync;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingSyncSubtitlesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1891newBuilder();
    }

    public MinutesRecordingSyncSubtitlesRequest(String r2, String r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MinutesRecordingSyncSubtitlesRequest(String r2, String r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.session_id = r2;
        this.language = r3;
        this.force_sync = r4;
    }
}
