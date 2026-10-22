package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ActionInfo extends com.squareup.wire.Message<ActionInfo, Builder> {
    public static final ProtoAdapter<ActionInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ActionCode maction_code;
    public final ActionExtraInfo mextra;
    public final Map<String, String> mi18n_text;
    public final ActionOperateCode moperator_code;

    public static final enum ActionCode extends Enum<ActionCode> implements WireEnum {
        private static final /* synthetic */ ActionCode[] $VALUES = null;
        public static final ActionCode ACTION_APPLY_USE = null;
        public static final ActionCode ACTION_CONTACT_ADMIN = null;
        public static final ActionCode ACTION_NONE = null;
        public static final ProtoAdapter<ActionCode> ADAPTER = null;
        private final int value;

        static {
            ActionCode r0 = new ActionCode("ACTION_NONE", 0, 0);
            ACTION_NONE = r0;
            ActionCode r1 = new ActionCode("ACTION_CONTACT_ADMIN", 1, 1);
            ACTION_CONTACT_ADMIN = r1;
            ActionCode r3 = new ActionCode("ACTION_APPLY_USE", 2, 2);
            ACTION_APPLY_USE = r3;
            $VALUES = new ActionCode[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionCode.class);
        }

        public static ActionCode[] values() {
            return (ActionCode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ActionCode fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return ACTION_APPLY_USE;
        L12:
            return ACTION_CONTACT_ADMIN;
        L14:
            return ACTION_NONE;
        }

        public static ActionCode valueOf(String r1) {
            return (ActionCode) a.a(ActionCode.class, r1);
        }

        private ActionCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ActionOperateCode extends Enum<ActionOperateCode> implements WireEnum {
        private static final /* synthetic */ ActionOperateCode[] $VALUES = null;
        public static final ProtoAdapter<ActionOperateCode> ADAPTER = null;
        public static final ActionOperateCode CLOSE_APP = null;
        public static final ActionOperateCode CLOSE_WINDOW = null;
        private final int value;

        static {
            ActionOperateCode r0 = new ActionOperateCode("CLOSE_WINDOW", 0, 1);
            CLOSE_WINDOW = r0;
            ActionOperateCode r1 = new ActionOperateCode("CLOSE_APP", 1, 2);
            CLOSE_APP = r1;
            $VALUES = new ActionOperateCode[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionOperateCode.class);
        }

        public static ActionOperateCode[] values() {
            return (ActionOperateCode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ActionOperateCode fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return CLOSE_APP;
        L11:
            return CLOSE_WINDOW;
        }

        public static ActionOperateCode valueOf(String r1) {
            return (ActionOperateCode) a.a(ActionOperateCode.class, r1);
        }

        private ActionOperateCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<ActionInfo, Builder> {
        public ActionCode maction_code;
        public ActionExtraInfo mextra;
        public Map<String, String> mi18n_text;
        public ActionOperateCode moperator_code;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ActionInfo m1004build() {
            return new ActionInfo(this.mi18n_text, this.moperator_code, this.maction_code, this.mextra, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_text = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1004build();
        }

        public Builder action_code(ActionCode r1) {
            this.maction_code = r1;
            return this;
        }

        public Builder extra(ActionExtraInfo r1) {
            this.mextra = r1;
            return this;
        }

        public Builder i18n_text(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_text = r1;
            return this;
        }

        public Builder operator_code(ActionOperateCode r1) {
            this.moperator_code = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ActionInfo extends ProtoAdapter<ActionInfo> {
        private final ProtoAdapter<Map<String, String>> mi18n_text;

        public ProtoAdapter_ActionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ActionInfo.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_text = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public ActionInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mi18n_text.putAll((Map) this.mi18n_text.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.moperator_code = (ActionOperateCode) ActionOperateCode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.maction_code = (ActionCode) ActionCode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mextra = (ActionExtraInfo) ActionExtraInfo.ADAPTER.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m1004build();
        }

        public int encodedSize(ActionInfo r6) {
            int r0 = this.mi18n_text.encodedSizeWithTag(1, r6.mi18n_text);
            ActionOperateCode r1 = r6.moperator_code;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ActionOperateCode.ADAPTER.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            ActionCode r5 = r6.maction_code;
            if (r5 == null) goto L9;
            int r7 = ActionCode.ADAPTER.encodedSizeWithTag(3, r5);
        L10:
            int r8 = r4 + r7;
            ActionExtraInfo r9 = r6.mextra;
            if (r9 == null) goto L14;
            r2 = ActionExtraInfo.ADAPTER.encodedSizeWithTag(4, r9);
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
        public /* bridge */ /* synthetic */ Object m1005decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ActionInfo) r1);
        }

        public void encode(ProtoWriter r4, ActionInfo r5) throws IOException {
            this.mi18n_text.encodeWithTag(r4, 1, r5.mi18n_text);
            ActionOperateCode r0 = r5.moperator_code;
            if (r0 == null) goto L5;
            ActionOperateCode.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            ActionCode r1 = r5.maction_code;
            if (r1 == null) goto L8;
            ActionCode.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            ActionExtraInfo r2 = r5.mextra;
            if (r2 == null) goto L11;
            ActionExtraInfo.ADAPTER.encodeWithTag(r4, 4, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ActionInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ActionInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1003newBuilder() {
        Builder r0 = new Builder();
        r0.mi18n_text = Internal.copyOf("mi18n_text", this.mi18n_text);
        r0.moperator_code = this.moperator_code;
        r0.maction_code = this.maction_code;
        r0.mextra = this.mextra;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ActionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1003newBuilder();
    }

    public ActionInfo(Map<String, String> r7, ActionOperateCode r8, ActionCode r9, ActionExtraInfo r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public ActionInfo(Map<String, String> r2, ActionOperateCode r3, ActionCode r4, ActionExtraInfo r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mi18n_text = Internal.immutableCopyOf("mi18n_text", r2);
        this.moperator_code = r3;
        this.maction_code = r4;
        this.mextra = r5;
    }
}
