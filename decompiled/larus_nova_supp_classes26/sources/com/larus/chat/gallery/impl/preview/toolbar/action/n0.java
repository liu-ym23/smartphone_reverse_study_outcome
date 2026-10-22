package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.utils.z2;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.larus.platform.api.v2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n0 implements o {

    public static final class a {
    }

    static {
    }

    public n0() {
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r8, Continuation<? super Unit> r9) {
        FLogger.a.i("ViewSourceAction", "execute");
        xy8.d r10 = r8.a;
        Map<String, Object> r1 = r10.f;
        long r2 = ko8.a.e;
        JSONObject r4 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        Map.Entry<String, Object> r5 = r3.next();
        r4.put(r5.getKey(), r5.getValue());
        goto L4
    L7:
        if (r4.has("user_type") == true) goto L10;
        r4.put("user_type", "bot");
    L10:
        if (r4.has("rich_media_type") == true) goto L13;
        r4.put("rich_media_type", "mixed_picture");
    L13:
        if (r4.has("enter_picture_method") == true) goto L16;
        r4.put("enter_picture_method", "chat");
    L16:
        if (r4.has("bot_id") == true) goto L26;
        com.larus.bmhome.chat.api.e0 r6 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r6 == null) goto L23;
        LaunchInfo r7 = r6.a;
        if (r7 == null) goto L23;
        String r11 = r7.W();
        if (r11 == null) goto L23;
    L24:
        r4.put("bot_id", r11);
    L23:
        r11 = "";
    L26:
        if (r4.has("chat_type") == true) goto L28;
        LruCache<String, wc9.e> r12 = ko8.a.a;
        r4.put("chat_type", ko8.a.e(r2));
    L28:
        com.larus.platform.service.o.a.reportEvent("rich_media_picture_link_click", r4);
        final String r13 = r10.j.get("source_url");
        boolean r14 = false;
        if (r13 != null) goto L31;
    L34:
        boolean r15 = true;
    L35:
        if (r15 == false) goto L38;
        FLogger.a.i("ViewSourceAction", "source_url is empty, ignore");
        return Unit.INSTANCE;
    L38:
        final Context r16 = r8.getContext();
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        r2 r17 = null;
        if (r0 == null) goto L41;
        v2 r18 = r0.Y();
    L42:
        if (r18 != null) goto L44;
    L46:
        boolean r19 = false;
    L47:
        if (r19 == true) goto L49;
        Uri r20 = UriProtector.parse(r13);
        IFlowSdkDepend r21 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r21 == null) goto L53;
        r17 = r21.A0();
    L53:
        if (r17 != null) goto L55;
    L57:
        if (r14 == false) goto L64;
        JSONObject r22 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r23 = r10.f.entrySet().iterator();
    L60:
        if (r23.hasNext() == false) goto L62;
        Map.Entry<String, Object> r24 = r23.next();
        r22.put(r24.getKey(), r24.getValue());
        goto L60
    L62:
        r17.a(r16, r20);
        return Unit.INSTANCE;
    L64:
        z2.b(r13, new m0(r16, r13));
        return Unit.INSTANCE;
    L55:
        if (r17.j(r20) != true) goto L57;
        r14 = true;
        goto L57
    L49:
        return Unit.INSTANCE;
    L44:
        if (r18.a(null) != true) goto L46;
        r19 = true;
        goto L47
    L41:
        r18 = null;
        goto L42
    L31:
        if (StringsKt.isBlank(r13) == true) goto L34;
        r15 = false;
        goto L35
    }
}
