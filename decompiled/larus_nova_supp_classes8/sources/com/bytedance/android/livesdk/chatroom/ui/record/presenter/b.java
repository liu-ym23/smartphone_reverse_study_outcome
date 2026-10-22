package com.bytedance.android.livesdk.chatroom.ui.record.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeQuickRecordWidget;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow;
import com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m60.i;
import o60.e;
import vr1.q;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class b extends AudioProcessorWrapper implements com.bytedance.android.livesdk.chatroom.ui.record.presenter.a, WeakHandler.IHandler {
    public IQuickRecordPopupWindow a;
    public final int[] b;
    public final Lazy c;
    public long d;
    public boolean e;
    public final Context f;
    public final DataCenter g;
    public final View h;
    public final boolean i;
    public final QuickRecordingPresenter.b j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.presenter.b$b, reason: collision with other inner class name */
    public static final class C0027b implements e {
        public final /* synthetic */ b a;
        public final /* synthetic */ long b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.presenter.b$b$a */
        public static final class a implements Runnable {
            public final /* synthetic */ C0027b a;

            public a(C0027b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                C0027b r0 = this.a;     // Catch: Throwable -> L4
                r0.a.d(r0.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onPermissionDenied(String... r3) {
            Intrinsics.checkNotNullParameter(r3, "permissions");
            ALogger.i("QuickRecordBasePresenter", "permission denied " + GsonProtectorUtils.toJson(GsonHelper.get(), r3));
        }

        public final void onPermissionGrant(String... r3) {
            Intrinsics.checkNotNullParameter(r3, "permissions");
            ALogger.i("QuickRecordBasePresenter", "permission granted " + GsonProtectorUtils.toJson(GsonHelper.get(), r3));
            View r4 = this.a.h;
            if (r4 == null) goto L6;
            r4.post(new a(this));
            return;
        }

        public C0027b(b r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ ILiveRecordService.RecordStatus b;

        public c(b r1, ILiveRecordService.RecordStatus r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.r().d(this.b, this.a.g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public abstract void d(long r1);

    public void onActivityResult(int r1, int r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
    }

    public void audioClose() {
        ALogger.i("QuickRecordBasePresenter", "audioClose");
    }

    public final void audioUnbind() {
        ALogger.i("QuickRecordBasePresenter", "audioUnbind");
    }

    public final Context getContext() {
        return this.f;
    }

    public void a(long r3) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        d(r3);
        return;
    L5:
        c(r3, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public final void audioRelease(int r2) {
        ALogger.i("QuickRecordBasePresenter", "audioRelease");
    }

    public void e(ILiveRecordService.RecordStatus r4) {
        Intrinsics.checkNotNullParameter(r4, "status");
        View r0 = this.h;
        if (r0 == null) goto L6;
        r0.post(new c(this, r4));
    L6:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a == true) goto L14;
        if (r4 != ILiveRecordService.RecordStatus.READY) goto L11;
        this.g.put("data_screen_record_is_open", Boolean.TRUE);
        goto L14
    L11:
        if (r4 != ILiveRecordService.RecordStatus.FINISH) goto L14;
        this.g.put("data_screen_record_is_open", Boolean.FALSE);
    L14:
        if (r4 != ILiveRecordService.RecordStatus.READY) goto L16;
    L25:
        u r5 = r.u(this.g, null, 2);
        if (r5 == null) goto L35;
        m<Boolean> r6 = r5.x0();
        if (r6 == null) goto L36;
        r6.setValue(Boolean.TRUE);
        return;
    L36:
        return;
    L35:
        return;
    L16:
        if (r4 == ILiveRecordService.RecordStatus.RECORDING) goto L25;
        if (r4 != ILiveRecordService.RecordStatus.FINISH) goto L31;
        u r7 = r.u(this.g, null, 2);
        if (r7 == null) goto L32;
        m<Boolean> r8 = r7.x0();
        if (r8 == null) goto L33;
        r8.setValue(Boolean.FALSE);
        return;
    L33:
        return;
    L32:
        return;
    }

    public final void f(boolean r3) {
        gr1.a r0 = jr1.c.a();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(this.g);
        if (r1 == null) goto L7;
        r1.setVisibilityStatus(r3);
    L7:
        r.r().setClearScreen(!r3);
    }

    public final void handleMsg(Message r4) {
        Integer r0 = null;
        if (r4 == null) goto L5;
        Object r1 = r4.obj;
    L7:
        if ((r1 instanceof Uri) == true) goto L9;
        r1 = null;
    L9:
        Uri r2 = (Uri) r1;
        if (r4 == null) goto L12;
        r0 = Integer.valueOf(r4.what);
    L12:
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0.intValue() != 499) goto L21;
        if (r2 != null) goto L19;
        f2.b(2131919862, 0);
        return;
    L19:
        this.f.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r2));
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void c(long r4, String... r6) {
        Intrinsics.checkNotNullParameter(r6, "permissions");
        Context r0 = this.f;
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (m60.c.d(r1, (String[]) Arrays.copyOf(r6, r6.length)) == false) goto L10;
        d(r4);
        return;
    L10:
        SettingKey r2 = i.a;
        new i.b(r1).b(new C0027b(this, r4), null, TokenCert.Companion.with("bpea-live_quick_record_request_permission"), (String[]) Arrays.copyOf(r6, r6.length));
    }

    public void audioProcess(ByteBuffer[] r1, int r2, long r3) {
        ALogger.d("QuickRecordBasePresenter", "audioProcess");
    }

    public void audioOpen(int r4, int r5, int r6, int r7) {
        ALogger.i("QuickRecordBasePresenter", "audioOpen samplerate:" + r4 + " channels:" + r5 + " format:" + r7);
        q r0 = r.m();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("samplerate", String.valueOf(r4));
        r1.put("channels", String.valueOf(r5));
        r1.put("duration", String.valueOf(r6));
        r1.put("format", String.valueOf(r7));
        r1.put("solution", r.p().c());
        Unit r8 = Unit.INSTANCE;
        r0.logQuickRecordAudioOpen(r1);
    }

    public b(Context r2, DataCenter r3, View r4, boolean r5, LandscapeQuickRecordWidget r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "anchorView");
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.b = new int[2];
        this.c = LazyKt.lazy(new QuickRecordBasePresenter$handler$2(this));
    }
}
