package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.e;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Objects;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialBackOrchestrator {

    @Nullable
    private final BackCallbackDelegate backCallbackDelegate;

    @NonNull
    private final MaterialBackHandler backHandler;

    @NonNull
    private final View view;

    /* JADX INFO: renamed from: com.google.android.material.motion.MaterialBackOrchestrator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    @RequiresApi(33)
    public static class Api33BackCallbackDelegate implements BackCallbackDelegate {

        @Nullable
        private OnBackInvokedCallback onBackInvokedCallback;

        private Api33BackCallbackDelegate() {
        }

        public OnBackInvokedCallback createOnBackInvokedCallback(@NonNull final MaterialBackHandler r5) {
            Objects.requireNonNull(r5);
            return new a(r5);
        }

        public boolean isListeningForBackCallbacks() {
            if (this.onBackInvokedCallback == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        @DoNotInline
        public void startListeningForBackCallbacks(@NonNull MaterialBackHandler r5, @NonNull View r10, boolean r11) {
            if (this.onBackInvokedCallback == null) goto L5;
            return;
        L5:
            OnBackInvokedDispatcher r12 = e.k(r10);
            if (r12 != null) goto L8;
            return;
        L8:
            OnBackInvokedCallback r13 = createOnBackInvokedCallback(r5);
            this.onBackInvokedCallback = r13;
            if (r11 == false) goto L11;
            int r14 = DurationKt.NANOS_IN_MILLIS;
        L12:
            e.s(r12, r14, r13);
            return;
        L11:
            r14 = 0;
            goto L12
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        @DoNotInline
        public void stopListeningForBackCallbacks(@NonNull View r5) {
            OnBackInvokedDispatcher r10 = e.k(r5);
            if (r10 != null) goto L5;
            return;
        L5:
            e.t(r10, this.onBackInvokedCallback);
            this.onBackInvokedCallback = null;
        }

        public /* synthetic */ Api33BackCallbackDelegate(AnonymousClass1 r5) {
            this();
        }
    }

    @RequiresApi(34)
    public static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        private Api34BackCallbackDelegate() {
            super(null);
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate
        public OnBackInvokedCallback createOnBackInvokedCallback(@NonNull final MaterialBackHandler r5) {
            return new AnonymousClass1(this, r5);
        }

        public /* synthetic */ Api34BackCallbackDelegate(AnonymousClass1 r5) {
            this();
        }
    }

    public interface BackCallbackDelegate {
        void startListeningForBackCallbacks(@NonNull MaterialBackHandler r5, @NonNull View r10, boolean r11);

        void stopListeningForBackCallbacks(@NonNull View r5);
    }

    public <T extends View & MaterialBackHandler> MaterialBackOrchestrator(@NonNull T r5) {
        this(r5, r5);
    }

    @Nullable
    private static BackCallbackDelegate createBackCallbackDelegate() {
        int r5 = Build.VERSION.SDK_INT;
        AnonymousClass1 r10 = null;
        if (r5 < 34) goto L7;
        return new Api34BackCallbackDelegate(r10);
    L7:
        if (r5 >= 33) goto L9;
        return null;
    L9:
        return new Api33BackCallbackDelegate(r10);
    }

    public boolean shouldListenForBackCallbacks() {
        if (this.backCallbackDelegate == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void startListeningForBackCallbacks() {
        startListeningForBackCallbacks(false);
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        startListeningForBackCallbacks(true);
    }

    public void stopListeningForBackCallbacks() {
        BackCallbackDelegate r5 = this.backCallbackDelegate;
        if (r5 == null) goto L6;
        r5.stopListeningForBackCallbacks(this.view);
        return;
    }

    public MaterialBackOrchestrator(@NonNull MaterialBackHandler r5, @NonNull View r10) {
        this.backCallbackDelegate = createBackCallbackDelegate();
        this.backHandler = r5;
        this.view = r10;
    }

    private void startListeningForBackCallbacks(boolean r5) {
        BackCallbackDelegate r10 = this.backCallbackDelegate;
        if (r10 == null) goto L6;
        r10.startListeningForBackCallbacks(this.backHandler, this.view, r5);
        return;
    }
}
