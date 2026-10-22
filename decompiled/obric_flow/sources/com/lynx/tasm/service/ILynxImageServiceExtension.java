package com.lynx.tasm.service;

import an.c;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxImageServiceExtension {
    @Nullable
    c createBackgroundImageDrawable(@NonNull Context r5, @NonNull String r10);

    void onLynxEnvSetup();
}
