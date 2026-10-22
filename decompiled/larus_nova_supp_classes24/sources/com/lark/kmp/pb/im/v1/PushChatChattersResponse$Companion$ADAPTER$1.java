package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Entity;
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
public final class PushChatChattersResponse$Companion$ADAPTER$1 extends ProtoAdapter<PushChatChattersResponse> implements c<PushChatChattersResponse> {
    public final Lazy v;

    @Override // com.lark.wire.ProtoAdapter
    public final PushChatChattersResponse c(g0 r11) {
        Intrinsics.checkNotNullParameter(r11, "reader");
        PushChatChattersResponse.a r1 = new PushChatChattersResponse.a();
        LinkedHashMap r2 = new LinkedHashMap();
        long r3 = r11.c();
    L3:
        int r5 = r11.e();
        if (r5 == (-1)) goto L24;
        if (r5 != 1) goto L8;
        PushChatChattersResponse.Type r6 = PushChatChattersResponse.Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        r1.d = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
    L22:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r7 = Unit.INSTANCE;
        goto L3
    L8:
        if (r5 != 2) goto L10;
        r1.e = Chat.ADAPTER.c(r11);
        goto L3
    L10:
        if (r5 != 5) goto L12;
        r2.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r11));
        goto L3
    L12:
        if (r5 != 6) goto L14;
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.g = r11.i();
        goto L3
    L14:
        if (r5 != 7) goto L15;
        r1.h = Entity.ADAPTER.c(r11);
        goto L3
    L15:
        r11.j(r5);
        goto L3
    L24:
        ByteString r12 = r11.d(r3);
        Intrinsics.checkNotNullParameter(r2, "ordered_weight");
        r1.f = r2;
        return new PushChatChattersResponse(r1, r12, null);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(PushChatChattersResponse r5) {
        PushChatChattersResponse r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        return ((((r6.unknownFields().size() + PushChatChattersResponse.Type.ADAPTER.l(1, r6.getType())) + Chat.ADAPTER.l(2, r6.getChat())) + ((ProtoAdapter) this.v.getValue()).l(5, r6.getOrdered_weight())) + ProtoAdapter.q.l(6, r6.getOperator_id())) + Entity.ADAPTER.l(7, r6.getEntity());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r4, PushChatChattersResponse r5) {
        PushChatChattersResponse r6 = r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        PushChatChattersResponse.Type.ADAPTER.i(r4, 1, r6.getType());
        Chat.ADAPTER.i(r4, 2, r6.getChat());
        ((ProtoAdapter) this.v.getValue()).i(r4, 5, r6.getOrdered_weight());
        ProtoAdapter.q.i(r4, 6, r6.getOperator_id());
        Entity.ADAPTER.i(r4, 7, r6.getEntity());
        r4.a(r6.unknownFields());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r4, PushChatChattersResponse r5) {
        PushChatChattersResponse r6 = r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        r4.d(r6.unknownFields());
        Entity.ADAPTER.j(r4, 7, r6.getEntity());
        ProtoAdapter.q.j(r4, 6, r6.getOperator_id());
        ((ProtoAdapter) this.v.getValue()).j(r4, 5, r6.getOrdered_weight());
        Chat.ADAPTER.j(r4, 2, r6.getChat());
        PushChatChattersResponse.Type.ADAPTER.j(r4, 1, r6.getType());
    }

    public PushChatChattersResponse$Companion$ADAPTER$1(FieldEncoding r7, KClass<PushChatChattersResponse> r8, Syntax r9) {
        super(r7, r8, "type.googleapis.com/im.v1.PushChatChattersResponse", r9, null);
        this.v = LazyKt.lazy(PushChatChattersResponse$Companion$ADAPTER$1$ordered_weightAdapter$2.INSTANCE);
    }
}
