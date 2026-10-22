package com.obric.memorydata.memory.ui.migration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.databinding.ActivityDataMigrationBinding;
import com.obric.memorydata.memory.utils.n;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.g;
import com.obric.memorydata.utils.bb;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataMigrationActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityDataMigrationBinding;", "qrScannerHelper", "Lcom/obric/memorydata/memory/utils/QrScannerHelper;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "showImportConfirmDialog", "showExportSelectionDialog", "initialSelection", "Lcom/obric/memorydata/memory/ui/migration/ExportSelection;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataMigrationActivity extends BaseActivity {
    public static final a Companion = null;
    private ActivityDataMigrationBinding binding;
    private n qrScannerHelper;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataMigrationActivity$Companion;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            ZeusTransformUtils.startActivity(r2, new Intent(r2, DataMigrationActivity.class), "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\"\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"com/obric/memorydata/memory/ui/migration/DataMigrationActivity$showExportSelectionDialog$SelectionItemBinding", "", "itemView", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "<init>", "(Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;Lcom/obric/oui/checkbox/OCheckBox;)V", "getItemView", "()Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "component1", "component2", "copy", "(Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;Lcom/obric/oui/checkbox/OCheckBox;)Lcom/obric/memorydata/memory/ui/migration/DataMigrationActivity$showExportSelectionDialog$SelectionItemBinding;", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OSelectionItemView f11347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OCheckBox f11348b;

        public b(OSelectionItemView r2, OCheckBox r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "checkBox");
            this.f11347a = r2;
            this.f11348b = r3;
        }

        public final OSelectionItemView a() {
            return this.f11347a;
        }

        public final OCheckBox b() {
            return this.f11348b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11347a, r6.f11347a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11348b, r6.f11348b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11347a.hashCode() * 31) + this.f11348b.hashCode();
        }

        public String toString() {
            return "SelectionItemBinding(itemView=" + this.f11347a + ", checkBox=" + this.f11348b + ')';
        }
    }

    static {
        Companion = new a(null);
    }

    public DataMigrationActivity() {
    }

    private final void initViews() {
        BaseActivity r2 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityDataMigrationBinding r0 = this.binding;
        ActivityDataMigrationBinding r9 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r3 = r0.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r3, "viewTitle");
        ActivityDataMigrationBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        BaseActivity.setupTitleBarBackAction$default(r2, r3, (View) ZeusTransformUtils.preCheckCast(r1.scrollContainer, View.class, "com.obric.memorydata.plugin"), 0, null, 12, null);
        ActivityDataMigrationBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        r4.btnExport.setOnContentClickListener(new $$Lambda$DataMigrationActivity$4hQJNNwxedasW3hguVxb2m4bOOY(this));
        ActivityDataMigrationBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r9.btnImport.setOnContentClickListener(new $$Lambda$DataMigrationActivity$PRcuft1YsjEUG3PmeFR_jGO7C4(this));
        return;
    L14:
        r9 = r5;
        goto L15
    }

    private static final void initViews$lambda$1(DataMigrationActivity r3, View r4) {
        ((DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataMigrationActivity.class, "com.obric.memorydata.plugin")).showExportSelectionDialog(new com.obric.memorydata.memory.ui.migration.a(false, false, 3, null));
    }

    private static final void initViews$lambda$2(DataMigrationActivity r1, View r2) {
        ((DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r1, DataMigrationActivity.class, "com.obric.memorydata.plugin")).showImportConfirmDialog();
    }

    public static /* synthetic */ void lambda$4hQJNNwxedasW3hguVxb2m4bOOY(DataMigrationActivity r0, View r1) {
        initViews$lambda$1(r0, r1);
    }

    public static /* synthetic */ View lambda$4lNMt5vN81xHhvEOnIOw7KLLL94(DataMigrationActivity r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, Ref.ObjectRef r4, ViewGroup r5) {
        return showExportSelectionDialog$lambda$14(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$7W23ToFwzRxUte1U0cuUnyHBaUQ(DataMigrationActivity r0, DialogInterface r1, int r2) {
        return showImportConfirmDialog$lambda$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$7ccsM3SPKUbiqROfWaWRM-mjxAI, reason: not valid java name */
    public static /* synthetic */ Unit m952lambda$7ccsM3SPKUbiqROfWaWRMmjxAI() {
        return showExportSelectionDialog$lambda$16();
    }

    /* JADX INFO: renamed from: lambda$CXOtDAjv6AE-5ns7yQv6VtDEAvo, reason: not valid java name */
    public static /* synthetic */ void m953lambda$CXOtDAjv6AE5ns7yQv6VtDEAvo(Function1 r0, OCheckBox r1, View r2) {
        showExportSelectionDialog$createSelectionItem$lambda$8$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$ELQIhHhOS4k2WUtbwilp4vfm4L4(Ref.ObjectRef r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3) {
        return showExportSelectionDialog$createExportSelectionBody$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$FMtgC54VM9oQYJitpHWQXaPBuec(Ref.ObjectRef r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, boolean r4) {
        return showExportSelectionDialog$createExportSelectionBody$lambda$13(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$PRcuft1YsjEUG-3PmeFR_jGO7C4, reason: not valid java name */
    public static /* synthetic */ void m954lambda$PRcuft1YsjEUG3PmeFR_jGO7C4(DataMigrationActivity r0, View r1) {
        initViews$lambda$2(r0, r1);
    }

    public static /* synthetic */ void lambda$VFcL_o3idr4q2WJNanTs_dshqx4(Function0 r0, View r1) {
        showExportSelectionDialog$createSelectionItem$lambda$8$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$WGYA0EU2jKzljhCo-Sd4o4liZXs, reason: not valid java name */
    public static /* synthetic */ Unit m955lambda$WGYA0EU2jKzljhCoSd4o4liZXs(Ref.ObjectRef r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3) {
        return showExportSelectionDialog$createExportSelectionBody$lambda$12(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$gD-RUEkjKdZVRe2W_QUoxaafYfE, reason: not valid java name */
    public static /* synthetic */ Unit m956lambda$gDRUEkjKdZVRe2W_QUoxaafYfE(DataMigrationActivity r0, Ref.ObjectRef r1) {
        return showExportSelectionDialog$lambda$15(r0, r1);
    }

    public static /* synthetic */ Unit lambda$zDNMqpXN9wfRBT_fPP0sPxp7clE(DataMigrationActivity r0, String r1) {
        return onCreate$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit lambda$zcYZ6spx_av_m9GmOUHoUS5BXo8(Ref.ObjectRef r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, boolean r4) {
        return showExportSelectionDialog$createExportSelectionBody$lambda$11(r0, r1, r2, r3, r4);
    }

    private static final Unit onCreate$lambda$0(DataMigrationActivity r3, String r4) {
        DataMigrationActivity r5 = (DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataMigrationActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "qrText");
        DataTransferActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"), r4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [T, com.obric.oui.dialog.v2.selection.a] */
    private final void showExportSelectionDialog(com.obric.memorydata.memory.ui.migration.a r32) {
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = r32;
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_export_select_scope_header, TypedValues.Custom.S_STRING, "memory_data_export_select_scope_header"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r18 = new $$Lambda$DataMigrationActivity$4lNMt5vN81xHhvEOnIOw7KLLL94(this, r9, r10, r7, r8);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_export_select_scope_export, TypedValues.Custom.S_STRING, "memory_data_export_select_scope_export"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        com.obric.oui.dialog.base.b.a r4 = new com.obric.oui.dialog.base.b.a(r1, new $$Lambda$DataMigrationActivity$gDRUEkjKdZVRe2W_QUoxaafYfE(this, r7), null, 4, null);
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_export_select_scope_cancel, TypedValues.Custom.S_STRING, "memory_data_export_select_scope_cancel"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        ?? r11 = new com.obric.oui.dialog.v2.selection.a(r13, new com.obric.oui.dialog.v2.selection.a.b(r16, r17, r18, r4, new com.obric.oui.dialog.base.b.a(r2, $$Lambda$DataMigrationActivity$7ccsM3SPKUbiqROfWaWRMmjxAI.INSTANCE, null, 4, null)));
        r11.setCanceledOnTouchOutside(true);
        r11.setCancelable(true);
        r8.element = r11;
        if (r8.element != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        com.obric.oui.dialog.v2.selection.a r3 = null;
    L6:
        r3.show();
        showExportSelectionDialog$renderSelectionState(r9, r7, r10, r8);
        return;
    L5:
        r3 = (com.obric.oui.dialog.v2.selection.a) ZeusTransformUtils.preCheckCast(r8.element, com.obric.oui.dialog.v2.selection.a.class, "com.obric.memorydata.plugin");
        goto L6
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [T, com.obric.oui.checkbox.OCheckBox] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.obric.oui.checkbox.OCheckBox] */
    private static final LinearLayout showExportSelectionDialog$createExportSelectionBody(DataMigrationActivity r9, final Ref.ObjectRef<OCheckBox> r10, final Ref.ObjectRef<OCheckBox> r11, final Ref.ObjectRef<com.obric.memorydata.memory.ui.migration.a> r12, final Ref.ObjectRef<com.obric.oui.dialog.v2.selection.a> r13) {
        DataMigrationActivity r14 = (DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r9, DataMigrationActivity.class, "com.obric.memorydata.plugin");
        LinearLayout r0 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(r14, Context.class, "com.obric.memorydata.plugin"));
        r0.setOrientation(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        String r3 = r14.getString(ZeusTransformUtils.mapRes(R.string.memory_data_export_select_scope_option_task, TypedValues.Custom.S_STRING, "memory_data_export_select_scope_option_task"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        b r4 = showExportSelectionDialog$createSelectionItem(r14, r3, true, new $$Lambda$DataMigrationActivity$ELQIhHhOS4k2WUtbwilp4vfm4L4(r12, r10, r11, r13), new $$Lambda$DataMigrationActivity$zcYZ6spx_av_m9GmOUHoUS5BXo8(r12, r10, r11, r13));
        r10.element = r4.b();
        float r7 = 2;
        bb.c((View) ZeusTransformUtils.preCheckCast(r4.a(), View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
        String r5 = r14.getString(ZeusTransformUtils.mapRes(R.string.memory_data_export_select_scope_option_memory, TypedValues.Custom.S_STRING, "memory_data_export_select_scope_option_memory"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        b r15 = showExportSelectionDialog$createSelectionItem(r14, r5, false, new $$Lambda$DataMigrationActivity$WGYA0EU2jKzljhCoSd4o4liZXs(r12, r10, r11, r13), new $$Lambda$DataMigrationActivity$FMtgC54VM9oQYJitpHWQXaPBuec(r12, r10, r11, r13));
        r11.element = r15.b();
        bb.b((View) ZeusTransformUtils.preCheckCast(r15.a(), View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
        r0.addView((View) ZeusTransformUtils.preCheckCast(r4.a(), View.class, "com.obric.memorydata.plugin"));
        r0.addView((View) ZeusTransformUtils.preCheckCast(r15.a(), View.class, "com.obric.memorydata.plugin"));
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.obric.memorydata.memory.ui.migration.a] */
    private static final Unit showExportSelectionDialog$createExportSelectionBody$lambda$10(Ref.ObjectRef r5, Ref.ObjectRef r6, Ref.ObjectRef r7, Ref.ObjectRef r8) {
        r5.element = com.obric.memorydata.memory.ui.migration.a.a((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r5.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin"), !((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r5.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin")).a(), false, 2, null);
        showExportSelectionDialog$renderSelectionState(r6, r5, r7, r8);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [T, com.obric.memorydata.memory.ui.migration.a] */
    private static final Unit showExportSelectionDialog$createExportSelectionBody$lambda$11(Ref.ObjectRef r4, Ref.ObjectRef r5, Ref.ObjectRef r6, Ref.ObjectRef r7, boolean r8) {
        r4.element = com.obric.memorydata.memory.ui.migration.a.a((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r4.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin"), r8, false, 2, null);
        showExportSelectionDialog$renderSelectionState(r5, r4, r6, r7);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.obric.memorydata.memory.ui.migration.a] */
    private static final Unit showExportSelectionDialog$createExportSelectionBody$lambda$12(Ref.ObjectRef r5, Ref.ObjectRef r6, Ref.ObjectRef r7, Ref.ObjectRef r8) {
        r5.element = com.obric.memorydata.memory.ui.migration.a.a((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r5.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin"), false, !((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r5.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin")).b(), 1, null);
        showExportSelectionDialog$renderSelectionState(r6, r5, r7, r8);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [T, com.obric.memorydata.memory.ui.migration.a] */
    private static final Unit showExportSelectionDialog$createExportSelectionBody$lambda$13(Ref.ObjectRef r4, Ref.ObjectRef r5, Ref.ObjectRef r6, Ref.ObjectRef r7, boolean r8) {
        r4.element = com.obric.memorydata.memory.ui.migration.a.a((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r4.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin"), false, r8, 1, null);
        showExportSelectionDialog$renderSelectionState(r5, r4, r6, r7);
        return Unit.INSTANCE;
    }

    private static final b showExportSelectionDialog$createSelectionItem(DataMigrationActivity r7, String r8, boolean r9, Function0<Unit> r10, Function1<? super Boolean, Unit> r11) {
        DataMigrationActivity r12 = (DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r7, DataMigrationActivity.class, "com.obric.memorydata.plugin");
        final Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        final Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        final OCheckBox r0 = new OCheckBox((Context) ZeusTransformUtils.preCheckCast(r12, Context.class, "com.obric.memorydata.plugin"));
        FrameLayout r2 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(r12, Context.class, "com.obric.memorydata.plugin"));
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        r2.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        OSelectionItemView r4 = new OSelectionItemView((Context) ZeusTransformUtils.preCheckCast(r12, Context.class, "com.obric.memorydata.plugin"), null, 2, null);
        r4.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
        r4.a(r9);
        r4.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), new ViewGroup.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())), -2));
        r4.setOnClickListener(new $$Lambda$DataMigrationActivity$VFcL_o3idr4q2WJNanTs_dshqx4(r13));
        r0.setOnClickListener(new $$Lambda$DataMigrationActivity$CXOtDAjv6AE5ns7yQv6VtDEAvo(r14, r0));
        return new b(r4, r0);
    }

    private static final void showExportSelectionDialog$createSelectionItem$lambda$8$lambda$6(Function0 r1, View r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final void showExportSelectionDialog$createSelectionItem$lambda$8$lambda$7(Function1 r1, OCheckBox r2, View r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r1, Function1.class, "com.obric.memorydata.plugin")).invoke(Boolean.valueOf(r2.isChecked()));
    }

    private static final View showExportSelectionDialog$lambda$14(DataMigrationActivity r2, Ref.ObjectRef r3, Ref.ObjectRef r4, Ref.ObjectRef r5, Ref.ObjectRef r6, ViewGroup r7) {
        DataMigrationActivity r8 = (DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataMigrationActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "it");
        return (View) ZeusTransformUtils.preCheckCast(showExportSelectionDialog$createExportSelectionBody(r8, r3, r4, r5, r6), View.class, "com.obric.memorydata.plugin");
    }

    private static final Unit showExportSelectionDialog$lambda$15(DataMigrationActivity r3, Ref.ObjectRef r4) {
        DataMigrationActivity r5 = (DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataMigrationActivity.class, "com.obric.memorydata.plugin");
        DataTransferActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r4.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit showExportSelectionDialog$lambda$16() {
        return Unit.INSTANCE;
    }

    private static final void showExportSelectionDialog$renderSelectionState(Ref.ObjectRef<OCheckBox> r4, Ref.ObjectRef<com.obric.memorydata.memory.ui.migration.a> r5, Ref.ObjectRef<OCheckBox> r6, Ref.ObjectRef<com.obric.oui.dialog.v2.selection.a> r7) {
        OCheckBox r1 = null;
        if (r4.element != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("taskCheckBox");
        OCheckBox r8 = null;
    L6:
        r8.setChecked(((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r5.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin")).a());
        if (r6.element != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCheckBox");
    L10:
        r1.setChecked(((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r5.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin")).b());
        showExportSelectionDialog$updatePositiveButtonState(r7, r5);
        return;
    L9:
        r1 = (OCheckBox) ZeusTransformUtils.preCheckCast(r6.element, OCheckBox.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r8 = (OCheckBox) ZeusTransformUtils.preCheckCast(r4.element, OCheckBox.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private static final void showExportSelectionDialog$updatePositiveButtonState(Ref.ObjectRef<com.obric.oui.dialog.v2.selection.a> r2, Ref.ObjectRef<com.obric.memorydata.memory.ui.migration.a> r3) {
        if (r2.element != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        com.obric.oui.dialog.v2.selection.a r4 = null;
    L6:
        r4.u().setEnabled(((com.obric.memorydata.memory.ui.migration.a) ZeusTransformUtils.preCheckCast(r3.element, com.obric.memorydata.memory.ui.migration.a.class, "com.obric.memorydata.plugin")).c());
        return;
    L5:
        r4 = (com.obric.oui.dialog.v2.selection.a) ZeusTransformUtils.preCheckCast(r2.element, com.obric.oui.dialog.v2.selection.a.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private final void showImportConfirmDialog() {
        com.obric.oui.dialog.v2.alert.b r0 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_data_import_confirm_title, TypedValues.Custom.S_STRING, "memory_data_import_confirm_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_data_import_confirm_message, TypedValues.Custom.S_STRING, "memory_data_import_confirm_message")), CharSequence.class, "com.obric.memorydata.plugin")).a(true);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_import_confirm_positive_btn, TypedValues.Custom.S_STRING, "memory_data_import_confirm_positive_btn"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r6 = r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$DataMigrationActivity$7W23ToFwzRxUte1U0cuUnyHBaUQ(this));
        String r12 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_import_confirm_negative_btn, TypedValues.Custom.S_STRING, "memory_data_import_confirm_negative_btn"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        com.obric.oui.dialog.v2.alert.b.b(r6, (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 4, null).h();
    }

    private static final Unit showImportConfirmDialog$lambda$3(DataMigrationActivity r1, DialogInterface r2, int r3) {
        DataMigrationActivity r4 = (DataMigrationActivity) ZeusTransformUtils.wrapperContextForParams(r1, DataMigrationActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin"), "<unused var>");
        n r5 = r4.qrScannerHelper;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("qrScannerHelper");
        r5 = null;
    L5:
        r5.a();
        return Unit.INSTANCE;
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.qrScannerHelper = new n((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.memorydata.plugin"), new $$Lambda$DataMigrationActivity$zDNMqpXN9wfRBT_fPP0sPxp7clE(this));
        prepareSystemBar();
        ActivityDataMigrationBinding r6 = ActivityDataMigrationBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityDataMigrationBinding r7 = this.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        ONestedScrollView r8 = r7.scrollContainer;
        Intrinsics.checkNotNullExpressionValue(r8, "scrollContainer");
        g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        initViews();
    }
}
