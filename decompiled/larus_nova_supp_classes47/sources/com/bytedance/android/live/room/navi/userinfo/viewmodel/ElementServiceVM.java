package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0005\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/ElementServiceVM;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Ljava/lang/Class;", "Ln91/a;", "map", "Ljava/util/Map;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ElementServiceVM extends DataContext {
    private final CompositeDisposable cd;
    private final Map<Class<? extends n91.a>, n91.a> map;

    public static final class a implements Action {
        public final /* synthetic */ ElementServiceVM a;

        public a(ElementServiceVM r1) {
            this.a = r1;
        }

        public final void run() {
            ElementServiceVM.access$getMap$p(this.a).clear();
            ElementServiceVM.access$getCd$p(this.a).dispose();
        }
    }

    public ElementServiceVM() {
        this.map = new ConcurrentHashMap();
        CompositeDisposable r0 = new CompositeDisposable();
        this.cd = r0;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r0);
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(ElementServiceVM r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Map access$getMap$p(ElementServiceVM r0) {
        return r0.map;
    }
}
