package com.larus.bmhome.bot;

import com.larus.bmhome.bot.dialog.BotNickNameEditDialog;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g5 implements BotNickNameEditDialog.c {
    public final /* synthetic */ CommonSettingFragment a;
    public final /* synthetic */ com.larus.bmhome.setting.c b;

    @Override // com.larus.bmhome.bot.dialog.BotNickNameEditDialog.c
    public final void onCancel() {
    }

    public g5(CommonSettingFragment r1, com.larus.bmhome.setting.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.bmhome.bot.dialog.BotNickNameEditDialog.c
    public final void a(String r71, String r72) {
        Intrinsics.checkNotNullParameter(r71, "nickName");
        Intrinsics.checkNotNullParameter(r72, "firstMessage");
        CommonSettingFragment r15 = this.a;
        if (r15.s != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L5:
        BotModel r2 = this.a.s;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r42 = null;
    L9:
        r15.rb0(BotModel.copy$default(r42, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, r71, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2147483519, null));
        ItemTextArrow r1 = this.b.x0();
        if (r1 == null) goto L12;
        int r3 = ItemTextArrow.k;
        r1.Z5(r71, null);
    L12:
        this.a.getClass();
        return;
    L8:
        r42 = r2;
        goto L9
    }
}
