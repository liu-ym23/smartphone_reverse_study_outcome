package com.ss.android.lark.pb.usearch;

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
public final class AggregatedMessageMeta extends Message<AggregatedMessageMeta, Builder> {
    public static final ProtoAdapter<AggregatedMessageMeta> ADAPTER = null;
    public static final Integer DEFAULT_ALL_NUMBER = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_FOLD = null;
    public static final Boolean DEFAULT_IS_P2P_CHAT = null;
    private static final long serialVersionUID = 0;
    public final Integer mall_number;
    public final String mchatter_id;
    public final String mid;
    public final Boolean mis_fold;
    public final Boolean mis_p2p_chat;
    public final List<SearchResult> mmessages;

    public static final class Builder extends Message.Builder<AggregatedMessageMeta, Builder> {
        public Integer mall_number;
        public String mchatter_id;
        public String mid;
        public Boolean mis_fold;
        public Boolean mis_p2p_chat;
        public List<SearchResult> mmessages;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AggregatedMessageMeta m2504build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new AggregatedMessageMeta(this.mid, this.mall_number, this.mmessages, this.mchatter_id, this.mis_p2p_chat, this.mis_fold, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
            this.mmessages = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2504build();
        }

        public Builder all_number(Integer r1) {
            this.mall_number = r1;
            return this;
        }

        public Builder chatter_id(String r1) {
            this.mchatter_id = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_fold(Boolean r1) {
            this.mis_fold = r1;
            return this;
        }

        public Builder is_p2p_chat(Boolean r1) {
            this.mis_p2p_chat = r1;
            return this;
        }

        public Builder messages(List<SearchResult> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmessages = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AggregatedMessageMeta extends ProtoAdapter<AggregatedMessageMeta> {
        public ProtoAdapter_AggregatedMessageMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, AggregatedMessageMeta.class);
        }

        public AggregatedMessageMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mall_number = 0;
            r0.mchatter_id = "";
            Boolean r1 = Boolean.FALSE;
            r0.mis_p2p_chat = r1;
            r0.mis_fold = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.mis_fold = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mis_p2p_chat = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            r0.mchatter_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mmessages.add((SearchResult) SearchResult.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.mall_number = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L12:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r2);
            return r0.m2504build();
        }

        public int encodedSize(AggregatedMessageMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            Integer r2 = r7.mall_number;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r2);
        L6:
            int r5 = (r1 + r4) + SearchResult.ADAPTER.asRepeated().encodedSizeWithTag(3, r7.mmessages);
            String r6 = r7.mchatter_id;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(4, r6);
        L10:
            int r9 = r5 + r8;
            Boolean r10 = r7.mis_p2p_chat;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r10);
        L14:
            int r12 = r9 + r11;
            Boolean r13 = r7.mis_fold;
            if (r13 == null) goto L18;
            r3 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r13);
        L18:
            return (r12 + r3) + r7.unknownFields().size();
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2505decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AggregatedMessageMeta) r1);
        }

        public void encode(ProtoWriter r5, AggregatedMessageMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            Integer r1 = r6.mall_number;
            if (r1 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r1);
        L5:
            SearchResult.ADAPTER.asRepeated().encodeWithTag(r5, 3, r6.mmessages);
            String r2 = r6.mchatter_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 4, r2);
        L8:
            Boolean r3 = r6.mis_p2p_chat;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 5, r3);
        L11:
            Boolean r4 = r6.mis_fold;
            if (r4 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r5, 6, r4);
        L14:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AggregatedMessageMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AggregatedMessageMeta();
        DEFAULT_ALL_NUMBER = 0;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_P2P_CHAT = r0;
        DEFAULT_IS_FOLD = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2503newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mall_number = this.mall_number;
        r0.mmessages = Internal.copyOf("mmessages", this.mmessages);
        r0.mchatter_id = this.mchatter_id;
        r0.mis_p2p_chat = this.mis_p2p_chat;
        r0.mis_fold = this.mis_fold;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AggregatedMessageMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2503newBuilder();
    }

    public AggregatedMessageMeta(String r9, Integer r10, List<SearchResult> r11, String r12, Boolean r13, Boolean r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public AggregatedMessageMeta(String r2, Integer r3, List<SearchResult> r4, String r5, Boolean r6, Boolean r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mid = r2;
        this.mall_number = r3;
        this.mmessages = Internal.immutableCopyOf("mmessages", r4);
        this.mchatter_id = r5;
        this.mis_p2p_chat = r6;
        this.mis_fold = r7;
    }
}
