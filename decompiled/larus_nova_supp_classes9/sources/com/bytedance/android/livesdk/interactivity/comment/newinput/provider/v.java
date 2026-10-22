package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.comment.input.DanmakuTabAdapter;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements DanmakuTabAdapter.b {
    public final /* synthetic */ DanmakuSectionProvider.b a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ v a;
        public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.danmu.b b;

        public a(v r1, com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.a.i.h.A(this.b);
        }
    }

    public v(DanmakuSectionProvider.b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.input.DanmakuTabAdapter.b
    public final void a(com.bytedance.android.live.profit.privilege.model.danmu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "tabItem");
        DanmakuTabAdapter r0 = this.a.d;
        if (r0 == null) goto L5;
        r0.notifyDataSetChanged();
    L5:
        this.a.i.d.add(RxUtilKt.h(Observable.timer(150, TimeUnit.MILLISECONDS)).subscribe(new a(this, r5)));
    }
}
