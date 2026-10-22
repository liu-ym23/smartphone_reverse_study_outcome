package com.ss.android.lark.flow.chat.message.layout;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.s;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends com.ss.android.lark.flow.chat.message.layout.b {

    public static final class a implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.DOUBAO_BUBBLE;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new e(r3, r4, false);
        }
    }

    public static final class b implements wza.d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public b() {
            this.a = IMMessageKeys.Layouts.RTL_DOUBAO_BUBBLE;
        }

        public u getType() {
            return this.a;
        }

        public final q a(com.ss.android.lark.blueprint.g r3, BlueprintCell r4) {
            Intrinsics.checkNotNullParameter(r3, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cell");
            return new e(r3, r4, true);
        }
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final Map<v, Integer> z() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(IMMessageKeys.Slots.HEADER, 2131364920), TuplesKt.to(IMMessageKeys.Slots.CONTENT, 2131364916), TuplesKt.to(IMMessageKeys.Slots.FOOTER, 2131364918)});
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.a
    public final void v() {
        ViewGroup r0 = s(IMMessageKeys.Slots.HEADER);
        if (r0 == null) goto L6;
        r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), r0.getPaddingRight(), 0);
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final LKUIRoundLinearLayout y(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LKUIRoundLinearLayout r5 = LayoutInflater.from(r4.getContext()).inflate(2131561140, r4, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.layout.LKUIRoundLinearLayout");
        return r5;
    }

    @Override // com.ss.android.lark.flow.chat.message.layout.b, com.ss.android.lark.flow.chat.message.layout.a
    public final void B(LKUIRoundLinearLayout r12, y6b.a<?> r13) {
        Intrinsics.checkNotNullParameter(r12, "bodyLayout");
        Intrinsics.checkNotNullParameter(r13, "data");
        C(r12, r13, 8.0f);
        s r0 = x().d0(s.class);
        boolean r1 = false;
        int r2 = p3b.a.b(false);
        if (r0 == null) goto L7;
        Integer r3 = r0.a;
        if (r3 == null) goto L7;
        r2 = UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), r3.intValue());
    L7:
        r12.setBackgroundColor(r2);
        String r14 = r13.getId();
        long r4 = SystemClock.elapsedRealtime();
        com.ss.android.lark.flow.chat.statistics.perf.a r15 = com.ss.android.lark.flow.chat.statistics.perf.a.a;
        Intrinsics.checkNotNullParameter(r14, "doubaoMsgId");
        if (r14.length() != 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L27;
        com.ss.android.lark.flow.chat.statistics.perf.a.b r16 = com.ss.android.lark.flow.chat.statistics.perf.a.f.remove(r14);
        if (r16 == null) goto L28;
        long r5 = r16.d;
        long r6 = r4 - r5;
        long r7 = r16.h;
        long r8 = r7 - r5;
        long r9 = r16.i;
        long r10 = r9 - r7;
        long r11 = r4 - r9;
        JSONObject r17 = new JSONObject();
        String r18 = r16.f;
        String r19 = "";
        if (r18 != null) goto L18;
        r18 = "";
    L18:
        r17.put("reply_id", r18);
        String r20 = r16.g;
        if (r20 != null) goto L21;
        r20 = "";
    L21:
        r17.put("message_id", r20);
        r17.put("conversation_id", r16.a);
        String r21 = r16.c;
        if (r21 == null) goto L25;
        r19 = r21;
    L25:
        r17.put("thread_id", r19);
        r17.put("chat_type", r16.b);
        r17.put("duration", r6);
        r17.put("duration_query", r8);
        r17.put("duration_response", r10);
        r17.put("duration_render", r11);
        r17.put("has_enter_background", r16.j);
        r17.put("has_page_invisible", r16.k);
        Log.i("DoubaoReplyLatencyTracker", "report doubao reply latency: " + r17);
        Statistics.sendEvent("flow_reply_message_first_shown", r17);
        return;
    L28:
        return;
    }

    public e(com.ss.android.lark.blueprint.g r2, BlueprintCell r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3, r4);
    }
}
