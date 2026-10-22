package com.obric.oui.toast;

import android.os.Handler;
import android.os.Looper;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 c2\u00020\u0001:\u0003bcdB7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0006\u00103\u001a\u000204J\b\u00105\u001a\u000204H\u0002J\u0006\u00106\u001a\u000204J\b\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u000204H\u0002J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0007J\u0015\u0010>\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u00002\b\u0010B\u001a\u0004\u0018\u00010CJ\u0015\u0010A\u001a\u00020\u00002\b\u0010D\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010EJ\u0015\u0010F\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010EJ\u0010\u0010-\u001a\u00020\u00002\b\u0010H\u001a\u0004\u0018\u00010\u0014J\"\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010M\u001a\u00020\u0007J\u0010\u0010N\u001a\u00020\u00002\b\u0010B\u001a\u0004\u0018\u00010CJ\u0015\u0010N\u001a\u00020\u00002\b\u0010D\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010EJ\u0012\u0010O\u001a\u0002042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010#J\u0010\u0010P\u001a\u0002042\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0010\u0010S\u001a\u0002042\b\u0010T\u001a\u0004\u0018\u00010UJ\u0010\u0010V\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010XJ\u0010\u0010Y\u001a\u0002042\u0006\u0010Z\u001a\u00020[H\u0003J\b\u0010\\\u001a\u000204H\u0002J\u0018\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u0007H\u0002J\u000e\u0010`\u001a\u0004\u0018\u00010#*\u00020\u0014H\u0002J\u000e\u0010a\u001a\u0004\u0018\u00010#*\u00020\u0014H\u0002R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/obric/oui/toast/OToastModal;", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "", "position", "", "includeCutoutInLandscape", "", "style", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Boolean;I)V", "baseMsgMaxWidth", "button", "Lcom/obric/oui/button/OButton;", "getButton", "()Lcom/obric/oui/button/OButton;", "setButton", "(Lcom/obric/oui/button/OButton;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "dismissRunnable", "Ljava/lang/Runnable;", "drawableReservedWidth", "duration", "forceRemoveRunnable", "handler", "Landroid/os/Handler;", "hostAttachListener", "Landroid/view/View$OnAttachStateChangeListener;", "hostParent", "Landroid/view/ViewGroup;", "hostView", "Ljava/lang/Boolean;", "isDismissing", "isFinished", "ivIcon", "Landroid/widget/ImageView;", "msgMaxWidth", "rightAction", "getRightAction", "setRightAction", "toastProgress", "Lcom/obric/oui/progress/ODownloadProgressView;", "tvMsg", "Landroid/widget/TextView;", "verticalWidthSpace", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "dismissWithAnimation", "enableProgressbar", "finishToast", "onToastFinished", "recalculateMsgMaxWidth", "registerHostParent", "parent", "removeHostView", "setDuration", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/toast/OToastModal;", "setLeftDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "res", "(Ljava/lang/Integer;)Lcom/obric/oui/toast/OToastModal;", "setPos", "pos", "action", "setRightButtonAndClickListener", TypedValues.Custom.S_STRING, "listener", "Landroid/view/View$OnClickListener;", "bgColorResId", "setStartDrawable", "show", "showInActivity", "activity", "Landroid/app/Activity;", "showInDialog", "dialog", "Landroid/app/Dialog;", "showInPopupWindow", "popupWindow", "Landroid/widget/PopupWindow;", "showNow", "record", "Lcom/obric/oui/toast/OToastModal$ToastRecord;", "unregisterHostParent", "wrapWithShadowFrame", "view", "yOffset", "findPopupWindowAttachParent", "findPopupWindowParent", "Builder", "Companion", "ToastRecord", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14812a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f14813b = null;
    private static final ArrayDeque<C0789b> c = null;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/toast/OToastModal$Companion;", "", "()V", "FORCE_REMOVE_DELAY_MS", "", "MAX_PACKAGE_TOASTS", "", "TAG", "", "currentToast", "Lcom/obric/oui/toast/OToastModal;", "toastQueue", "Ljava/util/ArrayDeque;", "Lcom/obric/oui/toast/OToastModal$ToastRecord;", "toastQueueHandler", "Landroid/os/Handler;", "builder", "Lcom/obric/oui/toast/OToastModal$Builder;", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "cancelToast", "", "toast", "enqueueToast", "record", "onToastHidden", "resolveLayoutResId", "style", "showNextToastLocked", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.toast.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/toast/OToastModal$ToastRecord;", "", "toast", "Lcom/obric/oui/toast/OToastModal;", "resolveParent", "Lkotlin/Function0;", "Landroid/view/ViewGroup;", "(Lcom/obric/oui/toast/OToastModal;Lkotlin/jvm/functions/Function0;)V", "getResolveParent", "()Lkotlin/jvm/functions/Function0;", "getToast", "()Lcom/obric/oui/toast/OToastModal;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0789b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f14814a;

        public final b a() {
            return this.f14814a;
        }
    }

    static {
        f14812a = new a(null);
        f14813b = new Handler(Looper.getMainLooper());
        c = new ArrayDeque();
    }

    private final ViewGroup a(View r3) {
        if (r3.isAttachedToWindow() == true) goto L5;
        return null;
    L5:
        ViewParent r2 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L8;
        ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin");
    L9:
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.isAttachedToWindow() == false) goto L14;
        return r4;
    L14:
        ViewParent r5 = r4.getParent();
    L16:
        if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L23;
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).isAttachedToWindow() == false) goto L23;
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
    L23:
        r5 = r5.getParent();
        goto L16
    L24:
        return null;
    L8:
        r4 = null;
        goto L9
    }

    public static final /* synthetic */ ViewGroup a(b r0, View r1) {
        return r0.a(r1);
    }
}
