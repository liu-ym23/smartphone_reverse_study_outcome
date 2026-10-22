package com.larus.voicecall.impl.scene;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.av_call.constant.ThemeType;
import com.larus.platform.model.audio.RealtimeCallSceneModeHelloConfig;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.y;
import com.larus.voicecall.impl.databinding.LarusFragmentSceneBoardBinding;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 82\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\rH\u0016J\u001a\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/voicecall/impl/scene/RealtimeCallSceneBoard;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/voicecall/impl/databinding/LarusFragmentSceneBoardBinding;", "sceneAdapter", "Lcom/larus/voicecall/impl/scene/RealtimeCallSceneAdapter;", "isDisplaySingle", NameKeys.UnloadStrategy_No_Strategy, "tag", NameKeys.UnloadStrategy_No_Strategy, "userClickTraceId", NameKeys.UnloadStrategy_No_Strategy, "sceneManager", "Lcom/larus/voicecall/impl/scene/IRealtimeCallSceneManager;", "getSceneManager", "()Lcom/larus/voicecall/impl/scene/IRealtimeCallSceneManager;", "setSceneManager", "(Lcom/larus/voicecall/impl/scene/IRealtimeCallSceneManager;)V", "dialogListener", "Lcom/larus/voicecall/impl/scene/RealtimeCallSceneBoard$CustomDialogListener;", "getDialogListener", "()Lcom/larus/voicecall/impl/scene/RealtimeCallSceneBoard$CustomDialogListener;", "setDialogListener", "(Lcom/larus/voicecall/impl/scene/RealtimeCallSceneBoard$CustomDialogListener;)V", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "getThemeType", "()Lcom/larus/av_call/constant/ThemeType;", "setThemeType", "(Lcom/larus/av_call/constant/ThemeType;)V", "dismissRunnable", "Ljava/lang/Runnable;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "getTheme", "onViewCreated", "view", "setUpTalkBackClose", "setUpRecyclerView", "setUpObservers", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "CustomDialogListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSceneBoard extends BottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public LarusFragmentSceneBoardBinding d;
    public RealtimeCallSceneAdapter e;
    public boolean f;
    public final String g;
    public int h;
    public com.larus.voicecall.impl.scene.b i;
    public b j;
    public ThemeType k;
    public final f l;

    public static final class a {
    }

    public interface b {
        void a();

        void onDialogDismiss();
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(g r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954339;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voicecall.impl.scene.f] */
    public RealtimeCallSceneBoard() {
        this.g = "RealtimeCallSceneBoard";
        this.k = ThemeType.DEFAULT;
        this.l = new f(this);
    }

    public static void S90(RealtimeCallSceneBoard r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r4);
        e2 r0 = e2.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L7:
        if (r0.a(r2, r4) == false) goto L10;
        S90(this);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void onCreate(Bundle r7) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r7);
        Keva r8 = c78.a.g;
        boolean r1 = true;
        if (r8.getBoolean("key_first_open_scene_board", true) == false) goto L9;
        FLogger.a.i(this.g, "[onCreate] first open board");
        r8.storeBoolean("key_first_open_scene_board", false);
        RealtimeCallUtil.a.getClass();
        if (((RealtimeCallSceneModeHelloConfig) RealtimeCallUtil.p.getValue()).getEnableSceneGuide() == false) goto L9;
        com.larus.voicecall.impl.scene.b r9 = this.i;
        if (r9 == null) goto L9;
        r9.n();
    L9:
        int r10 = m0.a;
        if (m0.b(getContext()) <= c7.a(v19.c.b(2130971452, null, 2131167273))) goto L13;
        r1 = false;
    L13:
        this.f = r1;
        b r11 = this.j;
        if (r11 == null) goto L17;
        r11.a();
        return;
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L8
        b r0 = this.j;     // Catch: Throwable -> L8
        if (r0 == null) goto L5;
        r0.onDialogDismiss();     // Catch: Throwable -> L8
    L5:
        SoftReference r1 = y.a;     // Catch: Throwable -> L8
        f r2 = this.l;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r2, "action");     // Catch: Throwable -> L8
        y.a(r2);     // Catch: Throwable -> L8
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voicecall.impl.scene.g] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.larus.voicecall.impl.scene.d] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.larus.voicecall.impl.scene.e] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        BottomSheetDialog r12 = getDialog();
        if ((r12 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r13 = r12;
    L6:
        if (r13 == null) goto L8;
        View r14 = r13.findViewById(2131368870);
    L9:
        com.larus.voicecall.impl.scene.b r15 = this.i;
        if (r15 == null) goto L14;
        List<m> r16 = r15.a();
        if (r16 == null) goto L14;
        int r17 = r16.size();
    L15:
        int r1 = (c7.a(v19.c.b(2130971266, null, 2131166902)) + c7.a(v19.c.b(2130971299, null, 2131166968))) + c7.a(v19.c.b(2130971299, null, 2131166968));
        if (this.f == false) goto L18;
        int r2 = c7.a(v19.c.b(2130971543, null, 2131167455));
        int r6 = c7.a(v19.c.b(2130971163, null, 2131166696));
        int r3 = (((r2 + r6) * r17) - r6) + r1;
    L19:
        int r4 = RangesKt.coerceAtMost(r3, c7.a(v19.c.b(2130971509, null, 2131167386)));
        FLogger r5 = FLogger.a;
        r5.i(this.g, "[onViewCreated] isDisplaySingle: " + this.f + ", modeSize: " + r17 + ", height:" + r4);
        if (r14 == null) goto L22;
        ViewGroup.LayoutParams r18 = r14.getLayoutParams();
        r18.height = r4;
        r14.setLayoutParams(r18);
        BottomSheetBehavior r19 = BottomSheetBehavior.from(r14);
        r14.setBackgroundResource(R.color.transparent);
        r19.setState(3);
        r19.setPeekHeight(r4);
    L22:
        final int r110 = c7.a(v19.c.b(2130971163, null, 2131166696));
        LarusFragmentSceneBoardBinding r111 = this.d;
        if (r111 == null) goto L36;
        RecyclerView r112 = r111.c;
        if (r112 == null) goto L36;
        if (this.f == false) goto L29;
        r112.setLayoutManager(new LinearLayoutManager(r112.getContext()));
        r112.addItemDecoration(new RealtimeCallSceneBoard$setUpRecyclerView$1$1(r110));
    L30:
        ThemeType r7 = this.k;
        com.larus.voicecall.impl.scene.b r0 = this.i;
        if (r0 == null) goto L34;
        List<m> r8 = r0.a();
        if (r8 == null) goto L34;
    L35:
        RealtimeCallSceneAdapter r113 = new RealtimeCallSceneAdapter(r7, r8, new d(this), new e(this), this.f);
        this.e = r113;
        r112.setAdapter(r113);
    L34:
        r8 = CollectionsKt.emptyList();
        goto L35
    L29:
        r112.setLayoutManager(new GridLayoutManager(r112.getContext(), 2));
        r112.addItemDecoration(new RealtimeCallSceneBoard$setUpRecyclerView$1$2(r110));
    L36:
        com.larus.voicecall.impl.scene.b r114 = this.i;
        if (r114 == null) goto L42;
        MutableLiveData r115 = r114.getCurrentScene();
        if (r115 == null) goto L42;
        r115.observe(getViewLifecycleOwner(), new c(new g(this)));
    L42:
        if (z2.a.fixRealtimeTalkbackEnable() == true) goto L44;
        r5.w(this.g, "fixRealtimeTalkbackEnable is false");
        return;
    L44:
        Dialog r116 = getDialog();
        if (r116 == null) goto L49;
        View r117 = r116.findViewById(2131385148);
        if (r117 == null) goto L49;
        r117.setContentDescription(getString(2131898809));
        r117.setOnClickListener(new h(this));
        return;
    L49:
        r5.w(this.g, "setUpTalkBackClose onclick view is null");
        return;
    L18:
        int r9 = c7.a(v19.c.b(2130971563, null, 2131167495));
        int r20 = c7.a(v19.c.b(2130971163, null, 2131166696));
        r3 = ((((r17 + 1) / 2) * (r9 + r20)) - r20) + r1;
    L14:
        r17 = 0;
        goto L15
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562432, r10, false);
        int r13 = 2131364319;
        View r14 = ViewBindings.findChildViewById(r12, 2131364319);
        if (r14 == null) goto L23;
        r13 = 2131384070;
        RecyclerView r3 = ViewBindings.findChildViewById(r12, 2131384070);
        if (r3 == null) goto L23;
        r13 = 2131385147;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r12, 2131385147);
        if (r6 == null) goto L23;
        r13 = 2131385148;
        View r7 = ViewBindings.findChildViewById(r12, 2131385148);
        if (r7 == null) goto L23;
        LarusFragmentSceneBoardBinding r15 = new LarusFragmentSceneBoardBinding((LinearLayout) r12, r14, r3, r6, r7);
        this.d = r15;
        Application r16 = c4a.f.a;
        ThemeType r17 = this.k;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r17, "themeType");
        if (i88.e.o(r17) == false) goto L16;
        r14.setBackgroundResource(2131239565);
        if (r17 != ThemeType.DEFAULT) goto L15;
        r7.setBackgroundResource(2131239563);
        r6.setBackgroundColor(ColorProtector.parseColor("#333333"));
    L17:
        LarusFragmentSceneBoardBinding r18 = this.d;
        if (r18 != null) goto L24;
        return null;
    L24:
        return r18.a;
    L15:
        r7.setBackgroundResource(2131239562);
        r6.setBackgroundColor(ColorProtector.parseColor("#383838"));
        goto L17
    L16:
        r14.setBackgroundResource(2131239564);
        r7.setBackgroundResource(2131239561);
        r6.setBackgroundColor(ColorProtector.parseColor("#FFFFFF"));
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
