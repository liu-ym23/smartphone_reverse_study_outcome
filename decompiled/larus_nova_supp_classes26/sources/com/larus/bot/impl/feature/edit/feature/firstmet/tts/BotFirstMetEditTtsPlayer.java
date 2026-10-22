package com.larus.bot.impl.feature.edit.feature.firstmet.tts;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import n68.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotFirstMetEditTtsPlayer {
    public a a;
    public final x1 b;
    public Message c;
    public WeakReference<LifecycleOwner> d;

    public BotFirstMetEditTtsPlayer() {
        this.b = RepoDispatcherDelegate.b.e().x1().a();
    }

    public final void a(String r8, SpeakerVoice r9) {
        Intrinsics.checkNotNullParameter(r8, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r9, "speakerVoice");
        WeakReference<LifecycleOwner> r0 = this.d;
        if (r0 == null) goto L10;
        LifecycleOwner r1 = r0.get();
        if (r1 == null) goto L11;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r1);
        if (r2 == null) goto L12;
        BuildersKt.launch$default(r2, RepoDispatcherDelegate.b.g(), null, new BotFirstMetEditTtsPlayer$readText$1(this, r8, r9, null), 2, null);
        return;
    L12:
        return;
    L11:
        return;
    }
}
