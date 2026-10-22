package com.lark.kmp.pb.todo.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/CustomComplete;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/todo/v1/CustomComplete$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/todo/v1/CustomComplete$Builder;Lokio/ByteString;)V", "android", "Lcom/lark/kmp/pb/todo/v1/CustomComplete$Action;", "getAndroid", "()Lcom/lark/kmp/pb/todo/v1/CustomComplete$Action;", "ios", "getIos", "pc", "getPc", "newBuilder", "toString", "", "Builder", "Companion", "Action", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CustomComplete extends Message<CustomComplete, a> {
    public static final ProtoAdapter<CustomComplete> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Action android;
    private final Action ios;
    private final Action pc;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/CustomComplete$Action;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/todo/v1/CustomComplete$Action$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/todo/v1/CustomComplete$Action$Builder;Lokio/ByteString;)V", "href", "", "getHref", "()Ljava/lang/String;", "tip", "", "getTip", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Action extends Message<Action, a> {
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final String href;
        private final Map<String, String> tip;

        public static final class a extends Message.a<Action, a> {
            public String d;
            public Map<String, String> e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new Action(this, c(), null);
            }

            public a() {
                this.e = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ Action(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(Action.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new CustomComplete$Action$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.href;
            r0.e = this.tip;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Action.class).getSimpleName() + '@' + hashCode();
        }

        public final String getHref() {
            return this.href;
        }

        public final Map<String, String> getTip() {
            return this.tip;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public Action(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.href = r2.d;
            this.tip = com.lark.wire.internal.a.d("tip", r2.e);
        }

        public /* synthetic */ Action(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<CustomComplete, a> {
        public Action d;
        public Action e;
        public Action f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CustomComplete(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CustomComplete> {
        @Override // com.lark.wire.ProtoAdapter
        public final CustomComplete c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L8;
            r0.d = Action.ADAPTER.c(r6);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = Action.ADAPTER.c(r6);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.f = Action.ADAPTER.c(r6);
            goto L3
        L11:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L16:
            return new CustomComplete(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CustomComplete r5) {
            CustomComplete r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            ProtoAdapter<Action> r1 = Action.ADAPTER;
            return ((r0 + r1.l(1, r6.getAndroid())) + r1.l(2, r6.getIos())) + r1.l(3, r6.getPc());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CustomComplete r5) {
            CustomComplete r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter<Action> r0 = Action.ADAPTER;
            r0.i(r4, 1, r6.getAndroid());
            r0.i(r4, 2, r6.getIos());
            r0.i(r4, 3, r6.getPc());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CustomComplete r5) {
            CustomComplete r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter<Action> r0 = Action.ADAPTER;
            r0.j(r4, 3, r6.getPc());
            r0.j(r4, 2, r6.getIos());
            r0.j(r4, 1, r6.getAndroid());
        }

        public b(FieldEncoding r7, KClass<CustomComplete> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/todo.v1.CustomComplete", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CustomComplete(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CustomComplete.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.android;
        r0.e = this.ios;
        r0.f = this.pc;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CustomComplete.class).getSimpleName() + '@' + hashCode();
    }

    public final Action getAndroid() {
        return this.android;
    }

    public final Action getIos() {
        return this.ios;
    }

    public final Action getPc() {
        return this.pc;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CustomComplete(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.android = r2.d;
        this.ios = r2.e;
        this.pc = r2.f;
    }

    public /* synthetic */ CustomComplete(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
