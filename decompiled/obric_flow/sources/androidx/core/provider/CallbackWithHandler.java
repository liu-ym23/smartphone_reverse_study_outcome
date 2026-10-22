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

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback r5, @NonNull Handler r10) {
        this.mCallback = r5;
        this.mCallbackHandler = r10;
    }

    private void onTypefaceRequestFailed(final int r5) {
        final FontsContractCompat.FontRequestCallback r10 = this.mCallback;
        this.mCallbackHandler.post(new AnonymousClass2(this, r10, r5));
    }

    private void onTypefaceRetrieved(@NonNull final Typeface r5) {
        final FontsContractCompat.FontRequestCallback r10 = this.mCallback;
        this.mCallbackHandler.post(new AnonymousClass1(this, r10, r5));
    }

    public void onTypefaceResult(@NonNull FontRequestWorker.TypefaceResult r5) {
        if (r5.isSuccess() == false) goto L5;
        onTypefaceRetrieved(r5.mTypeface);
        return;
    L5:
        onTypefaceRequestFailed(r5.mResult);
    }

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback r5) {
        this.mCallback = r5;
        this.mCallbackHandler = CalleeHandler.create();
    }
}
