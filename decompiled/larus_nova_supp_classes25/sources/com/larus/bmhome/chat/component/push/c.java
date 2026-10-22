package com.larus.bmhome.chat.component.push;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.OpenPushReminderScene;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements IIMCallback<List<? extends e>> {
    public final /* synthetic */ PushReminderComponent a;
    public final /* synthetic */ OpenPushReminderScene b;
    public final /* synthetic */ BotModel c;
    public final /* synthetic */ Map<String, Object> d;
    public final /* synthetic */ Function1<Boolean, Unit> e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r7) {
        List r8 = (List) r7;
        Intrinsics.checkNotNullParameter(r8, "result");
        if (z2.a.enableFilterDeletedBotConversation() == false) goto L17;
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L16;
        Object r1 = r9.next();
        Integer r2 = ((e) r1).t;
        if (r2 != null) goto L11;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L6;
        r0.add(r1);
        goto L6
    L11:
        if (r2.intValue() != 2) goto L12;
        r3 = false;
        goto L14
    L16:
        r8 = r0;
    L17:
        e r4 = (e) CollectionsKt.firstOrNull(r8);
        this.a.dK(this.b, r4, this.c, this.d, this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(PushReminderComponent r1, OpenPushReminderScene r2, BotModel r3, Map<String, ? extends Object> r4, Function1<? super Boolean, Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
