package com.larus.bmhome.chat.component.audio;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements y.a<BotModel> {
    public final /* synthetic */ MutableLiveData<BotModel> a;

    public f(MutableLiveData<BotModel> r1) {
        this.a = r1;
    }

    public final void c(Object r2) {
        BotModel r3 = (BotModel) r2;
        Intrinsics.checkNotNullParameter(r3, "new");
        this.a.postValue(r3);
    }
}
