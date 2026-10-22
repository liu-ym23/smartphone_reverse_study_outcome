package cb8;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m1 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ com.larus.bmhome.chat.component.cvs.y a;
    public final /* synthetic */ Function1<BotModel, Unit> b;

    public final void c(Object r2) {
        BotModel r3 = (BotModel) r2;
        Intrinsics.checkNotNullParameter(r3, "new");
        this.a.lQ(this);
        this.b.invoke(r3);
    }

    public m1(com.larus.bmhome.chat.component.cvs.y r1, Function1<? super BotModel, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
