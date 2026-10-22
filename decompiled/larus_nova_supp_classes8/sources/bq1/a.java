package bq1;

import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    boolean a(MotionEvent r1, Function1<? super MotionEvent, Boolean> r2);

    void b(boolean r1, Function1<? super Boolean, Unit> r2);

    boolean c(String r1, Function1<? super String, Boolean> r2);
}
