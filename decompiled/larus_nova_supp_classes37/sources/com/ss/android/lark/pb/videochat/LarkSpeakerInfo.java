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
public final class LarkSpeakerInfo extends Message<LarkSpeakerInfo, Builder> {
    public static final ProtoAdapter<LarkSpeakerInfo> ADAPTER = null;
    public static final String DEFAULT_DEPARTMENT = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final Image mavatar;
    public final String mdepartment;
    public final String mid;
    public final String mname;

    public static final class Builder extends Message.Builder<LarkSpeakerInfo, Builder> {
        public Image mavatar;
        public String mdepartment;
        public String mid;
        public String mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public LarkSpeakerInfo m3149build() {
            String r0 = this.mid;
            if (r0 == null) goto L13;
            if (this.mname == null) goto L13;
            if (this.mdepartment == null) goto L13;
            if (this.mavatar == null) goto L13;
            return new LarkSpeakerInfo(this.mid, this.mname, this.mdepartment, this.mavatar, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mname, "mname", this.mdepartment, "mdepartment", this.mavatar, "mavatar"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3149build();
        }

        public Builder avatar(Image r1) {
            this.mavatar = r1;
            return this;
        }

        public Builder department(String r1) {
            this.mdepartment = r1;
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

    public static final class ProtoAdapter_LarkSpeakerInfo extends ProtoAdapter<LarkSpeakerInfo> {
        public ProtoAdapter_LarkSpeakerInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkSpeakerInfo.class);
        }

        public LarkSpeakerInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.mdepartment = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mdepartment = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mavatar = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m3149build();
        }

        public int encodedSize(LarkSpeakerInfo r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (((r0.encodedSizeWithTag(1, r5.mid) + r0.encodedSizeWithTag(2, r5.mname)) + r0.encodedSizeWithTag(3, r5.mdepartment)) + Image.ADAPTER.encodedSizeWithTag(4, r5.mavatar)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3150decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((LarkSpeakerInfo) r1);
        }

        public void encode(ProtoWriter r4, LarkSpeakerInfo r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            r0.encodeWithTag(r4, 2, r5.mname);
            r0.encodeWithTag(r4, 3, r5.mdepartment);
            Image.ADAPTER.encodeWithTag(r4, 4, r5.mavatar);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (LarkSpeakerInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkSpeakerInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3148newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mdepartment = this.mdepartment;
        r0.mavatar = this.mavatar;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return LarkSpeakerInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3148newBuilder();
    }

    public LarkSpeakerInfo(String r7, String r8, String r9, Image r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public LarkSpeakerInfo(String r2, String r3, String r4, Image r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mid = r2;
        this.mname = r3;
        this.mdepartment = r4;
        this.mavatar = r5;
    }
}
