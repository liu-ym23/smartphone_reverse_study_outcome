package com.larus.audioplayer.impl.news;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.audioplayer.impl.utils.BitmapDownloader;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.n;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u000489:;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020 H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020+*\u00020+H\u0002J\b\u0010,\u001a\u00020 H\u0016J\b\u0010-\u001a\u00020\u0015H\u0016J\b\u0010.\u001a\u00020\u0015H\u0016J\u0012\u0010/\u001a\u00020\u00152\b\b\u0002\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0002J\"\u00104\u001a\u0002052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000205H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/audioplayer/impl/news/NewsPlayService;", "Landroid/app/Service;", "Lcom/larus/audioplayer/impl/news/INewsMediaSessionService;", "<init>", "()V", "mBinder", "Lcom/larus/audioplayer/impl/news/NewsPlayService$NewsPlayServiceBinder;", "mNewsMediaSessionCallback", "Lcom/larus/audioplayer/impl/news/NewsPlayService$NewsMediaSessionCallback;", "mMainHandler", "Landroid/os/Handler;", "mDelayAutoUpdateTask", "Ljava/lang/Runnable;", "mPlayPendingIntent", "Landroid/app/PendingIntent;", "mPausePendingIntent", "mRewindPendingIntent", "mFastForwardPendingIntent", "mMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mIsStopped", "", "mIsForeground", "generateActionPendingIntent", "action", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "isStopped", "stopService", "", "activateMediaSession", "deactivateMediaSession", "showMediaNotification", "updateNotification", "getNotification", "Landroid/app/Notification;", "mediaSession", "news", "Lcom/larus/audioplayer/api/news/NewsAudioData;", "addPlayPauseAction", "Landroidx/core/app/NotificationCompat$Builder;", "dismissMediaNotification", "updateMediaMetadata", "updatePlaybackState", "doUpdatePlaybackState", "isAuto", "initMediaSession", "releaseMediaSession", "createNotificationChannel", "onStartCommand", "", "flags", "startId", "Companion", "NewsPlayServiceBinder", "MediaSessionManageCallback", "NewsMediaSessionCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class NewsPlayService extends Service implements f88.a {
    public static final /* synthetic */ int l = 0;
    public final d a;
    public final c b;
    public final Handler c;
    public final f88.b d;
    public final PendingIntent e;
    public final PendingIntent f;
    public final PendingIntent g;
    public final PendingIntent h;
    public MediaSessionCompat i;
    public boolean j;
    public boolean k;

    public static final class a {
    }

    public final class b implements pk9.a.a {
        public final /* synthetic */ NewsPlayService a;

        public final void a() {
            this.a.b();
            this.a.d();
            this.a.b.onPause();
            FLogger.a.i("NewsPlayService", "MediaSessionManageCallback onDeactivated");
        }

        public b(NewsPlayService r1) {
            this.a = r1;
        }
    }

    public final class c extends MediaSessionCompat.Callback {
        public final /* synthetic */ NewsPlayService a;

        public static void a() {
            com.larus.audioplayer.impl.news.a r0 = com.larus.audioplayer.impl.news.a.a;
            b88.d r1 = com.larus.audioplayer.impl.news.a.f;
            if (r1 == null) goto L16;
            String r2 = r1.c;
            if (r2 == null) goto L16;
            com.larus.audioplayer.impl.news.b r3 = com.larus.audioplayer.impl.news.a.g;
            int r4 = 0;
            if (r3 == null) goto L9;
            int r5 = r3.m.getCurrentPlaybackTime();
        L10:
            int r6 = r5 + 30000;
            com.larus.audioplayer.impl.news.b r7 = com.larus.audioplayer.impl.news.a.g;
            if (r7 == null) goto L13;
            r4 = r7.m.n();
        L13:
            if (r6 <= r4) goto L15;
            r6 = r4;
        L15:
            com.larus.audioplayer.impl.news.a.h(r2, r6);
        L17:
            FLogger.a.i("NewsPlayService", "NewsMediaSessionCallback handleFastForwardAction, audioUrl: " + r2);
            return;
        L9:
            r5 = 0;
        L16:
            r2 = null;
            goto L17
        }

        public static void b() {
            com.larus.audioplayer.impl.news.a r0 = com.larus.audioplayer.impl.news.a.a;
            b88.d r1 = com.larus.audioplayer.impl.news.a.f;
            if (r1 == null) goto L15;
            String r2 = r1.c;
            if (r2 == null) goto L15;
            com.larus.audioplayer.impl.news.b r3 = com.larus.audioplayer.impl.news.a.g;
            int r4 = 0;
            if (r3 == null) goto L9;
            int r5 = r3.m.getCurrentPlaybackTime();
        L10:
            int r6 = r5 - 15000;
            if (r6 < 0) goto L14;
            r4 = r6;
        L14:
            com.larus.audioplayer.impl.news.a.h(r2, r4);
        L16:
            FLogger.a.i("NewsPlayService", "NewsMediaSessionCallback handleRewindAction, audioUrl: " + r2);
            return;
        L9:
            r5 = 0;
        L15:
            r2 = null;
            goto L16
        }

        public final void onPause() {
            super.onPause();
            b88.d r0 = com.larus.audioplayer.impl.news.a.f;
            if (r0 == null) goto L7;
            String r1 = r0.c;
            if (r1 == null) goto L7;
            com.larus.audioplayer.impl.news.a.a.d(r1, Integer.valueOf(SOURCE_TYPE.URL.getValue()), "");
        L8:
            FLogger.a.i("NewsPlayService", "NewsMediaSessionCallback onPause, audioUrl: " + r1);
            return;
        L7:
            r1 = null;
            goto L8
        }

        public final void onPlay() {
            super.onPlay();
            com.larus.audioplayer.impl.news.a r0 = com.larus.audioplayer.impl.news.a.a;
            b88.d r1 = com.larus.audioplayer.impl.news.a.f;
            String r2 = null;
            if (r1 == null) goto L5;
            r0.e(r1, null);
        L6:
            FLogger r3 = FLogger.a;
            StringBuilder r4 = new StringBuilder("NewsMediaSessionCallback onPlay, audioUrl: ");
            if (r1 == null) goto L9;
            r2 = r1.c;
        L9:
            r4.append(r2);
            r3.i("NewsPlayService", r4.toString());
            return;
        L5:
            r1 = null;
            goto L6
        }

        public c(NewsPlayService r1) {
            this.a = r1;
        }

        public final void onSeekTo(long r3) {
            super.onSeekTo(r3);
            b88.d r0 = com.larus.audioplayer.impl.news.a.f;
            if (r0 == null) goto L7;
            String r1 = r0.c;
            if (r1 == null) goto L7;
            com.larus.audioplayer.impl.news.a.h(r1, (int) r3);
        L8:
            this.a.f();
            FLogger.a.i("NewsPlayService", "NewsMediaSessionCallback onSeekTo, pos: " + LongCompanionObject.INSTANCE + ", audioUrl: " + r1);
            return;
        L7:
            r1 = null;
            goto L8
        }

        public final void onCustomAction(String r1, Bundle r2) {
            super.onCustomAction(r1, r2);
            if (Intrinsics.areEqual(r1, "rewind") == false) goto L6;
            b();
            return;
        L6:
            if (Intrinsics.areEqual(r1, "fast_forward") == false) goto L10;
            a();
            return;
        }
    }

    public final class d extends Binder {
        public final /* synthetic */ NewsPlayService a;

        public d(NewsPlayService r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // f88.a
    public final synchronized void b() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.j == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.k == false) goto L15;
        if (Build.VERSION.SDK_INT < 24) goto L11;
        stopForeground(1);     // Catch: Throwable -> L17
    L12:
        this.k = false;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        stopForeground(true);     // Catch: Throwable -> L17
        goto L12
    }

    @Override // f88.a
    public final synchronized boolean c() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (this.j == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        MediaSessionCompat r0 = this.i;     // Catch: Throwable -> L19
        if (r0 != null) goto L11;
    L13:
        if (r1 == false) goto L16;
        monitor-exit(this);
        return true;
    L16:
        boolean r2 = k();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r2;
    L11:
        if (r0.isActive() != true) goto L13;
        r1 = true;
        goto L13
    }

    @Override // f88.a
    public final synchronized void d() {
        monitor-enter(this);
        this.c.removeCallbacks(this.d);     // Catch: Throwable -> L6
        l();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // f88.a
    public final synchronized boolean e() {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = true;
        if (this.k == false) goto L10;
        monitor-exit(this);
        return true;
    L10:
        if (this.j == false) goto L13;
        monitor-exit(this);
        return false;
    L13:
        MediaSessionCompat r0 = this.i;     // Catch: Throwable -> L36
        if (r0 != null) goto L17;
        monitor-exit(this);
        return false;
    L17:
        com.larus.audioplayer.impl.news.a r3 = com.larus.audioplayer.impl.news.a.a;     // Catch: Throwable -> L36
        b88.d r4 = com.larus.audioplayer.impl.news.a.f;     // Catch: Throwable -> L36
        if (r4 != null) goto L21;
        monitor-exit(this);
        return false;
    L21:
        NotificationManagerCompat r5 = NotificationManagerCompat.from(AppHost.a.getApplication());     // Catch: Throwable -> L36
        int r6 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L36
        if (r6 < 26) goto L24;
        NotificationChannel r7 = new NotificationChannel("music_channel", GlobalAudioSceneEnum.MUSIC, 2);     // Catch: Throwable -> L36
        r7.enableVibration(false);     // Catch: Throwable -> L36
        r7.setSound(null, null);     // Catch: Throwable -> L36
        r5.createNotificationChannel(r7);     // Catch: Throwable -> L36
    L24:
        Notification r2 = j(r0, r4);     // Catch: Throwable -> L36
        if (r6 < 34) goto L28;
        startForeground(103, r2, 2);     // Catch: Exception -> L31 Throwable -> L36
    L29:
        FLogger.a.i("NewsPlayService", "succeed starting foreground service");     // Catch: Exception -> L31 Throwable -> L36
    L33:
        this.k = r1;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r1;
    L28:
        startForeground(103, r2);     // Catch: Exception -> L31 Throwable -> L36
    L31:
        e = move-exception;
        FLogger.a.e("NewsPlayService", "fail starting foreground service", e);     // Catch: Throwable -> L36
        r1 = false;
        goto L33
    }

    @Override // f88.a
    public final synchronized boolean f() {
        monitor-enter(this);
        boolean r0 = h(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean k() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.j == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (com.larus.audioplayer.impl.news.a.f != null) goto L12;
        monitor-exit(this);
        return false;
    L12:
        MediaSessionCompat r0 = new MediaSessionCompat(AppHost.a.getApplication(), "NewsPlayService");     // Catch: Throwable -> L25
        r0.setCallback(this.b);     // Catch: Throwable -> L25
        r0.setFlags(3);     // Catch: Throwable -> L25
        Bundle r2 = new Bundle();     // Catch: Throwable -> L25
        r2.putBoolean("HMOS_MEDIA_CONTROLLER", true);     // Catch: Throwable -> L25
        r0.setExtras(r2);     // Catch: Throwable -> L25
        this.i = r0;     // Catch: Throwable -> L25
        if (g() == true) goto L18;
        this.i = null;     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L18:
        if (f() == true) goto L22;
        this.i = null;     // Catch: Throwable -> L25
        monitor-exit(this);
        return false;
    L22:
        pk9.a r1 = pk9.a.a;     // Catch: Throwable -> L25
        pk9.a.b(r0, new b(this));     // Catch: Throwable -> L25
        r1.a(r0);     // Catch: Throwable -> L25
        FLogger.a.i("NewsPlayService", "initMediaSession done");     // Catch: Throwable -> L25
        monitor-exit(this);
        return true;
    }

    public final synchronized void l() {
        monitor-enter(this);
        MediaSessionCompat r0 = this.i;     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        r0.setActive(false);     // Catch: Throwable -> L16
    L6:
        MediaSessionCompat r1 = this.i;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        r1.release();     // Catch: Throwable -> L16
    L9:
        pk9.a r2 = pk9.a.a;     // Catch: Throwable -> L16
        MediaSessionCompat r3 = this.i;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        pk9.a.b.remove(r3);     // Catch: Throwable -> L16
    L13:
        this.i = null;     // Catch: Throwable -> L16
        FLogger.a.i("NewsPlayService", "releaseMediaSession done");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // f88.a
    public void stopService() {
        this.j = true;
        stopSelf();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [f88.b] */
    public NewsPlayService() {
        this.a = new d(this);
        this.b = new c(this);
        this.c = new Handler(Looper.getMainLooper());
        this.d = new f88.b(this);
        this.e = i("play");
        this.f = i("pause");
        this.g = i("rewind");
        this.h = i("fast_forward");
    }

    @Override // f88.a
    public final synchronized boolean g() {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L6:
        if (this.j == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        MediaSessionCompat r1 = this.i;     // Catch: Throwable -> L37
        if (r1 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        com.larus.audioplayer.impl.news.a r3 = com.larus.audioplayer.impl.news.a.a;     // Catch: Throwable -> L37
        final b88.d r4 = com.larus.audioplayer.impl.news.a.f;     // Catch: Throwable -> L37
        if (r4 != null) goto L17;
        monitor-exit(this);
        return false;
    L17:
        MediaMetadataCompat.Builder r5 = new MediaMetadataCompat.Builder().putString("android.media.metadata.TITLE", r4.e).putString("android.media.metadata.ARTIST", r4.f);     // Catch: Throwable -> L37
        com.larus.audioplayer.impl.news.b r6 = com.larus.audioplayer.impl.news.a.g;     // Catch: Throwable -> L37
        if (r6 == null) goto L20;
        int r7 = r6.m.n();     // Catch: Throwable -> L37
    L21:
        MediaMetadataCompat.Builder r8 = r5.putLong("android.media.metadata.DURATION", r7);     // Catch: Throwable -> L37
        Bitmap r9 = r4.g;     // Catch: Throwable -> L37
        if (r9 == null) goto L24;
        r8.putBitmap("android.media.metadata.ALBUM_ART", r9);     // Catch: Throwable -> L37
    L40:
        r1.setMetadata(r8.build());     // Catch: Exception -> L33 Throwable -> L37
        FLogger.a.i("NewsPlayService", "updateMediaMetadata done, audioUrl: " + r4.c);     // Catch: Throwable -> L37
        monitor-exit(this);
        return true;
    L33:
        e = move-exception;
        FLogger.a.e("NewsPlayService", "mediaSession.setMetadata exception", e);     // Catch: Throwable -> L37
        return false;
    L24:
        String r10 = r4.h;     // Catch: Throwable -> L37
        if (r10 == null) goto L40;
        BitmapDownloader.a(r10, new f88.c(r4, this), new f88.d(r4));     // Catch: Throwable -> L37
        monitor-exit(this);
        return true;
    L20:
        r7 = 0;
        goto L21
    }

    public final synchronized void m() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.k == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        MediaSessionCompat r1 = this.i;     // Catch: Throwable -> L25
        if (r1 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        com.larus.audioplayer.impl.news.a r2 = com.larus.audioplayer.impl.news.a.a;     // Catch: Throwable -> L25
        b88.d r3 = com.larus.audioplayer.impl.news.a.f;     // Catch: Throwable -> L25
        if (r3 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        if (r3.g == null) goto L19;
    L22:
        NotificationManagerCompat.from(AppHost.a.getApplication()).notify(103, j(r1, r3));     // Catch: Throwable -> L25
        FLogger.a.i("NewsPlayService", "updateNotification done, audioUrl: " + r3.c);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L19:
        if (r3.h == null) goto L22;
        monitor-exit(this);
    }

    @Override // f88.a
    public final boolean a() {
        return this.j;
    }

    public static PendingIntent i(String r4) {
        AppHost.Companion r1 = AppHost.a;
        Intent r0 = new Intent(r1.getApplication(), NewsPlayService.class);
        r0.setAction(r4);
        Application r5 = r1.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r2 = 201326592;
    L7:
        return PendingIntent.getService(r5, 103, r0, r2);
    L5:
        r2 = 134217728;
        goto L7
    }

    public final boolean h(boolean r8) {
        if (this.j == false) goto L5;
        return false;
    L5:
        MediaSessionCompat r0 = this.i;
        if (r0 != null) goto L8;
        return false;
    L8:
        com.larus.audioplayer.impl.news.a r2 = com.larus.audioplayer.impl.news.a.a;
        if (com.larus.audioplayer.impl.news.a.f != null) goto L11;
        return false;
    L11:
        int r3 = com.larus.audioplayer.impl.news.a.i;
        com.larus.audioplayer.impl.news.b r4 = com.larus.audioplayer.impl.news.a.g;
        if (r4 == null) goto L16;
        n r5 = r4.m.a();
        if (r5 == null) goto L16;
        float r6 = r5.a;
    L18:
        if (com.larus.audioplayer.impl.news.a.n == false) goto L20;
        r6 = 0.0f;
    L20:
        PlaybackStateCompat.Builder r7 = new PlaybackStateCompat.Builder();
        Bundle r9 = new Bundle();
        r9.putBoolean("HMOS_MEDIA_CONTROLLER_LYRIC", false);
        PlaybackStateCompat.Builder r10 = r7.setExtras(r9).setActions(774).addCustomAction("rewind", "rewind", 2131240878);
        com.larus.audioplayer.impl.news.b r11 = com.larus.audioplayer.impl.news.a.g;
        if (r11 == null) goto L23;
        int r12 = r11.m.getCurrentPlaybackTime();
    L33:
        r0.setPlaybackState(r10.setState(r3, r12, r6).addCustomAction("fast_forward", "fast_forward", 2131240877).build());     // Catch: Exception -> L30
        m();     // Catch: Exception -> L30
        if (r8 == true) goto L35;
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, 500);
        return true;
    L35:
        return true;
    L30:
        e = move-exception;
        FLogger.a.e("NewsPlayService", "mediaSession.setPlaybackState exception", e);
        return false;
    L23:
        r12 = 0;
    L16:
        r6 = 1.0f;
        goto L18
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a;
    }

    public final Notification j(MediaSessionCompat r6, b88.d r7) {
        NotificationCompat.MediaStyle r8 = new NotificationCompat.MediaStyle().setMediaSession(r6.getSessionToken()).setShowActionsInCompactView(new int[]{0, 1, 2});
        androidx.core.app.NotificationCompat.Builder r1 = new androidx.core.app.NotificationCompat.Builder(AppHost.a.getApplication(), "music_channel").setShowWhen(false).setSound(null).setContentTitle(r7.e).setContentText(r7.f).setSmallIcon(2131241614).setAutoCancel(false).setOngoing(false).addAction(2131240878, "rewind", this.g);
        PendingIntent r2 = this.e;
        if (com.larus.audioplayer.impl.news.a.i != 3) goto L5;
        r2 = this.f;
        String r0 = "pause";
        int r3 = 2131241615;
    L6:
        androidx.core.app.NotificationCompat.Builder r9 = r1.addAction(r3, r0, r2).addAction(2131240877, "fast_forward", this.h).setStyle(r8);
        Bitmap r10 = r7.g;
        if (r10 == null) goto L10;
        r9.setLargeIcon(r10);
    L10:
        return r9.build();
    L5:
        r0 = "play";
        r3 = 2131241616;
        goto L6
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r3, int r4, int r5) {
        if (r3 == null) goto L4;
        String r0 = r3.getAction();
    L5:
        if (r0 == null) goto L26;
        switch(r0.hashCode()) {
            case -934318917: goto L22;
            case -878512670: goto L18;
            case 3443508: goto L14;
            case 106440182: goto L10;
            default: goto L26;
        };
    L10:
        if (r0.equals("pause") == false) goto L26;
        this.b.onPause();
        goto L26
    L14:
        if (r0.equals("play") == false) goto L26;
        this.b.onPlay();
        goto L26
    L18:
        if (r0.equals("fast_forward") == false) goto L26;
        this.b.getClass();
        c.a();
        goto L26
    L22:
        if (r0.equals("rewind") == false) goto L26;
        this.b.getClass();
        c.b();
    L26:
        return super.onStartCommand(r3, r4, r5);
    L4:
        r0 = null;
        goto L5
    }
}
