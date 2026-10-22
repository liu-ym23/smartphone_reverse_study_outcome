package com.ss.android.lark.integrator.im.impl.preview;

import android.view.ViewGroup;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewRenderResult;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/integrator/im/impl/preview/OfficeUrlPreviewPageServiceImpl;", "Lcom/ss/android/lark/biz/officesdk/im/preview/IOfficeUrlPreviewPageService;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "session", "Lcom/ss/android/lark/integrator/im/impl/preview/UrlPreviewSession;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/ss/android/lark/integrator/im/impl/preview/UrlPreviewSession;)V", "pullPreview", "", "previewIds", "", "", "needLocalPreview", "", "removePreview", "previewId", "renderPreview", "Lcom/ss/android/lark/biz/officesdk/im/preview/UrlPreviewRenderResult;", "cardType", "Lcom/ss/android/lark/biz/officesdk/im/preview/UrlPreviewCardType;", "container", "Landroid/view/ViewGroup;", "onDestroy", "owner", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeUrlPreviewPageServiceImpl implements sza.a, DefaultLifecycleObserver {
    public final LifecycleOwner a;
    public final h b;

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    public final void J(List r2) {
        Intrinsics.checkNotNullParameter(r2, "previewIds");
        this.b.J(r2);
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        r2.getLifecycle().removeObserver(this);
        this.b.close();
    }

    public final void s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "previewId");
        this.b.s(r2);
    }

    public OfficeUrlPreviewPageServiceImpl(LifecycleOwner r3, OfficeUrlPreviewSessionImpl r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "session");
        this.a = r3;
        this.b = r4;
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        r4.close();
        return;
    L5:
        r3.getLifecycle().addObserver(this);
    }

    public final UrlPreviewRenderResult j0(String r2, UrlPreviewCardType r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "previewId");
        Intrinsics.checkNotNullParameter(r3, "cardType");
        Intrinsics.checkNotNullParameter(r4, "container");
        return this.b.j0(r2, r3, r4);
    }
}
