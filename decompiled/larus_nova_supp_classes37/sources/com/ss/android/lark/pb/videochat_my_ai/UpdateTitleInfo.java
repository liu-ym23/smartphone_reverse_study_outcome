package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateTitleInfo extends Message<UpdateTitleInfo, Builder> {
    public static final ProtoAdapter<UpdateTitleInfo> ADAPTER = null;
    public static final String DEFAULT_MANUAL_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String mmanual_title;

    public static final class Builder extends Message.Builder<UpdateTitleInfo, Builder> {
        public String mmanual_title;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateTitleInfo m3311build() {
            return new UpdateTitleInfo(this.mmanual_title, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3311build();
        }

        public Builder manual_title(String r1) {
            this.mmanual_title = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTitleInfo extends ProtoAdapter<UpdateTitleInfo> {
        public ProtoAdapter_UpdateTitleInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTitleInfo.class);
        }

        public UpdateTitleInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mmanual_title = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmanual_title = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m3311build();
        }

        public int encodedSize(UpdateTitleInfo r4) {
            String r0 = r4.mmanual_title;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3312decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateTitleInfo) r1);
        }

        public void encode(ProtoWriter r4, UpdateTitleInfo r5) throws IOException {
            String r0 = r5.mmanual_title;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateTitleInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateTitleInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3310newBuilder() {
        Builder r0 = new Builder();
        r0.mmanual_title = this.mmanual_title;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateTitleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3310newBuilder();
    }

    public UpdateTitleInfo(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public UpdateTitleInfo(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmanual_title = r2;
    }
}
