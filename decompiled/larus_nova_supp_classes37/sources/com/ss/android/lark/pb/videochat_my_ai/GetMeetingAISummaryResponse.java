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
public final class GetMeetingAISummaryResponse extends Message<GetMeetingAISummaryResponse, Builder> {
    public static final ProtoAdapter<GetMeetingAISummaryResponse> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_DIGEST = "";
    public static final Long DEFAULT_TIMESTAMP = null;
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final CustomSummaryInfo mcustom_summary;
    public final String mdigest;
    public final EmptyStateInfo mempty_state_info;
    public final AIViewExportData mexport_data;
    public final AILayoutFishBone mfish_bone;
    public final List<FishboneEvalInfo> mfishbone_eval_infos;
    public final FeatureStatus mnote_switch;
    public final List<NotesBlock> mnotes;
    public final NotesBlock mnotes_block;
    public final List<MeetingAISubtitle> msubtitles;
    public final Long mtimestamp;
    public final AILayoutTopic mtopic;

    public static final class Builder extends Message.Builder<GetMeetingAISummaryResponse, Builder> {
        public String mcontent;
        public CustomSummaryInfo mcustom_summary;
        public String mdigest;
        public EmptyStateInfo mempty_state_info;
        public AIViewExportData mexport_data;
        public AILayoutFishBone mfish_bone;
        public List<FishboneEvalInfo> mfishbone_eval_infos;
        public FeatureStatus mnote_switch;
        public List<NotesBlock> mnotes;
        public NotesBlock mnotes_block;
        public List<MeetingAISubtitle> msubtitles;
        public Long mtimestamp;
        public AILayoutTopic mtopic;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetMeetingAISummaryResponse m3287build() {
            return new GetMeetingAISummaryResponse(this.mcontent, this.mtimestamp, this.mdigest, this.mfish_bone, this.mtopic, this.msubtitles, this.mcustom_summary, this.mfishbone_eval_infos, this.mempty_state_info, this.mnotes_block, this.mnotes, this.mnote_switch, this.mexport_data, super.buildUnknownFields());
        }

        public Builder() {
            this.msubtitles = Internal.newMutableList();
            this.mfishbone_eval_infos = Internal.newMutableList();
            this.mnotes = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3287build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder custom_summary(CustomSummaryInfo r1) {
            this.mcustom_summary = r1;
            return this;
        }

        public Builder digest(String r1) {
            this.mdigest = r1;
            return this;
        }

        public Builder empty_state_info(EmptyStateInfo r1) {
            this.mempty_state_info = r1;
            return this;
        }

        public Builder export_data(AIViewExportData r1) {
            this.mexport_data = r1;
            return this;
        }

        public Builder fish_bone(AILayoutFishBone r1) {
            this.mfish_bone = r1;
            return this;
        }

        public Builder fishbone_eval_infos(List<FishboneEvalInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfishbone_eval_infos = r1;
            return this;
        }

        public Builder note_switch(FeatureStatus r1) {
            this.mnote_switch = r1;
            return this;
        }

        public Builder notes(List<NotesBlock> r1) {
            Internal.checkElementsNotNull(r1);
            this.mnotes = r1;
            return this;
        }

        public Builder notes_block(NotesBlock r1) {
            this.mnotes_block = r1;
            return this;
        }

        public Builder subtitles(List<MeetingAISubtitle> r1) {
            Internal.checkElementsNotNull(r1);
            this.msubtitles = r1;
            return this;
        }

        public Builder timestamp(Long r1) {
            this.mtimestamp = r1;
            return this;
        }

        public Builder topic(AILayoutTopic r1) {
            this.mtopic = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMeetingAISummaryResponse extends ProtoAdapter<GetMeetingAISummaryResponse> {
        public ProtoAdapter_GetMeetingAISummaryResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMeetingAISummaryResponse.class);
        }

        public GetMeetingAISummaryResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            r0.mtimestamp = 0L;
            r0.mdigest = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L23;
            switch(r3) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L6;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L25;
                case 14: goto L7;
                default: goto L6;
            };
        L25:
            r0.mnote_switch = (FeatureStatus) FeatureStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mexport_data = (AIViewExportData) AIViewExportData.ADAPTER.decode(r9);
            goto L3
        L12:
            r0.mnotes.add((NotesBlock) NotesBlock.ADAPTER.decode(r9));
            goto L3
        L13:
            r0.mnotes_block = (NotesBlock) NotesBlock.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mempty_state_info = (EmptyStateInfo) EmptyStateInfo.ADAPTER.decode(r9);
            goto L3
        L15:
            r0.mfishbone_eval_infos.add((FishboneEvalInfo) FishboneEvalInfo.ADAPTER.decode(r9));
            goto L3
        L16:
            r0.mcustom_summary = (CustomSummaryInfo) CustomSummaryInfo.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.msubtitles.add((MeetingAISubtitle) MeetingAISubtitle.ADAPTER.decode(r9));
            goto L3
        L18:
            r0.mtopic = (AILayoutTopic) AILayoutTopic.ADAPTER.decode(r9);
            goto L3
        L19:
            r0.mfish_bone = (AILayoutFishBone) AILayoutFishBone.ADAPTER.decode(r9);
            goto L3
        L20:
            r0.mdigest = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.mtimestamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L22:
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L23:
            r9.endMessage(r1);
            return r0.m3287build();
        }

        public int encodedSize(GetMeetingAISummaryResponse r6) {
            String r0 = r6.mcontent;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mtimestamp;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mdigest;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            AILayoutFishBone r10 = r6.mfish_bone;
            if (r10 == null) goto L17;
            int r11 = AILayoutFishBone.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            AILayoutTopic r13 = r6.mtopic;
            if (r13 == null) goto L21;
            int r14 = AILayoutTopic.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = (r12 + r14) + MeetingAISubtitle.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.msubtitles);
            CustomSummaryInfo r16 = r6.mcustom_summary;
            if (r16 == null) goto L25;
            int r17 = CustomSummaryInfo.ADAPTER.encodedSizeWithTag(8, r16);
        L26:
            int r18 = (r15 + r17) + FishboneEvalInfo.ADAPTER.asRepeated().encodedSizeWithTag(9, r6.mfishbone_eval_infos);
            EmptyStateInfo r19 = r6.mempty_state_info;
            if (r19 == null) goto L29;
            int r20 = EmptyStateInfo.ADAPTER.encodedSizeWithTag(10, r19);
        L30:
            int r21 = r18 + r20;
            NotesBlock r22 = r6.mnotes_block;
            if (r22 == null) goto L33;
            int r23 = NotesBlock.ADAPTER.encodedSizeWithTag(11, r22);
        L34:
            int r24 = (r21 + r23) + NotesBlock.ADAPTER.asRepeated().encodedSizeWithTag(12, r6.mnotes);
            FeatureStatus r25 = r6.mnote_switch;
            if (r25 == null) goto L37;
            int r26 = FeatureStatus.ADAPTER.encodedSizeWithTag(13, r25);
        L38:
            int r27 = r24 + r26;
            AIViewExportData r28 = r6.mexport_data;
            if (r28 == null) goto L42;
            r1 = AIViewExportData.ADAPTER.encodedSizeWithTag(14, r28);
        L42:
            return (r27 + r1) + r6.unknownFields().size();
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3288decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetMeetingAISummaryResponse) r1);
        }

        public void encode(ProtoWriter r4, GetMeetingAISummaryResponse r5) throws IOException {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mtimestamp;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mdigest;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            AILayoutFishBone r3 = r5.mfish_bone;
            if (r3 == null) goto L14;
            AILayoutFishBone.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            AILayoutTopic r6 = r5.mtopic;
            if (r6 == null) goto L17;
            AILayoutTopic.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            MeetingAISubtitle.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.msubtitles);
            CustomSummaryInfo r7 = r5.mcustom_summary;
            if (r7 == null) goto L20;
            CustomSummaryInfo.ADAPTER.encodeWithTag(r4, 8, r7);
        L20:
            FishboneEvalInfo.ADAPTER.asRepeated().encodeWithTag(r4, 9, r5.mfishbone_eval_infos);
            EmptyStateInfo r8 = r5.mempty_state_info;
            if (r8 == null) goto L23;
            EmptyStateInfo.ADAPTER.encodeWithTag(r4, 10, r8);
        L23:
            NotesBlock r9 = r5.mnotes_block;
            if (r9 == null) goto L26;
            NotesBlock.ADAPTER.encodeWithTag(r4, 11, r9);
        L26:
            NotesBlock.ADAPTER.asRepeated().encodeWithTag(r4, 12, r5.mnotes);
            FeatureStatus r10 = r5.mnote_switch;
            if (r10 == null) goto L29;
            FeatureStatus.ADAPTER.encodeWithTag(r4, 13, r10);
        L29:
            AIViewExportData r11 = r5.mexport_data;
            if (r11 == null) goto L32;
            AIViewExportData.ADAPTER.encodeWithTag(r4, 14, r11);
        L32:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetMeetingAISummaryResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetMeetingAISummaryResponse();
        DEFAULT_TIMESTAMP = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3286newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.mtimestamp = this.mtimestamp;
        r0.mdigest = this.mdigest;
        r0.mfish_bone = this.mfish_bone;
        r0.mtopic = this.mtopic;
        r0.msubtitles = Internal.copyOf("msubtitles", this.msubtitles);
        r0.mcustom_summary = this.mcustom_summary;
        r0.mfishbone_eval_infos = Internal.copyOf("mfishbone_eval_infos", this.mfishbone_eval_infos);
        r0.mempty_state_info = this.mempty_state_info;
        r0.mnotes_block = this.mnotes_block;
        r0.mnotes = Internal.copyOf("mnotes", this.mnotes);
        r0.mnote_switch = this.mnote_switch;
        r0.mexport_data = this.mexport_data;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetMeetingAISummaryResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3286newBuilder();
    }

    public GetMeetingAISummaryResponse(String r16, Long r17, String r18, AILayoutFishBone r19, AILayoutTopic r20, List<MeetingAISubtitle> r21, CustomSummaryInfo r22, List<FishboneEvalInfo> r23, EmptyStateInfo r24, NotesBlock r25, List<NotesBlock> r26, FeatureStatus r27, AIViewExportData r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public GetMeetingAISummaryResponse(String r2, Long r3, String r4, AILayoutFishBone r5, AILayoutTopic r6, List<MeetingAISubtitle> r7, CustomSummaryInfo r8, List<FishboneEvalInfo> r9, EmptyStateInfo r10, NotesBlock r11, List<NotesBlock> r12, FeatureStatus r13, AIViewExportData r14, ByteString r15) {
        super(ADAPTER, r15);
        this.mcontent = r2;
        this.mtimestamp = r3;
        this.mdigest = r4;
        this.mfish_bone = r5;
        this.mtopic = r6;
        this.msubtitles = Internal.immutableCopyOf("msubtitles", r7);
        this.mcustom_summary = r8;
        this.mfishbone_eval_infos = Internal.immutableCopyOf("mfishbone_eval_infos", r9);
        this.mempty_state_info = r10;
        this.mnotes_block = r11;
        this.mnotes = Internal.immutableCopyOf("mnotes", r12);
        this.mnote_switch = r13;
        this.mexport_data = r14;
    }
}
