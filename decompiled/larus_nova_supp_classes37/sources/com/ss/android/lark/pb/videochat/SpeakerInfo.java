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
public final class SpeakerInfo extends Message<SpeakerInfo, Builder> {
    public static final ProtoAdapter<SpeakerInfo> ADAPTER = null;
    public static final String DEFAULT_AVATAR = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mavatar;
    public final String mid;
    public final String mname;

    public static final class Builder extends Message.Builder<SpeakerInfo, Builder> {
        public String mavatar;
        public String mid;
        public String mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SpeakerInfo m3191build() {
            String r0 = this.mid;
            if (r0 == null) goto L11;
            if (this.mname == null) goto L11;
            if (this.mavatar == null) goto L11;
            return new SpeakerInfo(this.mid, this.mname, this.mavatar, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mname, "mname", this.mavatar, "mavatar"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3191build();
        }

        public Builder avatar(String r1) {
            this.mavatar = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SpeakerInfo extends ProtoAdapter<SpeakerInfo> {
        public ProtoAdapter_SpeakerInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeakerInfo.class);
        }

        public SpeakerInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.mavatar = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mavatar = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m3191build();
        }

        public int encodedSize(SpeakerInfo r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return ((r0.encodedSizeWithTag(1, r5.mid) + r0.encodedSizeWithTag(2, r5.mname)) + r0.encodedSizeWithTag(3, r5.mavatar)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3192decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SpeakerInfo) r1);
        }

        public void encode(ProtoWriter r4, SpeakerInfo r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            r0.encodeWithTag(r4, 2, r5.mname);
            r0.encodeWithTag(r4, 3, r5.mavatar);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SpeakerInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeakerInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3190newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mavatar = this.mavatar;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SpeakerInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3190newBuilder();
    }

    public SpeakerInfo(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SpeakerInfo(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mid = r2;
        this.mname = r3;
        this.mavatar = r4;
    }
}
