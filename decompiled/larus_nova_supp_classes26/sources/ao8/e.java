package ao8;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.chat.standarduikit.vlm.view.l;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.VLMImage;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RenderType.values().length];
            r0[RenderType.Picture.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RenderType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final String a(l r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        RenderType r2 = r1.h;
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        return "picture";
    L5:
        if (r3 == 2) goto L7;
        return "graphic";
    L7:
        return "video";
    }

    public static final List<Integer> b(l r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        VLMImage r4 = r3.i.a;
        if (r4 == null) goto L12;
        Integer[] r0 = new Integer[2];
        Integer r1 = r4.getOriginWidth();
        int r2 = 0;
        if (r1 == null) goto L7;
        int r5 = r1.intValue();
    L8:
        r0[0] = Integer.valueOf(r5);
        Integer r6 = r4.getOriginHeight();
        if (r6 == null) goto L11;
        r2 = r6.intValue();
    L11:
        r0[1] = Integer.valueOf(r2);
        return CollectionsKt.listOf(r0);
    L7:
        r5 = 0;
        goto L8
    L12:
        return null;
    }

    public static final void c(final SimpleDraweeView r17, l r18, String r19, final Function0<Unit> r20, final Function0<Unit> r21, final Function0<Unit> r22) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "vlmVlmRenderInfo");
        Intrinsics.checkNotNullParameter(r19, ShareType.URL);
        if (r18.h != RenderType.Video) goto L5;
        MessageImageType r5 = MessageImageType.VIDEO;
    L6:
        if (r20 != null) goto L10;
        if (r21 != null) goto L10;
        if (r22 != null) goto L10;
        MessageImageType r2 = r5;
        IMessageImageLoaderService.a.a(MessageImageLoader.a, r18.a, r2, r17, r19, "VlmMixedMediaCardWidget", new ao8.a(r17), 32);
        return;
    L10:
        MessageImageType r3 = r5;
        IMessageImageLoaderService.a.b(MessageImageLoader.a, r18.a, r3, r17, r19, "VlmMixedMediaCardWidget", null, null, new b(r21), new c(r20), new d(r22), false, 1120);
        return;
    L5:
        r5 = MessageImageType.IMAGE;
        goto L6
    }
}
