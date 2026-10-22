package na2;

import android.text.Spannable;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui.PublicScreenStyleSettingDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock.FakeMessageListAdapter;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ PublicScreenStyleSettingDialog a;

    public f(PublicScreenStyleSettingDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        List<? extends Spannable> r5 = (List) r4;
        FakeMessageListAdapter r0 = this.a.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.a = r5;
        FakeMessageListAdapter r1 = this.a.h;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L8:
        r1.notifyDataSetChanged();
        RecyclerView r2 = this.a.f;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L11:
        r2.scrollToPosition(CollectionsKt.getLastIndex(r5));
    }
}
