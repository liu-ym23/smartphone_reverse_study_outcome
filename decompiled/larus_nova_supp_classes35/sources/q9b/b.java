package q9b;

import android.os.Bundle;
import android.view.View;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.ss.android.lark.chat.api.chatpreview.BasicChatInfo;
import com.ss.android.lark.chat.api.chatpreview.ChatId;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.impl.group.ContactsMyGroupAdapter;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ AvatarItemView a;
    public final /* synthetic */ Chat b;
    public final /* synthetic */ ContactsMyGroupAdapter c;

    public b(AvatarItemView r1, Chat r2, ContactsMyGroupAdapter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        y1b.a r16 = (y1b.a) PluginServiceLoader.loadFirstOrNull(y1b.a.class);
        if (r16 == null) goto L16;
        this.a.getContext();
        Chat r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        ChatId.ID r3 = new ChatId.ID(r0.getId());
        String r4 = r0.getName();
        String r5 = r0.getAvatarKey();
        if (r0.getChatMode() != Chat.ChatMode.THREAD_V2) goto L7;
    L10:
        boolean r6 = true;
    L11:
        new BasicChatInfo(r3, r4, r5, r6, r0.isP2PChat(), r0.getP2pChatterId(), null, r0.isSecret(), false, 256, null);
        Bundle r1 = this.c.f;
        if (r1 == null) goto L14;
        r1.getString("key_scene", BuildConfig.FLAVOR);
    L14:
        r16.a();
        return;
    L7:
        if (r0.getChatMode() == Chat.ChatMode.THREAD) goto L10;
        r6 = false;
        goto L11
    }
}
