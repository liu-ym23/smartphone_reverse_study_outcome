package ua;

import android.os.IBinder;
import com.obric.aikernel.core.log.AIKLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import se.f;

/* JADX INFO: loaded from: classes.dex */
public final class a implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBinder f12523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f<Boolean> f12524b;

    public a(IBinder r8, f<Boolean> r10) {
        this.f12523a = r8;
        this.f12524b = r10;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        AIKLog.INSTANCE.i("BinderMonitor", "binderDied, start callback.");
        b.a().remove(Integer.valueOf(this.f12523a.hashCode()));
        ConcurrentHashMap r8 = b.a();
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if ((!((b.a) r12.getValue()).a().isBinderAlive()) == false) goto L4;
        r10.put(r12.getKey(), r12.getValue());
        goto L4
    L8:
        Iterator r13 = r10.entrySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        b.a().remove(((Map.Entry) r13.next()).getKey());
        goto L10
    L12:
        this.f12524b.b(Boolean.FALSE);
    }
}
