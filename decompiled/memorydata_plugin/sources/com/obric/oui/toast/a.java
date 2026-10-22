package com.obric.oui.toast;

import android.app.Activity;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.c.c;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.k;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.j;
import com.obric.oui.common.util.m;
import com.obric.oui.common.util.o;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0003FGHBA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0002J\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u00020&H\u0002J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\tJ\u0015\u0010.\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u000103J\u0015\u00101\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00105J\u0015\u00106\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00105J\u0010\u0010!\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u00010\u0015J\"\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001a\u00020\u0007J\u0010\u0010>\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u000103J\u0015\u0010>\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00105J\u0010\u0010?\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010AJ\u0015\u0010B\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00105J\u0006\u0010D\u001a\u00020&J\b\u0010E\u001a\u00020&H\u0002R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/toast/OToast;", "", "mContext", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "", "position", "", "forceUseAddViewToast", "", "includeCutoutInLandscape", "style", "(Landroid/content/Context;Ljava/lang/String;IZLjava/lang/Boolean;I)V", "baseMsgMaxWidth", "button", "Lcom/obric/oui/button/OButton;", "getButton", "()Lcom/obric/oui/button/OButton;", "setButton", "(Lcom/obric/oui/button/OButton;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "drawableReservedWidth", "Ljava/lang/Boolean;", "mTN", "Lcom/obric/oui/toast/OToast$TN;", "msgMaxWidth", "rightAction", "getRightAction", "setRightAction", "systemToast", "Landroid/widget/Toast;", "verticalWidthSpace", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "cancelNow", "enableProgressbar", "recalculateMsgMaxWidth", "setDuration", "duration", "setEnableTouch", "enable", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/toast/OToast;", "setLeftDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "res", "(Ljava/lang/Integer;)Lcom/obric/oui/toast/OToast;", "setPos", "pos", "action", "setRightButtonAndClickListener", TypedValues.Custom.S_STRING, "listener", "Landroid/view/View$OnClickListener;", "bgColorResId", "setStartDrawable", "setWindowToken", "token", "Landroid/os/IBinder;", "setWindowType", "type", "show", "showNow", "Companion", "OutlineProvider", "TN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0786a f14807a = null;
    private static final String q = null;
    private static WeakReference<a> r;
    private static final Handler s = null;
    private static final ArrayDeque<a> t = null;
    private static a u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14808b;
    private final String c;
    private int d;
    private final boolean e;
    private Boolean f;
    private int g;
    private View h;
    private final b i;
    private Toast j;
    private final int k;
    private final int l;
    private final int m;
    private int n;
    private View o;
    private OButton p;

    /* JADX INFO: renamed from: com.obric.oui.toast.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002JM\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0002\u0010)JC\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0002\u0010*J;\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\b\b\u0002\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0002\u0010,J*\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\b\b\u0002\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u0004J<\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\b\b\u0002\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u0004J2\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\b\b\u0002\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u0004J1\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0002\u0010-JC\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0002\u0010.J \u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u0004J2\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u0004J9\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0002\u0010/J(\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u0004J\u001a\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u0004H\u0007JM\u00100\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u001aH\u0002J;\u00103\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/oui/toast/OToast$Companion;", "", "()V", "DURATION_LONG", "", "DURATION_SHORT", "MAX_PACKAGE_TOASTS", "MAX_WIDTH_RATIO", "", "SNACKBAR_DURATION", "STYLE_DARK", "STYLE_DAY_NIGHT", "STYLE_LIGHT", "TAG", "", "getTAG", "()Ljava/lang/String;", "currentToast", "Lcom/obric/oui/toast/OToast;", "toastQueue", "Ljava/util/ArrayDeque;", "toastQueueHandler", "Landroid/os/Handler;", "toastRef", "Ljava/lang/ref/WeakReference;", "cancelToast", "", "toast", "enqueueToast", "onToastHidden", "show", "context", "Landroid/app/Activity;", "style", NotificationCompat.CATEGORY_MESSAGE, "includeCutoutInLandscape", "", "drawable", "rightAction", "Landroid/view/View;", "pos", "(Landroid/app/Activity;ILjava/lang/String;Ljava/lang/Boolean;ILandroid/view/View;I)V", "(Landroid/app/Activity;ILjava/lang/String;ILjava/lang/Boolean;I)V", "Landroid/content/Context;", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/Boolean;I)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;I)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;ILandroid/view/View;I)V", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Boolean;I)V", "showIconToast", "(Landroid/content/Context;Ljava/lang/String;ILandroid/view/View;ILjava/lang/Boolean;I)V", "showNextToastLocked", "showTextToast", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0786a {
        private C0786a() {
        }

        public /* synthetic */ C0786a(DefaultConstructorMarker r1) {
            this();
        }

        private final void a(Context r10, String r11, int r12, Boolean r13, int r14) {
            a r9 = new a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), r11, r12, false, r13, r14, 8, null);
            C0786a r15 = a.f14807a;
            a.a(new WeakReference(r9));
            r9.d();
        }

        public static /* synthetic */ void a(C0786a r1, Context r2, String r3, int r4, int r5, Object r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if ((r5 & 4) == 0) goto L5;
            r4 = 80;
        L5:
            r1.a(r7, r3, r4);
        }

        static /* synthetic */ void a(C0786a r6, Context r7, String r8, int r9, Boolean r10, int r11, int r12, Object r13) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            if ((r12 & 8) == 0) goto L5;
            r10 = null;
        L5:
            Boolean r4 = r10;
            if ((r12 & 16) == 0) goto L8;
            r11 = 0;
        L8:
            r6.a(r1, r8, r9, r4, r11);
        }

        public static final /* synthetic */ void a(C0786a r0, a r1) {
            r0.a(r1);
        }

        private final void a(final a r2) {
            a.f().post(new $$Lambda$a$a$hLKujp1G_lQIQS0SVKQ6Mp46ZQ8(r2));
        }

        private final void b() {
            if (a.g() == null) goto L5;
            return;
        L5:
            a r2 = (a) ZeusTransformUtils.preCheckCast(a.h().poll(), a.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L8;
            return;
        L8:
            a.a(r2);
            a.b(r2);
        }

        public static final /* synthetic */ void b(C0786a r0, a r1) {
            r0.b(r1);
        }

        private final void b(final a r2) {
            a.f().post(new $$Lambda$a$a$PC0nbMjw0l6iU8SCcdF7AGf4E(r2));
        }

        private static final void c(a r3) {
            Intrinsics.checkNotNullParameter(r3, "$toast");
            if (a.g() != r3) goto L5;
            return;
        L5:
            if (a.h().contains(r3) == true) goto L18;
            int r0 = a.h().size();
            if (a.g() != null) goto L10;
            int r1 = 0;
        L11:
            int r2 = r0 + r1;
            if (r2 < 50) goto L15;
            com.obric.oui.c.a.b.d(a.f14807a.a(), "Package has already queued " + r2 + " toasts. Not showing more.");
            return;
        L15:
            a.h().offer(r3);
            a.f14807a.b();
            return;
        L10:
            r1 = 1;
            goto L11
        }

        private static final void d(a r1) {
            Intrinsics.checkNotNullParameter(r1, "$toast");
            if (a.g() != r1) goto L5;
            C0786a r2 = a.f14807a;
            a.a(null);
            a.f14807a.b();
            return;
        L5:
            a.h().remove(r1);
        }

        /* JADX INFO: renamed from: lambda$PC-0nbMjw0l-6iU8SCcdF7AGf4E, reason: not valid java name */
        public static /* synthetic */ void m1396lambda$PC0nbMjw0l6iU8SCcdF7AGf4E(a r0) {
            d(r0);
        }

        public static /* synthetic */ void lambda$hLKujp1G_lQIQS0SVKQ6Mp46ZQ8(a r0) {
            c(r0);
        }

        public final String a() {
            return a.e();
        }

        public final void a(Context r9, String r10, int r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
            a(this, r1, r10, r11, null, 0, 24, null);
        }
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010U\u001a\u00020PJ\b\u0010V\u001a\u00020PH\u0002J\u0010\u0010W\u001a\u00020P2\u0006\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u00020PH\u0002J\u0006\u0010[\u001a\u00020PJ\u0006\u0010\\\u001a\u00020PJ\"\u0010]\u001a\u00020)2\b\u0010^\u001a\u0004\u0018\u00010\u000b2\u0006\u0010_\u001a\u00020)2\u0006\u0010`\u001a\u00020\u0011H\u0003R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'R\u001c\u00103\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010+\"\u0004\b5\u0010-R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0013\"\u0004\bJ\u0010\u0015R\u001a\u0010K\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0013\"\u0004\bM\u0010\u0015R\"\u0010N\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006b"}, d2 = {"Lcom/obric/oui/toast/OToast$TN;", "", "()V", "includeCutoutInLandscape", "", "getIncludeCutoutInLandscape", "()Ljava/lang/Boolean;", "setIncludeCutoutInLandscape", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mDuration", "", "getMDuration", "()I", "setMDuration", "(I)V", "mEnableTouch", "getMEnableTouch", "()Z", "setMEnableTouch", "(Z)V", "mGravity", "getMGravity", "setMGravity", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHorizontalMargin", "", "getMHorizontalMargin", "()F", "setMHorizontalMargin", "(F)V", "mNextView", "Landroid/view/View;", "getMNextView", "()Landroid/view/View;", "setMNextView", "(Landroid/view/View;)V", "mParams", "Landroid/view/WindowManager$LayoutParams;", "mVerticalMargin", "getMVerticalMargin", "setMVerticalMargin", "mView", "getMView", "setMView", "mWM", "Landroid/view/WindowManager;", "getMWM", "()Landroid/view/WindowManager;", "setMWM", "(Landroid/view/WindowManager;)V", "mWindowToken", "Landroid/os/IBinder;", "getMWindowToken", "()Landroid/os/IBinder;", "setMWindowToken", "(Landroid/os/IBinder;)V", "mWindowType", "getMWindowType", "()Ljava/lang/Integer;", "setMWindowType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mX", "getMX", "setMX", "mY", "getMY", "setMY", "onHidden", "Lkotlin/Function0;", "", "getOnHidden", "()Lkotlin/jvm/functions/Function0;", "setOnHidden", "(Lkotlin/jvm/functions/Function0;)V", "clearPendingMessages", "handleHide", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "handleShow", "hide", "show", "wrapWithShadowFrame", "context", "view", "yOffset", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0787a f14809a = null;
        private static final int s = 0;
        private static final int t = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WindowManager.LayoutParams f14810b;
        private Boolean c;
        private final Handler d;
        private int e;
        private int f;
        private int g;
        private float h;
        private float i;
        private int j;
        private View k;
        private View l;
        private Context m;
        private IBinder n;
        private Integer o;
        private WindowManager p;
        private boolean q;
        private Function0<Unit> r;

        /* JADX INFO: renamed from: com.obric.oui.toast.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/toast/OToast$TN$Companion;", "", "()V", "MSG_HIDE", "", "MSG_SHOW", "getResId", "type", "", ActivityLifecycle.NAME, "ToastHandler", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class C0787a {

            /* JADX INFO: renamed from: com.obric.oui.toast.a$b$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/toast/OToast$TN$Companion$ToastHandler;", "Landroid/os/Handler;", "tn", "Lcom/obric/oui/toast/OToast$TN;", "(Lcom/obric/oui/toast/OToast$TN;)V", "mTn", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            private static final class HandlerC0788a extends Handler {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final b f14811a;

                public HandlerC0788a(b r2) {
                    Intrinsics.checkNotNullParameter(r2, "tn");
                    super(Looper.getMainLooper());
                    this.f14811a = r2;
                }

                @Override // android.os.Handler
                public void handleMessage(Message r4) {
                    Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
                    Log.v(a.f14807a.a(), "handleMessage " + r4.what + ' ' + this.f14811a);
                    b.a(this.f14811a, r4);
                }
            }

            private C0787a() {
            }

            public /* synthetic */ C0787a(DefaultConstructorMarker r1) {
                this();
            }

            public final int a(String r1, String r2) {
                Intrinsics.checkNotNullParameter(r1, "type");
                return ZeusTransformUtils.forName(Intrinsics.stringPlus("com.android.internal.R$", r1), "com.obric.memorydata.plugin").getField(r2).getInt(null);
            L5:
                e = move-exception;
                e.printStackTrace();
                return 0;
            }
        }

        static {
            f14809a = new C0787a(null);
            s = 1;
            t = 2;
        }

        public b() {
            WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
            this.f14810b = r0;
            this.d = (Handler) ZeusTransformUtils.preCheckCast(new C0787a.HandlerC0788a(this), Handler.class, "com.obric.memorydata.plugin");
            this.j = 2000;
            this.q = true;
            r0.height = -2;
            r0.width = -2;
            r0.format = -3;
            r0.windowAnimations = f14809a.a("style", "Animation_Toast");
            r0.type = 2;
            r0.flags = 168;
            r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast("ObricCustomToast", CharSequence.class, "com.obric.memorydata.plugin"));
        }

        private final View a(Context r12, View r13, int r14) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L5;
            return r13;
        L5:
            c r15 = c.f13403a;
            if (r13 != null) goto L9;
        L7:
            View r1 = null;
        L11:
            ToastBackgroundView r2 = (ToastBackgroundView) ZeusTransformUtils.preCheckCast(r1, ToastBackgroundView.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L14;
            int r3 = 24;
        L15:
            View r4 = ZeusTransformUtils.inflate(LayoutInflater.from(r11), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), null, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
            SingleChildFrameLayout r5 = (SingleChildFrameLayout) ZeusTransformUtils.preCheckCast(r4, SingleChildFrameLayout.class, "com.obric.memorydata.plugin");
            r5.addView(r13, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            r5.setShadowCornerRadius(r3);
            List<k> r16 = f.a(r11, "oui_shadow_thick");
            if (r16 != null) goto L18;
            int r6 = 0;
        L33:
            SingleChildFrameLayout r17 = new SingleChildFrameLayout(r11, null, 2, null);
            r17.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            View r18 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
            FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
            r19.gravity = 1;
            Unit r7 = Unit.INSTANCE;
            r17.addView(r18, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            r17.setClipChildren(false);
            r17.setClipToPadding(false);
            r17.setPadding(0, r6, 0, r14);
            return (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin");
        L18:
            Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            r6 = 0;
            int r8 = 0;
            int r9 = 0;
            int r10 = 0;
        L20:
            if (r110.hasNext() == false) goto L33;
            k r20 = (k) ZeusTransformUtils.preCheckCast(r110.next(), k.class, "com.obric.memorydata.plugin");
            if ((r20.b() - r20.c()) <= r8) goto L25;
            r8 = MathKt.roundToInt(r20.b() - r20.c());
        L25:
            if ((r20.b() + r20.c()) <= r9) goto L28;
            r9 = MathKt.roundToInt(r20.b() + r20.c());
        L28:
            if ((r20.b() - r20.d()) <= r6) goto L31;
            r6 = MathKt.roundToInt(r20.b() - r20.d());
        L31:
            if ((r20.b() + r20.d()) <= r10) goto L20;
            r10 = MathKt.roundToInt(r20.b() + r20.d());
            goto L20
        L14:
            r3 = r2.getCornerRadius();
            goto L15
        L9:
            if (ZeusTransformUtils.instanceOf(r13, ToastBackgroundView.class) == false) goto L7;
            r1 = r13;
            goto L11
        }

        private final void a(Message r2) {
            int r3 = r2.what;
            if (r3 != s) goto L6;
            d();
            return;
        L6:
            if (r3 != t) goto L13;
            e();
            this.l = null;
            this.m = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
            this.p = null;
            this.n = null;
            Function0<Unit> r0 = this.r;
            this.r = null;
            if (r0 == null) goto L14;
            r0.invoke();
            return;
        L14:
            return;
        }

        public static final /* synthetic */ void a(b r0, Message r1) {
            r0.a(r1);
        }

        private final void d() {
            Log.v(a.f14807a.a(), "HANDLE SHOW: " + this + " mView=" + this.k + " mNextView=" + this.l);
            e();
            Context r0 = this.m;
            if (r0 != null) goto L5;
            Activity r1 = null;
        L6:
            Context r2 = this.m;
            View r3 = this.l;
            Intrinsics.checkNotNull(r3);
            View r4 = a(r2, r3, this.g);
            this.k = r4;
            Intrinsics.checkNotNull(r4);
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            View r6 = this.k;
            Intrinsics.checkNotNull(r6);
            String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
            if (r5 != null) goto L9;
            View r8 = this.k;
            Intrinsics.checkNotNull(r8);
            r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        L9:
            Intrinsics.checkNotNull(r5);
            Object r9 = r5.getSystemService("window");
            Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.WindowManager");
            this.p = (WindowManager) ZeusTransformUtils.preCheckCast(r9, WindowManager.class, "com.obric.memorydata.plugin");
            View r10 = this.k;
            Intrinsics.checkNotNull(r10);
            int r11 = Gravity.getAbsoluteGravity(this.e, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().getLayoutDirection());
            this.f14810b.gravity = r11;
            if ((r11 & 7) != 7) goto L13;
            this.f14810b.horizontalWeight = 1.0f;
        L13:
            if ((r11 & 112) != 112) goto L15;
            this.f14810b.verticalWeight = 1.0f;
        L15:
            this.f14810b.x = this.f;
            this.f14810b.y = this.g;
            this.f14810b.verticalMargin = this.i;
            this.f14810b.horizontalMargin = this.h;
            Integer r12 = this.o;
            if (r12 == null) goto L20;
            this.f14810b.type = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue();
        L20:
            if (this.q == true) goto L22;
            this.f14810b.flags |= 16;
        L22:
            com.obric.oui.window.a.a(r5, this.f14810b, this.c);
            this.f14810b.y = 0;
            this.f14810b.width = -1;
            if (r1 == null) goto L26;
            WindowManager.LayoutParams r13 = this.f14810b;
            IBinder r14 = ZeusTransformUtils.getWindow(r1, "com.obric.memorydata.plugin").getAttributes().token;
        L25:
            r13.token = r14;
        L29:
            this.f14810b.packageName = r7;
            View r15 = this.k;
            Intrinsics.checkNotNull(r15);
            if (r15.getParent() == null) goto L32;
            Log.v(a.f14807a.a(), "REMOVE! " + this.k + " in " + this);
            WindowManager r16 = this.p;
            Intrinsics.checkNotNull(r16);
            r16.removeView(this.k);
        L32:
            Log.v(a.f14807a.a(), "ADD! " + this.k + " in " + this);
            WindowManager r17 = this.p;     // Catch: Exception -> L35
            Intrinsics.checkNotNull(r17);     // Catch: Exception -> L35
            r17.addView(this.k, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(this.f14810b, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L35
            return;
        L35:
            e = move-exception;
            e.printStackTrace();
            return;
        L26:
            r14 = this.n;
            if (r14 == null) goto L29;
            r13 = this.f14810b;
            goto L25
        L5:
            r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.oui.window.a.f14878a.getActivity(r0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
            goto L6
        }

        private final void e() {
            Log.v(a.f14807a.a(), "handleHide " + this.k + " in " + this);
            if (this.k == null) goto L15;
            String r0 = a.f14807a.a();
            View r1 = this.k;
            Intrinsics.checkNotNull(r1);
            Log.v(r0, Intrinsics.stringPlus("handleHide parent ", r1.getParent()));
            View r2 = this.k;
            Intrinsics.checkNotNull(r2);
            if (r2.getParent() == null) goto L11;
            Log.v(a.f14807a.a(), "REMOVE! " + this.k + " in " + this);
            WindowManager r3 = this.p;     // Catch: Exception -> L9
            Intrinsics.checkNotNull(r3);     // Catch: Exception -> L9
            r3.removeView(this.k);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
        L11:
            this.k = null;
            return;
        }

        public final Handler a() {
            return this.d;
        }

        public final void a(int r1) {
            this.e = r1;
        }

        public final void a(Context r3) {
            this.m = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        public final void a(View r1) {
            this.l = r1;
        }

        public final void a(Boolean r1) {
            this.c = r1;
        }

        public final void a(Function0<Unit> r3) {
            this.r = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        public final int b() {
            return this.j;
        }

        public final void b(int r1) {
            this.g = r1;
        }

        public final void c() {
            Log.v(a.f14807a.a(), Intrinsics.stringPlus("SHOW: ", this));
            Handler r0 = this.d;
            int r1 = s;
            r0.removeMessages(r1);
            Handler r2 = this.d;
            int r3 = t;
            r2.removeMessages(r3);
            this.d.sendEmptyMessage(r1);
            this.d.sendEmptyMessageDelayed(r3, this.j);
        }
    }

    static {
        f14807a = new C0786a(null);
        q = "OToast";
        r = new WeakReference(null);
        s = new Handler(Looper.getMainLooper());
        t = new ArrayDeque();
    }

    public a(Context r3, String r4, int r5, boolean r6, Boolean r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "mContext");
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Context r10 = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.f14808b = r10;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        b r11 = new b();
        this.i = r11;
        int r12 = h.a(r10, 73);
        this.k = r12;
        this.l = h.a(r10, 28);
        if (j.f13505a.a(r10) == true) goto L5;
        int r13 = h.a(r10) - r12;
    L6:
        this.m = r13;
        this.n = r13;
        LayoutInflater r14 = LayoutInflater.from(r10);
        int r15 = this.g;
        if (r15 != 0) goto L9;
        int r16 = R.layout.o_toast;
        String r17 = "o_toast";
    L13:
        View r18 = ZeusTransformUtils.inflate(r14, ZeusTransformUtils.mapRes(r16, "layout", r17), null, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r18, "from(mContext)\n        .…   }\n            }, null)");
        this.o = r18;
        if (this.d == 80) goto L16;
        this.d = 80;
        com.obric.oui.c.a.b.d(q, "custom position is not supported! position " + this.d + '!');
    L16:
        r11.b(96);
        r11.a(this.d);
        ((TextView) ZeusTransformUtils.preCheckCast(this.o.findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, OaidModel.KEY_ID, "tv_msg")), TextView.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        View r19 = this.o.findViewById(ZeusTransformUtils.mapRes(R.id.right_button, OaidModel.KEY_ID, "right_button"));
        Intrinsics.checkNotNullExpressionValue(r19, "contentView.findViewById(R.id.right_button)");
        this.p = (OButton) ZeusTransformUtils.preCheckCast(r19, OButton.class, "com.obric.memorydata.plugin");
        i();
        return;
    L9:
        if (r15 == 2) goto L11;
        r16 = R.layout.o_toast_light;
        r17 = "o_toast_light";
        goto L13
    L11:
        r16 = R.layout.o_toast_dark;
        r17 = "o_toast_dark";
        goto L13
    L5:
        r13 = h.a(r10, 288);
        goto L6
    }

    public /* synthetic */ a(Context r8, String r9, int r10, boolean r11, Boolean r12, int r13, int r14, DefaultConstructorMarker r15) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if ((r14 & 4) == 0) goto L5;
        r10 = 80;
    L5:
        int r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        boolean r4 = false;
    L10:
        if ((r14 & 16) == 0) goto L12;
        r12 = null;
    L12:
        Boolean r5 = r12;
        if ((r14 & 32) == 0) goto L15;
        int r6 = 0;
    L16:
        this(r1, r9, r3, r4, r5, r6);
        return;
    L15:
        r6 = r13;
        goto L16
    L8:
        r4 = r11;
        goto L10
    }

    public static final /* synthetic */ void a(a r0) {
        u = r0;
    }

    public static final /* synthetic */ void a(WeakReference r0) {
        r = r0;
    }

    public static final /* synthetic */ void b(a r0) {
        r0.j();
    }

    private static final void c(a r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        C0786a.b(f14807a, r1);
    }

    public static final /* synthetic */ String e() {
        return q;
    }

    public static final /* synthetic */ Handler f() {
        return s;
    }

    public static final /* synthetic */ a g() {
        return u;
    }

    public static final /* synthetic */ ArrayDeque h() {
        return t;
    }

    private final void i() {
        View r0 = this.o.findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon"));
        Intrinsics.checkNotNullExpressionValue(r0, "contentView.findViewById<ImageView>(R.id.iv_icon)");
        if (o.e(r0) == false) goto L8;
        View r1 = this.o.findViewById(ZeusTransformUtils.mapRes(R.id.toast_progress, OaidModel.KEY_ID, "toast_progress"));
        Intrinsics.checkNotNullExpressionValue(r1, "contentView.findViewById…iew>(R.id.toast_progress)");
        if (o.e(r1) == false) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == false) goto L11;
        int r3 = this.m - this.l;
    L12:
        this.n = r3;
        ((TextView) ZeusTransformUtils.preCheckCast(this.o.findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, OaidModel.KEY_ID, "tv_msg")), TextView.class, "com.obric.memorydata.plugin")).setMaxWidth(this.n);
        return;
    L11:
        r3 = this.m;
    L8:
        r2 = true;
        goto L9
    }

    private final void j() {
    L43:
        e = move-exception;
        String r4 = e.getMessage();
        String r5 = "Try DeadObjectException occur, ";
        Object r3 = e;
    L47:
        m.a(Intrinsics.stringPlus(r5, r4));
        Exception r1 = (Exception) ZeusTransformUtils.preCheckCast(r3, Exception.class, "com.obric.memorydata.plugin");
        m.a(Intrinsics.stringPlus(q, ", showAsDropDown exception occur, try showAtLocation"));
        C0786a.b(f14807a, this);
        Boolean.valueOf(true);
        return;
    L45:
        e = move-exception;
        r4 = e.getMessage();
        r5 = "Try runtimeException occur, ";
        r3 = e;
        goto L47
    L4:
        if (this.g == 0) goto L6;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L9;
    L18:
        Log.d(q, "show toast by ocean");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        int r7 = this.d;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r7 != 17) goto L21;
    L24:
        int r8 = 0;
    L29:
        if (a() == null) goto L31;
        ((LinearLayout) ZeusTransformUtils.preCheckCast(b().findViewById(ZeusTransformUtils.mapRes(R.id.toast_root, OaidModel.KEY_ID, "toast_root")), LinearLayout.class, "com.obric.memorydata.plugin")).addView(a());     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L31:
        ((TextView) ZeusTransformUtils.preCheckCast(b().findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, OaidModel.KEY_ID, "tv_msg")), TextView.class, "com.obric.memorydata.plugin")).setMaxWidth(this.n);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        b().measure(0, 0);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        c r9 = c.f13403a;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        View r10 = b();     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r10 != null) goto L35;
    L33:
        r10 = null;
    L36:
        ToastBackgroundView r11 = (ToastBackgroundView) ZeusTransformUtils.preCheckCast(r10, ToastBackgroundView.class, "com.obric.memorydata.plugin");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r11 == null) goto L40;
        ToastBackgroundView.a(r11, b().getMeasuredHeight(), 0, null, 6, null);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L40:
        b r12 = this.i;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.a(b());     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.a(this.f14808b);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.a(this.d);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.b(r8);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.a(this.f);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.a((Function0) ZeusTransformUtils.preCheckCast(new OToast$showNow$1$3(this), Function0.class, "com.obric.memorydata.plugin"));     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.c();     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L41:
        Unit r13 = Unit.INSTANCE;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L51:
        return;
    L35:
        if (ZeusTransformUtils.instanceOf(r10, ToastBackgroundView.class) == false) goto L33;
    L21:
        if (r7 != 48) goto L23;
        r8 = h.a(this.f14808b, 20);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        goto L29
    L23:
        if (r7 != 80) goto L24;
        r8 = h.a(this.f14808b, 96);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        goto L29
    L9:
        if (this.e == true) goto L18;
        if (o.e((View) ZeusTransformUtils.preCheckCast(c(), View.class, "com.obric.memorydata.plugin")) == false) goto L13;
    L14:
        Log.d(q, "show toast by system");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14808b.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r14 != null) goto L17;
        r14 = this.f14808b;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L17:
        Toast r15 = Toast.makeText(r14, (CharSequence) ZeusTransformUtils.preCheckCast(this.c, CharSequence.class, "com.obric.memorydata.plugin"), 0);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        this.j = r15;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r15.show();     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        this.i.a().postDelayed(new $$Lambda$a$hQA9KjRzORPZ7Wr6h0JBcDwrA(this), this.i.b());     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        goto L41
    L13:
        if (c().isClickable() == true) goto L18;
    L6:
        r6 = false;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$hQA9--KjRzORPZ7Wr6h0JBcDwrA, reason: not valid java name */
    public static /* synthetic */ void m1395lambda$hQA9KjRzORPZ7Wr6h0JBcDwrA(a r0) {
        c(r0);
    }

    public final View a() {
        return this.h;
    }

    public final View b() {
        return this.o;
    }

    public final OButton c() {
        return this.p;
    }

    public final void d() {
        C0786a.a(f14807a, this);
    }
}
