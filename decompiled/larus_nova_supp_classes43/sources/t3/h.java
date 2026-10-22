package t3;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<T> implements Comparator {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r10, T r11) {
        com.bytedance.ai.bridge.method.device.a.C0023a r12 = (com.bytedance.ai.bridge.method.device.a.C0023a) r10;
        com.bytedance.ai.bridge.method.device.a.C0023a r13 = (com.bytedance.ai.bridge.method.device.a.C0023a) r11;
        return ComparisonsKt.compareValues(r12.a + '-' + r12.b + '-' + r12.c, r13.a + '-' + r13.b + '-' + r13.c);
    }
}
