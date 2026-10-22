package com.bytedance.android.live.base.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.RankRoundBanner.Item")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/base/model/live/c;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "_name", "Ljava/lang/String;", "get_name", "()Ljava/lang/String;", "set_name", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/base/model/live/b;", "_userList", "Ljava/util/List;", "get_userList", "()Ljava/util/List;", "set_userList", "(Ljava/util/List;)V", "_url", "get_url", "set_url", "_background", "get_background", "set_background", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName(KtvSubElement.BACKGROUND)
    protected ImageModel _background;

    @SerializedName("icon")
    protected ImageModel _icon;

    @SerializedName("name")
    protected String _name;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    protected String _url;

    @SerializedName("list")
    protected List<b> _userList;

    public c() {
    }

    public c(g r5) {
        this._userList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this._url = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._userList.add(new b(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._name = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._icon = x.a(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._background = x.a(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
