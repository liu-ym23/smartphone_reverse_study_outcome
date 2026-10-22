package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void a(String r1, Sticker r2);

        void b(String r1, ExceptionResult r2);
    }

    public interface b {
        void onFail(ExceptionResult r1);

        void onSuccess(List<Sticker> r1);
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.effectgame.base.c$c, reason: collision with other inner class name */
    public static final class C0055c implements k.g {
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Sticker c;
        public final /* synthetic */ SafeThreadEffectFetchCallBackDelegate d;
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.effectgame.base.a e;
        public final /* synthetic */ Sticker f;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r4, Sticker r5) {
            StringBuilder r0 = new StringBuilder("[");
            r0.append(this.a);
            r0.append("]download success panel: ");
            r0.append(r4);
            r0.append(" sticker: ");
            if (r5 == null) goto L5;
            String r6 = r5.getName();
        L6:
            r0.append(r6);
            ALogger.i("EffectResourceLoadUtils", r0.toString());
            if (r5 == null) goto L13;
            Sticker r7 = this.c;
            int r1 = c.a;
            Intrinsics.checkNotNullParameter(r5, "sticker");
            List<String> r2 = LiveEffectContext.h;
            r7.setDownloaded(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().q(r5));
            SafeThreadEffectFetchCallBackDelegate r8 = this.d;
            if (r8 == null) goto L11;
            r8.a(1, false, this.b, this.c);
        L11:
            c.c(this.c, this.d);
            return;
        L13:
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r3, Sticker r4) {
            StringBuilder r5 = new StringBuilder("[");
            r5.append(this.a);
            r5.append("]download start sticker: ");
            if (r4 == null) goto L5;
            String r6 = r4.getName();
        L6:
            r5.append(r6);
            ALogger.i("EffectResourceLoadUtils", r5.toString());
            if (this.b != 1) goto L14;
            Sticker r7 = this.c;
            if (r7 == null) goto L15;
            SafeThreadEffectFetchCallBackDelegate r0 = this.d;
            if (r0 == null) goto L16;
            r0.c(1, r7);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.effect.api.k.g
        public final void onProgress(int r7, long r8) {
            SafeThreadEffectFetchCallBackDelegate r0 = this.d;
            if (r0 == null) goto L6;
            r0.b(1, r7, r8, this.f);
            return;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r4, Sticker r5, ExceptionResult r6) {
            StringBuilder r0 = new StringBuilder("[");
            r0.append(this.a);
            r0.append("]download fail panel[");
            r0.append(this.b);
            r0.append("]: ");
            r0.append(r4);
            r0.append(" sticker: ");
            if (r5 == null) goto L5;
            String r7 = r5.getName();
        L6:
            r0.append(r7);
            ALogger.e("EffectResourceLoadUtils", r0.toString());
            int r8 = this.b;
            if (r8 < 3) goto L11;
            SafeThreadEffectFetchCallBackDelegate r9 = this.d;
            if (r9 == null) goto L13;
            r9.d(1, this.c, r6);
            return;
        L13:
            return;
        L11:
            int r11 = c.a;
            c.b(this.c, r8 + 1, this.e);
            return;
        L5:
            r7 = null;
            goto L6
        }

        public C0055c(long r1, int r3, Sticker r4, SafeThreadEffectFetchCallBackDelegate r5, com.bytedance.android.live.broadcastgame.effectgame.base.a r6, Sticker r7) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class d extends AbsDownloadListener {
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.effectgame.base.a a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public final void onProgress(DownloadInfo r8) {
            super.onProgress(r8);
            if (r8 == null) goto L8;
            int r3 = (int) ((r8.getCurBytes() / r8.getTotalBytes()) * 100);
            com.bytedance.android.live.broadcastgame.effectgame.base.a r1 = this.a;
            if (r1 == null) goto L9;
            r1.b(2, r3, r8.getTotalBytes(), this.b);
            return;
        L9:
            return;
        }

        public final void onStart(DownloadInfo r3) {
            super.onStart(r3);
            com.bytedance.android.live.broadcastgame.effectgame.base.a r4 = this.a;
            if (r4 == null) goto L6;
            r4.c(2, this.b);
            return;
        }

        public final void onSuccessed(DownloadInfo r5) {
            super.onSuccessed(r5);
            if (r5 == null) goto L15;
            String r6 = r5.getTargetFilePath();
            if (r6 == null) goto L15;
            if (StringsKt.isBlank(r6) == false) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L15;
            FileUtils.unZipFolder(r6, this.c + "_zip");     // Catch: Exception -> L13
            new PolarisFileWrapper(r6).delete();     // Catch: Exception -> L13
            new PolarisFileWrapper(this.c + "_zip").renameTo(new PolarisFileWrapper(this.c));     // Catch: Exception -> L13
        L13:
            e = move-exception;
            ALogger.e("EffectResourceLoadUtils unZipFolder", e);
            goto L15
        L9:
            r2 = false;
        L15:
            com.bytedance.android.live.broadcastgame.effectgame.base.a r7 = this.a;
            if (r7 == null) goto L21;
            r7.a(2, false, this.d, this.b);
            return;
        }

        public final void onFailed(DownloadInfo r7, BaseException r8) {
            super.onFailed(r7, r8);
            int r0 = this.d;
            if (r0 < 3) goto L7;
            ExceptionResult r1 = new ExceptionResult(-1, r8);
            com.bytedance.android.live.broadcastgame.effectgame.base.a r2 = this.a;
            if (r2 == null) goto L8;
            r2.d(2, this.b, r1);
        L8:
            if (r7 == null) goto L14;
            String r3 = r7.getTargetFilePath();
            if (r3 == null) goto L14;
            if (StringsKt.isBlank(r3) != true) goto L14;
            new PolarisFileWrapper(r7.getTargetFilePath()).delete();
        L14:
            ALogger.e("EffectResourceLoadUtils", "count: " + this.d + ' ' + r8);
            return;
        L7:
            int r4 = c.a;
            c.e(this.b, this.c, this.e, r0 + 1, this.a);
            goto L8
        }

        public d(com.bytedance.android.live.broadcastgame.effectgame.base.a r1, Sticker r2, String r3, int r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    public static String d(String r6) {
        int r0 = StringsKt.lastIndexOf$default(r6, ".", 0, false, 6, null);
        if (r0 == (-1)) goto L10;
        if (r6 == null) goto L9;
        return r6.substring(0, r0);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L10:
        return r6;
    }

    public static void a(Sticker r6, r r7) {
        Intrinsics.checkNotNullParameter(r6, "sticker");
        Intrinsics.checkNotNullParameter(r7, "gameExtra");
        Intrinsics.checkNotNullParameter(r6, "sticker");
        List<String> r0 = LiveEffectContext.h;
        r6.setDownloaded(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().q(r6));
        Unit r1 = Unit.INSTANCE;
        r7.a = r6;
        Sticker.EffectGameInfo r2 = r6.getGameInfo();
        r2.setGuide_show_count(r7.t());
        r2.setLoadgame_when_guide(r7.v());
        r2.setNeed_beat(r7.y());
        r2.setNeed_bgmusic(r7.z());
        r2.setSupport_mode(r7.J());
        r2.setSupport_effect_mix_stream(r7.I());
        String r3 = r6.getGameInfo().getGuide_url();
        boolean r4 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
        r6.getGameInfo().setGuide_res_path(r6.getUnzipPath() + File.separator + d(r6.getGameInfo().getGuide_name()));
    L11:
        List<String> r8 = r7.L();
        if (r8 != null) goto L14;
    L17:
        boolean r9 = true;
    L18:
        if (r9 == true) goto L32;
        String r11 = r7.s();
        if (r11 != null) goto L22;
    L25:
        if (r4 == true) goto L33;
        String r12 = r7.s();
        Intrinsics.checkNotNull(r12);
        r2.setGuide_name(r12);
        List<String> r13 = r7.L();
        if (r13 == null) goto L29;
        String r14 = (String) ListProtector.get(r13, 0);
    L30:
        r2.setGuide_url(Intrinsics.stringPlus(r14, r2.getGuide_name()));
        return;
    L29:
        r14 = null;
        goto L30
    L33:
        return;
    L22:
        if (StringsKt.isBlank(r11) == true) goto L25;
        r4 = false;
        goto L25
    L32:
        return;
    L14:
        if (r8.isEmpty() == true) goto L17;
        r9 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r5 = false;
        goto L9
    }

    public static void c(Sticker r5, SafeThreadEffectFetchCallBackDelegate r6) {
        String r0 = r5.getGameInfo().getGuide_url();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L16;
        String r2 = r5.getGameInfo().getGuide_name();
        String r3 = r5.getUnzipPath() + File.separator + d(r2);
        r5.getGameInfo().setGuide_res_path(r3);
        if (new PolarisFileWrapper(r3).exists() == true) goto L14;
        e(r5, r3, r2, 1, r6);
        return;
    L14:
        if (r6 == null) goto L20;
        r6.a(2, true, 1, r5);
        return;
    L20:
        return;
    L16:
        if (r6 == null) goto L22;
        r6.a(2, true, 1, r5);
        return;
    L22:
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public static void b(Sticker r11, int r12, com.bytedance.android.live.broadcastgame.effectgame.base.a r13) {
        Intrinsics.checkNotNullParameter(r11, "sticker");
        List<String> r0 = LiveEffectContext.h;
        k r1 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r13 == null) goto L7;
        SafeThreadEffectFetchCallBackDelegate r2 = new SafeThreadEffectFetchCallBackDelegate(r13);
    L8:
        SafeThreadEffectFetchCallBackDelegate r7 = r2;
        r11.setDownloaded(r1.q(r11));
        if (r11.isDownloaded() == true) goto L11;
        r1.g("livegame", r11, new C0055c(h.a.incrementAndGet(), r12, r11, r7, r13, r11));
        return;
    L11:
        if (r7 == null) goto L13;
        r7.a(1, true, 1, r11);
    L13:
        c(r11, r7);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static void e(Sticker r8, String r9, String r11, int r12, com.bytedance.android.live.broadcastgame.effectgame.base.a r13) {
        Downloader.with(s1.getContext()).url(r8.getGameInfo().getGuide_url()).name(r11).savePath(r9 + "_zip").monitorScene("live_revenue_effect_play_resource").subThreadListener(new d(r13, r8, r9, r12, r11)).download();
    }
}
