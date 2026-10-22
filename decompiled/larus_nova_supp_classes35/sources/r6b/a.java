package r6b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.d;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {

    /* JADX INFO: renamed from: r6b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0292a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        Message.Type r0 = r4.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        String r2 = ((MediaContent) r4.getContent()).getCompressPath();
        if (r2 != null) goto L22;
    L21:
        r2 = BuildConfig.FLAVOR;
    L22:
        Log.i("MediaSendUtils", "getCompressPath, cid:" + r4.getcId() + ", type:" + r0 + ", compressPath:" + r2.hashCode());
        return r2;
    L9:
        if (r1 != 2) goto L21;
        RichText r3 = ((PostContent) r4.getContent()).getRichText();
        if (r3 == null) goto L14;
        RichTextElement.MediaProperty r5 = (RichTextElement.MediaProperty) CollectionsKt.firstOrNull(d.d(r3));
    L15:
        if (r5 == null) goto L21;
        r2 = r5.getCompressPath();
        if (r2 != null) goto L22;
    L14:
        r5 = null;
        goto L15
    L5:
        r1 = C0292a.a[r0.ordinal()];
        goto L7
    }

    @JvmStatic
    public static final String b(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        Message.Type r0 = r4.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        String r2 = ((MediaContent) r4.getContent()).getOriginPath();
        if (r2 != null) goto L22;
    L21:
        r2 = BuildConfig.FLAVOR;
    L22:
        Log.i("MediaSendUtils", "getOriginPath, cid:" + r4.getcId() + ", type:" + r0 + ", originPath:" + r2.hashCode());
        return r2;
    L9:
        if (r1 != 2) goto L21;
        RichText r3 = ((PostContent) r4.getContent()).getRichText();
        if (r3 == null) goto L14;
        RichTextElement.MediaProperty r5 = (RichTextElement.MediaProperty) CollectionsKt.firstOrNull(d.d(r3));
    L15:
        if (r5 == null) goto L21;
        r2 = r5.getOriginPath();
        if (r2 != null) goto L22;
    L14:
        r5 = null;
        goto L15
    L5:
        r1 = C0292a.a[r0.ordinal()];
        goto L7
    }
}
