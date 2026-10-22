package com.ss.android.lark.photoeditor.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import com.ss.android.photoeditor.util.PhotoMemoryUtils;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r implements com.ss.android.lark.photoeditor.impl.ui.b {
    public final Context a;
    public final View b;
    public final String c;
    public final String d;
    public List<RectF> e;
    public com.ss.android.lark.photoeditor.impl.ui.b.a f;
    public final b g;
    public CommonLoadingDialog h;
    public FrameLayout i;
    public ofc.b j;
    public final q0c.b.a k;
    public ujb.f l;
    public int m;

    public class a implements jkc.b {
        public final /* synthetic */ File a;
        public final /* synthetic */ View b;
        public final /* synthetic */ r c;

        public final void a(final PolarisFileWrapper r4) {
            Log.i("PhotoEditorView", "[cipher] file decrypt success, original path = " + this.a.getAbsolutePath() + ", new path = " + r4.getAbsolutePath());
            final r r0 = this.c;
            final View r1 = this.b;
            r0.getClass();
            r0.m = PhotoMemoryUtils.a();
            UICallbackExecutor.post(new q(r0, r4, r1));
        }

        public final void b(DecryptException r2) {
            Log.e("PhotoEditorView", "[cipher] file decrypt failed, original path = " + this.a.getAbsolutePath());
            r r3 = this.c;
            r3.getClass();
            UICallbackExecutor.post(new p(r3));
        }

        public a(r r1, VFSFile r2, View r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public interface b {
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void A2() {
        CommonLoadingDialog r0 = this.h;
        if (r0 == null) goto L6;
        r0.show(this.a);
        return;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void K3() {
        CommonLoadingDialog r0 = this.h;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public final void create() {
        this.h = new CommonLoadingDialog();
        FrameLayout r0 = (FrameLayout) this.b.findViewById(2131382248);
        this.i = r0;
        StatusBarUtil.setTranslucentForImageView((Activity) this.a, 178, new View[]{r0});
        View r1 = this.b.findViewById(2131382248);
        VFSFiles.b.getClass();
        VFSFile r2 = VFSFiles.b(true).i(this.d);
        a r3 = new a(this, r2, r1);
        int r4 = CipherManager.a;
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r2, "file");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.lark.android.encryption.a(r2, true, r3));
    }

    public final void destroy() {
        ofc.b r0 = this.j;
        if (r0 == null) goto L5;
        r0.a();
        this.j = null;
    L5:
        ujb.f r1 = this.l;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.d() == false) goto L12;
        this.l.close();
        return;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final boolean onBackPressed() {
        b r0 = this.g;
        if (r0 == null) goto L7;
        ((PhotoEditorFragment.a) r0).a.finish();
        return true;
    L7:
        return true;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void y() {
        UICallbackExecutor.post(new p(this));
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.f = (com.ss.android.lark.photoeditor.impl.ui.b.a) r1;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void showToast(String r2) {
        LKUIToast.show(this.a, r2);
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void z(int r2) {
        LKUIToast.show(this.a, 2131892247);
    }

    public r(FragmentActivity r2, View r3, String r4, String r5, PhotoEditorFragment.a r6) {
        this.m = -1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.g = r6;
        this.k = p0c.a.a().getGuideDependency();
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b
    public final void v2(String r15, boolean r16, boolean r17, String r18, String r19, String r20, q0c.a r21) {
        boolean r10 = "from_screenshot_forward_preview".equals(this.c);
        ArrayList r12 = new ArrayList();
        r12.add(new r0c.c(this.a, r17, r15, r10));
        r12.add(new r0c.b(this.a, r10, r15));
        if (r10 == false) goto L5;
        int r8 = 2131892137;
    L6:
        r12.add(new r0c.k(this.a, r16, r15, r18, r19, r20, r8, r10, r10, r21));
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = r12.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        r0c.d r3 = (r0c.d) r2.next();
        if (r3.isValid() == false) goto L8;
        r1.put(r3.a(), r3);
        goto L8
    L12:
        String[] r4 = (String[]) r1.keySet().toArray(new String[0]);
        com.larksuite.component.ui.dialog.i r5 = new com.larksuite.component.ui.dialog.i(this.a);
        r5.n(r4);
        ((com.larksuite.component.ui.dialog.b) r5).f = new t(r4, r1);
        ((com.larksuite.component.ui.dialog.b) r5).g.itemTextColor(2131101892);
        r5.b(2131378548, UIUtils.getString(this.a, 2131891541), null);
        r5.i();
        return;
    L5:
        r8 = 2131892145;
        goto L6
    }
}
