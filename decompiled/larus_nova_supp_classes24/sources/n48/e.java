package n48;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import by7.f;
import com.bytedance.awemeopen.infra.support.AoThrowableResult;
import com.ixigua.lib.track.TrackParams;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larus.api.serviceimpl.AoSharePanelServiceImpl;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.video.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ JSONObject f;
    public final /* synthetic */ AoSharePanelServiceImpl g;

    public /* synthetic */ e(Activity r1, String r2, String r3, String r4, String r5, JSONObject r6, AoSharePanelServiceImpl r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r115) {
        FragmentActivity r1 = this.a;
        String r5 = this.b;
        String r6 = this.c;
        String r10 = this.d;
        String r11 = this.e;
        JSONObject r12 = this.f;
        AoSharePanelServiceImpl r9 = this.g;
        AoThrowableResult r2 = (AoThrowableResult) r115;
        int r3 = AoSharePanelServiceImpl.a;
        Intrinsics.checkNotNullParameter(r2, "$this$getShortLinkShare");
        if (((Boolean) r2.b.getValue()).booleanValue() == false) goto L5;
        Object r4 = r2.a;
    L6:
        String r8 = (String) r4;
        FLogger.a.i("AoSharePanelServiceImpl", "getShortLinkShare: " + r8);
        f r14 = new f();
        r14.a.put("current_page", "sdk_video");
        TrackParams r7 = r14.a;
        if (r12 == null) goto L9;
        String r13 = r12.optString("host_chat_type");
    L10:
        r7.put("chat_type", r13);
        IShareService r30 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r30 == null) goto L30;
        if ((r1 instanceof FragmentActivity) == false) goto L15;
        FragmentActivity r15 = r1;
    L16:
        ShareScene r31 = ShareScene.SDK_VIDEO;
        com.larus.bmhome.share.panel.b r32 = new com.larus.bmhome.share.panel.b(null, null, r5, r6, null, null, null, r10, r11, null, null, null, null, r8, null, null, false, false, null, null, false, false, null, false, null, null, 67100275);
        if (r12 == null) goto L27;
        r9.getClass();
        AoSharePanelServiceImpl.E2("host_slidemode", "slidemode", r12);
        AoSharePanelServiceImpl.E2("host_card_position", "card_position", r12);
        AoSharePanelServiceImpl.E2("host_card_sub_position", "card_sub_position", r12);
        AoSharePanelServiceImpl.E2("host_req_id", "search_id", r12);
        AoSharePanelServiceImpl.E2("host_reply_id", "reply_id", r12);
        AoSharePanelServiceImpl.E2("host_section_id", "section_id", r12);
        AoSharePanelServiceImpl.E2("host_bot_id", "bot_id", r12);
        AoSharePanelServiceImpl.E2("host_agent_id", "agent_id", r12);
        AoSharePanelServiceImpl.E2("host_message_id", "message_id", r12);
        AoSharePanelServiceImpl.E2("host_chat_type", "chat_type", r12);
        AoSharePanelServiceImpl.E2("host_rich_media_type", "rich_media_type", r12);
        AoSharePanelServiceImpl.E2("host_module_source", "module_source", r12);
        AoSharePanelServiceImpl.E2("host_module_position", "module_position", r12);
        AoSharePanelServiceImpl.E2("host_last_message_id", "last_message_id", r12);
        AoSharePanelServiceImpl.E2("host_enter_from_group_id", "enter_from_group_id", r12);
        AoSharePanelServiceImpl.E2("host_impr_index", "impr_index", r12);
        AoSharePanelServiceImpl.E2("host_rank", "rank", r12);
        AoSharePanelServiceImpl.E2("host_doc_id", "doc_id", r12);
        AoSharePanelServiceImpl.E2("host_chat_id", "chat_id", r12);
        AoSharePanelServiceImpl.E2("host_card_id", CardActionService.CARD_ID, r12);
        AoSharePanelServiceImpl.E2("host_agent_mode", "agent_mode", r12);
        AoSharePanelServiceImpl.E2("host_card_source", "card_source", r12);
        AoSharePanelServiceImpl.E2("host_card_group_id", "card_group_id", r12);
        String r16 = r12.optString("group_id");
        r12.put("video_id", r16);
        r12.put("is_inner_video", String.valueOf(!Intrinsics.areEqual(r16, r12.optString("enter_from_group_id")) ? 1 : 0));
        String r17 = r12.optString("host_incoming_video_ids");
        Intrinsics.checkNotNull(r16);
        if (StringsKt.contains$default(r17, r16, false, 2, null) == false) goto L21;
        String r19 = "414";
    L22:
        r12.put("channel_id", r19);
        String r20 = r12.optString("host_recommend_type");
        Map r21 = com.larus.bmhome.video.e.a;
        Intrinsics.checkNotNull(r20);
        g r22 = com.larus.bmhome.video.e.e(r20, r16);
        if (r22 == null) goto L25;
        String r110 = r22.c;
    L26:
        r12.put("req_id", r110);
        Unit r23 = Unit.INSTANCE;
        JSONObject r47 = r12;
    L28:
        IShareService.a.g(r30, r15, r31, r32, new h(null, null, null, null, null, null, null, r47, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -257, -1, 1023), null, r14, false, 208);
        goto L30
    L25:
        r110 = null;
        goto L26
    L21:
        r19 = "416";
        goto L22
    L27:
        r47 = null;
        goto L28
    L15:
        r15 = null;
    L30:
        return Unit.INSTANCE;
    L9:
        r13 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
