package com.larus.setting.impl.iconchanger;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00150\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/setting/impl/iconchanger/AppIconViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroid/view/View;", "onClickItem", "Lkotlin/Function1;", "Lcom/larus/setting/impl/iconchanger/ChangeAppIconData;", "Lkotlin/ParameterName;", "name", "changeAppIconData", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "lastRenderImgUrl", "", "selctCircle", "Lcom/larus/setting/impl/iconchanger/CircleRingView;", "kotlin.jvm.PlatformType", "dynamicAvatar", "Lcom/larus/common_ui/widget/CircleSimpleDraweeView;", "staticAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bindData", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AppIconViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int g = 0;
    public final View a;
    public final Function1<b, Unit> b;
    public String c;
    public final CircleRingView d;
    public final CircleSimpleDraweeView e;
    public final SimpleDraweeView f;

    /* JADX WARN: Multi-variable type inference failed */
    public AppIconViewHolder(View r2, Function1<? super b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onClickItem");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.d = (CircleRingView) r2.findViewById(2131385764);
        this.e = r2.findViewById(2131370468);
        this.f = r2.findViewById(2131387273);
    }
}
