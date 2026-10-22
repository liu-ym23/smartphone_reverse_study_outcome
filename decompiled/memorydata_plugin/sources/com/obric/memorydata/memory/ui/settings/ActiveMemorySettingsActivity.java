package com.obric.memorydata.memory.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.databinding.ActivityActiveMemorySettingsBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.ThemeCardCorners;
import com.obric.memorydata.utils.ar;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0014J\b\u0010\u0011\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ActiveMemorySettingsActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityActiveMemorySettingsBinding;", "activeKeyMemorySwitchCheckListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "activeGestureMemorySwitchCheckListener", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "onBackPressed", "initViews", "onResumeChecked", "refreshCardBackgrounds", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActiveMemorySettingsActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private static final String TAG = "ActiveMemorySettingsActivity";
    private final CompoundButton.OnCheckedChangeListener activeGestureMemorySwitchCheckListener;
    private final CompoundButton.OnCheckedChangeListener activeKeyMemorySwitchCheckListener;
    private ActivityActiveMemorySettingsBinding binding;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ActiveMemorySettingsActivity$Companion;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            ZeusTransformUtils.startActivity(r2, new Intent(r2, ActiveMemorySettingsActivity.class), "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.ActiveMemorySettingsActivity$initViews$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object r8) {
            super(0, r8, ActiveMemorySettingsActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ActiveMemorySettingsActivity) ZeusTransformUtils.preCheckCast(this.receiver, ActiveMemorySettingsActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    static {
        Companion = new a(null);
    }

    public ActiveMemorySettingsActivity() {
        this.activeKeyMemorySwitchCheckListener = new $$Lambda$ActiveMemorySettingsActivity$88ff6oARICyZLaG9EGnlZ8k5DQ(this);
        this.activeGestureMemorySwitchCheckListener = new $$Lambda$ActiveMemorySettingsActivity$the2P6rQDoVGtK2YsHtXBH9PUE(this);
    }

    private static final void activeGestureMemorySwitchCheckListener$lambda$1(ActiveMemorySettingsActivity r1, CompoundButton r2, boolean r3) {
        if (Settings.System.putInt(((ActiveMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, ActiveMemorySettingsActivity.class, "com.obric.memorydata.plugin")).getContentResolver(), ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_GESTURE_ENABLED, r3 ? 1 : 0) == false) goto L6;
        com.obric.memorydata.memory.tracker.f.f10542a.a();
        return;
    }

    private static final void activeKeyMemorySwitchCheckListener$lambda$0(ActiveMemorySettingsActivity r1, CompoundButton r2, boolean r3) {
        if (Settings.System.putInt(((ActiveMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, ActiveMemorySettingsActivity.class, "com.obric.memorydata.plugin")).getContentResolver(), ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_KEY_ENABLED, r3 ? 1 : 0) == false) goto L6;
        com.obric.memorydata.memory.tracker.f.f10542a.a();
        return;
    }

    private final void initViews() {
        ActivityActiveMemorySettingsBinding r0 = this.binding;
        ActivityActiveMemorySettingsBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r2 = r0.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r2, "viewTitle");
        ActivityActiveMemorySettingsBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.activeMemorySettingsContainer, View.class, "com.obric.memorydata.plugin");
        boolean r8 = true;
        int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        ActivityActiveMemorySettingsBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        setupTitleBarBackAction(r2, r5, r6, r7.cutOff);
        ActivityActiveMemorySettingsBinding r3 = this.binding;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L14:
        OFloatingTitleBar r9 = r3.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r9, "viewTitle");
        com.obric.memorydata.ui.custom.a.a(r9, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function0.class, "com.obric.memorydata.plugin"));
        ActivityActiveMemorySettingsBinding r10 = this.binding;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L17:
        OFloatingTitleBar r11 = r10.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r11, "viewTitle");
        registerFloatingTitleBar(r11);
        refreshCardBackgrounds();
        boolean r12 = ar.b();
        String r13 = DeviceInfoState.INSTANCE.getDeviceModel();
        boolean r14 = com.obric.memorydata.utils.b.a(r13);
        boolean r15 = com.obric.memorydata.utils.b.b(r13);
        if (r12 == false) goto L23;
        ActivityActiveMemorySettingsBinding r16 = this.binding;
        if (r16 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L22:
        r16.activeKeyMemory.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_settings_active_memory_key_v2, TypedValues.Custom.S_STRING, "memory_settings_active_memory_key_v2")), CharSequence.class, "com.obric.memorydata.plugin"));
    L23:
        ActivityActiveMemorySettingsBinding r17 = this.binding;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L26:
        OSwitch r18 = r17.activeKeyMemory.getEndSwitch();
        if (r18 != null) goto L29;
    L33:
        ActivityActiveMemorySettingsBinding r19 = this.binding;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L36:
        OSwitch r20 = r19.activeGestureMemory.getEndSwitch();
        if (r20 == null) goto L44;
        if (Settings.System.getInt(getContentResolver(), ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_GESTURE_ENABLED, 1) == 1) goto L42;
        r8 = false;
    L42:
        r20.setChecked(r8);
        r20.setOnCheckedChangeListener(this.activeGestureMemorySwitchCheckListener);
    L44:
        if (Intrinsics.areEqual(r13, "Genesis-R") == false) goto L62;
        ActivityActiveMemorySettingsBinding r21 = this.binding;
        if (r21 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L48:
        r21.llActiveMemory1.setVisibility(8);
        ActivityActiveMemorySettingsBinding r22 = this.binding;
        if (r22 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L51:
        r22.activeKeyMemory.setVisibility(8);
        ActivityActiveMemorySettingsBinding r23 = this.binding;
        if (r23 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L54:
        r23.llActiveMemory4.setVisibility(8);
        ActivityActiveMemorySettingsBinding r24 = this.binding;
        if (r24 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L57:
        r24.activeTextMemory.setVisibility(8);
        ActivityActiveMemorySettingsBinding r110 = this.binding;
        if (r110 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L61:
        ImageView r111 = r1.ivActiveMemory3;
        int r25 = ZeusTransformUtils.mapRes(R.drawable.bg_active_memory_3_gr, "drawable", "bg_active_memory_3_gr");
    L82:
        r111.setImageResource(r25);
        return;
    L60:
        r1 = r110;
        goto L61
    L62:
        String r26 = "bg_active_memory_1_n1_v2";
        if (r12 == false) goto L67;
        if (r15 == false) goto L67;
    L65:
        int r27 = R.drawable.bg_active_memory_1_n1_v2;
    L66:
        r25 = ZeusTransformUtils.mapRes(r27, "drawable", r26);
    L77:
        ActivityActiveMemorySettingsBinding r112 = this.binding;
        if (r112 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L81:
        r111 = r1.ivActiveMemory1;
        goto L82
    L80:
        r1 = r112;
    L67:
        if (r12 == false) goto L70;
        if (r14 == false) goto L70;
        r27 = R.drawable.bg_active_memory_1_p_v2;
        r26 = "bg_active_memory_1_p_v2";
    L70:
        if (r12 == true) goto L65;
        if (r15 == false) goto L75;
    L74:
        r25 = ZeusTransformUtils.mapRes(R.drawable.bg_active_memory_1_n1, "drawable", "bg_active_memory_1_n1");
        goto L77
    L75:
        if (r14 == false) goto L74;
        r27 = R.drawable.bg_active_memory_1_p;
        r26 = "bg_active_memory_1_p";
        goto L66
    L29:
        if (Settings.System.getInt(getContentResolver(), ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_KEY_ENABLED, 1) != 1) goto L31;
        boolean r28 = true;
    L32:
        r18.setChecked(r28);
        r18.setOnCheckedChangeListener(this.activeKeyMemorySwitchCheckListener);
        goto L33
    L31:
        r28 = false;
        goto L32
    }

    /* JADX INFO: renamed from: lambda$88ff6oARICyZL-aG9EGnlZ8k5DQ, reason: not valid java name */
    public static /* synthetic */ void m966lambda$88ff6oARICyZLaG9EGnlZ8k5DQ(ActiveMemorySettingsActivity r0, CompoundButton r1, boolean r2) {
        activeKeyMemorySwitchCheckListener$lambda$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$the2P-6rQDoVGtK2YsHtXBH9PUE, reason: not valid java name */
    public static /* synthetic */ void m967lambda$the2P6rQDoVGtK2YsHtXBH9PUE(ActiveMemorySettingsActivity r0, CompoundButton r1, boolean r2) {
        activeGestureMemorySwitchCheckListener$lambda$1(r0, r1, r2);
    }

    private final void refreshCardBackgrounds() {
        ConstraintLayout[] r0 = new ConstraintLayout[4];
        ActivityActiveMemorySettingsBinding r1 = this.binding;
        ActivityActiveMemorySettingsBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r0[0] = r1.llActiveMemory1;
        ActivityActiveMemorySettingsBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        r0[1] = r4.llActiveMemory2;
        ActivityActiveMemorySettingsBinding r5 = this.binding;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L11:
        r0[2] = r5.llActiveMemory3;
        ActivityActiveMemorySettingsBinding r8 = this.binding;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r0[3] = r2.llActiveMemory4;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        ConstraintLayout r3 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r9.next(), ConstraintLayout.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        com.obric.memorydata.ui.custom.c.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), 0.0f, ThemeCardCorners.TOP, 0, 5, null);
        goto L17
    L19:
        return;
    L14:
        r2 = r8;
        goto L15
    }

    public void finish() {
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r5) {
        prepareSystemBar();
        ActivityActiveMemorySettingsBinding r6 = ActivityActiveMemorySettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityActiveMemorySettingsBinding r7 = this.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        ONestedScrollView r8 = r7.activeMemorySettingsContainer;
        Intrinsics.checkNotNullExpressionValue(r8, "activeMemorySettingsContainer");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        initViews();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        refreshCardBackgrounds();
    }
}
