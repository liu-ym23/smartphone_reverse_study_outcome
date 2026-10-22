package com.ss.android.lark.pb.section;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
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
public final class Action extends Message<Action, Builder> {
    public static final ProtoAdapter<Action> ADAPTER = null;
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> mparams;
    public final ActionType mtype;
    public final String muri;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType SEARCH_INSIDE = null;
        public static final ActionType SEARCH_OUTSIDE = null;
        public static final ActionType UNKNOWN = null;
        private final int value;

        static {
            ActionType r0 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ActionType r1 = new ActionType("SEARCH_INSIDE", 1, 1);
            SEARCH_INSIDE = r1;
            ActionType r3 = new ActionType("SEARCH_OUTSIDE", 2, 2);
            SEARCH_OUTSIDE = r3;
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
            return SEARCH_OUTSIDE;
        L12:
            return SEARCH_INSIDE;
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

    public static final class Builder extends Message.Builder<Action, Builder> {
        public Map<String, String> mparams;
        public ActionType mtype;
        public String muri;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Action m2138build() {
            return new Action(this.mtype, this.muri, this.mparams, super.buildUnknownFields());
        }

        public Builder() {
            this.mparams = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2138build();
        }

        public Builder params(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mparams = r1;
            return this;
        }

        public Builder type(ActionType r1) {
            this.mtype = r1;
            return this;
        }

        public Builder uri(String r1) {
            this.muri = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Action extends ProtoAdapter<Action> {
        private final ProtoAdapter<Map<String, String>> mparams;

        public ProtoAdapter_Action() {
            super(FieldEncoding.LENGTH_DELIMITED, Action.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mparams = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public Action decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.muri = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtype = (ActionType) ActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.muri = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mparams.putAll((Map) this.mparams.decode(r9));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2138build();
        }

        public int encodedSize(Action r5) {
            ActionType r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ActionType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.muri;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + this.mparams.encodedSizeWithTag(3, r5.mparams)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2139decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Action) r1);
        }

        public void encode(ProtoWriter r4, Action r5) throws IOException {
            ActionType r0 = r5.mtype;
            if (r0 == null) goto L5;
            ActionType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.muri;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            this.mparams.encodeWithTag(r4, 3, r5.mparams);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Action) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Action();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2137newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.muri = this.muri;
        r0.mparams = Internal.copyOf("mparams", this.mparams);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Action.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2137newBuilder();
    }

    public Action(ActionType r2, String r3, Map<String, String> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public Action(ActionType r2, String r3, Map<String, String> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtype = r2;
        this.muri = r3;
        this.mparams = Internal.immutableCopyOf("mparams", r4);
    }
}
