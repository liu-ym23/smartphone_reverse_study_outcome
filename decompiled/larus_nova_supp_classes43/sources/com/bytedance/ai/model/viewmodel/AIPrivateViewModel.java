package com.bytedance.ai.model.viewmodel;

import com.bytedance.assem.arch.viewModel.AssemViewModel;
import com.bytedance.assem.arch.viewModel.h;
import java.util.HashMap;
import java.util.Iterator;
import u4.b;
import u4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AIPrivateViewModel extends AssemViewModel<i5.a> {

    public static class a implements a6.a {
        public final g a;

        @Override // a6.a
        public final b getIStorage() {
            return this.a;
        }

        public a(String r10) {
            this.a = new g(false, r10);
        }
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public i5.a m18defaultState() {
        return new i5.a(new HashMap());
    }

    public void onCleared() {
        Iterator<a6.a> r0 = ((i5.a) getState()).a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getIStorage().cleanup();
        goto L4
    L6:
        super.onCleared();
    }

    public AIPrivateViewModel() {
    }

    public /* bridge */ /* synthetic */ h defaultState() {
        return m18defaultState();
    }

    public a6.a getIAIViewModel(String r10) {
        i5.a r0 = (i5.a) getState();
        a6.a r1 = r0.a.get(r10);
        if (r1 != null) goto L6;
        a r11 = new a(r10);
        r0.a.put(r10, r11);
        return r11;
    L6:
        return r1;
    }
}
