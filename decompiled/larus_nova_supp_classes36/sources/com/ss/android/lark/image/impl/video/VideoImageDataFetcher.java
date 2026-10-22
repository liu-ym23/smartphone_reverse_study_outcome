package com.ss.android.lark.image.impl.video;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.videosend.tools.VideoCoverManager;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class VideoImageDataFetcher extends ResourceImageDataFetcher<VideoImage> {
    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "VideoImageDataFetcher";
    }

    public VideoImageDataFetcher(VideoImage r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(VideoImage r7) throws FileNotFoundException {
        long r0 = SystemClock.elapsedRealtime();
        String r8 = r7.getPath();
        String r2 = VideoCoverManager.getVideoCover(UIHelper.getContext(), r8).a;
        long r3 = SystemClock.elapsedRealtime() - r0;
        Log.d(getLogTag(), "getResourceStream: cost=" + r3 + ", coverPath=" + r2 + ", videoPath=" + r8);
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return new PolarisFileInputStreamWrapper(r2);
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(VideoImage r1) throws FileNotFoundException {
        return getResourceStream2(r1);
    }
}
