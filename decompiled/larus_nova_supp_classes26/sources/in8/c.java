package in8;

import com.larus.bmhome.chat.standarduikit.searchcot.view.SearchCotView;
import jn8.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ d a;

    public /* synthetic */ c(d r1) {
        this.a = r1;
    }

    public final Object invoke() {
        d r0 = this.a;
        j r1 = r0.a().a();
        kn8.c.b r2 = r0.a().a;
        ((SearchCotView) r0.b.getValue()).b(r1, r2);
        return Unit.INSTANCE;
    }
}
