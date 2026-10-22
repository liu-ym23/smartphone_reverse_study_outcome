package com.ss.ttvideoengine.strategrycenter;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IPortraitService {
    public static final String FROM = "from";
    public static final String FROM_SMART = "smart";
    public static final String FROM_VIDEO = "video";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String TYPE_GROUP_PORTRAITS = "group";
    public static final String TYPE_ONE_PORTRAIT = "one";
    public static final String VIDEO_ID = "video_id";

    /* JADX INFO: renamed from: com.ss.ttvideoengine.strategrycenter.IPortraitService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addGroupConfig(IPortraitService r0, Map r1, List r2) {
        }

        public static Map $default$getPortraits(IPortraitService r0, Map r1) {
            return null;
        }
    }

    void addGroupConfig(Map<String, String> r1, List<String> r2);

    Map<String, String> getPortraits(Map<String, String> r1);
}
