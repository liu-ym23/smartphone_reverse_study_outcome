package com.ss.android.lark.contact.impl.group.join;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends BaseModel implements a {
    public boolean a;
    public boolean b;
    public long c;
    public final List<Chat> d;

    public c() {
        this.a = true;
        this.b = false;
        this.c = 0;
        this.d = new ArrayList();
    }

    @Override // com.ss.android.lark.contact.impl.group.join.a
    public final boolean isHasMore() {
        return this.a;
    }

    @Override // com.ss.android.lark.contact.impl.group.join.a
    public final void N0(final UIGetDataCallback r6) {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        ContactBaseModuleDependency.b.getClass();
        ContactBaseModuleDependency.a().h(this.c, (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new MyJoinGroupModel$2(this, r6)));
    }

    public final void h(List<Chat> r6) {
        if (this.c != 0) goto L6;
        ((ArrayList) this.d).clear();
        ((ArrayList) this.d).addAll(r6);
        return;
    L6:
        HashSet r0 = new HashSet();
        Iterator<Chat> r1 = r6.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r0.add(r1.next().getId());
        goto L8
    L10:
        Iterator r2 = ((ArrayList) this.d).iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        if (r0.contains(((Chat) r2.next()).getId()) == false) goto L12;
        r2.remove();
        goto L12
    L16:
        ((ArrayList) this.d).addAll(r6);
    }

    @Override // com.ss.android.lark.contact.impl.group.join.a
    public final void t5(final UIGetDataCallback r4) {
        ContactBaseModuleDependency.b.getClass();
        ContactBaseModuleDependency.a().i((IGetDataCallback) getCallbackManager().wrapAndAddCallback(new MyJoinGroupModel$1(this, r4)));
    }
}
