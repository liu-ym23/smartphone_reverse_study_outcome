package com.larus.bmhome.chat.standarduikit.localfileblock.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.mainbot.impl.databinding.LarusBlockItemPcLocalFileBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c;
import vl8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tJF\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0012\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/PcLocalFileCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemPcLocalFileBinding;", "isPreviewSupported", "", "isLoading", "isDownloaded", "downloadCompletedTask", "Ljava/lang/Runnable;", "trackingStatus", "", "isSourceDeviceOffline", "isClick", "bindData", "", "fileName", "fileType", "sourceDeviceName", "onClick", "Lkotlin/Function1;", "updateSourceDevice", "deviceName", "updateDownloaded", "updateLoading", "recycle", "clearDownloadCompleted", "updateDownloadState", "startCompletionTimer", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcLocalFileCardView extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public final LarusBlockItemPcLocalFileBinding a;
    public boolean b;
    public boolean c;
    public boolean d;
    public h e;

    /* JADX WARN: Multi-variable type inference failed */
    public PcLocalFileCardView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        LayoutInflater.from(r10).inflate(2131561837, this);
        int r11 = 2131370143;
        View r2 = ViewBindings.findChildViewById(this, 2131370143);
        if (r2 == null) goto L19;
        r11 = 2131372456;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(this, 2131372456);
        if (r3 == null) goto L19;
        r11 = 2131376188;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131376188);
        if (r4 == null) goto L19;
        r11 = 2131376240;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(this, 2131376240);
        if (r5 == null) goto L19;
        r11 = 2131379043;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(this, 2131379043);
        if (r6 == null) goto L19;
        r11 = 2131390623;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131390623);
        if (r7 == null) goto L19;
        r11 = 2131391531;
        TextView r8 = (TextView) ViewBindings.findChildViewById(this, 2131391531);
        if (r8 == null) goto L19;
        this.a = new LarusBlockItemPcLocalFileBinding(this, r2, r3, r4, r5, r6, r7, r8);
        setBackgroundResource(2131243140);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r6) {
        h r0 = this.e;
        int r1 = 0;
        if (r0 != null) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L14;
        if (r6 == false) goto L14;
        if (r0 == null) goto L14;
        postDelayed(r0, 3000);
    L14:
        AppCompatImageView r7 = this.a.d;
        if (r2 == false) goto L17;
        int r3 = 2131243141;
    L18:
        r7.setImageResource(r3);
        if (r2 == false) goto L21;
        int r8 = c.a(2130972081, getContext(), 2131103143);
    L22:
        this.a.d.setImageTintList(ColorStateList.valueOf(r8));
        ProgressBar r9 = this.a.f;
        if (this.c == false) goto L25;
        int r4 = 0;
    L26:
        r9.setVisibility(r4);
        AppCompatImageView r10 = this.a.d;
        if (this.c == false) goto L29;
        int r5 = 4;
    L35:
        r10.setVisibility(r5);
        View r11 = this.a.b;
        if (this.d == false) goto L38;
        r1 = 8;
    L38:
        r11.setVisibility(r1);
        return;
    L29:
        if (r2 == false) goto L32;
    L34:
        r5 = 0;
        goto L35
    L32:
        if (this.d == false) goto L34;
        r5 = 8;
        goto L35
    L25:
        r4 = 8;
        goto L26
    L21:
        r8 = c.a(2130972082, getContext(), 2131103146);
        goto L22
    L17:
        r3 = 2131243142;
        goto L18
    L5:
        if (this.c == true) goto L9;
        if (this.d == false) goto L9;
        r2 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(boolean r3) {
        boolean r0 = this.d;
        if (r0 == true) goto L6;
        if (r3 == false) goto L6;
        boolean r1 = true;
    L7:
        if (r0 == false) goto L15;
        if (r3 == true) goto L15;
        if (this.c == true) goto L15;
        h r2 = this.e;
        if (r2 == null) goto L14;
        removeCallbacks(r2);
    L14:
        this.e = null;
    L15:
        this.d = r3;
        R5(r1);
        return;
    L6:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [vl8.h] */
    public final void T5(boolean r3) {
        if (this.c == false) goto L6;
        if (r3 == true) goto L6;
        boolean r0 = true;
    L7:
        if (r3 == false) goto L12;
        h r1 = this.e;
        if (r1 == null) goto L11;
        removeCallbacks(r1);
    L11:
        this.e = new h(this);
    L12:
        this.c = r3;
        R5(r0);
        if (this.b == true) goto L16;
        if (r3 == true) goto L16;
        float r4 = 0.4f;
    L17:
        this.a.e.setAlpha(r4);
        this.a.c.setAlpha(r4);
        this.a.d.setAlpha(r4);
        return;
    L16:
        r4 = 1.0f;
    L6:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(String r4) {
        Context r0 = getContext();
        Object[] r1 = new Object[1];
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim(r4).toString();
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r1[0] = r5;
        String r6 = StringsKt.trimEnd(r0.getString(2131908783, r1)).toString();
        this.a.h.setText(r6);
        setContentDescription(this.a.g.getText() + ", " + r6);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
