package com.ss.android.lark.contact.customized.newcontact.repository;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public boolean a;
    public boolean b;
    public String c;
    public final List<ChatApplication> d;
    public com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a e;
    public final b f;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.newcontact.repository.a$a, reason: collision with other inner class name */
    public static final class C0176a {
    }

    public static final class b implements f9b.a {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // f9b.a
        public final void a(List<ChatApplication> r2) {
            if (CollectionUtils.isEmpty(r2) == false) goto L5;
            return;
        L5:
            com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a r0 = this.a.e;
            if (r0 == null) goto L9;
            r0.a(r2);
            return;
        }
    }

    static {
    }

    public a() {
        this.a = true;
        this.c = DocTabPayload.DocType.UNKNOWN;
        this.d = new ArrayList();
        this.f = new b(this);
    }
}
