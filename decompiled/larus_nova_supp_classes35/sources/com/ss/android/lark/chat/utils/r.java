package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements Runnable {
    public final /* synthetic */ PhotoItem a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ q.a c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ PhotoItem g;

        public a(Context r1, Fragment r2, File r3, String r4, boolean r5, boolean r6, PhotoItem r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void a() {
            w4b.c r0 = ChatCoreModule.a();
            Context r1 = this.a;
            Fragment r2 = this.b;
            String r4 = this.c.getAbsolutePath();
            String r5 = this.d + System.currentTimeMillis() + ".jpg";
            boolean r6 = this.e;
            boolean r7 = this.f;
            String r8 = this.g.getImageKey();
            MessageIdentity r9 = this.g.getMessageIdentity();
            String r10 = null;
            if (r9 == null) goto L5;
            String r11 = r9.getChatId();
        L6:
            MessageIdentity r12 = this.g.getMessageIdentity();
            if (r12 == null) goto L9;
            r10 = r12.getMessageId();
        L9:
            r0.startPhotoEditorActivityFromPreview(r1, r2, 2, r4, r5, r6, r7, r8, r11, r10);
            return;
        L5:
            r11 = null;
            goto L6
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

    public r(PhotoItem r1, Context r2, e3b.a.c r3, Fragment r4, boolean r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        this.a.getCurrentUrl();
        com.ss.android.lark.widget.photopicker.f.d r0 = com.ss.android.lark.widget.photopicker.f.a();
        ImageLoader.with(this.b);
        this.a.getImageKey();
        this.a.getEntityId();
        PhotoItem r1 = this.a;
        boolean r3 = false;
        if (r1.getImageKey() != null) goto L5;
    L19:
        Log.i("PhotoUtils", "isResourceImage:" + r3 + ", key:" + r1.getImageKey());
        this.a.getType();
        File r5 = r0.f();
        if (r5 == null) goto L24;
        int r2 = com.suite.lark.platform.component.storage.file.dirs.h.c;
        com.suite.lark.platform.component.storage.file.dirs.h r4 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(this.b);
        r4.c(com.ss.android.lark.im.base.a.b());
        UICallbackExecutor.execute(new a(this.b, this.d, r5, r4.b(new com.suite.lark.platform.component.storage.file.dirs.e()).getRealPath(), this.e, this.f, this.a));
        if (this.c.a() == false) goto L34;
        q.a.f(this.c.getChatId(), this.a.getImageKey());
        return;
    L34:
        return;
    L24:
        Log.e("EditImageUtils", "resource == null");
        return;
    L5:
        if (r1.getImageKey().contains("http") == true) goto L19;
        Iterator r6 = r1.getPaths().iterator();
    L8:
        if (r6.hasNext() == false) goto L16;
        String r7 = (String) r6.next();
        if (TextUtils.isEmpty(r7) == true) goto L8;
        if (FileUtils.s(r7) == false) goto L8;
        if (FileUtils.r(r7) == false) goto L8;
        Log.i("PhotoUtils", "PhotoItem is local, path:" + r7);
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
        r3 = true;
        goto L19
    L16:
        r8 = false;
        goto L17
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
