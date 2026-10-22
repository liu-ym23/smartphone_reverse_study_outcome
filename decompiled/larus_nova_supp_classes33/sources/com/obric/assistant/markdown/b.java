package com.obric.assistant.markdown;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;
    public static final Set<String> b = null;
    public static final Lazy c = null;

    public b() {
    }

    static {
        a = new b();
        b = SetsKt.setOf(new String[]{"docx", "sheets", "slides", "base", "file", "wiki"});
        c = LazyKt.lazy(new a());
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "link");
        FLogger.a.i("ObricComplexTaskLinkResolver", "handleResolve: show lark url for completed complex task");
        IAgentAppIntentIDL r0 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r0 == null) goto L6;
        r0.showLarkUrl(r3);
        return;
    }

    public static boolean c(String r6) {
        IThirdPartyPlatformAuthorizationProvider r0 = (IThirdPartyPlatformAuthorizationProvider) c.getValue();
        if (r0 == null) goto L32;
        List r1 = r0.a();
        if (r1 == null) goto L33;
        List r2 = r1;
        if ((r2 instanceof Collection) == true) goto L9;
    L11:
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L23;
        String r4 = (String) r3.next();
        if (Intrinsics.areEqual(r6, r4) == false) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L13;
        boolean r7 = true;
    L24:
        if (r7 != true) goto L34;
        return true;
    L34:
        return false;
    L17:
        if (StringsKt.endsWith$default(r6, "." + r4, false, 2, null) == true) goto L20;
        r5 = false;
    L23:
        r7 = false;
        goto L24
    L9:
        if (r2.isEmpty() == false) goto L11;
    L33:
        return false;
    L32:
        return false;
    }

    public static boolean a(String r3, Message r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "link");
        boolean r0 = false;
        String r1 = null;
        if (r5 == true) goto L37;
        if (r4 == null) goto L6;
        Map r6 = r4.getExt();
    L7:
        if (r6 == null) goto L9;
        String r7 = (String) r6.get("o_task_type");
    L11:
        if (Intrinsics.areEqual(r7, "complex_task") == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r6.get("o_task_state"), "complete") == true) goto L37;
        return false;
    L9:
        r7 = null;
        goto L11
    L6:
        r6 = null;
    L37:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L30
        Uri r9 = UriProtector.parse(r3);     // Catch: Throwable -> L30
        String r10 = r9.getHost();     // Catch: Throwable -> L30
        if (r10 == null) goto L19;
        r1 = r10.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L30
    L19:
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        List<String> r11 = r9.getPathSegments();     // Catch: Throwable -> L30
        if (c(r1) == true) goto L24;
    L28:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r0));     // Catch: Throwable -> L30
    L32:
        Boolean r13 = Boolean.FALSE;
        if (Result.isFailure-impl(r12) == false) goto L36;
        r12 = r13;
    L36:
        return ((Boolean) r12).booleanValue();
    L24:
        if (r11.size() != 2) goto L28;
        if (b.contains(ListProtector.get(r11, 0)) == false) goto L28;
        r0 = true;
    L30:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }
}
