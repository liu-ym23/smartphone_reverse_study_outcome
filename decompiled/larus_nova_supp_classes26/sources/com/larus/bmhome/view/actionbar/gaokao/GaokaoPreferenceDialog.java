package com.larus.bmhome.view.actionbar.gaokao;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.databinding.LarusDialogGaokaoPreferenceBinding;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoPreferenceAdapter;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoPreferenceItemDecoration;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoProvinceAdapter;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoProvince;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.MaxHeightScrollView;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0012\u0010&\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010'\u001a\u00020#H\u0002J\u001c\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\r2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010+\u001a\u00020#H\u0003J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020#H\u0002J\u0018\u00103\u001a\u0004\u0018\u00010\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J\u001c\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010=\u001a\u00020\u0015H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020#H\u0002J\u0012\u0010@\u001a\u00020#2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\rH\u0002J\b\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u00020FH\u0002J\b\u0010N\u001a\u00020FH\u0002J\u0014\u0010O\u001a\u0004\u0018\u00010\r2\b\u0010P\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010Q\u001a\u00020\u0015H\u0002J\b\u0010R\u001a\u00020#H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010I\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bJ\u0010K¨\u0006T"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/GaokaoPreferenceDialog;", "Landroidx/fragment/app/Fragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusDialogGaokaoPreferenceBinding;", "mTypeList", "", "Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoType;", "mProvinceList", "Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoProvince;", "mPostGradPreferenceList", "", "mProvinceAdapter", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter;", "mSingleSelectAdapter", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter;", "mMultiSelectAdapter", "mPostGradPreferenceAdapter", "mIsReadyForRank", "", "mIsValid", "mCurrentRankJob", "Lkotlinx/coroutines/Job;", "isFinishing", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "startSlideInBottom", "initView", "refreshView", "provinceKey", "provinceName", "initViewClickListener", "getTextToSend", "clearInputFocus", "getSelectedSubjectString", "getSelectedPreferencesString", "calculator", "Lcom/larus/bmhome/view/actionbar/gaokao/GaokaoRankCalculator;", "tryCalculateRank", "getSubjectForRank", "singleSelectSubject", "setupDialogWindow", "mHasInitImeInsetsListener", "initImeInsetsListener", "updatePreferenceScrollMaxHeight", "validate", "isReadyForRank", "isScoreValid", "scoreStr", "showToast", "isGaokaoScoreProvided", "hideKeyboard", "scrollToBottom", "scrollView", "Landroid/widget/ScrollView;", "getGaokaoType", "gaokaoProvinceKey", "getScreenHeight", "", "getStringByResId", "resId", "navBarHeight", "getNavBarHeight", "()I", "navBarHeight$delegate", "Lkotlin/Lazy;", "getNavigationBarHeight", "trimScore", "score", "isProvinceRankDisabled", "finishDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoPreferenceDialog extends Fragment implements by7.e {
    public static final /* synthetic */ int s = 0;
    public LarusDialogGaokaoPreferenceBinding d;
    public List<GaokaoType> e;
    public List<GaokaoProvince> f;
    public List<String> g;
    public GaokaoProvinceAdapter h;
    public GaokaoPreferenceAdapter i;
    public GaokaoPreferenceAdapter j;
    public GaokaoPreferenceAdapter k;
    public boolean l;
    public boolean m;
    public Job n;
    public boolean o;
    public final GaokaoRankCalculator p;
    public boolean q;
    public final Lazy r;

    public static final class a {
    }

    static {
    }

    public final void T90() {
        this.o = true;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.finish();
        return;
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final void S90() {
        LarusDialogGaokaoPreferenceBinding r0 = this.d;
        EditText r1 = null;
        if (r0 == null) goto L5;
        EditText r2 = r0.r;
    L6:
        if (r0 == null) goto L8;
        r1 = r0.q;
    L8:
        boolean r3 = false;
        if (r2 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L21;
        if (r1 != null) goto L17;
    L19:
        if (r3 == true) goto L21;
        return;
    L17:
        if (r1.hasFocus() != true) goto L19;
        r3 = true;
    L21:
        hideKeyboard();
        if (r2 == null) goto L24;
        r2.clearFocus();
    L24:
        if (r1 == null) goto L27;
        r1.clearFocus();
        return;
    L27:
        return;
    L11:
        if (r2.hasFocus() != true) goto L13;
        r4 = true;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final int V90() {
        return ((Number) this.r.getValue()).intValue();
    }

    public final int W90() {
        Resources r0 = AppHost.a.getApplication().getResources();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).heightPixels;
    }

    public final boolean Y90() {
        GaokaoProvinceAdapter r0 = this.h;
        if (r0 == null) goto L7;
        GaokaoProvince r1 = r0.g;
        if (r1 == null) goto L7;
        String r2 = r1.getDisableRank();
    L9:
        return Intrinsics.areEqual(r2, "1");
    L7:
        r2 = null;
        goto L9
    }

    public final boolean Z90() {
        LarusDialogGaokaoPreferenceBinding r0 = this.d;
        if (r0 == null) goto L9;
        RecyclerView r1 = r0.s;
        if (r1 == null) goto L9;
        if (r1.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L19;
        GaokaoPreferenceAdapter r3 = this.i;
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == true) goto L19;
        return false;
    L14:
        if (((ArrayList) r3.y2()).size() != 1) goto L16;
        r4 = true;
    L19:
        LarusDialogGaokaoPreferenceBinding r5 = this.d;
        if (r5 == null) goto L26;
        RecyclerView r6 = r5.b;
        if (r6 == null) goto L26;
        if (r6.getVisibility() != 0) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == false) goto L38;
        GaokaoPreferenceAdapter r8 = this.j;
        Integer r9 = null;
        if (r8 == null) goto L31;
        Integer r10 = Integer.valueOf(((ArrayList) r8.y2()).size());
    L32:
        GaokaoPreferenceAdapter r11 = this.j;
        if (r11 == null) goto L36;
        r9 = Integer.valueOf(r11.b);
    L36:
        if (Intrinsics.areEqual(r10, r9) == true) goto L38;
        return false;
    L31:
        r10 = null;
    L38:
        LarusDialogGaokaoPreferenceBinding r12 = this.d;
        if (r12 == null) goto L53;
        EditText r13 = r12.r;
        if (r13 == null) goto L53;
        Editable r14 = r13.getText();
        if (r14 == null) goto L53;
        if (r14.length() != 0) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L51;
        return false;
    L51:
        if (aa0(this, r14.toString()) == true) goto L53;
        return false;
    L47:
        r15 = false;
    L53:
        return true;
    L26:
        r7 = false;
    L9:
        r2 = false;
        goto L10
    }

    public final void da0() {
        if (this.o == false) goto L6;
        return;
    L6:
        if (Y90() == false) goto L9;
        return;
    L9:
        if (Z90() == true) goto L11;
        return;
    L11:
        Context r0 = getContext();
        if (r0 == null) goto L24;
        LarusDialogGaokaoPreferenceBinding r1 = this.d;
        if (r1 == null) goto L18;
        EditText r2 = r1.r;
        if (r2 == null) goto L18;
        Editable r3 = r2.getText();
    L19:
        String r4 = String.valueOf(r3);
        Job r5 = this.n;
        if (r5 == null) goto L22;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L22:
        this.n = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getIO(), null, new GaokaoPreferenceDialog$tryCalculateRank$1$1(this, r0, r4, null), 2, null);
        return;
    L18:
        r3 = null;
        goto L19
    }

    public final void ea0() {
        if (this.o == false) goto L5;
        return;
    L5:
        boolean r0 = Z90();
        boolean r1 = Y90();
        boolean r2 = false;
        if (r0 == false) goto L23;
        LarusDialogGaokaoPreferenceBinding r5 = this.d;
        if (r5 == null) goto L12;
        EditText r6 = r5.r;
        if (r6 == null) goto L12;
        Editable r7 = r6.getText();
    L13:
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L20:
        if ((!r8) == false) goto L23;
        r2 = true;
        goto L23
    L15:
        if (StringsKt.isBlank(r7) == true) goto L18;
        r8 = false;
    L12:
        r7 = null;
    L23:
        if (r0 == this.l) goto L37;
        this.l = r0;
        if (r0 == true) goto L37;
        Job r3 = this.n;
        if (r3 == null) goto L29;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L29:
        this.n = null;
        if (r1 == true) goto L37;
        LarusDialogGaokaoPreferenceBinding r4 = this.d;
        if (r4 == null) goto L37;
        EditText r9 = r4.q;
        if (r9 == null) goto L37;
        r9.setText(null);
    L37:
        if (r2 == this.m) goto L48;
        this.m = r2;
        if (r2 == false) goto L41;
        int r10 = v19.c.b(2130970676, getContext(), 2131239100);
    L42:
        LarusDialogGaokaoPreferenceBinding r11 = this.d;
        if (r11 == null) goto L49;
        TextView r12 = r11.g;
        if (r12 == null) goto L50;
        r12.setBackgroundResource(r10);
        return;
    L50:
        return;
    L49:
        return;
    L41:
        r10 = v19.c.b(2130970675, getContext(), 2131239097);
        goto L42
    }

    public final void onDestroyView() {
        Job r0 = this.n;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.n = null;
        super.onDestroyView();
    }

    public GaokaoPreferenceDialog() {
        this.p = new GaokaoRankCalculator();
        this.r = LazyKt.lazy(new j(this));
    }

    public final void hideKeyboard() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L17;
        View r1 = r0.getCurrentFocus();
        if (r1 == null) goto L19;
        FragmentActivity r2 = getActivity();
        InputMethodManager r3 = null;
        if (r2 == null) goto L10;
        Object r4 = r2.getSystemService("input_method");
    L12:
        if ((r4 instanceof InputMethodManager) == false) goto L14;
        r3 = (InputMethodManager) r4;
    L14:
        if (r3 == null) goto L18;
        r3.hideSoftInputFromWindow(r1.getWindowToken(), 0);
        return;
    L18:
        return;
    L10:
        r4 = null;
        goto L12
    L19:
        return;
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public static String X90(int r1) {
        return AppHost.a.getApplication().getString(r1);
    }

    public static String ca0(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.length() > 1) goto L8;
        return r5;
    L8:
        if (StringsKt.startsWith$default(r5, TriggerSendLoading.NO_LOADING, false, 2, null) == true) goto L10;
        return r5;
    L10:
        return ca0(StringsKt.removeRange(r5, 0, 1).toString());
    }

    public final GaokaoType U90(String r13) {
        List<GaokaoProvince> r0 = this.f;
        if (r0 == null) goto L27;
        Iterator<T> r1 = r0.iterator();
    L5:
        Object r2 = null;
        if (r1.hasNext() == false) goto L10;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((GaokaoProvince) r3).getKey(), r13) == false) goto L5;
    L11:
        GaokaoProvince r4 = (GaokaoProvince) r3;
        if (r4 == null) goto L27;
        List<GaokaoType> r14 = this.e;
        if (r14 == null) goto L25;
        Iterator<T> r15 = r14.iterator();
    L18:
        if (r15.hasNext() == false) goto L22;
        Object r5 = r15.next();
        if (Intrinsics.areEqual(((GaokaoType) r5).getCode(), r4.getTypeCode()) == false) goto L18;
        r2 = r5;
    L22:
        GaokaoType r6 = (GaokaoType) r2;
        if (r6 == null) goto L25;
        return r6;
    L25:
        return new GaokaoType(null, null, null, null, null, null, 63, null);
    L10:
        r3 = null;
    L27:
        return new GaokaoType(null, null, null, null, null, null, 63, null);
    }

    public static boolean aa0(GaokaoPreferenceDialog r10, String r11) {
        if (r11 != null) goto L5;
        r10.getClass();
        return false;
    L5:
        GaokaoProvinceAdapter r1 = r10.h;
        if (r1 == null) goto L19;
        GaokaoProvince r2 = r1.g;
        if (r2 == null) goto L19;
        String r3 = r2.getMaxScore();
        if (r3 == null) goto L19;
        int r12 = CastIntegerProtector.parseInt(r11);     // Catch: NumberFormatException -> L21
        if (r12 > CastIntegerProtector.parseInt(r3)) goto L15;
        if (r12 < 0) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == true) goto L25;
        String r4 = X90(2131911135);
        t19.s r5 = t19.s.a;
        Context r6 = r10.getContext();
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        t19.s.j(r5, r6, String.format(r4, Arrays.copyOf(new Object[]{r3}, 1)), null, false, 28);
    L25:
        return r13;
    L15:
        r13 = false;
    L19:
        return true;
    }

    public final void ba0(String r11, String r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r12 != null) goto L6;
        return;
    L6:
        List<GaokaoProvince> r0 = this.f;
        if (r0 == null) goto L18;
        Iterator<T> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((GaokaoProvince) r2).getKey(), r11) == false) goto L10;
    L15:
        GaokaoProvince r3 = (GaokaoProvince) r2;
        if (r3 == null) goto L18;
        String r4 = r3.getDisableRank();
    L19:
        boolean r5 = true;
        if (Intrinsics.areEqual(r4, "1") == false) goto L26;
        LarusDialogGaokaoPreferenceBinding r6 = this.d;
        if (r6 == null) goto L31;
        EditText r7 = r6.q;
        if (r7 == null) goto L31;
        r7.setEnabled(true);
        r7.setHint(X90(2131906011));
    L31:
        GaokaoType r13 = U90(r11);
        LarusDialogGaokaoPreferenceBinding r8 = this.d;
        if (r8 == null) goto L36;
        TextView r9 = r8.j;
        if (r9 == null) goto L36;
        r9.setText(r12);
    L36:
        LarusDialogGaokaoPreferenceBinding r14 = this.d;
        if (r14 == null) goto L57;
        TextView r15 = r14.t;
        if (r15 == null) goto L57;
        String r10 = r13.getCode();
        if (r10 != null) goto L43;
    L56:
        r15.setVisibility(0);
        r15.setText(X90(2131911139));
        goto L57
    L43:
        switch(r10.hashCode()) {
            case 49: goto L53;
            case 50: goto L49;
            case 51: goto L46;
            default: goto L56;
        };
    L46:
        if (r10.equals("3") == false) goto L56;
    L51:
        r15.setVisibility(8);
        goto L57
    L49:
        if (r10.equals("2") == true) goto L51;
    L53:
        if (r10.equals("1") == false) goto L56;
        r15.setVisibility(0);
        r15.setText(X90(2131911136));
    L57:
        LarusDialogGaokaoPreferenceBinding r16 = this.d;
        if (r16 == null) goto L78;
        TextView r17 = r16.c;
        if (r17 == null) goto L78;
        String r18 = r13.getCode();
        if (r18 != null) goto L64;
    L77:
        r17.setVisibility(8);
        goto L78
    L64:
        switch(r18.hashCode()) {
            case 49: goto L74;
            case 50: goto L70;
            case 51: goto L67;
            default: goto L77;
        };
    L67:
        if (r18.equals("3") == false) goto L77;
    L72:
        r17.setVisibility(0);
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;
        r17.setText(String.format(X90(2131911138), Arrays.copyOf(new Object[]{r13.getName()}, 1)));
        goto L78
    L70:
        if (r18.equals("2") == true) goto L72;
    L74:
        if (r18.equals("1") == false) goto L77;
        r17.setVisibility(0);
        r17.setText(X90(2131911137));
    L78:
        LarusDialogGaokaoPreferenceBinding r110 = this.d;
        if (r110 == null) goto L113;
        RecyclerView r111 = r110.s;
        if (r111 == null) goto L113;
        String r20 = r13.getCode();
        if (r20 != null) goto L85;
    L99:
        List<String> r21 = r13.getSelectedMajor();
        if (r21 == null) goto L102;
        List r22 = CollectionsKt.filterNotNull(r21);
    L103:
        List r23 = r22;
        if (r23 != null) goto L106;
    L109:
        boolean r24 = true;
    L110:
        if (r24 == false) goto L112;
        r111.setVisibility(8);
        this.i = null;
        goto L113
    L112:
        r111.setVisibility(0);
        GaokaoPreferenceAdapter r25 = new GaokaoPreferenceAdapter(r22, 1, new e(this));
        this.i = r25;
        r111.setAdapter(r25);
        goto L113
    L106:
        if (r23.isEmpty() == true) goto L109;
        r24 = false;
    L102:
        r22 = null;
        goto L103
    L85:
        switch(r20.hashCode()) {
            case 49: goto L94;
            case 50: goto L91;
            case 51: goto L88;
            default: goto L99;
        };
    L88:
        if (r20.equals("3") == true) goto L102;
    L91:
        if (r20.equals("2") == true) goto L102;
    L94:
        if (r20.equals("1") == false) goto L99;
        List<String> r26 = r13.getSelectedMajor();
        if (r26 == null) goto L102;
        r22 = CollectionsKt.filterNotNull(r26);
    L113:
        LarusDialogGaokaoPreferenceBinding r112 = this.d;
        if (r112 == null) goto L157;
        RecyclerView r113 = r112.b;
        if (r113 == null) goto L158;
        String r27 = r13.getCode();
        int r28 = 3;
        if (r27 != null) goto L120;
        List r114 = null;
    L138:
        List r29 = r114;
        if (r29 != null) goto L141;
    L144:
        if (r5 == false) goto L146;
        r113.setVisibility(8);
        this.j = null;
        return;
    L146:
        r113.setVisibility(0);
        GaokaoPreferenceAdapter r30 = new GaokaoPreferenceAdapter(r114, r28, new f(this));
        this.j = r30;
        r113.setAdapter(r30);
        return;
    L141:
        if (r29.isEmpty() == true) goto L144;
        r5 = false;
        goto L144
    L120:
        switch(r27.hashCode()) {
            case 49: goto L132;
            case 50: goto L126;
            case 51: goto L123;
            default: goto L153;
        };
    L153:
        r114 = null;
        goto L138
    L123:
        if (r27.equals("3") == false) goto L154;
    L128:
        List<String> r115 = r13.getSelectedMajor();
        if (r115 == null) goto L151;
        r114 = CollectionsKt.filterNotNull(r115);
        goto L138
    L151:
        r114 = null;
        goto L138
    L154:
        r114 = null;
        goto L138
    L126:
        if (r27.equals("2") == true) goto L128;
        r114 = null;
        goto L138
    L132:
        if (r27.equals("1") == false) goto L156;
        List<String> r116 = r13.getReselectedMajor();
        r28 = 2;
        if (r116 == null) goto L152;
        r114 = CollectionsKt.filterNotNull(r116);
        goto L138
    L152:
        r114 = null;
        goto L138
    L156:
        r114 = null;
        goto L138
    L158:
        return;
    L157:
        return;
    L26:
        LarusDialogGaokaoPreferenceBinding r31 = this.d;
        if (r31 == null) goto L31;
        EditText r32 = r31.q;
        if (r32 == null) goto L31;
        r32.setEnabled(false);
        r32.setHint(X90(2131911130));
        goto L31
    L14:
        r2 = null;
    L18:
        r4 = null;
        goto L19
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        LarusDialogGaokaoPreferenceBinding r8 = this.d;
        if (r8 == null) goto L7;
        AppCompatImageView r9 = r8.f;
        if (r9 == null) goto L7;
        e1.d(r9, new k(this));
    L7:
        LarusDialogGaokaoPreferenceBinding r10 = this.d;
        if (r10 == null) goto L12;
        ConstraintLayout r11 = r10.a;
        if (r11 == null) goto L12;
        e1.d(r11, new m(this));
    L12:
        LarusDialogGaokaoPreferenceBinding r12 = this.d;
        if (r12 == null) goto L17;
        AppCompatImageView r13 = r12.m;
        if (r13 == null) goto L17;
        e1.d(r13, new n(this));
    L17:
        LarusDialogGaokaoPreferenceBinding r14 = this.d;
        if (r14 == null) goto L22;
        View r15 = r14.n;
        if (r15 == null) goto L22;
        e1.d(r15, new o(this));
    L22:
        LarusDialogGaokaoPreferenceBinding r16 = this.d;
        if (r16 == null) goto L27;
        ConstraintLayout r17 = r16.i;
        if (r17 == null) goto L27;
        e1.d(r17, new p(this));
    L27:
        LarusDialogGaokaoPreferenceBinding r18 = this.d;
        if (r18 == null) goto L32;
        EditText r19 = r18.r;
        if (r19 == null) goto L32;
        r19.setOnTouchListener(new q(this));
    L32:
        LarusDialogGaokaoPreferenceBinding r20 = this.d;
        if (r20 == null) goto L37;
        EditText r21 = r20.q;
        if (r21 == null) goto L37;
        r21.setOnTouchListener(new r(this));
    L37:
        LarusDialogGaokaoPreferenceBinding r22 = this.d;
        if (r22 == null) goto L42;
        EditText r23 = r22.r;
        if (r23 == null) goto L42;
        r23.addTextChangedListener(new s(this));
    L42:
        LarusDialogGaokaoPreferenceBinding r24 = this.d;
        if (r24 == null) goto L47;
        EditText r25 = r24.r;
        if (r25 == null) goto L47;
        r25.setOnFocusChangeListener(new b(this));
    L47:
        LarusDialogGaokaoPreferenceBinding r26 = this.d;
        if (r26 == null) goto L52;
        TextView r27 = r26.g;
        if (r27 == null) goto L52;
        e1.d(r27, new c(this));
    L52:
        LarusDialogGaokaoPreferenceBinding r28 = this.d;
        if (r28 == null) goto L57;
        LinearLayout r29 = r28.u;
        if (r29 == null) goto L57;
        e1.d(r29, new d(this));
    L57:
        LarusDialogGaokaoPreferenceBinding r30 = this.d;
        if (r30 == null) goto L62;
        LinearLayout r31 = r30.l;
        if (r31 == null) goto L62;
        e1.d(r31, new l(this));
    L62:
        FragmentActivity r32 = requireActivity();
        if (r32 == null) goto L78;
        Window r33 = r32.getWindow();
        if (r33 == null) goto L78;
        WindowManager.LayoutParams r0 = r33.getAttributes();
        r33.setLayout(-1, -1);
        r33.setBackgroundDrawable(new ColorDrawable(0));
        r33.clearFlags(2);
        View r1 = r33.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L72;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L72;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L72:
        r1.setPadding(0, 0, 0, 0);
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 29) goto L75;
        r33.setNavigationBarContrastEnforced(false);
    L75:
        r33.addFlags(Integer.MIN_VALUE);
        if (r3 <= 28) goto L78;
        r0.layoutInDisplayCutoutMode = 1;
    L78:
        LarusDialogGaokaoPreferenceBinding r34 = this.d;
        LinearLayout r4 = null;
        if (r34 == null) goto L87;
        MaxHeightScrollView r35 = r34.k;
        if (r35 == null) goto L87;
        int r36 = RangesKt.coerceAtLeast(((W90() - V90()) - getResources().getDimensionPixelSize(v19.c.b(2130971512, null, 2131167393))) - getResources().getDimensionPixelSize(v19.c.b(2130971155, null, 2131166679)), 0);
        if (r36 > getResources().getDimensionPixelSize(v19.c.b(2130971515, null, 2131167398))) goto L87;
        r35.setMaxHeight(r36);
    L87:
        LarusDialogGaokaoPreferenceBinding r37 = this.d;
        if (r37 == null) goto L90;
        r4 = r37.u;
    L90:
        if (r4 == null) goto L94;
        Animation r38 = AnimationUtils.loadAnimation(getActivity(), 2130772408);
        r38.setAnimationListener(new t(r4));
        r4.startAnimation(r38);
        return;
    }

    /* JADX WARN: Type inference failed for: r10v10, types: [com.larus.bmhome.view.actionbar.gaokao.a] */
    public final View onCreateView(LayoutInflater r29, ViewGroup r30, Bundle r31) {
        Intrinsics.checkNotNullParameter(r29, "inflater");
        ConstraintLayout r0 = r29.inflate(2131562078, r30, false);
        int r2 = 2131373586;
        RecyclerView r7 = ViewBindings.findChildViewById(r0, 2131373586);
        if (r7 == null) goto L159;
        r2 = 2131373587;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131373587);
        if (r8 == null) goto L159;
        r2 = 2131373588;
        RecyclerView r9 = ViewBindings.findChildViewById(r0, 2131373588);
        if (r9 == null) goto L159;
        r2 = 2131373589;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131373589);
        if (r10 == null) goto L159;
        r2 = 2131373590;
        AppCompatImageView r11 = ViewBindings.findChildViewById(r0, 2131373590);
        if (r11 == null) goto L159;
        r2 = 2131373591;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131373591);
        if (r12 == null) goto L159;
        r2 = 2131373592;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131373592);
        if (r13 == null) goto L159;
        r2 = 2131373593;
        ConstraintLayout r14 = ViewBindings.findChildViewById(r0, 2131373593);
        if (r14 == null) goto L159;
        r2 = 2131373594;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131373594);
        if (r15 == null) goto L159;
        r2 = 2131373595;
        if (ViewBindings.findChildViewById(r0, 2131373595) == null) goto L159;
        r2 = 2131373596;
        MaxHeightScrollView r16 = ViewBindings.findChildViewById(r0, 2131373596);
        if (r16 == null) goto L159;
        r2 = 2131373597;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131373597);
        if (r17 == null) goto L159;
        r2 = 2131373598;
        AppCompatImageView r18 = ViewBindings.findChildViewById(r0, 2131373598);
        if (r18 == null) goto L159;
        r2 = 2131373599;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131373599)) == null) goto L159;
        r2 = 2131373600;
        View r19 = ViewBindings.findChildViewById(r0, 2131373600);
        if (r19 == null) goto L159;
        r2 = 2131373601;
        RecyclerView r20 = ViewBindings.findChildViewById(r0, 2131373601);
        if (r20 == null) goto L159;
        r2 = 2131373602;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131373602);
        if (r21 == null) goto L159;
        r2 = 2131373603;
        EditText r22 = (EditText) ViewBindings.findChildViewById(r0, 2131373603);
        if (r22 == null) goto L159;
        r2 = 2131373604;
        EditText r23 = (EditText) ViewBindings.findChildViewById(r0, 2131373604);
        if (r23 == null) goto L159;
        r2 = 2131373605;
        RecyclerView r24 = ViewBindings.findChildViewById(r0, 2131373605);
        if (r24 == null) goto L159;
        r2 = 2131373606;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r0, 2131373606);
        if (r25 == null) goto L159;
        r2 = 2131384822;
        LinearLayout r26 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131384822);
        if (r26 == null) goto L159;
        this.d = new LarusDialogGaokaoPreferenceBinding(r0, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        Bundle r1 = getArguments();
        if (r1 == null) goto L49;
        String r3 = r1.getString("current_province_key");
    L50:
        Bundle r4 = getArguments();
        if (r4 == null) goto L53;
        String r5 = r4.getString("current_province_name");
    L54:
        boolean r6 = true;
        if (r3 != null) goto L57;
    L60:
        boolean r27 = true;
    L160:
        Bundle r28 = getArguments();     // Catch: Throwable -> L152
        if (r28 == null) goto L64;
        ArrayList r32 = r28.getParcelableArrayList("type_list");     // Catch: Throwable -> L152
    L65:
        this.e = r32;     // Catch: Throwable -> L152
        Bundle r33 = getArguments();     // Catch: Throwable -> L152
        if (r33 == null) goto L68;
        ArrayList r34 = r33.getParcelableArrayList("province_list");     // Catch: Throwable -> L152
    L69:
        this.f = r34;     // Catch: Throwable -> L152
        Bundle r35 = getArguments();     // Catch: Throwable -> L152
        if (r35 == null) goto L72;
        ArrayList<String> r36 = r35.getStringArrayList("post_grad_preference_list");     // Catch: Throwable -> L152
    L73:
        this.g = r36;     // Catch: Throwable -> L152
        if (r27 == false) goto L86;
        List<GaokaoProvince> r37 = this.f;
        if (r37 == null) goto L78;
        GaokaoProvince r38 = (GaokaoProvince) CollectionsKt.firstOrNull(r37);
    L79:
        if (r38 == null) goto L81;
        String r39 = r38.getKey();
    L82:
        if (r38 == null) goto L84;
        String r40 = r38.getProvince();
    L85:
        String r210 = r39;
        r5 = r40;
        r3 = r210;
        goto L86
    L84:
        r40 = null;
        goto L85
    L81:
        r39 = null;
        goto L82
    L78:
        r38 = null;
    L86:
        LarusDialogGaokaoPreferenceBinding r41 = this.d;
        if (r41 == null) goto L96;
        LinearLayout r42 = r41.h;
        if (r42 == null) goto L96;
        ViewGroup.LayoutParams r43 = r42.getLayoutParams();
        if ((r43 instanceof LinearLayout.LayoutParams) == false) goto L93;
        LinearLayout.LayoutParams r44 = (LinearLayout.LayoutParams) r43;
    L94:
        if (r44 == null) goto L96;
        r44.bottomMargin = V90();
        goto L96
    L93:
        r44 = null;
    L96:
        LarusDialogGaokaoPreferenceBinding r45 = this.d;
        if (r45 == null) goto L109;
        RecyclerView r46 = r45.o;
        if (r46 == null) goto L109;
        r46.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        List<GaokaoProvince> r47 = this.f;
        if (r47 != null) goto L103;
        T90();
        goto L109
    L103:
        GaokaoProvinceAdapter r48 = new GaokaoProvinceAdapter(r47, r3, r27, new com.larus.bmhome.view.actionbar.gaokao.a(this));
        this.h = r48;
        r46.setAdapter(r48);
        ViewGroup.LayoutParams r49 = r46.getLayoutParams();
        if ((r49 instanceof LinearLayout.LayoutParams) == false) goto L106;
        LinearLayout.LayoutParams r50 = (LinearLayout.LayoutParams) r49;
    L107:
        if (r50 == null) goto L109;
        r50.bottomMargin = V90();
        goto L109
    L106:
        r50 = null;
    L109:
        LarusDialogGaokaoPreferenceBinding r51 = this.d;
        if (r51 == null) goto L114;
        RecyclerView r52 = r51.s;
        if (r52 == null) goto L114;
        r52.setLayoutManager(new GridLayoutManager(getContext(), 2));
        r52.addItemDecoration(new GaokaoPreferenceItemDecoration(2, getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462))));
    L114:
        LarusDialogGaokaoPreferenceBinding r53 = this.d;
        if (r53 == null) goto L119;
        RecyclerView r54 = r53.b;
        if (r54 == null) goto L119;
        r54.setLayoutManager(new GridLayoutManager(getContext(), 3));
        r54.addItemDecoration(new GaokaoPreferenceItemDecoration(3, getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462))));
    L119:
        List<String> r55 = this.g;
        if (r55 != null) goto L122;
    L125:
        if (r6 == false) goto L136;
        LarusDialogGaokaoPreferenceBinding r56 = this.d;
        if (r56 == null) goto L131;
        TextView r57 = r56.e;
        if (r57 == null) goto L131;
        r57.setVisibility(8);
    L131:
        LarusDialogGaokaoPreferenceBinding r58 = this.d;
        if (r58 == null) goto L151;
        RecyclerView r59 = r58.d;
        if (r59 == null) goto L151;
        r59.setVisibility(8);
    L151:
        ba0(r3, r5);
    L154:
        LarusDialogGaokaoPreferenceBinding r60 = this.d;
        if (r60 != null) goto L157;
        return null;
    L157:
        return r60.a;
    L136:
        LarusDialogGaokaoPreferenceBinding r61 = this.d;
        if (r61 == null) goto L141;
        TextView r62 = r61.e;
        if (r62 == null) goto L141;
        r62.setVisibility(0);
    L141:
        LarusDialogGaokaoPreferenceBinding r63 = this.d;
        if (r63 == null) goto L146;
        RecyclerView r64 = r63.d;
        if (r64 == null) goto L146;
        r64.setVisibility(0);
    L146:
        LarusDialogGaokaoPreferenceBinding r65 = this.d;
        if (r65 == null) goto L151;
        RecyclerView r66 = r65.d;
        if (r66 == null) goto L151;
        r66.setLayoutManager(new GridLayoutManager(getContext(), 3));
        r66.addItemDecoration(new GaokaoPreferenceItemDecoration(3, getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462))));
        GaokaoPreferenceAdapter r67 = new GaokaoPreferenceAdapter(r55, r55.size(), null);
        this.k = r67;
        r66.setAdapter(r67);
        goto L151
    L122:
        if (r55.isEmpty() == true) goto L125;
        r6 = false;
        goto L125
    L72:
        r36 = null;
        goto L73
    L68:
        r34 = null;
        goto L69
    L64:
        r32 = null;
    L152:
        th = move-exception;
        FLogger.a.e("GaokaoPreferenceDialog", "wrong typeList or provinceList format", th);
        T90();
        goto L154
    L57:
        if (StringsKt.isBlank(r3) == true) goto L60;
        r27 = false;
        goto L160
    L53:
        r5 = null;
        goto L54
    L49:
        r3 = null;
    L159:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    }
}
