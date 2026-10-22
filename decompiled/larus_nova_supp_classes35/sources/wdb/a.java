package wdb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends FeedCardComponent<Object, TextView> {

    /* JADX INFO: renamed from: wdb.a$a, reason: collision with other inner class name */
    public static final class C0317a {
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        TextView r0 = new TextView(getContext());
        r0.setTextColor(UDColorUtils.getColor(r0.getContext(), 2131106622));
        r0.setTextSize(0, b.h(r0.getContext(), 16));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setSingleLine(true);
        return r0;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
