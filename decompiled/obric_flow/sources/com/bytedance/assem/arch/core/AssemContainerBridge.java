package com.bytedance.assem.arch.core;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/core/AssemContainerBridge;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AssemContainerBridge extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArrayCompat f3927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArrayCompat f3928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f3929c;

    public AssemContainerBridge() {
        this.f3927a = new SparseArrayCompat();
        this.f3928b = new SparseArrayCompat();
        this.f3929c = new LinkedHashSet();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r5, int r10, Intent r11) {
        super.onActivityResult(r5, r10, r11);
        SparseArrayCompat r12 = this.f3927a;
        Function3 r13 = (Function3) r12.get(r5);
        if (r13 == null) goto L6;
        r13.invoke(Integer.valueOf(r5), Integer.valueOf(r10), r11);
        r12.remove(r5);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        LinkedHashSet r10 = this.f3929c;
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((Function0) r11.next()).invoke();
        goto L4
    L6:
        r10.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int r5, String[] r10, int[] r11) {
        super.onRequestPermissionsResult(r5, r10, r11);
        SparseArrayCompat r12 = this.f3928b;
        Function1 r13 = (Function1) r12.get(r5);
        if (r13 == null) goto L6;
        r13.invoke(r11);
        r12.remove(r5);
        return;
    }
}
