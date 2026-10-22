package com.ss.android.lark.locationmessage.ui.navigation;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.location.dto.Scene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends BasePresenter<b, Object, c> {

    public class a implements c {
        public final /* synthetic */ h a;

        @Override // com.ss.android.lark.locationmessage.ui.navigation.c
        public final boolean isAdminGpsEnabled() {
            return ((b) this.a.getModel()).isAdminGpsEnabled();
        }

        public a(h r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.locationmessage.ui.navigation.c
        public final void S(Context r2, Token r3, Scene r4, u r5) {
            ((b) this.a.getModel()).S(r2, r3, r4, r5);
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    public final void create() {
        super.create();
    }

    public final void destroy() {
        super.destroy();
    }

    public h(NavigateView r2) {
        super(new g(), r2);
    }
}
