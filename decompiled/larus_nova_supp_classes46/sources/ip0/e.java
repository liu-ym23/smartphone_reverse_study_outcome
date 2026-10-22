package ip0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository.MiniAppListRepository;
import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MiniAppListRepository a;

    public e(MiniAppListRepository r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.b.a(Result.box-impl(Result.constructor-impl((b) r2)));
    }
}
