package com.lark.kmp.pb.vote.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/vote/v1/VoteOption;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/vote/v1/VoteOption$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/vote/v1/VoteOption$Builder;Lokio/ByteString;)V", "index", "", "getIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "content", "", "getContent", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/vote/v1/VoteOption$Type;", "getType", "()Lcom/lark/kmp/pb/vote/v1/VoteOption$Type;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VoteOption extends Message<VoteOption, a> {
    public static final ProtoAdapter<VoteOption> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String content;
    private final Integer index;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/vote/v1/VoteOption$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TEXT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type TEXT = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return Type.TEXT;
            L9:
                return Type.UNKNOWN;
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("TEXT", 1, 1);
            TEXT = r1;
            Type[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return TEXT;
        L9:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<VoteOption, a> {
        public Integer d;
        public String e;
        public Type f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new VoteOption(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<VoteOption> {
        @Override // com.lark.wire.ProtoAdapter
        public final VoteOption c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            r1.d = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.f = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L11:
            r10.j(r4);
            goto L3
        L19:
            return new VoteOption(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VoteOption r5) {
            VoteOption r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.h.l(1, r6.getIndex())) + ProtoAdapter.q.l(2, r6.getContent())) + Type.ADAPTER.l(3, r6.getType());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, VoteOption r5) {
            VoteOption r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.h.i(r4, 1, r6.getIndex());
            ProtoAdapter.q.i(r4, 2, r6.getContent());
            Type.ADAPTER.i(r4, 3, r6.getType());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, VoteOption r5) {
            VoteOption r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Type.ADAPTER.j(r4, 3, r6.getType());
            ProtoAdapter.q.j(r4, 2, r6.getContent());
            ProtoAdapter.h.j(r4, 1, r6.getIndex());
        }

        public b(FieldEncoding r7, KClass<VoteOption> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/vote.v1.VoteOption", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VoteOption(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VoteOption.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.index;
        r0.e = this.content;
        r0.f = this.type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VoteOption.class).getSimpleName() + '@' + hashCode();
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public VoteOption(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.index = r2.d;
        this.content = r2.e;
        this.type = r2.f;
    }

    public /* synthetic */ VoteOption(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
