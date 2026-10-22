package com.bytedance.android.live.openplatform.impl.miniappaudience.intention;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.constant.OpenPlatformConstants$ExplainCardTriggerType;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceLynxExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.action.CommentCountAction;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.action.DiggCountAction;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.action.HighValueCommentAction;
import com.bytedance.android.livesdk.config.ce0;
import com.bytedance.android.livesdk.config.qc1;
import com.bytedance.android.livesdk.config.rc1;
import com.bytedance.android.livesdk.config.sc1;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kq0.c;
import m71.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/intention/AudienceHighIntentionContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/intention/a;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceHighIntentionContextService extends OpenPlatformContextService implements com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a {
    public static final /* synthetic */ int g = 0;
    public final rc1 a;
    public final oq0.a b;
    public final List<kq0.b> c;
    public final mq0.a d;
    public long e;
    public final b f;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ AudienceHighIntentionContextService a;

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            if (r4.what != 2) goto L25;
            Object r5 = r4.obj;
            ShelfCardInfo r1 = null;
            if ((r5 instanceof ShelfInfo) == true) goto L8;
            r5 = null;
        L8:
            AudienceHighIntentionContextService r0 = this.a;
            ShelfCardInfo r6 = g.a((ShelfInfo) r5);
            int r2 = AudienceHighIntentionContextService.g;
            r0.getClass();
            MiniAppDataContext.Companion.getClass();
            MiniAppDataContext r3 = MiniAppDataContext.a.a();
            if (r3 == null) goto L16;
            n<ShelfInfo> r7 = r3.m618getShelfInfo();
            if (r7 == null) goto L16;
            ShelfInfo r8 = (ShelfInfo) r7.getValue();
            if (r8 == null) goto L16;
            r1 = g.a(r8);
        L16:
            if ((!Intrinsics.areEqual(r6, r1)) == false) goto L19;
            qo0.a.c("AudienceHighIntentionContextService", "delayHideCardAction:shelfInfo was changed!");
            return;
        L19:
            if (((AudienceExplainCardContextService) r0.getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).b == true) goto L21;
            qo0.a.c("AudienceHighIntentionContextService", "delayHideCardAction:explain card has been hided!");
            return;
        L21:
            ((AudienceExplainCardContextService) r0.getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).f(false);
            return;
        }

        public b(AudienceHighIntentionContextService r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    public final void f() {
        qo0.a.c("AudienceHighIntentionContextService", "onHideExplainCardByUser");
        mq0.a r0 = this.d;
        long r1 = this.e;
        r0.d.put(Long.valueOf(r1), Long.valueOf(System.currentTimeMillis()));
        long r3 = r0.c;
        mq0.a.b r2 = r0.e;
        r2.sendMessageDelayed(r2.obtainMessage(1, Long.valueOf(r1)), r3);
    }

    public final void g() {
        qo0.a.c("AudienceHighIntentionContextService", "onStart");
        qo0.a.c("AudienceHighIntentionContextService", "initActions");
        List r1 = this.a.a();
        if (r1 == null) goto L22;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L22;
        qc1 r3 = (qc1) r2.next();
        String r4 = r3.getType();
        switch(r4.hashCode()) {
            case -1120985297: goto L20;
            case -121614219: goto L17;
            case 291671226: goto L14;
            case 1657558895: goto L11;
            default: goto L6;
        };
    L11:
        if (r4.equals("comment_high_intention") == false) goto L6;
        ((ArrayList) this.c).add(new HighValueCommentAction(getOpenPlatformContext(), r3, this, this.b));
        goto L6
    L14:
        if (r4.equals("stay_duration") == false) goto L6;
        ((ArrayList) this.c).add(new c(getOpenPlatformContext(), r3, this, this.b));
        goto L6
    L17:
        if (r4.equals("digg_count") == false) goto L6;
        ((ArrayList) this.c).add(new DiggCountAction(getOpenPlatformContext(), r3, this, this.b));
        goto L6
    L20:
        if (r4.equals("comment_count") == false) goto L6;
        ((ArrayList) this.c).add(new CommentCountAction(getOpenPlatformContext(), r3, this, this.b));
    L22:
        Iterator r5 = ((ArrayList) this.c).iterator();
    L24:
        if (r5.hasNext() == false) goto L26;
        kq0.b r6 = (kq0.b) r5.next();
        int r7 = qo0.a.a;
        qo0.a.c("AudienceHighIntentionContextService", "init action: " + r6.type());
        r6.init();
        goto L24
    L26:
        qo0.a.c("AudienceHighIntentionContextService", "clearExpiredPrefRecord");
        sc1 r8 = this.a.b();
        if (r8 == null) goto L29;
        long r9 = r8.b();
    L30:
        final long r10 = r9 * 1000;
        final long r11 = System.currentTimeMillis();
        Function1<oq0.c, Boolean> r12 = new AudienceHighIntentionContextService$clearExpiredFreqRecord$expirePredicate$1(r10, r11);
        oq0.a r13 = this.b;
        List r14 = CollectionsKt.listOf(new String[]{"comment_count_records", "comment_high_intention_records", "digg_count_records", "auto_trigger_count_records", "clue_complete_records"});
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "recordKeys");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator r15 = r14.iterator();
    L32:
        if (r15.hasNext() == false) goto L44;
        String r16 = (String) r15.next();
        oq0.b r17 = r13.a(r16);
        Map<String, oq0.c> r18 = r17.a();
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator<Map.Entry<String, oq0.c>> r20 = r18.entrySet().iterator();
    L35:
        if (r20.hasNext() == false) goto L39;
        Map.Entry<String, oq0.c> r21 = r20.next();
        if (((Boolean) r12.invoke(r21.getValue())).booleanValue() == false) goto L35;
        r19.put(r21.getKey(), r21.getValue());
        goto L35
    L39:
        r17.b(MapsKt.toMutableMap(r19));
        String r22 = GsonHelper.get().toJson(r17);     // Catch: Exception -> L42
    L43:
        r13.a.m(r16, r22);
    L42:
        r22 = "";
        goto L43
    L44:
        qo0.a.c("AudienceHighIntentionContextService", "observeShelfInfoChanged");
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r0 = MiniAppDataContext.a.a();
        if (r0 == null) goto L80;
        n<ShelfInfo> r23 = r0.m618getShelfInfo();
        if (r23 == null) goto L81;
        i80.a.b(r23, new AudienceHighIntentionContextService$observeShelfInfoChanged$1(this));
        return;
    L81:
        return;
    L80:
        return;
    L29:
        r9 = 86400;
        goto L30
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        qo0.a.c("AudienceHighIntentionContextService", "onDestroy");
        this.f.removeMessages(2);
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((kq0.b) r0.next()).onDestroy();
        goto L4
    L6:
        this.d.e.removeMessages(1);
        super.onDestroy();
    }

    public AudienceHighIntentionContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = (rc1) ce0.a.getValue();
        oq0.a r0 = new oq0.a(r2.getContext());
        this.b = r0;
        this.c = new ArrayList();
        this.d = new mq0.a(r0, this);
        this.f = new b(this, Looper.getMainLooper());
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a
    public final void a(String r17) {
        Intrinsics.checkNotNullParameter(r17, "actionType");
        qo0.a.c("AudienceHighIntentionContextService", "onConditionStatusChanged");
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: action=".concat(r17));
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r1 = MiniAppDataContext.a.b();
        if (r1 == null) goto L9;
        ShelfCardInfo r2 = g.a(r1);
        if (r2 == null) goto L9;
        if (r2.C0() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: clue component not access!");
        return;
    L12:
        oq0.c r4 = this.b.b("clue_complete_records", String.valueOf(this.e));
        if (r4 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L20;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: clue complete!");
        return;
    L20:
        List<kq0.b> r6 = this.c;
        if ((r6 instanceof Collection) == true) goto L23;
    L25:
        Iterator r7 = ((ArrayList) r6).iterator();
    L27:
        if (r7.hasNext() == false) goto L33;
        kq0.b r8 = (kq0.b) r7.next();
        boolean r9 = r8.a();
        if (r9 == false) goto L31;
        int r10 = qo0.a.a;
        qo0.a.c("AudienceHighIntentionContextService", "match condition: " + r8.type());
    L31:
        if (r9 == false) goto L27;
        boolean r11 = true;
    L34:
        if (r11 == true) goto L36;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: conditions not matched!");
        return;
    L36:
        mq0.a r12 = this.d;
        long r13 = this.e;
        oq0.c r14 = r12.f.b("auto_trigger_count_records", String.valueOf(r13));
        if (r14 == null) goto L39;
        long r15 = r14.a();
    L41:
        if (r15 >= r12.a) goto L55;
        if (r14 == null) goto L45;
        long r16 = r14.b();
    L47:
        if ((System.currentTimeMillis() - r16) < r12.b) goto L55;
        Long r18 = (Long) ((LinkedHashMap) r12.d).get(Long.valueOf(r13));
        if (r18 == null) goto L52;
        long r19 = r18.longValue();
    L54:
        if ((System.currentTimeMillis() - r19) < r12.c) goto L55;
        boolean r20 = true;
    L57:
        if (r20 == true) goto L60;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: frequency control not matched!");
        return;
    L60:
        if (e.c(10) == false) goto L65;
        if (((AudienceLynxExplainCardContextService) getOpenPlatformContext().getService(AudienceLynxExplainCardContextService.class)).b == false) goto L67;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: explain card is showing!");
        return;
    L67:
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r21 = AudienceMiniAppDataContext.a.a();
        if (r21 == null) goto L72;
        n<ShelfInfo> r22 = r21.m618getShelfInfo();
        if (r22 == null) goto L72;
        ShelfInfo r23 = (ShelfInfo) r22.getValue();
    L73:
        if (r23 != null) goto L75;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: shelfInfo is null!");
        return;
    L75:
        long r24 = 30;
        if (e.c(10) == false) goto L81;
        JSONObject r25 = new JSONObject();
        r25.put("triggerType", OpenPlatformConstants$ExplainCardTriggerType.HighIntention.getValue());
        sc1 r26 = this.a.b();
        if (r26 == null) goto L80;
        r24 = r26.d();
    L80:
        r25.put("showDuration", r24);
        AudienceLynxExplainCardContextService.f((AudienceLynxExplainCardContextService) getOpenPlatformContext().getService(AudienceLynxExplainCardContextService.class), false, r25, 1);
    L85:
        mq0.a r27 = this.d;
        long r28 = this.e;
        r27.f.c("auto_trigger_count_records", 1, String.valueOf(r28));
        long r29 = r27.b;
        mq0.a.b r30 = r27.e;
        r30.sendMessageDelayed(r30.obtainMessage(1, Long.valueOf(r28)), r29);
        return;
    L81:
        AudienceExplainCardContextService.i((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class), r23, false, true, 2);
        sc1 r31 = this.a.b();
        if (r31 == null) goto L84;
        r24 = r31.d();
    L84:
        this.f.removeMessages(2);
        b r32 = this.f;
        r32.sendMessageDelayed(r32.obtainMessage(2, r23), r24 * 1000);
    L72:
        r23 = null;
        goto L73
    L65:
        if (((AudienceExplainCardContextService) getOpenPlatformContext().getService(AudienceExplainCardContextService.class)).b == false) goto L67;
        qo0.a.c("AudienceHighIntentionContextService", "tryActiveExplainCard: explain card is showing!");
        return;
    L52:
        r19 = 0;
        goto L54
    L45:
        r16 = 0;
    L55:
        r20 = false;
        goto L57
    L39:
        r15 = 0;
    L33:
        r11 = false;
        goto L34
    L23:
        if (((ArrayList) r6).isEmpty() == false) goto L25;
    L15:
        if (r4.a() != 1) goto L17;
        r5 = true;
    L9:
        r3 = false;
        goto L10
    }
}
