package com.obric.memorydata.memory.ui.lab;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.memory.databinding.ActivityAilabBinding;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.lab.d;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.g;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.ba;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Objects;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.i;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001XB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020&H\u0014J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020)H\u0014J\b\u0010-\u001a\u00020)H\u0014J\b\u0010.\u001a\u00020)H\u0014J\b\u0010/\u001a\u00020)H\u0014J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020)H\u0002J\b\u00104\u001a\u00020)H\u0002J\"\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u000208H\u0017J\b\u0010=\u001a\u00020)H\u0002J\b\u0010>\u001a\u00020)H\u0002J\b\u0010?\u001a\u00020)H\u0002J\b\u0010@\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020)H\u0002J*\u0010B\u001a\u00020)2\b\u0010C\u001a\u0004\u0018\u00010\f2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u0002082\u0006\u0010F\u001a\u000208H\u0002J \u0010G\u001a\u00020)2\u0006\u0010H\u001a\u0002082\u0006\u0010E\u001a\u0002082\u0006\u0010I\u001a\u00020\u001bH\u0002J\b\u0010J\u001a\u00020)H\u0002J \u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u0002082\b\u0010O\u001a\u0004\u0018\u000108J\u001a\u0010P\u001a\u00020)2\b\u0010C\u001a\u0004\u0018\u00010\f2\u0006\u00106\u001a\u00020\u001bH\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u0019H\u0002J&\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u0002082\u0006\u00107\u001a\u0002082\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020VR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/memorydata/memory/ui/lab/AILabActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "Lcom/obric/memorydata/memory/lab/AILabAccessControlLogic$PermissionStatusCallback;", "Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "Lcom/obric/memorydata/memory/ui/MemoryFloatingTitleBarOwner;", "<init>", "()V", "systemInfoText", "Landroid/widget/TextView;", "screenMemoryItem", "Lcom/obric/oui/lisitem/OListItemGeneral;", "screenMemoryBtn", "Lcom/obric/oui/button/OButton;", "screenMemoryLayout", "Landroid/widget/LinearLayout;", "voiceMemoryItem", "voiceMemoryBtn", "voiceMemoryLayout", "autoMemoryItem", "autoMemoryBtn", "autoMemoryLayout", "aiProactiveAgentItem", "aiProactiveAgentBtn", "aiProactiveAgentLayout", "currentPermissionState", "Lcom/obric/memorydata/memory/lab/AILabPermissionState;", "screenMemoryStatus", "", "voiceMemoryStatus", "autoMemoryStatus", "aiProactiveAgentStatus", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityAilabBinding;", "getCurrentFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "permissionStateJob", "Lkotlinx/coroutines/Job;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onDestroy", "onResumeChecked", "initViews", "increaseScrollContentTopMargin", "increaseFeatureItemSubtitleSpacing", "observePermissionState", "initPermissionLogic", "onPermissionStatusChanged", "status", "message", "", "permissionData", "Lorg/json/JSONObject;", "onNetworkError", "error", "setupButtonListener", "onScreenMemoryButtonClick", "onVoiceMemoryButtonClick", "onAutoMemoryButtonClick", "onAIProactiveAgentButtonClick", "onPermissionButtonClick", "button", "currentStatus", "permissionName", "featureTitle", "submitPermissionRequest", ObricMemoryConstants.KEY_PACKAGE_NAME, "requestType", "updateSystemInfo", "copyTextToClipboard", "context", "Landroid/content/Context;", "textToCopy", "toastMessage", "applyButtonState", "updateUIForState", "state", "showDialog", "title", "negativeListener", "Landroid/content/DialogInterface$OnClickListener;", "positiveListener", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AILabActivity extends BaseActivity implements com.obric.memorydata.memory.lab.a.InterfaceC0503a, com.obric.memorydata.ui.b {
    public static final a Companion = null;
    private static final int LIST_ITEM_SUBTITLE_TOP_MARGIN_INCREASE_DP = 2;
    private static final int SCROLL_CONTENT_TOP_MARGIN_INCREASE_DP = 8;
    public static final String TAG = "AILabActivity";
    private static volatile boolean foreground;
    private OButton aiProactiveAgentBtn;
    private OListItemGeneral aiProactiveAgentItem;
    private LinearLayout aiProactiveAgentLayout;
    private int aiProactiveAgentStatus;
    private OButton autoMemoryBtn;
    private OListItemGeneral autoMemoryItem;
    private LinearLayout autoMemoryLayout;
    private int autoMemoryStatus;
    private ActivityAilabBinding binding;
    private d currentPermissionState;
    private bx permissionStateJob;
    private OButton screenMemoryBtn;
    private OListItemGeneral screenMemoryItem;
    private LinearLayout screenMemoryLayout;
    private int screenMemoryStatus;
    private TextView systemInfoText;
    private OButton voiceMemoryBtn;
    private OListItemGeneral voiceMemoryItem;
    private LinearLayout voiceMemoryLayout;
    private int voiceMemoryStatus;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/lab/AILabActivity$Companion;", "", "<init>", "()V", "TAG", "", "SCROLL_CONTENT_TOP_MARGIN_INCREASE_DP", "", "LIST_ITEM_SUBTITLE_TOP_MARGIN_INCREASE_DP", "foreground", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "isInForeground", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r4 = new Intent(r2, AILabActivity.class);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r4, "com.obric.memorydata.plugin");
        }

        public final boolean a() {
            return AILabActivity.access$getForeground$cp();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.lab.AILabActivity$observePermissionState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.lab.AILabActivity$observePermissionState$1", f = "AILabActivity.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AILabActivity this$0;

        AnonymousClass1(AILabActivity r3, Continuation<? super AnonymousClass1> r4) {
            AILabActivity r5 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r3, AILabActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<d> r7 = AILabPermissionRepository.f10236a.a();
            final AILabActivity r3 = this.this$0;
            j<? super d> r2 = (j) ZeusTransformUtils.preCheckCast(new C05601(r3), j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AILabActivity() {
        this.currentPermissionState = (d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), d.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ boolean access$getForeground$cp() {
        return foreground;
    }

    public static final /* synthetic */ void access$setCurrentPermissionState$p(AILabActivity r2, d r3) {
        ((AILabActivity) ZeusTransformUtils.wrapperContextForParams(r2, AILabActivity.class, "com.obric.memorydata.plugin")).currentPermissionState = r3;
    }

    public static final /* synthetic */ void access$updateUIForState(AILabActivity r2, d r3) {
        ((AILabActivity) ZeusTransformUtils.wrapperContextForParams(r2, AILabActivity.class, "com.obric.memorydata.plugin")).updateUIForState(r3);
    }

    private final void applyButtonState(OButton r1, int r2) {
        com.obric.memorydata.memory.ui.lab.a r0 = b.f10976a.a(r2);
        if (r1 == null) goto L5;
        r1.setEnabled(r0.b());
    L5:
        if (r1 == null) goto L8;
        r1.setText(r0.a());
        return;
    }

    private final void increaseFeatureItemSubtitleSpacing() {
        ActivityAilabBinding r8 = this.binding;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L5:
        LinearLayout r9 = r8.featureListContainer;
        Intrinsics.checkNotNullExpressionValue(r9, "featureListContainer");
        Sequence r10 = SequencesKt.filter(ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(AILabActivity$increaseFeatureItemSubtitleSpacing$$inlined$filterIsInstance$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        View r0 = (View) ZeusTransformUtils.preCheckCast(((OListItemGeneral) ZeusTransformUtils.preCheckCast(r11.next(), OListItemGeneral.class, "com.obric.memorydata.plugin")).getMTvSubtitle(), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r3 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin += MathKt.roundToInt(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
        r0.setLayoutParams(r3);
        goto L7
    }

    private final void increaseScrollContentTopMargin() {
        ActivityAilabBinding r6 = this.binding;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        OScrollView r7 = r6.scrollContent;
        Intrinsics.checkNotNullExpressionValue(r7, "scrollContent");
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin += MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        r8.setLayoutParams(r1);
    }

    private final void initPermissionLogic() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "init AILab permission check from activity", false, 4, null);     // Catch: Exception -> L5
        com.obric.memorydata.memory.lab.a.f10241a.a((com.obric.memorydata.memory.lab.a.InterfaceC0503a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.memory.lab.a.InterfaceC0503a.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L5
        com.obric.memorydata.memory.lab.a.f10241a.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "AILabActivity.onResume");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "init AILab permission logic failed: " + e.getMessage(), null, 4, null);
        updateUIForState(this.currentPermissionState);
    }

    private final void initViews() {
        increaseScrollContentTopMargin();
        ActivityAilabBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r1, "viewTitle");
        ActivityAilabBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3.scrollContent, View.class, "com.obric.memorydata.plugin");
        int r5 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        ActivityAilabBinding r6 = this.binding;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L11:
        setupTitleBarBackAction(r1, r4, r5, r6.cutOff);
        ActivityAilabBinding r2 = this.binding;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L14:
        r2.viewTitle.setFloatingTransitionEnabled(true);
        this.systemInfoText = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.ailab_systeminfo, OaidModel.KEY_ID, "ailab_systeminfo")), TextView.class, "com.obric.memorydata.plugin");
        this.screenMemoryItem = (OListItemGeneral) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.screen_memory_item, OaidModel.KEY_ID, "screen_memory_item")), OListItemGeneral.class, "com.obric.memorydata.plugin");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.ai_lab_button_layout, "layout", "ai_lab_button_layout"), null, "com.obric.memorydata.plugin");
        this.screenMemoryBtn = (OButton) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button, OaidModel.KEY_ID, "approve_button")), OButton.class, "com.obric.memorydata.plugin");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button_layout, OaidModel.KEY_ID, "approve_button_layout")), LinearLayout.class, "com.obric.memorydata.plugin");
        this.screenMemoryLayout = r8;
        OListItemGeneral r9 = this.screenMemoryItem;
        if (r9 == null) goto L17;
        r9.setTrailingView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
    L17:
        this.voiceMemoryItem = (OListItemGeneral) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.voice_memory_item, OaidModel.KEY_ID, "voice_memory_item")), OListItemGeneral.class, "com.obric.memorydata.plugin");
        View r10 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.ai_lab_button_layout, "layout", "ai_lab_button_layout"), null, "com.obric.memorydata.plugin");
        this.voiceMemoryBtn = (OButton) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button, OaidModel.KEY_ID, "approve_button")), OButton.class, "com.obric.memorydata.plugin");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button_layout, OaidModel.KEY_ID, "approve_button_layout")), LinearLayout.class, "com.obric.memorydata.plugin");
        this.voiceMemoryLayout = r11;
        OListItemGeneral r12 = this.voiceMemoryItem;
        if (r12 == null) goto L20;
        r12.setTrailingView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
    L20:
        this.autoMemoryItem = (OListItemGeneral) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.auto_memory_item, OaidModel.KEY_ID, "auto_memory_item")), OListItemGeneral.class, "com.obric.memorydata.plugin");
        View r13 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.ai_lab_button_layout, "layout", "ai_lab_button_layout"), null, "com.obric.memorydata.plugin");
        this.autoMemoryBtn = (OButton) ZeusTransformUtils.preCheckCast(r13.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button, OaidModel.KEY_ID, "approve_button")), OButton.class, "com.obric.memorydata.plugin");
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button_layout, OaidModel.KEY_ID, "approve_button_layout")), LinearLayout.class, "com.obric.memorydata.plugin");
        this.autoMemoryLayout = r14;
        OListItemGeneral r15 = this.autoMemoryItem;
        if (r15 == null) goto L23;
        r15.setTrailingView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
    L23:
        this.aiProactiveAgentItem = (OListItemGeneral) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.ai_proactive_agent_item, OaidModel.KEY_ID, "ai_proactive_agent_item")), OListItemGeneral.class, "com.obric.memorydata.plugin");
        View r16 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.ai_lab_button_layout, "layout", "ai_lab_button_layout"), null, "com.obric.memorydata.plugin");
        this.aiProactiveAgentBtn = (OButton) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button, OaidModel.KEY_ID, "approve_button")), OButton.class, "com.obric.memorydata.plugin");
        LinearLayout r17 = (LinearLayout) ZeusTransformUtils.preCheckCast(r16.findViewById(ZeusTransformUtils.mapRes(R.id.approve_button_layout, OaidModel.KEY_ID, "approve_button_layout")), LinearLayout.class, "com.obric.memorydata.plugin");
        this.aiProactiveAgentLayout = r17;
        OListItemGeneral r18 = this.aiProactiveAgentItem;
        if (r18 == null) goto L26;
        r18.setTrailingView((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"));
    L26:
        increaseFeatureItemSubtitleSpacing();
        updateUIForState(this.currentPermissionState);
        updateSystemInfo();
        setupButtonListener();
    }

    /* JADX INFO: renamed from: lambda$JTv9qmfifcXwHSzNxl71-lpkjfA, reason: not valid java name */
    public static /* synthetic */ void m865lambda$JTv9qmfifcXwHSzNxl71lpkjfA(AILabActivity r0, String r1, int r2, DialogInterface r3, int r4) {
        onPermissionButtonClick$lambda$12$lambda$11(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$OuuQ2f0sLSLIuzM5tjUkYgWbaFQ(AILabActivity r0, View r1) {
        setupButtonListener$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$U9ARpP8pnBw1yEBq8oD7VK09R8E(AILabActivity r0, View r1) {
        setupButtonListener$lambda$8(r0, r1);
    }

    public static /* synthetic */ void lambda$WWcauO3aSmYvuguQQpsHeX4lnpM(AILabActivity r0, View r1) {
        setupButtonListener$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$YFDQZ_nNW-xNCg75QxwHr769X4Y, reason: not valid java name */
    public static /* synthetic */ void m866lambda$YFDQZ_nNWxNCg75QxwHr769X4Y(int r0, String r1, JSONObject r2, AILabActivity r3) {
        onPermissionStatusChanged$lambda$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$YLBGHq5-owmO-AEVK_nC2rrPdNk, reason: not valid java name */
    public static /* synthetic */ void m867lambda$YLBGHq5owmOAEVK_nC2rrPdNk(OButton r0, DialogInterface r1, int r2) {
        onPermissionButtonClick$lambda$12$lambda$10(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$_gPM73yiD-T8HICwxPBeIyJb2Qc, reason: not valid java name */
    public static /* synthetic */ void m868lambda$_gPM73yiDT8HICwxPBeIyJb2Qc(AILabActivity r0, View r1) {
        setupButtonListener$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$dOnBpwa6-Df9up8eDh_vmqtPHPo, reason: not valid java name */
    public static /* synthetic */ Unit m869lambda$dOnBpwa6Df9up8eDh_vmqtPHPo(String r0) {
        return updateSystemInfo$lambda$13(r0);
    }

    public static /* synthetic */ void lambda$toAgOCbXCf5U5Bvgh79_GG0Tl48(String r0, AILabActivity r1) {
        onNetworkError$lambda$4(r0, r1);
    }

    public static /* synthetic */ boolean lambda$yaOcKX3F3N_4GpnWo1N6iVHlJh4(AILabActivity r0, String r1, View r2) {
        return updateSystemInfo$lambda$14(r0, r1, r2);
    }

    private final void observePermissionState() {
        if (this.permissionStateJob == null) goto L5;
        return;
    L5:
        this.permissionStateJob = i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void onAIProactiveAgentButtonClick() {
        OButton r0 = this.aiProactiveAgentBtn;
        int r1 = this.aiProactiveAgentStatus;
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.memory_settings_ai_proactive_agent_title, TypedValues.Custom.S_STRING, "memory_settings_ai_proactive_agent_title"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        onPermissionButtonClick(r0, r1, "ai_proactive_agent", r2);
    }

    private final void onAutoMemoryButtonClick() {
        OButton r0 = this.autoMemoryBtn;
        int r1 = this.autoMemoryStatus;
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.memory_task, TypedValues.Custom.S_STRING, "memory_task"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        onPermissionButtonClick(r0, r1, "auto_memory", r2);
    }

    private static final void onNetworkError$lambda$4(String r8, AILabActivity r9) {
        AILabActivity r10 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r9, AILabActivity.class, "com.obric.memorydata.plugin");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onNetworkError: " + r8, null, 4, null);
        ba.a((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.string.ailab_settings_network_error, TypedValues.Custom.S_STRING, "ailab_settings_network_error"), 0, 4, null);
        r10.updateUIForState(r10.currentPermissionState);
    }

    private final void onPermissionButtonClick(final OButton r8, int r9, final String r10, String r11) {
        Integer r0 = b.f10976a.b(r9);
        if (r0 == null) goto L6;
        submitPermissionRequest(BuildConfig.LIBRARY_PACKAGE_NAME, r10, ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L6:
        Integer r1 = b.f10976a.c(r9);
        if (r1 == null) goto L10;
        final int r12 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue();
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.ailab_settings_stop_title, TypedValues.Custom.S_STRING, "ailab_settings_stop_title"), new Object[]{r11});
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        String r13 = getString(ZeusTransformUtils.mapRes(R.string.ailab_settings_stop_mesg, TypedValues.Custom.S_STRING, "ailab_settings_stop_mesg"), new Object[]{r11});
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        showDialog(r2, r13, new $$Lambda$AILabActivity$YLBGHq5owmOAEVK_nC2rrPdNk(r8), new $$Lambda$AILabActivity$JTv9qmfifcXwHSzNxl71lpkjfA(this, r10, r12));
        return;
    L10:
        if (r8 == null) goto L12;
        r8.setEnabled(b.f10976a.a(r9).b());
    L12:
        RunLog.INSTANCE.debug(TAG, "onPermissionButtonClick: permissionName=" + r10 + " status=" + r9);
    }

    private static final void onPermissionButtonClick$lambda$12$lambda$10(OButton r1, DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        r1.setEnabled(true);
    L5:
        if (r4 == null) goto L8;
        r4.dismiss();
        return;
    }

    private static final void onPermissionButtonClick$lambda$12$lambda$11(AILabActivity r1, String r2, int r3, DialogInterface r4, int r5) {
        AILabActivity r6 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r1, AILabActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        r7.dismiss();
    L5:
        r6.submitPermissionRequest(BuildConfig.LIBRARY_PACKAGE_NAME, r2, r3);
    }

    private static final void onPermissionStatusChanged$lambda$3(int r8, String r9, JSONObject r10, AILabActivity r11) {
        AILabActivity r12 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r11, AILabActivity.class, "com.obric.memorydata.plugin");
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder().append("onPermissionStatusChanged status=").append(r8).append(" message=").append(r9).append(" hasPermissionData=");
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        IRunLog.a.a(r2, TAG, r13.append(r14).append(' ').append(AILabPermissionRepository.f10236a.a((d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), d.class, "com.obric.memorydata.plugin"))).toString(), false, 4, null);
        r12.updateUIForState((d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), d.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r14 = false;
        goto L6
    }

    private final void onScreenMemoryButtonClick() {
        OButton r0 = this.screenMemoryBtn;
        int r1 = this.screenMemoryStatus;
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.ailab_settings_screen_memory, TypedValues.Custom.S_STRING, "ailab_settings_screen_memory"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        onPermissionButtonClick(r0, r1, "screen_memory", r2);
    }

    private final void onVoiceMemoryButtonClick() {
        OButton r0 = this.voiceMemoryBtn;
        int r1 = this.voiceMemoryStatus;
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.ailab_settings_voice_memory, TypedValues.Custom.S_STRING, "ailab_settings_voice_memory"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        onPermissionButtonClick(r0, r1, "voice_memory", r2);
    }

    private final void setupButtonListener() {
        OButton r0 = this.screenMemoryBtn;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new $$Lambda$AILabActivity$OuuQ2f0sLSLIuzM5tjUkYgWbaFQ(this));
    L5:
        OButton r1 = this.voiceMemoryBtn;
        if (r1 == null) goto L8;
        r1.setOnClickListener(new $$Lambda$AILabActivity$_gPM73yiDT8HICwxPBeIyJb2Qc(this));
    L8:
        OButton r2 = this.autoMemoryBtn;
        if (r2 == null) goto L11;
        r2.setOnClickListener(new $$Lambda$AILabActivity$WWcauO3aSmYvuguQQpsHeX4lnpM(this));
    L11:
        OButton r3 = this.aiProactiveAgentBtn;
        if (r3 == null) goto L15;
        r3.setOnClickListener(new $$Lambda$AILabActivity$U9ARpP8pnBw1yEBq8oD7VK09R8E(this));
        return;
    }

    private static final void setupButtonListener$lambda$5(AILabActivity r1, View r2) {
        AILabActivity r3 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r1, AILabActivity.class, "com.obric.memorydata.plugin");
        OButton r4 = r3.screenMemoryBtn;
        if (r4 == null) goto L5;
        r4.setEnabled(false);
    L5:
        r3.onScreenMemoryButtonClick();
    }

    private static final void setupButtonListener$lambda$6(AILabActivity r1, View r2) {
        AILabActivity r3 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r1, AILabActivity.class, "com.obric.memorydata.plugin");
        OButton r4 = r3.voiceMemoryBtn;
        if (r4 == null) goto L5;
        r4.setEnabled(false);
    L5:
        r3.onVoiceMemoryButtonClick();
    }

    private static final void setupButtonListener$lambda$7(AILabActivity r1, View r2) {
        AILabActivity r3 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r1, AILabActivity.class, "com.obric.memorydata.plugin");
        OButton r4 = r3.autoMemoryBtn;
        if (r4 == null) goto L5;
        r4.setEnabled(false);
    L5:
        r3.onAutoMemoryButtonClick();
    }

    private static final void setupButtonListener$lambda$8(AILabActivity r1, View r2) {
        AILabActivity r3 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r1, AILabActivity.class, "com.obric.memorydata.plugin");
        OButton r4 = r3.aiProactiveAgentBtn;
        if (r4 == null) goto L5;
        r4.setEnabled(false);
    L5:
        r3.onAIProactiveAgentButtonClick();
    }

    private final void submitPermissionRequest(String r9, String r10, int r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "submit AILab permission request packageName=" + r9 + " permissionName=" + r10 + " requestType=" + r11, false, 4, null);     // Catch: Exception -> L5
        com.obric.memorydata.memory.lab.a.f10241a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r9, r10, r11);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "submit permission request failed: " + e.getMessage(), null, 4, null);
        updateUIForState(this.currentPermissionState);
    }

    private final void updateSystemInfo() {
        if (AppContext.INSTANCE.isDebug() == true) goto L11;
        TextView r0 = this.systemInfoText;
        if (r0 == null) goto L7;
        ((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
    L7:
        TextView r4 = this.systemInfoText;
        if (r4 == null) goto L21;
        r4.setOnLongClickListener(null);
        return;
    L21:
        return;
    L11:
        TextView r1 = this.systemInfoText;
        if (r1 == null) goto L14;
        ((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin")).setVisibility(0);
    L14:
        final String r2 = "userId: " + AppContext.INSTANCE.getUserId() + "\ndeviceId: " + AppContext.INSTANCE.getOsDeviceId($$Lambda$AILabActivity$dOnBpwa6Df9up8eDh_vmqtPHPo.INSTANCE) + '\n';
        TextView r3 = this.systemInfoText;
        if (r3 == null) goto L17;
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    L17:
        TextView r5 = this.systemInfoText;
        if (r5 == null) goto L22;
        r5.setOnLongClickListener(new $$Lambda$AILabActivity$yaOcKX3F3N_4GpnWo1N6iVHlJh4(this, r2));
        return;
    }

    private static final Unit updateSystemInfo$lambda$13(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final boolean updateSystemInfo$lambda$14(AILabActivity r1, String r2, View r3) {
        AILabActivity r4 = (AILabActivity) ZeusTransformUtils.wrapperContextForParams(r1, AILabActivity.class, "com.obric.memorydata.plugin");
        r4.copyTextToClipboard((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"), r2, "已复制设备信息到剪贴板");
        return true;
    }

    private final void updateUIForState(d r6) {
        RunLog.INSTANCE.debug(TAG, "updateUIForState,state=" + r6);
        int r1 = 8;
        if (r6.b() != null) goto L38;
        OListItemGeneral r7 = this.voiceMemoryItem;
        if (r7 == null) goto L7;
        ((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
    L7:
        OListItemGeneral r8 = this.autoMemoryItem;
        if (r8 == null) goto L10;
        ((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
    L10:
        OListItemGeneral r9 = this.aiProactiveAgentItem;
        if (r9 == null) goto L13;
        ((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
    L13:
        OButton r10 = this.screenMemoryBtn;
        if (r10 == null) goto L16;
        r10.setEnabled(true);
    L16:
        OButton r11 = this.screenMemoryBtn;
        if (r11 == null) goto L19;
        r11.setText(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"));
    L19:
        OButton r12 = this.voiceMemoryBtn;
        if (r12 == null) goto L22;
        r12.setEnabled(true);
    L22:
        OButton r13 = this.voiceMemoryBtn;
        if (r13 == null) goto L25;
        r13.setText(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"));
    L25:
        OButton r14 = this.autoMemoryBtn;
        if (r14 == null) goto L28;
        r14.setEnabled(true);
    L28:
        OButton r15 = this.autoMemoryBtn;
        if (r15 == null) goto L31;
        r15.setText(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"));
    L31:
        OButton r16 = this.aiProactiveAgentBtn;
        if (r16 == null) goto L34;
        r16.setEnabled(true);
    L34:
        OButton r5 = this.aiProactiveAgentBtn;
        if (r5 == null) goto L67;
        r5.setText(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"));
        return;
    L67:
        return;
    L38:
        OListItemGeneral r0 = this.screenMemoryItem;
        if (r0 == null) goto L45;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
        if (r6.d().d() == false) goto L43;
        int r4 = 0;
    L44:
        r2.setVisibility(r4);
        goto L45
    L43:
        r4 = 8;
    L45:
        OListItemGeneral r3 = this.voiceMemoryItem;
        if (r3 == null) goto L52;
        View r17 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        if (r6.e().d() == false) goto L50;
        int r18 = 0;
    L51:
        r17.setVisibility(r18);
        goto L52
    L50:
        r18 = 8;
    L52:
        OListItemGeneral r19 = this.autoMemoryItem;
        if (r19 == null) goto L59;
        View r20 = (View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin");
        if (r6.f().d() == false) goto L57;
        int r21 = 0;
    L58:
        r20.setVisibility(r21);
        goto L59
    L57:
        r21 = 8;
    L59:
        OListItemGeneral r22 = this.aiProactiveAgentItem;
        if (r22 == null) goto L65;
        View r23 = (View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin");
        if (r6.g().d() == false) goto L64;
        r1 = 0;
    L64:
        r23.setVisibility(r1);
    L65:
        int r24 = r6.d().b();
        this.screenMemoryStatus = r24;
        applyButtonState(this.screenMemoryBtn, r24);
        int r25 = r6.e().b();
        this.voiceMemoryStatus = r25;
        applyButtonState(this.voiceMemoryBtn, r25);
        int r26 = r6.f().b();
        this.autoMemoryStatus = r26;
        applyButtonState(this.autoMemoryBtn, r26);
        int r27 = r6.g().b();
        this.aiProactiveAgentStatus = r27;
        applyButtonState(this.aiProactiveAgentBtn, r27);
    }

    public final void copyTextToClipboard(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "textToCopy");
        Object r7 = r3.getSystemService("clipboard");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) ZeusTransformUtils.preCheckCast(r7, ClipboardManager.class, "com.obric.memorydata.plugin")).setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast(AnnotatedPrivateKey.LABEL, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")));
        if (r6 == null) goto L6;
        ba.a(r3, r6, 0, 4, null);
        return;
    }

    @Override // com.obric.memorydata.ui.BaseActivity, com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        ActivityAilabBinding r1 = this.binding;
        if (r1 == null) goto L8;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L7:
        return r1.viewTitle;
    L8:
        return null;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r7) {
        if (ak.f13164a.a() == false) goto L6;
        finish();
        return;
    L6:
        AILabPermissionRepository r8 = AILabPermissionRepository.f10236a;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "getApplicationContext(...)");
        r8.a(r0);
        if (((d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), d.class, "com.obric.memorydata.plugin")).c() == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "AILabActivity is not visible, finish", false, 4, null);
        finish();
        return;
    L10:
        prepareSystemBar();
        ActivityAilabBinding r9 = ActivityAilabBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r9, "inflate(...)");
        this.binding = r9;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L13:
        setContentView((View) ZeusTransformUtils.preCheckCast(r9.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityAilabBinding r10 = this.binding;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L16:
        OScrollView r11 = r10.scrollContent;
        Intrinsics.checkNotNullExpressionValue(r11, "scrollContent");
        g.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        initViews();
        observePermissionState();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        com.obric.memorydata.memory.lab.a.f10241a.a(null);
    }

    @Override // com.obric.memorydata.memory.lab.a.InterfaceC0503a
    public void onNetworkError(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        runOnUiThread(new $$Lambda$AILabActivity$toAgOCbXCf5U5Bvgh79_GG0Tl48(r2, this));
    }

    @Override // com.obric.memorydata.memory.lab.a.InterfaceC0503a
    public void onPermissionStatusChanged(final int r2, final String r3, final JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        runOnUiThread(new $$Lambda$AILabActivity$YFDQZ_nNWxNCg75QxwHr769X4Y(r2, r3, r4, this));
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        initPermissionLogic();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        foreground = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        foreground = false;
        super.onStop();
    }

    public final void showDialog(String r12, String r13, DialogInterface.OnClickListener r14, DialogInterface.OnClickListener r15) {
        DialogInterface.OnClickListener r4 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r16 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r4, "negativeListener");
        Intrinsics.checkNotNullParameter(r16, "positiveListener");
        com.obric.oui.dialog.v2.alert.b r2 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).a(true);
        String r17 = getString(ZeusTransformUtils.mapRes(R.string.ailab_dialog_cancel, TypedValues.Custom.S_STRING, "ailab_dialog_cancel"));
        Intrinsics.checkNotNullExpressionValue(r17, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r5 = com.obric.oui.dialog.v2.alert.b.b(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"), r4, null, 4, null);
        String r11 = getString(ZeusTransformUtils.mapRes(R.string.ailab_dialog_ok, TypedValues.Custom.S_STRING, "ailab_dialog_ok"));
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        com.obric.oui.dialog.v2.alert.b.a(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), r16, null, 4, null).h();
    }
}
