package com.ss.android.lark.imageocr.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imageocr.mvp.ImageOCRPresenter;
import com.ss.android.lark.imageocr_export.OCRParams;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/imageocr/activity/ImageOCRFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mPresenter", "Lcom/ss/android/lark/imageocr/mvp/ImageOCRPresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "", "initWindowInsets", "initMVP", "onBackPressed", "onDestroy", "Companion", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageOCRFragment extends Fragment {
    public ImageOCRPresenter d;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        super.onDestroy();
        ImageOCRPresenter r0 = this.d;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public ImageOCRFragment() {
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L11;
        Bundle r0 = getArguments();
        if (r0 == null) goto L7;
        Serializable r1 = r0.getSerializable("KEY_OCR_PARAMS");
    L8:
        OCRParams r2 = (OCRParams) r1;
        if (r2 == null) goto L11;
        ImageOCRPresenter r5 = new ImageOCRPresenter(r4, r2);
        this.d = r5;
        r5.create();
        goto L11
    L7:
        r1 = null;
    L11:
        f r6 = WindowInsetsUtils.b(this);
        r6.b(0);
        r6.o(true);
        r6.i(UIUtils.getColor(getContext(), 2131106500));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return getLayoutInflater().inflate(2131561532, r3, false);
    }
}
