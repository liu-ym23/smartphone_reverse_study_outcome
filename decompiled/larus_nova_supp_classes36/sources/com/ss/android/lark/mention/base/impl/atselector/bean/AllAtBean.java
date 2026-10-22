package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.o;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AllAtBean extends BaseAtBean {
    private static final long serialVersionUID = -8614341601803028028L;
    public int allSize;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 1;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        if (this.allSize <= 0) goto L6;
        return UIHelper.getString(2131891514) + "(" + this.allSize + ")";
    L6:
        return UIHelper.getString(2131891514);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        Pattern r0 = o.a;
        return "all";
    }

    public AllAtBean(int r1) {
        this.allSize = r1;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r1, ImageView r2, int r3, int r4) {
        r2.getLayoutParams().width = r3;
        r2.getLayoutParams().height = r4;
        r2.setImageResource(2131231736);
    }
}
