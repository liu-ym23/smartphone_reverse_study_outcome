package com.obric.feedback.sdk;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\r\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/feedback/sdk/FeedbackSdk;", "", "()V", "FEEDBACK_PROVIDER_AUTHORITY", "", "METHOD_TRIGGER_FEEDBACK", "TAG", "appInfoProvider", "Lcom/obric/feedback/sdk/IAppInfoProvider;", "application", "Landroid/app/Application;", "logger", "Lcom/obric/feedback/sdk/IFeedbackSdkLogger;", "getAppInfoProvider", "getAppInfoProvider$feedbacksdk_release", "getLogger", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "provider", "triggerFeedback", "Landroid/os/Bundle;", "problemDesc", "customFilePathList", "", "feedbacksdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Application f8038b;
    private static b c;
    private static c d;

    static {
        f8037a = new a();
    }

    private a() {
    }

    public static /* synthetic */ Bundle a(a r1, String r2, List r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = null;
    L6:
        return r1.a(r2, r6);
    }

    public final Bundle a(String r21, List<String> r22) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "problemDesc");
        Application r3 = f8038b;
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getPackageName();
    L6:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        if (r6 != null) goto L9;
    L12:
        boolean r8 = true;
    L14:
        if (r8 == false) goto L20;
        c r0 = d;
        if (r0 == null) goto L18;
        r0.a("FeedbackSdk", "package name is null");
    L18:
        Bundle r2 = new Bundle();
        r2.putBoolean("success", false);
        r2.putString("error_msg", "package name is null");
        return r2;
    L20:
        Application r9 = f8038b;
        if (r9 == null) goto L25;
        ContentResolver r10 = r9.getContentResolver();
        if (r10 == null) goto L25;
        ContentProviderClient r11 = r10.acquireUnstableContentProviderClient("com.obric.feedback.provider");
    L26:
        if (r11 != null) goto L32;
        c r12 = d;
        if (r12 == null) goto L30;
        r12.a("FeedbackSdk", "acquire content provider client failed");
    L30:
        Bundle r13 = new Bundle();
        r13.putBoolean("success", false);
        r13.putString("error_msg", "acquire content provider client failed");
        return r13;
    L32:
        Bundle r14 = new Bundle();
        r14.putString("from_package", r5);
        r14.putString("problem_desc", r21);
        if (r1 == null) goto L36;
        ArrayList<String> r15 = (ArrayList) ZeusTransformUtils.preCheckCast(CollectionsKt.toCollection((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin")), ArrayList.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L36;
    L37:
        r14.putStringArrayList("file_path_list", r15);
        b r16 = c;
        if (r16 == null) goto L40;
        String r17 = r16.a();
    L41:
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L44;
    L47:
        boolean r19 = true;
    L48:
        if (r19 == true) goto L54;
        b r20 = c;
        if (r20 == null) goto L52;
        String r23 = r20.a();
    L53:
        r14.putString(Header.KEY_USER_ID, r23);
        goto L54
    L52:
        r23 = null;
    L54:
        b r24 = c;
        if (r24 == null) goto L57;
        String r25 = r24.b();
    L58:
        CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin");
        if (r26 != null) goto L61;
    L64:
        if (r7 == true) goto L70;
        b r27 = c;
        if (r27 == null) goto L68;
        String r28 = r27.b();
    L69:
        r14.putString("device_id", r28);
        goto L70
    L68:
        r28 = null;
    L70:
        b r29 = c;
        if (r29 == null) goto L73;
        long r30 = r29.c();
    L74:
        r14.putLong("trace_time_window", r30);
        c r31 = d;
        if (r31 == null) goto L77;
        r31.b("FeedbackSdk", "trigger feedback, extras: " + r14);
    L77:
        Bundle r32 = r11.call("trigger_feedback", r21, r14);
        c r33 = d;
        if (r33 == null) goto L81;
        r33.b("FeedbackSdk", "trigger feedback result: " + r32);
    L81:
        if (Build.VERSION.SDK_INT < 24) goto L83;
        r11.close();
    L84:
        StringBuilder r34 = new StringBuilder().append("trigger feedback result: ");
        if (r32 == null) goto L89;
        Set<String> r35 = r32.keySet();
        if (r35 == null) goto L89;
        r4 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r35, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L89:
        Log.i("FeedbackSdk", r34.append(r4).toString());
        return r32;
    L83:
        r11.release();
        goto L84
    L73:
        r30 = 0;
        goto L74
    L61:
        if (r26.length() == 0) goto L64;
        r7 = false;
        goto L64
    L57:
        r25 = null;
        goto L58
    L44:
        if (r18.length() == 0) goto L47;
        r19 = false;
        goto L48
    L40:
        r17 = null;
    L36:
        r15 = new ArrayList();
    L25:
        r11 = null;
        goto L26
    L9:
        if (r6.length() == 0) goto L12;
        r8 = false;
        goto L14
    L5:
        r5 = null;
        goto L6
    }

    public final b a() {
        return c;
    }

    public final void a(Application r2, b r3, c r4) {
        Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "application");
        Intrinsics.checkNotNullParameter(r5, "provider");
        Intrinsics.checkNotNullParameter(r6, "logger");
        f8038b = r1;
        c = r5;
        d = r6;
    }

    public final c b() {
        return d;
    }
}
