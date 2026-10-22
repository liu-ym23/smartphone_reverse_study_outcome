package com.lark.kmp.pb.im.v1;

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
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MGetChatsResponse$Companion$ADAPTER$1 extends ProtoAdapter<MGetChatsResponse> implements c<MGetChatsResponse> {
    public final Lazy v;

    @Override // com.lark.wire.ProtoAdapter
    public final MGetChatsResponse c(g0 r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        MGetChatsResponse.a r0 = new MGetChatsResponse.a();
        LinkedHashMap r1 = new LinkedHashMap();
        long r2 = r7.c();
    L3:
        int r4 = r7.e();
        if (r4 == (-1)) goto L12;
        if (r4 != 1) goto L8;
        r0.d = Entity.ADAPTER.c(r7);
        goto L3
    L8:
        if (r4 != 2) goto L9;
        r1.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r7));
        goto L3
    L9:
        r7.j(r4);
        goto L3
    L12:
        ByteString r8 = r7.d(r2);
        Intrinsics.checkNotNullParameter(r1, "chat_option_info");
        r0.e = r1;
        return new MGetChatsResponse(r0, r8, null);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(MGetChatsResponse r5) {
        MGetChatsResponse r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        return (r6.unknownFields().size() + Entity.ADAPTER.l(1, r6.getEntity())) + ((ProtoAdapter) this.v.getValue()).l(2, r6.getChat_option_info());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r4, MGetChatsResponse r5) {
        MGetChatsResponse r6 = r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        Entity.ADAPTER.i(r4, 1, r6.getEntity());
        ((ProtoAdapter) this.v.getValue()).i(r4, 2, r6.getChat_option_info());
        r4.a(r6.unknownFields());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r4, MGetChatsResponse r5) {
        MGetChatsResponse r6 = r5;
        Intrinsics.checkNotNullParameter(r4, "writer");
        Intrinsics.checkNotNullParameter(r6, "value");
        r4.d(r6.unknownFields());
        ((ProtoAdapter) this.v.getValue()).j(r4, 2, r6.getChat_option_info());
        Entity.ADAPTER.j(r4, 1, r6.getEntity());
    }

    public MGetChatsResponse$Companion$ADAPTER$1(FieldEncoding r7, KClass<MGetChatsResponse> r8, Syntax r9) {
        super(r7, r8, "type.googleapis.com/im.v1.MGetChatsResponse", r9, null);
        this.v = LazyKt.lazy(MGetChatsResponse$Companion$ADAPTER$1$chat_option_infoAdapter$2.INSTANCE);
    }
}
