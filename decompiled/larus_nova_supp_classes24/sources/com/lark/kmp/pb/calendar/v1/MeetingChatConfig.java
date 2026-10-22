package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/MeetingChatConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/MeetingChatConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/MeetingChatConfig$Builder;Lokio/ByteString;)V", "forbid_create_chat", "", "getForbid_create_chat", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "meeting_chat_setting_type", "Lcom/lark/kmp/pb/calendar/v1/MeetingChatConfig$MeetingChatSettingType;", "getMeeting_chat_setting_type", "()Lcom/lark/kmp/pb/calendar/v1/MeetingChatConfig$MeetingChatSettingType;", "bind_chat_id", "", "getBind_chat_id", "()Ljava/lang/String;", "bind_user_id", "getBind_user_id", "associate_chat_id", "getAssociate_chat_id", "newBuilder", "toString", "Builder", "Companion", "MeetingChatSettingType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MeetingChatConfig extends Message<MeetingChatConfig, a> {
    public static final ProtoAdapter<MeetingChatConfig> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String associate_chat_id;
    private final String bind_chat_id;
    private final String bind_user_id;
    private final Boolean forbid_create_chat;
    private final MeetingChatSettingType meeting_chat_setting_type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/MeetingChatConfig$MeetingChatSettingType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ALLOW_CREATE_CHAT", "FORBID_CREATE_CHAT", "BIND_CHAT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum MeetingChatSettingType extends Enum<MeetingChatSettingType> implements o0 {
        public static final ProtoAdapter<MeetingChatSettingType> ADAPTER = null;
        public static final MeetingChatSettingType ALLOW_CREATE_CHAT = null;
        public static final MeetingChatSettingType BIND_CHAT = null;
        public static final b Companion = null;
        public static final MeetingChatSettingType FORBID_CREATE_CHAT = null;
        public static final MeetingChatSettingType UNKNOWN = null;
        public static final /* synthetic */ MeetingChatSettingType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<MeetingChatSettingType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                MeetingChatSettingType.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return MeetingChatSettingType.BIND_CHAT;
            L18:
                return MeetingChatSettingType.FORBID_CREATE_CHAT;
            L19:
                return MeetingChatSettingType.ALLOW_CREATE_CHAT;
            L15:
                return MeetingChatSettingType.UNKNOWN;
            }

            public a(KClass<MeetingChatSettingType> r1, Syntax r2, MeetingChatSettingType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<MeetingChatSettingType> getEntries() {
            return b;
        }

        static {
            MeetingChatSettingType r0 = new MeetingChatSettingType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            MeetingChatSettingType r1 = new MeetingChatSettingType("ALLOW_CREATE_CHAT", 1, 1);
            ALLOW_CREATE_CHAT = r1;
            MeetingChatSettingType r3 = new MeetingChatSettingType("FORBID_CREATE_CHAT", 2, 2);
            FORBID_CREATE_CHAT = r3;
            MeetingChatSettingType r5 = new MeetingChatSettingType("BIND_CHAT", 3, 3);
            BIND_CHAT = r5;
            MeetingChatSettingType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(MeetingChatSettingType.class), Syntax.PROTO_2, r0);
        }

        public static MeetingChatSettingType[] values() {
            return (MeetingChatSettingType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final MeetingChatSettingType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return BIND_CHAT;
        L18:
            return FORBID_CREATE_CHAT;
        L19:
            return ALLOW_CREATE_CHAT;
        L15:
            return UNKNOWN;
        }

        public static MeetingChatSettingType valueOf(String r1) {
            return (MeetingChatSettingType) r27.a.a(MeetingChatSettingType.class, r1);
        }

        public MeetingChatSettingType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<MeetingChatConfig, a> {
        public Boolean d;
        public MeetingChatSettingType e;
        public String f;
        public String g;
        public String h;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new MeetingChatConfig(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MeetingChatConfig> {
        @Override // com.lark.wire.ProtoAdapter
        public final MeetingChatConfig c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L25;
            if (r4 != 1) goto L8;
            r1.d = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = MeetingChatSettingType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.f = r10.i();
            goto L3
        L12:
            if (r4 != 4) goto L14;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L14:
            if (r4 != 5) goto L15;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L15:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L25:
            return new MeetingChatConfig(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MeetingChatConfig r5) {
            MeetingChatConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = (r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.getForbid_create_chat())) + MeetingChatSettingType.ADAPTER.l(2, r6.getMeeting_chat_setting_type());
            w r1 = ProtoAdapter.q;
            return ((r0 + r1.l(3, r6.getBind_chat_id())) + r1.l(4, r6.getBind_user_id())) + r1.l(5, r6.getAssociate_chat_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MeetingChatConfig r5) {
            MeetingChatConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.g.i(r4, 1, r6.getForbid_create_chat());
            MeetingChatSettingType.ADAPTER.i(r4, 2, r6.getMeeting_chat_setting_type());
            w r0 = ProtoAdapter.q;
            r0.i(r4, 3, r6.getBind_chat_id());
            r0.i(r4, 4, r6.getBind_user_id());
            r0.i(r4, 5, r6.getAssociate_chat_id());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MeetingChatConfig r5) {
            MeetingChatConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 5, r6.getAssociate_chat_id());
            r0.j(r4, 4, r6.getBind_user_id());
            r0.j(r4, 3, r6.getBind_chat_id());
            MeetingChatSettingType.ADAPTER.j(r4, 2, r6.getMeeting_chat_setting_type());
            ProtoAdapter.g.j(r4, 1, r6.getForbid_create_chat());
        }

        public b(FieldEncoding r7, KClass<MeetingChatConfig> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.MeetingChatConfig", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MeetingChatConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MeetingChatConfig.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.forbid_create_chat;
        r0.e = this.meeting_chat_setting_type;
        r0.f = this.bind_chat_id;
        r0.g = this.bind_user_id;
        r0.h = this.associate_chat_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MeetingChatConfig.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAssociate_chat_id() {
        return this.associate_chat_id;
    }

    public final String getBind_chat_id() {
        return this.bind_chat_id;
    }

    public final String getBind_user_id() {
        return this.bind_user_id;
    }

    public final Boolean getForbid_create_chat() {
        return this.forbid_create_chat;
    }

    public final MeetingChatSettingType getMeeting_chat_setting_type() {
        return this.meeting_chat_setting_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public MeetingChatConfig(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.forbid_create_chat = r2.d;
        this.meeting_chat_setting_type = r2.e;
        this.bind_chat_id = r2.f;
        this.bind_user_id = r2.g;
        this.associate_chat_id = r2.h;
    }

    public /* synthetic */ MeetingChatConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
