package com.larus.bmhome.utils;

import android.app.Application;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import gw8.c;
import gw8.c$b;
import java.util.List;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.TrackerUtils$trackRdFlowMarkdownParseNodeInfo$1", f = "TrackerUtils.kt", i = {0}, l = {36}, m = "invokeSuspend", n = {"service"}, s = {"L$0"})
public final class TrackerUtils$trackRdFlowMarkdownParseNodeInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ boolean $useSubscribedColor;
    Object L$0;
    int label;

    public TrackerUtils$trackRdFlowMarkdownParseNodeInfo$1(Message r1, boolean r2, Continuation<? super TrackerUtils$trackRdFlowMarkdownParseNodeInfo$1> r3) {
        this.$data = r1;
        this.$useSubscribedColor = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TrackerUtils$trackRdFlowMarkdownParseNodeInfo$1(this.$data, this.$useSubscribedColor, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        c r2 = (c) this.L$0;
        ResultKt.throwOnFailure(r27);
        Object r3 = r27;
    L27:
        List r4 = (List) r3;
        if (r4 == null) goto L30;
        String r5 = CollectionsKt.joinToString$default(r4, "\n", null, null, 0, null, null, 62, null);
        c r10 = r2;
    L32:
        if (r5 == null) goto L36;
    L37:
        String r13 = r5;
        AppHost.Companion r6 = AppHost.a;
        Application r12 = r6.getApplication();
        Lazy r7 = dg8.s.a;
        b r8 = c$b.c(r10, r12, r13, true, dg8.s.a(r6.getApplication(), this.$useSubscribedColor, false, this.$data, null, null, false, false, false, false, 2032), null, null, null, 112);
        if (r8 == null) goto L40;
        JSONObject r9 = new JSONObject();
        int r11 = TrackerUtils.a;
        Stack r14 = new Stack();
        r14.push(r8);
    L43:
        if (r14.isEmpty() == true) goto L51;
        b r15 = (b) r14.pop();
        Intrinsics.checkNotNull(r15);
        String r16 = r10.getNodeReportName(r15);
        if (r9.has(r16) == false) goto L47;
        r9.put(r16, JSONObjectProtectorUtils.getLong(r9, r16) + 1);
    L48:
        b r17 = r15.c;
    L49:
        if (r17 == null) goto L43;
        r14.push(r17);
        r17 = r17.d;
        goto L49
    L47:
        r9.put(r16, 1);
        goto L48
    L51:
        String r18 = this.$data.getMessageId();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r18 != null) goto L59;
    L57:
        TrackParams r19 = new TrackParams().merge(r9);
        by7.a r20 = new by7.a("rd_flow_markdown_parse_node_info");
        r20.a.merge(r19);
        r20.b();
        return Unit.INSTANCE;
    L59:
        r9.put(MusicAppletPage.KEY_MESSAGE_ID, r18);     // Catch: JSONException -> L55
    L55:
        e = move-exception;
        FLogger.a.e("RdEventHelper", "error in RdEventHelper rd_flow_markdown_parse_node_info " + e.getLocalizedMessage());
        goto L57
    L40:
        return Unit.INSTANCE;
    L36:
        r5 = "";
        goto L37
    L30:
        r10 = r2;
    L31:
        r5 = null;
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r27);
        c.a.getClass();
        r10 = c.a.b();
        if (r10 != null) goto L13;
        return Unit.INSTANCE;
    L13:
        if (this.$data.getContentType() == 1) goto L20;
        if (this.$data.getContentType() == 9999) goto L20;
        return Unit.INSTANCE;
    L20:
        if (com.larus.im.bean.message.a.b0(this.$data) == false) goto L34;
        com.larus.bmhome.chat.layout.holder.helper.s0 r21 = ILegacyChatUiServiceDelegate.b.X8();
        if (r21 == null) goto L31;
        List r22 = com.larus.im.bean.message.a.A(this.$data);
        this.L$0 = r10;
        this.label = 1;
        r3 = com.larus.bmhome.chat.layout.holder.helper.s0.a.a(r21, r22, true, null, true, null, this, 20);
        if (r3 != r0) goto L26;
        return r0;
    L26:
        r2 = r10;
        goto L27
    L34:
        r5 = com.larus.bmhome.chat.bean.d.s(this.$data);
        if (r5 != null) goto L37;
        goto L36
    }
}
