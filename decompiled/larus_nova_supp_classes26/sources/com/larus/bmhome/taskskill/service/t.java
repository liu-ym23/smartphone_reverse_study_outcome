package com.larus.bmhome.taskskill.service;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t implements IIMCallback<wc9.e> {
    public final /* synthetic */ String a;
    public final /* synthetic */ QuickReplyItem b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ FragmentActivity e;
    public final /* synthetic */ Integer f;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("SkillServiceImpl", "[showGoToPcTipDialogIfNeeded] load conversation for QuickReply failed, errorCode=" + r4.getCode());
    }

    public final void onSuccess(Object r10) {
        final wc9.e r1 = (wc9.e) r10;
        Handler r11 = SkillServiceImpl.a;
        final String r2 = this.a;
        final QuickReplyItem r3 = this.b;
        final int r4 = this.c;
        final String r5 = this.d;
        final FragmentActivity r6 = this.e;
        final Integer r7 = this.f;
        r11.post(new s(r1, r2, r3, r4, r5, r6, r7));
    }

    public t(String r1, QuickReplyItem r2, int r3, String r4, FragmentActivity r5, Integer r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
