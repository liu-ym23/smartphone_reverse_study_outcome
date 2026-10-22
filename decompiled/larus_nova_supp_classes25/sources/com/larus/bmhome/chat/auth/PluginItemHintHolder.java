package com.larus.bmhome.chat.auth;

import android.graphics.drawable.Drawable;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusLayoutViewPluginHintBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JY\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000eH\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/auth/PluginItemHintHolder;", "Lcom/larus/bmhome/chat/auth/PluginHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusLayoutViewPluginHintBinding;", "<init>", "(Lcom/larus/bmhome/databinding/LarusLayoutViewPluginHintBinding;)V", "updateHolder", "", "item", "Lcom/larus/bmhome/chat/auth/model/PluginItem;", "pos", "", "total", "getDrawable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "res", "Landroid/graphics/drawable/Drawable;", "clickListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PluginItemHintHolder extends PluginHolder {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.auth.PluginHolder
    public final void T3(PluginItem r1, int r2, int r3, Function1<? super Integer, ? extends Drawable> r4, Function1<? super PluginItem, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r4, "getDrawable");
        Intrinsics.checkNotNullParameter(r5, "clickListener");
    }

    public PluginItemHintHolder(LarusLayoutViewPluginHintBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
    }
}
