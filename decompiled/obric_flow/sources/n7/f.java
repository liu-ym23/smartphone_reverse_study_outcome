package n7;

import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CopyOnWriteArrayList f20210c;
    public a d;
    public boolean e;

    @Override // um.a
    public final void w() {
        super.w();
        System.currentTimeMillis();
        this.e = true;
        w7.b.a(AsyncTaskManagerType.CPU).b(this.d);
    }

    @Override // um.a
    public final StateType y() {
        return StateType.THREAD_DETECT;
    }
}
