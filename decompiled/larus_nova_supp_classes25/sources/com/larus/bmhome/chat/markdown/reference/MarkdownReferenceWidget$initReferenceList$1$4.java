package com.larus.bmhome.chat.markdown.reference;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import fh8.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MarkdownReferenceWidget$initReferenceList$1$4 extends FunctionReferenceImpl implements Function2<Integer, RecyclerView.ViewHolder, Boolean> {
    public MarkdownReferenceWidget$initReferenceList$1$4(Object r8) {
        super(2, r8, MarkdownReferenceWidget.class, "itemShowCallBack", "itemShowCallBack(ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", 0);
    }

    public final Boolean invoke(int r11, RecyclerView.ViewHolder r12) {
        Intrinsics.checkNotNullParameter(r12, "p1");
        MarkdownReferenceWidget r1 = (MarkdownReferenceWidget) ((CallableReference) this).receiver;
        Object r13 = ListProtector.get(r1.e, r11);
        oi8.n.a r2 = null;
        if ((r13 instanceof TextCard) == false) goto L5;
        TextCard r14 = (TextCard) r13;
    L6:
        if (r14 == null) goto L13;
        Long r3 = r14.getId();
        if (r3 == null) goto L10;
        String r4 = r3.toString();
    L11:
        oi8.n.a r0 = new oi8.n.a(r4, r14.getUrl(), r14.getDocId(), null);
    L12:
        r2 = r0;
    L19:
        f r15 = r1.n;
        if (r15 == null) goto L25;
        Message r5 = r15.b;
        if (r5 == null) goto L25;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MarkdownReferenceWidget$itemShowCallBack$1$1(r1, r2, r5, r11, null), 3, null);
    L25:
        return Boolean.TRUE;
    L10:
        r4 = null;
        goto L11
    L13:
        Object r16 = ListProtector.get(r1.e, r11);
        if ((r16 instanceof VideoCard) == false) goto L16;
        VideoCard r17 = (VideoCard) r16;
    L17:
        if (r17 == null) goto L19;
        r0 = new oi8.n.a(r17.getId(), r17.getMainSiteUrl(), r17.getItemId(), null);
        goto L12
    L16:
        r17 = null;
        goto L17
    L5:
        r14 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (RecyclerView.ViewHolder) r2);
    }
}
