package com.ss.android.lark.picker.base.widget.selectedview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseResponsiveComponentActivity;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.component_container.a;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreResponsiveActivity;", "Lcom/ss/android/lark/base/fragment/BaseResponsiveComponentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SelectedMoreResponsiveActivity extends BaseResponsiveComponentActivity {
    public static final Companion Companion = null;
    private static final String ENABLE_CHAT_PREVIEW = "enableChatPreview";
    public static final String KEY_REMOVE_DATA = "removeData";
    private static final String KEY_SCENE = "keyScene";
    private static final String KEY_USE_RESULT = "useResult";
    public static final String SELECTED_DATA = "selected.data";
    public static final String _TAG = "LarkSearch.SearchWidget.SelectedMoreActivity";

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017JF\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J2\u0010\u001a\u001a\u00020\u001b*\u00020\u001b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreResponsiveActivity$Companion;", "", "<init>", "()V", "_TAG", "", "SELECTED_DATA", "KEY_REMOVE_DATA", "ENABLE_CHAT_PREVIEW", "KEY_SCENE", "KEY_USE_RESULT", "startForResult", "", "context", "Landroid/content/Context;", "data", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isEnableChatPreview", "", "isUseResult", "scene", "requestCode", "", "fragment", "Landroidx/fragment/app/Fragment;", "applyParams", "Landroid/content/Intent;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Serializable, java.lang.Object[]] */
        private final Intent applyParams(Intent r2, List<? extends SearchBaseInfo> r3, boolean r4, boolean r5, String r6) {
            r2.putExtra("selected.data", r3.toArray(new SearchBaseInfo[0]));
            r2.putExtra(SelectedMoreResponsiveActivity.ENABLE_CHAT_PREVIEW, r4);
            r2.putExtra(SelectedMoreResponsiveActivity.KEY_USE_RESULT, r5);
            r2.putExtra(SelectedMoreResponsiveActivity.KEY_SCENE, r6);
            return r2;
        }

        public final void startForResult(Context r8, List<? extends SearchBaseInfo> r9, boolean r10, boolean r11, String r12, int r13) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r9, "data");
            Intrinsics.checkNotNullParameter(r12, "scene");
            Intent r14 = applyParams(new Intent(r8, SelectedMoreResponsiveActivity.class), r9, r10, r11, r12).addFlags(65536);
            boolean r15 = r8 instanceof Activity;
            Activity r16 = null;
            if (r15 == false) goto L5;
            Activity r17 = (Activity) r8;
        L6:
            if (r17 == null) goto L8;
            r17.startActivityForResult(r14, r13);
        L8:
            if (r15 == false) goto L10;
            r16 = (Activity) r8;
        L10:
            if (r16 == null) goto L13;
            r16.overridePendingTransition(0, 0);
            return;
        L13:
            return;
        L5:
            r17 = null;
            goto L6
        }

        public final void startForResult(Context r8, Fragment r9, List<? extends SearchBaseInfo> r10, boolean r11, boolean r12, String r13, int r14) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r10, "data");
            Intrinsics.checkNotNullParameter(r13, "scene");
            Intent r15 = applyParams(new Intent(r8, SelectedMoreResponsiveActivity.class), r10, r11, r12, r13).addFlags(65536);
            if (r9 == null) goto L5;
            r9.startActivityForResult(r15, r14);
        L5:
            if (r9 == null) goto L10;
            FragmentActivity r16 = r9.getActivity();
            if (r16 == null) goto L11;
            r16.overridePendingTransition(0, 0);
            return;
        L11:
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__finish$___twin___() {
        super.finish();
    }

    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__onStop$___twin___() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
    }

    public void finish() {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SelectedMoreResponsiveActivity() {
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SelectedMoreResponsiveActivity r1) {
        r1.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(SelectedMoreResponsiveActivity r11) {
        r11.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(SelectedMoreResponsiveActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(2097152);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(SelectedMoreResponsiveActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        SelectedMoreFragment r4 = new SelectedMoreFragment();
        r4.setArguments(getIntent().getExtras());
        a.b(r4, this, null, Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(SelectedMoreResponsiveActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreResponsiveActivity__onCreate$___twin___(r2);
    }
}
