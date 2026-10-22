package com.ss.android.lark.chat.name;

import android.util.LruCache;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.translate.dialog.MoreTranslateActionDialog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a implements f {
    public final IChatService a;
    public final ITranslateService b;
    public final g c;
    public b d;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.name.a$a, reason: collision with other inner class name */
    public static final class C0104a {
    }

    public static final class b {
        public final String a;
        public final WeakReference<MoreTranslateActionDialog> b;

        public b(String r2, MoreTranslateActionDialog r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            Intrinsics.checkNotNullParameter(r3, "dialog");
            this.a = r2;
            this.b = new WeakReference(r3);
        }
    }

    static {
    }

    @Inject
    public a(IChatService r2, ITranslateService r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "chatService");
        Intrinsics.checkNotNullParameter(r3, "translateService");
        Intrinsics.checkNotNullParameter(r4, "fgService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        new LruCache(20);
    }

    public static void a(s5c.a r2, Chat r3, Map r4) {
        Map r5 = ChatParamUtils.b(r3, null, 6);
        LinkedHashMap r0 = new LinkedHashMap();
        s5c.a r1 = r.c;
        r0.put("click", r2.b);
        r0.putAll(r5);
        if (r4 == null) goto L5;
        r0.putAll(r4);
    L5:
        Statistics.sendEvent("im_chat_main_click", new JSONObject(r0));
    }
}
