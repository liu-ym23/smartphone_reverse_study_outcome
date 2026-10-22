package com.obric.assistant.markdown;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.bmhome.chat.layout.widget.handler.e;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.obric_action.IObricActionService;
import com.obric.assistant.obric_action.c;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.g;
import com.obric.assistant.obric_action.j;
import com.obric.assistant.spi.markdown.IObricMarkdownResolverService;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0003J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/markdown/ObricMarkdownResolverServiceImpl;", "Lcom/obric/assistant/spi/markdown/IObricMarkdownResolverService;", "<init>", "()V", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "resolve", "", "view", "Landroid/view/View;", "link", "", "enableLinkStyle", "chatMessage", "Lcom/larus/im/bean/message/Message;", "needUnderline", "handleIntentLink", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "uri", "isFromOmniDetailPage", "buildObricActionExpectKey", "findOmniDetailBlockIdFromView", "findBlockIdFromView", "isSkillDetailRouteUri", "Landroid/net/Uri;", "matchesActionHost", "host", "allowedHosts", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMarkdownResolverServiceImpl implements IObricMarkdownResolverService {
    public final CoroutineScope a;

    public static final class a {
    }

    static {
    }

    public ObricMarkdownResolverServiceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "link");
        IObricActionService r0 = c.a();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L82;
        Uri r10 = UriProtector.parse(r9);
        String r3 = r10.getHost();
        LinkedHashSet<String> r4 = d.l.a.b;
        String r5 = null;
        if (r3 == null) goto L12;
        String r6 = r3.toLowerCase(Locale.ROOT);
    L13:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        if (r6.length() != 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L22;
    L43:
        boolean r8 = false;
    L44:
        if (r8 == false) goto L83;
        String r11 = UriProtector.getQueryParameter(r10, "data");
        if (r11 == null) goto L84;
        j.a.getClass();
        if (StringsKt.isBlank(r11) == false) goto L75;
        j.a r12 = null;
    L63:
        if (r12 == null) goto L69;
        String r13 = r12.b();
        if (r13 == null) goto L69;
        if ((!StringsKt.isBlank(r13)) == false) goto L69;
        r5 = r13;
    L69:
        if (r5 != null) goto L71;
    L72:
        r1 = true;
    L74:
        return !r1;
    L71:
        if (StringsKt.isBlank(r5) == false) goto L74;
    L75:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L54
        Object r15 = Result.constructor-impl((j.a) ((Gson) j.b.getValue()).fromJson(r11, j.a.class));     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L60;
        FLogger.a.w("ObricSkillDetailActionUtils", "parse failed. data=" + r11 + ", " + r16.getMessage(), r16);
    L60:
        if (Result.isFailure-impl(r15) == false) goto L62;
        r15 = null;
    L62:
        r12 = (j.a) r15;
    L54:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L84:
        return false;
    L83:
        return false;
    L22:
        if ((r4 instanceof Collection) == true) goto L24;
    L26:
        Iterator<T> r18 = r4.iterator();
    L28:
        if (r18.hasNext() == false) goto L43;
        String r19 = ((String) r18.next()).toLowerCase(Locale.ROOT);
        if (StringsKt.endsWith$default(r6, r19, false, 2, null) == true) goto L33;
    L40:
        boolean r20 = false;
    L41:
        if (r20 == false) goto L28;
        r8 = true;
        goto L44
    L33:
        if (r6.length() == r19.length()) goto L39;
        int r21 = (r6.length() - r19.length()) - 1;
        if (r21 < 0) goto L40;
        if (r6.charAt(r21) != '.') goto L40;
    L39:
        r20 = true;
        goto L41
    L24:
        if (r4.isEmpty() == false) goto L26;
    L18:
        r7 = false;
        goto L19
    L12:
        r6 = null;
        goto L13
    L82:
        return false;
    L5:
        if (r0.a(r9) != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "link");
        IObricActionService r0 = c.a();
        if (r0 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        if (r0.a(r4) != true) goto L7;
        r5 = true;
        goto L8
    }

    public static String d(View r5, Message r6) {
        Context r0 = r5.getContext();
    L3:
        boolean r2 = true;
        if ((r0 instanceof ContextWrapper) == false) goto L9;
        if ((r0 instanceof yga.a) == true) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L3
    L7:
        boolean r1 = true;
    L10:
        String r3 = null;
        if (r1 == false) goto L35;
        View r4 = r5;
    L13:
        if (r4 == null) goto L26;
        String r7 = (String) e.a(r4, "obric_omni_detail_block_id");
        if (r7 != null) goto L17;
    L22:
        Object r8 = r4.getParent();
        if ((r8 instanceof View) == true) goto L24;
        r4 = null;
        goto L13
    L24:
        r4 = (View) r8;
        goto L13
    L17:
        if ((!StringsKt.isBlank(r7)) == true) goto L20;
        r7 = null;
    L20:
        if (r7 == null) goto L22;
    L27:
        if (r7 != null) goto L29;
    L32:
        if (r2 == true) goto L35;
        return c.a().c("omni_detail", r7);
    L29:
        if (StringsKt.isBlank(r7) == true) goto L32;
        r2 = false;
        goto L32
    L26:
        r7 = null;
    L35:
        IObricActionService r9 = c.a();
        if (r6 == null) goto L38;
        r3 = g.a(r6);
    L38:
        Object r10 = r5.getTag();
        if ((r10 instanceof jc8.b) == true) goto L40;
        Object r11 = r5.getParent();
        if ((r11 instanceof View) == false) goto L46;
        r5 = (View) r11;
        goto L38
    L46:
        FLogger.a.w("ObricMarkdownResolverServiceImpl", "has not found block holder tag");
    L47:
        String r12 = "";
    L49:
        return r9.c(r3, r12);
    L40:
        r12 = ((jc8.b) r10).b;
        if (r12 != null) goto L49;
        FLogger.a.w("ObricMarkdownResolverServiceImpl", "block holder has no blockId: " + r10);
        goto L47
    L9:
        r1 = r0 instanceof yga.a;
        goto L10
    }

    @Deprecated(message = "安全性低，不再扩展功能，当前只支持打开通话记录。统一使用 obric_action:// 新协议")
    public final boolean e(Intent r12, String r13) {
        String r0 = r12.getPackage();
        ComponentName r1 = r12.getComponent();
        FLogger.a.i("ObricMarkdownResolverServiceImpl", "handleIntentLink: intent = " + r12);
        Bundle r2 = r12.getExtras();
        if (r2 == null) goto L14;
        Set<String> r3 = r2.keySet();
        if (r3 == null) goto L14;
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        String r5 = (String) r4.next();
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("handleIntentLink: extra key = ");
        r7.append(r5);
        r7.append(" = ");
        Bundle r8 = r12.getExtras();
        if (r8 == null) goto L12;
        Object r9 = r8.get(r5);
    L13:
        r7.append(r9);
        r6.i("ObricMarkdownResolverServiceImpl", r7.toString());
        goto L8
    L12:
        r9 = null;
    L14:
        FLogger r14 = FLogger.a;
        r14.i("ObricMarkdownResolverServiceImpl", "handleIntentLink: pkg = " + r0 + ", component = " + r1);
        if (Intrinsics.areEqual(r0, "com.android.contacts") == false) goto L23;
        if (r1 == null) goto L18;
        String r10 = r1.getClassName();
    L20:
        if (Intrinsics.areEqual(r10, "com.android.contacts.calllog.record.CallRecordAndSummaryActivity") == false) goto L28;
        r14.i("ObricMarkdownResolverServiceImpl", "handleIntentLink: is call record intent, jump to call record");
        BuildersKt.launch$default(this.a, null, null, new ObricMarkdownResolverServiceImpl$handleIntentLink$2(r13, null), 3, null);
        return true;
    L28:
        return false;
    L18:
        r10 = null;
        goto L20
    L23:
        return false;
    }

    @Override // com.obric.assistant.spi.markdown.IObricMarkdownResolverService
    public final boolean c(View r7, String r8, boolean r9, Message r10) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "link");
        FLogger r0 = FLogger.a;
        r0.i("ObricMarkdownResolverServiceImpl", "resolve: link: " + r8 + ", enableLinkStyle: " + r9);
        boolean r2 = false;
        if (r8.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L58;
        return false;
    L58:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L48
        String r5 = null;
        if (StringsKt.startsWith$default(r8, "intent://#Intent;", false, 2, null) == false) goto L11;
        r2 = e(Intent.parseUri(r8, 4), r8);     // Catch: Throwable -> L48
    L46:
        Object r13 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L48
    L50:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L53;
        FLogger.a.w("ObricMarkdownResolverServiceImpl", "resolve intent failed: " + r14.getMessage(), r14);
    L53:
        Boolean r15 = Boolean.FALSE;
        if (Result.isFailure-impl(r13) == false) goto L57;
        r13 = r15;
    L57:
        return ((Boolean) r13).booleanValue();
    L11:
        if (r10 == null) goto L15;
        Map r16 = r10.getExt();     // Catch: Throwable -> L48
        if (r16 == null) goto L15;
        String r17 = (String) r16.get("o_knowledge_ai");     // Catch: Throwable -> L48
    L17:
        if (Intrinsics.areEqual(r17, "1") == false) goto L21;
        IAgentAppIntentIDL r18 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L48
        if (r18 == null) goto L45;
        r18.showLarkUrl(r8);     // Catch: Throwable -> L48
    L45:
        r2 = true;
        goto L46
    L21:
        Context r19 = r7.getContext();     // Catch: Throwable -> L48
    L23:
        if ((r19 instanceof ContextWrapper) == false) goto L28;
        if ((r19 instanceof yga.a) == true) goto L26;
        r19 = ((ContextWrapper) r19).getBaseContext();     // Catch: Throwable -> L48
        goto L23
    L26:
        boolean r20 = true;
    L29:
        if (r20 == false) goto L33;
        b.a.getClass();     // Catch: Throwable -> L48
        if (b.a(r8, r10, true) == false) goto L33;
        r0.i("ObricMarkdownResolverServiceImpl", "resolve: show lark url from omni detail page");     // Catch: Throwable -> L48
        b.b(r8);     // Catch: Throwable -> L48
    L33:
        if (r10 == null) goto L38;
        Map r21 = r10.getExt();     // Catch: Throwable -> L48
        if (r21 == null) goto L38;
        r5 = (String) r21.get("o_task_type");     // Catch: Throwable -> L48
    L38:
        if (Intrinsics.areEqual(r5, "complex_task") == false) goto L43;
        b.a.getClass();     // Catch: Throwable -> L48
        if (b.a(r8, r10, false) == false) goto L43;
        b.b(r8);     // Catch: Throwable -> L48
    L43:
        if (c.a().a(r8) == false) goto L46;
        c.a().d(r7.getContext(), r8, d(r7, r10));     // Catch: Throwable -> L48
        goto L45
    L28:
        r20 = r19 instanceof yga.a;     // Catch: Throwable -> L48
    L15:
        r17 = null;
    L48:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L5:
        r11 = false;
        goto L6
    }
}
