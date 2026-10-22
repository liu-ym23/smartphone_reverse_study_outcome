package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.digitavatar.AvatarGender;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.c0;
import com.bytedance.android.livesdk.message.model.zf;
import com.bytedance.android.livesdkapi.model.VideoDigitAvatarBgConfig;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public DownloadTask a;
    public final CompositeDisposable b;
    public int c;
    public final boolean d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r4;
            e r6 = this.a;
            r6.getClass();
            int r0 = je0.d.f();
            if (r6.c == r0) goto L26;
            ALogger.i("KtvDigitAvatar", "video talk scene change: " + r6.c + " -> " + r0);
            r6.c = r0;
            if (r6.d == false) goto L27;
            DigitAvatarContext.a r1 = DigitAvatarContext.Companion;
            DigitAvatarContext r2 = r1.getContext();
            if (r2 == null) goto L9;
            VideoShowMode r3 = r2.getCurrentVideoShowMode();
        L11:
            if (r3 != VideoShowMode.DIGIT_AVATAR) goto L28;
            DigitAvatarContext r7 = r1.getContext();
            if (r7 == null) goto L20;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r8 = r7.getDigitAvatar();
            if (r8 == null) goto L20;
            com.bytedance.android.live.liveinteract.digitavatar.n r9 = (com.bytedance.android.live.liveinteract.digitavatar.n) r8.getValue();
            if (r9 == null) goto L20;
            AvatarGender r10 = r9.b;
            if (r10 == null) goto L20;
        L22:
            if (r6.c == 8) goto L24;
            r6.b(r10, true);
            return;
        L24:
            r6.b(r10, false);
            return;
        L20:
            r10 = c0.b();
            goto L22
        L28:
            return;
        L9:
            r3 = null;
            goto L11
        L27:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c {
    }

    static {
    }

    public static String a(String r1) {
        StringBuilder r0 = new StringBuilder();
        String r2 = zf.a(r1.getBytes());     // Catch: Exception -> L5
    L7:
        r0.append(r2);
        r0.append(".png");
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        r2 = null;
        goto L7
    }

    public final void b(AvatarGender r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "gender");
        ALogger.i("KtvDigitAvatar", "loadBgAndSend： " + r6 + ", useSmallBg=" + r7);
        VideoDigitAvatarBgConfig r0 = (VideoDigitAvatarBgConfig) vm2.d.d3.getValue(null, vm2.d.a[209(0xd1, float:2.93E-43)]);
        if (r7 == false) goto L6;
        String r8 = (String) ListProtector.get(r0.getSmallBgList(), Random.Default.nextInt(r0.getSmallBgList().size()));
    L9:
        String r1 = com.bytedance.android.live.liveinteract.digitavatar.l.a;
        File r2 = s1.getContext().getExternalCacheDir();
        String r4 = com.bytedance.android.live.liveinteract.digitavatar.l.c;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2, r4);
        if (r3.exists() == true) goto L13;
        r3.mkdirs();
    L13:
        if (new PolarisFileWrapper(r3, a(r8)).exists() == true) goto L23;
        ALogger.i("KtvDigitAvatar", "download image： " + r8);
        String r9 = a(r8);
        DownloadTask r5 = this.a;
        if (r5 == null) goto L18;
        r5.subThreadListener(null);
    L18:
        DownloadTask r10 = Downloader.with(s1.getContext()).url(r8).name(r9);
        PolarisFileWrapper r11 = new PolarisFileWrapper(s1.getContext().getExternalCacheDir(), r4);
        if (r11.exists() == true) goto L21;
        r11.mkdirs();
    L21:
        DownloadTask r12 = r10.savePath(r11.getAbsolutePath()).monitorScene("live_video_talk_room_digit_avatar").subThreadListener(new f(this));
        r12.download();
        Unit r13 = Unit.INSTANCE;
        this.a = r12;
        return;
    L23:
        return;
    L6:
        if (r6 != AvatarGender.Female) goto L8;
        r8 = r0.getFemaleBg();
        goto L9
    L8:
        r8 = r0.getMaleBg();
        goto L9
    }

    public e(DigitAvatarMsgController r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "effectMsgController");
        this.d = r3;
        CompositeDisposable r5 = new CompositeDisposable();
        this.b = r5;
        this.c = je0.d.f();
        if (r4 == false) goto L14;
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L16;
        BehaviorSubject r8 = r7.a();
        if (r8 == null) goto L17;
        Disposable r9 = r8.subscribe(new a(this), b.a);
        if (r9 == null) goto L18;
        r5.add(r9);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
