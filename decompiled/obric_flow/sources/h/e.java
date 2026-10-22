package h;

import ai.y;
import bolts.ExecutorException;
import com.bytedance.android.anniex.scene.core.i;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k6.a f17260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f17261c;
    public final /* synthetic */ d d;

    public /* synthetic */ e(k6.a r5, d r10, y r11, int r12) {
        this.f17259a = r12;
        this.f17260b = r5;
        this.d = r10;
        this.f17261c = r11;
    }

    @Override // h.d
    public final Object a(f r10) {
        y r5 = this.f17261c;
        d r11 = this.d;
        k6.a r12 = this.f17260b;
        switch(this.f17259a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        dd.b r13 = (dd.b) r11;
        ExecutorService r14 = f.g;
        r5.execute(new i(r12, 18, r13, r10));     // Catch: Exception -> L7
    L9:
        return null;
    L7:
        e = move-exception;
        r12.h(new ExecutorException(e));
        goto L9
    L10:
        ExecutorService r15 = f.g;
        r5.execute(new i(r12, 17, r11, r10));     // Catch: Exception -> L13
    L15:
        return null;
    L13:
        e = move-exception;
        r12.h(new ExecutorException(e));
        goto L15
    }
}
