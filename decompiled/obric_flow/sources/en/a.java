package en;

import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.behavior.a0;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f16839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f16840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList f16841c;
    public LinkedList d;

    public a() {
        Handler r5 = new Handler(Looper.getMainLooper());
        this.f16839a = r5;
        this.d = new LinkedList();
        this.f16841c = new LinkedList();
        a0 r10 = new a0(this);
        this.f16840b = r10;
        r5.postDelayed(r10, 500);
    }

    @Override // en.c
    public final void a() {
    }
}
