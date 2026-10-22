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
public final class NotifySpeakerInfoChange extends Message<NotifySpeakerInfoChange, Builder> {
    public static final ProtoAdapter<NotifySpeakerInfoChange> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Boolean DEFAULT_SPEAKER_INFO_CHANGE = null;
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final Boolean mspeaker_info_change;

    public static final class Builder extends Message.Builder<NotifySpeakerInfoChange, Builder> {
        public String mmeeting_id;
        public Boolean mspeaker_info_change;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public NotifySpeakerInfoChange m3167build() {
            String r0 = this.mmeeting_id;
            if (r0 == null) goto L9;
            if (this.mspeaker_info_change == null) goto L9;
            return new NotifySpeakerInfoChange(this.mmeeting_id, this.mspeaker_info_change, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mmeeting_id", this.mspeaker_info_change, "mspeaker_info_change"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3167build();
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder speaker_info_change(Boolean r1) {
            this.mspeaker_info_change = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_NotifySpeakerInfoChange extends ProtoAdapter<NotifySpeakerInfoChange> {
        public ProtoAdapter_NotifySpeakerInfoChange() {
            super(FieldEncoding.LENGTH_DELIMITED, NotifySpeakerInfoChange.class);
        }

        public NotifySpeakerInfoChange decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.mspeaker_info_change = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mspeaker_info_change = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3167build();
        }

        public int encodedSize(NotifySpeakerInfoChange r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mmeeting_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r5.mspeaker_info_change)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3168decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((NotifySpeakerInfoChange) r1);
        }

        public void encode(ProtoWriter r4, NotifySpeakerInfoChange r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mmeeting_id);
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r5.mspeaker_info_change);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (NotifySpeakerInfoChange) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NotifySpeakerInfoChange();
        DEFAULT_SPEAKER_INFO_CHANGE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3166newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.mspeaker_info_change = this.mspeaker_info_change;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return NotifySpeakerInfoChange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3166newBuilder();
    }

    public NotifySpeakerInfoChange(String r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public NotifySpeakerInfoChange(String r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mmeeting_id = r2;
        this.mspeaker_info_change = r3;
    }
}
