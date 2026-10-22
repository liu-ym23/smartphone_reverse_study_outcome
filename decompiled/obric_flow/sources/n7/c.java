package n7;

import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f20208c;

    @Override // um.a
    public final void w() {
        super.w();
        b r5 = this.f20208c;
        if (r5 == null) goto L5;
        r5.f22747a = 120000;
        r5.f22749c = 0;
    L5:
        w7.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(r5);
    }

    @Override // um.a
    public final StateType y() {
        return StateType.COOL_DOWN;
    }
}
