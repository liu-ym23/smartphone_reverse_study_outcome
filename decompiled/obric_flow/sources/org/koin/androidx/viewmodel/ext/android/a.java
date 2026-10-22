package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final CreationExtras a(Bundle r5, ViewModelStoreOwner r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "viewModelStoreOwner");
        Object r11 = null;
        if (r5.keySet().isEmpty() == true) goto L17;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L7
        MutableCreationExtras r13 = new MutableCreationExtras(null, 1, null);     // Catch: Throwable -> L7
        r13.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, r5);     // Catch: Throwable -> L7
        r13.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, r10);     // Catch: Throwable -> L7
        r13.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, (SavedStateRegistryOwner) r10);     // Catch: Throwable -> L7
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L7
    L10:
        if (Result.m130isFailureimpl(r14) == true) goto L14;
        r11 = r14;
    L14:
        return (CreationExtras) r11;
    L7:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    L17:
        return null;
    }
}
