package com.obric.oui.window.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.v2.OSheet;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 O2\u00020\u0001:\u0003OPQB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J8\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00192\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\u0012\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u000100H\u0015J\b\u00101\u001a\u00020\u0013H\u0014J\b\u00102\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u0013H\u0014J\b\u00105\u001a\u00020\u0013H\u0014J\b\u00106\u001a\u00020\u0013H\u0014J\b\u00107\u001a\u00020\u0013H\u0014J\u0018\u00108\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J+\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020!0>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010?J \u0010@\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010A\u001a\u00020\u0013H\u0002J\u0012\u0010B\u001a\u00020\u00132\b\u0010C\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\bJ\u0010\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020KH\u0007J\u0014\u0010L\u001a\u00020\u0013*\u00020M2\b\b\u0002\u0010N\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "contentChild", "Landroid/view/View;", "firstFramePreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "firstFrameReported", "", "firstFrameTargetView", "hasAgreed", "onCreateStartElapsedRealtime", "", "privacySheet", "Lcom/obric/oui/privacy/OPrivacySheet;", "root", "showNetworkConfirm", "useLinkTextAsTitle", "applyClickableSpan", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/text/SpannableStringBuilder;", "span", "Landroid/text/style/ClickableSpan;", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "canFinishSelfInOnCreateIfCallbackNotSet", "clearCallbacksAndFinish", "createClickableSpan", "context", "Landroid/content/Context;", "url", "", "title", "createHeaderView", "createSingleButton", "styleRes", "onClickListener", "Lkotlin/Function1;", "getAppPackageName", "isEdgeToEdge", "logPrivacySheetFirstFrame", "onAgree", "onBackPressed", "onContentChanged", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDisagree", "onPageDismiss", "onPause", "onResume", "onStart", "onStop", "openBrowser", "processMessage", "Landroid/text/SpannableString;", "message", "", "urls", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;Landroid/content/Context;)Landroid/text/SpannableString;", "removeBracePair", "removeFirstFramePreDrawListener", "reportPrivacySheetFirstFrame", "targetView", "setSystemInsetsAppearance", "isLightMode", "shouldApplyJustification", "locale", "Ljava/util/Locale;", "showSheetDialog", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "setSmartJustification", "Landroid/widget/TextView;", "force", "Companion", "LinkClickListener", "PrivacyConsentCallback", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PrivacyStatementActivity extends AppCompatActivity {
    public static final a Companion = null;
    private static final String EXTRA_FLOATING_TRANSITION_ENABLED = "floatingTransitionEnabled";
    private static final String EXTRA__KEY_ACTIVITY_INSTANCE_ID = "PrivacyStatementActivityInstanceId";
    private static final String TAG = "PrivacyStatementActivity";
    private static final Map<String, a.AbstractC0795a> activityCustomizers = null;
    private static int counter;
    private static final Map<String, b> linkClickListeners = null;
    private static final Map<String, c> privacyConsentCallbacks = null;
    private static final Map<String, List<com.obric.oui.privacy.d>> privacyItems = null;
    private static final Map<String, List<String>> privacyPolicyLinkTextsList = null;
    private View contentChild;
    private ViewTreeObserver.OnPreDrawListener firstFramePreDrawListener;
    private boolean firstFrameReported;
    private View firstFrameTargetView;
    private boolean hasAgreed;
    private long onCreateStartElapsedRealtime;
    private com.obric.oui.privacy.a privacySheet;
    private View root;
    private boolean showNetworkConfirm;
    private boolean useLinkTextAsTitle;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion;", "", "()V", "EXTRA_FLOATING_TRANSITION_ENABLED", "", "EXTRA__KEY_ACTIVITY_INSTANCE_ID", "TAG", "activityCustomizers", "", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$ActivityCustomizer;", "counter", "", "linkClickListeners", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$LinkClickListener;", "privacyConsentCallbacks", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "privacyItems", "", "Lcom/obric/oui/privacy/PrivacyItem;", "privacyPolicyLinkTextsList", "activityInstanceId", "ActivityCustomizer", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$ActivityCustomizer;", "", "()V", "modifyStartIntent", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onActivityCreate", "activity", "Landroid/app/Activity;", "onActivityDestroy", "onActivityFinish", "", "onActivityPause", "onActivityResume", "onActivityStart", "onActivityStop", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static abstract class AbstractC0795a {
            public AbstractC0795a() {
            }

            public void a(Activity r2) {
                Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            }

            public void a(Intent r1) {
                Intrinsics.checkNotNullParameter(r1, MemorySourceLinkType.INTENT);
            }

            public void b(Activity r2) {
                Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            }

            public void c(Activity r2) {
                Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            }

            public void d(Activity r2) {
                Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            }

            public void e(Activity r2) {
                Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            }

            public void f(Activity r2) {
                Intrinsics.checkNotNullParameter((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"), "activity");
            }
        }

        @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\tJ\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\tJ\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0014\u00103\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0017J\u0014\u00106\u001a\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u0019\u00109\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\tJ\u000e\u0010=\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010<\u001a\u00020?J\u001a\u0010<\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CJ\u0012\u0010<\u001a\u00020?2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "agreeText", "", "cancelText", "cancelable", "", "customPackageName", "customizedCancelText", "description", "enableDim", "enableEnterAnim", PrivacyStatementActivity.EXTRA_FLOATING_TRANSITION_ENABLED, "forceNightMode", "iconResId", "", "items", "", "Lcom/obric/oui/privacy/PrivacyItem;", "linkClickListener", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$LinkClickListener;", "privacyConsentCallback", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "privacyPolicyLinkTexts", "privacyText", "", "showNetworkConfirm", "title", "urls", "", "[Ljava/lang/String;", "useLinkTextAsTitle", "setAgreeText", "setCancelText", "setCancelable", "setConsentCallback", "callback", "setCustomPackageName", ObricMemoryConstants.KEY_PACKAGE_NAME, "setCustomizedCancelText", "setDescription", "setEnableDim", "enable", "setEnableEnterAnim", "setFloatingTransitionEnabled", "enabled", "setForceNightMode", "setIconResId", "setItems", "setLinkClickListener", "listener", "setPrivacyPolicyLinkTexts", "linkTexts", "setPrivacyText", "setPrivacyUrls", "([Ljava/lang/String;)Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$Builder;", "setShowNetworkConfirmDialog", "show", "setTitle", "setUseLinkTextAsTitle", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "activityCustomizer", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$ActivityCustomizer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Context f14904a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f14905b;
            private String c;
            private String d;
            private String e;
            private CharSequence f;
            private List<String> g;
            private List<? extends com.obric.oui.privacy.d> h;
            private int i;
            private c j;
            private b k;
            private boolean l;
            private String[] m;
            private String n;
            private boolean o;
            private String p;
            private boolean q;
            private boolean r;
            private boolean s;
            private boolean t;
            private boolean u;

            public b(Context r4) {
                Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "context");
                Context r6 = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
                this.f14904a = r6;
                String r7 = r6.getString(ZeusTransformUtils.mapRes(R.string.default_title, TypedValues.Custom.S_STRING, "default_title"));
                Intrinsics.checkNotNullExpressionValue(r7, "context.getString(R.string.default_title)");
                this.f14905b = r7;
                this.g = CollectionsKt.emptyList();
                this.h = CollectionsKt.emptyList();
                this.i = ZeusTransformUtils.mapRes(R.drawable.ic_default_icon, "drawable", "ic_default_icon");
                this.l = true;
                this.m = new String[0];
                this.r = true;
                this.s = true;
            }

            @Deprecated(message = "不支持应用自行设置")
            public final b a(int r4) {
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).i = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
            }

            public final b a(c r4) {
                c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "callback");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).j = r5;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
            }

            public final b a(CharSequence r4) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "privacyText");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f = r5;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
            }

            public final b a(String r4) {
                Intrinsics.checkNotNullParameter(r4, "title");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f14905b = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
            }

            public final b a(String[] r4) {
                Intrinsics.checkNotNullParameter(r4, "urls");
                ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).m = r4;
                return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
            }

            public final void a(Intent r6, AbstractC0795a r7) {
                Intrinsics.checkNotNullParameter(r6, MemorySourceLinkType.INTENT);
                com.obric.oui.c.a.b.b(PrivacyStatementActivity.TAG, "show with intent");
                r6.putExtra("title", this.f14905b);
                r6.putExtra("description", this.c);
                r6.putExtra("cancelText", this.d);
                r6.putExtra("agreeText", this.e);
                r6.putExtra("privacyText", this.f);
                r6.putExtra("iconResId", this.i);
                r6.putExtra("urls", this.m);
                r6.putExtra("showNetworkConfirm", this.l);
                r6.putExtra("useLinkTextAsTitle", this.o);
                r6.putExtra("customPackageName", this.p);
                r6.putExtra("forceNightMode", this.q);
                r6.putExtra("enableDim", this.r);
                r6.putExtra("cancelable", this.s);
                r6.putExtra("enableEnterAnim", this.t);
                r6.putExtra(PrivacyStatementActivity.EXTRA_FLOATING_TRANSITION_ENABLED, this.u);
                String r0 = this.n;
                boolean r2 = true;
                if (r0 != null) goto L6;
            L4:
                r2 = false;
            L10:
                if (r2 == false) goto L12;
                r6.putExtra("customizedCancelText", this.n);
            L12:
                String r1 = a.a(PrivacyStatementActivity.Companion);
                r6.putExtra(PrivacyStatementActivity.EXTRA__KEY_ACTIVITY_INSTANCE_ID, r1);
                if (r7 == null) goto L15;
                PrivacyStatementActivity.access$getActivityCustomizers$cp().put(r1, r7);
                r7.a(r6);
            L15:
                PrivacyStatementActivity.access$getPrivacyItems$cp().put(r1, this.h);
                PrivacyStatementActivity.access$getPrivacyPolicyLinkTextsList$cp().put(r1, this.g);
                PrivacyStatementActivity.access$getPrivacyConsentCallbacks$cp().put(r1, this.j);
                PrivacyStatementActivity.access$getLinkClickListeners$cp().put(r1, this.k);
                ZeusTransformUtils.startActivity(this.f14904a, r6, "com.obric.memorydata.plugin");
                return;
            L6:
                if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
                boolean r3 = true;
            L9:
                if (r3 != true) goto L4;
            L8:
                r3 = false;
                goto L9
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a() {
            StringBuilder r2 = new StringBuilder().append("PrivacyStatementActivity_").append(UUID.randomUUID()).append('_');
            int r0 = PrivacyStatementActivity.access$getCounter$cp();
            PrivacyStatementActivity.access$setCounter$cp(r0 + 1);
            return r2.append(r0).toString();
        }

        public static final /* synthetic */ String a(a r0) {
            return r0.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$LinkClickListener;", "", "onLinkClick", "", "url", "", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(String r1, Context r2);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "", "onAgree", "", "", "activity", "Landroid/app/Activity;", "onCancel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            public static boolean a(c r2, Activity r3) {
                c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
                Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "this");
                Intrinsics.checkNotNullParameter(r5, "activity");
                return false;
            }

            public static boolean b(c r2, Activity r3) {
                c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
                Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "this");
                Intrinsics.checkNotNullParameter(r5, "activity");
                return false;
            }
        }

        @Deprecated(message = "use onAgree(activity: Activity) instead")
        void a();

        boolean a(Activity r1);

        @Deprecated(message = "use onCancel(activity: Activity) instead")
        void b();

        boolean b(Activity r1);
    }

    /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$createSingleButton$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", "width", "", "height", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
        final /* synthetic */ Function1<View, Unit> $onClickListener;
        final /* synthetic */ String $text;

        AnonymousClass1(String r3, Function1<? super View, Unit> r4) {
            Function1<View, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            this.$text = r3;
            this.$onClickListener = r5;
            super(3);
        }

        /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
        private static final void m1398invoke$lambda1$lambda0(Function1 r2, View r3) {
            ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
        }

        public static /* synthetic */ void lambda$BU3hBO8pfy95Ebj72EeaFYz_o9c(Function1 r0, View r1) {
            m1398invoke$lambda1$lambda0(r0, r1);
        }

        public final OButton invoke(Context r10, int r11, int r12) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "styledContext");
            OButton r13 = new OButton(r2, null, 0, 0, null, 28, null);
            String r14 = this.$text;
            final Function1<View, Unit> r9 = this.$onClickListener;
            r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
            r13.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
            if (r9 != null) goto L5;
            View.OnClickListener r15 = null;
        L6:
            r13.setOnClickListener(r15);
            return r13;
        L5:
            r15 = new $$Lambda$PrivacyStatementActivity$createSingleButton$1$BU3hBO8pfy95Ebj72EeaFYz_o9c(r9);
            goto L6
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ OButton invoke(Context r3, Integer r4, Integer r5) {
            return invoke((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/oui/window/permission/PrivacyStatementActivity$createClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f14906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14907b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        d(PrivacyStatementActivity r3, String r4, String r5, Context r6) {
            PrivacyStatementActivity r7 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r3, PrivacyStatementActivity.class, "com.obric.memorydata.plugin");
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            this.f14906a = r7;
            this.f14907b = r4;
            this.c = r5;
            this.d = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r9) {
            Intrinsics.checkNotNullParameter(r9, "widget");
            final b r10 = (b) ZeusTransformUtils.preCheckCast(PrivacyStatementActivity.access$getLinkClickListeners$cp().get(this.f14906a.getIntent().getStringExtra(PrivacyStatementActivity.EXTRA__KEY_ACTIVITY_INSTANCE_ID)), b.class, "com.obric.memorydata.plugin");
            boolean r2 = true;
            if (PrivacyStatementActivity.access$getShowNetworkConfirm$p(this.f14906a) == true) goto L15;
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f14907b, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L7;
        L10:
            if (r2 == true) goto L31;
            if (r10 == null) goto L32;
            r10.a(this.f14907b, (Context) ZeusTransformUtils.preCheckCast(this.f14906a, Context.class, "com.obric.memorydata.plugin"));
            return;
        L32:
            return;
        L31:
            return;
        L7:
            if (r0.length() == 0) goto L10;
            r2 = false;
            goto L10
        L15:
            Unit r4 = null;
            if (PrivacyStatementActivity.access$getHasAgreed$p(this.f14906a) == false) goto L29;
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f14907b, CharSequence.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L20;
        L23:
            if (r2 == true) goto L33;
            if (r10 == null) goto L27;
            r10.a(this.f14907b, (Context) ZeusTransformUtils.preCheckCast(this.f14906a, Context.class, "com.obric.memorydata.plugin"));
            r4 = Unit.INSTANCE;
        L27:
            if (r4 != null) goto L34;
            PrivacyStatementActivity.access$openBrowser(this.f14906a, this.f14907b, this.c);
            return;
        L34:
            return;
        L33:
            return;
        L20:
            if (r1.length() == 0) goto L23;
            r2 = false;
            goto L23
        L29:
            com.obric.oui.dialog.v2.alert.b r3 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this.f14906a, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(this.f14906a.getString(ZeusTransformUtils.mapRes(R.string.privacy_permisssion_dialog_title, TypedValues.Custom.S_STRING, "privacy_permisssion_dialog_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(this.f14906a.getString(ZeusTransformUtils.mapRes(R.string.privacy_permisssion_dialog_message, TypedValues.Custom.S_STRING, "privacy_permisssion_dialog_message")), CharSequence.class, "com.obric.memorydata.plugin"));
            String r5 = this.f14906a.getString(ZeusTransformUtils.mapRes(R.string.oui_agree, TypedValues.Custom.S_STRING, "oui_agree"));
            Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.oui_agree)");
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
            final PrivacyStatementActivity r7 = this.f14906a;
            final String r8 = this.f14907b;
            final String r11 = this.c;
            com.obric.oui.dialog.v2.alert.b r12 = r3.a(r6, (Function2) ZeusTransformUtils.preCheckCast(new PrivacyStatementActivity$createClickableSpan$1$onClick$1(r7, r8, r10, r11), Function2.class, "com.obric.memorydata.plugin"));
            String r13 = this.f14906a.getString(ZeusTransformUtils.mapRes(R.string.oui_cancel_only, TypedValues.Custom.S_STRING, "oui_cancel_only"));
            Intrinsics.checkNotNullExpressionValue(r13, "getString(R.string.oui_cancel_only)");
            ((com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r12.b((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(PrivacyStatementActivity$createClickableSpan$1$onClick$2.INSTANCE, Function2.class, "com.obric.memorydata.plugin")).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin")).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r4) {
            Intrinsics.checkNotNullParameter(r4, "ds");
            super.updateDrawState(r4);
            r4.setColor(ContextCompat.getColor(this.d, ZeusTransformUtils.mapRes(R.color.oui_fill_highlighted, TypedValues.Custom.S_COLOR, "oui_fill_highlighted")));
            r4.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/window/permission/PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f14908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f14909b;

        e(PrivacyStatementActivity r3, View r4) {
            this.f14908a = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r3, PrivacyStatementActivity.class, "com.obric.memorydata.plugin");
            this.f14909b = r4;
        }

        private static final void a(PrivacyStatementActivity r2) {
            PrivacyStatementActivity r3 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this$0");
            PrivacyStatementActivity.access$logPrivacySheetFirstFrame(r3);
        }

        public static /* synthetic */ void lambda$zNK2NC6HY6mg3hrPhOuw4QgSkKc(PrivacyStatementActivity r0) {
            a(r0);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            PrivacyStatementActivity.access$removeFirstFramePreDrawListener(this.f14908a);
            if (PrivacyStatementActivity.access$getFirstFrameReported$p(this.f14908a) == false) goto L5;
            return true;
        L5:
            PrivacyStatementActivity.access$setFirstFrameReported$p(this.f14908a, true);
            View r0 = this.f14909b;
            final PrivacyStatementActivity r3 = this.f14908a;
            r0.post(new $$Lambda$PrivacyStatementActivity$e$zNK2NC6HY6mg3hrPhOuw4QgSkKc(r3));
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/obric/oui/window/permission/PrivacyStatementActivity$showSheetDialog$1", "Lcom/obric/oui/privacy/OPrivacySheetListener;", "onAgreeClicked", "", "onBackPressed", "onDismiss", "onExitClicked", "onPrivacyPolicyClicked", "linkText", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements com.obric.oui.privacy.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f14910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f14911b;
        final /* synthetic */ List<String> c;
        final /* synthetic */ String[] d;
        final /* synthetic */ b e;
        final /* synthetic */ String f;

        f(c r3, PrivacyStatementActivity r4, List<String> r5, String[] r6, b r7, String r8) {
            c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            PrivacyStatementActivity r10 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r4, PrivacyStatementActivity.class, "com.obric.memorydata.plugin");
            List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            b r12 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
            this.f14910a = r9;
            this.f14911b = r10;
            this.c = r11;
            this.d = r6;
            this.e = r12;
            this.f = r8;
        }

        @Override // com.obric.oui.privacy.c
        public void a() {
            c r0 = this.f14910a;
            boolean r1 = false;
            if (r0 != null) goto L6;
        L8:
            if (r1 == true) goto L18;
            c r2 = this.f14910a;
            if (r2 == null) goto L13;
            r2.a();
        L13:
            this.f14911b.onAgree();
            com.obric.oui.privacy.a r6 = PrivacyStatementActivity.access$getPrivacySheet$p(this.f14911b);
            if (r6 == null) goto L19;
            r6.b();
            return;
        L19:
            return;
        L18:
            return;
        L6:
            if (r0.a((Activity) ZeusTransformUtils.preCheckCast(this.f14911b, Activity.class, "com.obric.memorydata.plugin")) != true) goto L8;
            r1 = true;
            goto L8
        }

        @Override // com.obric.oui.privacy.c
        public void a(String r9) {
            Intrinsics.checkNotNullParameter(r9, "linkText");
            boolean r2 = true;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return;
        L8:
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L11;
        L14:
            boolean r3 = true;
        L15:
            if (r3 == false) goto L17;
            return;
        L17:
            final String r10 = this.d[this.c.indexOf(r9)];
            if (PrivacyStatementActivity.access$getShowNetworkConfirm$p(this.f14911b) == true) goto L31;
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L22;
        L25:
            if (r2 == true) goto L48;
            b r5 = this.e;
            if (r5 == null) goto L49;
            Intrinsics.checkNotNullExpressionValue(r10, "url");
            r5.a(r10, (Context) ZeusTransformUtils.preCheckCast(this.f14911b, Context.class, "com.obric.memorydata.plugin"));
            return;
        L49:
            return;
        L48:
            return;
        L22:
            if (r4.length() == 0) goto L25;
            r2 = false;
            goto L25
        L31:
            Unit r6 = null;
            if (PrivacyStatementActivity.access$getHasAgreed$p(this.f14911b) == false) goto L46;
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L36;
        L39:
            if (r2 == true) goto L50;
            b r8 = this.e;
            if (r8 == null) goto L44;
            Intrinsics.checkNotNullExpressionValue(r10, "url");
            r8.a(r10, (Context) ZeusTransformUtils.preCheckCast(this.f14911b, Context.class, "com.obric.memorydata.plugin"));
            r6 = Unit.INSTANCE;
        L44:
            if (r6 != null) goto L51;
            PrivacyStatementActivity r11 = this.f14911b;
            Intrinsics.checkNotNullExpressionValue(r10, "url");
            PrivacyStatementActivity.access$openBrowser(r11, r10, this.f);
            return;
        L51:
            return;
        L50:
            return;
        L36:
            if (r7.length() == 0) goto L39;
            r2 = false;
            goto L39
        L46:
            com.obric.oui.dialog.v2.alert.b r12 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this.f14911b, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(this.f14911b.getString(ZeusTransformUtils.mapRes(R.string.privacy_permisssion_dialog_title, TypedValues.Custom.S_STRING, "privacy_permisssion_dialog_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(this.f14911b.getString(ZeusTransformUtils.mapRes(R.string.privacy_permisssion_dialog_message, TypedValues.Custom.S_STRING, "privacy_permisssion_dialog_message")), CharSequence.class, "com.obric.memorydata.plugin"));
            String r13 = this.f14911b.getString(ZeusTransformUtils.mapRes(R.string.oui_agree, TypedValues.Custom.S_STRING, "oui_agree"));
            Intrinsics.checkNotNullExpressionValue(r13, "getString(R.string.oui_agree)");
            CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
            final PrivacyStatementActivity r15 = this.f14911b;
            final b r16 = this.e;
            final String r17 = this.f;
            com.obric.oui.dialog.v2.alert.b r18 = r12.a(r14, (Function2) ZeusTransformUtils.preCheckCast(new PrivacyStatementActivity$showSheetDialog$1$onPrivacyPolicyClicked$1(r15, r10, r16, r17), Function2.class, "com.obric.memorydata.plugin"));
            String r19 = this.f14911b.getString(ZeusTransformUtils.mapRes(R.string.oui_cancel_only, TypedValues.Custom.S_STRING, "oui_cancel_only"));
            Intrinsics.checkNotNullExpressionValue(r19, "getString(R.string.oui_cancel_only)");
            ((com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r18.b((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(PrivacyStatementActivity$showSheetDialog$1$onPrivacyPolicyClicked$2.INSTANCE, Function2.class, "com.obric.memorydata.plugin")).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin")).show();
            return;
        L11:
            if (r1.isEmpty() == true) goto L14;
            r3 = false;
            goto L15
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.obric.oui.privacy.c
        public void b() {
            c r0 = this.f14910a;
            boolean r1 = false;
            if (r0 != null) goto L6;
        L8:
            if (r1 == true) goto L18;
            c r2 = this.f14910a;
            if (r2 == null) goto L13;
            r2.b();
        L13:
            this.f14911b.onDisagree();
            com.obric.oui.privacy.a r6 = PrivacyStatementActivity.access$getPrivacySheet$p(this.f14911b);
            if (r6 == null) goto L19;
            r6.b();
            return;
        L19:
            return;
        L18:
            return;
        L6:
            if (r0.b((Activity) ZeusTransformUtils.preCheckCast(this.f14911b, Activity.class, "com.obric.memorydata.plugin")) != true) goto L8;
            r1 = true;
            goto L8
        }

        @Override // com.obric.oui.privacy.c
        public void c() {
            com.obric.oui.privacy.c.a.a((com.obric.oui.privacy.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.privacy.c.class, "com.obric.memorydata.plugin"));
            this.f14911b.onPageDismiss();
            PrivacyStatementActivity.access$clearCallbacksAndFinish(this.f14911b);
        }

        @Override // com.obric.oui.privacy.c
        public void d() {
            c r0 = this.f14910a;
            boolean r1 = false;
            if (r0 != null) goto L6;
        L8:
            if (r1 == true) goto L18;
            c r2 = this.f14910a;
            if (r2 == null) goto L13;
            r2.b();
        L13:
            this.f14911b.onDisagree();
            com.obric.oui.privacy.a r6 = PrivacyStatementActivity.access$getPrivacySheet$p(this.f14911b);
            if (r6 == null) goto L19;
            r6.b();
            return;
        L19:
            return;
        L18:
            return;
        L6:
            if (r0.b((Activity) ZeusTransformUtils.preCheckCast(this.f14911b, Activity.class, "com.obric.memorydata.plugin")) != true) goto L8;
            r1 = true;
            goto L8
        }
    }

    static {
        Companion = new a(null);
        privacyConsentCallbacks = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        linkClickListeners = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        activityCustomizers = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        privacyPolicyLinkTextsList = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        privacyItems = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public PrivacyStatementActivity() {
        this.showNetworkConfirm = true;
    }

    public static final /* synthetic */ void access$clearCallbacksAndFinish(PrivacyStatementActivity r2) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).clearCallbacksAndFinish();
    }

    public static final /* synthetic */ Map access$getActivityCustomizers$cp() {
        return activityCustomizers;
    }

    public static final /* synthetic */ int access$getCounter$cp() {
        return counter;
    }

    public static final /* synthetic */ boolean access$getFirstFrameReported$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).firstFrameReported;
    }

    public static final /* synthetic */ boolean access$getHasAgreed$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).hasAgreed;
    }

    public static final /* synthetic */ Map access$getLinkClickListeners$cp() {
        return linkClickListeners;
    }

    public static final /* synthetic */ Map access$getPrivacyConsentCallbacks$cp() {
        return privacyConsentCallbacks;
    }

    public static final /* synthetic */ Map access$getPrivacyItems$cp() {
        return privacyItems;
    }

    public static final /* synthetic */ Map access$getPrivacyPolicyLinkTextsList$cp() {
        return privacyPolicyLinkTextsList;
    }

    public static final /* synthetic */ com.obric.oui.privacy.a access$getPrivacySheet$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).privacySheet;
    }

    public static final /* synthetic */ boolean access$getShowNetworkConfirm$p(PrivacyStatementActivity r2) {
        return ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).showNetworkConfirm;
    }

    public static final /* synthetic */ void access$logPrivacySheetFirstFrame(PrivacyStatementActivity r2) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).logPrivacySheetFirstFrame();
    }

    public static final /* synthetic */ void access$openBrowser(PrivacyStatementActivity r2, String r3, String r4) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).openBrowser(r3, r4);
    }

    public static final /* synthetic */ void access$removeFirstFramePreDrawListener(PrivacyStatementActivity r2) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).removeFirstFramePreDrawListener();
    }

    public static final /* synthetic */ void access$setCounter$cp(int r0) {
        counter = r0;
    }

    public static final /* synthetic */ void access$setFirstFrameReported$p(PrivacyStatementActivity r2, boolean r3) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).firstFrameReported = r3;
    }

    public static final /* synthetic */ void access$setHasAgreed$p(PrivacyStatementActivity r2, boolean r3) {
        ((PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin")).hasAgreed = r3;
    }

    private final void applyClickableSpan(SpannableStringBuilder r1, ClickableSpan r2, int r3, int r4) {
        r1.setSpan(r2, r3, r4, 33);
    }

    private final void clearCallbacksAndFinish() {
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L6;
        privacyConsentCallbacks.remove(r0);
        linkClickListeners.remove(r0);
        privacyPolicyLinkTextsList.remove(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(privacyItems.remove(r0), List.class, "com.obric.memorydata.plugin");
    L6:
        finish();
    }

    private final ClickableSpan createClickableSpan(Context r3, String r4, String r5) {
        return (ClickableSpan) ZeusTransformUtils.preCheckCast(new d(this, r4, r5, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")), ClickableSpan.class, "com.obric.memorydata.plugin");
    }

    private final View createHeaderView(Context r4) {
        View r3 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.layout_privacy_statement_header, "layout", "layout_privacy_statement_header"), null, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "headerView");
        return r3;
    }

    private final View createSingleButton(Context r2, String r3, int r4, Function1<? super View, Unit> r5) {
        return com.obric.oui.c.e.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r4, (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin")), Function3.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ View createSingleButton$default(PrivacyStatementActivity r2, Context r3, String r4, int r5, Function1 r6, int r7, Object r8) {
        PrivacyStatementActivity r9 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<? super View, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L10;
        if ((r7 & 8) == 0) goto L8;
        r11 = null;
    L8:
        return r9.createSingleButton(r10, r4, r5, r11);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSingleButton");
    }

    private final String getAppPackageName() {
        String r0 = getIntent().getStringExtra("customPackageName");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r3 = getPackageName();
        Intrinsics.checkNotNullExpressionValue(r3, "{\n            packageName\n        }");
        return r3;
    L11:
        com.obric.oui.c.a.b.d(TAG, Intrinsics.stringPlus("using custom packageName: ", r0));
        return r0;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final boolean isEdgeToEdge() {
        View r1 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(r1, "window.decorView");
        return !r1.getFitsSystemWindows();
    }

    public static /* synthetic */ WindowInsetsCompat lambda$z7ZCz95iUUxU2cfFMTCvvZKMW2o(View r0, WindowInsetsCompat r1) {
        return m1397onContentChanged$lambda5$lambda4(r0, r1);
    }

    private final void logPrivacySheetFirstFrame() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = r0 - this.onCreateStartElapsedRealtime;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        long r6 = Process.getStartElapsedRealtime();
        StringBuilder r11 = new StringBuilder().append("PrivacyStatementActivity first frame, processStartToPrivacyFirstFrameMs=");
        StringBuilder r12 = r11.append(r0 - r6).append(", activityCreateToFirstFrameMs=").append(r2).append(", processStartElapsedRealtime=").append(r6);
    L6:
        Log.i(TAG, r12.append(", firstFrameElapsedRealtime=").append(r0).toString());
        return;
    L5:
        r12 = new StringBuilder().append("PrivacyStatementActivity first frame, processStartToPrivacyFirstFrameMs=unsupported, activityCreateToFirstFrameMs=").append(r2);
        goto L6
    }

    /* JADX INFO: renamed from: onContentChanged$lambda-5$lambda-4, reason: not valid java name */
    private static final WindowInsetsCompat m1397onContentChanged$lambda5$lambda4(View r4, WindowInsetsCompat r5) {
        int r0 = r5.getSystemWindowInsetTop();
        r5.getSystemWindowInsetBottom();
        Intrinsics.checkNotNullExpressionValue(r4, BaseSwitches.V);
        r4.setPadding(r4.getPaddingLeft(), r0, r4.getPaddingRight(), 0);
        return r5;
    }

    private final void openBrowser(String r4, String r5) {
        WebViewActivity.open((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r4, r5, getIntent().getBooleanExtra(EXTRA_FLOATING_TRANSITION_ENABLED, false));
    }

    private final SpannableString processMessage(CharSequence r13, String[] r14, Context r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Context r17 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        String r0 = r16.toString();
        int r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), "{", 0, false, 6, null);
        int r3 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), "}", 0, false, 6, null);
        int r4 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), "{", 0, false, 6, null);
        int r5 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), "}", 0, false, 6, null);
        String r7 = "this as java.lang.String…ing(startIndex, endIndex)";
        if (this.useLinkTextAsTitle == false) goto L8;
        if (r2 == (-1)) goto L8;
        if (r3 == (-1)) goto L8;
        if (r2 >= r3) goto L8;
        String r6 = r0.substring(r2 + 1, r3);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        if (this.useLinkTextAsTitle == false) goto L15;
        if (r4 == (-1)) goto L15;
        if (r5 == (-1)) goto L15;
        if (r4 >= r5) goto L15;
        String r8 = r0.substring(r4 + 1, r5);
    L16:
        Intrinsics.checkNotNullExpressionValue(r8, r7);
        ClickableSpan r9 = createClickableSpan(r17, (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r14, 0), String.class, "com.obric.memorydata.plugin"), r6);
        ClickableSpan r18 = createClickableSpan(r17, (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r14, 1), String.class, "com.obric.memorydata.plugin"), r8);
        SpannableStringBuilder r19 = new SpannableStringBuilder(r16);
        if (r2 == (-1)) goto L38;
        if (r3 == (-1)) goto L38;
        if (r4 == (-1)) goto L38;
        if (r5 == (-1)) goto L38;
        if (r2 != r4) goto L30;
        if (r3 != r5) goto L30;
        if (removeBracePair(r19, r2, r3) == true) goto L28;
        com.obric.oui.c.a.b.d(TAG, "processMessage single marker invalid, start=" + r2 + ", end=" + r3 + ", length=" + r19.length());
        return new SpannableString(r16);
    L28:
        applyClickableSpan(r19, r9, r2, r3 - 1);
    L40:
        return new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"));
    L30:
        if (removeBracePair(r19, r4, r5) == true) goto L34;
        com.obric.oui.c.a.b.d(TAG, "processMessage user marker invalid, start=" + r4 + ", end=" + r5 + ", length=" + r19.length());
        return new SpannableString(r16);
    L34:
        if (removeBracePair(r19, r2, r3) == true) goto L37;
        com.obric.oui.c.a.b.d(TAG, "processMessage privacy marker invalid, start=" + r2 + ", end=" + r3 + ", length=" + r19.length());
        return new SpannableString(r16);
    L37:
        applyClickableSpan(r19, r9, r2, r3 - 1);
        applyClickableSpan(r19, r18, r4 - 2, r5 - 3);
    L38:
        com.obric.oui.c.a.b.d(TAG, Intrinsics.stringPlus("processMessage marker not find, text=", r0));
    L15:
        r8 = getString(ZeusTransformUtils.mapRes(R.string.title_user_agreement, TypedValues.Custom.S_STRING, "title_user_agreement"));
        r7 = "{\n                getStr…_agreement)\n            }";
    L8:
        r6 = getString(ZeusTransformUtils.mapRes(R.string.title_privacy_policy, TypedValues.Custom.S_STRING, "title_privacy_policy"));
        Intrinsics.checkNotNullExpressionValue(r6, "{\n                getStr…acy_policy)\n            }");
        goto L10
    }

    private final boolean removeBracePair(SpannableStringBuilder r1, int r2, int r3) {
        if (r2 < 0) goto L10;
        if (r3 < 0) goto L12;
        if (r2 < r3) goto L6;
        return false;
    L6:
        if (r3 >= r1.length()) goto L14;
        r1.delete(r3, r3 + 1);
        r1.delete(r2, r2 + 1);
        return true;
    L14:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    private final void removeFirstFramePreDrawListener() {
        ViewTreeObserver.OnPreDrawListener r0 = this.firstFramePreDrawListener;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.firstFrameTargetView;
        if (r1 == null) goto L14;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L14;
        if (r2.isAlive() == false) goto L14;
        r2.removeOnPreDrawListener(r0);
    L14:
        this.firstFrameTargetView = null;
        this.firstFramePreDrawListener = null;
    }

    private final void reportPrivacySheetFirstFrame(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.firstFrameReported == true) goto L9;
        removeFirstFramePreDrawListener();
        this.firstFrameTargetView = r4;
        e r0 = new e(this, r4);
        this.firstFramePreDrawListener = (ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(r0, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin");
        r4.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(r0, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        return;
    }

    public static /* synthetic */ void setSmartJustification$default(PrivacyStatementActivity r2, TextView r3, boolean r4, int r5, Object r6) {
        PrivacyStatementActivity r7 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 1) == 0) goto L7;
        r4 = false;
    L7:
        r7.setSmartJustification(r3, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSmartJustification");
    }

    private final boolean shouldApplyJustification(Locale r1) {
        return !Intrinsics.areEqual(r1.getLanguage(), Locale.ENGLISH.getLanguage());
    }

    public boolean canFinishSelfInOnCreateIfCallbackNotSet() {
        return true;
    }

    public void onAgree() {
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        c r0 = (c) ZeusTransformUtils.preCheckCast(privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), c.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == true) goto L14;
        if (r0 == null) goto L12;
        r0.b();
    L12:
        onDisagree();
        return;
    L14:
        return;
    L6:
        if (r0.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin")) != true) goto L8;
        r1 = true;
        goto L8
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public void onContentChanged() {
        super.onContentChanged();
        this.contentChild = ((ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(android.R.id.content), ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(0);
        if (isEdgeToEdge() == false) goto L9;
        View r3 = this.contentChild;
        if (r3 == null) goto L10;
        ViewCompat.setOnApplyWindowInsetsListener(r3, $$Lambda$PrivacyStatementActivity$z7ZCz95iUUxU2cfFMTCvvZKMW2o.INSTANCE);
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r11) {
        this.onCreateStartElapsedRealtime = SystemClock.elapsedRealtime();
        if (getDelegate().getLocalNightMode() != 2) goto L5;
        boolean r0 = true;
    L7:
        if ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L9;
        boolean r5 = true;
    L10:
        com.obric.oui.c.a.b.b(TAG, Intrinsics.stringPlus("onCreate savedInstanceState: ", r11));
        com.obric.oui.c.a.b.b(TAG, Intrinsics.stringPlus("onCreate delegate.localNightMode: ", Integer.valueOf(getDelegate().getLocalNightMode())));
        com.obric.oui.c.a.b.b(TAG, Intrinsics.stringPlus("onCreate isLocalInNightMode: ", Boolean.valueOf(r0)));
        com.obric.oui.c.a.b.b(TAG, Intrinsics.stringPlus("onCreate isConfigNightMode: ", Boolean.valueOf(r5)));
        boolean r1 = getIntent().getBooleanExtra("forceNightMode", false);
        com.obric.oui.c.a.b.b(TAG, Intrinsics.stringPlus("onCreate forceNightMode: ", Boolean.valueOf(r1)));
        if (r5 == true) goto L14;
        if (r1 == false) goto L14;
        boolean r6 = true;
    L15:
        if (r11 != null) goto L18;
        if (r1 == false) goto L18;
        getIntent().putExtra("forceNightMode", false);
        getDelegate().setLocalNightMode(2);
    L18:
        super.onCreate(r11);
        if (r11 != null) goto L21;
    L25:
        getWindow().setWindowAnimations(0);
        overridePendingTransition(0, 0);
        String r2 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r2 == null) goto L33;
        a.AbstractC0795a r3 = (a.AbstractC0795a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r2), a.AbstractC0795a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L33;
        r3.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    L33:
        if (canFinishSelfInOnCreateIfCallbackNotSet() == false) goto L39;
        if (r11 == null) goto L39;
        com.obric.oui.c.a.b.d(TAG, "onCreate, savedInstanceState is not null");
        if (((c) ZeusTransformUtils.preCheckCast(privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), c.class, "com.obric.memorydata.plugin")) != null) goto L38;
        com.obric.oui.c.a.b.d(TAG, "privacyConsentCallbacks is null, finish");
    L23:
        finish();
        return;
    L38:
        com.obric.oui.c.a.b.c(TAG, "privacyConsentCallbacks is not null");
    L39:
        Window r12 = getWindow();
        r12.clearFlags(1024);
        r12.setBackgroundDrawableResource(android.R.color.transparent);
        r12.getAttributes().format = -2;
        this.showNetworkConfirm = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.useLinkTextAsTitle = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        this.root = r12.getDecorView().getRootView();
        if (r6 == true) goto L43;
        Intent r13 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r13, MemorySourceLinkType.INTENT);
        showSheetDialog(r13);
        getIntent().putExtra("finishShowSheet", true);
        return;
    L43:
        return;
    L21:
        if (getIntent().getBooleanExtra("finishShowSheet", false) == false) goto L25;
        com.obric.oui.c.a.b.b(TAG, "onCreate -> finish when savedInstanceState is not null and finishShowSheet is true");
    L14:
        r6 = false;
        goto L15
    L9:
        r5 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        com.obric.oui.c.a.b.b(TAG, "onDestroy");
        removeFirstFramePreDrawListener();
        View r1 = this.root;
        if (r1 != null) goto L27;
    L8:
        View r2 = this.contentChild;
        if (r2 != null) goto L29;
    L14:
        com.obric.oui.privacy.a r0 = this.privacySheet;
        if (r0 == null) goto L18;
        r0.c();
    L18:
        this.root = null;
        this.contentChild = null;
        this.privacySheet = null;
        super.onDestroy();
        String r3 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r3 == null) goto L31;
        Map<String, a.AbstractC0795a> r4 = activityCustomizers;
        a.AbstractC0795a r5 = (a.AbstractC0795a) ZeusTransformUtils.preCheckCast(r4.get(r3), a.AbstractC0795a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L25;
        r5.f((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    L25:
        a.AbstractC0795a r6 = (a.AbstractC0795a) ZeusTransformUtils.preCheckCast(r4.remove(r3), a.AbstractC0795a.class, "com.obric.memorydata.plugin");
        return;
    L31:
        return;
    L29:
        ViewCompat.setOnApplyWindowInsetsListener(r2, null);     // Catch: Exception -> L13
    L13:
        com.obric.oui.c.a.b.e(TAG, "removing contentChild WindowInsets listener failed");
        goto L14
    L27:
        r1.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L7
    L7:
        com.obric.oui.c.a.b.e(TAG, "removing root WindowInsets listener failed");
        goto L8
    }

    public void onDisagree() {
    }

    public void onPageDismiss() {
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC0795a r1 = (a.AbstractC0795a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC0795a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.d((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC0795a r1 = (a.AbstractC0795a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC0795a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC0795a r1 = (a.AbstractC0795a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC0795a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        a.AbstractC0795a r1 = (a.AbstractC0795a) ZeusTransformUtils.preCheckCast(activityCustomizers.get(r0), a.AbstractC0795a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.e((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        return;
    }

    public final void setSmartJustification(TextView r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Build.VERSION.SDK_INT < 29) goto L12;
        if (r4 == true) goto L9;
        Locale r5 = r3.getTextLocale();
        Intrinsics.checkNotNullExpressionValue(r5, "this.textLocale");
        if (shouldApplyJustification(r5) == true) goto L9;
        int r2 = 0;
    L10:
        r3.setJustificationMode(r2);
        return;
    L9:
        r2 = 1;
        goto L10
    }

    public final void setSystemInsetsAppearance(boolean r5) {
        Window r2 = null;
        if (Build.VERSION.SDK_INT < 23) goto L11;
        com.obric.oui.privacy.a r4 = this.privacySheet;
        if (r4 == null) goto L13;
        OSheet r6 = r4.d();
        if (r6 == null) goto L13;
        r2 = r6.getWindow();
    L13:
        if (Build.VERSION.SDK_INT < 30) goto L35;
        int r7 = 0;
        if (r2 == null) goto L25;
        WindowInsetsController r0 = r2.getInsetsController();
        if (r0 == null) goto L25;
        if (r5 == false) goto L23;
        int r3 = 8;
    L24:
        r0.setSystemBarsAppearance(r3, 8);
        goto L25
    L23:
        r3 = 0;
    L25:
        if (r2 == null) goto L46;
        WindowInsetsController r1 = r2.getInsetsController();
        if (r1 != null) goto L31;
        return;
    L31:
        if (r5 == false) goto L33;
        r7 = 16;
    L33:
        r1.setSystemBarsAppearance(r7, 16);
        return;
    L46:
        return;
    L35:
        if (Build.VERSION.SDK_INT < 23) goto L45;
        if (r2 == null) goto L48;
        View r8 = r2.getDecorView();
        if (r5 == false) goto L41;
        int r9 = r2.getDecorView().getSystemUiVisibility() | 8192;
    L42:
        r8.setSystemUiVisibility(r9);
        return;
    L41:
        r9 = r2.getDecorView().getSystemUiVisibility() & (-8193);
        goto L42
    L48:
        return;
    L45:
        return;
    L11:
        r2 = (Window) ZeusTransformUtils.preCheckCast(null, Window.class, "com.obric.memorydata.plugin");
        goto L13
    }

    public final void showSheetDialog(Intent r24) {
        Intrinsics.checkNotNullParameter(r24, MemorySourceLinkType.INTENT);
        String r1 = r24.getStringExtra("title");
        if (r1 != null) goto L5;
        r1 = getString(ZeusTransformUtils.mapRes(R.string.default_title, TypedValues.Custom.S_STRING, "default_title"));
    L5:
        String r6 = r1;
        Intrinsics.checkNotNullExpressionValue(r6, "intent.getStringExtra(\"t…g(R.string.default_title)");
        String r11 = r24.getStringExtra("description");
        String r16 = r24.getStringExtra("cancelText");
        String r15 = r24.getStringExtra("agreeText");
        CharSequence r2 = r24.getCharSequenceExtra("privacyText");
        String[] r3 = r24.getStringArrayExtra("urls");
        if (r3 != null) goto L8;
        r3 = new String[0];
    L8:
        String[] r4 = r3;
        boolean r17 = r24.getBooleanExtra("enableDim", true);
        boolean r18 = r24.getBooleanExtra("cancelable", true);
        boolean r19 = r24.getBooleanExtra("enableEnterAnim", false);
        c r5 = (c) ZeusTransformUtils.preCheckCast(privacyConsentCallbacks.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), c.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(privacyItems.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), List.class, "com.obric.memorydata.plugin");
        List r20 = (List) ZeusTransformUtils.preCheckCast(privacyPolicyLinkTextsList.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), List.class, "com.obric.memorydata.plugin");
        b r21 = (b) ZeusTransformUtils.preCheckCast(linkClickListeners.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)), b.class, "com.obric.memorydata.plugin");
        String r9 = getAppPackageName();
        if (r7 != null) goto L11;
        List r12 = CollectionsKt.emptyList();
    L12:
        View r22 = null;
        if (r2 != null) goto L15;
        String r13 = null;
    L16:
        if (r20 != null) goto L18;
        List r8 = CollectionsKt.emptyList();
    L19:
        com.obric.oui.privacy.a r0 = new com.obric.oui.privacy.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new com.obric.oui.privacy.b(r9, r6, r11, r12, r13, r8, r15, r16, r17, r18, r19)).a((com.obric.oui.privacy.c) ZeusTransformUtils.preCheckCast(new f(r5, this, r20, r4, r21, r6), com.obric.oui.privacy.c.class, "com.obric.memorydata.plugin")).a();
        this.privacySheet = r0;
        if (r0 == null) goto L29;
        OSheet r10 = r0.d();
        if (r10 == null) goto L29;
        Window r14 = r10.getWindow();
        if (r14 == null) goto L29;
        r22 = r14.getDecorView();
    L29:
        reportPrivacySheetFirstFrame(r22);
        return;
    L18:
        r8 = r20;
        goto L19
    L15:
        r13 = r2.toString();
        goto L16
    L11:
        r12 = r7;
        goto L12
    }
}
