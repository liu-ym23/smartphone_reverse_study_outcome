package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {
    public static final a E0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @JvmStatic
        public static PkPanelService a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("IPkPanelService");
            if ((r0 instanceof PkPanelService) == true) goto L6;
            r0 = null;
        L6:
            return (PkPanelService) r0;
        }
    }

    static {
        E0 = a.a;
    }

    void closeLink();

    void openAnchorLinkDebugDialog();

    void openInviteMorePanel();

    void openSetPanel();

    void openVoteStartDialog();

    void showFeedBackDialog();

    void startTeamPkMatch(String r1);
}
