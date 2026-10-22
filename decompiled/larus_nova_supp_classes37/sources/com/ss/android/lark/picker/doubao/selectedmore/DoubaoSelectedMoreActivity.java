package com.ss.android.lark.picker.doubao.selectedmore;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "moreList", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "bottomBarBtn", "Landroid/widget/Button;", "selectedData", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "adapter", "Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreAdapter;", "removedData", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateBottomSelectedCount", "count", "", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoSelectedMoreActivity extends BaseFragmentActivity {
    public static final Companion Companion = null;
    private static final String ENABLE_CHAT_PREVIEW = "enableChatPreview";
    public static final String KEY_REMOVE_DATA = "removeData";
    private static final String KEY_SCENE = "keyScene";
    private static final String KEY_USE_RESULT = "useResult";
    public static final String SELECTED_DATA = "selected.data";
    public static final String TAG = "LarkSearch.SearchWidget.DoubaoSelectedMoreActivity";
    private DoubaoSelectedMoreAdapter adapter;
    private Button bottomBarBtn;
    private CommonRecyclerView moreList;
    private final List<SearchBaseInfo> removedData;
    private final List<SearchBaseInfo> selectedData;
    private CommonTitleBar titleBar;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreActivity$Companion;", "", "<init>", "()V", "TAG", "", "SELECTED_DATA", "KEY_REMOVE_DATA", "ENABLE_CHAT_PREVIEW", "KEY_SCENE", "KEY_USE_RESULT", "startForResult", "", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "data", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "requestCode", "", "applyParams", "Landroid/content/Intent;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Serializable, java.lang.Object[]] */
        private final Intent applyParams(Intent r2, List<? extends SearchBaseInfo> r3) {
            r2.putExtra("selected.data", r3.toArray(new SearchBaseInfo[0]));
            return r2;
        }

        public final void startForResult(Context r3, Fragment r4, List<? extends SearchBaseInfo> r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r5, "data");
            Intent r7 = applyParams(new Intent(r3, DoubaoSelectedMoreActivity.class), r5);
            if (r4 == null) goto L6;
            r4.startActivityForResult(r7, r6);
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__finish$___twin___() {
        super.finish();
    }

    public void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__onStop$___twin___() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
    }

    public void finish() {
        com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public DoubaoSelectedMoreActivity() {
        this.selectedData = new ArrayList();
        this.removedData = new ArrayList();
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ DoubaoSelectedMoreAdapter access$getAdapter$p(DoubaoSelectedMoreActivity r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ List access$getRemovedData$p(DoubaoSelectedMoreActivity r0) {
        return r0.removedData;
    }

    public static final /* synthetic */ List access$getSelectedData$p(DoubaoSelectedMoreActivity r0) {
        return r0.selectedData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DoubaoSelectedMoreActivity r1) {
        r1.com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(DoubaoSelectedMoreActivity r11) {
        r11.com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoubaoSelectedMoreActivity.class.getName()));
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

    public static void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(DoubaoSelectedMoreActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    private final void updateBottomSelectedCount(int r4) {
        Button r0 = null;
        if (r4 <= 0) goto L9;
        Button r2 = this.bottomBarBtn;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBarBtn");
    L8:
        r0.setText(UIHelper.mustacheFormat(2131892184, "select_count", String.valueOf(r4)));
        return;
    L7:
        r0 = r2;
        goto L8
    L9:
        Button r5 = this.bottomBarBtn;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBarBtn");
    L13:
        r0.setText(UIHelper.getString(2131891624));
        return;
    L12:
        r0 = r5;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(2131563315);
        this.moreList = findViewById(2131380315);
        this.bottomBarBtn = (Button) findViewById(2131385846);
        Bundle r7 = getIntent().getExtras();
        Button r0 = null;
        if (r7 == null) goto L5;
        Object r8 = r7.get("selected.data");
    L6:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Array<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        SearchBaseInfo[] r1 = (SearchBaseInfo[]) r8;
        CollectionsKt.addAll(this.selectedData, (Object[]) r8);
        CommonTitleBar r9 = findViewById(2131388807);
        r9.setImmersive(true);
        this.titleBar = r9;
        this.adapter = new DoubaoSelectedMoreAdapter(this);
        RecyclerView r10 = this.moreList;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("moreList");
        r10 = null;
    L9:
        RecyclerView.Adapter r3 = this.adapter;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r3 = null;
    L12:
        r10.setAdapter(r3);
        RecyclerView r11 = this.moreList;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("moreList");
        r11 = null;
    L15:
        r11.setLayoutManager(new LinearLayoutManager(this, 1, false));
        DoubaoSelectedMoreAdapter r12 = this.adapter;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r12 = null;
    L18:
        r12.setOnItemRemoveListener(new AnonymousClass3(this));
        DoubaoSelectedMoreAdapter r13 = this.adapter;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r13 = null;
    L21:
        r13.addAll(this.selectedData);
        Button r14 = this.bottomBarBtn;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBarBtn");
    L25:
        r0.setOnClickListener(new AnonymousClass4(this));
        updateBottomSelectedCount(this.selectedData.size());
        return;
    L24:
        r0 = r14;
        goto L25
    L5:
        r8 = null;
        goto L6
    }

    public static final /* synthetic */ void access$updateBottomSelectedCount(DoubaoSelectedMoreActivity r0, int r1) {
        r0.updateBottomSelectedCount(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(DoubaoSelectedMoreActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_ss_android_lark_picker_doubao_selectedmore_DoubaoSelectedMoreActivity__onCreate$___twin___(r2);
    }
}
