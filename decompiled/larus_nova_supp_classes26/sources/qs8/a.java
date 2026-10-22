package qs8;

import android.view.View;
import com.larus.common_ui.video.progress.PlayerProgressView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {
    void I4(boolean r1);

    void J1(float r1, boolean r2);

    View asView();

    void d5(Function0<Unit> r1);

    void h3();

    void setProgressViewVisibility(boolean r1);

    void z1(Function1<? super PlayerProgressView, Unit> r1);
}
