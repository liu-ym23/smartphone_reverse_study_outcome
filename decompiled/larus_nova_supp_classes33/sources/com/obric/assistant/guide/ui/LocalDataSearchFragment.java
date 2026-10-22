package com.obric.assistant.guide.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricGuideForLocalDataSearchBinding;
import com.obric.assistant.settings.AILabSettingItem;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.SelectableToggleItem;
import com.obric.assistant.settings.ToggleName;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0082@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/guide/ui/LocalDataSearchFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricGuideForLocalDataSearchBinding;", "isObricOS", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "buildCustomPermissionToggleList", "", "Lcom/obric/assistant/settings/SelectableToggleItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCustomPermissions", "toggleList", "goToNextView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalDataSearchFragment extends Fragment {
    public static final /* synthetic */ int f = 0;
    public ObricGuideForLocalDataSearchBinding d;
    public final boolean e;

    public static final class a {
        public static LocalDataSearchFragment a(boolean r3) {
            LocalDataSearchFragment r0 = new LocalDataSearchFragment();
            Bundle r1 = new Bundle();
            r1.putBoolean("is_last_page", r3);
            r0.setArguments(r1);
            return r0;
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(q r2) {
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

    public LocalDataSearchFragment() {
        this.e = t9a.b.a().b();
    }

    public final void U90() {
        UserGuideActivity r0 = getActivity();
        if ((r0 instanceof UserGuideActivity) == false) goto L5;
        UserGuideActivity r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = r1.Q1().getCurrentItem();
        RecyclerView.Adapter r3 = r1.Q1().getAdapter();
        if (r3 == null) goto L11;
        int r4 = r3.getItemCount();
    L12:
        FLogger.a.i("LocalDataSearchFragment", "goToNextView, currentPage=" + r2 + ", totalPage=" + r4);
        int r5 = r2 + 1;
        if (r5 != r4) goto L15;
        r1.S1("local_data_search_finish");
        r1.finish();
        return;
    L15:
        r1.Q1().setCurrentItem(r5, true);
        return;
    L11:
        r4 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public static final Object S90(LocalDataSearchFragment r9, Continuation r10) {
        r9.getClass();
        if ((r10 instanceof LocalDataSearchFragment$buildCustomPermissionToggleList$1) == false) goto L7;
        LocalDataSearchFragment$buildCustomPermissionToggleList$1 r0 = (LocalDataSearchFragment$buildCustomPermissionToggleList$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        ?? r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        if (((Boolean) r11).booleanValue() != true) goto L23;
        r2 = r5;
        r4 = true;
    L25:
        if (r4 == false) goto L27;
        T90(r2, ToggleName.AI_DIARY, r9.getString(2131912146), r9.getString(2131912129));
    L27:
        return r2;
    L23:
        List r12 = r5;
    L24:
        r2 = r12;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r12 = new ArrayList();
        String r6 = tga.b.a();
        T90(r12, ToggleName.NOTES, r6, r9.getString(2131912139, new Object[]{r6}));
        T90(r12, ToggleName.CLOCK, r9.getString(2131912152), r9.getString(2131912134));
        T90(r12, ToggleName.RECORD, r9.getString(2131912170), r9.getString(2131912140));
        T90(r12, ToggleName.GLOBAL_MEMORY, r9.getString(2131912160), r9.getString(2131912137));
        IAILabService r7 = (IAILabService) ServiceManager.get().getService(IAILabService.class);
        if (r7 == null) goto L24;
        AILabSettingItem r8 = AILabSettingItem.ScreenMemory;
        r0.L$0 = r12;
        r0.label = 1;
        Object r13 = r7.b(r8, r0);
        if (r13 == r2) goto L27;
        r5 = r12;
        r11 = r13;
    L7:
        r0 = new LocalDataSearchFragment$buildCustomPermissionToggleList$1(r9, r10);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r9v8, types: [com.obric.assistant.guide.ui.s] */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        Bundle r11 = getArguments();
        boolean r0 = false;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("onViewCreated, savedInstanceState=");
        if (r10 == null) goto L11;
        r0 = true;
    L11:
        r3.append(r0);
        r3.append(", isObricOS=");
        r3.append(this.e);
        r3.append(", isLastPage=");
        r3.append(r12);
        r3.append(", localDataSearchEnabled=");
        r3.append(ObricPersonalContextSettingApiDelegate.b.q());
        r2.i("LocalDataSearchFragment", r3.toString());
        if (this.e == false) goto L14;
        if (r12 == false) goto L14;
    L19:
        ObricGuideForLocalDataSearchBinding r13 = this.d;
        if (r13 == null) goto L24;
        ImageView r14 = r13.e;
        if (r14 == null) goto L24;
        r14.setImageDrawable(requireContext().getDrawable(2131244434));
    L24:
        ObricGuideForLocalDataSearchBinding r15 = this.d;
        if (r15 == null) goto L29;
        OButton r16 = r15.b;
        if (r16 == null) goto L29;
        r16.setOnClickListener(new r(this));
    L29:
        final ?? r17 = new s(this);
        if (this.e == false) goto L41;
        ObricGuideForLocalDataSearchBinding r18 = this.d;
        if (r18 == null) goto L36;
        OFloatingTitleBar r19 = r18.d;
        if (r19 == null) goto L36;
        OFloatingTitleBar.k(r19, new t(r17), 2);
    L36:
        ObricGuideForLocalDataSearchBinding r20 = this.d;
        if (r20 == null) goto L65;
        OFloatingTitleBar r21 = r20.d;
        if (r21 == null) goto L65;
        View.OnClickListener r110 = new u(this);
        Token$Bounce r1 = OFloatingTitleBar.H0;
        r21.h(2131244127, -1, r110);
    L65:
        ObricGuideForLocalDataSearchBinding r22 = this.d;
        if (r22 == null) goto L71;
        OButton r23 = r22.c;
        if (r23 == null) goto L72;
        r23.setOnClickListener(new w(this));
        return;
    L72:
        return;
    L71:
        return;
    L41:
        int r111 = rda.a.a;
        ObricGuideForLocalDataSearchBinding r112 = this.d;
        if (r112 == null) goto L44;
        OFloatingTitleBar r113 = r112.d;
    L45:
        NovaTitleBarEx.b6(rda.a.b(r113), 2131241477, false, null, null, new v(r17), 14);
        int r24 = getResources().getDimensionPixelSize(v19.c.b(2130971208, null, 2131166786));
        ObricGuideForLocalDataSearchBinding r114 = this.d;
        if (r114 == null) goto L50;
        OButton r115 = r114.c;
        if (r115 == null) goto L50;
        r115.setBackgroundResource(2131244295);
    L50:
        ObricGuideForLocalDataSearchBinding r116 = this.d;
        if (r116 == null) goto L55;
        OButton r117 = r116.c;
        if (r117 == null) goto L55;
        r117.setRadius(r24);
    L55:
        ObricGuideForLocalDataSearchBinding r118 = this.d;
        if (r118 == null) goto L60;
        OButton r119 = r118.c;
        if (r119 == null) goto L60;
        r119.setTextColor(ContextCompat.getColor(requireContext(), 2131102529));
    L60:
        ObricGuideForLocalDataSearchBinding r120 = this.d;
        if (r120 == null) goto L65;
        OButton r121 = r120.b;
        if (r121 == null) goto L65;
        r121.setRadius(r24);
        goto L65
    L44:
        r113 = null;
    L14:
        ObricGuideForLocalDataSearchBinding r25 = this.d;
        if (r25 == null) goto L19;
        OButton r26 = r25.b;
        if (r26 == null) goto L19;
        r26.setText(2131912522);
        goto L19
    L5:
        if (r11.getBoolean("is_last_page") != true) goto L7;
        r12 = true;
        goto L8
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131564017, r8, false);
        int r11 = 2131373138;
        if (ViewBindings.findChildViewById(r10, 2131373138) == null) goto L19;
        r11 = 2131380090;
        if (ViewBindings.findChildViewById(r10, 2131380090) == null) goto L19;
        r11 = 2131381502;
        OButton r2 = (OButton) ViewBindings.findChildViewById(r10, 2131381502);
        if (r2 == null) goto L19;
        r11 = 2131381532;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r10, 2131381532);
        if (r3 == null) goto L19;
        r11 = 2131388807;
        OFloatingTitleBar r4 = ViewBindings.findChildViewById(r10, 2131388807);
        if (r4 == null) goto L19;
        r11 = 2131389245;
        if (ViewBindings.findChildViewById(r10, 2131389245) == null) goto L19;
        r11 = 2131392718;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, 2131392718);
        if (r5 == null) goto L19;
        ConstraintLayout r12 = r10;
        this.d = new ObricGuideForLocalDataSearchBinding(r12, r2, r3, r4, r5);
        return r12;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static final void T90(List<SelectableToggleItem> r10, ToggleName r11, String r12, String r13) {
        boolean r0 = ObricPersonalContextSettingApiDelegate.b.o(r11);
        FLogger.a.i("LocalDataSearchFragment", "buildCustomPermissionToggleList, toggle=" + r11 + ", isOn=" + r0);
        if (r0 == true) goto L6;
        r10.add(new SelectableToggleItem(r11, r12, r13, null, 24));
        return;
    }
}
