package com.bumptech.glide;

import androidx.annotation.NonNull;
import d0.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Registry$NoModelLoaderAvailableException extends Registry$MissingComponentException {
    public Registry$NoModelLoaderAvailableException(@NonNull Object r5) {
        super("Failed to find any ModelLoaders registered for model class: " + r5.getClass());
    }

    public <M> Registry$NoModelLoaderAvailableException(@NonNull M r5, @NonNull List<r> r10) {
        super("Found ModelLoaders for model class: " + r10 + ", but none that handle this specific model instance: " + r5);
    }

    public Registry$NoModelLoaderAvailableException(@NonNull Class<?> r5, @NonNull Class<?> r10) {
        super("Failed to find any ModelLoaders for model: " + r5 + " and data: " + r10);
    }
}
