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
public final class CustomSummaryItem extends Message<CustomSummaryItem, Builder> {
    public static final ProtoAdapter<CustomSummaryItem> ADAPTER = null;
    public static final Boolean DEFAULT_IS_FINAL = null;
    private static final long serialVersionUID = 0;
    public final CustomSubType mcustom_sub_type;
    public final List<CustomSummaryGoldenSentences> mgolden_sentences;
    public final Boolean mis_final;
    public final CustomSummaryKeypoint mkey_point;
    public final List<CustomSummaryMyTodo> mmy_todo;
    public final CustomSummarySelfPerformance mself_performance;
    public final List<CustomSummarySpeakerSummary> mspeaker_summary;

    public static final class Builder extends Message.Builder<CustomSummaryItem, Builder> {
        public CustomSubType mcustom_sub_type;
        public List<CustomSummaryGoldenSentences> mgolden_sentences;
        public Boolean mis_final;
        public CustomSummaryKeypoint mkey_point;
        public List<CustomSummaryMyTodo> mmy_todo;
        public CustomSummarySelfPerformance mself_performance;
        public List<CustomSummarySpeakerSummary> mspeaker_summary;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummaryItem m3251build() {
            return new CustomSummaryItem(this.mcustom_sub_type, this.mmy_todo, this.mkey_point, this.mspeaker_summary, this.mgolden_sentences, this.mis_final, this.mself_performance, super.buildUnknownFields());
        }

        public Builder() {
            this.mmy_todo = Internal.newMutableList();
            this.mspeaker_summary = Internal.newMutableList();
            this.mgolden_sentences = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3251build();
        }

        public Builder custom_sub_type(CustomSubType r1) {
            this.mcustom_sub_type = r1;
            return this;
        }

        public Builder golden_sentences(List<CustomSummaryGoldenSentences> r1) {
            Internal.checkElementsNotNull(r1);
            this.mgolden_sentences = r1;
            return this;
        }

        public Builder is_final(Boolean r1) {
            this.mis_final = r1;
            return this;
        }

        public Builder key_point(CustomSummaryKeypoint r1) {
            this.mkey_point = r1;
            return this;
        }

        public Builder my_todo(List<CustomSummaryMyTodo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmy_todo = r1;
            return this;
        }

        public Builder self_performance(CustomSummarySelfPerformance r1) {
            this.mself_performance = r1;
            return this;
        }

        public Builder speaker_summary(List<CustomSummarySpeakerSummary> r1) {
            Internal.checkElementsNotNull(r1);
            this.mspeaker_summary = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryItem extends ProtoAdapter<CustomSummaryItem> {
        public ProtoAdapter_CustomSummaryItem() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryItem.class);
        }

        public CustomSummaryItem decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_final = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.mcustom_sub_type = (CustomSubType) CustomSubType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mself_performance = (CustomSummarySelfPerformance) CustomSummarySelfPerformance.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mis_final = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            r0.mgolden_sentences.add((CustomSummaryGoldenSentences) CustomSummaryGoldenSentences.ADAPTER.decode(r9));
            goto L3
        L10:
            r0.mspeaker_summary.add((CustomSummarySpeakerSummary) CustomSummarySpeakerSummary.ADAPTER.decode(r9));
            goto L3
        L11:
            r0.mkey_point = (CustomSummaryKeypoint) CustomSummaryKeypoint.ADAPTER.decode(r9);
            goto L3
        L12:
            r0.mmy_todo.add((CustomSummaryMyTodo) CustomSummaryMyTodo.ADAPTER.decode(r9));
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r1);
            return r0.m3251build();
        }

        public int encodedSize(CustomSummaryItem r6) {
            CustomSubType r0 = r6.mcustom_sub_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = CustomSubType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + CustomSummaryMyTodo.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mmy_todo);
            CustomSummaryKeypoint r4 = r6.mkey_point;
            if (r4 == null) goto L9;
            int r5 = CustomSummaryKeypoint.ADAPTER.encodedSizeWithTag(3, r4);
        L10:
            int r7 = ((r3 + r5) + CustomSummarySpeakerSummary.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mspeaker_summary)) + CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.mgolden_sentences);
            Boolean r8 = r6.mis_final;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r8);
        L14:
            int r10 = r7 + r9;
            CustomSummarySelfPerformance r11 = r6.mself_performance;
            if (r11 == null) goto L18;
            r1 = CustomSummarySelfPerformance.ADAPTER.encodedSizeWithTag(7, r11);
        L18:
            return (r10 + r1) + r6.unknownFields().size();
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3252decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummaryItem) r1);
        }

        public void encode(ProtoWriter r4, CustomSummaryItem r5) throws IOException {
            CustomSubType r0 = r5.mcustom_sub_type;
            if (r0 == null) goto L5;
            CustomSubType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            CustomSummaryMyTodo.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mmy_todo);
            CustomSummaryKeypoint r1 = r5.mkey_point;
            if (r1 == null) goto L8;
            CustomSummaryKeypoint.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            CustomSummarySpeakerSummary.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mspeaker_summary);
            CustomSummaryGoldenSentences.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.mgolden_sentences);
            Boolean r2 = r5.mis_final;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r2);
        L11:
            CustomSummarySelfPerformance r3 = r5.mself_performance;
            if (r3 == null) goto L14;
            CustomSummarySelfPerformance.ADAPTER.encodeWithTag(r4, 7, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummaryItem) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryItem();
        DEFAULT_IS_FINAL = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3250newBuilder() {
        Builder r0 = new Builder();
        r0.mcustom_sub_type = this.mcustom_sub_type;
        r0.mmy_todo = Internal.copyOf("mmy_todo", this.mmy_todo);
        r0.mkey_point = this.mkey_point;
        r0.mspeaker_summary = Internal.copyOf("mspeaker_summary", this.mspeaker_summary);
        r0.mgolden_sentences = Internal.copyOf("mgolden_sentences", this.mgolden_sentences);
        r0.mis_final = this.mis_final;
        r0.mself_performance = this.mself_performance;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummaryItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3250newBuilder();
    }

    public CustomSummaryItem(CustomSubType r10, List<CustomSummaryMyTodo> r11, CustomSummaryKeypoint r12, List<CustomSummarySpeakerSummary> r13, List<CustomSummaryGoldenSentences> r14, Boolean r15, CustomSummarySelfPerformance r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public CustomSummaryItem(CustomSubType r2, List<CustomSummaryMyTodo> r3, CustomSummaryKeypoint r4, List<CustomSummarySpeakerSummary> r5, List<CustomSummaryGoldenSentences> r6, Boolean r7, CustomSummarySelfPerformance r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mcustom_sub_type = r2;
        this.mmy_todo = Internal.immutableCopyOf("mmy_todo", r3);
        this.mkey_point = r4;
        this.mspeaker_summary = Internal.immutableCopyOf("mspeaker_summary", r5);
        this.mgolden_sentences = Internal.immutableCopyOf("mgolden_sentences", r6);
        this.mis_final = r7;
        this.mself_performance = r8;
    }
}
