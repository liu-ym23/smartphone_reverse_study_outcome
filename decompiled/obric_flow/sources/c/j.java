package c;

import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.data.ExpressDetail;
import com.zte.miboard.cards.express.data.ExpressDetailBean;
import io.reactivex.disposables.Disposable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f1059b;

    public j(f r5, String r10) {
        this.f1059b = r5;
        this.f1058a = r10;
    }

    @Override // mt.u
    public final void onComplete() {
        m.i("ExpressDetailActivity", "getJDDetailDatas onCompleted: ");
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        m.i("ExpressDetailActivity", "getJDDetailDatas onError: " + r5);
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        ExpressDetailBean r11 = (ExpressDetailBean) r10;
        m.i("ExpressDetailActivity", "getJDDetailDatas res: " + r11.getResult());
        if (r11.getResult() == 0) goto L5;
        return;
    L5:
        if (r11.getData() == null) goto L11;
        ExpressDetail r12 = r11.getData();
        f r5 = this.f1059b;
        r5.f1045w.setText(r5.getResources().getString(R.string.express_mail_no) + this.f1058a);
        List<ExpressDetail.Detail> r13 = r12.getDetail();
        if (r13.size() <= 0) goto L12;
        r5.f1043u.f1033b.clear();
        r5.f1043u.f1033b.addAll(r13);
        r5.f1043u.notifyDataSetChanged();
        return;
    L12:
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
    }
}
