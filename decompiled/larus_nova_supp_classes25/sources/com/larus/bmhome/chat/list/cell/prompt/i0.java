package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.RuleRequestParamRequest;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i0 implements Function0 {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ i0(PromptCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final PromptCell r9 = this.a;
        Message r10 = this.b;
        Keva r1 = PromptCell.Y;
        r9.getClass();
        if (com.larus.platform.exp.t.c == true) goto L49;
        if (z2.a.enablePromptFilter() == false) goto L49;
        String r2 = r10.getConversationId();
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if (com.larus.bmhome.utils.i.g(r2) == false) goto L49;
        PromptSpan r3 = r9.e;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r3 = null;
    L16:
        ArrayList<Pair<View, PromptSpan.a.C0062a>> r4 = r3.getSuggestViewList();
        ArrayList r6 = new ArrayList();
        r6.addAll(r4);
        ArrayList r5 = new ArrayList();
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        PromptSpan.a.C0062a r8 = (PromptSpan.a.C0062a) ((Pair) r7.next()).getSecond();
        if (r8 == null) goto L18;
        r5.add(r8);
        goto L18
    L23:
        if (com.larus.bmhome.chat.bean.d.k0(r10) == false) goto L26;
        int r11 = 1;
    L28:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r13 = r5.iterator();
    L30:
        if (r13.hasNext() == false) goto L36;
        PromptSpan.a.C0062a r14 = (PromptSpan.a.C0062a) r13.next();
        String r15 = r14.a;
        String r16 = r14.b;
        if (r16 == null) goto L34;
        Long r17 = StringsKt.toLongOrNull(r16);
    L35:
        r12.add(new RuleRequestParamRequest(r15, r17, null, 4, null));
        goto L30
    L34:
        r17 = null;
        goto L35
    L36:
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r19 = r5.iterator();
    L38:
        if (r19.hasNext() == false) goto L43;
        String r20 = ((PromptSpan.a.C0062a) r19.next()).b;
        if (r20 != null) goto L42;
        r20 = "";
    L42:
        r18.add(r20);
        goto L38
    L43:
        Fragment r21 = lf8.a.d(r9);
        if (r21 == null) goto L49;
        LifecycleCoroutineScope r110 = LifecycleOwnerKt.getLifecycleScope(r21);
        if (r110 == null) goto L49;
        BuildersKt.launch$default(r110, Dispatchers.getIO(), null, new PromptCell$filterPromptList$2(r12, r11, r10, r9, r6, r18, null), 2, null);
        goto L49
    L26:
        if (com.larus.bmhome.chat.bean.d.W0(r10) == false) goto L49;
        r11 = 2;
    L49:
        if (com.larus.bmhome.chat.bean.d.z0(r10) == false) goto L56;
        PromptSpan r22 = r9.e;
        if (r22 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        PromptSpan r111 = null;
    L54:
        r111.post(new k0(r9));
        goto L56
    L53:
        r111 = r22;
    L56:
        return Unit.INSTANCE;
    }
}
