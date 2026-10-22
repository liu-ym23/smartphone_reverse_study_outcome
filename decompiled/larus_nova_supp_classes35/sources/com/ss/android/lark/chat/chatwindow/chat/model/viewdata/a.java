package com.ss.android.lark.chat.chatwindow.chat.model.viewdata;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.chat.core.model.b.a<y6b.c> {
    public final InterfaceC0054a a;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a$a, reason: collision with other inner class name */
    public interface InterfaceC0054a {
        boolean a();

        boolean isSecret();
    }

    public a(InterfaceC0054a r1) {
        this.a = r1;
    }

    public final void d(List r5) {
        if (this.a.a() == false) goto L9;
        if (this.a.isSecret() == true) goto L9;
        Log.d("ExtraItemInterceptor", "insertItemWhenEmpty: hasMoreItem");
        return;
    L9:
        if (CollectionUtils.isEmpty(r5) == false) goto L11;
        y6b.c.a r0 = new y6b.c.a();
        r0.e(BuildConfig.FLAVOR);
        r0.a(BuildConfig.FLAVOR);
        r0.f(Message.Type.UNKNOWN);
        r0.b(BuildConfig.FLAVOR);
        r0.d(BuildConfig.FLAVOR);
        r0.c(new com.ss.android.lark.chat.base.view.vo.message.g());
        ((ArrayList) r5).add(r0.g());
    L11:
        Log.d("ExtraItemInterceptor", "insertItemWhenEmpty：" + ((ArrayList) r5).size());
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void c(List r1, int r2) {
        d(r1);
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void a(List<y6b.c> r1, int r2, int r3) {
        d(r1);
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void b(List<y6b.c> r1, int r2, int r3) {
        d(r1);
    }
}
