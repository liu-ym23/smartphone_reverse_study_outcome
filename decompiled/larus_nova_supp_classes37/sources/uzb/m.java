package uzb;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.passport.base.core.log.PassportLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {

    public static class a implements View.OnClickListener {
        public final View.OnClickListener a;
        public long b;

        public a(View.OnClickListener r3) {
            this.b = 0;
            this.a = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            long r0 = SystemClock.elapsedRealtime();
            PassportLog.d("ViewUtil", "click time -> " + r0 + " lastTime -> " + this.b);
            if ((r0 - this.b) <= 500) goto L8;
            PassportLog.d("ViewUtil", " click vaild " + (r0 - this.b));
            this.b = r0;
            View.OnClickListener r1 = this.a;
            if (r1 == null) goto L9;
            r1.onClick(r9);
            return;
        L9:
            return;
        }
    }

    public static void a(View r1, View.OnClickListener r2) {
        if (r1 == null) goto L5;
        r1.setOnClickListener(new a(r2));
        return;
    }
}
