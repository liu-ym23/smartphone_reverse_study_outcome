package com.ss.android.lark.flow.chat.page.flow.plugin;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.message.lynxcard.message.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public IMessageListComponent g;
    public String h;

    public static final class a implements IMessageListComponent.a {
        public final /* synthetic */ l a;

        /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.plugin.l$a$a, reason: collision with other inner class name */
        public static final class C0035a implements hya.c<String, f5b.b> {
            public final /* synthetic */ String a;

            /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.plugin.l$a$a$a, reason: collision with other inner class name */
            public static final class C0036a extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
                public C0036a() {
                }

                public final f5b.b b(Object r2) {
                    f5b.b r3 = (f5b.b) r2;
                    Intrinsics.checkNotNullParameter(r3, "existedItem");
                    return r3;
                }
            }

            public final hya.a<f5b.b> a() {
                return new C0036a();
            }

            public final hya.b<String> b() {
                return new BasePageStore.e(this.a);
            }

            public C0035a(String r1) {
                this.a = r1;
            }
        }

        public static final class b implements hya.c<String, f5b.b> {
            public final /* synthetic */ String a;

            /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.plugin.l$a$b$a, reason: collision with other inner class name */
            public static final class C0037a extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
                public C0037a() {
                }

                public final f5b.b b(Object r2) {
                    f5b.b r3 = (f5b.b) r2;
                    Intrinsics.checkNotNullParameter(r3, "existedItem");
                    return r3;
                }
            }

            public final hya.a<f5b.b> a() {
                return new C0037a();
            }

            public final hya.b<String> b() {
                return new BasePageStore.e(this.a);
            }

            public b(String r1) {
                this.a = r1;
            }
        }

        public final /* synthetic */ void A9() {
        }

        public final void B9(ChatChatter r2) {
            Intrinsics.checkNotNullParameter(r2, "chatChatter");
        }

        public final void e(BasePageStore r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
        }

        public final void w9(ThreadTopic r2) {
            Intrinsics.checkNotNullParameter(r2, "threadTopic");
        }

        public final /* synthetic */ void y9() {
        }

        public final void z9(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
        }

        public final void x9() {
            IMessageListComponent r0 = this.a.g;
            if (r0 == null) goto L7;
            MutableLiveData r1 = r0.getMessageList();
            if (r1 == null) goto L7;
            List r2 = (List) r1.getValue();
        L8:
            List r3 = r2;
            if (r3 != null) goto L11;
        L14:
            boolean r4 = true;
        L15:
            if (r4 == false) goto L17;
            return;
        L17:
            y6b.c r5 = (y6b.c) CollectionsKt.last(r2);
            int r6 = r2.size();
            Iterator r7 = r2.iterator();
            int r8 = 0;
        L19:
            if (r7.hasNext() == false) goto L29;
            Object r9 = r7.next();
            int r10 = r8 + 1;
            if (r8 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            y6b.c r11 = (y6b.c) r9;
            if (r8 != (r6 - 1)) goto L26;
            boolean r12 = true;
        L27:
            r11.K2 = r12;
            r8 = r10;
            goto L19
        L26:
            r12 = false;
            goto L27
        L29:
            if (r2.size() >= 2) goto L31;
            String r13 = "";
        L32:
            String r14 = r5.c;
            if (Intrinsics.areEqual(r14, this.a.h) == true) goto L50;
            ArrayList r15 = new ArrayList();
            if (r.a(r13) == false) goto L38;
            r15.add(new C0035a(r13));
        L38:
            if (r.a(r14) == false) goto L41;
            r15.add(new b(r14));
        L41:
            if ((!r15.isEmpty()) == false) goto L45;
            IMessageListComponent r16 = this.a.g;
            if (r16 == null) goto L45;
            r16.batchUpdateMsg(r15);
        L45:
            l r17 = this.a;
            r17.h = r14;
            r5.isPreMessage();
            r17.getClass();
            return;
        L50:
            return;
        L31:
            r13 = ((y6b.c) ListProtector.get(r2, r6 - 2)).c;
            goto L32
        L11:
            if (r3.isEmpty() == true) goto L14;
            r4 = false;
        L7:
            r2 = null;
            goto L8
        }

        public a(l r1) {
            this.a = r1;
        }
    }

    public l() {
        this.h = "";
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r2, r3);
        IMessageListComponent r4 = r2.a(IMessageListComponent.class);
        this.g = r4;
        if (r4 == null) goto L7;
        MutableLiveData r5 = r4.getMessageList();
        if (r5 == null) goto L7;
        List r6 = (List) r5.getValue();
    L8:
        List r7 = r6;
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == true) goto L17;
        y6b.c r9 = (y6b.c) CollectionsKt.last(r6);
        this.h = r9.c;
        r9.isPreMessage();
    L17:
        IMessageListComponent r10 = this.g;
        if (r10 == null) goto L21;
        r10.m(new a(this));
        return;
    L21:
        return;
    L11:
        if (r7.isEmpty() == true) goto L14;
        r8 = false;
    L7:
        r6 = null;
        goto L8
    }
}
