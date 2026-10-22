package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.TTCNPAHelperKt;
import com.larus.bmhome.music.databinding.LarusLayoutMusicShareDynamicBinding;
import com.larus.bmhome.music.protocol.BigMusicVideoInfo;
import com.larus.bmhome.music.save_video.software_decoder.BitmapToVideoEncoder;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.LyricsUtterances;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.t0;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kr8.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MusicVideoSaver {
    public static final MusicVideoSaver a = null;
    public static final StateFlowImpl b = null;
    public static final int c = 0;
    public static long d;
    public static long e;
    public static long f;
    public static String g;
    public static volatile int h;
    public static volatile int i;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final /* synthetic */ String a;
        public final /* synthetic */ MusicCreationContent b;
        public final /* synthetic */ Function2 c;
        public final /* synthetic */ LyricsSeekContent d;

        public final void handleException(CoroutineContext r9, Throwable r10) {
            FLogger.a.e("Music Edit Error", "sql execute err! msg=" + r10 + " with downloadTaskKey " + this.a);
            kr8.l.a.b(new y(TriggerSendLoading.NO_LOADING, "error code " + r10.getCause() + ", msg " + r10.getMessage(), this.b.getVid(), null, 17), null, 3);
            String r1 = "";
            this.c.invoke(-1, "");
            MusicVideoSaver r11 = MusicVideoSaver.a;
            String r12 = this.b.getVid();
            if (r12 == null) goto L6;
            r1 = r12;
        L6:
            MusicVideoSaver.i(r1);
            com.larus.platform.service.g.a.ensureNotReachHere(r10, "music save video failed, lyricsSeekContent: " + this.d);
        }

        public a(CoroutineExceptionHandler.Key r1, String r2, MusicCreationContent r3, Function2 r4, LyricsSeekContent r5) {
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r1);
        }
    }

    public MusicVideoSaver() {
    }

    static {
        a = new MusicVideoSaver();
        b = j1.a(CollectionsKt.emptyList());
        z2 r0 = z2.a;
        if (r0.getMusicCreateConfig().e != 2) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        int r2 = 5;
    L9:
        c = r2;
        g = "";
        h = 960;
        i = 1920;
        return;
    L8:
        r2 = r0.getMusicSaveConfig().b;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    public static void g(String r6) {
        long r0 = System.currentTimeMillis();
        FLogger.a.i("save_music_video", r6 + " success, use time is " + (r0 - e) + "ms");
        e = r0;
    }

    public static void i(String r2) {
        StateFlowImpl r0 = b;
        List r1 = CollectionsKt.toMutableList((Collection) r0.getValue());
        r1.remove(r2);
        r0.setValue(r1);
    }

    public static Bitmap d(ConstraintLayout r8, int r9) {
        Bitmap r0 = Bitmap.createBitmap(h, i, Bitmap.Config.ARGB_8888);
        Canvas r7 = new Canvas(r0);
        Paint r6 = new Paint();
        r6.setColor(r9);
        r7.drawRect(0.0f, 0.0f, h, i, r6);
        int r10 = r8.getWidth();
        int r1 = r8.getHeight();
        if (r1 <= i) goto L5;
        float r2 = i / r1;
    L7:
        if (r10 <= h) goto L9;
        r2 = RangesKt.coerceAtMost(h / r10, r2);
    L9:
        Matrix r3 = new Matrix();
        r3.setScale(r2, r2);
        int r4 = (int) (r1 * r2);
        int r5 = (h - ((int) (r10 * r2))) / 2;
        int r11 = (i - r4) / 2;
        r7.save();
        r7.translate(r5, r11);
        r7.concat(r3);
        r8.draw(r7);
        r7.restore();
        return r0;
    L5:
        r2 = 1.0f;
        goto L7
    }

    public final Object j(String r17, Continuation<? super String> r18) {
        if ((r18 instanceof MusicVideoSaver$requestAudioUrl$1) == false) goto L7;
        MusicVideoSaver$requestAudioUrl$1 r1 = (MusicVideoSaver$requestAudioUrl$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MusicVideoSaver$requestAudioUrl$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        boolean r15 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        com.larus.network.http.y r5 = (com.larus.network.http.a) r0;
        if ((r5 instanceof com.larus.network.http.y) == false) goto L28;
        BigMusicVideoInfo r6 = (BigMusicVideoInfo) ((com.larus.network.http.a) r5).b;
        if (r6 == null) goto L28;
        String r7 = r6.a();
        if (r7 == null) goto L28;
        if (r7.length() == 0) goto L27;
        r15 = false;
    L27:
        if (r15 == true) goto L28;
        return r7;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r13.label = 1;
        JSONObject r8 = new JSONObject();
        r8.put("video_id", r17);
        Unit r9 = Unit.INSTANCE;
        r0 = HttpExtKt.k("Social", BigMusicVideoInfo.class, "/alice/media/bigmusic/get_video", r8, null, null, false, null, null, null, r13, 1008);
        if (r0 != r3) goto L17;
        return r3;
    L7:
        r1 = new MusicVideoSaver$requestAudioUrl$1(this, r18);
        goto L8
    }

    public final Object c(String r5, com.larus.bmhome.bigimg.download.c r6, Continuation r7) {
        if ((r7 instanceof MusicVideoSaver$collectLoadingStatus$1) == false) goto L7;
        MusicVideoSaver$collectLoadingStatus$1 r0 = (MusicVideoSaver$collectLoadingStatus$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L12;
        ResultKt.throwOnFailure(r8);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        StateFlowImpl r9 = b;
        n r4 = new n(r6, r5);
        r0.label = 1;
        if (r9.collect(r4, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new MusicVideoSaver$collectLoadingStatus$1(this, r7);
        goto L8
    }

    public static void h(String r3, String r4, boolean r5, String r6) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.putOpt("task_key", r3);
        r1.putOpt(ShareType.URL, r4);
        r1.putOpt("is_success", ve8.c.b(r5));
        if (r6 == null) goto L5;
        r1.putOpt("error_msg", r6);
    L5:
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("larus_music_download_result", r1);
    }

    public static final void a(Ref.ObjectRef r10, kotlinx.coroutines.i r11, String r12, Context r13, Ref.IntRef r14) {
        Job r0 = (Job) r10.element;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        r10.element = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r11.getContext()), null, null, new MusicVideoSaver$saveAudioFile$2$startTimer$1(r12, r13, r14, r11, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.constraintlayout.widget.ConstraintLayout, com.larus.bmhome.music.save_video.MusicDynamicShareView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.larus.bmhome.music.save_video.MusicDynamicShareView] */
    public final Object e(MusicDynamicShareView r5, List<Bitmap> r6, String r7, int r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof MusicVideoSaver$enqueueFrameBitmap$1) == false) goto L7;
        MusicVideoSaver$enqueueFrameBitmap$1 r0 = (MusicVideoSaver$enqueueFrameBitmap$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.I$0;
        r5 = (MusicDynamicShareView) r0.L$3;
        MusicDynamicShareView r11 = (MusicDynamicShareView) r0.L$2;
        r7 = (String) r0.L$1;
        r6 = (List) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L21:
        if (Build.VERSION.SDK_INT < z2.a.getMusicSaveConfig().a) goto L23;
        Bitmap r12 = d(r5, r8);
    L24:
        r6.add(r12);
        long r13 = System.currentTimeMillis();
        FLogger r14 = FLogger.a;
        r14.i("save_music_video", "enqueue bitmap success, use time is " + (r13 - f) + "ms, lyrics: " + ("lyric:" + r7));
        f = r13;
        return Unit.INSTANCE;
    L23:
        r5.setDrawingCacheEnabled(true);
        Bitmap r15 = Bitmap.createBitmap(r5.getDrawingCache(), 0, 0, h, i);
        r5.setDrawingCacheEnabled(false);
        r12 = r15;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r5;
        r0.L$3 = r5;
        r0.I$0 = r8;
        r0.label = 1;
        LarusLayoutMusicShareDynamicBinding r16 = r5.a;
        r16.c.setText(r7);
        r5.requestLayout();
        Object r17 = ViewExtKt.b(r16.c, r0);
        if (r17 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r17 = Unit.INSTANCE;
    L18:
        if (r17 != r2) goto L21;
        return r2;
    L7:
        r0 = new MusicVideoSaver$enqueueFrameBitmap$1(this, r9);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v16, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v3, types: [android.view.View, com.larus.bmhome.music.save_video.MusicShareView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.view.View, com.larus.bmhome.music.save_video.MusicDynamicShareView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.bmhome.music.save_video.MusicVideoSaver] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.larus.bmhome.music.save_video.MusicVideoSaver] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19, types: [com.larus.bmhome.music.save_video.MusicVideoSaver] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.larus.bmhome.music.save_video.MusicDynamicShareView] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.larus.bmhome.music.save_video.MusicDynamicShareView] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x027a -> B:86:0x0281). Please report as a decompilation issue!!! */
    public final Object f(Context r24, ViewGroup r25, MusicCreationContent r26, LyricsSeekContent r27, Continuation<? super Pair<? extends List<Bitmap>, j>> r28) {
        ?? r2 = r25;
        LyricsSeekContent r4 = r27;
        if ((r28 instanceof MusicVideoSaver$getVideoFrames$1) == false) goto L7;
        MusicVideoSaver$getVideoFrames$1 r5 = (MusicVideoSaver$getVideoFrames$1) r28;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
        ?? r12 = this;
    L8:
        Object r0 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L17;
        if (r7 != 4) goto L16;
        int r1 = r5.I$0;
        MusicShareView r3 = (MusicShareView) r5.L$5;
        MusicShareView r8 = (MusicShareView) r5.L$4;
        Ref.ObjectRef r9 = (Ref.ObjectRef) r5.L$3;
        j r10 = (j) r5.L$2;
        List r11 = (List) r5.L$1;
        ViewGroup r14 = (ViewGroup) r5.L$0;
        ResultKt.throwOnFailure(r0);
        ?? r15 = r3;
        ?? r16 = r14;
        boolean r17 = true;
    L93:
        if (Build.VERSION.SDK_INT < z2.a.getMusicSaveConfig().a) goto L95;
        r9.element = d(r15, r1);
    L96:
        Bitmap r18 = (Bitmap) r9.element;
        Boxing.boxBoolean(r11.add(r18.copy(z0.b(r18.getConfig()), ((Bitmap) r9.element).isMutable())));
        j r19 = r10;
        List r110 = r11;
        ?? r20 = r16;
    L97:
        r20.removeAllViews();
        return TuplesKt.to(r110, r19);
    L95:
        r15.setDrawingCacheEnabled(r17);
        r9.element = Bitmap.createBitmap(r15.getDrawingCache(), 0, 0, h, i);
        r15.setDrawingCacheEnabled(false);
        goto L96
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r21 = r5.I$3;
        int r22 = r5.I$2;
        int r23 = r5.I$1;
        int r29 = r5.I$0;
        MusicDynamicShareView r30 = (MusicDynamicShareView) r5.L$5;
        j r31 = (j) r5.L$4;
        List r32 = (List) r5.L$3;
        List r33 = (List) r5.L$2;
        LyricsSeekContent r111 = (LyricsSeekContent) r5.L$1;
        ViewGroup r112 = (ViewGroup) r5.L$0;
        ResultKt.throwOnFailure(r0);
        int r34 = r23;
        ?? r113 = r30;
        r19 = r31;
        ?? r114 = r12;
        Object r35 = r13;
        List r115 = r32;
        int r36 = r29;
        ?? r37 = r112;
        r110 = r33;
        MusicVideoSaver$getVideoFrames$1 r38 = r5;
        LyricsSeekContent r39 = r111;
    L86:
        int r40 = r22 + 1;
        int r116 = 0;
        ?? r41 = r37;
        ?? r117 = r113;
        ?? r118 = r114;
    L74:
        if (r40 >= r21) goto L87;
        int r42 = RangesKt.coerceAtLeast(((LyricsUtterances) ListProtector.get(r115, r40)).getStartTime() - r34, r116);
        int r43 = c;
        int r44 = r42 * r43;
        int r119 = r44 / GuidePriority.COMMERCE_CREDIT_PRIORITY;
        Object r210 = r35;
        if ((r44 % GuidePriority.COMMERCE_CREDIT_PRIORITY) == 0) goto L78;
        r119 = r119 + 1;
    L78:
        r19.a.put(Integer.valueOf(r40), Integer.valueOf(r119));
        r34 = r34 + ((GuidePriority.COMMERCE_CREDIT_PRIORITY / r43) * r119);
        String r45 = ((LyricsUtterances) ListProtector.get(r115, r40)).getText();
        if (r45 != null) goto L81;
        String r46 = "";
    L82:
        r38.L$0 = r41;
        r38.L$1 = r39;
        r38.L$2 = r110;
        r38.L$3 = r115;
        r38.L$4 = r19;
        r38.L$5 = r117;
        r38.I$0 = r36;
        r38.I$1 = r34;
        r38.I$2 = r40;
        r38.I$3 = r21;
        r38.label = 3;
        ?? r120 = r41;
        LyricsSeekContent r121 = r39;
        int r211 = r40;
        if (r118.e(r117, r110, r46, r36, r38) != r210) goto L85;
        return r210;
    L85:
        r35 = r210;
        r37 = r120;
        r39 = r121;
        r22 = r211;
        r113 = r117;
        r114 = r118;
        goto L86
    L81:
        r46 = r45;
        goto L82
    L87:
        double r47 = r39.getDuration();
        double r48 = GuidePriority.COMMERCE_CREDIT_PRIORITY;
        double r49 = (RangesKt.coerceAtLeast((r47 * r48) - ((double) r34), 0.0d) * ((double) c)) / r48;
        r19.a.put(Integer.valueOf(r115.size()), Integer.valueOf((int) r49));
        r20 = r41;
        goto L97
    L18:
        int r50 = r5.I$1;
        int r51 = r5.I$0;
        MusicDynamicShareView r52 = (MusicDynamicShareView) r5.L$5;
        j r53 = (j) r5.L$4;
        List r54 = (List) r5.L$3;
        List r55 = (List) r5.L$2;
        LyricsSeekContent r56 = (LyricsSeekContent) r5.L$1;
        ViewGroup r57 = (ViewGroup) r5.L$0;
        ResultKt.throwOnFailure(r0);
        r116 = 0;
        ?? r58 = r52;
        ?? r59 = r57;
    L73:
        r117 = r58;
        r19 = r53;
        r110 = r55;
        r41 = r59;
        r118 = r12;
        r40 = 0;
        r38 = r5;
        r39 = r56;
        r36 = r51;
        int r212 = r50;
        r21 = r54.size();
        r34 = r212;
        r115 = r54;
        r35 = r13;
        goto L74
    L19:
        int r60 = r5.I$1;
        r51 = r5.I$0;
        MusicDynamicShareView r61 = (MusicDynamicShareView) r5.L$5;
        j r62 = (j) r5.L$4;
        List r63 = (List) r5.L$3;
        List r64 = (List) r5.L$2;
        LyricsSeekContent r65 = (LyricsSeekContent) r5.L$1;
        ViewGroup r122 = (ViewGroup) r5.L$0;
        ResultKt.throwOnFailure(r0);
        int r66 = r60;
        j r123 = r62;
        List r124 = r63;
        r4 = r65;
        List r67 = r64;
        ?? r68 = r61;
        ?? r125 = r122;
    L69:
        int r69 = r66 + (GuidePriority.COMMERCE_CREDIT_PRIORITY / c);
        r5.L$0 = r125;
        r5.L$1 = r4;
        r5.L$2 = r67;
        r5.L$3 = r124;
        r5.L$4 = r123;
        r5.L$5 = r68;
        r5.I$0 = r51;
        r5.I$1 = r69;
        r5.label = 2;
        List r126 = r67;
        ?? r127 = r125;
        r116 = 0;
        List r70 = r124;
        if (e(r68, r67, "", r51, r5) != r13) goto L72;
        return r13;
    L72:
        r54 = r70;
        r56 = r4;
        r53 = r123;
        r59 = r127;
        r55 = r126;
        r50 = r69;
        r58 = r68;
        goto L73
    L20:
        ResultKt.throwOnFailure(r0);
        r11 = new ArrayList();
        r25.removeAllViews();
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L32
        String r72 = r26.getCoverMainColor();     // Catch: Throwable -> L32
        if (r72 != null) goto L25;
        r72 = "";
    L25:
        if (r72.length() != 0) goto L27;
        boolean r73 = true;
    L28:
        if (r73 == false) goto L30;
        r72 = "#0E9189";
    L30:
        Object r74 = Result.constructor-impl(Boxing.boxInt(Color.parseColor(r72)));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r74) == false) goto L37;
        r74 = null;
    L37:
        Integer r75 = (Integer) r74;
        if (r75 == null) goto L40;
        int r76 = r75.intValue();
    L41:
        if (r4 == null) goto L55;
        List r77 = r27.getUtterances();
        if (r77 == null) goto L55;
        ArrayList r128 = new ArrayList();
        Iterator r78 = r77.iterator();
    L46:
        if (r78.hasNext() == false) goto L56;
        Object r79 = r78.next();
        String r129 = ((LyricsUtterances) r79).getText();
        Iterator r130 = r78;
        if (r129 == null) goto L50;
        boolean r80 = StringsKt.contains$default(r129, "[", false, 2, null);
    L52:
        if ((!r80) == false) goto L54;
        r128.add(r79);
    L54:
        r78 = r130;
        goto L46
    L50:
        r80 = false;
    L56:
        j r81 = new j();
        if (r128 != null) goto L59;
    L62:
        boolean r131 = true;
    L64:
        if (r131 == true) goto L88;
        ?? r132 = new MusicDynamicShareView(r24, null, 6, 0);
        r2.addView(r132, 960, 1920);
        f = System.currentTimeMillis();
        r5.L$0 = r2;
        r5.L$1 = r4;
        r5.L$2 = r11;
        r5.L$3 = r128;
        r5.L$4 = r81;
        r5.L$5 = r132;
        r5.I$0 = r76;
        r5.I$1 = 0;
        r5.label = 1;
        if (r132.R5(r26, r5) != r13) goto L68;
        return r13;
    L68:
        r125 = r2;
        r67 = r11;
        r68 = r132;
        r124 = r128;
        r51 = r76;
        r123 = r81;
        r66 = 0;
        goto L69
    L88:
        r17 = true;
        Ref.ObjectRef r133 = new Ref.ObjectRef();
        ?? r134 = new MusicShareView(r24, null, 6, 0);
        r2.addView(r134, 960, 1920);
        r5.L$0 = r2;
        r5.L$1 = r11;
        r5.L$2 = r81;
        r5.L$3 = r133;
        r5.L$4 = r134;
        r5.L$5 = r134;
        r5.I$0 = r76;
        r5.label = 4;
        if (r134.R5(r26, r5) != r13) goto L91;
        return r13;
    L91:
        r1 = r76;
        r10 = r81;
        r9 = r133;
        r16 = r2;
        r15 = r134;
        goto L93
    L59:
        if (r128.isEmpty() == true) goto L62;
        r131 = false;
    L55:
        r128 = null;
        goto L56
    L40:
        r76 = -16777216;
        goto L41
    L27:
        r73 = false;
    L32:
        th = move-exception;
        Result.Companion r82 = Result.Companion;
        r74 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        ?? r135 = this;
        r5 = new MusicVideoSaver$getVideoFrames$1(r135, r28);
        r12 = r135;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    public final Object m(Context r20, List<Bitmap> r21, String r22, String r23, j r24, Continuation<? super Integer> r25) {
        if ((r25 instanceof MusicVideoSaver$softwareDecode$1) == false) goto L7;
        MusicVideoSaver$softwareDecode$1 r1 = (MusicVideoSaver$softwareDecode$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
        int r13 = 0;
    L87:
        int r4 = ((Number) r0).intValue();
        if (r4 != 400) goto L90;
        g("Mux audio");
        return Boxing.boxInt(r13);
    L90:
        return Boxing.boxInt(r4);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r5 = (String) r1.L$2;
        String r6 = (String) r1.L$1;
        String r7 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r13 = 0;
    L39:
        int r8 = ((Number) r0).intValue();
        if (r8 != 300) goto L42;
        g("Encode bitmap to video");
        int r9 = com.larus.bmhome.music.save_video.software_decoder.a.a;
        MediaMuxer r10 = null;
        r1.L$0 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.label = 2;
        kotlinx.coroutines.j r11 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r1), 1);
        r11.C();
        MediaExtractor r14 = new MediaExtractor();
        r14.setDataSource(r5);     // Catch: IOException -> L81
        int r15 = r14.getTrackCount();
        MediaFormat r16 = null;
        int r17 = 0;
    L47:
        if (r17 >= r15) goto L52;
        r16 = r14.getTrackFormat(r17);
        String r18 = r16.getString("mime");
        Intrinsics.checkNotNull(r18);
        if (StringsKt.startsWith$default(r18, "video/", r13, 2, null) == true) goto L50;
        r17 = r17 + 1;
        goto L47
    L50:
        com.larus.bmhome.music.save_video.software_decoder.a.a = r17;
        int r19 = r16.getInteger("max-input-size");
    L54:
        if (com.larus.bmhome.music.save_video.software_decoder.a.a >= 0) goto L56;
        com.larus.bmhome.music.save_video.software_decoder.a.a(r14, null, null);
        Result.Companion r26 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(Boxing.boxInt(402)));
    L82:
        r0 = r11.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L85;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L85:
        if (r0 != r12) goto L87;
        return r12;
    L56:
        MediaExtractor r27 = new MediaExtractor();
        r27.setDataSource(r7);     // Catch: IOException -> L80
        int r28 = r27.getTrackCount();
        MediaFormat r110 = null;
        int r111 = 0;
    L59:
        if (r111 >= r28) goto L64;
        r110 = r27.getTrackFormat(r111);
        String r29 = r110.getString("mime");
        Intrinsics.checkNotNull(r29);
        int r210 = r28;
        MediaMuxer r30 = null;
        if (StringsKt.startsWith$default(r29, "audio/", r13, 2, null) == true) goto L62;
        r111 = r111 + 1;
        r10 = null;
        r28 = r210;
        goto L59
    L62:
        com.larus.bmhome.music.save_video.software_decoder.a.b = r111;
    L66:
        if (com.larus.bmhome.music.save_video.software_decoder.a.b >= 0) goto L68;
        com.larus.bmhome.music.save_video.software_decoder.a.a(r14, r27, r30);
        Result.Companion r31 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(Boxing.boxInt(404)));
        goto L82
    L68:
        MediaCodec.BufferInfo r32 = new MediaCodec.BufferInfo();
        MediaMuxer r33 = new MediaMuxer(r6, r13 == true ? 1 : 0);     // Catch: IOException -> L79
        Intrinsics.checkNotNull(r16);
        int r34 = r33.addTrack(r16);
        Intrinsics.checkNotNull(r110);
        int r35 = r33.addTrack(r110);
        r33.start();
        ByteBuffer r36 = ByteBuffer.allocate(r19);
        r14.unselectTrack(com.larus.bmhome.music.save_video.software_decoder.a.a);
        r14.selectTrack(com.larus.bmhome.music.save_video.software_decoder.a.a);
    L71:
        int r37 = r14.readSampleData(r36, r13 == true ? 1 : 0);
        if (r37 < 0) goto L73;
        long r112 = r14.getSampleTime();
        r32.size = r37;
        r32.presentationTimeUs = r112;
        r32.offset = r13 == true ? 1 : 0;
        r32.flags = r14.getSampleFlags();
        r33.writeSampleData(r34, r36, r32);
        r14.advance();
        goto L71
    L73:
        r14.unselectTrack(com.larus.bmhome.music.save_video.software_decoder.a.a);
        MediaCodec.BufferInfo r113 = new MediaCodec.BufferInfo();
        r27.selectTrack(com.larus.bmhome.music.save_video.software_decoder.a.b);
    L74:
        int r38 = r27.readSampleData(r36, r13 == true ? 1 : 0);
        if (r38 < 0) goto L76;
        long r114 = r27.getSampleTime();
        r113.size = r38;
        r113.presentationTimeUs = r114 + 0;
        r113.offset = r13 == true ? 1 : 0;
        r113.flags = r27.getSampleFlags();
        r33.writeSampleData(r35, r36, r113);
        r27.advance();
        goto L74
    L76:
        r27.unselectTrack(com.larus.bmhome.music.save_video.software_decoder.a.b);
        com.larus.bmhome.music.save_video.software_decoder.a.a(r14, r27, r33);
        Result.Companion r39 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(Boxing.boxInt(400)));
    L79:
        com.larus.bmhome.music.save_video.software_decoder.a.a(r14, r27, null);
        Result.Companion r40 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(Boxing.boxInt(405)));
        goto L82
    L64:
        r30 = r10;
    L80:
        com.larus.bmhome.music.save_video.software_decoder.a.a(r14, r27, null);
        Result.Companion r41 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(Boxing.boxInt(403)));
        goto L82
    L52:
        r19 = 0;
    L81:
        com.larus.bmhome.music.save_video.software_decoder.a.a(r14, null, null);
        Result.Companion r42 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(Boxing.boxInt(401)));
        goto L82
    L42:
        return Boxing.boxInt(r8);
    L16:
        ResultKt.throwOnFailure(r0);
        ArrayList r43 = new ArrayList();
        Iterator<T> r44 = r21.iterator();
        int r45 = 0;
    L18:
        if (r44.hasNext() == false) goto L30;
        Object r46 = r44.next();
        int r47 = r45 + 1;
        if (r45 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        Bitmap r48 = (Bitmap) r46;
        Integer r49 = r24.a.get(Integer.valueOf(r45));
        if (r49 == null) goto L25;
        int r50 = RangesKt.coerceAtLeast(r49.intValue(), 1);
    L26:
        int r51 = 0;
    L27:
        if (r51 >= r50) goto L29;
        r43.add(r48.copy(z0.b(r48.getConfig()), false));
        r51 = r51 + 1;
        goto L27
    L29:
        r45 = r47;
        goto L18
    L25:
        r50 = 1;
        goto L26
    L30:
        String r52 = r20.getCacheDir().getAbsolutePath() + "/music/video/" + System.currentTimeMillis() + ".mp4";
        File r53 = new PolarisFileWrapper(r52).getParentFile();
        if (r53 != null) goto L33;
    L35:
        BitmapToVideoEncoder r54 = BitmapToVideoEncoder.a;
        int r55 = ((Bitmap) CollectionsKt.first(r43)).getWidth();
        int r56 = ((Bitmap) CollectionsKt.first(r43)).getHeight();
        r1.L$0 = r22;
        r1.L$1 = r23;
        r1.L$2 = r52;
        r1.label = 1;
        r13 = 0;
        Object r57 = r54.a(r55, r56, r43, r52, null, null, null, r1);
        if (r57 != r12) goto L38;
        return r12;
    L38:
        r7 = r22;
        r6 = r23;
        r5 = r52;
        r0 = r57;
        goto L39
    L33:
        if (r53.exists() == true) goto L35;
        r53.mkdirs();
    L7:
        r1 = new MusicVideoSaver$softwareDecode$1(this, r25);
        goto L8
    }

    public static final Object b(MusicVideoSaver r44, Context r45, ViewGroup r46, String r47, String r48, MusicCreationContent r49, LyricsSeekContent r50, Continuation r51) {
        String r1 = r48;
        r44.getClass();
        if ((r51 instanceof MusicVideoSaver$saveVideo$1) == false) goto L7;
        MusicVideoSaver$saveVideo$1 r3 = (MusicVideoSaver$saveVideo$1) r51;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        String r0 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L112:
        g = r0;
        FLogger.a.i("save_music_video", "Save video success, total use time is " + (System.currentTimeMillis() - d) + "ms");
        return Boxing.boxInt(0);
    L13:
        r0 = (String) r3.L$1;
        Context r6 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L106:
        int r7 = ((Number) r2).intValue();
        if (r7 != 0) goto L120;
    L109:
        com.larus.platform.service.e.b(r0);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        MusicVideoSaver$saveVideo$2 r9 = new MusicVideoSaver$saveVideo$2(r6, r0, null);
        r3.L$0 = r0;
        r3.L$1 = null;
        r3.label = 8;
        if (BuildersKt.withContext(r8, r9, r3) != r5) goto L112;
        return r5;
    L120:
        return Boxing.boxInt(r7);
    L14:
        r0 = (String) r3.L$1;
        r6 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L93:
        int r10 = ((Number) r2).intValue();
        if (r10 == 0) goto L109;
        return Boxing.boxInt(r10);
    L15:
        MusicCreationContent r11 = (MusicCreationContent) r3.L$2;
        String r12 = (String) r3.L$1;
        Context r13 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        MusicCreationContent r14 = r11;
        r0 = r12;
        r6 = r13;
    L87:
        int r15 = ((Number) r2).intValue();
        FLogger.a.i("save_music_video", "softwareDecode result is " + r15);
        if (r15 != 0) goto L118;
        r3.L$0 = r6;
        r3.L$1 = r0;
        r3.L$2 = null;
        r3.label = 6;
        r2 = TTCNPAHelperKt.b(r0, r14, r3);
        if (r2 != r5) goto L93;
        return r5;
    L118:
        return Boxing.boxInt(r15);
    L16:
        List<Bitmap> r16 = (List) r3.L$4;
        Pair r17 = (Pair) r3.L$3;
        MusicCreationContent r18 = (MusicCreationContent) r3.L$2;
        String r19 = (String) r3.L$1;
        Context r110 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        List<Bitmap> r28 = r16;
        Pair r30 = r17;
        r14 = r18;
        r0 = r19;
        r6 = r110;
    L68:
        String r29 = (String) r2;
        if (r29 == null) goto L117;
        g("Save audio to disk");
        File r20 = new PolarisFileWrapper(r0).getParentFile();
        if (r20 != null) goto L74;
    L76:
        int r21 = (int) Math.ceil(r14.getDurationSec(new k()));
        if (r21 > 0) goto L79;
        r21 = 30;
    L79:
        z2 r22 = z2.a;
        if (r22.getMusicCreateConfig().e != 2) goto L82;
        boolean r111 = true;
    L83:
        if (r111 == false) goto L97;
        j r23 = (j) r30.getSecond();
        r3.L$0 = r6;
        r3.L$1 = r0;
        r3.L$2 = r14;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.label = 5;
        r2 = r44.m(r6, r28, r29, r0, r23, r3);
        if (r2 != r5) goto L87;
        return r5;
    L97:
        if (r28.isEmpty() == true) goto L100;
        r21 = (c * r21) / r28.size();
    L100:
        int r36 = r21;
        if (((j) r30.getSecond()).a.size() != 0) goto L103;
        j r24 = (j) r30.getSecond();
        r24.a.put(0, Integer.valueOf(r36));
    L103:
        PolarisFileWrapper r25 = new PolarisFileWrapper(r0);
        int r33 = h;
        int r34 = i;
        int r26 = c;
        q r27 = new q(r25, r33, r34, "video/avc", r36, r26, 1500000, r26 * 5, r22.getMusicSaveConfig().c, r22.getMusicSaveConfig().d);
        CoroutineDispatcher r31 = Dispatchers.getIO();
        MusicVideoSaver$saveVideo$saveResult$1 r32 = new MusicVideoSaver$saveVideo$saveResult$1(r6, r27, r28, r29, r30, r0, r14, null);
        r3.L$0 = r6;
        r3.L$1 = r0;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.label = 7;
        r2 = BuildersKt.withContext(r31, r32, r3);
        if (r2 != r5) goto L106;
        return r5;
    L82:
        r111 = false;
        goto L83
    L74:
        if (r20.exists() == true) goto L76;
        r20.mkdirs();
        goto L76
    L117:
        return Boxing.boxInt(201);
    L17:
        List<Bitmap> r35 = (List) r3.L$5;
        Pair r37 = (Pair) r3.L$4;
        MusicCreationContent r112 = (MusicCreationContent) r3.L$3;
        String r113 = (String) r3.L$2;
        String r114 = (String) r3.L$1;
        Context r38 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L53:
        String r39 = (String) r2;
        if (r39 == null) goto L116;
        g("Request audio url");
        r3.L$0 = r38;
        r3.L$1 = r113;
        r3.L$2 = r112;
        r3.L$3 = r37;
        r3.L$4 = r35;
        r3.L$5 = null;
        r3.label = 4;
        kotlinx.coroutines.j r40 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r3), 1);
        r40.C();
        Ref.IntRef r41 = new Ref.IntRef();
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        DownloadTask r42 = Downloader.with(r38).taskKey(r114);
        t0 r116 = z2.a.getCreationDownloaderConfig();
        if (r116 == null) goto L61;
        Integer r117 = r116.retryCount;
        if (r117 == null) goto L61;
        int r118 = r117.intValue();
    L62:
        DownloadTask r43 = r42.retryCount(r118).autoSetHashCodeForSameTask(true).url(r39).savePath(r38.getCacheDir().getAbsolutePath() + "/music/audio/");
        StringBuilder r52 = new StringBuilder();
        r14 = r112;
        String r410 = r113;
        r52.append(System.currentTimeMillis());
        r52.append(".m4a");
        DownloadTask r53 = r43.name(r52.toString()).subThreadListener(new p(r114, r40, r115, r39, r38, r41));
        r41.element = r53.getDownloadId();
        r40.i(new o(r53, r114, r38, r115));
        r53.asyncDownload(null);
        a(r115, r40, r114, r38, r41);
        r2 = r40.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L65;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L65:
        if (r2 == r5) goto L124;
        r0 = r410;
        r28 = r35;
        r30 = r37;
        r6 = r38;
        goto L68
    L124:
        return r5;
    L61:
        r118 = 3;
        goto L62
    L116:
        return Boxing.boxInt(101);
    L18:
        MusicCreationContent r54 = (MusicCreationContent) r3.L$3;
        String r55 = (String) r3.L$2;
        String r56 = (String) r3.L$1;
        Context r119 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r113 = r55;
        r114 = r56;
        r38 = r119;
        r112 = r54;
    L46:
        Pair r57 = (Pair) r2;
        r35 = (List) r57.getFirst();
        g("Generate bitmap(" + r35.size() + ')');
        String r58 = r112.getVid();
        if (r58 != null) goto L49;
        r58 = "";
    L49:
        r3.L$0 = r38;
        r3.L$1 = r114;
        r3.L$2 = r113;
        r3.L$3 = r112;
        r3.L$4 = r57;
        r3.L$5 = r35;
        r3.label = 3;
        Object r59 = r44.j(r58, r3);
        if (r59 == r5) goto L123;
        r37 = r57;
        r2 = r59;
        goto L53
    L123:
        return r5;
    L19:
        LyricsSeekContent r60 = (LyricsSeekContent) r3.L$5;
        MusicCreationContent r61 = (MusicCreationContent) r3.L$4;
        String r62 = (String) r3.L$3;
        String r120 = (String) r3.L$2;
        ViewGroup r121 = (ViewGroup) r3.L$1;
        Context r122 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
        LyricsSeekContent r63 = r60;
        r1 = r62;
        ViewGroup r64 = r121;
        MusicCreationContent r123 = r61;
    L42:
        g("updateVideoSize");
        r3.L$0 = r122;
        r3.L$1 = r120;
        r3.L$2 = r1;
        r3.L$3 = r123;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.label = 2;
        r2 = r44.f(r122, r64, r123, r63, r3);
        if (r2 == r5) goto L122;
        r38 = r122;
        r114 = r120;
        r112 = r123;
        r113 = r1;
        goto L46
    L122:
        return r5;
    L20:
        ResultKt.throwOnFailure(r2);
        if (z2.a.getMusicCreateConfig().e != 1) goto L23;
        boolean r65 = true;
    L24:
        if (r65 == true) goto L114;
        String r66 = r49.getVid();
        if (r66 != null) goto L29;
    L32:
        boolean r67 = true;
    L33:
        if (r67 == true) goto L115;
        long r124 = System.currentTimeMillis();
        d = r124;
        e = r124;
        PolarisFileWrapper r68 = new PolarisFileWrapper(r1);
        int r125 = h;
        int r126 = i;
        int r69 = c;
        q r70 = new q(r68, r125, r126, "video/avc", 0, r69, 1500000, r69 * 5, 784);
        r3.L$0 = r45;
        r64 = r46;
        r3.L$1 = r64;
        r120 = r47;
        r3.L$2 = r120;
        r3.L$3 = r1;
        r123 = r49;
        r3.L$4 = r123;
        r3.L$5 = r50;
        r3.label = 1;
        Object r71 = BuildersKt.withContext(Dispatchers.getIO(), new MusicVideoSaver$updateVideoSize$2(r70, null), r3);
        if (r71 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L39;
        r71 = Unit.INSTANCE;
    L39:
        if (r71 == r5) goto L121;
        r63 = r50;
        r122 = r45;
        goto L42
    L121:
        return r5;
    L115:
        return Boxing.boxInt(102);
    L29:
        if (StringsKt.isBlank(r66) == true) goto L32;
        r67 = false;
        goto L33
    L114:
        return Boxing.boxInt(501);
    L23:
        r65 = false;
        goto L24
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r3 = new MusicVideoSaver$saveVideo$1(r44, r51);
        goto L8
    }

    public static void l(Context r17, ViewGroup r18, String r19, final MusicCreationContent r20, LyricsSeekContent r21, Message r22, CoroutineScope r23, Function2 r24) {
        FLogger.a.i("save_music_video", "saveVideoAndLoadingInternal");
        a r0 = new a(CoroutineExceptionHandler.Key, r19, r20, r24, r21);
        StateFlowImpl r1 = b;
        List r2 = CollectionsKt.toMutableList((Collection) r1.getValue());
        String r4 = r20.getVid();
        TypeIntrinsics.asMutableCollection(r2).remove(r4);
        r2.add(String.valueOf(r20.getVid()));
        r1.setValue(r2);
        BuildersKt.launch$default(r23, r0, null, new MusicVideoSaver$saveVideoAndLoadingInternal$1(r20, r21, r22, r24, r17, r18, r19, null), 2, null).invokeOnCompletion(new m(r20));
    }

    public static void k(final Context r19, final ViewGroup r20, final String r21, final MusicCreationContent r22, final LyricsSeekContent r23, String r24, String r25, final Message r26, final CoroutineScope r27, kr8.o r28, final Function2 r29, int r30) {
        boolean r4 = false;
        if ((r30 & 512) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r30 & 1024) == 0) goto L9;
        kr8.o r12 = null;
    L10:
        Intrinsics.checkNotNullParameter(r20, "viewParent");
        Intrinsics.checkNotNullParameter(r21, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r22, "musicContent");
        Intrinsics.checkNotNullParameter(r24, "currentPage");
        Intrinsics.checkNotNullParameter(r25, "clickFrom");
        Intrinsics.checkNotNullParameter(r27, "scope");
        Intrinsics.checkNotNullParameter(r29, "dismissLoadingCallback");
        if (r19 != null) goto L13;
        r29.invoke(101, "no context");
        return;
    L13:
        FlowFileProtectionService r2 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r2 == null) goto L19;
        if (r2.I0() != true) goto L19;
        r4 = true;
    L19:
        if (r4 == false) goto L29;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r5 = new JSONObject();
        r5.put("action", "save_album");
        r5.put("entry", "music_video_saver");
        r5.put("channel", "album");
        r5.put("content_type", "video");
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("flow_enterprise_file_egress_block", r5);
        String r1 = r2.H0();
        if (r1 != null) goto L23;
    L28:
        r29.invoke(602, "");
        return;
    L23:
        if ((!StringsKt.isBlank(r1)) == false) goto L25;
        String r11 = r1;
    L26:
        if (r11 == null) goto L28;
        t19.s.j(t19.s.a, r19, r11, null, false, 28);
        goto L28
    L25:
        r11 = null;
        goto L26
    L29:
        if (r3 == false) goto L44;
        String r7 = r22.getVid();
        if (r26 == null) goto L33;
        String r8 = r26.getMessageId();
    L34:
        if (r8 != null) goto L36;
        String r9 = "";
    L37:
        if (r26 == null) goto L41;
        Map r10 = r26.getExt();
        if (r10 == null) goto L41;
        String r16 = (String) r10.get("gen_music_create_way");
    L42:
        kr8.d r13 = new kr8.d(r24, r7, r25, r9, r16, 1);
        kr8.n r14 = kr8.n.a;
        kr8.l.a.b(r13, kr8.n.c(r12, r24, true), 1);
    L41:
        r16 = null;
        goto L42
    L36:
        r9 = r8;
        goto L37
    L33:
        r8 = null;
    L44:
        int r15 = Build.VERSION.SDK_INT;
        if (r15 > 21) goto L48;
        FLogger.a.e("Music Save Error", "version too low");
        r29.invoke(501, "");
        return;
    L48:
        if (r15 <= 28) goto L50;
    L58:
        l(r19, r20, r21, r22, r23, r26, r27, r29);
        return;
    L50:
        if (ContextCompat.checkSelfPermission(r19, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L58;
        if ((r19 instanceof FragmentActivity) == false) goto L54;
        FragmentActivity r17 = (FragmentActivity) r19;
    L55:
        if (r17 == null) goto L64;
        i2.b.a(r17, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new l(r19, r20, r21, r22, r23, r26, r27, r29));
        return;
    L64:
        return;
    L54:
        r17 = null;
        goto L55
    L9:
        r12 = r28;
        goto L10
    L5:
        r3 = false;
        goto L7
    }
}
