package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0004)*+,B\u0013\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\fH\u0001¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010 \u001a\u00020\u0014H\u0003J\b\u0010!\u001a\u00020\u0014H\u0007J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0007J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0007H\u0003J\b\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "onHasEnabledCallbacksChanged", "Landroidx/core/util/Consumer;", "", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "backInvokedCallbackRegistered", "hasEnabledCallbacks", "inProgressCallback", "Landroidx/activity/OnBackPressedCallback;", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "addCallback", "", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "dispatchOnBackCancelled", "dispatchOnBackProgressed", "backEvent", "Landroidx/activity/BackEventCompat;", "dispatchOnBackStarted", "onBackCancelled", "onBackPressed", "onBackProgressed", "onBackStarted", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "shouldBeRegistered", "updateEnabledCallbacks", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOnBackPressedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,430:1\n1747#2,3:431\n533#2,6:434\n533#2,6:440\n533#2,6:446\n533#2,6:452\n*S KotlinDebug\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n*L\n114#1:431,3\n233#1:434,6\n251#1:440,6\n271#1:446,6\n290#1:452,6\n*E\n"})
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final ArrayDeque<OnBackPressedCallback> onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @RequiresApi(33)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", "callback", "unregisterOnBackInvokedCallback", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = null;

        static {
            INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
        }

        public static /* synthetic */ void a(Function0 r5) {
            createOnBackInvokedCallback$lambda$0(r5);
        }

        private static final void createOnBackInvokedCallback$lambda$0(Function0 r5) {
            Intrinsics.checkNotNullParameter(r5, "$onBackInvoked");
            r5.invoke();
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackInvokedCallback(final Function0<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "onBackInvoked");
            return new f(r5);
        }

        @DoNotInline
        public final void registerOnBackInvokedCallback(Object r5, int r10, Object r11) {
            Intrinsics.checkNotNullParameter(r5, "dispatcher");
            Intrinsics.checkNotNullParameter(r11, "callback");
            ((OnBackInvokedDispatcher) r5).registerOnBackInvokedCallback(r10, (OnBackInvokedCallback) r11);
        }

        @DoNotInline
        public final void unregisterOnBackInvokedCallback(Object r5, Object r10) {
            Intrinsics.checkNotNullParameter(r5, "dispatcher");
            Intrinsics.checkNotNullParameter(r10, "callback");
            ((OnBackInvokedDispatcher) r5).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r10);
        }
    }

    @RequiresApi(34)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "()V", "createOnBackAnimationCallback", "Landroid/window/OnBackInvokedCallback;", "onBackStarted", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "backEvent", "", "onBackProgressed", "onBackInvoked", "Lkotlin/Function0;", "onBackCancelled", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = null;

        static {
            INSTANCE = new Api34Impl();
        }

        private Api34Impl() {
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackAnimationCallback(final Function1<? super BackEventCompat, Unit> r5, final Function1<? super BackEventCompat, Unit> r10, final Function0<Unit> r11, final Function0<Unit> r12) {
            Intrinsics.checkNotNullParameter(r5, "onBackStarted");
            Intrinsics.checkNotNullParameter(r10, "onBackProgressed");
            Intrinsics.checkNotNullParameter(r11, "onBackInvoked");
            Intrinsics.checkNotNullParameter(r12, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(r5, r10, r11, r12);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", "cancel", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r5, Lifecycle r10, OnBackPressedCallback r11) {
            Intrinsics.checkNotNullParameter(r10, "lifecycle");
            Intrinsics.checkNotNullParameter(r11, "onBackPressedCallback");
            this.this$0 = r5;
            this.lifecycle = r10;
            this.onBackPressedCallback = r11;
            r10.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable r5 = this.currentCancellable;
            if (r5 == null) goto L5;
            r5.cancel();
        L5:
            this.currentCancellable = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r5, Lifecycle.Event r10) {
            Intrinsics.checkNotNullParameter(r5, "source");
            Intrinsics.checkNotNullParameter(r10, "event");
            if (r10 != Lifecycle.Event.ON_START) goto L6;
            this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            return;
        L6:
            if (r10 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r11 = this.currentCancellable;
            if (r11 == null) goto L15;
            r11.cancel();
            return;
        L15:
            return;
        L11:
            if (r10 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "cancel", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher r5, OnBackPressedCallback r10) {
            Intrinsics.checkNotNullParameter(r10, "onBackPressedCallback");
            this.this$0 = r5;
            this.onBackPressedCallback = r10;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.access$getOnBackPressedCallbacks$p(this.this$0).remove(this.onBackPressedCallback);
            if (Intrinsics.areEqual(OnBackPressedDispatcher.access$getInProgressCallback$p(this.this$0), this.onBackPressedCallback) == false) goto L5;
            this.onBackPressedCallback.handleOnBackCancelled();
            OnBackPressedDispatcher.access$setInProgressCallback$p(this.this$0, null);
        L5:
            this.onBackPressedCallback.removeCancellable(this);
            Function0<Unit> r5 = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (r5 == null) goto L8;
            r5.invoke();
        L8:
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX INFO: renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class C00331 extends FunctionReferenceImpl implements Function0<Unit> {
        public C00331(Object r10) {
            super(0, r10, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OnBackPressedDispatcher.access$updateEnabledCallbacks((OnBackPressedDispatcher) this.receiver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ OnBackPressedCallback access$getInProgressCallback$p(OnBackPressedDispatcher r5) {
        return r5.inProgressCallback;
    }

    public static final /* synthetic */ ArrayDeque access$getOnBackPressedCallbacks$p(OnBackPressedDispatcher r5) {
        return r5.onBackPressedCallbacks;
    }

    public static final /* synthetic */ void access$onBackCancelled(OnBackPressedDispatcher r5) {
        r5.onBackCancelled();
    }

    public static final /* synthetic */ void access$onBackProgressed(OnBackPressedDispatcher r5, BackEventCompat r10) {
        r5.onBackProgressed(r10);
    }

    public static final /* synthetic */ void access$onBackStarted(OnBackPressedDispatcher r5, BackEventCompat r10) {
        r5.onBackStarted(r10);
    }

    public static final /* synthetic */ void access$setInProgressCallback$p(OnBackPressedDispatcher r5, OnBackPressedCallback r10) {
        r5.inProgressCallback = r10;
    }

    public static final /* synthetic */ void access$updateEnabledCallbacks(OnBackPressedDispatcher r5) {
        r5.updateEnabledCallbacks();
    }

    @MainThread
    private final void onBackCancelled() {
        ArrayDeque<OnBackPressedCallback> r5 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r10 = r5.listIterator(r5.size());
    L4:
        if (r10.hasPrevious() == false) goto L8;
        OnBackPressedCallback r11 = r10.previous();
        if (r11.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r12 = r11;
        this.inProgressCallback = null;
        if (r12 == null) goto L16;
        r12.handleOnBackCancelled();
        return;
    L16:
        return;
    L8:
        r11 = null;
        goto L9
    }

    @MainThread
    private final void onBackProgressed(BackEventCompat r5) {
        ArrayDeque<OnBackPressedCallback> r10 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r11 = r10.listIterator(r10.size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        OnBackPressedCallback r12 = r11.previous();
        if (r12.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r13 = r12;
        if (r13 == null) goto L16;
        r13.handleOnBackProgressed(r5);
        return;
    L16:
        return;
    L8:
        r12 = null;
        goto L9
    }

    @MainThread
    private final void onBackStarted(BackEventCompat r5) {
        ArrayDeque<OnBackPressedCallback> r10 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r11 = r10.listIterator(r10.size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        OnBackPressedCallback r12 = r11.previous();
        if (r12.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r13 = r12;
        this.inProgressCallback = r13;
        if (r13 == null) goto L16;
        r13.handleOnBackStarted(r5);
        return;
    L16:
        return;
    L8:
        r12 = null;
        goto L9
    }

    @RequiresApi(33)
    private final void updateBackInvokedCallbackState(boolean r5) {
        OnBackInvokedDispatcher r10 = this.invokedDispatcher;
        OnBackInvokedCallback r11 = this.onBackInvokedCallback;
        if (r10 == null) goto L15;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r5 == true) goto L8;
    L10:
        if (r5 == false) goto L12;
        return;
    L12:
        if (this.backInvokedCallbackRegistered == false) goto L19;
        Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(r10, r11);
        this.backInvokedCallbackRegistered = false;
        return;
    L19:
        return;
    L8:
        if (this.backInvokedCallbackRegistered == true) goto L10;
        Api33Impl.INSTANCE.registerOnBackInvokedCallback(r10, 0, r11);
        this.backInvokedCallbackRegistered = true;
        return;
    }

    private final void updateEnabledCallbacks() {
        boolean r5 = this.hasEnabledCallbacks;
        ArrayDeque<OnBackPressedCallback> r10 = this.onBackPressedCallbacks;
        boolean r11 = false;
        if (r10 != null) goto L5;
    L7:
        Iterator<OnBackPressedCallback> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        if (r12.next().isEnabled() == false) goto L9;
        r11 = true;
    L13:
        this.hasEnabledCallbacks = r11;
        if (r11 == r5) goto L25;
        Consumer<Boolean> r13 = this.onHasEnabledCallbacksChanged;
        if (r13 == null) goto L19;
        r13.accept(Boolean.valueOf(r11));
    L19:
        if (Build.VERSION.SDK_INT < 33) goto L26;
        updateBackInvokedCallbackState(r11);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }

    @MainThread
    public final void addCallback(OnBackPressedCallback r5) {
        Intrinsics.checkNotNullParameter(r5, "onBackPressedCallback");
        addCancellableCallback$activity_release(r5);
    }

    @MainThread
    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback r5) {
        Intrinsics.checkNotNullParameter(r5, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(r5);
        OnBackPressedCancellable r10 = new OnBackPressedCancellable(this, r5);
        r5.addCancellable(r10);
        updateEnabledCallbacks();
        r5.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return r10;
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackProgressed(BackEventCompat r5) {
        Intrinsics.checkNotNullParameter(r5, "backEvent");
        onBackProgressed(r5);
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackStarted(BackEventCompat r5) {
        Intrinsics.checkNotNullParameter(r5, "backEvent");
        onBackStarted(r5);
    }

    @MainThread
    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    @MainThread
    public final void onBackPressed() {
        ArrayDeque<OnBackPressedCallback> r5 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r10 = r5.listIterator(r5.size());
    L4:
        if (r10.hasPrevious() == false) goto L8;
        OnBackPressedCallback r11 = r10.previous();
        if (r11.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r12 = r11;
        this.inProgressCallback = null;
        if (r12 == null) goto L13;
        r12.handleOnBackPressed();
        return;
    L13:
        Runnable r13 = this.fallbackOnBackPressed;
        if (r13 == null) goto L20;
        r13.run();
        return;
    L20:
        return;
    L8:
        r11 = null;
        goto L9
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r5) {
        Intrinsics.checkNotNullParameter(r5, "invoker");
        this.invokedDispatcher = r5;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(Runnable r5, Consumer<Boolean> r10) {
        this.fallbackOnBackPressed = r5;
        this.onHasEnabledCallbacksChanged = r10;
        this.onBackPressedCallbacks = new ArrayDeque();
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 33) goto L5;
        return;
    L5:
        if (r11 < 34) goto L7;
        OnBackInvokedCallback r12 = Api34Impl.INSTANCE.createOnBackAnimationCallback(new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
    L8:
        this.onBackInvokedCallback = r12;
        return;
    L7:
        r12 = Api33Impl.INSTANCE.createOnBackInvokedCallback(new AnonymousClass5(this));
        goto L8
    }

    @MainThread
    public final void addCallback(LifecycleOwner r5, OnBackPressedCallback r10) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r10, "onBackPressedCallback");
        Lifecycle r11 = r5.getLifecycle();
        if (r11.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r10.addCancellable(new LifecycleOnBackPressedCancellable(this, r11, r10));
        updateEnabledCallbacks();
        r10.setEnabledChangedCallback$activity_release(new C00331(this));
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    @JvmOverloads
    public OnBackPressedDispatcher(Runnable r5) {
        this(r5, null);
    }
}
