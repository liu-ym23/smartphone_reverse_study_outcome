package com.bytedance.android.livesdk.chatroom.vs.cache;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.vs.cache.historyprogress.ProgressApi;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.model.FirstShowLocalProgress;
import com.bytedance.android.livesdk.model.b0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.a;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import rp1.b;
import rp1.d;
import rp1.e;
import rp1.f;
import rp1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/cache/VSHistoryProgressServiceImp;", "Lcom/bytedance/android/livesdkapi/service/vs/IVSHistoryProgressService;", "()V", "getFirstShowTime", "", "any", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "getLocalPlayProgress", "episodeId", "getServerPlayProgress", "Lio/reactivex/Observable;", "leave", "", "leaveLocation", "saveFirstShowProgressToLocal", "roomId", "duration", "hasClickLatest", "", "saveProgressToLocal", "saveProgressToServer", "synPlayHistory", "seasonId", "seq", "", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSHistoryProgressServiceImp implements IVSHistoryProgressService {
    public VSHistoryProgressServiceImp() {
    }

    public Long getFirstShowTime(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "any");
        if ((r3 instanceof DataCenter) == false) goto L14;
        IVSPlayerService r0 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r0 == null) goto L15;
        DataCenter r4 = (DataCenter) r3;
        IPlayerProgressService r1 = r0.provideVSProgressService(r4);
        if (r1 == null) goto L16;
        PlayerProgressServiceContext r5 = r1.provideContext(r4);
        if (r5 == null) goto L17;
        m r6 = r5.getCurrentTime();
        if (r6 != null) goto L13;
        return null;
    L13:
        return (Long) r6.getValue();
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    public long getLocalPlayProgress(long r7) {
        int r0 = g.a;
        b0 r8 = (b0) new Gson().fromJson(a.b().getSharedPreferences("live_vs_sp_play_progress_cache", 0).getString(String.valueOf(r7), ""), b0.class);     // Catch: Exception -> L7
        if (r8 != null) goto L9;
        r8 = new b0(0, 0);     // Catch: Exception -> L7
    L9:
        return r8.a;
    L7:
        r8 = new b0(0, 0);
        goto L9
    }

    public Observable<Long> getServerPlayProgress(long r3) {
        int r0 = g.a;
        Observable<ListResponse<Episode>> r4 = ((ProgressApi) c.b().e(ProgressApi.class)).getProgress(Long.valueOf(r3));
        if (r4 == null) goto L7;
        Observable r5 = r4.doOnError(rp1.a.a);
        if (r5 == null) goto L7;
        return r5.map(b.a);
    L7:
        return null;
    }

    public void leave(long r5, long r7) {
        int r0 = g.a;
        HashMap<String, String> r1 = new HashMap();
        Observable<Response<Object>> r6 = ((ProgressApi) c.b().e(ProgressApi.class)).leave(Long.valueOf(r5), Long.valueOf(r7 / ((long) BubbleId.PadCast)), r1);
        if (r6 == null) goto L6;
        r6.subscribe(rp1.c.a, d.a);
        return;
    }

    public void saveProgressToLocal(long r5, long r7) {
        int r0 = g.a;
        SharedPreferences.Editor r1 = a.b().getSharedPreferences("live_vs_sp_play_progress_cache", 0).edit();
        r1.putString(String.valueOf(r5), GsonProtectorUtils.toJson(new Gson(), new b0(r7, System.currentTimeMillis())));     // Catch: JSONException -> L5
    L7:
        r1.apply();
        return;
    L5:
        e = move-exception;
        ALogger.e("VSVideoProgressUtil", "save local progress failed " + e);
        goto L7
    }

    public void saveProgressToServer(long r5, long r7) {
        int r0 = g.a;
        HashMap<String, String> r1 = new HashMap();
        Observable<Response<Object>> r6 = ((ProgressApi) c.b().e(ProgressApi.class)).ping(Long.valueOf(r5), Long.valueOf(r7 / ((long) BubbleId.PadCast)), r1);
        if (r6 == null) goto L6;
        r6.subscribe(e.a, f.a);
        return;
    }

    public void saveFirstShowProgressToLocal(long r9, long r11, boolean r13) {
        Map r0 = (Map) com.bytedance.android.livesdk.sharedpref.b.o2.getValue();
        FirstShowLocalProgress r1 = (FirstShowLocalProgress) new Gson().fromJson((String) r0.get(String.valueOf(r9)), FirstShowLocalProgress.class);     // Catch: Exception -> L5
    L6:
        if (r1 != null) goto L8;
    L10:
        if (r1 == null) goto L12;
        r0.put(String.valueOf(r9), GsonProtectorUtils.toJson(new Gson(), new FirstShowLocalProgress(r11, r1.getClickLatest(), System.currentTimeMillis())));
    L13:
        Iterator r10 = r0.entrySet().iterator();
    L15:
        if (r10.hasNext() == false) goto L22;
        FirstShowLocalProgress r12 = (FirstShowLocalProgress) new Gson().fromJson((String) ((Map.Entry) r10.next()).getValue(), FirstShowLocalProgress.class);     // Catch: Exception -> L18
    L20:
        if ((System.currentTimeMillis() - r12.getTs()) <= ((Number) com.bytedance.android.livesdk.sharedpref.b.q2.getValue()).longValue()) goto L15;
        r10.remove();
    L18:
        r12 = new FirstShowLocalProgress(0, false, 0);
        goto L20
    L22:
        com.bytedance.android.livesdk.sharedpref.e r14 = com.bytedance.android.livesdk.sharedpref.b.o2;
        r14.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r14, r0);
        return;
    L12:
        r0.put(String.valueOf(r9), GsonProtectorUtils.toJson(new Gson(), new FirstShowLocalProgress(r11, r13, System.currentTimeMillis())));
        goto L13
    L8:
        if (r11 >= 0) goto L10;
        r0.put(String.valueOf(r9), GsonProtectorUtils.toJson(new Gson(), new FirstShowLocalProgress(r1.getDuration(), r13, r1.getTs())));
    L5:
        r1 = new FirstShowLocalProgress(0, false, 0);
        goto L6
    }

    public Observable<Object> synPlayHistory(long r3, long r5, int r7) {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a == true) goto L5;
        return null;
    L5:
        return ((ProgressApi) c.b().e(ProgressApi.class)).synPlayHistory(String.valueOf(r3), String.valueOf(r5), r7);
    }
}
