package dz;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public ItemIdentity a;
    public int b;
    public int c;
    public Drawable d;
    public String e;
    public Function1<? super View, Boolean> f;

    public a() {
        this.a = ItemIdentity.BLANK;
    }

    public final int getType() {
        return this.b;
    }
}
