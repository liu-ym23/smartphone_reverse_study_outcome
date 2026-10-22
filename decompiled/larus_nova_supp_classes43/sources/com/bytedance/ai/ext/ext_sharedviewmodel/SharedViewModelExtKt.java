package com.bytedance.ai.ext.ext_sharedviewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SharedViewModelProvider;
import androidx.lifecycle.ViewModel;
import com.bytedance.ai.viewmodel.AISharedViewModel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SharedViewModelExtKt {
    public static final AISharedViewModel b(LifecycleOwner r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "appGroupId");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        return (AISharedViewModel) a(new SharedViewModelProvider(new SharedViewModelExtKt$getAISharedViewModel$1$1(r11)), r11, r10.getLifecycle(), AISharedViewModel.class);
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static final <T extends ViewModel> T a(SharedViewModelProvider r10, String r11, Lifecycle r12, Class<T> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "customKey");
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        Intrinsics.checkNotNullParameter(r13, "modelClass");
        String r0 = r13.getCanonicalName();
        if (r0 == null) goto L7;
        return (T) r10.get(r12, ("androidx.lifecycle.ViewModelProvider.DefaultKey:" + r11) + ':' + r0, r13);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
