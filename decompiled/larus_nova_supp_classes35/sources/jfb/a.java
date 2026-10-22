package jfb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter.FileItemViewHolder;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.a0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a<VH extends FileInfoAdapter.FileItemViewHolder> implements com.ss.android.lark.filedetail.impl.folder.manage.adapter.b<nfb.a, VH> {
    public a() {
    }

    public void b(VH r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "holder");
    }

    public abstract Pair<String, String> c(TextView r1, nfb.a r2);

    public abstract SimpleTarget<Drawable> d(LKUIRoundedImageView2 r1, int r2, boolean r3);

    public final void e(VH r10, nfb.a r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        Pair<String, String> r0 = c(r10.b, r11);
        r10.b.setText((CharSequence) r0.getFirst());
        r10.c.setText((CharSequence) r0.getSecond());
        Context r1 = r10.a.getContext();
        String r2 = r11.i;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        String r5 = r11.c;
        FileType r6 = r11.getType();
        FileType r7 = FileType.FOLDER;
        if (r6 != r7) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L25;
        String r9 = FileUtils.m(r5);
        if (r9 == null) goto L25;
        if (r9.length() <= 0) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == false) goto L25;
        if (com.ss.android.lark.utils.FileType.getFileTypeBySuffix(r9) != com.ss.android.lark.utils.FileType.TYPE_VIDEO) goto L25;
        boolean r13 = true;
    L26:
        if (r13 == false) goto L29;
        if (r4 == false) goto L29;
        boolean r14 = true;
    L30:
        int r15 = UIUtils.dp2px(r1, 100.0f);
        String r16 = r11.c;
        if (r11.getType() == r7) goto L34;
        r3 = false;
    L34:
        int r17 = a0.c(BuildConfig.FLAVOR, r16, r3);
        if (r4 == false) goto L41;
        IRequestCreator r18 = ImageLoader.with(r1);
        String r19 = r11.i;
        if (r19 == null) goto L39;
        EncryptImage r20 = new EncryptImage(r19);
    L40:
        r18.load(r20).asDrawable().override(r15, r15).error(r17).into(d(r10.a, r17, r14));
    L42:
        b(r10, r4, r14);
        return;
    L39:
        r20 = null;
        goto L40
    L41:
        r10.a.setImageResource(r17);
    L29:
        r14 = false;
        goto L30
    L20:
        r12 = false;
    L25:
        r13 = false;
        goto L26
    L11:
        r8 = false;
        goto L12
    L5:
        if (r2.length() <= 0) goto L7;
        r4 = true;
        goto L8
    }
}
