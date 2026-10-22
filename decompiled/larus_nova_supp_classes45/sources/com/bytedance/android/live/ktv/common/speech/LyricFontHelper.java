package com.bytedance.android.live.ktv.common.speech;

import android.graphics.Typeface;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.config.t70;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.google.gson.reflect.TypeToken;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LyricFontHelper {
    public DownloadTask a;
    public String b;

    public static final class a {
    }

    public static final class b extends AbsDownloadListener {
        public final /* synthetic */ LyricFontHelper a;
        public final /* synthetic */ LyricsDisplayConfig b;

        public final void onSuccessed(DownloadInfo r5) {
            super.onSuccessed(r5);
            StringBuilder r0 = new StringBuilder("font download success ");
            String r1 = null;
            if (r5 == null) goto L5;
            String r2 = r5.getSavePath();
        L6:
            r0.append(r2);
            r0.append(", ");
            if (r5 == null) goto L9;
            String r3 = r5.getName();
        L10:
            r0.append(r3);
            ALogger.i("LinkSpeechServerRecognizer", r0.toString());
            if (r5 == null) goto L13;
            String r4 = r5.getName();
        L14:
            if (r5 == null) goto L16;
            r1 = r5.getSavePath();
        L16:
            if (r4 == null) goto L30;
            if (r1 == null) goto L31;
            String r6 = r1 + File.separator + r4;
            LyricFontHelper r7 = this.a;
            LyricsDisplayConfig r8 = this.b;
            if (TypeFaceOptimizer.getSwitch() == false) goto L27;
            if (r6 == null) goto L27;
            if (TypeFaceLancet.cache.contains(r6) == false) goto L24;
            Typeface r9 = (Typeface) TypeFaceLancet.cache.get(r6);
        L28:
            r7.getClass();
            r8.g(r9);
            return;
        L24:
            Typeface r11 = Typeface.createFromFile(r6);
            if (r11 == null) goto L27;
            TypeFaceLancet.cache.put(r6, r11);
            r9 = r11;
        L27:
            r9 = Typeface.createFromFile(r6);
            goto L28
        L31:
            return;
        L30:
            return;
        L13:
            r4 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public b(LyricFontHelper r1, LyricsDisplayConfig r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailed(DownloadInfo r1, BaseException r2) {
            super.onFailed(r1, r2);
            this.a.b = null;
        }
    }

    public static final class c<T> implements SingleOnSubscribe {
        public final /* synthetic */ LyricFontHelper a;

        public c(LyricFontHelper r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Object> r1) {
            DownloadTask r2 = this.a.a;
            if (r2 == null) goto L6;
            r2.download();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/ktv/common/speech/LyricFontHelper$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/live/ktv/common/model/bean/g;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d extends TypeToken<List<? extends com.bytedance.android.live.ktv.common.model.bean.g>> {
        public d() {
        }
    }

    static {
    }

    public LyricFontHelper() {
    }

    public final void a(String r7, final LyricsDisplayConfig r8) {
        Intrinsics.checkNotNullParameter(r8, "config");
        List r9 = (List) GsonProtectorUtils.fromJson(GsonHelper.get(), r7, new d().getType());
        if (r9 == null) goto L5;
        com.bytedance.android.live.ktv.common.model.bean.g r11 = (com.bytedance.android.live.ktv.common.model.bean.g) CollectionsKt.firstOrNull(r9);
    L6:
        Map r1 = (Map) t70.a.getValue();
        if (r11 == null) goto L9;
        String r2 = r11.a();
    L10:
        if (r1 == null) goto L74;
        if (r1.containsKey(r2) == false) goto L19;
        if (r11 == null) goto L15;
        String r3 = r11.a();
    L16:
        Integer r4 = (Integer) r1.get(r3);
        if (r4 == null) goto L24;
        float r5 = r4.intValue();
        r8.i(UtilityKotlinExtentionsKt.h(r5), UtilityKotlinExtentionsKt.h(r5));
    L24:
        Long r6 = com.bytedance.android.live.liveinteract.utils.a.a;
        if (r11 == null) goto L27;
        String r12 = r11.a();
    L28:
        String r13 = com.bytedance.android.live.liveinteract.utils.a.l;
        com.bytedance.android.live.liveinteract.utils.a.l = r12;
        if (r13 == r12) goto L33;
        Function0 r14 = com.bytedance.android.live.liveinteract.utils.a.p;
        if (r14 == null) goto L33;
        Unit r15 = (Unit) r14.invoke();
    L33:
        if (r11 != null) goto L36;
        r8.g(null);
        this.b = null;
        return;
    L36:
        if (Intrinsics.areEqual(this.b, r11.a()) == false) goto L38;
        return;
    L38:
        this.b = r11.a();
        String r16 = r11.a();
        StringBuilder r17 = new StringBuilder(KtvCommonConfigParams.a());
        String r18 = File.separator;
        r17.append(r18);
        r17.append("lyrics");
        r17.append(r18);
        r17.append("fonts");
        r17.append(r18);
        String r19 = r17.toString();
        PolarisFileWrapper r21 = new PolarisFileWrapper(r19);
        String r22 = r16 + ".ttf";
        PolarisFileWrapper r23 = new PolarisFileWrapper(r21, r22);
        if (r23.exists() == false) goto L53;
        String r24 = r23.getAbsolutePath();
        if (TypeFaceOptimizer.getSwitch() == false) goto L49;
        if (r24 == null) goto L49;
        if (TypeFaceLancet.cache.contains(r24) == false) goto L46;
        Typeface r25 = (Typeface) TypeFaceLancet.cache.get(r24);
    L50:
        r8.g(r25);
        return;
    L46:
        Typeface r0 = Typeface.createFromFile(r24);
        if (r0 == null) goto L49;
        TypeFaceLancet.cache.put(r24, r0);
        r25 = r0;
    L49:
        r25 = Typeface.createFromFile(r24);
        goto L50
    L53:
        if (r21.exists() == true) goto L55;
        r21.mkdirs();
    L55:
        String r26 = r11.c();
        if (r26 != null) goto L58;
    L61:
        boolean r27 = true;
    L62:
        if (r27 == false) goto L65;
        this.b = null;
        r8.g(Typeface.DEFAULT);
        return;
    L65:
        DownloadTask r28 = this.a;
        if (r28 == null) goto L68;
        Downloader.getInstance(s1.getContext()).cancel(r28.getDownloadId());
    L68:
        DownloadTask r29 = Downloader.with(s1.getContext()).url(r11.c()).name(r22).savePath(r19).setCacheLifeTimeMax(1209600).monitorScene("InteractiveSongLyricFont");
        this.a = r29;
        if (r29 == null) goto L71;
        r29.mainThreadListener(new b(this, r8));
    L71:
        Single.create(new c(this)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L58:
        if (r26.length() == 0) goto L61;
        r27 = false;
        goto L62
    L27:
        r12 = null;
        goto L28
    L15:
        r3 = null;
        goto L16
    L19:
        if (r11 == null) goto L23;
        Integer r31 = r11.b();
        if (r31 == null) goto L23;
        float r32 = r31.intValue();
        r8.i(UtilityKotlinExtentionsKt.h(r32), UtilityKotlinExtentionsKt.h(r32));
        Unit r33 = Unit.INSTANCE;
    L23:
        new LyricFontHelper$handleLyricFont$3(r8);
        goto L24
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L9:
        r2 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }
}
