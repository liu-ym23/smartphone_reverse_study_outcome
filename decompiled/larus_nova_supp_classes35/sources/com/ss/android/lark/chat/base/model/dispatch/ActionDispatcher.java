package com.ss.android.lark.chat.base.model.dispatch;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ActionDispatcher extends ViewModel {
    private List<a> mActionHandlers;

    public interface a {
        boolean a(com.ss.android.lark.chat.base.model.dispatch.a r1);
    }

    public ActionDispatcher() {
        this.mActionHandlers = new ArrayList();
    }

    public static ActionDispatcher from(FragmentActivity r1) {
        return (ActionDispatcher) ViewModelProviders.of(r1).get(ActionDispatcher.class);
    }

    public void dispatch(com.ss.android.lark.chat.base.model.dispatch.a r3) {
        if (this.mActionHandlers.isEmpty() == true) goto L9;
        Iterator<a> r0 = this.mActionHandlers.iterator();
    L6:
        if (r0.hasNext() == false) goto L13;
        if (r0.next().a(r3) == false) goto L6;
        return;
    L13:
        return;
    }

    public <Result> Result dispatchSyncQuery(j<?, Result> r3) {
        if (this.mActionHandlers.isEmpty() == true) goto L11;
        Iterator<a> r0 = this.mActionHandlers.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        if (r0.next().a(r3) == false) goto L6;
        return r3.a;
    L16:
        return null;
    L11:
        return null;
    }

    public void registerActionListener(a r2) {
        if (this.mActionHandlers.contains(r2) == true) goto L6;
        this.mActionHandlers.add(r2);
        return;
    }

    public void unregisterActionHandler(a r2) {
        this.mActionHandlers.remove(r2);
    }
}
