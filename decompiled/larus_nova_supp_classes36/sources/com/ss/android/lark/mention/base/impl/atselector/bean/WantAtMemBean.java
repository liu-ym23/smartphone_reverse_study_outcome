package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class WantAtMemBean extends BaseAtBean {
    private static final long serialVersionUID = -6615256247996487612L;
    a chatterInfo;
    String guessType;
    String searchLocation;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 2;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return this.chatterInfo.c;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return this.chatterInfo.a;
    }

    public a getChatterInfo() {
        return this.chatterInfo;
    }

    public String getGuessType() {
        return this.guessType;
    }

    public String getSearchLocation() {
        return this.searchLocation;
    }

    public WantAtMemBean(a r2) {
        this.guessType = "";
        this.searchLocation = "";
        this.chatterInfo = r2;
    }

    public void setGuessType(String r1) {
        this.guessType = r1;
    }

    public void setSearchLocation(String r1) {
        this.searchLocation = r1;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r4, ImageView r5, int r6, int r7) {
        if (this.chatterInfo.b() == false) goto L5;
        r5.setImageDrawable(UIUtils.getDrawable(r4, 2131255192));
        return;
    L5:
        a r0 = this.chatterInfo;
        String r1 = r0.b;
        String r2 = r0.a;
        LoadParams r3 = new LoadParams();
        r3.a = r6;
        r3.b = r7;
        ImageModule.a(r4, r5, r1, r2, r3);
    }
}
