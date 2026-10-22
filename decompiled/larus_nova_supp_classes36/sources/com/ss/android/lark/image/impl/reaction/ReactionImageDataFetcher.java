package com.ss.android.lark.image.impl.reaction;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.entity.ReactionImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.a0;
import java.io.FileNotFoundException;
import java.io.InputStream;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ReactionImageDataFetcher extends ResourceImageDataFetcher<ReactionImage> {
    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "ReactionImageFetcher";
    }

    public ReactionImageDataFetcher(ReactionImage r1) {
        super(r1);
    }

    private String getReactionImagePath(ReactionImage r3) {
        e r0 = (e) ApiUtils.getApi(e.class);
        String r1 = a0.g(LarkContext.getApplication());
        return r0.getImageService().getReactionImage(r1, r3.getReactionKey());
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(ReactionImage r4) throws FileNotFoundException {
        String r0 = getReactionImagePath(r4);
        Log.i("ReactionImageFetcher", "load reaction image, key is:" + r4.getReactionKey() + ", path is:" + r0);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return new PolarisFileInputStreamWrapper(r0);
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(ReactionImage r1) throws FileNotFoundException {
        return getResourceStream2(r1);
    }
}
