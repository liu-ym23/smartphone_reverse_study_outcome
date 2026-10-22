package po8;

import android.content.Context;
import android.widget.LinearLayout;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusBlockCreateDocButtonBinding;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends LinearLayout {
    public final Lazy a;

    private final LarusBlockCreateDocButtonBinding getBinding() {
        return (LarusBlockCreateDocButtonBinding) this.a.getValue();
    }

    public c(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = LazyKt.lazy(new a(r2, this));
    }

    public final void a(final Message r4, final boolean r5, final String r6) {
        Intrinsics.checkNotNullParameter(r4, "message");
        getBinding().b.setText(getContext().getString(2131899580));
        e1.d(getBinding().b, new b(r4, r5, r6, this));
    }
}
