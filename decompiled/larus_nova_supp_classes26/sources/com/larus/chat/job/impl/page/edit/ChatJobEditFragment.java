package com.larus.chat.job.impl.page.edit;

import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.chat.job.impl.databinding.LarusChatJobEditFragmentBinding;
import com.larus.chat.job.impl.page.ChatJobFragment;
import com.larus.chat.job.impl.ui.ChatJobDatePickerView;
import com.larus.chat.job.impl.ui.ChatJobMinutePickerView;
import com.larus.chat.job.impl.ui.ChatJobTimePickerView;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.im.bean.job.AIJob;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 s2\u00020\u0001:\u0001sB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u0011H\u0002J\f\u00101\u001a\u00020\u0011*\u00020*H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0002J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020$H\u0002J\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020AH\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\r2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020$H\u0002J\b\u0010D\u001a\u00020\u0011H\u0002J&\u0010E\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010\r2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010K\u001a\u00020$H\u0002J\u0010\u0010L\u001a\u00020$2\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0018\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020O2\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0012\u0010P\u001a\u00020$2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\u0010\u0010S\u001a\u00020$2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010T\u001a\u00020$H\u0002J\u0018\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020HH\u0002J\u0010\u0010Z\u001a\u00020$2\u0006\u0010Q\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020$2\u0006\u0010Q\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020$2\u0006\u0010Q\u001a\u00020]H\u0002J\u0010\u0010_\u001a\u00020$2\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0010\u0010`\u001a\u00020$2\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0010\u0010a\u001a\u00020$2\u0006\u0010>\u001a\u00020\u001cH\u0002J \u0010b\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020AH\u0002J \u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020A2\u0006\u0010g\u001a\u00020AH\u0002J\u0018\u0010h\u001a\u00020i2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010j\u001a\u00020AH\u0002J\u0010\u0010k\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u001cH\u0002J\u0018\u0010l\u001a\u00020A2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010m\u001a\u00020AH\u0002J\b\u0010n\u001a\u00020AH\u0002J\u0010\u0010n\u001a\u00020A2\u0006\u0010>\u001a\u00020\u001cH\u0002J\b\u0010o\u001a\u00020AH\u0002J\b\u0010p\u001a\u00020AH\u0002J\b\u0010q\u001a\u00020AH\u0002J\u0010\u0010r\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006t"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/chat/job/impl/databinding/LarusChatJobEditFragmentBinding;", "adapter", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditAdapter;", "topMenu", "Landroid/widget/PopupWindow;", "frequencyMenu", "pickerPopup", "renderedFrequencyPageKey", "", "systemBarsSnapshot", "Lcom/larus/chat/job/impl/page/edit/SystemBarsSnapshot;", "isClosing", "", "viewModel", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditViewModel;", "getViewModel", "()Lcom/larus/chat/job/impl/page/edit/ChatJobEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isReadOnly", "()Z", "isReadOnly$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "bindTaskReplyModelDisplayNames", "findSourceInstructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onResume", "onDestroyView", "closeEditPage", "bindBackPressed", "removeEditPage", "allowStateLoss", "isEditTopBackStackEntry", "bindSystemBarInsets", "setupTransparentSystemBars", "setupTransparentSystemBarsIfNeeded", "restoreSystemBars", "observeEditList", "handleEffect", "effect", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditEffect;", "renderTopAction", "state", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditUiState;", "showTopMenu", "anchor", "handleTopMenuClick", "id", "", "topMenuClickFrom", "runJobAndCloseEditPage", "shouldOpenConversationAfterRun", "openConversation", "conversationId", "routeContext", "Landroid/content/Context;", "sideBarFragment", "Lcom/larus/bmhome/ISideBarFragment;", "openTaskManagementPage", "showFrequencyMenu", "handleOptionClick", "key", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditOptionKey;", "renderFrequencySubPage", "subPage", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditSubPageState;", "updateFrequencyConfirm", "buildWeeklyFrequencyBody", "createWeekdayRow", "context", "weekday", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditWeekday;", "createDivider", "updateWeeklyFrequencyBody", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditSubPageState$Weekly;", "buildCustomFrequencyBody", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditSubPageState$Custom;", "updateCustomFrequencyBody", "showDatePicker", "showTimePicker", "showMinutePicker", "showPickerPopup", "picker", "width", "wrapMenuContent", "content", "padding", "wrapFloatLayerShadow", "Lcom/larus/common_ui/widget/ShadowLayout;", "contentWidth", "createShadowPopupWindow", "calculateRightAlignedDropDownOffset", "layerWidth", "calculateFloatLayerDropDownYOffset", "calculateTopMenuDropDownYOffset", "floatLayerShadowLeftInset", "floatLayerShadowTopInset", "hideKeyboard", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobEditFragment extends Fragment {
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public static final int r = 0;
    public LarusChatJobEditFragmentBinding d;
    public ChatJobEditAdapter e;
    public PopupWindow f;
    public PopupWindow g;
    public PopupWindow h;
    public String i;
    public p1 j;
    public boolean k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatJobEditOptionKey.values().length];
            r0[ChatJobEditOptionKey.REPEAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[ChatJobEditOptionKey.FREQUENCY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[ChatJobEditOptionKey.HOURLY_MINUTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[ChatJobEditOptionKey.DATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ChatJobEditOptionKey.TIME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[ChatJobEditOptionKey.RUN_TIME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[ChatJobEditOptionKey.MODEL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[ChatJobEditOptionKey.ENVIRONMENT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[ChatJobEditOptionKey.PROJECT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(x r2) {
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

    /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<ChatJobEditTextKey, String, Unit> {
        public AnonymousClass1(Object r8) {
            super(2, r8, ChatJobEditViewModel.class, "updateText", "updateText(Lcom/larus/chat/job/impl/page/edit/ChatJobEditTextKey;Ljava/lang/String;)V", 0);
        }

        public final void invoke(ChatJobEditTextKey r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            Intrinsics.checkNotNullParameter(r3, "p1");
            ((ChatJobEditViewModel) ((CallableReference) this).receiver).updateText(r2, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((ChatJobEditTextKey) r1, (String) r2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.job.impl.page.edit.ChatJobEditFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<ChatJobEditOptionKey, View, Unit> {
        public AnonymousClass2(Object r8) {
            super(2, r8, ChatJobEditFragment.class, "handleOptionClick", "handleOptionClick(Lcom/larus/chat/job/impl/page/edit/ChatJobEditOptionKey;Landroid/view/View;)V", 0);
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [android.view.ViewGroup, com.larus.bmhome.view.screenmenu.CommonMenu] */
        public final void invoke(ChatJobEditOptionKey r55, View r56) {
            Intrinsics.checkNotNullParameter(r55, "p0");
            Intrinsics.checkNotNullParameter(r56, "p1");
            final ChatJobEditFragment r3 = (ChatJobEditFragment) ((CallableReference) this).receiver;
            int r4 = ChatJobEditFragment.n;
            r3.getClass();
            Integer r5 = null;
            int r6 = 0;
            switch(b.a[r55.ordinal()]) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L21;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                default: goto L5;
            };
        L6:
            r3.aa0().toggleProject();
            return;
        L7:
            r3.aa0().toggleEnvironment();
            return;
        L8:
            r3.aa0().toggleModel();
            return;
        L9:
            r3.ga0(r56);
            return;
        L10:
            r3.ga0(r56);
            return;
        L11:
            PopupWindow r2 = r3.h;
            if (r2 == null) goto L14;
            ChatJobEditFragment.T90(r2);
        L14:
            PopupWindow r7 = r3.g;
            if (r7 == null) goto L17;
            ChatJobEditFragment.T90(r7);
        L17:
            PopupWindow r8 = r3.f;
            if (r8 == null) goto L20;
            ChatJobEditFragment.T90(r8);
        L20:
            ChatJobDatePickerView r9 = new ChatJobDatePickerView(r56.getContext(), null, 6, 0);
            h r10 = ((f0) r3.aa0().getUiState().getValue()).h;
            Intrinsics.checkNotNullParameter(r10, "date");
            r9.b = r10;
            r9.d = r10.a;
            r9.e = r10.b;
            r9.c();
            r9.c = r3.aa0().minExecuteDate();
            r9.c();
            r9.setOnDateSelected(new ChatJobEditFragment$showDatePicker$picker$1$1(r3.aa0()));
            r3.h = r3.fa0(r56, r9, ChatJobDatePickerView.f);
            return;
        L21:
            PopupWindow r11 = r3.h;
            if (r11 == null) goto L24;
            ChatJobEditFragment.T90(r11);
        L24:
            PopupWindow r12 = r3.g;
            if (r12 == null) goto L27;
            ChatJobEditFragment.T90(r12);
        L27:
            PopupWindow r13 = r3.f;
            if (r13 == null) goto L30;
            ChatJobEditFragment.T90(r13);
        L30:
            final ChatJobMinutePickerView r14 = new ChatJobMinutePickerView(r56.getContext(), null, 6, 0);
            r14.b = RangesKt.coerceIn(((f0) r3.aa0().getUiState().getValue()).i.b, 0, 59);
            r14.removeAllViews();
            int r15 = gz8.g.a;
            r14.setBackground(gz8.g.a(r14.getContext()));
            r14.setPadding(i5.r0(), i5.r0(), i5.r0(), i5.r0());
            View r16 = new View(r14.getContext());
            int r17 = gz8.g.d(r16.getContext());
            float r18 = i5.r0();
            GradientDrawable r19 = new GradientDrawable();
            r19.setShape(0);
            r19.setColor(r17);
            r19.setCornerRadius(r18);
            r16.setBackground(r19);
            int r110 = ChatJobMinutePickerView.d;
            r16.setLayoutParams(new FrameLayout.LayoutParams(-1, r110, 16));
            r14.addView(r16);
            List r20 = CollectionsKt.toList(new IntRange(0, 59));
            r14.addView(fz8.u.a(r14.getContext(), r20, Integer.valueOf(r14.b), true, r110, new FrameLayout.LayoutParams(-1, ChatJobMinutePickerView.e), r110 * 2, i5.t(), new fz8.s(), new fz8.l(r14)));
            r14.setOnMinuteSelected(new ChatJobEditFragment$showMinutePicker$picker$1$1(r3.aa0()));
            r3.h = r3.fa0(r56, r14, ChatJobMinutePickerView.c);
            return;
        L31:
            r3.aa0().openFrequencyPage();
            return;
        L32:
            PopupWindow r21 = r3.g;
            if (r21 == null) goto L35;
            ChatJobEditFragment.T90(r21);
        L35:
            PopupWindow r22 = r3.h;
            if (r22 == null) goto L38;
            ChatJobEditFragment.T90(r22);
        L38:
            PopupWindow r23 = r3.f;
            if (r23 == null) goto L41;
            ChatJobEditFragment.T90(r23);
        L41:
            int r24 = i5.r();
            int r25 = i5.r0();
            int r26 = (r25 * 2) + r24;
            String r27 = ((f0) r3.aa0().getUiState().getValue()).c;
            List<String> r28 = r3.aa0().getFrequencyOptions();
            ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
            Iterator<T> r29 = r28.iterator();
        L43:
            if (r29.hasNext() == false) goto L52;
            Object r112 = r29.next();
            int r113 = r6 + 1;
            if (r6 >= 0) goto L47;
            CollectionsKt.throwIndexOverflow();
        L47:
            String r114 = (String) r112;
            int r115 = r6 + 100;
            if (Intrinsics.areEqual(r114, r27) == false) goto L50;
            Integer r210 = 2131240022;
        L51:
            r111.add(new com.larus.bmhome.view.screenmenu.l0(r115, 0, r114, null, null, null, null, r210, null, Intrinsics.areEqual(r114, r27), false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -646, 127));
            r6 = r113;
            r5 = null;
            goto L43
        L50:
            r210 = r5;
            goto L51
        L52:
            ?? r30 = new CommonMenu(r56.getContext());
            r30.d(r24);
            r30.g(r111, new w(r3));
            r30.setBackground(null);
            PopupWindow r31 = ChatJobEditFragment.Y90(ChatJobEditFragment.ha0(ChatJobEditFragment.ia0(r30, r26, r25), r26));
            ChatJobEditFragment.U90(r31, r56, r3.W90(r56, r26), ChatJobEditFragment.V90(r56));
            r3.g = r31;
            return;
        L5:
            throw new NoWhenBranchMatchedException();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((ChatJobEditOptionKey) r1, (View) r2);
            return Unit.INSTANCE;
        }
    }

    static {
        n = i5.q();
        o = i5.h();
        p = i5.E();
        q = i5.j0();
        r = i5.q();
    }

    public final void X90() {
        if (this.k == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.k = true;
        LarusChatJobEditFragmentBinding r1 = this.d;
        if (r1 == null) goto L8;
        ba0(r1.a);
    L8:
        PopupWindow r2 = this.f;
        if (r2 == null) goto L11;
        T90(r2);
    L11:
        PopupWindow r3 = this.g;
        if (r3 == null) goto L14;
        T90(r3);
    L14:
        PopupWindow r4 = this.h;
        if (r4 == null) goto L17;
        T90(r4);
    L17:
        da0();
        FragmentManager r5 = getParentFragmentManager();
        if (r5.isStateSaved() == false) goto L22;
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        return;
    L22:
        if (r5.getBackStackEntryCount() > 0) goto L24;
    L26:
        r0 = false;
    L27:
        if (r0 == true) goto L30;
        getParentFragmentManager().beginTransaction().remove(this).commit();
        return;
    L30:
        r5.popBackStack();
        return;
    L24:
        if (Intrinsics.areEqual(r5.getBackStackEntryAt(r5.getBackStackEntryCount() - 1).getName(), "ChatJobEditFragment") == false) goto L26;
        goto L26
    }

    public final ChatJobEditViewModel aa0() {
        return (ChatJobEditViewModel) this.l.getValue();
    }

    public final boolean ca0() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final void onDestroyView() {
        PopupWindow r0 = this.f;
        if (r0 == null) goto L5;
        T90(r0);
    L5:
        PopupWindow r1 = this.g;
        if (r1 == null) goto L8;
        T90(r1);
    L8:
        PopupWindow r2 = this.h;
        if (r2 == null) goto L11;
        T90(r2);
    L11:
        LarusChatJobEditFragmentBinding r3 = this.d;
        if (r3 == null) goto L16;
        ChatJobDragDismissLayout r4 = r3.a;
        if (r4 == null) goto L16;
        r4.setOnDragDismiss(null);
    L16:
        LarusChatJobEditFragmentBinding r5 = this.d;
        if (r5 == null) goto L23;
        ConstraintLayout r6 = r5.d;
        if (r6 == null) goto L23;
        ViewPropertyAnimator r7 = r6.animate();
        if (r7 == null) goto L23;
        r7.cancel();
    L23:
        LarusChatJobEditFragmentBinding r8 = this.d;
        if (r8 == null) goto L30;
        ConstraintLayout r9 = r8.o;
        if (r9 == null) goto L30;
        ViewPropertyAnimator r10 = r9.animate();
        if (r10 == null) goto L30;
        r10.cancel();
    L30:
        LarusChatJobEditFragmentBinding r11 = this.d;
        if (r11 == null) goto L35;
        ConstraintLayout r12 = r11.a;
        if (r12 == null) goto L35;
        ViewCompat.setOnApplyWindowInsetsListener(r12, null);
    L35:
        LarusChatJobEditFragmentBinding r13 = this.d;
        if (r13 == null) goto L40;
        RecyclerView r14 = r13.f;
        if (r14 == null) goto L40;
        r14.setAdapter(null);
    L40:
        this.e = null;
        this.i = null;
        this.d = null;
        da0();
        super.onDestroyView();
    }

    public ChatJobEditFragment() {
        final Function0<Fragment> r0 = new ChatJobEditFragment$special$$inlined$viewModels$default$1(this);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatJobEditViewModel.class), new ChatJobEditFragment$special$$inlined$viewModels$default$2(r0), new ChatJobEditFragment$special$$inlined$viewModels$default$3(r0, this));
        this.m = LazyKt.lazy(new p(this));
    }

    public final void da0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L22;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L23;
        p1 r2 = this.j;
        if (r2 != null) goto L10;
        return;
    L10:
        r1.setStatusBarColor(r2.a);
        r1.setNavigationBarColor(r2.b);
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 28) goto L16;
        Integer r4 = r2.c;
        if (r4 == null) goto L16;
        r1.setNavigationBarDividerColor(r4.intValue());
    L16:
        if (r3 < 29) goto L20;
        Boolean r5 = r2.d;
        if (r5 == null) goto L20;
        r1.setNavigationBarContrastEnforced(r5.booleanValue());
    L20:
        this.j = null;
        return;
    L23:
        return;
    }

    public final void ea0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L35;
        Window r3 = r2.getWindow();
        if (r3 != null) goto L17;
        return;
    L17:
        if (this.j != null) goto L25;
        int r6 = r3.getStatusBarColor();
        int r7 = r3.getNavigationBarColor();
        int r8 = Build.VERSION.SDK_INT;
        Boolean r9 = null;
        if (r8 < 28) goto L21;
        Integer r10 = Integer.valueOf(r3.getNavigationBarDividerColor());
    L22:
        if (r8 < 29) goto L24;
        r9 = Boolean.valueOf(r3.isNavigationBarContrastEnforced());
    L24:
        this.j = new p1(r6, r7, r10, r9);
        goto L25
    L21:
        r10 = null;
    L25:
        r3.setStatusBarColor(0);
        r3.setNavigationBarColor(0);
        int r4 = Build.VERSION.SDK_INT;
        if (r4 < 28) goto L28;
        r3.setNavigationBarDividerColor(0);
    L28:
        if (r4 < 29) goto L30;
        r3.setNavigationBarContrastEnforced(false);
    L30:
        boolean r5 = v19.h.a;
        boolean r11 = true ^ v19.h.b(requireContext());
        WindowInsetsControllerCompat r12 = WindowCompat.getInsetsController(r3, S90(r3));
        if (r12 == null) goto L33;
        r12.setAppearanceLightStatusBars(r11);
        r12.setAppearanceLightNavigationBars(r11);
    L33:
        ViewCompat.requestApplyInsets(S90(r3));
        return;
    L35:
        return;
    L5:
        if (r0.getBoolean("chat_job_edit_transparent_system_bars") != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void onResume() {
        super.onResume();
        ea0();
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void T90(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    public static int V90(View r5) {
        Object r0 = r5.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L7:
        if (r1 == null) goto L9;
        int[] r3 = new int[2];
        int[] r2 = new int[2];
        r5.getLocationOnScreen(r3);
        r1.getLocationOnScreen(r2);
        return ((r2[1] + r1.getHeight()) - (r3[1] + r5.getHeight())) + ((-n) - Math.max(0, p - q));
    L9:
        return (-n) - Math.max(0, p - q);
    L5:
        r1 = null;
        goto L7
    }

    public static PopupWindow Y90(ShadowLayout r3) {
        PopupWindow r0 = new PopupWindow(r3, -2, -2, true);
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.setOutsideTouchable(true);
        r0.setClippingEnabled(false);
        return r0;
    }

    public final com.larus.bmhome.instruction.g Z90(FragmentManager r5) {
        List r6 = CollectionsKt.asReversedMutable(r5.getFragments());
        ArrayList r0 = new ArrayList();
        Iterator r1 = r6.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if ((r2 instanceof ChatJobFragment) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        ArrayList r3 = new ArrayList();
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        Object r4 = r7.next();
        if ((((Fragment) r4) instanceof ChatJobFragment) == true) goto L10;
        r3.add(r4);
        goto L10
    L14:
        Iterator r8 = CollectionsKt.plus(r0, r3).iterator();
    L16:
        if (r8.hasNext() == false) goto L28;
        Fragment r9 = (Fragment) r8.next();
        if (r9 == this) goto L16;
        if (r9.isAdded() == false) goto L16;
        Intrinsics.checkNotNull(r9);
        com.larus.bmhome.instruction.g r10 = s1a.a.g(r9).getAbility(com.larus.bmhome.instruction.g.class);
        if (r10 != null) goto L24;
        com.larus.bmhome.instruction.g r11 = Z90(r9.getChildFragmentManager());
        if (r11 == null) goto L16;
        return r11;
    L24:
        return r10;
    L28:
        return null;
    }

    public final void ba0(View r3) {
        Object r0 = r3.getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
    L6:
        if (r1 == null) goto L9;
        r1.hideSoftInputFromWindow(r3.getWindowToken(), 0);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [fz8.m] */
    /* JADX WARN: Type inference failed for: r6v5, types: [fz8.q] */
    public final void ga0(View r20) {
        PopupWindow r1 = this.h;
        if (r1 == null) goto L5;
        T90(r1);
    L5:
        PopupWindow r2 = this.g;
        if (r2 == null) goto L8;
        T90(r2);
    L8:
        PopupWindow r3 = this.f;
        if (r3 == null) goto L11;
        T90(r3);
    L11:
        final ChatJobTimePickerView r4 = new ChatJobTimePickerView(r20.getContext(), null, 6, 0);
        e0 r5 = ((f0) aa0().getUiState().getValue()).i;
        Intrinsics.checkNotNullParameter(r5, "time");
        int r6 = r5.a;
        if (r6 < 12) goto L14;
        boolean r7 = true;
    L15:
        r4.b = r7;
        if (r6 != 0) goto L18;
        r6 = 12;
    L20:
        r4.c = r6;
        r4.d = r5.b;
        r4.removeAllViews();
        int r8 = gz8.g.a;
        r4.setBackground(gz8.g.a(r4.getContext()));
        r4.setPadding(i5.q(), i5.q(), i5.q(), i5.q());
        View r9 = new View(r4.getContext());
        int r10 = gz8.g.d(r9.getContext());
        float r11 = i5.r0();
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        r12.setColor(r10);
        r12.setCornerRadius(r11);
        r9.setBackground(r12);
        r9.setLayoutParams(new FrameLayout.LayoutParams(-1, ChatJobTimePickerView.f, 16));
        r4.addView(r9);
        boolean r13 = r4.b;
        int r14 = r4.c;
        int r15 = r4.d;
        final ?? r16 = new fz8.m(r4);
        Function1 r17 = new fz8.n(r4);
        Function1 r18 = new fz8.o(r4);
        gz8.d r19 = gz8.d.a;
        Locale r21 = Locale.getDefault();
        r19.getClass();
        final List r22 = gz8.d.b(r21);
        LinearLayout r23 = new LinearLayout(r4.getContext());
        r23.setOrientation(0);
        r23.setGravity(17);
        r23.setPadding(i5.h(), 0, i5.h(), 0);
        r23.setLayoutParams(new FrameLayout.LayoutParams(-1, ChatJobTimePickerView.g));
        if (r13 == false) goto L23;
        Object r24 = ListProtector.get(r22, 1);
    L24:
        r23.addView(ChatJobTimePickerView.a(r4, r22, (String) r24, 1.2f, null, new fz8.p(r16, r22), 16));
        View r25 = new View(r4.getContext());
        r25.setLayoutParams(new LinearLayout.LayoutParams(i5.Z(), -1));
        r23.addView(r25);
        r23.addView(ChatJobTimePickerView.a(r4, CollectionsKt.toList(new IntRange(1, 12)), Integer.valueOf(r14), 1.0f, null, r17, 24));
        View r26 = new View(r4.getContext());
        r26.setLayoutParams(new LinearLayout.LayoutParams(i5.Z(), -1));
        r23.addView(r26);
        r23.addView(ChatJobTimePickerView.a(r4, CollectionsKt.toList(new IntRange(0, 59)), Integer.valueOf(r15), 1.0f, new fz8.q(), r18, 8));
        r4.addView(r23);
        r4.setOnTimeSelected(new ChatJobEditFragment$showTimePicker$picker$1$1(aa0()));
        this.h = fa0(r20, r4, ChatJobTimePickerView.e);
        return;
    L23:
        r24 = ListProtector.get(r22, 0);
        goto L24
    L18:
        if (r6 <= 12) goto L20;
        r6 = r6 - 12;
        goto L20
    L14:
        r7 = false;
        goto L15
    }

    public static ShadowLayout ha0(View r4, int r5) {
        ShadowLayout r0 = new ShadowLayout(r4.getContext());
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setShadowSize(p);
        r0.setShadowOffset(new Point(0, q));
        r0.setShadowColor(ContextCompat.getColor(r4.getContext(), 2131103168));
        r0.setShadowRadius(r);
        r0.addView(r4, new ShadowLayout.LayoutParams(r5, -2));
        return r0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int W90(View r5, int r6) {
        LarusChatJobEditFragmentBinding r0 = this.d;
        if (r0 == null) goto L9;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L9;
        int[] r3 = new int[2];
        int[] r2 = new int[2];
        r1.getLocationOnScreen(r3);
        r5.getLocationOnScreen(r2);
        return ((((r3[0] + r1.getWidth()) - i5.q()) - r6) - Math.max(0, p - 0)) - r2[0];
    L9:
        return 0;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.chat.job.impl.page.edit.x] */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        final LarusChatJobEditFragmentBinding r11 = this.d;
        if (r11 != null) goto L5;
        return;
    L5:
        this.e = new ChatJobEditAdapter(new AnonymousClass1(aa0()), new AnonymousClass2(this), ca0());
        r11.f.setLayoutManager(new LinearLayoutManager(r9.getContext()));
        r11.f.setAdapter(this.e);
        r11.a.setOnDragDismiss(new r(this, r11));
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new ChatJobEditFragment$bindBackPressed$1(this));
        ConstraintLayout r12 = r11.a;
        final ConstraintLayout r1 = r11.d;
        final RecyclerView r3 = r11.f;
        final ConstraintLayout r2 = r11.o;
        final LinearLayout r5 = r11.j;
        final int r4 = r3.getPaddingBottom();
        final int r6 = r5.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(r12, new k(r1, r2, r3, r4, r5, r6));
        ViewCompat.requestApplyInsets(r12);
        ea0();
        r11.b.setContentDescription(gz8.f.b("button_cancel"));
        r11.k.setContentDescription(gz8.f.b("button_cancel"));
        r11.l.setContentDescription(gz8.f.b("button_save"));
        com.larus.bmhome.instruction.g r13 = Z90(getParentFragmentManager());
        if (r13 != null) goto L8;
        FLogger.a.w("ChatJobEditFragment", "task reply model names unavailable: source ActionBar not found");
    L11:
        ChatJobEditViewModel r14 = aa0();
        Bundle r0 = getArguments();
        if (r0 == null) goto L14;
        String r7 = r0.getString("chat_job_id");
    L15:
        AIJob r8 = c0.b(getArguments());
        Bundle r15 = getArguments();
        int r16 = 1;
        if (r15 == null) goto L18;
        r16 = r15.getInt("job_type", 1);
    L18:
        r14.load(r7, r8, r16);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ChatJobEditFragment$observeEditList$1(this, null), 3, null);
        com.larus.utils.e1.d(r11.b, new s(this));
        com.larus.utils.e1.d(r11.g, new t(this, r11));
        com.larus.utils.e1.d(r11.k, new u(this));
        com.larus.utils.e1.d(r11.l, new v(this));
        return;
    L14:
        r7 = null;
        goto L15
    L8:
        aa0().updateTaskReplyModelDisplayNames(gz8.i.d(r13.tq()));
        LiveData<List<com.larus.bmhome.actionbar.model.z0>> r17 = r13.uE();
        if (r17 == null) goto L11;
        r17.observe(getViewLifecycleOwner(), new c(new x(this)));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static View ia0(CommonMenu r3, int r4, int r5) {
        FrameLayout r0 = new FrameLayout(r3.getContext());
        int r1 = gz8.g.a;
        r0.setBackground(gz8.g.a(r0.getContext()));
        r0.setPadding(r5, r5, r5, r5);
        r0.addView(r3, new FrameLayout.LayoutParams(-1, -2));
        r0.setLayoutParams(new ShadowLayout.LayoutParams(r4, -2));
        return r0;
    }

    public final PopupWindow fa0(View r3, View r4, int r5) {
        r4.setLayoutParams(new FrameLayout.LayoutParams(r5, -2));
        PopupWindow r6 = Y90(ha0(r4, r5));
        U90(r6, r3, W90(r3, r5), V90(r3));
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, com.larus.chat.job.impl.page.edit.ChatJobDragDismissLayout] */
    public final View onCreateView(LayoutInflater r26, ViewGroup r27, Bundle r28) {
        Intrinsics.checkNotNullParameter(r26, "inflater");
        View r4 = r26.inflate(2131561887, r27, false);
        int r5 = 2131377186;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r4, 2131377186);
        if (r9 == null) goto L40;
        r5 = 2131377187;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r4, 2131377187);
        if (r10 == null) goto L40;
        r5 = 2131377188;
        ConstraintLayout r11 = ViewBindings.findChildViewById(r4, 2131377188);
        if (r11 == null) goto L40;
        r5 = 2131377189;
        View r12 = ViewBindings.findChildViewById(r4, 2131377189);
        if (r12 == null) goto L40;
        r5 = 2131377195;
        RecyclerView r13 = ViewBindings.findChildViewById(r4, 2131377195);
        if (r13 == null) goto L40;
        r5 = 2131377201;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r4, 2131377201);
        if (r14 == null) goto L40;
        r5 = 2131377202;
        AppCompatImageView r15 = ViewBindings.findChildViewById(r4, 2131377202);
        if (r15 == null) goto L40;
        r5 = 2131377218;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r4, 2131377218);
        if (r16 == null) goto L40;
        r5 = 2131377219;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r4, 2131377219);
        if (r17 == null) goto L40;
        r5 = 2131377220;
        AppCompatImageView r18 = ViewBindings.findChildViewById(r4, 2131377220);
        if (r18 == null) goto L40;
        r5 = 2131377221;
        FrameLayout r19 = (FrameLayout) ViewBindings.findChildViewById(r4, 2131377221);
        if (r19 == null) goto L40;
        r5 = 2131377222;
        AppCompatImageView r20 = ViewBindings.findChildViewById(r4, 2131377222);
        if (r20 == null) goto L40;
        r5 = 2131377223;
        ProgressBar r21 = (ProgressBar) ViewBindings.findChildViewById(r4, 2131377223);
        if (r21 == null) goto L40;
        r5 = 2131377224;
        ConstraintLayout r22 = ViewBindings.findChildViewById(r4, 2131377224);
        if (r22 == null) goto L40;
        r5 = 2131377225;
        FrameLayout r23 = (FrameLayout) ViewBindings.findChildViewById(r4, 2131377225);
        if (r23 == null) goto L40;
        r5 = 2131377226;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r4, 2131377226);
        if (r24 == null) goto L40;
        ?? r6 = (ChatJobDragDismissLayout) r4;
        this.d = new LarusChatJobEditFragmentBinding(r6, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        if (r6 == 0) goto L38;
        return r6;
    L38:
        return r26.inflate(2131561887, r27, false);
    L40:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    }

    public static void U90(PopupWindow r2, View r3, int r4, int r5) {
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r2, r3, r0) == false) goto L5;
        return;
    L5:
        r2.showAsDropDown(r3, r4, r5);
        PopupWindowLancet.trackAfterShow(r2, r0, r3);
    }
}
