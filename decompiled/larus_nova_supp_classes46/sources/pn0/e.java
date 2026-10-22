package pn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final LayoutConfigModel a;
    public final ProducerResStep b;

    public e(LayoutConfigModel r2, ProducerResStep r3) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfig");
        Intrinsics.checkNotNullParameter(r3, "step");
        this.a = r2;
        this.b = r3;
    }
}
