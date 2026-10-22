package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ss.android.lark.utils.UIHelper;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements OptionsSelectPopupMenu.d<String> {
    public final Context a;
    public final Collection<String> b;

    @Override // com.ss.android.lark.newemoji.emojioptions.OptionsSelectPopupMenu.d
    public final View a(String r5) {
        String r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "item");
        ImageView r0 = new ImageView(this.a);
        int r1 = UIHelper.dp2px(32.0f);
        r0.setLayoutParams(new ViewGroup.LayoutParams(r1, r1));
        Bitmap r7 = qsb.b.a().Hb(r6, false);
        if (r7 != null) goto L5;
        r0.setImageDrawable(new xsb.a(r0.getContext(), r1, r1));
    L6:
        return r0;
    L5:
        r0.setImageDrawable(new BitmapDrawable(r0.getContext().getResources(), r7));
        goto L6
    }

    public a(List<String> r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "options");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        this.b = r2;
    }
}
