package com.larus.bmhome.chat.component.push;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.d;
import com.larus.platform.api.OpenPushReminderScene;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PushReminderComponent$a implements IIMCallback<BotModel> {
    public final /* synthetic */ e a;
    public final /* synthetic */ PushReminderComponent b;
    public final /* synthetic */ OpenPushReminderScene c;
    public final /* synthetic */ Map<String, Object> d;
    public final /* synthetic */ Function1<Boolean, Unit> e;
    public final /* synthetic */ String f;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r9) {
        BotModel r3 = (BotModel) r9;
        Intrinsics.checkNotNullParameter(r3, "result");
        e r2 = this.a;
        if (r2 == null) goto L5;
        this.b.dK(this.c, r2, r3, this.d, this.e);
        return;
    L5:
        d.d().getBotConversation(this.f, new c(this.b, this.c, r3, this.d, this.e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PushReminderComponent$a(e r1, PushReminderComponent r2, OpenPushReminderScene r3, Map<String, ? extends Object> r4, Function1<? super Boolean, Unit> r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
