package com.lark.kmp.pb.openplatform.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/openplatform/v1/AppInfoItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/openplatform/v1/AppInfoItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/openplatform/v1/AppInfoItem$Builder;Lokio/ByteString;)V", "app_id", "", "getApp_id", "()J", "name", "", "getName", "()Ljava/lang/String;", "is_agent", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "avatar_url", "getAvatar_url", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AppInfoItem extends Message<AppInfoItem, a> {
    public static final ProtoAdapter<AppInfoItem> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final long app_id;
    private final String avatar_url;
    private final Boolean is_agent;
    private final String name;

    public static final class a extends Message.a<AppInfoItem, a> {
        public Long d;
        public String e;
        public Boolean f;
        public String g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new AppInfoItem(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<AppInfoItem> {
        @Override // com.lark.wire.ProtoAdapter
        public final AppInfoItem c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            r1.d = Long.valueOf(((Number) ProtoAdapter.k.c(r7)).longValue());
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "name");
            r1.e = r5;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Boolean) ProtoAdapter.g.c(r7);
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
            return new AppInfoItem(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AppInfoItem r6) {
            AppInfoItem r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + ProtoAdapter.k.l(1, Long.valueOf(r7.getApp_id()));
            w r1 = ProtoAdapter.q;
            return ((r0 + r1.l(2, r7.getName())) + ProtoAdapter.g.l(3, r7.is_agent())) + r1.l(4, r7.getAvatar_url());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, AppInfoItem r6) {
            AppInfoItem r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            ProtoAdapter.k.i(r5, 1, Long.valueOf(r7.getApp_id()));
            w r0 = ProtoAdapter.q;
            r0.i(r5, 2, r7.getName());
            ProtoAdapter.g.i(r5, 3, r7.is_agent());
            r0.i(r5, 4, r7.getAvatar_url());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, AppInfoItem r6) {
            AppInfoItem r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 4, r7.getAvatar_url());
            ProtoAdapter.g.j(r5, 3, r7.is_agent());
            r0.j(r5, 2, r7.getName());
            ProtoAdapter.k.j(r5, 1, Long.valueOf(r7.getApp_id()));
        }

        public b(FieldEncoding r7, KClass<AppInfoItem> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/openplatform.v1.AppInfoItem", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AppInfoItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AppInfoItem.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = Long.valueOf(this.app_id);
        r0.e = this.name;
        r0.f = this.is_agent;
        r0.g = this.avatar_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AppInfoItem.class).getSimpleName() + '@' + hashCode();
    }

    public final long getApp_id() {
        return this.app_id;
    }

    public final String getAvatar_url() {
        return this.avatar_url;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean is_agent() {
        return this.is_agent;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public AppInfoItem(a r3, ByteString r4) {
        super(ADAPTER, r4);
        Long r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.app_id = r5.longValue();
        String r6 = r3.e;
        Intrinsics.checkNotNull(r6);
        this.name = r6;
        this.is_agent = r3.f;
        this.avatar_url = r3.g;
    }

    public /* synthetic */ AppInfoItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
