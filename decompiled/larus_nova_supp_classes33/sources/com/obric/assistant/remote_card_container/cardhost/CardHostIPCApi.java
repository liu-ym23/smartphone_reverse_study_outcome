package com.obric.assistant.remote_card_container.cardhost;

import android.os.Bundle;
import android.os.Parcelable;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant_card.provider_core.IHostApi;
import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import com.obric.assistant.remote_card_container.manager.RemoteCardManager;
import com.obric.assistant.remote_card_container.manager.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import o9a.a;
import p9a.b;
import p9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/assistant/remote_card_container/cardhost/CardHostIPCApi;", "Lcom/obric/aiagent/assistant_card/provider_core/IHostApi$Stub;", "<init>", "()V", "TAG", "", "notifyCardChanged", "", "params", "Landroid/os/Bundle;", "callMethod", "methodName", "methodParams", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardHostIPCApi extends IHostApi.Stub {
    public static final CardHostIPCApi INSTANCE = null;
    private static final String TAG = "CardHostIPCApi";

    static {
        INSTANCE = new CardHostIPCApi();
    }

    private CardHostIPCApi() {
    }

    public void notifyCardChanged(Bundle r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getString("card_uri");
    L6:
        if (r3 == null) goto L8;
        r0 = r3.getString("card_extra_params");
    L8:
        if (r1 != null) goto L11;
        b.b(TAG, "notifyCardChanged: cardUri is null");
        return;
    L11:
        c.a(r1, r0, true);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void callMethod(String r18, Bundle r19) {
        e r2 = b.a;
        b.a(TAG, "callMethod: " + r18 + ", " + r19);
        if (r18 == null) goto L89;
        int r3 = r18.hashCode();
        int r6 = 0;
        a r9 = null;
        if (r3 == (-1903539871)) goto L46;
        if (r3 == 99891402) goto L30;
        if (r3 != 1117603247) goto L89;
        if (r18.equals("copy_content") == false) goto L89;
        if (r19 == null) goto L16;
        r9 = r19.getCharSequence("data");
    L16:
        if (r9 != null) goto L20;
        b.b(TAG, "copy content is null");
        return;
    L20:
        if (r9.length() != 0) goto L22;
        r6 = 1;
    L22:
        if (r6 == 0) goto L25;
        b.b(TAG, "copy content is isEmpty");
        return;
    L25:
        sfa.a r0 = RemoteCardManager.d;
        if (r0 == null) goto L28;
        r0.c(r9);
        return;
    L28:
        b.b(TAG, "getCardHostApi is null");
        return;
    L30:
        if (r18.equals("show_dialog") == false) goto L89;
        int r1 = a.g;
        if (r19 == null) goto L34;
        Bundle r4 = r19.getBundle("data_bean");
    L35:
        if (r4 == null) goto L38;
        r9 = new a(r4.getString("title"), r4.getString("message"), r4.getString("cancelText"), r4.getString("confirmText"), IHostApiCallback.Stub.asInterface(r4.getBinder("cancelClickListener")), IHostApiCallback.Stub.asInterface(r4.getBinder("confirmClickListener")));
    L38:
        b.a(TAG, "dialogBean = " + r9);
        if (r9 != null) goto L41;
        b.b(TAG, "dialog bean is null");
        return;
    L41:
        sfa.a r5 = RemoteCardManager.d;
        if (r5 == null) goto L44;
        r5.d(r9);
        return;
    L44:
        b.b(TAG, "getCardHostApi is null");
        return;
    L34:
        r4 = null;
        goto L35
    L46:
        if (r18.equals("show_menu") == false) goto L89;
        int r7 = o9a.b.b;
        if (r19 == null) goto L51;
        Bundle r8 = r19.getBundle("data_bean");
    L52:
        if (r8 == null) goto L78;
        Parcelable[] r10 = r8.getParcelableArray("menuItems");
        if (r10 == null) goto L75;
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
    L57:
        if (r6 >= r12) goto L62;
        Parcelable r13 = r10[r6];
        if ((r13 instanceof Bundle) == false) goto L61;
        r11.add(r13);
    L61:
        r6 = r6 + 1;
        goto L57
    L62:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L64:
        if (r15.hasNext() == false) goto L74;
        Bundle r16 = (Bundle) r15.next();
        int r17 = o9a.c.c;
        if (r16 != null) goto L68;
        o9a.c r20 = null;
    L72:
        if (r20 == null) goto L64;
        r14.add(r20);
        goto L64
    L68:
        String r21 = r16.getString("title");
        if (r21 != null) goto L71;
        r21 = "";
    L71:
        r20 = new o9a.c(r21, IHostApiCallback.Stub.asInterface(r16.getBinder("onClickListener")));
        goto L72
    L74:
        r9 = CollectionsKt.toList(r14);
    L75:
        if (r9 != null) goto L77;
        r9 = CollectionsKt.emptyList();
    L77:
        r9 = new o9a.b(r9);
    L78:
        e r22 = b.a;
        b.a(TAG, "menuBean = " + r9);
        if (r9 != null) goto L81;
    L87:
        FLogger.a.w(TAG, "menu bean is invalid");
        return;
    L81:
        if (((o9a.b) r9).a.isEmpty() == true) goto L87;
        sfa.a r23 = RemoteCardManager.d;
        if (r23 == null) goto L86;
        r23.a(r9);
        return;
    L86:
        b.b(TAG, "getCardHostApi is null");
        return;
    L51:
        r8 = null;
    L89:
        b.b(TAG, "callMethod: unknown method name " + r18);
    }
}
