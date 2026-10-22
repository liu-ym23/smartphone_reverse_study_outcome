package com.ss.android.lark.custom.repeat;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.custom.repeat.entity.EventRecurrence;
import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import com.ss.android.lark.custom.repeat.widget.bottom.container.CustomRepeatBottomContainer;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import com.ss.android.lark.ui.CommonTitleBar;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ^2\u00020\u0001:\u0002^_B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0016J&\u0010B\u001a\u0004\u0018\u00010%2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u001a\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020%2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010K\u001a\u000201H\u0002J\b\u0010L\u001a\u000201H\u0002J\b\u0010M\u001a\u000201H\u0002J\u0006\u0010N\u001a\u000201J\b\u0010O\u001a\u000201H\u0002J \u0010P\u001a\u0012\u0012\u0004\u0012\u00020R0Qj\b\u0012\u0004\u0012\u00020R`S2\u0006\u0010T\u001a\u000207H\u0002J\b\u0010U\u001a\u000201H\u0002J\b\u0010V\u001a\u000201H\u0002J\b\u0010W\u001a\u000201H\u0002J\b\u0010X\u001a\u000201H\u0002J\b\u0010Y\u001a\u000201H\u0002J\u000e\u0010Z\u001a\u0002012\u0006\u0010A\u001a\u00020\u0007J\u0006\u0010[\u001a\u000204J\u0006\u0010\\\u001a\u000201J\b\u0010]\u001a\u000201H\u0002R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010!\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001e\u0010$\u001a\u0004\u0018\u00010%8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010+8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u0002070@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", Keys.API_PARAM_KEY_ACTION, "Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment$CustomRepeatFragmentAction;", "repeatData", "Lcom/ss/android/lark/custom/repeat/entity/CustomRepeatData;", "(Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment$CustomRepeatFragmentAction;Lcom/ss/android/lark/custom/repeat/entity/CustomRepeatData;)V", "customRepeatBottomContainerFromXml", "Lcom/ss/android/lark/custom/repeat/widget/bottom/container/CustomRepeatBottomContainer;", "getCustomRepeatBottomContainerFromXml", "()Lcom/ss/android/lark/custom/repeat/widget/bottom/container/CustomRepeatBottomContainer;", "setCustomRepeatBottomContainerFromXml", "(Lcom/ss/android/lark/custom/repeat/widget/bottom/container/CustomRepeatBottomContainer;)V", "customRepeatTitleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getCustomRepeatTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setCustomRepeatTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "wheelRepeatWeekNoFromXml", "Lcom/ss/android/lark/custom/repeat/widget/wheelview/WheelView;", "getWheelRepeatWeekNoFromXml", "()Lcom/ss/android/lark/custom/repeat/widget/wheelview/WheelView;", "setWheelRepeatWeekNoFromXml", "(Lcom/ss/android/lark/custom/repeat/widget/wheelview/WheelView;)V", "wheelRepeatWeeksFromXml", "getWheelRepeatWeeksFromXml", "setWheelRepeatWeeksFromXml", "customWheelRepeatNumFromXml", "getCustomWheelRepeatNumFromXml", "setCustomWheelRepeatNumFromXml", "customWheelRepeatFrequencyUnitFromXml", "getCustomWheelRepeatFrequencyUnitFromXml", "setCustomWheelRepeatFrequencyUnitFromXml", "bottomContainerDividerFromXml", "Landroid/view/View;", "getBottomContainerDividerFromXml", "()Landroid/view/View;", "setBottomContainerDividerFromXml", "(Landroid/view/View;)V", "tvRepeatRuleFromXml", "Landroid/widget/TextView;", "getTvRepeatRuleFromXml", "()Landroid/widget/TextView;", "setTvRepeatRuleFromXml", "(Landroid/widget/TextView;)V", "clearFromXmlViewCache", BuildConfig.FLAVOR, "onDestroyView", "isFromLocalRecover", BuildConfig.FLAVOR, "customRepeatAction", "repeatFreIndex", BuildConfig.FLAVOR, "repeatNumAdapter", "Lcom/ss/android/lark/custom/repeat/adapter/CustomNumericWheelAdapter;", "repeatFreAdapter", "Lcom/ss/android/lark/custom/repeat/adapter/StringWheelAdapter;", "repeatFreSingularAdapter", "repeatMode", "Lcom/ss/android/lark/custom/repeat/entity/RepeatMode;", "repeatModelTypes", "Landroid/util/SparseArray;", "customRepeatData", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "initWeekContainer", "initTitleBar", "refreshPickerViewData", "initData", "getPluralListByNum", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "number", "refreshBottomContainerData", "initListener", "refreshBottomContainer", "refreshRepeatRule", "initWheelView", "refreshData", "onBackPressed", "clear", "initRepeatModeAndRefresh", "Companion", "CustomRepeatFragmentAction", "custom-repeat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseCustomRepeatFragment extends Fragment {
    public static final /* synthetic */ int u = 0;
    public CustomRepeatBottomContainer d;
    public CommonTitleBar e;
    public WheelView f;
    public WheelView g;
    public WheelView h;
    public WheelView i;
    public View j;
    public TextView k;
    public final boolean l;
    public final b m;
    public int n;
    public mab.b o;
    public mab.f p;
    public mab.f q;
    public final RepeatMode r;
    public final SparseArray<Integer> s;
    public final nab.a t;

    public static final class a {
    }

    public interface b {
        void a(EventRecurrence r1);

        void onBackPressed();
    }

    static {
    }

    public final View S90() {
        View r0 = this.j;
        if (r0 != null) goto L9;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131364439);
    L8:
        this.j = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final CustomRepeatBottomContainer T90() {
        View r0 = this.d;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368426);
    L8:
        this.d = (CustomRepeatBottomContainer) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (CustomRepeatBottomContainer) r0;
    }

    public final CommonTitleBar U90() {
        View r0 = this.e;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368428);
    L8:
        this.e = (CommonTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (CommonTitleBar) r0;
    }

    public final WheelView V90() {
        View r0 = this.i;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368484);
    L8:
        this.i = (WheelView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WheelView) r0;
    }

    public final WheelView W90() {
        View r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368485);
    L8:
        this.h = (WheelView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WheelView) r0;
    }

    public final void Y90() {
        this.r.setRepeatType(this.s.get(0).intValue());
        RepeatMode r0 = this.r;
        mab.b r1 = this.o;
        mab.f r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repeatNumAdapter");
        r1 = null;
    L5:
        r0.setInterval(r1.b(0).intValue());
        this.n = 0;
        WheelView r2 = V90();
        mab.f r4 = this.q;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("repeatFreSingularAdapter");
    L9:
        r2.setAdapter(r3);
        W90().setCurrentItem(0);
        V90().setCurrentItem(0);
        ba0();
        return;
    L8:
        r3 = r4;
        goto L9
    }

    public final void Z90() {
        int r0 = this.n;
        if (r0 != 0) goto L5;
        this.r.setRepeatType(7);
        T90().setVisibility(8);
        S90().setVisibility(8);
        return;
    L5:
        if (r0 != 1) goto L7;
        this.r.setRepeatType(8);
        T90().setVisibility(0);
        S90().setVisibility(0);
        T90().f();
        return;
    L7:
        if (r0 != 2) goto L9;
        T90().setVisibility(0);
        S90().setVisibility(0);
        T90().e();
        return;
    L9:
        if (r0 == 3) goto L11;
        this.r.setRepeatType(7);
        T90().setVisibility(8);
        S90().setVisibility(8);
        return;
    L11:
        T90().setVisibility(8);
        S90().setVisibility(8);
    }

    public final void ba0() {
        String r0 = qab.b.a(this.r.toER().toString(), this.t.i);
        View r1 = this.k;
        if (r1 != null) goto L9;
        View r2 = getView();
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131391287);
    L8:
        this.k = (TextView) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        ((TextView) r1).setText(r0);
    }

    public ChooseCustomRepeatFragment() {
        this.r = new RepeatMode();
        this.s = new SparseArray();
        this.t = new nab.a(0);
        this.l = true;
    }

    public final void aa0() {
        T90().setCustomRepeatData(this.t);
        T90().setFirstDayOfWeek(this.t.b);
        CustomRepeatBottomContainer r0 = T90();
        nab.a r1 = this.t;
        r0.d(r1.f, r1.a);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public final ArrayList<String> X90(int r4) {
        ArrayList<String> r0 = new ArrayList();
        r0.add(qab.c.b(getContext(), 2131755015, r4));
        r0.add(qab.c.b(getContext(), 2131755017, r4));
        r0.add(qab.c.b(getContext(), 2131755016, r4));
        r0.add(qab.c.b(getContext(), 2131755018, r4));
        return r0;
    }

    public ChooseCustomRepeatFragment(ChooseRepeatFragment.a r4, nab.a r5) {
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r5, "repeatData");
        RepeatMode r0 = new RepeatMode();
        this.r = r0;
        this.s = new SparseArray();
        this.t = new nab.a(0);
        this.l = false;
        this.m = r4;
        this.t = r5;
        r0.setIsSingleInWeek(r5.c);
        r0.setIsSingleInMonth(r5.d);
        r0.setWeekStartDay(r5.b);
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        if (this.l == false) goto L5;
        return;
    L5:
        U90().setDividerVisible(false);
        U90().setLeftImageResource(2131237604);
        U90().setLeftClickListener(new d(this));
        U90().addAction(new e(this, getContext().getResources().getString(2131886948)));
        W90().setLineSpacingMultiplier(3.0f);
        W90().setTextColorCenter(qab.c.a(getContext(), 2131106622));
        V90().setLineSpacingMultiplier(3.0f);
        V90().setTextColorCenter(qab.c.a(getContext(), 2131106622));
        T90().setFirstDayOfWeek(this.t.b);
        W90().setOnItemSelectedListener(new c(this));
        V90().setOnItemSelectedListener(new com.ss.android.lark.custom.repeat.b(this));
        T90().setOnCheckedListener(new com.ss.android.lark.custom.repeat.a(this));
        this.o = new mab.b();
        WheelView r7 = W90();
        mab.b r0 = this.o;
        mab.f r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("repeatNumAdapter");
        r0 = null;
    L8:
        r7.setAdapter(r0);
        this.p = new mab.f(X90(2));
        this.q = new mab.f(X90(1));
        WheelView r8 = V90();
        mab.f r3 = this.q;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("repeatFreSingularAdapter");
    L12:
        r8.setAdapter(r1);
        this.s.put(0, 1);
        this.s.put(1, 2);
        this.s.put(2, 4);
        this.s.put(3, 5);
        Y90();
        aa0();
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131561179, null);
    }
}
