package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.MiniAppChooseTalentSettingUtil;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.MiniAppChooseTitleBar;
import com.bytedance.android.livesdk.config.i90;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ MiniAppChooseContainerFragment a;

    public d(MiniAppChooseContainerFragment r1) {
        this.a = r1;
    }

    public final void a() {
        MiniAppChooseTitleBar r0 = (MiniAppChooseTitleBar) this.a.S90(2131388807);
        String r1 = s1.B(2131920394);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "text");
        if (MiniAppChooseTalentSettingUtil.b() == false) goto L13;
        SharedPrefHelper r2 = r0.b;
        String r3 = MiniAppChooseTitleBar.e;
        int r4 = r2.h(r3, 0);
        if (r4 > ((Integer) i90.a.getValue()).intValue()) goto L14;
        r0.b.m(r3, Integer.valueOf(r4 + 1));
        Activity r5 = ContextUtil.contextToActivity(r0.getContext());
        if (r5 == null) goto L12;
        c90.a.a r6 = new c90.a.a(r5);
        Intrinsics.checkNotNullParameter(r1, "str");
        r6.j = r1;
        r6.c = UtilityKotlinExtentionsKt.i(50);
        new c90.a(r6).i(r0.a(2131388030), 80, true);
        return;
    L12:
        return;
    L14:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
