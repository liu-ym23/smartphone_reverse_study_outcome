package bm8;

import com.larus.bmhome.chat.api.r;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ h a;
    public final /* synthetic */ MarkdownAppletContainer b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ e(h r1, MarkdownAppletContainer r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        h r0 = this.a;
        MarkdownAppletContainer r1 = this.b;
        String r2 = this.c;
        String r3 = this.d;
        r0.a = new g();
        AppletWidget r4 = r1.a;
        if (r4 == null) goto L7;
        r r5 = r4.getWidgetContainer();
        if (r5 == null) goto L7;
        r5.sendEvent("flow.chatBlur", MapsKt.mapOf(new Pair("mixture_card_id", r2)));
    L7:
        FLogger.a.d("MarkdownAppletContainer", "flow.chatBlur " + r3);
        return Unit.INSTANCE;
    }
}
