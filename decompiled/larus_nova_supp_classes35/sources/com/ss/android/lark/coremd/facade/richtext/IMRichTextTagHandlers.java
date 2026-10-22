package com.ss.android.lark.coremd.facade.richtext;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.richtextmd.parse.impl.RichTextTagHandlers;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMRichTextTagHandlers {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public static final class AtTagHandler extends RichTextTagHandlers.a {
        public AtTagHandler() {
        }

        public final s b(final b3c.b r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            final s r0 = super.b(r5);
            final RichTextElement.AtProperty r1 = r5.getElement().getProperty();
            IMAtNodeExtend.i.b(new IMRichTextTagHandlers$AtTagHandler$mapToNode$1(r0, r1, r5));
            return r0;
        }
    }

    public static final class ImageHandler extends RichTextTagHandlers.ImageTagHandler {
        public ImageHandler() {
        }

        public final s b(b3c.b r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            final s r0 = super.b(r4);
            final RichTextElement.ImageProperty r5 = r4.getElement().getProperty();
            IMImageExtend.p.b(new IMRichTextTagHandlers$ImageHandler$mapToNode$1(r0, r5));
            return r0;
        }
    }

    public static final class MediaHandler extends RichTextTagHandlers.q {
        public MediaHandler() {
        }

        public final s b(b3c.b r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            final s r0 = super.b(r5);
            final RichTextElement.MediaProperty r6 = r5.getElement().getProperty();
            final Image r1 = r6.getOriginImage();
            if (r1 != null) goto L9;
            Intrinsics.checkNotNull(r6);
            r1 = new Image();
            r1.setWidth(r6.getWidth());
            r1.setHeight(r6.getHeight());
            r1.setKey(r6.getKey());
            r1.setUrls(CollectionsKt.listOf(r6.getCoverPath()));
            if (r6.getResourceCleanScene() == null) goto L7;
            boolean r2 = true;
        L8:
            r1.setResourceIsCleaned(r2);
            r1.setResourceCleanScene(r6.getResourceCleanScene());
            goto L9
        L7:
            r2 = false;
        L9:
            IMMediaExtend.q.b(new IMRichTextTagHandlers$MediaHandler$mapToNode$1(r0, r1, r6));
            return r0;
        }
    }

    static {
        a = LazyKt.lazy(IMRichTextTagHandlers$atTagHandler$2.INSTANCE);
        b = LazyKt.lazy(IMRichTextTagHandlers$imageHandler$2.INSTANCE);
        c = LazyKt.lazy(IMRichTextTagHandlers$mediaHandler$2.INSTANCE);
        d = LazyKt.lazy(IMRichTextTagHandlers$textBizExtend$2.INSTANCE);
    }
}
