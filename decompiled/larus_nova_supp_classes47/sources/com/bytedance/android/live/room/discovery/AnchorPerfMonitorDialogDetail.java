package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfMonitorDialogDetail;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfMonitorDialogDetail extends CommonBottomDialog {
    public ArrayAdapter<CharSequence> a;
    public final List<CharSequence> b;

    public static final class a implements LiveBottomSheetDialog.m {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorDialogDetail a;

        public b(AnchorPerfMonitorDialogDetail r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public final int getLayoutId() {
        return 2131565372;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setBottomSheetSlideProcessor(a.a);
        int r5 = b1.a;
        b1.b(true, new AnchorPerfMonitorDialogDetail$initDialogUI$1(this));
        ImageView r6 = (ImageView) findViewById(2131363762);
        if (r6 == null) goto L5;
        r6.setOnClickListener(new b(this));
    L5:
        this.a = new ArrayAdapter(getContext(), 2131565131, this.b);
        ListView r7 = (ListView) findViewById(2131378057);
        if (r7 == null) goto L9;
        r7.setAdapter(this.a);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorPerfMonitorDialogDetail(Context r3, List<? extends CharSequence> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "records");
        super(r3, true, false);
        this.b = r4;
    }
}
