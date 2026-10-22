package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.model.VideoInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MDLExtraInfoHelper {
    public MDLExtraInfoHelper() {
    }

    public static String createMDLExtraInfo(VideoInfo r4) {
        StringBuilder r0 = new StringBuilder("fileId=");
        String r1 = r4.getValueStr(28);
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        String r3 = r4.getValueStr(29);
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r1);
        r0.append("&bitrate=");
        r0.append(r4.getValueInt(44));
        r0.append("&pcrc=");
        r0.append(TTHelper.encodeUrl(r2));
        return r0.toString();
    }

    public static String addPCDNFlag(int r0, String r1) {
        throw new UnsupportedOperationException("toB only");
    }

    public static void addTags(DataLoaderHelper.DataLoaderTaskItem r2, DataLoaderHelper.DataLoaderTaskItem.TrackItem r3) {
        if (r2.mTag == null) goto L9;
        if (r3.mExternalInfo != null) goto L7;
        r3.mExternalInfo = "tag=" + TTHelper.encodeUrl(r2.mTag);
        goto L9
    L7:
        r3.mExternalInfo += "&tag=" + TTHelper.encodeUrl(r2.mTag);
    L9:
        if (r2.mSubTag != null) goto L11;
        return;
    L11:
        if (r3.mExternalInfo != null) goto L13;
        r3.mExternalInfo = "stag=" + TTHelper.encodeUrl(r2.mSubTag);
        return;
    L13:
        r3.mExternalInfo += "&stag=" + TTHelper.encodeUrl(r2.mSubTag);
    }

    public static String createMDLExtraInfo(VideoInfo r4, DataLoaderHelper.DataLoaderTaskItem r5) {
        StringBuilder r0 = new StringBuilder("fileId=");
        String r1 = r4.getValueStr(28);
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        String r3 = r4.getValueStr(29);
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        int r6 = r4.getValueInt(44);
        r0.append(r1);
        r0.append("&bitrate=");
        r0.append(r6);
        r0.append("&pcrc=");
        r0.append(TTHelper.encodeUrl(r2));
        r0.append("&tag=");
        r0.append(TTHelper.encodeUrl(r5.mTag));
        if (TextUtils.isEmpty(r5.mSubTag) == true) goto L13;
        r0.append("&stag=");
        r0.append(TTHelper.encodeUrl(r5.mSubTag));
    L13:
        return r0.toString();
    }

    public static void addPCDNFlag(DataLoaderHelper.DataLoaderTaskItem r0, DataLoaderHelper.DataLoaderTaskItem.TrackItem r1) {
        throw new UnsupportedOperationException("toB only");
    }
}
