package klb;

import android.os.SystemClock;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a extends ClickableSpan {
    public long a;

    /* JADX INFO: renamed from: klb.a$a, reason: collision with other inner class name */
    public static final class C0290a {
    }

    static {
    }

    public a() {
    }

    public final boolean a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.a;
        this.a = r0;
        if (r2 >= 500) goto L6;
        Log.d("BaseClickSpan", "url click elapsed too short");
        return true;
    L6:
        return false;
    }
}
