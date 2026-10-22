package com.larus.bmhome.taskskill.service;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SkillServiceImpl$b implements IIMCallback<wc9.e> {
    public final /* synthetic */ SkillServiceImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ QuickReplyItem d;
    public final /* synthetic */ int e;
    public final /* synthetic */ FragmentActivity f;
    public final /* synthetic */ Integer g;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("SkillServiceImpl", "load conversation for QuickReply failed, errorCode=" + r4.getCode());
    }

    public final void onSuccess(Object r11) {
        final wc9.e r2 = (wc9.e) r11;
        Handler r12 = SkillServiceImpl.a;
        final SkillServiceImpl r1 = this.a;
        final String r3 = this.b;
        final String r4 = this.c;
        final QuickReplyItem r5 = this.d;
        final int r6 = this.e;
        final FragmentActivity r7 = this.f;
        final Integer r8 = this.g;
        r12.post(new r(r1, r2, r3, r4, r5, r6, r7, r8));
    }

    public SkillServiceImpl$b(SkillServiceImpl r1, String r2, String r3, QuickReplyItem r4, int r5, FragmentActivity r6, Integer r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
