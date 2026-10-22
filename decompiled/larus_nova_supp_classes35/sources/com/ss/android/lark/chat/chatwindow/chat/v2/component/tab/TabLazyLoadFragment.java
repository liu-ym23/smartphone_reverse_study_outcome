package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.forsetiutils.widget.NoSaveViewStateFrameLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u001c\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0014J\u0006\u0010#\u001a\u00020\u0005J\b\u0010$\u001a\u00020\u001cH\u0014J\b\u0010%\u001a\u00020\u001cH\u0014J\b\u0010&\u001a\u00020\u001cH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/TabLazyLoadFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mIsNeedLazyLoad", BuildConfig.FLAVOR, "getMIsNeedLazyLoad", "()Z", "setMIsNeedLazyLoad", "(Z)V", "mIsPageShowing", "mIsContentViewCreated", "mIsDestroyed", "mLayoutInflater", "Landroid/view/LayoutInflater;", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "onCreateView", "Landroid/view/View;", "inflater", "container", "savedInstanceState", "Landroid/os/Bundle;", "onResume", BuildConfig.FLAVOR, "onPause", "onDestroyView", "loadContentView", "getContentView", "onContentViewCreated", "root", "isPageShow", "onPageShow", "onPageHide", "destroy", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TabLazyLoadFragment extends BaseFragment {
    public final boolean d;
    public boolean e;
    public boolean f;
    public LayoutInflater g;
    public NoSaveViewStateFrameLayout h;

    public static final class a {
    }

    static {
    }

    public abstract View S90(LayoutInflater r1, ViewGroup r2);

    public final void T90() {
        LayoutInflater r0 = this.g;
        Intrinsics.checkNotNull(r0);
        View r1 = S90(r0, this.h);
        if (r1 == null) goto L7;
        NoSaveViewStateFrameLayout r2 = this.h;
        Intrinsics.checkNotNull(r2);
        r2.addView(r1, new FrameLayout.LayoutParams(-1, -1));
        this.e = true;
        this.f = false;
        return;
    L7:
        throw new RuntimeException("getContentView can't be null");
    }

    public final void onDestroyView() {
        if (this.f == false) goto L5;
    L7:
        super.onDestroyView();
        return;
    L5:
        if (this.e == false) goto L7;
        this.e = false;
        this.f = true;
        goto L7
    }

    public TabLazyLoadFragment() {
        this.d = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.d == true) goto L5;
        return;
    L5:
        if (this.e == true) goto L7;
    L8:
        T90();
        return;
    L7:
        if (this.f == true) goto L8;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this.g = r1;
        this.h = new NoSaveViewStateFrameLayout(requireContext(), null);
        if (this.d == true) goto L5;
        T90();
    L5:
        NoSaveViewStateFrameLayout r4 = this.h;
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
