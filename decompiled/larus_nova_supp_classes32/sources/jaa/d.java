package jaa;

import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.StateChangeListener;
import com.obric.aiagent.sharedstate.model.SharedValue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ StateChangeListener a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SharedValue c;

    public /* synthetic */ d(StateChangeListener r1, String r2, SharedValue r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedState.a(this.a, this.b, this.c);
    }
}
