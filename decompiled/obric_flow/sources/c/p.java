package c;

import android.content.Context;
import android.widget.Toast;
import com.zte.miboard.cards.AppCallbackUtils;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.data.ExpressNode;
import com.zte.miboard.cards.express.data.GetSFH5Result;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes.dex */
public final class p implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f1072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExpressNode f1073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f1074c;

    public p(long r5, Context r10, ExpressNode r11) {
        this.f1072a = r5;
        this.f1073b = r11;
        this.f1074c = r10;
    }

    @Override // mt.u
    public final void onComplete() {
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        m.j("ExpressUtils", "jumpToSFH5 getSFH5Url onError", r5);
        s.f1082b = false;
        Toast.makeText(this.f1074c, R.string.express_request_sf_error_try_again, 0).show();
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        GetSFH5Result r11 = (GetSFH5Result) r10;
        s.f1082b = false;
        m.i("ExpressUtils", "jumpToSFH5 getSFH5Url onNext hao=" + (System.currentTimeMillis() - this.f1072a) + "ms sfh5Result=" + r11);
        Context r5 = this.f1074c;
        if (r11 != null) goto L5;
    L7:
        m.l("ExpressUtils", "jumpToSFH5 getSFH5Url error result, sfh5Result=" + r11);
        Toast.makeText(r5, R.string.express_request_sf_error_try_again, 0).show();
        return;
    L5:
        if (r11.isAvailable() == false) goto L7;
        ExpressNode r12 = this.f1073b;
        String r13 = r12.getPhone();
        String r14 = r12.getMailNo();
        String r15 = r11.data.url;
        long r16 = r11.getExpiresTimeLong();
        r r17 = new r();
        r17.f1076a = r13;
        r17.f1077b = r14;
        r17.f1078c = r15;
        r17.d = r16;
        s.f1081a.add(r17);
        m.i("ExpressUtils", "jumpToSFH5 getSFH5Url isAvailable result");
        AppCallbackUtils.callAppJumpToWebView(r5, r15);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
    }
}
