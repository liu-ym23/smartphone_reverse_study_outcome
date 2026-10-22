package com.ss.android.lark.contact.base.contact_list.mvp;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.contact.base.service.InvRequestUtils;
import com.ss.android.lark.contact.base.service.InvRequestUtils$LocalAndServerRequestImpl$localCallback$1;
import com.ss.android.lark.contact.base.service.InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.android.lark.contact.base.service.b0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExternalContactPresenter2 extends BasePresenter<l, m, m.a> {

    public class ViewDelegate implements m.a {
        public final /* synthetic */ ExternalContactPresenter2 a;

        public ViewDelegate(ExternalContactPresenter2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.base.contact_list.mvp.m.a
        public final void N6(String r4) {
            ((l) this.a.getModel()).X3(r4, new UIGetDataCallback(new AnonymousClass1(this)));
        }

        @Override // com.ss.android.lark.contact.base.contact_list.mvp.m.a
        public final void t4(final w8b.a r5) {
            ((l) this.a.getModel()).z4(r5.e, new UIGetDataCallback(new AnonymousClass2(this, r5)));
        }
    }

    public class a implements InvRequestUtils.a<List<w8b.a>> {
        public final /* synthetic */ ExternalContactPresenter2 a;

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void c() {
            ((m) this.a.getView()).hideLoading();
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void onShowLoading() {
            ((m) this.a.getView()).showLoading();
        }

        public a(ExternalContactPresenter2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void a(InvRequestUtils$LocalAndServerRequestImpl$localCallback$1 r3) {
            Log.i("ExternalContactPresenter2", "start load local data");
            ((l) this.a.getModel()).b1(Boolean.TRUE, r3);
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final /* bridge */ /* synthetic */ boolean d(List<w8b.a> r1) {
            return true;
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void e(InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1 r3) {
            Log.i("ExternalContactPresenter2", "start load server data");
            ((l) this.a.getModel()).b1(Boolean.FALSE, r3);
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void f(ErrorResult r21) {
            ((m) this.a.getView()).l3();
            if (r21 == null) goto L5;
            Log.e("ExternalContactPresenter2", "get external contacts failed: " + r21.toString());
        L6:
            ConcurrentHashMap<String, Long> r2 = a0.a;
            Intrinsics.checkNotNullParameter(r21, "err");
            AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Contact, Event.show_external_contacts, ErrorType.SDK, ErrorLevel.Fatal, r21.getErrorCode(), "show_contact_external", "ContactExternalView".concat("V2"), r21.getMessage(), Boolean.TRUE, null, null, null, 7168, null));
            return;
        L5:
            Log.e("ExternalContactPresenter2", "get external contacts failed.");
            goto L6
        }

        @Override // com.ss.android.lark.contact.base.service.InvRequestUtils.a
        public final void b(boolean r4, List<w8b.a> r5) {
            List<w8b.a> r6 = r5;
            StringBuilder r0 = new StringBuilder("isFromLocal: ");
            r0.append(r4);
            r0.append(", size: ");
            if (r6 != null) goto L5;
            int r2 = 0;
        L6:
            r0.append(r2);
            Log.i("ExternalContactPresenter2", r0.toString());
            if (CollectionUtils.isEmpty(r6) == false) goto L9;
            ((m) this.a.getView()).l3();
        L10:
            if (r4 == true) goto L13;
            a0.e(false);
            return;
        L13:
            return;
        L9:
            ((m) this.a.getView()).o2(r6);
            goto L10
        L5:
            r2 = r6.size();
            goto L6
        }
    }

    public class b implements l.a {
        public final /* synthetic */ ExternalContactPresenter2 a;

        public b(ExternalContactPresenter2 r1) {
            this.a = r1;
        }

        public final w8b.a a(String r4) {
            Iterator<w8b.a> r0 = ((m) this.a.getView()).j6().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            w8b.a r1 = r0.next();
            if (r4.equals(r1.e) == false) goto L4;
            return r1;
        L8:
            return null;
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    public final void create() {
        super.create();
        a0.e(true);
        a r0 = new a(this);
        int r1 = InvRequestUtils.a;
        Intrinsics.checkNotNullParameter(r0, "callback");
        Intrinsics.checkNotNullParameter(r0, "callback");
        ViewUtils.runOnUiThread(new b0(new InvRequestUtils.LocalAndServerRequestImpl(r0)));
    }

    public ExternalContactPresenter2(ExternalContactModel2 r1, ExternalContactView2 r2) {
        super(r1, r2);
        r1.a = new b(this);
    }
}
