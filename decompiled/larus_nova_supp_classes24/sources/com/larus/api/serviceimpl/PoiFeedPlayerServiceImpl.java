package com.larus.api.serviceimpl;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.locallife.poi.IPoiFeedPlayerService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.lark.kmp.server.pb.improto.Packet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.sdk.f;
import cy6.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0018"}, d2 = {"Lcom/larus/api/serviceimpl/PoiFeedPlayerServiceImpl;", "Lcom/bytedance/locallife/poi/IPoiFeedPlayerService;", "<init>", "()V", "openPoiFeedPage", "", "context", "Landroid/content/Context;", "token", "", "awemeListJson", "enterAwemeId", "poiId", "enterIndex", "", "hasMore", "", "startPositionMs", "", "poiTrackParamsJson", "parseAwemeListJson", "", "releaseToken", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PoiFeedPlayerServiceImpl implements IPoiFeedPlayerService {

    public static final class a {
    }

    static {
    }

    public PoiFeedPlayerServiceImpl() {
    }

    public final void a(Context r62, String r63, String r64, String r65, String r66, int r67, boolean r68, long r69, String r71) {
        Intrinsics.checkNotNullParameter(r63, "token");
        Intrinsics.checkNotNullParameter(r64, "awemeListJson");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        JSONArray r5 = new JSONArray(r64);     // Catch: Throwable -> L9
        IntRange r0 = RangesKt.until(0, r5.length());     // Catch: Throwable -> L9
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Throwable -> L9
        IntIterator r1 = r0.iterator();     // Catch: Throwable -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        r6.add(JSONArrayProtectorUtils.getJSONObject(r5, r1.nextInt()).toString());     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r2 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r2);
        if (r7 == null) goto L14;
        FLogger.a.e("PoiFeedPlayerServiceImpl", "parseAwemeListJson failed: " + r7.getMessage());
    L14:
        List r8 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r2) == false) goto L17;
        r2 = r8;
    L17:
        List r9 = (List) r2;
        if (r9.isEmpty() == false) goto L23;
        FLogger.a.e("PoiFeedPlayerServiceImpl", "openPoiFeedPage: awemeList empty or parse failed");
        cy6.a r3 = c.a(r63);
        if (r3 == null) goto L89;
        r3.release();
        return;
    L89:
        return;
    L23:
        int r10 = m2a.a.a;
        Intrinsics.checkNotNullParameter(r9, "awemeJsonList");
        ArrayList r11 = new ArrayList();
        Iterator r12 = r9.iterator();
    L24:
        Object r13 = null;
        if (r12.hasNext() == false) goto L42;
        String r14 = (String) r12.next();
        int r15 = m2a.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L29
        Object r17 = Result.constructor-impl(m2a.a.a(r14));     // Catch: Throwable -> L29
    L31:
        Throwable r19 = Result.exceptionOrNull-impl(r17);
        if (r19 == null) goto L35;
        FLogger.a.e("PoiAwemeModelConverter", "convert failed: " + r19.getMessage() + ", jsonLen=" + r14.length() + ", jsonPrefix=" + StringsKt.take(r14, Packet.DEFAULT_STATUS));
    L35:
        if (Result.isFailure-impl(r17) == true) goto L38;
        r13 = r17;
    L38:
        MediaEntity r20 = (MediaEntity) r13;
        if (r20 == null) goto L24;
        r11.add(r20);
    L29:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L42:
        if (r11.isEmpty() == false) goto L47;
        FLogger.a.e("PoiFeedPlayerServiceImpl", "openPoiFeedPage: convert failed, size=" + r9.size());
        cy6.a r21 = c.a(r63);
        if (r21 == null) goto L90;
        r21.release();
        return;
    L90:
        return;
    L47:
        if (r65 == null) goto L65;
        Iterator r22 = r11.iterator();
        int r23 = 0;
    L50:
        if (r22.hasNext() == false) goto L55;
        if (Intrinsics.areEqual(((MediaEntity) r22.next()).getItem_id(), r65) == true) goto L56;
        r23 = r23 + 1;
    L56:
        Integer r24 = Integer.valueOf(r23);
        if (r24.intValue() < 0) goto L59;
        boolean r25 = true;
    L60:
        if (r25 == true) goto L63;
        r24 = null;
    L63:
        if (r24 == null) goto L65;
        int r26 = r24.intValue();
    L66:
        int r111 = r26;
        ArrayList r27 = new ArrayList(r11);
        MediaEntityContainer r29 = new MediaEntityContainer(null, new ArrayList(r11), null, null, r68, 0, 0, null, 237, null);
        String r112 = EnterVideoMethod.POI_VIDEO_PAGE.getValue();
        VideoParam.RecommendType r30 = VideoParam.RecommendType.PoiFeed;
        Bundle r31 = new Bundle();
        r31.putString("key_poi_feed_provider_token", r63);
        r31.putString("key_poi_enter_aweme_id", r65);
        r31.putString("key_poi_id", r66);
        r31.putLong("key_start_play_position", RangesKt.coerceAtLeast(r69, 0));
        r31.putString("key_poi_track_params_json", r71);
        Unit r32 = Unit.INSTANCE;
        VideoParam r33 = new VideoParam(r27, r29, null, null, null, null, null, r111, r112, null, null, null, null, 0, 0, null, false, null, null, null, r30, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, r31, null, -1048964, 98303);
        if (r62 != null) goto L69;
        Context r34 = AppHost.a.a().getCurrentActivity();
    L70:
        if (r34 != null) goto L75;
        FLogger.a.e("PoiFeedPlayerServiceImpl", "openPoiFeedPage: no valid context, releasing token=" + r63);
        cy6.a r35 = c.a(r63);
        if (r35 == null) goto L91;
        r35.release();
        return;
    L91:
        return;
    L75:
        f.a.p(r34, null, r33);
        return;
    L69:
        r34 = r62;
        goto L70
    L59:
        r25 = false;
        goto L60
    L55:
        r23 = -1;
    L65:
        r26 = RangesKt.coerceIn(r67, 0, CollectionsKt.getLastIndex(r11));
    L9:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
