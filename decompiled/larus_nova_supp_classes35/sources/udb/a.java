package udb;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends FeedCardComponent<Object, AppCompatImageView> {
    public final Context c;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AppCompatImageView r0 = new AppCompatImageView(getContext());
        r0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return r0;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public Context getContext() {
        return this.c;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r2;
    }
}
