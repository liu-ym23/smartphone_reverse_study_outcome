package com.bytedance.ies.bullet.core.container;

import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5287a;

    public a(FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        new WeakReference(r5);
        this.f5287a = new ArrayList();
    }
}
