package com.larus.ugc.perf.impl;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.chat.trace.j;
import com.larus.im.bean.message.Message;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements nq9.f {
    public static final h a = null;

    public h() {
    }

    static {
        a = new h();
        int r0 = f1a.a.a;
        FLogger.a.i("UgcPerfConfig", "init with img, and lyrics to song observer. ");
    }

    @Override // nq9.f
    public final void b() {
        i1a.a r0 = i1a.a.a;
    }

    @Override // nq9.f
    public final OldUgcGenImgPerfMonitor a(boolean r1) {
        if (r1 == false) goto L5;
        return com.larus.ugc.perf.impl.genimg.d.d;
    L5:
        return com.larus.ugc.perf.impl.genimg.e.d;
    }

    @Override // nq9.f
    public final void d(j r5) {
        Intrinsics.checkNotNullParameter("MusicCreateMob", "key");
        Intrinsics.checkNotNullParameter(r5, "listener");
        f.a.getClass();
        Intrinsics.checkNotNullParameter("MusicCreateMob", "key");
        Intrinsics.checkNotNullParameter(r5, "listener");
        f.d.put("MusicCreateMob", r5);
    }

    @Override // nq9.f
    public final void o4(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        f.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "msg");
        String r0 = r5.getReplyId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        e r1 = f.b(r0);
        if (r1 == null) goto L35;
        r1.k(r5.getMessageId());
        r1.j(r5.getContentType());
        r1.a = r5;
        if (com.larus.im.bean.message.a.r0(r5) == true) goto L10;
    L29:
        d r6 = f.c.get(Integer.valueOf(r5.getContentType()));
        if (r6 == null) goto L38;
        r6.a(r1);
        return;
    L38:
        return;
    L10:
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"image", "avatar_image", "ai_beautify_image"}), ap8.a.b(r5)) == false) goto L29;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        Map r7 = r5.getExt();     // Catch: Throwable -> L20
        if (r7 == null) goto L17;
        String r8 = (String) r7.get("creativity_resp_num");     // Catch: Throwable -> L20
        if (r8 == null) goto L17;
        int r9 = CastIntegerProtector.parseInt(r8);     // Catch: Throwable -> L20
    L18:
        Object r10 = Result.constructor-impl(Integer.valueOf(r9));     // Catch: Throwable -> L20
    L23:
        if (Result.exceptionOrNull-impl(r10) == null) goto L26;
        r10 = 0;
    L26:
        r1.h(((Number) r10).intValue());
        d r11 = f.c.get(6);
        if (r11 == null) goto L36;
        r11.h(r1);
        return;
    L36:
        return;
    L17:
        r9 = 0;
    L20:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    @Override // nq9.f
    public final void e(String r4, ISDKPointCallback.EndMsg r5) {
        Intrinsics.checkNotNullParameter(r5, "endMsg");
        f.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "endMsg");
        e r6 = f.b(r4);
        if (r6 == null) goto L11;
        d r0 = f.c.get(Integer.valueOf(r5.getContentType()));
        if (r0 == null) goto L7;
        r0.d(r6);
    L7:
        Iterator<T> r7 = f.d.values().iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        ((Function2) r7.next()).invoke(r5.getId(), Integer.valueOf(r5.getContentType()));
        goto L9
    L13:
        return;
    }

    @Override // nq9.f
    public final void f(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "localSendMsgId");
        f.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "localSendMsgId");
        boolean r1 = true;
        if ((!StringsKt.isBlank(r5)) == false) goto L18;
        if (r6 != null) goto L6;
    L9:
        if (r1 == true) goto L19;
        LruCache<String, e> r0 = f.b;
        e r7 = r0.remove(r5);
        if (r7 == null) goto L20;
        r0.put(r6, r7);
        long r2 = System.currentTimeMillis();
        r7.n(Long.valueOf(r2));
        Long r8 = r7.d();
        if (r8 == null) goto L15;
        long r3 = r8.longValue();
    L16:
        r7.l(Long.valueOf(r2 - r3));
        return;
    L15:
        r3 = 0;
        goto L16
    L20:
        return;
    L19:
        return;
    L6:
        if (StringsKt.isBlank(r6) == true) goto L9;
        r1 = false;
        goto L9
    }

    @Override // nq9.f
    public final void c(String r2, String r3, int r4) {
        f.a.getClass();
        e r5 = f.b(r2);
        if (r5 == null) goto L8;
        r5.k(r3);
        r5.j(r4);
        d r6 = f.c.get(Integer.valueOf(r4));
        if (r6 == null) goto L9;
        r6.c(r5);
        return;
    L9:
        return;
    }

    @Override // nq9.f
    public final void g(String r7, String r8, String r9, int r10, String r11, String r12, List<Message> r13, long r14) {
        Intrinsics.checkNotNullParameter(r7, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r8, "cvsId");
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "convType");
        f.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "convType");
        if (StringsKt.isBlank(r7) == true) goto L108;
        boolean r15 = Intrinsics.areEqual("regen", r9);
        e r0 = new e(null);
        r0.p(Long.valueOf(r14));
        r0.e(r11);
        String r16 = "1";
        if (Intrinsics.areEqual("group", r12) == false) goto L8;
        String r17 = "1";
    L9:
        r0.g(r17);
        int r18 = 6;
        if (Intrinsics.areEqual("batch", r9) == false) goto L79;
        boolean r19 = false;
        if (r13 == null) goto L30;
        List<Message> r110 = r13;
        if ((r110 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r111 = r110.iterator();
    L20:
        if (r111.hasNext() == false) goto L30;
        Message r3 = (Message) r111.next();
        if (r3.getContentType() != 6) goto L24;
    L27:
        boolean r4 = true;
    L28:
        if (r4 == false) goto L20;
        boolean r112 = true;
    L31:
        if (r13 == null) goto L54;
        List<Message> r5 = r13;
        if ((r5 instanceof Collection) == true) goto L35;
    L37:
        Iterator<T> r6 = r5.iterator();
    L39:
        if (r6.hasNext() == false) goto L54;
        Message r20 = (Message) r6.next();
        if (r20.getContentType() != 1) goto L51;
        String r21 = r20.getContent();
        if (r21 != null) goto L45;
    L48:
        boolean r22 = true;
    L49:
        if (r22 == true) goto L51;
        boolean r23 = true;
    L52:
        if (r23 == false) goto L39;
        boolean r24 = true;
    L55:
        if (r13 == null) goto L72;
        List<Message> r113 = r13;
        if ((r113 instanceof Collection) == true) goto L59;
    L61:
        Iterator<T> r114 = r113.iterator();
    L63:
        if (r114.hasNext() == false) goto L72;
        Message r25 = (Message) r114.next();
        if (r25.getContentType() == 6) goto L67;
    L69:
        boolean r26 = false;
    L70:
        if (r26 == false) goto L63;
        r19 = true;
        goto L72
    L67:
        if (IAIChatControlTraceService.a.ib(r25.getExt()) == false) goto L69;
        r26 = true;
        goto L70
    L59:
        if (r113.isEmpty() == false) goto L61;
    L72:
        if (r19 == false) goto L76;
        if (r24 == true) goto L82;
        r18 = 4;
    L82:
        r0.i(Integer.valueOf(r18));
        if (r15 == true) goto L86;
        r16 = "0";
    L86:
        r0.o(r16);
        if (TextUtils.isEmpty(r7) == true) goto L91;
        if (r7 == null) goto L91;
        e r27 = f.b.put(r7, r0);
    L91:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MessageLruSourceImpl$onStartSendMsg$1(r0, r11, null), 3, null);
        return;
    L76:
        if (r112 == false) goto L81;
        if (r24 == false) goto L80;
        r18 = 3;
    L80:
        r18 = 1;
    L81:
        r18 = 2;
        goto L82
    L45:
        if (StringsKt.isBlank(r21) == true) goto L48;
        r22 = false;
    L51:
        r23 = false;
        goto L52
    L35:
        if (r5.isEmpty() == false) goto L37;
    L54:
        r24 = false;
        goto L55
    L24:
        if (Intrinsics.areEqual(r3.getBizContentType(), "flow_nested") == true) goto L27;
        r4 = false;
        goto L28
    L16:
        if (r110.isEmpty() == false) goto L18;
    L30:
        r112 = false;
        goto L31
    L79:
        if (r10 != 6) goto L81;
    L8:
        r17 = "0";
        goto L9
    }
}
