package com.lark.kmp.pb.im.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005+,-./B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\nH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\r\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001e\u0010\u000fR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010#\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00060"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "is_from_server", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "scene", "Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Scene;", "getScene", "()Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Scene;", "filter", "getFilter", "cursor", "getCursor", "limit", "", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_full_data", "condition", "Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Condition;", "getCondition", "()Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Condition;", "offset", "getOffset", "from_scene", "Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$FromScene;", "getFrom_scene", "()Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$FromScene;", "newBuilder", "toString", "Builder", "Companion", "Scene", "Condition", "FromScene", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GetChatChattersRequest extends Message<GetChatChattersRequest, a> {
    public static final ProtoAdapter<GetChatChattersRequest> ADAPTER = null;
    public static final c Companion = null;
    public static final Condition DEFAULT_CONDITION = null;
    public static final FromScene DEFAULT_FROM_SCENE = null;
    public static final boolean DEFAULT_IS_FROM_SERVER = true;
    public static final boolean DEFAULT_IS_FULL_DATA = false;
    public static final int DEFAULT_OFFSET = 0;
    public static final Scene DEFAULT_SCENE = null;
    public static final we6.c<GetChatChattersRequest> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final String chat_id;
    private final Condition condition;
    private final String cursor;
    private final String filter;
    private final FromScene from_scene;
    private final Boolean is_from_server;
    private final Boolean is_full_data;
    private final Integer limit;
    private final Integer offset;
    private final Scene scene;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Condition;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "NoLimit", "NonDepartment", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Condition extends Enum<Condition> implements o0 {
        public static final ProtoAdapter<Condition> ADAPTER = null;
        public static final b Companion = null;
        public static final Condition NoLimit = null;
        public static final Condition NonDepartment = null;
        public static final Condition Unknown = null;
        public static final /* synthetic */ Condition[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Condition> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Condition.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Condition.NonDepartment;
            L15:
                return Condition.NoLimit;
            L12:
                return Condition.Unknown;
            }

            public a(KClass<Condition> r1, Syntax r2, Condition r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Condition> getEntries() {
            return b;
        }

        static {
            Condition r0 = new Condition("Unknown", 0, 0);
            Unknown = r0;
            Condition r1 = new Condition("NoLimit", 1, 1);
            NoLimit = r1;
            Condition r3 = new Condition("NonDepartment", 2, 2);
            NonDepartment = r3;
            Condition[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Condition.class), Syntax.PROTO_2, r0);
        }

        public static Condition[] values() {
            return (Condition[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Condition fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return NonDepartment;
        L15:
            return NoLimit;
        L12:
            return Unknown;
        }

        public static Condition valueOf(String r1) {
            return (Condition) r27.a.a(Condition.class, r1);
        }

        public Condition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$FromScene;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UnknownScene", "FirstGetChatChatterList", "GetChatChatterList", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FromScene extends Enum<FromScene> implements o0 {
        public static final ProtoAdapter<FromScene> ADAPTER = null;
        public static final b Companion = null;
        public static final FromScene FirstGetChatChatterList = null;
        public static final FromScene GetChatChatterList = null;
        public static final FromScene UnknownScene = null;
        public static final /* synthetic */ FromScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FromScene> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FromScene.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return FromScene.GetChatChatterList;
            L15:
                return FromScene.FirstGetChatChatterList;
            L12:
                return FromScene.UnknownScene;
            }

            public a(KClass<FromScene> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FromScene> getEntries() {
            return b;
        }

        static {
            FromScene r0 = new FromScene("UnknownScene", 0, 1);
            UnknownScene = r0;
            FromScene r1 = new FromScene("FirstGetChatChatterList", 1, 2);
            FirstGetChatChatterList = r1;
            FromScene r4 = new FromScene("GetChatChatterList", 2, 3);
            GetChatChatterList = r4;
            FromScene[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FromScene.class), Syntax.PROTO_2);
        }

        public static FromScene[] values() {
            return (FromScene[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FromScene fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return GetChatChatterList;
        L15:
            return FirstGetChatChatterList;
        L12:
            return UnknownScene;
        }

        public static FromScene valueOf(String r1) {
            return (FromScene) r27.a.a(FromScene.class, r1);
        }

        public FromScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/im/v1/GetChatChattersRequest$Scene;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT_MEMBER", "URGENT", "AT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Scene extends Enum<Scene> implements o0 {
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene AT = null;
        public static final Scene CHAT_MEMBER = null;
        public static final b Companion = null;
        public static final Scene URGENT = null;
        public static final /* synthetic */ Scene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Scene> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Scene.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Scene.AT;
            L15:
                return Scene.URGENT;
            L12:
                return Scene.CHAT_MEMBER;
            }

            public a(KClass<Scene> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Scene> getEntries() {
            return b;
        }

        static {
            Scene r0 = new Scene("CHAT_MEMBER", 0, 1);
            CHAT_MEMBER = r0;
            Scene r1 = new Scene("URGENT", 1, 2);
            URGENT = r1;
            Scene r4 = new Scene("AT", 2, 3);
            AT = r4;
            Scene[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Scene.class), Syntax.PROTO_2);
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Scene fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return AT;
        L15:
            return URGENT;
        L12:
            return CHAT_MEMBER;
        }

        public static Scene valueOf(String r1) {
            return (Scene) r27.a.a(Scene.class, r1);
        }

        public Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<GetChatChattersRequest, a> implements we6.d<GetChatChattersRequest> {
        public String d;
        public Boolean e;
        public Scene f;
        public String g;
        public String h;
        public Integer i;
        public Boolean j;
        public Condition k;
        public Integer l;
        public FromScene m;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new GetChatChattersRequest(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<GetChatChattersRequest> implements we6.c<GetChatChattersRequest> {
        @Override // com.lark.wire.ProtoAdapter
        public final GetChatChattersRequest c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L27;
            switch(r4) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L32;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L30;
                case 9: goto L11;
                case 10: goto L28;
                default: goto L6;
            };
        L28:
            r1.m = FromScene.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L30:
            r1.k = Condition.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L32:
            r1.f = Scene.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L11:
            r1.l = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L16:
            r1.j = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L17:
            r1.i = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L24:
            r1.e = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L25:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r8 = r10.i();
            Intrinsics.checkNotNullParameter(r8, "chat_id");
            r1.d = r8;
            goto L3
        L6:
            r10.j(r4);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L27:
            return new GetChatChattersRequest(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(GetChatChattersRequest r7) {
            GetChatChattersRequest r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = r0 + r1.l(1, r8.getChat_id());
            l r3 = ProtoAdapter.g;
            int r4 = (((r2 + r3.l(2, r8.is_from_server())) + Scene.ADAPTER.l(3, r8.getScene())) + r1.l(4, r8.getFilter())) + r1.l(5, r8.getCursor());
            s r5 = ProtoAdapter.h;
            return ((((r4 + r5.l(6, r8.getLimit())) + r3.l(7, r8.is_full_data())) + Condition.ADAPTER.l(8, r8.getCondition())) + r5.l(9, r8.getOffset())) + FromScene.ADAPTER.l(10, r8.getFrom_scene());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, GetChatChattersRequest r7) {
            GetChatChattersRequest r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getChat_id());
            l r1 = ProtoAdapter.g;
            r1.i(r6, 2, r8.is_from_server());
            Scene.ADAPTER.i(r6, 3, r8.getScene());
            r0.i(r6, 4, r8.getFilter());
            r0.i(r6, 5, r8.getCursor());
            s r2 = ProtoAdapter.h;
            r2.i(r6, 6, r8.getLimit());
            r1.i(r6, 7, r8.is_full_data());
            Condition.ADAPTER.i(r6, 8, r8.getCondition());
            r2.i(r6, 9, r8.getOffset());
            FromScene.ADAPTER.i(r6, 10, r8.getFrom_scene());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, GetChatChattersRequest r7) {
            GetChatChattersRequest r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            FromScene.ADAPTER.j(r6, 10, r8.getFrom_scene());
            s r0 = ProtoAdapter.h;
            r0.j(r6, 9, r8.getOffset());
            Condition.ADAPTER.j(r6, 8, r8.getCondition());
            l r1 = ProtoAdapter.g;
            r1.j(r6, 7, r8.is_full_data());
            r0.j(r6, 6, r8.getLimit());
            w r2 = ProtoAdapter.q;
            r2.j(r6, 5, r8.getCursor());
            r2.j(r6, 4, r8.getFilter());
            Scene.ADAPTER.j(r6, 3, r8.getScene());
            r1.j(r6, 2, r8.is_from_server());
            r2.j(r6, 1, r8.getChat_id());
        }

        public b(FieldEncoding r7, KClass<GetChatChattersRequest> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.GetChatChattersRequest", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ GetChatChattersRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_SCENE = Scene.CHAT_MEMBER;
        DEFAULT_CONDITION = Condition.NoLimit;
        DEFAULT_FROM_SCENE = FromScene.UnknownScene;
        b r3 = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GetChatChattersRequest.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.GetChatChattersRequest>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.chat_id;
        r0.e = this.is_from_server;
        r0.f = this.scene;
        r0.g = this.filter;
        r0.h = this.cursor;
        r0.i = this.limit;
        r0.j = this.is_full_data;
        r0.k = this.condition;
        r0.l = this.offset;
        r0.m = this.from_scene;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(GetChatChattersRequest.class).getSimpleName() + '@' + hashCode();
    }

    public final String getChat_id() {
        return this.chat_id;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final FromScene getFrom_scene() {
        return this.from_scene;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final Boolean is_from_server() {
        return this.is_from_server;
    }

    public final Boolean is_full_data() {
        return this.is_full_data;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public GetChatChattersRequest(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.chat_id = r4;
        this.is_from_server = r2.e;
        this.scene = r2.f;
        this.filter = r2.g;
        this.cursor = r2.h;
        this.limit = r2.i;
        this.is_full_data = r2.j;
        this.condition = r2.k;
        this.offset = r2.l;
        this.from_scene = r2.m;
    }

    public /* synthetic */ GetChatChattersRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
