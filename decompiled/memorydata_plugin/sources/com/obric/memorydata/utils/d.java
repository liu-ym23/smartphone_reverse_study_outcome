package com.obric.memorydata.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.memory.ui.settings.SmartMemorySettingsViewModel;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\u00020\u0016*\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/utils/AppUtils;", "", "<init>", "()V", "TAG", "", "AGENT_EXECUTION_ENGINE", "isAssistantPackageName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isInstalled", "context", "Landroid/content/Context;", "pkg", "openAppStore", "", "clearAppUserData", "getVersionCode", "", "pkgName", "getVersionName", "compareVer", "", "current", TypedValues.AttributesType.S_TARGET, "getPackageMetaIntValue", "key", "getPUIOSVersion", "safeToInt", "defValue", "Packages", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13204a = null;

    static {
        f13204a = new d();
    }

    private d() {
    }

    static /* synthetic */ int a(d r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.a(r1, r2);
    }

    private final int a(String r1, int r2) {
        Integer r0 = StringsKt.toIntOrNull(r1);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0.intValue();
    }

    public final int a(String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "current");
        Intrinsics.checkNotNullParameter(r15, TypedValues.AttributesType.S_TARGET);
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(a(f13204a, (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin"), 0, 1, null)));
        goto L4
    L6:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r13.iterator();
    L8:
        if (r110.hasNext() == false) goto L10;
        r19.add(Integer.valueOf(a(f13204a, (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin"), 0, 1, null)));
        goto L8
    L10:
        List r111 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        int r112 = Math.max(r18.size(), r111.size());
        int r2 = 0;
    L11:
        if (r2 >= r112) goto L26;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r18, r2), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
        int r4 = r3.intValue();
    L16:
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r111, r2), Integer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L19;
        int r6 = r5.intValue();
    L20:
        if (r4 > r6) goto L21;
        if (r4 < r6) goto L23;
        r2 = r2 + 1;
        goto L11
    L23:
        return -1;
    L21:
        return 1;
    L19:
        r6 = 0;
        goto L20
    L15:
        r4 = 0;
        goto L16
    L26:
        return 0;
    }

    public final String a() {
        String r1 = Build.DISPLAY;
        Intrinsics.checkNotNullExpressionValue(r1, "DISPLAY");
        return r1;
    }

    public final void a(Context r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        kotlinx.coroutines.i.a(kotlinx.coroutines.am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AppUtils$clearAppUserData$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final boolean a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "pkg");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r6.getPackageManager().getPackageInfo(r5, 0);     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r7) == false) goto L11;
        r7 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean a(String r1) {
        if (Intrinsics.areEqual(r1, "com.obric.assistant") == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, AppInfo.OAssistant.getPackageName()) == true) goto L12;
        if (Intrinsics.areEqual(r1, AppInfo.ASSISTANT_AI_AGENT.getPackageName()) == true) goto L12;
        if (Intrinsics.areEqual(r1, AppInfo.OExecutionEngine.getPackageName()) == true) goto L12;
        return false;
    }

    public final void b(Context r5, String r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intent r7 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L22
        r7.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Exception -> L22
        if (Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R") == false) goto L10;
        r7.setData(Uri.parse("https://app.mi.com/details?id=" + r6));     // Catch: Exception -> L22
        if (r7.resolveActivity(r4.getPackageManager()) == null) goto L18;
        ZeusTransformUtils.startActivity(r4, r7, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        return;
    L18:
        r7.setData(Uri.parse("market://details?id=" + r6));     // Catch: Exception -> L22
        r7.setPackage(null);     // Catch: Exception -> L22
        if (r7.resolveActivity(r4.getPackageManager()) == null) goto L26;
        ZeusTransformUtils.startActivity(r4, r7, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        return;
    L26:
        return;
    L10:
        r7.setData(Uri.parse("market://details?id=" + r6));     // Catch: Exception -> L22
        r7.setPackage(SmartMemorySettingsViewModel.STORE_PACKAGE_NAME);     // Catch: Exception -> L22
        if (r7.resolveActivity(r4.getPackageManager()) == null) goto L14;
        ZeusTransformUtils.startActivity(r4, r7, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        return;
    L14:
        r7.setPackage("zte.com.market");     // Catch: Exception -> L22
        if (r7.resolveActivity(r4.getPackageManager()) == null) goto L18;
        ZeusTransformUtils.startActivity(r4, r7, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
    }
}
