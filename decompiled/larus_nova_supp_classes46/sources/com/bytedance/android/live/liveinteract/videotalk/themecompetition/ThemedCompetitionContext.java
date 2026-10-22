package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.model.interact.SelectionType;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionStatus;
import com.bytedance.android.livesdk.chatroom.model.interact.a2;
import com.bytedance.android.livesdk.chatroom.model.interact.b2;
import com.bytedance.android.livesdk.chatroom.model.interact.n1;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/themecompetition/ThemedCompetitionContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lpj0/a;", "Lcom/bytedance/live/datacontext/j;", "Lpj0/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/ThemedCompetitionStatus;", "status$delegate", "getStatus", "()Lcom/bytedance/live/datacontext/m;", "status", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a2;", "info$delegate", "getInfo", "()Lcom/bytedance/live/datacontext/n;", "info", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ThemedCompetitionContext extends DataContext implements pj0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p info$delegate;
    private final p service$delegate;
    private final p status$delegate;

    public static final class a {
        public a() {
        }

        public static boolean e() {
            IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
            if (r0 == null) goto L13;
            com.bytedance.android.livesdk.user.e r1 = r0.user();
            if (r1 == null) goto L13;
            UserAttr r2 = r1.q();
            if (r2 == null) goto L13;
            List r3 = r2.getAdminPrivileges();
            if (r3 == null) goto L13;
            LiveRoomPermission.D.getClass();
            if (r3.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L13;
            return true;
        L13:
            return false;
        }

        public final ThemedCompetitionContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(pj0.a.class);
            if ((r0 instanceof ThemedCompetitionContext) == true) goto L6;
            r0 = null;
        L6:
            return (ThemedCompetitionContext) r0;
        }

        public final int b() {
            ThemedCompetitionContext r0 = getContext();
            if (r0 == null) goto L12;
            n<a2> r1 = r0.getInfo();
            if (r1 == null) goto L12;
            a2 r2 = (a2) r1.getValue();
            if (r2 == null) goto L12;
            b2 r3 = r2.getSetting();
            if (r3 == null) goto L12;
            return r3.getSelectionType();
        L12:
            return SelectionType.UNKNOWN.getValue();
        }

        public final pj0.b c() {
            ThemedCompetitionContext r0 = getContext();
            if (r0 == null) goto L7;
            j<pj0.b> r1 = r0.getService();
            if (r1 == null) goto L7;
            return (pj0.b) r1.getValue();
        L7:
            return null;
        }

        public final boolean g() {
            ThemedCompetitionContext r0 = getContext();
            if (r0 == null) goto L7;
            m<ThemedCompetitionStatus> r1 = r0.getStatus();
            if (r1 == null) goto L7;
            ThemedCompetitionStatus r2 = (ThemedCompetitionStatus) r1.getValue();
        L9:
            if (r2 != ThemedCompetitionStatus.START) goto L11;
            return true;
        L11:
            return false;
        L7:
            r2 = null;
            goto L9
        }

        public final boolean h() {
            ThemedCompetitionContext r0 = getContext();
            ThemedCompetitionStatus r1 = null;
            if (r0 == null) goto L7;
            m<ThemedCompetitionStatus> r2 = r0.getStatus();
            if (r2 == null) goto L7;
            ThemedCompetitionStatus r3 = (ThemedCompetitionStatus) r2.getValue();
        L9:
            if (r3 == ThemedCompetitionStatus.START) goto L19;
            ThemedCompetitionContext r4 = getContext();
            if (r4 == null) goto L16;
            m<ThemedCompetitionStatus> r5 = r4.getStatus();
            if (r5 == null) goto L16;
            r1 = (ThemedCompetitionStatus) r5.getValue();
        L16:
            if (r1 == ThemedCompetitionStatus.SHOW_RESULT) goto L19;
            return false;
        L19:
            return true;
        L7:
            r3 = null;
            goto L9
        }

        public final String a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "score");
            int r0 = b();
            if (r0 != SelectionType.NORMAL.getValue()) goto L6;
            return r3;
        L6:
            if (r0 != SelectionType.SCORING.getValue()) goto L9;
            StringBuffer r1 = new StringBuffer();
            r1.append(r3);
            r1.append("分");
            return r1.toString();
        L9:
            return r3;
        }

        public final n1 d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            ThemedCompetitionContext r0 = getContext();
            if (r0 == null) goto L13;
            n<a2> r1 = r0.getInfo();
            if (r1 == null) goto L13;
            a2 r3 = (a2) r1.getValue();
            if (r3 == null) goto L13;
            Map r4 = r3.getUserIdStrToScore();
            if (r4 == null) goto L13;
            n1 r5 = (n1) r4.get(r2);
            if (r5 == null) goto L13;
            return r5;
        L13:
            return vh7.f.c(n1.class);
        }

        public final void f(a2 r4) {
            Intrinsics.checkNotNullParameter(r4, "info");
            int r0 = r4.getStatus();
            ThemedCompetitionStatus r1 = ThemedCompetitionStatus.START;
            if (r0 != r1.getValue()) goto L9;
            ThemedCompetitionContext r2 = getContext();
            if (r2 == null) goto L16;
            m<ThemedCompetitionStatus> r3 = r2.getStatus();
            if (r3 == null) goto L16;
            r3.setValue(r1);
        L16:
            ThemedCompetitionContext r5 = getContext();
            if (r5 == null) goto L22;
            n<a2> r6 = r5.getInfo();
            if (r6 == null) goto L23;
            r6.setValue(r4);
            return;
        L23:
            return;
        L22:
            return;
        L9:
            int r7 = r4.getStatus();
            ThemedCompetitionStatus r8 = ThemedCompetitionStatus.SHOW_RESULT;
            if (r7 != r8.getValue()) goto L16;
            ThemedCompetitionContext r9 = getContext();
            if (r9 == null) goto L16;
            m<ThemedCompetitionStatus> r10 = r9.getStatus();
            if (r10 == null) goto L16;
            r10.setValue(r8);
            goto L16
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ThemedCompetitionContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ThemedCompetitionContext.class, "status", "getStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ThemedCompetitionContext.class, "info", "getInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final n<a2> getInfo() {
        return (n) this.info$delegate.a(this, $$delegatedProperties[2]);
    }

    public final j<pj0.b> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<ThemedCompetitionStatus> getStatus() {
        return (m) this.status$delegate.a(this, $$delegatedProperties[1]);
    }

    public ThemedCompetitionContext() {
        this.service$delegate = ConstantKt.c(this);
        this.status$delegate = q.d(this, ThemedCompetitionStatus.UNKNOWN);
        this.info$delegate = q.c(this);
    }
}
