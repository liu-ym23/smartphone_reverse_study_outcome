package y62;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.comment.mylive.MyLiveEntranceManager;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ MyLiveEntranceManager a;

    public d(MyLiveEntranceManager r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        MyLiveEntranceManager r7 = this.a;
        int r0 = MyLiveEntranceManager.k;
        r7.getClass();
        IMiddlewareUserService r1 = k.n(IMiddlewareUserService.class);
        Bundle r2 = new Bundle();
        com.bytedance.android.livesdk.user.e r3 = r1.user();
        Context r4 = r7.f;
        l.a r5 = new l.a();
        r5.a = s1.B(2131915990);
        r5.d = "comment_live";
        r5.c = -1;
        r5.h = r2;
        r5.e = BuildConfig.FLAVOR;
        Disposable r8 = r3.login(r4, new l(r5)).subscribe(e.a, f.a);
        CompositeDisposable r9 = r7.c;
        if (r9 == null) goto L6;
        r9.add(r8);
        return;
    }
}
