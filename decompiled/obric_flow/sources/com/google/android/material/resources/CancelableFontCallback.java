package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback extends TextAppearanceFontCallback {
    private final ApplyFont applyFont;
    private boolean cancelled;
    private final Typeface fallbackFont;

    public interface ApplyFont {
        void apply(Typeface r5);
    }

    public CancelableFontCallback(ApplyFont r5, Typeface r10) {
        this.fallbackFont = r10;
        this.applyFont = r5;
    }

    private void updateIfNotCancelled(Typeface r5) {
        if (this.cancelled == true) goto L6;
        this.applyFont.apply(r5);
        return;
    }

    public void cancel() {
        this.cancelled = true;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int r5) {
        updateIfNotCancelled(this.fallbackFont);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface r5, boolean r10) {
        updateIfNotCancelled(r5);
    }
}
