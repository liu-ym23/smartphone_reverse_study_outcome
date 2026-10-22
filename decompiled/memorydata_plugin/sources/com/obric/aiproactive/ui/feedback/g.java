package com.obric.aiproactive.ui.feedback;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "recordShownInAll", "", "recommendIds", "", "", "nowMillis", "", "recordAdopted", "recommendId", "getShownInAllCountLast7Days", "", "getAdoptedCountLast7Days", "readMap", "Lorg/json/JSONObject;", "key", "writeMap", "obj", "countRecent", "prune", "", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f6657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f6658b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveRecommendationStatsStore$Companion;", "", "<init>", "()V", "KEY_SHOWN_ALL", "", "KEY_ADOPTED", "WINDOW_MILLIS", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6657a = new a(null);
    }

    public g(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f6658b = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("proactive_ui", 0);
    }

    private final JSONObject a(String r4) {
        String r5 = this.f6658b.getString(r4, null);
        if (r5 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r6 = Result.m1421constructorimpl(new JSONObject(r5));     // Catch: Throwable -> L8
    L10:
        JSONObject r7 = new JSONObject();
        if (Result.m1427isFailureimpl(r6) == false) goto L14;
        r6 = r7;
    L14:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        return new JSONObject();
    }

    private final void a(String r1, JSONObject r2) {
        this.f6658b.edit().putString(r1, r2.toString()).apply();
    }

    private final boolean a(JSONObject r5, long r6) {
        long r7 = r6 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS;
        ArrayList r4 = new ArrayList();
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.optLong(r1, 0) >= r7) goto L4;
        r4.add(r1);
        goto L4
    L9:
        if (r4.isEmpty() == false) goto L12;
        return false;
    L12:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r5.remove((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        goto L14
    L16:
        return true;
    }

    public final void a(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "recommendId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        JSONObject r1 = a("stats_adopted_v1");
        if (r1.has(r4) == true) goto L8;
        r1.put(r4, r5);
    L8:
        a(r1, r5);
        a("stats_adopted_v1", r1);
    }

    public final void a(List<String> r9, long r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "recommendIds");
        if (r11.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r2 = a("stats_shown_all_v1");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r3 = false;
        boolean r4 = false;
    L7:
        if (r12.hasNext() == false) goto L14;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        if (r2.has(r5) == true) goto L7;
        r2.put(r5, r10);
        r4 = true;
        goto L7
    L14:
        if (a(r2, r10) == true) goto L16;
        if (r4 == true) goto L16;
    L17:
        if (r3 == false) goto L27;
        a("stats_shown_all_v1", r2);
        return;
    L27:
        return;
    L16:
        r3 = true;
        goto L17
    }
}
