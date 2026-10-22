package ia1;

import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;
import com.bytedance.android.live.schema.convert.PopupGraType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final HybridType a;
    public final HybridUiType b;
    public final PopupGraType c;

    public /* synthetic */ a(HybridType r2, HybridUiType r3) {
        this(r2, r3, PopupGraType.OTHER);
    }

    public a(HybridType r2, HybridUiType r3, PopupGraType r4) {
        Intrinsics.checkNotNullParameter(r2, "hybridType");
        Intrinsics.checkNotNullParameter(r3, "hybridUiType");
        Intrinsics.checkNotNullParameter(r4, "popupGraType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
