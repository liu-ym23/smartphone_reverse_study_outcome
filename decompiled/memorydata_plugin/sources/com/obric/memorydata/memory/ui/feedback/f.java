package com.obric.memorydata.memory.ui.feedback;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.chip.v2.OChip;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JU\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c\u0018\u00010\u001b2\u0012\b\u0002\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001eH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackDialog;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "localViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "localOwner", "com/obric/memorydata/memory/ui/feedback/MemoryFeedbackDialog$localOwner$1", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackDialog$localOwner$1;", "viewModel", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "collectJobs", "", "Lkotlinx/coroutines/Job;", "show", "", MemoryInfoSectionEditActivity.KIND_SCENE, "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackScene;", "extraText", "", "customFilePathListProvider", "Lkotlin/Function1;", "", "odpReportDataProvider", "Lkotlin/Function0;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "show$memory_obricRelease", "launchReportApp", "message", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10938a = null;
    private static final int g = 0;
    private static final int h = 0;
    private static final int i = 0;
    private static final int j = 0;
    private static final int k = 0;
    private static final int l = 0;
    private static final int m = 0;
    private static final int n = 0;
    private static final int o = 0;
    private static final int p = 0;
    private static final float q = 0.0f;
    private static final float r = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f10939b;
    private final ViewModelStore c;
    private final MemoryFeedbackDialog$localOwner$1 d;
    private final Lazy e;
    private final List<bx> f;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackDialog$Companion;", "", "<init>", "()V", "TAG", "", "MAX_FEEDBACK_CHARS", "", "LIMIT_COUNT_CHARS", "CHIP_GROUP_HORIZONTAL_MARGIN", "CHIP_GROUP_TOP_MARGIN", "INPUT_HORIZONTAL_MARGIN", "CHIP_GROUP_TO_INPUT_TOP_MARGIN", "INPUT_TO_FOOTER_BOTTOM_MARGIN", "INPUT_MIN_HEIGHT", "INPUT_MAX_HEIGHT", "INPUT_PADDING", "INPUT_HINT_ROW_HORIZONTAL_PADDING", "INPUT_HINT_ROW_BOTTOM_MARGIN", "INPUT_TEXT_SIZE_SP", "", "INPUT_HINT_ROW_TEXT_SIZE_SP", "INPUT_HEIGHT_ANIMATION_DURATION_MS", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputLayout f10940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OSheet f10941b;
        final /* synthetic */ LinearLayout c;
        final /* synthetic */ Ref.ObjectRef d;
        final /* synthetic */ Ref.ObjectRef e;
        final /* synthetic */ Ref.BooleanRef f;
        final /* synthetic */ NestedScrollView g;
        final /* synthetic */ Ref.ObjectRef h;
        final /* synthetic */ OChipGroup i;
        final /* synthetic */ LinearLayout j;
        final /* synthetic */ LinearLayout k;
        final /* synthetic */ Ref.BooleanRef l;
        final /* synthetic */ Ref.BooleanRef m;

        public b(OInputLayout r1, OSheet r2, LinearLayout r3, Ref.ObjectRef r4, Ref.ObjectRef r5, Ref.BooleanRef r6, NestedScrollView r7, Ref.ObjectRef r8, OChipGroup r9, LinearLayout r10, LinearLayout r11, Ref.BooleanRef r12, Ref.BooleanRef r13) {
            this.f10940a = r1;
            this.f10941b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
            this.m = r13;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r18) {
            Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r18, Editable.class, "com.obric.memorydata.plugin");
            this.f10940a.getVInput().post((Runnable) ZeusTransformUtils.preCheckCast(new d(this.f10941b, this.c, this.f10940a, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m), Runnable.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/memory/ui/feedback/MemoryFeedbackDialog$show$4", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "editable", "Landroid/text/Editable;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputLayout f10942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OTextView f10943b;
        final /* synthetic */ OTextView c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        c(OInputLayout r1, OTextView r2, OTextView r3, int r4, int r5) {
            this.f10942a = r1;
            this.f10943b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r4) {
            Editable r5 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L5;
            int r6 = r5.length();
        L7:
            if (r6 <= 500) goto L9;
            this.f10942a.setTextState(true);
            this.f10943b.setText((CharSequence) ZeusTransformUtils.preCheckCast("500/500", CharSequence.class, "com.obric.memorydata.plugin"));
            this.c.setTextColor(this.d);
            OTextView r7 = this.f10943b;
            int r3 = this.d;
        L10:
            r7.setTextColor(r3);
            return;
        L9:
            this.f10942a.setTextState(false);
            this.f10943b.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6 + "/500", CharSequence.class, "com.obric.memorydata.plugin"));
            this.c.setTextColor(this.e);
            r7 = this.f10943b;
            r3 = this.e;
            goto L10
        L5:
            r6 = 0;
            goto L7
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSheet f10944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinearLayout f10945b;
        final /* synthetic */ OInputLayout c;
        final /* synthetic */ Ref.ObjectRef<Integer> d;
        final /* synthetic */ Ref.ObjectRef<Boolean> e;
        final /* synthetic */ Ref.BooleanRef f;
        final /* synthetic */ NestedScrollView g;
        final /* synthetic */ Ref.ObjectRef<Integer> h;
        final /* synthetic */ OChipGroup i;
        final /* synthetic */ LinearLayout j;
        final /* synthetic */ LinearLayout k;
        final /* synthetic */ Ref.BooleanRef l;
        final /* synthetic */ Ref.BooleanRef m;

        d(OSheet r1, LinearLayout r2, OInputLayout r3, Ref.ObjectRef<Integer> r4, Ref.ObjectRef<Boolean> r5, Ref.BooleanRef r6, NestedScrollView r7, Ref.ObjectRef<Integer> r8, OChipGroup r9, LinearLayout r10, LinearLayout r11, Ref.BooleanRef r12, Ref.BooleanRef r13) {
            this.f10944a = r1;
            this.f10945b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
            this.m = r13;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a(this.f10944a, this.f10945b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, true, "textChanged");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f10946a;

        public e(f r1) {
            this.f10946a = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
            MemoryFeedbackViewModel r2 = f.a(this.f10946a);
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            if (r5 != null) goto L8;
            r5 = "";
        L8:
            r2.setInputText(r5);
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.feedback.f$f, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/memory/ui/feedback/MemoryFeedbackDialog$show$positionScrollableBodyAtBottomOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ViewTreeObserverOnPreDrawListenerC0559f implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NestedScrollView f10947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f10948b;
        final /* synthetic */ OSheet c;
        final /* synthetic */ LinearLayout d;
        final /* synthetic */ Ref.BooleanRef e;

        ViewTreeObserverOnPreDrawListenerC0559f(NestedScrollView r1, Ref.BooleanRef r2, OSheet r3, LinearLayout r4, Ref.BooleanRef r5) {
            this.f10947a = r1;
            this.f10948b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f10947a.getViewTreeObserver().isAlive() == false) goto L5;
            this.f10947a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        L5:
            this.f10948b.element = false;
            if (this.c.isShowing() == false) goto L8;
            this.f10947a.scrollTo(0, this.d.getHeight());
            this.e.element = true;
        L8:
            return true;
        }
    }

    static {
        f10938a = new a(null);
        g = 16;
        h = 16;
        i = 16;
        j = 20;
        k = 19;
        l = 94;
        m = 240;
        n = 8;
        o = 20;
        p = 16;
        q = 16.0f;
        r = 10.0f;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.obric.memorydata.memory.ui.feedback.MemoryFeedbackDialog$localOwner$1] */
    public f(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.f10939b = ZeusTransformUtils.wrapperContext2Activity(r4, "com.obric.memorydata.plugin");
        this.c = new ViewModelStore();
        this.d = new MemoryFeedbackDialog$localOwner$1(this);
        this.e = LazyKt.lazy(new $$Lambda$f$ge99iVZiS3eTyCaoyaAdSMS90dU(this));
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private static final int a(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        int r0 = 0;
        if (r4 == null) goto L9;
        int r1 = r4.topMargin;
    L10:
        if (r4 == null) goto L13;
        r0 = r4.bottomMargin;
    L13:
        return r1 + r0;
    L9:
        r1 = 0;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private static final int a(LinearLayout r2, OChipGroup r3, LinearLayout r4, LinearLayout r5) {
        return (((((((r2.getPaddingTop() + r2.getPaddingBottom()) + r3.getMeasuredHeight()) + a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"))) + r4.getPaddingTop()) + r4.getPaddingBottom()) + a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"))) + r5.getMeasuredHeight()) + a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Integer] */
    private static final int a(OInputLayout r3, Ref.ObjectRef<Integer> r4) {
        OEditText r0 = r3.getVInput();
        int r5 = RangesKt.coerceAtLeast(r3.getMeasuredHeight() - r0.getMeasuredHeight(), 0);
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r4.element, Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        r4.element = Integer.valueOf(r5);
        return r5;
    L7:
        return r1.intValue();
    }

    private final MemoryFeedbackViewModel a() {
        return (MemoryFeedbackViewModel) ZeusTransformUtils.preCheckCast(this.e.getValue(), MemoryFeedbackViewModel.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ MemoryFeedbackViewModel a(f r0) {
        return r0.a();
    }

    private static final OChipGroup a(Context r6, int r7, int r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "styledContext");
        OChipGroup r9 = new OChipGroup(r1, null, 0, 6, null);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, -2);
        int r0 = g;
        r10.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())));
        r10.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())));
        r10.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, h, Resources.getSystem().getDisplayMetrics()));
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return r9;
    }

    private static final OChip a(final f r4, final OChipGroup r5, final String r6, boolean r7) {
        if (r7 == false) goto L5;
        int r8 = R.layout.memory_feedback_chip;
        String r1 = "memory_feedback_chip";
    L6:
        int r9 = ZeusTransformUtils.mapRes(r8, "layout", r1);
        View r10 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(r4.f10939b, Context.class, "com.obric.memorydata.plugin")), r9, (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.oui.chip.v2.OChip");
        OChip r11 = (OChip) ZeusTransformUtils.preCheckCast(r10, OChip.class, "com.obric.memorydata.plugin");
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        r11.setOnClickListener(new $$Lambda$f$wOKzn9cODDM6T_4MA29SFK7Bl70(r4, r6, r5));
        return r11;
    L5:
        r8 = R.layout.memory_feedback_chip_default;
        r1 = "memory_feedback_chip_default";
        goto L6
    }

    public static /* synthetic */ void a(f r1, MemoryFeedbackScene r2, String r3, Function1 r4, Function0 r5, int r6, Object r7) {
        Function1<? super String, ? extends List<String>> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<h> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r8 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r9 = null;
    L11:
        r1.a(r2, r3, r8, r9);
    }

    private static final void a(f r3, MemoryFeedbackScene r4, String r5, Function1 r6, Function0 r7, View r8) {
        Function1<? super String, ? extends List<String>> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function0<h> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.info("MemoryFeedbackDialog", "click feedback submit", true);
        r3.a().submit$memory_obricRelease(r4.getDescriptionTitleResId(), r5, r9, r10);
    }

    public static final /* synthetic */ void a(f r0, String r1) {
        r0.a(r1);
    }

    private static final void a(f r2, String r3, OChipGroup r4, View r5) {
        r2.a().selectOption(r3);
        r4.removeAllViews();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(r2.a().getState().c(), o.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        com.obric.memorydata.memory.ui.feedback.d r7 = (com.obric.memorydata.memory.ui.feedback.d) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.memorydata.memory.ui.feedback.d.class, "com.obric.memorydata.plugin");
        r4.addView((View) ZeusTransformUtils.preCheckCast(a(r2, r4, r7.a(), r7.b()), View.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private static final void a(OEditText r5, int r6, String r7) {
        Layout r0 = r5.getLayout();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getLineForOffset(r6);
        int r2 = RangesKt.coerceAtLeast((r5.getHeight() - r5.getCompoundPaddingTop()) - r5.getCompoundPaddingBottom(), 0);
        int r4 = RangesKt.coerceAtLeast(r0.getHeight() - r2, 0);
        int r3 = RangesKt.coerceIn(r0.getLineBottom(r1) - r2, 0, r4);
        r5.scrollTo(0, r3);
        RunLog.INSTANCE.debug("MemoryFeedbackDialog", "scroll input to text end trigger=" + r7 + " length=" + r6 + " line=" + r1 + " targetY=" + r3 + " maxY=" + r4);
    }

    private static final void a(OInputLayout r2) {
        int r0 = RangesKt.coerceAtLeast(r2.getVInput().getSelectionEnd(), 0);
        if (r0 <= 0) goto L6;
        r2.getVInput().bringPointIntoView(r0);
        return;
    }

    public static final /* synthetic */ void a(OInputLayout r0, OSheet r1, String r2) {
        b(r0, r1, r2);
    }

    public static final /* synthetic */ void a(OInputLayout r0, Ref.ObjectRef r1, OSheet r2, String r3) {
        b(r0, r1, r2, r3);
    }

    private static final void a(OSheet r3, View r4) {
        RunLog.INSTANCE.info("MemoryFeedbackDialog", "click close", true);
        r3.dismiss();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.Boolean] */
    private static final void a(OSheet r18, LinearLayout r19, OInputLayout r20, Ref.ObjectRef r21, Ref.ObjectRef r22, String r23, boolean r24, Ref.BooleanRef r25, NestedScrollView r26, Ref.ObjectRef r27, OChipGroup r28, LinearLayout r29, LinearLayout r30, Ref.BooleanRef r31, Ref.BooleanRef r32) {
        if (r18.isShowing() == true) goto L5;
        return;
    L5:
        if (r19.getHeight() > 0) goto L7;
        return;
    L7:
        if (r20.getHeight() > 0) goto L9;
        return;
    L9:
        if (r18.getHeaderContainer().getHeight() > 0) goto L11;
        return;
    L11:
        if (r18.getFooterContainer().getHeight() <= 0) goto L46;
        com.obric.memorydata.memory.ui.feedback.b r7 = new com.obric.memorydata.memory.ui.feedback.b(b(r20, r27), c(r20, r27), MathKt.roundToInt(TypedValue.applyDimension(1, m, Resources.getSystem().getDisplayMetrics())), r18.f(), r18.getRootContainer().getPaddingTop(), r18.getRootContainer().getPaddingBottom(), r18.getHeaderContainer().getHeight(), r18.getFooterContainer().getHeight(), a(r19, r28, r29, r30));
        com.obric.memorydata.memory.ui.feedback.c r0 = com.obric.memorydata.memory.ui.feedback.a.f10928a.a(r7);
        int r8 = r0.a();
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r21.element, Integer.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L17;
    L23:
        RunLog r10 = RunLog.INSTANCE;
        StringBuilder r11 = new StringBuilder();
        r11.append("update input height trigger=").append(r23).append(" animate=").append(r24).append(" target=").append(r8).append(" content=").append(r7.a()).append(" min=").append(r7.b()).append(" sheetMax=").append(r7.d()).append(" padding=").append(r7.e()).append(',').append(r7.f()).append(" header=").append(r7.g()).append(" footer=").append(r7.h()).append(" bodyFixed=").append(r7.i()).append(" scrollBody=");
        r11.append(r0.b());
        r10.debug("MemoryFeedbackDialog", r11.toString());
        if (r24 == false) goto L29;
        if (r25.element == false) goto L29;
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r18.getRootContainer(), ViewGroup.class, "com.obric.memorydata.plugin");
        AutoTransition r12 = new AutoTransition();
        r12.setDuration(180);
        r12.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        TransitionManager.beginDelayedTransition(r3, (Transition) ZeusTransformUtils.preCheckCast(r12, Transition.class, "com.obric.memorydata.plugin"));
    L29:
        if (Intrinsics.areEqual(r22.element, Boolean.valueOf(r0.b())) == true) goto L40;
        r22.element = Boolean.valueOf(r0.b());
        r26.setFillViewport(r0.b());
        ViewGroup.LayoutParams r4 = r26.getLayoutParams();
        if (r0.b() == false) goto L33;
        int r13 = -1;
    L34:
        r4.height = r13;
        r26.setLayoutParams(r4);
        if (r0.b() == false) goto L37;
        OSheet.HeightMode r1 = OSheet.HeightMode.FULL_HEIGHT;
    L38:
        r18.a(r1);
        goto L40
    L37:
        r1 = OSheet.HeightMode.WRAP_HEIGHT;
        goto L38
    L33:
        r13 = -2;
    L40:
        r21.element = Integer.valueOf(r8);
        ViewGroup.LayoutParams r2 = r20.getLayoutParams();
        r2.height = r8;
        r20.setLayoutParams(r2);
        r20.setMinimumHeight(r8);
        int r5 = com.obric.memorydata.memory.ui.feedback.a.f10928a.a(r8, a(r20, r27));
        OEditText r14 = r20.getVInput();
        r14.setMinHeight(r5);
        r14.setMinimumHeight(r5);
        r14.setMaxHeight(r5);
        r25.element = true;
        b(r20);
        a(r22, r31, r32, r26, r18, r19);
        return;
    L17:
        if (r9.intValue() != r8) goto L23;
        if (r20.getLayoutParams().height != r8) goto L23;
        if (Intrinsics.areEqual(r22.element, Boolean.valueOf(r0.b())) == false) goto L23;
        return;
    }

    private static final void a(OSheet r15, LinearLayout r16, OInputLayout r17, Ref.ObjectRef r18, Ref.ObjectRef r19, Ref.BooleanRef r20, NestedScrollView r21, Ref.ObjectRef r22, OChipGroup r23, LinearLayout r24, LinearLayout r25, Ref.BooleanRef r26, Ref.BooleanRef r27) {
        b(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, false, "initialLayout");
    }

    private static final void a(OSheet r15, LinearLayout r16, OInputLayout r17, Ref.ObjectRef r18, Ref.ObjectRef r19, Ref.BooleanRef r20, NestedScrollView r21, Ref.ObjectRef r22, OChipGroup r23, LinearLayout r24, LinearLayout r25, Ref.BooleanRef r26, Ref.BooleanRef r27, Ref.ObjectRef r28, View r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37) {
        b(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, true, "sheetLayout");
        b(r17, r28, r15, "sheetLayout");
    }

    public static final /* synthetic */ void a(OSheet r0, LinearLayout r1, OInputLayout r2, Ref.ObjectRef r3, Ref.ObjectRef r4, Ref.BooleanRef r5, NestedScrollView r6, Ref.ObjectRef r7, OChipGroup r8, LinearLayout r9, LinearLayout r10, Ref.BooleanRef r11, Ref.BooleanRef r12, boolean r13, String r14) {
        b(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    private static final void a(OSheet r1, final OEditText r2, final String r3) {
        if (r1.isShowing() == true) goto L5;
        return;
    L5:
        Editable r4 = r2.getText();
        if (r4 == null) goto L8;
        final int r5 = r4.length();
    L10:
        if (r2.getSelectionStart() == r5) goto L12;
    L13:
        r2.setSelection(r5);
    L14:
        r2.postOnAnimation(new $$Lambda$f$_OpbHoPpm1Vf1411YHAqw842164(r2, r5, r3));
        return;
    L12:
        if (r2.getSelectionEnd() == r5) goto L14;
    L8:
        r5 = 0;
        goto L10
    }

    private final void a(final String r3) {
        new Handler(Looper.getMainLooper()).post(new $$Lambda$f$ggGPrMiT4wQEfM6BSB7tlzdV064(this, r3));
    }

    private static final void a(Ref.ObjectRef r2, OSheet r3, f r4, DialogInterface r5) {
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.memorydata.plugin");
        View.OnLayoutChangeListener r7 = (View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(r2.element, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        r3.getRootContainer().removeOnLayoutChangeListener(r7);
    L5:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        bx.a.a((bx) ZeusTransformUtils.preCheckCast(r8.next(), bx.class, "com.obric.memorydata.plugin"), null, 1, null);
        goto L7
    L9:
        r4.f.clear();
        r4.c.clear();
    }

    private static final void a(Ref.ObjectRef<Boolean> r7, Ref.BooleanRef r8, Ref.BooleanRef r9, NestedScrollView r10, OSheet r11, LinearLayout r12) {
        if (Intrinsics.areEqual(r7.element, true) == true) goto L5;
        return;
    L5:
        if (r8.element == false) goto L7;
        return;
    L7:
        if (r9.element == true) goto L13;
        r8.element = true;
        r10.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new ViewTreeObserverOnPreDrawListenerC0559f(r10, r8, r11, r12, r9), ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        return;
    }

    private static final boolean a(Ref.FloatRef r5, View r6, MotionEvent r7) {
        int r0 = r7.getActionMasked();
        int r1 = -1;
        boolean r3 = true;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L6;
    L22:
        r6.getParent().requestDisallowInterceptTouchEvent(false);
    L30:
        return false;
    L6:
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L22;
    L11:
        if (r7.getY() <= r5.element) goto L14;
    L17:
        r5.element = r7.getY();
        ViewParent r8 = r6.getParent();
        if (r1 != 0) goto L20;
    L29:
        r8.requestDisallowInterceptTouchEvent(r3);
        goto L30
    L20:
        if (r6.canScrollVertically(r1) == true) goto L29;
    L28:
        r3 = false;
        goto L29
    L14:
        if (r7.getY() >= r5.element) goto L16;
        r1 = 1;
        goto L17
    L16:
        r1 = 0;
        goto L17
    L23:
        r5.element = r7.getY();
        r8 = r6.getParent();
        if (r6.canScrollVertically(-1) == true) goto L29;
        if (r6.canScrollVertically(1) == false) goto L28;
        goto L28
    }

    private static final int b(OInputLayout r2, Ref.ObjectRef<Integer> r3) {
        OEditText r0 = r2.getVInput();
        Layout r1 = r0.getLayout();
        if (r1 == null) goto L5;
        int r4 = r1.getHeight();
    L7:
        return ((a(r2, r3) + r4) + r0.getCompoundPaddingTop()) + r0.getCompoundPaddingBottom();
    L5:
        r4 = r0.getLineHeight();
        goto L7
    }

    public static final /* synthetic */ Activity b(f r0) {
        return r0.f10939b;
    }

    private static final void b(f r10, String r11) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Intent r3 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L8
        r3.setPackage("com.obric.feedbackserviceproject");     // Catch: Throwable -> L8
        r3.setClassName("com.obric.feedbackserviceproject", "com.obric.feedbackserviceproject.MainActivity");     // Catch: Throwable -> L8
        r3.addCategory("android.intent.category.LAUNCHER");     // Catch: Throwable -> L8
        if (r10.f10939b.getPackageManager().resolveActivity(r3, 0) == null) goto L7;
        com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast(r10.f10939b, Context.class, "com.obric.memorydata.plugin"), r11, 0, 4, null);     // Catch: Throwable -> L8
        ZeusTransformUtils.startActivity(r10.f10939b, r3, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L15;
        RunLog.INSTANCE.error("MemoryFeedbackDialog", "launch report app failed", r13);
        com.obric.oui.toast.a.C0786a r4 = com.obric.oui.toast.a.f14807a;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(r10.f10939b, Context.class, "com.obric.memorydata.plugin");
        String r6 = r10.f10939b.getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_submit_failed, TypedValues.Custom.S_STRING, "memory_feedback_submit_failed"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r4, r5, r6, 0, 4, null);
        return;
    L15:
        return;
    L7:
        throw new RuntimeException("Activity not found or disabled");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final void b(final OInputLayout r2) {
        r2.getVInput().post(new $$Lambda$f$ttoghsExG8Xi3MzWILHleSZxXLk(r2));
    }

    private static final void b(OInputLayout r1, final OSheet r2, final String r3) {
        final OEditText r4 = r1.getVInput();
        r4.post(new $$Lambda$f$54Drl5X78ofARwXz31moMjtTbAU(r2, r4, r3));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
    private static final void b(OInputLayout r5, Ref.ObjectRef<Boolean> r6, OSheet r7, String r8) {
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(r5.getVInput(), View.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L5;
        boolean r1 = r0.isVisible(WindowInsetsCompat.Type.ime());
    L6:
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(r6.element, Boolean.class, "com.obric.memorydata.plugin");
        r6.element = Boolean.valueOf(r1);
        if (r1 == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r2, false) == false) goto L13;
        b(r5, r7, r8);
        return;
    L13:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private static final void b(final OSheet r18, final LinearLayout r19, final OInputLayout r20, final Ref.ObjectRef<Integer> r21, final Ref.ObjectRef<Boolean> r22, final Ref.BooleanRef r23, final NestedScrollView r24, final Ref.ObjectRef<Integer> r25, final OChipGroup r26, final LinearLayout r27, final LinearLayout r28, final Ref.BooleanRef r29, final Ref.BooleanRef r30, final boolean r31, final String r32) {
        r18.getRootContainer().post(new $$Lambda$f$hDtebjKhDATVzS4o32osAPlOEnc(r18, r19, r20, r21, r22, r32, r31, r23, r24, r25, r26, r27, r28, r29, r30));
    }

    private static final int c(OInputLayout r2, Ref.ObjectRef<Integer> r3) {
        OEditText r0 = r2.getVInput();
        return Math.max(MathKt.roundToInt(TypedValue.applyDimension(1, l, Resources.getSystem().getDisplayMetrics())), ((a(r2, r3) + r0.getLineHeight()) + r0.getCompoundPaddingTop()) + r0.getCompoundPaddingBottom());
    }

    public static final /* synthetic */ ViewModelStore c(f r0) {
        return r0.c;
    }

    private static final MemoryFeedbackViewModel d(f r3) {
        return (MemoryFeedbackViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3.d, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryFeedbackViewModel.class), MemoryFeedbackViewModel.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$1ft-Zq_C7bsNF8ywgROMXEy_Gts, reason: not valid java name */
    public static /* synthetic */ OChipGroup m860lambda$1ftZq_C7bsNF8ywgROMXEy_Gts(Context r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$1jqoq6-DoAWO0tgZnwrHcu6XJH8, reason: not valid java name */
    public static /* synthetic */ void m861lambda$1jqoq6DoAWO0tgZnwrHcu6XJH8(OSheet r0, LinearLayout r1, OInputLayout r2, Ref.ObjectRef r3, Ref.ObjectRef r4, Ref.BooleanRef r5, NestedScrollView r6, Ref.ObjectRef r7, OChipGroup r8, LinearLayout r9, LinearLayout r10, Ref.BooleanRef r11, Ref.BooleanRef r12) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ void lambda$54Drl5X78ofARwXz31moMjtTbAU(OSheet r0, OEditText r1, String r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Mq5QnLKjVrFkDM7esgiFVfmdqM0(OSheet r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$N1yP_Dk5m2_7OKWodrreWl1iDXQ(Ref.FloatRef r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$PVDJvvGPt2t3bSboPKlhNRlMbf0(OSheet r0, LinearLayout r1, OInputLayout r2, Ref.ObjectRef r3, Ref.ObjectRef r4, Ref.BooleanRef r5, NestedScrollView r6, Ref.ObjectRef r7, OChipGroup r8, LinearLayout r9, LinearLayout r10, Ref.BooleanRef r11, Ref.BooleanRef r12, Ref.ObjectRef r13, View r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    /* JADX INFO: renamed from: lambda$S9Mt9zrHMpFWtakNsL57T-4ftX4, reason: not valid java name */
    public static /* synthetic */ void m862lambda$S9Mt9zrHMpFWtakNsL57T4ftX4(f r0, MemoryFeedbackScene r1, String r2, Function1 r3, Function0 r4, View r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$Thnpv3qOp0X4rlwoOrd9wQzfosA(Ref.ObjectRef r0, OSheet r1, f r2, DialogInterface r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$_OpbHoPpm1Vf1411YHAqw842164(OEditText r0, int r1, String r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ MemoryFeedbackViewModel lambda$ge99iVZiS3eTyCaoyaAdSMS90dU(f r0) {
        return d(r0);
    }

    public static /* synthetic */ void lambda$ggGPrMiT4wQEfM6BSB7tlzdV064(f r0, String r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$hDtebjKhDATVzS4o32osAPlOEnc(OSheet r0, LinearLayout r1, OInputLayout r2, Ref.ObjectRef r3, Ref.ObjectRef r4, String r5, boolean r6, Ref.BooleanRef r7, NestedScrollView r8, Ref.ObjectRef r9, OChipGroup r10, LinearLayout r11, LinearLayout r12, Ref.BooleanRef r13, Ref.BooleanRef r14) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void lambda$ttoghsExG8Xi3MzWILHleSZxXLk(OInputLayout r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$wOKzn9cODDM6T_4MA29SFK7Bl70(f r0, String r1, OChipGroup r2, View r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v88, types: [T, com.obric.memorydata.memory.ui.feedback.-$$Lambda$f$PVDJvvGPt2t3bSboPKlhNRlMbf0] */
    public final void a(final MemoryFeedbackScene r38, final String r39, Function1<? super String, ? extends List<String>> r40, Function0<h> r41) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r40, Function1.class, "com.obric.memorydata.plugin");
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r41, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r38, MemoryInfoSectionEditActivity.KIND_SCENE);
        RunLog.INSTANCE.info("MemoryFeedbackDialog", "enter feedback dialog", true);
        a().loadOptions(r38.getOptionResIds());
        final OSheet r3 = new OSheet((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), 0, 0, false, false, 30, null);
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r3.a(OSheet.HeightMode.WRAP_HEIGHT);
        r3.f(false);
        r3.setOnDismissListener(new $$Lambda$f$Thnpv3qOp0X4rlwoOrd9wQzfosA(r1, r3, this));
        r3.a(OSheet.Header.MODAL, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_title, TypedValues.Custom.S_STRING, "memory_feedback_title")), null, null, null, false, null, new $$Lambda$f$Mq5QnLKjVrFkDM7esgiFVfmdqM0(r3), null, null, null, null, null, null);
        RunLog.INSTANCE.debug("MemoryFeedbackDialog", "build body start");
        final LinearLayout r15 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"));
        r15.setOrientation(1);
        r15.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        final OChipGroup r14 = (OChipGroup) ZeusTransformUtils.preCheckCast(com.obric.oui.c.e.a((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.style.MemoryProFeedbackChipGroupStyle, "style", "MemoryProFeedbackChipGroupStyle"), $$Lambda$f$1ftZq_C7bsNF8ywgROMXEy_Gts.INSTANCE), OChipGroup.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(a().getState().c(), o.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        com.obric.memorydata.memory.ui.feedback.d r11 = (com.obric.memorydata.memory.ui.feedback.d) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.memorydata.memory.ui.feedback.d.class, "com.obric.memorydata.plugin");
        r14.addView((View) ZeusTransformUtils.preCheckCast(a(this, r14, r11.a(), r11.b()), View.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        r15.addView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
        final OInputLayout r13 = new OInputLayout((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
        r13.a(false);
        r13.c(false);
        r13.e(false);
        r13.setType(1);
        r13.getVInput().setHint((CharSequence) ZeusTransformUtils.preCheckCast(this.f10939b.getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_input_hint, TypedValues.Custom.S_STRING, "memory_feedback_input_hint")), CharSequence.class, "com.obric.memorydata.plugin"));
        r13.getVInput().setTextSize(2, q);
        r13.getVInput().setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        r13.getVInput().setHintTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b")));
        r13.getVInput().setInputType(131073);
        r13.getVInput().setMaxLines(Integer.MAX_VALUE);
        r13.getVInput().setHorizontallyScrolling(false);
        OEditText r2 = r13.getVInput();
        int r9 = l;
        r2.setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r9, Resources.getSystem().getDisplayMetrics())));
        r13.getVInput().setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r9, Resources.getSystem().getDisplayMetrics())));
        r13.getVInput().setMaxHeight(MathKt.roundToInt(TypedValue.applyDimension(1, m, Resources.getSystem().getDisplayMetrics())));
        r13.getVInput().setVerticalScrollBarEnabled(true);
        r13.getVInput().setMovementMethod(ScrollingMovementMethod.getInstance());
        r13.getVInput().setLongClickable(true);
        r13.getVInput().setGravity(48);
        r13.getVInput().setTextIsSelectable(true);
        OEditText r6 = r13.getVInput();
        int r12 = n;
        r6.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())));
        r13.setLimitCount(501);
        r13.g(false);
        r13.setAutoChangeWithLimit(true);
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r13.getVInput(), TextView.class, "com.obric.memorydata.plugin");
        e r8 = new e(this);
        r7.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r8, TextWatcher.class, "com.obric.memorydata.plugin"));
        TextWatcher r16 = (TextWatcher) ZeusTransformUtils.preCheckCast(r8, TextWatcher.class, "com.obric.memorydata.plugin");
        r13.getVInput();
        final LinearLayout r17 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"));
        r17.setOrientation(0);
        r17.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        int r18 = o;
        r17.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r18, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r18, Resources.getSystem().getDisplayMetrics())), 0);
        OTextView r19 = new OTextView((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        r19.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f10939b.getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_limit_hint, TypedValues.Custom.S_STRING, "memory_feedback_limit_hint"), new Object[]{500}), CharSequence.class, "com.obric.memorydata.plugin"));
        r19.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(0, -2, 1.0f), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        float r20 = r;
        r19.setTextSize(2, r20);
        r19.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        OTextView r21 = new OTextView((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        r21.setText((CharSequence) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(a().getState().c(), o.class, "com.obric.memorydata.plugin")).b().length() + "/500", CharSequence.class, "com.obric.memorydata.plugin"));
        r21.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r21.setTextSize(2, r20);
        r21.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r13.getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new c(r13, r21, r19, ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6")), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3"))), TextWatcher.class, "com.obric.memorydata.plugin"));
        r17.addView((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin"));
        r17.addView((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"));
        final LinearLayout r22 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"));
        r22.setOrientation(1);
        r22.setBackground(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.bg_memory_card, "drawable", "bg_memory_card")));
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-1, -2);
        int r24 = i;
        r23.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r24, Resources.getSystem().getDisplayMetrics())));
        r23.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r24, Resources.getSystem().getDisplayMetrics())));
        r23.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, j, Resources.getSystem().getDisplayMetrics()));
        r23.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, k, Resources.getSystem().getDisplayMetrics()));
        r22.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r23, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r22.addView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r25 = (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin");
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(-1, -2);
        r26.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, p, Resources.getSystem().getDisplayMetrics()));
        Unit r27 = Unit.INSTANCE;
        r22.addView(r25, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r26, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r15.addView((View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin"));
        final NestedScrollView r28 = new NestedScrollView((Context) ZeusTransformUtils.preCheckCast(this.f10939b, Context.class, "com.obric.memorydata.plugin"));
        r28.setFillViewport(false);
        r28.setVerticalScrollBarEnabled(false);
        r28.setOverScrollMode(1);
        r28.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r28.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        final Ref.FloatRef r110 = new Ref.FloatRef();
        r13.getVInput().setOnTouchListener(new $$Lambda$f$N1yP_Dk5m2_7OKWodrreWl1iDXQ(r110));
        final Ref.ObjectRef r29 = new Ref.ObjectRef();
        final Ref.BooleanRef r210 = new Ref.BooleanRef();
        final Ref.ObjectRef r30 = new Ref.ObjectRef();
        final Ref.ObjectRef r31 = new Ref.ObjectRef();
        final Ref.BooleanRef r32 = new Ref.BooleanRef();
        final Ref.BooleanRef r33 = new Ref.BooleanRef();
        final Ref.ObjectRef r111 = new Ref.ObjectRef();
        ViewCompat.setWindowInsetsAnimationCallback((View) ZeusTransformUtils.preCheckCast(r13.getVInput(), View.class, "com.obric.memorydata.plugin"), (WindowInsetsAnimationCompat.Callback) ZeusTransformUtils.preCheckCast(new MemoryFeedbackDialog$show$7(r111, r13, r3), WindowInsetsAnimationCompat.Callback.class, "com.obric.memorydata.plugin"));
        TextView r112 = (TextView) ZeusTransformUtils.preCheckCast(r13.getVInput(), TextView.class, "com.obric.memorydata.plugin");
        b r113 = new b(r13, r3, r15, r30, r31, r210, r28, r29, r14, r22, r17, r32, r33);
        r112.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r113, TextWatcher.class, "com.obric.memorydata.plugin"));
        TextWatcher r34 = (TextWatcher) ZeusTransformUtils.preCheckCast(r113, TextWatcher.class, "com.obric.memorydata.plugin");
        r3.c((View) ZeusTransformUtils.preCheckCast(r28, View.class, "com.obric.memorydata.plugin"));
        r3.a(null, false, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.memory_feedback_submit, TypedValues.Custom.S_STRING, "memory_feedback_submit")), true, new $$Lambda$f$S9Mt9zrHMpFWtakNsL57T4ftX4(this, r38, r39, r4, r5));
        View r35 = r3.u();
        if (r35 == null) goto L25;
        Iterable r36 = (Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(a().getState().c(), o.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r36, Collection.class) == true) goto L11;
    L13:
        Iterator r37 = r36.iterator();
    L15:
        if (r37.hasNext() == false) goto L12;
        if (((com.obric.memorydata.memory.ui.feedback.d) ZeusTransformUtils.preCheckCast(r37.next(), com.obric.memorydata.memory.ui.feedback.d.class, "com.obric.memorydata.plugin")).b() == false) goto L15;
        boolean r42 = true;
    L19:
        if (r42 == true) goto L21;
    L23:
        boolean r43 = false;
    L24:
        r35.setEnabled(r43);
        Unit r44 = Unit.INSTANCE;
        goto L25
    L21:
        if (((o) ZeusTransformUtils.preCheckCast(a().getState().c(), o.class, "com.obric.memorydata.plugin")).b().length() > 500) goto L23;
        r43 = true;
    L12:
        r42 = false;
        goto L19
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
    L25:
        RunLog.INSTANCE.debug("MemoryFeedbackDialog", "sheet built, ready to show");
        r3.show();
        RunLog.INSTANCE.debug("MemoryFeedbackDialog", "sheet shown");
        WindowInsetsCompat r45 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(r13.getVInput(), View.class, "com.obric.memorydata.plugin"));
        if (r45 == null) goto L28;
        T r46 = Boolean.valueOf(r45.isVisible(WindowInsetsCompat.Type.ime()));
    L29:
        r111.element = r46;
        r1.element = new $$Lambda$f$PVDJvvGPt2t3bSboPKlhNRlMbf0(r3, r15, r13, r30, r31, r210, r28, r29, r14, r22, r17, r32, r33, r111);
        r3.getRootContainer().addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(r1.element, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        r15.post(new $$Lambda$f$1jqoq6DoAWO0tgZnwrHcu6XJH8(r3, r15, r13, r30, r31, r210, r28, r29, r14, r22, r17, r32, r33));
        Activity r47 = this.f10939b;
        if (ZeusTransformUtils.instanceOf(r47, LifecycleOwner.class) == false) goto L32;
        LifecycleOwner r48 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(r47, LifecycleOwner.class, "com.obric.memorydata.plugin");
    L33:
        if (r48 != null) goto L35;
        return;
    L35:
        ((Collection) ZeusTransformUtils.preCheckCast(this.f, Collection.class, "com.obric.memorydata.plugin")).add(kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r48), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryFeedbackDialog$show$13(this, r3, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        ((Collection) ZeusTransformUtils.preCheckCast(this.f, Collection.class, "com.obric.memorydata.plugin")).add(kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r48), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryFeedbackDialog$show$14(this, r3, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        return;
    L32:
        r48 = null;
        goto L33
    L28:
        r46 = false;
        goto L29
    }
}
