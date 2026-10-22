package com.bytedance.android.livesdk.interactivity.comment.utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/utils/LiveCommentInterceptTipDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommentInterceptTipDialog extends DialogFragment {
    public String d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LiveCommentInterceptTipDialog a;

        public a(LiveCommentInterceptTipDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public LiveCommentInterceptTipDialog() {
        this.d = BuildConfig.FLAVOR;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        View r5 = getView();
        Button r6 = null;
        if (r5 == null) goto L5;
        TextView r7 = (TextView) r5.findViewById(2131388723);
    L6:
        if (r7 == null) goto L8;
        r7.setText("通过jsb:" + this.d + "调用直播发评能力进行快捷发评时，该jsb请求缺失有效request_source参数，请联系zhangwen.wendyys或zhaofei.hym");
    L8:
        View r8 = getView();
        if (r8 == null) goto L11;
        r6 = (Button) r8.findViewById(2131365114);
    L11:
        if (r6 == null) goto L14;
        r6.setOnClickListener(new a(this));
        return;
    L14:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565319, null, false);
    }
}
