package m80;

import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a<E> extends Function<E, E> {
    E apply(E r1) throws OutsideScopeException;
}
