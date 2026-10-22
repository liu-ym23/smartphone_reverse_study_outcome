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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EntitySchema;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EntitySchema$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EntitySchema$Builder;Lokio/ByteString;)V", "unique_name", "", "getUnique_name", "()Ljava/lang/String;", "ui_level", "Lcom/lark/kmp/pb/calendar/v1/EntitySchema$ItemUILevel;", "getUi_level", "()Lcom/lark/kmp/pb/calendar/v1/EntitySchema$ItemUILevel;", "app_link", "getApp_link", "incompatible_level", "Lcom/lark/kmp/pb/calendar/v1/IncompatibleLevel;", "getIncompatible_level", "()Lcom/lark/kmp/pb/calendar/v1/IncompatibleLevel;", "newBuilder", "toString", "Builder", "Companion", "ItemUILevel", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EntitySchema extends Message<EntitySchema, a> {
    public static final ProtoAdapter<EntitySchema> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String app_link;
    private final IncompatibleLevel incompatible_level;
    private final ItemUILevel ui_level;
    private final String unique_name;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EntitySchema$ItemUILevel;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HIDE", "READONLY", "EDITABLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ItemUILevel extends Enum<ItemUILevel> implements o0 {
        public static final ProtoAdapter<ItemUILevel> ADAPTER = null;
        public static final b Companion = null;
        public static final ItemUILevel EDITABLE = null;
        public static final ItemUILevel HIDE = null;
        public static final ItemUILevel READONLY = null;
        public static final /* synthetic */ ItemUILevel[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ItemUILevel> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ItemUILevel.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return ItemUILevel.EDITABLE;
            L15:
                return ItemUILevel.READONLY;
            L12:
                return ItemUILevel.HIDE;
            }

            public a(KClass<ItemUILevel> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ItemUILevel> getEntries() {
            return b;
        }

        static {
            ItemUILevel r0 = new ItemUILevel("HIDE", 0, 1);
            HIDE = r0;
            ItemUILevel r1 = new ItemUILevel("READONLY", 1, 2);
            READONLY = r1;
            ItemUILevel r4 = new ItemUILevel("EDITABLE", 2, 3);
            EDITABLE = r4;
            ItemUILevel[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ItemUILevel.class), Syntax.PROTO_2);
        }

        public static ItemUILevel[] values() {
            return (ItemUILevel[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ItemUILevel fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return EDITABLE;
        L15:
            return READONLY;
        L12:
            return HIDE;
        }

        public static ItemUILevel valueOf(String r1) {
            return (ItemUILevel) r27.a.a(ItemUILevel.class, r1);
        }

        public ItemUILevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<EntitySchema, a> {
        public String d;
        public ItemUILevel e;
        public String f;
        public IncompatibleLevel g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new EntitySchema(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EntitySchema> {
        @Override // com.lark.wire.ProtoAdapter
        public final EntitySchema c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L25;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = ItemUILevel.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
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
            if (r4 != 4) goto L13;
            r1.g = IncompatibleLevel.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L13:
            r10.j(r4);
            goto L3
        L25:
            return new EntitySchema(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EntitySchema r6) {
            EntitySchema r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((r0 + r1.l(1, r7.getUnique_name())) + ItemUILevel.ADAPTER.l(2, r7.getUi_level())) + r1.l(3, r7.getApp_link())) + IncompatibleLevel.ADAPTER.l(4, r7.getIncompatible_level());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, EntitySchema r6) {
            EntitySchema r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getUnique_name());
            ItemUILevel.ADAPTER.i(r5, 2, r7.getUi_level());
            r0.i(r5, 3, r7.getApp_link());
            IncompatibleLevel.ADAPTER.i(r5, 4, r7.getIncompatible_level());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, EntitySchema r6) {
            EntitySchema r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            IncompatibleLevel.ADAPTER.j(r5, 4, r7.getIncompatible_level());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getApp_link());
            ItemUILevel.ADAPTER.j(r5, 2, r7.getUi_level());
            r0.j(r5, 1, r7.getUnique_name());
        }

        public b(FieldEncoding r7, KClass<EntitySchema> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.EntitySchema", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EntitySchema(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EntitySchema.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.unique_name;
        r0.e = this.ui_level;
        r0.f = this.app_link;
        r0.g = this.incompatible_level;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EntitySchema.class).getSimpleName() + '@' + hashCode();
    }

    public final String getApp_link() {
        return this.app_link;
    }

    public final IncompatibleLevel getIncompatible_level() {
        return this.incompatible_level;
    }

    public final ItemUILevel getUi_level() {
        return this.ui_level;
    }

    public final String getUnique_name() {
        return this.unique_name;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public EntitySchema(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.unique_name = r2.d;
        this.ui_level = r2.e;
        this.app_link = r2.f;
        this.incompatible_level = r2.g;
    }

    public /* synthetic */ EntitySchema(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
