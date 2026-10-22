package com.obric.memorydata.datatransport.transfer.buildmemory;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.google.android.material.timepicker.TimeModel;
import com.obric.memorydata.datatransport.api.MemoryBuildExportRequest;
import com.obric.memorydata.datatransport.api.MemoryBuildExportTimeRange;
import com.obric.memorydata.datatransport.api.d;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.z;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.g;
import com.obric.oui.button.OButton;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020\u0019H\u0014J\b\u0010%\u001a\u00020\u0019H\u0014J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020'H\u0016J\b\u0010+\u001a\u00020'H\u0014J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u000203H\u0002J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u0019H\u0002J\b\u00109\u001a\u00020'H\u0002J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\b\u0010<\u001a\u00020'H\u0002J\n\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0018\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020A2\u0006\u00108\u001a\u00020\u0019H\u0002J\u0010\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020!H\u0002J\u0010\u0010D\u001a\u0002032\u0006\u0010C\u001a\u00020!H\u0002J\b\u0010E\u001a\u00020'H\u0002J\u0018\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u0002032\u0006\u0010H\u001a\u000203H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0012\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"¨\u0006J"}, d2 = {"Lcom/obric/memorydata/datatransport/transfer/buildmemory/MemoryBuildDataPackageActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "viewTitle", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "btnExport", "Lcom/obric/oui/button/OButton;", "btnImportLatest", "btnShare", "btnCopyPath", "btnSelectStartTime", "btnSelectEndTime", "btnClearTimeRange", "switchOnlyRawObservation", "Lcom/obric/oui/oswitch/OSwitch;", "tvStatus", "Landroid/widget/TextView;", "tvLatestPackageSummary", "tvTimeRangeSummary", "tvExportScopeSummary", "tvLog", "scrollViewLog", "Landroid/widget/ScrollView;", "running", "", "latestFile", "Ljava/io/File;", "latestPreviewFile", "logs", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "selectedStartTimeMs", "", "Ljava/lang/Long;", "selectedEndTimeMs", "needLoginCheckOnCreate", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onDestroy", "exportPackage", "importLatestPackage", "migrationCallback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "setRunning", EventBody.KEY_VALUE, "status", "", "refreshFileButtons", "appendLog", "message", "selectDateTime", "isStart", "clearTimeRange", "refreshTimeRangeSummary", "refreshExportScopeSummary", "refreshLatestPackageInfo", "buildExportRequestOrToast", "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "showTimePickerWithSeconds", "calendar", "Ljava/util/Calendar;", "formatDateTime", "timeMs", "formatButtonDateTime", "shareLatestFiles", "copyToClipboard", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "toast", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildDataPackageActivity extends BaseActivity {
    public static final a Companion = null;
    private OButton btnClearTimeRange;
    private OButton btnCopyPath;
    private OButton btnExport;
    private OButton btnImportLatest;
    private OButton btnSelectEndTime;
    private OButton btnSelectStartTime;
    private OButton btnShare;
    private File latestFile;
    private File latestPreviewFile;
    private final StringBuilder logs;
    private boolean running;
    private ScrollView scrollViewLog;
    private Long selectedEndTimeMs;
    private Long selectedStartTimeMs;
    private OSwitch switchOnlyRawObservation;
    private TextView tvExportScopeSummary;
    private TextView tvLatestPackageSummary;
    private TextView tvLog;
    private TextView tvStatus;
    private TextView tvTimeRangeSummary;
    private OFloatingTitleBar viewTitle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/datatransport/transfer/buildmemory/MemoryBuildDataPackageActivity$Companion;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            ZeusTransformUtils.startActivity(r2, new Intent(r2, MemoryBuildDataPackageActivity.class), "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.transfer.buildmemory.MemoryBuildDataPackageActivity$exportPackage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.transfer.buildmemory.MemoryBuildDataPackageActivity$exportPackage$2", f = "MemoryBuildDataPackageActivity.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ MemoryBuildExportRequest $exportRequest;
        int label;
        final /* synthetic */ MemoryBuildDataPackageActivity this$0;

        AnonymousClass2(MemoryBuildDataPackageActivity r3, MemoryBuildExportRequest r4, Continuation<? super AnonymousClass2> r5) {
            MemoryBuildDataPackageActivity r6 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$exportRequest = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$exportRequest, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            TextView r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            z r13 = (z) ZeusTransformUtils.preCheckCast(r12, z.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, z.b.class) == false) goto L25;
            MemoryBuildDataPackageActivity.access$setLatestFile$p(this.this$0, (File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r13, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin"));
            MemoryBuildDataPackageActivity r3 = this.this$0;
            File r8 = b.f9812a.a((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r13, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin"));
            if (r8.isFile() == true) goto L17;
            r8 = null;
        L17:
            MemoryBuildDataPackageActivity.access$setLatestPreviewFile$p(r3, r8);
            MemoryBuildDataPackageActivity r4 = this.this$0;
            String r14 = r4.getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_export_done_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_export_done_log"), new Object[]{((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r13, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath()});
            Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
            MemoryBuildDataPackageActivity.access$appendLog(r4, r14);
            File r15 = MemoryBuildDataPackageActivity.access$getLatestPreviewFile$p(this.this$0);
            if (r15 == null) goto L20;
            MemoryBuildDataPackageActivity r5 = this.this$0;
            String r16 = r5.getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_preview_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_preview_log"), new Object[]{r15.getAbsolutePath()});
            Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
            MemoryBuildDataPackageActivity.access$appendLog(r5, r16);
        L20:
            TextView r17 = MemoryBuildDataPackageActivity.access$getTvStatus$p(this.this$0);
            if (r17 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
            r17 = null;
        L23:
            MemoryBuildDataPackageActivity r6 = this.this$0;
            int r7 = R.string.data_transport_memory_build_package_export_done;
            String r9 = "data_transport_memory_build_package_export_done";
        L30:
            r17.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_STRING, r9)), CharSequence.class, "com.obric.memorydata.plugin"));
            MemoryBuildDataPackageActivity r18 = this.this$0;
            TextView r10 = MemoryBuildDataPackageActivity.access$getTvStatus$p(r18);
            if (r10 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
        L34:
            MemoryBuildDataPackageActivity.access$setRunning(r18, false, r2.getText().toString());
            MemoryBuildDataPackageActivity.access$refreshLatestPackageInfo(this.this$0);
            return Unit.INSTANCE;
        L33:
            r2 = r10;
            goto L34
        L25:
            if (ZeusTransformUtils.instanceOf(r13, z.a.class) == false) goto L37;
            MemoryBuildDataPackageActivity r11 = this.this$0;
            String r19 = r11.getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_export_failed_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_export_failed_log"), new Object[]{((z.a) ZeusTransformUtils.preCheckCast(r13, z.a.class, "com.obric.memorydata.plugin")).a().b()});
            Intrinsics.checkNotNullExpressionValue(r19, "getString(...)");
            MemoryBuildDataPackageActivity.access$appendLog(r11, r19);
            r17 = MemoryBuildDataPackageActivity.access$getTvStatus$p(this.this$0);
            if (r17 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
            r17 = null;
        L29:
            r6 = this.this$0;
            r7 = R.string.data_transport_memory_build_package_export_failed;
            r9 = "data_transport_memory_build_package_export_failed";
            goto L30
        L37:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            CoroutineContext r110 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r20 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryBuildDataPackageActivity$exportPackage$2$result$1(this.$exportRequest, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r12 = i.a(r110, r20, r21);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.transfer.buildmemory.MemoryBuildDataPackageActivity$importLatestPackage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.transfer.buildmemory.MemoryBuildDataPackageActivity$importLatestPackage$1", f = "MemoryBuildDataPackageActivity.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        int label;
        final /* synthetic */ MemoryBuildDataPackageActivity this$0;

        AnonymousClass1(MemoryBuildDataPackageActivity r3, File r4, Continuation<? super AnonymousClass1> r5) {
            MemoryBuildDataPackageActivity r6 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$file = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$file, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            TextView r3 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L11:
            z r12 = (z) ZeusTransformUtils.preCheckCast(r11, z.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, z.b.class) == false) goto L19;
            MemoryBuildDataPackageActivity r13 = this.this$0;
            String r2 = r13.getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_import_done_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_import_done_log"));
            Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
            MemoryBuildDataPackageActivity.access$appendLog(r13, r2);
            TextView r14 = MemoryBuildDataPackageActivity.access$getTvStatus$p(this.this$0);
            if (r14 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
            r14 = null;
        L16:
            MemoryBuildDataPackageActivity r4 = this.this$0;
            int r5 = R.string.data_transport_memory_build_package_import_done;
            String r6 = "data_transport_memory_build_package_import_done";
        L17:
            r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r6)), CharSequence.class, "com.obric.memorydata.plugin"));
            MemoryBuildDataPackageActivity r15 = this.this$0;
            TextView r7 = MemoryBuildDataPackageActivity.access$getTvStatus$p(r15);
            if (r7 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
        L28:
            MemoryBuildDataPackageActivity.access$setRunning(r15, false, r3.getText().toString());
            MemoryBuildDataPackageActivity.access$refreshLatestPackageInfo(this.this$0);
            return Unit.INSTANCE;
        L27:
            r3 = r7;
            goto L28
        L19:
            if (ZeusTransformUtils.instanceOf(r12, z.a.class) == false) goto L31;
            MemoryBuildDataPackageActivity r8 = this.this$0;
            String r16 = r8.getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_import_failed_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_import_failed_log"), new Object[]{((z.a) ZeusTransformUtils.preCheckCast(r12, z.a.class, "com.obric.memorydata.plugin")).a().b()});
            Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
            MemoryBuildDataPackageActivity.access$appendLog(r8, r16);
            r14 = MemoryBuildDataPackageActivity.access$getTvStatus$p(this.this$0);
            if (r14 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
            r14 = null;
        L23:
            r4 = this.this$0;
            r5 = R.string.data_transport_memory_build_package_import_failed;
            r6 = "data_transport_memory_build_package_import_failed";
            goto L17
        L31:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            CoroutineContext r17 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r9 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryBuildDataPackageActivity$importLatestPackage$1$result$1(this.$file, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r11 = i.a(r17, r9, r10);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryBuildDataPackageActivity() {
        this.logs = new StringBuilder();
    }

    public static final /* synthetic */ void access$appendLog(MemoryBuildDataPackageActivity r2, String r3) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).appendLog(r3);
    }

    public static final /* synthetic */ File access$getLatestPreviewFile$p(MemoryBuildDataPackageActivity r2) {
        return ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).latestPreviewFile;
    }

    public static final /* synthetic */ TextView access$getTvStatus$p(MemoryBuildDataPackageActivity r2) {
        return ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).tvStatus;
    }

    public static final /* synthetic */ m access$migrationCallback(MemoryBuildDataPackageActivity r2) {
        return ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).migrationCallback();
    }

    public static final /* synthetic */ void access$refreshLatestPackageInfo(MemoryBuildDataPackageActivity r2) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).refreshLatestPackageInfo();
    }

    public static final /* synthetic */ void access$setLatestFile$p(MemoryBuildDataPackageActivity r2, File r3) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).latestFile = r3;
    }

    public static final /* synthetic */ void access$setLatestPreviewFile$p(MemoryBuildDataPackageActivity r2, File r3) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).latestPreviewFile = r3;
    }

    public static final /* synthetic */ void access$setRunning(MemoryBuildDataPackageActivity r2, boolean r3, String r4) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).setRunning(r3, r4);
    }

    private final void appendLog(String r5) {
        this.logs.append('[' + new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()) + "] ").append(r5).append('\n');
        TextView r6 = this.tvLog;
        ScrollView r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvLog");
        r6 = null;
    L5:
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.logs.toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        ScrollView r7 = this.scrollViewLog;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("scrollViewLog");
    L9:
        r0.post(new $$Lambda$MemoryBuildDataPackageActivity$HPQfHbH25CBNl9arBBqstmEa9s(this));
        return;
    L8:
        r0 = r7;
        goto L9
    }

    private static final void appendLog$lambda$13(MemoryBuildDataPackageActivity r2) {
        ScrollView r3 = ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).scrollViewLog;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scrollViewLog");
        r3 = null;
    L5:
        r3.fullScroll(130);
    }

    private final MemoryBuildExportRequest buildExportRequestOrToast() {
        Long r0 = this.selectedStartTimeMs;
        Long r1 = this.selectedEndTimeMs;
        boolean r2 = true;
        if (r0 != null) goto L5;
        boolean r4 = true;
    L6:
        if (r1 == null) goto L9;
        r2 = false;
    L9:
        OSwitch r6 = null;
        if (r4 == r2) goto L15;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        int r5 = R.string.data_transport_memory_build_package_time_range_required;
        String r7 = "data_transport_memory_build_package_time_range_required";
    L12:
        Toast.makeText(r3, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r7)), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        return null;
    L15:
        if (r0 == null) goto L26;
        if (r1 == null) goto L26;
        if (r0.longValue() <= r1.longValue()) goto L20;
        r3 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        r5 = R.string.data_transport_memory_build_package_start_after_end;
        r7 = "data_transport_memory_build_package_start_after_end";
        goto L12
    L20:
        OSwitch r13 = this.switchOnlyRawObservation;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("switchOnlyRawObservation");
    L25:
        return new MemoryBuildExportRequest(new MemoryBuildExportTimeRange(r0.longValue(), r1.longValue()), r6.isChecked(), null, 4, null);
    L23:
        r6 = r13;
    L26:
        OSwitch r14 = this.switchOnlyRawObservation;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("switchOnlyRawObservation");
    L31:
        return new MemoryBuildExportRequest(null, r6.isChecked(), null, 5, null);
    L29:
        r6 = r14;
        goto L31
    L5:
        r4 = false;
        goto L6
    }

    private final void clearTimeRange() {
        this.selectedStartTimeMs = null;
        this.selectedEndTimeMs = null;
        refreshTimeRangeSummary();
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_time_filter_cleared_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_time_filter_cleared_log"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        appendLog(r0);
    }

    private final void copyToClipboard(String r5, String r6) {
        Object r0 = getSystemService("clipboard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) ZeusTransformUtils.preCheckCast(r0, ClipboardManager.class, "com.obric.memorydata.plugin")).setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast("memory_build_migration_package", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")));
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
    }

    private final void exportPackage() {
        if (this.running == false) goto L5;
        return;
    L5:
        MemoryBuildExportRequest r0 = buildExportRequestOrToast();
        if (r0 != null) goto L8;
        return;
    L8:
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_exporting, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_exporting"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        setRunning(true, r1);
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_start_export_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_start_export_log"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        appendLog(r2);
        if (r0.getOnlyRawObservation() == false) goto L11;
        int r3 = R.string.data_transport_memory_build_package_export_scope_only_log;
        String r5 = "data_transport_memory_build_package_export_scope_only_log";
    L12:
        String r4 = getString(ZeusTransformUtils.mapRes(r3, TypedValues.Custom.S_STRING, r5));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        appendLog(r4);
        MemoryBuildExportTimeRange r6 = r0.getTimeRange();
        if (r6 == null) goto L15;
        String r7 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_export_time_range_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_export_time_range_log"), new Object[]{formatDateTime(r6.getStartTimeMs()), formatDateTime(r6.getEndTimeMs())});
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        appendLog(r7);
    L15:
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L11:
        r3 = R.string.data_transport_memory_build_package_export_scope_all_log;
        r5 = "data_transport_memory_build_package_export_scope_all_log";
        goto L12
    }

    private final String formatButtonDateTime(long r3) {
        String r2 = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINA).format(new Date(r3));
        Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
        return r2;
    }

    private final String formatDateTime(long r3) {
        String r2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(r3));
        Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
        return r2;
    }

    private final void importLatestPackage() {
        if (this.running == false) goto L5;
        return;
    L5:
        refreshLatestPackageInfo();
        File r0 = this.latestFile;
        if (r0 != null) goto L9;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_not_found_toast, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_not_found_toast")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        return;
    L9:
        String r4 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_importing, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_importing"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        setRunning(true, r4);
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_start_import_latest_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_start_import_latest_log"), new Object[]{r0.getName()});
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        appendLog(r5);
        String r6 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_import_file_modified_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_import_file_modified_log"), new Object[]{formatDateTime(r0.lastModified())});
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        appendLog(r6);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_import_file_path_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_import_file_path_log"), new Object[]{r0.getAbsolutePath()});
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        appendLog(r1);
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static /* synthetic */ void lambda$5cwr2jCvkSTZToGaAMh3xdJurzI(MemoryBuildDataPackageActivity r0, CompoundButton r1, boolean r2) {
        onCreateChecked$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$6DEnfgsj_e68Xs8qHaq7FfMlTPY(int r0) {
        return showTimePickerWithSeconds$createPicker$lambda$26$lambda$25(r0);
    }

    public static /* synthetic */ void lambda$AJ93_1bZwOGFfwASH8ldXp24Md4(MemoryBuildDataPackageActivity r0, View r1) {
        onCreateChecked$lambda$7(r0, r1);
    }

    public static /* synthetic */ void lambda$D_kwJyoGnmeJBMiWIsLlPmpxmes(MemoryBuildDataPackageActivity r0, View r1) {
        onCreateChecked$lambda$6(r0, r1);
    }

    public static /* synthetic */ void lambda$FGGNNSUalxVgbStDx7aOUSMUuns(MemoryBuildDataPackageActivity r0, boolean r1, Calendar r2, DatePicker r3, int r4, int r5, int r6) {
        selectDateTime$lambda$18(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: lambda$HPQfHbH25CB-Nl9arBBqstmEa9s, reason: not valid java name */
    public static /* synthetic */ void m641lambda$HPQfHbH25CBNl9arBBqstmEa9s(MemoryBuildDataPackageActivity r0) {
        appendLog$lambda$13(r0);
    }

    public static /* synthetic */ void lambda$PKhB3gXuFM599nobZD1XPQAw7RE(MemoryBuildDataPackageActivity r0, p r1) {
        migrationCallback$lambda$12(r0, r1);
    }

    public static /* synthetic */ void lambda$PUpNSfEc31x_l0r_99yYFq6zZgg(MemoryBuildDataPackageActivity r0, View r1) {
        onCreateChecked$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$VD_6-KzqmUntNoU3E5YHCes1ITk, reason: not valid java name */
    public static /* synthetic */ void m642lambda$VD_6KzqmUntNoU3E5YHCes1ITk(MemoryBuildDataPackageActivity r0, View r1) {
        onCreateChecked$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ZZMkeupkfE2XlyyfdnVJx5f-dMM, reason: not valid java name */
    public static /* synthetic */ void m643lambda$ZZMkeupkfE2XlyyfdnVJx5fdMM(MemoryBuildDataPackageActivity r0, View r1) {
        onCreateChecked$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$m1XA2JZN0J5dAc-8b9ToAMr88SU, reason: not valid java name */
    public static /* synthetic */ void m644lambda$m1XA2JZN0J5dAc8b9ToAMr88SU(MemoryBuildDataPackageActivity r0, View r1) {
        onCreateChecked$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tlbkWDmbQkM81h2PRiW1-tR7IPw, reason: not valid java name */
    public static /* synthetic */ void m645lambda$tlbkWDmbQkM81h2PRiW1tR7IPw(Calendar r0, NumberPicker r1, NumberPicker r2, NumberPicker r3, boolean r4, MemoryBuildDataPackageActivity r5, DialogInterface r6, int r7) {
        showTimePickerWithSeconds$lambda$31(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void lambda$uCJ7Z2sGfeyEq1bLaFkbEm7cyo4(MemoryBuildDataPackageActivity r0, View r1) {
        onCreateChecked$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$vfW7oI4relymdc-zNOaF1iisxGw, reason: not valid java name */
    public static /* synthetic */ void m646lambda$vfW7oI4relymdczNOaF1iisxGw(p r0, MemoryBuildDataPackageActivity r1) {
        migrationCallback$lambda$12$lambda$11(r0, r1);
    }

    private final m migrationCallback() {
        return new $$Lambda$MemoryBuildDataPackageActivity$PKhB3gXuFM599nobZD1XPQAw7RE(this);
    }

    private static final void migrationCallback$lambda$12(MemoryBuildDataPackageActivity r2, final p r3) {
        final MemoryBuildDataPackageActivity r4 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        r4.runOnUiThread(new $$Lambda$MemoryBuildDataPackageActivity$vfW7oI4relymdczNOaF1iisxGw(r3, r4));
    }

    private static final void migrationCallback$lambda$12$lambda$11(p r5, MemoryBuildDataPackageActivity r6) {
        MemoryBuildDataPackageActivity r7 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r6, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, p.e.class) == false) goto L10;
        StringBuilder r0 = new StringBuilder().append(((p.e) ZeusTransformUtils.preCheckCast(r5, p.e.class, "com.obric.memorydata.plugin")).a()).append(": ");
        String r8 = ((p.e) ZeusTransformUtils.preCheckCast(r5, p.e.class, "com.obric.memorydata.plugin")).b();
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        String r9 = r0.append(r8).toString();
    L8:
        r7.appendLog(r9);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, p.c.class) == false) goto L16;
        TextView r10 = r7.tvStatus;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
        r10 = null;
    L14:
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(((p.c) ZeusTransformUtils.preCheckCast(r5, p.c.class, "com.obric.memorydata.plugin")).a() + ": " + ((p.c) ZeusTransformUtils.preCheckCast(r5, p.c.class, "com.obric.memorydata.plugin")).d() + '%', CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r5, p.b.class) == false) goto L19;
        r9 = r7.getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_migration_error_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_migration_error_log"), new Object[]{((p.b) ZeusTransformUtils.preCheckCast(r5, p.b.class, "com.obric.memorydata.plugin")).a(), ((p.b) ZeusTransformUtils.preCheckCast(r5, p.b.class, "com.obric.memorydata.plugin")).b().b()});
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        goto L8
    L19:
        if (ZeusTransformUtils.instanceOf(r5, p.a.class) == false) goto L22;
        r0 = new StringBuilder().append(((p.a) ZeusTransformUtils.preCheckCast(r5, p.a.class, "com.obric.memorydata.plugin")).a()).append(": ");
        r8 = ((p.a) ZeusTransformUtils.preCheckCast(r5, p.a.class, "com.obric.memorydata.plugin")).b();
        goto L7
    L22:
        if (ZeusTransformUtils.instanceOf(r5, p.d.class) == false) goto L25;
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    }

    private static final void onCreateChecked$lambda$0(MemoryBuildDataPackageActivity r1, View r2) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).exportPackage();
    }

    private static final void onCreateChecked$lambda$1(MemoryBuildDataPackageActivity r1, View r2) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).importLatestPackage();
    }

    private static final void onCreateChecked$lambda$2(MemoryBuildDataPackageActivity r1, View r2) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).shareLatestFiles();
    }

    private static final void onCreateChecked$lambda$4(MemoryBuildDataPackageActivity r3, View r4) {
        MemoryBuildDataPackageActivity r5 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
        File r6 = r5.latestFile;
        if (r6 == null) goto L6;
        String r7 = r6.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r7, "getAbsolutePath(...)");
        String r0 = r5.getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_path_copied, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_path_copied"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        r5.copyToClipboard(r7, r0);
        return;
    }

    private static final void onCreateChecked$lambda$5(MemoryBuildDataPackageActivity r1, View r2) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).selectDateTime(true);
    }

    private static final void onCreateChecked$lambda$6(MemoryBuildDataPackageActivity r1, View r2) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).selectDateTime(false);
    }

    private static final void onCreateChecked$lambda$7(MemoryBuildDataPackageActivity r1, View r2) {
        ((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin")).clearTimeRange();
    }

    private static final void onCreateChecked$lambda$8(MemoryBuildDataPackageActivity r1, CompoundButton r2, boolean r3) {
        MemoryBuildDataPackageActivity r4 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
        r4.refreshExportScopeSummary();
        if (r3 == false) goto L5;
        int r5 = R.string.data_transport_memory_build_package_scope_enabled_log;
        String r0 = "data_transport_memory_build_package_scope_enabled_log";
    L6:
        String r6 = r4.getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r0));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        r4.appendLog(r6);
        return;
    L5:
        r5 = R.string.data_transport_memory_build_package_scope_disabled_log;
        r0 = "data_transport_memory_build_package_scope_disabled_log";
        goto L6
    }

    private final void refreshExportScopeSummary() {
        TextView r0 = this.tvExportScopeSummary;
        OSwitch r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvExportScopeSummary");
        r0 = null;
    L5:
        OSwitch r2 = this.switchOnlyRawObservation;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("switchOnlyRawObservation");
    L10:
        if (r1.isChecked() == false) goto L12;
        int r3 = R.string.data_transport_memory_build_package_export_scope_on;
        String r4 = "data_transport_memory_build_package_export_scope_on";
    L13:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r3, TypedValues.Custom.S_STRING, r4)), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        r3 = R.string.data_transport_memory_build_package_export_scope_off;
        r4 = "data_transport_memory_build_package_export_scope_off";
        goto L13
    L8:
        r1 = r2;
        goto L10
    }

    private final void refreshFileButtons() {
        File r0 = this.latestFile;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        OButton r3 = this.btnImportLatest;
        OButton r4 = null;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("btnImportLatest");
        r3 = null;
    L12:
        if (this.running == true) goto L15;
        if (r2 == false) goto L15;
        boolean r5 = true;
    L16:
        r3.setEnabled(r5);
        OButton r6 = this.btnShare;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
        r6 = null;
    L20:
        if (this.running == true) goto L23;
        if (r2 == false) goto L23;
        boolean r7 = true;
    L24:
        r6.setEnabled(r7);
        OButton r8 = this.btnCopyPath;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("btnCopyPath");
    L29:
        if (this.running == true) goto L32;
        if (r2 == false) goto L32;
    L33:
        r4.setEnabled(r1);
        return;
    L32:
        r1 = false;
        goto L33
    L27:
        r4 = r8;
    L23:
        r7 = false;
    L15:
        r5 = false;
        goto L16
    L5:
        if (r0.isFile() != true) goto L7;
        r2 = true;
        goto L8
    }

    private final void refreshLatestPackageInfo() {
        File r0 = b.f9812a.a();
        this.latestFile = r0;
        TextView r1 = null;
        if (r0 == null) goto L7;
        File r2 = b.f9812a.a(r0);
        if (r2.isFile() == false) goto L7;
    L8:
        this.latestPreviewFile = r2;
        TextView r3 = this.tvLatestPackageSummary;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tvLatestPackageSummary");
    L12:
        File r4 = this.latestFile;
        if (r4 == null) goto L22;
        File r7 = this.latestPreviewFile;
        if (r7 == null) goto L18;
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_preview_summary, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_preview_summary"), new Object[]{r7.getName(), r7.getAbsolutePath()});
        if (r8 == null) goto L18;
    L19:
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_latest_summary, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_latest_summary"), new Object[]{r4.getName(), formatDateTime(r4.lastModified()), r4.getAbsolutePath(), r8});
        if (r5 == null) goto L22;
    L23:
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        refreshFileButtons();
        return;
    L18:
        r8 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_preview_missing, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_preview_missing"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
    L22:
        r5 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_latest_empty_summary, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_latest_empty_summary"), new Object[]{d.f9726a.c().getAbsolutePath()});
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        goto L23
    L11:
        r1 = r3;
    L7:
        r2 = null;
        goto L8
    }

    private final void refreshTimeRangeSummary() {
        OButton r0 = this.btnSelectStartTime;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnSelectStartTime");
        r0 = null;
    L5:
        Long r2 = this.selectedStartTimeMs;
        if (r2 == null) goto L10;
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_start_time_button, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_start_time_button"), new Object[]{formatButtonDateTime(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue())});
        if (r3 == null) goto L10;
    L11:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r4 = this.btnSelectEndTime;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("btnSelectEndTime");
        r4 = null;
    L14:
        Long r5 = this.selectedEndTimeMs;
        if (r5 == null) goto L19;
        String r6 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_end_time_button, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_end_time_button"), new Object[]{formatButtonDateTime(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue())});
        if (r6 == null) goto L19;
    L20:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r7 = this.tvTimeRangeSummary;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("tvTimeRangeSummary");
    L24:
        Long r8 = this.selectedStartTimeMs;
        if (r8 != null) goto L27;
    L29:
        if (r8 == null) goto L33;
        int r9 = ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_start_selected_continue_end, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_start_selected_continue_end");
        Long r10 = this.selectedStartTimeMs;
        Intrinsics.checkNotNull(r10);
        String r11 = getString(r9, new Object[]{formatDateTime(r10.longValue())});
    L36:
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L33:
        if (this.selectedEndTimeMs == null) goto L35;
        int r12 = ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_end_selected_continue_start, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_end_selected_continue_start");
        Long r13 = this.selectedEndTimeMs;
        Intrinsics.checkNotNull(r13);
        r11 = getString(r12, new Object[]{formatDateTime(r13.longValue())});
        goto L36
    L35:
        r11 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_time_filter_empty, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_time_filter_empty"));
        goto L36
    L27:
        if (this.selectedEndTimeMs == null) goto L29;
        int r14 = ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_current_filter, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_current_filter");
        Long r15 = this.selectedStartTimeMs;
        Intrinsics.checkNotNull(r15);
        Long r16 = this.selectedEndTimeMs;
        Intrinsics.checkNotNull(r16);
        r11 = getString(r14, new Object[]{formatDateTime(r15.longValue()), formatDateTime(r16.longValue())});
        goto L36
    L23:
        r1 = r7;
    L19:
        r6 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_select_end_time_with_time, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_select_end_time_with_time"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
    L10:
        r3 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_select_start_time_with_time, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_select_start_time_with_time"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        goto L11
    }

    private final void selectDateTime(final boolean r13) {
        if (r13 == false) goto L4;
        Long r0 = this.selectedStartTimeMs;
    L5:
        final Calendar r1 = Calendar.getInstance();
        if (r0 != null) goto L8;
    L16:
        DatePickerDialog r2 = new DatePickerDialog((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryBuildDataPackageActivity$FGGNNSUalxVgbStDx7aOUSMUuns(this, r13, r1), r1.get(1), r1.get(2), r1.get(5));
        if (r13 == false) goto L19;
        int r14 = R.string.data_transport_memory_build_package_select_start_date;
        String r3 = "data_transport_memory_build_package_select_start_date";
    L20:
        r2.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r14, TypedValues.Custom.S_STRING, r3)), CharSequence.class, "com.obric.memorydata.plugin"));
        r2.show();
        return;
    L19:
        r14 = R.string.data_transport_memory_build_package_select_end_date;
        r3 = "data_transport_memory_build_package_select_end_date";
        goto L20
    L8:
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L16;
        r1.setTimeInMillis(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L16
    L10:
        r4 = false;
        goto L11
    L4:
        r0 = this.selectedEndTimeMs;
        goto L5
    }

    private static final void selectDateTime$lambda$18(MemoryBuildDataPackageActivity r2, boolean r3, Calendar r4, DatePicker r5, int r6, int r7, int r8) {
        MemoryBuildDataPackageActivity r9 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
        Calendar r10 = Calendar.getInstance();
        r10.setTimeInMillis(r4.getTimeInMillis());
        r10.set(1, r6);
        r10.set(2, r7);
        r10.set(5, r8);
        Intrinsics.checkNotNull(r10);
        r9.showTimePickerWithSeconds(r10, r3);
    }

    private final void setRunning(boolean r6, String r7) {
        this.running = r6;
        Window r1 = getWindow();
        if (r6 == false) goto L5;
        r1.addFlags(128);
    L6:
        TextView r0 = this.tvStatus;
        OButton r2 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tvStatus");
        r0 = null;
    L9:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r8 = this.btnExport;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("btnExport");
        r8 = null;
    L12:
        r8.setEnabled(!r6);
        OButton r9 = this.btnImportLatest;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("btnImportLatest");
        r9 = null;
    L15:
        r9.setEnabled(!r6);
        OButton r10 = this.btnSelectStartTime;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("btnSelectStartTime");
        r10 = null;
    L18:
        r10.setEnabled(!r6);
        OButton r11 = this.btnSelectEndTime;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("btnSelectEndTime");
        r11 = null;
    L21:
        r11.setEnabled(!r6);
        OButton r12 = this.btnClearTimeRange;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("btnClearTimeRange");
        r12 = null;
    L24:
        r12.setEnabled(!r6);
        OSwitch r13 = this.switchOnlyRawObservation;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("switchOnlyRawObservation");
        r13 = null;
    L27:
        r13.setEnabled(!r6);
        OButton r14 = this.btnShare;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
        r14 = null;
    L30:
        boolean r3 = false;
        if (r6 == false) goto L33;
    L35:
        boolean r4 = false;
    L36:
        r14.setEnabled(r4);
        OButton r15 = this.btnCopyPath;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("btnCopyPath");
        r15 = null;
    L39:
        if (r6 == false) goto L41;
    L43:
        boolean r5 = false;
    L44:
        r15.setEnabled(r5);
        OButton r16 = this.btnImportLatest;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("btnImportLatest");
    L48:
        if (r6 == false) goto L50;
    L52:
        r2.setEnabled(r3);
        return;
    L50:
        if (this.latestFile == null) goto L52;
        r3 = true;
        goto L52
    L47:
        r2 = r16;
        goto L48
    L41:
        if (this.latestFile == null) goto L43;
        r5 = true;
        goto L44
    L33:
        if (this.latestFile == null) goto L35;
        r4 = true;
        goto L36
    L5:
        r1.clearFlags(128);
        goto L6
    }

    private final void shareLatestFiles() {
        File r0 = this.latestFile;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(new File[]{r0, this.latestPreviewFile}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.fileprovider", (File) ZeusTransformUtils.preCheckCast(r3.next(), File.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"));
        goto L7
    L9:
        ArrayList<? extends Parcelable> r4 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (r4.size() <= 1) goto L12;
        Intent r5 = new Intent("android.intent.action.SEND_MULTIPLE");
        r5.setType("application/octet-stream");
        r5.putParcelableArrayListExtra("android.intent.extra.STREAM", r4);
    L13:
        r5.addFlags(1);
        ZeusTransformUtils.startActivity(this, Intent.createChooser(r5, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_share_chooser, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_share_chooser")), CharSequence.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin");
        return;
    L12:
        r5 = new Intent("android.intent.action.SEND");
        r5.setType("application/octet-stream");
        r5.putExtra("android.intent.extra.STREAM", (Parcelable) ZeusTransformUtils.preCheckCast(CollectionsKt.first((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")), Parcelable.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    private final void showTimePickerWithSeconds(final Calendar r13, final boolean r14) {
        int r1 = (int) (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density * 16);
        final NumberPicker r7 = showTimePickerWithSeconds$createPicker(this, 0, 23, r13.get(11));
        final NumberPicker r8 = showTimePickerWithSeconds$createPicker(this, 0, 59, r13.get(12));
        final NumberPicker r9 = showTimePickerWithSeconds$createPicker(this, 0, 59, r13.get(13));
        LinearLayout r2 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r2.setOrientation(0);
        r2.setGravity(17);
        r2.setPadding(r1, r1, r1, r1);
        r2.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
        TextView r3 = new TextView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_hour_label, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_hour_label")), CharSequence.class, "com.obric.memorydata.plugin"));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        TextView r4 = new TextView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_minute_label, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_minute_label")), CharSequence.class, "com.obric.memorydata.plugin"));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"));
        TextView r5 = new TextView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_second_label, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_second_label")), CharSequence.class, "com.obric.memorydata.plugin"));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
        AlertDialog.Builder r6 = new AlertDialog.Builder((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        if (r14 == false) goto L5;
        int r10 = R.string.data_transport_memory_build_package_select_start_time;
        String r11 = "data_transport_memory_build_package_select_start_time";
    L6:
        r6.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r10, TypedValues.Custom.S_STRING, r11)), CharSequence.class, "com.obric.memorydata.plugin")).setView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).setNegativeButton((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_cancel, TypedValues.Custom.S_STRING, "data_transport_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), null).setPositiveButton((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_confirm, TypedValues.Custom.S_STRING, "data_transport_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryBuildDataPackageActivity$tlbkWDmbQkM81h2PRiW1tR7IPw(r13, r7, r8, r9, r14, this)).show();
        return;
    L5:
        r10 = R.string.data_transport_memory_build_package_select_end_time;
        r11 = "data_transport_memory_build_package_select_end_time";
        goto L6
    }

    private static final NumberPicker showTimePickerWithSeconds$createPicker(MemoryBuildDataPackageActivity r3, int r4, int r5, int r6) {
        NumberPicker r0 = new NumberPicker((Context) ZeusTransformUtils.preCheckCast((MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setMinValue(r4);
        r0.setMaxValue(r5);
        r0.setWrapSelectorWheel(true);
        r0.setDescendantFocusability(393216);
        r0.setFormatter($$Lambda$MemoryBuildDataPackageActivity$6DEnfgsj_e68Xs8qHaq7FfMlTPY.INSTANCE);
        r0.setValue(RangesKt.coerceIn(r6, r4, r5));
        return r0;
    }

    private static final String showTimePickerWithSeconds$createPicker$lambda$26$lambda$25(int r0) {
        return showTimePickerWithSeconds$twoDigits(r0);
    }

    private static final void showTimePickerWithSeconds$lambda$31(Calendar r1, NumberPicker r2, NumberPicker r3, NumberPicker r4, boolean r5, MemoryBuildDataPackageActivity r6, DialogInterface r7, int r8) {
        MemoryBuildDataPackageActivity r9 = (MemoryBuildDataPackageActivity) ZeusTransformUtils.wrapperContextForParams(r6, MemoryBuildDataPackageActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r10 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r7, DialogInterface.class, "com.obric.memorydata.plugin");
        r1.set(11, r2.getValue());
        r1.set(12, r3.getValue());
        r1.set(13, r4.getValue());
        r1.set(14, 0);
        Long r11 = Long.valueOf(r1.getTimeInMillis());
        if (r5 == false) goto L5;
        r9.selectedStartTimeMs = r11;
    L6:
        r9.refreshTimeRangeSummary();
        return;
    L5:
        r9.selectedEndTimeMs = r11;
        goto L6
    }

    private static final String showTimePickerWithSeconds$twoDigits(int r4) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r5 = String.format(Locale.CHINA, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(r4)}, 1));
        Intrinsics.checkNotNullExpressionValue(r5, "format(...)");
        return r5;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.running == false) goto L6;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.data_transport_build_task_running_wait, TypedValues.Custom.S_STRING, "data_transport_build_task_running_wait")), CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        return;
    L6:
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r20) {
        if (AppContext.INSTANCE.isDebug() == true) goto L6;
        finish();
        return;
    L6:
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_memory_build_data_package, "layout", "activity_memory_build_data_package"));
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.contentScrollView, OaidModel.KEY_ID, "contentScrollView"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(...)");
        OSwitch r6 = null;
        g.a(r1, 0, 1, null);
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(...)");
        this.viewTitle = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r2, OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.btnExportPackage, OaidModel.KEY_ID, "btnExportPackage"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(...)");
        this.btnExport = (OButton) ZeusTransformUtils.preCheckCast(r3, OButton.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.btnImportLatestPackage, OaidModel.KEY_ID, "btnImportLatestPackage"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(...)");
        this.btnImportLatest = (OButton) ZeusTransformUtils.preCheckCast(r4, OButton.class, "com.obric.memorydata.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.btnSharePackage, OaidModel.KEY_ID, "btnSharePackage"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
        this.btnShare = (OButton) ZeusTransformUtils.preCheckCast(r5, OButton.class, "com.obric.memorydata.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.btnCopyPackagePath, OaidModel.KEY_ID, "btnCopyPackagePath"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(...)");
        this.btnCopyPath = (OButton) ZeusTransformUtils.preCheckCast(r7, OButton.class, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.btnSelectStartTime, OaidModel.KEY_ID, "btnSelectStartTime"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(...)");
        this.btnSelectStartTime = (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.btnSelectEndTime, OaidModel.KEY_ID, "btnSelectEndTime"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(...)");
        this.btnSelectEndTime = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btnClearTimeRange, OaidModel.KEY_ID, "btnClearTimeRange"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(...)");
        this.btnClearTimeRange = (OButton) ZeusTransformUtils.preCheckCast(r10, OButton.class, "com.obric.memorydata.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.switchOnlyRawObservation, OaidModel.KEY_ID, "switchOnlyRawObservation"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(...)");
        this.switchOnlyRawObservation = (OSwitch) ZeusTransformUtils.preCheckCast(r11, OSwitch.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.tvStatus, OaidModel.KEY_ID, "tvStatus"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(...)");
        this.tvStatus = (TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.tvLatestPackageSummary, OaidModel.KEY_ID, "tvLatestPackageSummary"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(...)");
        this.tvLatestPackageSummary = (TextView) ZeusTransformUtils.preCheckCast(r13, TextView.class, "com.obric.memorydata.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.tvTimeRangeSummary, OaidModel.KEY_ID, "tvTimeRangeSummary"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(...)");
        this.tvTimeRangeSummary = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.tvExportScopeSummary, OaidModel.KEY_ID, "tvExportScopeSummary"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(...)");
        this.tvExportScopeSummary = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.tvLog, OaidModel.KEY_ID, "tvLog"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(...)");
        this.tvLog = (TextView) ZeusTransformUtils.preCheckCast(r16, TextView.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.scrollViewLog, OaidModel.KEY_ID, "scrollViewLog"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(...)");
        this.scrollViewLog = (ScrollView) ZeusTransformUtils.preCheckCast(r17, ScrollView.class, "com.obric.memorydata.plugin");
        BaseActivity r18 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        OFloatingTitleBar r19 = this.viewTitle;
        if (r19 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewTitle");
        OFloatingTitleBar r110 = null;
    L10:
        BaseActivity.setupTitleBarBackAction$default(r18, r110, null, 0, null, 14, null);
        OFloatingTitleBar r21 = this.viewTitle;
        if (r21 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewTitle");
        r21 = null;
    L13:
        registerFloatingTitleBar(r21);
        refreshLatestPackageInfo();
        refreshTimeRangeSummary();
        refreshExportScopeSummary();
        OButton r22 = this.btnExport;
        if (r22 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("btnExport");
        r22 = null;
    L16:
        r22.setOnClickListener(new $$Lambda$MemoryBuildDataPackageActivity$ZZMkeupkfE2XlyyfdnVJx5fdMM(this));
        OButton r23 = this.btnImportLatest;
        if (r23 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("btnImportLatest");
        r23 = null;
    L19:
        r23.setOnClickListener(new $$Lambda$MemoryBuildDataPackageActivity$m1XA2JZN0J5dAc8b9ToAMr88SU(this));
        OButton r24 = this.btnShare;
        if (r24 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("btnShare");
        r24 = null;
    L22:
        r24.setOnClickListener(new $$Lambda$MemoryBuildDataPackageActivity$PUpNSfEc31x_l0r_99yYFq6zZgg(this));
        OButton r25 = this.btnCopyPath;
        if (r25 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("btnCopyPath");
        r25 = null;
    L25:
        r25.setOnClickListener(new $$Lambda$MemoryBuildDataPackageActivity$VD_6KzqmUntNoU3E5YHCes1ITk(this));
        OButton r26 = this.btnSelectStartTime;
        if (r26 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("btnSelectStartTime");
        r26 = null;
    L28:
        r26.setOnClickListener(new $$Lambda$MemoryBuildDataPackageActivity$uCJ7Z2sGfeyEq1bLaFkbEm7cyo4(this));
        OButton r27 = this.btnSelectEndTime;
        if (r27 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("btnSelectEndTime");
        r27 = null;
    L31:
        r27.setOnClickListener(new $$Lambda$MemoryBuildDataPackageActivity$D_kwJyoGnmeJBMiWIsLlPmpxmes(this));
        OButton r28 = this.btnClearTimeRange;
        if (r28 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("btnClearTimeRange");
        r28 = null;
    L34:
        r28.setOnClickListener(new $$Lambda$MemoryBuildDataPackageActivity$AJ93_1bZwOGFfwASH8ldXp24Md4(this));
        OSwitch r29 = this.switchOnlyRawObservation;
        if (r29 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("switchOnlyRawObservation");
    L38:
        r6.setOnCheckedChangeListener(new $$Lambda$MemoryBuildDataPackageActivity$5cwr2jCvkSTZToGaAMh3xdJurzI(this));
        String r30 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_tool_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_tool_log"));
        Intrinsics.checkNotNullExpressionValue(r30, "getString(...)");
        appendLog(r30);
        String r31 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_content_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_content_log"));
        Intrinsics.checkNotNullExpressionValue(r31, "getString(...)");
        appendLog(r31);
        String r32 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_scope_default_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_scope_default_log"));
        Intrinsics.checkNotNullExpressionValue(r32, "getString(...)");
        appendLog(r32);
        String r33 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_description_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_description_log"));
        Intrinsics.checkNotNullExpressionValue(r33, "getString(...)");
        appendLog(r33);
        String r34 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_default_latest_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_default_latest_log"));
        Intrinsics.checkNotNullExpressionValue(r34, "getString(...)");
        appendLog(r34);
        File r35 = this.latestFile;
        if (r35 == null) goto L42;
        String r36 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_current_latest_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_current_latest_log"), new Object[]{r35.getName()});
        Intrinsics.checkNotNullExpressionValue(r36, "getString(...)");
        appendLog(r36);
        String r37 = getString(ZeusTransformUtils.mapRes(R.string.data_transport_memory_build_package_current_latest_path_log, TypedValues.Custom.S_STRING, "data_transport_memory_build_package_current_latest_path_log"), new Object[]{r35.getAbsolutePath()});
        Intrinsics.checkNotNullExpressionValue(r37, "getString(...)");
        appendLog(r37);
        return;
    L42:
        return;
    L37:
        r6 = r29;
        goto L38
    L9:
        r110 = r19;
        goto L10
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(128);
    }
}
