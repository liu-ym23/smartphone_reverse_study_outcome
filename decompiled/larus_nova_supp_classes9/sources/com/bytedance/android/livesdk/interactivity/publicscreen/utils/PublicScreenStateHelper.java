package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenIndividualPriorityState;
import com.bytedance.android.livesdk.interactivity.api.settings.config.k0;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenStateHelper implements Handler.Callback {
    public final Companion.c a;
    public final Companion.a b;
    public final Companion.b c;
    public final Handler d;
    public PublicScreenHeatState e;
    public int f;
    public int g;
    public int h;
    public final ja2.b i;
    public final g j;
    public final k0 k;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/utils/PublicScreenStateHelper$Companion$HandlerMessage;", BuildConfig.FLAVOR, "UPDATE_MESSAGE_HEAT_STATE", "UPDATE_COMMENT_MESSAGE_STATE", "UPDATE_INDIVIDUAL_PRIORITY_STATE", "UPDATE_CHAT_MESSAGE_COUNT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum HandlerMessage extends Enum<HandlerMessage> {
            public static final HandlerMessage UPDATE_CHAT_MESSAGE_COUNT = null;
            public static final HandlerMessage UPDATE_COMMENT_MESSAGE_STATE = null;
            public static final HandlerMessage UPDATE_INDIVIDUAL_PRIORITY_STATE = null;
            public static final HandlerMessage UPDATE_MESSAGE_HEAT_STATE = null;
            public static final /* synthetic */ HandlerMessage[] a = null;

            static {
                HandlerMessage r1 = new HandlerMessage("UPDATE_MESSAGE_HEAT_STATE", 0);
                UPDATE_MESSAGE_HEAT_STATE = r1;
                HandlerMessage r2 = new HandlerMessage("UPDATE_COMMENT_MESSAGE_STATE", 1);
                UPDATE_COMMENT_MESSAGE_STATE = r2;
                HandlerMessage r3 = new HandlerMessage("UPDATE_INDIVIDUAL_PRIORITY_STATE", 2);
                UPDATE_INDIVIDUAL_PRIORITY_STATE = r3;
                HandlerMessage r4 = new HandlerMessage("UPDATE_CHAT_MESSAGE_COUNT", 3);
                UPDATE_CHAT_MESSAGE_COUNT = r4;
                a = new HandlerMessage[]{r1, r2, r3, r4};
            }

            public static HandlerMessage valueOf(String r1) {
                return (HandlerMessage) r27.a.a(HandlerMessage.class, r1);
            }

            public static HandlerMessage[] values() {
                return (HandlerMessage[]) a.clone();
            }

            public HandlerMessage(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final class a {
            public final long a;
            public final int b;

            public final boolean equals(Object r6) {
                if (this != r6) goto L4;
                return true;
            L4:
                if ((r6 instanceof a) == false) goto L10;
                a r7 = (a) r6;
                if (this.a == r7.a) goto L8;
                return false;
            L8:
                if (this.b == r7.b) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                long r0 = this.a;
                return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b;
            }

            public final String toString() {
                return "CommentMessageStateConfig(updateTimeInMS=" + this.a + ", messageCount=" + this.b + ")";
            }

            public a() {
                this.a = RiskAdviseSyncData.PRIORITY;
                this.b = 30;
            }
        }

        public static final class b {
            public final long a;
            public final int b;
            public final int c;

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
                long r0 = this.a;
                return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c;
            }

            public final String toString() {
                return "IndividualPriorityStateConfig(updateTimeInMs=" + this.a + ", highProtectThreshold=" + this.b + ", lowDegradeThreshold=" + this.c + ")";
            }

            public b(int r3, int r4) {
                this.a = 30000;
                this.b = r3;
                this.c = r4;
            }
        }

        public static final class c {
            public final long a;
            public final int b;
            public final int c;

            public final boolean equals(Object r6) {
                if (this != r6) goto L4;
                return true;
            L4:
                if ((r6 instanceof c) == false) goto L12;
                c r7 = (c) r6;
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
                long r0 = this.a;
                return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c;
            }

            public final String toString() {
                return "MessageHeatStateConfig(updateTimeInMS=" + this.a + ", coldMaxLimit=" + this.b + ", hotMinLimit=" + this.c + ")";
            }

            public c(long r1, int r3, int r4) {
                this.a = r1;
                this.b = r3;
                this.c = r4;
            }
        }
    }

    static {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r20) {
        Intrinsics.checkNotNullParameter(r20, "msg");
        int r0 = r20.what;
        Companion.HandlerMessage r1 = Companion.HandlerMessage.UPDATE_MESSAGE_HEAT_STATE;
        if (r0 != r1.ordinal()) goto L24;
        int r2 = this.f;
        Companion.c r3 = this.a;
        if (r2 >= r3.b) goto L8;
        PublicScreenHeatState r4 = PublicScreenHeatState.COLD;
    L11:
        this.e = r4;
        ((aa2.v) this.j).a.C0(null, r4, null, null);
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L14;
    L23:
        this.f = 0;
        this.d.sendEmptyMessageDelayed(r1.ordinal(), this.a.a);
        return false;
    L14:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.a == false) goto L23;
        PublicScreenHeatState r5 = this.e;
        if (r5 != PublicScreenHeatState.COLD) goto L19;
        final String r6 = "低热";
    L22:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(new PublicScreenStateHelper$updateMessageHeatState$1(this, r6));
        goto L23
    L19:
        if (r5 != PublicScreenHeatState.HOT) goto L21;
        r6 = "高热";
        goto L22
    L21:
        r6 = "默认";
        goto L22
    L8:
        if (r2 <= r3.c) goto L10;
        r4 = PublicScreenHeatState.HOT;
        goto L11
    L10:
        r4 = PublicScreenHeatState.DEFAULT;
        goto L11
    L24:
        Companion.HandlerMessage r10 = Companion.HandlerMessage.UPDATE_COMMENT_MESSAGE_STATE;
        if (r0 != r10.ordinal()) goto L31;
        int r13 = this.i.i();
        final Ref.IntRef r11 = new Ref.IntRef();
        r11.element = 0;
        final Ref.IntRef r14 = new Ref.IntRef();
        r14.element = 0;
        final Ref.IntRef r15 = new Ref.IntRef();
        r15.element = 0;
        final Ref.IntRef r16 = new Ref.IntRef();
        r16.element = 0;
        final Ref.IntRef r7 = new Ref.IntRef();
        r7.element = 0;
        this.i.e(new PublicScreenStateHelper$updateCommentMessageState$1(this, r11, r14, r15, r16, r7));
        int r8 = r11.element;
        if (r8 > 0) goto L29;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f r9 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f(0);
    L30:
        ((aa2.v) this.j).a.C0(null, null, r9, null);
        this.d.sendEmptyMessageDelayed(r10.ordinal(), this.b.a);
        return false;
    L29:
        float r17 = r8;
        r9 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f(r13, r8, r16.element / r17, r15.element / r17, r14.element / r17, r7.element / r17);
        goto L30
    L31:
        Companion.HandlerMessage r18 = Companion.HandlerMessage.UPDATE_INDIVIDUAL_PRIORITY_STATE;
        if (r0 != r18.ordinal()) goto L46;
        int r19 = this.h;
        Companion.b r21 = this.c;
        int r23 = r21.b;
        if (r19 >= r23) goto L36;
    L38:
        if (r19 < r23) goto L41;
        PublicScreenIndividualPriorityState r24 = PublicScreenIndividualPriorityState.HIGH_PROTECT;
    L44:
        ((aa2.v) this.j).a.C.f(r24);
        this.h = 0;
        this.d.sendEmptyMessageDelayed(r18.ordinal(), this.c.a);
        return false;
    L41:
        if (r19 < r21.c) goto L43;
        r24 = PublicScreenIndividualPriorityState.LOW_DEGRADE;
        goto L44
    L43:
        r24 = PublicScreenIndividualPriorityState.DEFAULT;
        goto L44
    L36:
        if (r19 < r21.c) goto L38;
        r24 = PublicScreenIndividualPriorityState.HIT_ALL;
        goto L44
    L46:
        if (r0 != Companion.HandlerMessage.UPDATE_CHAT_MESSAGE_COUNT.ordinal()) goto L128;
        g r25 = this.j;
        int r26 = this.g;
        aa2.v r27 = (aa2.v) r25;
        l r28 = r27.a.J;
        if (r28 != null) goto L50;
        int r29 = 0;
    L116:
        this.g = r29;
        Handler r30 = this.d;
        int r31 = Companion.HandlerMessage.UPDATE_CHAT_MESSAGE_COUNT.ordinal();
        int r33 = this.k.heatStatusCalculateInterval;
        if (r33 > 0) goto L119;
        r33 = 5;
    L119:
        r30.sendEmptyMessageDelayed(r31, r33 * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        return false;
    L50:
        if (r28.h == false) goto L52;
    L51:
        r29 = 0;
    L112:
        boolean r110 = false;
    L113:
        if (r110 == false) goto L116;
        TransTextMessagePresenter r34 = r27.a;
        r34.C0(null, null, null, r34.J.a);
        goto L116
    L52:
        ((ArrayDeque) r28.g).offer(Integer.valueOf(r26));
        r28.b += r26;
        if (((ArrayDeque) r28.g).size() < r28.f) goto L55;
        boolean r35 = true;
    L56:
        if (r35 == false) goto L111;
        int r36 = ((ArrayDeque) r28.g).size() - r28.f;
        if (r36 <= 0) goto L65;
        int r37 = 0;
    L60:
        if (r37 >= r36) goto L65;
        Integer r38 = (Integer) ((ArrayDeque) r28.g).poll();
        if (r38 == null) goto L64;
        int r39 = r38.intValue();
        int r40 = r28.b - r39;
        r28.b = r40;
        boolean r41 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        k0 r43 = r28.i;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a(r43.chatCountDuration, r43.heatStatusCalculateInterval, r40, r26, r39);
    L64:
        r37 = r37 + 1;
    L65:
        int r44 = r28.b;
        k0 r45 = r28.i;
        if (r44 < r45.hotStatusChatCountThreshold) goto L69;
        PSMessageHeatState r46 = PSMessageHeatState.HOT;
    L72:
        boolean r47 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        int r48 = r45.chatCountDuration;
        Intrinsics.checkNotNullParameter(r46, "state");
        boolean r49 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        if (r49 == false) goto L77;
        ALogger.e("PS_MESSAGE_HEAT", "最近" + r48 + "秒评论总数：" + r44 + "，对应的热度状态：" + r46.name());
    L77:
        if (r28.e == false) goto L83;
        PSMessageHeatState r50 = r28.a;
        Intrinsics.checkNotNullParameter(r50, "curState");
        Intrinsics.checkNotNullParameter(r46, "newState");
        if (r49 == false) goto L82;
        ALogger.e("PS_MESSAGE_HEAT", "第一次使用评论数量计算热度，热度从" + r50.name() + "变为" + r46.name());
    L82:
        r28.a = r46;
        r28.e = false;
        ALogger.i("PS_MESSAGE_HEAT", "first time use chat count, cur chat count: " + r28.b + ", new state: " + r46);
        r29 = 0;
        r110 = true;
        goto L113
    L83:
        PSMessageHeatState r51 = r28.a;
        if (r46 != r51) goto L90;
        String r53 = "新状态与当前状态均为" + r28.a.name() + ", 当前计数为" + r28.c + ", 重置为0";
        Intrinsics.checkNotNullParameter(r53, "failReason");
        if (r49 == false) goto L89;
        ALogger.e("PS_MESSAGE_HEAT", r53);
    L89:
        ALogger.i("PS_MESSAGE_HEAT", "new state and old state are both " + r28.a.name() + ", reset record status");
        r28.c = 0;
        r28.d = null;
        goto L51
    L90:
        int r54 = m.a[r51.ordinal()];
        if (r54 != 1) goto L93;
    L109:
        r28.c++;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.b("本次计算状态：" + r46.name() + ",与当前状态：" + r28.a.name() + "不同，计数+1，当前计数为" + r28.c);
        boolean r55 = r28.a(PSMessageHeatState.NORMAL);
    L110:
        r110 = r55;
        r29 = 0;
        goto L113
    L93:
        if (r54 == 2) goto L109;
        if (r54 != 3) goto L108;
        PSMessageHeatState r56 = r28.d;
        if (r56 != null) goto L99;
        r28.d = r46;
        r28.c++;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.b("当前状态为中热, 本次计算状态为：" + r46.name() + ", 计数+1，当前计数为" + r28.c);
    L106:
        r55 = r28.a(r46);
        goto L110
    L99:
        if (r46 != r56) goto L101;
        r28.c++;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.b("当前状态为中热, 新状态与上次计算状态均为：" + r46.name() + ", 计数+1，当前计数为" + r28.c);
        goto L106
    L101:
        StringBuilder r57 = new StringBuilder("当前状态为中热，上次计算状态为");
        PSMessageHeatState r58 = r28.d;
        if (r58 == null) goto L104;
        String r59 = r58.name();
    L105:
        r57.append(r59);
        r57.append("，新状态为");
        r57.append(r46.name());
        r57.append("，计数重置为1");
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.b(r57.toString());
        r28.d = r46;
        r28.c = 1;
        goto L106
    L104:
        r59 = null;
        goto L105
    L108:
        throw new NoWhenBranchMatchedException();
    L69:
        if (r44 >= r45.coldStatusChatCountThreshold) goto L71;
        r46 = PSMessageHeatState.COLD;
        goto L72
    L71:
        r46 = PSMessageHeatState.NORMAL;
        goto L72
    L111:
        boolean r60 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        k0 r61 = r28.i;
        r29 = 0;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a(r61.chatCountDuration, r61.heatStatusCalculateInterval, r28.b, r26, 0);
        goto L112
    L55:
        r35 = false;
        goto L56
    L128:
        return false;
    }

    public static final int a(PublicScreenStateHelper r1, com.bytedance.android.live.base.model.message.k0 r2) {
        r1.getClass();
        String r3 = r2.getChatContent();
        int r0 = 0;
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L6:
        IBaseUser r5 = r2.getUserInfo();
        if (r5 == null) goto L12;
        String r6 = r5.getNickName();
        if (r6 == null) goto L12;
        r0 = r6.length();
    L12:
        return r4 + r0;
    L5:
        r4 = 0;
        goto L6
    }

    public PublicScreenStateHelper(com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a r5, aa2.v r6, o72.b r7, int r8, com.bytedance.android.livesdk.interactivity.api.settings.config.m r9, k0 r10) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r9, "priorityConfig");
        Intrinsics.checkNotNullParameter(r10, "messageHeatConfig");
        this.i = r5;
        this.j = r6;
        this.k = r10;
        if (r7 == null) goto L5;
        int r11 = r7.intervalTime;
    L6:
        long r0 = ((long) r11) * 1000;
        if (r7 == null) goto L9;
        int r13 = r7.intervalMaxMessageSize;
    L10:
        this.a = new Companion.c(r0, r13, r8);
        this.b = new Companion.a();
        this.c = new Companion.b(r9.highPriorityProtectThreshold, r9.lowPriorityDegradeThreshold);
        this.d = new Handler(Looper.getMainLooper(), this);
        this.e = PublicScreenHeatState.DEFAULT;
        return;
    L9:
        r13 = 60;
        goto L10
    L5:
        r11 = 20;
        goto L6
    }
}
