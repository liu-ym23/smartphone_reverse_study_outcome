package com.larus.bmhome.chat.auth;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusLayoutViewPluginItemBinding;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JY\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/auth/PluginItemContentHolder;", "Lcom/larus/bmhome/chat/auth/PluginHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusLayoutViewPluginItemBinding;", "<init>", "(Lcom/larus/bmhome/databinding/LarusLayoutViewPluginItemBinding;)V", "updateHolder", "", "item", "Lcom/larus/bmhome/chat/auth/model/PluginItem;", "pos", "", "total", "getDrawable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "res", "Landroid/graphics/drawable/Drawable;", "clickListener", "setPluginIcon", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PluginItemContentHolder extends PluginHolder {
    public static final /* synthetic */ int b = 0;
    public final LarusLayoutViewPluginItemBinding a;

    public static final class a {
    }

    static {
    }

    public PluginItemContentHolder(LarusLayoutViewPluginItemBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super(r3.a);
        this.a = r3;
        r3.h.setText("");
        r3.e.setText("");
        r3.c.setText("");
        e1.o(r3.f);
    }

    @Override // com.larus.bmhome.chat.auth.PluginHolder
    public final void T3(final PluginItem r3, int r4, int r5, Function1<? super Integer, ? extends Drawable> r6, final Function1<? super PluginItem, Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r6, "getDrawable");
        Intrinsics.checkNotNullParameter(r7, "clickListener");
        if (r5 != 2) goto L6;
        this.a.d.setBackground((Drawable) r6.invoke(Integer.valueOf(v19.c.b(2130970749, null, 2131239406))));
        e1.o(this.a.f);
    L12:
        final SimpleDraweeView r8 = this.a.g;
        String r9 = r3.iconUrl;
        if (r9 == null) goto L16;
        r8.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.c(12)));
        ImageLoaderKt.y(r8, r9, "settings.avatar", new v(r8), 4);
    L16:
        String r10 = r3.pluginName;
        if (r10 == null) goto L19;
        this.a.h.setText(r10);
    L19:
        String r11 = r3.pluginDesc;
        if (r11 == null) goto L22;
        this.a.e.setText(r11);
    L22:
        String r12 = r3.developer;
        if (r12 == null) goto L27;
        String r13 = AppHost.a.getApplication().getResources().getString(2131908370) + r12;
        if (r13 == null) goto L27;
        this.a.c.setText(r13);
    L27:
        Integer r14 = r3.authType;
        if (r14 == null) goto L36;
        int r15 = r14.intValue();
        Resources r16 = AppHost.a.getApplication().getResources();
        if (r15 != PluginAuthType.Always.value) goto L32;
        int r17 = 2131908366;
    L33:
        String r18 = r16.getString(r17);
        if (r18 == null) goto L36;
        this.a.b.setText(r18);
        goto L36
    L32:
        r17 = 2131899916;
    L36:
        e1.d(this.a.a, new u(r7, r3));
        return;
    L6:
        if (r4 != 1) goto L9;
        this.a.d.setBackground((Drawable) r6.invoke(Integer.valueOf(v19.c.b(2130970750, null, 2131239409))));
        e1.x(this.a.f);
        goto L12
    L9:
        if (r4 != (r5 - 1)) goto L11;
        this.a.d.setBackground((Drawable) r6.invoke(Integer.valueOf(v19.c.b(2130970747, null, 2131239400))));
        e1.o(this.a.f);
        goto L12
    L11:
        this.a.d.setBackground((Drawable) r6.invoke(Integer.valueOf(v19.c.b(2130970748, null, 2131239403))));
        e1.x(this.a.f);
        goto L12
    }
}
