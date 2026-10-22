package z1;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;

/* JADX INFO: loaded from: classes.dex */
public class h extends b {
    public h(@NonNull c.a r10) {
        super(r10);
    }

    @Override // z1.d
    public void a(Intent r10, com.bytedance.common.wschannel.model.a r11) {
        r10.setExtrasClassLoader(ServiceConnectEvent.class.getClassLoader());
        ServiceConnectEvent r12 = (ServiceConnectEvent) r10.getParcelableExtra("service");
        this.f13752a.d(r12);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
