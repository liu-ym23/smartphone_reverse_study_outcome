package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LabelAtBean extends BaseAtBean {
    private static final long serialVersionUID = -5399462310353446789L;
    private int bgColorResId;
    String label;
    String subLabel;
    private int textSize;
    private int verticalPadding;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 3;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r1, ImageView r2, int r3, int r4) {
    }

    public int getBgColorResId() {
        return this.bgColorResId;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return this.label;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return this.label;
    }

    public String getSubLabel() {
        return this.subLabel;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public int getVerticalPadding() {
        return this.verticalPadding;
    }

    public LabelAtBean(String r2) {
        this.textSize = 14;
        this.bgColorResId = 2131100545;
        this.verticalPadding = UIHelper.dp2px(9.0f);
        this.label = r2;
    }

    public void setBgColorResId(int r1) {
        this.bgColorResId = r1;
    }

    public void setTextSize(int r1) {
        this.textSize = r1;
    }

    public void setVerticalPadding(int r1) {
        this.verticalPadding = r1;
    }

    public LabelAtBean(String r2, String r3) {
        this.textSize = 14;
        this.bgColorResId = 2131100545;
        this.verticalPadding = UIHelper.dp2px(9.0f);
        this.label = r2;
        this.subLabel = r3;
    }
}
