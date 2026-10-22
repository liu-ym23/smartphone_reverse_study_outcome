package com.ss.android.lark.chatwindow.view.preview;

import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.chat.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void b(Map<String, PreviewHangPoint> r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        Iterator<Map.Entry<String, PreviewHangPoint>> r4 = r3.entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        PreviewHangPoint r1 = r4.next().getValue();
        if (r1.getUrlCardPreviewEntity() == null) goto L15;
        ConcurrentHashMap<Integer, Long> r2 = o1.a;
        o1.c(r1.getPreviewId());
        goto L12
    L15:
        ConcurrentHashMap<Integer, Long> r5 = o1.a;
        o1.d(r1.getPreviewId(), Long.valueOf(System.currentTimeMillis()));
        goto L12
    L17:
        return;
    L4:
        if (r3.isEmpty() == true) goto L7;
        r0 = false;
        goto L8
    }

    @JvmStatic
    public static final void c(View r5, Map<String, PreviewHangPoint> r6) {
        if (r5 == null) goto L25;
        if (r6 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L26;
        Object r1 = r5.getTag(2131388117);
        if ((r1 instanceof List) == false) goto L14;
        List r2 = (List) r1;
    L15:
        Collection<PreviewHangPoint> r3 = r6.values();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r7 = r3.iterator();
    L17:
        if (r7.hasNext() == false) goto L20;
        r4.add(((PreviewHangPoint) r7.next()).getPreviewId());
        goto L17
    L20:
        if (Intrinsics.areEqual(r4, r2) == true) goto L22;
        b(r6);
    L22:
        r5.setTag(2131388117, r4);
        return;
    L14:
        r2 = null;
        goto L15
    L26:
        return;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    @JvmStatic
    public static final void d(String r4, MessageLink r5) {
        Intrinsics.checkNotNullParameter("card_title", "clickValue");
        HashMap r0 = new HashMap();
        r0.put("occasion", "chat");
        if (r4 != null) goto L5;
        r4 = "none";
    L5:
        r0.put("occasion_id", r4);
        r0.put("root_msg_cnt", Integer.valueOf(r5.getEntityIds().size()));
        MessageLink.ChatInfo r6 = r5.getChatInfo();
        if (r6 == null) goto L9;
        String r7 = r6.getChatId();
        if (r7 == null) goto L9;
    L10:
        r0.put("root_chat_id", r7);
        r0.put("root_msg_id", h6b.g.b.a(r5.getEntityIds()));
        r0.put("click", "card_title");
        Lazy r8 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r0, "extraParams");
        Map<String, Object> r9 = ChatParamUtils.e();
        if (r9 == null) goto L20;
        JSONObject r10 = new JSONObject(r9);
        Iterator r11 = r0.entrySet().iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r11.next();
        r10.put((String) r1.getKey(), r1.getValue());
        goto L15
    L17:
        r10.put("target", "none");
        ChatHitPointNew.d().sendEvent("im_msg_link_card_click", r10);
        return;
    L20:
        return;
    L9:
        r7 = "none";
        goto L10
    }

    public static s5c.d a(s5c.d r2, String r3, String r4, long r5, long r7) {
        ChatCoreModule.a().getWschannelDependency().getCurNetWorkLevel();
        com.ss.android.lark.statistics.chat.h r6 = new com.ss.android.lark.statistics.chat.h(String.valueOf(ChatCoreModule.a().getChatDependency().e()));
        if (com.ss.android.lark.appcontext.applifecycle.c.a.a.a == false) goto L5;
        com.ss.android.lark.statistics.chat.c r8 = new com.ss.android.lark.statistics.chat.c(DocTabPayload.DocType.UNKNOWN);
    L7:
        if (r4 != null) goto L9;
    L12:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        r4 = "none";
    L23:
        Intrinsics.checkNotNull(r4);
        n r10 = new n(r4);
        if (r3 != null) goto L26;
        r3 = "none";
    L26:
        com.ss.android.lark.statistics.chat.i r11 = new com.ss.android.lark.statistics.chat.i(r3);
        return r2.plus(r6).plus(r8).plus(r10).plus(r11);
    L16:
        int r12 = fkb.a.a;
        if (TextUtils.isEmpty(r4) == true) goto L23;
        int r13 = r4.indexOf("?");
        if (r13 == (-1)) goto L23;
        r4 = r4.substring(0, r13);
        goto L23
    L9:
        if (r4.length() == 0) goto L12;
        r9 = false;
        goto L14
    L5:
        r8 = new com.ss.android.lark.statistics.chat.c("1");
        goto L7
    }

    @JvmStatic
    public static final void e(ChatHitPointExtraParams.UrlAnalysisScene r8, String r9, String r10, ChatHitPointExtraParams.DataSource r11, long r12) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        long r6 = System.currentTimeMillis();
        s5c.d r0 = r8.plus(new com.ss.android.lark.statistics.chat.f(String.valueOf(r6 - r12)));
        if (r11 == null) goto L5;
        s5c.d r1 = r0.plus(r11);
    L6:
        s5c.d r13 = a(r1, r9, r10, r12, r6);
        Lazy r14 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r13, "param");
        JSONObject r15 = r13.plus(ChatParamUtils.e()).toJson();
        ChatHitPointNew.d().sendEvent("url_preview_sign_inline_render_dev", r15);
        Log.d("[URLPreview]", "SIGN SIGN SIGN SIGN,paramJson:" + r15);
        ConcurrentHashMap<Integer, Long> r16 = o1.a;
        o1.b(r9 + r8.getValue(), Long.valueOf(System.currentTimeMillis()));
        return;
    L5:
        r1 = r0;
        goto L6
    }
}
