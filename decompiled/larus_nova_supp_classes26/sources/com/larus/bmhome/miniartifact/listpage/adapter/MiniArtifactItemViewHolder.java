package com.larus.bmhome.miniartifact.listpage.adapter;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.miniartifact.listpage.request.ApplicationTemplate;
import com.larus.mainbot.impl.databinding.LarusItemMiniArtifactTemplateBinding;
import cr8.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B8\u0012'\u0010\u0002\u001a#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u001c\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002JL\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0004H\u0002R/\u0010\u0002\u001a#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/adapter/MiniArtifactItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "", "binding", "Lcom/larus/mainbot/impl/databinding/LarusItemMiniArtifactTemplateBinding;", "<init>", "(Lkotlin/jvm/functions/Function2;Lcom/larus/mainbot/impl/databinding/LarusItemMiniArtifactTemplateBinding;)V", "bindData", "size", "Landroid/util/Size;", "position", "miniAppItemData", "setupOnExpose", "setShapeCornerColorTint", "colorString", "", "adjustToView", "Landroid/view/View;", "adjustViewBgGradient", "view", "topLeftRadius", "", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "startColor", "endColor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactItemViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final Function2<Integer, ApplicationTemplate, Unit> a;
    public final LarusItemMiniArtifactTemplateBinding b;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MiniArtifactItemViewHolder(Function2<? super Integer, ? super ApplicationTemplate, Unit> r2, LarusItemMiniArtifactTemplateBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "onClick");
        Intrinsics.checkNotNullParameter(r3, "binding");
        super(r3.a);
        this.a = r2;
        this.b = r3;
    }

    public static void T3(MiniArtifactItemViewHolder r2, View r3, float r4, float r5, int r6, int r7) {
        r2.getClass();
        ShapeDrawable r8 = new ShapeDrawable(new RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r4, r4, r5, r5}, null, null));
        r8.setShaderFactory(new e(r6, r7));
        r3.setBackground(r8);
    }
}
