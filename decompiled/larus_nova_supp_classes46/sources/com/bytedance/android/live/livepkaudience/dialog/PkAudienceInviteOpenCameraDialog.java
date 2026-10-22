package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.r2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkAudienceInviteOpenCameraDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "b", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudienceInviteOpenCameraDialog extends LiveDialogFragment {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> d;
    public final CompositeDisposable e;
    public final int f;
    public b g;
    public Room h;

    public static final class a {
    }

    public interface b {
        void a();

        void onRefuse();
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkAudienceInviteOpenCameraDialog a;

        public c(PkAudienceInviteOpenCameraDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            PkAudienceInviteOpenCameraDialog r4 = this.a;
            int r0 = PkAudienceInviteOpenCameraDialog.i;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L17;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L18;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ PkAudienceInviteOpenCameraDialog a;

        public d(PkAudienceInviteOpenCameraDialog r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a.f) - r6.longValue());
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PkAudienceInviteOpenCameraDialog a;

        public e(PkAudienceInviteOpenCameraDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            ((TextView) this.a.S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf((int) r6.longValue())}));
            if (r6.longValue() == 0) goto L12;
            return;
        L12:
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L15;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public PkAudienceInviteOpenCameraDialog() {
        this.d = new LinkedHashMap();
        this.e = new CompositeDisposable();
        this.f = 9;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.dispose();
        ((LinkedHashMap) this.d).clear();
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
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new c(this));
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        ((TextView) S90(2131384151)).setOnClickListener(x0.a(new AnonymousClass1(this)));
        ((TextView) S90(2131361963)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        HSImageView r6 = S90(2131374209);
        Room r0 = this.h;
        if (r0 == null) goto L7;
        User r1 = r0.getOwner();
        if (r1 == null) goto L7;
        py.k r2 = r1._avatarMedium;
    L8:
        ImageLoader.bindImage(r6, r2, new l3(5));
        r2.a(S90(2131374268), UtilityKotlinExtentionsKt.i(4));
        ((TextView) S90(2131384151)).setText(s1.C(2131917997, new Object[]{Integer.valueOf(this.f)}));
        this.e.add(du2.a.d(1, TimeUnit.SECONDS).take(this.f + 1).map(new d(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)));
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565731, r3, false);
    }
}
