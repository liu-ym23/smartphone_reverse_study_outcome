package com.lark.kmp.pb.contact.v2;

import com.lark.kmp.pb.basic.v1.ActionType;
import com.lark.kmp.pb.basic.v1.SyncDataStrategy;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class GetAuthChattersRequest$Companion$ADAPTER$1 extends ProtoAdapter<GetAuthChattersRequest> implements c<GetAuthChattersRequest> {
    public final Lazy v;

    @Override // com.lark.wire.ProtoAdapter
    public final GetAuthChattersRequest c(g0 r10) {
        Intrinsics.checkNotNullParameter(r10, "reader");
        GetAuthChattersRequest.a r0 = new GetAuthChattersRequest.a();
        LinkedHashMap r1 = new LinkedHashMap();
        long r2 = r10.c();
    L3:
        int r4 = r10.e();
        if (r4 == (-1)) goto L21;
        if (r4 != 1) goto L8;
        ActionType r5 = ActionType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        Intrinsics.checkNotNullParameter(r5, "action_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        r0.d = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
    L19:
        e = move-exception;
        r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r6 = Unit.INSTANCE;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        r1.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r10));
        goto L3
    L10:
        if (r4 != 3) goto L11;
        r0.f = SyncDataStrategy.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
    L14:
        e = move-exception;
        r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r7 = Unit.INSTANCE;
        goto L3
    L11:
        r10.j(r4);
        goto L3
    L21:
        ByteString r11 = r10.d(r2);
        Intrinsics.checkNotNullParameter(r1, "chatters_auth_info");
        r0.e = r1;
        return new GetAuthChattersRequest(r0, r11, null);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(GetAuthChattersRequest r5) {
        GetAuthChattersRequest r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        return ((r6.unknownFields().size() + ActionType.ADAPTER.l(1, r6.getAction_type())) + ((ProtoAdapter) this.v.getValue()).l(2, r6.getChatters_auth_info())) + SyncDataStrategy.ADAPTER.l(3, r6.getSync_data_strategy());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r4, GetAuthChattersRequest r5) {
        GetAuthChattersRequest r6 = r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        ActionType.ADAPTER.i(r4, 1, r6.getAction_type());
        ((ProtoAdapter) this.v.getValue()).i(r4, 2, r6.getChatters_auth_info());
        SyncDataStrategy.ADAPTER.i(r4, 3, r6.getSync_data_strategy());
        r4.a(r6.unknownFields());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r4, GetAuthChattersRequest r5) {
        GetAuthChattersRequest r6 = r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        r4.d(r6.unknownFields());
        SyncDataStrategy.ADAPTER.j(r4, 3, r6.getSync_data_strategy());
        ((ProtoAdapter) this.v.getValue()).j(r4, 2, r6.getChatters_auth_info());
        ActionType.ADAPTER.j(r4, 1, r6.getAction_type());
    }

    public GetAuthChattersRequest$Companion$ADAPTER$1(FieldEncoding r7, KClass<GetAuthChattersRequest> r8, Syntax r9) {
        super(r7, r8, "type.googleapis.com/contact.v2.GetAuthChattersRequest", r9, null);
        this.v = LazyKt.lazy(GetAuthChattersRequest$Companion$ADAPTER$1$chatters_auth_infoAdapter$2.INSTANCE);
    }
}
