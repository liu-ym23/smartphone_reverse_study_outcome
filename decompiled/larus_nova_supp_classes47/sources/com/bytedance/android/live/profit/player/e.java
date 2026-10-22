package com.bytedance.android.live.profit.player;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ Single a(e r13, Context r14, String r15, a5 r16, Map r17, TextAlignType r18, String r19, String r20, int r22, o.e r23, int r24) {
            if ((r24 & 128) == 0) goto L5;
            int r10 = -1;
        L7:
            if ((r24 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L9;
            boolean r12 = true;
        L11:
            if ((r24 & 512) == 0) goto L13;
            o.e r110 = null;
        L15:
            return r13.a(r14, r15, r16, r17, r18, r19, r20, r10, r12, r110);
        L13:
            r110 = r23;
            goto L15
        L9:
            r12 = false;
            goto L11
        L5:
            r10 = r22;
            goto L7
        }
    }

    Single<s<List<MaskSrc>>> a(Context r1, String r2, a5 r3, Map<String, ? extends c5> r4, TextAlignType r5, String r6, String r7, int r8, boolean r9, o.e r10);

    Single<s<Bitmap>> b(Context r1, a5 r2, Map<String, ? extends c5> r3, int r4, int r5, TextAlignType r6);
}
