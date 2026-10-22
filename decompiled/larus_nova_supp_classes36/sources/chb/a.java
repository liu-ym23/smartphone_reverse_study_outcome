package chb;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    s M(FlowMixedFeedFragment r1);

    void Nb(Function0<Unit> r1);

    com.ss.android.lark.flow.feed.data.a Q();

    void ce(Function0<Unit> r1);

    void i8(Function0<Unit> r1);

    void k3(Function0<Unit> r1);

    String t();

    s t0(ViewModelStoreOwner r1);

    l w();
}
