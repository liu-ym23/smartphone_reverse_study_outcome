package com.ss.android.lark.chat.preview.components;

import android.graphics.RectF;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.preview.components.view.FlowLayout;
import com.ss.android.lark.chat.preview.entity.component.property.TagListProperty;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 extends q6c.e<TagListProperty, FlowLayout, r6c.a> {
    public final TagListProperty f;
    public final r6c.a g;
    public final FlowLayout h;
    public final b0 i;

    public static final class a extends FlowLayout.c {
        public a(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final String i() {
        return "com.larksuite.framework.ui.flowlayout.FlowLayout";
    }

    public final boolean j() {
        return true;
    }

    public final View a(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "size");
        return new FlowLayout(this.g.getContext());
    }

    public final s6c.b.a d(s6c.b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "size");
        this.h.setAdapter(this.i);
        this.h.setMaxLines(this.f.getNumberOfLines());
        this.h.measure(View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(r4.a), PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(536870911, 0));
        return new s6c.b.a(h18.d.e(this.g.getContext(), this.h.getMeasuredWidth()), h18.d.e(this.g.getContext(), this.h.getMeasuredHeight()));
    }

    public void update(FlowLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (Intrinsics.areEqual(r2, this.h) == true) goto L5;
        r2.setMChildrenPositionList(this.h.getMChildrenPositionList());
    L5:
        r2.setAdapter(this.i);
        r2.setMaxLines(this.f.getNumberOfLines());
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((FlowLayout) r1);
    }

    public a0(TagListProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "prop");
        Intrinsics.checkNotNullParameter(r4, "dependence");
        super(r2, r3, r4);
        this.f = r2;
        this.g = r4;
        this.h = new FlowLayout(r4.getContext());
        this.i = new b0(this);
    }
}
