package mba;

import com.bytedance.keva.Keva;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final Keva a;

    public b() {
        this.a = Keva.getRepo(CloudControlInf.PERMISSION, 0);
    }
}
