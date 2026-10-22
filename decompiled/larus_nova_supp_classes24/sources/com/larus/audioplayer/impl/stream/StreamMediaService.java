package com.larus.audioplayer.impl.stream;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import androidx.media.app.NotificationCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audioplayer.impl.utils.BitmapDownloader;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0004789:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010&\u001a\u00020'*\u00020'2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020\u000fH\u0016J\u001a\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u0012H\u0002J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u000fH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\"\u00103\u001a\u0002042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/audioplayer/impl/stream/StreamMediaService;", "Landroid/app/Service;", "Lcom/larus/audioplayer/impl/stream/IStreamMediaSessionService;", "<init>", "()V", "mBinder", "Lcom/larus/audioplayer/impl/stream/StreamMediaService$StreamMediaServiceBinder;", "mStreamMediaSessionCallback", "Lcom/larus/audioplayer/impl/stream/StreamMediaService$StreamMediaSessionCallback;", "mPlayPendingIntent", "Landroid/app/PendingIntent;", "mPausePendingIntent", "mMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mIsStopped", "", "mIsForeground", "mEmptyAlbumArt", "Landroid/graphics/Bitmap;", "generateActionPendingIntent", "action", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "isStopped", "stopService", "", "activateMediaSession", "deactivateMediaSession", "showMediaNotification", "updateNotification", "getStreamNotification", "Landroid/app/Notification;", "mediaSession", "streamInfo", "Lcom/larus/audioplayer/impl/stream/StreamPlayerInfo;", "addPlayPauseAction", "Landroidx/core/app/NotificationCompat$Builder;", "dismissMediaNotification", "updateMediaMetadata", "doUpdateMediaMetadata", "reason", "useEmptyAlbumArt", "getEmptyAlbumArt", "updatePlaybackState", "doUpdatePlaybackState", "initMediaSession", "releaseMediaSession", "createNotificationChannel", "onStartCommand", "", "flags", "startId", "Companion", "StreamMediaServiceBinder", "MediaSessionManageCallback", "StreamMediaSessionCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class StreamMediaService extends Service implements t {
    public static final /* synthetic */ int i = 0;
    public final c a;
    public final d b;
    public final PendingIntent c;
    public final PendingIntent d;
    public MediaSessionCompat e;
    public boolean f;
    public boolean g;
    public Bitmap h;

    public static final class a {
    }

    public final class b implements pk9.a.a {
        public final /* synthetic */ StreamMediaService a;

        public final void a() {
            FLogger.a.i("StreamMediaService", "MediaSessionManageCallback onDeactivated");
            this.a.b();
            this.a.d();
            this.a.b.onPause();
        }

        public b(StreamMediaService r1) {
            this.a = r1;
        }
    }

    public final class c extends Binder {
        public final /* synthetic */ StreamMediaService a;

        public c(StreamMediaService r1) {
            this.a = r1;
        }
    }

    public final class d extends MediaSessionCompat.Callback {
        public final void onPause() {
            super.onPause();
            c68.b.d("AudioStream:MediaSession", "StreamMediaSessionCallback onPause");
            AudioStreamPlayer r1 = AudioStreamPlayer.a;
            z r2 = AudioStreamPlayer.j;
            if (r2 == null) goto L6;
            c68.b.d("AudioStream:MediaSession", "trigger pause for uuid: " + r2.a);
            r1.s(r2.a, "system_button");
            return;
        }

        public final void onPlay() {
            super.onPlay();
            c68.b.d("AudioStream:MediaSession", "StreamMediaSessionCallback onPlay");
            AudioStreamPlayer r1 = AudioStreamPlayer.a;
            z r2 = AudioStreamPlayer.j;
            if (r2 == null) goto L6;
            c68.b.d("AudioStream:MediaSession", "trigger resume for uuid: " + r2.a);
            r1.u(r2.a, "system_button");
            return;
        }

        public d() {
        }

        public final boolean onMediaButtonEvent(Intent r8) {
            Intrinsics.checkNotNullParameter(r8, "mediaButtonEvent");
            Bundle r0 = r8.getExtras();
            if (r0 != null) goto L7;
            return super.onMediaButtonEvent(r8);
        L7:
            if (Build.VERSION.SDK_INT < 33) goto L9;
            KeyEvent r1 = (KeyEvent) r8.getParcelableExtra("android.intent.extra.KEY_EVENT", KeyEvent.class);
        L10:
            if (r1 != null) goto L14;
            return super.onMediaButtonEvent(r8);
        L14:
            if (r1.getAction() != 0) goto L40;
            int r2 = c68.b.a;
            c68.b.d("AudioStream:MediaSession", "onMediaButtonEvent: keyCode=" + r1.getKeyCode());
            int r3 = r1.getKeyCode();
            if (r3 != 79) goto L18;
        L32:
            AudioStreamPlayer r9 = AudioStreamPlayer.a;
            z r4 = AudioStreamPlayer.j;
            if (r4 != null) goto L35;
        L38:
            return true;
        L35:
            if (r4.e == false) goto L37;
            c68.b.d("AudioStream:MediaSession", "media button event: pause playback");
            r9.s(r4.a, "headphone_button");
            goto L38
        L37:
            c68.b.d("AudioStream:MediaSession", "media button event: resume playback");
            r9.u(r4.a, "headphone_button");
            goto L38
        L18:
            if (r3 == 85) goto L32;
            if (r3 != 126) goto L22;
            AudioStreamPlayer r10 = AudioStreamPlayer.a;
            z r5 = AudioStreamPlayer.j;
            if (r5 == null) goto L31;
            c68.b.d("AudioStream:MediaSession", "media button event: resume playback");
            r10.u(r5.a, "headphone_button");
        L31:
            return true;
        L22:
            if (r3 != 127) goto L40;
            AudioStreamPlayer r11 = AudioStreamPlayer.a;
            z r6 = AudioStreamPlayer.j;
            if (r6 == null) goto L27;
            c68.b.d("AudioStream:MediaSession", "media button event: pause playback");
            r11.s(r6.a, "headphone_button");
        L27:
            return true;
        L40:
            return super.onMediaButtonEvent(r8);
        L9:
            r1 = (KeyEvent) r0.getParcelable("android.intent.extra.KEY_EVENT");
            goto L10
        }
    }

    static {
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public final synchronized void b() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.g == false) goto L15;
        if (Build.VERSION.SDK_INT < 24) goto L11;
        stopForeground(1);     // Catch: Throwable -> L17
    L12:
        this.g = false;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        stopForeground(true);     // Catch: Throwable -> L17
        goto L12
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public final synchronized void d() {
        monitor-enter(this);
        n();     // Catch: Throwable -> L6
        this.h = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public final synchronized boolean f() {
        monitor-enter(this);
        c68.b.d("AudioStream:MediaSession", "updatePlaybackState");     // Catch: Throwable -> L6
        boolean r0 = j();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public final synchronized boolean g() {
        monitor-enter(this);
        c68.b.d("AudioStream:MediaSession", "updateMediaMetadata");     // Catch: Throwable -> L6
        boolean r0 = i("update", false);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void n() {
        monitor-enter(this);
        MediaSessionCompat r0 = this.e;     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        r0.setActive(false);     // Catch: Throwable -> L16
    L6:
        MediaSessionCompat r1 = this.e;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        r1.release();     // Catch: Throwable -> L16
    L9:
        pk9.a r2 = pk9.a.a;     // Catch: Throwable -> L16
        MediaSessionCompat r3 = this.e;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        pk9.a.b.remove(r3);     // Catch: Throwable -> L16
    L13:
        this.e = null;     // Catch: Throwable -> L16
        FLogger.a.i("StreamMediaService", "releaseMediaSession done");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public void stopService() {
        this.f = true;
        b();
        d();
        stopSelf();
    }

    public static void h() {
        c68.b.d("AudioStream:MediaSession", "createNotificationChannel called");
        NotificationManagerCompat r1 = NotificationManagerCompat.from(AppHost.a.getApplication());
        c68.b.d("AudioStream:MediaSession", "got NotificationManagerCompat instance");
        if (Build.VERSION.SDK_INT < 26) goto L9;
        c68.b.d("AudioStream:MediaSession", "Android O or higher, creating notification channel");
        NotificationChannel r2 = new NotificationChannel("stream_channel", GlobalAudioSceneEnum.PODCAST, 2);     // Catch: Exception -> L7
        r2.enableVibration(false);     // Catch: Exception -> L7
        r2.setSound(null, null);     // Catch: Exception -> L7
        c68.b.d("AudioStream:MediaSession", "notification channel created: id=stream_channel, name=podcast");     // Catch: Exception -> L7
        r1.createNotificationChannel(r2);     // Catch: Exception -> L7
        c68.b.d("AudioStream:MediaSession", "notification channel registered with system");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        c68.b.c("AudioStream:MediaSession", "failed to create notification channel", e);
        return;
    L9:
        c68.b.d("AudioStream:MediaSession", "Android version below O, no need to create notification channel");
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public final synchronized boolean c() {
        monitor-enter(this);
        int r1 = c68.b.a;     // Catch: Throwable -> L24
        StringBuilder r2 = new StringBuilder("activateMediaSession: mIsStopped=");     // Catch: Throwable -> L24
        r2.append(this.f);     // Catch: Throwable -> L24
        r2.append(", isActive=");     // Catch: Throwable -> L24
        MediaSessionCompat r0 = this.e;     // Catch: Throwable -> L24
        if (r0 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r0.isActive());     // Catch: Throwable -> L24
    L8:
        r2.append(r3);     // Catch: Throwable -> L24
        c68.b.d("AudioStream:MediaSession", r2.toString());     // Catch: Throwable -> L24
        boolean r4 = false;
        if (this.f == false) goto L13;
        monitor-exit(this);
        return false;
    L13:
        MediaSessionCompat r5 = this.e;     // Catch: Throwable -> L24
        if (r5 != null) goto L16;
    L18:
        if (r4 == false) goto L21;
        monitor-exit(this);
        return true;
    L21:
        boolean r6 = m();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r6;
    L16:
        if (r5.isActive() != true) goto L18;
        r4 = true;
        goto L18
    L7:
        r3 = null;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public final synchronized boolean e() {
        monitor-enter(this);
        int r4 = c68.b.a;     // Catch: Throwable -> L36
        c68.b.d("AudioStream:MediaSession", "showMediaNotification: mIsForeground=" + this.g + ", mIsStopped=" + this.f);     // Catch: Throwable -> L36
        boolean r5 = true;
        if (this.g == false) goto L11;
        monitor-exit(this);
        return true;
    L11:
        if (this.f == false) goto L14;
        monitor-exit(this);
        return false;
    L14:
        MediaSessionCompat r3 = this.e;     // Catch: Throwable -> L36
        if (r3 != null) goto L19;
        c68.b.b("AudioStream:MediaSession", "showMediaNotification: mediaSession is null, return false");     // Catch: Throwable -> L36
        monitor-exit(this);
        return false;
    L19:
        z r6 = AudioStreamPlayer.j;     // Catch: Throwable -> L36
        if (r6 != null) goto L24;
        c68.b.b("AudioStream:MediaSession", "showMediaNotification: streamInfo is null, return false");     // Catch: Throwable -> L36
        monitor-exit(this);
        return false;
    L24:
        c68.b.d("AudioStream:MediaSession", "show notification for: " + r6);     // Catch: Throwable -> L36
        c68.b.d("AudioStream:MediaSession", "creating notification channel");     // Catch: Throwable -> L36
        h();     // Catch: Throwable -> L36
        c68.b.d("AudioStream:MediaSession", "building notification");     // Catch: Throwable -> L36
        Notification r2 = l(r3, r6);     // Catch: Throwable -> L36
        c68.b.d("AudioStream:MediaSession", "calling startForeground");     // Catch: Exception -> L31 Throwable -> L36
        if (Build.VERSION.SDK_INT < 34) goto L28;
        c68.b.d("AudioStream:MediaSession", "startForeground with media playback type");     // Catch: Exception -> L31 Throwable -> L36
        startForeground(103, r2, 2);     // Catch: Exception -> L31 Throwable -> L36
    L29:
        c68.b.d("AudioStream:MediaSession", "startForeground succeeded");     // Catch: Exception -> L31 Throwable -> L36
    L33:
        this.g = r5;     // Catch: Throwable -> L36
        c68.b.d("AudioStream:MediaSession", "showMediaNotification result: " + this.g);     // Catch: Throwable -> L36
        boolean r0 = this.g;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r0;
    L28:
        c68.b.d("AudioStream:MediaSession", "startForeground without service type");     // Catch: Exception -> L31 Throwable -> L36
        startForeground(103, r2);     // Catch: Exception -> L31 Throwable -> L36
    L31:
        e = move-exception;
        int r7 = c68.b.a;     // Catch: Throwable -> L36
        c68.b.c("AudioStream:MediaSession", "startForeground failed: " + e.getClass().getSimpleName() + ", message: " + e.getMessage(), e);     // Catch: Throwable -> L36
        r5 = false;
    L36:
        th = move-exception;
        throw th;
    }

    public final boolean j() {
        int r1 = c68.b.a;
        c68.b.d("AudioStream:MediaSession", "doUpdatePlaybackState: mIsStopped=" + this.f);
        if (this.f == false) goto L5;
        return false;
    L5:
        MediaSessionCompat r2 = this.e;
        if (r2 != null) goto L8;
        return false;
    L8:
        z r4 = AudioStreamPlayer.j;
        if (r4 != null) goto L11;
        return false;
    L11:
        c68.b.d("AudioStream:MediaSession", "update playback state: isPlaying=" + r4.e);
        PlaybackStateCompat.Builder r3 = new PlaybackStateCompat.Builder();
        Bundle r5 = new Bundle();
        r5.putBoolean("HMOS_MEDIA_CONTROLLER_LYRIC", false);
        PlaybackStateCompat.Builder r6 = r3.setExtras(r5).setActions(518);
        if (r4.e == false) goto L14;
        int r7 = 3;
    L22:
        r2.setPlaybackState(r6.setState(r7, -1, 1.0f).build());     // Catch: Exception -> L19
        o();     // Catch: Exception -> L19
        FLogger.a.i("StreamMediaService", "doUpdatePlaybackState done, uuid: " + r4.a + ", title: " + r4.b + ", isPlaying: " + r4.e);
        return true;
    L19:
        e = move-exception;
        FLogger.a.e("StreamMediaService", "mediaSession.setPlaybackState exception", e);
        return false;
    L14:
        r7 = 2;
        goto L22
    }

    public final synchronized boolean m() {
        monitor-enter(this);
        int r1 = c68.b.a;     // Catch: Throwable -> L29
        StringBuilder r2 = new StringBuilder("initMediaSession: mIsStopped=");     // Catch: Throwable -> L29
        r2.append(this.f);     // Catch: Throwable -> L29
        r2.append(", hasStreamInfo=");     // Catch: Throwable -> L29
        if (AudioStreamPlayer.j == null) goto L7;
        boolean r0 = true;
    L8:
        r2.append(r0);     // Catch: Throwable -> L29
        c68.b.d("AudioStream:MediaSession", r2.toString());     // Catch: Throwable -> L29
        if (this.f == false) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (AudioStreamPlayer.j != null) goto L16;
        monitor-exit(this);
        return false;
    L16:
        MediaSessionCompat r3 = new MediaSessionCompat(AppHost.a.getApplication(), "StreamMediaService");     // Catch: Throwable -> L29
        r3.setCallback(this.b);     // Catch: Throwable -> L29
        r3.setFlags(3);     // Catch: Throwable -> L29
        Bundle r4 = new Bundle();     // Catch: Throwable -> L29
        r4.putBoolean("HMOS_MEDIA_CONTROLLER", true);     // Catch: Throwable -> L29
        r3.setExtras(r4);     // Catch: Throwable -> L29
        this.e = r3;     // Catch: Throwable -> L29
        if (g() == true) goto L22;
        this.e = null;     // Catch: Throwable -> L29
        monitor-exit(this);
        return false;
    L22:
        if (f() == true) goto L26;
        this.e = null;     // Catch: Throwable -> L29
        monitor-exit(this);
        return false;
    L26:
        pk9.a r5 = pk9.a.a;     // Catch: Throwable -> L29
        pk9.a.b(r3, new b(this));     // Catch: Throwable -> L29
        r5.a(r3);     // Catch: Throwable -> L29
        FLogger.a.i("StreamMediaService", "initMediaSession done");     // Catch: Throwable -> L29
        monitor-exit(this);
        return true;
    L7:
        r0 = false;
    L29:
        th = move-exception;
        throw th;
    }

    public StreamMediaService() {
        this.a = new c(this);
        this.b = new d();
        this.c = k("play");
        this.d = k("pause");
    }

    public final synchronized void o() {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.g == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        MediaSessionCompat r1 = this.e;     // Catch: Throwable -> L24
        if (r1 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        z r2 = AudioStreamPlayer.j;     // Catch: Throwable -> L24
        if (r2 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) goto L21;
        c68.b.b("AudioStream:MediaSession", "updateNotification: POST_NOTIFICATIONS permission denied, return false");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        NotificationManagerCompat.from(AppHost.a.getApplication()).notify(103, l(r1, r2));     // Catch: Throwable -> L24
        FLogger.a.i("StreamMediaService", "updateNotification done, uuid: " + r2.a + ", title: " + r2.b);     // Catch: Throwable -> L24
        monitor-exit(this);
    }

    @Override // com.larus.audioplayer.impl.stream.t
    public final boolean a() {
        return this.f;
    }

    public static PendingIntent k(String r4) {
        AppHost.Companion r1 = AppHost.a;
        Intent r0 = new Intent(r1.getApplication(), StreamMediaService.class);
        r0.setAction(r4);
        Application r5 = r1.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r2 = 201326592;
    L7:
        return PendingIntent.getService(r5, 101, r0, r2);
    L5:
        r2 = 134217728;
        goto L7
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a;
    }

    public final boolean i(String r9, boolean r10) {
        int r0 = c68.b.a;
        c68.b.d("AudioStream:MediaSession", "doUpdateMediaMetadata: reason=" + r9 + ", mIsStopped=" + this.f + ", useEmptyAlbumArt=" + r10);
        if (this.f == false) goto L5;
        return false;
    L5:
        MediaSessionCompat r11 = this.e;
        if (r11 != null) goto L8;
        return false;
    L8:
        final z r2 = AudioStreamPlayer.j;
        if (r2 != null) goto L11;
        return false;
    L11:
        StringBuilder r3 = new StringBuilder("update metadata for: title=");
        r3.append(r2.b);
        r3.append(", hasCover=");
        if (r2.f == null) goto L14;
        boolean r4 = true;
    L15:
        r3.append(r4);
        c68.b.d("AudioStream:MediaSession", r3.toString());
        MediaMetadataCompat.Builder r5 = new MediaMetadataCompat.Builder().putString("android.media.metadata.TITLE", r2.b).putString("android.media.metadata.ARTIST", r2.c).putString("android.media.metadata.ALBUM_ARTIST", r2.c).putLong("android.media.metadata.DURATION", -1);
        String r6 = r2.d;
        Bitmap r7 = r2.f;
        if (r7 == null) goto L18;
        r5.putBitmap("android.media.metadata.ALBUM_ART", r7);
    L34:
        r11.setMetadata(r5.build());     // Catch: Exception -> L31
        c68.b.d("AudioStream:MediaSession", "updateMediaMetadata done, uuid: " + r2.a + ", title: " + r2.b);
        return true;
    L31:
        e = move-exception;
        FLogger.a.e("StreamMediaService", "mediaSession.setMetadata exception", e);
        return false;
    L18:
        if (r6 == null) goto L23;
        if (r10 == true) goto L23;
        BitmapDownloader.a(r6, new x(r2, this), new y(r2, this));
        return true;
    L23:
        Bitmap r12 = this.h;
        if (r12 != null) goto L27;
        r12 = BitmapFactory.decodeResource(AppHost.a.getApplication().getResources(), 2131241292);
        this.h = r12;
        Intrinsics.checkNotNull(r12);
    L27:
        r5.putBitmap("android.media.metadata.ALBUM_ART", r12);
        goto L34
    L14:
        r4 = false;
        goto L15
    }

    public final Notification l(MediaSessionCompat r9, z r10) {
        int r0 = c68.b.a;
        c68.b.d("AudioStream:MediaSession", "getStreamNotification called for title: " + r10.b);
        NotificationCompat.MediaStyle r11 = new NotificationCompat.MediaStyle().setMediaSession(r9.getSessionToken()).setShowActionsInCompactView(new int[]{0}).setShowCancelButton(false).setCancelButtonIntent(null);
        AppHost.Companion r5 = AppHost.a;
        androidx.core.app.NotificationCompat.Builder r1 = new androidx.core.app.NotificationCompat.Builder(r5.getApplication(), "stream_channel").setShowWhen(false).setSound(null).setContentTitle(r10.b).setContentText(r10.c).setSmallIcon(2131241614).setAutoCancel(false).setOngoing(true);
        if (r10.e == false) goto L5;
        PendingIntent r2 = this.d;
        String r3 = "pause";
        int r4 = 2131241615;
    L6:
        c68.b.d("AudioStream:MediaSession", "addPlayPauseAction: action=".concat(r3));
        androidx.core.app.NotificationCompat.Builder r12 = r1.addAction(r4, r3, r2).setStyle(r11);
        if (r10.f == null) goto L9;
        c68.b.d("AudioStream:MediaSession", "using streamInfo.coverBitmap");
        Bitmap r13 = r10.f;
    L13:
        Notification r14 = r12.setLargeIcon(r13).build();
        c68.b.d("AudioStream:MediaSession", "notification built successfully");
        return r14;
    L9:
        c68.b.d("AudioStream:MediaSession", "using empty album art");
        r13 = this.h;
        if (r13 != null) goto L13;
        r13 = BitmapFactory.decodeResource(r5.getApplication().getResources(), 2131241292);
        this.h = r13;
        Intrinsics.checkNotNull(r13);
        goto L13
    L5:
        r2 = this.c;
        r3 = "play";
        r4 = 2131241616;
        goto L6
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
        this.b.onPause();
        goto L20
    L16:
        if (r0.equals("play") == false) goto L20;
        this.b.onPlay();
    L20:
        return super.onStartCommand(r4, r5, r6);
    L4:
        r0 = null;
        goto L5
    }
}
