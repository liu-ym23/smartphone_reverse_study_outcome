package com.ss.android.lark.pb.videochat_my_ai;

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
public final class AILayoutFishBone extends Message<AILayoutFishBone, Builder> {
    public static final ProtoAdapter<AILayoutFishBone> ADAPTER = null;
    public static final Integer DEFAULT_FISH_BONE_VERSION = null;
    public static final Integer DEFAULT_SUMMARY_VERSION = null;
    public static final Integer DEFAULT_TOPIC_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<AILayoutFishBoneItem> mfish_bone_items;
    public final Integer mfish_bone_version;
    public final Integer msummary_version;
    public final List<AILayoutTopicItem> mtopic_items;
    public final Integer mtopic_version;

    public static final class Builder extends Message.Builder<AILayoutFishBone, Builder> {
        public List<AILayoutFishBoneItem> mfish_bone_items;
        public Integer mfish_bone_version;
        public Integer msummary_version;
        public List<AILayoutTopicItem> mtopic_items;
        public Integer mtopic_version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AILayoutFishBone m3215build() {
            return new AILayoutFishBone(this.mfish_bone_items, this.mtopic_items, this.mfish_bone_version, this.msummary_version, this.mtopic_version, super.buildUnknownFields());
        }

        public Builder() {
            this.mfish_bone_items = Internal.newMutableList();
            this.mtopic_items = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3215build();
        }

        public Builder fish_bone_items(List<AILayoutFishBoneItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfish_bone_items = r1;
            return this;
        }

        public Builder fish_bone_version(Integer r1) {
            this.mfish_bone_version = r1;
            return this;
        }

        public Builder summary_version(Integer r1) {
            this.msummary_version = r1;
            return this;
        }

        public Builder topic_items(List<AILayoutTopicItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtopic_items = r1;
            return this;
        }

        public Builder topic_version(Integer r1) {
            this.mtopic_version = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AILayoutFishBone extends ProtoAdapter<AILayoutFishBone> {
        public ProtoAdapter_AILayoutFishBone() {
            super(FieldEncoding.LENGTH_DELIMITED, AILayoutFishBone.class);
        }

        public AILayoutFishBone decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mfish_bone_version = 0;
            r0.msummary_version = 0;
            r0.mtopic_version = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mfish_bone_items.add((AILayoutFishBoneItem) AILayoutFishBoneItem.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtopic_items.add((AILayoutTopicItem) AILayoutTopicItem.ADAPTER.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mfish_bone_version = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.msummary_version = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mtopic_version = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m3215build();
        }

        public int encodedSize(AILayoutFishBone r6) {
            int r0 = AILayoutFishBoneItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mfish_bone_items) + AILayoutTopicItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mtopic_items);
            Integer r1 = r6.mfish_bone_version;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.INT32.encodedSizeWithTag(3, r1);
        L6:
            int r4 = r0 + r3;
            Integer r5 = r6.msummary_version;
            if (r5 == null) goto L9;
            int r7 = ProtoAdapter.INT32.encodedSizeWithTag(4, r5);
        L10:
            int r8 = r4 + r7;
            Integer r9 = r6.mtopic_version;
            if (r9 == null) goto L14;
            r2 = ProtoAdapter.INT32.encodedSizeWithTag(5, r9);
        L14:
            return (r8 + r2) + r6.unknownFields().size();
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3216decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AILayoutFishBone) r1);
        }

        public void encode(ProtoWriter r4, AILayoutFishBone r5) throws IOException {
            AILayoutFishBoneItem.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mfish_bone_items);
            AILayoutTopicItem.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mtopic_items);
            Integer r0 = r5.mfish_bone_version;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r0);
        L5:
            Integer r1 = r5.msummary_version;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r1);
        L8:
            Integer r2 = r5.mtopic_version;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AILayoutFishBone) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AILayoutFishBone();
        DEFAULT_FISH_BONE_VERSION = 0;
        DEFAULT_SUMMARY_VERSION = 0;
        DEFAULT_TOPIC_VERSION = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3214newBuilder() {
        Builder r0 = new Builder();
        r0.mfish_bone_items = Internal.copyOf("mfish_bone_items", this.mfish_bone_items);
        r0.mtopic_items = Internal.copyOf("mtopic_items", this.mtopic_items);
        r0.mfish_bone_version = this.mfish_bone_version;
        r0.msummary_version = this.msummary_version;
        r0.mtopic_version = this.mtopic_version;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AILayoutFishBone.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3214newBuilder();
    }

    public AILayoutFishBone(List<AILayoutFishBoneItem> r8, List<AILayoutTopicItem> r9, Integer r10, Integer r11, Integer r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public AILayoutFishBone(List<AILayoutFishBoneItem> r2, List<AILayoutTopicItem> r3, Integer r4, Integer r5, Integer r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mfish_bone_items = Internal.immutableCopyOf("mfish_bone_items", r2);
        this.mtopic_items = Internal.immutableCopyOf("mtopic_items", r3);
        this.mfish_bone_version = r4;
        this.msummary_version = r5;
        this.mtopic_version = r6;
    }
}
