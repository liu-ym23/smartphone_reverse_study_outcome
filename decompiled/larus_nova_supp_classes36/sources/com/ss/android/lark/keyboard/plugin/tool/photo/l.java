package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.text.TextUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements d {
    public final /* synthetic */ List<VideoInfo> a;
    public final /* synthetic */ PhotoKBPlugin b;

    public static final class a implements Runnable {
        public final /* synthetic */ PhotoKBPlugin a;
        public final /* synthetic */ ErrorResult b;

        public a(PhotoKBPlugin r1, ErrorResult r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.a.n().l().getContext(), this.b.getDisplayMsg(UIHelper.getString(2131891714)));     // Catch: Throwable -> L4
            this.a.i.dismiss();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PhotoKBPlugin a;

        public b(PhotoKBPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i.dismiss();     // Catch: Throwable -> L4
            this.a.n().z().z();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ List<VideoInfo> a;
        public final /* synthetic */ Map<String, FrameInfo> b;
        public final /* synthetic */ PhotoKBPlugin c;

        public c(List<VideoInfo> r1, Map<String, FrameInfo> r2, PhotoKBPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            List<VideoInfo> r0 = this.a;
            Map<String, FrameInfo> r1 = this.b;
            PhotoKBPlugin r2 = this.c;
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L13;
            VideoInfo r7 = (VideoInfo) r3.next();
            FrameInfo r8 = r1.get(r7.getPath());
            if (r8 == null) goto L12;
            if (TextUtils.isEmpty(r8.getPath()) == true) goto L12;
            int r4 = PhotoKBPlugin.w;
            r2.getClass();
            com.ss.android.lark.widget.span.b.b.a r5 = new com.ss.android.lark.widget.span.b.b.a(r8.getPath(), r8.getWidth(), r8.getHeight());
            Object r6 = r2.n().L().c();
            if ((r6 instanceof FunctionEditText) == false) goto L4;
            ((com.ss.android.lark.keyboard.edittext2.edittors.e) ((FunctionEditText) r6).q(com.ss.android.lark.keyboard.edittext2.edittors.e.e)).insert(new hob.g(r5, (int) r7.getDuration(), r7, r8, null));
            r2.f.a();
        L12:
            Log.e("get first frame failed：" + r7.getPath());
            goto L4
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.d
    public final void onFinish() {
        UICallbackExecutor.execute(new b(this.b));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.d
    public final void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        UICallbackExecutor.execute(new a(this.b, r3));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.d
    public final void onSuccess(Map<String, FrameInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "ret");
        UICallbackExecutor.execute(new c(this.a, r4, this.b));
    }

    public l(List<VideoInfo> r1, PhotoKBPlugin r2) {
        this.a = r1;
        this.b = r2;
    }
}
