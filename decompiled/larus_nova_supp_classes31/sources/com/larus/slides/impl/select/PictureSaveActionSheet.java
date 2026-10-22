package com.larus.slides.impl.select;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.common.apphost.AppHost;
import com.larus.slides.biz.impl.databinding.LarusSlidesDialogPictureSaveActionBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000e\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0016\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u0004\u0018\u00010%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/slides/impl/select/PictureSaveActionSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesDialogPictureSaveActionBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "creationId", "", "createWay", "behaviorCallback", "com/larus/slides/impl/select/PictureSaveActionSheet$behaviorCallback$1", "Lcom/larus/slides/impl/select/PictureSaveActionSheet$behaviorCallback$1;", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "pictureData", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "setup", "initView", "downloadImg", "imgUrl", "doDownloadImg", "downloadImage", "Lkotlinx/coroutines/CompletableDeferred;", "", "url", "saveBitmapInternal", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitmapToSD", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)Ljava/lang/Boolean;", "overlay", "originBitmap", "waterBitmap", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PictureSaveActionSheet extends BottomSheetDialogFragment implements by7.e {
    public static final /* synthetic */ int j = 0;
    public LarusSlidesDialogPictureSaveActionBinding d;
    public BottomSheetBehavior<View> e;
    public String f;
    public String g;
    public final b h;
    public GenerateImageViewHolder.b i;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ PictureSaveActionSheet a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(PictureSaveActionSheet r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.e;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public PictureSaveActionSheet() {
        this.h = new b(this);
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public final Boolean S90(Bitmap r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        AppHost.Companion r1 = AppHost.a;
        r0.append(r1.getAppName());
        r0.append(System.currentTimeMillis());
        r0.append(".jpeg");
        String r2 = r0.toString();
        String r3 = i1.b();
        if (i1.e(r5, r3, r2) == false) goto L9;
        String r6 = r3 + File.separator + r2;
        i1.f(r1.getApplication(), r6, true);
        ImageSave.a.getClass();
        ImageSave.g(r6);
        return Boolean.TRUE;
    L9:
        ImageSave r7 = ImageSave.a;
        String r4 = r3 + File.separator + r2;
        r7.getClass();
        ImageSave.g(r4);
        FLogger.a.w("ImageSave", "save failed");
        return Boolean.FALSE;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L5;
        r4.setOnShowListener(new w(this));
    L5:
        Dialog r5 = getDialog();
        if (r5 == null) goto L8;
        r5.setOnCancelListener(new x(this));
    L8:
        LarusSlidesDialogPictureSaveActionBinding r6 = this.d;
        if (r6 == null) goto L12;
        e1.d(r6.c, new y(this));
        e1.d(r6.b, new z(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131563134, r3, false);
        int r6 = 2131365123;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131365123);
        if (r7 == null) goto L9;
        r6 = 2131385109;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131385109);
        if (r0 == null) goto L9;
        LinearLayout r8 = (LinearLayout) r5;
        this.d = new LarusSlidesDialogPictureSaveActionBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
