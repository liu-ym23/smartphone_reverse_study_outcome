package k22;

import am2.x;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AIClone;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        o r0 = j0.l().c(x.class);
        if (r0 == null) goto L8;
        Map r1 = r0.getMap();
        if (r1 == null) goto L8;
        String r2 = (String) r1.get("enter_method");
        if (r2 == null) goto L8;
    L9:
        o r3 = j0.l().c(x.class);
        if (r3 == null) goto L15;
        Map r4 = r3.getMap();
        if (r4 == null) goto L15;
        String r5 = (String) r4.get("enter_from_merge");
        if (r5 == null) goto L15;
    L16:
        Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", r7), TuplesKt.to("live_enter_method", r2), TuplesKt.to("enter_from", r5)});
        h r6 = q.g();
        if (r6 == null) goto L64;
        j<AIClone> r9 = r6.getAiCloneItem();
        if (r9 == null) goto L64;
        AIClone r10 = (AIClone) r9.getValue();
        if (r10 == null) goto L64;
        List<AICloneConvItem> r11 = r10.aiCloneList;
        if (r11 == null) goto L64;
        AICloneConvItem r13 = (AICloneConvItem) CollectionsKt.firstOrNull(r11);
        if (r13 == null) goto L64;
        Map<String, String> r14 = r13.getMap();
        if (r14 == null) goto L64;
        Iterator<Map.Entry<String, String>> r15 = r14.entrySet().iterator();
    L30:
        if (r15.hasNext() == false) goto L64;
        Map.Entry<String, String> r16 = r15.next();
        String r17 = r16.getKey();
        if (r17 == null) goto L30;
        String r18 = r16.getValue();
        if (r18 != null) goto L36;
        r18 = BuildConfig.FLAVOR;
    L36:
        r8.put(r17, r18);
    L64:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L60
        h r20 = q.g();     // Catch: Throwable -> L60
        Unit r21 = null;
        if (r20 == null) goto L58;
        j<b> r23 = r20.getAiCloneManager();     // Catch: Throwable -> L60
        if (r23 == null) goto L58;
        b r24 = (b) r23.getValue();     // Catch: Throwable -> L60
        if (r24 == null) goto L58;
        AICloneConvItem r25 = r24.a();     // Catch: Throwable -> L60
        if (r25 == null) goto L46;
        String r26 = r25.getSchema();     // Catch: Throwable -> L60
    L47:
        String r27 = UriProtector.getQueryParameter(UriProtector.parse(r26), "im_bot_id");     // Catch: Throwable -> L60
        if (r27 == null) goto L58;
        if (r27.length() <= 0) goto L52;
        boolean r28 = true;
    L53:
        if (r28 == true) goto L56;
        r27 = null;
    L56:
        if (r27 == null) goto L58;
        r8.put("format_digital_human_id", r27);     // Catch: Throwable -> L60
        r21 = Unit.INSTANCE;     // Catch: Throwable -> L60
        goto L58
    L52:
        r28 = false;
        goto L53
    L46:
        r26 = null;
    L58:
        Result.constructor-impl(r21);     // Catch: Throwable -> L60
    L62:
        j0.l().h("format_entrance_show", r8, new Object[]{IRoom.class, x.class});
        return;
    L60:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        r5 = BuildConfig.FLAVOR;
    L8:
        r2 = BuildConfig.FLAVOR;
        goto L9
    }

    public static void a(Map r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "pressType");
        Intrinsics.checkNotNullParameter(r6, "clickArea");
        HashMap r0 = new HashMap();
        String r1 = BuildConfig.FLAVOR;
        if (r4 == null) goto L13;
        Iterator r7 = r4.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) r7.next();
        String r3 = (String) r2.getKey();
        if (r3 == null) goto L6;
        String r8 = (String) r2.getValue();
        if (r8 != null) goto L12;
        r8 = BuildConfig.FLAVOR;
    L12:
        r0.put(r3, r8);
    L13:
        IMiddlewareUserService r9 = k.f(IMiddlewareUserService.class);
        if (r9 == null) goto L21;
        e r10 = r9.user();
        if (r10 == null) goto L21;
        String r11 = r10.n();
        if (r11 == null) goto L21;
        r1 = r11;
    L21:
        r0.put("user_id", r1);
        r0.put("press_type", r5);
        r0.put("click_area", r6);
        j0.l().sendLog("livesdk_ai_qa_screen_message_click", r0, new Object[]{IRoom.class, x.class});
    }
}
