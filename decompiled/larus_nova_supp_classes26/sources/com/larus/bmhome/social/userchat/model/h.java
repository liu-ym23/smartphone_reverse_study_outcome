package com.larus.bmhome.social.userchat.model;

import androidx.lifecycle.MutableLiveData;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.BotChangeType;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements com.larus.im.service.y {
    public final /* synthetic */ MutableLiveData<a> a;

    public h(MutableLiveData<a> r1) {
        this.a = r1;
    }

    public final void a(List<BotModel> r2, BotChangeType r3) {
        Intrinsics.checkNotNullParameter(r2, "changedBots");
        Intrinsics.checkNotNullParameter(r3, "changeType");
        final BotModel r4 = (BotModel) CollectionsKt.getOrNull(r2, 0);
        SoftReference r5 = com.larus.utils.y.a;
        final MutableLiveData<a> r6 = this.a;
        com.larus.utils.y.c(new g(r6, r4));
    }
}
