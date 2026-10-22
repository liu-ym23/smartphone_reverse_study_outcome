package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.os.Handler;
import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.setting.f5;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class CommonIconModel$loadHybridComponent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ f.b $callback;
    final /* synthetic */ vo1.i $component;
    final /* synthetic */ String $fallbackUrl;
    final /* synthetic */ String $url;
    final /* synthetic */ f this$0;

    public static final class a extends d0 {
        public final /* synthetic */ CommonIconModel$loadHybridComponent$1 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconModel$loadHybridComponent$1$a$a, reason: collision with other inner class name */
        public static final class RunnableC0053a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0053a(a r1) {
                this.a = r1;
            }

            public final void a() {
                CommonIconModel$loadHybridComponent$1 r0 = this.a.a;
                f.b(r0.this$0, r0.$fallbackUrl, r0.$callback);
                int r1 = com.bytedance.android.livesdk.chatroom.utils.a.a;
                com.bytedance.android.livesdk.chatroom.utils.a.a(ActivityMonitor.ActivityStatusCode.SUCCESS.getCode(), Integer.valueOf(((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) this.a.a.this$0).d), String.valueOf(this.a.a.this$0.o), this.a.a.$fallbackUrl);
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

        public final void a() {
            new Handler().post(new RunnableC0053a(this));
            int r0 = com.bytedance.android.livesdk.chatroom.utils.a.a;
            int r1 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
            ActivityHybridMonitor.ContainerType r3 = ActivityHybridMonitor.ContainerType.LYNX;
            f r2 = this.a.this$0;
            com.bytedance.android.livesdk.chatroom.utils.a.c(r1, "onFallback", r3, ((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) r2).d, String.valueOf(r2.o), this.a.$url);
        }

        public a(CommonIconModel$loadHybridComponent$1 r1) {
            this.a = r1;
        }

        public final void g(View r3) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            this.a.$callback.onLoadSuccess();
            f r4 = this.a.this$0;
            int r0 = f.s;
            r4.l(true);
            com.bytedance.android.livesdk.chatroom.monitor.f r5 = this.a.this$0.k;
            if (r5 == null) goto L8;
            r5.d("ON_PAGE_FINISHED");
            if (r5.i != 2) goto L9;
            r5.g();
            return;
        L9:
            return;
        }
    }

    public CommonIconModel$loadHybridComponent$1(f r1, String r2, f.b r3, String r4, vo1.i r5) {
        this.this$0 = r1;
        this.$fallbackUrl = r2;
        this.$callback = r3;
        this.$url = r4;
        this.$component = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m162invoke() {
        com.bytedance.android.livesdk.chatroom.monitor.f r0 = this.this$0.k;
        if (r0 == null) goto L5;
        r0.d("LOAD_URL_START");
    L5:
        a r1 = new a(this);
        if (((Boolean) f5.a.getValue()).booleanValue() == false) goto L8;
        vo1.i r2 = this.$component;
        String r3 = this.$url;
        f r4 = this.this$0;
        r2.h(r3, r4.n(r4.q), r1);
    L9:
        com.bytedance.android.livesdk.chatroom.monitor.f r5 = this.this$0.k;
        if (r5 == null) goto L13;
        r5.d("LOAD_URL_END");
        return;
    L13:
        return;
    L8:
        this.$component.b(this.$url, r1);
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m162invoke();
        return Unit.INSTANCE;
    }
}
