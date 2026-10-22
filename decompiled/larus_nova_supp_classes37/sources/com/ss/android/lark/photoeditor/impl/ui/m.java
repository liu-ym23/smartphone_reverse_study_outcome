package com.ss.android.lark.photoeditor.impl.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements b.a {
    public final /* synthetic */ o a;

    public class a implements com.ss.android.lark.photoeditor.impl.ui.a.InterfaceC0097a {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ m c;

        public a(m r1, Bitmap r2, ArrayList r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public m(o r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b.a
    public final void F6(String r9, Bitmap r10) {
        if ("from_screenshot_forward_preview".equals(this.a.c) == false) goto L6;
        b r0 = (b) this.a.getView();
        o r11 = this.a;
        r0.v2(r9, r11.d, r11.e, r11.g, r11.h, r11.i, r11.j);
        return;
    L6:
        o.a r1 = this.a.f;
        PhotoEditorFragment.b r2 = (PhotoEditorFragment.b) r1;
        r2.b(r9, r9, new Pair(Integer.valueOf(r10.getWidth()), Integer.valueOf(r10.getHeight())), null);
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b.a
    public final void L7(final Bitmap r8, final ArrayList<pfc.f.a> r9) {
        Log.i("PhotoEditorPresenter", "resultPath:" + this.a.b);
        if (TextUtils.isEmpty(this.a.b) == true) goto L31;
        Activity r0 = this.a.a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isFinishing() == false) goto L9;
        return;
    L9:
        if (this.a.a.isDestroyed() == true) goto L34;
        o r1 = this.a;
        Activity r2 = r1.a;
        String r3 = r1.b;
        String r4 = r2.getCacheDir().getAbsolutePath();     // Catch: Exception -> L21
        String r5 = r2.getFilesDir().getAbsolutePath();     // Catch: Exception -> L21
        String r6 = r2.getExternalCacheDir().getAbsolutePath();     // Catch: Exception -> L21
        String r7 = r2.getExternalFilesDir(null).getAbsolutePath();     // Catch: Exception -> L21
        if (r3.contains(r4) == false) goto L15;
    L20:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L27;
        b(r8, r9);
        return;
    L27:
        StoragePermissionUtils.f(this.a.a, new i(this, r8, r9), 16, new Token("LARK-PSDA-android_photo_editor_request_permission"), new String[0]);
        return;
    L15:
        if (r3.contains(r5) == true) goto L20;
        if (r3.contains(r6) == true) goto L20;
        if (r3.contains(r7) == true) goto L20;
    L23:
        r10 = false;
    L21:
        e = move-exception;
        Log.e("PhotoEditorUtil", "isLarkDataPath:" + e);
        goto L23
    L34:
        return;
    }

    public final void b(Bitmap r4, ArrayList<pfc.f.a> r5) {
        Log.i("PhotoEditorPresenter", "performSave");
        ((b) this.a.getView()).A2();
        ((com.ss.android.lark.photoeditor.impl.ui.a) this.a.getModel()).m1(r4, this.a.b, new a(this, r4, r5));
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.b.a
    public final void n0(Bitmap r2, vfc.d r3) {
        ((com.ss.android.lark.photoeditor.impl.ui.a) this.a.getModel()).n0(r2, r3);
    }
}
