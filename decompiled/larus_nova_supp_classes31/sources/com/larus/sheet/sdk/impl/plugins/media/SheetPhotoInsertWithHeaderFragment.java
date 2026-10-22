package com.larus.sheet.sdk.impl.plugins.media;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.sheet.sdk.impl.databinding.LarusSheetPhotoInsertWithHeaderLayoutBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/media/SheetPhotoInsertWithHeaderFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/sheet/sdk/impl/databinding/LarusSheetPhotoInsertWithHeaderLayoutBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetPhotoInsertWithHeaderFragment extends DialogFragment {
    public static final /* synthetic */ int e = 0;
    public LarusSheetPhotoInsertWithHeaderLayoutBinding d;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public SheetPhotoInsertWithHeaderFragment() {
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        LarusSheetPhotoInsertWithHeaderLayoutBinding r0 = this.d;
        if (r0 == null) goto L7;
        ImageView r1 = r0.d;
        if (r1 == null) goto L7;
        e1.d(r1, new h0(this));
    L7:
        LarusSheetPhotoInsertWithHeaderLayoutBinding r2 = this.d;
        if (r2 == null) goto L12;
        LinearLayout r3 = r2.b;
        if (r3 == null) goto L12;
        r3.addOnLayoutChangeListener(new i0(this));
    L12:
        LarusSheetPhotoInsertWithHeaderLayoutBinding r6 = this.d;
        if (r6 == null) goto L17;
        TextView r7 = r6.e;
        if (r7 == null) goto L17;
        r7.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r7.getPaint().setStrokeWidth(1.0f);
    L17:
        Bundle r8 = getArguments();
        final LinearLayout r9 = null;
        if (r8 == null) goto L31;
        String r10 = r8.getString("panel_title");
        if (r10 == null) goto L31;
        if ((!StringsKt.isBlank(r10)) == true) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L31;
        LarusSheetPhotoInsertWithHeaderLayoutBinding r11 = this.d;
        if (r11 == null) goto L31;
        TextView r12 = r11.e;
        if (r12 == null) goto L31;
        r12.setText(r10);
    L31:
        Bundle r13 = getArguments();
        if (r13 == null) goto L34;
        final int r14 = r13.getInt("init_height");
    L35:
        if (r5 == null) goto L37;
        return;
    L37:
        if (getChildFragmentManager().findFragmentByTag("sheet_photo_insert_content_fragment") != null) goto L51;
        LarusSheetPhotoInsertWithHeaderLayoutBinding r15 = this.d;
        if (r15 == null) goto L41;
        LinearLayout r16 = r15.c;
    L43:
        if ((r16 instanceof View) == false) goto L45;
        r9 = r16;
    L45:
        if (r9 == null) goto L48;
        r4 = r9;
    L48:
        r4.post(new j0(this, r9, r14));
        return;
    L41:
        r16 = null;
        goto L43
    L51:
        return;
    L34:
        r14 = i5.U();
        goto L35
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131563132, null, false);
        LinearLayout r11 = (LinearLayout) r10;
        int r12 = 2131374285;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131374285);
        if (r3 == null) goto L13;
        r12 = 2131386188;
        if (ViewBindings.findChildViewById(r10, 2131386188) == null) goto L13;
        r12 = 2131386190;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r10, 2131386190);
        if (r4 == null) goto L13;
        r12 = 2131386191;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131386191);
        if (r5 == null) goto L13;
        this.d = new LarusSheetPhotoInsertWithHeaderLayoutBinding(r11, r11, r3, r4, r5);
        return r11;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r12)));
    }
}
