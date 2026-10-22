package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.internal.a;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.w;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class GetChatChattersResponse$Companion$ADAPTER$1 extends ProtoAdapter<GetChatChattersResponse> implements c<GetChatChattersResponse> {
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;

    @Override // com.lark.wire.ProtoAdapter
    public final GetChatChattersResponse c(g0 r13) {
        Intrinsics.checkNotNullParameter(r13, "reader");
        GetChatChattersResponse.a r1 = new GetChatChattersResponse.a();
        LinkedHashMap r2 = new LinkedHashMap();
        ArrayList r3 = new ArrayList();
        LinkedHashMap r4 = new LinkedHashMap();
        ArrayList r5 = new ArrayList();
        LinkedHashMap r6 = new LinkedHashMap();
        LinkedHashMap r7 = new LinkedHashMap();
        long r8 = r13.c();
    L3:
        int r10 = r13.e();
        if (r10 == (-1)) goto L18;
        switch(r10) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        r1.n = (Boolean) ProtoAdapter.g.c(r13);
        goto L3
    L8:
        r7.putAll((Map) ((ProtoAdapter) this.y.getValue()).c(r13));
        goto L3
    L9:
        r6.putAll((Map) ((ProtoAdapter) this.x.getValue()).c(r13));
        goto L3
    L10:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r13, "reader");
        r5.add(r13.i());
        goto L3
    L11:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r13, "reader");
        r1.j = r13.i();
        goto L3
    L12:
        r1.i = (Integer) ProtoAdapter.h.c(r13);
        goto L3
    L13:
        r1.h = (Boolean) ProtoAdapter.g.c(r13);
        goto L3
    L14:
        r4.putAll((Map) ((ProtoAdapter) this.w.getValue()).c(r13));
        goto L3
    L15:
        r3.add(GetChatChattersResponse.LetterMap.ADAPTER.c(r13));
        goto L3
    L16:
        r1.e = Entity.ADAPTER.c(r13);
        goto L3
    L17:
        r2.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r13));
        goto L3
    L6:
        r13.j(r10);
        goto L3
    L18:
        ByteString r14 = r13.d(r8);
        Intrinsics.checkNotNullParameter(r2, "ordered_weight");
        r1.d = r2;
        Intrinsics.checkNotNullParameter(r3, "letter_maps");
        a.a(r3);
        r1.f = r3;
        Intrinsics.checkNotNullParameter(r4, "nicknames");
        r1.g = r4;
        Intrinsics.checkNotNullParameter(r5, "chatter_ids");
        a.a(r5);
        r1.k = r5;
        Intrinsics.checkNotNullParameter(r6, "chatter_id2department_name");
        r1.l = r6;
        Intrinsics.checkNotNullParameter(r7, "tag_infos");
        r1.m = r7;
        return new GetChatChattersResponse(r1, r14, null);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(GetChatChattersResponse r6) {
        GetChatChattersResponse r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "value");
        int r0 = (((r7.unknownFields().size() + ((ProtoAdapter) this.v.getValue()).l(1, r7.getOrdered_weight())) + Entity.ADAPTER.l(2, r7.getEntity())) + GetChatChattersResponse.LetterMap.ADAPTER.a().l(3, r7.getLetter_maps())) + ((ProtoAdapter) this.w.getValue()).l(4, r7.getNicknames());
        l r1 = ProtoAdapter.g;
        int r2 = (r0 + r1.l(5, r7.getShow_search())) + ProtoAdapter.h.l(6, r7.getMember_count());
        w r3 = ProtoAdapter.q;
        return ((((r2 + r3.l(7, r7.getCursor())) + r3.a().l(8, r7.getChatter_ids())) + ((ProtoAdapter) this.x.getValue()).l(9, r7.getChatter_id2department_name())) + ((ProtoAdapter) this.y.getValue()).l(10, r7.getTag_infos())) + r1.l(11, r7.getNeed_display_department());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r5, GetChatChattersResponse r6) {
        GetChatChattersResponse r7 = r6;
        Intrinsics.checkNotNullParameter(r5, "writer");
        Intrinsics.checkNotNullParameter(r7, "value");
        ((ProtoAdapter) this.v.getValue()).i(r5, 1, r7.getOrdered_weight());
        Entity.ADAPTER.i(r5, 2, r7.getEntity());
        GetChatChattersResponse.LetterMap.ADAPTER.a().i(r5, 3, r7.getLetter_maps());
        ((ProtoAdapter) this.w.getValue()).i(r5, 4, r7.getNicknames());
        l r0 = ProtoAdapter.g;
        r0.i(r5, 5, r7.getShow_search());
        ProtoAdapter.h.i(r5, 6, r7.getMember_count());
        w r1 = ProtoAdapter.q;
        r1.i(r5, 7, r7.getCursor());
        r1.a().i(r5, 8, r7.getChatter_ids());
        ((ProtoAdapter) this.x.getValue()).i(r5, 9, r7.getChatter_id2department_name());
        ((ProtoAdapter) this.y.getValue()).i(r5, 10, r7.getTag_infos());
        r0.i(r5, 11, r7.getNeed_display_department());
        r5.a(r7.unknownFields());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r6, GetChatChattersResponse r7) {
        GetChatChattersResponse r8 = r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r8, "value");
        r6.d(r8.unknownFields());
        l r0 = ProtoAdapter.g;
        r0.j(r6, 11, r8.getNeed_display_department());
        ((ProtoAdapter) this.y.getValue()).j(r6, 10, r8.getTag_infos());
        ((ProtoAdapter) this.x.getValue()).j(r6, 9, r8.getChatter_id2department_name());
        w r1 = ProtoAdapter.q;
        r1.a().j(r6, 8, r8.getChatter_ids());
        r1.j(r6, 7, r8.getCursor());
        ProtoAdapter.h.j(r6, 6, r8.getMember_count());
        r0.j(r6, 5, r8.getShow_search());
        ((ProtoAdapter) this.w.getValue()).j(r6, 4, r8.getNicknames());
        GetChatChattersResponse.LetterMap.ADAPTER.a().j(r6, 3, r8.getLetter_maps());
        Entity.ADAPTER.j(r6, 2, r8.getEntity());
        ((ProtoAdapter) this.v.getValue()).j(r6, 1, r8.getOrdered_weight());
    }

    public GetChatChattersResponse$Companion$ADAPTER$1(FieldEncoding r7, KClass<GetChatChattersResponse> r8, Syntax r9) {
        super(r7, r8, "type.googleapis.com/im.v1.GetChatChattersResponse", r9, null);
        this.v = LazyKt.lazy(GetChatChattersResponse$Companion$ADAPTER$1$ordered_weightAdapter$2.INSTANCE);
        this.w = LazyKt.lazy(GetChatChattersResponse$Companion$ADAPTER$1$nicknamesAdapter$2.INSTANCE);
        this.x = LazyKt.lazy(GetChatChattersResponse$Companion$ADAPTER$1$chatter_id2department_nameAdapter$2.INSTANCE);
        this.y = LazyKt.lazy(GetChatChattersResponse$Companion$ADAPTER$1$tag_infosAdapter$2.INSTANCE);
    }
}
