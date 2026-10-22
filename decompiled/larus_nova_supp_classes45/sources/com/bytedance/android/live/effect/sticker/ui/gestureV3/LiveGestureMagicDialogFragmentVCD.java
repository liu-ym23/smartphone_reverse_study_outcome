package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.BaseDialogFragmentV2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/gestureV3/LiveGestureMagicDialogFragmentVCD;", "Lcom/bytedance/android/live/BaseDialogFragmentV2;", "", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGestureMagicDialogFragmentVCD extends BaseDialogFragmentV2 {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> d;
    public final LiveEffectContextFactoryDelegate$Type e;
    public List<EffectCategoryResponse> f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LiveGestureMagicDialogFragmentVCD a;

        public c(LiveGestureMagicDialogFragmentVCD r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveGestureMagicDialogFragmentVCD r3 = this.a;
            int r0 = LiveGestureMagicDialogFragmentVCD.i;
            r3.U90();
        }
    }

    public static final class d implements k.i {
        public final /* synthetic */ LiveGestureMagicDialogFragmentVCD a;

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void b() {
            if (LiveGestureMagicDialogFragmentVCD.T90(this.a) == true) goto L5;
            return;
        L5:
            this.a.S90(2131387318).showError();
        }

        public d(LiveGestureMagicDialogFragmentVCD r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void a(EffectChannelResponse r9) {
            if (LiveGestureMagicDialogFragmentVCD.T90(this.a) == true) goto L6;
            return;
        L6:
            if (r9 == null) goto L33;
            List r1 = r9.getCategoryResponseList();
            if (r1 == null) goto L33;
            if (r1.isEmpty() == true) goto L33;
            this.a.f = r9.getCategoryResponseList();
            this.a.S90(2131387318).reset();
            this.a.S90(2131387318).setVisibility(8);
            LiveGestureMagicPageAdapterVCD r0 = (LiveGestureMagicPageAdapterVCD) this.a.g.getValue();
            List<EffectCategoryResponse> r2 = r9.getCategoryResponseList();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r2, "categoryResponseList");
            r0.b = r2;
            Iterator r3 = ((HashMap) r0.e).entrySet().iterator();
        L14:
            if (r3.hasNext() == false) goto L25;
            Map.Entry r4 = (Map.Entry) r3.next();
            int r5 = ((Number) r4.getKey()).intValue();
            RecyclerView.LayoutManager r6 = ((RecyclerView) r4.getValue()).getLayoutManager();
            if ((r6 instanceof LinearLayoutManager) == true) goto L18;
            r6 = null;
        L18:
            LinearLayoutManager r7 = (LinearLayoutManager) r6;
            if (r7 == null) goto L14;
            View r8 = r7.getChildAt(0);
            if (r8 == null) goto L14;
            r0.f.put(Integer.valueOf(r5), new Integer[]{Integer.valueOf(r7.getPosition(r8)), Integer.valueOf(r8.getLeft())});
            goto L14
        L25:
            r0.notifyDataSetChanged();
            if (r9.getCategoryResponseList().size() < 3) goto L42;
            Dialog r11 = this.a.getDialog();
            if (r11 == null) goto L43;
            Window r12 = r11.getWindow();
            if (r12 == null) goto L44;
            r12.setLayout(-1, s1.f(272.0f));
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L33:
            this.a.S90(2131387318).showEmpty();
        }
    }

    static {
    }

    public LiveGestureMagicDialogFragmentVCD() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.g = LazyKt.lazy(new LiveGestureMagicDialogFragmentVCD$gestureMagicPageAdapter$2(this));
        this.h = LazyKt.lazy(new LiveGestureMagicDialogFragmentVCD$liveComposerManager$2(this));
    }

    public final void U90() {
        S90(2131387318).showLoading();
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.e).b().r().l(d0.b, new d(this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        U90();
    }

    public static final boolean T90(LiveGestureMagicDialogFragmentVCD r1) {
        if (r1.isAdded() == true) goto L5;
    L10:
        return false;
    L5:
        if (r1.isHidden() == true) goto L10;
        if (r1.getView() == null) goto L10;
        return true;
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
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        r5.setLayout(-1, s1.f(208.0f));
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954665);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        S90(2131387318).setOnClickListener(b.a);
        View r7 = LayoutInflater.from(getContext()).inflate(2131565944, null, false);
        r7.setOnClickListener(new c(this));
        S90(2131387318).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setUseProgressBar((int) UIUtils.dip2Px(getContext(), 56.0f)).setErrorView(r7));
        S90(2131373635).setAdapter((LiveGestureMagicPageAdapterVCD) this.g.getValue());
        S90(2131373635).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        LiveGestureMagicPageAdapterVCD r8 = (LiveGestureMagicPageAdapterVCD) this.g.getValue();
        e r9 = new e(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "gestureSelectChangeListener");
        r8.a = r9;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565858, r3, false);
    }
}
