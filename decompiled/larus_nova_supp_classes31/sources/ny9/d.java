package ny9;

import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ Object a(d r8, Bundle r9, ICoreInputAbility.OnSendParams r10, boolean r11, String r12, Continuation r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            r9 = com.larus.utils.f.c(new Pair[0]);
        L5:
            Bundle r3 = r9;
            if ((r14 & 4) == 0) goto L8;
            boolean r5 = false;
        L10:
            if ((r14 & 8) == 0) goto L13;
            r12 = null;
        L13:
            return r8.a(r3, r10, r5, r12, r13);
        L8:
            r5 = r11;
            goto L10
        }

        public static /* synthetic */ Object b(d r9, Bundle r10, String r11, String r12, String r13, Map r14, String r15, Continuation r16) {
            return r9.b(r10, r11, r12, false, r13, r14, r15, r16);
        }
    }

    Object a(Bundle r1, ICoreInputAbility.OnSendParams r2, boolean r3, String r4, Continuation<? super Unit> r5);

    Object b(Bundle r1, String r2, String r3, boolean r4, String r5, Map<String, String> r6, String r7, Continuation<? super Unit> r8);
}
