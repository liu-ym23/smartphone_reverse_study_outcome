package n7b;

import android.os.CountDownTimer;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.chatwindow.view.burn.CountDownView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends CountDownTimer {
    public long a;
    public final /* synthetic */ CountDownView b;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        CountDownView r0 = this.b;
        int r1 = CountDownView.c;
        r0.getClass();
        this.b.b = false;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r4) {
        CountDownView r0 = this.b;
        int r1 = CountDownView.c;
        r0.getClass();
        if (r4 == this.a) goto L6;
        AppCompatTextView r2 = this.b;
        r2.getClass();
        r2.setText(CountDownView.x(r4));
        this.a = r4;
        return;
    }

    public a(CountDownView r3, long r4) {
        this.b = r3;
        super(r4, 0);
        this.a = -1;
    }
}
