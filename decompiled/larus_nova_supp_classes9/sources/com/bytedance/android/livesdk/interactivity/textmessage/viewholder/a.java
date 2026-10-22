package com.bytedance.android.livesdk.interactivity.textmessage.viewholder;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l;
import com.bytedance.android.livesdk.interactivity.textmessage.model.AudioChatTextMessage;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.j;
import kotlin.jvm.internal.Intrinsics;
import tb2.g;
import u22.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements l {
    public final /* synthetic */ AudioTextMessageViewHolderV2 a;

    public a(AudioTextMessageViewHolderV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        AudioChatTextMessage r3 = (AudioChatTextMessage) this.a.c.invoke();
        if (r3 == null) goto L6;
        r3.E(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
    public final boolean b(View r8, tb2.b r9, ClickableSpan r10) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "action");
        Intrinsics.checkNotNullParameter(r10, "span");
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.textmessage.render.a) == false) goto L9;
        AudioChatTextMessage r11 = (AudioChatTextMessage) this.a.c.invoke();
        if (r11 == null) goto L7;
        f72.a.b("Audio Message Click");
        xs2.b.a().post(new d(r11.b.getAudioUrl(), r11.b.getAudioPath(), r11.b.getAudioDuration(), r11.b.getContent()));
        r11.J("business");
    L7:
        return true;
    L9:
        if ((r9 instanceof g) == false) goto L17;
        AudioChatTextMessage r13 = (AudioChatTextMessage) this.a.c.invoke();
        if (r13 == null) goto L16;
        IBaseUser r14 = ((g) r9).getUser();
        if (r14 == null) goto L16;
        UserProfileEvent r0 = new UserProfileEvent(r14);
        r0.setClickUserPosition("audio_chat_message");
        r0.setExtraFollowParams(j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        xs2.b.a().post(r0);
        r13.J("text_user");
    L16:
        return true;
    L17:
        return false;
    }
}
