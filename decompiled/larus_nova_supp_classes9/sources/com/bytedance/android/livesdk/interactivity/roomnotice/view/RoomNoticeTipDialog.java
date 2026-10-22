package com.bytedance.android.livesdk.interactivity.roomnotice.view;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.gd0;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomnotice/view/RoomNoticeTipDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomNoticeTipDialog extends LiveDialogFragment {
    public static final a e = null;
    public Map<Integer, View> d;

    public static final class a {
        public a() {
        }

        public static Observable a() {
            ImageModel r0 = new ImageModel();
            r0.mUrls = ArraysKt.toMutableList(new String[]{(String) gd0.a.getValue()});
            return a1.k(r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RoomNoticeTipDialog a;

        public b(RoomNoticeTipDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RoomNoticeTipDialog a;

        public c(RoomNoticeTipDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Bitmap r4 = (Bitmap) r3;
            if (r4 == null) goto L7;
            this.a.S90(2131381023).setImageBitmap(r4);
            return;
        }
    }

    static {
        e = new a();
    }

    public RoomNoticeTipDialog() {
        this.d = new LinkedHashMap();
        setNoTitleAndCancelOutside(true);
    }

    public final void onDestroyView() {
        super.onDestroyView();
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
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ((TextView) S90(2131381028)).setOnClickListener(new b(this));
        if ((S90(2131381023).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.LayoutParams r5 = S90(2131381023).getLayoutParams();
        if (r5 == null) goto L8;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        r6.height = (int) (((s1.y() - r6.leftMargin) - r6.rightMargin) * 0.53061223f);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ImageLoader.bindImage(S90(2131381023), (String) gd0.a.getValue());
        e.getClass();
        a.a().subscribe(new c(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565764, r3, false);
    }
}
