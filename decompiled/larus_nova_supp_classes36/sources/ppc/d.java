package ppc;

import android.graphics.BitmapFactory;
import android.util.Size;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements e {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // ppc.e
    public final boolean a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        IForwardContent r0 = r3.d.getForwardContent();
        if ((r0 instanceof ImageForwardContent) == false) goto L5;
    L14:
        return true;
    L5:
        if ((r0 instanceof SingleMessageForwardContent) == false) goto L13;
        Message r4 = r3.d.getSourceMessage();
        if (r4 == null) goto L9;
        Message.Type r5 = r4.getType();
    L11:
        if (r5 != Message.Type.IMAGE) goto L13;
    L9:
        r5 = null;
    L13:
        return false;
    }

    @Override // ppc.e
    public final boolean b(g r17) {
        Intrinsics.checkNotNullParameter(r17, "context");
        IForwardContent r1 = r17.d.getForwardContent();
        if ((r1 instanceof ImageForwardContent) == false) goto L12;
        String r2 = (String) CollectionsKt.firstOrNull(((ImageForwardContent) r1).b);
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r2, "path");
        if (StringsKt.isBlank(r2) == false) goto L10;
        return false;
    L10:
        BitmapFactory.Options r3 = new BitmapFactory.Options();
        r3.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r2, r3);
        Size r4 = h.b(r3.outWidth, r3.outHeight);
        ImageView r5 = h.c(r17);
        r17.c.setBackground(null);
        r17.c.addView(r5, new FrameLayout.LayoutParams(r4.getWidth(), r4.getHeight(), 17));
        ImageLoader.with(r17.getActivity()).load(r2).centerCrop().override(r4.getWidth(), r4.getHeight()).into(r5);
        r17.c.setVisibility(0);
        return true;
    L12:
        Message r6 = r17.d.getSourceMessage();
        if (r6 == null) goto L15;
        ImageContent r7 = (ImageContent) r6.getContent();
    L17:
        if ((r7 instanceof ImageContent) == true) goto L20;
        r7 = null;
    L20:
        if (r7 == null) goto L47;
        ImageSet r8 = r7.getImageSet();
        if (r8 == null) goto L47;
        Image r9 = r8.getOrigin();
        if (r9 == null) goto L29;
        List<String> r10 = r9.getUrls();
        if (r10 == null) goto L29;
        String r11 = (String) CollectionsKt.firstOrNull(r10);
    L30:
        if (r11 != null) goto L32;
    L35:
        boolean r12 = true;
    L36:
        if (r12 == false) goto L38;
    L40:
        Image r13 = r8.getThumbnail();
        if (r13 != null) goto L46;
        Image r14 = r8.getMiddle();
        if (r14 == null) goto L48;
        r9 = r14;
    L48:
        if (r9 != null) goto L50;
        r9 = r17.d.getDialogContent().g;
    L50:
        Image r15 = r9;
        if (r15 == null) goto L53;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r15, LoadParams.ImageFormat.IMAGE);
        Size r16 = h.b(r15.getWidth(), r15.getHeight());
        ImageView r18 = h.c(r17);
        r17.c.setBackground(null);
        r17.c.addView(r18, new FrameLayout.LayoutParams(r16.getWidth(), r16.getHeight(), 17));
        com.ss.android.lark.forwardv3.utils.a.a(r17.getActivity(), r18, false, r15, true, false, r16.getWidth(), r16.getHeight());
        r17.c.setVisibility(0);
        return true;
    L53:
        return false;
    L46:
        r9 = r13;
        goto L48
    L38:
        if (URLUtil.isNetworkUrl(r11) == true) goto L40;
    L32:
        if (StringsKt.isBlank(r11) == true) goto L35;
        r12 = false;
    L29:
        r11 = null;
    L47:
        r9 = null;
        goto L48
    L15:
        r7 = null;
        goto L17
    }
}
