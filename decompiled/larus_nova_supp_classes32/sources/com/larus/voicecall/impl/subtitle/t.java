package com.larus.voicecall.impl.subtitle;

import com.larus.audio.call.subtitle.DisplayType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.platform.service.z2;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t implements u1 {
    public final /* synthetic */ RealtimeCallSubtitleLayout a;

    public t(RealtimeCallSubtitleLayout r1) {
        this.a = r1;
    }

    @Override // com.larus.voicecall.impl.subtitle.u1
    public final void b(CustomMarkdownTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        RealtimeCallSubtitleLayout.T5(this.a, r2);
        this.a.j = "double_click_text";
    }

    @Override // com.larus.voicecall.impl.subtitle.u1
    public final void a(CustomMarkdownTextView r5, c r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.DATA_KEY);
        DisplayType r0 = r6.c;
        if (r0 == DisplayType.REPLY_TXT) goto L7;
        if (r0 == DisplayType.REPLY_BLOCK) goto L7;
    L17:
        RealtimeCallSubtitleLayout.T5(this.a, r5);
        this.a.j = "long_press_answer";
        return;
    L7:
        if (z2.a.audioFeedbackSwitch().getRealtimeCallLongPressReplyMessageEnable() == false) goto L17;
        RealtimeCallSubtitleLayout r1 = this.a;
        e3a.b r2 = r1.f;
        boolean r3 = false;
        if (r2 != null) goto L11;
    L13:
        if (r3 == false) goto L17;
        Function2<CustomMarkdownTextView, c, Unit> r4 = r1.getSubtitleLongClickListener();
        if (r4 == null) goto L19;
        r4.invoke(r5, r6);
        return;
    L19:
        return;
    L11:
        if (((h88.b) r2).d != true) goto L13;
        r3 = true;
        goto L13
    }
}
