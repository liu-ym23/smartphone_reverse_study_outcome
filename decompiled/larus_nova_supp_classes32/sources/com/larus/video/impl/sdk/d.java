package com.larus.video.impl.sdk;

import android.app.ActivityOptions;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.aweme.api.video.service.AwemeVideoFeedDelegate;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.btm.api.IBTMService;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.FlowRuntime;
import com.larus.network.HttpConst;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.VideoParam;
import com.larus.video.impl.VideoActivity;
import com.larus.video.impl.douyin.DouYinVideoActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ VideoParam b;
    public final /* synthetic */ ActivityOptions c;
    public final /* synthetic */ View d;

    public /* synthetic */ d(Context r1, String r2, VideoParam r3, ActivityOptions r4, View r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.video.impl.sdk.e] */
    public final Object invoke() {
        Context r0 = this.a;
        final VideoParam r1 = this.b;
        final ActivityOptions r2 = this.c;
        View r3 = this.d;
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L11;
        r4.P();
        Fragment r5 = ChatServiceImpl.a.f();
        if (r5 == null) goto L11;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r6 = s1a.a.g(r5).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r6 == null) goto L11;
        if (r6.Lo() != true) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        t19.s r8 = t19.s.a;
        Application r9 = FlowRuntime.a().getApplication();
        r8.getClass();
        t19.s.s(r9, 2131911054);
    L72:
        return Unit.INSTANCE;
    L14:
        ArrayList r10 = r1.a;
        String r11 = null;
        if (r10 == null) goto L17;
        MediaEntity r12 = (MediaEntity) CollectionsKt.getOrNull(r10, r1.h);
    L18:
        if (r12 == null) goto L25;
        Integer r13 = r12.getSource_from();
        int r14 = SourceFrom.Toutiao.value;
        if (r13 == null) goto L25;
        if (r13.intValue() != r14) goto L25;
        boolean r15 = true;
    L26:
        if (r15 == false) goto L37;
        String r16 = r12.getItem_id();
        if (r16 != null) goto L30;
    L33:
        boolean r17 = true;
    L34:
        if (r17 == true) goto L72;
        com.larus.platform.service.q r18 = com.larus.platform.service.q.a;
        StringBuilder r19 = new StringBuilder();
        HttpConst.a.getClass();
        r19.append(HttpConst.e0);
        r19.append(r12.getItem_id());
        r18.e(r0, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r19.toString())}), null);
        goto L72
    L30:
        if (r16.length() == 0) goto L33;
        r17 = false;
        goto L34
    L37:
        final Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = or9.a.a(r1.i);
        ?? r21 = new e(r20, r1, r2);
        String r22 = "douyin_default_player";
        if (r1.p != VideoParam.VideoPlayerType.VIDEO_ACTIVITY) goto L41;
        Intent r23 = new Intent(r0, VideoActivity.class);
    L63:
        com.larus.platform.service.o r24 = com.larus.platform.service.o.a;
        JSONObject r25 = new JSONObject();
        Iterator r26 = r1.l.entrySet().iterator();
    L65:
        if (r26.hasNext() == false) goto L67;
        Map.Entry r27 = (Map.Entry) r26.next();
        r25.put((String) r27.getKey(), r27.getValue());
        r25.put("style", r22);
        goto L65
    L67:
        Unit r28 = Unit.INSTANCE;
        r24.reportEvent("enter_video_player", r25);
        r21.invoke(r23);
        if (r2 != null) goto L70;
        r0.startActivity(r23);
        goto L72
    L70:
        r0.startActivity(r23, r2.toBundle());
        goto L72
    L41:
        if (AwemeVideoFeedDelegate.b.b() == false) goto L43;
    L48:
        Intent r29 = new Intent(r0, DouYinVideoActivity.class);
        if (r3 == null) goto L51;
        Object r30 = r3.getTag(2131364614);
    L53:
        if ((r30 instanceof String) == false) goto L55;
        String r31 = (String) r30;
    L56:
        IBTMService r32 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        Map r33 = MapsKt.mapOf(TuplesKt.to("doubao_message_id", r1.e));
        if (r3 == null) goto L60;
        if (r32 == null) goto L62;
        r11 = r32.d(r31, r33, r3);
    L62:
        r29.putExtra("source_btm_token", r11);
        r22 = "douyin_sdk_player";
        r23 = r29;
        goto L63
    L60:
        if (r32 == null) goto L62;
        r11 = r32.m(r31, r33, com.larus.utils.i.getActivity(r0));
        goto L62
    L55:
        r31 = null;
        goto L56
    L51:
        r30 = null;
        goto L53
    L43:
        if (r20.element == EnterVideoMethod.WELCOME_BACK_AWEME_VIDEO_CARD_LIST) goto L48;
        if (r1.p == VideoParam.VideoPlayerType.DOUYIN_VIDEO_ACTIVITY) goto L48;
        r23 = new Intent(r0, VideoActivity.class);
    L25:
        r15 = false;
        goto L26
    L17:
        r12 = null;
    L11:
        r7 = false;
        goto L12
    }
}
