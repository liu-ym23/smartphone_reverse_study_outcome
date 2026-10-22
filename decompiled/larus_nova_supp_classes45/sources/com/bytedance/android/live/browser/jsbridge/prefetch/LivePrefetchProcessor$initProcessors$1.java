package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.livesdk.config.sd1;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "configStringList", "channel", "Lx46/a;", "invoke", "(Ljava/util/List;Ljava/lang/String;)Lx46/a;", "createProcessor"}, k = 3, mv = {1, 4, 3})
final class LivePrefetchProcessor$initProcessors$1 extends Lambda implements Function2<List<? extends String>, String, x46.a> {
    public static final LivePrefetchProcessor$initProcessors$1 INSTANCE = null;

    public static final class a implements Executor {
        public static final a a = null;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.prefetch.LivePrefetchProcessor$initProcessors$1$a$a, reason: collision with other inner class name */
        public static final class C0119a<T> implements Consumer {
            public static final C0119a a = null;

            static {
                a = new C0119a();
            }

            public C0119a() {
            }

            public final void accept(Object r1) {
                ((Runnable) r1).run();
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r3) {
            Observable.just(r3).subscribeOn(Schedulers.io()).subscribe(C0119a.a, b.a);
        }
    }

    public static final class b implements com.bytedance.ies.tools.prefetch.g {
        public final /* synthetic */ List a;

        public final List<String> a() {
            return this.a;
        }

        public b(List r1) {
            this.a = r1;
        }
    }

    static {
        INSTANCE = new LivePrefetchProcessor$initProcessors$1();
    }

    public LivePrefetchProcessor$initProcessors$1() {
        super(2);
    }

    public final x46.a invoke(List<String> r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "configStringList");
        Intrinsics.checkNotNullParameter(r6, "channel");
        x46.a r0 = x46.a.b;
        int r1 = LivePrefetchProcessor.d;
        x46.a.b r2 = new x46.a.b();
        LocalTestManager.a(new Class[]{wy.a.class});
        ((com.bytedance.ies.tools.prefetch.a) r2).e = false;
        ((com.bytedance.ies.tools.prefetch.a) r2).b = a.a;
        if (((Boolean) sd1.a.getValue()).booleanValue() == true) goto L5;
        ((com.bytedance.ies.tools.prefetch.a) r2).a = new LivePrefetchProcessor.LocalStorageImpl(r6);
    L5:
        ((com.bytedance.ies.tools.prefetch.a) r2).d = new b(r5);
        ((com.bytedance.ies.tools.prefetch.a) r2).c = new PrefetchNetworkExecutorImpl();
        return r2.a();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((List) r1, (String) r2);
    }
}
