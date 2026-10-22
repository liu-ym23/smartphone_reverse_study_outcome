package com.bytedance.android.live.liveinteract.bgComponent.theme;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.bgComponent.theme.api.VoiceLiveThemeApi;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.c70;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.android.livesdkapi.depend.model.live.audio.UploadBackgroundResponse;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveThemeListResponse;
import com.bytedance.android.livesdkapi.model.DefaultVoiceLiveThemeResource;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends com.bytedance.android.live.liveinteract.bgComponent.theme.d implements x00.c {
    public static final j l = null;
    public int b;
    public final be0.c c;
    public km3.g d;
    public final Handler e;
    public Disposable f;
    public WeakReference<ThemeUpLoadListener> g;
    public String[] h;
    public String[] i;
    public final CompositeDisposable j;
    public final f k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ int b;

        public b(j r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            IVoiceLiveTheme r4 = ((UploadBackgroundResponse) ((Response) r3).data).voiceLiveTheme;
            if (r4 == null) goto L6;
            this.a.c(r4, this.b);
            ALogger.d("[VideoTalk]VoiceLiveThemeManager", "addUgcBgTheme.success," + r4);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            ALogger.e("[VideoTalk]VoiceLiveThemeManager", "addUgcBgTheme.failed:" + ((Throwable) r3).getMessage());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ IVoiceLiveTheme b;

        public d(j r1, IVoiceLiveTheme r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            this.a.A(this.b.getBgType());
            if (IVoiceLiveThemeKt.isUgcVideoTheme(this.b) == false) goto L11;
            j r5 = this.a;
            IAnimatedBgInfo r1 = this.b.getAnimatedBgInfo();
            if (r1 == null) goto L9;
            py.k r2 = r1.getAnimatedBg();
            if (r2 == null) goto L9;
            String r6 = r2.getUri();
        L10:
            String r7 = String.valueOf(r6);
            r5.getClass();
            j.z(r7);
        L9:
            r6 = null;
        L11:
            com.bytedance.android.live.liveinteract.bgComponent.theme.h.a(true, null);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            f2.b(2131922877, 0);
            com.bytedance.android.live.liveinteract.bgComponent.theme.h.a(false, (Throwable) r3);
        }
    }

    public static final class f implements com.bytedance.android.live.liveinteract.bgComponent.theme.e.a {
        public final /* synthetic */ j a;

        public static final class a implements Runnable {
            public final /* synthetic */ f a;
            public final /* synthetic */ long b;
            public final /* synthetic */ long c;

            public a(f r1, long r2, long r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }

            public final void a() {
                km3.g r0 = this.a.a.d;
                if (r0 != null) goto L5;
                return;
            L5:
                if (r0 != null) goto L7;
            L15:
                int r1 = (int) ((this.b * ((long) 100)) / (this.c + ((long) 10)));
                km3.g r2 = this.a.a.d;
                Intrinsics.checkNotNull(r2);
                if (r1 <= r2.getProgress()) goto L24;
                km3.g r3 = this.a.a.d;
                if (r3 == null) goto L25;
                r3.setProgress(r1);
                return;
            L25:
                return;
            L24:
                return;
            L7:
                if (r0.isShowing() == true) goto L15;
                km3.g r4 = this.a.a.d;
                if (r4 == null) goto L15;
                if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L22;
                DialogLancet.handleBlockedDialogShow(r4);
                goto L15
            L22:
                DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
            L14:
                DialogLancet.beforeDialogShow(r4);
                r4.show();
                DialogLancet.afterDialogShow(r4);
                goto L15
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public f(j r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.e.a
        public final void onProgress(long r9, long r11) {
            this.a.e.post(new a(this, r9, r11));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function2 d;

        public g(j r1, int r2, long r3, Function2 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r8) {
            Response r9 = (Response) r8;
            VoiceLiveThemeListResponse r0 = (VoiceLiveThemeListResponse) r9.data;
            if (r0 == null) goto L5;
            List r1 = r0.themeList;
        L6:
            List r2 = r1;
            if (r2 != null) goto L9;
        L12:
            boolean r3 = true;
        L14:
            if (r3 == false) goto L16;
            ALogger.e("[VideoTalk]VoiceLiveThemeManager", "theme list is empty");
            int r4 = com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a;
            com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, new Exception("theme list is empty"));
            return;
        L16:
            VoiceLiveThemeListResponse r5 = (VoiceLiveThemeListResponse) r9.data;
            if (r5 == null) goto L19;
            ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.success.bgType:" + this.b + ",roomId:" + this.c + ",preChoice:" + r5.lastThemeKey + ",ugc:" + r5.ugcAvailable + ",imgType:" + String.valueOf(r5.imageType) + ",animType:" + String.valueOf(r5.animatedType) + ",list:" + r5.themeList);
        L19:
            j.t(this.a, (VoiceLiveThemeListResponse) r9.data, this.b);
            Function2 r6 = this.d;
            if (r6 == null) goto L22;
            Unit r10 = (Unit) r6.invoke(((VoiceLiveThemeListResponse) r9.data).themeList, Boolean.TRUE);
        L22:
            com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(true, null);
            return;
        L9:
            if (r2.isEmpty() == true) goto L12;
            r3 = false;
            goto L14
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ Function2 b;

        public h(int r1, Function2 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.failed.bgType:" + this.a);
            Function2 r0 = this.b;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(null, Boolean.FALSE);
        L5:
            com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, r5);
        }
    }

    static {
        l = new j();
    }

    public final String[] i() {
        return (String[]) this.h.clone();
    }

    public final String[] s() {
        return (String[]) this.i.clone();
    }

    public j() {
        this.c = new be0.c();
        this.e = new Handler(Looper.getMainLooper());
        this.h = new String[0];
        this.i = new String[0];
        new HashMap();
        this.j = new CompositeDisposable();
        this.k = new f(this);
    }

    public final void b() {
        String r0 = VideoThemeDownloadManager.c();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0.substring(0, r0.length() - 1));
        if (r1.exists() == true) goto L5;
        return;
    L5:
        if (r1.canWrite() == false) goto L9;
        r1.delete();
        return;
    }

    public final int e() {
        return this.b;
    }

    public static void z(String r2) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        if (r0.exists() == true) goto L5;
    L9:
        PolarisFileWrapper r1 = new PolarisFileWrapper(VideoThemeDownloadManager.d(r2));
        if (r1.exists() == true) goto L12;
        return;
    L12:
        if (r1.canWrite() == false) goto L16;
        r1.delete();
        return;
    L16:
        return;
    L5:
        if (r0.canWrite() == false) goto L9;
        if (r0.delete() == false) goto L9;
    }

    public final void A(int r10) {
        NextLiveData<ArrayList<IVoiceLiveTheme>> r0 = this.c.a(r10).b();
        ArrayList r1 = (ArrayList) r0.getValue();
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return;
    L11:
        Iterator r5 = r1.iterator();
    L12:
        Object r6 = null;
        if (r5.hasNext() == false) goto L22;
        Object r7 = r5.next();
        IVoiceLiveTheme r8 = (IVoiceLiveTheme) r7;
        if (IVoiceLiveThemeKt.isUgcImage(r8) == false) goto L17;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L12;
    L23:
        IVoiceLiveTheme r11 = (IVoiceLiveTheme) r7;
        if (r11 != null) goto L26;
        r11 = w(5);
    L26:
        Iterator r2 = r1.iterator();
    L28:
        if (r2.hasNext() == false) goto L32;
        Object r3 = r2.next();
        if (IVoiceLiveThemeKt.isUgcImage((IVoiceLiveTheme) r3) == false) goto L28;
        r6 = r3;
    L32:
        IVoiceLiveTheme r12 = (IVoiceLiveTheme) r6;
        if (r12 != null) goto L35;
        return;
    L35:
        r1.remove(r12);
        c(r11, r10);
        Room r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r13 == null) goto L38;
        long r14 = r13.getRoomId();
    L40:
        if (r14 == 0) goto L42;
        m(r14, r11, r10);
    L42:
        r0.setValue(r1);
        return;
    L38:
        r14 = 0;
        goto L40
    L17:
        if (IVoiceLiveThemeKt.isAddImage(r8) == true) goto L19;
        r9 = true;
        goto L20
    L22:
        r7 = null;
        goto L23
    L5:
        if (r1.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final IVoiceLiveTheme a(int r2) {
        return (IVoiceLiveTheme) this.c.a(r2).a().getValue();
    }

    public final void h(int r5) {
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r0 == null) goto L5;
        long r1 = r0.getRoomId();
    L6:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestOneKeyBroadcastThemeList.type:" + r5 + ",roomId:" + r1);
        ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).fetchOneKeyVoiceLiveThemeList(r5, r1, 4).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r5, r1), m.a);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.b
    public final void l(int r2) {
        if (VoiceLiveThemeManageDialog.j == false) goto L6;
        g(r2, null);
        return;
    }

    public final boolean n(int r5) {
        Integer r0 = (Integer) this.c.a(r5).c().getValue();
        if (r0 != null) goto L5;
        r0 = 0;
    L5:
        int r1 = r0.intValue();
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        return false;
    L10:
        if (r5 == 3) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean o(int r4) {
        Integer r0 = (Integer) this.c.a(r4).c().getValue();
        if (r0 != null) goto L6;
        r0 = 0;
    L6:
        if (r0.intValue() == 2) goto L8;
        return false;
    L8:
        if (r4 == 3) goto L12;
        return true;
    L12:
        return false;
    }

    public final IVoiceLiveTheme q(int r2) {
        return (IVoiceLiveTheme) this.c.a(r2).getCurrentTheme().getValue();
    }

    public final ArrayList<IVoiceLiveTheme> v(int r2) {
        ArrayList<IVoiceLiveTheme> r3 = (ArrayList) this.c.a(r2).b().getValue();
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new ArrayList();
    }

    public final IVoiceLiveTheme w(int r4) {
        Iterator<T> r5 = v(r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if (Intrinsics.areEqual(((IVoiceLiveTheme) r0).getImageUri(), ((DefaultVoiceLiveThemeResource) c70.a.getValue()).imageUri) == false) goto L4;
    L9:
        IVoiceLiveTheme r1 = (IVoiceLiveTheme) r0;
        if (r1 == null) goto L12;
        return r1;
    L12:
        return com.bytedance.android.livesdk.model.k.a();
    L8:
        r0 = null;
        goto L9
    }

    public final boolean x(File r9) {
        if (r9 != null) goto L5;
    L24:
        return false;
    L5:
        if (r9.exists() == false) goto L24;
        String r1 = r9.getName();
        int r10 = StringsKt.lastIndexOf$default(r9.getName(), ".", 0, false, 6, null) + 1;
        if (r1 == null) goto L23;
        String r11 = r1.substring(r10);
        String[] r2 = this.h;
        if (r2.length != 0) goto L12;
        boolean r3 = true;
    L14:
        if ((!r3) == false) goto L21;
        int r4 = r2.length;
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L28;
        if (Intrinsics.areEqual(r2[r5], r11) == true) goto L19;
        r5 = r5 + 1;
        goto L16
    L19:
        return true;
    L28:
        return false;
    L21:
        return false;
    L12:
        r3 = false;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean y(File r9) {
        if (r9 != null) goto L5;
    L24:
        return false;
    L5:
        if (r9.exists() == false) goto L24;
        String r1 = r9.getName();
        int r10 = StringsKt.lastIndexOf$default(r9.getName(), ".", 0, false, 6, null) + 1;
        if (r1 == null) goto L23;
        String r11 = r1.substring(r10);
        String[] r2 = this.i;
        if (r2.length != 0) goto L12;
        boolean r3 = true;
    L14:
        if ((!r3) == false) goto L21;
        int r4 = r2.length;
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L28;
        if (Intrinsics.areEqual(r2[r5], r11) == true) goto L19;
        r5 = r5 + 1;
        goto L16
    L19:
        return true;
    L28:
        return false;
    L21:
        return false;
    L12:
        r3 = false;
        goto L14
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final void c(IVoiceLiveTheme r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "theme");
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "updateCurrentTheme.bgType:" + r7 + ", theme:" + r6);
        be0.a r8 = this.c.a(r7);
        r8.a().setValue(r8.getCurrentTheme().getValue());
        r8.getCurrentTheme().setValue(r6);
        if (IVoiceLiveThemeKt.isUgcImage(r6) == false) goto L29;
        ArrayList r0 = (ArrayList) r8.b().getValue();
        if (r0 != null) goto L7;
        r0 = new ArrayList();
    L7:
        Iterator r1 = r0.iterator();
    L8:
        String r3 = null;
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        if (IVoiceLiveThemeKt.isUgcImage((IVoiceLiveTheme) r2) == false) goto L8;
    L14:
        IVoiceLiveTheme r4 = (IVoiceLiveTheme) r2;
        if (r4 == null) goto L24;
        int r5 = r0.indexOf(r4);
        if (IVoiceLiveThemeKt.isSourceEqual(r4, r6) == true) goto L30;
        ListProtector.set(r0, r5, r6);
        IAnimatedBgInfo r9 = r4.getAnimatedBgInfo();
        if (r9 == null) goto L23;
        py.k r10 = r9.getAnimatedBg();
        if (r10 == null) goto L23;
        r3 = r10.getUri();
    L23:
        z(String.valueOf(r3));
        r8.b().setValue(r0);
        return;
    L30:
        return;
    L24:
        ListProtector.add(r0, 0, r6);
        r8.b().setValue(r0);
        return;
    L13:
        r2 = null;
        goto L14
    }

    public final void d(long r4, IVoiceLiveTheme r6) {
        Intrinsics.checkNotNullParameter(r6, "theme");
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "deleteTheme.room:" + r4 + ",theme:" + r6);
        if (IVoiceLiveThemeKt.isLocalUgcTheme(r6) == false) goto L7;
        A(r6.getBgType());
        return;
    L7:
        if (r6.getAnimatedBgInfo() == null) goto L12;
        IAnimatedBgInfo r0 = r6.getAnimatedBgInfo();
        Intrinsics.checkNotNull(r0);
        py.k r1 = r0.getAnimatedBg();
        if (r1 == null) goto L11;
        String r2 = r1.getUri();
    L13:
        if (r2 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L21;
        return;
    L21:
        ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).deleteTheme(r4, r2, r6.getBgType()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r6), e.a);
        return;
    L15:
        if (r2.length() == 0) goto L18;
        r3 = false;
        goto L19
    L11:
        r2 = null;
        goto L13
    L12:
        r2 = r6.getImageUri();
        goto L13
    }

    public final void f(Observer<IVoiceLiveTheme> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.c.a(r3).getCurrentTheme().removeObserver(r2);
    }

    public final void g(int r9, Function2<? super List<? extends IVoiceLiveTheme>, ? super Boolean, Unit> r10) {
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r0 == null) goto L5;
        long r1 = r0.getRoomId();
    L6:
        long r5 = r1;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.type:" + r9 + ",roomId:" + r5);
        ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).fetchVoiceLiveThemeList(r9, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r9, r5, r10), new h(r9, r10));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static final void t(j r12, VoiceLiveThemeListResponse r13, int r14) {
        r12.getClass();
        ArrayList<IVoiceLiveTheme> r0 = new ArrayList();
        List r1 = r13.themeList;
        if (r1 == null) goto L5;
        r0.addAll(r1);
    L5:
        be0.a r2 = r12.c.a(r14);
        r2.c().setValue(Integer.valueOf(r13.ugcAvailable));
        String[] r3 = r13.animatedType;
        int r4 = 0;
        if (r3 != null) goto L8;
        r3 = new String[0];
    L8:
        r12.i = r3;
        String[] r5 = r13.imageType;
        if (r5 != null) goto L11;
        r5 = new String[0];
    L11:
        r12.h = r5;
        ae0.a.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "themes");
        Iterator r6 = CollectionsKt.listOf(new ae0.a[]{new ae0.d(), new ae0.c(), new ae0.b()}).iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        r0 = ((ae0.a) r6.next()).a(r0);
        goto L13
    L15:
        if (r0 == null) goto L74;
        Iterator<T> r7 = r0.iterator();
        int r8 = -1;
        int r9 = -1;
        int r10 = -1;
    L18:
        if (r7.hasNext() == false) goto L32;
        Object r11 = r7.next();
        int r15 = r4 + 1;
        if (r4 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        IVoiceLiveTheme r16 = (IVoiceLiveTheme) r11;
        if (IVoiceLiveThemeKt.isConfig(r16) == false) goto L26;
        r8 = r4;
    L31:
        r4 = r15;
        goto L18
    L26:
        if (Intrinsics.areEqual(r16.isPreLoad(), Boolean.TRUE) == false) goto L29;
        r9 = r4;
        goto L31
    L29:
        if (Intrinsics.areEqual(r16.getImageUri(), r13.lastThemeKey) == false) goto L31;
        r10 = r4;
        goto L31
    L32:
        int r17 = r0.size();
        String r18 = null;
        if (r8 < 0) goto L36;
        if (r8 >= r17) goto L36;
        IVoiceLiveTheme r19 = (IVoiceLiveTheme) ListProtector.get(r0, r8);
    L37:
        if (r9 < 0) goto L40;
        if (r9 >= r17) goto L40;
        IVoiceLiveTheme r20 = (IVoiceLiveTheme) ListProtector.get(r0, r9);
    L41:
        if (r10 < 0) goto L44;
        if (r10 >= r17) goto L44;
        IVoiceLiveTheme r110 = (IVoiceLiveTheme) ListProtector.get(r0, r10);
    L45:
        IVoiceLiveTheme r21 = (IVoiceLiveTheme) r2.getCurrentTheme().getValue();
        if (r19 != null) goto L48;
        r19 = r21;
    L48:
        if (r19 == null) goto L51;
        r20 = r19;
    L51:
        if (r20 == null) goto L54;
        r110 = r20;
    L54:
        if (r110 != null) goto L56;
        r110 = r2.d();
    L56:
        if (r21 == null) goto L58;
        String r22 = r21.getImageUri();
    L59:
        if (r110 == null) goto L62;
        r18 = r110.getImageUri();
    L62:
        if ((!Intrinsics.areEqual(r22, r18)) == false) goto L71;
        if (r110 == null) goto L71;
        r2.getCurrentTheme().setValue(r110);
        Room r23 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r23 == null) goto L67;
        long r24 = r23.getRoomId();
    L69:
        if (r24 <= 0) goto L71;
        r12.m(r24, r110, r14);
        goto L71
    L67:
        r24 = 0;
    L71:
        r2.b().setValue(r0);
        return;
    L58:
        r22 = null;
    L44:
        r110 = null;
    L40:
        r20 = null;
    L36:
        r19 = null;
        goto L37
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme> /* = java.util.ArrayList<com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme> */");
    }

    public final void j(LifecycleOwner r2, Observer<IVoiceLiveTheme> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.c.a(r4).getCurrentTheme().observe(r2, r3, true);
    }

    public final void k(int r17, long r18, Function2 r20) {
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r0 == null) goto L5;
        long r1 = r0.getRoomId();
    L6:
        long r5 = r1;
        if (r17 != 100) goto L9;
        int r10 = 1;
    L10:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList ;; realBgType == " + r10 + " ;; bgType == " + r17 + " ;; imageType == 5 ;; roomId == " + r5 + " ;; playMode == " + r18);
        RxUtilKt.c(((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).fetchVoiceLiveThemeList(r10, r5, String.valueOf(5), r18).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(this, r18, r17, r5, r20), new o(r20, r17)), this.j);
        return;
    L9:
        r10 = r17;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public final void m(long r11, IVoiceLiveTheme r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "theme");
        if (r11 > 0) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r13.isPreLoad(), Boolean.TRUE) == true) goto L42;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "selectTheme.room:" + r11 + ",bgType:" + r14 + ",theme:" + r13);
        this.b = r14;
        boolean r1 = true;
        if (r14 != 100) goto L10;
        int r0 = 1;
    L11:
        VoiceLiveThemeApi r2 = (VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class);
        String r3 = r13.getImageUri();
        if (r3 != null) goto L14;
    L17:
        if (r1 == false) goto L38;
        IAnimatedBgInfo r4 = r13.getAnimatedBgInfo();
        if (r4 == null) goto L22;
        String r5 = r4.getFileFormat();
        if (r5 == null) goto L22;
    L23:
        String r6 = r5;
        IAnimatedBgInfo r7 = r13.getAnimatedBgInfo();
        if (r7 == null) goto L27;
        IThemeShowArea r8 = r7.getThemeShowArea();
        if (r8 == null) goto L27;
    L28:
        IAnimatedBgInfo r9 = r13.getAnimatedBgInfo();
        if (r9 == null) goto L36;
        py.k r10 = r9.getAnimatedBg();
        if (r10 == null) goto L36;
        String r12 = r10.getUri();
        if (r12 == null) goto L36;
        String r15 = r12;
    L37:
        Observable<Response<UploadBackgroundResponse>> r16 = r2.addUgcBgTheme(r11, r15, r6, (String) r8, r0, false);
    L39:
        r16.compose(RxUtil.rxSchedulerHelper()).subscribe(new p(r11, r13), new q(this, r13, r14));
        return;
    L36:
        r15 = "";
    L27:
        r8 = "";
    L22:
        r5 = "gif";
        goto L23
    L38:
        r16 = r2.selectTheme(r11, r13.getImageUri(), r13.getImageType(), r0);
        goto L39
    L14:
        if (r3.length() == 0) goto L17;
        r1 = false;
        goto L17
    L10:
        r0 = r14;
        goto L11
    }

    public final void p(LifecycleOwner r2, Observer<ArrayList<IVoiceLiveTheme>> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.c.a(r4).b().observe(r2, r3, true);
    }

    public final void r(FragmentActivity r18, long r19, String r21, IThemeShowArea r22, int r23, ThemeUpLoadListener r24) {
        Intrinsics.checkNotNullParameter(r21, "path");
        PolarisFileWrapper r3 = new PolarisFileWrapper(r21);
        if (r3.exists() == true) goto L9;
        f2.b(2131922878, 0);
        if (r24 == null) goto L38;
        r24.onUploadFailed();
        return;
    L38:
        return;
    L9:
        if (y(r3) == false) goto L17;
        if (FileUtils.getFileSize(r3) <= 20971520) goto L17;
        f2.b(2131916138, 0);
        if (r24 == null) goto L39;
        r24.onUploadFailed();
        return;
    L39:
        return;
    L17:
        if (x(r3) == true) goto L19;
    L24:
        ALogger.d("[VideoTalk]VoiceLiveThemeManager", "uploadFile.bgType" + r23 + ",roomId:" + r19 + ",path" + r21);
        if (r18 == null) goto L32;
        km3.g r1 = new km3.g(r18);
        r1.setMessage(r1.getContext().getResources().getString(2131916135));
        r1.setCancelable(false);
        r1.b();
        if (r1.b == false) goto L31;
        View r8 = r1.d;
        if (r8 == null) goto L31;
        r8.setAlpha(0.5f);
    L31:
        r1.setProgressStyle(0);
        r1.e = new k(this);
        Unit r4 = Unit.INSTANCE;
        this.d = r1;
    L32:
        String r2 = r3.getName();
        int r5 = StringsKt.lastIndexOf$default(r3.getName(), ".", 0, false, 6, null) + 1;
        if (r2 == null) goto L37;
        String r9 = r2.substring(r5);
        com.bytedance.android.live.liveinteract.bgComponent.theme.e r6 = new com.bytedance.android.live.liveinteract.bgComponent.theme.e(this.k, r3);
        TypedOutput r7 = new MultipartTypedOutput();
        r7.addPart("data", r6);
        this.g = new WeakReference(r24);
        this.f = ((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).uploadFile("audio_room_bg", r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new r(this, r21, r3, r22, r23, r19, r9), new s(this, r18));
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        if (FileUtils.getFileSize(r3) <= 20971520) goto L24;
        f2.b(2131916132, 0);
        if (r24 == null) goto L40;
        r24.onUploadFailed();
        return;
    }

    public final void u(long r9, String r11, String r12, IThemeShowArea r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "imageUri");
        Intrinsics.checkNotNullParameter(r12, "fileFormat");
        if (r13 == null) goto L5;
        String r16 = String.valueOf(com.bytedance.android.livesdk.jsbridge.methods.draft.m.a(r13));
    L6:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "addUgcBgTheme.roomId:" + r9 + ",image:" + r11 + ",format:" + r12 + ",bgType:" + r14 + ",isPreLoad:" + r15);
        this.j.add(((VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class)).addUgcBgTheme(r9, r11, r12, r16, r14, r15).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r14), c.a));
        return;
    L5:
        r16 = "";
        goto L6
    }
}
