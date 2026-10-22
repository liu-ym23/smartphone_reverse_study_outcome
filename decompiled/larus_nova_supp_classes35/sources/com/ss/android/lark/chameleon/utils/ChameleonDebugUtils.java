package com.ss.android.lark.chameleon.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.storage.IKVStorage;
import com.ss.android.lark.chameleon.storage.SPKVStore;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleon/utils/ChameleonDebugUtils;", BuildConfig.FLAVOR, "()V", "DEBUG_VIEW_TAG", BuildConfig.FLAVOR, "KEY_DISABLE_DEBUG_VIEW", "KEY_DISABLE_OFFLINE_RES", "KEY_SPECIFIC_BIZNAME", "KEY_SPECIFIC_RES_PATH", "KEY_SPECIFIC_VERSION", "TAG", "addDebugEntry", BuildConfig.FLAVOR, "viewGroup", "Landroid/view/ViewGroup;", "intervalMs", BuildConfig.FLAVOR, "clickCounts", BuildConfig.FLAVOR, "addDebugView", "config", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "generateDebugInfo", "getActivityFromContext", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "getOfflineResVersion", "chameleonConfig", "getSpecificBizname", "getSpecificResPath", "getSpecificVersion", "isDebugViewDisabled", BuildConfig.FLAVOR, "isOfflineResDisabled", "startDebugActivity", "activity", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonDebugUtils {
    private static final String DEBUG_VIEW_TAG = "chameleon_debug_view";
    public static final ChameleonDebugUtils INSTANCE = null;
    private static final String KEY_DISABLE_DEBUG_VIEW = "chameleon_disable_debug_view";
    private static final String KEY_DISABLE_OFFLINE_RES = "chameleon_disable_offline_res";
    private static final String KEY_SPECIFIC_BIZNAME = "chameleon_specific_bizname";
    private static final String KEY_SPECIFIC_RES_PATH = "chameleon_specific_res_path";
    private static final String KEY_SPECIFIC_VERSION = "chameleon_specific_version";
    private static final String TAG = "ChameleonDebugUtils";

    static {
        INSTANCE = new ChameleonDebugUtils();
    }

    private ChameleonDebugUtils() {
    }

    private final String getSpecificVersion() {
        return IKVStorage.DefaultImpls.getString$default(SPKVStore.INSTANCE, KEY_SPECIFIC_VERSION, null, 2, null);
    }

    private final boolean isDebugViewDisabled() {
        return SPKVStore.INSTANCE.getBoolean(KEY_DISABLE_DEBUG_VIEW, false);
    }

    public final String getSpecificBizname() {
        return IKVStorage.DefaultImpls.getString$default(SPKVStore.INSTANCE, KEY_SPECIFIC_BIZNAME, null, 2, null);
    }

    public final String getSpecificResPath() {
        return IKVStorage.DefaultImpls.getString$default(SPKVStore.INSTANCE, KEY_SPECIFIC_RES_PATH, null, 2, null);
    }

    public final boolean isOfflineResDisabled() {
        return SPKVStore.INSTANCE.getBoolean(KEY_DISABLE_OFFLINE_RES, false);
    }

    private final String generateDebugInfo(ChameleonConfig r12) {
        if (isDebugViewDisabled() == false) goto L5;
        return null;
    L5:
        if (r12 != null) goto L7;
    L27:
        return null;
    L7:
        if (TextUtils.isEmpty(r12.getBizName()) == true) goto L27;
        ArrayList r2 = new ArrayList();
        if (isOfflineResDisabled() == true) goto L23;
        if (Intrinsics.areEqual(getSpecificBizname(), r12.getBizName()) == false) goto L23;
        String r0 = getSpecificVersion();
        if (r0 != null) goto L16;
    L19:
        boolean r1 = true;
    L20:
        if (r1 == true) goto L23;
        r2.add("离线资源版本: " + getSpecificVersion());
        goto L23
    L16:
        if (r0.length() == 0) goto L19;
        r1 = false;
    L23:
        if (r2.isEmpty() == false) goto L26;
        return null;
    L26:
        return "调试:" + r12.getBizName() + '\n' + CollectionsKt.joinToString$default(r2, "\n", null, null, 0, null, null, 62, null);
    }

    private final Activity getActivityFromContext(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof ContextWrapper) == false) goto L12;
        if ((r3 instanceof Activity) == true) goto L10;
        r3 = ((ContextWrapper) r3).getBaseContext();
        goto L6
    L10:
        return (Activity) r3;
    L12:
        return null;
    }

    public final String getOfflineResVersion(ChameleonConfig r3) {
        if (r3 == null) goto L4;
        String r4 = r3.getBizName();
    L6:
        if (Env.isDebug() == false) goto L22;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L22;
        if (isOfflineResDisabled() == false) goto L18;
        return BuildConfig.FLAVOR;
    L18:
        String r6 = getSpecificResPath();
        if (r6 != null) goto L21;
        return BuildConfig.FLAVOR;
    L21:
        return r6;
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
    L22:
        return BuildConfig.FLAVOR;
    L4:
        r4 = null;
        goto L6
    }

    public final void startDebugActivity(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intent r0 = new Intent("com.ss.android.lark.ACTION_CML_DEBUG");     // Catch: Exception -> L7
        r0.addCategory("android.intent.category.DEFAULT");     // Catch: Exception -> L7
        r0.addFlags(268435456);     // Catch: Exception -> L7
        r0.setPackage(r3.getPackageName());     // Catch: Exception -> L7
        if (r0.resolveActivity(r3.getPackageManager()) == null) goto L10;
        r3.startActivity(r0);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public static final /* synthetic */ Activity access$getActivityFromContext(ChameleonDebugUtils r0, Context r1) {
        return r0.getActivityFromContext(r1);
    }

    public final void addDebugView(ChameleonConfig r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Context r0 = r6.getContext();
        if (r0 != null) goto L6;
        return;
    L6:
        if (((TextView) r6.findViewWithTag(DEBUG_VIEW_TAG)) == null) goto L8;
        return;
    L8:
        TextView r2 = new TextView(r0);
        r2.setText(INSTANCE.generateDebugInfo(r5));
        r2.setTag(DEBUG_VIEW_TAG);
        r2.setTextColor(-1);
        r2.setBackgroundColor(r0.getResources().getColor(2131100787));
        r2.setTextSize(12.0f);
        if ((r6 instanceof FrameLayout) == false) goto L12;
        ConstraintLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams) r7).gravity = 8388661;
    L15:
        r7.setMargins(40, 40, 40, 40);
        r2.setLayoutParams(r7);
        r6.addView(r2);
        return;
    L12:
        if ((r6 instanceof ConstraintLayout) == false) goto L14;
        r7 = new ConstraintLayout.LayoutParams(-2, -2);
        r7.endToEnd = 0;
        r7.bottomToBottom = 0;
        goto L15
    L14:
        r7 = new ViewGroup.MarginLayoutParams(-2, -2);
        goto L15
    }

    public final void addDebugEntry(ViewGroup r3, final long r4, final int r6) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        final Context r0 = r3.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = new ChameleonDebugUtils$addDebugEntry$transparentView$1(r0, r4, r6);
        r1.setBackgroundColor(0);
        r1.setClickable(false);
        r3.addView(r1, -1, -1);
    }

    public static /* synthetic */ void addDebugEntry$default(ChameleonDebugUtils r0, ViewGroup r1, long r2, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 1000;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 5;
    L8:
        r0.addDebugEntry(r1, r2, r4);
    }
}
