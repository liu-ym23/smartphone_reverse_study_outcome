package com.ss.android.lark.lynxkit.host;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tqb.d;
import tqb.f;
import tqb.h;
import tqb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxKitHost;", "", "<init>", "()V", "TAG", "", "createView", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "context", "Landroid/content/Context;", "params", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "options", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostOptions;", "createViewHolder", "Lcom/ss/android/lark/lynxkit/host/ILarkLynxViewHolder;", "createPageHolder", "Lcom/ss/android/lark/lynxkit/host/ILarkLynxPageHolder;", "createFragmentHolder", "Lcom/ss/android/lark/lynxkit/host/ILarkLynxFragmentHolder;", "createDialogHolder", "Lcom/ss/android/lark/lynxkit/host/ILarkLynxDialogHolder;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "openPage", "", "showDialog", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxKitHost {
    public static final LarkLynxKitHost INSTANCE = null;
    private static final String TAG = "LynxKitHost";

    static {
        INSTANCE = new LarkLynxKitHost();
    }

    private LarkLynxKitHost() {
    }

    @JvmStatic
    public static final ILarkLynxDialogHolder createDialogHolder(FragmentActivity r2, LarkLynxHostParams r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r3, "params");
        return createDialogHolder$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final ILarkLynxFragmentHolder createFragmentHolder(LarkLynxHostParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return createFragmentHolder$default(r2, null, 2, null);
    }

    @JvmStatic
    public static final ILarkLynxPageHolder createPageHolder(Context r2, LarkLynxHostParams r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        return createPageHolder$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final ILarkLynxContainer createView(Context r2, LarkLynxHostParams r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        return createView$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final ILarkLynxViewHolder createViewHolder(Context r2, LarkLynxHostParams r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        return createViewHolder$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final boolean openPage(Context r2, LarkLynxHostParams r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        return openPage$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final boolean showDialog(FragmentActivity r2, LarkLynxHostParams r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r3, "params");
        return showDialog$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final ILarkLynxFragmentHolder createFragmentHolder(LarkLynxHostParams r1, LarkLynxHostOptions r2) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "options");
        return new b(r1, r2);
    }

    public static void INVOKEVIRTUAL_com_ss_android_lark_lynxkit_host_LarkLynxKitHost_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(LarkLynxDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        LarkLynxDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @JvmStatic
    public static final ILarkLynxDialogHolder createDialogHolder(FragmentActivity r1, LarkLynxHostParams r2, LarkLynxHostOptions r3) {
        Intrinsics.checkNotNullParameter(r1, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "options");
        return new a(r1, r2, r3);
    }

    @JvmStatic
    public static final ILarkLynxPageHolder createPageHolder(Context r1, LarkLynxHostParams r2, LarkLynxHostOptions r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "options");
        return new h(r1, r2, r3);
    }

    @JvmStatic
    public static final ILarkLynxContainer createView(Context r1, LarkLynxHostParams r2, LarkLynxHostOptions r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "options");
        ILarkLynxContainer r4 = tqb.b.a(r1, r2, r3, null);
        if (r3.getRenderOnCreateView() == false) goto L5;
        tqb.b.c(r4, r2);
    L5:
        return r4;
    }

    @JvmStatic
    public static final ILarkLynxViewHolder createViewHolder(Context r1, LarkLynxHostParams r2, LarkLynxHostOptions r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "options");
        return new i(r1, r2, r3);
    }

    @JvmStatic
    public static final boolean openPage(Context r4, LarkLynxHostParams r5, LarkLynxHostOptions r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "options");
        if (tqb.b.b(r5) == true) goto L7;
        Log.e(TAG, "openPage failed, templateUrl and templatePath are empty");
        return false;
    L7:
        if ((r4 instanceof Activity) == false) goto L14;
        Activity r0 = (Activity) r4;
        if (r0.isFinishing() == false) goto L11;
    L12:
        Log.e(TAG, "openPage failed, activity is finishing or destroyed");
        return false;
    L11:
        if (r0.isDestroyed() == true) goto L12;
    L14:
        String r7 = f.b(r5, r6, true, null);
        Intent r8 = new Intent(r4, LarkLynxPageActivity.class).putExtra("extra_lynx_host_id", r7);     // Catch: Throwable -> L20
        if ((r4 instanceof Activity) == true) goto L18;
        r8.addFlags(268435456);     // Catch: Throwable -> L20
    L18:
        r4.startActivity(r8);     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        ConcurrentHashMap<String, d> r9 = f.a;
        f.c(r7);
        Log.e(TAG, "openPage failed", th);
        return false;
    }

    @JvmStatic
    public static final boolean showDialog(FragmentActivity r5, LarkLynxHostParams r6, LarkLynxHostOptions r7) {
        Intrinsics.checkNotNullParameter(r5, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "options");
        if (tqb.b.b(r6) == true) goto L7;
        Log.e(TAG, "showDialog failed, templateUrl and templatePath are empty");
        return false;
    L7:
        if (r5.isFinishing() == false) goto L9;
    L21:
        Log.e(TAG, "showDialog failed, activity is finishing or destroyed");
        return false;
    L9:
        if (r5.isDestroyed() == true) goto L21;
        FragmentManager r8 = r5.getSupportFragmentManager();
        if (r8.isStateSaved() == false) goto L15;
        Log.e(TAG, "showDialog failed, fragment manager state saved");
        return false;
    L15:
        String r9 = f.b(r6, r7, true, null);
        int r10 = LarkLynxDialogFragment.j;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r9, "hostId");     // Catch: Throwable -> L18
        LarkLynxDialogFragment r11 = new LarkLynxDialogFragment();     // Catch: Throwable -> L18
        Bundle r0 = new Bundle();     // Catch: Throwable -> L18
        r0.putString("extra_lynx_host_id", r9);     // Catch: Throwable -> L18
        r11.setArguments(r0);     // Catch: Throwable -> L18
        INVOKEVIRTUAL_com_ss_android_lark_lynxkit_host_LarkLynxKitHost_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r11, r8, "LynxDialogFragment");     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        ConcurrentHashMap<String, d> r12 = f.a;
        f.c(r9);
        Log.e(TAG, "showDialog failed", th);
        return false;
    }

    public static /* synthetic */ ILarkLynxFragmentHolder createFragmentHolder$default(LarkLynxHostParams r19, LarkLynxHostOptions r20, int r21, Object r22) {
        if ((r21 & 2) == 0) goto L5;
        LarkLynxHostOptions r0 = new LarkLynxHostOptions(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    L7:
        return createFragmentHolder(r19, r0);
    L5:
        r0 = r20;
        goto L7
    }

    public static /* synthetic */ ILarkLynxDialogHolder createDialogHolder$default(FragmentActivity r19, LarkLynxHostParams r20, LarkLynxHostOptions r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        LarkLynxHostOptions r0 = new LarkLynxHostOptions(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    L7:
        return createDialogHolder(r19, r20, r0);
    L5:
        r0 = r21;
        goto L7
    }

    public static /* synthetic */ ILarkLynxPageHolder createPageHolder$default(Context r19, LarkLynxHostParams r20, LarkLynxHostOptions r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        LarkLynxHostOptions r0 = new LarkLynxHostOptions(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    L7:
        return createPageHolder(r19, r20, r0);
    L5:
        r0 = r21;
        goto L7
    }

    public static /* synthetic */ ILarkLynxContainer createView$default(Context r19, LarkLynxHostParams r20, LarkLynxHostOptions r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        LarkLynxHostOptions r0 = new LarkLynxHostOptions(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    L7:
        return createView(r19, r20, r0);
    L5:
        r0 = r21;
        goto L7
    }

    public static /* synthetic */ ILarkLynxViewHolder createViewHolder$default(Context r19, LarkLynxHostParams r20, LarkLynxHostOptions r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        LarkLynxHostOptions r0 = new LarkLynxHostOptions(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    L7:
        return createViewHolder(r19, r20, r0);
    L5:
        r0 = r21;
        goto L7
    }

    public static /* synthetic */ boolean openPage$default(Context r19, LarkLynxHostParams r20, LarkLynxHostOptions r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        LarkLynxHostOptions r0 = new LarkLynxHostOptions(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    L7:
        return openPage(r19, r20, r0);
    L5:
        r0 = r21;
        goto L7
    }

    public static /* synthetic */ boolean showDialog$default(FragmentActivity r19, LarkLynxHostParams r20, LarkLynxHostOptions r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        LarkLynxHostOptions r0 = new LarkLynxHostOptions(false, null, null, null, null, null, null, null, 0, 0, 0, 0.0f, false, false, 0, 32767, null);
    L7:
        return showDialog(r19, r20, r0);
    L5:
        r0 = r21;
        goto L7
    }
}
