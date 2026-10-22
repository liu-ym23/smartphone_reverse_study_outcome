package qj8;

import com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.FlowMarkdownCodeView;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ FlowMarkdownCodeView a;
    public final /* synthetic */ m b;
    public final /* synthetic */ com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a c;
    public final /* synthetic */ Boolean d;
    public final /* synthetic */ Long e;

    public /* synthetic */ h(FlowMarkdownCodeView r1, m r2, com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a r3, Boolean r4, Long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r10) {
        final FlowMarkdownCodeView r1 = this.a;
        final m r2 = this.b;
        final com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a r3 = this.c;
        final Boolean r4 = this.d;
        final Long r5 = this.e;
        ki9.b r11 = (ki9.b) r10;
        int r0 = FlowMarkdownCodeView.g;
        Intrinsics.checkNotNullParameter(r11, "$this$exposeX");
        Function0 r6 = new j(r1, r2);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r6, "cellId");
        r11.a = r6;
        r11.a(CollectionsKt.listOf(new Integer[]{0, 1, 2}));
        r11.c = 0.5f;
        r11.e = true;
        Function0 r7 = new k(r1, r2, r3, r4, r5);
        Intrinsics.checkNotNullParameter(r7, "block");
        r11.b = r7;
        return Unit.INSTANCE;
    }
}
