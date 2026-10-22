package com.bytedance.android.live.liveinteract.widget.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/LinkDistributionHelpDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkDistributionHelpDialog extends LiveDialogFragment implements View.OnClickListener {
    public Map<Integer, View> d;
    public final Lazy e;
    public HybridCard f;
    public final String g;
    public final a h;

    public interface a {
        void onBackPressed();
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class c extends b7.a {
        public final /* synthetic */ LinkDistributionHelpDialog a;

        public c(LinkDistributionHelpDialog r1) {
            this.a = r1;
        }

        public final void onLoadSuccess(View r4) {
            LinkDistributionHelpDialog r5 = this.a;
            View r0 = r5.f;
            if (r0 == null) goto L17;
            LiveDoubleColorBallAnimationView r2 = r5.S90(2131379091);
            if (r2 == null) goto L7;
            r2.c();
        L7:
            LiveDoubleColorBallAnimationView r1 = r5.S90(2131379091);
            if (r1 == null) goto L10;
            r1.setVisibility(8);
        L10:
            FrameLayout r3 = (FrameLayout) r5.S90(2131393122);
            if (r3 == null) goto L13;
            r3.removeAllViews();
        L13:
            FrameLayout r6 = (FrameLayout) r5.S90(2131393122);
            if (r6 == null) goto L18;
            r6.addView(r0);
            return;
        L18:
            return;
        }
    }

    public final boolean onBackPressed() {
        dismiss();     // Catch: Exception -> L4
    L8:
        a r0 = this.h;
        if (r0 == null) goto L12;
        r0.onBackPressed();
    L12:
        return super.onBackPressed();
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L8;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        HybridCard r0 = this.f;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setGravity(80);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        c1.b(r5, 0, 14);
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 == null) goto L4;
        Integer r4 = Integer.valueOf(r3.getId());
    L5:
        if (r4 != null) goto L8;
    L10:
        if (r4 != null) goto L13;
        return;
    L13:
        if (r4.intValue() != 2131366972) goto L24;
        dismiss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L25;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L25:
        return;
    L24:
        return;
    L8:
        if (r4.intValue() != 2131381793) goto L10;
        onBackPressed();
        return;
    L4:
        r4 = null;
        goto L5
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setBottomSheetSlideProcessor(b.a);
    }

    public LinkDistributionHelpDialog(String r2, l.a r3) {
        Intrinsics.checkNotNullParameter(r2, "mHelpUrl");
        this.g = r2;
        this.h = r3;
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(LinkDistributionHelpDialog$webViewManager$2.INSTANCE);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ImageView r5 = (ImageView) S90(2131381793);
        if (r5 == null) goto L5;
        r5.setOnClickListener(this);
    L5:
        View r6 = S90(2131366972);
        if (r6 == null) goto L8;
        r6.setOnClickListener(this);
    L8:
        LiveDoubleColorBallAnimationView r7 = S90(2131379091);
        if (r7 == null) goto L11;
        r7.setVisibility(0);
    L11:
        LiveDoubleColorBallAnimationView r8 = S90(2131379091);
        if (r8 == null) goto L14;
        r8.b();
    L14:
        IBaseBrowserService r9 = (IBaseBrowserService) this.e.getValue();
        Context r10 = getContext();
        if (r10 == null) goto L21;
        HybridCard r11 = r9.getHybridCard((Activity) r10, x6.a.b(this.g), new c(this));
        this.f = r11;
        if (r11 == null) goto L22;
        a7.a.a(r11, null, null, 3);
        return;
    L22:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565584, r3, false);
    }
}
