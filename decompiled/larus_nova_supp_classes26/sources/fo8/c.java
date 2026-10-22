package fo8;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.layout.widget.u;
import com.larus.bmhome.chat.standarduikit.widget.view.WidgetView;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.j2;
import com.larus.platform.service.DoraAudioService;
import com.larus.utils.p0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import go8.f;
import java.util.Map;
import kc8.e0;
import kc8.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public final WidgetView b() {
        return (WidgetView) this.b.getValue();
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.c = LazyKt.lazy(new b());
    }

    public final void a(ho8.a r29, eo8.b r30) {
        Intrinsics.checkNotNullParameter(r29, "vmData");
        ho8.c r3 = (ho8.c) this.c.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r29, "vmData");
        r3.a = r29;
        r3.b = r30;
        ho8.c r2 = (ho8.c) this.c.getValue();
        ho8.a r0 = r2.a;
        boolean r5 = false;
        if (r0 == null) goto L14;
        Message r1 = r0.c;
        if (r1 == null) goto L14;
        String r4 = r1.getMessageId();
        if (r4 == null) goto L14;
        if (r4.length() != 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 != true) goto L14;
        boolean r7 = true;
    L15:
        String r8 = "";
        String r9 = null;
        if (r7 == false) goto L25;
        ho8.a r10 = r2.a;
        if (r10 == null) goto L22;
        Message r11 = r10.c;
        if (r11 == null) goto L22;
        String r12 = r11.getLocalMessageId();
    L23:
        if (r12 == null) goto L32;
    L33:
        String r13 = r12;
    L197:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L48
        ho8.a r15 = r2.a;     // Catch: Throwable -> L48
        if (r15 == null) goto L43;
        String r16 = r15.d;     // Catch: Throwable -> L48
        if (r16 == null) goto L43;
        JSONObject r17 = new JSONObject(r16);     // Catch: Throwable -> L48
        String r18 = r17.optString("mixture_card_id");     // Catch: Throwable -> L48
        String r19 = r17.optString("fpa_common_param");     // Catch: Throwable -> L41
        r17.optDouble("aspect_ratio");     // Catch: Throwable -> L46
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        Result.constructor-impl(r20);     // Catch: Throwable -> L46
    L52:
        ho8.a r21 = r2.a;
        if (r21 == null) goto L56;
        Map<String, Object> r22 = r21.g;
        if (r22 == null) goto L56;
    L57:
        Map r23 = MapsKt.toMutableMap(r22);
        ho8.a r24 = r2.a;
        if (r24 == null) goto L64;
        Message r25 = r24.c;
        if (r25 == null) goto L64;
        Map r26 = r25.getExt();
        if (r26 == null) goto L64;
        String r27 = (String) r26.get("app_key");
    L65:
        Lazy r110 = DoraAudioService.a;
        if (r27 != null) goto L68;
    L71:
        boolean r111 = true;
    L72:
        if (r111 == true) goto L77;
        j2 r112 = DoraAudioService.c();
        if (r112 == null) goto L77;
        Integer r28 = r112.o(r27);
    L78:
        if (r28 == null) goto L80;
        r23.put("dora_sub_biz", Integer.valueOf(r28.intValue()));
    L80:
        ho8.a r31 = r2.a;
        if (r31 == null) goto L85;
        Message r32 = r31.c;
        if (r32 == null) goto L85;
        String r33 = r32.getSenderId();
    L86:
        if (r33 != null) goto L88;
        String r113 = "";
    L89:
        ho8.a r34 = r2.a;
        if (r34 == null) goto L94;
        Message r35 = r34.c;
        if (r35 == null) goto L94;
        String r36 = r35.getConversationId();
    L95:
        if (r36 != null) goto L97;
        String r114 = "";
    L98:
        ho8.a r37 = r2.a;
        if (r37 == null) goto L103;
        Message r38 = r37.c;
        if (r38 == null) goto L103;
        String r39 = r38.getSectionId();
    L104:
        if (r39 != null) goto L106;
        String r115 = "";
    L107:
        ho8.a r40 = r2.a;
        if (r40 == null) goto L112;
        Message r41 = r40.c;
        if (r41 == null) goto L112;
        String r42 = r41.getReplyId();
    L113:
        if (r42 != null) goto L115;
        String r116 = "";
    L116:
        ho8.a r43 = r2.a;
        if (r43 == null) goto L119;
        String r44 = r43.d;
    L120:
        if (r44 == null) goto L123;
        r8 = r44;
    L123:
        String r117 = p0.a(r18);
        eo8.a r45 = r2.b;
        if (r45 == null) goto L126;
        Fragment r118 = r45.o2();
    L127:
        ho8.a r46 = r2.a;
        if (r46 == null) goto L140;
        Message r47 = r46.c;
        if (r47 == null) goto L140;
        Map r48 = r47.getExt();
        if (r48 == null) goto L140;
        Map r49 = MapsKt.toMutableMap(r48);
        if (r49 == null) goto L140;
        if (r19 == null) goto L139;
        String r119 = p0.a(r19);
        if (r119 == null) goto L139;
        r49.put("fpa_common_param", r119);
    L139:
        Map r50 = r49;
    L141:
        ho8.a r51 = r2.a;
        if (r51 == null) goto L144;
        boolean r210 = r51.f;
    L145:
        Pair[] r120 = new Pair[5];
        if (r51 == null) goto L150;
        Message r52 = r51.c;
        if (r52 == null) goto L150;
        Long r53 = Long.valueOf(r52.getCreateTime());
    L151:
        r120[0] = TuplesKt.to("createTime", r53);
        IFlowSdkDepend r54 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r54 == null) goto L154;
        r54.r();
        Boolean r55 = Boolean.valueOf(mc9.a.a.h());
    L155:
        r120[1] = TuplesKt.to("hasFirstFeedShow", r55);
        IFlowSdkDepend r56 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r56 == null) goto L158;
        r56.r();
        Long r57 = Long.valueOf(mc9.a.a.g());
    L159:
        r120[2] = TuplesKt.to("coldStartTime", r57);
        eo8.a r58 = r2.b;
        if (r58 == null) goto L162;
        Boolean r59 = Boolean.valueOf(r58.W());
    L163:
        r120[3] = TuplesKt.to("hasPageFirstFeedShow", r59);
        eo8.a r60 = r2.b;
        if (r60 == null) goto L166;
        Long r61 = Long.valueOf(r60.O());
    L167:
        r120[4] = TuplesKt.to("openPageTime", r61);
        Map r121 = MapsKt.mapOf(r120);
        eo8.a r62 = r2.b;
        if (r62 == null) goto L170;
        n r211 = r62.q2();
    L171:
        eo8.a r63 = r2.b;
        if (r63 == null) goto L174;
        e0 r212 = r63.p2();
    L175:
        eo8.a r64 = r2.b;
        if (r64 == null) goto L178;
        String r213 = r64.m();
    L179:
        eo8.a r65 = r2.b;
        if (r65 == null) goto L182;
        r9 = r65.Z0();
    L182:
        u r66 = new u(r13, r113, r114, r115, r116, r8, r118, -1, r50, r121, r117, r210, null, r211, r212, r213, r9, r23, 4096);
        ho8.a r67 = r2.a;
        if (r67 == null) goto L185;
        int r68 = r67.b;
    L186:
        if (r67 == null) goto L188;
        r5 = r67.a;
    L188:
        if (r67 == null) goto L190;
        float r69 = r67.e;
    L191:
        b().a(new f(r68, r5, r66, r69), (ho8.c.b) ((ho8.c) this.c.getValue()).c.getValue());
        return;
    L190:
        r69 = 0.0f;
        goto L191
    L185:
        r68 = 0;
        goto L186
    L178:
        r213 = null;
        goto L179
    L174:
        r212 = null;
        goto L175
    L170:
        r211 = null;
        goto L171
    L166:
        r61 = null;
        goto L167
    L162:
        r59 = null;
        goto L163
    L158:
        r57 = null;
        goto L159
    L154:
        r55 = null;
    L150:
        r53 = null;
        goto L151
    L144:
        r210 = true;
    L140:
        r50 = null;
        goto L141
    L126:
        r118 = null;
        goto L127
    L119:
        r44 = null;
        goto L120
    L115:
        r116 = r42;
    L112:
        r42 = null;
        goto L113
    L106:
        r115 = r39;
    L103:
        r39 = null;
        goto L104
    L97:
        r114 = r36;
    L94:
        r36 = null;
        goto L95
    L88:
        r113 = r33;
    L85:
        r33 = null;
    L77:
        r28 = null;
        goto L78
    L68:
        if (r27.length() == 0) goto L71;
        r111 = false;
    L64:
        r27 = null;
    L56:
        r22 = MapsKt.emptyMap();
    L46:
        th = th;
    L51:
        Result.Companion r70 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L41:
        th = th;
    L50:
        r19 = null;
    L43:
        r18 = "";
        r20 = null;
        r19 = null;
    L48:
        th = th;
        r18 = "";
    L32:
        r13 = "";
    L22:
        r12 = null;
        goto L23
    L25:
        ho8.a r71 = r2.a;
        if (r71 == null) goto L30;
        Message r72 = r71.c;
        if (r72 == null) goto L30;
        r12 = r72.getMessageId();
    L31:
        if (r12 != null) goto L33;
    L30:
        r12 = null;
        goto L31
    L11:
        r6 = false;
    L14:
        r7 = false;
        goto L15
    }
}
