package com.lark.kmp.server.pb.entities;

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
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u001e\u001f !\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/lark/kmp/server/pb/entities/AppFeedCardButton;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "multi_url", "Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$URL;", "getMulti_url", "()Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$URL;", "action_type", "Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$ActionType;", "getAction_type", "()Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$ActionType;", "text", "Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$Text;", "getText", "()Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$Text;", "button_type", "Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$ButtonType;", "getButton_type", "()Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$ButtonType;", "newBuilder", "toString", "Builder", "Companion", "Text", "URL", "ActionType", "ButtonType", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AppFeedCardButton extends Message<AppFeedCardButton, a> {
    public static final ProtoAdapter<AppFeedCardButton> ADAPTER = null;
    public static final c Companion = null;
    public static final ButtonType DEFAULT_BUTTON_TYPE = null;
    private static final long serialVersionUID = 0;
    private final ActionType action_type;
    private final ButtonType button_type;
    private final String id;
    private final URL multi_url;
    private final Text text;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$ActionType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "URL_PAGE", "WEBHOOK", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ActionType extends Enum<ActionType> implements o0 {
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final b Companion = null;
        public static final ActionType UNKNOWN = null;
        public static final ActionType URL_PAGE = null;
        public static final ActionType WEBHOOK = null;
        public static final /* synthetic */ ActionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ActionType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ActionType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return ActionType.WEBHOOK;
            L15:
                return ActionType.URL_PAGE;
            L12:
                return ActionType.UNKNOWN;
            }

            public a(KClass<ActionType> r1, Syntax r2, ActionType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ActionType> getEntries() {
            return b;
        }

        static {
            ActionType r0 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ActionType r1 = new ActionType("URL_PAGE", 1, 1);
            URL_PAGE = r1;
            ActionType r3 = new ActionType("WEBHOOK", 2, 2);
            WEBHOOK = r3;
            ActionType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ActionType.class), Syntax.PROTO_2, r0);
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ActionType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return WEBHOOK;
        L15:
            return URL_PAGE;
        L12:
            return UNKNOWN;
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$ButtonType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PRIMARY", "SUCCESS", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ButtonType extends Enum<ButtonType> implements o0 {
        public static final ProtoAdapter<ButtonType> ADAPTER = null;
        public static final b Companion = null;
        public static final ButtonType DEFAULT = null;
        public static final ButtonType PRIMARY = null;
        public static final ButtonType SUCCESS = null;
        public static final /* synthetic */ ButtonType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ButtonType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ButtonType.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return ButtonType.SUCCESS;
            L15:
                return ButtonType.PRIMARY;
            L12:
                return ButtonType.DEFAULT;
            }

            public a(KClass<ButtonType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ButtonType> getEntries() {
            return b;
        }

        static {
            ButtonType r0 = new ButtonType("DEFAULT", 0, 1);
            DEFAULT = r0;
            ButtonType r1 = new ButtonType("PRIMARY", 1, 2);
            PRIMARY = r1;
            ButtonType r4 = new ButtonType("SUCCESS", 2, 3);
            SUCCESS = r4;
            ButtonType[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ButtonType.class), Syntax.PROTO_2);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ButtonType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return SUCCESS;
        L15:
            return PRIMARY;
        L12:
            return DEFAULT;
        }

        public static ButtonType valueOf(String r1) {
            return (ButtonType) r27.a.a(ButtonType.class, r1);
        }

        public ButtonType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$Text;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$Text$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$Text$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "i18nContent", "", "getI18nContent", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Text extends Message<Text, a> {
        public static final ProtoAdapter<Text> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String content;
        private final Map<String, String> i18nContent;

        public static final class a extends Message.a<Text, a> {
            public String d;
            public Map<String, String> e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new Text(this, c(), null);
            }

            public a() {
                this.e = MapsKt.emptyMap();
            }
        }

        public static final class b extends ProtoAdapter<Text> {
            public final Lazy v;

            @Override // com.lark.wire.ProtoAdapter
            public final Text c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                LinkedHashMap r2 = new LinkedHashMap();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L12;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                String r6 = r8.i();
                Intrinsics.checkNotNullParameter(r6, "content");
                r1.d = r6;
                goto L3
            L8:
                if (r5 != 2) goto L9;
                r2.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r8));
                goto L3
            L9:
                r8.j(r5);
                goto L3
            L12:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "i18nContent");
                r1.e = r2;
                return new Text(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Text r5) {
                Text r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getContent())) + ((ProtoAdapter) this.v.getValue()).l(2, r6.getI18nContent());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Text r5) {
                Text r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getContent());
                ((ProtoAdapter) this.v.getValue()).i(r4, 2, r6.getI18nContent());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Text r5) {
                Text r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ((ProtoAdapter) this.v.getValue()).j(r4, 2, r6.getI18nContent());
                ProtoAdapter.q.j(r4, 1, r6.getContent());
            }

            public b(FieldEncoding r7, KClass<Text> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/entities.AppFeedCardButton.Text", r9, null);
                this.v = LazyKt.lazy(new ky7.a());
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Text(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Text.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.content;
            r0.e = this.i18nContent;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Text.class).getSimpleName() + "@" + hashCode();
        }

        public final String getContent() {
            return this.content;
        }

        public final Map<String, String> getI18nContent() {
            return this.i18nContent;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public Text(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.content = r4;
            this.i18nContent = com.lark.wire.internal.a.d("i18nContent", r2.e);
        }

        public /* synthetic */ Text(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$URL;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$URL$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/AppFeedCardButton$URL$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "android_url", "getAndroid_url", "ios_url", "getIos_url", "pc_url", "getPc_url", "newBuilder", "toString", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class URL extends Message<URL, a> {
        public static final ProtoAdapter<URL> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String android_url;
        private final String ios_url;
        private final String pc_url;
        private final String url;

        public static final class a extends Message.a<URL, a> {
            public String d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new URL(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<URL> {
            @Override // com.lark.wire.ProtoAdapter
            public final URL c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                String r5 = r7.i();
                Intrinsics.checkNotNullParameter(r5, "url");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L19:
                return new URL(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(URL r5) {
                URL r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getAndroid_url())) + r1.l(3, r6.getIos_url())) + r1.l(4, r6.getPc_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, URL r5) {
                URL r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUrl());
                r0.i(r4, 2, r6.getAndroid_url());
                r0.i(r4, 3, r6.getIos_url());
                r0.i(r4, 4, r6.getPc_url());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, URL r5) {
                URL r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getPc_url());
                r0.j(r4, 3, r6.getIos_url());
                r0.j(r4, 2, r6.getAndroid_url());
                r0.j(r4, 1, r6.getUrl());
            }

            public b(FieldEncoding r7, KClass<URL> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/entities.AppFeedCardButton.URL", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ URL(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(URL.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.url;
            r0.e = this.android_url;
            r0.f = this.ios_url;
            r0.g = this.pc_url;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(URL.class).getSimpleName() + "@" + hashCode();
        }

        public final String getAndroid_url() {
            return this.android_url;
        }

        public final String getIos_url() {
            return this.ios_url;
        }

        public final String getPc_url() {
            return this.pc_url;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public URL(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.url = r4;
            this.android_url = r2.e;
            this.ios_url = r2.f;
            this.pc_url = r2.g;
        }

        public /* synthetic */ URL(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<AppFeedCardButton, a> {
        public String d;
        public URL e;
        public ActionType f;
        public Text g;
        public ButtonType h;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new AppFeedCardButton(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<AppFeedCardButton> {
        @Override // com.lark.wire.ProtoAdapter
        public final AppFeedCardButton c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L28;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = URL.ADAPTER.c(r10);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = ActionType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r1.g = Text.ADAPTER.c(r10);
            goto L3
        L14:
            if (r4 != 5) goto L15;
            r1.h = ButtonType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L15:
            r10.j(r4);
            goto L3
        L28:
            return new AppFeedCardButton(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AppFeedCardButton r5) {
            AppFeedCardButton r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getId())) + URL.ADAPTER.l(2, r6.getMulti_url())) + ActionType.ADAPTER.l(3, r6.getAction_type())) + Text.ADAPTER.l(4, r6.getText())) + ButtonType.ADAPTER.l(5, r6.getButton_type());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, AppFeedCardButton r5) {
            AppFeedCardButton r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getId());
            URL.ADAPTER.i(r4, 2, r6.getMulti_url());
            ActionType.ADAPTER.i(r4, 3, r6.getAction_type());
            Text.ADAPTER.i(r4, 4, r6.getText());
            ButtonType.ADAPTER.i(r4, 5, r6.getButton_type());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, AppFeedCardButton r5) {
            AppFeedCardButton r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ButtonType.ADAPTER.j(r4, 5, r6.getButton_type());
            Text.ADAPTER.j(r4, 4, r6.getText());
            ActionType.ADAPTER.j(r4, 3, r6.getAction_type());
            URL.ADAPTER.j(r4, 2, r6.getMulti_url());
            ProtoAdapter.q.j(r4, 1, r6.getId());
        }

        public b(FieldEncoding r7, KClass<AppFeedCardButton> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.AppFeedCardButton", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AppFeedCardButton(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_BUTTON_TYPE = ButtonType.DEFAULT;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AppFeedCardButton.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.multi_url;
        r0.f = this.action_type;
        r0.g = this.text;
        r0.h = this.button_type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AppFeedCardButton.class).getSimpleName() + "@" + hashCode();
    }

    public final ActionType getAction_type() {
        return this.action_type;
    }

    public final ButtonType getButton_type() {
        return this.button_type;
    }

    public final String getId() {
        return this.id;
    }

    public final URL getMulti_url() {
        return this.multi_url;
    }

    public final Text getText() {
        return this.text;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public AppFeedCardButton(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.multi_url = r2.e;
        this.action_type = r2.f;
        this.text = r2.g;
        this.button_type = r2.h;
    }

    public /* synthetic */ AppFeedCardButton(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
