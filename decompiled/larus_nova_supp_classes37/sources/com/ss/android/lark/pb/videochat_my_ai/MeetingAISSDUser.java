package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MeetingAISSDUser extends Message<MeetingAISSDUser, Builder> {
    public static final ProtoAdapter<MeetingAISSDUser> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteviewUser morigin_user;
    public final MeetingAISSDInfo mssd_info;

    public static final class Builder extends Message.Builder<MeetingAISSDUser, Builder> {
        public ByteviewUser morigin_user;
        public MeetingAISSDInfo mssd_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MeetingAISSDUser m3293build() {
            return new MeetingAISSDUser(this.morigin_user, this.mssd_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3293build();
        }

        public Builder origin_user(ByteviewUser r1) {
            this.morigin_user = r1;
            return this;
        }

        public Builder ssd_info(MeetingAISSDInfo r1) {
            this.mssd_info = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAISSDUser extends ProtoAdapter<MeetingAISSDUser> {
        public ProtoAdapter_MeetingAISSDUser() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAISSDUser.class);
        }

        public MeetingAISSDUser decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.morigin_user = (ByteviewUser) ByteviewUser.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mssd_info = (MeetingAISSDInfo) MeetingAISSDInfo.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3293build();
        }

        public int encodedSize(MeetingAISSDUser r5) {
            ByteviewUser r0 = r5.morigin_user;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ByteviewUser.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            MeetingAISSDInfo r3 = r5.mssd_info;
            if (r3 == null) goto L10;
            r1 = MeetingAISSDInfo.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3294decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MeetingAISSDUser) r1);
        }

        public void encode(ProtoWriter r4, MeetingAISSDUser r5) throws IOException {
            ByteviewUser r0 = r5.morigin_user;
            if (r0 == null) goto L5;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            MeetingAISSDInfo r1 = r5.mssd_info;
            if (r1 == null) goto L8;
            MeetingAISSDInfo.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MeetingAISSDUser) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAISSDUser();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3292newBuilder() {
        Builder r0 = new Builder();
        r0.morigin_user = this.morigin_user;
        r0.mssd_info = this.mssd_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MeetingAISSDUser.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3292newBuilder();
    }

    public MeetingAISSDUser(ByteviewUser r2, MeetingAISSDInfo r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public MeetingAISSDUser(ByteviewUser r2, MeetingAISSDInfo r3, ByteString r4) {
        super(ADAPTER, r4);
        this.morigin_user = r2;
        this.mssd_info = r3;
    }
}
