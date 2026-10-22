package com.ss.android.lark.chameleonv2.lkapi.biz.profile;

import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements RxScheduledExecutor.Consumer {
    public final /* synthetic */ Callback a;
    public final /* synthetic */ BizProfile.b b;
    public final /* synthetic */ IBizProfile$OpenProfileRequest c;

    public b(Callback r1, BizProfile.b r2, IBizProfile$OpenProfileRequest r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void consume(Object r10) {
        Chatter r11 = (Chatter) r10;
        if (r11 != null) goto L6;
        this.a.error(new LKAPIError(-1, "chatter is null"));
        j.b(this.b.a, "chatter is null");
        return;
    L6:
        if (r11.isBot() == false) goto L8;
        this.a.error(new LKAPIError(-1, "chatter is bot"));
        j.b(this.b.a, "chatter is bot");
        return;
    L8:
        ContactSource r7 = new ContactSource();
        r7.setSourceType(4);
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2.a.a(IProfileLauncherV2.Companion.a(), LarkContext.getApplication(), this.c.getUserId(), null, r7, 186);
    }
}
