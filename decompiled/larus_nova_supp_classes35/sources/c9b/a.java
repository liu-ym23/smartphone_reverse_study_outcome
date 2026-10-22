package c9b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import f06.b;
import f06.c;
import f06.d;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends PthreadAsyncTask<Object, Object, Bitmap> {
    public final ContactMobileBean h;
    public final WeakReference<TextView> i;
    public final WeakReference<ImageView> j;

    public final Object doInBackground(Object[] r18) {
        Intrinsics.checkNotNullParameter(r18, "objects");
        ContentResolver r0 = LarkContext.getApplication().getContentResolver();
        Uri r9 = UriProtector.parse(this.h.getAvatarUri());
        String[] r11 = {"data15"};
        c r12 = new c();
        ByteArrayInputStream r15 = null;
        Object[] r13 = {r9, r11, null, null, null};
        b r16 = new b();
        d r8 = r12.b(240004, "android/content/ContentResolver", "query", r0, r13, "android.database.Cursor", r16);
        if (r8.a == false) goto L5;
        r12.a(240004, "android/content/ContentResolver", "query", r0, r13, null, r16, false);
        Cursor r14 = (Cursor) r8.b;
    L6:
        if (r14 == null) goto L20;
    L15:
        th = move-exception;
        r14.close();
        throw th;
    L9:
        if (r14.moveToFirst() == false) goto L13;
        byte[] r1 = r14.getBlob(0);     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        r15 = new ByteArrayInputStream(r1);     // Catch: Throwable -> L15
    L13:
        r14.close();
        return BitmapFactory.decodeStream(r15);
    L20:
        return null;
    L5:
        r14 = r0.query(r9, r11, null, null, null);
        r12.a(240004, "android/content/ContentResolver", "query", r0, r13, r14, r16, true);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPostExecute(Object r3) {
        Bitmap r4 = (Bitmap) r3;
        super/*android.os.AsyncTask*/.onPostExecute(r4);
        if (this.j.get() != null) goto L5;
        return;
    L5:
        if (r4 == null) goto L9;
        ImageView r1 = this.j.get();
        if (r1 == null) goto L14;
        r1.setVisibility(0);
        r1.setImageBitmap(r4);
        return;
    L14:
        return;
    L9:
        TextView r5 = this.i.get();
        if (r5 == null) goto L16;
        r5.setVisibility(0);
        r5.setText(this.h.getAvatarName());
        return;
    }

    public a(TextView r2, ImageView r3, ContactMobileBean r4) {
        Intrinsics.checkNotNullParameter(r2, "avatarTv");
        Intrinsics.checkNotNullParameter(r3, "avatarIv");
        Intrinsics.checkNotNullParameter(r4, "bean");
        this.h = r4;
        r2.setVisibility(8);
        r3.setVisibility(8);
        this.i = new WeakReference(r2);
        this.j = new WeakReference(r3);
    }
}
