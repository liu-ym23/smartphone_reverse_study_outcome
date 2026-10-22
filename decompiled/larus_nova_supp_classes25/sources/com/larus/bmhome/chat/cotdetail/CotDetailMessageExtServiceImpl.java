package com.larus.bmhome.chat.cotdetail;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/CotDetailMessageExtServiceImpl;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "service", "", "setSendMessageExt", "", "map", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "getCotDetailFragment", "Lcom/larus/bmhome/chat/cotdetail/CotDetailFragment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CotDetailMessageExtServiceImpl implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public CotDetailMessageExtServiceImpl() {
    }

    public static CotDetailFragment c() {
        FragmentActivity r1 = AppHost.a.a().getCurrentActivity();     // Catch: Exception -> L47
        if ((r1 instanceof FragmentActivity) == false) goto L6;
        FragmentActivity r2 = r1;     // Catch: Exception -> L47
    L7:
        if (r2 != null) goto L9;
        return null;
    L9:
        CotDetailDialogFragment r3 = r2.getSupportFragmentManager().findFragmentByTag("CotDetailDialogFragment");     // Catch: Exception -> L47
        if ((r3 instanceof CotDetailDialogFragment) == false) goto L12;
        CotDetailDialogFragment r4 = r3;     // Catch: Exception -> L47
    L13:
        if (r4 != null) goto L16;
        return null;
    L16:
        if (r4.isAdded() == true) goto L18;
    L46:
        return null;
    L18:
        if (r4.isDetached() == true) goto L46;
        if (r4.isRemoving() == true) goto L46;
        List r5 = CollectionsKt.asReversedMutable(r4.getChildFragmentManager().getFragments());     // Catch: Exception -> L47
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L47
        Iterator r7 = r5.iterator();     // Catch: Exception -> L47
    L24:
        if (r7.hasNext() == false) goto L28;
        Object r8 = r7.next();     // Catch: Exception -> L47
        if ((r8 instanceof CotDetailFragment) == false) goto L24;
        r6.add(r8);     // Catch: Exception -> L47
        goto L24
    L28:
        Iterator r9 = r6.iterator();     // Catch: Exception -> L47
    L30:
        if (r9.hasNext() == false) goto L43;
        Object r10 = r9.next();     // Catch: Exception -> L47
        CotDetailFragment r11 = (CotDetailFragment) r10;     // Catch: Exception -> L47
        if (r11.isAdded() == true) goto L34;
    L40:
        boolean r12 = false;
    L41:
        if (r12 == false) goto L30;
    L44:
        return (CotDetailFragment) r10;
    L34:
        if (r11.isDetached() == true) goto L40;
        if (r11.isRemoving() == true) goto L40;
        if (r11.isHidden() == true) goto L40;
        r12 = true;
        goto L41
    L43:
        r10 = null;
        goto L44
    L12:
        r4 = null;
        goto L13
    L6:
        r2 = null;
    L47:
        e = move-exception;
        FLogger.a.e("CotDetailMessageExt", "get COT detail fragment failed", e);
        return null;
    }

    @Override // com.larus.bmhome.chat.api.IMessageExtService
    public final String service() {
        return "CotDetailMessageExtServiceImpl";
    }

    @Override // com.larus.bmhome.chat.api.IMessageExtService
    public final void b(Map r1, IMessageExtService.a r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
    }

    @Override // com.larus.bmhome.chat.api.IMessageExtService
    public final void a(Map<String, String> r2, e r3, IMessageExtService.a r4) {
        Intrinsics.checkNotNullParameter(r2, "map");
        CotDetailFragment r5 = c();     // Catch: Exception -> L11
        if (r5 == null) goto L16;
        b r6 = s1a.a.g(r5);     // Catch: Exception -> L11
        if (r6 == null) goto L17;
        fe8.b r7 = (fe8.b) r6.getAbility(fe8.b.class);     // Catch: Exception -> L11
        if (r7 == null) goto L18;
        r7.fA(r2);     // Catch: Exception -> L11
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L11:
        e = move-exception;
        FLogger.a.e("CotDetailMessageExt", "append COT detail message ext failed", e);
    }
}
