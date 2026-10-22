package com.bytedance.android.live.liveinteract.bgComponent.theme;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.e0;
import com.bytedance.android.livesdk.y4;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.android.livesdkapi.model.DefaultVoiceLiveThemeResource;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends c implements x00.c {
    public static final a d = null;
    public int b;
    public final be0.c c;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.bgComponent.theme.a$a, reason: collision with other inner class name */
    public static final class C0020a<T> implements SingleOnSubscribe {
        public final /* synthetic */ a a;

        public C0020a(a r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Void> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            this.a.getClass();
            a.t(DefaultVoiceLiveThemeResource.videoTalkRoomDefaultTheme());
            a.t(DefaultVoiceLiveThemeResource.guestBattleDefaultTheme());
        }
    }

    public static final class b {
    }

    public final void d(long r1, IVoiceLiveTheme r3) {
        Intrinsics.checkNotNullParameter(r3, "theme");
    }

    public final void g(int r1, Function2<? super List<? extends IVoiceLiveTheme>, ? super Boolean, Unit> r2) {
    }

    public final void h(int r1) {
    }

    public final String[] i() {
        return new String[0];
    }

    public final void k(int r1, long r2, Function2 r4) {
    }

    public final void m(long r1, IVoiceLiveTheme r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "theme");
    }

    public final boolean n(int r1) {
        return false;
    }

    public final boolean o(int r1) {
        return false;
    }

    public final void p(LifecycleOwner r1, Observer<ArrayList<IVoiceLiveTheme>> r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r2, "observer");
    }

    public final void r(FragmentActivity r1, long r2, String r4, IThemeShowArea r5, int r6, ThemeUpLoadListener r7) {
        Intrinsics.checkNotNullParameter(r4, "path");
    }

    public final String[] s() {
        return new String[0];
    }

    static {
        d = new a();
    }

    public final void b() {
        Iterator r0 = ((LinkedHashMap) this.c.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((be0.a) ((Map.Entry) r0.next()).getValue()).getCurrentTheme().setValue(null);
        goto L4
    L6:
        String r1 = VideoThemeDownloadManager.c();
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1.substring(0, r1.length() - 1));
        if (r2.exists() == true) goto L9;
        return;
    L9:
        if (r2.canWrite() == false) goto L14;
        r2.delete();
        return;
    }

    public a() {
        if (((Boolean) y4.a.getValue()).booleanValue() == false) goto L5;
        Single.create(new C0020a(this)).subscribeOn(Schedulers.newThread()).subscribe();
    L6:
        this.b = 5;
        this.c = new be0.c();
        return;
    L5:
        t(DefaultVoiceLiveThemeResource.videoTalkRoomDefaultTheme());
        t(DefaultVoiceLiveThemeResource.guestBattleDefaultTheme());
        goto L6
    }

    public final int e() {
        return this.b;
    }

    public static void t(IVoiceLiveTheme r1) {
        int r0 = e0.a;
        e0.a(r1.getStaticBackground());
        e0.a(r1.getSingleStaticBackground());
    }

    public final IVoiceLiveTheme a(int r2) {
        return (IVoiceLiveTheme) this.c.a(r2).a().getValue();
    }

    public final IVoiceLiveTheme q(int r2) {
        return (IVoiceLiveTheme) this.c.a(r2).getCurrentTheme().getValue();
    }

    public final void c(IVoiceLiveTheme r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "theme");
        if (r12.getBgType() == r13) goto L5;
        return;
    L5:
        this.b = r13;
        String r2 = null;
        if (IVoiceLiveThemeKt.isUgcVideoTheme(r12) == false) goto L92;
        IAnimatedBgInfo r1 = r12.getAnimatedBgInfo();
        if (r1 == null) goto L14;
        py.k r3 = r1.getAnimatedBg();
        if (r3 == null) goto L14;
        List r4 = r3.getUrls();
        if (r4 == null) goto L14;
        String r5 = (String) ListProtector.get(r4, 0);
    L15:
        IAnimatedBgInfo r6 = r12.getAnimatedBgInfo();
        if (r6 == null) goto L20;
        py.k r7 = r6.getAnimatedBg();
        if (r7 == null) goto L20;
        String r8 = r7.getUri();
    L22:
        if (r5 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == true) goto L41;
        if (r8 != null) goto L31;
    L34:
        boolean r10 = true;
    L35:
        if (r10 == true) goto L41;
        if (VideoThemeDownloadManager.e(r8) == true) goto L41;
        Intrinsics.checkNotNullParameter(r8, "id");
        if (VideoThemeDownloadManager.b.containsKey(r8) == true) goto L41;
        boolean r11 = true;
    L42:
        if (r11 == false) goto L92;
        Lazy r14 = VideoThemeDownloadManager.a;
        Intrinsics.checkNotNullParameter(r12, "theme");
        IAnimatedBgInfo r0 = r12.getAnimatedBgInfo();
        if (r0 == null) goto L48;
        py.k r15 = r0.getAnimatedBg();
        if (r15 == null) goto L48;
        String r16 = r15.getUri();
    L49:
        if (r16 != null) goto L51;
    L54:
        boolean r17 = true;
    L55:
        if (r17 == true) goto L92;
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        IAnimatedBgInfo r19 = r12.getAnimatedBgInfo();
        if (r19 == null) goto L62;
        py.k r20 = r19.getAnimatedBg();
        if (r20 == null) goto L62;
        String r21 = r20.getUri();
    L63:
        Intrinsics.checkNotNull(r21);
        r18.element = r21;
        HashMap<String, VideoThemeDownloadManager.a> r22 = VideoThemeDownloadManager.b;
        if (r22.containsKey(r21) == true) goto L92;
        if (VideoThemeDownloadManager.e((String) r18.element) == true) goto L92;
        Ref.ObjectRef r23 = new Ref.ObjectRef();
        IAnimatedBgInfo r24 = r12.getAnimatedBgInfo();
        if (r24 == null) goto L76;
        py.k r25 = r24.getAnimatedBg();
        if (r25 == null) goto L76;
        List r26 = r25.getUrls();
        if (r26 == null) goto L76;
        String r27 = (String) ListProtector.get(r26, 0);
    L77:
        r23.element = r27;
        if (r27 != null) goto L80;
    L83:
        boolean r28 = true;
    L84:
        if (r28 == true) goto L92;
        String r29 = (String) r18.element;
        r22.put(r29, new VideoThemeDownloadManager.a((String) r23.element, r29, CollectionsKt.arrayListOf(new WeakReference[]{new WeakReference(null)})));
        DownloadTask r30 = Downloader.with(s1.getContext()).url((String) r23.element).name(String.valueOf(((String) r18.element).toString().hashCode())).savePath(VideoThemeDownloadManager.c()).monitorScene("VideoTheme");
        Method r31 = VideoThemeDownloadManager.a().getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L89
        r31.setAccessible(true);     // Catch: Exception -> L89
        r31.invoke(r30, new Object[]{1209600});     // Catch: Exception -> L89
    L91:
        r30.subThreadListener(new f(r23, r18)).download();
    L89:
        e = move-exception;
        ALogger.d("VoiceLiveTheme", "set cache life time max fail : " + e.getMessage());
        goto L91
    L80:
        if (r27.length() == 0) goto L83;
        r28 = false;
    L76:
        r27 = null;
    L62:
        r21 = null;
        goto L63
    L51:
        if (r16.length() == 0) goto L54;
        r17 = false;
    L48:
        r16 = null;
        goto L49
    L31:
        if (r8.length() == 0) goto L34;
        r10 = false;
    L41:
        r11 = false;
        goto L42
    L24:
        if (r5.length() == 0) goto L27;
        r9 = false;
    L20:
        r8 = null;
    L14:
        r5 = null;
    L92:
        IVoiceLiveTheme r32 = q(r13);
        if (r32 == null) goto L99;
        IAnimatedBgInfo r33 = r32.getAnimatedBgInfo();
        if (r33 == null) goto L99;
        py.k r34 = r33.getAnimatedBg();
        if (r34 == null) goto L99;
        r2 = r34.getUri();
    L99:
        if (r2 == null) goto L113;
        PolarisFileWrapper r35 = new PolarisFileWrapper(r2);
        if (r35.exists() == true) goto L104;
    L108:
        PolarisFileWrapper r36 = new PolarisFileWrapper(VideoThemeDownloadManager.d(r2));
        if (r36.exists() == false) goto L113;
        if (r36.canWrite() == false) goto L113;
        r36.delete();
        goto L113
    L104:
        if (r35.canWrite() == false) goto L108;
        if (r35.delete() == false) goto L108;
    L113:
        be0.a r110 = this.c.a(r13);
        r110.a().setValue(r110.getCurrentTheme().getValue());
        t(r12);
        r110.getCurrentTheme().setValue(r12);
    }

    public final void f(Observer<IVoiceLiveTheme> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.c.a(r3).getCurrentTheme().removeObserver(r2);
    }

    public final void j(LifecycleOwner r2, Observer<IVoiceLiveTheme> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.c.a(r4).getCurrentTheme().observe(r2, r3, true);
    }
}
