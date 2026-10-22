package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParamContainer;
import com.larksuite.framework.apiplugin.validator.format.GrayKey;
import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UG {
    public static final List<String> a = null;

    public static final enum ShareChannelType extends Enum<ShareChannelType> {
        public static final ShareChannelType SYSTEM = null;
        public static final ShareChannelType WX = null;
        public static final ShareChannelType WX_TIMELINE = null;
        public static final /* synthetic */ ShareChannelType[] a = null;
        public String mValue;

        static {
            ShareChannelType r0 = new ShareChannelType("WX", 0, "wx");
            WX = r0;
            ShareChannelType r1 = new ShareChannelType("WX_TIMELINE", 1, "wx_timeline");
            WX_TIMELINE = r1;
            ShareChannelType r2 = new ShareChannelType("SYSTEM", 2, "system");
            SYSTEM = r2;
            a = new ShareChannelType[]{r0, r1, r2};
        }

        public static ShareChannelType[] values() {
            return (ShareChannelType[]) a.clone();
        }

        public static ShareChannelType valueOf(String r1) {
            return (ShareChannelType) a.a(ShareChannelType.class, r1);
        }

        public ShareChannelType(String r1, int r2, String r3) {
            super(r1, r2);
            this.mValue = r3;
        }
    }

    public static final enum ShareContentType extends Enum<ShareContentType> {
        public static final ShareContentType FILE = null;
        public static final ShareContentType IMAGE = null;
        public static final ShareContentType TEXT = null;
        public static final ShareContentType WEB_URL = null;
        public static final /* synthetic */ ShareContentType[] a = null;
        public final String mValue;

        static {
            ShareContentType r0 = new ShareContentType("TEXT", 0, "text");
            TEXT = r0;
            ShareContentType r1 = new ShareContentType("IMAGE", 1, "image");
            IMAGE = r1;
            ShareContentType r2 = new ShareContentType("WEB_URL", 2, "url");
            WEB_URL = r2;
            ShareContentType r4 = new ShareContentType("FILE", 3, "file");
            FILE = r4;
            a = new ShareContentType[]{r0, r1, r2, r4};
        }

        public static ShareContentType[] values() {
            return (ShareContentType[]) a.clone();
        }

        public static ShareContentType valueOf(String r1) {
            return (ShareContentType) a.a(ShareContentType.class, r1);
        }

        public ShareContentType(String r1, int r2, String r3) {
            super(r1, r2);
            this.mValue = r3;
        }
    }

    public static class ShareRequest extends LKBaseRequestModel {

        @GrayKey("feature_key_share")
        @StringEnum(gray = true, values = {"wx", "wx_timeline", "system"})
        @NotBlank(gray = true)
        @JSONField(name = "channelType")
        public List<String> mChannelType;

        @JSONField(name = "content")
        public String mContent;

        @GrayKey("feature_key_share")
        @StringEnum(gray = true, values = {"text", "image", "url", "file"})
        @LKRequiredParamContainer({@LKRequiredParam, @LKRequiredParam(gray = true)})
        @JSONField(name = "contentType")
        public String mContentType;

        @JSONField(name = "filePath")
        public String mFilePath;

        @JSONField(name = "image")
        public String mImage;

        @JSONField(name = "title")
        public String mTitle;

        @JSONField(name = "url")
        public String mUrl;

        public ShareRequest() {
            this.mChannelType = new ArrayList(UG.a);
        }
    }

    public static class ShareResponse extends LKBaseResponseModel {
        public ShareResponse() {
        }
    }

    static {
        a = new ArrayList();
        if (LarkContext.getApplication().getPackageName().contains("com.larksuite.suite") == false) goto L5;
        a = new ArrayList(Arrays.asList(new String[]{ShareChannelType.SYSTEM.mValue}));
        return;
    L5:
        a = new ArrayList(Arrays.asList(new String[]{ShareChannelType.WX.mValue, ShareChannelType.WX_TIMELINE.mValue}));
    }
}
