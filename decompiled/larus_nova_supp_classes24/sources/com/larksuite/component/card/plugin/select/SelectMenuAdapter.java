package com.larksuite.component.card.plugin.select;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$IconModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001#B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012%\u0010\u0006\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0006\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", "context", "Landroid/content/Context;", "resource", "", "getImageKey", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "imageID", "<init>", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "options", "", "Lcom/larksuite/component/card/plugin/model/UniversalCardShowSelectMenuPluginModel$OptionsItemModel;", "getOptions", "()Ljava/util/List;", "setOptions", "(Ljava/util/List;)V", "onCreateViewHolder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "initCheckBox", "viewHolder", "Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter$ItemViewHolder;", "ItemViewHolder", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class SelectMenuAdapter extends UDBaseListDialogAdapter {
    public final Context i;
    public final int j;
    public final Function1<String, String> k;
    public List<? extends UniversalCardShowSelectMenuPluginModel$OptionsItemModel> l;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larksuite/component/card/plugin/select/SelectMenuAdapter$ItemViewHolder;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getIcon", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ItemViewHolder extends UDBaseListDialogAdapter.UDDialogListItemViewHolder {
        public final LKUIRoundedImageView2 b;
        public final UDCheckBox c;

        public ItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.b = (LKUIRoundedImageView2) r2.findViewById(2131391800);
            this.c = (UDCheckBox) r2.findViewById(2131391792);
        }
    }

    public final Context getContext() {
        return this.i;
    }

    public void B2(int r2, ItemViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        if (((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.l, r2)).isSelected == false) goto L5;
        UDCheckBox r4 = r3.c;
        r4.setVisibility(0);
        r4.setChecked(true);
        return;
    L5:
        UDCheckBox r5 = r3.c;
        r5.setVisibility(8);
        r5.setChecked(false);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r1, r2);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "holder");
        super.y2(r19, r20);
        if ((r19 instanceof ItemViewHolder) == false) goto L5;
        ItemViewHolder r3 = (ItemViewHolder) r19;
    L6:
        if (r3 == null) goto L78;
        r3.b.setVisibility(8);
        if (this.l.size() <= r20) goto L74;
        UniversalCardShowSelectMenuPluginModel$IconModel r0 = ((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(this.l, r20)).icon;
        if (r0 == null) goto L14;
        String r7 = r0.token;
        if (r7 == null) goto L14;
        boolean r8 = StringsKt.endsWith$default(r7, "colorful", false, 2, null);
    L15:
        if (r0 == null) goto L17;
        String r9 = r0.token;
    L18:
        if (r9 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L26;
        int r11 = 0;
    L28:
        if (r11 == 0) goto L60;
        r3.b.setVisibility(0);
        AppCompatImageView r12 = r3.b;
        r12.setVisibility(0);
        if (r0 == null) goto L32;
        String r13 = r0.color;
    L33:
        if (r0 == null) goto L35;
        String r1 = r0.customColor;
    L36:
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (r8 == false) goto L76;
        Drawable r2 = UDIconUtils.getIconDrawable(r12.getContext(), r11);
    L59:
        r12.setImageDrawable(r2);
        goto L74
    L76:
        Integer r4 = Integer.valueOf(Color.parseColor(r1));     // Catch: Exception -> L40
    L42:
        if (r4 == null) goto L44;
        r2 = UDIconUtils.getIconDrawable(r12.getContext(), r11, r4.intValue());
        goto L59
    L44:
        if (r13 != null) goto L46;
    L57:
        r2 = UDIconUtils.getIconDrawable(r12.getContext(), r11);
        goto L59
    L46:
        if (Intrinsics.areEqual(r13, "icon-disabled") == false) goto L48;
        r13 = "icon-disable";
    L48:
        String r14 = r13;
        int r5 = UDColorUtils.getColorIdByToken(r12.getContext(), r14);
        if (r5 == 0) goto L51;
    L53:
        if (r5 == 0) goto L55;
        r2 = UDIconUtils.getIconDrawable(r12.getContext(), r11, r12.getContext().getResources().getColor(r5));
    L56:
        if (r2 != null) goto L59;
    L55:
        r2 = UDIconUtils.getIconDrawable(r12.getContext(), r11);
        goto L56
    L51:
        if (StringsKt.startsWith$default(r14, "ud", false, 2, null) == true) goto L53;
        r5 = UDColorUtils.getColorIdByToken(r12.getContext(), "ud_" + StringsKt.replace$default(r14, "-", "_", false, 4, null));
    L40:
        e = move-exception;
        Log.e("SelectMenuItemHelper", e);
        r4 = null;
        goto L42
    L35:
        r1 = null;
        goto L36
    L32:
        r13 = null;
        goto L33
    L60:
        if (r0 == null) goto L62;
        String r6 = r0.imageID;
    L64:
        if (TextUtils.isEmpty(r6) == true) goto L74;
        Function1<String, String> r15 = this.k;
        if (r0 == null) goto L68;
        String r16 = r0.imageID;
    L69:
        String r17 = (String) r15.invoke(r16);
        if (r17 == null) goto L72;
        AppCompatImageView r21 = r3.b;
        r21.setVisibility(0);
        Context r22 = r21.getContext();
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r22, "context");
        IRequestCreator r23 = ImageLoader.with(r22).load(new EncryptImage(r17));
        r23.centerCrop();
        r21.setScaleType(ImageView.ScaleType.FIT_CENTER);
        IRequestCreator r24 = r23.dontAnimate(false);
        ListenerParams.a r25 = new ListenerParams.a();
        r25.a(Biz.Messenger);
        r25.c(ListenerParams.FromType.CARD);
        r25.o = r17;
        r24.listener(new PerfLoadPicMonitor.MonitorRequestListener(r25.b())).into(r21);
        goto L74
    L72:
        AppCompatImageView r26 = r3.b;
        Intrinsics.checkNotNullParameter(r26, "<this>");
        r26.setImageDrawable(null);
        ImageLoader.clear(r26);
        return;
    L68:
        r16 = null;
        goto L69
    L62:
        r6 = null;
        goto L64
    L26:
        int r27 = com.larksuite.component.card.utils.d.a;
        LarkAppContext.Companion.getClass();
        r11 = com.larksuite.component.card.utils.d.a(r9, LarkAppContext.access$getInstance$cp().getContext());
        goto L28
    L20:
        if (r9.length() == 0) goto L23;
        r10 = false;
        goto L24
    L17:
        r9 = null;
    L14:
        r8 = false;
    L74:
        B2(r20, r3);
        return;
    L78:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final UDBaseListDialogAdapter.UDDialogListItemViewHolder z2(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ItemViewHolder(LayoutInflater.from(this.i).inflate(this.j, r3, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectMenuAdapter(Context r2, int r3, Function1<? super String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "getImageKey");
        super(r2);
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = new ArrayList();
    }
}
