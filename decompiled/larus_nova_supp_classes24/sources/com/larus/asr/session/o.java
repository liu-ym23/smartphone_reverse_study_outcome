package com.larus.asr.session;

import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.im.bean.message.Message;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface o {
    void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r1);

    void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r1);

    com.larus.bmhome.chat.component.bottom.core.speaker.g J5();

    void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r1);

    void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r1);

    void clear();

    void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r1);

    void la(Function1<? super com.larus.audio.b, Boolean> r1, Function1<? super com.larus.audio.a, Boolean> r2, Function2<? super String, ? super byte[], Unit> r3, Function1<? super String, Boolean> r4);

    boolean m0();

    void ma(String r1, Message r2, boolean r3);

    void na(Function2<? super String, ? super Boolean, Unit> r1);

    @Deprecated(message = "不允许外部主动更新")
    void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r1);

    void onStop();

    void pa(String r1, boolean r2, boolean r3, com.larus.audio.asr.c0 r4, long r5, Long r7, Integer r8, d58.a r9);

    void qa(String r1, Message r2);

    void ra(Function2<? super String, ? super String, Boolean> r1);

    void sa(ChatBottomSpeakerComponent$f r1);
}
