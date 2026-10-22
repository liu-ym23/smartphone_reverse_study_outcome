package com.ss.android.lark.pb.guide;

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
public final class UserGuideViewAreaPair extends Message<UserGuideViewAreaPair, Builder> {
    public static final ProtoAdapter<UserGuideViewAreaPair> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Area marea;
    public final List<UserGuideInfo> minfos;

    public static final class Builder extends Message.Builder<UserGuideViewAreaPair, Builder> {
        public Area marea;
        public List<UserGuideInfo> minfos;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserGuideViewAreaPair m1739build() {
            return new UserGuideViewAreaPair(this.marea, this.minfos, super.buildUnknownFields());
        }

        public Builder() {
            this.minfos = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1739build();
        }

        public Builder area(Area r1) {
            this.marea = r1;
            return this;
        }

        public Builder infos(List<UserGuideInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.minfos = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserGuideViewAreaPair extends ProtoAdapter<UserGuideViewAreaPair> {
        public ProtoAdapter_UserGuideViewAreaPair() {
            super(FieldEncoding.LENGTH_DELIMITED, UserGuideViewAreaPair.class);
        }

        public UserGuideViewAreaPair decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.marea = (Area) Area.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.minfos.add((UserGuideInfo) UserGuideInfo.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1739build();
        }

        public int encodedSize(UserGuideViewAreaPair r5) {
            Area r0 = r5.marea;
            if (r0 == null) goto L5;
            int r1 = Area.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + UserGuideInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.minfos)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1740decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserGuideViewAreaPair) r1);
        }

        public void encode(ProtoWriter r4, UserGuideViewAreaPair r5) throws IOException {
            Area r0 = r5.marea;
            if (r0 == null) goto L5;
            Area.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            UserGuideInfo.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.minfos);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserGuideViewAreaPair) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserGuideViewAreaPair();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1738newBuilder() {
        Builder r0 = new Builder();
        r0.marea = this.marea;
        r0.minfos = Internal.copyOf("minfos", this.minfos);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserGuideViewAreaPair.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1738newBuilder();
    }

    public UserGuideViewAreaPair(Area r2, List<UserGuideInfo> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public UserGuideViewAreaPair(Area r2, List<UserGuideInfo> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.marea = r2;
        this.minfos = Internal.immutableCopyOf("minfos", r3);
    }
}
