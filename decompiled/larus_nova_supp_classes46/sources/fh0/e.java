package fh0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public Boolean b;
    public final b c;
    public final DataCenter d;
    public final int e;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            KVData r10 = (KVData) r9;
            if (r10 == null) goto L34;
            boolean r1 = false;
            if (Intrinsics.areEqual("data_big_party_support_send_gift_to_linker", r10.getKey()) == false) goto L18;
            if (r10.getData() == null) goto L15;
            Object r11 = r10.getData();
            if (r11 == null) goto L13;
            r1 = ((Boolean) r11).booleanValue();
            goto L15
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L15:
            if ((!Intrinsics.areEqual(this.a.b, Boolean.valueOf(r1))) == false) goto L30;
            gh0.a.b("SupportSendGiftSettingHandler", "call isSupportSendGift change from " + this.a.b + " to " + r1 + ", on VideoTalkRoom", 4);
            this.a.b = Boolean.valueOf(r1);
            this.a.c();
            return;
        L30:
            return;
        L18:
            if (Intrinsics.areEqual("data_audio_chat_support_send_gift_to_linker", r10.getKey()) == true) goto L20;
            return;
        L20:
            if (r10.getData() == null) goto L27;
            Object r12 = r10.getData();
            if (r12 == null) goto L25;
            r1 = ((Boolean) r12).booleanValue();
            goto L27
        L25:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L27:
            if ((!Intrinsics.areEqual(this.a.b, Boolean.valueOf(r1))) == false) goto L33;
            gh0.a.b("SupportSendGiftSettingHandler", "call isSupportSendGift change from " + this.a.b + " to " + r1 + ", on VoiceChatRoom", 4);
            this.a.b = Boolean.valueOf(r1);
            this.a.c();
            return;
        L33:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        int r0 = this.e;
        if (r0 != 8) goto L5;
        this.d.observe("data_audio_chat_support_send_gift_to_linker", this.c);
        return;
    L5:
        if (r0 != 16) goto L11;
        this.d.observe("data_big_party_support_send_gift_to_linker", this.c);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.d.removeObserver("data_big_party_support_send_gift_to_linker", this.c);
        this.d.removeObserver("data_audio_chat_support_send_gift_to_linker", this.c);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r12) {
        Intrinsics.checkNotNullParameter(r12, "oldMergeDataList");
        List<ch0.e> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
        boolean r1 = false;
        ch0.e r3 = null;
    L4:
        if (r14.hasNext() == false) goto L19;
        ch0.e r4 = (ch0.e) r14.next();
        if (Intrinsics.areEqual(Boolean.valueOf(r4.a.isOpenSendGift()), this.b) == false) goto L8;
        boolean r5 = r1;
        ch0.e r2 = r4;
    L9:
        IBaseUser r6 = r2.a.getUser();
        if (r6 == null) goto L12;
        String r7 = r6.getIdString();
    L14:
        if (Intrinsics.areEqual(r7, gh0.a.c()) == false) goto L17;
        if (r2 == r4) goto L17;
        r3 = r2;
    L17:
        r0.add(r2);
        r1 = r5;
        goto L4
    L12:
        r7 = null;
        goto L14
    L8:
        ILinkPlayerInfoBridge r8 = n.a(r4.a);
        r8.setOpenSendGift(this.b.booleanValue());
        r2 = ch0.e.a(r4, r8, null, null, null, 14);
        r5 = true;
        goto L9
    L19:
        return new h.a(r1, r0, r3);
    }

    public e(DataCenter r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.d = r2;
        this.e = r3;
        this.b = (Boolean) r2.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE);
        this.c = new b(this);
    }
}
