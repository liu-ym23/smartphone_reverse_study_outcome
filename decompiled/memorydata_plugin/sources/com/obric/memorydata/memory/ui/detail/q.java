package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.content.Intent;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.az;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R,\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/LinkRouter;", "", "<init>", "()V", "TAG", "", "handlers", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "dispatch", "context", "link", "handleSms", "raw", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f10871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Function2<Context, String, Unit>> f10872b = null;

    static {
        f10871a = new q();
        f10872b = MapsKt.mapOf(new Pair[]{TuplesKt.to("phone:", $$Lambda$q$xSViKEYzGcOLaXF9Ol2DucOO8A.INSTANCE), TuplesKt.to("call:", $$Lambda$q$F5d1NZuO9BHJBTJOwiYWnOvJGs.INSTANCE), TuplesKt.to("smsto:", $$Lambda$q$yebVPtw8ICw4AmaFQJ3dh3A2bQY.INSTANCE), TuplesKt.to("contact:", $$Lambda$q$CAfas6boEu3AAwjSVAxARzBUZlI.INSTANCE), TuplesKt.to("map:", $$Lambda$q$QkEIdVoT1_eE8oUHWejbMJIGZgo.INSTANCE), TuplesKt.to("identifier:", $$Lambda$q$i1vqxrH2RT5zyHvenWv39KHJbdA.INSTANCE)});
    }

    private q() {
    }

    private static final Unit a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "defaultMapPackageName");
        com.obric.memorydata.memory.ui.settings.l.f11479a.a().a(r1);
        return Unit.INSTANCE;
    }

    private final void b(Context r6, String r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        MatchResult r8 = Regex.find$default(new Regex("[?&]body=([^&]+)"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r8 == null) goto L17;
        List<String> r9 = r8.getGroupValues();
        if (r9 == null) goto L17;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.get(1), String.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Object r2 = Result.m1421constructorimpl(URLDecoder.decode(r10, RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L10
    L12:
        Object r11 = r10;
        if (Result.m1427isFailureimpl(r2) == true) goto L16;
        r11 = r2;
    L16:
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
    L18:
        Intent r13 = com.obric.memorydata.utils.z.f13269a.a(StringsKt.substringBefore$default(r7, '?', null, 2, null), r12);
        r13.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ZeusTransformUtils.startActivity(r5, r13, "com.obric.memorydata.plugin");
        return;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        r12 = null;
        goto L18
    }

    private static final Unit c(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        com.obric.memorydata.markdown.custom.j.f9994a.d(r4, r3);
        return Unit.INSTANCE;
    }

    private static final Unit d(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        com.obric.memorydata.markdown.custom.j.f9994a.d(r4, r3);
        return Unit.INSTANCE;
    }

    private static final Unit e(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        f10871a.b(r4, r3);
        return Unit.INSTANCE;
    }

    private static final Unit f(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        ZeusTransformUtils.startActivity(r4, com.obric.memorydata.utils.z.f13269a.b(r3), "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private static final Unit g(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "ctx");
        Intrinsics.checkNotNullParameter(r5, BaseSwitches.V);
        com.obric.memorydata.markdown.custom.e.f9983a.a(r6, r5, (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().e().c(), String.class, "com.obric.memorydata.plugin"), $$Lambda$q$jWXzkbJ0yyVrzjaWAhNZwbGAE.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final Unit h(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ctx");
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        com.obric.memorydata.markdown.custom.c.f9982a.a(r4, r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$CAfas6boEu3AAwjSVAxARzBUZlI(Context r0, String r1) {
        return f(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$F5d1-NZuO9BHJBTJOwiYWnOvJGs, reason: not valid java name */
    public static /* synthetic */ Unit m850lambda$F5d1NZuO9BHJBTJOwiYWnOvJGs(Context r0, String r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ Unit lambda$QkEIdVoT1_eE8oUHWejbMJIGZgo(Context r0, String r1) {
        return g(r0, r1);
    }

    public static /* synthetic */ Unit lambda$i1vqxrH2RT5zyHvenWv39KHJbdA(Context r0, String r1) {
        return h(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$jWXzkbJ0yyVr-z-jaWAhNZwbGAE, reason: not valid java name */
    public static /* synthetic */ Unit m851lambda$jWXzkbJ0yyVrzjaWAhNZwbGAE(String r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$x-SViKEYzGcOLaXF9Ol2DucOO8A, reason: not valid java name */
    public static /* synthetic */ Unit m852lambda$xSViKEYzGcOLaXF9Ol2DucOO8A(Context r0, String r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ Unit lambda$yebVPtw8ICw4AmaFQJ3dh3A2bQY(Context r0, String r1) {
        return e(r0, r1);
    }

    public final void a(Context r7, String r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r8, "link");
        Iterator<Map.Entry<String, Function2<Context, String, Unit>>> r9 = f10872b.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(r1.getValue(), Function2.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default(r8, r2, false, 2, null) == false) goto L4;
        String r10 = az.c(r8);
        RunLog.INSTANCE.debug("LinkRouter", "link: " + r8 + ", decodedLink: " + r10);
        r3.invoke(r6, StringsKt.removePrefix(r10, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")));
        return;
    L9:
        com.obric.memorydata.markdown.custom.m.f9998a.a(r6, r8);
    }
}
