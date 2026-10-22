package cz9;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.list.expose.ExposureTrackerExtKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public static final void a(View r1, RecyclerView.ViewHolder r2, final PropertyReference1Impl r3, Object r4, final Function3 r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "dataOwner");
        Intrinsics.checkNotNullParameter(r3, "dataProvider");
        Intrinsics.checkNotNullParameter(r4, "reportOwner");
        Intrinsics.checkNotNullParameter(r5, "reporter");
        final WeakReference r0 = new WeakReference(r2);
        final WeakReference r6 = new WeakReference(r4);
        ExposureTrackerExtKt.a(r1, new i(r0, r3, r6, r5));
    }
}
