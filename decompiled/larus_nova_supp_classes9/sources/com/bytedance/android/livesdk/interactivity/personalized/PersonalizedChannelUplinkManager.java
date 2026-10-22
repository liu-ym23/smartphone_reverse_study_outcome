package com.bytedance.android.livesdk.interactivity.personalized;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import ju1.n;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import vlc.d;
import vlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PersonalizedChannelUplinkManager implements x42.a {
    public PropertyOwner<n> a;
    public CompositeDisposable b;
    public long c;
    public n d;
    public boolean e;
    public final RoomContext f;

    public static final class a {
    }

    static {
    }

    public final void b() {
        this.b = new CompositeDisposable();
        this.f.getDynamicStrategy().c(new PersonalizedChannelUplinkManager$init$1(this));
    }

    @Override // x42.a
    public final void destroy() {
        CompositeDisposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
        Object r1 = this.f.getMessageManager().getValue();
        if ((r1 instanceof f) == true) goto L8;
        r1 = null;
    L8:
        f r2 = (f) r1;
        if (r2 == null) goto L11;
        r2.p(null);
    L11:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(AnonymousClass1.INSTANCE);
    }

    public PersonalizedChannelUplinkManager(RoomContext r3) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.f = r3;
        this.c = -1;
    }

    public static final void a(PersonalizedChannelUplinkManager r18, final String r19, d r20) {
        r18.getClass();
        if (r19.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L21;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(new PersonalizedChannelUplinkManager$sendPayloadItem$1(r19));
        long r5 = r18.c;
        if (r5 >= 0) goto L11;
        long r6 = System.currentTimeMillis();
        r18.c = r6;
    L12:
        long r16 = r6;
        tlc.f r4 = new tlc.f(8889, 2, "upstream", "pb", r19.getBytes(Charsets.UTF_8), new ArrayList(), r16, r16);
        if ((r20 instanceof f) == true) goto L15;
        d r7 = null;
    L16:
        f r8 = (f) r7;
        if (r8 == null) goto L19;
        r8.w(r4);
    L19:
        d4.j(r20, MapsKt.mapOf(TuplesKt.to("channel_tags", r19)));
        com.bytedance.android.livesdk.interactivity.personalized.a.a(InteractivityMonitor.Event.PersonalizedChannelUplinkNotify, (IRoom) r18.f.getRoom().getValue(), 0, null);
        return;
    L15:
        r7 = r20;
        goto L16
    L11:
        r6 = r5 + 1;
        r18.c = r6;
        goto L12
    L21:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
