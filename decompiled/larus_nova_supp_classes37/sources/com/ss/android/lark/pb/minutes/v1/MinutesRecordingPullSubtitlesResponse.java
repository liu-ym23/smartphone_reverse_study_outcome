package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingPullSubtitlesResponse extends Message<MinutesRecordingPullSubtitlesResponse, Builder> {
    public static final ProtoAdapter<MinutesRecordingPullSubtitlesResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_NEXT_TARGET_SEG_ID = null;
    public static final ProtoAdapter_MinutesRecordingPullSubtitlesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_more;
    public final Long next_target_seg_id;
    public final List<RecordingSubtitleData> subtitles;

    public static final class Builder extends Message.Builder<MinutesRecordingPullSubtitlesResponse, Builder> implements d<MinutesRecordingPullSubtitlesResponse> {
        public Boolean has_more;
        public Long next_target_seg_id;
        public List<RecordingSubtitleData> subtitles;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingPullSubtitlesResponse m1856build() {
            return new MinutesRecordingPullSubtitlesResponse(this.subtitles, this.next_target_seg_id, this.has_more, super.buildUnknownFields());
        }

        public Builder() {
            this.subtitles = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1856build();
        }

        public Builder has_more(Boolean r1) {
            this.has_more = r1;
            return this;
        }

        public Builder next_target_seg_id(Long r1) {
            this.next_target_seg_id = r1;
            return this;
        }

        public Builder subtitles(List<RecordingSubtitleData> r1) {
            Internal.checkElementsNotNull(r1);
            this.subtitles = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingPullSubtitlesResponse extends ProtoAdapter<MinutesRecordingPullSubtitlesResponse> implements c<MinutesRecordingPullSubtitlesResponse> {
        public ProtoAdapter_MinutesRecordingPullSubtitlesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingPullSubtitlesResponse.class);
        }

        public MinutesRecordingPullSubtitlesResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.next_target_seg_id = 0L;
            r0.has_more = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.subtitles.add((RecordingSubtitleData) RecordingSubtitleData.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.next_target_seg_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.has_more = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1856build();
        }

        public int encodedSize(MinutesRecordingPullSubtitlesResponse r6) {
            int r0 = RecordingSubtitleData.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.subtitles);
            Long r1 = r6.next_target_seg_id;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.INT64.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Boolean r5 = r6.has_more;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1857decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingPullSubtitlesResponse) r1);
        }

        public void encode(ProtoWriter r4, MinutesRecordingPullSubtitlesResponse r5) throws IOException {
            RecordingSubtitleData.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.subtitles);
            Long r0 = r5.next_target_seg_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r0);
        L5:
            Boolean r1 = r5.has_more;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingPullSubtitlesResponse) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingPullSubtitlesResponse r0 = new ProtoAdapter_MinutesRecordingPullSubtitlesResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_NEXT_TARGET_SEG_ID = 0L;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1855newBuilder() {
        Builder r0 = new Builder();
        r0.subtitles = Internal.copyOf("subtitles", this.subtitles);
        r0.next_target_seg_id = this.next_target_seg_id;
        r0.has_more = this.has_more;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingPullSubtitlesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1855newBuilder();
    }

    public MinutesRecordingPullSubtitlesResponse(List<RecordingSubtitleData> r2, Long r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MinutesRecordingPullSubtitlesResponse(List<RecordingSubtitleData> r2, Long r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.subtitles = Internal.immutableCopyOf("subtitles", r2);
        this.next_target_seg_id = r3;
        this.has_more = r4;
    }
}
