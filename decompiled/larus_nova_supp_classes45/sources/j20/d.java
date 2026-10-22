package j20;

import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ InteractGameFeedbackDialog a;

    public d(InteractGameFeedbackDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        if (r8 == null) goto L37;
        j10.a r9 = (j10.a) ((ExtraResponse) r8).data;
        if (r9 == null) goto L38;
        List<String> r0 = r9.a;
        List<String> r1 = r0;
        if (r0 != null) goto L26;
        ArrayList r2 = new ArrayList();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L23
        JSONArray r4 = new JSONObject(r9.tags).optJSONArray("feedback");     // Catch: Throwable -> L23
        if (r4 == null) goto L20;
        int r5 = r4.length();     // Catch: Throwable -> L23
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L19;
        JSONObject r11 = r4.optJSONObject(r6);     // Catch: Throwable -> L23
        if (r11 == null) goto L18;
        String r12 = r11.optString("text");     // Catch: Throwable -> L23
        if (r12 == null) goto L18;
        r2.add(r12);     // Catch: Throwable -> L23
    L18:
        r6 = r6 + 1;     // Catch: Throwable -> L23
        goto L12
    L19:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(r13);     // Catch: Throwable -> L23
    L25:
        r9.a = r2;
        r1 = r2;
        goto L26
    L20:
        r13 = null;
    L23:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        a r15 = this.a.a;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L29:
        r15.a = r1;
        r15.notifyDataSetChanged();
        return;
    L38:
        return;
    }
}
