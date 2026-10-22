package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.pb.search.v2.ExplanationTag;
import com.bytedance.lark.pb.search.v2.MailContactMeta;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.f;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.picker.base.utils.UiUtil;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz7.a;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/MailContactBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "bindTag", "", "position", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "needBindDynamicTag", "", "bindAvatar", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MailContactBinder extends CommonBinder<SearchBaseInfo> {
    private final Context mContext;
    private final g mOnItemClickHandler;

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public boolean needBindDynamicTag() {
        return false;
    }

    public MailContactBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void bindAvatar(ChatterChatViewHolder r5, SearchBaseInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "data");
        if (TextUtils.isEmpty(r6.getAvatarKey()) == true) goto L5;
        super.bindAvatar(r5, r6);
        return;
    L5:
        boolean r0 = r6 instanceof SearchMailContactInfo;
        if (r0 == true) goto L8;
    L10:
        if (r0 == true) goto L12;
    L14:
        Bitmap r7 = FakePickerAvatarCreator.createNameAvatarBitmap(UIUtils.dp2px(this.mContext, 100.0f), UIUtils.sp2px(this.mContext, 35.0f), StringsKt.take(r6.getTitle(), 2), ContextCompat.getColor(this.mContext, 2131105548), this.mContext);
        BitmapDrawable r1 = new BitmapDrawable(this.mContext.getResources(), r7);
        AvatarItemView r8 = r5.getAvatarItemView().getItem();
        a.a r9 = new a.a();
        r9.e(r1);
        r8.avatar(new a(r9));
        return;
    L12:
        if (((SearchMailContactInfo) r6).getContactType() != MailContactMeta.ContactType.SHARED_MAILBOX) goto L14;
        AvatarItemView r10 = r5.getAvatarItemView().getItem();
        a.a r11 = new a.a();
        r11.d(2131238065);
        r10.avatar(new a(r11));
        return;
    L8:
        if (((SearchMailContactInfo) r6).getContactType() != MailContactMeta.ContactType.MAIL_GROUP) goto L10;
        AvatarItemView r12 = r5.getAvatarItemView().getItem();
        a.a r13 = new a.a();
        r13.d(2131238003);
        r12.avatar(new a(r13));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void bindTag(int r5, ChatterChatViewHolder r6, SearchBaseInfo r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "data");
        LarkNameTag.e r8 = new LarkNameTag.e(this.mContext);
        List r9 = r7.getExplanationTags();
        if (r9 == null) goto L8;
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        ExplanationTag r0 = (ExplanationTag) r10.next();
        int r1 = f.g;
        f.a r2 = new f.a();
        UDTagsDrawable.TagColorSet r3 = UiUtil.Companion.getColorResByTagType(r0.tag_type);
        r2.b = 100;
        r2.d = r0.text;
        r2.e = r3.getTextColorRes();
        r2.g = r3.getBackgroundColorRes();
        r8.d(new f(r2), true);
    L8:
        r6.getAvatarItemView().getItem().setTag(r8);
    }
}
