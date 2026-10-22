package w78;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.bmhome.auth.Config;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public final j<Config> a;
    public final MutableLiveData<w78.a> b;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public f(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "application");
        j<Config> r6 = new j(Config.class, CollectionsKt.listOf("sami_token"));
        this.a = r6;
        this.b = new MutableLiveData();
        AuthModelDelegate r0 = AuthModelDelegate.b;
        r0.j().observeForever(new a(new c(this)));
        r0.j().observeForever(new a(new d(this)));
        r6.c.observeForever(new a(new e(this)));
    }
}
