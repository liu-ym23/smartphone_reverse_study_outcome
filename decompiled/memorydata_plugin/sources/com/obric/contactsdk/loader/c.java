package com.obric.contactsdk.loader;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.gson.Gson;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001e\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b\u001a1\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u0007¨\u0006 "}, d2 = {"AUTHORITY", "", "CALL_FEATURE_PATH", "CALL_FEATURE_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getCALL_FEATURE_URI", "()Landroid/net/Uri;", "CALL_FLAG_SPLIT", "PARAM_ACTION_CALL_FEATURE_TYPE_DELETE", "PARAM_ACTION_CALL_FEATURE_TYPE_INSERT", "PARAM_ACTION_CALL_FEATURE_TYPE_UPDATE", "PARAM_KEY_ACTION", "PARAM_KEY_CALL_FlAG", "SCHEME_CONTENT", "callFeatureUri", "getCallFeatureUri", "callFeatureUri$delegate", "Lkotlin/Lazy;", "getCallCreateTimeAndPhoneNumber", "Lkotlin/Pair;", "callFlag", "getCallFeatureEntity", "Lcom/obric/contactsdk/loader/CallFeatureEntity;", "contentResolver", "Landroid/content/ContentResolver;", "callCreateTime", "", "selection", "selectionArgs", "", "(Landroid/content/ContentResolver;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/contactsdk/loader/CallFeatureEntity;", "contactsdk_debug"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f7864a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f7865b = null;

    static {
        f7864a = new Uri.Builder().scheme(Params.CONTENT).authority("call_log_obric").path("call_feature").build();
        f7865b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(CallFeatureEntityUtilKt$callFeatureUri$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final Uri a() {
        return f7864a;
    }

    public static final b a(ContentResolver r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "contentResolver");
        return a(r2, a.f7860a.b() + "=?", new String[]{String.valueOf(r3)});
    }

    private static final b a(ContentResolver r8, String r9, String[] r10) {
        Cursor r11 = ZeusProviderTransform.query(r8, b(), null, r9, r10, null, null, "com.obric.memorydata.plugin");
        if (r11 == null) goto L50;
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r13 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        if (r13.moveToFirst() == true) goto L9;
        CloseableKt.closeFinally(r12, null);
        return null;
    L9:
        int r1 = r13.getColumnIndex(a.f7860a.a());     // Catch: Throwable -> L45
        if (r1 != (-1)) goto L14;
        Log.e("", "Get index error! Return.");     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r12, null);
        return null;
    L14:
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        String r14 = r13.getString(r1);     // Catch: Throwable -> L20
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L23:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        boolean r5 = false;
        if (r4 != null) goto L26;
    L29:
        boolean r6 = true;
    L30:
        boolean r7 = !r6;     // Catch: Throwable -> L45
        if (r7 == false) goto L42;
        CallSummary r15 = (CallSummary) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r14, CallSummary.class), CallSummary.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        String r16 = r15.getSummaryStr();     // Catch: Throwable -> L45
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r15.getTodoListStr(), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L45
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        if (r0 != null) goto L35;
    L38:
        boolean r17 = true;
    L39:
        if (r17 == true) goto L41;
        r5 = true;
    L41:
        String r18 = r15.getTitle();     // Catch: Throwable -> L45
        r14 = r16;
        r7 = r5;
    L43:
        b r19 = new b(r7, r14, r2, r18);     // Catch: Throwable -> L45
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r12, null);
        return r19;
    L35:
        if (r0.length() == 0) goto L38;
        r17 = false;
        goto L39
    L42:
        r18 = null;
        goto L43
    L26:
        if (r4.length() == 0) goto L29;
        r6 = false;
    L18:
        th = th;
    L22:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L45
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L45
    L20:
        th = th;
        r14 = null;
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L50:
        return null;
    }

    public static final Pair<String, String> a(String r11) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L26;
        return null;
    L26:
        List r12 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"@@"}, false, 0, 6, null);     // Catch: Throwable -> L23
        String r2 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r12, 0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r2 == null) goto L22;
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L23
        if (r3 == null) goto L22;
        String r13 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r12, 1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r13 != null) goto L20;
        return null;
    L20:
        return new Pair(r3, r13);
    L22:
        return null;
    L23:
        th = move-exception;
        System.out.println("Error getCallCreateTimeAndPhoneNumber to list: " + th.getMessage());
        return null;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public static final Uri b() {
        return (Uri) ZeusTransformUtils.preCheckCast(f7865b.getValue(), Uri.class, "com.obric.memorydata.plugin");
    }
}
