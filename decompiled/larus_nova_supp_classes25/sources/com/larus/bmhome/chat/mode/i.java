package com.larus.bmhome.chat.mode;

import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.instruction.g;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ com.larus.bmhome.chat.model.n a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ModeSwitchComponent d;

    public /* synthetic */ i(com.larus.bmhome.chat.model.n r1, String r2, String r3, ModeSwitchComponent r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.larus.bmhome.chat.model.n r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        ModeSwitchComponent r3 = this.d;
        int r4 = ModeSwitchComponent.k0;
        String r5 = null;
        if (Intrinsics.areEqual(r0.c, r1) == true) goto L5;
    L24:
        FLogger r6 = FLogger.a;
        StringBuilder r8 = new StringBuilder("skip stale mode draft restore target=");
        r8.append(r1);
        r8.append(" storageId=");
        r8.append(r2);
        r8.append(" draftMode=");
        r8.append(r0.c);
        r8.append(" currentStorageId=");
        r8.append(r0.b);
        r8.append(" selectedMode=");
        ConversationMode r7 = (ConversationMode) r3.Si().getValue();
        if (r7 == null) goto L27;
        r5 = r7.a();
    L27:
        r8.append(r5);
        r6.w("ModeSwitchComponent", r8.toString());
        return;
    L5:
        if (Intrinsics.areEqual(r0.b, r2) == false) goto L24;
        ConversationMode r9 = (ConversationMode) r3.Si().getValue();
        if (r9 == null) goto L9;
        String r10 = r9.a();
    L11:
        if (Intrinsics.areEqual(r10, r1) == false) goto L24;
        FLogger r11 = FLogger.a;
        r11.i("ModeSwitchComponent", "beginModeDraftRestore key=" + r1 + " storageId=" + r2);
        boolean r12 = true;
        r0.d = true;
        g r13 = r3.vc();
        if (r13 == null) goto L15;
        r13.nB(r1);
    L15:
        r0.d = true;
        p1 r14 = (p1) r3.s.getValue();
        if (r14 == null) goto L18;
        r14.cb(false);
    L19:
        StringBuilder r15 = new StringBuilder("restoreModeDraft key=");
        r15.append(r1);
        r15.append(" storageId=");
        r15.append(r0.b);
        r15.append(" itemTypes=");
        List<ChatDraftItem> r16 = r0.p;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L21:
        if (r18.hasNext() == false) goto L23;
        r17.add(((ChatDraftItem) r18.next()).getType());
        goto L21
    L23:
        r15.append(r17);
        r15.append(" restored=");
        r15.append(r12);
        r11.i("ModeSwitchComponent", r15.toString());
        return;
    L18:
        r12 = false;
        goto L19
    L9:
        r10 = null;
        goto L11
    }
}
