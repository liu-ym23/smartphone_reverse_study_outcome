package iqc;

import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class b$a {
    public String a;
    public final Set<PluginBroadcastReceiver> b;

    public b$a() {
        this.b = new CopyOnWriteArraySet();
    }

    public void registerReceiver(PluginBroadcastReceiver r3) {
        if (r3 == null) goto L5;
        ZeusLogger.i("Zeus/receiver_zeus", "plugin-receiver:" + r3.getClass().getSimpleName() + ",action=" + this.a + "[注册完成]");
        ((CopyOnWriteArraySet) this.b).add(r3);
        return;
    }

    public void unregisterReceiver(PluginBroadcastReceiver r5) {
        if (r5 == null) goto L15;
    L10:
        th = move-exception;
        ZeusLogger.w("Zeus/receiver_zeus", "unregisterReceiver-plugin-receiver->action:" + this.a + "[exception]:", th);
        return;
    L5:
        if (((CopyOnWriteArraySet) this.b).size() <= 0) goto L16;
        boolean r2 = ((CopyOnWriteArraySet) this.b).remove(r5);     // Catch: Throwable -> L10
        if (r2 == false) goto L17;
        ZeusLogger.d("Zeus/receiver_zeus", "unregisterReceiver->[移除Action]:" + this.a + ",receiver.hashCode()=" + r5.hashCode() + ",是否成功，success:" + r2);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L16:
        return;
    }
}
