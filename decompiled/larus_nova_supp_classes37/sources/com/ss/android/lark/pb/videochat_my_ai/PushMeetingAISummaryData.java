package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PushMeetingAISummaryData extends Message<PushMeetingAISummaryData, Builder> {
    public static final ProtoAdapter<PushMeetingAISummaryData> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Long DEFAULT_TIMESTAMP = null;
    private static final long serialVersionUID = 0;
    public final ActionType maction_type;
    public final String mmeeting_id;
    public final Long mtimestamp;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType NOTIFY_MANUAL_REFRESH_SUMMARY = null;
        public static final ActionType NOTIFY_NEW_SUMMARY = null;
        public static final ActionType UNKNOWN = null;
        private final int value;

        static {
            ActionType r0 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ActionType r1 = new ActionType("NOTIFY_NEW_SUMMARY", 1, 1);
            NOTIFY_NEW_SUMMARY = r1;
            ActionType r3 = new ActionType("NOTIFY_MANUAL_REFRESH_SUMMARY", 2, 2);
            NOTIFY_MANUAL_REFRESH_SUMMARY = r3;
            $VALUES = new ActionType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ActionType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return NOTIFY_MANUAL_REFRESH_SUMMARY;
        L12:
            return NOTIFY_NEW_SUMMARY;
        L14:
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

    public static final class Builder extends Message.Builder<PushMeetingAISummaryData, Builder> {
        public ActionType maction_type;
        public String mmeeting_id;
        public Long mtimestamp;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PushMeetingAISummaryData m3308build() {
            return new PushMeetingAISummaryData(this.mmeeting_id, this.mtimestamp, this.maction_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3308build();
        }

        public Builder action_type(ActionType r1) {
            this.maction_type = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder timestamp(Long r1) {
            this.mtimestamp = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PushMeetingAISummaryData extends ProtoAdapter<PushMeetingAISummaryData> {
        public ProtoAdapter_PushMeetingAISummaryData() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMeetingAISummaryData.class);
        }

        public PushMeetingAISummaryData decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.mtimestamp = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtimestamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.maction_type = (ActionType) ActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m3308build();
        }

        public int encodedSize(PushMeetingAISummaryData r6) {
            String r0 = r6.mmeeting_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mtimestamp;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ActionType r7 = r6.maction_type;
            if (r7 == null) goto L14;
            r1 = ActionType.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3309decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PushMeetingAISummaryData) r1);
        }

        public void encode(ProtoWriter r4, PushMeetingAISummaryData r5) throws IOException {
            String r0 = r5.mmeeting_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mtimestamp;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            ActionType r2 = r5.maction_type;
            if (r2 == null) goto L11;
            ActionType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PushMeetingAISummaryData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushMeetingAISummaryData();
        DEFAULT_TIMESTAMP = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3307newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.mtimestamp = this.mtimestamp;
        r0.maction_type = this.maction_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PushMeetingAISummaryData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3307newBuilder();
    }

    public PushMeetingAISummaryData(String r2, Long r3, ActionType r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PushMeetingAISummaryData(String r2, Long r3, ActionType r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mmeeting_id = r2;
        this.mtimestamp = r3;
        this.maction_type = r4;
    }
}
