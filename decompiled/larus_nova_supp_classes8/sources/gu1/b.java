package gu1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.dslservice.slice.view.container.NormalContainerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends yt1.a<NormalContainerView> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // yt1.f
    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new NormalContainerView(r2);
    }
}
