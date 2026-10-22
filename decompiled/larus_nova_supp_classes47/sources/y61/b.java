package y61;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import d71.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends c {
    CompositeDisposable getContainerCd();

    i monitor();

    d<v61.a, d71.b> recordManager(MsgWindowPosition r1);

    i71.a scheduler();

    q71.b stateDispatcher();

    Disposable useContainer(MsgWindowPosition r1, Function1<? super w61.a<v61.a>, Unit> r2);

    w61.a<v61.a> windowContainer(MsgWindowPosition r1);
}
