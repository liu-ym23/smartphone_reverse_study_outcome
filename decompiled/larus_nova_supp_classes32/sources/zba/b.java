package zba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OTipBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricBlockCommonTipBinding;
import j19.c;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends uba.a<zba.a> {
    public ObricBlockCommonTipBinding d;

    public static final class a {
    }

    static {
    }

    public final void i() {
        FLogger.a.i("CommonTipBlockHolder", "onViewRecycled");
    }

    public b() {
    }

    public final void g(jc8.a r9) {
        zba.a r10 = (zba.a) r9;
        Intrinsics.checkNotNullParameter(r10, "blockModel");
        FLog.i("CommonTipBlockHolder", "onBindBlockView");
        Intrinsics.checkNotNullParameter(r10, "blockModel");
        ObricBlockCommonTipBinding r0 = this.d;
        if (r0 != null) goto L5;
        FLogger.a.w("CommonTipBlockHolder", "binding is null");
        return;
    L5:
        BlockContent r11 = ((jc8.a) r10).a.getContent();
        if (r11 == null) goto L23;
        OTipBlock r12 = r11.getOTipBlock();
        if (r12 == null) goto L23;
        String r1 = r12.content;
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        FLogger.a.w("CommonTipBlockHolder", "tipBlock.content is null or empty");
        e1.o(r0.a);
        return;
    L19:
        c.f(r0.a);
        we8.a.b(r0.b, i5.h(), false, null, null, 12);
        TextView r3 = r0.b;
        String r13 = r12.content;
        if (r13 != null) goto L22;
        r13 = NameKeys.UnloadStrategy_No_Strategy;
    L22:
        r3.setText(r13);
        return;
    L13:
        if (r1.length() == 0) goto L16;
        r2 = false;
    L23:
        FLogger.a.w("CommonTipBlockHolder", "tipBlock is null");
        e1.o(r0.a);
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("CommonTipBlockHolder", "onCreatedBlockView");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563935, r4, false);
        if (r5 == null) goto L7;
        TextView r6 = (TextView) r5;
        this.d = new ObricBlockCommonTipBinding(r6, r6);
        return r6;
    L7:
        throw new NullPointerException("rootView");
    }
}
