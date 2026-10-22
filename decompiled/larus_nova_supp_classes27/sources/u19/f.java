package u19;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface f {
    void dismiss();

    void icon(int r1);

    boolean isShown();

    void lottie(Function1<? super LottieAdapterView, Unit> r1);

    void setAutoDisappear(boolean r1);

    void setDuration(int r1);

    void setYOffsetPx(Integer r1);

    void show(Context r1, boolean r2);

    void show(Fragment r1, boolean r2);

    void text(CharSequence r1);

    void updateText(CharSequence r1);
}
