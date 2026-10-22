package com.bytedance.android.livesdk.chatroom.vs_impl.message;

import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import dq1.c;
import f52.b;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class BizAdMsgPanelViewManager$BizAdMsgTopView$onShow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $container;
    final /* synthetic */ BizAdMsgPanelViewManager.BizAdMsgTopView this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BizAdMsgPanelViewManager$BizAdMsgTopView$onShow$1 a;

        public a(BizAdMsgPanelViewManager$BizAdMsgTopView$onShow$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            BizAdMsgPanelViewManager r5 = this.a.this$0.o;
            int r0 = BizAdMsgPanelViewManager.n;
            r5.g().c(true, new BizAdMsgPanelViewManager$BizAdMsgTopView$onShow$1$1$1(this));
        }
    }

    public BizAdMsgPanelViewManager$BizAdMsgTopView$onShow$1(BizAdMsgPanelViewManager.BizAdMsgTopView r1, b r2) {
        this.this$0 = r1;
        this.$container = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m386invoke() {
        BizAdMsgPanelViewManager r0 = this.this$0.o;
        r0.h = r0.m.getWidth();
        c r1 = f.k();
        if (r1 == null) goto L5;
        r1.h("activity_ad_show", "comment_screen", this.this$0.n, null);
    L5:
        ViewTreeObserver r2 = this.this$0.o.m.getViewTreeObserver();
        if (r2 == null) goto L8;
        r2.addOnGlobalLayoutListener(this.this$0.o.i);
    L8:
        RxUtilKt.c(Observable.timer(this.this$0.n.displaySecond, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.this$0.o.c);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m386invoke();
        return Unit.INSTANCE;
    }
}
