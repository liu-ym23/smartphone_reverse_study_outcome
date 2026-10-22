package com.larus.uaigc.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016J(\u0010#\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016¨\u0006$"}, d2 = {"Lcom/larus/uaigc/service/CreationShareServiceImpl;", "Lcom/larus/uaigc/service/ICreationShareService;", "<init>", "()V", "showShareImagePanel", "", "context", "Landroid/content/Context;", "imgUrl", "", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "taskType", "", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "galleryShareVideo", "params", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "tryShareLocalImage", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sourceUrls", "", "tryShareLocalVideo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationShareServiceImpl implements ICreationShareService {
    public CreationShareServiceImpl() {
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final void o(com.larus.uaigc.creation.f r22) {
        Intrinsics.checkNotNullParameter(r22, "params");
        CreationGalleryUtil r1 = CreationGalleryUtil.a;
        CreationGalleryUtil.i(new sz9.c(null, null, null, null, null, null, null, r22.d, null, null, r22.b, r22.g, r22.a, r22.e, r22.h, false, null, 99199), r22.f, r22.c);
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final boolean O(final Context r10, CoroutineScope r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "sourceUrls");
        u.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "sourceUrls");
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r0 = r13.next();
        if (u.c((String) r0) == false) goto L4;
    L9:
        String r1 = (String) r0;
        if (r1 != null) goto L13;
        return false;
    L13:
        if (u.b(r10, "image") == true) goto L16;
        BuildersKt.launch$default(r11, null, null, new LocalMediaMenuShareHelper$shareLocalMedia$1(new LocalMediaMenuShareHelper$tryShareImage$1(r10, r1, null), new t(r10), new s(r10), null), 3, null);
    L16:
        return true;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final boolean P(final Context r10, CoroutineScope r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "sourceUrls");
        u.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "sourceUrls");
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r0 = r13.next();
        if (u.c((String) r0) == false) goto L4;
    L9:
        String r1 = (String) r0;
        if (r1 != null) goto L13;
        return false;
    L13:
        if (u.b(r10, "video") == true) goto L16;
        BuildersKt.launch$default(r11, null, null, new LocalMediaMenuShareHelper$shareLocalMedia$1(new LocalMediaMenuShareHelper$tryShareVideo$1(r10, r1, null), new r(r10), new q(r10), null), 3, null);
    L16:
        return true;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.larus.uaigc.service.ICreationShareService
    public final void N(Context r35, String r36, ShareScene r37, com.larus.bmhome.share.panel.d r38, com.larus.bmhome.share.panel.h r39, by7.e r40, UserCreationFromIM r41, UserCreation r42, Integer r43, String r44) {
        Intrinsics.checkNotNullParameter(r37, "shareScene");
        if ((r35 instanceof FragmentActivity) == true) goto L5;
        return;
    L5:
        int r3 = com.larus.uaigc.share.a.a;
        FragmentActivity r4 = (FragmentActivity) r35;
        Intrinsics.checkNotNullParameter(r37, "shareScene");
        IShareService r0 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r0 == null) goto L12;
        ICreationMetadataService.Companion r1 = ICreationMetadataService.a;
        Map<String, String> r5 = r1.L(r41, null);
        if (r5 != null) goto L10;
        r5 = r1.H(r42, null);
    L10:
        IShareService.a.g(r0, r4, r37, new com.larus.bmhome.share.panel.b(r36, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r5, true, true, r44, null, false, false, r43, false, null, null, 62423038), r39, r38, r40, false, 192);
        return;
    }
}
