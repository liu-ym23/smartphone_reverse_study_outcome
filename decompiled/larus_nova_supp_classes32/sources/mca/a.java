package mca;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a<T extends AppEntity> {
    public final List<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "wrapped");
        this.a = r2;
    }
}
