package aa2;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m {
    public final /* synthetic */ TransTextMessagePresenter a;

    public final boolean a() {
        if (this.a.F.e != PublicScreenHeatState.COLD) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.a.F.e != PublicScreenHeatState.HOT) goto L5;
        return true;
    L5:
        return false;
    }

    public w(TransTextMessagePresenter r1) {
        this.a = r1;
    }
}
