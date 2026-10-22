package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.protocol.model.BotActionScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements t0 {
    public final String a;
    public final t0 b;
    public final List<String> c;

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        ArrayList r0 = (ArrayList) this.c;
        r0.addAll(r2);
    }

    public f(String r2, t0 r3) {
        Intrinsics.checkNotNullParameter(r3, "fallbackCreator");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r12, Message r13, Function0<Message> r14, com.larus.bmhome.chat.api.q0 r15, BotModel r16, wc9.e r17, com.larus.bmhome.chat.api.q0.a r18, JSONObject r19) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r16, "chatBot");
        String r1 = this.a;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L29;
        List r3 = r16.getActionScenes();
        BotActionScene r4 = null;
        Object r5 = null;
        if (r3 == null) goto L19;
        Iterator r6 = r3.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((BotActionScene) r7).getScene(), this.a) == false) goto L14;
        r5 = r7;
    L18:
        r4 = (BotActionScene) r5;
    L19:
        if (r4 == null) goto L29;
        List r8 = r4.getActionList();
        if (r8 != null) goto L24;
        r8 = CollectionsKt.emptyList();
    L24:
        if (r8.isEmpty() == true) goto L26;
        m0 r9 = new m0(this.a);
        r9.b(this.c);
        return r9.a(r12, r13, r14, r15, r16, r17, r18, r19);
    L26:
        return CollectionsKt.emptyList();
    L29:
        t0 r10 = this.b;
        r10.b(this.c);
        return r10.a(r12, r13, r14, r15, r16, r17, r18, r19);
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }
}
