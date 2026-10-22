package vdb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends FeedCardComponent<b, AppCompatImageView> {

    /* JADX INFO: renamed from: vdb.a$a, reason: collision with other inner class name */
    public static final class C0312a {
    }

    public static final class b {
        public b(Drawable r1) {
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AppCompatImageView r0 = new AppCompatImageView(getContext());
        r0.setScaleType(ImageView.ScaleType.FIT_XY);
        r0.setPadding(0, 0, UIHelper.dp2px(4.0f), 0);
        return r0;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
