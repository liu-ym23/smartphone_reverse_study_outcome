package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.user.IUserService;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j0 implements View.OnClickListener {
    public final /* synthetic */ LiveDrawerFeedCategoryFragment a;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "res");
            if (r3.isLogOut() == false) goto L5;
        L8:
            return true;
        L5:
            if (r3.isLogin() == true) goto L8;
            return false;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j0 a;

        public b(j0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((UserEvent) r2).isLogin() == false) goto L12;
            View r3 = this.a.a.s;
            if (r3 == null) goto L7;
            r3.setVisibility(8);
        L7:
            RecyclerView r4 = this.a.a.f;
            if (r4 == null) goto L10;
            r4.setVisibility(0);
        L10:
            LiveDrawerFeedCategoryFragment r5 = this.a.a;
            r5.g.a();
            r5.d.onFragmentUserVisibleHint(r5.getUserVisibleHint());
            return;
        }
    }

    public j0(LiveDrawerFeedCategoryFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.android.livesdk.user.f r5 = jc1.k.n(IUserService.class).user();
        Context r0 = this.a.getContext();
        com.bytedance.android.livesdk.user.l.a r1 = new com.bytedance.android.livesdk.user.l.a();
        r1.c = -1;
        r5.login(r0, new com.bytedance.android.livesdk.user.l(r1)).subscribe(this.a.N);
        Disposable r6 = jc1.k.n(IUserService.class).user().m().filter(a.a).subscribe(new b(this));
        this.a.t.add(r6);
    }
}
