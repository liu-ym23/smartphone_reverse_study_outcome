package com.larus.bmhome.viewholder;

import android.view.View;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.t1;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uo8.j;
import yt8.b;
import yt8.c;
import yt8.d;
import yt8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010)\u001a\u00020\u001bH\u0016J\"\u0010*\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0,J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0016JV\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u0006\u00105\u001a\u00020\u0014H\u0016J\u001a\u00106\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00107\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0002J>\u00109\u001a\u00020\u001b2\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!H\u0002J\b\u0010=\u001a\u00020\u001bH\u0016J\b\u0010>\u001a\u00020\u001bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0006R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006?"}, d2 = {"Lcom/larus/bmhome/viewholder/LifeViewHolder;", "Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;", "Lcom/larus/bmhome/viewholder/ITransitionHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "TAG", "", "selectionObserver", "Landroidx/lifecycle/Observer;", "", "unselectionObserver", "processView", "getProcessView", "()Landroid/view/View;", "setProcessView", "itemData", "Lcom/larus/bmhome/bigimg/MediaItem;", "uriUpdateListener", "Lcom/larus/bmhome/common_ui/image/OnUriUpdateListener;", "getUriUpdateListener", "()Lcom/larus/bmhome/common_ui/image/OnUriUpdateListener;", "setUriUpdateListener", "(Lcom/larus/bmhome/common_ui/image/OnUriUpdateListener;)V", "onImageLoadSuccessListener", "Lkotlin/Function1;", "", "getOnImageLoadSuccessListener", "()Lkotlin/jvm/functions/Function1;", "setOnImageLoadSuccessListener", "(Lkotlin/jvm/functions/Function1;)V", "onImageLongPressListener", "Lkotlin/Function0;", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "onDismiss", "observeSelection", "unselectedLiveData", "Landroidx/lifecycle/LiveData;", "selectedLiveData", "updateSelectionState", "selected", "", "realBindData", "imagePreviewDownloadUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "orNull", "updateListener", "bindMediaData", "setProgressUI", "mediaInfo", "bindListeners", "imageLoadSuccessListener", "longPressListener", "scaleListener", "onFullyAttach", "onFullyDetach", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LifeViewHolder extends TransitionViewHolder {
    public static final /* synthetic */ int j = 0;
    public c b;
    public b c;
    public final View d;
    public t1 e;
    public j f;
    public Function1<? super Integer, Unit> g;
    public Function0<Unit> h;
    public Function0<Unit> i;

    public void V3() {
    }

    public void W3() {
    }

    public void Y3(boolean r1) {
    }

    public LifeViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.d = r2.findViewById(2131373418);
        this.g = new d();
    }

    public void U3(n1 r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "imagePreviewDownloadUrl");
        t1 r3 = r1.b;
        this.e = r3;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.d() == false) goto L10;
        View r4 = this.d;
        if (r4 == null) goto L14;
        e1.x(r4);
        return;
    L14:
        return;
    L10:
        View r5 = this.d;
        if (r5 == null) goto L16;
        e1.o(r5);
        return;
    }

    public final void X3(n1 r2, String r3, Function1 r4, Function0 r5, Function0 r6, uo8.b r7) {
        Intrinsics.checkNotNullParameter(r2, "imagePreviewDownloadUrl");
        Intrinsics.checkNotNullParameter(r4, "onImageLoadSuccessListener");
        Intrinsics.checkNotNullParameter(r7, "updateListener");
        this.f = r7;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        U3(r2, r3);
        T3().c(new e(this));
    }
}
