package rf8;

import android.view.ViewGroup;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.list.cell.botmaker.BotMakerCell;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ by7.e e;
    public final /* synthetic */ BotMakerCell f;

    public /* synthetic */ d(Message r1, String r2, String r3, String r4, by7.e r5, BotMakerCell r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r8) {
        Message r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        String r3 = this.d;
        by7.e r4 = this.e;
        BotMakerCell r5 = this.f;
        Intrinsics.checkNotNullParameter((ViewGroup) r8, "it");
        q0 r9 = lf8.a.b(r5);
        if (r9 == null) goto L7;
        nq9.e r10 = r9.H7();
        if (r10 == null) goto L7;
        r10.b(r0);
    L7:
        o.a(r1, "head", r2, r3, r4);
        return Unit.INSTANCE;
    }
}
