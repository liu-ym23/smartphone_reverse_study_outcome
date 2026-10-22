package com.obric.assistant.interaction.impl.window;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B+\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJS\u0010\r\u001a\u00020\u000e\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u0010\"\n\b\u0001\u0010\u0011*\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00110\u00152\u0006\u0010\u0016\u001a\u0002H\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowActivityResultRegistry;", "Landroidx/activity/result/ActivityResultRegistry;", "hostActivityProvider", "Lkotlin/Function0;", "Landroid/app/Activity;", "startProxyActivity", "Lkotlin/Function1;", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "mainHandler", "Landroid/os/Handler;", "onLaunch", "", "I", "", "O", "requestCode", "", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "dispatchRawResult", "resultCode", "data", "Landroid/content/Intent;", "isChatLocalFileSelectRequest", MemorySourceLinkType.INTENT, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowActivityResultRegistry extends ActivityResultRegistry {
    public static final Companion Companion = null;
    private static final String TAG = "ChatWindowActivityResultRegistry";
    private final Function0<Activity> hostActivityProvider;
    private final Handler mainHandler;
    private final Function1<ActivityProxyListener, Boolean> startProxyActivity;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowActivityResultRegistry$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ChatWindowActivityResultRegistry r0, int r1, ActivityResultContract.SynchronousResult r2) {
        onLaunch$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void b(ChatWindowActivityResultRegistry r0, int r1) {
        onLaunch$lambda$0(r0, r1);
    }

    public static /* synthetic */ void c(WeakReference r0, ChatWindowActivityResultRegistry r1, int r2, int r3, Intent r4) {
        onLaunch$dispatchResultAndRelease$lambda$2(r0, r1, r2, r3, r4);
    }

    private final boolean isChatLocalFileSelectRequest(Intent r5) {
        if (Intrinsics.areEqual(r5.getAction(), "android.intent.action.GET_CONTENT") == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getType(), "*/*") == false) goto L18;
        Set<String> r0 = r5.getCategories();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L14;
        return false;
    L14:
        if (r5.getBooleanExtra("android.intent.extra.ALLOW_MULTIPLE", false) == false) goto L20;
        return true;
    L20:
        return false;
    L9:
        if (r0.contains("android.intent.category.OPENABLE") != true) goto L11;
        r1 = true;
        goto L12
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatWindowActivityResultRegistry(Function0<? extends Activity> r2, Function1<? super ActivityProxyListener, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "hostActivityProvider");
        Intrinsics.checkNotNullParameter(r3, "startProxyActivity");
        this.hostActivityProvider = r2;
        this.startProxyActivity = r3;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static Bundle INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivityResultRegistry_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    private static final void onLaunch$lambda$0(ChatWindowActivityResultRegistry r2, int r3) {
        r2.dispatchResult(r3, 0, null);
    }

    private static final void onLaunch$lambda$1(ChatWindowActivityResultRegistry r0, int r1, ActivityResultContract.SynchronousResult r2) {
        r0.dispatchResult(r1, r2.getValue());
    }

    public final boolean dispatchRawResult(int r1, int r2, Intent r3) {
        return dispatchResult(r1, r2, r3);
    }

    public <I, O> void onLaunch(final int r15, ActivityResultContract<I, O> r16, I r17, ActivityOptionsCompat r18) {
        Intrinsics.checkNotNullParameter(r16, "contract");
        Activity r2 = (Activity) this.hostActivityProvider.invoke();
        if (r2 != null) goto L6;
        this.mainHandler.post(new j(this, r15));
        return;
    L6:
        final ActivityResultContract.SynchronousResult r3 = r16.getSynchronousResult(r2, r17);
        if (r3 == null) goto L10;
        this.mainHandler.post(new k(this, r15, r3));
        return;
    L10:
        Intent r4 = r16.createIntent(r2, r17);
        Bundle r0 = r4.getExtras();
        if (r0 != null) goto L13;
    L15:
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        if (r4.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE") == false) goto L18;
        r5.element = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivityResultRegistry_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r4, "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        r4.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
    L20:
        boolean r1 = isChatLocalFileSelectRequest(r4);
        if (r1 == false) goto L23;
        WeakReference<Dialog> r6 = PopupOrDialogVisibilityTracker.INSTANCE.retainActiveWindowDialog$impl_mainlandRelease();
    L24:
        WeakReference<Dialog> r7 = r6;
        if (r1 == false) goto L31;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("launch local file picker requestCode=");
        r9.append(r15);
        r9.append(" retained=");
        if (r7 == null) goto L29;
        boolean r10 = true;
    L30:
        r9.append(r10);
        r8.i(TAG, r9.toString());
        goto L31
    L29:
        r10 = false;
    L31:
        ChatWindowActivityResultRegistry$onLaunch$listener$1 r11 = new ChatWindowActivityResultRegistry$onLaunch$listener$1(r15, r7, this, r4, r5);
        if (((Boolean) this.startProxyActivity.invoke(r11)).booleanValue() == true) goto L35;
        ChatWindowActivityResultRegistry$onLaunch$listener$1.completeCancelOnce$default(r11, "proxy unavailable, requestCode=" + r15, null, null, false, 8, null);
        return;
    L35:
        return;
    L23:
        r6 = null;
        goto L24
    L18:
        if (r18 == null) goto L20;
        r5.element = r18.toBundle();
        goto L20
    L13:
        if (r0.getClassLoader() != null) goto L15;
        r4.setExtrasClassLoader(r2.getClassLoader());
        goto L15
    }

    public static final /* synthetic */ void access$onLaunch$dispatchResultAndRelease(ChatWindowActivityResultRegistry r0, WeakReference r1, int r2, int r3, Intent r4) {
        onLaunch$dispatchResultAndRelease(r0, r1, r2, r3, r4);
    }

    private static final void onLaunch$dispatchResultAndRelease(final ChatWindowActivityResultRegistry r8, final WeakReference<Dialog> r9, final int r10, final int r11, final Intent r12) {
        r8.mainHandler.post(new l(r9, r8, r10, r11, r12));
    }

    private static final void onLaunch$dispatchResultAndRelease$lambda$2(WeakReference r4, ChatWindowActivityResultRegistry r5, int r6, int r7, Intent r8) {
        if (r4 != null) goto L12;
        r5.dispatchResult(r6, r7, r8);
        return;
    L12:
        FLogger.a.i(TAG, "dispatch local file picker result requestCode=" + r6 + " resultCode=" + r7);     // Catch: Throwable -> L9
        r5.dispatchResult(r6, r7, r8);     // Catch: Throwable -> L9
        PopupOrDialogVisibilityTracker.INSTANCE.releaseWindowDialog$impl_mainlandRelease(r4);
        return;
    L9:
        th = move-exception;
        PopupOrDialogVisibilityTracker.INSTANCE.releaseWindowDialog$impl_mainlandRelease(r4);
        throw th;
    }
}
