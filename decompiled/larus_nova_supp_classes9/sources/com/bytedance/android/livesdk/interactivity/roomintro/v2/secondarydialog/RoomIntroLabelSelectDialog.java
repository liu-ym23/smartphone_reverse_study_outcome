package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.arch.mvvm.f;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.LabelGroup;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.SelectLabelView;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/secondarydialog/RoomIntroLabelSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIntroLabelSelectDialog extends LiveDialogFragment {
    public static final /* synthetic */ int j = 0;
    public RoomIntroDataSource d;
    public Integer e;
    public View f;
    public TextView g;
    public ViewGroup h;
    public final CompositeDisposable i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RoomIntroLabelSelectDialog a;

        public b(RoomIntroLabelSelectDialog r1) {
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

    static {
    }

    public RoomIntroLabelSelectDialog() {
        this.i = new CompositeDisposable();
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
        setShouldUseNewPanel(true);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        this.i.clear();     // Catch: Throwable -> L7
        RoomIntroDataSource r3 = this.d;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.h.a(Unit.INSTANCE);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        Integer r13 = this.e;
        if (r13 == null) goto L7;
        int r14 = r13.intValue();
        View r15 = this.f;
        if (r15 == null) goto L7;
        a1.k(r15, r14);
    L7:
        RoomIntroDataSource r16 = this.d;
        if (r16 == null) goto L16;
        PropertyOwner r17 = r16.j;
        if (r17 == null) goto L16;
        Observable r18 = f.b(r17);
        if (r18 == null) goto L16;
        Disposable r19 = r18.subscribe(new c(this));
        if (r19 == null) goto L16;
        RxUtilKt.c(r19, this.i);
    L16:
        RoomIntroDataSource r110 = this.d;
        if (r110 == null) goto L51;
        List<LabelGroup> r111 = r110.p;
        if (r111 == null) goto L64;
        Iterator<T> r112 = r111.iterator();
    L22:
        if (r112.hasNext() == false) goto L65;
        LabelGroup r113 = (LabelGroup) r112.next();
        View r0 = LayoutInflater.from(getContext()).inflate(2131567440, this.h, false);
        if (r0 == null) goto L22;
        TextView r1 = (TextView) r0.findViewById(2131374015);
        if (r1 == null) goto L29;
        r1.setText(r113.getGroupText());
    L29:
        final WrapLineFlowLayout r2 = r0.findViewById(2131385814);
        if (r2 == null) goto L22;
        List<RoomIntroLabel> r114 = r113.getLabels();
        if (r114 == null) goto L48;
        Iterator<T> r115 = r114.iterator();
    L36:
        if (r115.hasNext() == false) goto L48;
        RoomIntroLabel r3 = (RoomIntroLabel) r115.next();
        final SelectLabelView r4 = new SelectLabelView(r2.getContext(), null, 6, 0);
        r2.addView(r4);
        Intrinsics.checkNotNullParameter(r3, "label");
        r4.d = r3;
        String r5 = r3.getTypeName();
        String r6 = BuildConfig.FLAVOR;
        if (r5 != null) goto L40;
        r5 = BuildConfig.FLAVOR;
    L40:
        String r7 = r3.getLabelText();
        if (r7 == null) goto L44;
        r6 = r7;
    L44:
        TextView r8 = r4.c;
        if (r8 == null) goto L47;
        r8.setText(r5 + 65306 + r6);
    L47:
        r4.a(r3.getSelected());
        r4.setOnClickListener(x0.a(new RoomIntroLabelSelectDialog$createLabelGroupLayout$$inlined$forEach$lambda$1(r4, this, r2)));
    L48:
        ViewGroup r116 = this.h;
        if (r116 == null) goto L22;
        r116.addView(r0);
        goto L22
    L65:
        return;
    L64:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565755, r3, false);
        this.f = r5;
        ViewGroup r6 = null;
        if (r5 == null) goto L5;
        TextView r7 = (TextView) r5.findViewById(2131388772);
    L6:
        this.g = r7;
        View r8 = this.f;
        if (r8 == null) goto L9;
        r6 = (ViewGroup) r8.findViewById(2131388098);
    L9:
        this.h = r6;
        View r9 = this.f;
        if (r9 == null) goto L15;
        View r10 = r9.findViewById(2131363779);
        if (r10 == null) goto L15;
        r10.setOnClickListener(new b(this));
    L15:
        return this.f;
    L5:
        r7 = null;
        goto L6
    }
}
