package com.bytedance.android.livesdk.interactivity.barrage.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.interactivity.api.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DanmakuStateHelper implements Handler.Callback {
    public final Companion.a a;
    public final Handler b;
    public a c;
    public int d;
    public final h e;
    public final d f;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/utils/DanmakuStateHelper$Companion$HandlerMessage;", BuildConfig.FLAVOR, "UPDATE_COMMENT_MESSAGE_STATE", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum HandlerMessage extends Enum<HandlerMessage> {
            public static final HandlerMessage UPDATE_COMMENT_MESSAGE_STATE = null;
            public static final /* synthetic */ HandlerMessage[] a = null;

            static {
                HandlerMessage r1 = new HandlerMessage();
                UPDATE_COMMENT_MESSAGE_STATE = r1;
                a = new HandlerMessage[]{r1};
            }

            public static HandlerMessage valueOf(String r1) {
                return (HandlerMessage) r27.a.a(HandlerMessage.class, r1);
            }

            public static HandlerMessage[] values() {
                return (HandlerMessage[]) a.clone();
            }

            public HandlerMessage() {
                super("UPDATE_COMMENT_MESSAGE_STATE", 0);
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
                this.a = 5000;
                this.b = 30;
            }
        }
    }

    static {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        if (r6.what != Companion.HandlerMessage.UPDATE_COMMENT_MESSAGE_STATE.ordinal()) goto L50;
        Iterator<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r7 = this.e.c.iterator();
        int r0 = 0;
        int r2 = 0;
    L6:
        if (r7.hasNext() == false) goto L11;
        r0 = r0 + 1;
        if (r7.next().i() == false) goto L10;
        r2 = r2 + 1;
    L10:
        int r3 = this.a.b;
        goto L6
    L11:
        if (r0 > 0) goto L13;
        a r8 = new a(0);
    L14:
        this.c = r8;
        int r4 = 2;
        int r9 = this.f.f() * 2;
        if (r0 < 0) goto L19;
        if (r9 < r0) goto L19;
        r4 = 0;
    L29:
        if (this.d == r4) goto L40;
        com.bytedance.android.livesdk.interactivity.api.h r10 = q.g();
        if (r10 == null) goto L39;
        j<b> r11 = r10.getBarrageContext();
        if (r11 == null) goto L39;
        b r13 = (b) r11.getValue();
        if (r13 == null) goto L39;
        m<Integer> r14 = r13.getWaitDanmakuCountEnum();
        if (r14 == null) goto L39;
        r14.setValue(Integer.valueOf(r4));
    L39:
        this.d = r4;
    L40:
        com.bytedance.android.livesdk.interactivity.api.h r15 = q.g();
        if (r15 == null) goto L49;
        j<b> r16 = r15.getBarrageContext();
        if (r16 == null) goto L49;
        b r17 = (b) r16.getValue();
        if (r17 == null) goto L49;
        m<a> r18 = r17.getWaitMessageState();
        if (r18 == null) goto L49;
        r18.setValue(this.c);
    L49:
        this.b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE_COMMENT_MESSAGE_STATE.ordinal(), this.a.a);
    L19:
        int r19 = (this.f.f() * 2) + 1;
        int r5 = this.f.f() * 5;
        if (r19 > r0) goto L25;
        if (r5 < r0) goto L25;
    L27:
        r4 = 1;
    L25:
        if (r0 <= (this.f.f() * 5)) goto L27;
    L13:
        r8 = new a(r0, r2 / r0);
    L50:
        return false;
    }

    public DanmakuStateHelper(h r2, LandscapeDanmakuPresenterV2.e r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "heatController");
        this.e = r2;
        this.f = r3;
        this.a = new Companion.a();
        this.b = new Handler(Looper.getMainLooper(), this);
        this.c = new a(0);
    }
}
