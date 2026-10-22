package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class WhiteMap {
    public static final /* synthetic */ int a = 0;

    @AppConfig(key = "larkapi_rustcmd_whitelist")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/WhiteMap$CommandWhiteList;", BuildConfig.FLAVOR, "<init>", "()V", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommandWhiteList {
        public CommandWhiteList() {
        }
    }

    static {
    }

    public static boolean a(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "bizName");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error bizName empty");
        return false;
    L10:
        String r1 = SettingManager.getInstance().getString(CommandWhiteList.class);
        if (r1 != null) goto L14;
        r1 = BuildConfig.FLAVOR;
    L14:
        if (r1.length() != 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L32;
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error config empty");
        return false;
    L32:
        JSONArray r2 = JSON.parseObject(r1).getJSONArray(r5);
        if (r2.isEmpty() == false) goto L26;
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error white list empty ".concat(r5));
        return false;
    L26:
        if (r2.contains(Integer.valueOf(r6)) == false) goto L28;
        return true;
    L28:
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error rust command forbidden " + r5 + r6);
        return false;
    L30:
        j.b("LK_API_TAG_CommandWhiteMap", "command validate permission error config parse error");
        return false;
    L16:
        r4 = false;
        goto L17
    L5:
        r0 = false;
        goto L7
    }
}
