package c;

import android.os.CountDownTimer;
import android.widget.Button;
import com.zte.miboard.cards.R;

/* JADX INFO: loaded from: classes.dex */
public final class r0 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Button f1079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1080b;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        this.f1080b = true;
        Button r5 = this.f1079a;
        r5.setEnabled(true);
        r5.setText(R.string.express_get_verify_code);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r5) {
        this.f1080b = false;
        Button r10 = this.f1079a;
        r10.setEnabled(false);
        r10.setText(r10.getResources().getString(R.string.express_get_verify_code_again) + "(" + String.valueOf(r5 / 1000) + ")");
    }
}
