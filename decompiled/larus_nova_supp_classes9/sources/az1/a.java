package az1;

import android.animation.ObjectAnimator;
import android.view.animation.PathInterpolator;
import com.bytedance.android.livesdk.gift.guide.view.CommentGiftGuideView;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Runnable {
    public final /* synthetic */ CommentGiftGuideView a;

    public a(CommentGiftGuideView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.FrameLayout, com.bytedance.android.livesdk.gift.guide.view.CommentGiftGuideView, java.lang.Object] */
    public final void a() {
        ?? r0 = this.a;
        int r1 = CommentGiftGuideView.i;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r0, "translationX", new float[]{r0.getWidth(), 0.0f});
        r0.d = r2;
        if (r2 == null) goto L5;
        r2.setDuration(200);
        r2.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r2.start();
    L5:
        Disposable r3 = r0.e;
        if (r3 == null) goto L8;
        r3.dispose();
    L8:
        r0.e = Observable.timer(5000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r0), c.a);
        r0.g = System.currentTimeMillis();
        r0.h = true;
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
