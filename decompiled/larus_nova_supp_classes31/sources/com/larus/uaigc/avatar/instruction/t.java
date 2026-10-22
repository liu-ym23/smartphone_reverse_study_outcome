package com.larus.uaigc.avatar.instruction;

import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t {

    public static final class a extends BaseControllerListener<Object> {
        public final /* synthetic */ FrameLayout a;

        public a(FrameLayout r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            FLogger.a.i("DigitalAvatarTemplateListSelectorWidget", "cover image failed");
            super.onFailure(r4, r5);
            e1.x(this.a);
        }

        public final void onSubmit(String r4, Object r5) {
            FLogger.a.i("DigitalAvatarTemplateListSelectorWidget", "cover image submit");
            super.onSubmit(r4, r5);
            e1.o(this.a);
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            super.onFinalImageSet(r2, r3, r4);
            FLogger.a.i("DigitalAvatarTemplateListSelectorWidget", "cover image set");
            if (r3 == null) goto L6;
            e1.x(this.a);
            return;
        }
    }

    public static final void a(LarusItemActionbarImageTemplateCoverHolderV2Binding r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "cover");
        final SimpleDraweeView r0 = r3.c;
        final FrameLayout r5 = r3.d;
        ImageLoaderKt.y(r0, r4, "custom_actionbar_icon_instruction", new s(r0, r5), 4);
    }

    public static final void b(LarusItemActionbarImageTemplateCoverHolderV2Binding r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "label");
        r1.e.setText(r2);
    }
}
