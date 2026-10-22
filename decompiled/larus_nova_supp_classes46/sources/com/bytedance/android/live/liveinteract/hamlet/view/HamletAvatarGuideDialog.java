package com.bytedance.android.live.liveinteract.hamlet.view;

import android.app.Dialog;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/view/HamletAvatarGuideDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HamletAvatarGuideDialog extends LiveDialogFragment {
    public static final /* synthetic */ int e = 0;
    public HSImageView d;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public b() {
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            r5.setAnimationBackend(new com.bytedance.android.live.liveinteract.hamlet.view.a(r5.getAnimationBackend()));
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ HamletAvatarGuideDialog a;

        public c(HamletAvatarGuideDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        HSImageView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setController(null);
        return;
    }

    public HamletAvatarGuideDialog() {
    }

    public final void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L8;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L9;
        r6.setLayout(-1, -1);
        WindowManager.LayoutParams r0 = r6.getAttributes();
        r0.height = s1.w() - s1.A();
        r6.setAttributes(r0);
        r6.setGravity(80);
        r6.clearFlags(1024);
        r6.setDimAmount(0.34f);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954578);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        this.d = r3.findViewById(2131376172);
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        String r6 = r5.getString("ARG_HAMLET_AVATAR_GUIDE_FILE");
        if (r6 == null) goto L9;
        Uri r7 = UriProtector.parse("file://".concat(r6));
        PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setControllerListener(new b());
        r0.setUri(r7);
        HSImageView r8 = this.d;
        if (r8 == null) goto L9;
        r8.setController(r0.build());
    L9:
        TextView r9 = (TextView) r3.findViewById(2131367267);
        if (r9 == null) goto L13;
        r9.setOnClickListener(new c(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565187, r3, false);
    }
}
