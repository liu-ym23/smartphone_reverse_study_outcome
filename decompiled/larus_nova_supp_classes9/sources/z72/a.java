package z72;

import android.widget.TextView;
import com.bytedance.android.live.base.model.data.d;
import com.bytedance.android.livesdk.interactivity.grouplive.CollaborateWidget;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ d b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ CollaborateWidget d;

    public a(Ref.LongRef r1, d r2, Map r3, CollaborateWidget r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r13) {
        Long r14 = (Long) r13;
        Ref.LongRef r15 = this.a;
        long r0 = r15.element;
        if (r0 <= 1) goto L7;
        long r1 = r0 - 1;
        r15.element = r1;
        TextView r16 = this.d.a;
        if (r16 == null) goto L9;
        r16.setText(String.valueOf(r1));
        return;
    L9:
        return;
    L7:
        CollaborateWidget.xq(this.d, this.b.d(), this.c, null, null, false, EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_MESSAGE, false, 92);
    }
}
