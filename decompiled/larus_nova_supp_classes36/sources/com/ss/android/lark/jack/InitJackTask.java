package com.ss.android.lark.jack;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.larksuite.arch.jack.g;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/jack/InitJackTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "jack-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitJackTask extends AsyncLaunchTask<Object> {

    public static final class a<I, O> implements Function {
        public static final a<I, O> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            Runnable r4 = (Runnable) r3;
            Intrinsics.checkNotNull(r4);
            return new lnb.a(qqb.a.d(), r4);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public InitJackTask() {
    }

    public final void a(Context r2) {
        g.a r3 = g.a;
        g.b = a.a;
        Intrinsics.checkNotNullParameter(new b(), "log");
        g.a r4 = g.a;
    }
}
