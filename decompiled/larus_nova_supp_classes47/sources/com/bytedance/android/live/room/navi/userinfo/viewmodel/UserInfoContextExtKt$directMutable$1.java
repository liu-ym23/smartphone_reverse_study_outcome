package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import android.os.Looper;
import com.bytedance.live.datacontext.MutableMemberConfig;
import com.bytedance.live.datacontext.o;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lcom/bytedance/live/datacontext/MutableMemberConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class UserInfoContextExtKt$directMutable$1 extends Lambda implements Function1<MutableMemberConfig<Object>, Unit> {
    public static final UserInfoContextExtKt$directMutable$1 INSTANCE = null;

    static {
        INSTANCE = new UserInfoContextExtKt$directMutable$1();
    }

    public UserInfoContextExtKt$directMutable$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((MutableMemberConfig) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(MutableMemberConfig<Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L5;
        Scheduler r0 = AndroidSchedulers.mainThread();
    L6:
        ((o) r3).c = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }
}
