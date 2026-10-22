package com.bytedance.android.live.liveinteract.voicechat.stage;

import com.bytedance.android.anniex.container.util.i;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.b;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import pn0.f;
import tf0.j;
import tf0.o;
import vm2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/stage/AudioChatStageWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioChatStageWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public final CompositeDisposable a;
    public AudioChatStageContext b;

    public static final class a {
    }

    static {
    }

    public AudioChatStageWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = d.a(AudioChatStageWidget$initDataContext$pair$1.INSTANCE);
        AudioChatStageContext r1 = (AudioChatStageContext) r0.getFirst();
        r1.getService().d(this);
        b.a(r1, mj0.a.class);
        this.b = r1;
        this.a.add((Disposable) r0.getSecond());
        ((Widget) this).dataCenter.observe("data_audio_chat_stage_is_insert", this);
        ((Widget) this).dataCenter.observe("data_enlarge_stage_bottom_pos", this);
        DataCenter r2 = ((Widget) this).dataCenter;
        Boolean r3 = Boolean.TRUE;
        r2.put("cmd_audio_chat_stage_widget_init", r3);
        DataCenter r4 = ((Widget) this).dataCenter;
        Boolean r5 = Boolean.FALSE;
        if (((Boolean) r4.get("data_feed_audio_chat_stage_showing", r5)).booleanValue() == false) goto L11;
        AudioChatStageContext r6 = this.b;
        if (r6 == null) goto L9;
        m<Boolean> r7 = r6.isStageShowing();
        if (r7 == null) goto L9;
        r7.setValue(r3);
    L9:
        ((Widget) this).dataCenter.put("data_feed_audio_chat_stage_showing", r5);
    L11:
        if (c.b().getStageIsInsertStatusBugfix() == false) goto L20;
        Boolean r8 = (Boolean) ((Widget) this).dataCenter.get("data_audio_chat_stage_is_insert", r5);
        int r9 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        com.bytedance.android.live.liveinteract.voicechat.stage.a.e("AudioChatStageWidget#onCreate", "stageIsInsert=" + r8);
        if (r8.booleanValue() == false) goto L21;
        AudioChatStageContext r10 = this.b;
        if (r10 == null) goto L22;
        m<Boolean> r11 = r10.isStageShowing();
        if (r11 == null) goto L23;
        r11.setValue(r3);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        ((Widget) this).dataCenter.removeObserver(this);
        this.a.clear();
    }

    public final void onChanged(Object r8) {
        KVData r9 = (KVData) r8;
        if (isViewValid() == false) goto L82;
        if (r9 == null) goto L83;
        Object r0 = r9.getData();
        f r2 = null;
        if ((r0 instanceof Object) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L89;
        String r1 = r9.getKey();
        int r3 = r1.hashCode();
        boolean r4 = false;
        if (r3 == (-800003709)) goto L26;
        if (r3 == (-320311548)) goto L16;
        return;
    L16:
        if (r1.equals("data_audio_chat_stage_is_insert") == false) goto L84;
        int r5 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        com.bytedance.android.live.liveinteract.voicechat.stage.a.e("audioChatStageInsertUpdate", "stageIsInsert=" + ((Boolean) r9.getData()));
        AudioChatStageContext r6 = this.b;
        if (r6 == null) goto L85;
        m<Boolean> r7 = r6.isStageShowing();
        if (r7 == null) goto L86;
        Boolean r10 = (Boolean) r9.getData();
        if (r10 == null) goto L24;
        r4 = r10.booleanValue();
    L24:
        r7.setValue(Boolean.valueOf(r4));
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L26:
        if (r1.equals("data_enlarge_stage_bottom_pos") == false) goto L88;
        Integer r11 = (Integer) r9.getData();
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r12 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r12 == null) goto L31;
        o r13 = r12.commonWindowManager();
        if (r13 == null) goto L31;
    L35:
        if (r13 == null) goto L37;
        j r14 = r13.E();
    L39:
        if ((r14 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == true) goto L41;
        r14 = null;
    L41:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r15 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m) r14;
        if (r15 == null) goto L44;
        r2 = r15.d;
    L44:
        if (r2 == null) goto L48;
        f.b r16 = r2.c;
        if (r16 == null) goto L48;
        int r17 = r16.b;
    L49:
        if (r2 == null) goto L55;
        List<f.c> r18 = r2.d;
        if (r18 == null) goto L55;
        f.c r19 = (f.c) ListProtector.get(r18, 0);
        if (r19 == null) goto L55;
        int r20 = r19.d;
    L56:
        if (r2 == null) goto L62;
        List<f.c> r21 = r2.d;
        if (r21 == null) goto L62;
        f.c r22 = (f.c) ListProtector.get(r21, 0);
        if (r22 == null) goto L62;
        int r23 = r22.f;
    L63:
        int r24 = (r17 + r20) + r23;
        i r25 = i.a;
        int r26 = (r24 + r25.a(30.0f)) + r25.a(62.0f);
        int r27 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        com.bytedance.android.live.liveinteract.voicechat.stage.a.e("audioChatStageInsertUpdate", "enlargeStageBottomPos=" + r11 + ", firstRegionBottomPos=" + r26);
        if (r11 != null) goto L67;
    L68:
        InteractionWidgetsPosContext r28 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r28 == null) goto L80;
        m r29 = r28.getAudioTalkBottomPos();
        if (r29 == null) goto L80;
        if (r11 == null) goto L74;
        r26 = r11.intValue();
    L74:
        r29.setValue(Integer.valueOf(r26));
    L80:
        ((Widget) this).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
        return;
    L67:
        if (r11.intValue() != 0) goto L68;
        InteractionWidgetsPosContext r30 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r30 == null) goto L80;
        m r31 = r30.getAudioTalkBottomPos();
        if (r31 == null) goto L80;
        r31.setValue(Integer.valueOf(r26));
    L62:
        r23 = 0;
    L55:
        r20 = 0;
    L48:
        r17 = 0;
        goto L49
    L37:
        r14 = null;
    L31:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r32 = IVoiceChatGuestService.a.a();
        if (r32 == null) goto L34;
        r13 = r32.commonWindowManager();
        goto L35
    L34:
        r13 = null;
        goto L35
    L88:
        return;
    L89:
        return;
    L83:
        return;
    }
}
