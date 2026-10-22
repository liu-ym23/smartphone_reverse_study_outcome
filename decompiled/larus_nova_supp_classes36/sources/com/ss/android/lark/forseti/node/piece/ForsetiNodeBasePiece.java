package com.ss.android.lark.forseti.node.piece;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0004J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0004J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0004R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010!\u001a\u00020\"8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/ss/android/lark/forseti/node/piece/ForsetiNodeBasePiece;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/ss/android/lark/forseti/node/piece/IActivityLifeAttach;", "<init>", "()V", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "isAttach", "", "()Z", "setAttach", "(Z)V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "setLayoutInflater", "(Landroid/view/LayoutInflater;)V", "attach", "", "activity", "detach", "requireActivity", "getActivity", "getContext", "Landroid/content/Context;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "get_viewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "_viewModelStore$delegate", "viewModelStore", "getViewModelStore", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class ForsetiNodeBasePiece implements LifecycleOwner, ViewModelStoreOwner {
    public FragmentActivity a;
    public boolean b;
    public final Handler c;
    public LayoutInflater d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public final FragmentActivity b() {
        if (this.a != null) goto L5;
    L6:
        Log.e("ForsetiNodePiece", "not attach to activity not available!");
    L7:
        FragmentActivity r0 = this.a;
        if (r0 == null) goto L11;
        return r0;
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        if (this.b == true) goto L7;
        goto L6
    }

    public final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.e.getValue();
    }

    public final ViewModelStore getViewModelStore() {
        return (ViewModelStore) this.f.getValue();
    }

    public ForsetiNodeBasePiece() {
        this.c = new Handler(Looper.getMainLooper());
        this.e = LazyKt.lazy(new ForsetiNodeBasePiece$lifecycleRegistry$2(this));
        this.f = LazyKt.lazy(ForsetiNodeBasePiece$_viewModelStore$2.INSTANCE);
    }

    public final Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public final Context getContext() {
        return this.a;
    }

    public final void a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        LayoutInflater r3 = LayoutInflater.from(r2);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.d = r3;
        this.b = true;
    }
}
