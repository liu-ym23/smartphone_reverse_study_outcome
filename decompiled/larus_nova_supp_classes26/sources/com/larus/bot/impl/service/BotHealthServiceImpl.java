package com.larus.bot.impl.service;

import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.bot.health.IChatBotHealthService;
import com.larus.bmhome.chat.component.bottom.t0;
import com.larus.bot.impl.feature.health.g;
import com.larus.im.bean.bot.BotModel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/bot/impl/service/BotHealthServiceImpl;", "Lcom/larus/bmhome/bot/health/IChatBotHealthService;", "<init>", "()V", "showHealthTipFragmentDialog", "", "backListener", "Lkotlin/Function1;", "", "view", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "dismissDialog", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotHealthServiceImpl implements IChatBotHealthService {
    public BotHealthServiceImpl() {
    }

    public final void dismissDialog() {
        g r0 = g.a;
        g.e(null);
        g.d(null);
        Job r1 = g.e;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        Job r2 = g.c;
        if (r2 == null) goto L9;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        return;
    }

    public final void a(t0 r2, WeakReference r3, FragmentManager r4, BotModel r5) {
        Intrinsics.checkNotNullParameter(r2, "backListener");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        Intrinsics.checkNotNullParameter(r5, "botModel");
        g r0 = g.a;
        g.c(r2, r3, r4, r5);
    }
}
