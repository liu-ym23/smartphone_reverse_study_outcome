package com.obric.memorydata.memory.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/obric/memorydata/memory/utils/PinShortcutUtils$observeResumeForCancel$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "hasPaused", "", "onPause", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "onDestroy", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PinShortcutUtils$observeResumeForCancel$1 implements DefaultLifecycleObserver {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ long $generation;
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ String $shortcutId;
    private boolean hasPaused;

    PinShortcutUtils$observeResumeForCancel$1(Context r3, String r4, long r5, Lifecycle r7) {
        this.$appContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.$shortcutId = r4;
        this.$generation = r5;
        this.$lifecycle = r7;
    }

    /* JADX INFO: renamed from: lambda$hb15ei_Kvssj-ZUzF5TJ6CCHycI, reason: not valid java name */
    public static /* synthetic */ void m993lambda$hb15ei_KvssjZUzF5TJ6CCHycI(Context r0, String r1, long r2, Lifecycle r4, PinShortcutUtils$observeResumeForCancel$1 r5) {
        onResume$lambda$0(r0, r1, r2, r4, r5);
    }

    private static final void onResume$lambda$0(Context r8, String r9, long r10, Lifecycle r12, PinShortcutUtils$observeResumeForCancel$1 r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        m r2 = m.f11550a;
        Intrinsics.checkNotNull(r3);
        m.a(r2, r3, r9, r10, "resume");
        r12.removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(r13, LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), "owner");
        this.$lifecycle.removeObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), "owner");
        this.hasPaused = true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner r9) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r9, LifecycleOwner.class, "com.obric.memorydata.plugin"), "owner");
        if (this.hasPaused == true) goto L5;
        return;
    L5:
        Handler r10 = new Handler(Looper.getMainLooper());
        final Context r2 = this.$appContext;
        final String r3 = this.$shortcutId;
        final long r4 = this.$generation;
        final Lifecycle r6 = this.$lifecycle;
        r10.postDelayed(new $$Lambda$PinShortcutUtils$observeResumeForCancel$1$hb15ei_KvssjZUzF5TJ6CCHycI(r2, r3, r4, r6, this), 500);
    }
}
