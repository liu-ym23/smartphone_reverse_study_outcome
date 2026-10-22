package com.ss.android.lark.forwardv2.impl;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.impl.model.d;
import com.ss.android.lark.forwardv2.impl.view.d0;
import com.ss.android.lark.forwardv2.impl.view.delegate.TemplateForwardViewDelegate;
import com.ss.android.lark.forwardv3.plugins.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardPresenter extends BasePresenter<iib.a, iib.c, iib.c.a> {
    public final d0 a;
    public final d b;
    public final ForwardTemplate c;
    public Disposable d;
    public final f e;
    public final long f;
    public int g;
    public int h;
    public boolean i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestStatus {
        public static final int AVAILABLE = 1;
        public static final int ERROR = 2;
        public static final int NOT_ARRIVE = 0;
    }

    public class a implements Observer<rib.b> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ IGetDataCallback b;
        public final /* synthetic */ ForwardPresenter c;

        public final void onComplete() {
            Log.i("ForwardPresenter", "zipRecentAndRecommend has onCompleted, from local: " + this.a);
        }

        public final void onError(Throwable r3) {
            if (this.a == true) goto L5;
            this.c.g = 2;
        L7:
            if ((r3 instanceof ErrorResult) == false) goto L9;
            this.b.onError((ErrorResult) r3);
        L9:
            Log.e("ForwardPresenter", r3);
            return;
        L5:
            this.c.h = 2;
            goto L7
        }

        public final void onNext(Object r3) {
            rib.b r4 = (rib.b) r3;
            Log.i("ForwardPresenter", "zipRecentAndRecommend success, from local: " + this.a);
            if (this.a == true) goto L5;
            this.c.g = 1;
        L6:
            this.b.onSuccess(r4);
            return;
        L5:
            this.c.h = 1;
            goto L6
        }

        public final void onSubscribe(Disposable r2) {
            this.c.d = r2;
        }

        public a(ForwardPresenter r1, boolean r2, IGetDataCallback r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements BiFunction<List<SearchBaseInfo>, List<SearchBaseInfo>, rib.b> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ForwardPresenter c;

        public final Object apply(Object r6, Object r7) throws Exception {
            List<SearchBaseInfo> r8 = (List) r6;
            List<SearchBaseInfo> r9 = (List) r7;
            long r0 = SystemClock.elapsedRealtime();
            Log.i("ForwardPresenter", "zip data success, from local:" + this.a + "\nfrom start activity to zip data success, cost: " + (r0 - this.c.f) + "\nfrom start zip data to zip data success cost: " + (r0 - this.b));
            rib.b.a r2 = new rib.b.a();
            Intrinsics.checkNotNullParameter(r9, "recentForwardData");
            r2.b = r9;
            Intrinsics.checkNotNullParameter(r8, "recentVisitData");
            r2.a = r8;
            r2.c = r0 - this.b;
            r2.d = this.a;
            return r2.a();
        }

        public b(ForwardPresenter r1, boolean r2, long r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public final void create() {
        qqb.c.c(new com.ss.android.lark.forwardv2.impl.b(this));
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new TemplateForwardViewDelegate(this.a, this.b, this.c);
    }

    public final void destroy() {
        super.destroy();
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public static /* synthetic */ void H8(ForwardPresenter r2) {
        super.create();
        r2.a.f1(new c(r2));
    }

    public final void I8(IGetDataCallback<rib.b> r6, final boolean r7) {
        long r0 = SystemClock.elapsedRealtime();
        Log.i("ForwardPresenter", "++++++++++ zipRecentAndRecommend start, from local: " + r7 + "++++++++++\nfrom start activity to start zip data cost: " + (r0 - this.f));
        final d r2 = this.b;
        Observable r3 = Observable.create(new AnonymousClass5(this, r2, r7));
        final d r4 = this.b;
        Observable.zip(r3, Observable.create(new AnonymousClass4(this, r4, r7)), new b(this, r7, r0)).subscribe(new a(this, r7, r6));
    }

    public ForwardPresenter(long r13, FragmentActivity r15, ForwardTemplate r16, ForwardPickFragment.a r17, Fragment r18) {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.f = r13;
        this.c = r16;
        f r8 = new f(r18);
        this.e = r8;
        d r10 = new d(r16);
        this.b = r10;
        d0 r11 = new d0(r13, r15, r18, r17, r16, r8);
        this.a = r11;
        setModel(r10);
        setView(r11);
        r11.d = new TemplateForwardViewDelegate(r11, r10, r16);
    }
}
