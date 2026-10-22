package fx1;

import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface e<T> {
    void a();

    void b(Function2<? super TriggerId, ? super T, Unit> r1);

    TriggerId getId();

    void reset();
}
