package com.ss.android.lark.pb.videochat_my_ai;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetMeetingAISummaryRequest extends Message<GetMeetingAISummaryRequest, Builder> {
    public static final ProtoAdapter<GetMeetingAISummaryRequest> ADAPTER = null;
    public static final String DEFAULT_EXPORT_TASK_ID = "";
    public static final Boolean DEFAULT_HARDWARE_COMPLETE = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_UNIQUE_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final ActionType maction_type;
    public final AIViewBlockData mai_view_export_data;
    public final CustomSummaryAction mcustom_summary_action;
    public final EmptyStateAction mempty_state_action;
    public final String mexport_task_id;
    public final FishBoneEvalRequest mfish_bone_eval_req;
    public final Boolean mhardware_complete;
    public final String mmeeting_id;
    public final FeatureStatus mnote_switch;
    public final NotesAction mnotes_action;
    public final List<NotesBlock> mnotes_block;
    public final List<Long> msentence_ids;
    public final String munique_id;
    public final UpdateTitleInfo mupdate_title_info;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType CUSTOM_SUMMARY_ACTION = null;
        public static final ActionType EMPTY_STATE_ACTION = null;
        public static final ActionType EXPORT_AI_VIEW = null;
        public static final ActionType GET_EXPORT_AI_VIEW_URL = null;
        public static final ActionType GET_FISHBONE_EVAL = null;
        public static final ActionType GET_FISHBONE_EVAL_SUBTITLES = null;
        public static final ActionType GET_FISHBONE_SUBTITLES = null;
        public static final ActionType GET_LATEST_AI_LAYOUT_FISH_BONE = null;
        public static final ActionType GET_LATEST_AI_LAYOUT_TOPIC = null;
        public static final ActionType GET_LATEST_MANUAL_REFRESH_RESULT = null;
        public static final ActionType GET_LATEST_MEETING_SUMMARY = null;
        public static final ActionType HANDLE_VC_AI_NOTES = null;
        public static final ActionType MANUAL_REFRESH_MEETING_SUMMARY = null;
        public static final ActionType UNKNOWN = null;
        public static final ActionType UPDATE_MINUTES_TITLE = null;
        private final int value;

        static {
            ActionType r0 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ActionType r1 = new ActionType("GET_LATEST_MEETING_SUMMARY", 1, 1);
            GET_LATEST_MEETING_SUMMARY = r1;
            ActionType r3 = new ActionType("MANUAL_REFRESH_MEETING_SUMMARY", 2, 2);
            MANUAL_REFRESH_MEETING_SUMMARY = r3;
            ActionType r5 = new ActionType("GET_LATEST_MANUAL_REFRESH_RESULT", 3, 3);
            GET_LATEST_MANUAL_REFRESH_RESULT = r5;
            ActionType r7 = new ActionType("GET_LATEST_AI_LAYOUT_FISH_BONE", 4, 4);
            GET_LATEST_AI_LAYOUT_FISH_BONE = r7;
            ActionType r9 = new ActionType("GET_LATEST_AI_LAYOUT_TOPIC", 5, 5);
            GET_LATEST_AI_LAYOUT_TOPIC = r9;
            ActionType r11 = new ActionType("GET_FISHBONE_SUBTITLES", 6, 6);
            GET_FISHBONE_SUBTITLES = r11;
            ActionType r13 = new ActionType("CUSTOM_SUMMARY_ACTION", 7, 7);
            CUSTOM_SUMMARY_ACTION = r13;
            ActionType r15 = new ActionType("GET_FISHBONE_EVAL", 8, 8);
            GET_FISHBONE_EVAL = r15;
            ActionType r14 = new ActionType("GET_FISHBONE_EVAL_SUBTITLES", 9, 9);
            GET_FISHBONE_EVAL_SUBTITLES = r14;
            ActionType r12 = new ActionType("UPDATE_MINUTES_TITLE", 10, 10);
            UPDATE_MINUTES_TITLE = r12;
            ActionType r10 = new ActionType("EMPTY_STATE_ACTION", 11, 11);
            EMPTY_STATE_ACTION = r10;
            ActionType r8 = new ActionType("HANDLE_VC_AI_NOTES", 12, 12);
            HANDLE_VC_AI_NOTES = r8;
            ActionType r6 = new ActionType("EXPORT_AI_VIEW", 13, 13);
            EXPORT_AI_VIEW = r6;
            ActionType r4 = new ActionType("GET_EXPORT_AI_VIEW_URL", 14, 14);
            GET_EXPORT_AI_VIEW_URL = r4;
            $VALUES = new ActionType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ActionType fromValue(int r0) {
            switch(r0) {
                case 0: goto L34;
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                case 14: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return GET_EXPORT_AI_VIEW_URL;
        L8:
            return EXPORT_AI_VIEW;
        L10:
            return HANDLE_VC_AI_NOTES;
        L12:
            return EMPTY_STATE_ACTION;
        L14:
            return UPDATE_MINUTES_TITLE;
        L16:
            return GET_FISHBONE_EVAL_SUBTITLES;
        L18:
            return GET_FISHBONE_EVAL;
        L20:
            return CUSTOM_SUMMARY_ACTION;
        L22:
            return GET_FISHBONE_SUBTITLES;
        L24:
            return GET_LATEST_AI_LAYOUT_TOPIC;
        L26:
            return GET_LATEST_AI_LAYOUT_FISH_BONE;
        L28:
            return GET_LATEST_MANUAL_REFRESH_RESULT;
        L30:
            return MANUAL_REFRESH_MEETING_SUMMARY;
        L32:
            return GET_LATEST_MEETING_SUMMARY;
        L34:
            return UNKNOWN;
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) a.a(ActionType.class, r1);
        }

        private ActionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<GetMeetingAISummaryRequest, Builder> {
        public ActionType maction_type;
        public AIViewBlockData mai_view_export_data;
        public CustomSummaryAction mcustom_summary_action;
        public EmptyStateAction mempty_state_action;
        public String mexport_task_id;
        public FishBoneEvalRequest mfish_bone_eval_req;
        public Boolean mhardware_complete;
        public String mmeeting_id;
        public FeatureStatus mnote_switch;
        public NotesAction mnotes_action;
        public List<NotesBlock> mnotes_block;
        public List<Long> msentence_ids;
        public String munique_id;
        public UpdateTitleInfo mupdate_title_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetMeetingAISummaryRequest m3284build() {
            return new GetMeetingAISummaryRequest(this.mmeeting_id, this.maction_type, this.msentence_ids, this.mcustom_summary_action, this.mfish_bone_eval_req, this.mupdate_title_info, this.mempty_state_action, this.mnotes_action, this.mnotes_block, this.munique_id, this.mhardware_complete, this.mnote_switch, this.mai_view_export_data, this.mexport_task_id, super.buildUnknownFields());
        }

        public Builder() {
            this.msentence_ids = Internal.newMutableList();
            this.mnotes_block = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3284build();
        }

        public Builder action_type(ActionType r1) {
            this.maction_type = r1;
            return this;
        }

        public Builder ai_view_export_data(AIViewBlockData r1) {
            this.mai_view_export_data = r1;
            return this;
        }

        public Builder custom_summary_action(CustomSummaryAction r1) {
            this.mcustom_summary_action = r1;
            return this;
        }

        public Builder empty_state_action(EmptyStateAction r1) {
            this.mempty_state_action = r1;
            return this;
        }

        public Builder export_task_id(String r1) {
            this.mexport_task_id = r1;
            return this;
        }

        public Builder fish_bone_eval_req(FishBoneEvalRequest r1) {
            this.mfish_bone_eval_req = r1;
            return this;
        }

        public Builder hardware_complete(Boolean r1) {
            this.mhardware_complete = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder note_switch(FeatureStatus r1) {
            this.mnote_switch = r1;
            return this;
        }

        public Builder notes_action(NotesAction r1) {
            this.mnotes_action = r1;
            return this;
        }

        public Builder notes_block(List<NotesBlock> r1) {
            Internal.checkElementsNotNull(r1);
            this.mnotes_block = r1;
            return this;
        }

        public Builder sentence_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.msentence_ids = r1;
            return this;
        }

        public Builder unique_id(String r1) {
            this.munique_id = r1;
            return this;
        }

        public Builder update_title_info(UpdateTitleInfo r1) {
            this.mupdate_title_info = r1;
            return this;
        }
    }

    public static final enum NotesAction extends Enum<NotesAction> implements WireEnum {
        private static final /* synthetic */ NotesAction[] $VALUES = null;
        public static final ProtoAdapter<NotesAction> ADAPTER = null;
        public static final NotesAction CREATE = null;
        public static final NotesAction DELETE = null;
        public static final NotesAction GET = null;
        public static final NotesAction GET_SWITCH = null;
        public static final NotesAction MODIFY = null;
        public static final NotesAction MODIFY_SWITCH = null;
        private final int value;

        static {
            NotesAction r0 = new NotesAction("CREATE", 0, 1);
            CREATE = r0;
            NotesAction r1 = new NotesAction("DELETE", 1, 2);
            DELETE = r1;
            NotesAction r4 = new NotesAction("MODIFY", 2, 3);
            MODIFY = r4;
            NotesAction r6 = new NotesAction("GET", 3, 4);
            GET = r6;
            NotesAction r8 = new NotesAction("GET_SWITCH", 4, 5);
            GET_SWITCH = r8;
            NotesAction r10 = new NotesAction("MODIFY_SWITCH", 5, 6);
            MODIFY_SWITCH = r10;
            $VALUES = new NotesAction[]{r0, r1, r4, r6, r8, r10};
            ADAPTER = ProtoAdapter.newEnumAdapter(NotesAction.class);
        }

        public static NotesAction[] values() {
            return (NotesAction[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NotesAction fromValue(int r0) {
            switch(r0) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MODIFY_SWITCH;
        L8:
            return GET_SWITCH;
        L10:
            return GET;
        L12:
            return MODIFY;
        L14:
            return DELETE;
        L16:
            return CREATE;
        }

        public static NotesAction valueOf(String r1) {
            return (NotesAction) a.a(NotesAction.class, r1);
        }

        private NotesAction(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_GetMeetingAISummaryRequest extends ProtoAdapter<GetMeetingAISummaryRequest> {
        public ProtoAdapter_GetMeetingAISummaryRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMeetingAISummaryRequest.class);
        }

        public GetMeetingAISummaryRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.munique_id = "";
            r0.mhardware_complete = Boolean.FALSE;
            r0.mexport_task_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L30;
            switch(r3) {
                case 1: goto L29;
                case 2: goto L36;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L32;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L34;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L32:
            r0.mnotes_action = (NotesAction) NotesAction.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L34:
            r0.mnote_switch = (FeatureStatus) FeatureStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L36:
            r0.maction_type = (ActionType) ActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mexport_task_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mai_view_export_data = (AIViewBlockData) AIViewBlockData.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mhardware_complete = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            r0.munique_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mnotes_block.add((NotesBlock) NotesBlock.ADAPTER.decode(r9));
            goto L3
        L20:
            r0.mempty_state_action = (EmptyStateAction) EmptyStateAction.ADAPTER.decode(r9);
            goto L3
        L21:
            r0.mupdate_title_info = (UpdateTitleInfo) UpdateTitleInfo.ADAPTER.decode(r9);
            goto L3
        L22:
            r0.mfish_bone_eval_req = (FishBoneEvalRequest) FishBoneEvalRequest.ADAPTER.decode(r9);
            goto L3
        L23:
            r0.mcustom_summary_action = (CustomSummaryAction) CustomSummaryAction.ADAPTER.decode(r9);
            goto L3
        L24:
            r0.msentence_ids.add((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L29:
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L30:
            r9.endMessage(r1);
            return r0.m3284build();
        }

        public int encodedSize(GetMeetingAISummaryRequest r6) {
            String r0 = r6.mmeeting_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ActionType r3 = r6.maction_type;
            if (r3 == null) goto L9;
            int r4 = ActionType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = (r2 + r4) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(3, r6.msentence_ids);
            CustomSummaryAction r7 = r6.mcustom_summary_action;
            if (r7 == null) goto L13;
            int r8 = CustomSummaryAction.ADAPTER.encodedSizeWithTag(4, r7);
        L14:
            int r9 = r5 + r8;
            FishBoneEvalRequest r10 = r6.mfish_bone_eval_req;
            if (r10 == null) goto L17;
            int r11 = FishBoneEvalRequest.ADAPTER.encodedSizeWithTag(5, r10);
        L18:
            int r12 = r9 + r11;
            UpdateTitleInfo r13 = r6.mupdate_title_info;
            if (r13 == null) goto L21;
            int r14 = UpdateTitleInfo.ADAPTER.encodedSizeWithTag(6, r13);
        L22:
            int r15 = r12 + r14;
            EmptyStateAction r16 = r6.mempty_state_action;
            if (r16 == null) goto L25;
            int r17 = EmptyStateAction.ADAPTER.encodedSizeWithTag(7, r16);
        L26:
            int r18 = r15 + r17;
            NotesAction r19 = r6.mnotes_action;
            if (r19 == null) goto L29;
            int r20 = NotesAction.ADAPTER.encodedSizeWithTag(8, r19);
        L30:
            int r21 = (r18 + r20) + NotesBlock.ADAPTER.asRepeated().encodedSizeWithTag(9, r6.mnotes_block);
            String r22 = r6.munique_id;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(10, r22);
        L34:
            int r24 = r21 + r23;
            Boolean r25 = r6.mhardware_complete;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r25);
        L38:
            int r27 = r24 + r26;
            FeatureStatus r28 = r6.mnote_switch;
            if (r28 == null) goto L41;
            int r29 = FeatureStatus.ADAPTER.encodedSizeWithTag(12, r28);
        L42:
            int r30 = r27 + r29;
            AIViewBlockData r31 = r6.mai_view_export_data;
            if (r31 == null) goto L45;
            int r32 = AIViewBlockData.ADAPTER.encodedSizeWithTag(13, r31);
        L46:
            int r33 = r30 + r32;
            String r34 = r6.mexport_task_id;
            if (r34 == null) goto L50;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(14, r34);
        L50:
            return (r33 + r1) + r6.unknownFields().size();
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ Object m3285decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetMeetingAISummaryRequest) r1);
        }

        public void encode(ProtoWriter r4, GetMeetingAISummaryRequest r5) throws IOException {
            String r0 = r5.mmeeting_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ActionType r1 = r5.maction_type;
            if (r1 == null) goto L8;
            ActionType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 3, r5.msentence_ids);
            CustomSummaryAction r2 = r5.mcustom_summary_action;
            if (r2 == null) goto L11;
            CustomSummaryAction.ADAPTER.encodeWithTag(r4, 4, r2);
        L11:
            FishBoneEvalRequest r3 = r5.mfish_bone_eval_req;
            if (r3 == null) goto L14;
            FishBoneEvalRequest.ADAPTER.encodeWithTag(r4, 5, r3);
        L14:
            UpdateTitleInfo r6 = r5.mupdate_title_info;
            if (r6 == null) goto L17;
            UpdateTitleInfo.ADAPTER.encodeWithTag(r4, 6, r6);
        L17:
            EmptyStateAction r7 = r5.mempty_state_action;
            if (r7 == null) goto L20;
            EmptyStateAction.ADAPTER.encodeWithTag(r4, 7, r7);
        L20:
            NotesAction r8 = r5.mnotes_action;
            if (r8 == null) goto L23;
            NotesAction.ADAPTER.encodeWithTag(r4, 8, r8);
        L23:
            NotesBlock.ADAPTER.asRepeated().encodeWithTag(r4, 9, r5.mnotes_block);
            String r9 = r5.munique_id;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r9);
        L26:
            Boolean r10 = r5.mhardware_complete;
            if (r10 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r4, 11, r10);
        L29:
            FeatureStatus r11 = r5.mnote_switch;
            if (r11 == null) goto L32;
            FeatureStatus.ADAPTER.encodeWithTag(r4, 12, r11);
        L32:
            AIViewBlockData r12 = r5.mai_view_export_data;
            if (r12 == null) goto L35;
            AIViewBlockData.ADAPTER.encodeWithTag(r4, 13, r12);
        L35:
            String r13 = r5.mexport_task_id;
            if (r13 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r4, 14, r13);
        L38:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetMeetingAISummaryRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetMeetingAISummaryRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
        DEFAULT_HARDWARE_COMPLETE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3283newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.maction_type = this.maction_type;
        r0.msentence_ids = Internal.copyOf("msentence_ids", this.msentence_ids);
        r0.mcustom_summary_action = this.mcustom_summary_action;
        r0.mfish_bone_eval_req = this.mfish_bone_eval_req;
        r0.mupdate_title_info = this.mupdate_title_info;
        r0.mempty_state_action = this.mempty_state_action;
        r0.mnotes_action = this.mnotes_action;
        r0.mnotes_block = Internal.copyOf("mnotes_block", this.mnotes_block);
        r0.munique_id = this.munique_id;
        r0.mhardware_complete = this.mhardware_complete;
        r0.mnote_switch = this.mnote_switch;
        r0.mai_view_export_data = this.mai_view_export_data;
        r0.mexport_task_id = this.mexport_task_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetMeetingAISummaryRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3283newBuilder();
    }

    public GetMeetingAISummaryRequest(String r17, ActionType r18, List<Long> r19, CustomSummaryAction r20, FishBoneEvalRequest r21, UpdateTitleInfo r22, EmptyStateAction r23, NotesAction r24, List<NotesBlock> r25, String r26, Boolean r27, FeatureStatus r28, AIViewBlockData r29, String r30) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, ByteString.EMPTY);
    }

    public GetMeetingAISummaryRequest(String r4, ActionType r5, List<Long> r6, CustomSummaryAction r7, FishBoneEvalRequest r8, UpdateTitleInfo r9, EmptyStateAction r10, NotesAction r11, List<NotesBlock> r12, String r13, Boolean r14, FeatureStatus r15, AIViewBlockData r16, String r17, ByteString r18) {
        super(ADAPTER, r18);
        this.mmeeting_id = r4;
        this.maction_type = r5;
        this.msentence_ids = Internal.immutableCopyOf("msentence_ids", r6);
        this.mcustom_summary_action = r7;
        this.mfish_bone_eval_req = r8;
        this.mupdate_title_info = r9;
        this.mempty_state_action = r10;
        this.mnotes_action = r11;
        this.mnotes_block = Internal.immutableCopyOf("mnotes_block", r12);
        this.munique_id = r13;
        this.mhardware_complete = r14;
        this.mnote_switch = r15;
        this.mai_view_export_data = r16;
        this.mexport_task_id = r17;
    }
}
