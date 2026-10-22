package kk0;

import android.content.Context;
import android.graphics.PointF;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final Context a;
    public final DataCenter b;
    public final ViewGroup c;
    public final HSImageView d;
    public final InterfaceC0227a e;

    /* JADX INFO: renamed from: kk0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0227a {
        PointF x(String r1);
    }

    public a(Context r2, DataCenter r3, ViewGroup r4, HSImageView r5, InterfaceC0227a r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
