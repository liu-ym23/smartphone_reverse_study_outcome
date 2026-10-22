package com.bytedance.android.live.room.navi.userinfo.util;

import android.view.View;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveRoomUserInfoUtils {

    public static final class a implements Action {
        public final /* synthetic */ q4.b a;

        public a(q4.b r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.a();
        }
    }

    static {
    }

    @JvmStatic
    public static final <T extends View, R extends View> Disposable a(T r7, R r8, long r9, Function2<? super T, ? super R, Unit> r12) {
        Intrinsics.checkNotNullParameter(r7, "showView");
        Intrinsics.checkNotNullParameter(r8, "hideView");
        Intrinsics.checkNotNullParameter(r12, "onEndOrCancel");
        q4.b r10 = u4.c(new LiveRoomUserInfoUtils$getAndStartReplaceAnim$controller$1(r7, r8, r12, r9));
        r10.c();
        return Disposables.fromAction(new a(r10));
    }
}
