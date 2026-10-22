package com.bytedance.android.live.livepkaudience.service;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c {
    public static final a w0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static LinkPkInteractGuestDataContext a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("linkpk_interact_guest_data_service");
            if ((r0 instanceof LinkPkInteractGuestDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (LinkPkInteractGuestDataContext) r0;
        }
    }

    static {
        w0 = a.a;
    }

    String getAudienceSelfLinkMicId();

    String getGuestAnchorLinkMicId();

    MutableLiveData<String> getGuestLynxListData();

    com.bytedance.android.live.pkaudience.api.d getPkAudienceLogData();

    String getSelfAnchorLinkMicId();

    Boolean hasAudienceJoinSelfAnchorLink();

    void resetLinkData();

    void setAudienceSelfLinkMicId(String r1);

    void setGameData(String r1);

    void setGuestAnchorLinkMicId(String r1, String r2);

    void setSelfAnchorLinkMicId(String r1);
}
