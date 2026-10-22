package n7;

import android.util.Log;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f20209c;
    public boolean d;
    public final /* synthetic */ int e;

    public /* synthetic */ e(com.bytedance.geckox.c r5, int r10) {
        this.e = r10;
        super(r5, 6);
    }

    public final long F() {
        switch(this.e) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.d == false) goto L7;
        return 300000;
    L7:
        return 5000;
    L10:
        if (this.d == false) goto L12;
        return 600000;
    L12:
        return 30000;
    }

    @Override // um.a
    public final void w() {
        super.w();
        this.d = true;
        String r5 = "enter : " + y() + " provideDetectInterval : " + F() + " isBack : true";
        if (td.b.f22124a == false) goto L5;
        Log.i("APM-CPU", r5);
    L5:
        a r10 = this.f20209c;
        if (r10 != null) goto L8;
        this.f20209c = new a(this, F(), F());
    L11:
        w7.b.a(AsyncTaskManagerType.CPU).b(this.f20209c);
        return;
    L8:
        long r11 = F();
        long r12 = F();
        r10.f22747a = r11;
        r10.f22749c = r12;
        if (r12 <= 0) goto L11;
        r10.f22748b = true;
        goto L11
    }

    @Override // um.a
    public final StateType y() {
        switch(this.e) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return StateType.PROCESS_DOUBLE_DETECT;
    L7:
        return StateType.PROCESS_DETECT;
    }
}
