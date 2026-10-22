package com.larus.bmhome.double_post;

import com.google.gson.Gson;
import com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.video.Content;
import com.larus.im.callback.IMError;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.g0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends com.larus.im.service.a {
    public final AwemeDoublePostFragment b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public e(AwemeDoublePostFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fg");
        this.b = r2;
        this.c = LazyKt.lazy(new b());
    }

    public final void a(IMError r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        StringBuilder r0 = new StringBuilder();
        Map r1 = r7.getExt();
        if (r1 == null) goto L8;
        Iterator r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        r0.append("extKey-" + ((String) r3.getKey()) + " : extValue-" + ((String) r3.getValue()));
    L8:
        String r4 = r0.toString();
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("process cmd = 10 error, msg: ");
        r6.append(r7.getCode());
        r6.append(", ");
        r6.append(r7.getTips());
        r6.append(", ");
        Throwable r8 = r7.getException();
        if (r8 == null) goto L11;
        String r9 = r8.getMessage();
    L12:
        r6.append(r9);
        r6.append(", ");
        r6.append(r4);
        r5.e("ReleatedVideoTwoRowFlowDataCmdProcessor", r6.toString());
        return;
    L11:
        r9 = null;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r5v14, types: [com.larus.bmhome.double_post.c] */
    public final void c(d0 r5) {
        final List r0 = null;
        if (r5 == null) goto L5;
        i r6 = (i) r5.get("common_cmd_notify");
    L7:
        if ((r6 instanceof d0) == false) goto L9;
        d0 r7 = (d0) r6;
    L10:
        if (r7 == null) goto L12;
        i r1 = (i) r7.get("biz_code");
    L14:
        if ((r1 instanceof g0) == false) goto L16;
        g0 r2 = (g0) r1;
    L17:
        if (r2 == null) goto L19;
        String r3 = k.g(r2);
    L21:
        if (Intrinsics.areEqual(r3, "two_col_video_preload_info") == true) goto L58;
        return;
    L58:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L33
        Gson r8 = (Gson) this.c.getValue();     // Catch: Throwable -> L33
        Object r9 = r7.get("value");     // Catch: Throwable -> L33
        if ((r9 instanceof g0) == false) goto L26;
        g0 r10 = (g0) r9;     // Catch: Throwable -> L33
    L27:
        if (r10 == null) goto L30;
        String r11 = k.g(r10);     // Catch: Throwable -> L33
        if (r11 == null) goto L30;
    L31:
        Object r12 = Result.constructor-impl((ReleatedVideoTwoRowFlowData) r8.fromJson(r11, ReleatedVideoTwoRowFlowData.class));     // Catch: Throwable -> L33
    L36:
        if (Result.exceptionOrNull-impl(r12) != null) goto L61;
        ReleatedVideoTwoRowFlowData r13 = (ReleatedVideoTwoRowFlowData) r12;
        FLogger.a.d("ReleatedVideoTwoRowFlowDataCmdProcessor", "receive downLinkInfo:" + r13);
        List<Content> r14 = r13.getUgcItems();
        if (r14 == null) goto L40;
        r0 = CollectionsKt.filterNotNull(r14);
    L40:
        List r15 = r0;
        if (r15 != null) goto L43;
    L46:
        boolean r16 = true;
    L47:
        if (r16 == false) goto L49;
        return;
    L49:
        AwemeDoublePostCacheManager r17 = AwemeDoublePostCacheManager.a;
        AwemeDoublePostCacheManager.d(r0, r13.getMessageId(), r13.getCacheTime());
        Iterator r18 = r0.iterator();
    L51:
        if (r18.hasNext() == false) goto L53;
        Content r19 = (Content) r18.next();
        r19.setImprIndex(1);
        r19.setBizTag("chat_feed");
        goto L51
    L53:
        final ?? r20 = new c(this, r0);
        if (this.b.isAdded() == false) goto L56;
        r20.invoke();
        return;
    L56:
        AwemeDoublePostFragment r21 = this.b;
        Function0 r22 = new d(r20);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "callBack");
        r21.x = r22;
        return;
    L43:
        if (r15.isEmpty() == true) goto L46;
        r16 = false;
        goto L47
    L61:
        return;
    L30:
        r11 = "";
        goto L31
    L26:
        r10 = null;
    L33:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L19:
        r3 = null;
        goto L21
    L16:
        r2 = null;
        goto L17
    L12:
        r1 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L7
    }
}
