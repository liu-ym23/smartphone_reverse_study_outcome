package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FishboneEvalInfo extends Message<FishboneEvalInfo, Builder> {
    public static final ProtoAdapter<FishboneEvalInfo> ADAPTER = null;
    public static final Integer DEFAULT_SUBTITLE_TOKENS = null;
    private static final long serialVersionUID = 0;
    public final AILayoutFishBone mfish_bone;
    public final Integer msubtitle_tokens;

    public static final class Builder extends Message.Builder<FishboneEvalInfo, Builder> {
        public AILayoutFishBone mfish_bone;
        public Integer msubtitle_tokens;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FishboneEvalInfo m3281build() {
            return new FishboneEvalInfo(this.msubtitle_tokens, this.mfish_bone, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3281build();
        }

        public Builder fish_bone(AILayoutFishBone r1) {
            this.mfish_bone = r1;
            return this;
        }

        public Builder subtitle_tokens(Integer r1) {
            this.msubtitle_tokens = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FishboneEvalInfo extends ProtoAdapter<FishboneEvalInfo> {
        public ProtoAdapter_FishboneEvalInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FishboneEvalInfo.class);
        }

        public FishboneEvalInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msubtitle_tokens = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.msubtitle_tokens = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mfish_bone = (AILayoutFishBone) AILayoutFishBone.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3281build();
        }

        public int encodedSize(FishboneEvalInfo r5) {
            Integer r0 = r5.msubtitle_tokens;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            AILayoutFishBone r3 = r5.mfish_bone;
            if (r3 == null) goto L10;
            r1 = AILayoutFishBone.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3282decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FishboneEvalInfo) r1);
        }

        public void encode(ProtoWriter r4, FishboneEvalInfo r5) throws IOException {
            Integer r0 = r5.msubtitle_tokens;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            AILayoutFishBone r1 = r5.mfish_bone;
            if (r1 == null) goto L8;
            AILayoutFishBone.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FishboneEvalInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FishboneEvalInfo();
        DEFAULT_SUBTITLE_TOKENS = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3280newBuilder() {
        Builder r0 = new Builder();
        r0.msubtitle_tokens = this.msubtitle_tokens;
        r0.mfish_bone = this.mfish_bone;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FishboneEvalInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3280newBuilder();
    }

    public FishboneEvalInfo(Integer r2, AILayoutFishBone r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public FishboneEvalInfo(Integer r2, AILayoutFishBone r3, ByteString r4) {
        super(ADAPTER, r4);
        this.msubtitle_tokens = r2;
        this.mfish_bone = r3;
    }
}
