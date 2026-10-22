package com.larus.uaigc.chat.markdown.image.component;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoEditorComponent implements k {
    public final /* synthetic */ k a;

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final String K() {
        return this.a.K();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final String L() {
        return this.a.L();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final Fragment M() {
        return this.a.M();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final ChatPageContext N() {
        return this.a.N();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final boolean O() {
        return this.a.O();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final z0 P() {
        return this.a.P();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final BotModel a() {
        return this.a.a();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.k
    public final CoroutineScope getScope() {
        return this.a.getScope();
    }

    public VideoEditorComponent(k r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.a = r2;
    }

    public final void b(String r7) {
        BuildersKt.launch$default(getScope(), null, null, new VideoEditorComponent$goCreationIndependentPage$1(this, r7, null), 3, null);
    }
}
