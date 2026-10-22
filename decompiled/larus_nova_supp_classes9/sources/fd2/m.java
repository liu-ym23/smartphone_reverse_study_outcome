package fd2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.MVPreViewDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface m {
    com.bytedance.android.livesdk.ktvimpl.mv.opus.c a(com.bytedance.android.livesdk.ktvapi.model.mv.h r1);

    com.bytedance.android.livesdk.ktvimpl.mv.opus.c b(Function1 r1);

    com.bytedance.android.livesdk.ktvimpl.mv.opus.c c(f0 r1);

    void d(Function1<? super Boolean, Unit> r1);

    MVPreViewDialog e(Context r1, Function0 r2);

    com.bytedance.android.livesdk.ktvimpl.mv.opus.c f(View r1);
}
