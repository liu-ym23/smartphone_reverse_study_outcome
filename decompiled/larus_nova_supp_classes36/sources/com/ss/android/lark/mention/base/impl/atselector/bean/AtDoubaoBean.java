package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtDoubaoBean;", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/BaseAtBean;", "chatChatter", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtChatterInfo;", "<init>", "(Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtChatterInfo;)V", "getType", "", "getId", "", "getDisplayName", "getPinyin", "", "showAvatar", "", "context", "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "width", "height", "Companion", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AtDoubaoBean extends BaseAtBean {
    public static final a Companion = null;
    private static final long serialVersionUID = -5977531557505484463L;
    private final com.ss.android.lark.mention.base.impl.atselector.bean.a chatChatter;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return '0';
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 8;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return this.chatChatter.c;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return this.chatChatter.a;
    }

    public AtDoubaoBean(com.ss.android.lark.mention.base.impl.atselector.bean.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chatChatter");
        this.chatChatter = r2;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r4, ImageView r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "imageView");
        com.ss.android.lark.mention.base.impl.atselector.bean.a r0 = this.chatChatter;
        String r1 = r0.b;
        String r2 = r0.a;
        LoadParams r3 = new LoadParams();
        r3.a = r6;
        r3.b = r7;
        ImageModule.a(r4, r5, r1, r2, r3);
    }
}
