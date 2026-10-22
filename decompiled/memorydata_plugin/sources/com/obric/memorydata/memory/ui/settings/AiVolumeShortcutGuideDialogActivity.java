package com.obric.memorydata.memory.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.constants.Constants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ad;
import com.obric.memorydata.utils.ag;
import com.obric.memorydata.utils.as;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AiVolumeShortcutGuideDialogActivity;", "Landroid/app/Activity;", "<init>", "()V", "actionHandled", "", "currentConsentType", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "guideDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onDestroy", "showGuideDialog", "consentType", "buildDialogContent", "Lcom/obric/memorydata/memory/ui/settings/AiVolumeShortcutGuideDialogActivity$DialogContent;", "buildHighlightedMessage", "Landroid/text/SpannableString;", Params.CONTENT, "cancelCurrentRequest", "parseConsentType", "Companion", "DialogContent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiVolumeShortcutGuideDialogActivity extends GeneratePluginActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11401b;
    private ShortcutMemoryConsentType c;
    private com.obric.oui.dialog.v2.alert.a d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AiVolumeShortcutGuideDialogActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_CONSENT_TYPE", Constants.LAUNCH_TAG, "", "context", "Landroid/content/Context;", "consentType", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3, ShortcutMemoryConsentType r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "consentType");
            Intent r5 = new Intent(r2, AiVolumeShortcutGuideDialogActivity.class).putExtra("shortcut_memory_consent_type", r4.name());
            Intrinsics.checkNotNullExpressionValue(r5, "putExtra(...)");
            r5.setFlags(872415232);
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AiVolumeShortcutGuideDialogActivity$DialogContent;", "", "titleRes", "", "messageRes", "highlightRes", "bannerRes", "<init>", "(IIII)V", "getTitleRes", "()I", "getMessageRes", "getHighlightRes", "getBannerRes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11403b;
        private final int c;
        private final int d;

        public b(int r1, int r2, int r3, int r4) {
            this.f11402a = r1;
            this.f11403b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final int a() {
            return this.f11402a;
        }

        public final int b() {
            return this.f11403b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f11402a == r6.f11402a) goto L12;
            return false;
        L12:
            if (this.f11403b == r6.f11403b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f11402a) * 31) + Integer.hashCode(this.f11403b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "DialogContent(titleRes=" + this.f11402a + ", messageRes=" + this.f11403b + ", highlightRes=" + this.c + ", bannerRes=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/memory/ui/settings/AiVolumeShortcutGuideDialogActivity$buildHighlightedMessage$linkStyle$1", "Lcom/obric/memorydata/utils/OnClickCallback;", "onBefore", "", "keyword", "", "data", "onAfter", "", "success", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements ag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AiVolumeShortcutGuideDialogActivity f11404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortcutMemoryConsentType f11405b;

        c(AiVolumeShortcutGuideDialogActivity r3, ShortcutMemoryConsentType r4) {
            this.f11404a = (AiVolumeShortcutGuideDialogActivity) ZeusTransformUtils.wrapperContextForParams(r3, AiVolumeShortcutGuideDialogActivity.class, "com.obric.memorydata.plugin");
            this.f11405b = r4;
        }

        @Override // com.obric.memorydata.utils.ag
        public void a(String r1, String r2, Exception r3) {
            ag.a.a(this, r1, r2, r3);
        }

        @Override // com.obric.memorydata.utils.ag
        public void a(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "keyword");
            Intrinsics.checkNotNullParameter(r3, "data");
            if (r4 == false) goto L9;
            com.obric.oui.dialog.v2.alert.a r5 = AiVolumeShortcutGuideDialogActivity.a(this.f11404a);
            if (r5 == null) goto L7;
            r5.e();
            return;
        L7:
            this.f11404a.finish();
            return;
        }

        @Override // com.obric.memorydata.utils.ag
        public boolean a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "keyword");
            Intrinsics.checkNotNullParameter(r3, "data");
            AiVolumeShortcutGuideDialogActivity.a(this.f11404a, true);
            com.obric.memorydata.memory.v.f11572a.b(this.f11405b);
            return true;
        }
    }

    static {
        f11400a = new a(null);
    }

    public AiVolumeShortcutGuideDialogActivity() {
    }

    private final SpannableString a(b r16, ShortcutMemoryConsentType r17) {
        String r1 = getString(r16.b());
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        String r3 = getString(r16.c());
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        SpannableString r2 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
        int r4 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), r3, 0, false, 6, null);
        if (r4 >= 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ShortcutMemoryConsent", "highlight text not found in shortcut consent message", null, 4, null);
        return r2;
    L6:
        r2.setSpan(new com.obric.memorydata.utils.p(r3, new ad("", (com.obric.memorydata.utils.e) ZeusTransformUtils.preCheckCast(new as(ActiveMemorySettingsActivity.class, null, 2, null), com.obric.memorydata.utils.e.class, "com.obric.memorydata.plugin"), getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6")), false, (ag) ZeusTransformUtils.preCheckCast(new c(this, r17), ag.class, "com.obric.memorydata.plugin"))), r4, r3.length() + r4, 33);
        return r2;
    }

    private final ShortcutMemoryConsentType a(Intent r6) {
        String r5 = r6.getStringExtra("shortcut_memory_consent_type");
        if (r5 != null) goto L5;
        return null;
    L5:
        ShortcutMemoryConsentType[] r0 = ShortcutMemoryConsentType.values();
        int r1 = 0;
        int r2 = r0.length;
    L6:
        if (r1 >= r2) goto L14;
        ShortcutMemoryConsentType r3 = r0[r1];
        if (Intrinsics.areEqual(r3.name(), r5) == true) goto L11;
        r1 = r1 + 1;
        goto L6
    L11:
        return r3;
    L14:
        return null;
    }

    public static final /* synthetic */ com.obric.oui.dialog.v2.alert.a a(AiVolumeShortcutGuideDialogActivity r2) {
        return ((AiVolumeShortcutGuideDialogActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiVolumeShortcutGuideDialogActivity.class, "com.obric.memorydata.plugin")).d;
    }

    private static final Unit a(AiVolumeShortcutGuideDialogActivity r1, ShortcutMemoryConsentType r2, DialogInterface r3, int r4) {
        AiVolumeShortcutGuideDialogActivity r5 = (AiVolumeShortcutGuideDialogActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiVolumeShortcutGuideDialogActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dialog");
        r5.f11401b = true;
        r6.dismiss();
        com.obric.memorydata.memory.v.f11572a.b(r2);
        return Unit.INSTANCE;
    }

    private final void a() {
        this.f11401b = true;
        ShortcutMemoryConsentType r1 = this.c;
        if (r1 == null) goto L6;
        com.obric.memorydata.memory.v.f11572a.b(r1);
        return;
    }

    private static final void a(AiVolumeShortcutGuideDialogActivity r2, com.obric.oui.dialog.v2.alert.a r3, DialogInterface r4) {
        AiVolumeShortcutGuideDialogActivity r5 = (AiVolumeShortcutGuideDialogActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiVolumeShortcutGuideDialogActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r5.d != r3) goto L6;
        r5.d = null;
        r5.finish();
        return;
    }

    public static final /* synthetic */ void a(AiVolumeShortcutGuideDialogActivity r2, boolean r3) {
        ((AiVolumeShortcutGuideDialogActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiVolumeShortcutGuideDialogActivity.class, "com.obric.memorydata.plugin")).f11401b = r3;
    }

    private final void a(final ShortcutMemoryConsentType r7) {
        b r0 = b(r7);
        final com.obric.oui.dialog.v2.alert.a r8 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(r0.a()), CharSequence.class, "com.obric.memorydata.plugin"), false).d(r0.d()).a(-1, -2).a((CharSequence) ZeusTransformUtils.preCheckCast(a(r0, r7), CharSequence.class, "com.obric.memorydata.plugin")), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.shortcut_guide_cancel, TypedValues.Custom.S_STRING, "shortcut_guide_cancel"), new $$Lambda$AiVolumeShortcutGuideDialogActivity$prXpSD8sVmDsMYLqa9iIJONlY(this, r7)).a(ZeusTransformUtils.mapRes(R.string.shortcut_guide_agree, TypedValues.Custom.S_STRING, "shortcut_guide_agree"), new $$Lambda$AiVolumeShortcutGuideDialogActivity$VczzaZJ6TqUvaiqTPL888AXahTk(this, r7)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        this.d = r8;
        TextView r1 = r8.f();
        if (r1 == null) goto L5;
        r1.setMovementMethod(LinkMovementMethod.getInstance());
    L5:
        r8.setCanceledOnTouchOutside(false);
        r8.setCancelable(false);
        r8.setOnDismissListener(new $$Lambda$AiVolumeShortcutGuideDialogActivity$IWA5xy3uSc1SDzvQ6R9NvCLqWo0(this, r8));
        r8.show();
    }

    private final b b(ShortcutMemoryConsentType r6) {
        if (r6 == ShortcutMemoryConsentType.GESTURE) goto L5;
        String r5 = DeviceInfoState.INSTANCE.getDeviceModel();
        if (com.obric.memorydata.utils.b.b(r5) == false) goto L10;
    L8:
        int r7 = ZeusTransformUtils.mapRes(R.drawable.banner_global_memory_3_n1_v2, "drawable", "banner_global_memory_3_n1_v2");
    L13:
        return new b(ZeusTransformUtils.mapRes(R.string.ai_volume_shortcut_guide_title, TypedValues.Custom.S_STRING, "ai_volume_shortcut_guide_title"), ZeusTransformUtils.mapRes(R.string.ai_volume_shortcut_guide_message, TypedValues.Custom.S_STRING, "ai_volume_shortcut_guide_message"), ZeusTransformUtils.mapRes(R.string.ai_volume_shortcut_guide_message_highlights, TypedValues.Custom.S_STRING, "ai_volume_shortcut_guide_message_highlights"), r7);
    L10:
        if (com.obric.memorydata.utils.b.a(r5) == false) goto L8;
        r7 = ZeusTransformUtils.mapRes(R.drawable.banner_global_memory_3_p_v2, "drawable", "banner_global_memory_3_p_v2");
        goto L13
    L5:
        return new b(ZeusTransformUtils.mapRes(R.string.three_finger_shortcut_guide_title, TypedValues.Custom.S_STRING, "three_finger_shortcut_guide_title"), ZeusTransformUtils.mapRes(R.string.three_finger_shortcut_guide_message, TypedValues.Custom.S_STRING, "three_finger_shortcut_guide_message"), ZeusTransformUtils.mapRes(R.string.three_finger_shortcut_guide_message_highlights, TypedValues.Custom.S_STRING, "three_finger_shortcut_guide_message_highlights"), ZeusTransformUtils.mapRes(R.drawable.bg_active_memory_2, "drawable", "bg_active_memory_2"));
    }

    private static final Unit b(AiVolumeShortcutGuideDialogActivity r1, ShortcutMemoryConsentType r2, DialogInterface r3, int r4) {
        AiVolumeShortcutGuideDialogActivity r5 = (AiVolumeShortcutGuideDialogActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiVolumeShortcutGuideDialogActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dialog");
        r5.f11401b = true;
        r6.dismiss();
        com.obric.memorydata.memory.v.f11572a.a(r2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void lambda$IWA5xy3uSc1SDzvQ6R9NvCLqWo0(AiVolumeShortcutGuideDialogActivity r0, com.obric.oui.dialog.v2.alert.a r1, DialogInterface r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$VczzaZJ6TqUvaiqTPL888AXahTk(AiVolumeShortcutGuideDialogActivity r0, ShortcutMemoryConsentType r1, DialogInterface r2, int r3) {
        return b(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$prX-pSD8sVmDsMY-Lqa9iIJONlY, reason: not valid java name */
    public static /* synthetic */ Unit m968lambda$prXpSD8sVmDsMYLqa9iIJONlY(AiVolumeShortcutGuideDialogActivity r0, ShortcutMemoryConsentType r1, DialogInterface r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    public String getPluginPkgName() {
        return "com.obric.memorydata.plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r7) {
        super/*android.app.Activity*/.onCreate(r7);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window r8 = getWindow();
        r8.getDecorView().setSystemUiVisibility(5888);
        r8.setStatusBarColor(0);
        r8.setNavigationBarColor(0);
        Intent r9 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r9, "getIntent(...)");
        ShortcutMemoryConsentType r10 = a(r9);
        if (r10 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ShortcutMemoryConsent", "missing shortcut consent type", null, 4, null);
        a();
        finish();
        return;
    L6:
        this.c = r10;
        a(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        if (this.f11401b == true) goto L5;
        a();
    L5:
        super/*android.app.Activity*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent r9) {
        Intrinsics.checkNotNullParameter(r9, MemorySourceLinkType.INTENT);
        super/*android.app.Activity*/.onNewIntent(r9);
        setIntent(r9);
        ShortcutMemoryConsentType r10 = a(r9);
        if (r10 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ShortcutMemoryConsent", "ignore shortcut consent intent without valid type", null, 4, null);
        return;
    L6:
        ShortcutMemoryConsentType r1 = v.a(this.c, r10);
        if (r1 != null) goto L9;
        return;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ShortcutMemoryConsent", "replace shortcut consent dialog: " + r1 + " -> " + r10, false, 4, null);
        com.obric.memorydata.memory.v.f11572a.b(r1);
        this.c = r10;
        this.f11401b = false;
        com.obric.oui.dialog.v2.alert.a r0 = this.d;
        this.d = null;
        if (r0 == null) goto L12;
        r0.e();
    L12:
        a(r10);
    }
}
