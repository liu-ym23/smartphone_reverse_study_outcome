package m52;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public int a;
    public final PublishSubject<Integer> b;
    public boolean c;

    public e() {
        this.b = PublishSubject.create();
        this.c = true;
    }

    public final void a(int r2) {
        if (r2 != this.a) goto L5;
        return;
    L5:
        this.a = r2;
        this.b.onNext(Integer.valueOf(r2));
    }

    public final void onEvent(IModelListDataManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r2.getType() == IModelListDataManager.ModelChangeType.INSERT_BOTTOM) goto L5;
        return;
    L5:
        if (this.c == false) goto L9;
        a(this.a + 1);
        return;
    }
}
