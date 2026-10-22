package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.pb.office_ai.QuickAction;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MyAIQuickActionConfig extends Message<MyAIQuickActionConfig, Builder> {
    public static final ProtoAdapter<MyAIQuickActionConfig> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_SHOW_IN_CHAT = null;
    private static final long serialVersionUID = 0;
    public final String mid;
    public final QuickAction mquick_action;
    public final Boolean mshow_in_chat;
    public final ActionType mtype;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType SUMMARIZE_MEETING = null;
        public static final ActionType SUMMARIZE_PARTICIPANT = null;
        public static final ActionType TODO_TASK = null;
        public static final ActionType UNKNOWN = null;
        private final int value;

        static {
            ActionType r0 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ActionType r1 = new ActionType("SUMMARIZE_MEETING", 1, 1);
            SUMMARIZE_MEETING = r1;
            ActionType r3 = new ActionType("SUMMARIZE_PARTICIPANT", 2, 2);
            SUMMARIZE_PARTICIPANT = r3;
            ActionType r5 = new ActionType("TODO_TASK", 3, 3);
            TODO_TASK = r5;
            $VALUES = new ActionType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ActionType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return TODO_TASK;
        L14:
            return SUMMARIZE_PARTICIPANT;
        L16:
            return SUMMARIZE_MEETING;
        L18:
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

    public static final class Builder extends Message.Builder<MyAIQuickActionConfig, Builder> {
        public String mid;
        public QuickAction mquick_action;
        public Boolean mshow_in_chat;
        public ActionType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MyAIQuickActionConfig m3164build() {
            return new MyAIQuickActionConfig(this.mid, this.mtype, this.mshow_in_chat, this.mquick_action, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3164build();
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder quick_action(QuickAction r1) {
            this.mquick_action = r1;
            return this;
        }

        public Builder show_in_chat(Boolean r1) {
            this.mshow_in_chat = r1;
            return this;
        }

        public Builder type(ActionType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MyAIQuickActionConfig extends ProtoAdapter<MyAIQuickActionConfig> {
        public ProtoAdapter_MyAIQuickActionConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, MyAIQuickActionConfig.class);
        }

        public MyAIQuickActionConfig decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mshow_in_chat = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (ActionType) ActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mshow_in_chat = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mquick_action = (QuickAction) QuickAction.ADAPTER.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m3164build();
        }

        public int encodedSize(MyAIQuickActionConfig r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ActionType r3 = r6.mtype;
            if (r3 == null) goto L9;
            int r4 = ActionType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mshow_in_chat;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            QuickAction r10 = r6.mquick_action;
            if (r10 == null) goto L18;
            r1 = QuickAction.ADAPTER.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m3165decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MyAIQuickActionConfig) r1);
        }

        public void encode(ProtoWriter r4, MyAIQuickActionConfig r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ActionType r1 = r5.mtype;
            if (r1 == null) goto L8;
            ActionType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mshow_in_chat;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            QuickAction r3 = r5.mquick_action;
            if (r3 == null) goto L14;
            QuickAction.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MyAIQuickActionConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MyAIQuickActionConfig();
        DEFAULT_SHOW_IN_CHAT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3163newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mshow_in_chat = this.mshow_in_chat;
        r0.mquick_action = this.mquick_action;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MyAIQuickActionConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3163newBuilder();
    }

    public MyAIQuickActionConfig(String r7, ActionType r8, Boolean r9, QuickAction r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public MyAIQuickActionConfig(String r2, ActionType r3, Boolean r4, QuickAction r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mid = r2;
        this.mtype = r3;
        this.mshow_in_chat = r4;
        this.mquick_action = r5;
    }
}
