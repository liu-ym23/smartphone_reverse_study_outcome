package com.bytedance.android.live.openplatform.impl.base.view.settingdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformBottomDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/OpenPlatformBottomSettingDialog;", "Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformBottomDialog;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OpenPlatformBottomSettingDialog extends OpenPlatformBottomDialog {
    public Map<Integer, View> d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OpenPlatformBottomSettingDialog a;

        public a(OpenPlatformBottomSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.X90();
        }
    }

    public abstract List<SettingItemView> V90();

    public abstract String W90();

    public void S90() {
        this.d.clear();
    }

    public final View U90() {
        View r0 = new View(getContext());
        r0.setBackgroundColor(s1.h(2131107351));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        return r0;
    }

    public OpenPlatformBottomSettingDialog() {
        this.d = new LinkedHashMap();
    }

    public void X90() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public View T90(int r3) {
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

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        ((TextView) T90(2131388920)).setText(W90());
        ((ImageView) T90(2131366984)).setOnClickListener(new a(this));
        Iterator<T> r7 = V90().iterator();
        int r8 = 0;
    L4:
        if (r7.hasNext() == false) goto L12;
        Object r0 = r7.next();
        int r1 = r8 + 1;
        if (r8 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        SettingItemView r2 = (SettingItemView) r0;
        if (r8 == 0) goto L11;
        ((LinearLayout) T90(2131385987)).addView(U90());
    L11:
        ((LinearLayout) T90(2131385987)).addView(r2);
        r8 = r1;
        goto L4
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565685, r3, false);
    }
}
