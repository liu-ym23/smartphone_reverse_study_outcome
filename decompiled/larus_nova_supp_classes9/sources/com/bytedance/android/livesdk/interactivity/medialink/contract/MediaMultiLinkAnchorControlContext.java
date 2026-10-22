package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/contract/MediaMultiLinkAnchorControlContext;", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/MediaLinkContext;", "<init>", "()V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAnchorControlContext extends MediaLinkContext {
    public static final a Companion = null;

    public static final class a {
        @JvmStatic
        public final MediaMultiLinkAnchorControlContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MediaLinkContext.class);
            if ((r0 instanceof MediaMultiLinkAnchorControlContext) == true) goto L6;
            r0 = null;
        L6:
            return (MediaMultiLinkAnchorControlContext) r0;
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final MediaMultiLinkAnchorControlContext getContext() {
        return Companion.getContext();
    }

    public MediaMultiLinkAnchorControlContext() {
    }
}
