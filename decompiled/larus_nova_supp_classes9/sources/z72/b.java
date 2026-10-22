package z72;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.data.d;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.grouplive.CollaborateWidget;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ d b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ d d;
    public final /* synthetic */ CollaborateWidget e;

    public b(Ref.LongRef r1, d r2, Map r3, d r4, CollaborateWidget r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r13) {
        Long r14 = (Long) r13;
        ViewGroup r15 = ((Widget) this.e).containerView;
        if (r15 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r15, true);
    L5:
        Ref.LongRef r16 = this.a;
        long r0 = r16.element;
        if (r0 <= 1) goto L10;
        long r1 = r0 - 1;
        r16.element = r1;
        TextView r17 = this.e.a;
        if (r17 == null) goto L16;
        r17.setText(String.valueOf(r1));
        return;
    L16:
        return;
    L10:
        CollaborateWidget r2 = this.e;
        long r3 = this.b.d();
        Map r4 = this.c;
        IBaseUser r18 = this.d.f();
        if (r18 == null) goto L13;
        String r19 = r18.getIdString();
    L14:
        CollaborateWidget.xq(r2, r3, r4, r19, Long.valueOf(this.d.d()), false, EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_MESSAGE, true, 16);
        return;
    L13:
        r19 = null;
        goto L14
    }
}
