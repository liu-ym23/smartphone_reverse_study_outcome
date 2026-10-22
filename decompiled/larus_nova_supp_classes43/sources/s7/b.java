package s7;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements c {
    public b() {
    }

    @Override // s7.c
    public final void a(Configuration r1, PopupHybridParamVoNew r10) {
        Intrinsics.checkNotNullParameter(r10, "popupHybridParamVoNew");
    }

    @Override // s7.c
    public final void b(Configuration r1, AnnieCard r10) {
        Intrinsics.checkNotNullParameter(r10, "annieCard");
    }

    @Override // s7.c
    public final void c(Resources r10) {
        Intrinsics.checkNotNullParameter(r10, "resources");
    }
}
