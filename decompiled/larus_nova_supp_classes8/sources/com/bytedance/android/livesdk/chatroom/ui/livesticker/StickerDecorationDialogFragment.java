package com.bytedance.android.livesdk.chatroom.ui.livesticker;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.e3;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter.StickerDecorationFragmentPagerAdapter;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.android.material.tabs.TabLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/StickerDecorationDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerDecorationDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int h = 0;
    public Map<Integer, View> d;
    public e3 e;
    public DataCenter f;
    public final CompositeDisposable g;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public b() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final boolean shouldInterceptSlide(int r1) {
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ StickerDecorationDialogFragment a;

        public c(StickerDecorationDialogFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((h1) r2).a == 7) goto L5;
            return;
        L5:
            if (this.a.isShowing() == true) goto L14;
            return;
        L14:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L18;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public StickerDecorationDialogFragment() {
        this.d = new LinkedHashMap();
        setNoTitleAndCancelOutside(true);
        this.g = new CompositeDisposable();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.g.clear();
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

    public final void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        Dialog r7 = getDialog();
        if (r7 == null) goto L12;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L12;
        if (isVertical() == false) goto L9;
        int r0 = 80;
    L10:
        r8.setGravity(r0);
        r8.setSoftInputMode(32);
        r8.setLayout(-1, -1);
        goto L12
    L9:
        r0 = 8388613;
    L12:
        if (getHost() == null) goto L20;
        ViewPager r1 = S90(2131387343);
        if (r1 == null) goto L16;
        r1.setAdapter(new StickerDecorationFragmentPagerAdapter(getChildFragmentManager(), this.f, this.e));
    L16:
        TabLayout r2 = S90(2131387342);
        if (r2 == null) goto L21;
        r2.setupWithViewPager(S90(2131387343));
        return;
    L21:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        DataCenter r4 = this.f;
        if (r4 == null) goto L5;
        boolean r5 = z.m(r4, true);
    L6:
        setVertical(r5);
        if (isVertical() == false) goto L9;
        int r6 = 2131954816;
    L10:
        setStyle(1, r6);
        setBottomSheetSlideProcessor(new b());
        this.g.add(xs2.b.a().b(h1.class).subscribe(new c(this)));
        return;
    L9:
        r6 = 2131954817;
        goto L10
    L5:
        r5 = true;
        goto L6
    }

    public final void T90(FragmentManager r3, e3 r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "StickerDecorationDialogFragment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L12;
    L7:
        if (r4 == null) goto L9;
        this.e = r4;
    L9:
        int r5 = com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.a;
        NewBroadcastMonitor.a r6 = NewBroadcastMonitor.c("ttlive_anchor_sticker_panel_event", null, null, 14);
        r6.l(1);
        r6.a().report();
        return;
    L12:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        super.show(r3, "StickerDecorationDialogFragment");
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567474, r3, false);
    }
}
