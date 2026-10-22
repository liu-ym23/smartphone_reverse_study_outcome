package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.interactivity.seek.EpisodePlayEventNotifyWidget;
import com.bytedance.android.livesdk.interactivity.seek.EpisodeSeekMessageServiceWidget;
import com.bytedance.android.livesdk.vscore_api.IEpisodeInteractiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J@\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/EpisodeInteractiveService;", "Lcom/bytedance/android/livesdk/vscore_api/IEpisodeInteractiveService;", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getEpisodeSeekMessageServiceWidgetClass", "getEpisodePlayEventNotifyWidgetClass", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "isFirstShow", BuildConfig.FLAVOR, "roomId", "episodeId", BuildConfig.FLAVOR, "episodeStage", "seasonId", "Lvlc/d;", "provideSeekMessageManager", BuildConfig.FLAVOR, "liveBaseContext", BuildConfig.FLAVOR, "setUpForTemplate", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class EpisodeInteractiveService implements IEpisodeInteractiveService {
    public EpisodeInteractiveService() {
    }

    public Class<? extends Widget> getEpisodePlayEventNotifyWidgetClass() {
        return EpisodePlayEventNotifyWidget.class;
    }

    public Class<? extends Widget> getEpisodeSeekMessageServiceWidgetClass() {
        return EpisodeSeekMessageServiceWidget.class;
    }

    public void setUpForTemplate(Object r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if ((r2 instanceof d90.a) == false) goto L18;
        nm1.q r0 = pm1.f.m();
        if (r0 == null) goto L19;
        RoomContext r4 = ((d90.a) r2).b();
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L15;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L15;
        EpisodeExtraInfo r7 = r6.getEpisodeComponentData();
        if (r7 == null) goto L15;
        boolean r8 = r7.isInteractConfigExist();
    L16:
        r0.c(r8, r3);
        return;
    L15:
        r8 = false;
        goto L16
    L19:
        return;
    }

    public vlc.d provideSeekMessageManager(Context r15, DataCenter r16, boolean r17, long r18, long r20, int r23, long r24) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "dataCenter");
        int r6 = com.bytedance.android.livesdk.interactivity.seek.d.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "dataCenter");
        String r5 = jc1.k.n(IUserService.class).user().n();
        VSDataContext.Companion.getClass();
        VSDataContext r0 = VSDataContext.a.b(r16);
        boolean r7 = false;
        long r8 = 0;
        if (r0 == null) goto L16;
        com.bytedance.live.datacontext.m r1 = r0.isVSVideo();
        if (r1 == null) goto L16;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L16;
        VSDataContext r10 = VSDataContext.a.b(r16);
        if (r10 == null) goto L15;
        com.bytedance.live.datacontext.n r11 = r10.getEpisode();
        if (r11 == null) goto L15;
        Episode r13 = (Episode) r11.getValue();
        if (r13 == null) goto L15;
        r8 = r13.attachRoomId;
    L15:
        com.bytedance.android.livesdk.message.interceptor.d r2 = new com.bytedance.android.livesdk.message.interceptor.d(r18, r8);
    L32:
        nm1.e r9 = pm1.f.c();
        if (r9 != null) goto L35;
    L37:
        if (r7 == false) goto L39;
        amc.e r14 = new com.bytedance.android.livesdk.interactivity.seek.v2.a(r16, r15, r18, r5, r17, r20, r23, r24, CollectionsKt.listOf(r2));
    L41:
        return amc.f.a(r14);
    L39:
        r14 = new com.bytedance.android.livesdk.interactivity.seek.v2.b(r16, r15, r18, r5, r17, r20, r23, r24, CollectionsKt.listOf(r2));
        goto L41
    L35:
        if (r9.f(r16) != true) goto L37;
        r7 = true;
    L16:
        nm1.e r3 = pm1.f.c();
        if (r3 != null) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L31;
        lm1.b r19 = pm1.f.d(r16);
        if (r19 == null) goto L30;
        com.bytedance.live.datacontext.n r110 = r19.getEpisode();
        if (r110 == null) goto L30;
        Episode r111 = (Episode) r110.getValue();
        if (r111 == null) goto L30;
        r8 = r111.attachRoomId;
    L30:
        r2 = new com.bytedance.android.livesdk.message.interceptor.d(r18, r8);
        goto L32
    L31:
        r2 = new com.bytedance.android.livesdk.message.interceptor.d(r18);
        goto L32
    L19:
        if (r3.f(r16) != true) goto L21;
        r4 = true;
        goto L22
    }
}
