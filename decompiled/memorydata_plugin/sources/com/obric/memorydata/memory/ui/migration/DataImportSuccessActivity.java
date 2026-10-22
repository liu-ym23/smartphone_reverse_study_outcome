package com.obric.memorydata.memory.ui.migration;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.memory.databinding.ActivityDataImportSuccessBinding;
import com.obric.memorydata.memory.ui.settings.MemorySettingsActivity;
import com.obric.memorydata.memory.utils.e;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.ui.g;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0017\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0011H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0014J\b\u0010\u001b\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataImportSuccessActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityDataImportSuccessBinding;", "mainHandler", "Landroid/os/Handler;", "shouldKillProcessOnStop", "", "killProcessRunnable", "Ljava/lang/Runnable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "navigateToTargetPage", "scope", "", "(Ljava/lang/Integer;)V", "onStop", "onDestroy", "onBackPressed", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataImportSuccessActivity extends BaseActivity {
    public static final a Companion = null;
    public static final String EXTRA_EXPORT_SCOPE = "extra_export_scope";
    private static final String OAUTO_TASKS_LIST_ACTIVITY_NAME = "com.obric.autoaction.app.launcherpage.LauncherPageStarterActivity";
    private static final long PROCESS_KILL_DELAY_MS = 1000;
    private ActivityDataImportSuccessBinding binding;
    private final Runnable killProcessRunnable;
    private final Handler mainHandler;
    private final NavigationBarScheme navigationBarScheme;
    private boolean shouldKillProcessOnStop;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataImportSuccessActivity$Companion;", "", "<init>", "()V", "EXTRA_EXPORT_SCOPE", "", "PROCESS_KILL_DELAY_MS", "", "OAUTO_TASKS_LIST_ACTIVITY_NAME", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public DataImportSuccessActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.killProcessRunnable = $$Lambda$DataImportSuccessActivity$osLe3l8sXg9E81WpR9oreTDtkAM.INSTANCE;
    }

    private final void initViews() {
        Intent r0 = getIntent();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        ActivityDataImportSuccessBinding r5 = null;
        if (r1 == false) goto L15;
        final Integer r3 = Integer.valueOf(getIntent().getIntExtra(EXTRA_EXPORT_SCOPE, -1));
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() == (-1)) goto L13;
        r2 = true;
    L13:
        if (r2 == false) goto L15;
    L16:
        ActivityDataImportSuccessBinding r4 = this.binding;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L19:
        OTextView r6 = r4.tvSubtitle;
        if (r3 == null) goto L27;
        if (r3.intValue() != 1) goto L27;
        int r7 = R.string.memory_data_transfer_success_import_subtitle_memory_only;
        String r8 = "memory_data_transfer_success_import_subtitle_memory_only";
    L39:
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_STRING, r8)), CharSequence.class, "com.obric.memorydata.plugin"));
        ActivityDataImportSuccessBinding r9 = this.binding;
        if (r9 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L43:
        r5.btnAction.setOnClickListener(new $$Lambda$DataImportSuccessActivity$a_i1oBoPqoeGjC19DRULqyPP4w(this, r3));
        return;
    L42:
        r5 = r9;
    L27:
        if (r3 == null) goto L33;
        if (r3.intValue() != 2) goto L33;
        r7 = R.string.memory_data_transfer_success_import_subtitle_task_only;
        r8 = "memory_data_transfer_success_import_subtitle_task_only";
    L33:
        if (r3 != null) goto L36;
    L38:
        r7 = R.string.memory_data_transfer_success_import_subtitle;
        r8 = "memory_data_transfer_success_import_subtitle";
        goto L39
    L36:
        if (r3.intValue() != 3) goto L38;
        r7 = R.string.memory_data_transfer_success_import_subtitle_both;
        r8 = "memory_data_transfer_success_import_subtitle_both";
    L15:
        r3 = null;
        goto L16
    L5:
        if (r0.hasExtra(EXTRA_EXPORT_SCOPE) != true) goto L7;
        r1 = true;
        goto L8
    }

    private static final void initViews$lambda$2(DataImportSuccessActivity r2, Integer r3, View r4) {
        DataImportSuccessActivity r5 = (DataImportSuccessActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataImportSuccessActivity.class, "com.obric.memorydata.plugin");
        r5.shouldKillProcessOnStop = true;
        e.f11535a.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"));
        r5.navigateToTargetPage(r3);
        r5.finishAndRemoveTask();
        r5.overridePendingTransition(0, 0);
    }

    private static final void killProcessRunnable$lambda$0() {
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: renamed from: lambda$a_i1oBoPqoeGjC19D-RULqyPP4w, reason: not valid java name */
    public static /* synthetic */ void m951lambda$a_i1oBoPqoeGjC19DRULqyPP4w(DataImportSuccessActivity r0, Integer r1, View r2) {
        initViews$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$osLe3l8sXg9E81WpR9oreTDtkAM() {
        killProcessRunnable$lambda$0();
    }

    private final void navigateToTargetPage(Integer r5) {
        if (r5 == null) goto L9;
        if (r5.intValue() != 1) goto L9;
        ZeusTransformUtils.startActivity(this, new Intent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), MemorySettingsActivity.class), "com.obric.memorydata.plugin");
        return;
    L9:
        if (r5 != null) goto L12;
    L15:
        DataMigrationActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        if (r5.intValue() != 2) goto L15;
        Intent r6 = new Intent();     // Catch: Exception -> L17
        r6.setComponent(new ComponentName((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), OAUTO_TASKS_LIST_ACTIVITY_NAME));     // Catch: Exception -> L17
        r6.addFlags(268468224);     // Catch: Exception -> L17
        ZeusTransformUtils.startActivity(this, r6, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        prepareSystemBar();
        ActivityDataImportSuccessBinding r6 = ActivityDataImportSuccessBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        ActivityDataImportSuccessBinding r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityDataImportSuccessBinding r7 = this.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        OButton r8 = r0.btnAction;
        Intrinsics.checkNotNullExpressionValue(r8, "btnAction");
        g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        initViews();
        return;
    L8:
        r0 = r7;
        goto L9
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        if (this.shouldKillProcessOnStop == true) goto L5;
    L6:
        this.mainHandler.removeCallbacks(this.killProcessRunnable);
    L7:
        super.onDestroy();
        return;
    L5:
        if (isChangingConfigurations() == false) goto L7;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        if (this.shouldKillProcessOnStop == true) goto L5;
        return;
    L5:
        if (isChangingConfigurations() == true) goto L9;
        this.mainHandler.removeCallbacks(this.killProcessRunnable);
        this.mainHandler.postDelayed(this.killProcessRunnable, 1000);
        return;
    }
}
