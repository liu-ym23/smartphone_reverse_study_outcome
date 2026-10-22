package com.ss.android.lark.custom.repeat;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.custom.repeat.databinding.ActivityChooseRepeatPageBinding;
import com.ss.android.lark.custom.repeat.entity.EventRecurrence;
import com.ss.android.lark.custom.repeat.entity.RruleListItem;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n*\u0001$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\f\u00100\u001a\u00020'*\u00020)H\u0002J8\u00101\u001a\u00020'2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u00105\u001a\u00020'*\u000206H\u0002J\u0006\u00107\u001a\u00020'J\f\u00108\u001a\u00020'*\u000206H\u0002J\b\u00109\u001a\u00020\bH\u0002J\b\u0010:\u001a\u00020\bH\u0002J\f\u0010;\u001a\u00020'*\u000206H\u0002J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020>H\u0002J\u001a\u0010?\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010 2\u0006\u0010A\u001a\u00020\u0016H\u0002J\u0012\u0010B\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0006H\u0002J\u0010\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006H\u0002J\b\u0010G\u001a\u00020'H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006H"}, d2 = {"Lcom/ss/android/lark/custom/repeat/ChooseRepeatFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "defaultRruleList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mChosenIndex", BuildConfig.FLAVOR, "mRepeatAdapter", "Lcom/ss/android/lark/custom/repeat/adapter/RepeatAdapter;", "rruleList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/custom/repeat/entity/RruleListItem;", "Lcom/ss/android/lark/custom/repeat/entity/RruleList;", "inputRRule", "parsedInputRruleText", "firstDayOfWeek", "Lcom/ss/android/lark/custom/repeat/CustomRepeatParams$DayOfWeek;", "languageType", "Lcom/bytedance/lark/pb/basic/v1/LanguageType;", "isSingleInWeek", BuildConfig.FLAVOR, "isSingleInMonth", "isFixDefaultDate", "defaultDate", "Ljava/util/GregorianCalendar;", "bannedUnselectedStringId", "Ljava/lang/Integer;", "bannedSlideStringId", "selfDefineItemText", "mChooseCustomRepeatFragment", "Lcom/ss/android/lark/custom/repeat/ChooseCustomRepeatFragment;", "fragmentStack", "Ljava/util/Stack;", "mCustomRepeatFragmentAction", "com/ss/android/lark/custom/repeat/ChooseRepeatFragment$mCustomRepeatFragmentAction$1", "Lcom/ss/android/lark/custom/repeat/ChooseRepeatFragment$mCustomRepeatFragmentAction$1;", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "parseDataFromIntent", "initRruleList", "customRepeatRruleList", "customHideRepeat", "lastRrule", "initTitle", "Lcom/ss/android/lark/custom/repeat/databinding/ActivityChooseRepeatPageBinding;", "onBackPressed", "initList", "getIndexOfInputRrule", "getChosenIndex", "initListener", "showCustomRepeatFragment", "getDefaultCalendarDate", "Lcom/ss/android/lark/custom/repeat/entity/CalendarDate;", "showFragment", "fragment", "isFirstAdd", "hideFragment", "setResultWithRRule", "rrule", "getRepeatRuleShowStr", "rRule", "close", "custom-repeat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseRepeatFragment extends BaseFragment {
    public static final /* synthetic */ int v = 0;
    public final List<String> d;
    public int e;
    public mab.e f;
    public final ArrayList<RruleListItem> g;
    public String h;
    public String i;
    public CustomRepeatParams$DayOfWeek j;
    public LanguageType k;
    public boolean l;
    public boolean m;
    public boolean n;
    public GregorianCalendar o;
    public Integer p;
    public Integer q;
    public String r;
    public ChooseCustomRepeatFragment s;
    public final Stack<ChooseCustomRepeatFragment> t;
    public final a u;

    public static final class a implements ChooseCustomRepeatFragment.b {
        public final /* synthetic */ ChooseRepeatFragment a;

        @Override // com.ss.android.lark.custom.repeat.ChooseCustomRepeatFragment.b
        public final void onBackPressed() {
            ChooseRepeatFragment r0 = this.a;
            r0.V90(r0.s);
        }

        public a(ChooseRepeatFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.custom.repeat.ChooseCustomRepeatFragment.b
        public final void a(EventRecurrence r2) {
            Intrinsics.checkNotNullParameter(r2, "customRRule");
            ChooseRepeatFragment.S90(this.a, r2.toString());
        }
    }

    public final int T90() {
        Iterator<RruleListItem> r0 = this.g.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L15;
        RruleListItem r3 = r0.next();
        if (Intrinsics.areEqual(r3.getRrule(), this.h) == false) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L19;
        r2 = r2 + 1;
        goto L4
    L19:
        return r2;
    L8:
        if (Intrinsics.areEqual(r3.getParsedText(), this.i) == true) goto L11;
        r4 = false;
        goto L12
    L15:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBackPressed() {
        if (this.t.size() <= 0) goto L8;
        ChooseCustomRepeatFragment r0 = this.t.peek();
        if (r0 == null) goto L7;
        V90(r0);
        return;
    L7:
        com.ss.android.lark.ui.component_container.a.d(this, null);
        return;
    L8:
        com.ss.android.lark.ui.component_container.a.d(this, null);
    }

    public ChooseRepeatFragment() {
        this.d = CollectionsKt.listOf(new String[]{BuildConfig.FLAVOR, "FREQ=DAILY;INTERVAL=1", "FREQ=WEEKLY;INTERVAL=1", "FREQ=MONTHLY;INTERVAL=1", "FREQ=YEARLY;INTERVAL=1", "FREQ=WEEKLY;INTERVAL=1;BYDAY=MO,TU,WE,TH,FR"});
        this.g = new ArrayList();
        this.h = BuildConfig.FLAVOR;
        this.i = BuildConfig.FLAVOR;
        this.j = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.k = LanguageType.UNKNOWN_LANGUAGE;
        this.t = new Stack();
        this.u = new a(this);
    }

    public final String U90(String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        Application r3 = getActivity();
        if (r3 != null) goto L10;
        r3 = LarkContext.getApplication();
    L10:
        String r4 = r3.getResources().getString(2131886955);
        Intrinsics.checkNotNull(r4);
        return r4;
    L11:
        String r5 = qab.b.a(r2, this.k);
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        r0 = false;
        goto L6
    }

    public final void V90(ChooseCustomRepeatFragment r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r4.r.clearRule();
        r4.T90().c();
        getChildFragmentManager().beginTransaction().setCustomAnimations(2130772644, 2130772645).hide(r4).commitAllowingStateLoss();
        if (this.t.size() <= 0) goto L7;
        this.t.pop();
    L7:
        getChildFragmentManager().executePendingTransactions();
    }

    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        Bundle r14 = getArguments();
        if (r14 == null) goto L45;
        CustomRepeatParams$DayOfWeek r0 = (CustomRepeatParams$DayOfWeek) r14.get("custom_repeat_first_day_of_week");
        if (r0 != null) goto L7;
        r0 = CustomRepeatParams$DayOfWeek.SUNDAY;
    L7:
        this.j = r0;
        this.l = r14.getBoolean("custom_repeat_is_single_in_week");
        this.m = r14.getBoolean("custom_repeat_is_single_in_month");
        this.n = r14.getBoolean("custom_repeat_is_fixed_default_date");
        Object r1 = r14.get("custom_repeat_default_date");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.util.GregorianCalendar");
        this.o = (GregorianCalendar) r1;
        this.p = Integer.valueOf(r14.getInt("custom_repeat_banned_unselected_localize_id"));
        this.q = Integer.valueOf(r14.getInt("custom_repeat_banned_select_localize_id"));
        this.r = r14.getString("custom_repeat_self_define_item_text");
        LanguageType r2 = (LanguageType) r14.get("custom_repeat_language_type");
        if (r2 != null) goto L10;
        r2 = LanguageType.UNKNOWN_LANGUAGE;
    L10:
        this.k = r2;
        Serializable r3 = r14.getSerializable("custom_repeat_rrule_list");
        if ((r3 instanceof ArrayList) == false) goto L13;
        ArrayList r4 = (ArrayList) r3;
    L14:
        ArrayList<String> r5 = r14.getStringArrayList("custom_hide_repeat");
        String r15 = r14.getString("custom_repeat_last_rrule");
        this.g.clear();
        int r6 = 0;
        if (r4 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == false) goto L26;
        Iterator<T> r8 = this.d.iterator();
    L24:
        if (r8.hasNext() == false) goto L27;
        String r9 = (String) r8.next();
        String r10 = U90(r9);
        this.g.add(new RruleListItem(r9, r10, r10, null, 8, null));
    L27:
        if (r5 == null) goto L32;
        Iterator<T> r11 = r5.iterator();
    L30:
        if (r11.hasNext() == false) goto L32;
        final String r12 = (String) r11.next();
        CollectionsKt.removeAll(this.g, new ChooseRepeatFragment$initRruleList$2$1(r12));
    L32:
        if (r15 != null) goto L34;
        r15 = BuildConfig.FLAVOR;
    L34:
        this.h = r15;
        this.i = U90(r15);
        if (T90() >= 0) goto L37;
        ArrayList<RruleListItem> r16 = this.g;
        String r17 = this.h;
        String r18 = this.i;
        r16.add(new RruleListItem(r17, r18, r18, null, 8, null));
    L37:
        int r19 = T90();
        if (r19 == (-1)) goto L41;
        r6 = r19;
    L41:
        this.e = r6;
        return;
    L26:
        this.g.addAll(r4);
        goto L27
    L17:
        if (r4.isEmpty() == true) goto L20;
        r7 = false;
        goto L21
    L13:
        r4 = null;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void S90(ChooseRepeatFragment r3, String r4) {
        FragmentActivity r0 = r3.getActivity();
        if (r0 == null) goto L7;
        Intent r1 = new Intent();
        r1.putExtra("custom_repeat_result_rrule", r4);
        r1.putExtra("custom_repeat_result_display_text", r3.U90(r4));
        r0.setResult(-1, r1);
        com.ss.android.lark.ui.component_container.a.d(r3, null);
        return;
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        boolean r0 = false;
        View r15 = r12.inflate(2131558466, r13, false);
        int r16 = 2131378854;
        RelativeLayout r17 = (RelativeLayout) ViewBindings.findChildViewById(r15, 2131378854);
        if (r17 == null) goto L29;
        r16 = 2131379262;
        ListView r8 = (ListView) ViewBindings.findChildViewById(r15, 2131379262);
        if (r8 == null) goto L29;
        r16 = 2131384291;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131384291);
        if (r5 == null) goto L29;
        r16 = 2131384299;
        CommonTitleBar r9 = ViewBindings.findChildViewById(r15, 2131384299);
        if (r9 == null) goto L29;
        r16 = 2131385870;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r15, 2131385870);
        if (r10 == null) goto L29;
        RelativeLayout r18 = (RelativeLayout) r15;
        Intrinsics.checkNotNull(new ActivityChooseRepeatPageBinding(r18, r17, r8, r5, r9, r10));
        r9.setDividerVisible(false);
        r9.setLeftImageResource(2131254998);
        r9.setTitle(2131886957);
        r9.setLeftClickListener(new h(this));
        mab.e r19 = this.f;
        if (r19 != null) goto L18;
        int r110 = T90();
        if (r110 != (-1)) goto L17;
        r110 = 0;
    L17:
        this.e = r110;
        mab.e r111 = new mab.e(this.g, this.e, r18.getContext());
        this.f = r111;
        r8.setAdapter(r111);
    L19:
        r8.setOnItemClickListener(new f(this));
        String r112 = this.r;
        if (r112 != null) goto L22;
    L23:
        r0 = true;
    L24:
        if (r0 == true) goto L26;
        r10.setText(this.r);
    L26:
        r17.setOnClickListener(new g(this));
        WindowInsetsUtils.g(r18, true, true);
        return r18;
    L22:
        if (r112.length() != 0) goto L24;
    L18:
        ArrayList<RruleListItem> r1 = this.g;
        int r2 = this.e;
        Intrinsics.checkNotNullParameter(r1, "rruleList");
        r19.c.clear();
        r19.c.addAll(r1);
        r19.a = r2;
        r19.notifyDataSetChanged();
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
