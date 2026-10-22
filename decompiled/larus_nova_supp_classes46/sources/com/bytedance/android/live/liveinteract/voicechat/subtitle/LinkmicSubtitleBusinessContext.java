package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleBusinessContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lnj0/a;", "Lcom/bytedance/live/datacontext/j;", "Lnj0/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleStatus;", "status$delegate", "getStatus", "()Lcom/bytedance/live/datacontext/m;", "status", "Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "linkmicSubtitleSettingStatus$delegate", "getLinkmicSubtitleSettingStatus", "linkmicSubtitleSettingStatus", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicSubtitleBusinessContext extends DataContext implements nj0.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "LinkmicSubtitleBusinessContext";
    private final com.bytedance.live.datacontext.p linkmicSubtitleSettingStatus$delegate;
    private final com.bytedance.live.datacontext.p service$delegate;
    private final com.bytedance.live.datacontext.p status$delegate;

    public static final class a {
        public a() {
        }

        public final LinkmicSubtitleBusinessContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(nj0.a.class);
            if ((r0 instanceof LinkmicSubtitleBusinessContext) == true) goto L6;
            r0 = null;
        L6:
            return (LinkmicSubtitleBusinessContext) r0;
        }

        public static int a() {
            com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r0 == null) goto L5;
            IRoom r1 = (IRoom) r0.getValue();
        L6:
            int r2 = g0.c(r1);
            boolean r3 = false;
            if (r2 != 1) goto L9;
        L12:
            boolean r4 = true;
        L13:
            if (r4 == false) goto L16;
            return LinkmicSubtitleStyle.LONG.ordinal();
        L16:
            if (g0.c(r1) != 3) goto L18;
            r3 = true;
        L18:
            if (r3 == false) goto L21;
            return LinkmicSubtitleStyle.SHORT.ordinal();
        L21:
            return LinkmicSubtitleStyle.UNKNOWN.ordinal();
        L9:
            if (r2 == 2) goto L12;
            r4 = false;
            goto L13
        L5:
            r1 = null;
            goto L6
        }

        public static boolean c() {
            if (vm2.c.b().getAudioSubtitleGuestEnable() == true) goto L7;
            return false;
        L7:
            return true;
        }

        public final nj0.b b() {
            LinkmicSubtitleBusinessContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<nj0.b> r1 = r0.getService();
            if (r1 == null) goto L7;
            return (nj0.b) r1.getValue();
        L7:
            return null;
        }

        public final boolean d() {
            LinkmicSubtitleBusinessContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.m<LinkmicSubtitleStatus> r1 = r0.getStatus();
            if (r1 == null) goto L7;
            LinkmicSubtitleStatus r2 = (LinkmicSubtitleStatus) r1.getValue();
        L9:
            if (r2 != LinkmicSubtitleStatus.OPEN) goto L11;
            return true;
        L11:
            return false;
        L7:
            r2 = null;
            goto L9
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkmicSubtitleBusinessContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LinkmicSubtitleBusinessContext.class, "status", "getStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkmicSubtitleBusinessContext.class, "linkmicSubtitleSettingStatus", "getLinkmicSubtitleSettingStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.m<q2> getLinkmicSubtitleSettingStatus() {
        return (com.bytedance.live.datacontext.m) this.linkmicSubtitleSettingStatus$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.j<nj0.b> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<LinkmicSubtitleStatus> getStatus() {
        return (com.bytedance.live.datacontext.m) this.status$delegate.a(this, $$delegatedProperties[1]);
    }

    public LinkmicSubtitleBusinessContext() {
        this.service$delegate = ConstantKt.c(this);
        this.status$delegate = com.bytedance.live.datacontext.q.d(this, LinkmicSubtitleStatus.UNKNOWN);
        this.linkmicSubtitleSettingStatus$delegate = com.bytedance.live.datacontext.q.d(this, vh7.f.c(q2.class));
    }
}
