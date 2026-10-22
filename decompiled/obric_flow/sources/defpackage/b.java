package defpackage;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.android.anniex.container.m;
import kj.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c, s3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f800a;

    public b(Activity r5, m r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        this.f800a = r11;
    }

    public b(ViewGroup r5) {
        this.f800a = r5;
    }
}
