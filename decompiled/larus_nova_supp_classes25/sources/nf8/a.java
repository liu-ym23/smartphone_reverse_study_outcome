package nf8;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.list.cell.avatar.BigAvatarCell;
import com.larus.platform.api.d0;
import com.larus.platform.service.u;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ BigAvatarCell a;
    public final /* synthetic */ e b;
    public final /* synthetic */ TextView c;

    public /* synthetic */ a(BigAvatarCell r1, e r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r11) {
        BigAvatarCell r0 = this.a;
        e r1 = this.b;
        TextView r2 = this.c;
        int r3 = BigAvatarCell.g;
        Intrinsics.checkNotNullParameter((TextView) r11, "it");
        Fragment r12 = lf8.a.d(r0);
        if (r12 == null) goto L27;
        Context r4 = r12.getContext();
        if (r4 == null) goto L27;
        vc8.e.b("disable_onboarding_entrance");
        u r13 = u.a;
        by7.e r14 = lf8.a.d(r0);
        if ((r14 instanceof by7.e) == false) goto L10;
        by7.e r15 = r14;
    L11:
        Integer r5 = r1.f;
        if (r5 != null) goto L15;
    L17:
        String r6 = null;
    L18:
        Integer r7 = r1.f;
        if (r7 != null) goto L22;
    L24:
        String r8 = r1.a;
    L25:
        d0.a.a(r4, "chat_onboarding_click", r15, r6, r8, null, 96);
        e1.o(r2);
        return Unit.INSTANCE;
    L22:
        if (r7.intValue() != 1) goto L24;
        r8 = null;
        goto L25
    L15:
        if (r5.intValue() != 1) goto L17;
        r6 = r1.a;
        goto L18
    L10:
        r15 = null;
    L27:
        return Unit.INSTANCE;
    }
}
