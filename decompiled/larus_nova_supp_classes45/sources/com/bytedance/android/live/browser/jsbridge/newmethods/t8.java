package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.browser.jsbridge.base.OpenGalleryResultModel;
import com.bytedance.android.livesdk.widget.FullScreenImageViewDialog;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openGallery")
public final class t8 extends w20.k4<w20.jc, OpenGalleryResultModel> {
    public FullScreenImageViewDialog a;

    public final void onTerminate() {
        FullScreenImageViewDialog r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r0);
    L20:
        this.a = null;
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L20
    }

    public t8() {
    }

    public final void invoke(Object r5, CallContext r6) throws Exception {
        w20.jc r7 = (w20.jc) r5;
        List<String> r0 = r7.a();
        Integer r8 = r7.b();
        if (r8 != null) goto L5;
        r6.getContext();
        IllegalArgumentException r9 = new IllegalArgumentException();
        com.bytedance.android.live.core.utils.f2.b(2131921650, 0);
        finishWithFailure(r9);
        return;
    L5:
        int r11 = r8.intValue();
        if (r11 < r0.size()) goto L8;
        r6.getContext();
        IndexOutOfBoundsException r12 = new IndexOutOfBoundsException();
        com.bytedance.android.live.core.utils.f2.b(2131921650, 0);
        finishWithFailure(r12);
        return;
    L8:
        String r13 = (String) ListProtector.get(r0, r11);
        FullScreenImageViewDialog r1 = new FullScreenImageViewDialog(r6.getContext());
        this.a = r1;
        s8 r14 = new s8(this);
        ImageRequest r15 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r13)).build();
        DataSource r16 = ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(r15, r1.getContext());
        r16.subscribe(new com.bytedance.android.livesdk.widget.x(r1, r14), UiThreadImmediateExecutorService.getInstance());
        r1.setOnDismissListener(new com.bytedance.android.livesdk.widget.v(r1, r16));
        FullScreenImageViewDialog r17 = this.a;
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r17);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r17);
        r17.show();
        DialogLancet.afterDialogShow(r17);
    }
}
