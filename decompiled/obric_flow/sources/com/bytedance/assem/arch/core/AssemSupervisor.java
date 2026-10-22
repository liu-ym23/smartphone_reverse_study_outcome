package com.bytedance.assem.arch.core;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.extensions.b;
import java.util.ArrayList;
import kotlin.Metadata;
import x7.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/assem/arch/core/AssemSupervisor;", "Landroidx/lifecycle/LifecycleEventObserver;", "assem_release"}, k = 1, mv = {1, 4, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AssemSupervisor implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r5, Lifecycle.Event r10) {
        switch(a.f22981a[r10.ordinal()]) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Log.i("AssemSupervisor", "onDestroy: ");
        throw null;
    L7:
        Log.i("AssemSupervisor", "onStop: ");
        int r11 = b.f3935a;
        new ArrayList();
        throw null;
    L9:
        Log.i("AssemSupervisor", "onPause: ");
        int r12 = b.f3935a;
        new ArrayList();
        throw null;
    L11:
        Log.i("AssemSupervisor", "onResume: ");
        int r13 = b.f3935a;
        new ArrayList();
        throw null;
    L13:
        Log.i("AssemSupervisor", "onStart: ");
        int r14 = b.f3935a;
        new ArrayList();
        throw null;
    L15:
        Log.i("AssemSupervisor", "onCreate: ");
        int r15 = b.f3935a;
        new ArrayList();
        throw null;
    }
}
