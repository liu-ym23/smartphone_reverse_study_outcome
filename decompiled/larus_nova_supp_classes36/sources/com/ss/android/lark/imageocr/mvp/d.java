package com.ss.android.lark.imageocr.mvp;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.imageocr.ImageOCRKit;
import com.ss.android.lark.imageocr.view.OCRBottomView;
import com.ss.android.lark.imageocr.view.OCRPickTextLayout;
import com.ss.android.lark.imageocr.view.OCRScanView;
import com.ss.android.lark.imageocr.view.OCRTipView;
import com.ss.android.lark.imageocr_export.OCRParams;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.pan.ImageOCRResponse;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements IView<com.ss.android.lark.imageocr.mvp.a>, OCRBottomView.c {
    public final Activity a;
    public final OCRParams b;
    public final View c;
    public final ImageView d;
    public final LargeImageView e;
    public final OCRBottomView f;
    public final OCRScanView g;
    public final OCRTipView h;
    public final OCRPickTextLayout i;
    public ImageOCRResponse j;
    public ArrayList<ilb.b> k;

    public static final class a {
    }

    static {
    }

    public final void create() {
        this.c.setVisibility(4);
        LargeImageView r0 = this.e;
        VFSPath r1 = VFSFiles.b.z(this.b.getLocalImagePath());
        nlb.g r2 = new nlb.g();
        r2.a = r1;
        r0.o(r2);
        this.e.setLoadPreviewListener(new e(this));
        this.d.setOnClickListener(new f(this));
        this.f.setItemListener(this);
    }

    public final void destroy() {
        Log.i("ImageOCRView", "destroy");
        this.g.b();
        LargeImageView r0 = this.e;
        SubsamplingScaleImageView r1 = r0.b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getVisibility() != 0) goto L9;
        SubsamplingScaleImageView r2 = r0.b;
        r2.G(true);
        r2.G1 = null;
        r2.H1 = null;
        r2.L1 = null;
        r2.M1 = null;
        return;
    }

    @Override // com.ss.android.lark.imageocr.view.OCRBottomView.c
    public final void h(int r13) {
        Log.i("ImageOCRView", "onBottomItemClick, clickId" + r13);
        ImageOCRResponse r11 = null;
        switch(r13) {
            case 1: goto L53;
            case 2: goto L45;
            case 3: goto L34;
            case 4: goto L24;
            case 5: goto L16;
            case 6: goto L5;
            default: goto L71;
        };
    L5:
        com.ss.android.lark.imageocr.utils.a.a("select_accurate_character", true, "public_select_accurate_character_view");
        int r14 = klb.d.a;
        ArrayList<ilb.b> r15 = this.k;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r15 = null;
    L8:
        ImageOCRResponse r0 = this.j;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        r0 = null;
    L11:
        SpannableStringBuilder r16 = klb.d.b(r15, r0, false);
        Activity r1 = this.a;
        ImageOCRResponse r2 = this.j;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L15:
        klb.d.a(r1, r16, r11);
        this.i.h(r16);
        return;
    L14:
        r11 = r2;
        goto L15
    L16:
        com.ss.android.lark.imageocr.utils.a.a("forward", true, "public_multi_select_share_view");
        int r17 = klb.d.a;
        ArrayList<ilb.b> r18 = this.k;
        if (r18 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r18 = null;
    L19:
        ImageOCRResponse r3 = this.j;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L23:
        SpannableStringBuilder r19 = klb.d.b(r18, r11, false);
        llb.a r4 = ImageOCRKit.a();
        r19.toString();
        r4.c();
        return;
    L22:
        r11 = r3;
        goto L23
    L24:
        com.ss.android.lark.imageocr.utils.a.a("copy", true, "none");
        int r110 = klb.d.a;
        ArrayList<ilb.b> r111 = this.k;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r111 = null;
    L27:
        ImageOCRResponse r5 = this.j;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L32:
        if (com.ss.android.lark.imageocr.utils.b.b(this.a, klb.d.b(r111, r11, false)) == false) goto L66;
        UDToast.show(this.a, 2131891160);
        return;
    L66:
        return;
    L30:
        r11 = r5;
        goto L32
    L34:
        com.ss.android.lark.imageocr.utils.a.a("select_accurate_character", false, "public_select_accurate_character_view");
        int r112 = klb.d.a;
        ArrayList<ilb.b> r113 = this.k;
        if (r113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r113 = null;
    L37:
        ImageOCRResponse r6 = this.j;
        if (r6 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        r6 = null;
    L40:
        SpannableStringBuilder r114 = klb.d.b(r113, r6, true);
        Activity r7 = this.a;
        ImageOCRResponse r8 = this.j;
        if (r8 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L44:
        klb.d.a(r7, r114, r11);
        this.i.h(r114);
        return;
    L43:
        r11 = r8;
        goto L44
    L45:
        com.ss.android.lark.imageocr.utils.a.a("forward", false, "public_multi_select_share_view");
        int r115 = klb.d.a;
        ArrayList<ilb.b> r116 = this.k;
        if (r116 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r116 = null;
    L48:
        ImageOCRResponse r9 = this.j;
        if (r9 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L52:
        SpannableStringBuilder r117 = klb.d.b(r116, r11, true);
        llb.a r10 = ImageOCRKit.a();
        r117.toString();
        r10.c();
        return;
    L51:
        r11 = r9;
        goto L52
    L53:
        com.ss.android.lark.imageocr.utils.a.a("copy", false, "none");
        int r118 = klb.d.a;
        ArrayList<ilb.b> r119 = this.k;
        if (r119 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r119 = null;
    L56:
        ImageOCRResponse r12 = this.j;
        if (r12 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L61:
        if (com.ss.android.lark.imageocr.utils.b.b(this.a, klb.d.b(r119, r11, true)) == false) goto L70;
        UDToast.show(this.a, 2131891160);
        return;
    L70:
        return;
    L59:
        r11 = r12;
        goto L61
    }

    public final void k(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.i("ImageOCRView", "onOCRError:" + r3);
        if (r3.getErrorCode() != (-10000)) goto L6;
        UDToast.show(this.a, 2131891173);
    L9:
        this.g.b();
        this.a.finish();
        return;
    L6:
        if (NetworkUtils.d(this.a) == false) goto L8;
        UDToast.show(this.a, 2131891169);
        goto L9
    L8:
        UDToast.show(this.a, 2131892010);
        goto L9
    }

    public final void setViewDelegate(IView.IViewDelegate r2) {
        Intrinsics.checkNotNullParameter((com.ss.android.lark.imageocr.mvp.a) r2, "viewDelegate");
    }

    public d(FragmentActivity r2, OCRParams r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.a = r2;
        this.b = r3;
        this.c = r2.findViewById(2131375028);
        this.d = (ImageView) r2.findViewById(2131375026);
        this.e = (LargeImageView) r2.findViewById(2131375027);
        this.f = (OCRBottomView) r2.findViewById(2131375025);
        this.g = (OCRScanView) r2.findViewById(2131375031);
        this.h = (OCRTipView) r2.findViewById(2131375034);
        this.i = (OCRPickTextLayout) r2.findViewById(2131375030);
    }
}
