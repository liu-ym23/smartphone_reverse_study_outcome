package yja;

import android.os.IBinder;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.eventstaskmanager.IEventBinderListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements IBinder.DeathRecipient {
    public final /* synthetic */ IEventBinderListener a;

    public /* synthetic */ c(IEventBinderListener r1) {
        this.a = r1;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        EventsTaskSdk.b(this.a);
    }
}
