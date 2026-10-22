package com.obric.assistant.chat;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import f09.a;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/ObricChatContextServiceImpl;", "Lcom/obric/assistant/chat/IObricChatContextService;", "<init>", "()V", "isChatHost", NameKeys.UnloadStrategy_No_Strategy, "activity", "Landroid/app/Activity;", "isChatActivity", "getChatContext", "Lcom/larus/ui/arch/context/external/VContext;", "getCurrentChatContext", "findChatHost", "Landroidx/fragment/app/FragmentActivity;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatContextServiceImpl implements IObricChatContextService {
    public ObricChatContextServiceImpl() {
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final FragmentActivity d() {
        int r0 = p.a;
        a r1 = AppHost.a.a();
        List r2 = r1.g();
        ListIterator r3 = r2.listIterator(r2.size());
    L4:
        if (r3.hasPrevious() == false) goto L8;
        Object r4 = r3.previous();
        if (p.e((Activity) r4) == false) goto L4;
    L9:
        Activity r5 = (Activity) r4;
        if (r5 == null) goto L41;
        List r6 = r1.m();
        if (r5.getTaskId() == 0) goto L15;
    L28:
        Activity r7 = r5;
    L29:
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("find chat host: candidate=");
        r9.append(r5.getClass().getSimpleName());
        r9.append(", host=");
        if (r7 == null) goto L32;
        String r10 = r7.getClass().getSimpleName();
    L33:
        r9.append(r10);
        r8.i("ObricChatPageCompat", r9.toString());
        if ((r7 instanceof FragmentActivity) == true) goto L36;
        return null;
    L36:
        return (FragmentActivity) r7;
    L32:
        r10 = null;
        goto L33
    L15:
        if (r6.contains(r5) == true) goto L28;
        boolean r11 = true;
        r7 = (Activity) CollectionsKt.getOrNull(r2, r2.lastIndexOf(r5) - 1);
        if (r7 != null) goto L20;
    L27:
        r7 = null;
        goto L29
    L20:
        if (p.e(r7) == true) goto L22;
    L24:
        r11 = false;
    L25:
        if (r11 == false) goto L27;
    L22:
        if (r6.contains(r7) == false) goto L24;
    L41:
        return null;
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final t1a.b a() {
        return p.b();
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final t1a.b b(Activity r1) {
        return p.a(r1);
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final boolean c(Activity r1) {
        return p.e(r1);
    }

    @Override // com.obric.assistant.chat.IObricChatContextService
    public final boolean e(Activity r1) {
        return p.d(r1);
    }
}
