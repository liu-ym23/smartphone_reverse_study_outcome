package com.larus.audio.tts.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.media.app.NotificationCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0002;<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\u0006\u0010#\u001a\u00020\nH\u0002J\u0014\u0010,\u001a\u00020-*\u00020-2\u0006\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\f\u00100\u001a\u000201*\u000201H\u0002J\f\u00100\u001a\u00020-*\u00020-H\u0002J\b\u00102\u001a\u00020\u001fH\u0002J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\nH\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020'H\u0002J\"\u00107\u001a\u0002082\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/audio/tts/notification/FlowTtsMediaService;", "Landroid/app/Service;", "Lcom/larus/audio/tts/notification/ITtsMediaSessionService;", "<init>", "()V", "binder", "Lcom/larus/audio/tts/notification/FlowTtsMediaService$TtsMediaServiceBinder;", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "isStopped", "", "isForeground", "playPendingIntent", "Landroid/app/PendingIntent;", "getPlayPendingIntent", "()Landroid/app/PendingIntent;", "playPendingIntent$delegate", "Lkotlin/Lazy;", "pausePendingIntent", "getPausePendingIntent", "pausePendingIntent$delegate", "metadata", "Lcom/larus/audio/tts/notification/ITtsMediaSessionService$Metadata;", "mCoverDarkMode", "mCoverBitmap", "Landroid/graphics/Bitmap;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "stopService", "", "activateMediaSession", "deactivateMediaSession", "showMediaNotification", "isPlaying", "dismissMediaNotification", "updateMediaMetadata", "getAppName", "", "updatePlaybackState", "buildNotification", "Landroid/app/Notification;", "session", "addPlayPauseAction", "Landroidx/core/app/NotificationCompat$Builder;", "playing", "createNotificationChannel", "updateCoverImage", "Landroid/support/v4/media/MediaMetadataCompat$Builder;", "doUpdateCoverImage", "createDefaultBackgroundBitmap", "isDarkMode", "pendingIntent", "action", "onStartCommand", "", "flags", "startId", "Companion", "TtsMediaServiceBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FlowTtsMediaService extends Service implements g {
    public static final /* synthetic */ int j = 0;
    public final b a;
    public MediaSessionCompat b;
    public boolean c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public g.a g;
    public boolean h;
    public Bitmap i;

    public static final class a {
    }

    public final class b extends Binder {
        public final /* synthetic */ FlowTtsMediaService a;

        public b(FlowTtsMediaService r1) {
            this.a = r1;
        }
    }

    public static final class c implements pk9.a.a {
        public c() {
        }

        public final void a() {
            IFlowTtsClientService.a.getClass();
            IFlowTtsClientService.a.a().f("media_session_deactivated");
        }
    }

    public static final class d extends MediaSessionCompat.Callback {
        public final void onPause() {
            IFlowTtsClientService.a.getClass();
            IFlowTtsClientService.a.a().l();
        }

        public final void onPlay() {
            IFlowTtsClientService.a.getClass();
            IFlowTtsClientService.a.a().k();
        }

        public d() {
        }

        public final boolean onMediaButtonEvent(Intent r4) {
            Intrinsics.checkNotNullParameter(r4, "mediaButtonEvent");
            if (Build.VERSION.SDK_INT < 33) goto L5;
            KeyEvent r0 = (KeyEvent) r4.getParcelableExtra("android.intent.extra.KEY_EVENT", KeyEvent.class);
        L9:
            int r1 = c68.b.a;
            c68.b.d("FlowTtsMediaService", "onMediaButtonEvent: " + r0);
            if (r0 != null) goto L14;
            return super.onMediaButtonEvent(r4);
        L14:
            if (r0.getAction() != 0) goto L36;
            int r2 = r0.getKeyCode();
            if (r2 != 79) goto L18;
        L26:
            IFlowTtsClientService.a.getClass();
            if (IFlowTtsClientService.a.a().m() != PlayStateEnum.PLAY_STATE_PLAYING) goto L29;
            boolean r5 = true;
        L30:
            IFlowTtsClientService r3 = IFlowTtsClientService.a.a();
            if (r5 == false) goto L33;
            r3.l();
        L34:
            return true;
        L33:
            r3.k();
            goto L34
        L29:
            r5 = false;
            goto L30
        L18:
            if (r2 == 85) goto L26;
            if (r2 == 126) goto L26;
            if (r2 != 127) goto L36;
            IFlowTtsClientService.a.getClass();
            IFlowTtsClientService.a.a().l();
            return true;
        L36:
            return super.onMediaButtonEvent(r4);
        L5:
            Bundle r6 = r4.getExtras();
            if (r6 == null) goto L8;
            r0 = (KeyEvent) r6.getParcelable("android.intent.extra.KEY_EVENT");
            goto L9
        L8:
            r0 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.larus.audio.tts.notification.g
    public void stopService() {
        this.c = true;
        b();
        d();
        stopSelf();
    }

    @Override // com.larus.audio.tts.notification.g
    public final void b() {
        int r0 = c68.b.a;
        c68.b.d("FlowTtsMediaService", "dismissMediaNotification: isStopped=" + this.c + ", isForeground=" + this.d);
        if (this.c == false) goto L5;
        return;
    L5:
        if (this.d == true) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        stopForeground(1);
    L11:
        this.d = false;
        return;
    L10:
        stopForeground(true);
        goto L11
    }

    @Override // com.larus.audio.tts.notification.g
    public final boolean c() {
        int r1 = c68.b.a;
        StringBuilder r2 = new StringBuilder("activateMediaSession: isStopped=");
        r2.append(this.c);
        r2.append(", isActive: ");
        MediaSessionCompat r3 = this.b;
        if (r3 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r3.isActive());
    L6:
        r2.append(r4);
        c68.b.d("FlowTtsMediaService", r2.toString());
        if (this.c == false) goto L9;
        return false;
    L9:
        MediaSessionCompat r5 = this.b;
        if (r5 != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L29;
        return true;
    L29:
        MediaSessionCompat r7 = new MediaSessionCompat(this, "FlowTtsMediaService");     // Catch: Exception -> L24
        r7.setCallback(new d());     // Catch: Exception -> L24
        r7.setFlags(3);     // Catch: Exception -> L24
        Bundle r8 = new Bundle();     // Catch: Exception -> L24
        r8.putBoolean("HMOS_MEDIA_CONTROLLER", true);     // Catch: Exception -> L24
        r7.setExtras(r8);     // Catch: Exception -> L24
        this.b = r7;     // Catch: Exception -> L24
        pk9.a r9 = pk9.a.a;     // Catch: Exception -> L20
        pk9.a.b(r7, new c());     // Catch: Exception -> L20
        r9.a(r7);     // Catch: Exception -> L20
    L22:
        r7.setActive(true);     // Catch: Exception -> L24
        c68.b.d("FlowTtsMediaService", "activateMediaSession: session.isActive=" + r7.isActive());     // Catch: Exception -> L24
        return true;
    L20:
        e = move-exception;
        c68.b.c("FlowTtsMediaService", "activateMediaSession: MediaSessionGlobalManager error", e);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        c68.b.c("FlowTtsMediaService", "activateMediaSession: failed", e);
        return false;
    L12:
        if (r5.isActive() != true) goto L14;
        r6 = true;
        goto L15
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.audio.tts.notification.g
    public final void d() {
        int r0 = c68.b.a;
        StringBuilder r1 = new StringBuilder("deactivateMediaSession: isStopped=");
        r1.append(this.c);
        r1.append(", isActive: ");
        MediaSessionCompat r2 = this.b;
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.isActive());
    L6:
        r1.append(r3);
        c68.b.d("FlowTtsMediaService", r1.toString());
        MediaSessionCompat r4 = this.b;
        if (r4 == null) goto L9;
        r4.setActive(false);
    L9:
        MediaSessionCompat r5 = this.b;
        if (r5 == null) goto L12;
        r5.release();
    L12:
        pk9.a r6 = pk9.a.a;
        MediaSessionCompat r7 = this.b;
        if (r7 == null) goto L16;
        pk9.a.b.remove(r7);
    L16:
        this.b = null;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void i() {
        boolean r0 = h.a;
        boolean r1 = h.b(this);
        if (this.i != null) goto L5;
    L6:
        this.h = r1;
        if (r1 == false) goto L9;
        int r2 = -16777216;
    L10:
        Drawable r3 = getDrawable(AppHost.a.b());
        if (r3 == null) goto L13;
        Bitmap r4 = DrawableKt.toBitmapOrNull(r3, 256, 256, Bitmap.Config.ARGB_8888);
    L14:
        if (r4 != null) goto L16;
        r4 = Bitmap.createBitmap(new int[]{r2}, 1, 1, Bitmap.Config.RGB_565);
    L16:
        this.i = r4;
        return;
    L13:
        r4 = null;
        goto L14
    L9:
        r2 = -1;
        goto L10
    L5:
        if (this.h != r1) goto L6;
    }

    public final String j() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(getPackageManager().getApplicationLabel(getApplicationInfo()).toString());     // Catch: Throwable -> L4
    L6:
        String r2 = null;
        Object r3 = null;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r4 = (String) r1;
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        return r4;
    L18:
        int r6 = getApplicationInfo().labelRes;
        if (r6 != 0) goto L34;
    L29:
        if (r2 != null) goto L36;
        return "";
    L36:
        return r2;
    L34:
        Object r7 = Result.constructor-impl(getString(r6));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r7) == true) goto L28;
        r3 = r7;
    L28:
        r2 = (String) r3;
    L22:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L12:
        if (r4.length() == 0) goto L15;
        r5 = false;
    L4:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public FlowTtsMediaService() {
        this.a = new b(this);
        this.e = LazyKt.lazy(new com.larus.audio.tts.notification.a(this));
        this.f = LazyKt.lazy(new com.larus.audio.tts.notification.b(this));
    }

    @Override // com.larus.audio.tts.notification.g
    public final boolean a() {
        return this.c;
    }

    @Override // com.larus.audio.tts.notification.g
    public final boolean e(boolean r9) {
        int r0 = c68.b.a;
        c68.b.d("FlowTtsMediaService", "showMediaNotification: isPlaying=" + r9 + ", isForeground=" + this.d + ", isStopped=" + this.c);
        if (ObricTtsControlDelegate.b.s() == false) goto L6;
        return true;
    L6:
        if (this.d == false) goto L9;
        return true;
    L9:
        if (this.c == false) goto L11;
        return false;
    L11:
        MediaSessionCompat r1 = this.b;
        if (r1 != null) goto L16;
        c68.b.d("FlowTtsMediaService", "showMediaNotification: mediaSession is null, trying to activate");
        if (c() == false) goto L16;
        r1 = this.b;
    L16:
        if (r1 != null) goto L19;
        return false;
    L19:
        if (Build.VERSION.SDK_INT >= 26) goto L36;
    L24:
        Notification r10 = h(r1, r9);
    L31:
        e = move-exception;
        c68.b.c("FlowTtsMediaService", "showMediaNotification: failed", e);
        return false;
    L26:
        if (Build.VERSION.SDK_INT < 34) goto L28;
        startForeground(936001, r10, 2);     // Catch: Exception -> L31
    L29:
        this.d = true;     // Catch: Exception -> L31
        c68.b.d("FlowTtsMediaService", "showMediaNotification: startForeground success");     // Catch: Exception -> L31
        return true;
    L28:
        startForeground(936001, r10);     // Catch: Exception -> L31
        goto L29
    L36:
        NotificationChannel r4 = new NotificationChannel("tts_channel", "tts", 2);     // Catch: Exception -> L22
        r4.enableVibration(false);     // Catch: Exception -> L22
        r4.setSound(null, null);     // Catch: Exception -> L22
        NotificationManagerCompat.from(this).createNotificationChannel(r4);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        int r5 = c68.b.a;
        c68.b.c("FlowTtsMediaService", "createNotificationChannel: failed, " + e, e);
        goto L24
    }

    @Override // com.larus.audio.tts.notification.g
    public final boolean f(boolean r10) {
        int r0 = c68.b.a;
        StringBuilder r1 = new StringBuilder("updatePlaybackState: isPlaying=");
        r1.append(r10);
        r1.append(", isStopped=");
        r1.append(this.c);
        r1.append(", hasSession: ");
        boolean r2 = true;
        if (this.b == null) goto L5;
        boolean r3 = true;
    L6:
        r1.append(r3);
        r1.append(", isForeground=");
        r1.append(this.d);
        c68.b.d("FlowTtsMediaService", r1.toString());
        if (ObricTtsControlDelegate.b.s() == false) goto L9;
        return true;
    L9:
        MediaSessionCompat r4 = this.b;
        if (r4 != null) goto L14;
        c68.b.d("FlowTtsMediaService", "updatePlaybackState: mediaSession is null, trying to activate");
        if (c() == false) goto L14;
        r4 = this.b;
    L14:
        if (r4 != null) goto L17;
        return false;
    L17:
        if (this.c == false) goto L20;
        return false;
    L20:
        if (this.d == true) goto L24;
        c68.b.d("FlowTtsMediaService", "updatePlaybackState: not foreground, trying to show notification");
        if (e(r10) == true) goto L24;
        return false;
    L24:
        PlaybackStateCompat.Builder r5 = new PlaybackStateCompat.Builder();
        Bundle r6 = new Bundle();
        r6.putBoolean("HMOS_MEDIA_CONTROLLER_LYRIC", false);
        PlaybackStateCompat.Builder r7 = r5.setExtras(r6).setActions(518);
        if (r10 == false) goto L27;
        int r8 = 3;
    L38:
        r4.setPlaybackState(r7.setState(r8, -1, 1.0f).build());     // Catch: Exception -> L35
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) goto L33;
        NotificationManagerCompat.from(this).notify(936001, h(r4, r10));     // Catch: Exception -> L35
    L40:
        return r2;
    L33:
        r2 = false;
    L35:
        e = move-exception;
        int r9 = c68.b.a;
        c68.b.c("FlowTtsMediaService", "updatePlaybackState: failed, " + e.getMessage(), e);
        return false;
    L27:
        r8 = 2;
        goto L38
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.larus.audio.tts.notification.g
    public final boolean g(g.a r7) {
        Intrinsics.checkNotNullParameter(r7, "metadata");
        int r0 = c68.b.a;
        StringBuilder r1 = new StringBuilder("updateMediaMetadata: isStopped=");
        r1.append(this.c);
        r1.append(", hasSession: ");
        if (this.b == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        c68.b.d("FlowTtsMediaService", r1.toString());
        if (this.c == false) goto L9;
        return false;
    L9:
        MediaSessionCompat r3 = this.b;
        if (r3 != null) goto L12;
        return false;
    L12:
        this.g = r7;
        MediaMetadataCompat.Builder r4 = new MediaMetadataCompat.Builder();
        String r5 = r7.a;
        if (r5 != null) goto L15;
        r5 = j();
    L15:
        MediaMetadataCompat.Builder r6 = r4.putString("android.media.metadata.TITLE", r5);
        String r8 = r7.b;
        if (r8 != null) goto L18;
        r8 = j();
    L18:
        MediaMetadataCompat.Builder r9 = r6.putString("android.media.metadata.ARTIST", r8).putLong("android.media.metadata.DURATION", -1);
        i();
        r9.putBitmap("android.media.metadata.ALBUM_ART", this.i);
        r3.setMetadata(r9.build());     // Catch: Exception -> L21
        return true;
    L21:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a;
    }

    public final Notification h(MediaSessionCompat r6, boolean r7) {
        int r0 = c68.b.a;
        c68.b.d("FlowTtsMediaService", "buildNotification: isPlaying=" + r7);
        NotificationCompat.MediaStyle r8 = new NotificationCompat.MediaStyle().setMediaSession(r6.getSessionToken()).setShowActionsInCompactView(new int[]{0}).setShowCancelButton(false).setCancelButtonIntent(null);
        androidx.core.app.NotificationCompat.Builder r1 = new androidx.core.app.NotificationCompat.Builder(this, "tts_channel").setShowWhen(false).setSound(null).setVibrate(null);
        g.a r3 = this.g;
        if (r3 == null) goto L6;
        String r4 = r3.a;
        if (r4 == null) goto L6;
    L7:
        androidx.core.app.NotificationCompat.Builder r2 = r1.setContentTitle(r4).setSmallIcon(getApplicationInfo().icon);
        g.a r5 = this.g;
        if (r5 == null) goto L11;
        String r9 = r5.b;
        if (r9 == null) goto L11;
    L12:
        androidx.core.app.NotificationCompat.Builder r10 = r2.setContentText(r9);
        i();
        r10.setLargeIcon(this.i);
        androidx.core.app.NotificationCompat.Builder r11 = r10.setAutoCancel(false).setOngoing(true).setPriority(1).setVisibility(1);
        if (r7 == false) goto L15;
        PendingIntent r12 = (PendingIntent) this.f.getValue();
        String r13 = "pause";
        int r14 = 2131238499;
    L16:
        Notification r15 = r11.addAction(r14, r13, r12).setStyle(r8).setCategory("transport").build();
        ObricTtsControlDelegate.b.q(r15.extras);
        return r15;
    L15:
        r12 = (PendingIntent) this.e.getValue();
        r13 = "play";
        r14 = 2131238500;
    L11:
        r9 = j();
    L6:
        r4 = j();
        goto L7
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r4, int r5, int r6) {
        if (r4 == null) goto L4;
        String r0 = r4.getAction();
    L5:
        if (r0 == null) goto L20;
        int r1 = r0.hashCode();
        if (r1 == 3443508) goto L16;
        if (r1 != 106440182) goto L20;
        if (r0.equals("pause") == false) goto L20;
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().l();
        goto L20
    L16:
        if (r0.equals("play") == false) goto L20;
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().k();
    L20:
        return super.onStartCommand(r4, r5, r6);
    L4:
        r0 = null;
        goto L5
    }
}
