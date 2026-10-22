package com.larus.audioplayer.impl.music;

import a88.e;
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
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audioplayer.impl.utils.BitmapDownloader;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import e88.c0;
import e88.d0;
import e88.e0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0004@ABCB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00192\u0006\u0010)\u001a\u00020\u0014H\u0002J\u0018\u0010*\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-H\u0002J\f\u0010.\u001a\u00020/*\u00020/H\u0002J\u0014\u00100\u001a\u00020/*\u00020/2\u0006\u0010,\u001a\u00020-H\u0002J\b\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\u001c\u00103\u001a\u00020\u00162\b\b\u0002\u00104\u001a\u00020\u00162\b\b\u0002\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u0019H\u0002J\b\u00107\u001a\u00020\u0016H\u0016J\u0012\u00108\u001a\u00020\u00162\b\b\u0002\u00104\u001a\u00020\u0016H\u0002J\b\u00109\u001a\u00020\u0016H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\"\u0010<\u001a\u00020=2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/audioplayer/impl/music/MusicPlayService;", "Landroid/app/Service;", "Lcom/larus/audioplayer/impl/music/IMusicMediaSessionService;", "<init>", "()V", "mBinder", "Lcom/larus/audioplayer/impl/music/MusicPlayService$MusicPlayServiceBinder;", "mMusicMediaSessionCallback", "Lcom/larus/audioplayer/impl/music/MusicPlayService$MusicMediaSessionCallback;", "mMainHandler", "Landroid/os/Handler;", "mDelayAutoUpdateTask", "Ljava/lang/Runnable;", "mPlayPendingIntent", "Landroid/app/PendingIntent;", "mPausePendingIntent", "mPreviousPendingIntent", "mNextPendingIntent", "mLikePendingIntent", "mMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mIsStopped", "", "mIsForeground", "mEmptyAlbumArt", "Landroid/graphics/Bitmap;", "generateActionPendingIntent", "action", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "isStopped", "stopService", "", "activateMediaSession", "deactivateMediaSession", "showMediaNotification", "updateNotification", "getAlbumArt", "mediaSession", "getMusicNotification", "Landroid/app/Notification;", GlobalAudioSceneEnum.MUSIC, "Lcom/larus/audioplayer/api/music/MusicData;", "addPlayPauseAction", "Landroidx/core/app/NotificationCompat$Builder;", "addLikeAction", "dismissMediaNotification", "updateMediaMetadata", "doUpdateMediaMetadata", "isAuto", "useEmptyAlbumArt", "getEmptyAlbumArt", "updatePlaybackState", "doUpdatePlaybackState", "initMediaSession", "releaseMediaSession", "createNotificationChannel", "onStartCommand", "", "flags", "startId", "Companion", "MusicPlayServiceBinder", "MediaSessionManageCallback", "MusicMediaSessionCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MusicPlayService extends Service implements e88.a {
    public static final /* synthetic */ int n = 0;
    public final d a;
    public final c b;
    public final Handler c;
    public final c0 d;
    public final PendingIntent e;
    public final PendingIntent f;
    public final PendingIntent g;
    public final PendingIntent h;
    public final PendingIntent i;
    public MediaSessionCompat j;
    public boolean k;
    public boolean l;
    public Bitmap m;

    public static final class a {
    }

    public final class b implements pk9.a.a {
        public final /* synthetic */ MusicPlayService a;

        public final void a() {
            FLogger.a.i("MusicPlayService", "MediaSessionManageCallback onDeactivated");
            this.a.b();
            this.a.d();
            this.a.b.onPause();
        }

        public b(MusicPlayService r1) {
            this.a = r1;
        }
    }

    public final class c extends MediaSessionCompat.Callback {
        public final /* synthetic */ MusicPlayService a;

        public static void b() {
            e r0 = MusicPlayManager.j;
            String r1 = null;
            if (r0 == null) goto L18;
            String r2 = r0.a;
            if (r2 == null) goto L18;
            Intrinsics.checkNotNullParameter(r2, "musicId");
            LinkedList<a88.b> r3 = MusicPlayManager.f;
            monitor-enter(r3);
            Iterator<T> r4 = r3.iterator();     // Catch: Throwable -> L15
        L10:
            if (r4.hasNext() == false) goto L12;
            ((a88.b) r4.next()).e(r2);     // Catch: Throwable -> L15
            goto L10
        L12:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r3);
            FLogger.a.i("MusicPlayManager", "onMediaSessionLikeActionTriggered with musicId: ".concat(r2));
        L19:
            FLogger r6 = FLogger.a;
            StringBuilder r7 = new StringBuilder("MusicMediaSessionCallback handleLikeAction, musicId: ");
            r7.append(r2);
            r7.append(", musicTitle: ");
            if (r0 == null) goto L22;
            r1 = r0.c;
        L22:
            r7.append(r1);
            r6.i("MusicPlayService", r7.toString());
            return;
        L15:
            th = move-exception;
            throw th;
        L18:
            r2 = null;
            goto L19
        }

        public final void onPause() {
            super.onPause();
            MusicPlayManager r0 = MusicPlayManager.a;
            e r1 = MusicPlayManager.j;
            String r2 = null;
            if (r1 == null) goto L7;
            String r3 = r1.a;
            if (r3 == null) goto L7;
            MusicPlayManager.f(r3, 5);
            r0.g(r3);
        L8:
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("MusicMediaSessionCallback onPause, musicId: ");
            r5.append(r3);
            r5.append(", musicTitle: ");
            if (r1 == null) goto L11;
            r2 = r1.c;
        L11:
            r5.append(r2);
            r4.i("MusicPlayService", r5.toString());
            return;
        L7:
            r3 = null;
            goto L8
        }

        public final void onPlay() {
            super.onPlay();
            MusicPlayManager r0 = MusicPlayManager.a;
            e r1 = MusicPlayManager.j;
            String r2 = null;
            if (r1 == null) goto L5;
            MusicPlayManager.f(r1.a, 4);
            MusicPlayManager.i(r1);
        L6:
            FLogger r3 = FLogger.a;
            StringBuilder r4 = new StringBuilder("MusicMediaSessionCallback onPlay, musicId: ");
            if (r1 == null) goto L9;
            String r5 = r1.a;
        L10:
            r4.append(r5);
            r4.append(", musicTitle: ");
            if (r1 == null) goto L13;
            r2 = r1.c;
        L13:
            r4.append(r2);
            r3.i("MusicPlayService", r4.toString());
            return;
        L9:
            r5 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }

        public final void onSkipToNext() {
            super.onSkipToNext();
            MusicPlayManager r0 = MusicPlayManager.a;
            e r1 = MusicPlayManager.j;
            String r2 = null;
            if (r1 == null) goto L9;
            String r3 = r1.a;
            if (r3 == null) goto L9;
            if (MusicPlayManager.d(r3) == false) goto L10;
            MusicPlayManager.j(r3, "system_button");
        L10:
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("MusicMediaSessionCallback onSkipToNext, musicId: ");
            r5.append(r3);
            r5.append(", musicTitle: ");
            if (r1 == null) goto L13;
            r2 = r1.c;
        L13:
            r5.append(r2);
            r4.i("MusicPlayService", r5.toString());
            return;
        L9:
            r3 = null;
            goto L10
        }

        public final void onSkipToPrevious() {
            super.onSkipToPrevious();
            MusicPlayManager r0 = MusicPlayManager.a;
            e r1 = MusicPlayManager.j;
            String r2 = null;
            if (r1 == null) goto L9;
            String r3 = r1.a;
            if (r3 == null) goto L9;
            if (MusicPlayManager.e(r3) == false) goto L10;
            MusicPlayManager.k(r3, "system_button");
        L10:
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("MusicMediaSessionCallback onSkipToPrevious, musicId: ");
            r5.append(r3);
            r5.append(", musicTitle: ");
            if (r1 == null) goto L13;
            r2 = r1.c;
        L13:
            r5.append(r2);
            r4.i("MusicPlayService", r5.toString());
            return;
        L9:
            r3 = null;
            goto L10
        }

        public c(MusicPlayService r1) {
            this.a = r1;
        }

        public final void onSeekTo(long r7) {
            super.onSeekTo(r7);
            MusicPlayManager r0 = MusicPlayManager.a;
            e r1 = MusicPlayManager.j;
            String r2 = null;
            if (r1 == null) goto L25;
            String r3 = r1.a;
            if (r3 == null) goto L25;
            com.larus.audioplayer.impl.music.a r4 = MusicPlayManager.k;
            int r5 = 0;
            if (r4 == null) goto L9;
            int r6 = r4.f.n();
        L10:
            com.larus.audioplayer.impl.music.a r8 = MusicPlayManager.k;
            if (r8 == null) goto L13;
            r5 = r8.f.getCurrentPlaybackTime();
        L13:
            int r9 = (int) r7;
            MusicPlayManager.m(r3, r9, null);
            String r10 = a(r5, r6);
            String r11 = a(r9, r6);
            Intrinsics.checkNotNullParameter(r3, "musicId");
            Intrinsics.checkNotNullParameter(r10, "fromProgress");
            Intrinsics.checkNotNullParameter(r11, "toProgress");
            LinkedList<a88.b> r12 = MusicPlayManager.f;
            monitor-enter(r12);
            Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L22
        L17:
            if (r13.hasNext() == false) goto L19;
            ((a88.b) r13.next()).a(r3, r10, r11);     // Catch: Throwable -> L22
            goto L17
        L19:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r12);
            FLogger.a.i("MusicPlayManager", "onMediaSessionSeekToActionTriggered with musicId: ".concat(r3));
        L26:
            this.a.f();
            FLogger r15 = FLogger.a;
            StringBuilder r16 = new StringBuilder("MusicMediaSessionCallback onSeekTo, pos: ");
            r16.append(LongCompanionObject.INSTANCE);
            r16.append(", musicId: ");
            r16.append(r3);
            r16.append(", musicTitle: ");
            if (r1 == null) goto L29;
            r2 = r1.c;
        L29:
            r16.append(r2);
            r15.i("MusicPlayService", r16.toString());
            return;
        L22:
            th = move-exception;
            throw th;
        L9:
            r6 = 0;
        L25:
            r3 = null;
            goto L26
        }

        public final void onSetRating(RatingCompat r1) {
            super.onSetRating(r1);
            b();
        }

        public static String a(int r5, int r6) {
            if (r5 < 0) goto L9;
            if (r6 < 0) goto L9;
            StringCompanionObject r0 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L7
            return String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf((r5 * 1.0f) / r6)}, 1));
        L7:
            th = move-exception;
            FLogger.a.e("MusicPlayService", "progress format error. pos: " + r5 + ", dur: " + r6, th);
        L9:
            return "0";
        }

        public final void onCustomAction(String r1, Bundle r2) {
            super.onCustomAction(r1, r2);
            if (Intrinsics.areEqual(r1, "like") == false) goto L6;
            b();
            return;
        }
    }

    public final class d extends Binder {
        public final /* synthetic */ MusicPlayService a;

        public d(MusicPlayService r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // e88.a
    public final synchronized void b() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.k == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.l == false) goto L15;
        if (Build.VERSION.SDK_INT < 24) goto L11;
        stopForeground(1);     // Catch: Throwable -> L17
    L12:
        this.l = false;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        stopForeground(true);     // Catch: Throwable -> L17
        goto L12
    }

    @Override // e88.a
    public final synchronized boolean c() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (this.k == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        MediaSessionCompat r0 = this.j;     // Catch: Throwable -> L19
        if (r0 != null) goto L11;
    L13:
        if (r1 == false) goto L16;
        monitor-exit(this);
        return true;
    L16:
        boolean r2 = l();     // Catch: Throwable -> L19
        monitor-exit(this);
        return r2;
    L11:
        if (r0.isActive() != true) goto L13;
        r1 = true;
        goto L13
    }

    @Override // e88.a
    public final synchronized void d() {
        monitor-enter(this);
        this.c.removeCallbacks(this.d);     // Catch: Throwable -> L6
        m();     // Catch: Throwable -> L6
        this.m = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // e88.a
    public final synchronized boolean e() {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = true;
        if (this.l == false) goto L10;
        monitor-exit(this);
        return true;
    L10:
        if (this.k == false) goto L13;
        monitor-exit(this);
        return false;
    L13:
        MediaSessionCompat r0 = this.j;     // Catch: Throwable -> L36
        if (r0 != null) goto L17;
        monitor-exit(this);
        return false;
    L17:
        MusicPlayManager r3 = MusicPlayManager.a;     // Catch: Throwable -> L36
        e r4 = MusicPlayManager.j;     // Catch: Throwable -> L36
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
        Notification r2 = k(r0, r4);     // Catch: Throwable -> L36
        if (r6 < 34) goto L28;
        startForeground(102, r2, 2);     // Catch: Exception -> L31 Throwable -> L36
    L29:
        FLogger.a.i("MusicPlayService", "succeed starting foreground service");     // Catch: Exception -> L31 Throwable -> L36
    L33:
        this.l = r1;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r1;
    L28:
        startForeground(102, r2);     // Catch: Exception -> L31 Throwable -> L36
    L31:
        e = move-exception;
        FLogger.a.e("MusicPlayService", "fail starting foreground service", e);     // Catch: Throwable -> L36
        r1 = false;
        goto L33
    }

    @Override // e88.a
    public final synchronized boolean f() {
        monitor-enter(this);
        boolean r0 = i(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // e88.a
    public final synchronized boolean g() {
        monitor-enter(this);
        boolean r0 = h(false, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean l() {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (this.k == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (MusicPlayManager.j != null) goto L12;
        monitor-exit(this);
        return false;
    L12:
        MediaSessionCompat r0 = new MediaSessionCompat(AppHost.a.getApplication(), "MusicPlayService");     // Catch: Throwable -> L33
        r0.setCallback(this.b);     // Catch: Throwable -> L33
        e r2 = MusicPlayManager.j;     // Catch: Throwable -> L33
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L20;
        r0.setRatingType(2);     // Catch: Throwable -> L33
    L20:
        r0.setFlags(3);     // Catch: Throwable -> L33
        Bundle r4 = new Bundle();     // Catch: Throwable -> L33
        r4.putBoolean("HMOS_MEDIA_CONTROLLER", true);     // Catch: Throwable -> L33
        r0.setExtras(r4);     // Catch: Throwable -> L33
        this.j = r0;     // Catch: Throwable -> L33
        if (g() == true) goto L26;
        this.j = null;     // Catch: Throwable -> L33
        monitor-exit(this);
        return false;
    L26:
        if (f() == true) goto L30;
        this.j = null;     // Catch: Throwable -> L33
        monitor-exit(this);
        return false;
    L30:
        pk9.a r1 = pk9.a.a;     // Catch: Throwable -> L33
        pk9.a.b(r0, new b(this));     // Catch: Throwable -> L33
        r1.a(r0);     // Catch: Throwable -> L33
        FLogger.a.i("MusicPlayService", "initMediaSession done");     // Catch: Throwable -> L33
        monitor-exit(this);
        return true;
    L15:
        if (r2.f != true) goto L17;
        r3 = true;
        goto L18
    }

    public final synchronized void m() {
        monitor-enter(this);
        MediaSessionCompat r0 = this.j;     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        r0.setActive(false);     // Catch: Throwable -> L16
    L6:
        MediaSessionCompat r1 = this.j;     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        r1.release();     // Catch: Throwable -> L16
    L9:
        pk9.a r2 = pk9.a.a;     // Catch: Throwable -> L16
        MediaSessionCompat r3 = this.j;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        pk9.a.b.remove(r3);     // Catch: Throwable -> L16
    L13:
        this.j = null;     // Catch: Throwable -> L16
        FLogger.a.i("MusicPlayService", "releaseMediaSession done");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // e88.a
    public void stopService() {
        this.k = true;
        b();
        d();
        stopSelf();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [e88.c0] */
    public MusicPlayService() {
        this.a = new d(this);
        this.b = new c(this);
        this.c = new Handler(Looper.getMainLooper());
        this.d = new c0(this);
        this.e = j("play");
        this.f = j("pause");
        this.g = j("previous");
        this.h = j("next");
        this.i = j("like");
    }

    public final synchronized void n() {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.l == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        MediaSessionCompat r1 = this.j;     // Catch: Throwable -> L30
        if (r1 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        MusicPlayManager r2 = MusicPlayManager.a;     // Catch: Throwable -> L30
        e r3 = MusicPlayManager.j;     // Catch: Throwable -> L30
        if (r3 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        MediaControllerCompat r4 = r1.getController();     // Catch: Throwable -> L30
        if (r4 == null) goto L21;
        MediaMetadataCompat r5 = r4.getMetadata();     // Catch: Throwable -> L30
        if (r5 == null) goto L21;
        Bitmap r6 = r5.getBitmap("android.media.metadata.ALBUM_ART");     // Catch: Throwable -> L30
    L22:
        if (r6 == null) goto L24;
    L27:
        NotificationManagerCompat.from(AppHost.a.getApplication()).notify(102, k(r1, r3));     // Catch: Throwable -> L30
        FLogger.a.i("MusicPlayService", "updateNotification done, musicId: " + r3.a + ", musicTitle: " + r3.c);     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L24:
        if (r3.i == null) goto L27;
        monitor-exit(this);
        return;
    L21:
        r6 = null;
        goto L22
    }

    @Override // e88.a
    public final boolean a() {
        return this.k;
    }

    public static PendingIntent j(String r4) {
        AppHost.Companion r1 = AppHost.a;
        Intent r0 = new Intent(r1.getApplication(), MusicPlayService.class);
        r0.setAction(r4);
        Application r5 = r1.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r2 = 201326592;
    L7:
        return PendingIntent.getService(r5, 100, r0, r2);
    L5:
        r2 = 134217728;
        goto L7
    }

    public final boolean i(boolean r12) {
        if (this.k == false) goto L5;
        return false;
    L5:
        MediaSessionCompat r1 = this.j;
        if (r1 != null) goto L8;
        return false;
    L8:
        MusicPlayManager r3 = MusicPlayManager.a;
        e r4 = MusicPlayManager.j;
        if (r4 != null) goto L11;
        return false;
    L11:
        int r5 = MusicPlayManager.n;
        if (r4.h == true) goto L14;
    L17:
        long r6 = 790;
    L19:
        if (r4.h == true) goto L21;
    L22:
        r6 = r6 | 32;
    L24:
        if (r4.f == true) goto L27;
        r6 = r6 | 128;
    L27:
        if (r4.g == false) goto L29;
        int r7 = 2131241612;
    L30:
        PlaybackStateCompat.Builder r8 = new PlaybackStateCompat.Builder();
        Bundle r9 = new Bundle();
        r9.putBoolean("HMOS_MEDIA_CONTROLLER_LYRIC", false);
        PlaybackStateCompat.Builder r10 = r8.setExtras(r9).setActions(r6);
        com.larus.audioplayer.impl.music.a r11 = MusicPlayManager.k;
        if (r11 == null) goto L33;
        int r13 = r11.f.getCurrentPlaybackTime();
    L34:
        PlaybackStateCompat.Builder r14 = r10.setState(r5, r13, 1.0f);
        if (r4.f == true) goto L46;
        r14.addCustomAction("like", "like", r7);
    L46:
        r1.setPlaybackState(r14.build());     // Catch: Exception -> L43
        n();     // Catch: Exception -> L43
        if (r12 == true) goto L41;
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, 500);
    L41:
        FLogger.a.i("MusicPlayService", "doUpdatePlaybackState done, musicId: " + r4.a + ", musicTitle: " + r4.c + ", isAuto: " + r12);
        return true;
    L43:
        e = move-exception;
        FLogger.a.e("MusicPlayService", "mediaSession.setPlaybackState exception", e);
        return false;
    L33:
        r13 = 0;
        goto L34
    L29:
        r7 = 2131241611;
        goto L30
    L21:
        if (MusicPlayManager.d(r4.a) == false) goto L24;
    L14:
        if (MusicPlayManager.e(r4.a) == true) goto L17;
        r6 = 774;
        goto L19
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a;
    }

    public final boolean h(final boolean r10, boolean r11) {
        if (this.k == false) goto L5;
        return false;
    L5:
        MediaSessionCompat r1 = this.j;
        if (r1 != null) goto L8;
        return false;
    L8:
        MusicPlayManager r3 = MusicPlayManager.a;
        final e r4 = MusicPlayManager.j;
        if (r4 != null) goto L11;
        return false;
    L11:
        MediaMetadataCompat.Builder r5 = new MediaMetadataCompat.Builder().putString("android.media.metadata.TITLE", r4.c).putString("android.media.metadata.ARTIST", r4.d);
        com.larus.audioplayer.impl.music.a r6 = MusicPlayManager.k;
        if (r6 == null) goto L14;
        int r7 = r6.f.n();
    L15:
        MediaMetadataCompat.Builder r8 = r5.putLong("android.media.metadata.DURATION", r7);
        if (r4.f == true) goto L18;
        r8.putRating("android.media.metadata.RATING", RatingCompat.newHeartRating(r4.g));
    L18:
        Bitmap r9 = r4.e;
        String r12 = r4.i;
        if (r9 == null) goto L21;
        r8.putBitmap("android.media.metadata.ALBUM_ART", r9);
    L37:
        r1.setMetadata(r8.build());     // Catch: Exception -> L34
        FLogger.a.i("MusicPlayService", "updateMediaMetadata done, musicId: " + r4.a + ", musicTitle: " + r4.c + ", isAuto: " + r10);
        return true;
    L34:
        e = move-exception;
        FLogger.a.e("MusicPlayService", "mediaSession.setMetadata exception", e);
        return false;
    L21:
        if (r12 == null) goto L26;
        if (r11 == true) goto L26;
        BitmapDownloader.a(r12, new d0(r4, this, r10), new e0(r4, this, r10));
        return true;
    L26:
        Bitmap r13 = this.m;
        if (r13 != null) goto L30;
        r13 = BitmapFactory.decodeResource(AppHost.a.getApplication().getResources(), 2131241292);
        this.m = r13;
        Intrinsics.checkNotNull(r13);
    L30:
        r8.putBitmap("android.media.metadata.ALBUM_ART", r13);
        goto L37
    L14:
        r7 = 0;
        goto L15
    }

    public final Notification k(MediaSessionCompat r6, e r7) {
        NotificationCompat.MediaStyle r8 = new NotificationCompat.MediaStyle().setMediaSession(r6.getSessionToken()).setShowActionsInCompactView(new int[]{0, 1, 2});
        if (r7.h == false) goto L5;
        r8.setShowActionsInCompactView(new int[]{0});
    L6:
        androidx.core.app.NotificationCompat.Builder r1 = new androidx.core.app.NotificationCompat.Builder(AppHost.a.getApplication(), "music_channel").setShowWhen(false).setSound(null).setContentTitle(r7.c).setContentText(r7.d).setSmallIcon(2131241614).setAutoCancel(false).setOngoing(false);
        if (r7.h == false) goto L10;
        MusicPlayManager r2 = MusicPlayManager.a;
        if (MusicPlayManager.e(r7.a) == true) goto L10;
    L11:
        PendingIntent r3 = this.e;
        if (MusicPlayManager.n != 3) goto L14;
        r3 = this.f;
        String r0 = "pause";
        int r4 = 2131241615;
    L15:
        r1.addAction(r4, r0, r3);
        if (r7.h == false) goto L19;
        MusicPlayManager r5 = MusicPlayManager.a;
        if (MusicPlayManager.d(r7.a) == true) goto L19;
    L21:
        if (r7.f == false) goto L24;
    L28:
        r1.setStyle(r8);
        Bitmap r9 = r7.e;
        if (r9 == null) goto L32;
        r1.setLargeIcon(r9);
    L32:
        return r1.build();
    L24:
        if (r7.g == false) goto L26;
        int r10 = 2131241612;
    L27:
        r1.addAction(r10, "like", this.i);
        goto L28
    L26:
        r10 = 2131241611;
    L19:
        r1.addAction(2131241613, "next", this.h);
        goto L21
    L14:
        r0 = "play";
        r4 = 2131241616;
    L10:
        r1.addAction(2131241634, "previous", this.g);
        goto L11
    L5:
        r8.setShowActionsInCompactView(new int[]{0, 1, 2});
        goto L6
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r3, int r4, int r5) {
        if (r3 == null) goto L4;
        String r0 = r3.getAction();
    L5:
        if (r0 == null) goto L30;
        switch(r0.hashCode()) {
            case -1273775369: goto L26;
            case 3321751: goto L22;
            case 3377907: goto L18;
            case 3443508: goto L14;
            case 106440182: goto L10;
            default: goto L30;
        };
    L10:
        if (r0.equals("pause") == false) goto L30;
        this.b.onPause();
        goto L30
    L14:
        if (r0.equals("play") == false) goto L30;
        this.b.onPlay();
        goto L30
    L18:
        if (r0.equals("next") == false) goto L30;
        this.b.onSkipToNext();
        goto L30
    L22:
        if (r0.equals("like") == false) goto L30;
        this.b.getClass();
        c.b();
        goto L30
    L26:
        if (r0.equals("previous") == false) goto L30;
        this.b.onSkipToPrevious();
    L30:
        return super.onStartCommand(r3, r4, r5);
    L4:
        r0 = null;
        goto L5
    }
}
