package com.larus.suggest.impl.wcb.render;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements Function1<Message, Map<UpdateMessageLocalOption, ? extends String>> {
    public final /* synthetic */ ImSdkWcbRenderer a;

    public e(ImSdkWcbRenderer r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        Message r7 = (Message) r6;
        Intrinsics.checkNotNullParameter(r7, "message");
        Pair[] r0 = new Pair[1];
        UpdateMessageLocalOption r1 = UpdateMessageLocalOption.REPLACE_EXT;
        ImSdkWcbRenderer r2 = this.a;
        Map r8 = r7.getExt();
        if (r8 != null) goto L5;
        r8 = MapsKt.emptyMap();
    L5:
        Map r9 = MapsKt.toMutableMap(r8);
        r9.put("wcb_render_status", "DEPRECATED");
        Unit r3 = Unit.INSTANCE;
        r2.getClass();
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        kuc.a.f(r4);
        v2 r5 = v2.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r10 = zd9.i.c(r9, kuc.a.c(r5, r5));
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        r0[0] = TuplesKt.to(r1, r10);
        return MapsKt.mutableMapOf(r0);
    }
}
