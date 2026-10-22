package com.obric.memorydata.personalcontext.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u001e\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n \r*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0018\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/MediaMetaDataUtils;", "", "<init>", "()V", "TAG", "", "AUTHORITY", "AUTHORITY_URI", "Landroid/net/Uri;", "IMG_MAIN_INFO_URI", "START_FORCE_SCAN_URI", "STOP_FORCE_SCAN_URI", "REQUEST_FORE_INDEX_STATE", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "OBSERVE_FORE_INDEX_STATE", "COLUMN_CAPTION_STATE", "COLUMN_TAG_STATE", "OCR_STATE", "DELETED_STATE", "forceIndexStateChangeListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "startMediaMetaForceScan", "stopMediaMetaForceScan", "queryMediaMetaInitElementCount", "", "addForceIndexStateChangeListener", "listener", "notifyForceIndexStateChange", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12374b = null;
    private static final String c = null;
    private static final Uri d = null;
    private static final Uri e = null;
    private static final Uri f = null;
    private static final Uri g = null;
    private static final Uri h = null;
    private static final Uri i = null;
    private static final CopyOnWriteArrayList<Function0<Unit>> j = null;

    static {
        f12373a = new g();
        f12374b = "MediaMetaDataUtils";
        c = "com.obric.mediametadataservice";
        Uri r0 = Uri.parse("content://com.obric.mediametadataservice");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(...)");
        d = r0;
        Uri r1 = Uri.withAppendedPath(r0, "images/main");
        Intrinsics.checkNotNullExpressionValue(r1, "withAppendedPath(...)");
        e = r1;
        Uri r2 = Uri.withAppendedPath(r0, "force_continuous_scan/start");
        Intrinsics.checkNotNullExpressionValue(r2, "withAppendedPath(...)");
        f = r2;
        Uri r3 = Uri.withAppendedPath(r0, "force_continuous_scan/stop");
        Intrinsics.checkNotNullExpressionValue(r3, "withAppendedPath(...)");
        g = r3;
        h = Uri.withAppendedPath(r0, "force_create_policy/running_state/request");
        i = Uri.withAppendedPath(r0, "force_create_policy/running_state/update");
        j = new CopyOnWriteArrayList();
    }

    private g() {
    }

    public final void a() {
        Cursor r0 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.close();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error(f12374b, "startMediaMetaForceScan error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Function0<Unit> r2) {
        Function0<Unit> r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        j.add(r1);
    }

    public final void b() {
        Cursor r0 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), g, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.close();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error(f12374b, "stopMediaMetaForceScan error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final int c() {
        String[] r9 = {"captionState", "tagsState", "ocrState"};
        Cursor r0 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), e, r9, "isDeleted = 0", null, null, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return -1;
    L6:
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        int r4 = 0;
    L8:
        if (r0.moveToNext() == false) goto L20;
        int r5 = 0;
    L11:
        if (r5 >= 3) goto L8;
        String r6 = r9[r5];
        if (r0.getInt(r0.getColumnIndex(r6)) != 0) goto L19;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
    L18:
        r2.put(r6, Integer.valueOf(r8 + 1));
        r4 = r4 + 1;
        goto L19
    L17:
        r8 = 0;
    L19:
        r5 = r5 + 1;
        goto L11
    L20:
        r0.close();
        RunLog.INSTANCE.debug("DatasetAutoEvaluator", "queryMediaMetaInitElementCount: " + r2);
        return r4;
    }

    public final void d() {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(j, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Function0) ZeusTransformUtils.preCheckCast(r3.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
        goto L4
    }
}
