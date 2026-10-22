package com.lark.kmp.pb.im.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001b\u0010\u000bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001d\u0010\u000b¨\u0006\""}, d2 = {"Lcom/lark/kmp/pb/im/v1/UserGroupEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/UserGroupEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/UserGroupEntity$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "display_name", "", "getDisplay_name", "()Ljava/lang/String;", "description", "getDescription", "member_count", "", "getMember_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "status", "getStatus", "server_time", "getServer_time", "cache_time", "getCache_time", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UserGroupEntity extends Message<UserGroupEntity, a> {
    public static final ProtoAdapter<UserGroupEntity> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long cache_time;
    private final String description;
    private final String display_name;
    private final Long id;
    private final Integer member_count;
    private final Long server_time;
    private final Integer status;

    public static final class a extends Message.a<UserGroupEntity, a> {
        public Long d;
        public String e;
        public String f;
        public Integer g;
        public Integer h;
        public Long i;
        public Long j;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new UserGroupEntity(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<UserGroupEntity> {
        @Override // com.lark.wire.ProtoAdapter
        public final UserGroupEntity c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L15;
            switch(r4) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r1.j = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L8:
            r1.i = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L9:
            r1.h = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L10:
            r1.g = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L11:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.i();
            goto L3
        L13:
            r1.d = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L6:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L15:
            return new UserGroupEntity(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(UserGroupEntity r6) {
            UserGroupEntity r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            t r1 = ProtoAdapter.k;
            int r2 = r0 + r1.l(1, r7.getId());
            w r3 = ProtoAdapter.q;
            int r4 = (r2 + r3.l(2, r7.getDisplay_name())) + r3.l(3, r7.getDescription());
            s r5 = ProtoAdapter.h;
            return (((r4 + r5.l(4, r7.getMember_count())) + r5.l(5, r7.getStatus())) + r1.l(6, r7.getServer_time())) + r1.l(7, r7.getCache_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, UserGroupEntity r6) {
            UserGroupEntity r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r5, 1, r7.getId());
            w r1 = ProtoAdapter.q;
            r1.i(r5, 2, r7.getDisplay_name());
            r1.i(r5, 3, r7.getDescription());
            s r2 = ProtoAdapter.h;
            r2.i(r5, 4, r7.getMember_count());
            r2.i(r5, 5, r7.getStatus());
            r0.i(r5, 6, r7.getServer_time());
            r0.i(r5, 7, r7.getCache_time());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, UserGroupEntity r6) {
            UserGroupEntity r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r5, 7, r7.getCache_time());
            r0.j(r5, 6, r7.getServer_time());
            s r1 = ProtoAdapter.h;
            r1.j(r5, 5, r7.getStatus());
            r1.j(r5, 4, r7.getMember_count());
            w r2 = ProtoAdapter.q;
            r2.j(r5, 3, r7.getDescription());
            r2.j(r5, 2, r7.getDisplay_name());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<UserGroupEntity> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/im.v1.UserGroupEntity", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ UserGroupEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(UserGroupEntity.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.display_name;
        r0.f = this.description;
        r0.g = this.member_count;
        r0.h = this.status;
        r0.i = this.server_time;
        r0.j = this.cache_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(UserGroupEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getCache_time() {
        return this.cache_time;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final Long getId() {
        return this.id;
    }

    public final Integer getMember_count() {
        return this.member_count;
    }

    public final Long getServer_time() {
        return this.server_time;
    }

    public final Integer getStatus() {
        return this.status;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public UserGroupEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.id = r2.d;
        this.display_name = r2.e;
        this.description = r2.f;
        this.member_count = r2.g;
        this.status = r2.h;
        this.server_time = r2.i;
        this.cache_time = r2.j;
    }

    public /* synthetic */ UserGroupEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
