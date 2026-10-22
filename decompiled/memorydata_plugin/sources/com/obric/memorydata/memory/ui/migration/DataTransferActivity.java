package com.obric.memorydata.memory.ui.migration;

import android.animation.TimeInterpolator;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.databinding.ActivityDataTransferBinding;
import com.obric.memorydata.memory.utils.e;
import com.obric.memorydata.memory.utils.n;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.g;
import com.obric.memorydata.utils.bb;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.o;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0011H\u0002J\u001a\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J.\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020/H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010*2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u000e\u00103\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"J\f\u00104\u001a\u00020\u0019*\u000205H\u0002J\f\u00106\u001a\u00020\u0019*\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "TAG", "", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityDataTransferBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "qrScannerHelper", "Lcom/obric/memorydata/memory/utils/QrScannerHelper;", "currentState", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "transitionJob", "Lkotlinx/coroutines/Job;", "latestState", "exportSelection", "Lcom/obric/memorydata/memory/ui/migration/ExportSelection;", "lastRenderedQrText", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "onBackPressed", "showInterruptDialog", "loadDeviceName", "getGlobalDeviceName", "context", "Landroid/content/Context;", "handleImportSuccess", "state", "Lcom/obric/memorydata/memory/ui/migration/MigrationState$Success$Import;", "clearOtherAppTasksBeforeProcessKill", "renderState", "updateUiContent", "config", "Lcom/obric/memorydata/memory/ui/migration/DataTransferActivity$MigrationUiConfig;", "createQrBitmapOrNull", "Landroid/graphics/Bitmap;", Params.CONTENT, "sizePx", "", "foregroundColor", "backgroundColor", "getStateUiConfig", "navigateToAssistantSettings", "applyPrimaryStyle", "Lcom/obric/oui/button/OButton;", "applyNeutralStyle", "Companion", "MigrationUiConfig", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataTransferActivity extends BaseActivity {
    public static final a Companion = null;
    public static final String EXTRA_SCAN_RESULT = "extra_scan_result";
    private final String TAG;
    private ActivityDataTransferBinding binding;
    private com.obric.memorydata.memory.ui.migration.b currentState;
    private com.obric.memorydata.memory.ui.migration.a exportSelection;
    private String lastRenderedQrText;
    private com.obric.memorydata.memory.ui.migration.b latestState;
    private n qrScannerHelper;
    private bx transitionJob;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferActivity$Companion;", "", "<init>", "()V", "EXTRA_SCAN_RESULT", "", "startForExport", "", "context", "Landroid/content/Context;", "exportSelection", "Lcom/obric/memorydata/memory/ui/migration/ExportSelection;", "startForImport", "scanResult", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3, com.obric.memorydata.memory.ui.migration.a r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "exportSelection");
            Intent r5 = new Intent(r2, DataTransferActivity.class);
            r4.a(r5);
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }

        public final void a(Context r3, String r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "scanResult");
            Intent r5 = new Intent(r2, DataTransferActivity.class);
            r5.putExtra(DataTransferActivity.EXTRA_SCAN_RESULT, r4);
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferActivity$MigrationUiConfig;", "", "iconRes", "", "title", "", "subtitle", "buttonText", "isPrimaryButton", "", "onButtonClick", "Lkotlin/Function0;", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getIconRes", "()I", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getButtonText", "()Z", "getOnButtonClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11352b;
        private final String c;
        private final String d;
        private final boolean e;
        private final Function0<Unit> f;

        public b(int r3, String r4, String r5, String r6, boolean r7, Function0<Unit> r8) {
            Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, "subtitle");
            Intrinsics.checkNotNullParameter(r6, "buttonText");
            Intrinsics.checkNotNullParameter(r9, "onButtonClick");
            this.f11351a = r3;
            this.f11352b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r9;
        }

        public final int a() {
            return this.f11351a;
        }

        public final String b() {
            return this.f11352b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f11351a == r6.f11351a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11352b, r6.f11352b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final Function0<Unit> f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.f11351a) * 31) + this.f11352b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "MigrationUiConfig(iconRes=" + this.f11351a + ", title=" + this.f11352b + ", subtitle=" + this.c + ", buttonText=" + this.d + ", isPrimaryButton=" + this.e + ", onButtonClick=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f11353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataTransferActivity f11354b;
        final /* synthetic */ String c;
        final /* synthetic */ ImageView d;

        public c(View r3, DataTransferActivity r4, String r5, ImageView r6) {
            DataTransferActivity r7 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r4, DataTransferActivity.class, "com.obric.memorydata.plugin");
            this.f11353a = r3;
            this.f11354b = r7;
            this.c = r5;
            this.d = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.f11353a;
            com.obric.memorydata.memory.ui.migration.b r1 = DataTransferActivity.access$getLatestState$p(this.f11354b);
            if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.memory.ui.migration.b.g.class) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.migration.b.g) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.migration.b.g.class, "com.obric.memorydata.plugin")).a(), this.c) == false) goto L12;
            Bitmap r2 = DataTransferActivity.createQrBitmapOrNull$default(this.f11354b, this.c, r0.getWidth(), 0, 0, 12, null);
            if (r2 == null) goto L9;
            this.d.setImageBitmap(r2);
        L9:
            DataTransferActivity.access$setLastRenderedQrText$p(this.f11354b, this.c);
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.DataTransferActivity$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferActivity$onCreate$2", f = "DataTransferActivity.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DataTransferActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.DataTransferActivity$onCreate$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferActivity$onCreate$2$1", f = "DataTransferActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<com.obric.memorydata.memory.ui.migration.b, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DataTransferActivity this$0;

            AnonymousClass1(DataTransferActivity r3, Continuation<? super AnonymousClass1> r4) {
                DataTransferActivity r5 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataTransferActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(com.obric.memorydata.memory.ui.migration.b r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(com.obric.memorydata.memory.ui.migration.b r3, Continuation<? super Unit> r4) {
                return invoke2((com.obric.memorydata.memory.ui.migration.b) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r6);
                com.obric.memorydata.memory.ui.migration.b r7 = (com.obric.memorydata.memory.ui.migration.b) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
                RunLog.INSTANCE.debug(DataTransferActivity.access$getTAG$p(this.this$0), "收到 state: " + r7 + ", type=" + Reflection.getOrCreateKotlinClass(r7.getClass()).getSimpleName());
                boolean r0 = ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.memory.ui.migration.b.e.C0614b.class);
                DataTransferActivity r5 = this.this$0;
                if (r0 == false) goto L7;
                DataTransferActivity.access$handleImportSuccess(r5, (com.obric.memorydata.memory.ui.migration.b.e.C0614b) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.memory.ui.migration.b.e.C0614b.class, "com.obric.memorydata.plugin"));
            L9:
                return Unit.INSTANCE;
            L7:
                DataTransferActivity.access$renderState(r5, r7);
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(DataTransferActivity r3, Continuation<? super AnonymousClass2> r4) {
            DataTransferActivity r5 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataTransferActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            i r8 = k.c((i) ZeusTransformUtils.preCheckCast(DataTransferActivity.access$getViewModel(this.this$0).getUiState(), i.class, "com.obric.memorydata.plugin"));
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.DataTransferActivity$renderState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferActivity$renderState$1", f = "DataTransferActivity.kt", i = {0}, l = {233}, m = "invokeSuspend", n = {"durationMs"}, s = {"J$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.memorydata.memory.ui.migration.b $state;
        final /* synthetic */ ViewGroup $targetView;
        long J$0;
        int label;
        final /* synthetic */ DataTransferActivity this$0;

        AnonymousClass1(DataTransferActivity r3, com.obric.memorydata.memory.ui.migration.b r4, ViewGroup r5, Continuation<? super AnonymousClass1> r6) {
            DataTransferActivity r7 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataTransferActivity.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r7;
            this.$state = r4;
            this.$targetView = r5;
            super(2, r8);
        }

        private static final void invokeSuspend$lambda$4$lambda$3(ViewGroup r2) {
            ((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        }

        public static /* synthetic */ void lambda$oMRGIPniln5sspcQvE8APHP2uhs(ViewGroup r0) {
            invokeSuspend$lambda$4$lambda$3(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$state, this.$targetView, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r17) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            long r3 = this.J$0;
            ResultKt.throwOnFailure(r17);
        L62:
            long r9 = r3;
        L68:
            com.obric.memorydata.memory.ui.migration.b r4 = DataTransferActivity.access$getLatestState$p(this.this$0);
            if (r4 != null) goto L71;
            r4 = this.$state;
        L71:
            ViewGroup r5 = this.$targetView;
            ActivityDataTransferBinding r6 = DataTransferActivity.access$getBinding$p(this.this$0);
            if (r6 != null) goto L75;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r6 = null;
        L75:
            if (Intrinsics.areEqual(r5, r6.layoutGenericStatus) == false) goto L77;
            b r7 = DataTransferActivity.access$getStateUiConfig(this.this$0, r4);
        L78:
            DataTransferActivity.access$updateUiContent(this.this$0, r4, r7);
            this.$targetView.animate().cancel();
            this.$targetView.setAlpha(0.0f);
            ((View) ZeusTransformUtils.preCheckCast(this.$targetView, View.class, "com.obric.memorydata.plugin")).setVisibility(0);
            this.$targetView.animate().alpha(1.0f).setDuration(r9).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).setListener(null).start();
            DataTransferActivity.access$setCurrentState$p(this.this$0, r4);
            return Unit.INSTANCE;
        L77:
            r7 = null;
            goto L78
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r17);
            ViewGroup[] r8 = new ViewGroup[4];
            ActivityDataTransferBinding r11 = DataTransferActivity.access$getBinding$p(this.this$0);
            if (r11 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r11 = null;
        L11:
            r8[0] = r11.layoutWaitingForScan;
            ActivityDataTransferBinding r12 = DataTransferActivity.access$getBinding$p(this.this$0);
            if (r12 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r12 = null;
        L14:
            r8[1] = r12.layoutConnecting;
            ActivityDataTransferBinding r13 = DataTransferActivity.access$getBinding$p(this.this$0);
            if (r13 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r13 = null;
        L17:
            r8[2] = r13.pageStatusRestoring;
            ActivityDataTransferBinding r14 = DataTransferActivity.access$getBinding$p(this.this$0);
            if (r14 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r14 = null;
        L20:
            r8[3] = r14.layoutGenericStatus;
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r8), Iterable.class, "com.obric.memorydata.plugin");
            ViewGroup r15 = this.$targetView;
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r18 = r10.iterator();
        L22:
            if (r18.hasNext() == false) goto L26;
            Object r19 = r18.next();
            if ((!Intrinsics.areEqual((ViewGroup) ZeusTransformUtils.preCheckCast(r19, ViewGroup.class, "com.obric.memorydata.plugin"), r15)) == false) goto L22;
            r16.add(r19);
            goto L22
        L26:
            List r20 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
            Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
            Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r112 = r110.iterator();
        L28:
            if (r112.hasNext() == false) goto L41;
            Object r113 = r112.next();
            ViewGroup r114 = (ViewGroup) ZeusTransformUtils.preCheckCast(r113, ViewGroup.class, "com.obric.memorydata.plugin");
            if (((View) ZeusTransformUtils.preCheckCast(r114, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L32;
            boolean r115 = true;
        L33:
            if (r115 == false) goto L35;
        L38:
            boolean r116 = true;
        L39:
            if (r116 == false) goto L28;
            r111.add(r113);
            goto L28
        L35:
            if (r114.getAlpha() > 0.0f) goto L38;
            r116 = false;
            goto L39
        L32:
            r115 = false;
            goto L33
        L41:
            List r117 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin");
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r117, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L63;
            Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            if (r21.hasNext() == true) goto L46;
            Float r22 = null;
        L51:
            if (r22 == null) goto L53;
            float r23 = r22.floatValue();
        L54:
            float r118 = 300;
            long r119 = RangesKt.coerceAtLeast((long) (r23 * r118), 0);
            Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L56:
            if (r24.hasNext() == false) goto L58;
            final ViewGroup r120 = (ViewGroup) ZeusTransformUtils.preCheckCast(r24.next(), ViewGroup.class, "com.obric.memorydata.plugin");
            long r25 = RangesKt.coerceAtLeast((long) (r120.getAlpha() * r118), 0);
            r120.animate().cancel();
            r120.animate().alpha(0.0f).setDuration(r25).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$DataTransferActivity$renderState$1$oMRGIPniln5sspcQvE8APHP2uhs(r120)).start();
            goto L56
        L58:
            Continuation r26 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.J$0 = 300;
            this.label = 1;
            if (au.a(r119, r26) != r1) goto L61;
            return r1;
        L61:
            r3 = 300;
            goto L62
        L53:
            r23 = 0.0f;
            goto L54
        L46:
            float r121 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r21.next(), ViewGroup.class, "com.obric.memorydata.plugin")).getAlpha();
        L48:
            if (r21.hasNext() == false) goto L50;
            r121 = Math.max(r121, ((ViewGroup) ZeusTransformUtils.preCheckCast(r21.next(), ViewGroup.class, "com.obric.memorydata.plugin")).getAlpha());
            goto L48
        L50:
            r22 = Boxing.boxFloat(r121);
            goto L51
        L63:
            Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L65:
            if (r27.hasNext() == false) goto L67;
            ViewGroup r28 = (ViewGroup) ZeusTransformUtils.preCheckCast(r27.next(), ViewGroup.class, "com.obric.memorydata.plugin");
            r28.animate().cancel();
            ((View) ZeusTransformUtils.preCheckCast(r28, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
            r28.setAlpha(0.0f);
            goto L65
        L67:
            r9 = 300;
            goto L68
        }
    }

    static {
        Companion = new a(null);
    }

    public DataTransferActivity() {
        this.TAG = "DataTransferActivity";
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new DataTransferActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DataTransferViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new DataTransferActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new DataTransferActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        this.exportSelection = new com.obric.memorydata.memory.ui.migration.a(false, false, 3, null);
    }

    public static final /* synthetic */ ActivityDataTransferBinding access$getBinding$p(DataTransferActivity r2) {
        return ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.migration.b access$getLatestState$p(DataTransferActivity r2) {
        return ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).latestState;
    }

    public static final /* synthetic */ b access$getStateUiConfig(DataTransferActivity r2, com.obric.memorydata.memory.ui.migration.b r3) {
        return ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).getStateUiConfig(r3);
    }

    public static final /* synthetic */ String access$getTAG$p(DataTransferActivity r2) {
        return ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).TAG;
    }

    public static final /* synthetic */ DataTransferViewModel access$getViewModel(DataTransferActivity r2) {
        return ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$handleImportSuccess(DataTransferActivity r2, com.obric.memorydata.memory.ui.migration.b.e.C0614b r3) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).handleImportSuccess(r3);
    }

    public static final /* synthetic */ void access$renderState(DataTransferActivity r2, com.obric.memorydata.memory.ui.migration.b r3) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).renderState(r3);
    }

    public static final /* synthetic */ void access$setCurrentState$p(DataTransferActivity r2, com.obric.memorydata.memory.ui.migration.b r3) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).currentState = r3;
    }

    public static final /* synthetic */ void access$setLastRenderedQrText$p(DataTransferActivity r2, String r3) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).lastRenderedQrText = r3;
    }

    public static final /* synthetic */ void access$updateUiContent(DataTransferActivity r2, com.obric.memorydata.memory.ui.migration.b r3, b r4) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).updateUiContent(r3, r4);
    }

    private final void applyNeutralStyle(OButton r4) {
        r4.setBackgroundResource(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2"));
        r4.setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        r4.setAlpha(1.0f);
        r4.setEnabled(true);
    }

    private final void applyPrimaryStyle(OButton r4) {
        r4.setBackgroundResource(ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, TypedValues.Custom.S_COLOR, "oui_accent_6_bg"));
        r4.setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, TypedValues.Custom.S_COLOR, "oui_on_accent_default")));
        r4.setAlpha(1.0f);
        r4.setEnabled(true);
    }

    private final void clearOtherAppTasksBeforeProcessKill() {
        e.f11535a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), getTaskId());
    }

    private final Bitmap createQrBitmapOrNull(String r12, int r13, int r14, int r15) {
        Object r0 = null;
        if (r13 > 0) goto L6;
        return null;
    L6:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L28;
        return null;
    L28:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        DataTransferActivity r11 = (DataTransferActivity) ZeusTransformUtils.preCheckCast(this, DataTransferActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        com.google.zxing.common.b r16 = new com.google.zxing.qrcode.b().a(r12, BarcodeFormat.QR_CODE, r13, r13, MapsKt.mapOf(new Pair[]{TuplesKt.to(EncodeHintType.MARGIN, 0), TuplesKt.to(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M)}));     // Catch: Throwable -> L20
        int[] r17 = new int[r13 * r13];     // Catch: Throwable -> L20
        int r2 = 0;
    L9:
        if (r2 >= r13) goto L18;
        int r4 = r2 * r13;     // Catch: Throwable -> L20
        int r5 = 0;
    L11:
        if (r5 >= r13) goto L17;
        int r6 = r4 + r5;     // Catch: Throwable -> L20
        if (r16.a(r5, r2) == false) goto L15;
        int r7 = r14;
    L16:
        r17[r6] = r7;     // Catch: Throwable -> L20
        r5 = r5 + 1;     // Catch: Throwable -> L20
        goto L11
    L15:
        r7 = r15;
        goto L16
    L17:
        r2 = r2 + 1;     // Catch: Throwable -> L20
        goto L9
    L18:
        Object r18 = Result.m1421constructorimpl(Bitmap.createBitmap(r17, r13, r13, Bitmap.Config.ARGB_8888));     // Catch: Throwable -> L20
    L23:
        if (Result.m1427isFailureimpl(r18) == true) goto L27;
        r0 = r18;
    L27:
        return (Bitmap) ZeusTransformUtils.preCheckCast(r0, Bitmap.class, "com.obric.memorydata.plugin");
    L20:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    static /* synthetic */ Bitmap createQrBitmapOrNull$default(DataTransferActivity r1, String r2, int r3, int r4, int r5, int r6, Object r7) {
        DataTransferActivity r8 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r1, DataTransferActivity.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = ViewCompat.MEASURED_STATE_MASK;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = -1;
    L9:
        return r8.createQrBitmapOrNull(r2, r3, r4, r5);
    }

    private final b getStateUiConfig(com.obric.memorydata.memory.ui.migration.b r20) {
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.c.a.class) == false) goto L6;
        int r9 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_error, "drawable", "ic_transfer_error");
        String r10 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_account_mismatch_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_account_mismatch_title"));
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        String r11 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_account_mismatch_subtitle, TypedValues.Custom.S_STRING, "memory_data_transfer_error_account_mismatch_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        String r12 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_btn_got_it, TypedValues.Custom.S_STRING, "memory_data_btn_got_it"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        return new b(r9, r10, r11, r12, false, new $$Lambda$DataTransferActivity$te2hWD9fyKafc_k2_wzKrHZeL_M(this));
    L6:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.c.f.class) == false) goto L9;
        int r13 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_error, "drawable", "ic_transfer_error");
        String r14 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_version_low_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_version_low_title"));
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        String r15 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_version_low_subtitle, TypedValues.Custom.S_STRING, "memory_data_transfer_error_version_low_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");
        String r16 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_version_low_btn, TypedValues.Custom.S_STRING, "memory_data_transfer_error_version_low_btn"));
        Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
        return new b(r13, r14, r15, r16, true, new $$Lambda$DataTransferActivity$VlPDsmTdHEZfQ0gDthZqcEmmto4(this));
    L9:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.c.C0613c.class) == false) goto L12;
        int r17 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_error, "drawable", "ic_transfer_error");
        String r18 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_network_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_network_title"));
        Intrinsics.checkNotNullExpressionValue(r18, "getString(...)");
        String r19 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_network_subtitle, TypedValues.Custom.S_STRING, "memory_data_transfer_error_network_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r19, "getString(...)");
        String r110 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_network_btn, TypedValues.Custom.S_STRING, "memory_data_transfer_error_network_btn"));
        Intrinsics.checkNotNullExpressionValue(r110, "getString(...)");
        return new b(r17, r18, r19, r110, true, new $$Lambda$DataTransferActivity$FXhgZCOvtYYxMLH5KQFGuLLI40o(this));
    L12:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.c.e.class) == false) goto L20;
        int r111 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_error, "drawable", "ic_transfer_error");
        if (((com.obric.memorydata.memory.ui.migration.b.c.e) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.ui.migration.b.c.e.class, "com.obric.memorydata.plugin")).a() == false) goto L16;
        int r1 = ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_export_failed_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_export_failed_title");
    L17:
        String r2 = getString(r1);
        Intrinsics.checkNotNull(r2);
        String r112 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_transfer_failed_subtitle, TypedValues.Custom.S_STRING, "memory_data_transfer_error_transfer_failed_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r112, "getString(...)");
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_network_btn, TypedValues.Custom.S_STRING, "memory_data_transfer_error_network_btn"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        b r4 = new b(r111, r2, r112, r3, true, new $$Lambda$DataTransferActivity$d221V3e1HrR8qx56RqonJ08ml4(this));
    L82:
        return r4;
    L16:
        r1 = ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_import_failed_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_import_failed_title");
        goto L17
    L20:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.c.d.class) == false) goto L23;
        int r113 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_error, "drawable", "ic_transfer_error");
        String r114 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_storage_full_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_storage_full_title"));
        Intrinsics.checkNotNullExpressionValue(r114, "getString(...)");
        String r115 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_storage_full_subtitle, TypedValues.Custom.S_STRING, "memory_data_transfer_error_storage_full_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r115, "getString(...)");
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_btn_got_it, TypedValues.Custom.S_STRING, "memory_data_btn_got_it"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        return new b(r113, r114, r115, r5, false, new $$Lambda$DataTransferActivity$lhs05rbea8B0w67b1h_9ZboDlZc(this));
    L23:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.c.C0612b.class) == false) goto L30;
        int r116 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_error, "drawable", "ic_transfer_error");
        if (((com.obric.memorydata.memory.ui.migration.b.c.C0612b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.ui.migration.b.c.C0612b.class, "com.obric.memorydata.plugin")).a() == false) goto L27;
        int r6 = ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_export_failed_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_export_failed_title");
    L28:
        String r7 = getString(r6);
        Intrinsics.checkNotNull(r7);
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_btn_got_it, TypedValues.Custom.S_STRING, "memory_data_btn_got_it"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        r4 = new b(r116, r7, "", r8, false, new $$Lambda$DataTransferActivity$WOA3_gmApD_Rznaa3ktn7J9i94(this));
        goto L82
    L27:
        r6 = ZeusTransformUtils.mapRes(R.string.memory_data_transfer_error_import_failed_title, TypedValues.Custom.S_STRING, "memory_data_transfer_error_import_failed_title");
        goto L28
    L30:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.C0611b.class) == false) goto L33;
        int r117 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_lock, "drawable", "ic_transfer_lock");
        String r118 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_encrypting_title, TypedValues.Custom.S_STRING, "memory_data_transfer_encrypting_title"));
        Intrinsics.checkNotNullExpressionValue(r118, "getString(...)");
        String r119 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_encrypting_subtitle, TypedValues.Custom.S_STRING, "memory_data_transfer_encrypting_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r119, "getString(...)");
        String r21 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_interrupt_negative_btn, TypedValues.Custom.S_STRING, "memory_data_transfer_interrupt_negative_btn"));
        Intrinsics.checkNotNullExpressionValue(r21, "getString(...)");
        return new b(r117, r118, r119, r21, false, new $$Lambda$DataTransferActivity$r18DiVg4RyHkyVe5da2ACeD3iuI(this));
    L33:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.f.class) == false) goto L36;
        int r120 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_lock, "drawable", "ic_transfer_lock");
        String r121 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_transferring_title, TypedValues.Custom.S_STRING, "memory_data_transfer_transferring_title"));
        Intrinsics.checkNotNullExpressionValue(r121, "getString(...)");
        String r122 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_transferring_subtitle, TypedValues.Custom.S_STRING, "memory_data_transfer_transferring_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r122, "getString(...)");
        String r22 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_interrupt_negative_btn, TypedValues.Custom.S_STRING, "memory_data_transfer_interrupt_negative_btn"));
        Intrinsics.checkNotNullExpressionValue(r22, "getString(...)");
        return new b(r120, r121, r122, r22, false, new $$Lambda$DataTransferActivity$sb_nghxU2dDdakEZKsBU3VoRDXs(this));
    L36:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.e.C0614b.class) == false) goto L57;
        int r123 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_success, "drawable", "ic_transfer_success");
        String r124 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_success_import_title, TypedValues.Custom.S_STRING, "memory_data_transfer_success_import_title"));
        Intrinsics.checkNotNullExpressionValue(r124, "getString(...)");
        Integer r23 = ((com.obric.memorydata.memory.ui.migration.b.e.C0614b) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.ui.migration.b.e.C0614b.class, "com.obric.memorydata.plugin")).a();
        if (r23 != null) goto L41;
    L44:
        if (r23 != null) goto L47;
    L49:
        if (r23 != null) goto L52;
    L54:
        int r24 = R.string.memory_data_transfer_success_import_subtitle;
        String r25 = "memory_data_transfer_success_import_subtitle";
    L43:
        String r26 = getString(ZeusTransformUtils.mapRes(r24, TypedValues.Custom.S_STRING, r25));
        Intrinsics.checkNotNull(r26);
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_btn_finish, TypedValues.Custom.S_STRING, "memory_data_btn_finish"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        r4 = new b(r123, r124, r26, r0, true, $$Lambda$DataTransferActivity$xZBULiG1aCsRitRHg7VQHx2bwSQ.INSTANCE);
        goto L82
    L52:
        if (r23.intValue() != 3) goto L54;
        r24 = R.string.memory_data_transfer_success_import_subtitle_both;
        r25 = "memory_data_transfer_success_import_subtitle_both";
        goto L43
    L47:
        if (r23.intValue() != 2) goto L49;
        r24 = R.string.memory_data_transfer_success_import_subtitle_task_only;
        r25 = "memory_data_transfer_success_import_subtitle_task_only";
        goto L43
    L41:
        if (r23.intValue() != 1) goto L44;
        r24 = R.string.memory_data_transfer_success_import_subtitle_memory_only;
        r25 = "memory_data_transfer_success_import_subtitle_memory_only";
        goto L43
    L57:
        if (ZeusTransformUtils.instanceOf(r20, com.obric.memorydata.memory.ui.migration.b.e.a.class) == false) goto L77;
        int r125 = ZeusTransformUtils.mapRes(R.drawable.ic_transfer_success, "drawable", "ic_transfer_success");
        String r126 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_success_export_title, TypedValues.Custom.S_STRING, "memory_data_transfer_success_export_title"));
        Intrinsics.checkNotNullExpressionValue(r126, "getString(...)");
        Integer r27 = ((com.obric.memorydata.memory.ui.migration.b.e.a) ZeusTransformUtils.preCheckCast(r20, com.obric.memorydata.memory.ui.migration.b.e.a.class, "com.obric.memorydata.plugin")).a();
        if (r27 != null) goto L62;
    L65:
        if (r27 != null) goto L68;
    L70:
        if (r27 != null) goto L73;
    L75:
        int r28 = R.string.memory_data_transfer_success_export_subtitle;
        String r29 = "memory_data_transfer_success_export_subtitle";
    L64:
        String r30 = getString(ZeusTransformUtils.mapRes(r28, TypedValues.Custom.S_STRING, r29));
        Intrinsics.checkNotNull(r30);
        String r31 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_btn_finish, TypedValues.Custom.S_STRING, "memory_data_btn_finish"));
        Intrinsics.checkNotNullExpressionValue(r31, "getString(...)");
        r4 = new b(r125, r126, r30, r31, true, new $$Lambda$DataTransferActivity$5ezJPjf0T4Z7yHxlZxzK8pqYvj4(this));
        goto L82
    L73:
        if (r27.intValue() != 3) goto L75;
        r28 = R.string.memory_data_transfer_success_export_subtitle_both;
        r29 = "memory_data_transfer_success_export_subtitle_both";
        goto L64
    L68:
        if (r27.intValue() != 2) goto L70;
        r28 = R.string.memory_data_transfer_success_export_subtitle_task_only;
        r29 = "memory_data_transfer_success_export_subtitle_task_only";
        goto L64
    L62:
        if (r27.intValue() != 1) goto L65;
        r28 = R.string.memory_data_transfer_success_export_subtitle_memory_only;
        r29 = "memory_data_transfer_success_export_subtitle_memory_only";
        goto L64
    L77:
        return null;
    }

    private static final Unit getStateUiConfig$lambda$11(DataTransferActivity r2) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).finish();
        return Unit.INSTANCE;
    }

    private static final Unit getStateUiConfig$lambda$12(DataTransferActivity r2) {
        DataTransferActivity r3 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin");
        r3.navigateToAssistantSettings((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.memorydata.plugin"));
        r3.finish();
        return Unit.INSTANCE;
    }

    private static final Unit getStateUiConfig$lambda$13(DataTransferActivity r3) {
        DataTransferActivity r4 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataTransferActivity.class, "com.obric.memorydata.plugin");
        if (r4.getViewModel().isExport() == false) goto L5;
        r4.finish();
        Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"), r4.exportSelection);
    L10:
        return Unit.INSTANCE;
    L5:
        n r5 = r4.qrScannerHelper;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("qrScannerHelper");
        r5 = null;
    L8:
        r5.a();
        goto L10
    }

    private static final Unit getStateUiConfig$lambda$14(DataTransferActivity r3) {
        DataTransferActivity r4 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataTransferActivity.class, "com.obric.memorydata.plugin");
        if (r4.getViewModel().isExport() == false) goto L5;
        r4.finish();
        Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"), r4.exportSelection);
    L10:
        return Unit.INSTANCE;
    L5:
        n r5 = r4.qrScannerHelper;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("qrScannerHelper");
        r5 = null;
    L8:
        r5.a();
        goto L10
    }

    private static final Unit getStateUiConfig$lambda$15(DataTransferActivity r2) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).finish();
        return Unit.INSTANCE;
    }

    private static final Unit getStateUiConfig$lambda$16(DataTransferActivity r2) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).finish();
        return Unit.INSTANCE;
    }

    private static final Unit getStateUiConfig$lambda$17(DataTransferActivity r2) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).showInterruptDialog();
        return Unit.INSTANCE;
    }

    private static final Unit getStateUiConfig$lambda$18(DataTransferActivity r2) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).showInterruptDialog();
        return Unit.INSTANCE;
    }

    private static final Unit getStateUiConfig$lambda$19() {
        return Unit.INSTANCE;
    }

    private static final Unit getStateUiConfig$lambda$20(DataTransferActivity r2) {
        ((DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataTransferActivity.class, "com.obric.memorydata.plugin")).finish();
        return Unit.INSTANCE;
    }

    private final DataTransferViewModel getViewModel() {
        return (DataTransferViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), DataTransferViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void handleImportSuccess(com.obric.memorydata.memory.ui.migration.b.e.C0614b r5) {
        clearOtherAppTasksBeforeProcessKill();
        Intent r0 = new Intent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), DataImportSuccessActivity.class);
        Integer r6 = r5.a();
        if (r6 == null) goto L5;
        r0.putExtra(DataImportSuccessActivity.EXTRA_EXPORT_SCOPE, ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue());
    L5:
        ZeusTransformUtils.startActivity(this, r0, "com.obric.memorydata.plugin");
        finish();
        new Handler().postDelayed($$Lambda$DataTransferActivity$tooReG90LCaAYsbwgy37nc6GzwM.INSTANCE, 100);
    }

    private static final void handleImportSuccess$lambda$5() {
        Process.killProcess(Process.myPid());
    }

    private final void initViews() {
        BaseActivity r2 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityDataTransferBinding r0 = this.binding;
        ActivityDataTransferBinding r9 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r3 = r0.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r3, "viewTitle");
        ActivityDataTransferBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        BaseActivity.setupTitleBarBackAction$default(r2, r3, (View) ZeusTransformUtils.preCheckCast(r1.layoutWaitingForScan, View.class, "com.obric.memorydata.plugin"), 0, null, 12, null);
        ActivityDataTransferBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        OPageStatus r5 = r4.pageStatusConnecting;
        OTextView r6 = r5.getLoadingResultView();
        if (r6 == null) goto L14;
        o.b((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
    L14:
        ODownloadProgressView r7 = r5.getLoadingView();
        if (r7 == null) goto L17;
        com.obric.oui.c.i.c((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 0);
    L17:
        ActivityDataTransferBinding r8 = this.binding;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L20:
        r8.pageStatusRestoring.setLoadingResult((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_restoring_loading_text, TypedValues.Custom.S_STRING, "memory_data_transfer_restoring_loading_text")), CharSequence.class, "com.obric.memorydata.plugin"));
        ActivityDataTransferBinding r10 = this.binding;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L23:
        ONestedScrollView r11 = r10.layoutWaitingForScan;
        Intrinsics.checkNotNullExpressionValue(r11, "layoutWaitingForScan");
        ((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        ActivityDataTransferBinding r12 = this.binding;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L26:
        LinearLayout r13 = r12.layoutConnecting;
        Intrinsics.checkNotNullExpressionValue(r13, "layoutConnecting");
        ((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        ActivityDataTransferBinding r14 = this.binding;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L29:
        OPageStatus r15 = r14.pageStatusRestoring;
        Intrinsics.checkNotNullExpressionValue(r15, "pageStatusRestoring");
        ((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        ActivityDataTransferBinding r16 = this.binding;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L33:
        ConstraintLayout r17 = r9.layoutGenericStatus;
        Intrinsics.checkNotNullExpressionValue(r17, "layoutGenericStatus");
        ((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        return;
    L32:
        r9 = r16;
        goto L33
    }

    public static /* synthetic */ Unit lambda$5ezJPjf0T4Z7yHxlZxzK8pqYvj4(DataTransferActivity r0) {
        return getStateUiConfig$lambda$20(r0);
    }

    public static /* synthetic */ Unit lambda$FXhgZCOvtYYxMLH5KQFGuLLI40o(DataTransferActivity r0) {
        return getStateUiConfig$lambda$13(r0);
    }

    public static /* synthetic */ Unit lambda$VlPDsmTdHEZfQ0gDthZqcEmmto4(DataTransferActivity r0) {
        return getStateUiConfig$lambda$12(r0);
    }

    /* JADX INFO: renamed from: lambda$W3-Ku4W0IqTcodmyiz57la29kEM, reason: not valid java name */
    public static /* synthetic */ Unit m957lambda$W3Ku4W0IqTcodmyiz57la29kEM(DataTransferActivity r0, String r1) {
        return onCreate$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$WOA3_g-mApD_Rznaa3ktn7J9i94, reason: not valid java name */
    public static /* synthetic */ Unit m958lambda$WOA3_gmApD_Rznaa3ktn7J9i94(DataTransferActivity r0) {
        return getStateUiConfig$lambda$16(r0);
    }

    /* JADX INFO: renamed from: lambda$d221V3e1HrR8-qx56RqonJ08ml4, reason: not valid java name */
    public static /* synthetic */ Unit m959lambda$d221V3e1HrR8qx56RqonJ08ml4(DataTransferActivity r0) {
        return getStateUiConfig$lambda$14(r0);
    }

    /* JADX INFO: renamed from: lambda$ezQm35xdSrz6VF1mWMemfrIk-O0, reason: not valid java name */
    public static /* synthetic */ Unit m960lambda$ezQm35xdSrz6VF1mWMemfrIkO0(DataTransferActivity r0, DialogInterface r1, int r2) {
        return showInterruptDialog$lambda$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$iIk5e5tx4Z-s_FK8V8PAmyYiQvM, reason: not valid java name */
    public static /* synthetic */ Unit m961lambda$iIk5e5tx4Zs_FK8V8PAmyYiQvM(b r0, View r1) {
        return updateUiContent$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit lambda$lhs05rbea8B0w67b1h_9ZboDlZc(DataTransferActivity r0) {
        return getStateUiConfig$lambda$15(r0);
    }

    public static /* synthetic */ Unit lambda$r18DiVg4RyHkyVe5da2ACeD3iuI(DataTransferActivity r0) {
        return getStateUiConfig$lambda$17(r0);
    }

    public static /* synthetic */ Unit lambda$sb_nghxU2dDdakEZKsBU3VoRDXs(DataTransferActivity r0) {
        return getStateUiConfig$lambda$18(r0);
    }

    public static /* synthetic */ Unit lambda$te2hWD9fyKafc_k2_wzKrHZeL_M(DataTransferActivity r0) {
        return getStateUiConfig$lambda$11(r0);
    }

    public static /* synthetic */ void lambda$tooReG90LCaAYsbwgy37nc6GzwM() {
        handleImportSuccess$lambda$5();
    }

    public static /* synthetic */ Unit lambda$xZBULiG1aCsRitRHg7VQHx2bwSQ() {
        return getStateUiConfig$lambda$19();
    }

    private final void loadDeviceName() {
        String r0 = getGlobalDeviceName((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        if (r0 != null) goto L5;
        r0 = "Phone Name";
    L5:
        ActivityDataTransferBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.tvDeviceName.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit onCreate$lambda$0(DataTransferActivity r3, String r4) {
        DataTransferActivity r5 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataTransferActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "qrText");
        r5.finish();
        Companion.a((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"), r4);
        return Unit.INSTANCE;
    }

    private final void renderState(com.obric.memorydata.memory.ui.migration.b r13) {
        com.obric.memorydata.memory.ui.migration.b r0 = this.currentState;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.getClass() != r13.getClass()) goto L8;
        boolean r1 = false;
    L9:
        this.latestState = r13;
        b r5 = null;
        if (ZeusTransformUtils.instanceOf(r13, com.obric.memorydata.memory.ui.migration.b.g.class) == false) goto L17;
        ActivityDataTransferBinding r2 = this.binding;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L14:
        Object r3 = r2.layoutWaitingForScan;
        String r6 = "layoutWaitingForScan";
    L15:
        Intrinsics.checkNotNullExpressionValue(r3, r6);
        ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L37;
        bx r7 = this.transitionJob;
        if (r7 == null) goto L36;
        bx.a.a(r7, null, 1, null);
    L36:
        this.transitionJob = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r13, r4, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L37:
        ActivityDataTransferBinding r8 = this.binding;
        if (r8 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L41:
        if (Intrinsics.areEqual(r4, r8.layoutGenericStatus) == false) goto L43;
        r5 = getStateUiConfig(r13);
    L43:
        updateUiContent(r13, r5);
        this.currentState = r13;
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.memorydata.memory.ui.migration.b.a.class) == false) goto L23;
        ActivityDataTransferBinding r9 = this.binding;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L21:
        r3 = r9.layoutConnecting;
        r6 = "layoutConnecting";
        goto L15
    L23:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.memorydata.memory.ui.migration.b.d.class) == false) goto L28;
        ActivityDataTransferBinding r10 = this.binding;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L27:
        r3 = r10.pageStatusRestoring;
        r6 = "pageStatusRestoring";
        goto L15
    L28:
        ActivityDataTransferBinding r11 = this.binding;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L31:
        r3 = r11.layoutGenericStatus;
        r6 = "layoutGenericStatus";
    L8:
        r1 = true;
        goto L9
    }

    private final void showInterruptDialog() {
        com.obric.oui.dialog.v2.alert.b r0 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_interrupt_title, TypedValues.Custom.S_STRING, "memory_data_transfer_interrupt_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_interrupt_message, TypedValues.Custom.S_STRING, "memory_data_transfer_interrupt_message")), CharSequence.class, "com.obric.memorydata.plugin")).a(true);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_interrupt_positive_btn, TypedValues.Custom.S_STRING, "memory_data_transfer_interrupt_positive_btn"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r6 = r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$DataTransferActivity$ezQm35xdSrz6VF1mWMemfrIkO0(this));
        String r12 = getString(ZeusTransformUtils.mapRes(R.string.memory_data_transfer_interrupt_negative_btn, TypedValues.Custom.S_STRING, "memory_data_transfer_interrupt_negative_btn"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        com.obric.oui.dialog.v2.alert.b.b(r6, (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 4, null).h();
    }

    private static final Unit showInterruptDialog$lambda$2(DataTransferActivity r1, DialogInterface r2, int r3) {
        DataTransferActivity r4 = (DataTransferActivity) ZeusTransformUtils.wrapperContextForParams(r1, DataTransferActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin"), "<unused var>");
        r4.getViewModel().cancelByUser();
        r4.finish();
        return Unit.INSTANCE;
    }

    private final void updateUiContent(com.obric.memorydata.memory.ui.migration.b r19, final b r20) {
        ActivityDataTransferBinding r2 = this.binding;
        ActivityDataTransferBinding r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        OFloatingTitleBar r4 = r2.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r4, "viewTitle");
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        boolean r8 = true;
        int r9 = 8;
        if ((!ZeusTransformUtils.instanceOf(r19, com.obric.memorydata.memory.ui.migration.b.e.a.class)) == false) goto L8;
        int r6 = 0;
    L9:
        r5.setVisibility(r6);
        if (r20 == null) goto L84;
        ActivityDataTransferBinding r7 = this.binding;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L14:
        LinearLayout r10 = r7.llEncryptingStatus;
        Intrinsics.checkNotNullExpressionValue(r10, "llEncryptingStatus");
        ((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        ActivityDataTransferBinding r11 = this.binding;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L17:
        LinearLayout r12 = r11.llProgressContainer;
        Intrinsics.checkNotNullExpressionValue(r12, "llProgressContainer");
        ((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        ActivityDataTransferBinding r13 = this.binding;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L20:
        OButton r14 = r13.btnAction;
        Intrinsics.checkNotNullExpressionValue(r14, "btnAction");
        ((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        ActivityDataTransferBinding r15 = this.binding;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L23:
        r15.ivStatusIcon.setImageResource(r20.a());
        ActivityDataTransferBinding r16 = this.binding;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L26:
        r16.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r20.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        ActivityDataTransferBinding r17 = this.binding;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L29:
        r17.tvSubtitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r20.c(), CharSequence.class, "com.obric.memorydata.plugin"));
        ActivityDataTransferBinding r18 = this.binding;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L32:
        OTextView r21 = r18.tvSubtitle;
        Intrinsics.checkNotNullExpressionValue(r21, "tvSubtitle");
        View r22 = (View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20.c(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L36;
        r8 = false;
    L36:
        if (r8 == false) goto L38;
        r9 = 0;
    L38:
        r22.setVisibility(r9);
        ActivityDataTransferBinding r23 = this.binding;
        if (r23 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L41:
        OButton r24 = r23.btnAction;
        Intrinsics.checkNotNullExpressionValue(r24, "btnAction");
        ((View) ZeusTransformUtils.preCheckCast(r24, View.class, "com.obric.memorydata.plugin")).setVisibility(0);
        ActivityDataTransferBinding r25 = this.binding;
        if (r25 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L44:
        r25.btnAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(r20.d(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (r20.e() == false) goto L50;
        ActivityDataTransferBinding r26 = this.binding;
        if (r26 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L49:
        OButton r27 = r26.btnAction;
        Intrinsics.checkNotNullExpressionValue(r27, "btnAction");
        applyPrimaryStyle(r27);
    L54:
        ActivityDataTransferBinding r28 = this.binding;
        if (r28 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L57:
        OButton r29 = r28.btnAction;
        Intrinsics.checkNotNullExpressionValue(r29, "btnAction");
        bb.a((View) ZeusTransformUtils.preCheckCast(r29, View.class, "com.obric.memorydata.plugin"), 0, new $$Lambda$DataTransferActivity$iIk5e5tx4Zs_FK8V8PAmyYiQvM(r20), 1, null);
        if (ZeusTransformUtils.instanceOf(r19, com.obric.memorydata.memory.ui.migration.b.C0611b.class) == false) goto L68;
        ActivityDataTransferBinding r0 = this.binding;
        if (r0 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L62:
        LinearLayout r1 = r0.llEncryptingStatus;
        Intrinsics.checkNotNullExpressionValue(r1, "llEncryptingStatus");
        ((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin")).setVisibility(0);
        ActivityDataTransferBinding r30 = this.binding;
        if (r30 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L66:
        r3.smallLoadingView.setCurrentState(0);
        return;
    L65:
        r3 = r30;
        goto L66
    L68:
        if (ZeusTransformUtils.instanceOf(r19, com.obric.memorydata.memory.ui.migration.b.f.class) == false) goto L105;
        ActivityDataTransferBinding r31 = this.binding;
        if (r31 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L72:
        LinearLayout r32 = r31.llProgressContainer;
        Intrinsics.checkNotNullExpressionValue(r32, "llProgressContainer");
        ((View) ZeusTransformUtils.preCheckCast(r32, View.class, "com.obric.memorydata.plugin")).setVisibility(0);
        ActivityDataTransferBinding r33 = this.binding;
        if (r33 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L75:
        r33.progressBar.setProgress(((com.obric.memorydata.memory.ui.migration.b.f) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.ui.migration.b.f.class, "com.obric.memorydata.plugin")).a());
        ActivityDataTransferBinding r34 = this.binding;
        if (r34 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L78:
        r34.tvTransferredSize.setText((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.memory.ui.migration.b.f) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.ui.migration.b.f.class, "com.obric.memorydata.plugin")).b() + '/' + ((com.obric.memorydata.memory.ui.migration.b.f) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.ui.migration.b.f.class, "com.obric.memorydata.plugin")).c(), CharSequence.class, "com.obric.memorydata.plugin"));
        ActivityDataTransferBinding r35 = this.binding;
        if (r35 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L82:
        r3.tvProgressPercent.setText((CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append(((com.obric.memorydata.memory.ui.migration.b.f) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.ui.migration.b.f.class, "com.obric.memorydata.plugin")).a()).append('%').toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L81:
        r3 = r35;
        goto L82
    L105:
        return;
    L50:
        ActivityDataTransferBinding r36 = this.binding;
        if (r36 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r36 = null;
    L53:
        OButton r37 = r36.btnAction;
        Intrinsics.checkNotNullExpressionValue(r37, "btnAction");
        applyNeutralStyle(r37);
        goto L54
    L84:
        if (ZeusTransformUtils.instanceOf(r19, com.obric.memorydata.memory.ui.migration.b.g.class) == false) goto L107;
        ActivityDataTransferBinding r38 = this.binding;
        if (r38 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r38 = null;
    L88:
        ImageView r39 = r38.ivQrCode;
        Intrinsics.checkNotNullExpressionValue(r39, "ivQrCode");
        ((View) ZeusTransformUtils.preCheckCast(r39, View.class, "com.obric.memorydata.plugin")).setVisibility(0);
        String r40 = ((com.obric.memorydata.memory.ui.migration.b.g) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.ui.migration.b.g.class, "com.obric.memorydata.plugin")).a();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r40, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L91;
        return;
    L91:
        if (Intrinsics.areEqual(r40, this.lastRenderedQrText) == true) goto L109;
        ActivityDataTransferBinding r41 = this.binding;
        if (r41 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L96:
        ImageView r42 = r3.ivQrCode;
        Intrinsics.checkNotNullExpressionValue(r42, "ivQrCode");
        int r43 = r42.getWidth();
        if (r43 <= 0) goto L102;
        Bitmap r44 = createQrBitmapOrNull$default(this, r40, r43, 0, 0, 12, null);
        if (r44 == null) goto L101;
        r42.setImageBitmap(r44);
    L101:
        this.lastRenderedQrText = r40;
        return;
    L102:
        View r45 = (View) ZeusTransformUtils.preCheckCast(r42, View.class, "com.obric.memorydata.plugin");
        OneShotPreDrawListener.add(r45, (Runnable) ZeusTransformUtils.preCheckCast(new c(r45, this, r40, r42), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L95:
        r3 = r41;
        goto L96
    L109:
        return;
    L107:
        return;
    L8:
        r6 = 8;
        goto L9
    }

    private static final Unit updateUiContent$lambda$6(b r1, View r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.f().invoke();
        return Unit.INSTANCE;
    }

    public final String getGlobalDeviceName(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return Settings.Global.getString(r1.getContentResolver(), "device_name");
    L5:
        return null;
    }

    public final void navigateToAssistantSettings(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r5 = new Intent();
        r5.setComponent(new ComponentName(r3, "com.obric.assistant.AssistantSettingsActivity"));
        r5.putExtra("sub_page", "obric_about_app");
        r5.putExtra("obric_auto_check_update", true);
        ZeusTransformUtils.startActivity(r3, r5, "com.obric.memorydata.plugin");     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("Navigation", "Target Activity not found", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        com.obric.memorydata.memory.ui.migration.b r0 = (com.obric.memorydata.memory.ui.migration.b) ZeusTransformUtils.preCheckCast(getViewModel().getUiState().c(), com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.f.class) == false) goto L5;
    L13:
        showInterruptDialog();
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.C0611b.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.d.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.e.a.class) == false) goto L12;
        return;
    L12:
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.qrScannerHelper = new n((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.memorydata.plugin"), new $$Lambda$DataTransferActivity$W3Ku4W0IqTcodmyiz57la29kEM(this));
        prepareSystemBar();
        ActivityDataTransferBinding r11 = ActivityDataTransferBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r11, "inflate(...)");
        this.binding = r11;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r11.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityDataTransferBinding r12 = this.binding;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L8:
        ONestedScrollView r13 = r12.layoutWaitingForScan;
        Intrinsics.checkNotNullExpressionValue(r13, "layoutWaitingForScan");
        g.a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        ActivityDataTransferBinding r14 = this.binding;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L11:
        OButton r15 = r14.btnAction;
        Intrinsics.checkNotNullExpressionValue(r15, "btnAction");
        g.a((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"));
        initViews();
        loadDeviceName();
        this.exportSelection = com.obric.memorydata.memory.ui.migration.a.f11363a.a(getIntent());
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        getViewModel().initInitialState(getIntent().getStringExtra(EXTRA_SCAN_RESULT), this.exportSelection, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
    }
}
