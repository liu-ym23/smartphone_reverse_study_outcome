package com.bytedance.android.live.revlink.impl.audience;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.android.live.revlink.impl.multianchor.utils.h0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.utils.s;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.ILinkerCloseContent;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridgeKt;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkCheckLoadUtils implements com.bytedance.android.live.revlink.impl.pk.utils.g {
    public static final /* synthetic */ int r = 0;
    public final s a;
    public final w41.c b;
    public final int c;
    public final HashMap<Integer, Integer> d;
    public final HashMap<String, Integer> e;
    public final CompositeDisposable f;
    public final long g;
    public long h;
    public long i;
    public final h0 j;
    public long k;
    public long l;
    public b m;
    public final com.bytedance.android.live.revlink.impl.global.c n;
    public IRoom o;
    public final com.bytedance.android.live.revlink.impl.control.c p;
    public final yz0.f q;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.audience.LinkCheckLoadUtils$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(LinkCheckLoadUtils r8) {
            super(1, r8, LinkCheckLoadUtils.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r22) {
            Intrinsics.checkNotNullParameter(r22, "p1");
            LinkCheckLoadUtils r2 = (LinkCheckLoadUtils) ((CallableReference) this).receiver;
            int r3 = LinkCheckLoadUtils.r;
            r2.getClass();
            if ((r22 instanceof h1) == false) goto L48;
            i6 r0 = ((vh7.c) r22).castTo(i6.class);
            boolean r4 = false;
            if (((int) i1.c(r0)) != 2) goto L26;
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            if (((int) r0.getScene()) == 1) goto L12;
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            if (((int) r0.getScene()) == 7) goto L12;
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            if (((int) r0.getScene()) == 14) goto L12;
        L13:
            if (r4 == true) goto L15;
            return;
        L15:
            if (r2.b.c8() == false) goto L21;
            ILinkerCloseContent r5 = r0.getClose();
            if (r5 == null) goto L21;
            if (r5.getSource() != 1) goto L21;
            StringBuilder r6 = new StringBuilder("intercept switch_scene close msgScene=");
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            r6.append(r0.getScene());
            jy0.b.c("ttlive_pk_audience_load", r6.toString(), null, 4);
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            int r15 = (int) r0.getScene();
            Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
            long r16 = r0.getLinkerId();
            i97.a r1 = i97.a.a;
            r2.m = new b(r15, r16, System.currentTimeMillis());
            return;
        L21:
            Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
            r2.i = r0.getLinkerId();
            StringBuilder r7 = new StringBuilder("linker_close msg set closeChannelId=");
            r7.append(r2.i);
            r7.append(' ');
            r7.append(i11.a.a(r0));
            r7.append(' ');
            ILinkerCloseContent r8 = r0.getClose();
            if (r8 == null) goto L24;
            String r9 = ef2.a.c(r8);
        L25:
            r7.append(r9);
            jy0.b.f("ttlive_pk_audience_load", r7.toString(), null, 4);
            return;
        L24:
            r9 = null;
        L12:
            r4 = true;
            goto L13
        L26:
            Intrinsics.checkNotNullParameter(r0, "$this$typeExt");
            if (((int) r0.getType2()) != 7) goto L52;
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            if (((int) r0.getScene()) == 1) goto L34;
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            if (((int) r0.getScene()) == 7) goto L34;
            Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
            if (((int) r0.getScene()) == 14) goto L34;
        L35:
            if (r4 == false) goto L53;
            ILinkerLeaveContentBridge r10 = r0.getLeave();
            if (r10 == null) goto L39;
            String r12 = ILinkerLeaveContentBridgeKt.getUserIdEx(r10);
        L40:
            IBaseUser r13 = r2.o.getOwnerKt();
            if (r13 == null) goto L43;
            String r14 = r13.getIdString();
        L45:
            if (Intrinsics.areEqual(r12, r14) == false) goto L54;
            Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
            r2.i = r0.getLinkerId();
            jy0.b.f("ttlive_pk_audience_load", "linker_leave msg set closeChannelId=" + r2.i, null, 4);
            return;
        L54:
            return;
        L43:
            r14 = null;
            goto L45
        L39:
            r12 = null;
            goto L40
        L53:
            return;
        L34:
            r4 = true;
            goto L35
        L52:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final long b;
        public final long c;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L12;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.c;
            return r2 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "LinkSwitchCloseInfo(scene=" + this.a + ", channelId=" + this.b + ", timestamp=" + this.c + ")";
        }

        public b(int r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.utils.g
    public final boolean c(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.utils.g
    public final void a(p0 r9) {
        Integer r0 = this.d.get(Integer.valueOf(r9.getVersion()));
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L7:
        if (r1 <= this.c) goto L10;
        jy0.b.f("ttlive_pk_audience_load", "skip check for " + Integer.valueOf(r9.getVersion()) + " countMap=" + this.d, null, 4);
        return;
    L10:
        String r2 = String.valueOf(this.i);
        String r5 = r9.getChannelId();
        if (r5 != null) goto L15;
        r5 = null;
    L15:
        if (Intrinsics.areEqual(r2, r5) == false) goto L20;
        com.bytedance.android.live.revlink.impl.settings.live.c r3 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r3.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.e.getValue(r3, com.bytedance.android.live.revlink.impl.settings.live.c.a[3])).booleanValue() == false) goto L20;
        jy0.b.f("ttlive_pk_audience_load", "skip check for closeChannelId " + this.i, null, 4);
        return;
    L20:
        this.d.put(Integer.valueOf(r9.getVersion()), Integer.valueOf(r1 + 1));
        d(r9);
        return;
    L5:
        r1 = 0;
        goto L7
    }

    public final void b(String r16) {
        if (r16 == null) goto L158;
        boolean r7 = true;
        if (StringsKt.contains$default(r16, "app_data", false, 2, null) != true) goto L164;
        i97.a r6 = i97.a.a;
        if ((System.currentTimeMillis() - this.g) >= 1500) goto L23;
        com.bytedance.android.live.revlink.impl.control.c r8 = this.p;
        if (r8 == null) goto L23;
        if (r8.c == null) goto L14;
    L17:
        boolean r9 = true;
    L18:
        if (r9 != true) goto L23;
        com.bytedance.android.live.revlink.impl.settings.live.d r10 = com.bytedance.android.live.revlink.impl.settings.live.d.e;
        r10.getClass();
        if (((w41.b) com.bytedance.android.live.revlink.impl.settings.live.d.b.getValue(r10, com.bytedance.android.live.revlink.impl.settings.live.d.a[0])).M2() == false) goto L23;
        jy0.b.d("ttlive_pk_audience_load", "intercept sei load since just enter revlink room");
        return;
    L14:
        if (r8.d != null) goto L17;
        r9 = false;
    L23:
        cy0.e.a.getClass();
        j r12 = cy0.e.a.a;
        m.e.getClass();
        Object r13 = m.b(r12).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r13);
        int r14 = ((com.bytedance.live.kmp.core.c) r13).getMultiInteractMode();
        Object r15 = m.b(r12).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r15);
        int r17 = ((com.bytedance.live.kmp.core.c) r15).M5();
        if (r17 >= 2) goto L27;
        if (r14 != 2) goto L27;
        boolean r18 = true;
    L29:
        if (this.b.a8() == false) goto L56;
        if (r14 == 0) goto L60;
        if (com.bytedance.android.live.utils.c.a(r14, 4) == false) goto L34;
    L54:
        jy0.b.f("ttlive_pk_audience_load", "skip check for " + r14 + " already loaded", null, 4);
        return;
    L34:
        if (com.bytedance.android.live.utils.c.a(r14, 64) == true) goto L54;
        if (com.bytedance.android.live.utils.c.a(r14, 32) == false) goto L39;
    L42:
        boolean r19 = true;
    L43:
        if (r19 == true) goto L45;
        return;
    L45:
        if (StringsKt.contains$default(r16, "\\\"ver\\\":2,", false, 2, null) == true) goto L51;
        if (StringsKt.contains$default(r16, "\\\"ver\\\":6", false, 2, null) == true) goto L51;
        jy0.b.d("ttlive_pk_audience_load", "skip check for inAudienceLinkmic ver invalid");
        return;
    L51:
        if (r17 < 3) goto L60;
        jy0.b.f("ttlive_pk_audience_load", "skip check mode=" + r14 + " linkAudience=" + r17, null, 4);
        return;
    L39:
        if (com.bytedance.android.live.utils.c.a(r14, 2) == true) goto L42;
        r19 = false;
    L60:
        if ((System.currentTimeMillis() - this.h) >= WebcastRedirectException.UNKNOWN) goto L62;
        return;
    L62:
        this.h = System.currentTimeMillis();
        if (this.b.O7() == false) goto L115;
        this.j.getClass();
        JSONObject r2 = h0.b(r16);
        if (r2 == null) goto L69;
        this.j.getClass();
        JSONObject r3 = h0.a(r2);
        if (r3 == null) goto L69;
        int r20 = s.c;
        p0 r0 = s.a.a(r3, r16);
    L71:
        if (r0 != null) goto L73;
        return;
    L73:
        if (r0.getVersion() == 2) goto L77;
        if (r0.getVersion() == 6) goto L77;
        return;
    L77:
        if (Intrinsics.areEqual(String.valueOf(this.i), r0.getChannelId()) == false) goto L80;
        jy0.b.f("ttlive_pk_audience_load", "skip check for closeChannelId " + this.i, null, 4);
        return;
    L80:
        if (r0.getTimestamp() >= this.k) goto L82;
    L87:
        b r4 = this.m;
        if (r4 != null) goto L90;
    L107:
        Integer r5 = this.e.get(r0.getChannelId());
        if (r5 != null) goto L110;
        r5 = 0;
    L110:
        int r22 = r5.intValue();
        if (r22 < this.c) goto L113;
        jy0.b.f("ttlive_pk_audience_load", "skip check for channelId=" + r0.getChannelId() + " cnt=" + r22 + " countMap=" + this.e, null, 4);
        return;
    L113:
        this.e.put(r0.getChannelId(), Integer.valueOf(r22 + 1));
        d(r0);
        return;
    L90:
        if (r4.a != 1) goto L99;
        if (r0.getVersion() != 2) goto L99;
        if (Intrinsics.areEqual(r0.getChannelId(), String.valueOf(r4.b)) == false) goto L99;
        if (t.a(r4.c) >= this.b.z7()) goto L99;
        jy0.b.f("ttlive_pk_audience_load", "skip check for pkSwitchMulti info=" + r4 + " sei=" + x.h(r0), null, 4);
        return;
    L99:
        if (r4.a != 7) goto L107;
        if (r0.getVersion() != 6) goto L107;
        if (Intrinsics.areEqual(r0.getChannelId(), String.valueOf(r4.b)) == false) goto L107;
        if (t.a(r4.c) >= this.b.z7()) goto L107;
        jy0.b.f("ttlive_pk_audience_load", "skip check for multiSwitchPk info=" + r4 + " sei=" + x.h(r0), null, 4);
        return;
    L82:
        if (r0.getTimestamp() == r0.getTimestamp()) goto L84;
    L86:
        this.k = r0.getTimestamp();
        this.l = System.currentTimeMillis();
        goto L87
    L84:
        if (t.a(this.l) >= 3000) goto L86;
        return;
    L69:
        r0 = null;
        goto L71
    L115:
        s r23 = this.a;
        r23.getClass();
        if (r16.length() == 0) goto L119;
        r7 = false;
    L119:
        if (r7 == false) goto L121;
        return;
    L121:
        if (StringsKt.contains$default(r16, "app_data", false, 2, null) == false) goto L165;
        JSONObject r24 = LiveSeiUtil.a(r16);     // Catch: Throwable -> L146
        if (r24.has("info") == false) goto L135;
        if (r24.has("source") == false) goto L135;
        if (Intrinsics.areEqual(r24.optString("source"), "zego") == false) goto L135;
        Object r25 = r24.get("info");     // Catch: Throwable -> L146
        if (r25 == null) goto L133;
        r24 = (JSONObject) r25;     // Catch: Throwable -> L146
        goto L135
    L133:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Throwable -> L146
    L135:
        if (r24.has("app_data") == false) goto L160;
        JSONObject r26 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r24, "app_data"), ""));     // Catch: Throwable -> L146
        long r27 = r26.optLong("timestamp");     // Catch: Throwable -> L146
        if (r27 > r23.a) goto L140;
        return;
    L140:
        if (r26.has("ver") == true) goto L143;
        return;
    L143:
        if (r23.b.c(r26.optInt("ver")) == false) goto L163;
        r23.a = r27;     // Catch: Throwable -> L146
        int r28 = s.c;     // Catch: Throwable -> L146
        r23.b.a(s.a.a(r26, r16));     // Catch: Throwable -> L146
        return;
    L163:
        return;
    L160:
        return;
    L146:
        th = move-exception;
        jy0.b.c("RevLinkSeiHelper", "updateSei catch error " + ExceptionsKt.stackTraceToString(th), null, 4);
        return;
    L165:
        return;
    L56:
        if (r14 == 0) goto L60;
        if (r18 == true) goto L60;
        return;
    L27:
        r18 = false;
        goto L29
    L164:
        return;
    }

    public final void d(p0 r10) {
        com.bytedance.android.live.revlink.impl.multianchor.service.e r6 = null;
        IPkAudienceLoadService r7 = null;
        if (r10.getVersion() != 2) goto L10;
        jy0.b.f("ttlive_pk_audience_load", "pkSeiBackup roomId:" + IRoomKtKt.getId(this.o) + " channelId:" + r10.getChannelId() + " sei:" + x.h(r10), null, 4);
        this.b.F4();
        com.bytedance.android.live.revlink.impl.global.c r12 = this.n;
        if (r12 == null) goto L7;
        r7 = r12.Ik();
    L7:
        if (r7 == null) goto L24;
        SeiLoadPkSource r13 = SeiLoadPkSource.NORMAL_SEI;
        r7.a();
        return;
    L24:
        return;
    L10:
        if (r10.getVersion() != 6) goto L26;
        com.bytedance.android.live.revlink.impl.settings.live.c r0 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r0.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.d.getValue(r0, com.bytedance.android.live.revlink.impl.settings.live.c.a[2])).booleanValue() == true) goto L14;
        return;
    L14:
        if (r10.getChannelId() == null) goto L28;
        jy0.b.f("ttlive_pk_audience_load", "multiAnchorSeiBackup roomId:" + IRoomKtKt.getId(this.o) + " channelId:" + r10.getChannelId() + " sei:" + x.h(r10), null, 4);
        this.b.k5();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.n;
        if (r1 == null) goto L18;
        r6 = r1.Ta();
    L18:
        if (r6 == null) goto L29;
        Long r14 = StringsKt.toLongOrNull(r10.getChannelId());
        if (r14 == null) goto L22;
        r14.longValue();
    L22:
        r6.G8();
        return;
    L29:
        return;
    L28:
        return;
    }

    public LinkCheckLoadUtils(com.bytedance.android.live.revlink.impl.global.c r2, IRoom r3, com.bytedance.android.live.revlink.impl.control.c r4, yz0.f r5) {
        Intrinsics.checkNotNullParameter(r3, "room");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.a = new s(this);
        com.bytedance.android.live.revlink.impl.settings.live.c r6 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r6.getClass();
        w41.c r7 = (w41.c) com.bytedance.android.live.revlink.impl.settings.live.c.x.getValue(r6, com.bytedance.android.live.revlink.impl.settings.live.c.a[22]);
        this.b = r7;
        this.c = r7.j9();
        this.d = new HashMap();
        this.e = new HashMap();
        CompositeDisposable r8 = new CompositeDisposable();
        this.f = r8;
        i97.a r9 = i97.a.a;
        this.g = System.currentTimeMillis();
        this.j = new h0();
        if (r5 == null) goto L10;
        Observable r10 = yz0.h.a.a(r5, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r10 == null) goto L11;
        final AnonymousClass1 r12 = new AnonymousClass1(this);
        Disposable r13 = r10.subscribe(new c(r12));
        if (r13 == null) goto L12;
        com.bytedance.revenue.platform.api.core.rx.f.a(r13, r8);
        return;
    L12:
        return;
    L11:
        return;
    }
}
