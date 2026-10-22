package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableKt;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/bean/UserGroupBean;", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/BaseAtBean;", "userGroup", "Lcom/ss/android/lark/dto/usergroup/UserGroupEntity;", "<init>", "(Lcom/ss/android/lark/dto/usergroup/UserGroupEntity;)V", "getUserGroup", "()Lcom/ss/android/lark/dto/usergroup/UserGroupEntity;", "getType", "", "getId", "", "getDisplayName", "getPinyin", "", "showAvatar", "", "context", "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "width", "height", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UserGroupBean extends BaseAtBean {
    private final UserGroupEntity userGroup;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return '0';
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 7;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return this.userGroup.getGroupName();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return this.userGroup.getGroupId();
    }

    public final UserGroupEntity getUserGroup() {
        return this.userGroup;
    }

    public UserGroupBean(UserGroupEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "userGroup");
        this.userGroup = r2;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r7, ImageView r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "imageView");
        r8.getLayoutParams().width = r9;
        r8.getLayoutParams().height = r10;
        if (UIHelper.getDimens(2131165373) == r9) goto L5;
        r8.setBackgroundResource(2131238255);
    L5:
        r8.setScaleType(ImageView.ScaleType.CENTER);
        Drawable r0 = UIHelper.getDrawable(2131255326);
        r0.setTint(UIHelper.getColor(2131102419));
        Intrinsics.checkNotNull(r0);
        r8.setImageBitmap(DrawableKt.toBitmap$default(r0, u0c.a.a(20), u0c.a.a(20), null, 4, null));
    }
}
