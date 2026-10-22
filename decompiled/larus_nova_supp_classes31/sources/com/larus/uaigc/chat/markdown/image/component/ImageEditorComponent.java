package com.larus.uaigc.chat.markdown.image.component;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImageEditorComponent implements a {
    public final /* synthetic */ a a;

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final String K() {
        return this.a.K();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final String L() {
        return this.a.L();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final Fragment M() {
        return this.a.M();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final ChatPageContext N() {
        return this.a.N();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final boolean O() {
        return this.a.O();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final z0 P() {
        return this.a.P();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final BotModel a() {
        return this.a.a();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.a
    public final CoroutineScope getScope() {
        return this.a.getScope();
    }

    public ImageEditorComponent(a r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.a = r2;
    }

    public final void b(String r7, String r8) {
        BuildersKt.launch$default(getScope(), null, null, new ImageEditorComponent$goCreationIndependentPage$1(this, r7, r8, null), 3, null);
    }
}
