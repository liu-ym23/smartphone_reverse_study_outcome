package gu1;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.dslservice.slice.view.container.ConstraintContainerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends yt1.a<ConstraintLayout> {

    /* JADX INFO: renamed from: gu1.a$a, reason: collision with other inner class name */
    public static final class C0388a {
    }

    static {
    }

    public a() {
    }

    @Override // yt1.f
    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ConstraintContainerView(r2);
    }
}
