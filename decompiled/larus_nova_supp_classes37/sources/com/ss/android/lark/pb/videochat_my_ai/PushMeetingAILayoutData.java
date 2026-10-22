package com.ss.android.lark.pb.videochat_my_ai;

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
public final class PushMeetingAILayoutData extends Message<PushMeetingAILayoutData, Builder> {
    public static final ProtoAdapter<PushMeetingAILayoutData> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Long DEFAULT_TIMESTAMP = null;
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final FeatureStatus mnote_switch;
    public final List<NotesBlock> mnotes_blocks;
    public final Long mtimestamp;
    public final Type mtype;

    public static final class Builder extends Message.Builder<PushMeetingAILayoutData, Builder> {
        public String mmeeting_id;
        public FeatureStatus mnote_switch;
        public List<NotesBlock> mnotes_blocks;
        public Long mtimestamp;
        public Type mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PushMeetingAILayoutData m3305build() {
            return new PushMeetingAILayoutData(this.mmeeting_id, this.mtimestamp, this.mtype, this.mnotes_blocks, this.mnote_switch, super.buildUnknownFields());
        }

        public Builder() {
            this.mnotes_blocks = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3305build();
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder note_switch(FeatureStatus r1) {
            this.mnote_switch = r1;
            return this;
        }

        public Builder notes_blocks(List<NotesBlock> r1) {
            Internal.checkElementsNotNull(r1);
            this.mnotes_blocks = r1;
            return this;
        }

        public Builder timestamp(Long r1) {
            this.mtimestamp = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PushMeetingAILayoutData extends ProtoAdapter<PushMeetingAILayoutData> {
        public ProtoAdapter_PushMeetingAILayoutData() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMeetingAILayoutData.class);
        }

        public PushMeetingAILayoutData decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.mtimestamp = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L27;
            if (r3 != 1) goto L8;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtimestamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mnotes_blocks.add((NotesBlock) NotesBlock.ADAPTER.decode(r9));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mnote_switch = (FeatureStatus) FeatureStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L27:
            r9.endMessage(r1);
            return r0.m3305build();
        }

        public int encodedSize(PushMeetingAILayoutData r6) {
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
            Type r7 = r6.mtype;
            if (r7 == null) goto L13;
            int r8 = Type.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = (r5 + r8) + NotesBlock.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mnotes_blocks);
            FeatureStatus r10 = r6.mnote_switch;
            if (r10 == null) goto L18;
            r1 = FeatureStatus.ADAPTER.encodedSizeWithTag(5, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m3306decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PushMeetingAILayoutData) r1);
        }

        public void encode(ProtoWriter r4, PushMeetingAILayoutData r5) throws IOException {
            String r0 = r5.mmeeting_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mtimestamp;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            Type r2 = r5.mtype;
            if (r2 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            NotesBlock.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mnotes_blocks);
            FeatureStatus r3 = r5.mnote_switch;
            if (r3 == null) goto L14;
            FeatureStatus.ADAPTER.encodeWithTag(r4, 5, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PushMeetingAILayoutData) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AI_LAYOUT_FISH_BONE = null;
        public static final Type AI_LAYOUT_NOTES = null;
        public static final Type AI_LAYOUT_NOTE_SWITCH = null;
        public static final Type AI_LAYOUT_SUBTITLE_EFFECT = null;
        public static final Type AI_LAYOUT_TOPIC = null;
        public static final Type RESERVED_USER_6 = null;
        public static final Type RESERVED_USER_7 = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("AI_LAYOUT_FISH_BONE", 1, 1);
            AI_LAYOUT_FISH_BONE = r1;
            Type r3 = new Type("AI_LAYOUT_TOPIC", 2, 2);
            AI_LAYOUT_TOPIC = r3;
            Type r5 = new Type("AI_LAYOUT_SUBTITLE_EFFECT", 3, 3);
            AI_LAYOUT_SUBTITLE_EFFECT = r5;
            Type r7 = new Type("AI_LAYOUT_NOTES", 4, 4);
            AI_LAYOUT_NOTES = r7;
            Type r9 = new Type("AI_LAYOUT_NOTE_SWITCH", 5, 5);
            AI_LAYOUT_NOTE_SWITCH = r9;
            Type r11 = new Type("RESERVED_USER_6", 6, 6);
            RESERVED_USER_6 = r11;
            Type r13 = new Type("RESERVED_USER_7", 7, 7);
            RESERVED_USER_7 = r13;
            $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r0) {
            switch(r0) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return RESERVED_USER_7;
        L8:
            return RESERVED_USER_6;
        L10:
            return AI_LAYOUT_NOTE_SWITCH;
        L12:
            return AI_LAYOUT_NOTES;
        L14:
            return AI_LAYOUT_SUBTITLE_EFFECT;
        L16:
            return AI_LAYOUT_TOPIC;
        L18:
            return AI_LAYOUT_FISH_BONE;
        L20:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushMeetingAILayoutData();
        DEFAULT_TIMESTAMP = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3304newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.mtimestamp = this.mtimestamp;
        r0.mtype = this.mtype;
        r0.mnotes_blocks = Internal.copyOf("mnotes_blocks", this.mnotes_blocks);
        r0.mnote_switch = this.mnote_switch;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PushMeetingAILayoutData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3304newBuilder();
    }

    public PushMeetingAILayoutData(String r8, Long r9, Type r10, List<NotesBlock> r11, FeatureStatus r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public PushMeetingAILayoutData(String r2, Long r3, Type r4, List<NotesBlock> r5, FeatureStatus r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mmeeting_id = r2;
        this.mtimestamp = r3;
        this.mtype = r4;
        this.mnotes_blocks = Internal.immutableCopyOf("mnotes_blocks", r5);
        this.mnote_switch = r6;
    }
}
