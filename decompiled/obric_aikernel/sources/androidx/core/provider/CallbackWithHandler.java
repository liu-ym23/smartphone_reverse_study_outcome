package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class CallbackWithHandler {

    @NonNull
    private final FontsContractCompat.FontRequestCallback mCallback;

    @NonNull
    private final Handler mCallbackHandler;

    CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback r10) {
        this.mCallback = r10;
        this.mCallbackHandler = CalleeHandler.create();
    }

    CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback r10, @NonNull Handler r11) {
        this.mCallback = r10;
        this.mCallbackHandler = r11;
    }

    private void onTypefaceRequestFailed(final int r10) {
        final FontsContractCompat.FontRequestCallback r11 = this.mCallback;
        this.mCallbackHandler.post(new AnonymousClass2(this, r11, r10));
    }

    private void onTypefaceRetrieved(@NonNull final Typeface r10) {
        final FontsContractCompat.FontRequestCallback r11 = this.mCallback;
        this.mCallbackHandler.post(new AnonymousClass1(this, r11, r10));
    }

    void onTypefaceResult(@NonNull FontRequestWorker.TypefaceResult r10) {
        if (r10.isSuccess() == false) goto L5;
        onTypefaceRetrieved(r10.mTypeface);
        return;
    L5:
        onTypefaceRequestFailed(r10.mResult);
    }
}
