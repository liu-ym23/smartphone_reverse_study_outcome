package pp0;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import yo2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public TextView a;
    public View b;
    public f c;
    public final a d;

    public static final class a extends CountDownTimer {
        public final /* synthetic */ b a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            f r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.d();
            return;
        }

        public a(b r5) {
            this.a = r5;
            super(3000, 1000);
        }
    }

    public b() {
        this.d = new a(this);
    }
}
