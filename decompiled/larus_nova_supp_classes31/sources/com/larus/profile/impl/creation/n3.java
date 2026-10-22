package com.larus.profile.impl.creation;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n3 {
    public final Context a;
    public final boolean b;
    public final int c;
    public final CoroutineScope d;
    public final hs9.a e;
    public final ViewGroup f;

    public n3(Context r2, boolean r3, int r4, LifecycleCoroutineScope r5, ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1 r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r6, "userCreationAction");
        Intrinsics.checkNotNullParameter(r7, "shareContainer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
