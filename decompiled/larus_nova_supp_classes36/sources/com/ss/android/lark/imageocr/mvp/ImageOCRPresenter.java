package com.ss.android.lark.imageocr.mvp;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.imageocr_export.OCRParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.pan.ImageOCRResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageOCRPresenter extends BasePresenter<b, d, com.ss.android.lark.imageocr.mvp.a> {
    public static final /* synthetic */ int b = 0;
    public final OCRParams a;

    public static final class a {
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new c();
    }

    public final void create() {
        super.create();
        H8(false);
    }

    public final void H8(final boolean r6) {
        final b r0 = getModel();
        final IGetDataCallback<ImageOCRResponse> r1 = new ImageOCRPresenter$startOCR$1(r6, this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        Log.i("ImageOCRModel", "startOCR, isRetry:" + r6);
        final long r2 = System.currentTimeMillis();
        IGetDataCallback<ImageOCRResponse> r4 = new ImageOCRModel$startOCR$innerCallback$1(r1, r2, r0);
        if (r6 == false) goto L5;
        r0.a.setRemoteImageKey("");
    L5:
        jlb.a.a(r0.a, r0.getCallbackManager().wrapAndAddCallback(r4));
    }

    public ImageOCRPresenter(FragmentActivity r2, OCRParams r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a = r3;
        setView(new d(r2, r3));
        d r4 = (d) getView();
        c r0 = new c();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "viewDelegate");
        setModel(new b(r3));
    }
}
