package com.larus.share.impl.panel;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.ShareScene;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JR\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J[\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00152#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016J\u001c\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u001b2\u0006\u0010'\u001a\u00020\u0015H\u0016J\u0012\u0010(\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\"\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016¨\u0006-"}, d2 = {"Lcom/larus/share/impl/panel/SharePanelServiceNoop;", "Lcom/larus/share/impl/panel/ISharePanelService;", "<init>", "()V", "init", "", "showSharePanel", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "landscapeFixedPanelWidth", "", "monitorShare", "share", "context", "Landroid/content/Context;", "shareChannel", "", "shareType", "showLoading", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "resultCode", "createShareItemUIConfig", "Lcom/larus/platform/model/share/ShareItemUIConfig;", "channelType", "isImmersive", "isInstalledChannel", "handleShareResultOnActivityResult", "requestCode", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SharePanelServiceNoop implements ISharePanelService {
    public SharePanelServiceNoop() {
    }

    public final boolean a(String r1) {
        return false;
    }

    public final DialogFragment c(FragmentActivity r1, ShareScene r2, com.larus.bmhome.share.panel.b r3, com.larus.bmhome.share.panel.h r4, com.larus.bmhome.share.panel.d r5, by7.e r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "shareScene");
        Intrinsics.checkNotNullParameter(r3, "shareContent");
        return null;
    }

    public final void d(int r1, int r2, Intent r3) {
    }

    public final jr9.b e(String r1, boolean r2) {
        return null;
    }

    public final void init() {
    }

    public final void b(Context r1, String r2, String r3, com.larus.bmhome.share.panel.b r4, boolean r5, Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "shareContent");
        if (r6 == null) goto L6;
        r6.invoke(2);
        return;
    }
}
