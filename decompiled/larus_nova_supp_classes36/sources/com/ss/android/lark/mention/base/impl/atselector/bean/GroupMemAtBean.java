package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class GroupMemAtBean extends BaseAtBean implements Comparable<GroupMemAtBean> {
    private static final long serialVersionUID = -4450297628440362719L;
    a chatterInfo;
    private boolean hideDivider;
    private char letter;
    private boolean showShadow;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 0;
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

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return this.letter;
    }

    public boolean isHideDivider() {
        return this.hideDivider;
    }

    public boolean isShowShadow() {
        return this.showShadow;
    }

    public GroupMemAtBean(a r1) {
        this.chatterInfo = r1;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(GroupMemAtBean r2) {
        return this.chatterInfo.a(r2.chatterInfo);
    }

    public void setChatterInfo(a r1) {
        this.chatterInfo = r1;
    }

    public void setHideDivider(boolean r1) {
        this.hideDivider = r1;
    }

    public void setLetter(char r1) {
        this.letter = r1;
    }

    public void showShadow(boolean r1) {
        this.showShadow = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(GroupMemAtBean r1) {
        return compareTo2(r1);
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
