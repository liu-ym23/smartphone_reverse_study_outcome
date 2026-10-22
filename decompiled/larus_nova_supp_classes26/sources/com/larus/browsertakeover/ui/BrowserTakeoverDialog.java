package com.larus.browsertakeover.ui;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.browsertakeover.cdp.BrowserCdpClient;
import com.larus.browsertakeover.cdp.RemoteInputCommand;
import com.larus.browsertakeover.render.RemoteBrowserSurfaceView;
import com.larus.browsertakeover.render.RemoteImeEditText;
import com.larus.browsertakeover.session.BrowserTakeoverSession;
import com.larus.common_ui.dbx.component.DbxButton;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iv8.v0;
import iv8.w0;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001d\b\u0000\u0018\u0000 {2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002z{B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0016J\b\u00100\u001a\u00020 H\u0016J\u0010\u00101\u001a\u00020 2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020 2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020 2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020 2\u0006\u00106\u001a\u000209H\u0016J(\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0016J\u0010\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020 2\u0006\u00106\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020 H\u0002J!\u0010G\u001a\u00020 2\u0017\u0010H\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020 0I¢\u0006\u0002\bKH\u0002J\b\u0010L\u001a\u00020 H\u0002J\u0010\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020\u0019H\u0016J\u0010\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020\fH\u0002J\b\u0010Q\u001a\u00020 H\u0002J\b\u0010R\u001a\u00020 H\u0002J\b\u0010S\u001a\u00020 H\u0002J\u0010\u0010T\u001a\u00020 2\u0006\u0010U\u001a\u00020VH\u0002J\u0018\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020>H\u0016J\u0018\u0010Z\u001a\u00020 2\u0006\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020>H\u0016J(\u0010[\u001a\u00020 2\u0006\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020>2\u0006\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020>H\u0016J\u0018\u0010^\u001a\u00020 2\u0006\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020>H\u0016J\u0018\u0010_\u001a\u00020 2\u0006\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020>H\u0016J\u0018\u0010`\u001a\u00020 2\u0006\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020>H\u0016J\u0018\u0010a\u001a\u00020 2\u0006\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020>H\u0016J\u0010\u0010b\u001a\u00020 2\u0006\u0010c\u001a\u00020CH\u0016J\u0018\u0010d\u001a\u00020 2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020fH\u0016J\b\u0010h\u001a\u00020 H\u0016J\b\u0010i\u001a\u00020 H\u0016J\b\u0010j\u001a\u00020 H\u0016J \u0010c\u001a\u00020k2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020f2\u0006\u0010o\u001a\u00020>H\u0002J&\u0010p\u001a\u00020q2\u0006\u0010l\u001a\u00020m2\u0006\u0010r\u001a\u00020f2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020 0sH\u0002J&\u0010t\u001a\u00020q2\u0006\u0010l\u001a\u00020m2\u0006\u0010r\u001a\u00020f2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020 0sH\u0002J*\u0010u\u001a\u00020k2\u0006\u0010l\u001a\u00020m2\u0006\u0010v\u001a\u00020f2\u0006\u0010r\u001a\u00020f2\b\b\u0002\u0010w\u001a\u00020\fH\u0002J\u0010\u0010x\u001a\u00020f2\u0006\u0010y\u001a\u00020fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006|"}, d2 = {"Lcom/larus/browsertakeover/ui/BrowserTakeoverDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$Observer;", "Lcom/larus/browsertakeover/render/RemoteBrowserSurfaceView$InteractionListener;", "Lcom/larus/browsertakeover/render/RemoteImeEditText$Listener;", "<init>", "()V", "session", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession;", "views", "Lcom/larus/browsertakeover/ui/BrowserTakeoverDialog$Views;", "validEntry", "", "foreground", "destroyingView", "moreMenu", "Landroid/widget/PopupWindow;", "pendingConnect", "Ljava/lang/Runnable;", "keyboardState", "Lcom/larus/browsertakeover/render/RemoteBrowserKeyboardState;", "keyboardVisible", "getKeyboardVisible", "()Z", "remoteFocus", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient$RemoteEditableFocus;", "main", "Landroid/os/Handler;", "focusPoll", "com/larus/browsertakeover/ui/BrowserTakeoverDialog$focusPoll$1", "Lcom/larus/browsertakeover/ui/BrowserTakeoverDialog$focusPoll$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "connectWhenLaidOut", "retry", "cancelPendingConnect", "onStop", "onDestroyView", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onSessionState", "state", "Lcom/larus/browsertakeover/session/BrowserTakeoverSession$State;", "onStateChanged", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient$State;", "onFrame", "bitmap", "Landroid/graphics/Bitmap;", "deviceWidth", "", "deviceHeight", "offsetTop", "onPageHostChanged", "host", "", "onNavigationStateChanged", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient$NavigationState;", "updateNavigationControls", "navigatePage", "action", "Lkotlin/Function1;", "Lcom/larus/browsertakeover/cdp/BrowserCdpClient;", "Lkotlin/ExtensionFunctionType;", "showMoreMenu", "onRemoteEditableFocusChanged", "focus", "showKeyboard", "manual", "hideKeyboard", "ensureFocusVisible", "syncImeGeometry", "applyImeInsets", "insets", "Landroidx/core/view/WindowInsetsCompat;", "onClick", "x", "y", "onRightClick", "onScroll", "deltaX", "deltaY", "onDragStart", "onDragMove", "onDragEnd", "onDragCancel", "onTextCommitted", ShareType.TEXT, "onDeleteSurroundingText", "beforeLength", "", "afterLength", "onEnterKey", "onTabKey", "onImeDismissed", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "stringId", "size", "iconButton", "Landroid/widget/ImageView;", "icon", "Lkotlin/Function0;", "historyButton", "modeButton", "label", "selected", "dp", "value", "Views", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserTakeoverDialog extends DialogFragment implements BrowserTakeoverSession.b, RemoteBrowserSurfaceView.b, RemoteImeEditText.b {
    public static final /* synthetic */ int o = 0;
    public BrowserTakeoverSession d;
    public b e;
    public boolean f;
    public boolean g;
    public boolean h;
    public PopupWindow i;
    public Runnable j;
    public final com.larus.browsertakeover.render.b k;
    public BrowserCdpClient.l l;
    public final Handler m;
    public final d n;

    public static final class a {
    }

    public static final class b {
        public final LinearLayout a;
        public final LinearLayout b;
        public final TextView c;
        public final LinearLayout d;
        public final RemoteBrowserSurfaceView e;
        public final com.larus.browsertakeover.ui.b f;
        public final LinearLayout g;
        public final DbxButton h;
        public final RemoteImeEditText i;
        public final TextView j;
        public final ImageView k;
        public final ImageView l;
        public final ImageView m;

        public b(LinearLayout r2, LinearLayout r3, TextView r4, LinearLayout r5, RemoteBrowserSurfaceView r6, com.larus.browsertakeover.ui.b r7, LinearLayout r8, DbxButton r9, RemoteImeEditText r10, TextView r11, AppCompatImageView r12, AppCompatImageView r13, AppCompatImageView r14) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "navigation");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, "pageContent");
            Intrinsics.checkNotNullParameter(r6, "surface");
            Intrinsics.checkNotNullParameter(r7, "status");
            Intrinsics.checkNotNullParameter(r8, "footer");
            Intrinsics.checkNotNullParameter(r9, "complete");
            Intrinsics.checkNotNullParameter(r10, "input");
            Intrinsics.checkNotNullParameter(r11, "keyboard");
            Intrinsics.checkNotNullParameter(r12, "back");
            Intrinsics.checkNotNullParameter(r13, ShareChannel.FORWARD);
            Intrinsics.checkNotNullParameter(r14, ShareChannel.MORE);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BrowserTakeoverSession.State.values().length];
            r0[BrowserTakeoverSession.State.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[BrowserTakeoverSession.State.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[BrowserTakeoverSession.State.COMPLETION_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[BrowserTakeoverSession.State.IDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[BrowserTakeoverSession.State.CONNECTING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[BrowserTakeoverSession.State.COMPLETING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[BrowserTakeoverSession.State.ACTIVE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[BrowserTakeoverSession.State.COMPLETE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BrowserTakeoverDialog a;

        public final void a() {
            BrowserTakeoverDialog r0 = this.a;
            if (r0.g == false) goto L25;
            BrowserTakeoverSession r1 = r0.d;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("session");
            r1 = null;
        L8:
            if (r1.getCanControl() == false) goto L26;
            this.a.ba0();
            BrowserTakeoverSession r2 = this.a.d;
            if (r2 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("session");
            r2 = null;
        L13:
            BrowserCdpClient r3 = r2.getClient();
            if (r3 == null) goto L23;
            BrowserCdpClient.l r4 = this.a.l;
            if (r4 == null) goto L18;
            int r5 = r4.g;
        L20:
            if (r5 != r3.j.get()) goto L23;
            BrowserCdpClient.V(r3, null, Integer.valueOf(r5), 2);
            goto L23
        L18:
            r5 = 0;
        L23:
            this.a.m.postDelayed(this, 600);
            return;
        L26:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(BrowserTakeoverDialog r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void onDestroyView() {
        this.h = true;
        BrowserTakeoverSession r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L5:
        r0.detach();
        Runnable r1 = this.j;
        if (r1 == null) goto L12;
        b r2 = this.e;
        if (r2 == null) goto L12;
        RemoteBrowserSurfaceView r3 = r2.e;
        if (r3 == null) goto L12;
        r3.removeCallbacks(r1);
    L12:
        this.j = null;
        PopupWindow r4 = this.i;
        if (r4 == null) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
    L15:
        b r5 = this.e;
        if (r5 == null) goto L20;
        com.larus.browsertakeover.ui.b r6 = r5.f;
        if (r6 == null) goto L20;
        r6.setHostActive(false);
        r6.setOnRetry(null);
    L20:
        this.m.removeCallbacksAndMessages(null);
        b r7 = this.e;
        if (r7 == null) goto L25;
        RemoteBrowserSurfaceView r8 = r7.e;
        if (r8 == null) goto L25;
        r8.setInteractionListener(null);
        r8.setOnFirstFrameSubmitted(null);
        r8.e();
    L25:
        b r9 = this.e;
        if (r9 == null) goto L30;
        RemoteImeEditText r10 = r9.i;
        if (r10 == null) goto L30;
        r10.setListener(null);
    L30:
        this.e = null;
        super.onDestroyView();
    }

    public final void onStop() {
        this.g = false;
        Runnable r1 = this.j;
        if (r1 == null) goto L9;
        b r2 = this.e;
        if (r2 == null) goto L9;
        RemoteBrowserSurfaceView r3 = r2.e;
        if (r3 == null) goto L9;
        r3.removeCallbacks(r1);
    L9:
        BrowserTakeoverSession r4 = null;
        this.j = null;
        PopupWindow r5 = this.i;
        if (r5 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r5);
        r5.dismiss();
    L12:
        b r6 = this.e;
        if (r6 == null) goto L17;
        com.larus.browsertakeover.ui.b r7 = r6.f;
        if (r7 == null) goto L17;
        r7.setHostActive(false);
    L17:
        this.m.removeCallbacksAndMessages(null);
        b r8 = this.e;
        if (r8 == null) goto L22;
        RemoteBrowserSurfaceView r9 = r8.e;
        if (r9 == null) goto L22;
        r9.setInputEnabled(false);
    L22:
        hideKeyboard();
        BrowserTakeoverSession r0 = this.d;
        if (r0 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L25:
        r0.onBackgrounded();
        BrowserTakeoverSession r10 = this.d;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L29:
        r4.disconnect();
        super.onStop();
        return;
    L28:
        r4 = r10;
        goto L29
    }

    @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
    public final void v30(BrowserCdpClient.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.larus.browsertakeover.render.RemoteImeEditText.b
    public final void LI() {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L18;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        BrowserCdpClient r3 = r1.getClient();
        if (r3 == null) goto L19;
        RemoteInputCommand.Key r4 = RemoteInputCommand.Key.TAB;
        if (r3.n() == false) goto L16;
        r3.h("special_key", new v0(r3, r4));
        return;
    L16:
        r3.b0(r4);
        return;
    L19:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    public final void V90() {
        if (this.k.a == false) goto L123;
        BrowserTakeoverSession r1 = this.d;
        BrowserTakeoverSession r3 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r1 = null;
    L8:
        if (r1.getCanControl() == false) goto L136;
        b r2 = this.e;
        if (r2 == null) goto L124;
        RemoteBrowserSurfaceView r4 = r2.e;
        if (r4 == null) goto L137;
        BrowserCdpClient.l r5 = this.l;
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.a == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L138;
        Rect r6 = new Rect(0, 0, r4.getWidth(), r4.getHeight());
        Intrinsics.checkNotNullParameter(r6, "localVisibleRect");
        Rect r7 = new Rect(r6);
        if (r7.intersect(0, 0, r4.getWidth(), r4.getHeight()) == false) goto L72;
        com.larus.browsertakeover.render.c.b r8 = r4.f();
        if (r8 == null) goto L72;
        com.larus.browsertakeover.render.c.a r9 = new com.larus.browsertakeover.render.c.a(r7.left, r7.top, r7.right, r7.bottom);
        Intrinsics.checkNotNullParameter(r9, "local");
        com.larus.browsertakeover.render.c.a r10 = r8.f;
        if (r10 == null) goto L34;
        r9 = r9.a(r10);
        if (r9 != null) goto L34;
    L68:
        com.larus.browsertakeover.render.c.a r11 = null;
    L69:
        if (r11 == null) goto L72;
        RectF r12 = new RectF(r11.a, r11.b, r11.c, r11.d);
    L73:
        if (r12 != null) goto L75;
        return;
    L75:
        BrowserTakeoverSession r13 = this.d;
        if (r13 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L79:
        final BrowserCdpClient r14 = r3.getClient();
        if (r14 == null) goto L126;
        final int r15 = r5.g;
        String r16 = r5.f;
        float r17 = r12.top;
        float r18 = r12.bottom;
        Regex r19 = BrowserCdpClient.N;
        Intrinsics.checkNotNullParameter(r16, "expectedFocusSerial");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L84;
        return;
    L84:
        if (r15 == r14.j.get()) goto L86;
        return;
    L86:
        if (StringsKt.isBlank(r16) == false) goto L88;
        return;
    L88:
        if (r16.length() <= 32) goto L90;
        return;
    L90:
        if (Float.isInfinite(r17) == false) goto L92;
    L94:
        boolean r110 = false;
    L95:
        if (r110 == true) goto L97;
        return;
    L97:
        if (Float.isInfinite(r18) == false) goto L99;
    L101:
        boolean r111 = false;
    L102:
        if (r111 == true) goto L104;
        return;
    L104:
        if (r17 >= 0.0f) goto L106;
        return;
    L106:
        if (r18 <= 32768.0f) goto L108;
        return;
    L108:
        if ((r18 - r17) < 24.0f) goto L139;
        final BrowserCdpClient.j r20 = r14.d();
        if (r20 == null) goto L140;
        StringBuilder r112 = new StringBuilder("(");
        r112.append(BrowserCdpClient.Q);
        r112.append(")(");
        r112.append(JSONObject.quote(r16));
        r112.append(',');
        r112.append(r17);
        r112.append(',');
        r112.append(r18);
        r112.append(')');
        String r21 = r112.toString();
        if (r14.v(r20) == true) goto L116;
        return;
    L116:
        if (r15 != r14.j.get()) goto L141;
        final AtomicBoolean r22 = new AtomicBoolean(false);
        final Function1 r113 = null;
        if (BrowserCdpClient.Y(r14, "Runtime.evaluate", new JSONObject().put("expression", r21).put("returnByValue", true).put("awaitPromise", false).put("userGesture", false).put("silent", true), r20.c, false, new iv8.m(r14, r20, r15, r22, r113), 8) == true) goto L121;
        BrowserCdpClient.i(r22, r14, r20, r15, null, false);
    L121:
        final Function1 r114 = null;
        r14.d.postDelayed(new iv8.n(r22, r14, r20, r15, r114), 1500);
        return;
    L141:
        return;
    L140:
        return;
    L139:
        return;
    L99:
        if (Float.isNaN(r18) == true) goto L101;
        r111 = true;
        goto L102
    L92:
        if (Float.isNaN(r17) == true) goto L94;
        r110 = true;
        goto L95
    L126:
        return;
    L78:
        r3 = r13;
    L34:
        float r23 = Math.max(0.0f, (r9.a - r8.a.a) / r8.e);
        float r115 = Math.max(0.0f, ((r9.b - r8.a.b) / r8.e) - r8.d);
        float r116 = Math.min(r8.b, (r9.c - r8.a.a) / r8.e);
        float r117 = r8.c;
        float r118 = r8.d;
        float r24 = Math.min(r117 - r118, ((r9.d - r8.a.b) / r8.e) - r118);
        if (Float.isInfinite(r23) == false) goto L37;
    L39:
        boolean r25 = false;
    L40:
        if (r25 == false) goto L68;
        if (Float.isInfinite(r115) == false) goto L44;
    L46:
        boolean r26 = false;
    L47:
        if (r26 == false) goto L68;
        if (Float.isInfinite(r116) == false) goto L51;
    L53:
        boolean r27 = false;
    L54:
        if (r27 == false) goto L68;
        if (Float.isInfinite(r24) == false) goto L58;
    L60:
        boolean r28 = false;
    L61:
        if (r28 == false) goto L68;
        if (r23 >= r116) goto L68;
        if (r115 >= r24) goto L68;
        r11 = new com.larus.browsertakeover.render.c.a(r23, r115, r116, r24);
        goto L69
    L58:
        if (Float.isNaN(r24) == true) goto L60;
        r28 = true;
        goto L61
    L51:
        if (Float.isNaN(r116) == true) goto L53;
        r27 = true;
        goto L54
    L44:
        if (Float.isNaN(r115) == true) goto L46;
        r26 = true;
        goto L47
    L37:
        if (Float.isNaN(r23) == true) goto L39;
        r25 = true;
    L72:
        r12 = null;
        goto L73
    L138:
        return;
    L137:
        return;
    L124:
        return;
    L136:
        return;
    }

    public final void da0() {
        b r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        BrowserTakeoverSession r2 = null;
        boolean r5 = false;
        if (this.g == false) goto L13;
        BrowserTakeoverSession r1 = this.d;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r1 = null;
    L11:
        if (r1.getCanControl() == false) goto L13;
        boolean r3 = true;
    L14:
        Pair[] r6 = new Pair[3];
        ImageView r7 = r0.k;
        if (r3 == false) goto L22;
        BrowserTakeoverSession r8 = this.d;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r8 = null;
    L20:
        if (r8.getNavigationState().a == false) goto L22;
        boolean r9 = true;
    L23:
        r6[0] = TuplesKt.to(r7, Boolean.valueOf(r9));
        ImageView r10 = r0.l;
        if (r3 == false) goto L32;
        BrowserTakeoverSession r11 = this.d;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L30:
        if (r2.getNavigationState().b == false) goto L32;
        r5 = true;
        goto L32
    L28:
        r2 = r11;
    L32:
        r6[1] = TuplesKt.to(r10, Boolean.valueOf(r5));
        r6[2] = TuplesKt.to(r0.m, Boolean.valueOf(r3));
        Iterator r4 = CollectionsKt.listOf(r6).iterator();
    L34:
        if (r4.hasNext() == false) goto L40;
        Pair r12 = (Pair) r4.next();
        ImageView r13 = (ImageView) r12.component1();
        boolean r14 = ((Boolean) r12.component2()).booleanValue();
        r13.setEnabled(r14);
        if (r14 == false) goto L38;
        float r15 = 1.0f;
    L39:
        r13.setAlpha(r15);
        goto L34
    L38:
        r15 = 0.3f;
        goto L39
    L40:
        return;
    L22:
        r9 = false;
    L13:
        r3 = false;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.EditText, com.larus.browsertakeover.render.RemoteImeEditText] */
    public final void hideKeyboard() {
        com.larus.browsertakeover.render.b r0 = this.k;
        r0.b = true;
        r0.c = false;
        b r1 = this.e;
        if (r1 == null) goto L16;
        ?? r2 = r1.i;
        if (r2 != 0) goto L7;
        return;
    L7:
        if (r2.d == false) goto L9;
        r2.setProxyMode(false);
    L9:
        r2.clearFocus();
        Object r3 = r2.getContext().getSystemService("input_method");
        if ((r3 instanceof InputMethodManager) == false) goto L12;
        InputMethodManager r4 = (InputMethodManager) r3;
    L13:
        if (r4 == null) goto L18;
        r4.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    L18:
        return;
    L12:
        r4 = null;
        goto L13
    }

    @Override // com.larus.browsertakeover.render.RemoteImeEditText.b
    public final void ob() {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L18;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        BrowserCdpClient r3 = r1.getClient();
        if (r3 == null) goto L19;
        RemoteInputCommand.Key r4 = RemoteInputCommand.Key.ENTER;
        if (r3.n() == false) goto L16;
        r3.h("special_key", new v0(r3, r4));
        return;
    L16:
        r3.b0(r4);
        return;
    L19:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    public BrowserTakeoverDialog() {
        this.k = new com.larus.browsertakeover.render.b();
        this.m = new Handler(Looper.getMainLooper());
        this.n = new d(this);
    }

    public final void ba0() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        View r2 = S90(r1);
        if (r2 == null) goto L16;
        WindowInsetsCompat r3 = ViewCompat.getRootWindowInsets(r2);
        if (r3 == null) goto L15;
        T90(r3);
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.f == false) goto L35;
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L15;
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawableResource(R.color.black);
        r1.addFlags(8192);
        r1.setSoftInputMode(16);
        WindowCompat.setDecorFitsSystemWindows(r1, false);
        WindowInsetsControllerCompat r2 = WindowCompat.getInsetsController(r1, S90(r1));
        r2.setAppearanceLightStatusBars(false);
        r2.setAppearanceLightNavigationBars(false);
    L15:
        this.g = true;
        b r3 = this.e;
        if (r3 == null) goto L20;
        com.larus.browsertakeover.ui.b r4 = r3.f;
        if (r4 == null) goto L20;
        r4.setHostActive(true);
    L20:
        b r5 = this.e;
        if (r5 == null) goto L39;
        LinearLayout r6 = r5.a;
        if (r6 == null) goto L42;
        ViewCompat.requestApplyInsets(r6);
        b r7 = this.e;
        if (r7 != null) goto L29;
        return;
    L29:
        if (this.j == null) goto L31;
        return;
    L31:
        if (this.g == false) goto L44;
        x r8 = new x(this, r7);
        this.j = r8;
        r7.e.post(r8);
        return;
    L44:
        return;
    L42:
        return;
    L39:
        return;
    L35:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L37;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.browsertakeover.render.RemoteImeEditText.b
    public final void hQ() {
        hideKeyboard();
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // com.larus.browsertakeover.render.RemoteImeEditText.b
    public final void I10(final String r5) {
        Intrinsics.checkNotNullParameter(r5, ShareType.TEXT);
        BrowserTakeoverSession r1 = this.d;
        BrowserTakeoverSession r2 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r1 = null;
    L6:
        if (r1.getCanControl() == false) goto L26;
        BrowserTakeoverSession r3 = this.d;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        final BrowserCdpClient r4 = r2.getClient();
        if (r4 == null) goto L27;
        Intrinsics.checkNotNullParameter(r5, ShareType.TEXT);
        if (r5.length() != 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        return;
    L19:
        if (r5.length() <= 4096) goto L22;
        return;
    L22:
        if (r4.n() == false) goto L24;
        r4.h("insert_text", new w0(r4, r5));
        return;
    L24:
        BrowserCdpClient.a0(r4, "Input.insertText", new JSONObject().put(ShareType.TEXT, r5));
        return;
    L16:
        r6 = false;
        goto L17
    L27:
        return;
    L10:
        r2 = r3;
        goto L11
    }

    @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
    public final void OH(String r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        b r0 = this.e;
        if (r0 == null) goto L12;
        TextView r1 = r0.c;
        if (r1 == null) goto L13;
        r1.setText(r2);
        if ((!StringsKt.isBlank(r2)) == false) goto L9;
        int r3 = 0;
    L10:
        r1.setVisibility(r3);
        return;
    L9:
        r3 = 8;
        goto L10
    L13:
        return;
    }

    public final void T90(WindowInsetsCompat r22) {
        b r2 = this.e;
        if (r2 != null) goto L5;
        return;
    L5:
        LinearLayout r3 = r2.a;
        Insets r4 = r22.getInsets(WindowInsetsCompat.Type.systemBars());
        int r5 = r22.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        if (r22.isVisible(WindowInsetsCompat.Type.ime()) == false) goto L9;
        if (r5 <= 0) goto L9;
        boolean r1 = true;
    L10:
        com.larus.browsertakeover.render.b r8 = this.k;
        boolean r9 = r8.a;
        if (r9 == false) goto L14;
        if (r1 == true) goto L14;
        boolean r10 = true;
    L15:
        r8.a = r1;
        if (r10 == false) goto L18;
        r8.b = true;
        r8.c = false;
    L18:
        if (r1 == false) goto L20;
        r8.c = false;
    L20:
        if (r10 == false) goto L25;
        RemoteImeEditText r11 = r2.i;
        if (r11.d == false) goto L24;
        r11.setProxyMode(false);
    L24:
        r2.i.clearFocus();
    L25:
        if (r1 == r9) goto L34;
        r2.e.setImeVisible(r1);
        LinearLayout r12 = r2.b;
        boolean r13 = !r1;
        int r14 = 8;
        if (r13 == false) goto L29;
        int r15 = 0;
    L30:
        r12.setVisibility(r15);
        LinearLayout r16 = r2.g;
        if (r13 == false) goto L33;
        r14 = 0;
    L33:
        r16.setVisibility(r14);
        goto L34
    L29:
        r15 = 8;
    L34:
        Dialog r17 = getDialog();
        if (r17 == null) goto L37;
        Window r18 = r17.getWindow();
    L38:
        if (r1 == false) goto L45;
        if (r18 == null) goto L45;
        if (Build.VERSION.SDK_INT < 30) goto L44;
        Integer r6 = Integer.valueOf(r18.getWindowManager().getCurrentWindowMetrics().getBounds().bottom - r5);
    L46:
        int[] r19 = new int[2];
        r3.getLocationOnScreen(r19);
        int r110 = com.larus.browsertakeover.render.a.a;
        int r111 = r19[1];
        int r112 = r3.getHeight();
        int r113 = RangesKt.coerceIn(r4.bottom, 0, RangesKt.coerceAtLeast(r112, 0));
        if (r6 == null) goto L51;
        r113 = r113 + ((int) RangesKt.coerceIn(((((long) r111) + ((long) r112)) - ((long) r113)) - ((long) r6.intValue()), 0, RangesKt.coerceAtLeast(r112 - r113, 0)));
    L51:
        if (r3.getPaddingLeft() == r4.left) goto L53;
    L58:
        r3.setPadding(r4.left, r4.top, r4.right, r113);
    L59:
        r2.e.getLocationOnScreen(r19);
        int r7 = r19[1];
        int r20 = RangesKt.coerceAtLeast(r2.e.getHeight(), 0);
        if (r6 == null) goto L63;
        r20 = (int) RangesKt.coerceIn(((long) r6.intValue()) - ((long) r7), 0, r20);
    L63:
        RemoteBrowserSurfaceView r21 = r2.e;
        if (r1 == false) goto L66;
        Rect r23 = new Rect(0, 0, r2.e.getWidth(), r20);
    L67:
        r21.setImeVisibleBounds(r23);
        return;
    L66:
        r23 = null;
        goto L67
    L53:
        if (r3.getPaddingTop() != r4.top) goto L58;
        if (r3.getPaddingRight() != r4.right) goto L58;
        if (r3.getPaddingBottom() == r113) goto L59;
    L44:
        Rect r24 = new Rect();
        S90(r18).getWindowVisibleDisplayFrame(r24);
        r6 = Integer.valueOf(r24.bottom);
    L45:
        r6 = null;
        goto L46
    L37:
        r18 = null;
    L14:
        r10 = false;
    L9:
        r1 = false;
        goto L10
    }

    public final int U90(int r3) {
        Resources r0 = getResources();
        return MathKt.roundToInt(r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final void Z90(final Function1<? super BrowserCdpClient, Unit> r4) {
        if (this.g == false) goto L23;
        BrowserTakeoverSession r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L8:
        if (r0.getCanControl() == false) goto L24;
        b r1 = this.e;
        if (r1 == null) goto L15;
        RemoteImeEditText r2 = r1.i;
        if (r2 == null) goto L15;
        r2.g();
    L15:
        hideKeyboard();
        this.l = null;
        BrowserTakeoverSession r3 = this.d;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r3 = null;
    L18:
        final BrowserCdpClient r5 = r3.getClient();
        if (r5 != null) goto L21;
        return;
    L21:
        Function0<Unit> r6 = new o(this, r5, r4);
        Regex r7 = BrowserCdpClient.N;
        r5.R(null, r6);
        return;
    L24:
        return;
    }

    @Override // com.larus.browsertakeover.session.BrowserTakeoverSession.b
    public final void aC(BrowserTakeoverSession.State r15) {
        Intrinsics.checkNotNullParameter(r15, "state");
        b r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r15 != BrowserTakeoverSession.State.ACTIVE) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L18:
        boolean r4 = true;
    L19:
        RemoteBrowserSurfaceView r5 = r0.e;
        if (r1 == true) goto L22;
    L24:
        boolean r6 = false;
    L25:
        r5.setInputEnabled(r6);
        RemoteBrowserSurfaceView r7 = r0.e;
        BrowserTakeoverSession r8 = this.d;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r8 = null;
    L28:
        r7.setUsesRtsInputPacing(r8.getUsesRtsInputPacing());
        DbxButton r9 = r0.h;
        if (r15 != BrowserTakeoverSession.State.COMPLETING) goto L31;
        boolean r10 = true;
    L32:
        r9.setLoading(r10);
        DbxButton r11 = r0.h;
        BrowserTakeoverSession r12 = this.d;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r12 = null;
    L35:
        r11.setEnabled(r12.getCanComplete());
        TextView r13 = r0.j;
        BrowserTakeoverSession r14 = this.d;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r14 = null;
    L38:
        r13.setEnabled(r14.getCanControl());
        LinearLayout r16 = r0.d;
        int r17 = 4;
        if (r4 == false) goto L41;
        int r18 = 0;
    L42:
        r16.setVisibility(r18);
        LinearLayout r19 = r0.d;
        if (r4 == false) goto L45;
        r17 = 0;
    L45:
        r19.setImportantForAccessibility(r17);
        int[] r20 = c.a;
        int r21 = 8;
        switch(r20[r15.ordinal()]) {
            case 3: goto L64;
            case 4: goto L52;
            case 5: goto L52;
            case 6: goto L64;
            case 7: goto L64;
            case 8: goto L64;
            default: goto L48;
        };
    L52:
        com.larus.browsertakeover.ui.b r22 = r0.f;
        String r23 = getString(2131907699);
        r22.b = true;
        r22.i.setText(r23);
        TextView r110 = r22.i;
        if (r23 != null) goto L55;
    L58:
        boolean r24 = true;
    L60:
        if ((true ^ r24) == false) goto L62;
        int r2 = 0;
    L63:
        r110.setVisibility(r2);
        r22.g.setVisibility(0);
        r22.h.setVisibility(8);
        r22.j.setVisibility(8);
        r22.setVisibility(0);
        r22.d();
    L86:
        da0();
        DbxButton r3 = r0.h;
        int r25 = r20[r15.ordinal()];
        if (r25 != 3) goto L89;
        String r26 = getString(2131907697);
    L93:
        r3.setTitle(r26);
        this.m.removeCallbacks(this.n);
        if (r1 == true) goto L96;
    L98:
        PopupWindow r27 = this.i;
        if (r27 == null) goto L102;
        PopupWindowLancet.handleDismissBeforeOrigin(r27);
        r27.dismiss();
    L102:
        if (this.k.a == false) goto L104;
    L105:
        hideKeyboard();
    L106:
        this.l = null;
        RemoteImeEditText r28 = r0.i;
        if (r28.d == false) goto L109;
        r28.setProxyMode(false);
    L109:
        if (r4 == true) goto L112;
        r0.e.e();
    L112:
        if (r15 != BrowserTakeoverSession.State.COMPLETE) goto L122;
        dismissAllowingStateLoss();     // Catch: Exception -> L115
        return;
    L115:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r111 = DialogFragmentLancet.sLastShowStack;
        if (r111 == null) goto L123;
        com.bytedance.crash.d.d(r111, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L123:
        return;
    L122:
        return;
    L104:
        if (r0.i.hasFocus() == false) goto L106;
    L96:
        if (this.g == false) goto L98;
        this.m.post(this.n);
        goto L112
    L89:
        if (r25 == 6) goto L91;
        r26 = getString(2131907698);
        goto L93
    L91:
        r26 = null;
        goto L93
    L62:
        r2 = 8;
        goto L63
    L55:
        if (r23.length() == 0) goto L58;
        r24 = false;
        goto L60
    L64:
        com.larus.browsertakeover.ui.b r29 = r0.f;
        r29.b = false;
        r29.setVisibility(8);
        r29.c();
        goto L86
    L48:
        if (r15 != BrowserTakeoverSession.State.ERROR) goto L66;
        BrowserTakeoverSession r30 = this.d;
        if (r30 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r30 = null;
    L65:
        BrowserTakeoverSession.ErrorReason r31 = r30.getErrorReason();
    L67:
        com.larus.browsertakeover.ui.b r32 = r0.f;
        String r112 = getString(2131907700);
        String r113 = getString(2131907697);
        if (r31 == BrowserTakeoverSession.ErrorReason.MESSAGE_TOO_LARGE) goto L70;
        boolean r33 = true;
    L71:
        r32.getClass();
        Intrinsics.checkNotNullParameter(r113, "retryLabel");
        r32.b = false;
        r32.i.setText(r112);
        TextView r114 = r32.i;
        if (r112 != null) goto L74;
    L77:
        boolean r115 = true;
    L79:
        if ((true ^ r115) == false) goto L81;
        int r34 = 0;
    L82:
        r114.setVisibility(r34);
        r32.j.setTitle(r113);
        r32.g.setVisibility(8);
        r32.h.setVisibility(0);
        DbxButton r35 = r32.j;
        if (r33 == false) goto L85;
        r21 = 0;
    L85:
        r35.setVisibility(r21);
        r32.setVisibility(0);
        r32.d();
        goto L86
    L81:
        r34 = 8;
        goto L82
    L74:
        if (r112.length() == 0) goto L77;
        r115 = false;
        goto L79
    L70:
        r33 = false;
        goto L71
    L66:
        r31 = null;
        goto L67
    L41:
        r18 = 4;
        goto L42
    L31:
        r10 = false;
        goto L32
    L22:
        if (this.g == false) goto L24;
        r6 = true;
        goto L25
    L11:
        if (r15 == BrowserTakeoverSession.State.COMPLETING) goto L18;
        if (r15 == BrowserTakeoverSession.State.COMPLETION_FAILED) goto L18;
        if (r15 == BrowserTakeoverSession.State.COMPLETE) goto L18;
        r4 = false;
        goto L19
    L8:
        r1 = false;
        goto L9
    }

    public final void aa0(boolean r8) {
        if (this.g == false) goto L46;
        BrowserTakeoverSession r0 = this.d;
        InputMethodManager r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L8:
        if (r0.getCanControl() == false) goto L48;
        b r2 = this.e;
        if (r2 != null) goto L13;
        return;
    L13:
        ba0();
        com.larus.browsertakeover.render.b r3 = this.k;
        if (r8 == false) goto L16;
        r3.b = false;
        r3.c = false;
    L16:
        boolean r4 = true;
        if (r3.b == false) goto L19;
    L24:
        boolean r9 = false;
    L25:
        if (r9 == true) goto L27;
        return;
    L27:
        BrowserCdpClient.l r10 = this.l;
        if (r10 != null) goto L30;
    L35:
        r2.e.setImeVisible(true);
        r2.i.setProxyMode(true);
        r2.i.requestFocus();
        Object r11 = r2.i.getContext().getSystemService("input_method");
        if ((r11 instanceof InputMethodManager) == false) goto L38;
        r1 = (InputMethodManager) r11;
    L38:
        if (r1 != null) goto L40;
    L42:
        r4 = false;
    L43:
        if (r4 == true) goto L47;
        this.k.c = false;
        return;
    L47:
        return;
    L40:
        if (r1.showSoftInput(r2.i, 1) != true) goto L42;
    L30:
        if (r10.a == true) goto L33;
        r10 = null;
    L33:
        if (r10 == null) goto L35;
        r2.i.d(r10.b, r10.c, r10.e);
        goto L35
    L19:
        if (r3.a == true) goto L24;
        if (r3.c == true) goto L24;
        r3.c = true;
        r9 = true;
        goto L25
    L48:
        return;
    }

    @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
    public final void iu(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r2, "stage");
    }

    @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
    public final void ko(BrowserCdpClient.l r4) {
        Intrinsics.checkNotNullParameter(r4, "focus");
        this.l = r4;
        if (this.g == false) goto L22;
        BrowserTakeoverSession r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L8:
        if (r0.getCanControl() == false) goto L24;
        ba0();
        if (r4.a == true) goto L13;
        return;
    L13:
        if (this.k.b == true) goto L20;
        b r1 = this.e;
        if (r1 == null) goto L19;
        RemoteImeEditText r2 = r1.i;
        if (r2 == null) goto L19;
        r2.d(r4.b, r4.c, r4.e);
    L19:
        aa0(false);
    L20:
        V90();
        return;
    L24:
        return;
    }

    @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
    public final void m70(BrowserCdpClient.i r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        da0();
    }

    public final void onCancel(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L5:
        r0.onUserClosed();
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L9:
        r1.disconnect();
        super.onCancel(r4);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(1, 2131953689);
        BrowserTakeoverSession r4 = (BrowserTakeoverSession) new ViewModelProvider(this).get(BrowserTakeoverSession.class);
        this.d = r4;
        String r0 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r4 = null;
    L5:
        Bundle r1 = getArguments();
        if (r1 == null) goto L8;
        r0 = r1.getString("browser_takeover_entry_id");
    L8:
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        this.f = r4.initialize(r0);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.requestWindowFeature(1);
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L13
        if (this.h == false) goto L5;
    L10:
        super.onDismiss(r2);     // Catch: Throwable -> L13
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        if (r2 != getDialog()) goto L10;
        BrowserTakeoverSession r0 = this.d;     // Catch: Throwable -> L13
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("session");     // Catch: Throwable -> L13
        r0 = null;
    L9:
        r0.onPageDismissed();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.larus.browsertakeover.render.RemoteBrowserSurfaceView.b
    public final void CR(float r3, float r4) {
        BrowserTakeoverSession r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L5:
        BrowserCdpClient r1 = r0.getClient();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.e0(r3, r4) == false) goto L13;
        BrowserCdpClient.a0(r1, "Input.dispatchMouseEvent", BrowserCdpClient.E("mouseReleased", r3, r4).put("button", "left").put("buttons", 0).put("clickCount", 1));
        r1.t();
        return;
    }

    @Override // com.larus.browsertakeover.render.RemoteBrowserSurfaceView.b
    public final void F80(float r9, float r10) {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L18;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        BrowserCdpClient r3 = r1.getClient();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.e0(r9, r10) == false) goto L20;
        r3.t();
        BrowserCdpClient.a0(r3, "Input.dispatchMouseEvent", BrowserCdpClient.E("mousePressed", r9, r10).put("button", "right").put("buttons", 2).put("clickCount", 1));
        BrowserCdpClient.a0(r3, "Input.dispatchMouseEvent", BrowserCdpClient.E("mouseReleased", r9, r10).put("button", "right").put("buttons", 0).put("clickCount", 1));
        return;
    L20:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.larus.browsertakeover.render.RemoteBrowserSurfaceView.b
    public final void O70(final float r4, final float r5) {
        BrowserTakeoverSession r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == true) goto L8;
        return;
    L8:
        b r1 = this.e;
        if (r1 == null) goto L13;
        RemoteImeEditText r2 = r1.i;
        if (r2 == null) goto L13;
        r2.g();
    L13:
        BrowserTakeoverSession r3 = this.d;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r3 = null;
    L16:
        final BrowserCdpClient r6 = r3.getClient();
        if (r6 != null) goto L19;
        return;
    L19:
        Function0<Unit> r7 = new com.larus.browsertakeover.ui.c(this, r6, r4, r5);
        Regex r8 = BrowserCdpClient.N;
        r6.R(null, r7);
    }

    @Override // com.larus.browsertakeover.render.RemoteBrowserSurfaceView.b
    public final void f5(float r4, float r5) {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L21;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        BrowserCdpClient r3 = r1.getClient();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.e0(r4, r5) == false) goto L23;
        BrowserCdpClient.j r6 = r3.d();
        if (r6 == null) goto L24;
        r3.M(r4, r5, r6, r3.j.incrementAndGet());
        return;
    L24:
        return;
    L23:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.larus.browsertakeover.render.RemoteBrowserSurfaceView.b
    public final void p10(float r4, float r5) {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L18;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        BrowserCdpClient r3 = r1.getClient();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.e0(r4, r5) == false) goto L20;
        BrowserCdpClient.a0(r3, "Input.dispatchMouseEvent", BrowserCdpClient.E("mouseMoved", r4, r5).put("button", "left").put("buttons", 1));
        return;
    L20:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.larus.browsertakeover.render.RemoteBrowserSurfaceView.b
    public final void p50(float r4, float r5) {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L18;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        BrowserCdpClient r3 = r1.getClient();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.e0(r4, r5) == false) goto L20;
        r3.j.incrementAndGet();
        BrowserCdpClient.a0(r3, "Input.dispatchMouseEvent", BrowserCdpClient.E("mousePressed", r4, r5).put("button", "left").put("buttons", 1).put("clickCount", 1));
        return;
    L20:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
    public final void pW(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r4, "code");
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r4, "code");
    }

    @Override // com.larus.browsertakeover.render.RemoteImeEditText.b
    public final void y9(final int r6, final int r7) {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L22;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        final BrowserCdpClient r3 = r1.getClient();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.n() == false) goto L16;
        r3.h(ShareChannel.DELETE, new iv8.l(r3, r6, r7));
        return;
    L16:
        int r4 = 0;
        int r8 = RangesKt.coerceIn(r6, 0, 64);
        int r5 = 0;
    L17:
        if (r5 >= r8) goto L19;
        r3.b0(RemoteInputCommand.Key.BACKSPACE);
        r5 = r5 + 1;
        goto L17
    L19:
        int r9 = RangesKt.coerceIn(r7, 0, 64);
    L20:
        if (r4 >= r9) goto L27;
        r3.b0(RemoteInputCommand.Key.DELETE);
        r4 = r4 + 1;
        goto L20
    L27:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    public static TextView ca0(Context r1, int r2, float r3) {
        TextView r0 = new TextView(r1);
        r0.setText(r2);
        r0.setTextSize(r3);
        r0.setTextColor(-1);
        r0.setGravity(17);
        return r0;
    }

    public final AppCompatImageView W90(Context r3, int r4, Function0 r5) {
        AppCompatImageView r6 = X90(r3, r4, r5);
        r6.setPadding(U90(10), U90(10), U90(10), U90(10));
        GradientDrawable r7 = new GradientDrawable();
        r7.setCornerRadius(U90(8));
        r7.setColor(0);
        r7.setStroke(U90(1), 536870911);
        r6.setBackground(r7);
        return r6;
    }

    public final AppCompatImageView X90(Context r5, int r6, final Function0 r7) {
        AppCompatImageView r0 = new AppCompatImageView(r5);
        r0.setPadding(U90(14), U90(10), U90(14), U90(10));
        r0.setImageResource(r6);
        r0.setColorFilter(-1);
        r0.setClickable(true);
        r0.setFocusable(true);
        r0.setOnClickListener(new g(r7));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [android.view.View, android.widget.EditText, com.larus.browsertakeover.render.RemoteImeEditText] */
    public final View onCreateView(LayoutInflater r27, ViewGroup r28, Bundle r29) {
        Intrinsics.checkNotNullParameter(r27, "inflater");
        this.h = false;
        com.larus.browsertakeover.render.b r2 = this.k;
        r2.a = false;
        r2.b = false;
        r2.c = false;
        this.l = null;
        final Context r3 = com.larus.common_ui.dbx.theme.a.c(requireContext());
        final LinearLayout r15 = new LinearLayout(r3);
        r15.setOrientation(1);
        r15.setBackgroundColor(-16777216);
        r15.setSaveEnabled(false);
        LinearLayout r6 = new LinearLayout(r3);
        r6.setGravity(16);
        r15.addView(r6, new LinearLayout.LayoutParams(-1, U90(44)));
        r6.addView(X90(r3, 2131243468, new n(this)), new LinearLayout.LayoutParams(U90(52), U90(44)));
        LinearLayout r8 = new LinearLayout(r3);
        r8.setOrientation(1);
        r8.setGravity(17);
        TextView r13 = new TextView(r3);
        r13.setTextSize(14.0f);
        r13.setTextColor(-1);
        r13.setGravity(17);
        r13.setVisibility(8);
        r13.setTypeface(Typeface.create("sans-serif-medium", 0));
        r13.setMaxLines(1);
        r13.setMaxWidth(U90(174));
        r13.setEllipsize(TextUtils.TruncateAt.END);
        Drawable r14 = r3.getDrawable(2131243469);
        if (r14 == null) goto L5;
        Drawable r16 = r14.mutate();
    L6:
        if (r16 == null) goto L8;
        r16.setBounds(0, 0, U90(16), U90(16));
    L8:
        r13.setCompoundDrawables(r16, null, null, null);
        r13.setCompoundDrawablePadding(U90(4));
        r8.addView(r13, new LinearLayout.LayoutParams(-2, U90(22)));
        TextView r5 = ca0(r3, 2131907709, 11.0f);
        r5.setTextColor(-6710887);
        r8.addView(r5);
        r6.addView(r8, new LinearLayout.LayoutParams(0, -1, 1.0f));
        View r9 = X90(r3, 2131243472, new r(this));
        r6.addView(r9, new LinearLayout.LayoutParams(U90(52), U90(44)));
        FrameLayout r7 = new FrameLayout(r3);
        LinearLayout r10 = new LinearLayout(r3);
        r10.setOrientation(1);
        r7.addView(r10, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r12 = new FrameLayout(r3);
        final RemoteBrowserSurfaceView r17 = new RemoteBrowserSurfaceView(r3, null, 6, 0);
        r17.setBackgroundColor(-16777216);
        r17.setInteractionListener(this);
        BrowserTakeoverSession r4 = this.d;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r4 = null;
    L11:
        r17.setOnFirstFrameSubmitted(new BrowserTakeoverDialog$onCreateView$surface$1$1(r4));
        r12.addView(r17, new FrameLayout.LayoutParams(-1, -1));
        final ?? r11 = new RemoteImeEditText(r3, null, 6, 0);
        r11.setBackground(null);
        r11.setTextColor(0);
        r11.setHighlightColor(0);
        r11.setCursorVisible(false);
        r11.setFocusableInTouchMode(true);
        r11.setShowSoftInputOnFocus(false);
        r11.setLongClickable(false);
        r11.setMinWidth(0);
        r11.setMinHeight(0);
        r11.setPadding(0, 0, 0, 0);
        r11.setMaxLines(1);
        r11.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(4096)});
        r11.setInputType(16385);
        r11.setSaveEnabled(false);
        r11.setImportantForAccessibility(2);
        int r18 = Build.VERSION.SDK_INT;
        if (r18 < 26) goto L14;
        int r19 = 8;
        r11.setImportantForAutofill(8);
    L16:
        if (r18 < 30) goto L18;
        r11.setImportantForContentCapture(r19);
    L18:
        r11.setListener(this);
        r11.setOnEditorActionListener(new s(r11, this));
        r12.addView(r11, new FrameLayout.LayoutParams(U90(1), U90(1)));
        r10.addView(r12, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout r1 = new LinearLayout(r3);
        r1.setOrientation(1);
        r1.setPadding(U90(16), U90(12), U90(16), U90(8));
        LinearLayout r20 = new LinearLayout(r3);
        View r110 = W90(r3, 2131243473, new t(this));
        View r111 = W90(r3, 2131243474, new u(this));
        r20.addView(r110, new LinearLayout.LayoutParams(U90(36), U90(36)));
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(U90(36), U90(36));
        r21.setMarginStart(U90(8));
        Unit r22 = Unit.INSTANCE;
        r20.addView(r111, r21);
        TextView r23 = Y90(r3, 2131907710, 2131243470, true);
        r23.setOnClickListener(new v(this));
        TextView r112 = Y90(r3, 2131907707, 2131243471, false);
        r112.setOnClickListener(new w(this));
        TextView r24 = Y90(r3, 2131907705, 2131243475, false);
        r24.setOnClickListener(new com.larus.browsertakeover.ui.d(r3));
        Iterator r25 = CollectionsKt.listOf(new TextView[]{r23, r112, r24}).iterator();
    L20:
        if (r25.hasNext() == false) goto L22;
        TextView r26 = (TextView) r25.next();
        LinearLayout.LayoutParams r30 = new LinearLayout.LayoutParams(0, U90(36), 1.0f);
        r30.setMarginStart(U90(8));
        Unit r113 = Unit.INSTANCE;
        r20.addView(r26, r30);
        r25 = r25;
        r110 = r110;
        goto L20
    L22:
        View r210 = r110;
        r1.addView(r20, new LinearLayout.LayoutParams(-1, U90(36)));
        DbxButton r31 = new DbxButton(r3, null, 6, 0);
        r31.b(DbxButton.Style.SOLID, DbxButton.Size.XL);
        r31.setLeadingIcon(null);
        r31.setTrailingIcon(null);
        r31.setTitle(getString(2131907698));
        r31.setOnClickListener(new e(this, r11, r17));
        LinearLayout.LayoutParams r32 = new LinearLayout.LayoutParams(-1, U90(56));
        r32.topMargin = U90(12);
        Unit r33 = Unit.INSTANCE;
        r1.addView(r31, r32);
        r10.addView(r1, new LinearLayout.LayoutParams(-1, -2));
        com.larus.browsertakeover.ui.b r114 = new com.larus.browsertakeover.ui.b(r3);
        r114.setOnRetry(new BrowserTakeoverDialog$onCreateView$status$1$1(this));
        r7.addView(r114, new FrameLayout.LayoutParams(-1, -1));
        r15.addView(r7, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.e = new b(r15, r6, r13, r10, r17, r114, r1, r31, r11, r112, r210, r111, r9);
        ViewCompat.setOnApplyWindowInsetsListener(r15, new f(this, r15));
        r17.addOnLayoutChangeListener(new p(this));
        r15.addOnLayoutChangeListener(new q(this));
        BrowserTakeoverSession r34 = this.d;
        if (r34 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r34 = null;
    L25:
        r34.attach(this);
        return r15;
    L14:
        r19 = 8;
        goto L16
    L5:
        r16 = null;
        goto L6
    }

    @Override // com.larus.browsertakeover.render.RemoteBrowserSurfaceView.b
    public final void Gp(float r5, float r6, float r7, float r8) {
        BrowserTakeoverSession r0 = this.d;
        BrowserTakeoverSession r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r0 = null;
    L6:
        if (r0.getCanControl() == false) goto L32;
        BrowserTakeoverSession r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L11:
        BrowserCdpClient r3 = r1.getClient();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.e0(r5, r6) == false) goto L34;
        boolean r4 = true;
        if (Float.isInfinite(r7) == false) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == true) goto L23;
        return;
    L23:
        if (Float.isInfinite(r8) == false) goto L25;
    L27:
        r4 = false;
    L28:
        if (r4 == false) goto L36;
        BrowserCdpClient.a0(r3, "Input.dispatchMouseEvent", BrowserCdpClient.E("mouseWheel", r5, r6).put("deltaX", RangesKt.coerceIn(r7, -1000.0f, 1000.0f)).put("deltaY", RangesKt.coerceIn(r8, -1000.0f, 1000.0f)));
        return;
    L36:
        return;
    L25:
        if (Float.isNaN(r8) == true) goto L27;
    L18:
        if (Float.isNaN(r7) == true) goto L20;
        r9 = true;
        goto L21
    L34:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    @Override // com.larus.browsertakeover.cdp.BrowserCdpClient.d
    public final void R50(Bitmap r8, float r9, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r8, "bitmap");
        b r1 = this.e;
        if (r1 == null) goto L41;
        RemoteBrowserSurfaceView r2 = r1.e;
        if (r2 == null) goto L41;
        BrowserTakeoverSession r3 = this.d;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        r3 = null;
    L9:
        int r4 = r3.getConnectionAttempt();
        Intrinsics.checkNotNullParameter(r8, "bitmap");
        boolean r5 = true;
        if (r2.j != r9) goto L12;
        boolean r0 = true;
    L14:
        if (r0 == true) goto L16;
    L25:
        r2.a();
        r2.B = 1.0f;
        r2.C = 0.0f;
        r2.D = 0.0f;
    L26:
        Bitmap r6 = r2.g;
        r2.g = r8;
        r2.j = RangesKt.coerceAtLeast(r9, 1.0f);
        r2.k = RangesKt.coerceAtLeast(r10, 1.0f);
        r2.l = RangesKt.coerceAtLeast(r11, 0.0f);
        r2.invalidate();
        if (r6 == r8) goto L35;
        if (r6 != null) goto L30;
    L32:
        r5 = false;
    L33:
        if (r5 == false) goto L35;
        r6.recycle();
        goto L35
    L30:
        if (r6.isRecycled() == true) goto L32;
    L35:
        if (r4 > 0) goto L37;
        return;
    L37:
        if (r4 == r2.h) goto L44;
        r2.h = r4;
        Function1<? super Integer, Unit> r12 = r2.i;
        if (r12 == null) goto L45;
        r12.invoke(Integer.valueOf(r4));
        return;
    L45:
        return;
    L44:
        return;
    L16:
        if (r2.k != r10) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L25;
        if (r2.l != r11) goto L23;
        boolean r13 = true;
    L24:
        if (r13 == true) goto L26;
    L23:
        r13 = false;
        goto L24
    L18:
        r7 = false;
        goto L19
    L12:
        r0 = false;
    L41:
        r8.recycle();
    }

    public final TextView Y90(Context r5, int r6, int r7, boolean r8) {
        TextView r0 = ca0(r5, r6, 14.0f);
        if (r8 == false) goto L5;
        int r1 = com.larus.common_ui.dbx.theme.a.b(r5, 2130971093);
    L6:
        r0.setTextColor(r1);
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setContentDescription(getString(r6));
        Drawable r9 = r5.getDrawable(r7);
        if (r9 == null) goto L9;
        Drawable r10 = r9.mutate();
    L10:
        if (r10 == null) goto L13;
        r10.setTint(r1);
    L13:
        if (r10 == null) goto L15;
        r10.setBounds(0, 0, U90(16), U90(16));
    L15:
        r0.setCompoundDrawables(r10, null, null, null);
        r0.setCompoundDrawablePadding(U90(4));
        r0.setPadding(U90(8), 0, U90(8), 0);
        GradientDrawable r11 = new GradientDrawable();
        r11.setCornerRadius(U90(8));
        r11.setColor(0);
        int r12 = U90(1);
        if (r8 == false) goto L18;
        int r13 = 1718002943;
    L19:
        r11.setStroke(r12, r13);
        r0.setBackground(r11);
        r0.setClickable(true);
        r0.setFocusable(true);
        return r0;
    L18:
        r13 = 536870911;
        goto L19
    L9:
        r10 = null;
        goto L10
    L5:
        r1 = -1;
        goto L6
    }
}
