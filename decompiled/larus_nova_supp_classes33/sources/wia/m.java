package wia;

import com.obric.capabilitykit.EntityProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m implements Runnable {
    public /* synthetic */ m() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = EntityProvider.deviceUnlockedReceiver.1.a;
        EntityProvider.access$checkIfFirstRunOrDataClean(EntityProvider.INSTANCE);
    }
}
