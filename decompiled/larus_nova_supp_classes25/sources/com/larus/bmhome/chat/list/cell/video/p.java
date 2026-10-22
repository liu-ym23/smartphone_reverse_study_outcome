package com.larus.bmhome.chat.list.cell.video;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ VideoCell a;
    public final /* synthetic */ u b;

    public /* synthetic */ p(VideoCell r1, u r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        VideoCell r0 = this.a;
        Message r1 = this.b.a;
        r0.getClass();
        Fragment r2 = lf8.a.d(r0);
        if (r2 == null) goto L8;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
        if (r3 == null) goto L8;
        BuildersKt.launch$default(r3, Dispatchers.getIO(), null, new VideoCell$checkVideoAvailable$1(r1, null), 2, null);
    L8:
        return Unit.INSTANCE;
    }
}
