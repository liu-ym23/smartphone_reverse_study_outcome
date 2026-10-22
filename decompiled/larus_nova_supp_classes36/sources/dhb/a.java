package dhb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.flow.feed.component.loading.FlowLoadingView;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FeedCardComponent<C0249a, FlowLoadingView> {
    public final Context c;

    /* JADX INFO: renamed from: dhb.a$a, reason: collision with other inner class name */
    public static final class C0249a {
        public final Function2<FlowLoadingView, View, View> a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0249a(Function2<? super FlowLoadingView, ? super View, ? extends View> r1) {
            this.a = r1;
        }
    }

    public final View a() {
        return new FlowLoadingView(getContext());
    }

    public Context getContext() {
        return this.c;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r2;
    }
}
