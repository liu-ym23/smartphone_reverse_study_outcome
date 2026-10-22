package c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.google.gson.Gson;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.ExpressCard;
import com.zte.miboard.cards.express.data.SimpleResultBean;
import com.zte.miboard.cards.express.login.LoginActivity;
import com.zte.miboard.cards.express.login.LoginNumberActivity;
import io.reactivex.disposables.Disposable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f1025c;

    public a0(c0 r5, String r10, int r11) {
        this.f1025c = r5;
        this.f1023a = r10;
        this.f1024b = r11;
    }

    @Override // mt.u
    public final void onComplete() {
        m.i("LoginNumberAdapter", "unBindPhone onCompleted: ");
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        m.i("LoginNumberAdapter", "unBindPhone onError: " + r5);
        LoginNumberActivity r10 = this.f1025c.f1030b;
        Toast.makeText(r10, r10.getResources().getString(R.string.express_unbind_phone_failed), 1).show();
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        SimpleResultBean r11 = (SimpleResultBean) r10;
        m.i("LoginNumberAdapter", "unBindPhone res : " + r11.getResult());
        if (r11.getResult() != 0) goto L8;
        c0 r12 = this.f1025c;
        List r5 = r12.f1031c;
        String r13 = this.f1023a;
        r5.remove(r13);
        LoginNumberActivity r14 = r12.f1030b;
        Context r15 = r14.getApplicationContext();
        List r16 = s.b(r15);
        r16.remove(r13);
        r16.remove(r13.substring(1));
        String r17 = new Gson().toJson(r16);
        SharedPreferences.Editor r18 = r15.getSharedPreferences("express_info", 0).edit();
        r18.putString("express_data", r17);
        r18.commit();
        r12.notifyItemRemoved(this.f1024b);
        r12.notifyDataSetChanged();
        ExpressCard.b(r14);
        if (r12.f1031c.size() != 0) goto L7;
        m.i("LoginNumberAdapter", "UnbindPhone result has no phone: ");
        Intent r19 = new Intent(r14, LoginActivity.class);
        r19.addFlags(268435456);
        s0.g(r14, r19);
        r14.finish();
    L7:
        ExpressCard.q();
        ExpressCard.a(r14);
        Toast.makeText(r14, r14.getResources().getString(R.string.express_unbind_phone_ok), 1).show();
        return;
    L8:
        m.i("LoginNumberAdapter", "unBindPhone failed : ");
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
    }
}
