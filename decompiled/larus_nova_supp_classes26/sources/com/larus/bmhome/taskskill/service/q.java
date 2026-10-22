package com.larus.bmhome.taskskill.service;

import android.os.Handler;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q implements IIMCallback<wc9.e> {
    public final /* synthetic */ o a;
    public final /* synthetic */ SkillServiceImpl b;
    public final /* synthetic */ m c;
    public final /* synthetic */ Function1<k, Unit> d;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("SkillServiceImpl", "load conversation for QuickReply action failed, errorCode=" + r4.getCode());
        this.d.invoke(new k.b("load_conversation_failed"));
    }

    public final void onSuccess(Object r8) {
        final wc9.e r3 = (wc9.e) r8;
        Handler r9 = SkillServiceImpl.a;
        final o r1 = this.a;
        final SkillServiceImpl r2 = this.b;
        final m r4 = this.c;
        final Function1<k, Unit> r5 = this.d;
        r9.post(new p(r1, r2, r3, r4, r5));
    }

    public q(o r1, SkillServiceImpl r2, m r3, o r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
