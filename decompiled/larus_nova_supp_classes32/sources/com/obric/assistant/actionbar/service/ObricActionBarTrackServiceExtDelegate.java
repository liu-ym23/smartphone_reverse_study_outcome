package com.obric.assistant.actionbar.service;

import android.view.View;
import android.widget.TextView;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.im.bean.message.ReferenceInfo;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.actionbar.IObricActionBarTrackService;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qha.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001JF\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0096\u0001¢\u0006\u0002\u0010\u001fJ\u0019\u0010\u001c\u001a\u00020\u00122\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0096\u0001J\u001f\u0010\u001c\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010#\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J)\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J!\u0010(\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J!\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\u0019\u0010+\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J!\u0010,\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J2\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u000e2\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u000203H\u0096\u0001¢\u0006\u0002\u00104J1\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00052\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010:H\u0096\u0001J\u0011\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\nH\u0096\u0001J\u001b\u0010=\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020?H\u0096\u0001¨\u0006@"}, d2 = {"Lcom/obric/assistant/actionbar/service/ObricActionBarTrackServiceExtDelegate;", "Lcom/obric/assistant/actionbar/service/IObricActionBarTrackServiceExt;", "<init>", "()V", "getCurrentModelLevel", NameKeys.UnloadStrategy_No_Strategy, "getObricMockClickActionBarKey", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "isAssistantActionBar", NameKeys.UnloadStrategy_No_Strategy, "actionBarKey", "mapToActionBarV2Option", "itemId", NameKeys.UnloadStrategy_No_Strategy, "mapToObricActionBarTrackType", "Lcom/obric/trace/ObricActionBarTrackType;", "mobChatActionBarClick", NameKeys.UnloadStrategy_No_Strategy, "clickV2Option", "traceType", "customActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "botId", "conversationId", NameKeys.UnloadStrategy_No_Strategy, "clickPosition", "(Ljava/lang/String;Lcom/obric/trace/ObricActionBarTrackType;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/String;JLjava/lang/Integer;)V", "mobChatActionBarShow", "actionBarKeyList", NameKeys.UnloadStrategy_No_Strategy, "([Ljava/lang/String;)V", "actionBarList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/view/actionbar/custom/ObricBaseSegment;", "position", "mobObricActionBarBoardClick", "currentActionBar", "mobObricActionBarBoardLeave", "leaveMethod", "mobObricActionBarBoardShow", "mobObricActionBarLv3BoardClick", "clickV3Option", "mobObricActionBarLv3BoardShow", "mobObricActionPanelShow", "onObricActionBarInstructionShow", "tag", "Landroid/widget/TextView;", "status", "displayText", "itemView", "Landroid/view/View;", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;Landroid/view/View;)V", "onObricVoiceAuthenAsrUpdate", "lifeState", "Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", "taskId", "extraMap", NameKeys.UnloadStrategy_No_Strategy, "setIsClickModeChangeButton", "isClickModeChangeButton", "setObricVoiceAuthenParams", "json", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarTrackServiceExtDelegate implements IObricActionBarTrackServiceExt {
    public static final ObricActionBarTrackServiceExtDelegate b = null;
    public final /* synthetic */ IObricActionBarTrackServiceExt a;

    static {
        b = new ObricActionBarTrackServiceExtDelegate();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final boolean a(String r2) {
        return this.a.a(r2);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void b(List<? extends e> r2) {
        this.a.b(r2);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final String c(int r2) {
        return this.a.c(r2);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void d(String r3) {
        Intrinsics.checkNotNullParameter("obric_omni", "currentActionBar");
        this.a.d(r3);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void e() {
        this.a.e();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void f(String r10, ObricActionBarTrackType r11, z0 r12, String r13, long r14, Integer r16) {
        Intrinsics.checkNotNullParameter(r12, "customActionBarItem");
        this.a.f(r10, r11, r12, r13, r14, r16);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void g(z0 r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "customActionBarItem");
        Intrinsics.checkNotNullParameter(r3, "botId");
        this.a.g(r2, r3, r4);
    }

    public final String h() {
        return this.a.h();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void i(String r3, long r4) {
        Intrinsics.checkNotNullParameter("oauto_scheduled", "clickV3Option");
        Intrinsics.checkNotNullParameter(r3, "botId");
        this.a.i(r3, r4);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void j(List<z0> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "actionBarList");
        this.a.j(r2, r3);
    }

    public final void k(TextView r2, Integer r3, String r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r5, "itemView");
        this.a.k(r2, r3, r4, r5);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void l(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.l(r2, r3);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void m(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "actionBarKeyList");
        this.a.m(r2);
    }

    public final void n(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        this.a.n(r2, r3);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void o(ObricActionBarTrackType r2) {
        Intrinsics.checkNotNullParameter(r2, "traceType");
        this.a.o(r2);
    }

    public final String p() {
        return this.a.p();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void q(String r8, z0 r9, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, "leaveMethod");
        Intrinsics.checkNotNullParameter(r9, "customActionBarItem");
        Intrinsics.checkNotNullParameter(r10, "botId");
        this.a.q(r8, r9, r10, r11);
    }

    public final ReferenceInfo r() {
        return this.a.r();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void s(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "currentActionBar");
        Intrinsics.checkNotNullParameter(r3, "botId");
        this.a.s(r2, r3, r4);
    }

    public final void t(AsrLifeState r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "lifeState");
        this.a.t(r2, r3, r4);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final ObricActionBarTrackType u(int r2) {
        return this.a.u(r2);
    }

    private ObricActionBarTrackServiceExtDelegate() {
        Object r0 = ServiceManager.get().getService(IObricActionBarTrackService.class);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt");
        this.a = (IObricActionBarTrackServiceExt) r0;
    }
}
